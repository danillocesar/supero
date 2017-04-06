angular.module('tasklist.controllers',[])
// Home controller
.controller('HomeCtrl', function($scope, $allTasks, $editTask, $removeTask, $location) {
	$scope.view = {};
	$scope.getTasks = function(){
		$allTasks.get({}, function(response){
			$scope.view.tasks = response.entity;
		}, function(response){
			alert("Erro de conexão com o servidor");
		});
	}
	$scope.editTask = function(task){
		$location.path('/newtask').search({task: JSON.stringify(task)});
	}
	$scope.finishTask = function(task){
		task.status.id = 3;
		$editTask.save(task, function(response){
			alert(response.entity.system);
			$scope.getTasks();
		}, function(){
			alert("Erro de conexão com o servidor");
		});
	}
	$scope.removeTask = function(task){
		$removeTask.save(task, function(response){
			alert(response.entity.system);
			$scope.getTasks();
		}, function(){
			alert("Erro de conexão com o servidor");
		});
	}
})
.controller('NewTaskCtrl', function($scope, $loginUser, $location, $allStatus, $addTask, $localStorage, $routeParams, $editTask) {
	
	if($routeParams.task){
		$scope.task = JSON.parse($routeParams.task);
	}
	$scope.view = {};
	$allStatus.get({}, function(response){
		$scope.view.statuses = response.entity;
	}, function(){
		alert("Erro de conexão com o servidor");
	});
	$scope.save = function(){
		if($scope.task.id){
			$editTask.save($scope.task, function(response){			
				alert(response.entity.system);
				$location.path( "/home" );
			}, function(){
				alert("Erro de conexão com o servidor");
			});
		}else{
			$scope.task.user = $localStorage.getObject("user");
			$addTask.save($scope.task, function(response){			
				alert(response.entity.system);
				$location.path( "/home" );
				
			}, function(){
				alert("Erro de conexão com o servidor");
			});
		}
	}
})
.controller('LoginCtrl', function($scope, $loginUser, $location, $localStorage) {
	
	$scope.logon = function(event) {
		event.preventDefault();
		var login = $scope.login;
		var password = $scope.password;
		$loginUser.get({login:login, password:password}, function(response){
			if(response.entity.system && response.entity.status == 500){
				alert(response.entity.system);
			}else{
				$localStorage.setObject('user', response.entity);
				$location.path( "/home" );
			}
		},
		function(response){
			alert("Erro de conexão com o servidor");
		});
	}
});
