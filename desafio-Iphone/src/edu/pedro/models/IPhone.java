package edu.pedro.models;

import edu.pedro.interfaces.*;

public class IPhone extends Telefone implements ReprodutorMusica, NavegadorInternet{

    @Override
    public void ligar() {
        System.out.println("Efetuando ligação....");
    }

    @Override
    public void atender() {
        System.out.println("Atendendo ligação....");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("iniciando correio de voz....");
    }

    @Override
    public void tocar() {
        System.out.println("Tocando música....");
    }

    @Override
    public void selecionarMusica() {
        System.out.println("Selecionando música....");
    }

    @Override
    public void pausar() {
        System.out.println("Música pausada......");
    }

    @Override
    public void exibirPagina() {
        System.out.println("exibindo página...");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Atualizando página");
    }

}
