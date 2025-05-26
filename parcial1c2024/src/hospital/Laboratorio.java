package hospital;

public class Laboratorio extends Estudio {
    int items;

    public Laboratorio(int items) {
        this.items = items;
        
    }
    public int getItems() {
        return items;
    }
    
    @Override
    public String getNombre() {
        return "Laboratorio";
    }

    @Override
    public String describirEstudio() {
        return "Laboratorio de " + items + "items";
    }


}
