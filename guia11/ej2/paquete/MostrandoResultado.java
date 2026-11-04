package paquete;

public class MostrandoResultado implements State {
    private final Calculadora calc;

    public MostrandoResultado(Calculadora calc) {
        this.calc = calc;
    }

    @Override
    public void digito(char d) {                       // empieza una cuenta nueva
        calc.reset();
        calc.ingresa(d);
    }

    @Override
    public void operador(char op) {                    // sigue operando con el resultado
        calc.setPrimerOp(calc.getPantalla());
        calc.setSegOp("");
        calc.setOperador(op);
        calc.setPantalla(calc.getPrimerOp() + " " + op);
        calc.setEstado(new EsperandoSegundoOperando(calc));
    }

    @Override
    public void igual() { }

    @Override
    public void ce() { calc.reset(); }
}