package entity;

import java.time.LocalDate;

public class Partido {
    private LocalDate fecha;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;


    public Partido(LocalDate fecha, Equipo equipoLocal, Equipo equipoVisitante, int golesLocal, int golesVisitante) {
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;


    }


    @Override
    public String toString(){
        return "Fecha: " + fecha + ", "
                + equipoLocal.getNombre() + "(" + golesLocal + ")"
                + equipoVisitante.getNombre() + "(" + golesVisitante + ")";

    }


    public LocalDate getFecha() {
        return fecha;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }



}