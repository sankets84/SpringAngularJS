'use strict';

App.factory('CompanyService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllCompanies: function() {
					return $http.get('http://localhost:8080/SpringAngularJS/allcompany/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			},
		    
			createCompany: function(user){
					return $http.post('http://localhost:8080/SpringAngularJS/company/', user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateCompany: function(user, id){
					return $http.put('http://localhost:8080/SpringAngularJS/company/'+id, user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating user');
										return $q.reject(errResponse);
									}
							);
			},
		    
			/*deleteUser: function(id){
					return $http.delete('http://localhost:8080/Spring4MVCAngularJSExample/user/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting user');
										return $q.reject(errResponse);
									}
							);
			}*/
		
	};

}]);
