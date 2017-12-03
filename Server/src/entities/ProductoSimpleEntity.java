package entities;

import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enumerators.*;
import negocio.Lote;

@Entity
@Table(name="ProductoSimple")
public class ProductoSimpleEntity extends ProductoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1802406766174218765L;
	//@Column(name="medida")
	private String medida;
	/*
	@OneToMany
	@JoinColumn(name="nroLote1")
	private Vector<LoteEntity> lote;
	*/

	public ProductoSimpleEntity(int codigo, String nombre, String sectorEncargado,
			float minimo, float comisionExtra, float consumoEstimado,
			String unidadMedida, float precio) throws Exception {
		
		super(codigo, nombre, sectorEncargado, minimo, comisionExtra,
				consumoEstimado,precio);
		
		/*switch (unidadMedida) {
		case "Kilogramo":
			this.setMedida(UnidadMedida.kilogramo);
		case "Litro":
			this.setMedida(UnidadMedida.litro);
		case "Unidades":
			this.setMedida(UnidadMedida.unidad);
		default:
			throw new Exception("Unidad de medida incorrecta");
			
		}*/
	}

	
	public ProductoSimpleEntity() {
		// TODO Auto-generated constructor stub
	}


	public float getStockActual() {
		float stock = 0;
		/*for (Lote lotes : this.getLotes()) {
			stock = stock + lotes.getCantidad();
		}*/
		return stock;
	}

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
