package hospital;

//import java.util.List;

public class Paciente {
    int DNI;
    String nombre;


    public Paciente(String nombre, int DNI) {
        this.DNI = DNI;
        this.nombre = nombre;
    }
    public int getDNI() {
        return DNI;
    }
    public String getNombre() {
        return nombre;
    }
    public String toString() {
        return nombre + " [" + DNI + "]";
    }
}
