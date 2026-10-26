import model.Animal;
import model.Cuidador;
import model.Refugio;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // Creazione dello scanner
        Scanner scanner = new Scanner(System.in);

        // Creazione del rifugio
        Refugio refugio = new Refugio();

        // Menù interattivo
        int opcion;
        do {
            System.out.printf("|---------------------------------------------------|\n");
            System.out.printf("| GESTIÓN DEL REFUGIO                               |\n");
            System.out.printf("|---------------------------------------------------|\n");
            System.out.printf("| 1) Crear un nuevo registro de animales            |\n");
            System.out.printf("| 2) Configurar el precio del alimento por kg       |\n");
            System.out.printf("| 3) Añadir un nuevo animal al refugio              |\n");
            System.out.printf("| 4) Mostrar información de los animales            |\n");
            System.out.printf("| 5) Salir (se borrará toda la información)         |\n");
            System.out.printf("|---------------------------------------------------|\n");
            System.out.printf("Seleccione una opción (1-5): ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: System.out.println("Has selecionado opcion 1\n");
                        System.out.println("Escribir numero registro: ");
                        int numRegistro = scanner.nextInt();

                        if (numRegistro > 0) {
                            refugio.crearRegistro(numRegistro);
                            System.out.println("Registro creado correctamente\n");
                        }
                        else {
                            System.err.println("Error: debe ser mayor que cero");
                        }
                        break;
                case 2: System.out.println("Has selecionado opcion 2\n");
                        System.out.println("Escribir precio alimento: ");
                        double precioAlimento = scanner.nextDouble();

                        if (precioAlimento > 0.0) {
                            refugio.setPrecioAlimentos(precioAlimento);
                        }
                        else {
                            System.err.println("Error: debe ser mayor que cero");
                        }
                        break;
                case 3: System.out.println("Has selecionado opcion 3\n");
                        // Verifica che il registro esiste
                        if (refugio.getAnimales() == null) {
                            System.err.println("Error: primero debes crear un registro");
                            break;
                        }

                        // Verifica che c'è spazio disponibile
                        boolean hayEspacio = false;

                        for (int i = 0; i < refugio.getAnimales().length; i++) {
                            if (refugio.getAnimales()[i] == null) {
                                hayEspacio = true;
                                break;
                            }
                        }

                        if (!hayEspacio) {
                            System.err.println("Error: el refugio esta lleno");
                            break;
                        }

                        // Dati del cuidador
                        scanner.nextLine(); // Limpiar el salto de linea pendiente

                        System.out.println("Nombre del cuidador:");
                        String nombreCuidador = scanner.nextLine();

                        System.out.println("Apellidos del cuidador:");
                        String apellidosCuidador = scanner.nextLine();

                        System.out.println("Tiene formacion en cuidado animal? (true/false):");
                        boolean formacion = scanner.nextBoolean();

                        Cuidador cuidador = new Cuidador(nombreCuidador, apellidosCuidador, formacion);

                        // Dati degli animal
                        scanner.nextLine();

                        System.out.println("Nombre del animal:");
                        String nombreAnimal = scanner.nextLine();

                        System.out.println("Especie del animal:");
                        String especie = scanner.nextLine();

                        System.out.println("Peso del animal (kg):");
                        double peso = scanner.nextDouble();

                        System.out.println("Consumo diario de alimento (kg):");
                        double consumo = scanner.nextDouble();

                        // Valida peso e consumo
                        if (peso <= 0 || consumo <= 0) {
                            System.err.println("Error: el peso y el consumo deben ser mayores que cero");
                            break;
                        }

                        // Crea animal
                        Animal animal = new Animal(
                            cuidador, nombreAnimal, especie, peso, consumo
                        );

                        // Inseerire animale nel rifugio
                        refugio.anadirAnimal(animal);

                        System.out.println("Animal registrado correctamente");
                        break;

                case 4:
                    System.out.println("Has seleccionado opcion 4");

                    // Vede se esiste il registro
                    if (refugio.getAnimales() == null) {
                        System.err.println("Error: primero debes crear un registro");
                        break;
                    }

                    // Vede se ci stanno animali registrati
                    int cantidadAnimales = 0;

                    for (Animal a : refugio.getAnimales()) {
                        if (a != null) {
                            cantidadAnimales++;
                        }
                    }

                    if (cantidadAnimales == 0) {
                        System.out.println("El registro esta vacio");
                        break;
                    }

                    // Roba di tabella
                    System.out.printf("|----------------------------------------------------------------------------------------------------|%n");
                    System.out.printf("| ANIMALES DEL REFUGIO                                                                               |%n");
                    System.out.printf("|----------------------------------------------------------------------------------------------------|%n");

                    System.out.printf("| %-10s | %-10s | %-20s | %-9s | %9s | %10s | %9s |%n",
                            "Nombre", "Especie", "Cuidador", "Formacion",
                            "Peso (kg)", "Consumo kg", "Coste EUR");

                    System.out.printf("|----------------------------------------------------------------------------------------------------|%n");

                    // Mostra animali del registro
                    for (Animal a : refugio.getAnimales()) {

                        if (a != null) {

                            Cuidador c = a.getCuidador();

                            String nombreCompleto = c.getNombre() + " " + c.getApellido();

                            String formacionTexto = c.getFormacion() ? "Si" : "No";

                            double coste = a.calcularCosteDiario(refugio.getPrecioAlimentos());

                            System.out.printf("| %-10s | %-10s | %-20s | %-9s | %9.2f | %10.2f | %9.2f |%n",
                                            a.getNombre(), a.getEspecie(), nombreCompleto, formacionTexto, a.getPeso(), a.getConsumo(), coste);
                        }
                    }

                    System.out.printf("|----------------------------------------------------------------------------------------------------|%n");
                    System.out.printf("Coste diario total de alimentacion: %.2f EUR%n", refugio.calcularCosteTotal());
                    System.out.printf("Peso medio de los animales: %.2f kg%n", refugio.calcularPesoMedio());

                    break;

                case 5: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opcion no valida"); break;
            }
        }while (opcion != 5);
    scanner.close();
    }
}

