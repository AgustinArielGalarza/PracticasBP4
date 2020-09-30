package com.example;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*Test para la clase ValidaMail
Usaremos la metodología TDD para estos test

cada test case haremos
- preparar
- probar
- verificar

El TDD se basa en
-caso de fallo
-caso de error
-caso valido

*/
public class ValidaMailTest {
    //preparar
    private ValidaMail validador = ValidaMail.getInstance();

    @AfterEach
    public void after(){
        validador.reset();
    }

    //Caso Valido
    @Test
    public void CuentaBienFormadaTest(){
        //probar
        boolean resultado = validador.validarMail("agustin.galarza@bp-4.com");

        //Verificar
        assertTrue(resultado);
    }

    //Caso de fallo
    @Test
    public void CuentaMalDormadatest(){
        //probar
        boolean resultado = validador.validarMail("agustin.galarzaXXXbp-4.com");

        //Verificar
        assertFalse(resultado);
    }



}
