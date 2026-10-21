package model;

public class Cuidador {
    
    private String nombre;
    private String apellido;
    private boolean formacion;

    public Cuidador (String nombre, String apellido, boolean formacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.formacion = formacion;
    }

    public String getNombre () {
        return nombre;
    }
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getApellido () {
        return apellido;
    }
    public void setApellido (String apellido) {
        this.apellido = apellido;
    }

    public boolean getFormacion () {
        return formacion;
    }
    public void setFormcion (boolean formacion) {
        this.formacion = formacion;
    }

    

}
