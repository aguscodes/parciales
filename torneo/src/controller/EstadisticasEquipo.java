package controller;

public class EstadisticasEquipo {
    int jugados = 0;
    int puntos = 0;
    int ganados = 0;
    int empatados = 0;
    int perdidos = 0;
    int golesAFavor = 0;
    int golesEnContra = 0;

    public int diferenciaGol() {
        return golesAFavor - golesEnContra;
    }
}
