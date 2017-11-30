package negocio;

import java.time.LocalDate;

public class NotaDevolucion {

	private static long id = 0;
	private Remito remito;
	private LocalDate fecha;

	public NotaDevolucion(Remito remito) {
		id++;
		this.remito = remito;
		fecha = LocalDate.now();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(int anio, int mes, int dia) {
		this.fecha = LocalDate.of(anio, mes, dia);
	}

	public static long getId() {
		return id;
	}

	public Remito getRemito() {
		return remito;
	}

}
