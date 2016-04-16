'use strict';

/* Services */

/*
 http://docs.angularjs.org/api/ngResource.$resource

 Default ngResources are defined as

 'get':    {method:'GET'},
 'save':   {method:'POST'},
 'query':  {method:'GET', isArray:true},
 'remove': {method:'DELETE'},
 'delete': {method:'DELETE'}

 */

var annonceServices = angular.module('annonceServices', ['ngResource']);


annonceServices.factory('AnnoncesFactory', function ($resource) {
    return $resource('annonces', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

annonceServices.factory('AnnonceFactory', function ($resource) {
    return $resource('annonce/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});