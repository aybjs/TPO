<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="./css/estilos.css" />
		<script src="./js/funciones.js"></script>
		<title>TPO Grupo 4 - Crear Plato</title>
	</head>
	<body>
		 <form id="crearPlato">
		  Precio: <input type="text" id="precio" name="precio" value="1">
		  <br />
		  <br />
		  Nombre: <input type="text" id="nombre" name="nombre" value="nombre">
  		  <br />
  		  <br />
  		  Stock: <input type="text" id="stock" name="stock" value="1">
  		  <br />
  		  <br />
  		  Comision: <input type="text" id="comisionExtra" name="comisionExtra" value="1">
		  <br /> 
		  <br />
		  <span>Cocina  </span><input type="radio" name="area" value="Cocina" checked="checked"><span>   </span>
  		  <span>Cafeteria  </span><input type="radio" name="area" value="Cafeteria"><span>   </span>
  		  <span>Barra  </span><input type="radio" name="area" value="Barra"><span>   </span>
		  
		  <br /> 
		  <br />
		  <button class="pedir" type="button" id="crearPlato" onclick="crearAlgo()" >Crear Plato</button>
		  <br /> 
		  <br /> 
		</form> 
		<div id="platoCreadoResultado"></div>
	</body>
</html>