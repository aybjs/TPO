package dto;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class ProductoDTO  implements Serializable {

	private static final long serialVersionUID = 1066814429833576979L;
		
	private int codigo;
	private float precio;
	private String nombre;
	private float stock;
	private float comisionExtra;
	private Vector<String> ingredientes;
	private Vector<Integer> cantidades;
	/*
	private String sectorEncargado;
	private float minimo;
	private Vector<LoteDTO> lotes;
	private float consumoEstimado;
	
	*/
	
	public Vector<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Vector<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Vector<Integer> getCantidades() {
		return cantidades;
	}

	public void setCantidades(Vector<Integer> cantidades) {
		this.cantidades = cantidades;
	}

	public ProductoDTO(){
		
	}
	
	public ProductoDTO(int codigo, float stock, float precio, String nombre, String sectorEncargado, float minimo, float comisionExtra, Vector<LoteDTO> lotes, float consumoEstimado) throws Exception {
		this.codigo = codigo;
		this.precio = precio;
		this.nombre = nombre;
		this.stock = stock;
		this.comisionExtra = comisionExtra;
		/*
		this.minimo = minimo;
		this.lotes = lotes;
		this.consumoEstimado = consumoEstimado;
		this.sectorEncargado = sectorEncargado;
		*/
		
		
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
	
	public float getComisionExtra() {
		return comisionExtra;
	}
	/*
	public String getSectorEncargado() {
		return sectorEncargado;
	}

	public float getMinimo() {
		return minimo;
	}

	
	

	public List<LoteDTO> getLotes() {
		return lotes;
	}

	public float getConsumoEstimado() {
		return consumoEstimado;
	}
	*/
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setComisionExtra(float comisionExtra) {
		this.comisionExtra = comisionExtra;
	}
	/*
	public void setSectorEncargado(String sectorEncargado) {
		this.sectorEncargado = sectorEncargado;
	}

	public void setMinimo(float minimo) {
		this.minimo = minimo;
	}

	

	public void setLotes(Vector<LoteDTO> vector) {
		this.lotes = vector;
	}

	public void setConsumoEstimado(float consumoEstimado) {
		this.consumoEstimado = consumoEstimado;
	}
	*/
	public void setStock(float stock) {
		this.stock = stock;
	}

}

