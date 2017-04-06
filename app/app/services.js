angular.module('tasklist.services', ['ngResource'])
.factory('$loginUser', function($resource, WEB_SERVICE) {
	return $resource('http://' + WEB_SERVICE + 'logon?login=:login&password=:password')
})
.factory('$allTasks', function($resource, WEB_SERVICE) {
	return $resource('http://' + WEB_SERVICE + 'task/list')
})
.factory('$allStatus', function($resource, WEB_SERVICE) {
	return $resource('http://' + WEB_SERVICE + 'status/list')
})
.factory('$addTask', function($resource, WEB_SERVICE) {
	return $resource('http://' + WEB_SERVICE + '/task/addObj?task=:task')
})
.factory('$editTask', function($resource, WEB_SERVICE) {
	return $resource('http://' + WEB_SERVICE + '/task/editObj?task=:task')
})
.factory('$removeTask', function($resource, WEB_SERVICE) {
	return $resource('http://' + WEB_SERVICE + '/task/removeObj?task=:task')
})
.factory('$localStorage', ['$window', function($window) {
    return {
      set: function(key, value) {
        $window.localStorage[key] = value;
      },
      get: function(key, defaultValue) {
        return $window.localStorage[key] || defaultValue;
      },
      setObject: function(key, value) {
        $window.localStorage[key] = JSON.stringify(value);
      },
      getObject: function(key) {
        return JSON.parse($window.localStorage[key] || null);
      }
    }
  }])