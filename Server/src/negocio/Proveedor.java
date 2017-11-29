package negocio;

public class Proveedor {

	private int codProveedor;
	private String razonSocial;
	private String CUIT;

	public Proveedor(int codProveedor, String razonSocial, String cUIT) {
		this.codProveedor = codProveedor;
		this.razonSocial = razonSocial;
		CUIT = cUIT;
	}

	public int getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(int codProveedor) {
		this.codProveedor = codProveedor;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCUIT() {
		return CUIT;
	}

	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}

}
