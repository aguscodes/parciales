package entity;

import java.time.LocalDateTime;

public class Solicitud {
    private Asegurado cliente;
    private Prestador prestador;
    private String tarea;
    private LocalDateTime horaAtencion;
    public static String estado = "ASIGNADA";
    public static LocalDateTime horaHecha;

    public Solicitud(Asegurado cliente, String  tarea){
        this.cliente = cliente;
        this.tarea = tarea;
    }
    public static void procesar(){
        estado = "EN PROCESO";
        horaHecha = LocalDateTime.now();
    }

    public static void realizar(){
        estado = "REALIZADA";
        horaHecha = LocalDateTime.now();
    }

    public static void rechazar(){
        estado = "RECHAZADA";
        horaHecha = LocalDateTime.now();
    }
    }


