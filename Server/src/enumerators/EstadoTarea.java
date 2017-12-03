package enumerators;

public enum EstadoTarea {
	Asignado, NoIniciado, EnProceso, Finalizado {
		@Override
		public EstadoTarea next() {
			return this;
		}
	},
	Cancelado {
		@Override
		public EstadoTarea next() {
			return this;
		}
	};

	public EstadoTarea next() {
		// TODO Auto-generated method stub
		return values()[ordinal() + 1];
	}
}
