//  eval minErr.js, Angular.js, loader.js, auto/injector.js, ng/locale.js
//  AngularPublic.js, apis.js

var window = {};
setupModuleLoader(window);
var angular = window.angular;
publishExternalAPI(angular);
var m = angular.module("myModule", []);

m.provider('sk', 'sv').
  factory('fk', 'fv').
  service('a', 'aa').
  value('k', 'v').
  filter('f', 'ff').
  directive('d', 'dd').
  controller('ctrl', 'ccc').
  config('init2').
  constant('abc', 123).
  run('runBlock');

m.controller('myCtrl-01', ['$scope', function($scope) {
	$scope.counter = 0;
}]);
