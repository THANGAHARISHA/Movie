var app = angular.module("searchMoviesApp",[]);

app.controller('searchMoviesController', ['$scope','SearchMoviesService','$window','$http',
  function ($scope,SearchMoviesService,$window,$http) {

	$scope.movieOnLoad = function() {
		$scope.username=$window.sessionStorage.getItem('username');
		$scope.isAuthenticated=$window.sessionStorage.getItem('isAuthenticated');
		$scope.isSearchEnabled= true;
	};	
	
	$scope.logout = function() {
		$window.sessionStorage.setItem('username','');
		$window.sessionStorage.setItem('isAuthenticated', false);
		 $window.movieName.href = '/';
	}
	
	$scope.movies = [];
	 $scope.IsVisible = false;
      $scope.searchMovies = function () {    	  
    	  SearchMoviesService.searchMovies($scope.searchcriteria.place,$scope.searchcriteria.movieName,$scope.searchcriteria.movieDate,$scope.searchcriteria.count)
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
          	$scope.errorMessage='Error while getting the movies. Please try again later!';
			$scope.message='';
          });
      };   
      
      
  	
 	 $scope.isBookingEnabled=false;
      $scope.bookMovie= function(nameOfTheatre,movieNumber,place,movieName,movieDate,movieTime,currency,amount) {
     	$scope.isBookingEnabled=true;
     	$scope.isSearchEnabled= false;
     	$scope.bookMovie.nameOfTheatre= nameOfTheatre;
     	$scope.bookMovie.movieNumber= movieNumber;
     	$scope.bookMovie.place = place;     	
     	$scope.bookMovie.movieName = movieName;
     	$scope.bookMovie.movieDate = movieDate;
     	$scope.bookMovie.movieTime = movieTime;
     	$scope.bookMovie.currency= currency;
    	$scope.bookMovie.amount= amount;     	
  	};
  	
  	$scope.bookMovieWithMember = function(bookMovie,member1, member2, member3, member4) {
  		 $scope.members= [];
  		 $scope.members.push({
	  				 firstName: member1.firstName,
	  				 lastName: member1.lastName,
	  				 gender: member1.gender,
	  				 mobileNumber: member1.mobileNumber
	  		 },
	  		{
					 firstName: member2.firstName,
					 lastName: member2.lastName,
					 gender: member2.gender,
					 mobileNumber: member2.mobileNumber
			 },
			 {
					 firstName: member3.firstName,
					 lastName: member3.lastName,
					 gender: member3.gender,
					 mobileNumber: member3.mobileNumber
			 },
			 {
					 firstName: member4.firstName,
					 lastName: member4.lastName,
					 gender: member4.gender,
					 mobileNumber: member4.mobileNumber
			 });
  		 bookMovie.members= $scope.members;
  		 console.log(bookMovie.members);
  		 console.log($scope.members);
  		 console.log(bookMovie);
  		 $scope.isBookingEnabled=false;
  		 $scope.isSearchEnabled= false;
  		 $scope.isBookingConfirmEnabled=true;
  		 $scope.bookingDetails='';
  		 
  		 $http({
			method: 'POST', 
			url: 'bookMovie',
				data: {
				    movieNumber: bookMovie.movieNumber,
					place: bookMovie.place,
					movieName: bookMovie.movieName,
					amount: bookMovie.amount,
					movieDate: bookMovie.movieDate,
				    movieTime: bookMovie.movieTime,
					members: bookMovie.members					
				}						
		}).then(function success(response) {
				console.log(response.data);
				$scope.bookingDetails=response.data;
		    },
		    function error(response) { 
		    	console.log(response.status);
		    });
  	};
      
}]);


app.service("SearchMoviesService", ['$http', function($http){
	this.searchMovies = function searchMovies(place, movieName,movieDate, count){
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