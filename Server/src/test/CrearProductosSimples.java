package test;

import controllers.ControladorCentral;

public class CrearProductosSimples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ControladorCentral negocio = ControladorCentral.getInstancia();
		
		negocio.agregarIngredientes("tomate", "cocina", 0, 0.0f, 0, "unidades");
		negocio.agregarIngredientes("albahaca", "cocina", 0, 0.03f, 0, "unidades");
		negocio.agregarIngredientes("aceite", "cocina", 0, 0.01f, 0, "unidades");
		negocio.agregarIngredientes("tomillo", "cocina", 0, 0.002f, 0, "unidades");
		negocio.agregarIngredientes("queso regianito", "cocina", 0, 0.0001f, 0, "gramos");
		negocio.agregarIngredientes("carne picada", "cocina", 0, 0.0053f, 0, "gramos");
		

	}

}
