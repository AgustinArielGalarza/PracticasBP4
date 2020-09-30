package mockito;

import java.util.Queue;

public class ValidaUsr {

    public void login (String user, String password, Message message){
        if (checkLoguin(user, password)){
            message.Succes("Usuario Exitoso!");
        }else {
            message.onFail("Usuario Erroneo!");
        }
    }

    public boolean checkLoguin(String usr, String pass){
        if(usr.equals("agustin.galarza@bp-4.com") && pass.equals("123")){
            return true;
        }else {
            return false;
        }
    }
}
