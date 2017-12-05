package test;

import java.util.Date;

import controllers.ControladorCentral;
import dao.LoteDAO;
import dao.MozoDAO;
import dao.ProductoSimpleDAO;
import dto.ProductoDTO;
import exceptions.SinMozosException;
import negocio.Lote;
import negocio.Mozo;
import negocio.ProductoSimple;

public class PruebaDaos {
	public static void main(String[] args) throws SinMozosException {
/*	public void funcion() throws SinMozosException{
		
		//Mozo m = new Mozo(1, "Juan Perez", 0.2f);
		//MozoDAO.getInstance().grabarMozo(m);
		//Mozo m1 = MozoDAO.getInstance().recuperarMozo(1);
		//System.out.println("id: " + m1.getNroEmpleado() + " nombre: " +m1.getNombre()+" comision: " + m1.getComision() );
		
		Date a = new Date(1999,01,01);
		Lote l = new Lote(1, a, a, 4);
		LoteDAO.getInstance().grabarLote(l);
		// Mozo m = new Mozo(1, "Juan Perez", 0.2f);
		// MozoDAO.getInstance().grabarMozo(m);
		Mozo m1 = MozoDAO.getInstance().recuperarMozo(1);
		System.out.println("id: " + m1.getNroEmpleado() + " nombre: " +m1.getNombre()+" comision: " + m1.getComision() );		
	}
	
		ProductoDTO pdto = new ProductoDTO();
		pdto.setComisionExtra(23);
		pdto.setNombre("plato 1");
		pdto.setPrecio(23);
		pdto.setStock(23);
		
		ControladorCentral.getInstancia().agregarPlato(pdto);
		
		*/
		ControladorCentral.getInstancia();
		for(ProductoSimple ps : ProductoSimpleDAO.getInstance().recuperarProductos()){
			System.out.println(ps.getNombre());
		}
}
}
