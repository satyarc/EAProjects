cerebroUIApp.controller('LoginController', function($scope, $rootScope, $http) {
		$scope.login = function() {
			var xmlhttp_addresses = new XMLHttpRequest();
			
			xmlhttp_addresses.onreadystatechange=function() {

				if (xmlhttp_addresses.readyState == 4 && xmlhttp_addresses.status == 200) {
					alert(xmlhttp_addresses.responseText);
					$rootScope.addresses = JSON.parse(xmlhttp_addresses.responseText);
					location.href = "#/dashBoard";
				}else{
					var errorMessage = '<p style="color:red">' + xmlhttp_addresses.responseText + "</p>"
					document.getElementById("header").innerHTML = errorMessage;
				}
			}
			
			url = $rootScope.urlbase + "addresses";
			xmlhttp_addresses.open("GET", url, true);	
			xmlhttp_addresses.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
			xmlhttp_addresses.send();
		}
});