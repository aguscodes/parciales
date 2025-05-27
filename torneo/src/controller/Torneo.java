package controller;

import entity.Equipo;
import entity.Partido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Torneo {
    Map<String, Equipo> equipos;
    List<Partido> partidos;

    public Torneo() {
        this.equipos = new HashMap<>();
        this.partidos = new ArrayList<>();

    }


    public void cargarEquipo(String nombre, int fans) {
        Equipo equi = new Equipo(nombre, fans);
        equipos.put(nombre, equi);
    }

    public void cargarPartido(String local, String visitante, LocalDate fecha, int golloc, int golvis) {
        Equipo elocal = equipos.get(local);
        Equipo evisitante = equipos.get(visitante);
        if (elocal == null || evisitante == null) {
            throw new RuntimeException("hay equipos sin registrar");
        }
        Partido p = new Partido(fecha, elocal, evisitante, golloc, golvis);
        partidos.add(p);
    }

    public void mostrarPartidosFecha(LocalDate fecha) {
        for (Partido p : partidos) {
            if (fecha.equals(p.getFecha())) {
                System.out.println(p);
            }
        }

    }
    public void mostrarTabla() {
        Map<String, EstadisticasEquipo> tabla = new HashMap<>();


        for (String nombre : equipos.keySet()) {
            tabla.put(nombre, new EstadisticasEquipo());
        }

        // Recorremos los partidos
        for (Partido p : partidos) {
            String nomLocal = p.getEquipoLocal().getNombre();
            String nomVisitante = p.getEquipoVisitante().getNombre();

            EstadisticasEquipo statsLoc = tabla.get(nomLocal);
            EstadisticasEquipo statsVis = tabla.get(nomVisitante);

            statsLoc.jugados++;
            statsVis.jugados++;

            statsLoc.golesAFavor += p.getGolesLocal();
            statsLoc.golesEnContra += p.getGolesVisitante();

            statsVis.golesAFavor += p.getGolesVisitante();
            statsVis.golesEnContra += p.getGolesLocal();

            if (p.getGolesLocal() > p.getGolesVisitante()) {
                statsLoc.ganados++;
                statsLoc.puntos += 3;
                statsVis.perdidos++;
            } else if (p.getGolesLocal() < p.getGolesVisitante()) {
                statsVis.ganados++;
                statsVis.puntos += 3;
                statsLoc.perdidos++;
            } else {
                statsLoc.empatados++;
                statsVis.empatados++;
                statsLoc.puntos++;
                statsVis.puntos++;
            }
        }

        // Ordenar equipos
        List<Map.Entry<String, EstadisticasEquipo>> lista = new ArrayList<>(tabla.entrySet());
        lista.sort((e1, e2) -> {
            int cmp = Integer.compare(e2.getValue().puntos, e1.getValue().puntos);
            if (cmp == 0) {
                cmp = Integer.compare(e2.getValue().diferenciaGol(), e1.getValue().diferenciaGol());
            }
            return cmp;
        });

        // Mostrar tabla
        System.out.println("Equipo | Ju | Pu | Ga | Em | Pe | GF | GC | DG");
        for (Map.Entry<String, EstadisticasEquipo> entry : lista) {
            EstadisticasEquipo s = entry.getValue();
            System.out.printf("%s | %d | %d | %d | %d | %d | %d | %d | %d%n",
                    entry.getKey(), s.jugados, s.puntos, s.ganados, s.empatados,
                    s.perdidos, s.golesAFavor, s.golesEnContra, s.diferenciaGol());
        }
    }




}

