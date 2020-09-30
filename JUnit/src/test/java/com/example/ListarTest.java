package com.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


  /*

    1) Vacía Vacía Lista vacía
    2) Vacía No vacía Lista B
    2) No Vacía Vacía Lista A
    3) N elementos N elementos Lista con 2N elementos ordenada
    4) N elementos M elementos Lista con N+M elementos ordenada
    4) M elementos N elementos Lista con N+M elementos ordenada

    */


public class ListarTest {

    private Listar listar;
    private ArrayList<Integer> listaA;
    private ArrayList<Integer> listaB;
    private ArrayList<Integer> resultado;


    @BeforeEach
    public void listasBefore() {
        listar = new Listar();
        listaA = new ArrayList<>();
        listaB = new ArrayList<>();
        System.out.println("@BeforeAll -> listasBefore()");
    }

    @AfterEach
    public void listasAfter() {
        listar = null;
        listaA = null;
        listaB = null;
        System.out.println("@AfterEach -> listasAfter()");
    }

    @Test
    public void listasVacias_test() {
        resultado = listar.Vacias(listaA, listaB);
        assertEquals(0, this.resultado.size());
        System.out.println("@Test -> listasVacias_test()");
    }

    @Test
    public void listaA_vacias_error_test() throws Exception {
        listaA = new ArrayList<>();
        listaA.add(1);
        listaA.add(2);
        listaA.add(3);
        try {
            resultado = listar.Vacias(listaA, listaB);
            fail("El metodo lanza una exception y se capturará");
        } catch (Exception e) {
            assertEquals("Una de las listas estan llenas", e.getMessage());
            assertNotNull(e.getMessage());
            System.out.println("QTest -> listaA_vacias_error_test()");
        }
    }

    @Test
    public void listaB_vacias_error_test() throws Exception {
        listaB = new ArrayList<>();
        listaB.add(1);
        listaB.add(2);
        listaB.add(3);
        try {
            resultado = listar.Vacias(listaA, listaB);
            fail("El metodo lanza una exception y se capturará");
        } catch (Exception e) {
            assertEquals("Una de las listas estan llenas", e.getMessage());
            assertNotNull(e.getMessage());
            System.out.println("@Test -> listaB_vacias_error_test()");
        }
    }
    //--------------------------------------------------------------Punto Dos----------------------------------------
    @Test
    public void listaA_cruzadas_test() {
        listaA = new ArrayList<>();
        listaA.add(1);
        listaA.add(2);
        listaA.add(3);
        resultado = listar.Cruzadas(listaA, listaB);
        assertEquals(3, this.resultado.size());
        System.out.println("@Test -> listaA_cruzadas_test()");
    }

    @Test
    public void listaB_cruzadas_test() {
        listaB = new ArrayList<>();
        listaB.add(1);
        listaB.add(2);
        listaB.add(3);
        resultado = listar.Cruzadas(listaA, listaB);
        assertEquals(3, this.resultado.size());
        System.out.println("@Test -> listaB_cruzadas_test()");
    }

    @Test
    public void listaA_cruzadas_error_test() throws Exception{
        listaA = new ArrayList<>();
        try {
            resultado = listar.Cruzadas(listaA, listaB);
            fail("El metodo lanza una exception y se capturará");
        }catch(Exception e) {
            assertEquals("las listas estan vacías", e.getMessage());
            assertNotNull(e.getMessage());
            System.out.println("@Test -> listaA_cruzadas_error_test()");
        }
    }

    @Test
    public void listaB_cruzadas_error_test() throws Exception{
        listaB = new ArrayList<>();
        try {
            resultado = listar.Cruzadas(listaA, listaB);
            fail("El metodo lanza una exception y se capturará");
        }catch(Exception e) {
            assertEquals("las listas estan vacías", e.getMessage());
            assertNotNull(e.getMessage());
            System.out.println("@Test -> listaB_cruzadas_error_test()");
        }
    }
    //--------------------------------------------------------------Punto Tres----------------------------------------
    @Test
    public void listaA_ordenElementos_test() {
        listaA.add(2);
        listaA.add(4);
        listaA.add(3);
        listaA.add(1);

        ArrayList<Integer> comparador = new ArrayList<>();
        comparador.add(1);
        comparador.add(2);
        comparador.add(3);
        comparador.add(4);

        resultado = listar.ordenElementos(listaA);

        assertEquals(resultado, listaA);
        System.out.println("@Test -> listaA_ordenElementos_test()");
        System.out.println("Lista ordenada -> " + resultado);
    }

    @Test
    public void listaB_ordenElementos_test() {
        listaB.add(2);
        listaB.add(4);
        listaB.add(3);
        listaB.add(1);

        ArrayList<Integer> comparador = new ArrayList<>();
        comparador.add(1);
        comparador.add(2);
        comparador.add(3);
        comparador.add(4);

        resultado = listar.ordenElementos(listaB);

        assertEquals(resultado, listaB);
        System.out.println("@Test -> listaB_ordenElementos_test()");
        System.out.println("Lista ordenada -> " + resultado);
    }

