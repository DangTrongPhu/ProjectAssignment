angular.module('crudApp').factory('Candidate', Candidate);

Candidate.$inject = [ '$resource' ];

function Candidate($resource) {
	var resourceUrl = 'api/candidate/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}