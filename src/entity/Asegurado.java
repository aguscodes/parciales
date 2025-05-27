package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Asegurado {
    private String nombreCompleto;
    private int dni;
    private String eMail;
    private String celu;
    private String plan;
    private LocalDateTime lastPago;

    public Asegurado(String nombreCompleto, int dni, String eMail, String celu, String plan, LocalDateTime lastPago){
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.eMail = eMail;
        this.celu = celu;
        this.plan = plan;
        this.lastPago = lastPago;
    }

    public LocalDateTime getLastPago() {
        return lastPago;
    }
}