    @Test
    public void listaA_ordenElementos_error_test() throws Exception{
        ArrayList<Integer> comparador = new ArrayList<>();
        comparador.add(1);
        comparador.add(2);
        comparador.add(3);
        comparador.add(4);

        try {
            resultado = listar.ordenElementos(listaA);
            fail("El metodo lanza una exception y se capturará");
        }catch(Exception e) {
            assertEquals("la lista tiene datos", e.getMessage());
            assertNotNull(e.getMessage());
            System.out.println("@Test -> listaA_ordenElementos_error_test()");
            System.out.println("lista -> " + resultado);
        }
    }

    @Test
    public void listaB_ordenElementos_error_test() {
        ArrayList<Integer> comparador = new ArrayList<>();
        comparador.add(1);
        comparador.add(2);
        comparador.add(3);
        comparador.add(4);

        try {
            resultado = listar.ordenElementos(listaB);
            fail("El metodo lanza una exception y se capturará");
        }catch(Exception e) {
            assertEquals("la lista tiene datos", e.getMessage());
            assertNotNull(e.getMessage());
            System.out.println("@Test -> listaB_ordenElementos_error_test()");
            System.out.println("lista -> " + resultado);
        }
    }

    //--------------------------------------------------------------Punto Cuatro----------------------------------------
    @Test
    public void listaB_sumarListas_ordenarlas_test() {
        listaB.add(10);
        listaB.add(9);
        listaB.add(8);
        listaB.add(7);

        listaA.add(6);
        listaA.add(5);
        listaA.add(4);
        listaA.add(3);
        listaA.add(2);
        listaA.add(1);

        ArrayList<Integer> comparador = new ArrayList<>();
        comparador.add(1);
        comparador.add(2);
        comparador.add(3);
        comparador.add(4);
        comparador.add(5);
        comparador.add(6);
        comparador.add(7);
        comparador.add(8);
        comparador.add(9);
        comparador.add(10);

        resultado = listar.sumar_ordenar(listaA, listaB);

        assertEquals(comparador, resultado);
        System.out.println("@Test -> listaB_sumarListas_ordenarlas_test()");
        System.out.println(resultado);
    }

    @Test
    public void listaA_sumarListas_ordenarlas_test() {
        listaA.add(10);
        listaA.add(9);
        listaA.add(8);
        listaA.add(7);

        listaB.add(6);
        listaB.add(5);
        listaB.add(4);
        listaB.add(3);
        listaB.add(2);
        listaB.add(1);

        ArrayList<Integer> comparador = new ArrayList<>();
        comparador.add(1);
        comparador.add(2);
        comparador.add(3);
        comparador.add(4);
        comparador.add(5);
        comparador.add(6);
        comparador.add(7);
        comparador.add(8);
        comparador.add(9);
        comparador.add(10);

        resultado = listar.sumar_ordenar(listaA, listaB);

        assertEquals(comparador, resultado);
        System.out.println("@Test -> listaA_sumarListas_ordenarlas_test()");
        System.out.println(resultado);
    }

    @Test
    public void listaA_sumar_ordenar_error_test() {
        listaA.add(10);
        listaA.add(9);
        listaA.add(8);
        listaA.add(7);

        listaB.add(6);
        listaB.add(5);
        listaB.add(4);
        listaB.add(3);
        listaB.add(2);
        listaB.add(1);

        ArrayList<Integer> comparador = new ArrayList<>();
        comparador.add(1);
        comparador.add(2);
        comparador.add(3);
        comparador.add(4);
        comparador.add(5);
        comparador.add(6);
        comparador.add(7);
        comparador.add(8);
        comparador.add(9);
        comparador.add(10);

        try {
            resultado = listar.sumar_ordenar(listaA, listaB);
        }catch(Exception e) {
            assertEquals("las listas son iguales", e.getMessage());
            assertNotNull(e.getMessage());
            System.out.println("@Test -> listaA_sumar_ordenar_error_test()");
            System.out.println("lista -> " + resultado);
        }
    }

    @Test
    public void listaB_sumar_ordenar_error_test() {
        listaA.add(10);
        listaA.add(9);
        listaA.add(8);
        listaA.add(7);

        listaB.add(6);
        listaB.add(5);
        listaB.add(4);
        listaB.add(3);
        listaB.add(2);
        listaB.add(1);

        ArrayList<Integer> comparador = new ArrayList<>();
        comparador.add(1);
        comparador.add(2);
        comparador.add(3);
        comparador.add(4);
        comparador.add(5);
        comparador.add(6);
        comparador.add(7);
        comparador.add(8);
        comparador.add(9);
        comparador.add(10);

        try {
            resultado = listar.sumar_ordenar(listaA, listaB);
        }catch(Exception e) {
            assertEquals("las listas son iguales", e.getMessage());
            assertNotNull(e.getMessage());
            System.out.println("@Test -> listaB_sumar_ordenar_error_test()");
            System.out.println("lista -> " + resultado);
        }
    }

    @ParameterizedTest(name="{index} => a={0}, b{1}, sum={2}")
    @MethodSource("sumarParametetized")
    public void addTestParameterizedTest(int a, int b, int sum){
        assertEquals(sum, listar.sumar(a,b));
    }

    public static Stream<Arguments> sumarParametetized (){
        return Stream.of(
                Arguments.of(6,2,8),
                Arguments.of(5,2,7),
                Arguments.of(-1,-3,-4),
                Arguments.of(4,4,8),
                Arguments.of(5,5,10)
        );
    }
}
