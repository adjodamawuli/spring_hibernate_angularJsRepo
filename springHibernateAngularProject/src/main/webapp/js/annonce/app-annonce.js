'use strict';

// Declare app level module which depends on filters, and services
angular.module('annonce', ['annonce.filters', 'annonce.services', 'annonce.directives', 'annonce.controllers']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/annonce-list', {templateUrl: 'listAnnonces.html', controller: 'AnnonceListCtrl'});
        $routeProvider.when('/annonce-detail/:id', {templateUrl: 'partials/user/user-detail.html', controller: 'AnnonceDetailCtrl'});
        $routeProvider.when('/annonce-creation', {templateUrl: 'partials/user/user-creation.html', controller: 'AnnonceCreationCtrl'});
        $routeProvider.otherwise({redirectTo: '/annonce-list'});
    }]);
