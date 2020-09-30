package com.example.practicas;


//Validar la clase Valida Mail que se sospecha que su funcionamiento no es esperado.

public class ValidaMail {

    private static ValidaMail instance;
    private boolean estado = true;


    private ValidaMail(){ }

    public static ValidaMail getInstance(){
        if (ValidaMail.instance == null){
            instance = new ValidaMail();
        }
        return ValidaMail.instance;
    }

    public boolean validarMail (String mail) {
        if (!estado) {
            throw new IllegalStateException("La cuenta de mail no es correcta");
        }
        this.estado = false;
        if(!mail.contains("@")){
            return false;
        }
        return true;
    }
    public void reset (){
        if(this.estado){
            throw new IllegalThreadStateException("El estado fue reseteado");
        }
        this.estado = true;
    }

}
