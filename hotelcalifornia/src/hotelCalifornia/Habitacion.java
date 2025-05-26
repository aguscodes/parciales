package hotelCalifornia;
public class Habitacion {
    int numeroHab;
    int capacidad;

    public Habitacion(int numeroHab, int capacidad){
        this.numeroHab = numeroHab;
        this.capacidad = capacidad;
    }


    public int getCapacidad() {
        return capacidad;
    }

    public int getNumeroHab() {
        return numeroHab;
    }
}
