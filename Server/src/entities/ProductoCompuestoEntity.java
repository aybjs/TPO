package entities;

import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import enumerators.SectorEncargado;

@Entity
@DiscriminatorValue(value="Compuesto")
public class ProductoCompuestoEntity extends ProductoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(cascade=CascadeType.ALL)
	private Vector<ProductoEntity> items;
	@OneToMany(cascade=CascadeType.ALL)
	private Vector<Integer> cantItem;
	@Column(name="tiempoElaboracion")
	private int tiempoElaboracion; 

	public ProductoCompuestoEntity(int codigo, String nombre, SectorEncargado sectorEncargado,
			float minimo, float comisionExtra, float consumoEstimado, int tiempo)
			throws Exception {
		super(codigo, nombre, sectorEncargado, minimo, comisionExtra,
				consumoEstimado);

		this.items = null;
		this.cantItem = null;
		this.tiempoElaboracion = tiempo;
	}

}
