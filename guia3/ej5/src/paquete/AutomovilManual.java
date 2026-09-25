package paquete;

public class AutomovilManual extends Automovil{
	
	public AutomovilManual(String patente,double velmax) {
		super(patente,velmax);
	}
	
	public AutomovilManual(String patente) {
		this(patente,160.0);
	}

	public void cambiarMarcha(int nuevaMarcha) {
        setMarcha(nuevaMarcha);
    }
	
	@Override
	public void acelerar(double vel) {
		if (vel>=0)
			if ((vel+velocidad) <= velocidadMaxima)
				velocidad=vel;
	}

	@Override
	public void frenar(double vel) {
		if (vel>=0)
			if (vel <= velocidad)
				velocidad -= vel;
	}

}
