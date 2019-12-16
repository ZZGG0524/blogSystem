function GetXMlHttpRequest() {
	if(window.XMLHttpRequest) {
		//非IE浏览器
		return new XMLHttpRequest;
	}else {
		return new ActiveXObject('Microsoft.XMLHttp');
	}
}