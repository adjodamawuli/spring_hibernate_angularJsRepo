'use strict';

// Declare app level module which depends on filters, and services

/**
 * Déclaration de l'application routeApp
 */
 var myApp = angular.module('myApp', [
// Dépendances du "module"
//	'ngRoute', 
	'ui.router',
	'annonceControllers', 
	'annonceServices', 
	'filters',
	'directives' 
	
	]);
 
 
 
 myApp.config(function($stateProvider, $urlRouterProvider) {
	    
	    $urlRouterProvider.otherwise('/annonce-list');
	    
	    $stateProvider
	        
	        // HOME STATES AND NESTED VIEWS ========================================
	        .state('home', {
	            url: '/annonce-list',
	            templateUrl: 'partials/annonce/listAnnonces.html',
	            controller: 'AnnonceListCtrl'
	        })
	          .state('annoncehome', {
	            url: '/annonce-detail/:id',
	            templateUrl: 'partials/annonce/annonce-detail.html',
	            controller: 'AnnonceDetailCtrl'
	        })
	        .state('addannonce', {
	            url: '/annonce-creation',
	            templateUrl: 'partials/annonce/addAnonce.html',
	            controller: 'AnnonceCreationCtrl'
	        })
	        
	});


 myApp.directive("disableLink", function() {
	    return {
	        restrict: "A",
	        link: function(scope, elem, attrs) {
	            $(elem).click(function() {
	                $().JqueryFunction(elem);
	            });
	        }
	    }
	});


	$(document).ready(function() {
	  $("#jqueryBtn").click(function() {
		  alert("ok");
	    angular.element('#angularData').scope().AngularFunction();
	  });
	  
	  (function($){
	     $.fn.JqueryFunction = function(elem) {
	    	 alert(elem);
	    	 var currentId = $(elem[0]).attr('id');
	    	 alert(currentId);
//	    	 alert("adjoda:"+attrs);
//	    	 alert((elem).attr('id'));
	     }; 
	  })( jQuery );

	});