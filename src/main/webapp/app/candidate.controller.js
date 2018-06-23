angular.module("crudApp").controller("CandidateController", CandidateController);

CandidateController.inject = [ '$scope', 'Candidate' ];

function CandidateController($scope, Candidate) {
	$scope.success="";
	$scope.classButton="btn btn-primary btn-lg";
	$scope.ngshow = "false";
	$scope.state = "Add Candidate";
	$scope.candidates = Candidate.query();
	$scope.candidate = {};
	
	$scope.buttonText="Add";
	$scope.check = function(){
		if ($scope.success!=""){
            return true;
        }
        return false;
	}
	$scope.saveCandidate = function() {
		if ($scope.candidate.id !== undefined) {
			Candidate.update($scope.candidate, function() {
					$scope.candidates = Candidate.query();
					$scope.candidate = {};
					$scope.success = "Edit Candidate success"
					$scope.buttonText="Add";
					$scope.state ="";
			});
			} 
			else {
			
			Candidate.save($scope.candidate, function() {
					$scope.candidates = Candidate.query();
					$scope.candidate = {};
					$scope.success = "Add Candidate success";
					$scope.state ="";
				
			});
			
		}
	}

	$scope.updateCandidateInit = function(candidate) {
		$scope.state = "Edit Candidate";
		$scope.buttonText="Update";
		$scope.classButton="btn btn-success btn-lg";
		$scope.candidate = candidate;
		
	}

	$scope.deleteCandidate = function(candidate) {
		candidate.$delete({id: candidate.id}, function() {
			$scope.candidates = Candidate.query();
			$scope.success = "Delete Candidate success";
			$scope.candidate = {};
			$scope.buttonText="Add";
			$scope.state=""; 
		
		});
	}
	
	

	
}