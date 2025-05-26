package hospital;

public class RayosX extends Estudio {
    String zona;
    
    // Constructor
    public RayosX(String zona) {
        this.zona = zona;    
    }

    //getter para la zona
    public String getZona() {
        return zona;
    } 


    @Override
    public String getNombre() {
        return "Rayos X";
    }

    @Override
    public String describirEstudio() {
        return " de " + zona;
    }


}
