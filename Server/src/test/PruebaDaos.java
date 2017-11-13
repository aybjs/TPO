package test;

import dao.MozoDAO;
import negocio.Mozo;

public class PruebaDaos {

	public static void main(String[] args) {
		//Mozo m = new Mozo(1, "Juan Perez", 0.2f);
		//MozoDAO.getInstance().grabarMozo(m);
		Mozo m1 = MozoDAO.getInstance().recuperarMozo(1);
		System.out.println("id: " + m1.getNroEmpleado() + " nombre: " +m1.getNombre()+" comision: " + m1.getComision() );
	}
	
	
}
