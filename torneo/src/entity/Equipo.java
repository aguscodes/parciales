package entity;

public class Equipo {
    private String nombre;
    private int cantidadFans;

    public Equipo(String nombre, int cantidadFans){
        this.nombre = nombre;
        this.cantidadFans = cantidadFans;
    }

    public String getNombre() {
        return nombre;
    }
}
