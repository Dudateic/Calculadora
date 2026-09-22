<div align="center">

# Calculadora JavaFX

</div>

> Aplicação gráfica desenvolvida em JavaFX para estudo de Programação Orientada a Objetos, arquitetura MVC e organização de código.




## Sumário

- [01 · Visão Geral](#01--visão-geral)
- [02 · Funcionalidades](#02--funcionalidades)
- [03 · Arquitetura](#03--arquitetura)
- [04 · Estrutura do Projeto](#04--estrutura-do-projeto)
- [05 · Como Executar](#05--como-executar)


# 01 · Visão Geral

Este projeto consiste em uma **calculadora gráfica desenvolvida em JavaFX**, criada para aplicar conceitos de **Programação Orientada a Objetos**, desenvolvimento de interfaces gráficas e arquitetura de software.

A aplicação utiliza o padrão **MVC (Model–View–Controller)**, separando interface, controle de eventos e regras de negócio.

Além disso, foi implementada uma camada de serviço para centralizar as operações matemáticas e facilitar a manutenção do sistema.


# 02 · Funcionalidades

| Funcionalidade | Descrição |
|---|---|
| Operações básicas | Soma, subtração, multiplicação e divisão |
| Potenciação | Cálculo de exponenciação |
| Raiz quadrada | Operação com validação |
| Histórico | Registro das operações realizadas |
| Limpeza | Remoção do histórico |


# 03 · Arquitetura

Fluxo principal da aplicação:

```
View (JavaFX/FXML)
        |
        v
Controller
        |
        v
Service
        |
        v
Model
```

| Camada | Responsabilidade |
|---|---|
| View | Interface gráfica |
| Controller | Controle das ações do usuário |
| Service | Regras matemáticas |
| Model | Dados da aplicação |


# 04 · Estrutura do Projeto

```
calculadora/
├── pom.xml
├── mvnw
├── README.md
│
└── src/main/
    ├── java/
    │   └── org/example/calculadora/
    │       ├── app/
    │       │   └── App.java
    │       ├── controller/
    │       │   ├── CalculadoraController.java
    │       │   └── CalculadoraControllerFXML.java
    │       ├── model/
    │       │   ├── Calculadora.java
    │       │   └── Historico.java
    │       ├── service/
    │       │   └── CalculadoraService.java
    │       └── util/
    │           └── Validador.java
    │
    └── resources/
        └── CalculadoraView.fxml
```


# 05 · Como Executar

## Requisitos

- Java JDK 17+
- Maven
- JavaFX

Executar:

```bash
./mvnw javafx:run
```
---

<p align="center">
Calculadora JavaFX · Projeto Acadêmico · 2026
</p>
