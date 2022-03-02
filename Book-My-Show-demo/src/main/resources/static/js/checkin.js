var app = angular.module("checkinApp",[]);

app.controller('checkinController', ['$scope','CheckinService','$window','$http',
  function ($scope,CheckinService,$window,$http) {

	$scope.checkinOnLoad = function() {
		$scope.username=$window.sessionStorage.getItem('username');
		$scope.isAuthenticated=$window.sessionStorage.getItem('isAuthenticated');
		$scope.isCheckinFetchResult= false;
	};	
	
	$scope.logout = function() {
		$window.sessionStorage.setItem('username','');
		$window.sessionStorage.setItem('isAuthenticated', false);
		 $window.movieName.href = '/';
	}
	
      $scope.fetchCheckinData = function () { 
    	  CheckinService.fetchCheckinData($scope.checkin.bookingId)
    	  .then(function success(response) {
    		  if(response.data.length <=0){
    			  	$scope.isCheckinFetchResult= false;
  					$scope.errorMessage='No Records Found!';
  					$scope.message='';
    		  }else{    			    
    	          	$scope.bookingRecord= response.data;
    	          	console.log($scope.bookingRecord);
    				$scope.errorMessage='';
    				$scope.message='';
    				$scope.isCheckinFetchResult= true;			
    		  }
          	
          },
  	     function error(response) { 
          	$scope.errorMessage='Error while getting the movies. Please try again later!';
			$scope.message='';
			$scope.isCheckinFetchResult= false;
          });
      };
      
      $scope.checkinMovie = function checkinMovie(memberId, seatNumber){
    	  $scope.memberFromUI= {
    			  memberId: memberId,
    			  checkIn: {
    				  seatNumber: seatNumber
    			  	}
    			  };      
		    	  $http({
		  			method: 'POST', 
		  			url: 'checkin',
		  			data: $scope.memberFromUI
		  		}).then(function success(response){
		  				console.log(response.data);
		  				alert('Checkin completed');
		  				$window.movieName.href = '/checkin';
		  			},function error(response){
		  				console.log(response.status);
		  			});
		  		};	    
      
}]);


app.service("CheckinService", ['$http', function($http){
	this.fetchCheckinData = function fetchCheckinData(bookingId){
		return $http.get('booking/'+bookingId);
	}
}]);