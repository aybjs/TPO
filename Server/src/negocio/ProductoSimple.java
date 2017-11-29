package negocio;

import java.util.Vector;

import enumerators.*;

public class ProductoSimple extends Producto {

	private UnidadMedida medida;
	private float precioUnitario;

	public ProductoSimple(int codigo, String nombre, int sectorEncargado,
			float minimo, float comisionExtra, float consumoEstimado,
			String unidadMedida, float precio) throws Exception {
		super(codigo, nombre, sectorEncargado, minimo, comisionExtra,
				consumoEstimado);
		this.precioUnitario = precio;
		switch (unidadMedida) {
		case "Kilogramo":
			this.medida = UnidadMedida.kilogramo;
		case "Litro":
			this.medida = UnidadMedida.litro;
		case "Unidades":
			this.medida = UnidadMedida.unidad;
		default:
			throw new Exception("Unidad de medida incorrecta");
		}
	}

	@Override
	public float getStockActual() {
		float stock = 0;
		for (Lote lote : lotes) {
			stock = stock + lote.getCantidad();
		}
		return stock;
	}

	public float getPrecio() {
		return precioUnitario;
	}

	@Override
	public int getTiempoElaboracion() {
		// TODO Auto-generated method stub
		return 0;
	}

}
