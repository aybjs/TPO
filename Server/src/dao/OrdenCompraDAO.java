package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import hbt.HibernateUtil;
import negocio.ItemOC;
import negocio.OrdenCompra;
import negocio.Producto;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

import entities.ItemOCEntity;
import entities.OrdenCompraEntity;
import entities.ProductoEntity;

public class OrdenCompraDAO {
	
	private static OrdenCompraDAO instancia;
	private SessionFactory sf;
	
	
	private OrdenCompraDAO(){
		sf = HibernateUtil.getSessionFactory();
	}
	
	public OrdenCompraDAO getInstancia(){
		if(instancia==null)
			instancia = new OrdenCompraDAO();
		return instancia;
	}
	
	//Agrego OC a la BD
	public void grabar(OrdenCompra oc){
		Session s = sf.openSession();
		s.beginTransaction();
		OrdenCompraEntity oce = this.toEntity(oc);
		s.save(oce);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}

	public OrdenCompraEntity toEntity(OrdenCompra oc) {
		// TODO Auto-generated method stub
		OrdenCompraEntity oce = new OrdenCompraEntity();
		oce.setDestino(oc.getDestino());
		oce.setId(oc.getId());
		oce.setResponsable(oc.getResponsable());
		oce.setProveedor(ProveedorDAO.getInstancia().toEntity(oc.getProveedor()));
		Vector <ItemOCEntity> items = new Vector<ItemOCEntity>();
		for (ItemOC aux : oc.getItems()){
			ItemOCEntity ent = new ItemOCEntity();
			ent.setCantidad(aux.getCantidad());
			ent.setDiasHastaVto(aux.getDiasHastaVto());
			ProductoEntity pe = ProductoDAO.getInstancia().toEntity(aux.getProducto());
			ent.setProducto(pe);
			items.add(ent);
		}
		oce.setItems(items);
		
		return null;
	}

	

}
