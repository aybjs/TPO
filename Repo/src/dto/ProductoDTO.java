package dto;

import java.util.List;

public abstract class ProductoDTO {
	
	private int codigo;
	private float precio;
	private String nombre;
	private String sectorEncargado;
	private float minimo;
	private float comisionExtra;
	private List<LoteDTO> lotes;
	private float consumoEstimado;
	private float stock;
	
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
}

