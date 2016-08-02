'use strict';

var App = angular.module('mainApp',['ngRoute']);
App.config(function($routeProvider){
	$routeProvider
		.when('/first', {
			templateUrl : 'first.html',
		})
		
		.when('/second', {
			templateUrl : 'welcome.jsp',
		})
		
		.otherwise({
			redirectTo: '/'
		});
});

// create the controller and inject Angular's $scope
//App.controller('loginController', function($scope) {
    // create a message to display in our view
//    $scope.message = 'Login controller called.';
//});
