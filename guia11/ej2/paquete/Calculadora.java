package paquete;

public class Calculadora {
    private State estado;
    private String primerOp = "";
    private String segOp = "";
    private char operador;
    private String pantalla = "0";

    public Calculadora() {
        reset();
    }

    // Solo clasifica la tecla. No pregunta en qué estado está.
    public void ingresa(char c) {
        if (Character.isDigit(c))           estado.digito(c);
        else if ("+-*/".indexOf(c) >= 0)    estado.operador(c);
        else if (c == '=')                  estado.igual();
        else if (c == 'C')                  estado.ce();
    }

    public void reset() {
        primerOp = "";
        segOp = "";
        pantalla = "0";
        estado = new EsperandoPrimerOperando(this);
    }

    public double calcular() {
        double a = Double.parseDouble(primerOp);
        double b = Double.parseDouble(segOp);
        return switch (operador) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default  -> a / b;
        };
    }

    public static String formatear(double x) {
        return (x == Math.floor(x)) ? String.valueOf((long) x) : String.valueOf(x);
    }

    // getters y setters que usan los estados
    public void setEstado(State estado) { this.estado = estado; }
    public String getPrimerOp() { return primerOp; }
    public void setPrimerOp(String s) { primerOp = s; }
    public String getSegOp() { return segOp; }
    public void setSegOp(String s) { segOp = s; }
    public char getOperador() { return operador; }
    public void setOperador(char op) { operador = op; }
    public String getPantalla() { return pantalla; }
    public void setPantalla(String s) { pantalla = s; }
}