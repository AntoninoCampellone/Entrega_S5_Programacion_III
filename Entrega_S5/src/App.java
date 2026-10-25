import model.Animal;
import model.Cuidador;
import model.Refugio;

public class App {
    public static void main(String[] args) {

        // Creazione del cuidador
        Cuidador cuidador1 = new Cuidador("Mario", "Rossi", true);

        // Creazione dell'animale
        Animal animal1 = new Animal(
            cuidador1, "Luna", "Gato", 4.5, 0.15
        );

        // Creazione del rifugio
        Refugio refugio = new Refugio();

        // Creazione del registro con capacità 5
        refugio.crearRegistro(5);

        // Inserimento dell'animale
        refugio.anadirAnimal(animal1);

        // Visualizzazione dei risultati
        System.out.printf(
            "Coste diario total: %.2f EUR%n",
            refugio.calcularCosteTotal()
        );

        System.out.printf(
            "Peso medio: %.2f kg%n",
            refugio.calcularPesoMedio()
        );
    }
}

