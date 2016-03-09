'use strict';

App.controller('CompanyController', ['$scope', 'CompanyService', function($scope, UserService) {
          var self = this;
          self.user={id:null,username:'',address:'',email:''};
          self.users=[];
              
          self.fetchAllCompanies = function(){
              UserService.fetchAllCompanies()
                  .then(
      					       function(d) {
      						        self.users = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Companies');
            					}
      			       );
          };
           
          self.createCompany = function(user){
              UserService.createCompany(user)
		              .then(
                      self.fetchAllCompanies, 
				              function(errResponse){
					               console.error('Error while creating Company.');
				              }	
                  );
          };

         self.updateCompany = function(user, id){
              UserService.updateCompany(user, id)
		              .then(
				              self.fetchAllCompanies, 
				              function(errResponse){
					               console.error('Error while updating Company.');
				              }	
                  );
          };

          self.fetchAllCompanies();

          self.submit = function() {
              if(self.user.id==null){
                  console.log('Saving New User', self.user);    
                  self.createCompany(self.user);
              }else{
                  self.updateCompany(self.user, self.user.id);
                  console.log('User updated with id ', self.user.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.users.length; i++){
                  if(self.users[i].id == id) {
                     self.user = angular.copy(self.users[i]);
                     break;
                  }
              }
          };
              
          self.reset = function(){
              self.user={id:null,username:'',address:'',email:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
