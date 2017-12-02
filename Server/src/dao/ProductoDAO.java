package dao;

import negocio.Producto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entities.ProductoEntity;
import hbt.HibernateUtil;

public class ProductoDAO {
	
	private static ProductoDAO instancia;
	private static SessionFactory sf;

	public static ProductoDAO getInstance() {
		if (instancia == null) {
			instancia = new ProductoDAO();
			sf = HibernateUtil.getSessionFactory();
		}

		return instancia;
	}
	
	
	// AGREGAR UN PRODUCTO A LA BASE DE DATOS
	public void grabarProducto(Producto c) {
		Session s = sf.openSession();
		s.beginTransaction();
		ProductoEntity ce = toEntity(c);
		s.save(ce);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}

	// ACTUALIZAR UN PRODUCTO EN LA BASE DE DATOS
	public void actualizarProducto(Producto c) {
		Session s = sf.openSession();
		ProductoEntity ce = toEntity(c);
		s.update(ce);
		s.beginTransaction().commit();
		s.close();
	}

	// RECUPERAR UN PRODUCTO DE LA BASE DE DATOS
	public Producto recuperarProducto(Integer idProducto) {
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("FROM ProductoEntity WHERE codigo=?");
		q.setParameter(0, idProducto);
		ProductoEntity pe = (ProductoEntity) q.uniqueResult();
		Producto p = this.toNegocio(pe);
		s.flush();
		s.getTransaction().commit();
		s.close();
		return p;
	}

	private Producto toNegocio(ProductoEntity pe) {
		if(pe.get)
		
		return p;
	}

	private ProductoEntity toEntity(Producto p) {
		ProductoEntity pe = new ProductoEntity();

		return pe;
	}
	
}
