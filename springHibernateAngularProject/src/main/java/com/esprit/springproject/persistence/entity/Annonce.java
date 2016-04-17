package com.esprit.springproject.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table
public class Annonce implements Serializable {
	private Long idAnnonce;
	private String titre;
	private String description;
	private Double prix;
	private String quartier;
	private List<Image> images;
	private String imgB64;
	private Etat etat;
	private User user;
	private Boolean isEnable;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	public Long getIdAnnonce() {
		return idAnnonce;
	}

	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "annonce")
	@JsonIgnore
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	public String getImgB64() {
		return imgB64;
	}

	public void setImgB64(String imgB64) {
		this.imgB64 = imgB64;
	}

}
