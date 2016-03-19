'use strict';

// Declare app level module which depends on filters, and services
angular.module('ngdemo', ['ngdemo.filters', 'ngdemo.user.services', 'ngdemo.directives', 'ngdemo.user.controllers']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/user-list', {templateUrl: 'partials/user/user-list.html', controller: 'UserListCtrl'});
        $routeProvider.when('/user-detail/:id', {templateUrl: 'partials/user/user-detail.html', controller: 'UserDetailCtrl'});
        $routeProvider.when('/user-creation', {templateUrl: 'partials/user/user-creation.html', controller: 'UserCreationCtrl'});
        $routeProvider.otherwise({redirectTo: '/user-list'});
    }]);
