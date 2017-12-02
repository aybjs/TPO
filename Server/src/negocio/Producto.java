package negocio;

import java.util.Date;
import java.util.Vector;

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
	public ProductoDTO toProdDTO(){
		ProductoDTO p = new ProductoDTO();
		p.setCodigo(this.getCodigo());
		p.setComisionExtra(this.getComisionExtra());
		p.setConsumoEstimado(this.getConsumoEstimado());
		p.setLotes(this.toLoteDTO());
		p.setMinimo(this.getMinimo());
		p.setNombre(this.getNombre());
		p.setPrecio(this.getPrecio());
		p.setSectorEncargado(this.getSectorEncargado());
		p.setStock(this.getStockActual());
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
