var cerebroUIApp = angular.module("cerebroUIApp", ['ngRoute'])
			.run(function($rootScope) {
				$rootScope.urlbase = "http://localhost:8080/addressbook/";
			});

cerebroUIApp.config(function($routeProvider) {
	$routeProvider
		.when('/home', {
			templateUrl: 'login.html',
			controller: 'LoginController'
		})
		.when('/dashBoard', {
			templateUrl: 'dashboard.html',
			controller: 'DashboardController'
		})
		.when('/addAddress', {
			templateUrl: 'addAddress.html',
			controller: 'AddAddressController' 
		})
		/*
		.when('/addDeployments', {
			templateUrl: 'addDeployments.html',
			controller: 'AddDeploymentsController'
		})
		.when('/confirmAddDeployments', {
			templateUrl: 'confirmAddDeployments.html',
			controller: 'ConfirmAddDeploymentsController'
		})
		.when('/deleteDeployments', {
			templateUrl: 'dashboard.html',
			controller: 'DeleteDeploymentsController'
		})
		.when('/addEnvironments', {
			templateUrl: 'addEnvironments.html',
			controller: 'AddEnvironmentsController'
		})
		.when('/confirmAddEnvironments', {
			templateUrl: 'confirmAddEnvironments.html',
			controller: 'ConfirmAddEnvironmentsController'
		})
		.when('/deleteEnvironments', {
			templateUrl: 'envDashboard.html',
			controller: 'DeleteEnvironmentsController'
		})*/
		.otherwise({
			redirectTo: '/home'
		});
});















	