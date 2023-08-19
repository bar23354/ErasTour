/*
 * Clase Roberto y Linda
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProgramaPrincipal {
    private Comprador compradorActual;
    public static void main(String[] args) {
        ArrayList<Localidad> localidades = new ArrayList<>();
        localidades.add(new Localidad("Localidad 1", 100, 20));
        localidades.add(new Localidad("Localidad 5", 500, 20));
        localidades.add(new Localidad("Localidad 10", 1000, 20));

        Comprador compradorActual = null;
        ArrayList<Comprador> compradores = new ArrayList<>();
        VentaBoletos ventaBoletos = new VentaBoletos(localidades);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Código Especial");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la línea en blanco después de leer un número

            switch (opcion) {
                case 1:
                    // Nuevo comprador
                    System.out.print("Nombre del comprador: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Email del comprador: ");
                    String email = scanner.nextLine();
                    System.out.print("Cantidad de boletos a comprar: ");
                    int boletosDeseados = scanner.nextInt();
                    System.out.print("Presupuesto máximo: ");
                    int presupuesto = scanner.nextInt();
                    compradorActual = new Comprador(nombre, email, boletosDeseados, presupuesto);
                    compradores.add(compradorActual);
                    System.out.println("Nuevo comprador registrado.");
                    break;

                case 2:
                    // Nueva solicitud de boletos
                    if (compradorActual == null) {
                        System.out.println("Debe registrar un comprador primero.");
                    } else {
                        ventaBoletos.venderBoletos(compradorActual);
                    }
                    break;

                case 3:
                    // Consultar disponibilidad total
                    ventaBoletos.consultarDisponibilidadTotal();
                    break;

                case 4:
                    // Consultar disponibilidad individual
                    if (compradorActual == null) {
                        System.out.println("Debe registrar un comprador primero.");
                    } else {
                        System.out.print("Ingrese el nombre de la localidad: ");
                        String localidadNombre = scanner.nextLine();
                        ventaBoletos.consultarDisponibilidadIndividual(localidadNombre);
                    }
                    break;

                case 5:
                    // Reporte de caja
                    ventaBoletos.reporteDeCaja();
                    break;

                    case 6:
                    // Código Especial
                    if (compradorActual != null) {
                        System.out.print("Ingrese el código especial: ");
                        int codigoEspecial = scanner.nextInt();
                        ventaBoletos.venderBoletosEspeciales(codigoEspecial);
                    } else {
                        System.out.println("Debe registrar un comprador primero.");
                    }
                    break;
                

                case 7:
                    // Salir
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        scanner.close();
    }
}