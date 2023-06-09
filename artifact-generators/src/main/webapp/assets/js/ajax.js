function getXMLHTTPRequest() {
	var req = false;

	try {
		req = new XMLHttpRequest(); // Firefox etc
	} catch (err1) {
		try {
			req = new ActiveXObject("Msxml2.XMLHTTP"); // some IE editions
		} catch (err2) {
			try {
				req = new ActiveXObject("Microsoft.XMLHTTP"); // other IE
																// editions
			} catch (err3) {
				req = false;
			}
		}
	}

	return req;
}

function ajaxCallGet(param) {
	var request = getXMLHTTPRequest();
	var url = "bcm"; // or my jsp page (e.g. "page.jsp")
	var params = "op=" + param;

	var asynchr = true;

	var randomNumber = new Date().getTime() + parseInt(Math.random() * 9999999);
	// xtizw to full url pou tha kalesw
	var fullURL = url + "?" + params + "&rand=" + randomNumber;

	request.open("GET", fullURL, asynchr);
	request.onreadystatechange = function() {
		if (request.readyState == 4) {
			if (request.status == 200) {
				var response = request.responseText;
				if (param == "start") {
					response = "<div class='notify successbox'><p><span class='alerticon'><img src='assets/img/play.png' alt='start' /></span>"
							+ response + "</p></div>";
				} else if (param == "stop") {
					response = "<div class='notify successbox'><p><span class='alerticon'><img src='assets/img/shutdown.png' alt='start' /></span>"
							+ response + "</p></div>";
				}
				var content = document.getElementById("content");
				content.innerHTML += response;
			} else {
				alert("An error has occured: " + request.statusText);
			}
		} else {
		}
	}
	request.send(null);

}

function ajaxCallPOST(param) { // GIA NA STELNEIS PARAMETROUS ME MEGALO MHKOS

	var request = getXMLHTTPRequest();

	var myElem = document.getElementById("myElem").value;

	var url = "MyServlet"; // or my jsp page (e.g. "page.jsp")
	var params = "myElem=" + myElem + "&param=" + param;

	var asynchr = true;

	var randomNumber = new Date().getTime() + parseInt(Math.random() * 9999999);
	params = params + "&rand=" + randomNumber;

	request.open("POST", url, asynchr);
	request.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	request.setRequestHeader("Content-length", params.length);
	request.setRequestHeader("Connection", "close");

	request.onreadystatechange = function() {
		if (request.readyState == 4) {
			if (request.status == 200) {

				var response = request.responseText;
				document.getElementById("whereToPlaceMyResponse").innerHTML = response;

			} else {
				alert("An error has occured: " + request.statusText);
			}
		} else {
		}
	}
	request.send(params);

}
