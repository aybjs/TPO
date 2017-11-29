package test;

import java.util.Date;

import dao.LoteDAO;
import dao.MozoDAO;
import negocio.Lote;
import negocio.Mozo;

public class PruebaDaos {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
<<<<<<< Updated upstream
		//Mozo m = new Mozo(1, "Juan Perez", 0.2f);
		//MozoDAO.getInstance().grabarMozo(m);
		//Mozo m1 = MozoDAO.getInstance().recuperarMozo(1);
		//System.out.println("id: " + m1.getNroEmpleado() + " nombre: " +m1.getNombre()+" comision: " + m1.getComision() );
		
		Date a = new Date(1999,01,01);
		Lote l = new Lote(1, a, a, 4);
		LoteDAO.getInstance().grabarLote(l);
=======
		// Mozo m = new Mozo(1, "Juan Perez", 0.2f);
		// MozoDAO.getInstance().grabarMozo(m);
		Mozo m1 = MozoDAO.getInstance().recuperarMozo(1);
		System.out.println("id: " + m1.getNroEmpleado() + " nombre: "
				+ m1.getNombre() + " comision: " + m1.getComision());
>>>>>>> Stashed changes
	}

}
