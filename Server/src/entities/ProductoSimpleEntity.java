package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import enumerators.*;
import negocio.Lote;

@Entity
@DiscriminatorValue(value="Simple")
public class ProductoSimpleEntity extends ProductoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1802406766174218765L;
	@Column(name="medida")
	private UnidadMedida medida;
	@Column(name="precioUnitario")
	private float precioUnitario;

	public ProductoSimpleEntity(int codigo, String nombre, SectorEncargado sectorEncargado,
			float minimo, float comisionExtra, float consumoEstimado,
			String unidadMedida, float precio) throws Exception {
		
		super(codigo, nombre, sectorEncargado, minimo, comisionExtra,
				consumoEstimado);
		
		this.precioUnitario = precio;
		switch (unidadMedida) {
		case "Kilogramo":
			this.setMedida(UnidadMedida.kilogramo);
		case "Litro":
			this.setMedida(UnidadMedida.litro);
		case "Unidades":
			this.setMedida(UnidadMedida.unidad);
		default:
			throw new Exception("Unidad de medida incorrecta");
		}
	}

	
	public float getStockActual() {
		float stock = 0;
		for (Lote lotes : this.getLotes()) {
			stock = stock + lotes.getCantidad();
		}
		return stock;
	}

	public float getPrecio() {
		return precioUnitario;
	}

	public int getTiempoElaboracion() {
		// TODO Auto-generated method stub
		return 0;
	}


	public UnidadMedida getMedida() {
		return medida;
	}


	public void setMedida(UnidadMedida medida) {
		this.medida = medida;
	}


	public float getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	

}
