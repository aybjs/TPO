package controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

//import com.sun.scenario.effect.impl.prism.PrDrawable;






import dao.*;
import enumerators.EstadosMesa;
import exceptions.*;
import dto.*;
import entities.ProductoCompuestoEntity;
import entities.ProductoSimpleEntity;
import negocio.*;
//cambio de pruebas
@SuppressWarnings("unused")
public class ControladorCentral {
	
	private static ControladorCentral instancia;
	private List<Tarea> planProduccion;
	private List<Proveedor> proveedor;
	private List<Deposito> deposito;
	private List<Sucursal> sucursales;
	private List<OrdenCompra> ordenCompra;
	private List<Pedido> pedidos = new Vector<Pedido>();
	private String codigoResto; // hay que hacer algo con esto, ingresarlo en algun lugar a mano.
	
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
		
		//********Primera Sucursal********//
		
		Sucursal s1= new Sucursal("Suc 1");
		s1.setCarta(carta);
		sucursales.add(s1);
		
		//********Segunda Sucursal********//
		
		Sucursal s2= new Sucursal("Suc 2");
		s2.setCarta(carta);
		sucursales.add(s2);
		
		//********Tercera Sucursal********//
		
		Sucursal s3= new Sucursal("Suc 3");
		s2.setCarta(carta);
		sucursales.add(s3);
		
		//********Productos**************//
				/**
				
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
				//ps1.setProdCompuesto("milanesa de atun");
				ProductoSimpleDAO.getInstance().grabarProducto(ps1);
				
	**/
	}
	
	public Vector<CierreCajaDTO> cerrarCajas(){
		Vector<CierreCajaDTO> todo = new Vector<CierreCajaDTO>();
		for (Sucursal s : sucursales)
			todo.add(s.cierreCaja());
		return todo;
	}
	
	public Vector<ComisionesDTO> getComisiones() throws CierreException{
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
	
	/**
	 * public double GenerarPedido(PedidoDTO p, int suc){
		Mesa mesa = new Mesa(p.getMesa());
		Pedido ped = new Pedido(mesa);
		for(ProductoDTO prod : p.getItems()){
			ProductoCompuesto pc = new ProductoCompuesto(prod);
			ped.agregarItem(pc);
		}
		this.pedidos.add(ped);
		this.sucursales.get(suc).agregarPedido(p);
		return ped.getId();		
	}*
	**/
	
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

	public Pedido getPedido(double id) {
		Pedido aux = null;
		for(Pedido p: this.pedidos){
			if(p.getId()==id)
				aux = p;
		}
		return aux;
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
	
	public float facturar(double idPedido){
		float flo = 0;
		
		Pedido p = this.getPedido(idPedido);
		for(ProductoCompuesto prod : p.getItems()){
			flo = flo + prod.getPrecio();
		}
		
		Mesa mesaCierra = new Mesa();
		mesaCierra.setId((int) idPedido);
		mesaCierra.setCierre(LocalDateTime.now());
		return flo;
	}

	
	public void agregarPlato(ProductoDTO p) throws ProductoException{
		if (ProductoCompuestoDAO.getInstance().recuperarProductoNombre(p.getNombre()) == null){
			ProductoCompuesto prod = new ProductoCompuesto(p);
		}
		else throw new ProductoException("El producto ya existe");
		
	}
	
	public void agregarIngredientes(String nombre, String sector, float minimo, float comision, float consumo, String medida ){
			ProductoSimpleEntity pse = new ProductoSimpleEntity();
			pse.setNombre(nombre);
			pse.setSectorEncargado(sector);
			pse.setMinimo(minimo);
			pse.setComisionExtra(comision);
			pse.setConsumoEstimado(consumo);
			pse.setSectorEncargado(sector);
			ProductoSimpleDAO.getInstance().grabarProducto(pse);
		
	}
	
	public void abrirCajas(){
		for (Sucursal s : sucursales)
			s.abrirCaja();
	}
	
	
	
}
