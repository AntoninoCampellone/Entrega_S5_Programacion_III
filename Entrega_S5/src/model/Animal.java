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

    public String getNombre () {
        return especie;
    }
    public void setNombre (String especie) {
        this.especie = especie;
    }

    public float getPeso () {
        return peso;
    }
    public void setPeso (double peso) {
        this.peso = peso;
    }

    public float getConsumo () {
        return consumo;
    }
    public void setConsumo (double consumo) {
        this.consumo = consumo;
    }

    
}
