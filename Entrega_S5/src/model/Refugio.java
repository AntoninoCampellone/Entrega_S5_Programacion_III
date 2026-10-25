package model;

public class Refugio {

    private Animal [] animales;
    private double precioAlimentos;

    public Refugio () {
        this.animales = null;
        this.precioAlimentos = 3.0;
    }

// Questo metodo qui sotto serve per creare un nuovo registro di animali
    public void crearRegistro (int capacidad) {
        if (capacidad >= 1) {
            this.animales = new Animal[capacidad];
        }
        else {
            System.err.println ("Numero errado");
        }
    }

// Questo metodo qui sotto aggiunge un animale alla lista
    public void anadirAnimal (Animal animal) {
        if (this.animales != null) {
            for (int i = 0; i < animales.length; i ++) {
                if (animales [i] == null) {
                    animales [i] = animal;
                    return;
                }
            }
            System.out.println("El refugio está lleno");
            // Sta cosa qua sopra viene scritta solo se non trova nessuno spazio libero nell'array, perchè quando inserisce il nuovo animale si esegue anche il "return" cioè si ferma sto metodo
        } else {
            System.out.println("Primero debes crear un registro");
        }
    }

// Calcola il costo totale giornaliero di un rifugio
    public double calcularCosteTotal () {
        double costeTotal = 0.0;
        if (animales != null) {
            for (int i = 0; i < animales.length; i ++) {
                if (animales [i] != null) {
                    costeTotal += animales[i].calcularCosteDiario(precioAlimentos);
                }
            }
        }
        return costeTotal;
    }

// Questo metodo calcola il peso medio degli animali in un rifugio
    public double calcularPesoMedio () {
        double pesoMedio = 0.0;
        int j = 0;
        if (animales != null) {
            for (int i = 0; i < animales.length; i ++) {
                if (animales [i] != null) {
                    j ++;
                    pesoMedio += animales[i].getPeso();
                }
            }
            if (j > 0) {
                pesoMedio = pesoMedio / j;
            }
        }
        return pesoMedio;
    }

    public Animal [] getAnimales () {
        return animales;
    }
    public void setAnimales (Animal [] animales) {
        this.animales = animales;
    }

    public double GetPrecioAlimentos () {
        return precioAlimentos;
    }
// Modifica il prezzo del cibo solo se è superiore a 0
    public void setPrecioAlimentos (double precioAlimentos) {
        if (precioAlimentos > 0) {
            this.precioAlimentos = precioAlimentos;
        }
    }
    
}
