package paquete;

public class EsperandoSegundoOperando implements State {
    private final Calculadora calc;

    public EsperandoSegundoOperando(Calculadora calc) {
        this.calc = calc;
    }

    @Override
    public void digito(char d) {
        calc.setSegOp(calc.getSegOp() + d);
        calc.setPantalla(calc.getSegOp());
    }

    @Override
    public void operador(char op) {
        if (calc.getSegOp().isEmpty()) {               // se arrepintió del operador: lo reemplaza
            calc.setOperador(op);
            calc.setPantalla(calc.getPrimerOp() + " " + op);
        }                                               // si ya escribió el 2º número, se ignora
    }

    @Override
    public void igual() {
        if (calc.getSegOp().isEmpty()) return;
        if (calc.getOperador() == '/' && Double.parseDouble(calc.getSegOp()) == 0) {
            calc.setPantalla("Error");
            calc.setEstado(new Error(calc));
            return;
        }
        calc.setPantalla(Calculadora.formatear(calc.calcular()));
        calc.setEstado(new MostrandoResultado(calc));
    }

    @Override
    public void ce() { calc.reset(); }
}