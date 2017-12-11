package hbt;

import negocio.ItemRemito;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.AreaProduccionEntity;
import entities.CajaEntity;
import entities.CartaEntity;
import entities.DepositoEntity;
import entities.FacturaEntity;
import entities.ItemOCEntity;
import entities.ItemRemitoEntity;
import entities.LoteEntity;
import entities.MovStockEntity;
import entities.MozoEntity;
import entities.NotaDevEntity;
import entities.OrdenCompraEntity;
import entities.ProductoCompuestoEntity;
import entities.ProductoEntity;
import entities.ProductoSimpleEntity;
import entities.ProveedorEntity;
import entities.RemitoEntity;
import entities.StockEntity;
import entities.TareaEntity;

//<<<<<<< Updated upstream
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 //config.addAnnotatedClass(AreaProduccionEntity.class);
        	 //config.addAnnotatedClass(CajaEntity.class);
        	 config.addAnnotatedClass(CartaEntity.class);
        	// config.addAnnotatedClass(DepositoEntity.class);
        	// config.addAnnotatedClass(FacturaEntity.class);
        	// config.addAnnotatedClass(ItemOCEntity.class);
        	// config.addAnnotatedClass(ItemRemitoEntity.class);
        	 config.addAnnotatedClass(MozoEntity.class);
        	 //config.addAnnotatedClass(LoteEntity.class);
        	 //config.addAnnotatedClass(MovStockEntity.class);
        	 //config.addAnnotatedClass(NotaDevEntity.class);
        	 //config.addAnnotatedClass(OrdenCompraEntity.class);
        	 config.addAnnotatedClass(ProductoCompuestoEntity.class);
        	 config.addAnnotatedClass(ProductoEntity.class);
        	 config.addAnnotatedClass(ProductoSimpleEntity.class);
        	 config.addAnnotatedClass(ProveedorEntity.class);
        	 //config.addAnnotatedClass(RemitoEntity.class);
        	 //config.addAnnotatedClass(StockEntity.class);
        	 //config.addAnnotatedClass(TareaEntity.class);
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
