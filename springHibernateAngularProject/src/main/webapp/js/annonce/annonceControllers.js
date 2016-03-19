'use strict';

/* Controllers */

var app = angular.module('ngdemo.annonce.controllers', []);


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});



app.controller('AnnonceListCtrl', ['$scope', 'AnnoncesFactory', 'AnnonceFactory', '$location', function ($scope, AnnoncesFactory, AnnonceFactory, $location) {

        $scope.editAnnonce = function (AnnonceId) {
            $location.path('/annonce-detail/' + AnnonceId);
        };

        $scope.deleteAnnonce = function (AnnonceId) {
            AnnonceFactory.delete({ id: AnnonceId });
            $scope.annonces = AnnoncesFactory.query();
            $scope.$apply();
        };

        $scope.createNewAnnonce = function () {
            $location.path('/annonce-creation');
        };

        $scope.annonces = AnnoncesFactory.query();
    }]);

app.controller('AnnonceDetailCtrl', ['$scope', '$routeParams', 'AnnonceFactory', '$location',
    function ($scope, $routeParams, AnnonceFactory, $location) {

        $scope.updateAnnonce = function () {
        	AnnonceFactory.update($scope.annonce);
            $scope.$apply();
            $location.path('/annonce-list');
        };

        $scope.cancel = function () {
            $location.path('/annonce-list');
        };

        $scope.annonce = AnnonceFactory.show({id: $routeParams.id});
    }]);

app.controller('AnnonceCreationCtrl', ['$scope', 'AnnoncesFactory', '$location',
    function ($scope, AnnoncesFactory, $location) {

        $scope.createNewAnnonce = function () {
        	AnnoncesFactory.create($scope.user);
            $scope.$apply();
            $location.path('/annonce-list');
        }
    }]);

