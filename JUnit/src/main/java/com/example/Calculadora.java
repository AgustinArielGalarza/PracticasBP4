package com.example;

public class Calculadora {

    public static int sumar(int a, int b){
        return a + b;
    }

    public static int restar (int a, int b){
        return a - b;
    }

    public static double dividir(double a, double b){
        return a / b;
    }

    public static double dividirPorCero(double a, double b) {
        if (b == 0){
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }
}
