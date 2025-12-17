package org.example.calculadora.controller;

import org.example.calculadora.model.Calculadora;
import org.example.calculadora.service.CalculadoraService;

import java.util.List;

public class CalculadoraController {

    private final CalculadoraService service = new CalculadoraService(new Calculadora());

    public void somar(double a, double b){ service.somar(a, b); }

    public void subtrair(double a, double b){ service.subtrair(a, b); }

    public void multiplicar(double a, double b){ service.multiplicar(a, b); }

    public void dividir(double a, double b){ service.dividir(a, b); }

    public void potencia(double a, double b){ service.potencia(a, b); }

    public void raizQuadrada(double a){ service.raizQuadrada(a); }

    public double getUltimoValor(){
        return service.getUltimoValor();
    }

    public List<String> getHistorico(){
        return service.getHistorico();
    }

    public void limparHistorico(){
        service.limparHistorico();
    }
}
