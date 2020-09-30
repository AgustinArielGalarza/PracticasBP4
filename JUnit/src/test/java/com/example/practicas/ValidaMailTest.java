package com.example.practicas;


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

    private ValidaMail validador = ValidaMail.getInstance();

    //reset cada ciclo validador
    @AfterEach
    public void after(){
        validador.reset();
    }

    //test correcto
    @Test
    public void CuentaBienFormadaTest(){
        boolean resultado = validador.validarMail("agustin.galarza@bp-4.com");
        assertTrue(resultado);
    }

    //test con error
    @Test
    public void CuentaMalFormadatest(){
        boolean resultado = validador.validarMail("agustin.galarzaXXXbp-4.com");
        assertFalse(resultado);
    }



}
