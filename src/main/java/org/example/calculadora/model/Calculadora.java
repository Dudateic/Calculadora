package org.example.calculadora.model;

public class Calculadora {

    private double ultimoValor;
    private final Historico historico = new Historico();

    public double getUltimoValor(){
        return ultimoValor;
    }

    public void setUltimoValor(double ultimoValor){
        this.ultimoValor = ultimoValor;
    }

    public Historico getHistorico(){
        return historico;
    }
}
