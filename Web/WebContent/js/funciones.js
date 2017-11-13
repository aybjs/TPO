var request;

function cambiarEstadoMesa(idMesa, numero){
	var mesa = document.getElementById(idMesa);
	if(mesa.className == "cajaMesaVacia"){
		mesa.className = "cajaMesaOcupada";
		cambiarEstadoMesaAjax(numero);
	}
	else{
		mesa.className = "cajaMesaVacia";
	}
}

function cambiarEstadoMesaAjax(numeroMesa) {
	crearRequest();
	var url = "/AD_TPO_TOMCAT/CambiarEstadoMesa?mesa=" + numeroMesa;
	request.onreadystatechange = procesarCambiarEstadoMesa; 
	request.open("GET", url, true);
	request.send(null);
}

function crearRequest() {
	if (window.XMLHttpRequest) {
		 request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		internetExplorer = true;
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function procesarCambiarEstadoMesa() {
	if (request.readyState == 4) {
		if (request.status == 200) {
			document.getElementById("respuesta").innerHTML = request.responseText;
		}
	}
}