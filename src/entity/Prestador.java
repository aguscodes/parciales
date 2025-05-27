package entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Prestador {
    private long cuit;
    private String nombreCompleto;
    private String eMail;
    private String tel;
    List<String> servicios;
    private int fila;
    Map<String , Integer> duraciones;

    public Prestador(long cuit, String nombreCompleto, String eMail, String tel, List<String> servicios){
        this.cuit = cuit;
        this.nombreCompleto = nombreCompleto;
        this.eMail = eMail;
        this.tel = tel;
        this.servicios = servicios;
        this.fila = fila;
    }

    public int getFila() {
        return fila;
    }
}
