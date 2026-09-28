package com.example.viagempelomundo.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "estabelecimentos")
public class Estabelecimento {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String continente;
    private String pais;
    private String cidade;
    private String tipo;
    private String endereco;
    private String horario;
    private String descricao;

    private String caminhoImagem;


    public Estabelecimento(
            String nome,
            String continente,
            String pais,
            String cidade,
            String tipo,
            String endereco,
            String horario,
            String descricao,
            String caminhoImagem
    ) {

        this.nome = nome;
        this.continente = continente;
        this.pais = pais;
        this.cidade = cidade;
        this.tipo = tipo;
        this.endereco = endereco;
        this.horario = horario;
        this.descricao = descricao;
        this.caminhoImagem = caminhoImagem;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getContinente() {
        return continente;
    }


    public void setContinente(String continente) {
        this.continente = continente;
    }


    public String getPais() {
        return pais;
    }


    public void setPais(String pais) {
        this.pais = pais;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getHorario() {
        return horario;
    }


    public void setHorario(String horario) {
        this.horario = horario;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getCaminhoImagem() {
        return caminhoImagem;
    }


    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}