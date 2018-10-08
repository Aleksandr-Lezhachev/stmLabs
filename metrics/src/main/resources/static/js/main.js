var app = angular.module("metrics", [])
    .service('myService', function ($scope) {

    })
    .directive('myDirective', ['myService', function (myService) {

    }])
    .controller("AppCtrl", function ($scope, $http) {
        $scope.metrics = [];
        $http.get('http://localhost:8080/api/v1/metrics/get/cpu/all')
            .then(function (response) {
                $scope.metrics = response.data;
                console.log(response.data);
            });
        $http.post('http://localhost:8080/api/v1/metrics/get/cpu/all')
            .then(function (response) {
                $scope.metrics = response.data;
                console.log(response.data);
            });
    });