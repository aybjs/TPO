package negocio;

import java.util.Date;
import java.util.Timer;

import enumerators.EstadosMesa;

public abstract class Mesa {
	
	private int id;
	private int cantComen;
	private int capacidad;
	private String sector;
	private Date fecha;
	private Date apertura;
	private Date cierre; //no se manejar tiempos, esto es lo mejor que encontre
	private EstadosMesa estado;
	private Mozo mozo;
	public Mesa(int id, int capacidad, String sector,
			String apertura, String cierre, Mozo mozo) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.cantComen = 0;
		this.sector = sector;
		this.fecha = null;
		this.apertura = null;
		this.cierre = null;
		this.estado = EstadosMesa.libre;
		this.mozo = mozo;
	}
	
	public abstract void AbrirMesa(int personas);
	
	public abstract void SiguienteEstado();
	
	public abstract void CerrarMesa();
	
	public abstract void HabilitarMesa();
	
	

}
