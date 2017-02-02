package com.leonelatencio.calculadora;

/**
 * Result POJO Class.
 * Created by Leonel on 02/01/2017.
 */

public class Result {
    int result;
    char operation;

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public int getResultado() {
        return result;
    }

    public void setResultado(int result) {
        this.result = result;
    }
}
