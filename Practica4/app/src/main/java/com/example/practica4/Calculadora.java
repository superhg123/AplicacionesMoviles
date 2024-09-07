package com.example.practica4;

public class Calculadora {
    private int num1;
    private int num2;

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int suma() {
        return num1 + num2;
    }

    public int resta() {
        return num1 - num2;
    }

    public int mult() {
        return num1 * num2;
    }

    public double div() {
        if (num2 == 0) {
            return 0;
        } else {
            return (double) num1 / num2;
        }
    }
}
