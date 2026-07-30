package org.example.calculadora.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.calculadora.util.Validador;

public class CalculadoraControllerFXML{

    @FXML private TextField displayResultado;
    @FXML private Label displayOperacao;
    @FXML private ListView<String> historicoListView;

    private final CalculadoraController controller = new CalculadoraController();

    private double primeiroNumero;
    private String operador = "";
    private boolean iniciarNovoNumero = true;

    @FXML
    private void onBotaoNumeroClicado(ActionEvent event){
        String numero = ((Button) event.getSource()).getText();

        if (iniciarNovoNumero){
            displayResultado.setText(numero);
            iniciarNovoNumero = false;
        }
        else displayResultado.setText(displayResultado.getText() + numero);

    }

    @FXML
    private void onBotaoOperacaoClicado(ActionEvent event){
        try{
            primeiroNumero = Validador.validarNumero(displayResultado.getText());
            operador = ((Button) event.getSource()).getText();
            displayOperacao.setText(
                    primeiroNumero + " " + operador
            );
            iniciarNovoNumero = true;
        }catch(IllegalArgumentException e){
            mostrarErro(e.getMessage());
        }
    }

    @FXML
    private void onBotaoResultadoClicado(ActionEvent event){
        calcularResultado();
    }

    private void calcularResultado(){
        try {
            Validador.validarOperador(operador);
            double segundoNumero = Validador.validarNumero(displayResultado.getText());

            switch (operador){
                case "+" -> controller.somar(primeiroNumero, segundoNumero);
                case "-" -> controller.subtrair(primeiroNumero, segundoNumero);
                case "×" -> controller.multiplicar(primeiroNumero, segundoNumero);
                case "÷" -> controller.dividir(primeiroNumero, segundoNumero);
                case "^" -> controller.potencia(primeiroNumero, segundoNumero);
                default -> throw new IllegalArgumentException("Operação inválida.");
            }

            atualizarHistorico();
            displayOperacao.setText(
                    primeiroNumero + " " + operador + " " + segundoNumero + " ="
            );
            displayResultado.setText(
                    String.valueOf(controller.getUltimoValor())
            );
            operador = "";
            iniciarNovoNumero = true;
        } catch (IllegalArgumentException e){
            mostrarErro(e.getMessage());
        }
    }

    @FXML
    private void onBotaoRaizClicado(){
        try{
            double valor = Validador.validarNumero(displayResultado.getText());
            controller.raizQuadrada(valor);

            atualizarHistorico();
            displayResultado.setText(String.valueOf(controller.getUltimoValor()));
            iniciarNovoNumero = true;

        }catch(IllegalArgumentException e){
            mostrarErro(e.getMessage());
        }
    }

    @FXML
    private void onBotaoLimparClicado(ActionEvent event){
        displayResultado.setText("");
        displayOperacao.setText("");
        primeiroNumero = 0;
        operador = "";
        iniciarNovoNumero = true;
    }

    @FXML
    private void onBotaoLimparHistoricoClicado(){
        controller.limparHistorico();
        atualizarHistorico();
    }

    private void atualizarHistorico(){
        historicoListView.getItems().setAll(controller.getHistorico());
    }

    private void mostrarErro(String mensagem){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Operação inválida");
        alert.setContentText(mensagem);
        alert.showAndWait();

        displayResultado.setText("");
        iniciarNovoNumero = true;
    }
}
