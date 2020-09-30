package com.example;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.junit.jupiter.api.*;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;
    private static Calculadora calculadoraStatic;

    //se ejecuta al principio y luego nunca mas
    @BeforeAll
    public static void beforeAllTest (){
        calculadoraStatic = new Calculadora();
        System.out.println("@BeforeAll -> beforeAllTEst()");
    }

    // se ejecuta siempre de cada test case
    @BeforeEach
    void setUp(){
        calculadora = new Calculadora();
        System.out.println("@BeforeEach -> setUP()");
    }

    @AfterEach
    void tearDown(){
        calculadora = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @AfterAll
    public static void AfterAllTest (){
        calculadoraStatic = null;
        System.out.println("@AfterAll -> AfterAllTest()");
    }

    @Test
    void calcularNotNullTest() {
        assertNotNull(calculadoraStatic   ,"Calculadora debe ser not null");
        assertNotNull(calculadora   ,"Calculadora debe ser not null");
        System.out.println("@Test -> calcularNotNullTest()");
    }

    @Test
    void calcularNullTest() {
        assertNotNull(calculadora   ,"Calculadora debe ser null");
        System.out.println("@Test -> calcularNullTest()");
    }

    @Test
    void sumarAssert() {
        //1.SetUp
        Calculadora calculadora = new Calculadora();
        int esperado = 30;
        int resultado ;
        //2. Action
        resultado = Calculadora.sumar(10,20);
        //3. Assert
        assertEquals(resultado, esperado);
        System.out.println("@Test -Z addAssertTest()");
    }

    @Test
    void sumar() {
        assertEquals(50, Calculadora.sumar(30,20));
    }

    @Test
    void restar() {
        int resultado = Calculadora.restar(3,2);
        int esperado = 1;
        assertEquals(resultado, esperado);
    }



//probando muchos asserts
    @Test
    void assertTypesTest() {
        assertTrue(1 == 1);

        Calculadora calculadora1 = new Calculadora();
        Calculadora calculadora2 = new Calculadora();
        Calculadora calculadora3 = calculadora1;

        assertSame(calculadora1, calculadora3);
        assertNotSame(calculadora1, calculadora2);

        assertEquals("alberto","alberto");
        //assertEquals("alberto","albert", "Ha fallado niestro metodo String");

        assertEquals(1, 1.5 , 0.5);

    }
    /*______________________________________________________________________________________________________________________________*/

    //formas de testear - metodologias

    @Test
    public void restarValorExpresadoTest (){
        assertEquals(11, calculadora.restar(15,4));
    }


    @Test
    public void restarValorExpresadoNegativoTest (){
        assertEquals(5, calculadora.restar(10,5));
    }

    @Test
    public void DivideNormal(){
        assertEquals(5.0, calculadora.dividir(10.0,2.0));
    }

    @Test
    public void Divide_X_Cero(){
        fail("Fallo detectado manualmente - No se puede dividir por cero");
        assertEquals(2.0, calculadora.dividirPorCero(10.0,0.0));
    }

    @Test
    @DisplayName("Metodo Dividir -> Funciona")
    public void Divide_X_CeroConException(){
        assertThrows(ArithmeticException.class, () -> calculadora.dividirPorCero(2, 0), "No puede dividir por cero");
    }


    //no funciono
    @Test
    @Disabled("Disable until bug 23 be resolved")
    public void divide_invalidInput_Test(){
        assertEquals(2.0, calculadora.dividirPorCero(10.0, 0.0));
    }

    // a pesar de que uno falle los otros no lo haran

    @Test
     public void addAssertAllTest (){
        assertAll(
                () -> assertEquals(31,calculadora.sumar(11 ,20)),
                () -> assertEquals(30,calculadora.sumar(10 ,20)),
                () -> assertEquals(2,calculadora.sumar(1 ,1))
        );
    }

    @Nested
    class AddTest{
        @Test
        public void add_positiveTest(){
            assertEquals(30, calculadora.sumar(10,20));
        }
        @Test
        public void add_negativeTest(){
            assertEquals(-30, calculadora.sumar(-10,-20));
        }

        @Test
        public void add_CeroTest(){
            assertEquals(0, calculadora.sumar(0,0));
        }

    }

    }

