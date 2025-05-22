import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayList<Historial> historiales = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean repetir = true;
        do {
            System.out.println("=======================================");
            System.out.println(" Bienvenidos a Veterinaria Estrella");
            System.out.println("1. Registro de datos:");
            System.out.println("2. Reportes Generales");
            System.out.println("3. Todas las Historias de las mascotas");
            System.out.println("4. Salir");
            System.out.println("=======================================");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                        Historial historial = new Historial();
                        System.out.print("Nombre y apellido del cliente: ");
                        String nombre = scanner.nextLine();

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
                        Cliente cliente = new Cliente( nombre, numeroDocumento, celular, mascota);

                        clientes.add(cliente);
                        historial.setCliente(cliente);
                        historiales.add(historial);

                        historial.getEstados().push("Exámenes");

                        Stack<String> estados = new Stack<>();
                        estados.push("Examenes");

                        System.out.print("¿Según los examenes, la mascota es apta para cirugía? (s/n): ");
                        String apto = scanner.nextLine().trim();
                        historial.aptoCirugia(apto);
                        historiales.add(historial);

                        boolean continuar = true;
                        while (continuar) {
                            System.out.println("\n--- Menú ---");
                            System.out.println("1. Ver estado actual");
                            System.out.println("2. Agregar nuevo estado");
                            System.out.println("3. Deshacer último estado");
                            System.out.println("4. Ver historial completo");
                            System.out.println("5. Salir");
                            System.out.print("Elija una opción: ");
                            int opcionEstado = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcionEstado) {
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
                                                    "7. Dado de alta\n" +
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
                        historiales.add(historial);
                    }
                    break;
                case 2:
                    boolean reportes = true;
                    while (reportes) {
                        System.out.println("1. Ver cuántas mascotas fueron esterilizadas");
                        System.out.println("2. Ver cuántas mascotas fallecieron");
                        System.out.println("3. Ver cuántas mascotas no fueron aptas para cirugía");
                        System.out.println("4. Salir de los reportes");
                        System.out.println("Elige una opción: ");
                        int opcionReporte = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcionReporte) {
                            case 1:
                                long esterilizadas = historiales.stream()
                                        .filter(h -> h.verEstadoActual().equalsIgnoreCase("Operado"))
                                        .count();
                                System.out.println("Mascotas esterilizadas: " + esterilizadas);
                                break;
                            case 2:
                                long fallecidas = historiales.stream()
                                        .filter(h -> h.verEstadoActual().equalsIgnoreCase("Fallecido"))
                                        .count();
                                System.out.println("Mascotas fallecidas: " + fallecidas);
                                break;
                            case 3:
                                long noAptos = historiales.stream()
                                        .filter(h -> !h.isApto())
                                        .count();
                                System.out.println("Mascotas no aptas para cirugía: " + noAptos);
                                break;
                            case 4:
                                reportes = false;
                                System.out.println("Saliendo de los reportes...");
                                System.out.println("=======================================");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                    }
                    break;
                case 3:
                    for (Historial h : historiales) {
                        System.out.println("Cliente: " + h.getCliente().getNombre());
                        System.out.println("Mascota: " + h.getCliente().getMascota().getNombre());
                        System.out.println("Estados:");
                        for (String estado : h.getEstados()) {
                            System.out.println("- " + estado);
                        }

                    }
                    break;
                case 4:
                    repetir = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (repetir);

    }
}