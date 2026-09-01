package com.example.viagempelomundo.model;

public class Prato {

    private String nome;
    private String ingredientes;
    private String informacaoCultural;
    private int imagem;

    public Prato(
            String nome,
            String ingredientes,
            String informacaoCultural,
            int imagem) {

        this.nome = nome;
        this.ingredientes = ingredientes;
        this.informacaoCultural = informacaoCultural;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getInformacaoCultural() {
        return informacaoCultural;
    }

    public int getImagem() {
        return imagem;
    }
}