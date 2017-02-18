cerebroUIApp.controller('AddAddressController', function($scope, $rootScope){
	$scope.addAddresses = function() {
		var xmlhttp_addresses = new XMLHttpRequest();
		url = $rootScope.urlbase + "addAddress";
		xmlhttp_addresses.open("POST", url, true);	
		xmlhttp_addresses.setRequestHeader("Content-Type", "application/json;charset=UTF-8");			
		xmlhttp_addresses.send({"name": $scope.name, "address": $scope.user, "phone" : $scope.phone});
	
		xmlhttp_addresses.onreadystatechange=function() {
			if (xmlhttp_addresses.readyState == 4 && xmlhttp_addresses.status == 200) {
				$rootScope.deployments = JSON.parse(xmlhttp_addresses.responseText);
				location.href = "#/dashBoard";
			}else{
				var errorMessage = '<p style="color:red">' + xmlhttp_addresses.responseText + "</p>"
				document.getElementById("header").innerHTML = errorMessage;
			}
		}
	}
});