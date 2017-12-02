package exceptions;

public class ComprasPendientesException extends Exception{

	private static final long serialVersionUID = 1915235332743261330L;

	public ComprasPendientesException (String mensaje){
		super (mensaje);
	}
}
