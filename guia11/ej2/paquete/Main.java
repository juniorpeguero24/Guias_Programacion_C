package paquete;

public class Main {
    public static void main(String[] args) {
        String[][] pruebas = {
                {"12+34=", "46"},
                {"9/3=", "3"},
                {"7/0=", "Error"},
                {"7/0=5+2", "Error"},
                {"7/0=C5+2=", "7"},
                {"45*C3-1=", "2"},
                {"8-9=", "-1"},
        };
        for (String[] p : pruebas) {
            Calculadora calc = new Calculadora();
            for (char c : p[0].toCharArray()) calc.ingresa(c);
            String ok = calc.getPantalla().equals(p[1]) ? "OK" : "FALLA";
            System.out.println(p[0] + "  ->  " + calc.getPantalla() + "  (esperado " + p[1] + ")  " + ok);
        }
    }
}