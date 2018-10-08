/*var module = angular.module("metrics", ['ngResource'])
   .service('myService', function ($scope) {

    })
    .directive('myDirective', ['myService', function (myService) {

    }])

    module.factory('Metric', function ($resource) {
        return $resource(':metric/attributes',{metric:'@metric'})
    })
    .controller("MetricCtrl", function ($scope, Metric) {
       var url = function () {
           return{metric:$scope.metric};
       }

       $scope.add=function () {
           var metric = new Metric();
           metric.params = $

       }
    });*/