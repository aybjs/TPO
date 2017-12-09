package negocio;

import java.util.Date;
import java.util.Vector;

import dto.*;
import enumerators.SectorEncargado;

public abstract class Producto {

	protected int codigo;
	protected String nombre;
	protected String sectorEncargado;
	protected float minimo;
	protected float comisionExtra;
	protected Vector<Lote> lotes;
	protected float consumoEstimado;
	protected float precio;
	protected String prodCompuesto;

	public Producto(int codigo, String nombre, String sectorEncargado,
			float minimo, float comisionExtra, float consumoEstimado,float precio)
			throws Exception {
		this.codigo = codigo;
		this.nombre = nombre;
		this.minimo = minimo;
		this.comisionExtra = comisionExtra;
		this.lotes = null;
		this.consumoEstimado = consumoEstimado;
		this.precio = precio;
		/*
		switch (sectorEncargado) {
		case 1:
			this.sectorEncargado = SectorEncargado.Barra;
		case 2:
			this.sectorEncargado = SectorEncargado.Cafeteria;
		case 3:
			this.sectorEncargado = SectorEncargado.Cocina;
		default:
			throw new Exception("Sector incorrecto"); // probablemente tengamos
														// que hacer una
														// exception espec�fica
														 
		}*/
	}
	
	public Producto(){};


	public void agregarLote(int nro, Date fechaCompra, Date fechaVto,
			float cantidad) {
		this.lotes.add(new Lote(nro, fechaCompra, fechaVto, cantidad));
	}

	public abstract float getStockActual();


	public abstract int getTiempoElaboracion();

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSectorEncargado() {
		return sectorEncargado;
	}

	public void setSectorEncargado(String sectorEncargado) {
		this.sectorEncargado = sectorEncargado;
	}

	public float getMinimo() {
		return minimo;
	}

	public void setMinimo(float minimo) {
		this.minimo = minimo;
	}

	public float getComisionExtra() {
		return comisionExtra;
	}

	public void setComisionExtra(float comisionExtra) {
		this.comisionExtra = comisionExtra;
	}

	public Vector<Lote> getLotes() {
		return lotes;
	}
	
	public Vector<LoteDTO> toLoteDTO(){
		Vector<LoteDTO> losLotes = new Vector<LoteDTO>();
		for (int i = 0; i < lotes.size(); i++) {
			losLotes.add(lotes.elementAt(i).toLoteDTO());
		}
		return losLotes;
	}

	public void setLotes(Vector<Lote> lotes) {
		this.lotes = lotes;
	}

	public float getConsumoEstimado() {
		return consumoEstimado;
	}

	public void setConsumoEstimado(float consumoEstimado) {
		this.consumoEstimado = consumoEstimado;
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ProductoDTO toProdDTO(){
		ProductoDTO p = new ProductoDTO();
		p.setCodigo(this.getCodigo());
		p.setComisionExtra(this.getComisionExtra());
		//p.setConsumoEstimado(this.getConsumoEstimado());
		//p.setLotes(this.toLoteDTO());
		//p.setMinimo(this.getMinimo());
		p.setNombre(this.getNombre());
		//p.setSectorEncargado(this.getSectorEncargado());
		p.setStock(this.getStockActual());
		p.setPrecio(this.getPrecio());
		return p;		
	}
	
	public String getProdCompuesto() {
		return prodCompuesto;
	}

	public void setProdCompuesto(String prodCompuesto) {
		this.prodCompuesto = prodCompuesto;
	}
	

	

}
