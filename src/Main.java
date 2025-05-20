import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Bienvenidos a Veterinaria Estrella");
        System.out.println("=======================================");
        System.out.println("Ingrese los datos del cliente y su mascota:");

        int cont = 0;
        for (int i = 1; i <= 1; i++) {
            Historial historial = new Historial();
            System.out.println("\nRegistro del Cliente #" + i);

            int clienteId = i;

            System.out.print("Nombre del cliente: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingresa tu apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Ingresa tu número de documento: ");
            String numeroDocumento = scanner.nextLine();

            System.out.print("Ingresa tu celular: ");
            String celular = scanner.nextLine();

            // Datos de la mascota
            System.out.print("Ingresa el nombre de tu mascota: ");
            String nombreMascota = scanner.nextLine();

            System.out.print("Ingresa la raza de tu mascota: ");
            String raza = scanner.nextLine();

            System.out.print("Ingresa la genero de tu mascota: ");
            String genero = scanner.nextLine();

            System.out.print("Ingresa el tipo de especie de tu mascota: ");
            String tipoEspecie = scanner.nextLine();

            System.out.print("Ingresa la edad de tu mascota en meses: ");
            int edad = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingresa el peso de tu mascota en kilos: ");
            int peso = Integer.parseInt(scanner.nextLine());

            Mascota mascota = new Mascota(nombreMascota, raza, genero, tipoEspecie, edad, peso);
            Cliente cliente = new Cliente(clienteId, nombre, apellido, numeroDocumento, celular, mascota);

            clientes.add(cliente);

            Historial historia = new Historial();
            historial.setCliente(cliente);

            historial.getEstados().push("Exámenes");

            Stack<String> estados = new Stack<>();
            estados.push("Examenes");
//System.out.print(clientes.toString());
            System.out.print("¿Según los examenes, la mascota es apta para cirugía? (s/n): ");
            String respuesta = scanner.nextLine();
            boolean apto = respuesta.equalsIgnoreCase("s");

            historial.aptoCirugia(apto);
            boolean continuar = true;
            while (continuar) {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Ver estado actual");
                System.out.println("2. Agregar nuevo estado");
                System.out.println("3. Deshacer último estado");
                System.out.println("4. Ver historial completo");
                System.out.println("5. Salir");
                System.out.print("Elija una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                         System.out.println("Estado actual: " + historial.verEstadoActual());
                        break;
                    case 2:
                        System.out.print(
                                "1. En cirugía\n" +
                                "2. En observación\n" +
                                "3. Posoperatorio\n" +
                                "4. En la morgue\n" +
                                "5. Operado\n" +
                                "6. Fallecido\n" +
                                "7. Dado de alta\n"+
                                "8. Observaciones\n"
                        );
                        System.out.print("Ingrese el nuevo estado: ");
                        int nuevoEstado = Integer.parseInt(scanner.nextLine());
                        historial.agregarEstado(nuevoEstado);
                        System.out.println("Nuevo estado agregado.");
                        break;
                    case 3:
                        historial.deshacerEstado();
                        break;
                    case 4:
                        historial.mostrarHistorial();
                        break;
                    case 5:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }


            //Historial historia = new Historial(false, false, cliente, "HIST001", estados, 1L, false);
        }
    }
}