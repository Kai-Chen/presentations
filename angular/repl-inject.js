// create an injector and inspect it
var inj = angular.injector([]);

// use the injector to annotate a function
function fn($scope, $resource) {}
inj.annotate(fn);

// create a module with dependencies
var m = angular.module('myModule', []);

function NumberProvider() {
  var start = 0;
  this.$get = function() {
    return {
      next: function() { return ++start; }
    };
  };
}

function CharService() {
  var alphabet = "abcdefghijklmnopqrstuvwxyz".split('');
  var pos = 0;
  this.next = function () {
    if (pos >= alphabet.size) pos = 0;
    return alphabet[pos++];
  };
}

m.provider({counter: NumberProvider});
m.service('letter', CharService);
m.factory('sequence', ['letter', 'counter', function (letter, counter) {
  function NameGen(letter, counter) {
    this.next = function() { return letter.next() + counter.next(); };
  }
  return new NameGen(letter, counter);
}]);

// use the injector to locate each components
inj = angular.injector(['myModule']);

var s = inj.get('sequence');
s.next();

var n = inj.get('counter');
n.next();

var a = inj.get('letter');
a.next();
