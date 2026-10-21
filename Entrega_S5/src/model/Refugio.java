package model;

public class Refugio {

    private Animal [] animales;
    private double precioAlimentos;

    public Refugio () {
        this.animales = null;
        this.precioAlimentos = 3.0;
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
