package hotelCalifornia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private static String nombre;
    private String direccion;
    private List<Reserva> reservas;
    private Map<Integer, Habitacion> habitaciones;
    private int numeroHabitacion;
    //private LocalDate checkin;
    //private LocalDate checkout;
    // constructor
    public Hotel(String nombre, String direccion){
        this.direccion = direccion;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
        this.habitaciones = new HashMap<>();
    }
    public void definirPrecioNoche(int nuevoPrecio) {
        Reserva.setMontoNoche(nuevoPrecio);
    }
    public Habitacion agregarHabitacion(int capacidad){
        int numeroHab = numeroHabitacion;
        if(habitaciones.containsKey(numeroHab)){
            throw new RuntimeException("Ya existe esa habitación");
        }
        // Si no existe:
        Habitacion nueva = new Habitacion(numeroHab, capacidad);
        habitaciones.put(numeroHab, nueva);
        numeroHabitacion++;
        return nueva;
    }
    private boolean fechasSeSuperponen(LocalDate checkin1, LocalDate checkout1, LocalDate checkin2, LocalDate checkout2) {
        return !(checkout1.isEqual(checkin2) || checkout1.isBefore(checkin2) ||
                checkout2.isEqual(checkin1) || checkout2.isBefore(checkin1));
    }

    public void reservarHabitacion(Cliente cliente, LocalDate checkin, LocalDate checkout, int capacidad) {
        List<Habitacion> disponibles = obtenerHabitacionesDisponibles(checkin, checkout, capacidad);

        if (disponibles.isEmpty()) {
            System.out.println("No hay habitaciones disponibles para esa capacidad y fechas.");
            return;
        }

        Habitacion habParaReservar = disponibles.get(0);
        Reserva nuevaReserva = new Reserva(habParaReservar, checkin, checkout, cliente);
        reservas.add(nuevaReserva);

        System.out.println("Reserva realizada para " + cliente.getNombre() +
                " en habitación #" + habParaReservar.getNumeroHab());
    }
    public void consultarDisponibilidad(LocalDate checkin, LocalDate checkout) {
        System.out.println("Habitaciones disponibles entre " + checkin + " y " + checkout + ":");

        List<Habitacion> disponibles = obtenerHabitacionesDisponibles(checkin, checkout);

        for (Habitacion hab : disponibles) {
            System.out.println("Habitación #" + hab.getNumeroHab() +
                    " - Capacidad: " + hab.getCapacidad() + " personas");
        }
    }
    public List<Habitacion> obtenerHabitacionesDisponibles(LocalDate checkin, LocalDate checkout) {
        List<Habitacion> disponibles = new ArrayList<>();

        for (Habitacion hab : habitaciones.values()) {
            boolean ocupada = false;

            for (Reserva r : reservas) {
                if (r.getHabitacion().equals(hab) &&
                        fechasSeSuperponen(checkin, checkout, r.getCheckin(), r.getCheckout())) {
                    ocupada = true;
                    break;
                }
            }

            if (!ocupada) {
                disponibles.add(hab);
            }
        }

        return disponibles;
    }
    public List<Habitacion> obtenerHabitacionesDisponibles(LocalDate checkin, LocalDate checkout, int capacidadMinima) {
        List<Habitacion> todasDisponibles = obtenerHabitacionesDisponibles(checkin, checkout);

        List<Habitacion> filtradas = new ArrayList<>();
        for (Habitacion hab : todasDisponibles) {
            if (hab.getCapacidad() >= capacidadMinima) {
                filtradas.add(hab);
            }
        }

        return filtradas;
    }



    public String getNombre() {
        return nombre;
    }

    public void mostrarReservasHotel() {
        System.out.println("Reservas del hotel " + nombre + ":");

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas realizadas.");
            return;
        }

        for (Reserva r : reservas) {
            Habitacion hab = r.getHabitacion();
            System.out.println("Habitación #" + hab.getNumeroHab() +
                    " - Capacidad: " + hab.getCapacidad() + " personas" +
                    " | Cliente: " + r.getCliente().getNombre() +
                    " | Checkin: " + r.getCheckin() +
                    " | Checkout: " + r.getCheckout());
        }
    }









/*
    public void consultarDisponibilidad(LocalDate checkin, LocalDate checkout) {
        System.out.println("Habitaciones disponibles entre " + checkin + " y " + checkout + ":");

        // verifico cada habitación en el hotel
        for (Habitacion hab : habitaciones.values()) {
            boolean ocupada = false;

            // reviso si alguna reserva coincide con esta habitación y las fechas
            for (Reserva r : reservas) {
                if (r.getHabitacion().equals(hab) &&  // si la reserva es para esta habitación
                        checkin.isBefore(r.getCheckout()) &&
                        checkout.isAfter(r.getCheckin())) {
                    ocupada = true;
                    break;
                }
            }

            // si no está ocupada
            if (!ocupada) {
                System.out.println("Habitación #" + hab.getNumeroHab() +
                        " - Capacidad: " + hab.getCapacidad() + " personas");
            }
        }
    }
    public void reservarHabitacion(String cliente, LocalDate checkin, LocalDate checkout, int capacidad){
        for(Habitacion hab : habitaciones.values()){
            if(hab.getCapacidad() >= capacidad){
                boolean habOcupada = false;
                for (Reserva r : reservas) {
                    if (r.getHabitacion().equals(hab) &&  // si la reserva es para esta habitación
                            checkin.isBefore(r.getCheckout()) &&
                            checkout.isAfter(r.getCheckin())) {
                        habOcupada = true;
                        break;
                    }
                }
                if(!habOcupada){
                    Cliente c = new Cliente(cliente);
                    Reserva x = new Reserva(hab, checkin, checkout, c);
                    reservas.add(x);
                    return;
                }
                }
            }


    }

    Hotel tiene que






     public mostrarReservasHotel();

     */


}
