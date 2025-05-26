package hospital;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Hospital {
    String nombre;
    Map<Integer, Profesional> medicos;
    Map<Integer, Paciente> pacientes;
    List<Receta> recetas;



    public Hospital(String nombre) {
        this.nombre = nombre;
        this.medicos = new HashMap<>();
        this.pacientes = new HashMap<>();
        this.recetas = new ArrayList<>();
    }

    public Profesional registrarProfesional(String nombre, int matricula) {
        // Verificamos que no exista

        if (medicos.containsKey(matricula)) {
             throw new RuntimeException("El Profesional ya está registrado.");
         
        }
        // Si no existe, lo creamos y lo agregamos al diccionario
        Profesional nuevo = new Profesional(nombre, matricula);
        medicos.put(matricula, nuevo);
        return nuevo;
    }
    public Paciente registrarPaciente(String nombre, int DNI) {
        // Verificamos que no exista
        if (pacientes.containsKey(DNI)) {
             throw new RuntimeException("El Paciente ya está registrado.");
         
        }
        // Si no existe, lo creamos y lo agregamos al diccionario
        Paciente nuevo = new Paciente(nombre, DNI);
        pacientes.put(DNI, nuevo);
        return nuevo;
    }

    public Receta cargarReceta(Profesional medico, Paciente paciente, Estudio[] estudios) {
        // Verificamos que el paciente y el profesional existan
        if (!pacientes.containsKey(paciente.getDNI())) {
            throw new RuntimeException("El Paciente no está registrado.");
        }
        if (!medicos.containsKey(medico.getMatricula())) {
            throw new RuntimeException("El Profesional no está registrado.");
        }

        Receta nueva = new Receta(paciente, medico, estudios);
        recetas.add(nueva);
        return nueva;
        
    }

    public void procesar(Receta receta) {
        for (Receta r : recetas) {
            if (r.getId() == receta.getId()) {
                r.procesar();
                System.out.println("Receta procesada: " + r.getId());
                return;
            }
        }   
    }
    public void mostrarRecetas() {
        for (Receta r : recetas) {
            System.out.println("Receta: " + r.getId() + ", Paciente: " + r.getPaciente().getNombre() + ", Médico: " + r.getMedico().getNombre() + ", Estado: " + r.getEstaProcesada());
            for (Estudio e : r.getEstudios()) {
                System.out.println("  Estudio: " + e);
            }
        }
    }

    public void mostrarRecetasProcesadas() {
        for (Receta r : recetas) {
            if (r.getEstaProcesada().equals("PROCESADA")) {
                System.out.println("Receta: " + r.getId() + ", Paciente: " + r.getPaciente().getNombre() + ", Médico: " + r.getMedico().getNombre());
                for (Estudio e : r.getEstudios()) {
                    System.out.println("  Estudio: " + e.getNombre() + e.describirEstudio());
                }
            }
        }
    }

    public void mostrarPacientesConEstudios(int cantidadMinima) {
    for (Paciente p : pacientes.values()) {
        int contador = 0;
        for (Receta r : recetas) {
            if (r.getPaciente().getDNI() == p.getDNI() && r.getEstaProcesada().equals("PROCESADA")) {
                contador += r.getEstudios().length;
            }
        }
        if (contador >= cantidadMinima) {
            System.out.println("Paciente: " + p.getNombre() + ", DNI: " + p.getDNI() +
                ", Estudios realizados: " + contador);
        }
    }
}





}


    
   


    

    

