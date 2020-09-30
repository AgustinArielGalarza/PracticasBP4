package mockito.autos;

public class VerificaSudministros {

    public void estado(Sudministros auto, Message message) {
        if (check(auto)){
            message.Encender("Sudministors llenos");
        }else{
            message.Fallar("Faltan sudministors");
        }

    }
        public boolean check (Sudministros auto) {
            if (auto.getBateria() > 40 && auto.getNafta() > 70) {
                return true;
            } else {
                return false;
            }
        }

}
