package com.example;

/*
Escriba un conjunto de pruebas para verificar el comportamiento de un método que recibe
como parámetro dos conjuntos ordenados (o dos listas o dos arrays ordenadas de menor a
mayor) y devuelva un nuevo conjunto ordenado que contenga los elementos de ambos
conjuntos en el mismo orden.
¿Cómo podríamos saber el número de elementos comunes que había en ambos
conjuntos de entrada?
3
Solución
Los valores de entrada son las dos listas ordenadas y el resultado obtenido es una tercera lista.
Veamos qué combinaciones podemos hacer.
*/


import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Listar {

    private ArrayList<Integer> listaResultante;

    public Listar() {}

    public ArrayList<Integer> Vacias (ArrayList <Integer>listaA , ArrayList <Integer> listaB) {
        if (listaA.size() == 0 && listaB.size() == 0) {
            return listaResultante = new ArrayList<>();
        }else{
            throw new ArrayIndexOutOfBoundsException("Una de las listas estan llenas");
        }

    }
    public ArrayList<Integer> Cruzadas (ArrayList <Integer>listaA , ArrayList <Integer> listaB){

        listaResultante = new ArrayList<>();

        if (listaA.size() > 0 && listaB.size() == 0) {
            listaA.forEach( x -> listaB.add(x));
            listaResultante = listaB;
        }else if(listaA.size() == 0 && listaB.size() > 0){
            listaB.forEach( x -> listaA.add(x));
            listaResultante = listaA;
        }else{
            throw new ArrayIndexOutOfBoundsException("las listas estan vacías");
        }
        return listaResultante;
    }

    public ArrayList<Integer> ordenElementos (ArrayList <Integer>listaA){

       listaResultante = new ArrayList<>();

        if (listaA.size() > 0){
            Collections.sort(listaA);
            listaResultante = listaA;
        }else{
            throw new ArrayIndexOutOfBoundsException("la lista tiene datos");
        }

        return listaResultante;
    }

    public ArrayList<Integer> sumar_ordenar(ArrayList <Integer>listaA , ArrayList <Integer> listaB){

        listaResultante = new ArrayList<>();

        if (listaA.size() > listaB.size()){
            listaA.forEach( x -> listaB.add(x));
            //listaB.sort((x,y)-> x.compareTo(y));
            Collections.sort(listaB);
            listaResultante = listaB;
        }else if  (listaA.size() < listaB.size()){
            listaB.forEach( x -> listaA.add(x));
            Collections.sort(listaA);
            listaResultante = listaA;
            //listaA.sort((x,y)-> x.compareTo(y));
        }else{
            throw new ArrayIndexOutOfBoundsException("las listas son iguales");
        }
        return listaResultante;
    }

    public static int sumar (int a, int b){
        return a + b;
    }


}
