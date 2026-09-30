package com.example.viagempelomundo.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "estabelecimentos",
        foreignKeys = {
                @ForeignKey(
                        entity = Categoria.class,
                        parentColumns = "id",
                        childColumns = "categoriaId",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index("categoriaId")
        }
)
public class Estabelecimento {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String continente;
    private String pais;
    private String cidade;

    private int categoriaId;

    private String endereco;
    private String horario;
    private String descricao;
    private String caminhoImagem;


    public Estabelecimento(
            String nome,
            String continente,
            String pais,
            String cidade,
            int categoriaId,
            String endereco,
            String horario,
            String descricao,
            String caminhoImagem
    ) {

        this.nome = nome;
        this.continente = continente;
        this.pais = pais;
        this.cidade = cidade;

        this.categoriaId = categoriaId;

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


    public int getCategoriaId() {
        return categoriaId;
    }


    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
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