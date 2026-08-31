package com.example.viagempelomundo.model;

public class Estabelecimento {

    private String nome;
    private String continente;
    private String pais;
    private String cidade;
    private String tipo;
    private String endereco;
    private String horario;
    private String descricao;
    private int imagem;

    public Estabelecimento(
            String nome,
            String continente,
            String pais,
            String cidade,
            String tipo,
            String endereco,
            String horario,
            String descricao,
            int imagem) {

        this.nome = nome;
        this.continente = continente;
        this.pais = pais;
        this.cidade = cidade;
        this.tipo = tipo;
        this.endereco = endereco;
        this.horario = horario;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getContinente() {
        return continente;
    }

    public String getPais() {
        return pais;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getHorario() {
        return horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getImagem() {
        return imagem;
    }
}
