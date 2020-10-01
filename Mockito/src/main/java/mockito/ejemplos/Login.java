package mockito.ejemplos;

public class Login {

    public ValidaUsr validaUsr;
    public   boolean isLogin;

    public Login(ValidaUsr validaUsr){
        this.validaUsr = validaUsr;
        isLogin = false;
    }

    public void doLogin(){
         validaUsr.login("agustin.galarza@bp-4.com","123", new Message()  {
             @Override
            public void Succes(String response) {
                System.out.println("Usuario correcto!");
                isLogin = true;
            }
             @Override
            public void onFail(String error) {
                System.out.println("Usuario incorrecto!");
                isLogin = false;
            }
        });

    }
}
