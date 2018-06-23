angular.module('crudApp').factory('Roles', Roles);

Roles.$inject = [ '$resource' ];

function Roles($resource) {
	var resourceUrl = 'api/roles/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}