package hospital;



public class Receta {
    int id;
    Paciente paciente;
    Profesional medico;
    String estaProcesada = "PENDIENTE";
    Estudio[] estudios;

    public Receta(Paciente paciente, Profesional medico, Estudio[] estudios) {
        this.paciente = paciente;
        this.estudios = estudios;
        this.medico = medico;
    }

    public int getId() {
        return id;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public Profesional getMedico() {
        return medico;
    }
    public String getEstaProcesada() {
        return estaProcesada;
    }
    public Estudio[] getEstudios() {
        return estudios;
    }


    public void procesar() {
        
        estaProcesada = "PROCESADA";
        for (Estudio e : estudios){
            e.hacerEstudio();
        }


    
    }




    


}
