package ejercicio.banco;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import ejercicio.banco.Cuenta;
import ejercicio.banco.Cliente;

/**
 *
 * @author Tomas Saldaña
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear 10 cuentas con diferentes saldos y números
        Map<Integer, Cuenta> cuentas = new HashMap<>();
        cuentas.put(12345, new Cuenta(12345, 1000000, "Juan Perez"));
        cuentas.put(23456, new Cuenta(23456, 5500000, "Jose Castro"));
        cuentas.put(34567, new Cuenta(34567, 1500000, "Julieta Venegas"));
        cuentas.put(45678, new Cuenta(45678, 22300000, "Gabriel Mora"));
        cuentas.put(56789, new Cuenta(56789, 3700000, "Angelica Velasco"));
        cuentas.put(67890, new Cuenta(67890, 7000000, "Mariana Rodriguez"));
        cuentas.put(78901, new Cuenta(78901, 1245000, "David Vargas"));
        cuentas.put(89012, new Cuenta(89012, 2500000, "Samuel Feris"));
        cuentas.put(90123, new Cuenta(90123, 4500000, "Michel Plazas"));
        cuentas.put(10123, new Cuenta(10123, 350000, "Benito Martinez"));

        // Pedir al usuario que ingrese el número de cuenta
        System.out.print("Ingrese su numero de cuenta: ");
        int numeroCuenta = scanner.nextInt();

        // Verificar si la cuenta existe en el HashMap
        Cuenta cuentaCliente = cuentas.get(numeroCuenta);

        if (cuentaCliente != null) {
            System.out.println("Bienvenido " + cuentaCliente.getNombreTitular());
            System.out.println("Bienvenido Has accedido a la cuenta: " + numeroCuenta);
        } else {
            System.out.println("Número de cuenta no válido.");
            return; // Salir si la cuenta no existe
        }
        
        // Crear el cliente con el nombre y número de cuenta
        Cliente cliente = new Cliente(cuentaCliente.getNombreTitular(), numeroCuenta);
        cliente.setCuenta(cuentaCliente);
        String opcion;
        do {
            System.out.println("\nOpciones:");
            System.out.println("1. Consignar");
            System.out.println("2. Retirar");
            System.out.println("3. Transferir");
            System.out.println("4. Ver historial");
            System.out.println("5. Ver saldo");
            System.out.println("6. Salir");

            System.out.print("Ingrese una opcion: ");
            opcion = scanner.next();
            
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
                case "5" -> cliente.getCuenta().mostrarSaldo();
                case "6" -> System.out.println("Gracias por usar nuestros servicios!");
                default -> System.out.println("Opción invalida.");
            }
        } while (!opcion.equals("6"));
    }
}
    
