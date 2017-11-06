package negocio;

import java.util.Vector;

import enumerators.UnidadMedida;

public class Simple extends Producto {
	
	private UnidadMedida medida;

	public Simple(int codigo, String nombre, int sectorEncargado, float minimo,
			float comisionExtra, float consumoEstimado, String unidadMedida)
			throws Exception {
		super(codigo, nombre, sectorEncargado, minimo, comisionExtra, consumoEstimado);
		switch(unidadMedida){
			case "Kilogramo": this.medida = UnidadMedida.kilogramo;
			case "Litro": this.medida = UnidadMedida.litro;
			case "Unidades": this.medida = UnidadMedida.unidad;
			default: throw new Exception("Unidad de medida incorrecta");
		}
	}

	@Override
	public float getStockActual() {
		float stock = 0;
		for (Lote lote : lotes){
			stock = stock + lote.getCantidad();
		}
		return stock;
	}
	
	
	//comment de prueba para pablo

	

}
