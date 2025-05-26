package hotelCalifornia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Reserva {
    private Cliente cliente;
    private LocalDate checkin;
    private LocalDate checkout;
    private static int montoNoche;
    private Habitacion habitacion;

    public Reserva(Habitacion habitacion, LocalDate checkin, LocalDate checkout, Cliente cliente){
        this.checkin = checkin;
        this.checkout = checkout;
        this.habitacion = habitacion;
        this.cliente = cliente;
    }
    //cuantas noches se queda una persona
    public long getCantidadNoches() {
        return ChronoUnit.DAYS.between(checkin, checkout);
    }
    //preciopornoche
    public int getMonto() {
        return (int) (getCantidadNoches() * montoNoche);
    }
    //setter
    public static void setMontoNoche(int montoNoche) {
        Reserva.montoNoche = montoNoche;
    }


    //getters no se si todos van a ser utiles por ahora
    public Habitacion getHabitacion(){
        return habitacion;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
