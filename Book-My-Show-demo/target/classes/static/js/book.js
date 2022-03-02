var app = angular.module("bookMovieApp",[]);

app.controller('bookMovieController', ['$scope','BookMovieService','$window', 
  function ($scope,BookMovieService,$window) {
	$scope.bookOnLoad = function() {
		$scope.username=$window.sessionStorage.getItem('username');
		$scope.isAuthenticated=$window.sessionStorage.getItem('isAuthenticated');
	};	
	$scope.movies = [];
	 $scope.IsVisible = false;
      $scope.searchMovies = function () {    	  
    	  BookMovieService.searchMovies($scope.searchcriteria.place,$scope.searchcriteria.movieName,$scope.searchcriteria.movieDate,$scope.searchcriteria.count)
    	  .then(function success(response) {
    		  if(response.data.length <=0){
    			  	$scope.IsVisible = false;
  					$scope.errorMessage='No Records Found!';
  					$scope.message='';
    		  }else{    			    
    	          	$scope.movies= response.data;
    				$scope.errorMessage='';
    				$scope.message='';
    				$scope.IsVisible = true;
    		  }
          	
          },
  	    function error(response) { 
          	$scope.errorMessage='Please...Enter the correct Details!';
			$scope.message='';
          });
      };
}]);

app.service("BookMovieService", ['$http', function($http){
	this.searchMovies = function searchMovies(place, movieName, movieDate, count){
		return $http({
			method: 'POST', 
			url: 'searchMovies',
				data: {
					place: place,
					movieName: movieName,
					movieDate: movieDate,
					count: count
				}						
		});
	}
}]);