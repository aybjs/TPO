package negocio;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import dto.LoteDTO;
import dto.*;
import enumerators.SectorEncargado;

public abstract class Producto {

	protected int codigo;
	protected String nombre;
	protected SectorEncargado sectorEncargado;
	protected float minimo;
	protected float comisionExtra;
	protected Vector<Lote> lotes;
	protected float consumoEstimado;
	private Vector<Producto> items;
	private Vector<Integer> cantItem;

	public Producto(int codigo, String nombre, int sectorEncargado,
			float minimo, float comisionExtra, float consumoEstimado)
			throws Exception {
		this.codigo = codigo;
		this.nombre = nombre;
		this.minimo = minimo;
		this.comisionExtra = comisionExtra;
		this.lotes = null;
		this.consumoEstimado = consumoEstimado;
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
		}
	}
	
	public Producto(){};


	public void agregarLote(int nro, Date fechaCompra, Date fechaVto,
			float cantidad) {
		this.lotes.add(new Lote(nro, fechaCompra, fechaVto, cantidad));
	}

	public abstract float getStockActual();

	public abstract float getPrecio();

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
		return sectorEncargado.name();
	}

	public void setSectorEncargado(SectorEncargado sectorEncargado) {
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

	public void setLotes(Vector<Lote> lotes) {
		this.lotes = lotes;
	}

	public float getConsumoEstimado() {
		return consumoEstimado;
	}

	public void setConsumoEstimado(float consumoEstimado) {
		this.consumoEstimado = consumoEstimado;
	}
	public ProductoDTO toProdDTO(Producto prod){
		ProductoDTO p = new ProductoDTO(prod.getCodigo(), prod.getStockActual(), prod.getPrecio(), prod.getNombre(),prod.getSectorEncargado(), prod.getMinimo(), prod.getComisionExtra(), prod.getLotes(), prod.getConsumoEstimado());
		
		//(p.setCodigo(prod.getCodigo()), p.setStock(prod.getStockActual()), p.setPrecio(prod.getPrecio()), p.setNombre(prod.getNombre()),p.setSectorEncargado(prod.getSectorEncargado()), p.setMinimo(prod.getMinimo()), p.setComisionExtra(prod.getComisionExtra()), p.setLotes(prod.getLotes()), p.setConsumoEstimado(prod.getConsumoEstimado()));
		//(int codigo, float stock, float precio, String nombre, String sectorEncargado, float minimo, float comisionExtra, List<LoteDTO> lotes, float consumoEstimado)
		
		return p;
	}
	public void agregarItem(Producto p) {
		items.add(p);
	}

	public String getItems() {
		String rta = null;
		for (Producto item : items)
			rta = rta + item.getNombre() + ", ";
		return rta;
	}

	public Vector<Integer> getCantItem() {
		return cantItem;
	}

	public void setCantItem(Vector<Integer> cantItem) {
		this.cantItem = cantItem;
	}

	public void setItems(Vector<Producto> items) {
		this.items = items;
	}
	

}
