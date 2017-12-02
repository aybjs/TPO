package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.ReposicionDTO;
import negocio.*;

public class ControladorCentral {
	
	private List<Tarea> planProduccion;
	private List<Proveedor> proveedor;
	private List<Deposito> deposito;
	private List<Sucursal> sucursal;
	private List<OrdenCompra> ordenCompra;
	private String codigoResto; // hay que hacer algo con esto, ingresarlo en algún lugar a mano.
	
	public ControladorCentral (){
		planProduccion = new ArrayList<Tarea>();
		proveedor = new ArrayList<Proveedor>();
		deposito = new ArrayList<Deposito>();
		sucursal = new ArrayList<Sucursal>();
		ordenCompra = new ArrayList<OrdenCompra>();
		
		init();
	}
	
	private void init(){
		//que vamos a hacer aca?
		//Cargamos los datos de la base de datos
		
		//Y le agregamos...
		deposito.add(new Deposito("responsable"));
		sucursal.add(new Sucursal("codigoResto"));
	}
	
	public List<Producto> getComprasPendiente(){
		return null;
		
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
	
}
