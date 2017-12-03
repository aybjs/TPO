package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import dao.*;
import enumerators.EstadosMesa;
import exceptions.*;
import dto.*;
import negocio.*;

@SuppressWarnings("unused")
public class ControladorCentral {
	
	private static ControladorCentral instancia;
	private List<Tarea> planProduccion;
	private List<Proveedor> proveedor;
	private List<Deposito> deposito;
	private List<Sucursal> sucursales;
	private List<OrdenCompra> ordenCompra;
	private String codigoResto; // hay que hacer algo con esto, ingresarlo en algún lugar a mano.
	
	private ControladorCentral (){
		planProduccion = new ArrayList<Tarea>();
		proveedor = new ArrayList<Proveedor>();
		deposito = new ArrayList<Deposito>();
		sucursales = new ArrayList<Sucursal>();
		ordenCompra = new ArrayList<OrdenCompra>();
		
		init();
	}
	
	public static ControladorCentral getInstancia(){
		if(instancia == null)
			instancia = new ControladorCentral();
		return instancia;
	}
	
	private void init(){
		//que vamos a hacer aca?
		//Cargamos los datos de la base de datos
		
		//Y le agregamos...
		//deposito.add(new Deposito("responsable"));
		//sucursal.add(new Sucursal("codigoResto"));
		Sucursal s1= new Sucursal("1000");
		Vector<Mesa> mesas = new Vector<Mesa>();
		for (int i=0; i< 5; i++){
			Mesa mesa = null;
			mesa.setId(1);
			mesa.setCantComen(4);
			mesa.setSector("Central");
			mesas.add(mesa);
		}
		for (int i=0; i< 5; i++){
			Mesa mesa = null;
			mesa.setId(1);
			mesa.setCantComen(6);
			mesa.setSector("Lateral Izquierdo");
			mesas.add(mesa);
		}
		s1.setMesas(mesas);
		Carta carta = new Carta();
		carta.
		s1.setCarta();
		sucursales.add(s1);
	}
	
	public List<ProductoDTO> getComprasPendiente() throws ComprasPendientesException { 
		return null;
	}
	
	public ProductoDTO getProductos(int idProducto) { 
		List<ProductoDTO> listProductos = new ArrayList<ProductoDTO>();
		Producto prod = ProductoDAO.getInstance().recuperarProducto(idProducto);
		return prod.toProdDTO();
	}
	
	public void ingresarProducto(String codigo, int cantidad, int lote, Date vencimiento){
		
	}
	
	public void ingresarTarea(Integer codigoProducto, String nombre, String categoria, int cantidad){
		Producto producto = ProductoDAO.getInstance().recuperarProducto(codigoProducto);
		Tarea tarea = new Tarea(nombre, categoria, producto, cantidad);
		planProduccion.add(tarea);	
	}
	
	public void asignarTareas(){
		for (Tarea t : planProduccion){
			if(t.getEstado().compareTo("Asignado") != 0 || t.getEstado().compareTo("Finalizado") != 0){
				AsignarAlMasLibre(t);
				t.setAsignado();
			}			
		}
	}
	
	public Vector<TareaDTO> getTareas(int codigo){
		Sucursal aux = sucursales.get(codigo);
		return aux.getTareas();
	}
	private void AsignarAlMasLibre(Tarea t){
		Sucursal s = sucursales.get(0);
		for (Sucursal aux : sucursales)
			if (aux.getTiempoTareas(t.getCategoria()) < s.getTiempoTareas(t.getCategoria()))
				s = aux;		
	}
	
	public void noFacturable(String resto, String nroEmpleado, int cantidad){
		
	}
	
	public void tomarOrden(String resto, String nroEmpleado, int itemCarta, int cantidad, boolean facturable){
		
	}
	
	public void solicitarMovimiento(String resto, String producto, int cantidad, String destino){
		
	}
	
	public void solicitarMovimientoCentral(String resto, String producto, int cantidad){
		
	}
	
	public List<ReposicionDTO> recibirListaReposicion(List<ReposicionDTO> lista){
		return lista;
	}
	
	public void crearOC(){
		
	}
	
	public void solicitarInsumosNormal(String codResto){
		
	}
	
	public void solicitarInsumosExtra(String codResto, String producto, int cantidad, String solicitante){
		
	}
	
	public void generarMovimientoStock(){
		
	}
	
	public String test(String aux) {
		return "Lleg� al controlador";
	}
}
