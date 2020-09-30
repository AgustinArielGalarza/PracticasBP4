package mockito.velosidad;

public class VerificaLimites {

    public boolean deVelosidad(Velosidades velosidades) {
        if (check(velosidades)) {
            return true;
        } else {
            return false;
        }
    }


    public boolean check(Velosidades velosidad) {
        if (velosidad.getVelosidad() <= velosidad.getLimite()) {
            return true;
        } else {
            return false;
        }
    }
}