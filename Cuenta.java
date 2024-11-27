package ejercicio.banco;

/** Describiendo un sistema bancario
 *  Metodos son: Consignar, reirar, transferencia
 *  Clase cliente y clase cuenta
 */
import java.util.Scanner;

public class Cuenta {
    
    private int numeroCuenta; //Declaramos los tipos de variables que vamos a usar
    private double Saldo;
    private String[] historial = new String[10];


    
    public Cuenta(int numeroCuenta, double saldo){ //Constructor
        this.numeroCuenta = numeroCuenta;
        this.Saldo = saldo;
    }
    
    private double calcularImpuesto(double monto) {
        return monto * 0.004 / 100;  // se calcula el impuesto al 4x1000
    }
    
    public void retirar(double monto) { //Metodo para retirar
        double impuesto = calcularImpuesto(monto);  
        double montoConImpuesto = monto + impuesto;
        
        if (Saldo >= montoConImpuesto) {
            // Preguntar por la donación
            if (pedirDonacion()) {
                if (Saldo >= montoConImpuesto + 500) { // Asegurarse de que haya fondos suficientes para la donación
                    Saldo -= 500; // Restar la donación
                    agregarAlHistorial("Donación de $500 a Patitas Felices");
                } else {
                    System.out.println("No tienes suficiente saldo para hacer la donación.");
                }
            }
            Saldo -= montoConImpuesto;
            agregarAlHistorial("Retiro: $" + monto +  "(Impuesto: $" + impuesto + ")");
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }
    
    public void consignar(double monto) {
        double impuesto = calcularImpuesto(monto);  
        double montoConImpuesto = monto - impuesto;
        
        if (pedirDonacion()) {
            if (Saldo >= montoConImpuesto + 500) { // Asegurarse de que haya fondos suficientes para la donación
                Saldo -= 500; // Restar la donación
                agregarAlHistorial("Donación de $500 a Patitas Felices");
            } else {
                System.out.println("No tienes suficiente saldo para hacer la donación.");
            }
        }
        Saldo += montoConImpuesto;
        agregarAlHistorial("Deposito: $" + monto + " (Impuesto: $" + impuesto + ")");
    }
    
    public void transferir(Cuenta cuentaDestino, double monto) {
        double impuesto = calcularImpuesto(monto);  
        double montoConImpuesto = monto + impuesto;
        
        if (Saldo >= montoConImpuesto) {
            // Preguntar por la donación
            if (pedirDonacion()) {
                if (Saldo >= montoConImpuesto + 500) { // Asegurarse de que haya fondos suficientes para la donación
                    Saldo -= 500; // Restar la donación
                    agregarAlHistorial("Donación de $500 a Patitas Felices");
                } else {
                    System.out.println("No tienes suficiente saldo para hacer la donación.");
                }
            }
            Saldo -= montoConImpuesto;
            cuentaDestino.consignar(monto-impuesto);
            agregarAlHistorial("Transferencia a " + cuentaDestino.numeroCuenta + ": $" + monto+ " (Impuesto: $" + impuesto + ")");
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }
    
    public void mostrarSaldo() {
        System.out.println("Saldo actual: $" + Saldo);
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
    
      private boolean pedirDonacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseas donar 500 a la fundacion 'Patitas Felices'? (si/no): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("si");
    }
}
  
            
            
    