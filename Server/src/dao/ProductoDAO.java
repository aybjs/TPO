package dao;

import negocio.Producto;
import negocio.ProductoCompuesto;
import negocio.ProductoSimple;

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
		//Producto p = this.toNegocio(pe);
		s.flush();
		s.getTransaction().commit();
		s.close();
		return null;
	}

	public Producto toNegocio(ProductoEntity pe) {
		//Producto p;
		if(pe instanceof ProductoSimpleEntity){
			ProductoSimple ps = new ProductoSimple();
			ps = new ProductoSimple();
			ps.setCodigo(pe.getCodigo());
			ps.setComisionExtra(pe.getComisionExtra());
			ps.setConsumoEstimado(pe.getConsumoEstimado());
			//ps.setLotes(pe.getLotes());
			ps.setMinimo(pe.getMinimo());
			ps.setNombre(pe.getNombre());
			//p.setSectorEncargado(pe.getSectorEncargado());
		}else{
			ProductoCompuesto pc = new ProductoCompuesto();
			pc.setCodigo(pe.getCodigo());
			pc.setComisionExtra(pe.getComisionExtra());
			pc.setConsumoEstimado(pe.getConsumoEstimado());
			//p.setLotes(pe.getLotes());
			pc.setMinimo(pe.getMinimo());
			pc.setNombre(pe.getNombre());
			//pc.setSectorEncargado(pe.getSectorEncargado());
			//pc.setCantItem(pe.get);
			
		}
		
		
		return null;
	}

	public ProductoEntity toEntity(Producto p) {
		//ProductoEntity pe = new ProductoEntity();
		//return pe;
		 return null;
		 
	}
	
}
