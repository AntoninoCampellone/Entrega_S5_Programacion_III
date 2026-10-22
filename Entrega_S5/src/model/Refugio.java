package model;

public class Refugio {

    private Animal [] animales;
    private double precioAlimentos;

    public Refugio () {
        this.animales = null;
        this.precioAlimentos = 3.0;
    }

    public void crearRegistro (int capacidad) {
        if (capacidad >= 1) {
            this.animales = new Animal[capacidad];
        }
        else {
            System.err.println ("Numero errado");
        }
    }

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

    public Animal [] getAnimales () {
        return animales;
    }
    public void setAnimales (Animal [] animales) {
        this.animales = animales;
    }

    public double GetPrecioAlimentos () {
        return precioAlimentos;
    }
    public void setPrecioAlimentos (double precioAlimentos) {
        this.precioAlimentos = precioAlimentos;
    }
    
}
