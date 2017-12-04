var request;

function crearRequest() {
	if (window.XMLHttpRequest) {
		 request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		internetExplorer = true;
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function buscarPedido(idDiv, idMesa, numero, sucursal){
	var div = document.getElementById(idDiv);
	if(div.className == "cajaMesaVacia"){
		document.getElementById("sucursalPedidoValue").innerHTML = sucursal;
		document.getElementById("mesaPedidoValue").innerHTML  = numero;
		cargarPedidos();
	}
	else{
		div.className = "cajaMesaVacia";
		document.getElementById(idMesa).innerHTML = "Mesa " + sucursal + numero;
	}
}

function cargarPedidos(){
	crearRequest();
	var url = "CargarPedidos";
	request.onreadystatechange = function(){cargarPedidosEnDiv();};
	request.open("GET", url);
	request.send(null);
}

function cargarPedidosEnDiv() {
	if (request.readyState == 4) {
		if (request.status == 200) {
			document.getElementById("detallePedido").innerHTML = request.responseText;
		}
	}
}

function pedir(){
	var checks = document.querySelectorAll('input[type=checkbox]');
	var suc = document.getElementById("sucursalPedidoValue").innerHTML;
	var mesa = document.getElementById("mesaPedidoValue").innerHTML;
	var idDiv = "div" + suc + mesa
	var idMesa = "mesa" + suc + mesa
	var i;
	var j = 0;
	var array = new Array();
	for (i = 0; i < checks.length; i++) {
		if(checks[i].checked == true){
			array[j] = checks[i].value;
			j++;
		}
	}
	pedirAjax(array, idMesa, mesa);
	cambiarEstadoMesa(idDiv, idMesa, mesa, suc);
}

function pedirAjax(array, idMesa, mesa){
	crearRequest();
	var url = "GenerarPedido?array=" + array + "&mesa=" + mesa;
	request.onreadystatechange = function(){cargarPedidosEnMesa(idMesa);};
	request.open("GET", url);
	request.send(null);
}

function cargarPedidosEnMesa(idMesa){
	if (request.readyState == 4) {
		if (request.status == 200) {
			document.getElementById(idMesa).innerHTML = request.responseText;
			document.getElementById("detallePedido").innerHTML = "";
		}
	}
}

function cambiarEstadoMesa(idDiv, idMesa, numero, sucursal){
	var div = document.getElementById(idDiv);
	if(div.className == "cajaMesaVacia"){
		div.className = "cajaMesaOcupada";
	}
	else{
		div.className = "cajaMesaVacia";
		document.getElementById(idMesa).innerHTML = "Mesa " + sucursal + numero;
	}
}
