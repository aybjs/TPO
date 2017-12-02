package dao;

import negocio.Producto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entities.ProductoEntity;
import entities.ProductoSimpleEntity;
import hbt.HibernateUtil;
import entities.ProductoSimpleEntity;
import entities.ProductoCompuestoEntity;

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
	public void grabarProducto(Producto p) {
		Session s = sf.openSession();
		s.beginTransaction();
		ProductoEntity pe = toEntity(p);
		s.save(pe);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}

	// ACTUALIZAR UN PRODUCTO EN LA BASE DE DATOS
	public void actualizarProducto(Producto p) {
		Session s = sf.openSession();
		ProductoEntity pe = toEntity(p);
		s.update(pe);
		s.beginTransaction().commit();
		s.close();
	}

	// RECUPERAR UN PRODUCTO DE LA BASE DE DATOS
	public Producto recuperarProducto(Integer idProducto) {
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("FROM ProductoEntity WHERE codigo=? and tipoProducto = 'Compuesto'");
		q.setParameter(0, idProducto);
		ProductoEntity aux = (ProductoEntity) q.uniqueResult();
		ProductoEntity pe;
		if(aux!=null){
			pe = (ProductoCompuestoEntity) q.uniqueResult();
		} else {
			q = s.createQuery("FROM ProductoEntity WHERE codigo=? and tipoProducto = 'Simple'");
			q.setParameter(0, idProducto);
			pe = (ProductoSimpleEntity) q.uniqueResult();
		}
		Producto p = this.toNegocio(pe);
		s.flush();
		s.getTransaction().commit();
		s.close();
		return p;
	}

	public Producto toNegocio(ProductoEntity pe) {
		Producto p;
		if(pe instanceof ProductoSimpleEntity){
			
			
			
		}
		
		return p;
	}

	public ProductoEntity toEntity(Producto p) {
		ProductoEntity pe = new ProductoEntity();
		return pe;
	}
	
}
