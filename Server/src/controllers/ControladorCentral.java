package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ProductoDAO;
import exceptions.*;
import dto.*;
import negocio.*;

public class ControladorCentral {
	
	private static ControladorCentral instancia;
	@SuppressWarnings("unused")
	private List<Tarea> planProduccion;
	@SuppressWarnings("unused")
	private List<Proveedor> proveedor;
	private List<Deposito> deposito;
	private List<Sucursal> sucursal;
	@SuppressWarnings("unused")
	private List<OrdenCompra> ordenCompra;
	@SuppressWarnings("unused")
	private String codigoResto; // hay que hacer algo con esto, ingresarlo en algún lugar a mano.
	
	private ControladorCentral (){
		planProduccion = new ArrayList<Tarea>();
		proveedor = new ArrayList<Proveedor>();
		deposito = new ArrayList<Deposito>();
		sucursal = new ArrayList<Sucursal>();
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
		deposito.add(new Deposito("responsable"));
		sucursal.add(new Sucursal("codigoResto"));
	}
	
	public List<Producto> getComprasPendiente(int idProducto){
		List<Producto> listProductos = new ArrayList<Producto>();
		Producto prod = new Producto();
		ProductoDAO.getInstance().recuperarProducto(idProducto);
	public List<ProductoDTO> getComprasPendiente() throws ComprasPendientesException{
		
		return listProductos;
	
		
	}
	
	public void ingresarProducto(String codigo, int cantidad, int lote, Date vencimiento){
		
	}
	
	public void ingresarTarea(String codigo, String nombre, String categoria, int minutos){
		
	}
	
	public void asignarTarea(String codigo, int cantidad, String resto){
		
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
	}// de donde viene esta lista???
	
	public void crearOC(){
		
	}
	
	public void solicitarInsumosNormal(String codResto){
		
	}
	
	public void solicitarInsumosExtra(String codResto, String producto, int cantidad, String solicitante){
		
	}
	
	public void generarMovimientoStock(){
		
	}
	
	public String test(String aux) {
		return "chau";
	}
}
