package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import enumerators.FormaPago;

@Entity
@Table(name="Facturas")

public class FacturaEntity {

	@Id
	@Column(name="nroFactura")
	private static double nroFactura = 0;
	@Column(name="cliente")
	private String cliente;
	/*@Transient
	private PedidoEntity pedido;*/
	@Column(name="formaPago")
	private String formaPago;

	public FacturaEntity() {
	}

	public FacturaEntity(String cliente,  String formaPago) {
		nroFactura++;
		//this.pedido = pedido;
		this.cliente = cliente;
		this.formaPago = formaPago;
	}

	public static double getNroFactura() {
		return nroFactura;
	}

	public static void setNroFactura(double nroFactura) {
		FacturaEntity.nroFactura = nroFactura;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/*public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}*/

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
}
