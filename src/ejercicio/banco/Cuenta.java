
package ejercicio.banco;

/** Describiendo un sistema bancario
 *  Metodos son: Consignar, reirar, transferencia
 *  Clase cliente y clase cuenta
 */

public class Cuenta {
    
    private int numeroCuenta; //Declaramos los tipos de variables que vamos a usar
    private double Saldo;
    private String[] historial = new String[10];


    
    public Cuenta(int numeroCuenta, double saldo){ //Constructor
        this.numeroCuenta = numeroCuenta;
        this.Saldo = Saldo;
    }
    
    public void retirar(double monto) { //Metodo para retirar
        if (Saldo >= monto) {
            Saldo -= monto;
            agregarAlHistorial("Retiro: $" + monto);
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }
    
    public void consignar(double monto) {
        Saldo += monto;
        agregarAlHistorial("Deposito: $" + monto);
    }
    
    public void transferir(Cuenta cuentaDestino, double monto) {
        if (Saldo >= monto) {
            Saldo -= monto;
            cuentaDestino.consignar(monto);
            agregarAlHistorial("Transferencia a " + cuentaDestino.numeroCuenta + ": $" + monto);
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }
    
    public void visualizarUltimasOperaciones() {
        System.out.println("Historial de operaciones:");
        for (String operacion : historial) {
            if (operacion != null) {
                System.out.println(operacion);
            }
        }
    }
    
     private void agregarAlHistorial(String operacion) {
        // Desplazar las operaciones existentes y agregar la nueva al inicio
        for (int i = historial.length - 1; i > 0; i--) {
            historial[i] = historial[i - 1];
        }
        historial[0] = operacion;
    }
     public double getSaldo() {
        return Saldo;
    }
}
  
            
            
    