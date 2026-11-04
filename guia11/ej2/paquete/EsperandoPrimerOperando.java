package paquete;

public class EsperandoPrimerOperando implements State {
    private final Calculadora calc;

    public EsperandoPrimerOperando(Calculadora calc) {
        this.calc = calc;
    }

    @Override
    public void digito(char d) {
        calc.setPrimerOp(calc.getPrimerOp() + d);
        calc.setPantalla(calc.getPrimerOp());
    }

    @Override
    public void operador(char op) {
        if (calc.getPrimerOp().isEmpty()) return;      // todavía no hay número
        calc.setOperador(op);
        calc.setPantalla(calc.getPrimerOp() + " " + op);
        calc.setEstado(new EsperandoSegundoOperando(calc));
    }

    @Override
    public void igual() { }                            // nada que calcular

    @Override
    public void ce() { calc.reset(); }
}