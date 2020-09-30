package mockito.velosidad;

public class Carretera {

    private VerificaLimites verificaLimites;
    public boolean check;

    public Carretera(VerificaLimites verificaLimites){
        this.verificaLimites = verificaLimites;
        this.check = false;
    }

    public boolean manejar(Velosidades vel){
        check = verificaLimites.deVelosidad(vel);
        return check;
    }

}
