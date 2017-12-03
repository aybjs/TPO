package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import antlr.collections.impl.Vector;
import entities.ProductoCompuestoEntity;
import entities.ProductoEntity;
import entities.ProductoSimpleEntity;
import hbt.HibernateUtil;
import negocio.Lote;
import negocio.ProductoCompuesto;
import negocio.ProductoSimple;

public class ProductoCompuestoDAO {
	
	private static ProductoCompuestoDAO instancia;
	private static SessionFactory sf;

	public static ProductoCompuestoDAO getInstance() {
		if (instancia == null) {
			instancia = new ProductoCompuestoDAO();
			sf = HibernateUtil.getSessionFactory();
		}

		return instancia;
	}
	
	
	// AGREGAR UN PRODUCTO A LA BASE DE DATOS
	public void grabarProducto(ProductoCompuesto p) {
		Session s = sf.openSession();
		s.beginTransaction();
		ProductoCompuestoEntity pe = toEntity(p);
		s.save(pe);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}

	// ACTUALIZAR UN PRODUCTOSIMPLE EN LA BASE DE DATOS
	public void actualizarProducto(ProductoCompuesto p) {
		Session s = sf.openSession();
		ProductoCompuestoEntity pe = toEntity(p);
		s.update(pe);
		s.beginTransaction().commit();
		s.close();
	}

	// RECUPERAR UN PRODUCTO DE LA BASE DE DATOS
	public ProductoCompuesto recuperarProducto(Integer idProducto) {
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("FROM ProductoCompuestoEntity WHERE codigo=? ");
		q.setParameter(0, idProducto);
		ProductoCompuestoEntity aux = (ProductoCompuestoEntity) q.uniqueResult();
		s.flush();
		s.getTransaction().commit();
		s.close();
		return toNegocio(aux);
	}
	
	public java.util.Vector<ProductoCompuesto> recuperarProductos() {
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("FROM ProductoCompuestoEntity ");
		@SuppressWarnings("unchecked")
		List<ProductoCompuestoEntity> list = q.list();
		java.util.Vector<ProductoCompuesto> aux = new java.util.Vector<ProductoCompuesto>();
		for(ProductoCompuestoEntity p : list)
			aux.addElement(this.toNegocio(p));
		return aux;
	}


	public ProductoCompuesto toNegocio(ProductoCompuestoEntity pe) {
		ProductoCompuesto ps = new ProductoCompuesto();
		ps.setCodigo(pe.getCodigo());
		ps.setComisionExtra(pe.getComisionExtra());
		ps.setConsumoEstimado(pe.getConsumoEstimado());
		//ps.setLotes(pe.getLotes());
		ps.setMinimo(pe.getMinimo());
		ps.setNombre(pe.getNombre());
		ps.setSectorEncargado(pe.getSectorEncargado());
		ps.setPrecio(pe.getPrecio());
		for(ProductoSimpleEntity arreglo : pe.getItems()){
			ps.agregarItem(ProductoSimpleDAO.getInstance().toNegocio(arreglo));
		}
		ps.setTiempoElaboracion(pe.getTiempoElaboracion());
		return ps;	
		}
		
		

	public ProductoCompuestoEntity toEntity(ProductoCompuesto p) {
		ProductoCompuestoEntity pse = new ProductoCompuestoEntity();
		pse.setCodigo(p.getCodigo());
		pse.setComisionExtra(p.getComisionExtra());
		pse.setConsumoEstimado(p.getConsumoEstimado());
		for(Lote lotes : p.getLotes()){
			pse.addLote( LoteDAO.getInstance().toEntity(lotes));			
		}
		pse.setMinimo(p.getMinimo());
		pse.setNombre(p.getNombre());
		pse.setPrecio(p.getPrecio());
		pse.setSectorEncargado(p.getSectorEncargado());
		pse.setTiempoElaboracion(p.getTiempoElaboracion());
		pse.setSectorEncargado(p.getSectorEncargado());
		for(ProductoSimple arreglo : p.getItems()){
			pse.agregarItems(ProductoSimpleDAO.getInstance().toEntity(arreglo));
		}
		return pse;
		 
	}
	
}
