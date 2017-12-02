package hbt;

import negocio.ItemRemito;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.ItemOCEntity;
import entities.ItemRemitoEntity;
import entities.LoteEntity;
import entities.MozoEntity;
import entities.NotaDevEntity;
import entities.OrdenCompraEntity;
import entities.ProductoEntity;
import entities.ProveedorEntity;
import entities.RemitoEntity;

//<<<<<<< Updated upstream
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 config.addAnnotatedClass(ItemOCEntity.class);
        	 config.addAnnotatedClass(ItemRemitoEntity.class);
        	 config.addAnnotatedClass(MozoEntity.class);
        	 config.addAnnotatedClass(LoteEntity.class);
        	 config.addAnnotatedClass(NotaDevEntity.class);
        	 config.addAnnotatedClass(OrdenCompraEntity.class);
        	 config.addAnnotatedClass(ProductoEntity.class);
        	 config.addAnnotatedClass(ProveedorEntity.class);
        	 config.addAnnotatedClass(RemitoEntity.class);
        	 sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

/*public HibernateUtil() {
	private static final SessionFactory sessionFactory;
	static {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(MozoEntity.class);
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}*/
// >>>>>>> Stashed changes
}
