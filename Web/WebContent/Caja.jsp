<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="./css/estilos.css" />
		<script src="./js/funciones.js"></script>
		<title>TPO Grupo 4 - Caja</title>
	</head>
	<body>
		
		<div id="cerrarCaja">
			<button class="mesa" type="button" id="cerrarCajaButton" onclick="cerrarLaCaja()">Cerrar Cajas</button>			
		</div>

		<br />
		<div id="cerrarCajaResultado"></div>
		
		<br />
		<div id="calcularComisiones">
			<p>No ejecutar hasta no tener cerradas las cajas</p>
			<button class="mesa" type="button" id="calcularComisionesButton" onclick="comisiones()">Calcular Comisiones</button>			
		</div>

		<br />
		<div id="calcularComisionesResultado"></div>
			
	</body>
</html>