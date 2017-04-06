'use strict';
var app = angular.module('tasklist', ['tasklist.controllers', 'tasklist.services', 'ngRoute']);
app.constant('WEB_SERVICE', 'localhost:8080/tl/');
app.config(['$routeProvider', function($routeProvider, 	$localStorage) {
    $routeProvider.when('/home', {
        templateUrl: 'home/home.html',
        controller: 'HomeCtrl'
    });
	$routeProvider.when('/newtask', {
        templateUrl: 'home/new-task.html',
        controller: 'NewTaskCtrl'
    });
	$routeProvider.when('/newtask/:task', {
        templateUrl: 'home/new-task.html',
        controller: 'NewTaskCtrl'
    });
	$routeProvider.when('/login', {
        templateUrl: 'login/login.html',
        controller: 'LoginCtrl'
    });
	$routeProvider.otherwise({
		redirectTo: '/login'
	});	
}])