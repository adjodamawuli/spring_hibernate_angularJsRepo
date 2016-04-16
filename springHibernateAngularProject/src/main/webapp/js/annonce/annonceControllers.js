'use strict';

/* Controllers */

var app = angular.module('annonceControllers', []);


//Clear browser cache (in development mode)
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
        };

        $scope.createNewAnnonce = function () {
            $location.path('/annonce-creation');
        };
        $scope.listAnnonce = function () {
        	$scope.annonces = AnnoncesFactory.query();
            $location.path('/annonce-list');
        };
        $scope.annonces = AnnoncesFactory.query();
    }]);

app.controller('AnnonceDetailCtrl', ['$scope', '$stateParams', 'AnnonceFactory', '$location',
    function ($scope, $routeParams, AnnonceFactory, $location) {

        $scope.updateAnnonce = function () {
        	AnnonceFactory.update($scope.annonce);
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
        	alert("creation annonce");
        	AnnoncesFactory.create($scope.annonce);
        	alert("redirect to /annonce-list");
            $location.path('/annonce-list');
        }
    }]);


