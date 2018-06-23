var app = angular.module("crudApp", ['ngResource']);
app.controller('Candidate1Controller', function($scope, $http, $location) {
	$scope.message ="";
	$scope.getAllCandidates = function() {
		var url = "http://localhost:8080/api/candidates";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		$http.get(url, config).then(function(response) {
			if (response.data.status == "Done") {
				$scope.candidates = response.data.data;
				$scope.soluong = $scope.candidates.length;
				
			} else {
				$scope.getResultMessage = "get All book Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	$scope.quyen = function() {
		var url = "http://localhost:8080/api/quyen";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		$http.get(url, config).then(function(response) {
			if (response.data.status == "Done") {
				$scope.roles = response.data.data;
				
			} else {
				$scope.getResultMessage = "get All book Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	$scope.quyen();
	$scope.getAllUsers = function() {
		var url = "http://localhost:8080/api/users";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		$http.get(url, config).then(function(response) {
			if (response.data.status == "Done") {
				$scope.users = response.data.data;
				
			} else {
				$scope.getResultMessage = "get All book Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	$scope.getAllCandidates();
	$scope.getAllUsers();
	
	$scope.searchCandidate = function(search) {
		var url = "http://localhost:8080/api/search?search="+search;

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		$http.get(url, config).then(function(response) {
			
			if (response.data.status == "Done") {
				$scope.candidates = response.data.data;
				$scope.soluong = $scope.candidates.length;
				
			} else {
				
				$scope.getResultMessage = "Fail!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	$scope.filterCandidate= function(test){
		var url = "http://localhost:8080/api/filter?search="+test;

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		$http.get(url, config).then(function(response) {
			
			if (response.data.status == "Done") {
				$scope.candidates = response.data.data;
				$scope.soluong = $scope.candidates.length;
				
			} else {
				
				$scope.getResultMessage = "Fail!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	$scope.loginUser = function(email,pass) {
		var url = "http://localhost:8080/api/login?email="+email+"&pass="+pass;

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		$http.get(url, config).then(function(response) {
			
			if (response.data.status == "Done") {
				window.location.href="http://localhost:8080/candidate.html";
				
			} else {
				
				$scope.message = "Email or password incorrect!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
});