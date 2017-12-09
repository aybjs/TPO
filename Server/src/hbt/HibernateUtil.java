package hbt;

import negocio.ItemRemito;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import dto.RecetaDTO;
import entities.*;

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
        	 //config.addAnnotatedClass(CartaEntity.class);
        	// config.addAnnotatedClass(DepositoEntity.class);
        	// config.addAnnotatedClass(FacturaEntity.class);
        	// config.addAnnotatedClass(ItemOCEntity.class);
        	// config.addAnnotatedClass(ItemRemitoEntity.class);
        	 config.addAnnotatedClass(MozoEntity.class);
        	 config.addAnnotatedClass(ItemRecetaEntity.class);
        	 //config.addAnnotatedClass(LoteEntity.class);
        	 //config.addAnnotatedClass(MovStockEntity.class);
        	 //config.addAnnotatedClass(NotaDevEntity.class);
        	 //config.addAnnotatedClass(OrdenCompraEntity.class);
        	 config.addAnnotatedClass(ProductoSimpleEntity.class);
        	 config.addAnnotatedClass(ProductoCompuestoEntity.class);
        	 config.addAnnotatedClass(ProductoEntity.class);
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
