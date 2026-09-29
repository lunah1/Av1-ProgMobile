package com.example.viagempelomundo.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pratos")
public class Prato {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String cidade;
    private String ingredientes;
    private String informacaoCultural;

    private String caminhoImagem;

    private String caminhoAudio;


    public Prato(
            String nome,
            String cidade,
            String ingredientes,
            String informacaoCultural,
            String caminhoImagem,
            String caminhoAudio
    ) {

        this.nome = nome;
        this.cidade = cidade;
        this.ingredientes = ingredientes;
        this.informacaoCultural = informacaoCultural;
        this.caminhoImagem = caminhoImagem;
        this.caminhoAudio = caminhoAudio;
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


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getIngredientes() {
        return ingredientes;
    }


    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }


    public String getInformacaoCultural() {
        return informacaoCultural;
    }


    public void setInformacaoCultural(String informacaoCultural) {
        this.informacaoCultural = informacaoCultural;
    }


    public String getCaminhoImagem() {
        return caminhoImagem;
    }


    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }


    public String getCaminhoAudio() {
        return caminhoAudio;
    }


    public void setCaminhoAudio(String caminhoAudio) {
        this.caminhoAudio = caminhoAudio;
    }
}