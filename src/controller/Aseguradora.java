package controller;

import entity.Asegurado;
import entity.Prestador;
import entity.Solicitud;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

public class Aseguradora {
    public String nombre;
    public Map<Prestador, Integer> prestadores; // donde int es la cantidad de pedidos
    public Map<Asegurado, Integer> asegurados; // donde int es la cantidad de solicitudes
    public Map<String, Solicitud> solicitudes;
    public LocalDateTime tiempodeEspera;
    public static List<Integer> puntuaciones;
    public  static List<String> rechazos;

    public Aseguradora(String nombre) {
        this.nombre = nombre;
        this.prestadores = new HashMap<>();
        this.asegurados = new HashMap<>();
    }

    public Prestador registrarPrestador(String nombre, Long cuit, String mail, String tel, List<String> servicios) {
        Prestador p = new Prestador(cuit, nombre, mail, tel, servicios);
        prestadores.put(p, 0);
        return p;
    }

    public Asegurado registrarAsegurado(String nombre, int dni, String mail, String celu, String plan, LocalDateTime pago) {

        Asegurado a = new Asegurado(nombre, dni, mail, celu, plan, pago);
        asegurados.put(a, 0);
        return a;

    }

    public Solicitud solicitar(Asegurado a, String servicio) {
        boolean moroso = isMoroso(a);
        if (moroso == true) {
            throw new RuntimeException("Cliente moroso: debe 3 meses de pago");
        } else ;
        // buscar prestador con menos pedidos
        java.util.Collection<Integer> values = prestadores.values();
        // Encuentra la final mas corta y el key
        int filacorta = Collections.min(values);
        // calcular hora estimada


        Solicitud s = new Solicitud(a, servicio);
        return s;
    }

    public void llegoAlSitioDeAtencion(Solicitud s){
        s.procesar();

    }
    public void atencionRealizada(Solicitud s, int p){
        s.realizar();
        puntuaciones.add(p);
    }
    public void solicitudRechazada(Solicitud s, String razon){
        s.rechazar();
        rechazos.add(razon);
    }

    public List

    public boolean isMoroso(Asegurado a){
        if(a.getLastPago().isBefore(LocalDateTime.now().minusMonths(3))){
            return true;
        }
        return false;
    }




}


