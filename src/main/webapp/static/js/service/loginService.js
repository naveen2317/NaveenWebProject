'use strict';
App.factory('LoginService', ['$http', '$q', function($http, $q){
	
	return{
		/* Login service */
		
		login:function(user){
			return $http.post('http://localhost:8082/NaveenWebProject/demo/Login', user)
			.then(
				function(response){
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
			);
		},
	};
	
}]);