package controllers;

import java.util.Date;
import java.util.Vector;

import negocio.*;

public class ControladorCentral {
	
	private Vector<Tarea> planProduccion;
	private Proveedor proveedor;
	private Deposito deposito;
	private Sucursal sucursal;
	private OrdenCompra ordenCompra;
	private String codigoResto; // hay que hacer algo con esto, ingresarlo en algún lugar a mano.
	
	public ControladorCentral (){
		planProduccion = new Vector<Tarea>();
		deposito = new Deposito("responsable");
		sucursal = new Sucursal(codigoResto);
		ordenCompra = new OrdenCompra();
		init();
	}
	
	private void init(){
		//que vamos a hacer aca?
	}
	
	public Vector<Producto> getComprasPendiente(){
		
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
	public Lista recibirListaReposicion(Lista lista){
		return Lista;
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
