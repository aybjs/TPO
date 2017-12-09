package negocio;

import java.util.Vector;

import enumerators.*;

public class ProductoSimple extends Producto {

	private String medida;

	public ProductoSimple(int codigo, String nombre, String sectorEncargado,
			float minimo, float comisionExtra, float consumoEstimado,
			String unidadMedida, float precio) throws Exception {
		super(codigo, nombre, sectorEncargado, minimo, comisionExtra,
				consumoEstimado,precio);
		this.medida = unidadMedida;
		/*
		switch (unidadMedida) {
		case "Kilogramo":
			this.medida = UnidadMedida.kilogramo;
		case "Litro":
			this.medida = UnidadMedida.litro;
		case "Unidades":
			this.medida = UnidadMedida.unidad;
		default:
			throw new Exception("Unidad de medida incorrecta");
		}*/
	}

	public ProductoSimple() {
	}

	@Override
	public float getStockActual() {
		float stock = 0;
		for (Lote lote : lotes) {
			stock = stock + lote.getCantidad();
		}
		return stock;
	}

	@Override
	public int getTiempoElaboracion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	
	
}
