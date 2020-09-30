package com.example.practicas;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class CalculadorTemperaturaTest {

    private CalculadorTemperatura calculadorTemperatura;

    // se instancia calculador de temperatura por cada ciclo
    @BeforeEach
    void setUp(){
        calculadorTemperatura = new CalculadorTemperatura();
        System.out.println("@BeforeEach -> setUP()");
    }

    //se hace un assertAll cual podemos ejecutar una pila de assertEquals
    @Test
    public void TestCalcularTemperatura1 (){
        assertAll(
                () -> assertEquals(33.8,calculadorTemperatura.gradosAfahrenhit(1)),
                () -> assertEquals(50,calculadorTemperatura.gradosAfahrenhit(10)),
                () -> assertEquals(32,calculadorTemperatura.gradosAfahrenhit(0))
        );
        System.out.println("ha sido correcto!");
    }

    //y por ultimo dejamos a calcularTemperatura en null
    @AfterEach
    void tearDown(){
        calculadorTemperatura = null;
        System.out.println("@AfterEach -> tearDown()");
    }
}
