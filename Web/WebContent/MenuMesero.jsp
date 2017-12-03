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
				<button class="mesa" type="button" id="mesaA1" onclick="cambiarEstadoMesa('divA1', 'mesaA1', 1, 'A')">Mesa A1</button>
			</div>
			<div id="divA2" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaA2" onclick="cambiarEstadoMesa('divA2', 'mesaA2', 2, 'A')">Mesa A2</button>
			</div>
			<div id="divA3" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaA3" onclick="cambiarEstadoMesa('divA3', 'mesaA3', 3, 'A')">Mesa A3</button>
			</div>
			<div id="divA4" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaA4" onclick="cambiarEstadoMesa('divA4', 'mesaA4', 4, 'A')">Mesa A4</button>
			</div>
		</div>
		
		<div id="sucursalB" class="sucursal">
			<strong>Sucursal B</strong>
			<div id="divB1" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaB1" onclick="cambiarEstadoMesa('divB1', 'mesaB1', 1, 'B')">Mesa B1</button>
			</div>
			<div id="divB2" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaB2" onclick="cambiarEstadoMesa('divB2', 'mesaB2', 2, 'B')">Mesa B2</button>
			</div>
			<div id="divB3" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaB3" onclick="cambiarEstadoMesa('divB3', 'mesaB3', 3, 'B')">Mesa B3</button>
			</div>
			<div id="divB4" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaB4" onclick="cambiarEstadoMesa('divB4', 'mesaB4', 4, 'B')">Mesa B4</button>
			</div>
		</div>
		
		<div id="sucursalC" class="sucursal">
			<strong>Sucursal C</strong>
			<div id="divC1" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaC1" onclick="cambiarEstadoMesa('divC1', 'mesaC1', 1, 'C')">Mesa C1</button>
			</div>
			<div id="divC2" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaC2" onclick="cambiarEstadoMesa('divC2', 'mesaC2', 2, 'C')">Mesa C2</button>
			</div>
			<div id="divC3" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaC3" onclick="cambiarEstadoMesa('divC3', 'mesaC3', 3, 'C')">Mesa C3</button>
			</div>
			<div id="divC4" class="cajaMesaVacia">
				<button class="mesa" type="button" id="mesaC4" onclick="cambiarEstadoMesa('divC4', 'mesaC4', 4, 'C')">Mesa C4</button>
			</div>
		</div>
		
	</body>
</html>