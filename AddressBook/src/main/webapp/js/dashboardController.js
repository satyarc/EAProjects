cerebroUIApp.controller('DashboardController', function($scope, $rootScope, $http) {
		$scope.addresses = $rootScope.addresses;
		var selectedAddresses = [];
		
		alert($scope.addresses);
		$scope.addresses.forEach(function(item){
			selectedAddresses.push({"selected":false,"address":item});
		});
		$scope.selectedAddresses = selectedAddresses;
			
		$scope.toggleAll = function() {
			 var toggleStatus = !$scope.isAllSelected;
			 angular.forEach($scope.selectedAddresses, function(itm){ itm.selected = toggleStatus; });
		}
  
		$scope.optionToggled = function(){
			$scope.isAllSelected = $scope.selectedAddresses.every(function(itm){ return itm.selected; })
		}
		
		$scope.deleteAddresses = function(){
			$scope.selectedAddresses.filter(function(item){
				return item.selected;
			}).forEach(function(item){
				if(item.selected){
					var url = $rootScope.urlbase + "addresses/" + item.address.id + "/delete";
					alert(url);
					var xmlhttp = new XMLHttpRequest();
					xmlhttp.open("POST", url, true);	
					xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");			
					xmlhttp.send();
				}
			});
			location.href="#/dashBoard";
		}
		
		$scope.addAddresses = function(){
			location.href="#/addAddress";
		}
});