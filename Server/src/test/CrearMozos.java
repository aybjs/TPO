package test;

import java.util.Vector;

import negocio.Mozo;
import dao.MozoDAO;

public class CrearMozos { //metodo para meter mozos a la database
	
	public static void main(String[] args) { 
			
		MozoDAO.getInstance().grabarMozo(new Mozo(2017011, "Esteban Quito", 0.05f,1));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017012, "Amilcar Cajada", 0.05f,1));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017013, "Ana Tomia", 0.10f,1));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017014, "Benito Camelo", 0.05f,1));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017015, "Ariel C. Pillado", 0.07f,1));
		
		MozoDAO.getInstance().grabarMozo(new Mozo(2017021, "Aquiles Meo de Latorre", 0.05f,2));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017022, "Ana Konda", 0.10f,2));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017023, "Cindy Entes", 0.09f,2));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017024, "Alma Maria Rico", 0.06f,2));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017025, "Alex Plosivo", 0.05f,2));
		
		MozoDAO.getInstance().grabarMozo(new Mozo(2017031, "Susana Horia", 0.05f,3));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017032, "Jhony Meacuerdo", 0f,3));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017033, "Andres Tresado", 0f,3));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017034, "Coco Drilo", 0.05f,3));
		MozoDAO.getInstance().grabarMozo(new Mozo(2017035, "Dolores D. Parto", 0.045f, 3));
	}

}
