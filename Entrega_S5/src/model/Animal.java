package model;

public class Animal {

    private Cuidador cuidador;
    private String nombre;
    private String especie;
    private double peso;
    private double consumo;

    public Animal (Cuidador cuidador, String nombre, String especie, double peso, double consumo) {
        this.cuidador = cuidador;
        this.nombre = nombre;
        this.especie = especie;
        this.peso = peso;
        this.consumo = consumo;
    }

// Calcola il costo giornaliero per il cibo per animale
    public double calcularCosteDiario (double precioAlimentos) {
        return consumo * precioAlimentos;
    }

    public Cuidador getCuidador () {
        return cuidador;
    }
    public void setCuidador (Cuidador cuidador) {
        this.cuidador = cuidador;
    }

    public String getNombre () {
        return nombre;
    }
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie () {
        return especie;
    }
    public void setEspecie (String especie) {
        this.especie = especie;
    }

    public double getPeso () {
        return peso;
    }
    public void setPeso (double peso) {
        this.peso = peso;
    }

    public double getConsumo () {
        return consumo;
    }
    public void setConsumo (double consumo) {
        this.consumo = consumo;
    }

    
}
