package paquete;

public class Error implements State {
    private final Calculadora calc;

    public Error(Calculadora calc) {
        this.calc = calc;
    }

    @Override public void digito(char d) { }           // ignora todo...
    @Override public void operador(char op) { }
    @Override public void igual() { }

    @Override
    public void ce() { calc.reset(); }                  // ...menos CE
}