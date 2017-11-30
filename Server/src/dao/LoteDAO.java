package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.LoteEntity;

import hbt.HibernateUtil;
import negocio.Lote;


public class LoteDAO {

	private static LoteDAO instancia;
	private static SessionFactory sf;
	
	private LoteDAO(){}
	
	public static LoteDAO getInstance(){
		if(instancia==null){
			instancia = new LoteDAO();
			sf=HibernateUtil.getSessionFactory();
		}
			
		return instancia;
	}
	
	//AGREGAR UN LOTE A LA BASE DE DATOS
	public void grabarLote(Lote c) {		
		Session s = sf.openSession();		
		s.beginTransaction();
		LoteEntity ce = toEntity(c);
		s.save(ce);
		s.flush();
		s.getTransaction().commit();
		s.close();		
	}
	
	//ACTUALIZAR UN LOTE EN LA BASE DE DATOS
	public void actualizarLote(Lote c) {		
		Session s = sf.openSession();
		LoteEntity ce = toEntity(c);
		s.update(ce);
		s.beginTransaction().commit();			
		s.close();		
	}
	
	//RECUPERAR UN LOTE DE LA BASE DE DATOS
	public Lote recuperarLote(Integer idLote){	
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("FROM LoteEntity WHERE nroLote=?");
		q.setParameter(0, idLote);
		LoteEntity ce = (LoteEntity) q.uniqueResult();
		Lote c = this.toNegocio(ce);
		s.flush();
		s.getTransaction().commit();
		s.close();
		return c;
	}
	
	private Lote toNegocio(LoteEntity le) {
		Lote l = new Lote(le.getNroLote(),le.getFechaCompra(),le.getFechaVenta(),le.getCantidad());
		return l;
	}

	private LoteEntity toEntity(Lote l) {
		LoteEntity le = new LoteEntity();
		le.setCantidad(l.getCantidad());
		le.setFechaCompra(l.getFechaCompra());
		l.setFechaVto(l.getFechaVto());
		l.setNro(l.getNro());
		return le;
	}
}
