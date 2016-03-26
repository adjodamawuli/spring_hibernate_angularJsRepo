'use strict';

// Declare app level module which depends on filters, and services

/**
 * Déclaration de l'application routeApp
 */
 var myApp = angular.module('myApp', [
// Dépendances du "module"
	'ngRoute', 
	'controllers', 
	'services', 
	'filters',
	'directives' 
	
	]);

/**
 * Configuration du module principal : routeApp
 */
myApp.config([ '$routeProvider', function($routeProvider) {

	// Système de routage
	$routeProvider.when('/user-list', {
		templateUrl : 'partials/user/user-list.html',
		controller : 'UserListCtrl'
	});
	$routeProvider.when('/user-detail/:id', {
		templateUrl : 'partials/user/user-detail.html',
		controller : 'UserDetailCtrl'
	});
	$routeProvider.when('/user-creation', {
		templateUrl : 'partials/user/user-creation.html',
		controller : 'UserCreationCtrl'
	});
	$routeProvider.otherwise({
		redirectTo : '/user-list'
	});

} ]);
//angular.module(
//		'myApp',
//		[ 'myApp.filters', 'myApp.user.services', 'myApp.directives',
//				'myApp.user.controllers' ]).config(
//		[ '$routeProvider', function($routeProvider) {
//			$routeProvider.when('/user-list', {
//				templateUrl : 'partials/user/user-list.html',
//				controller : 'UserListCtrl'
//			});
//			$routeProvider.when('/user-detail/:id', {
//				templateUrl : 'partials/user/user-detail.html',
//				controller : 'UserDetailCtrl'
//			});
//			$routeProvider.when('/user-creation', {
//				templateUrl : 'partials/user/user-creation.html',
//				controller : 'UserCreationCtrl'
//			});
//			$routeProvider.otherwise({
//				redirectTo : '/user-list'
//			});
//		} ]);
