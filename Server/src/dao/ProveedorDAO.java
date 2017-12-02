package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ProveedorEntity;
import negocio.Proveedor;

public class ProveedorDAO {
	
	private static ProveedorDAO instancia;
	private SessionFactory sf;
	
	private ProveedorDAO(){
		sf = hbt.HibernateUtil.getSessionFactory();
	}
	
	public static ProveedorDAO getInstancia(){
		if (instancia==null)
			instancia = new ProveedorDAO();
		return instancia;
		
	}
	
	public List<Proveedor> getAll(){
		List <Proveedor> rta = new ArrayList<Proveedor>();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		@SuppressWarnings("unchecked")
		List<ProveedorEntity> aux = (List<ProveedorEntity>) sesion.createQuery("from proveedores").list();
		for (ProveedorEntity ent : aux){
			Proveedor p = this.toNegocio(ent);
			rta.add(p);
		}
		sesion.getTransaction().commit();
		sesion.close();
		return rta;
		
	}
	
	public Proveedor getByCUIT(String cuit){
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query q = sesion.createQuery("from proveedores where cuit = ?");
		q.setParameter(0, cuit);
		ProveedorEntity aux = (ProveedorEntity) q.uniqueResult();
		Proveedor p = toNegocio(aux);
		sesion.flush();
		sesion.getTransaction().commit();
		sesion.close();
		return p;		
	} 

	public Proveedor toNegocio(ProveedorEntity ent) {
		// TODO Auto-generated method stub
		Proveedor p = new Proveedor(ent.getCodProveedor(), ent.getRazonSocial(), ent.getCUIT());
		p.setCodProveedor(ent.getCodProveedor());
		return p;
	}
	
	public ProveedorEntity toEntity(Proveedor p){
		ProveedorEntity ent = new ProveedorEntity();
		ent.setCodProveedor(p.getCodProveedor());
		ent.setCUIT(p.getCUIT());
		ent.setRazonSocial(p.getRazonSocial());
		return ent;
	}

}
