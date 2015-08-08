package com.example.user.calculadora1;

/**
 * Created by user on 07/08/2015.
 */
public class Operation {
    private boolean isOperando;
    private int operando;
    private String operador;

    public Operation(boolean isOperando, int operando, String operador){
        this.isOperando = isOperando;
        this.operando = operando;
        this.operador = operador;
    }
    public boolean getIsOperando(){
        return isOperando;
    }
    public int getOperando(){
        return operando;
    }
    public String getOperador(){
        return operador;
    }
}
