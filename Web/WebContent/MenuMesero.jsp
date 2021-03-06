<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="./css/estilos.css" />
		<script src="./js/funciones.js"></script>
		<title>TPO Grupo 4 - Menu Mesero</title>
	</head>
	<body>
		
		<div id="sucursalA" class="sucursal">
			<strong>Sucursal A</strong>
			<div id="divA1" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaA1" onclick="buscarPedido('divA1', 'mesaA1', 1, 'A')">Mesa A1</button>
				<button class="agregar" type="button" id="addA1" onclick="agregar('divA1', 'mesaA1', 1, 'A')"></button>
			</div>
			<div id="divA2" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaA2" onclick="buscarPedido('divA2', 'mesaA2', 2, 'A')">Mesa A2</button>
				<button class="agregar" type="button" id="addA2" onclick="agregar('divA2', 'mesaA2', 2, 'A')"></button>
				
			</div>
			<div id="divA3" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaA3" onclick="buscarPedido('divA3', 'mesaA3', 3, 'A')">Mesa A3</button>
				<button class="agregar" type="button" id="addA3" onclick="agregar('divA3', 'mesaA3', 3, 'A')"></button>
			</div>
			<div id="divA4" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaA4" onclick="buscarPedido('divA4', 'mesaA4', 4, 'A')">Mesa A4</button>
				<button class="agregar" type="button" id="addA4" onclick="agregar('divA4', 'mesaA4', 4, 'A')"></button>
				
			</div>
		</div>
		
		<div id="sucursalB" class="sucursal">
			<strong>Sucursal B</strong>
			<div id="divB1" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaB1" onclick="buscarPedido('divB1', 'mesaB1', 1, 'B')">Mesa B1</button>
				<button class="agregar" type="button" id="addB1" onclick="agregar('divB1', 'mesaB1', 1, 'B')"></button>
			</div>
			<div id="divB2" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaB2" onclick="buscarPedido('divB2', 'mesaB2', 2, 'B')">Mesa B2</button>
				<button class="agregar" type="button" id="addB2" onclick="agregar('divB2', 'mesaB2', 2, 'B')"></button>
			</div>
			<div id="divB3" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaB3" onclick="buscarPedido('divB3', 'mesaB3', 3, 'B')">Mesa B3</button>
				<button class="agregar" type="button" id="addB3" onclick="agregar('divB3', 'mesaB3', 3, 'B')"></button>
			</div>
			<div id="divB4" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaB4" onclick="buscarPedido('divB4', 'mesaB4', 4, 'B')">Mesa B4</button>
				<button class="agregar" type="button" id="addB4" onclick="agregar('divB4', 'mesaB4', 4, 'B')"></button>
			</div>
		</div>
		
		<div id="sucursalC" class="sucursal">
			<strong>Sucursal C</strong>
			<div id="divC1" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaC1" onclick="buscarPedido('divC1', 'mesaC1', 1, 'C')">Mesa C1</button>
				<button class="agregar" type="button" id="addC1" onclick="agregar('divC1', 'mesaC1', 1, 'C')"></button>
			</div>
			<div id="divC2" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaC2" onclick="buscarPedido('divC2', 'mesaC2', 2, 'C')">Mesa C2</button>
				<button class="agregar" type="button" id="addC2" onclick="agregar('divC2', 'mesaC2', 2, 'C')"></button>
			</div>
			<div id="divC3" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaC3" onclick="buscarPedido('divC3', 'mesaC3', 3, 'C')">Mesa C3</button>
				<button class="agregar" type="button" id="addC3" onclick="agregar('divC3', 'mesaC3', 3, 'C')"></button>
			</div>
			<div id="divC4" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaC4" onclick="buscarPedido('divC4', 'mesaC4', 4, 'C')">Mesa C4</button>
				<button class="agregar" type="button" id="addC4" onclick="agregar('divC4', 'mesaC4', 4, 'C')"></button>
			</div>
		</div>
		
		<div id="pedido" class="pedidos">
			<span id="sucursalPedidoLabel">Sucursal: </span>
			<span id="sucursalPedidoValue"></span>
			<br />
			<span id="mesaPedidoLabel">Mesa: </span>
			<span id="mesaPedidoValue"></span>
			<br />
			<span id="cantPersonasLabel">Personas: </span>
			<input type="text" id="cantidadComensales" name="cantidadComensales" value="2">
			<br />
			<br />
			<p>Pago:</p>
			<br />			
			<input type="radio" name="pago" value="Efectivo" checked="checked">Efectivo<br>
			<input type="radio" name="pago" value="Tarjeta">Tarjeta
			<br />
			<br />
			<div id="detallePedido"></div>
		</div>
		
	</body>
</html>