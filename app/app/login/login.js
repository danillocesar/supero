angular.module('tasklist.controllers',[])
// Home controller
.controller('LoginCtrl', function($scope, $loginUser) {
	$scope.logon = function(event) {
		event.preventDefault();
		var login = $scope.login;
		var password = $scope.password;
		$loginUser.get({login:login, password:password}, function(response){
			if(response.entity.system && response.entity.status == 500){
				alert(response.entity.system);
			}else{
				$location.path( "/home" );
			}
		},
		function(response){
			alert("Erro de conexão com o servidor");
		});
	}
});
