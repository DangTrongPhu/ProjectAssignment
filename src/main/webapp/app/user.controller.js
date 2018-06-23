angular.module("crudApp").controller("UserController", UserController);

UserController.inject = [ '$scope', 'User' ];

function UserController($scope, User) {
	
	$scope.users = User.query();

	$scope.user = {};
	
	$scope.buttonText="Add";
	
	$scope.saveUser = function() {
		if ($scope.user.id !== undefined) {
			User.update($scope.user, function() {
				$scope.users = User.query();
				$scope.user = {};
				$scope.buttonText="Add";
			});
		} else {
			User.save($scope.user, function() {
				$scope.users = User.query();
				$scope.user = {};
			});
		}
	}

	$scope.updateUserInit = function(user) {
		$scope.buttonText="Update";
		$scope.user = user;
	}

	$scope.deleteuser = function(user) {
		user.$delete({id: user.id}, function() {
			$scope.users = User.query();
		});
	}
	
	

	
}