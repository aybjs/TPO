package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entities.MozoEntity;
import exceptions.SinMozosException;
import hbt.HibernateUtil;
import negocio.Mozo;

//se renombra la clase "MozoDao" a "MozoDAO" tal cual está declarado
public class MozoDAO {
	private static MozoDAO instancia;
	private static SessionFactory sf;

	public static MozoDAO getInstance() {
		if (instancia == null) {
			instancia = new MozoDAO();
			sf = HibernateUtil.getSessionFactory();
		}

		return instancia;
	}

	// AGREGAR UN MOZO A LA BASE DE DATOS
	public void grabarMozo(Mozo c) {
		Session s = sf.openSession();
		s.beginTransaction();
		MozoEntity ce = toEntity(c);
		s.save(ce);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}

	// ACTUALIZAR UN MOZO EN LA BASE DE DATOS
	public void actualizarMozo(Mozo c) {
		Session s = sf.openSession();
		MozoEntity ce = toEntity(c);
		s.update(ce);
		s.beginTransaction().commit();
		s.close();
	}
<<<<<<< HEAD
	
	//RECUPERAR UN MOZO DE LA BASE DE DATOS
	public Mozo recuperarMozo(Integer idMozo) throws SinMozosException{	
		Mozo c;
=======

	// RECUPERAR UN MOZO DE LA BASE DE DATOS
	public Mozo recuperarMozo(Integer idMozo) {
>>>>>>> master
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("FROM MozoEntity WHERE nroEmpleado=?");
		q.setParameter(0, idMozo);
		MozoEntity ce = (MozoEntity) q.uniqueResult();
		if(ce != null) {
			c = this.toNegocio(ce);
		}
		else {
			throw new SinMozosException("No hay mozos");
		}
		s.flush();
		s.getTransaction().commit();
		s.close();
		return c;
	}

	private Mozo toNegocio(MozoEntity ce) {
		Mozo m = new Mozo(ce.getNroEmpleado(), ce.getNombre(), ce.getComision());
		return m;
	}

	private MozoEntity toEntity(Mozo c) {
		MozoEntity me = new MozoEntity();
		me.setNroEmpleado(c.getNroEmpleado());
		me.setNombre(c.getNombre());
		me.setComision(c.getComision());
		return me;
	}
}
