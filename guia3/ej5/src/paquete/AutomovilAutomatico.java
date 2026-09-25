package paquete;

public class AutomovilAutomatico extends Automovil {

    public AutomovilAutomatico(String patente, double velmax) {
        super(patente, velmax);
    }

    public AutomovilAutomatico(String patente) {
        this(patente, 160.0);
    }

    private void actualizarMarcha() {
        if (velocidad == 0) {
            setMarcha(0); // Punto muerto
        } else if (velocidad <= 10) {
            setMarcha(1);
        } else if (velocidad <= 35) {
            setMarcha(2);
        } else if (velocidad <= 50) {
            setMarcha(3);
        } else if (velocidad <= 90) {
            setMarcha(4);
        } else {
            setMarcha(5);
        }
    }

    @Override
    public void acelerar(double vel) {
        if (vel > 0) {
            velocidad += vel;
            if (velocidad > velocidadMaxima) {
                velocidad = velocidadMaxima;
            }
            actualizarMarcha();
        }
    }

    @Override
    public void frenar(double vel) {
        if (vel > 0) {
            velocidad -= vel;
            if (velocidad < 0) {
                velocidad = 0;
            }
            actualizarMarcha();
        }
    }

    // Solución al problema de marcha atrás planteado en la consigna
    public void retroceder() {
        if (velocidad == 0) {
            setMarcha(-1);
        } else {
            System.out.println("Debe detener el vehículo por completo para poner reversa.");
        }
    }
}