'use strict';
App.controller('EmployeeController', ['$scope', 'EmployeeManagerService', function($scope, EmployeeManagerService){
	
	var self = this;
	self.employee={id:null, name:'', username:'', email:''};
	self.employees=[];
	
				/************* Create functions/methods *************/
	
	/* Fetch employee function/method */
	self.fetchAllEmployees=function(){
		EmployeeManagerService.fetchAllEmployees()
			.then(
				function(list){
					self.employees = list;
				},
				function(errResponse){
					console.error('Error while fetching employees')
				}
			);
	}
	
	/* Create employee function/method */
	self.createEmployee = function(employee){
		EmployeeManagerService.createEmployee(employee)
		.then(
				self.fetchAllEmployees,
				function(errResponse){
					console.error('Error while creating employee');
				}
		);
	};
	
	/* Delete employee function */
	
	self.deleteEmployee = function(id){
		EmployeeManagerService.deleteEmployee(id)
		.then(
				self.fetchAllEmployees,
				function(errResponse){
					console.error('Error while deleting employee');
				}
		);
	}
	
	/* Update employee function */
	
	self.updateEmployee = function(employee){
		EmployeeManagerService.updateEmployee(employee)
		.then(
				self.fetchAllEmployees,
				function(errResponse){
					console.error('Error while updating employee');
				}
		);
	}
	
				/************** Function/method calls ****************/

	/* Fetch employee function call */
	self.fetchAllEmployees();
	
	/* Create/Update employee function call */
	self.submit= function(){
		if(self.employee.id==null){
			console.log('Saving New User', self.employee);    
            self.createEmployee(self.employee);
		}else{
             console.log('Updating user');
             self.updateEmployee(self.employee);
		}
		self.reset();
		
	};
	
	  self.edit = function(id){
          console.log('id to be edited', id);
          for(var i = 0; i < self.employees.length; i++){
              if(self.employees[i].id === id) {
                 self.employee = angular.copy(self.employees[i]);
                 break;
              }
          }
      };
	
	/* Delete function call */
	
	self.remove = function(id){
		console.log('Employee id to be delete', id);
		if(self.employee.id == id){
			self.reset();
		}
		self.deleteEmployee(id);
	};
	
	
	  $scope.showConfirm = function(ev) {
		    // Appending dialog to document.body to cover sidenav in docs app
		    var confirm = $mdDialog.confirm()
		          .title('Would you like to delete your debt?')
		          .ariaLabel('Lucky day')
		          .targetEvent(ev)
		          .ok('Ok')
		          .cancel('Cancel');
		    $mdDialog.show(confirm).then(function(){
		      $scope.status = 'You decided to get rid of your debt.';
		    }, function() {
		      $scope.status = 'You decided to keep your debt.';
		    });
		  };
		  
		  
	/* Reset function call */
	  self.reset = function(){
          self.employee={id:null,name:'',username:'',email:''};
          $scope.myForm.$setPristine(); //reset Form
      };
      
      $scope.clicked = function(){
    	  window.location = "#/peges/employeeMgmt.jsp"
      };
}]);