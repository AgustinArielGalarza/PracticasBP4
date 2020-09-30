package mockito.autos;

public class Sudministros {

    private int nafta;
    private int bateria;

    public Sudministros(int nafta, int bateria){
        this.bateria = bateria;
        this.nafta = nafta;
    }

    public int getNafta() {
        return nafta;
    }

    public void setNafta(int nafta) {
        this.nafta = nafta;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }
}
