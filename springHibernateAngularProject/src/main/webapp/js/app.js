'use strict';

// Declare app level module which depends on filters, and services

/**
 * Déclaration de l'application routeApp
 */
 var myApp = angular.module('myApp', [
// Dépendances du "module"
//	'ngRoute', 
	'ui.router',
	'userControllers', 
	'userServices', 
	'filters',
	'directives' 
	
	]);
 
 
 
 myApp.config(function($stateProvider, $urlRouterProvider) {
	    
	    $urlRouterProvider.otherwise('/user-list');
	    
	    $stateProvider
	        
	        // HOME STATES AND NESTED VIEWS ========================================
	        .state('home', {
	            url: '/user-list',
	            templateUrl: 'partials/user/user-list.html',
	            controller: 'UserListCtrl'
	        })
	        .state('user home', {
	            url: '/user-detail/:id',
	            templateUrl: 'partials/user/user-detail.html',
	            controller: 'UserDetailCtrl'
	        })
	        .state('add user', {
	            url: '/user-creation',
	            templateUrl: 'partials/user/user-creation.html',
	            controller: 'UserCreationCtrl'
	        })
	        
	        // nested list with custom controller
//	        .state('home.list', {
//	            url: '/list',
//	            templateUrl: 'partial-home-list.html',
//	            controller: function($scope) {
//	                $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
//	            }
//	        })
//	        
//	        // nested list with just some random string data
//	        .state('home.paragraph', {
//	            url: '/paragraph',
//	            template: 'I could sure use a drink right now.'
//	        })
//	        
//	        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
//	        .state('about', {
//	            url: '/about',
//	            views: {
//	                '': { templateUrl: 'partial-about.html' },
//	                'columnOne@about': { template: 'Look I am a column!' },
//	                'columnTwo@about': { 
//	                    templateUrl: 'table-data.html',
//	                    controller: 'scotchController'
//	                }
//	            }
//	            
//	        });
	        
	});

