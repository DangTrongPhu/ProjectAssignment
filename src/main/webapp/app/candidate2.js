var app = angular.module("crudApp", ['ngResource']);
app.controller('Candidate2Controller', function($scope, $http, $location) {
	$scope.message ="";
	$scope.success="";
	$scope.classButton="btn btn-primary btn-lg";
	$scope.ngshow = "false";
	$scope.state = "Add Candidate";
	$scope.btnUpdate = true;
	$scope.btnInsert = true;
	$scope.buttonText="Add";
	$scope.btnInsert = true;
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
	$scope.check = function(){
		if ($scope.success!=""){
            return true;
        }
        return false;
	}
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
	$scope.loginUser = function(email,pass) {
		var url = "http://localhost:8080/api/login?email="+email+"&pass="+pass;

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		$http.get(url, config).then(function(response) {
			
			if (response.data.status == "Done") {
				window.location.href="http://localhost:8080/candidate2.html";
				
			} else {
				
				$scope.message = "Email or password incorrect!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	$scope.changepassUser = function(email,pass,passnew,repassnew) {
		var url = "http://localhost:8080/api/changepass?email="+email+"&pass="+pass+"&passnew="+passnew+"&repassnew="+repassnew;

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		$http.get(url, config).then(function(response) {
			
			if (response.data.status == "Done") {
				
				alert("Change password success");
				window.location.href="http://localhost:8080/login.html";
				
			} else {
				
				$scope.message = response.data.data;
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	
	$scope.saveCandidate = function(candidate) {
		var url = "http://localhost:8080/api/savecandidate";

		var config = {
				headers : {'Content-Type' : 'application/json;charset=utf-8;' },
				params: { 'id_user' : candidate.id_user,'fullname' : candidate.fullname,'gpa' : candidate.gpa,
						  'graduationyear' : candidate.graduationyear,'position' : candidate.position,'university' : candidate.	university,
						  'interviewdate' : candidate.interviewdate,'iqtest' : candidate.iqtest,'technicaltest' : candidate.technicaltest,
						  'toeic' : candidate.toeic,'interviewresult' : candidate.interviewresult,'interviewcomments' : candidate.interviewcomments,
						  'dayofbirth' : candidate.dayofbirth,'email' : candidate.email,'phone' : candidate.phone,
						  'address' : candidate.address,'degree' : candidate.degree,'notes' : candidate.notes},
		}
		$http.get(url, config).then(function(response) {
			
			if (response.data.status == "Done") {
				$scope.success = "Add Candidate success";
				alert("Add Candidate success");
				$scope.candidate = {};
				$scope.getAllCandidates();
				
			} else {
				alert(response.data.data);
				$scope.success =response.data.data ;
				
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	$scope.updateFormCandidate = function(candidate) {
		$scope.candidate = candidate;
		$scope.state = "Update Candidate";
		$scope.btnUpdate = false;
		$btnInsert = true;
	}
	$scope.updateCandidate = function(candidate) {
		var url = "http://localhost:8080/api/updatecandidate";

		var config = {
				headers : {'Content-Type' : 'application/json;charset=utf-8;' },
				params: { 'id' : candidate.id,'id_user' : candidate.id_user,'fullname' : candidate.fullname,'gpa' : candidate.gpa,
						  'graduationyear' : candidate.graduationyear,'position' : candidate.position,'university' : candidate.	university,
						  'interviewdate' : candidate.interviewdate,'iqtest' : candidate.iqtest,'technicaltest' : candidate.technicaltest,
						  'toeic' : candidate.toeic,'interviewresult' : candidate.interviewresult,'interviewcomments' : candidate.interviewcomments,
						  'dayofbirth' : candidate.dayofbirth,'email' : candidate.email,'phone' : candidate.phone,
						  'address' : candidate.address,'degree' : candidate.degree,'notes' : candidate.notes},
		}
		$http.get(url, config).then(function(response) {
			
			if (response.data.status == "Done") {
				$scope.success = "Update Candidate success";
				alert("Update Candidate success");
				$scope.candidate = {};
				$scope.getAllCandidates();
				$scope.btnUpdate = true;
				
			} else {
				alert(response.data.data);
				$scope.success =response.data.data ;
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	$scope.deleteCandidate = function(candidate) {
		 var url = "http://localhost:8080/api/deleteCandidate?id="+candidate.id;
		 var config = {
					headers : {	'Content-Type' : 'application/json;charset=utf-8;' },
				}
		 $http.get(url, config).then(function(response) {

				if (response.data.status == "Done") {
					$scope.state = "Add Candidate";
					$scope.success = "Delete Candidate success";
					alert("Delete Candidate success");
					$scope.getAllCandidates();
					$scope.btnUpdate = true;

				} else {
					$scope.state = "Delete Candidate";
					$scope.success = "Delete Candidate error";
				}

			}, function(response) {
				$scope.success = "Delete Candidate error";
			});

	 }
	
});