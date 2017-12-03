var request;

function cambiarEstadoMesa(idDiv, idMesa, numero, sucursal){
	var div = document.getElementById(idDiv);
	if(div.className == "cajaMesaVacia"){
		cambiarEstadoMesaAjax(idMesa, numero, sucursal);
		div.className = "cajaMesaOcupada";
	}
	else{
		div.className = "cajaMesaVacia";
		//Hacer función que Facture y la vuelva a la normalidad
	}
}

function cambiarEstadoMesaAjax(idMesa, numeroMesa, sucursal) {
	crearRequest();
	var url = "CambiarEstadoMesa?mesa=" + numeroMesa + "&sucursal='" + sucursal;
	request.onreadystatechange = function(){procesarCambiarEstadoMesa(idMesa);}; 
	request.open("GET", url);
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

function procesarCambiarEstadoMesa(idMesa) {
	if (request.readyState == 4) {
		if (request.status == 200) {
			document.getElementById(idMesa).innerHTML = request.responseText;
		}
	}
}
