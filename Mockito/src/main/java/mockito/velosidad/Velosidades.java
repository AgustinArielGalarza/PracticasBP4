package mockito.velosidad;

public class Velosidades {

    private int velosidad;
    private int limite;

    public Velosidades(int velosidad, int limite){
        this.velosidad = velosidad;
        this.limite = limite;
    }

    public int getVelosidad() {
        return velosidad;
    }

    public void setVelosidad(int velosidad) {
        this.velosidad = velosidad;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
}
