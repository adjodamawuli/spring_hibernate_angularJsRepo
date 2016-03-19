package com.esprit.springproject.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "family_name")
	private String familyName;

	@Column(name = "e_mail")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "language")
	private String language;

	@Column(name = "id_picture")
	private String pictureId;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "burth_date")
	private Date burthDate;

	@Column(name = "enabled")
	private Boolean enabled;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@JsonIgnore
	private List<Annonce> annonces;

	// @ManyToMany(fetch = FetchType.EAGER)
	// @JoinTable(name = "users_authority", joinColumns = { @JoinColumn(name =
	// "id_user", referencedColumnName = "id") }, inverseJoinColumns = {
	// @JoinColumn(name = "id_authority", table = "authority",
	// referencedColumnName = "id") })
	// private Set<Authority> authorities = new HashSet<Authority>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBurthDate() {
		return burthDate;
	}

	public void setBurthDate(Date burthDate) {
		this.burthDate = burthDate;
	}

	// public Set<Authority> getAuthorities() {
	// return authorities;
	// }
	//
	// public void setAuthorities(Set<Authority> authorities) {
	// this.authorities = authorities;
	// }

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", familyName=" + familyName + ", email=" + email
				+ ", phone=" + phone + ", language=" + language + ", pictureId=" + pictureId + ", login=" + login
				+ ", password=" + password + ", burthDate=" + burthDate + ", enabled=" + enabled + ", authorities="
				+ "]";
	}

	
	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

}
