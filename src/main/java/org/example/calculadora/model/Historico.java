package org.example.calculadora.model;

import java.util.ArrayList;
import java.util.List;

public class Historico {

    private final List<String> registros = new ArrayList<>();

    public void adicionar(String registro){
        registros.add(registro);
    }

    public List<String> getRegistros(){
        return new ArrayList<>(registros);
    }

    public void limpar(){
        registros.clear();
    }
}
