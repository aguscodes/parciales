package hospital;

public abstract class Estudio {
    
    public boolean realizado = false;

    public void hacerEstudio() {
        this.realizado = true;
    }

    public abstract String getNombre() ;
    

    public abstract String describirEstudio();
    }

    

    


