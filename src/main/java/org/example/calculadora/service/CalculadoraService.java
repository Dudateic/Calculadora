package org.example.calculadora.service;

import org.example.calculadora.model.Calculadora;
import org.example.calculadora.util.Validador;

import java.util.List;

public class CalculadoraService {

    private final Calculadora model;

    public CalculadoraService(Calculadora model){
        this.model = model;
    }

    private void registrar(double a, String operador, double b, double resultado){
        model.getHistorico().adicionar(
                a + " " + operador + " " + b + " = " + resultado
        );
        model.setUltimoValor(resultado);
    }

    public void somar(double a, double b){
        double r = a + b;
        registrar(a, "+", b, r);
    }

    public void subtrair(double a, double b){
        double r = a - b;
        registrar(a, "-", b, r);
    }

    public void multiplicar(double a, double b){
        double r = a * b;
        registrar(a, "×", b, r);
    }

    public void dividir(double a, double b){
        Validador.validarDivisao(b);
        double r = a / b;
        registrar(a, "÷", b, r);
    }

    public void potencia(double a, double b){
        double r = Math.pow(a, b);
        registrar(a, "^", b, r);
    }

    public void raizQuadrada(double a){
        Validador.validarRaizQuadrada(a);
        double r = Math.sqrt(a);

        model.getHistorico().adicionar(
                "√" + a + " = " + r
        );

        model.setUltimoValor(r);
    }

    public double getUltimoValor(){
        return model.getUltimoValor();
    }

    public List<String> getHistorico(){
        return model.getHistorico().getRegistros();
    }

    public void limparHistorico(){
        model.getHistorico().limpar();
    }
}
