package modelo;

import ventana.VentanaPrincipal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();

        try {
            // Cajas de Ahorro
            CajaDeAhorro ca1 = new CajaDeAhorro("Luc�a M�ndez");
            ca1.depositar(45000.0);

            CajaDeAhorro ca2 = new CajaDeAhorro("Mart�n G�mez");
            ca2.depositar(12000.0);

            // Cuentas Corrientes (tope por defecto de 10000 y tope personalizado)
            CuentaCorriente cc1 = new CuentaCorriente("Juan P�rez");
            cc1.depositar(25000.0);

            CuentaCorriente cc2 = new CuentaCorriente("Empresa Transporte SRL", 50000.0);
            cc2.depositar(80000.0);

            // Cuentas Universitarias
            CuentaUniversitaria cu1 = new CuentaUniversitaria("Sof�a Rossi");
            cu1.depositar(5000.0);

            CuentaUniversitaria cu2 = new CuentaUniversitaria("Mateo Fern�ndez");
            cu2.depositar(3500.0);

            // Agregamos al banco
            banco.agregarCuenta(ca1);
            banco.agregarCuenta(ca2);
            banco.agregarCuenta(cc1);
            banco.agregarCuenta(cc2);
            banco.agregarCuenta(cu1);
            banco.agregarCuenta(cu2);

            // Extracciones
            ca1.extraer(5000.0);
            cc1.extraer(30000.0); // Usa 5000 de descubierto
            cu1.extraer(800.0);   // Dentro del l�mite diario
            cu1.extraer(500.0);   // Supera el l�mite diario de 1000

            // Salida por consola
            for (CuentaBancaria c : banco.getCuentas()) {
                System.out.println(c);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal ventana = new VentanaPrincipal(banco);
                ventana.setVisible(true);
            }
        });
    }

}
    
    