package entities;

import java.util.Date;
import java.util.Timer;

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

}
