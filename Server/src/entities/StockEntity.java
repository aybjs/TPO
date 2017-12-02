package entities;

import javax.persistence.*;

@Entity
@Table (name="stock")
public class StockEntity {

	private ProductoEntity producto;
	private float cantidad;

	public StockEntity(){}
	
	public StockEntity (ProductoEntity producto, float cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public ProductoEntity getProducto() {
		return producto;
	}
	
	public void setProducto(ProductoEntity producto){
		this.producto = producto;
	}

}
