package controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Vector;

//import com.sun.scenario.effect.impl.prism.PrDrawable;




import dao.*;
import enumerators.EstadosMesa;
import exceptions.*;
import dto.*;
import entities.ProductoCompuestoEntity;
import entities.ProductoSimpleEntity;
import negocio.*;

@SuppressWarnings("unused")
public class ControladorCentral {
	
	private static ControladorCentral instancia;
	private List<Tarea> planProduccion;
	private List<Proveedor> proveedor;
	private List<Deposito> deposito;
	private List<Sucursal> sucursales;
	private List<OrdenCompra> ordenCompra;
	private List<Pedido> pedidos = new Vector<Pedido>();
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
		Vector<ProductoCompuesto> pc = new Vector<ProductoCompuesto>();
		//Vector<ProductoCompuesto> carta = new Vector<ProductoCompuesto>();
		pc=ProductoCompuestoDAO.getInstance().recuperarProductos();
		carta.agregarProducto(pc); 
		
		/*for (int idProducto= 0; idProducto<100; idProducto++){ 
			p = ProductoDAO.getInstance().recuperarProducto(idProducto);
			carta.agregarProducto(p);
		}//tenemos que ver como devolvemos algun contador de productos para limitar el for o devolver al cantidad de items de la DB*/
		
		Random r = new Random();
		
		//********Primera Sucursal********//
		
		Sucursal s1= new Sucursal("A");
		
		Vector<Mozo> mozos = new Vector<Mozo>();
		Mozo mozo = null;
		mozo = new Mozo(2017001, "Esteban Quito", 5);
		mozos.add(mozo);
		MozoDAO.getInstance().grabarMozo(mozo);
		mozo = new Mozo(2017002, "Amilcar Cajada", 5);
		mozos.add(mozo);
		MozoDAO.getInstance().grabarMozo(mozo);
		mozo = new Mozo(2017003, "Ana Tomia", 10);
		mozos.add(mozo);
		MozoDAO.getInstance().grabarMozo(mozo);
		mozo = new Mozo(2017004, "Benito Camelo", 5);
		mozos.add(mozo);
		MozoDAO.getInstance().grabarMozo(mozo);
		mozo = new Mozo(2017005, "Ariel C. Pillado", 5);
		mozos.add(mozo);
		MozoDAO.getInstance().grabarMozo(mozo);
		
		
		Vector<Mesa> mesas = new Vector<Mesa>();
		for (int i=0; i< 5; i++){
			Mesa mesa = new Mesa(i, "central");
			mesa.setId(i);
			mesa.setCantComen(4);
			mesa.setSector("Central");
			mesa.setMozo(mozos.elementAt(r.nextInt(4-1) + 1));
			mesas.add(mesa);
		}
		for (int i=5; i < 10; i++){
			Mesa mesa = new Mesa(i, "Lateral Izquierdo");
			mesa.setId(i);
			mesa.setCantComen(6);
			mesa.setSector("Lateral Izquierdo");
			mesa.setMozo(mozos.elementAt(r.nextInt(4-1) + 1));
			mesas.add(mesa);
		}
		
		s1.setMesas(mesas);
		s1.setCarta(carta);
		s1.setMozos(mozos);
		sucursales.add(s1);
		
		//********Segunda Sucursal********//
		
		Sucursal s2= new Sucursal("B");
		Vector<Mesa> mesas2 = new Vector<Mesa>();
		
		Vector<Mozo> mozos2 = new Vector<Mozo>();
		Mozo mozo2 = null;
		mozo2 = new Mozo(2017001, "Aquiles Meo de Latorre", 5);
		mozos2.add(mozo2);
		MozoDAO.getInstance().grabarMozo(mozo2);
		mozo2 = new Mozo(2017002, "Ana Konda", 10);
		mozos2.add(mozo2);
		MozoDAO.getInstance().grabarMozo(mozo2);
		mozo2 = new Mozo(2017003, "Cindy Entes", 10);
		mozos2.add(mozo2);
		MozoDAO.getInstance().grabarMozo(mozo2);
		mozo2 = new Mozo(2017004, "Alma Maria Rico", 5);
		mozos2.add(mozo2);
		MozoDAO.getInstance().grabarMozo(mozo2);
		mozo2 = new Mozo(2017005, "Alex Plosivo", 5);
		mozos2.add(mozo2);
		MozoDAO.getInstance().grabarMozo(mozo2);
		
