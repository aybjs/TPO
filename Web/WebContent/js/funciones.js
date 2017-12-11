var request;

function crearRequest() {
	if (window.XMLHttpRequest) {
		 request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		internetExplorer = true;
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function agregar(idDiv, idMesa, numero, sucursal){
	document.getElementById("sucursalPedidoValue").innerHTML = sucursal;
	document.getElementById("mesaPedidoValue").innerHTML  = numero;
	sumarPedidos();
}


function buscarPedido(idDiv, idMesa, numero, sucursal){
	var div = document.getElementById(idDiv);
	if(div.className == "cajaMesaVacia"){
		document.getElementById("sucursalPedidoValue").innerHTML = sucursal;
		document.getElementById("mesaPedidoValue").innerHTML  = numero;
		cargarPedidos();
	}
	else{
		var pedido = document.getElementById(idMesa).innerHTML;
		var pagoEfectivoOTarjeta = null;
		var radios = document.getElementsByName('pago');
		for (var i = 0; i <= radios.length; i++){
			if (radios[i].checked){
				 pagoEfectivoOTarjeta = radios[i].value;
				 break;
			}
		}
		facturarPedido(pedido, pagoEfectivoOTarjeta);		
		document.getElementById(idMesa).innerHTML = "Mesa " + sucursal + numero;
		cambiarEstadoMesa(idDiv, idMesa, numero, sucursal);

	}
}

function stock(){
	crearRequest();
	var url = "Stock";
	request.onreadystatechange = function(){cargarStock();};
	request.open("GET", url);
	request.send(null);
}

function cargarStock(){
	if (request.readyState == 4) {
		if (request.status == 200) {
			document.getElementById("divStock").innerHTML = request.responseText;
		}
	}
}

function facturarPedido(pedido, pagoEfectivoOTarjeta){
	crearRequest();
	var url = "FacturarPedido?pedido=" + pedido + "&pagoEfectivoOTarjeta=" + pagoEfectivoOTarjeta;
	request.onreadystatechange = function(){facturarPedidoAJAX();};
	request.open("GET", url);
	request.send(null);
}

function facturarPedidoAJAX(){
	if (request.readyState == 4) {
		if (request.status == 200) {
			alert("Cobrar: " + request.responseText);
		}
	}
}

function cargarPedidos(){
	crearRequest();
	var url = "CargarPedidos";
	request.onreadystatechange = function(){cargarPedidosEnDiv();};
	request.open("GET", url);
	request.send(null);
}

function sumarPedidos(){
	crearRequest();
	var url = "SumarPedidos";
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
	var cantidad = document.getElementById("cantidadComensales").value;
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
	pedirAjax(array, idMesa, mesa, cantidad, suc);
	cambiarEstadoMesa(idDiv, idMesa, mesa, suc);
}

function sumarAlPedido(){
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
	var pedido = document.getElementById("mesa" + suc + mesa).innerHTML;
	otroAjax(array, mesa, suc, pedido);
	sumarAjax(array, idMesa, mesa, cantidad, suc, pedido);
}

function otroAjax(array, mesa, suc, pedido){
	crearRequest();
	var url = "AgregarAlPedido?array=" + array + "&mesa=" + mesa + "&sucursal=" + suc + "&pedido=" + pedido;
	request.onreadystatechange = function(){sumarProductoAlPedido();};
	request.open("GET", url);
	request.send(null);
}

function pedirAjax(array, idMesa, mesa, cantidad, suc){
	crearRequest();
	var url = "GenerarPedido?array=" + array + "&mesa=" + mesa + "&cant=" + cantidad + "&sucursal=" + suc;
	request.onreadystatechange = function(){cargarPedidosEnMesa(idMesa);};
	request.open("GET", url);
	request.send(null);
}

function sumarAjax(array, idMesa, mesa, cantidad, suc, pedido){
	var url = "AgregarAlPedido?array=" + array + "&mesa=" + mesa + "&sucursal=" + suc + "&pedido=" + pedido;
	alert("AgregarAlPedido?array=" + array + "&mesa=" + mesa + "&sucursal=" + suc + "&pedido=" + document.getElementById("mesa" + suc + mesa).innerHTML);
	request.onreadystatechange = function(){sumarProductoAlPedido();};
	request.open("GET", url);
	request.send(null);
}

function cargarPedidosEnMesa(idMesa){
	if (request.readyState == 4) {
		if (request.status == 200) {
			document.getElementById(idMesa).innerHTML = request.responseText.replace(".0","");
			var sucursal = idMesa.substring(4,5);
			var mesa = idMesa.substring(5,6);
			var idMas = 'add' + sucursal + mesa;
			document.getElementById(idMas).innerHTML = "+";
			document.getElementById("detallePedido").innerHTML = "";
		}
	}
}

function sumarProductoAlPedido(){
	if (request.readyState == 4) {
		if (request.status == 200) {
			if (request.responseText == 1){
				alert ("Agregado OK");
				document.getElementById("detallePedido").innerHTML = "";	
			}
			else{
				alert("No agregado");
			}
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
		document.getElementById('add' + sucursal + numero).innerHTML = "";
	}
}

function crearAlgo(){
	var precio = document.getElementById("precio").value;
	var nombre = document.getElementById("nombre").value;
	var stock = document.getElementById("stock").value;
	var comisionExtra = document.getElementById("comisionExtra").value;
	var areaProd = 'Cocina';
	
	crearRequest();
	var url = "CrearPlato?precio=" + precio + "&nombre=" + nombre + "&stock=" + stock + "&comisionExtra=" + comisionExtra + "&areaProd=" + areaProd;
	request.onreadystatechange = function(){CrearPlatoAJAX();};
	request.open("GET", url);
	request.send(null);
}

function CrearPlatoAJAX(){
	if (request.readyState == 4) {
		if (request.status == 200) {
			document.getElementById("platoCreadoResultado").innerHTML = request.responseText;
		}
	}
}

function agregarIngredientes(){
	var ing = document.querySelectorAll(".ing");
	var nombre = document.getElementById("nombre").innerHTML;
	for (i = 0; i < ing.length; i++){		
		var ingrediente = ing[i].innerHTML;
		var cantidad = document.getElementById("cant."+ing[i].innerHTML).value;
		if (cantidad > 0){
			agregarIngredienteSolo(nombre, ingrediente, cantidad);
		}
	}
}

function agregarIngredienteSolo(nombre, ingrediente, cantidad){
	crearRequest();
	var url = "AgregarIngrediente?nombre=" + nombre + "&ingrediente=" + ingrediente + "&cantidad=" + cantidad;
	request.onreadystatechange = function(){agregarIngredienteSoloAJAX(ingrediente);};
	request.open("GET", url);
	request.send(null);
}

function agregarIngredienteSoloAJAX(ingrediente){
	if (request.readyState == 4) {
		if (request.status == 200) {
			alert(ingrediente + " agregado");
		}
	}
}

function cerrarLaCaja(){
	crearRequest();
	var url = "CerrarCajas";
	request.onreadystatechange = function(){cerrarCajaAjax();};
	request.open("GET", url);
	request.send(null);
}

function cerrarCajaAjax(){
	if (request.readyState == 4) {
		if (request.status == 200) {
			document.getElementById("cerrarCajaResultado").innerHTML = request.responseText;
		}
	}
}

function comisiones(){
	crearRequest();
	var url = "CalcularComisiones";
	request.onreadystatechange = function(){calcularComisiones();};
	request.open("GET", url);
	request.send(null);
}

function calcularComisiones(){
	if (request.readyState == 4) {
		if (request.status == 200) {
			document.getElementById("calcularComisionesResultado").innerHTML = request.responseText;
		}
	}
}
