'use strict';
App.factory('EmployeeManagerService', ['$http', '$q', function($http, $q){
	
	return{
		/* Create employee service */
		
		createEmployee:function(employee){
			return $http.post('http://localhost:8082/NaveenWebProject/demo/RegisterEmployee', employee)
			.then(
				function(response){
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
			);
		},
		
		/* Fetch employee service */
		
		fetchAllEmployees:function(){
			return $http.get('http://localhost:8082/NaveenWebProject/demo/EmployeesList')
			.then(
				function(response){
					return response.data;
				},
				function(errResponse){
					console.error('Error while fetching employee');
					return $q.reject(errResponse);
				}
			);
		},
		
		/* Delete service */
		
		deleteEmployee:function(id){
			return $http.delete('http://localhost:8082/NaveenWebProject/demo/DeleteEmployee/'+id)
			.then(
				function(response){
					return response.data;
				},
				function(errResponse){
					console.error('Error while deleting employee');
					return $q.reject(errResponse);
				}
			);
			
		},
		
		/* Update service */
		
		updateEmployee:function(employee){
			return $http.put('http://localhost:8082/NaveenWebProject/demo/UpdateEmployee/', employee)
			.then(
				function(response){
					return response.data;
				},
				function(errResponse){
					console.error('Error while updating employee');
					return $q.reject(errResponse);
				}
			);
		}
		
	};
	
}]);