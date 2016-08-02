<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AngularJS $http Example</title>

<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="mainApp" class="ng-cloak">
	<div class="generic-container"
		ng-controller="EmployeeController as ctrl">
		
		
		
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Employee Login</span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm1"
					class="form-horizontal">
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">User Name/ Email Id</label>
							
							<div class="col-md-7">
								<input type="text" 
									name="loginUserName" class="form-control input-sm"
									placeholder="Enter your username."
									required />
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Password</label>
							
							<div class="col-md-7">
								<input type="text" 
									name="loginPassword" class="form-control input-sm"
									placeholder="Enter your passwod."
									required />
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-actions floatRight">
								<button type="button" ng-model="button"
								class="btn btn-primary btn-sm">Login</button>
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								</button>

						</div>
					</div>
						
				</form>
			</div>
		</div>
		
		
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Employee Registration Form </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.employee.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.employee.name" name="name"
									class="name form-control input-sm" ng-disabled="button"
									placeholder="Enter your name" required ng-minlength="5" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Username</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.employee.username"
									name="username" class="form-control input-sm"
									placeholder="Enter your username. [This field is validation free]"
									required />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">E-Mail</label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.employee.email" name="email"
									class="form-control input-sm"
									placeholder="Enter your email. [This field is validation free]"
									required />

								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.email.$error.required">This is a
										required field</span> <span ng-show="myForm.email.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit"
								value="{{!ctrl.employee.id ? 'Register' : 'Update'}}"
								class="btn btn-primary btn-sm">
								
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								</button>

						</div>
					</div>
				</form>
			</div>
		</div>
		
		

		<!-- Table panel contents -->
		<div class="panel panel-default">

			<div class="panel-heading">
				<span class="lead">List of Employees </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID.</th>
							<th>Name</th>
							<th>Username</th>
							<th>Email</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="emp in ctrl.employees | orderBy:'+id'">
							<td><span ng-bind="emp.id"></span></td>
							<td><span ng-bind="emp.name"></span></td>
							<td><span ng-bind="emp.username"></span></td>
							<td><span ng-bind="emp.email"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(emp.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="deleteCtrl.open(emp.id)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>
	</div>
	<!-- Table panel contents -->


	<script src="<c:url value='/static/js/angular.js' />"></script>
	<script src="<c:url value='/static/js/angular-route.js' />"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/static/js/angular-confirm.js' />"></script>
	<script src="<c:url value='/static/js/service/employeeService.js' />"></script>
	<script src="<c:url value='/static/js/service/loginService.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/employeeController.js' />"></script>
<%-- 	<script
		src="<c:url value='/static/js/controller/modalController.js' />"></script> --%>
</body>
</html>