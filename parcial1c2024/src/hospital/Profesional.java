package hospital;

public class Profesional {
    String nombre;
    int matricula;

    public Profesional(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
    }
    public String getNombre() {
        return nombre;
    }   
    public int getMatricula() {
        return matricula;
    }

    public String toString() {
        return nombre + " [" + matricula + "]";
    }


}