		for (int i=0; i< 5; i++){
			Mesa mesa = new Mesa(i, "Sector Rio");
			mesa.setId(i);
			mesa.setCantComen(4);
			mesa.setSector("Sector Rio");
			mesa.setMozo(mozos2.elementAt(r.nextInt(4-1) + 1));			
			mesas2.add(mesa);
		}
		for (int i=5; i < 10; i++){
			Mesa mesa = new Mesa(i, "Sector Calle");
			mesa.setId(i);
			mesa.setCantComen(6);
			mesa.setSector("Sector Calle");
			mesa.setMozo(mozos2.elementAt(r.nextInt(4-1) + 1));						
			mesas2.add(mesa);
		}
		
		s2.setMesas(mesas2);
		s2.setCarta(carta);
		s2.setMozos(mozos2);
		sucursales.add(s2);
		
		//********Tercera Sucursal********//
		
		Sucursal s3= new Sucursal("C");
		Vector<Mesa> mesas3 = new Vector<Mesa>();
		
		Vector<Mozo> mozos3 = new Vector<Mozo>();
		Mozo mozo3 = null;
		mozo3 = new Mozo(2017001, "Susana Horia", 5);
		mozos3.add(mozo3);
		MozoDAO.getInstance().grabarMozo(mozo3);
		mozo3 = new Mozo(2017002, "Jhony Meacuerdo", 0);
		mozos3.add(mozo3);
		MozoDAO.getInstance().grabarMozo(mozo3);
		mozo3 = new Mozo(2017003, "Andres Tresado", 0);
		mozos3.add(mozo);
		MozoDAO.getInstance().grabarMozo(mozo3);
		mozo3 = new Mozo(2017004, "Coco Drilo", 5);
		mozos3.add(mozo3);
		MozoDAO.getInstance().grabarMozo(mozo3);
		mozo3 = new Mozo(2017005, "Dolores D. Parto", 15);
		mozos3.add(mozo3);
		MozoDAO.getInstance().grabarMozo(mozo3);
		
		
		for (int i=0; i< 5; i++){
			Mesa mesa = new Mesa(i, "Sector Rio");
			mesa.setId(i);
			mesa.setCantComen(4);
			mesa.setSector("Sector Rio");
			mesa.setMozo(mozos3.elementAt(r.nextInt(4-1) + 1));				
			mesas3.add(mesa);
		}
		for (int i=5; i < 10; i++){
			Mesa mesa = new Mesa(i, "Sector calle");
			mesa.setId(i);
			mesa.setCantComen(6);
			mesa.setSector("Sector Calle");
			mesa.setMozo(mozos3.elementAt(r.nextInt(4-1) + 1));			
			mesas3.add(mesa);
		}
		
		s3.setMesas(mesas3);
		s3.setCarta(carta);
		s3.setMozos(mozos3);
		sucursales.add(s3);
		
		
		ProductoCompuesto prodComp = new ProductoCompuesto();
		prodComp.setCodigo(1001);
		prodComp.setNombre("Milanesa Napolitana con Papas Fritas");
		prodComp.setPrecio(28);
		ProductoCompuestoDAO.getInstance().grabarProducto(prodComp);
		ProductoCompuesto prodComp2 = new ProductoCompuesto();
		prodComp2.setCodigo(1002);
		prodComp2.setNombre("Fideos al Pesto");
		prodComp2.setPrecio(57);
		ProductoCompuestoDAO.getInstance().grabarProducto(prodComp2);
		ProductoCompuesto prodComp3 = new ProductoCompuesto();
		prodComp3.setCodigo(1001);
		prodComp3.setPrecio(34);
		prodComp3.setNombre("Ravioles con Salsa Bolognesa");
		ProductoCompuestoDAO.getInstance().grabarProducto(prodComp3);
		
