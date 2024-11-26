/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.banco;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Tomas Saldaña
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       System.out.print("Ingrese el número de cuenta: ");
        int numeroCuenta = scanner.nextInt();

        // Crear un objeto Cuenta
        Cuenta cuentaCliente = new Cuenta(12345, 1000); // Suponiendo un saldo inicial de 1000

        Map<Integer, Cuenta> cuentas = new HashMap<>();
        cuentas.put(numeroCuenta, cuentaCliente);
        
        cuentas.put(12345, new Cuenta(12345, 1000));
        String opcion;
        do {
            System.out.println("\nOpciones:");
            System.out.println("1. Consignar");
            System.out.println("2. Retirar");
            System.out.println("3. Transferir");
            System.out.println("4. Ver historial");
            System.out.println("5. Salir");

            System.out.print("Ingrese una opción: ");
            opcion = scanner.next();
            
            Cliente cliente = new Cliente("Cliente", numeroCuenta);

            switch (opcion) {
                case "1" -> {
                    System.out.print("Ingrese el monto a consignar: ");
                    double monto = scanner.nextDouble();
                    cliente.getCuenta().consignar(monto);
                }
                case "2" -> {
                    System.out.print("Ingrese el monto a retirar: ");
                    double monto = scanner.nextDouble();
                    cliente.getCuenta().retirar(monto);
                }
                case "3" -> {
                    System.out.print("Ingrese el número de cuenta destino: ");
                    int cuentaDestino = scanner.nextInt();
                    System.out.print("Ingrese el monto a transferir: ");
                    double monto = scanner.nextDouble();

                 
                    Cuenta cuentaDestinoObj = cuentas.get(cuentaDestino);
                    if (cuentaDestinoObj != null) {
                        cliente.getCuenta().transferir(cuentaDestinoObj, monto);
                    } else {
                        System.out.println("La cuenta destino no existe.");
                    }
                    break;
                }
                case "4" -> cliente.getCuenta().visualizarUltimasOperaciones();
                case "5" -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
        } while (!opcion.equals("5"));
    }
}
    
