package negocio;

import enumerators.FormaPago;

public class Factura {

	private static double nroFactura = 0;
	private String cliente;
	private Pedido pedido;
	private String formaPago;

	public Factura() {
		nroFactura++;
		pedido = null;
	}

	public Factura(String cliente, Pedido pedido, String formaPago) {
		nroFactura++;
		this.pedido = pedido;
		this.cliente = cliente;
		this.formaPago = formaPago;
	}

	public float calcularTotal() {
		return pedido.subTotal() * (float) 1.21; // le sumo el iva (como para
													// hacer algo)

	}

	public static double getNroFactura() {
		return nroFactura;
	}

	public static void setNroFactura(double nroFactura) {
		Factura.nroFactura = nroFactura;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
}
