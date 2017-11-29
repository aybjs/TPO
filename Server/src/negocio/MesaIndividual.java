package negocio;

import java.util.Date;

import enumerators.*;

public class MesaIndividual extends Mesa {

	private int nro;
	private int maxCom;

	public MesaIndividual(int id, String sector, int nro, int maxCom) {
		super(id, sector);
		this.nro = nro;
		this.maxCom = maxCom;
		this.estado = EstadosMesa.libre;

	}

	@Override
	public void AbrirMesa(int personas, Mozo mozo) {
		// TODO Auto-generated method stub
		super.cantComen = personas;
		super.apertura = new Date();
		super.fecha = new Date();
		super.mozo = mozo;
		super.estado = EstadosMesa.ocupada;
	}

	@Override
	public void SiguienteEstado() {
		// TODO Auto-generated method stub
		// sigo pensando que esto está al pedo! :)
		super.estado = EstadosMesa.cerrada;

	}

	@Override
	public void CerrarMesa() {
		// TODO Auto-generated method stub
		super.estado = EstadosMesa.cerrada;

	}

	@Override
	public void HabilitarMesa() {
		// TODO Auto-generated method stub
		super.estado = EstadosMesa.libre;

	}

	public String getEstado() {
		return super.estado.toString();
	}

	public void setEstado(EstadosMesa estado) {
		super.estado = estado;
	}

}
