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
		
		Carta carta = new Carta();
		Producto p = null;
		for (int idProducto= 0; idProducto<100; idProducto++){ 
			p = ProductoDAO.getInstance().recuperarProducto(idProducto);
			carta.agregarProducto(p);
		}//tenemos que ver como devolvemos algun contador de productos para limitar el for o devolver al cantidad de items de la DB
		
		//********Primera Sucursal********//
		
		Sucursal s1= new Sucursal("1000");
		Vector<Mesa> mesas = new Vector<Mesa>();
		for (int i=0; i< 5; i++){
			Mesa mesa = null;
			mesa.setId(i);
			mesa.setCantComen(4);
			mesa.setSector("Central");
			mesas.add(mesa);
		}
		for (int i=5; i < 10; i++){
			Mesa mesa = null;
			mesa.setId(i);
			mesa.setCantComen(6);
			mesa.setSector("Lateral Izquierdo");
			mesas.add(mesa);
		}
		
		Vector<Mozo> mozos = new Vector<Mozo>();
		Mozo mozo = null;
		mozo = new Mozo(2017001, "Esteban Quito", 5);
		mozos.add(mozo);
		mozo = new Mozo(2017002, "Amilcar Cajada", 5);
		mozos.add(mozo);
		mozo = new Mozo(2017003, "Ana Tomia", 10);
		mozos.add(mozo);
		mozo = new Mozo(2017004, "Benito Camelo", 5);
		mozos.add(mozo);
		mozo = new Mozo(2017005, "Ariel C. Pillado", 5);
		mozos.add(mozo);
		
		s1.setMesas(mesas);
		s1.setCarta(carta);
		s1.setMozos(mozos);
		sucursales.add(s1);
		
		//********Segunda Sucursal********//
		
		Sucursal s2= new Sucursal("1001");
		Vector<Mesa> mesas2 = new Vector<Mesa>();
		for (int i=0; i< 5; i++){
			Mesa mesa = null;
			mesa.setId(i);
			mesa.setCantComen(4);
			mesa.setSector("Sector Rio");
			mesas2.add(mesa);
		}
		for (int i=5; i < 10; i++){
			Mesa mesa = null;
			mesa.setId(i);
			mesa.setCantComen(6);
			mesa.setSector("Sector Calle");
			mesas.add(mesa);
		}
		
		Vector<Mozo> mozos2 = new Vector<Mozo>();
		Mozo mozo2 = null;
		mozo2 = new Mozo(2017001, "Aquiles Meo de Latorre", 5);
		mozos2.add(mozo2);
		mozo2 = new Mozo(2017002, "Ana Konda", 10);
		mozos2.add(mozo2);
		mozo2 = new Mozo(2017003, "Cindy Entes", 10);
		mozos2.add(mozo2);
		mozo2 = new Mozo(2017004, "Alma Maria Rico", 5);
		mozos2.add(mozo2);
		mozo2 = new Mozo(2017005, "Alex Plosivo", 5);
		mozos2.add(mozo2);
		
		s2.setMesas(mesas2);
		s2.setCarta(carta);
		s2.setMozos(mozos2);
		sucursales.add(s2);
		
		//********Tercera Sucursal********//
		
				Sucursal s3= new Sucursal("1001");
				Vector<Mesa> mesas3 = new Vector<Mesa>();
				for (int i=0; i< 5; i++){
					Mesa mesa = null;
					mesa.setId(i);
					mesa.setCantComen(4);
					mesa.setSector("Sector Rio");
					mesas.add(mesa);
				}
				for (int i=5; i < 10; i++){
					Mesa mesa = null;
					mesa.setId(i);
					mesa.setCantComen(6);
					mesa.setSector("Sector Calle");
					mesas.add(mesa);
				}
				
				Vector<Mozo> mozos3 = new Vector<Mozo>();
				Mozo mozo3 = null;
				mozo3 = new Mozo(2017001, "Susana Horia", 5);
				mozos3.add(mozo3);
				mozo3 = new Mozo(2017002, "Jhony Meacuerdo", 0);
				mozos3.add(mozo3);
				mozo3 = new Mozo(2017003, "Andres Tresado", 0);
				mozos3.add(mozo);
				mozo3 = new Mozo(2017004, "Coco Drilo", 5);
				mozos3.add(mozo3);
				mozo3 = new Mozo(2017005, "Dolores D. Parto", 15);
				mozos3.add(mozo3);
				
				s2.setMesas(mesas3);
				s2.setCarta(carta);
				s2.setMozos(mozos3);
				sucursales.add(s3);
				
		
	}
	
	public List<ProductoDTO> getComprasPendiente() throws ComprasPendientesException { 
		return null;
	}
	
	public ProductoDTO getProducto(int idProducto) { 
		Producto prod = ProductoDAO.getInstance().recuperarProducto(idProducto);
		return prod.toProdDTO();
	}
	
	public Vector<ProductoDTO> buscarProductos(){
		Vector<ProductoDTO> productos = new Vector<ProductoDTO>();
		return productos;
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
		return "Llego al controlador";
	}
	

	
}
