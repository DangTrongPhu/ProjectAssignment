var app = angular.module("crudApp", ['ngResource']);
app.controller('Candidate1Controller', function($scope, $http, $location) {
	$scope.message ="";
	$scope.passed =true;
	$scope.failed = true;
	$scope.sortType='fullname'; 
	$scope.sortType='gpa';// set the default sort type
	$scope.sortReverse  = false; 
	$scope.sortgpa  = false; 
	$scope.new_sorting_order=false;
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
	 $scope.reverse = false;
	 $scope.sortingOrder = 'fullname';
	  $scope.sort_by = function(newSortingOrder) {
	        if ($scope.sortingOrder == newSortingOrder)
	            $scope.reverse = !$scope.reverse;

	        $scope.sortingOrder = newSortingOrder;

	        // icon setup
	        $('th i').each(function(){
	            // icon reset
	            $(this).removeClass().addClass('icon-sort');
	        });
	        if ($scope.reverse)
	            $('th.'+newSortingOrder+' i').removeClass().addClass('icon-chevron-up');
	        else
	            $('th.'+newSortingOrder+' i').removeClass().addClass('icon-chevron-down');
	    };
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
	$scope.filter1Candidate = function(passed,failed,start,end,test,select){
		var url = "http://localhost:8080/api/filter1?passed="+passed+"&failed="+failed+"&start="+start+"&end="+end+"&test="+test+"&select="+select;
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