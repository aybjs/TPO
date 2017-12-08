package dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import enumerators.EstadosMesa;

public class MesaDTO  implements Serializable {

	private static final long serialVersionUID = 1066814429833576978L;
	
		protected int id;
		protected int cantComen;
		protected String sector;
		protected Date fecha;
		protected Date apertura;
		protected LocalDateTime cierre; // no se manejar tiempos, esto es lo mejor que
								// encontre
		//protected EstadosMesa estado;
		protected String estado; 
		protected MozoDTO mozo;

		public MesaDTO(int id, String sector) {
			super();
			Calendar today = Calendar.getInstance();
			today.set(Calendar.HOUR_OF_DAY, 0);
			this.id = id;
			this.cantComen = 0;
			this.sector = sector;
			this.fecha = today.getTime();
			this.apertura = today.getTime();
			this.cierre = null;
			//this.mozo = null;
			this.estado = "libre";  
			this.mozo = new MozoDTO(53, "Roberto", 3);
		}

		public MesaDTO() {
			// TODO Auto-generated constructor stub
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

		public String getSector() {
			return sector;
		}

		public void setSector(String sector) {
			this.sector = sector;
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

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public MozoDTO getMozo() {
			return mozo;
		}

		public void setMozo(MozoDTO mozo) {
			this.mozo = mozo;
		}
}
