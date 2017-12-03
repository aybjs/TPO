package negocio;

import java.util.Date;
import java.util.Timer;

import dto.MesaDTO;
import enumerators.EstadosMesa;

public abstract class Mesa {

	protected int id;
	protected int cantComen;
	protected String sector;
	protected Date fecha;
	protected Date apertura;
	protected Date cierre; // no se manejar tiempos, esto es lo mejor que
							// encontre
	protected EstadosMesa estado;
	protected Mozo mozo;

	public Mesa(int id, String sector) {
		super();
		this.id = id;
		this.cantComen = 0;
		this.sector = sector;
		this.fecha = null;
		this.apertura = null;
		this.cierre = null;
		this.mozo = null;
	}

	public abstract void AbrirMesa(int personas, Mozo mozo);

	public abstract void SiguienteEstado();

	public abstract void CerrarMesa();

	public abstract void HabilitarMesa();

	public String getSector() {
		return sector;
	}

	public abstract void setEstado(EstadosMesa estado);

	public String getEstado() {
		return estado.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantComen() {
		return cantComen;
	}

	public void setCantComen(int cantComen) {
		this.cantComen = cantComen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getApertura() {
		return apertura;
	}

	public void setApertura(Date apertura) {
		this.apertura = apertura;
	}

	public Date getCierre() {
		return cierre;
	}

	public void setCierre(Date cierre) {
		this.cierre = cierre;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	public MesaDTO toDTO(){
		MesaDTO mesa = new MesaDTO();
		mesa.
		return null;
		
	}

}
