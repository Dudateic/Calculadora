package org.example.calculadora.util;

public class Validador {

    private Validador() {
    }

    public static double validarNumero(String texto) {
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Entrada inválida.");
        }
    }

    public static void validarDivisao(double divisor) {
        if (divisor == 0) throw new IllegalArgumentException("Divisão por zero não é permitida.");

    }

    public static void validarRaizQuadrada(double valor) {
        if (valor < 0) throw new IllegalArgumentException("Raiz de número negativo não é permitida.");
    }

    public static void validarOperador(String operador) {
        if (operador == null || operador.isBlank()) throw new IllegalArgumentException("Operação não selecionada.");
    }
}

