package dao;

import java.util.Vector;

import hbt.HibernateUtil;
import negocio.ProductoSimple;
import negocio.Stock;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.LoteEntity;
import entities.ProductoEntity;
import entities.StockEntity;

public class StockDAO {
	private static StockDAO instancia;
	private static SessionFactory sf;

	public static StockDAO getInstancia(){
		if(instancia == null){
			instancia = new StockDAO();
			sf = HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public StockDAO(){
		
	}
	public void saveMe(Stock s){
		Session session = sf.openSession();
		session.beginTransaction();
		StockEntity se = toEntity(s);
		session.save(se);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public StockEntity toEntity(Stock s){
		StockEntity se = new StockEntity();
		ProductoSimple pse = new ProductoSimple();
				
		//		s.getProducto().getCodigo(), s.getProducto().getNombre(),s.getProducto().getSectorEncargado(), s.getProducto().getMinimo(), s.getProducto().getComisionExtra(), null, s.getProducto().getConsumoEstimado(), s.getProducto().getPrecio());
		//(int codigo, String nombre, String sectorEncargado, float minimo, float comisionExtra,
		//		Vector<LoteEntity> lotes, float consumoEstimado, float precio) 
		
		//se.setProducto(pse);
		return se;
		
	}
	
	
}
