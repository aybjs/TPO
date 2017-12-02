package dto;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;





public abstract class ProductoDTO  implements Serializable {

	private static final long serialVersionUID = 1066814429833576979L;
		
	private int codigo;
	private float precio;
	private String nombre;
	private String sectorEncargado;
	private float minimo;
	private float comisionExtra;
	private List<LoteDTO> lotes;
	private float consumoEstimado;
	private float stock;
	
	public ProductoDTO(){
		
	}
	
	public ProductoDTO(int codigo, float stock, float precio, String nombre, String sectorEncargado, float minimo, float comisionExtra, List<LoteDTO> lotes, float consumoEstimado) throws Exception {
		this.codigo = codigo;
		this.precio = precio;
		this.nombre = nombre;
		this.minimo = minimo;
		this.comisionExtra = comisionExtra;
		this.lotes = lotes;
		this.consumoEstimado = consumoEstimado;
		this.sectorEncargado = sectorEncargado;
		this.stock = stock;
	}
	
	public float getStock() {
		return stock;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getSectorEncargado() {
		return sectorEncargado;
	}

	public float getMinimo() {
		return minimo;
	}

	
	public float getComisionExtra() {
		return comisionExtra;
	}

	public List<LoteDTO> getLotes() {
		return lotes;
	}

	public float getConsumoEstimado() {
		return consumoEstimado;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSectorEncargado(String sectorEncargado) {
		this.sectorEncargado = sectorEncargado;
	}

	public void setMinimo(float minimo) {
		this.minimo = minimo;
	}

	public void setComisionExtra(float comisionExtra) {
		this.comisionExtra = comisionExtra;
	}

	public void setLotes(List<LoteDTO> vector) {
		this.lotes = vector;
	}

	public void setConsumoEstimado(float consumoEstimado) {
		this.consumoEstimado = consumoEstimado;
	}

	public void setStock(float stock) {
		this.stock = stock;
	}

}

