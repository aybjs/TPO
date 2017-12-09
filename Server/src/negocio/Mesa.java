package negocio;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;

import dto.MesaDTO;
import enumerators.EstadosMesa;

public class Mesa {

	protected int id;
	protected int cantComen;
	protected String sector;
	protected Date fecha;
	protected Date apertura;
	protected LocalDateTime cierre; 
	protected String estado;
	protected Mozo mozo;

	public Mesa(int id, String sector) {
		this.id = id;
		this.cantComen = 0;
		this.sector = sector;
		this.fecha = null;
		this.apertura = null;
		this.cierre = null;
		this.mozo = null;
		this.estado = "libre";
	}
	
	public Mesa(int id, String sector, Mozo mozo) {
		this.id = id;
		this.cantComen = 0;
		this.sector = sector;
		this.fecha = null;
		this.apertura = null;
		this.cierre = null;
		this.mozo = mozo;
		this.estado = "libre";
	}
	
	public Mesa(MesaDTO m){
		this.id = m.getId();
		this.cantComen = m.getCantComen();
		this.sector = m.getSector();
		this.fecha = m.getFecha();
		this.apertura = m.getApertura();
		this.cierre = m.getCierre();
		Mozo mozo = new Mozo(m.getMozo());
		this.mozo = mozo;
		this.estado = m.getEstado();
				
	}

	public Mesa() {
		// TODO Auto-generated constructor stub
	}

	public void AbrirMesa(int personas, Mozo mozo) {
	}

	public void SiguienteEstado() {
	}

	public void CerrarMesa() {
		
		
	}

	public void HabilitarMesa() {
	}

	public String getSector() {
		return sector;
	}

	public void setEstado(EstadosMesa estado) {
	}

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

	public LocalDateTime getCierre() {
		return cierre;
	}

	public void setCierre(LocalDateTime cierre) {
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
	
	@SuppressWarnings("null")
	public MesaDTO toDTO(){
		MesaDTO mesa = new MesaDTO();
		mesa.setApertura(apertura);
		mesa.setCantComen(cantComen);
		mesa.setCierre(cierre);
		mesa.setEstado(estado);
		mesa.setFecha(fecha);
		mesa.setId(id);
		mesa.setMozo(mozo.toDTO());
		mesa.setSector(sector);
		return mesa;
		
	}

	public void setEstado(String estado) {
		this.estado = estado;
		// TODO Auto-generated method stub
		
	}
	
	

}
