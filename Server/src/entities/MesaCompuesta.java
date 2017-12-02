package entities;

import java.util.Vector;

import enumerators.*;

public class MesaCompuesta extends Mesa {

	private Vector<Mesa> mesas;

	public MesaCompuesta(int id, Vector<Mesa> mesas, int personas, Mozo mozo) {
		super(id, mesas.elementAt(0).getSector());
		this.mesas = mesas;
		super.mozo = mozo;
		super.cantComen = personas;
		setEstadoIndividuales(EstadosMesa.combinada);
		super.estado = EstadosMesa.ocupada;
	}

	@Override
	public void AbrirMesa(int personas, Mozo mozo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void SiguienteEstado() {
		// TODO Auto-generated method stub

	}

	@Override
	public void CerrarMesa() {
		// TODO Auto-generated method stub

	}

	@Override
	public void HabilitarMesa() {
		// TODO Auto-generated method stub

	}

	public void setEstadoIndividuales(EstadosMesa estado) {
		// TODO Auto-generated method stub
		for (Mesa m : mesas)
			m.setEstado(estado);

	}

	@Override
	public void setEstado(EstadosMesa estado) {
		// TODO Auto-generated method stub
		super.estado = estado;

	}

}
