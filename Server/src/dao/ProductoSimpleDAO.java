package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ProductoCompuestoEntity;
import entities.ProductoEntity;
import entities.ProductoSimpleEntity;
import hbt.HibernateUtil;
import negocio.ProductoCompuesto;
import negocio.ProductoSimple;

public class ProductoSimpleDAO {
	
	private static ProductoSimpleDAO instancia;
	private static SessionFactory sf;

	public static ProductoSimpleDAO getInstance() {
		if (instancia == null) {
			instancia = new ProductoSimpleDAO();
			sf = HibernateUtil.getSessionFactory();
		}

		return instancia;
	}
	
	
	// AGREGAR UN PRODUCTO A LA BASE DE DATOS
	public void grabarProducto(ProductoSimple p) {
		Session s = sf.openSession();
		s.beginTransaction();
		ProductoSimpleEntity pe = toEntity(p);
		s.save(pe);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}

	// ACTUALIZAR UN PRODUCTOSIMPLE EN LA BASE DE DATOS
	public void actualizarProducto(ProductoSimple p) {
		Session s = sf.openSession();
		ProductoSimpleEntity pe = toEntity(p);
		s.update(pe);
		s.beginTransaction().commit();
		s.close();
	}

	// RECUPERAR UN PRODUCTO DE LA BASE DE DATOS
	public ProductoSimple recuperarProducto(Integer idProducto) {
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("FROM ProductoSimpleEntity WHERE codigo=? ");
		q.setParameter(0, idProducto);
		ProductoSimpleEntity aux = (ProductoSimpleEntity) q.uniqueResult();
		s.flush();
		s.getTransaction().commit();
		s.close();
		return toNegocio(aux);
	}

	public ProductoSimple toNegocio(ProductoSimpleEntity pe) {
		ProductoSimple ps = new ProductoSimple();
		ps.setCodigo(pe.getCodigo());
		ps.setComisionExtra(pe.getComisionExtra());
		ps.setConsumoEstimado(pe.getConsumoEstimado());
		//ps.setLotes(pe.getLotes());
		ps.setMinimo(pe.getMinimo());
		ps.setNombre(pe.getNombre());
		ps.setSectorEncargado(pe.getSectorEncargado());
		//ps.setPrecio(pe.getPrecio());
		ps.setMedida(pe.getMedida());
		return ps;	
		}
		
		

	public ProductoSimpleEntity toEntity(ProductoSimple p) {
		ProductoSimpleEntity pse = new ProductoSimpleEntity();
		pse.setCodigo(p.getCodigo());
		pse.setComisionExtra(p.getComisionExtra());
		pse.setConsumoEstimado(p.getConsumoEstimado());
		//pse.setLotes(p.getLotes());
		pse.setMedida(p.getMedida());
		pse.setMinimo(p.getMinimo());
		pse.setNombre(p.getNombre());
		//pse.setPrecio(p.getPrecio());
		pse.setSectorEncargado(p.getSectorEncargado());
		return pse;
		 
	}
	
	public java.util.Vector<ProductoSimple> recuperarProductos() {
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("FROM ProductoSimpleEntity ");
		@SuppressWarnings("unchecked")
		List<ProductoSimpleEntity> list = q.list();
		java.util.Vector<ProductoSimple> aux = new java.util.Vector<ProductoSimple>();
		for(ProductoSimpleEntity p : list)
			aux.addElement(this.toNegocio(p));
		return aux;
	}
	
}
