package dao;

import java.util.Vector;

import negocio.Tarea;

public class TareaDAO {
	
	private static TareaDAO instancia;

	public static TareaDAO getInsatancia() {
		// TODO Auto-generated method stub
		if (instancia == null)
			instancia = new TareaDAO();
		return instancia;
	}
	
	private TareaDAO(){}
	
	public Vector<Tarea> getActivas(){
		return null;
	}

}