		ProductoSimple ps1 = new ProductoSimple();
		ps1.setNombre("salsa");
		ProductoSimpleDAO.getInstance().grabarProducto(ps1);
		ps1.setNombre("queso");
		ProductoSimpleDAO.getInstance().grabarProducto(ps1);
		ps1.setNombre("mayonesa");
		ProductoSimpleDAO.getInstance().grabarProducto(ps1);
		ps1.setNombre("huevo");
		ProductoSimpleDAO.getInstance().grabarProducto(ps1);
		ps1.setNombre("jamon");
		ProductoSimpleDAO.getInstance().grabarProducto(ps1);
		ps1.setNombre("carne");
		ProductoSimpleDAO.getInstance().grabarProducto(ps1);
		ps1.setNombre("leche");
		ProductoSimpleDAO.getInstance().grabarProducto(ps1);
		ps1.setNombre("atun");
		ps1.setProdCompuesto("milanesa de atun");
		ProductoSimpleDAO.getInstance().grabarProducto(ps1);
	
	}
	
	public Vector<CierreCajaDTO> cerrarCajas() throws CierreException{
		Vector<CierreCajaDTO> todo = new Vector<CierreCajaDTO>();
		for (Sucursal s : sucursales)
			todo.add(s.cierreCaja());
		return todo;
	}
	
	public Vector<ComisionesDTO> getComisiones(){
		Vector<ComisionesDTO> rta = new Vector<ComisionesDTO>();
		for (Sucursal s : sucursales)
			for (ComisionesDTO c : s.getComisiones())
				rta.add(c);
		return rta;		
	}
	
	public List<ProductoDTO> getComprasPendiente() throws ComprasPendientesException { 
		return null;
	}
	
	public ProductoDTO getProducto(int idProducto) { 
		Producto prod = ProductoDAO.getInstance().recuperarProducto(idProducto);
		return prod.toProdDTO();
	}
	
	public Vector<ProductoDTO> getTodosLosProductos() { 
		Vector<ProductoDTO> listProductos = new Vector<ProductoDTO>();
		for(ProductoCompuesto prod : ProductoCompuestoDAO.getInstance().recuperarProductos() )
			listProductos.add(prod.toProdDTO());
		return listProductos;
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
	
	/**public double GenerarPedido(PedidoDTO p, int suc){
		Mesa mesa = new Mesa(p.getMesa());
		Pedido ped = new Pedido(mesa);
		for(ProductoDTO prod : p.getItems()){
			ProductoCompuesto pc = new ProductoCompuesto(prod);
			ped.agregarItem(pc);
		}
		this.pedidos.add(ped);
		this.sucursales.get(suc).agregarPedido(p);
		return ped.getId();		
	}**/
	
	public double GenerarPedido (PedidoDTO p, int suc){
		return sucursales.get(suc).agregarPedido(p);
	}

	public float cerrarMesa(Pedido pedCierra){
		return 0;

		
	}
	public List<Tarea> getPlanProduccion() {
		return planProduccion;
	}

	public void setPlanProduccion(List<Tarea> planProduccion) {
		this.planProduccion = planProduccion;
	}

	public List<Proveedor> getProveedor() {
		return proveedor;
	}

	public void setProveedor(List<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}

	public List<Deposito> getDeposito() {
		return deposito;
	}

	public void setDeposito(List<Deposito> deposito) {
		this.deposito = deposito;
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public List<OrdenCompra> getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(List<OrdenCompra> ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getCodigoResto() {
		return codigoResto;
	}

	public void setCodigoResto(String codigoResto) {
		this.codigoResto = codigoResto;
	}
	
	public float facturar(double idPedido, String pagoEfectivoOTarjeta){
		float resp = 0;
		for (Sucursal s : sucursales) {
			resp = resp + s.facturar(idPedido, pagoEfectivoOTarjeta);
		}
		return resp;
	}

	
	public Vector<String> agregarPlato(ProductoDTO p){
		ProductoCompuesto prod = new ProductoCompuesto(p);
		//Vector<ProductoSimple> productosSimples = new Vector<ProductoSimple>();
		Vector<String> vectorNombre = new Vector<String>();
		ProductoCompuestoDAO.getInstance().grabarProducto(prod);
		
		for (ProductoSimple ps : ProductoSimpleDAO.getInstance().recuperarProductos()){
			vectorNombre.add(ps.getNombre());
		}
		/*
		vectorNombre.addElement("salsa");
		vectorNombre.addElement("queso");
		*/
		return vectorNombre;
		
	}
	
	public void agregarIngredientes(String nombre, String ingrediente, Integer cantidad ){
			
			ProductoSimpleEntity pse = new ProductoSimpleEntity();
			pse.setProdCompuesto(nombre);
			pse.setMedida(cantidad.toString());
			pse.setNombre(ingrediente);
			ProductoSimpleDAO.getInstance().grabarProducto(pse);
		
		
	}
	
	public void abrirCajas(){
		for (Sucursal s : sucursales)
			s.abrirCaja();
	}
	
	public MesaDTO getMesa(int suc, int nroMesa) throws MesaException{
		return sucursales.get(suc).getMesa(nroMesa);
	}
	
	
	
}
