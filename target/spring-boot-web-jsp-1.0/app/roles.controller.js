angular.module("crudApp").controller("RolesController", RolesController);

RolesController.inject = [ '$scope', 'Roles' ];

function RolesController($scope, Roles) {
	
	$scope.roless = Roles.query();

	$scope.roles = {};
	
	$scope.buttonText="Add";
	
	$scope.saveRoles = function() {
		if ($scope.roles.id !== undefined) {
			Roles.update($scope.roles, function() {
				$scope.Roles = Roles.query();
				$scope.roles = {};
				$scope.buttonText="Add";
			});
		} else {
			Roles.save($scope.roles, function() {
				$scope.roless = Roles.query();
				$scope.roles = {};
			});
		}
	}

	$scope.updateRolesInit = function(roles) {
		$scope.buttonText="Update";
		$scope.roles = roles;
	}

	$scope.deleteroles = function(roles) {
		roles.$delete({id: roles.id}, function() {
			$scope.roless = Roles.query();
		});
	}
}