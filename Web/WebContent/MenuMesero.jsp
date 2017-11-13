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
		
		<div id="cajaMesa1" class="cajaMesaVacia">
			<button class="mesa" type="button" id="mesa1" onclick="cambiarEstadoMesa('cajaMesa1',1)">Mesa 1</button>
		</div>
		<div id="cajaMesa2" class="cajaMesaVacia">
			<button class="mesa" type="button" id="mesa2" onclick="cambiarEstadoMesa('cajaMesa2',2)">Mesa 2</button>
		</div>
		<div id="cajaMesa3" class="cajaMesaVacia">
			<button class="mesa" type="button" id="mesa3" onclick="cambiarEstadoMesa('cajaMesa3',3)">Mesa 3</button>
		</div>
		<div id="cajaMesa4" class="cajaMesaVacia">
			<button class="mesa" type="button" id="mesa4" onclick="cambiarEstadoMesa('cajaMesa4',4)">Mesa 4</button>
		</div>
		
		<div id="respuesta"></div>
	</body>
</html>