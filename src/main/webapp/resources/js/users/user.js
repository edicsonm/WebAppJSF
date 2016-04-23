/**
 * 
 */

//alert('cargando libreria user.js');
angular.module('WebApp',['ui.bootstrap','ngMessages']);
angular.module('WebApp').controller('userController',['$scope','$http','$uibModal','$log',function($scope, $http, $uibModal, $log){
	
//	alert('Cargando Module');
	console.log('Ejecutando esto ...');
	
	$scope.edit = function(title, sSO, firstName, size) {
		var modalInstance = $uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'userForm.xhtml',
			controller:function($scope, $uibModalInstance, title, sSO, firstName){
				
				console.log('1 Imprimiendo usuario');
				console.log(sSO);
				console.log('2 Imprimiendo usuario');
				console.log(firstName);
				console.log('3 Imprimiendo usuario');
				
				$scope.hideErrors = true;
				$scope.title = title;
				$scope.sso = sSO;
				$scope.firstName = firstName;
				
				$scope.dismiss = function() {
					$scope.hideErrors = true;
					$scope.messages = [];
				};
				
				var index = 0;
				$scope.selectOptionSelect = function(state) {
					if (state == user.state) return true;
					return false;
				};
				
				$scope.save = function () {
					console.log($scope.sso);
					console.log($scope.firstName);
					/*$scope.user = {sso:$scope.sso, firstName:$scope.firstName, lastName:$scope.lastName, email:$scope.email, state:$scope.state, password:$scope.password};*/
					$http({
						  method: 'POST',
						  url: '/WebApp/updateUser'
						}).then(function successCallback(response) {
						    // this callback will be called asynchronously
						    // when the response is available
							console.log(response);
						  }, function errorCallback(response) {
							  console.log(response);
						    // called asynchronously if an error occurs
						    // or server returns response with an error status.
						  });
				};
				
				/*$scope.save = function () {
					$scope.user = {sso:$scope.sso, firstName:$scope.firstName, lastName:$scope.lastName, email:$scope.email, 
							state:$scope.state, password:$scope.password};
					userService.updateUser($scope.user).then(
					function(response) {
						console.log(response);
		    			$uibModalInstance.close(response);
					}, function(reason) {
						
						console.log(reason);
						$scope.titleMessage = 'Error';
		    			$scope.classAlert = 'danger';
		    			$scope.titleMessage = 'Error';
		    			$scope.hideErrors = false;
		    			$scope.messages = [];
		    			
		    			var fieldErrors = reason.data.errors;
		    			for (var int = 0; int < fieldErrors.length; int++) {
							var message = {cause:fieldErrors[int].cause,error:fieldErrors[int].error};
							$scope.messages.push(message);
						}
					})
				};
				*/
				$scope.cancel = function () {
					$uibModalInstance.dismiss('Cancel');
				};
			},
			size:size,
			resolve:{
				title: function() {return title;},
				sSO : function (){return sSO;},
				firstName : function (){return firstName;}
			}
		});
		
		modalInstance.result.then(function (response){
			if(response.status == 200){
				var data = response.data;
				$scope.loadUsers();
    			$scope.titleMessage = data.titleMessage;
    			$scope.message = data.message;
    			$scope.classAlert = 'success';
    			$scope.hide = false;
    		}
	    });
		
	};
	
}]);


/*angular.module('todoApp', []).controller('TodoListController', function() {})*/
//angular.module('pepo').controller('UserController', ['$scope','$uibModal','$log','userService', function($scope, $uibModal, $log, userService) {
