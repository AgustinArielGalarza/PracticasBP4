package mockito.autos;

public class Encender {

    public VerificaSudministros verificaSudministros;
    public boolean prendio;

    public Encender(VerificaSudministros verificaSudministros){
        this.verificaSudministros = verificaSudministros;
        prendio = false;
    }

    public void darArranque(Sudministros sudministros){
        verificaSudministros.estado(sudministros, new Message() {
            @Override
            public void Encender(String combustionPerfecta) {
                System.out.println("Motor Arranco!");
                prendio = true;
            }

            @Override
            public void Fallar(String combustionInsuficiente) {
                System.out.println("Motor fallo!");
                prendio = false;
            }
        });
    }
}
