package com.example.viagempelomundo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "usuarios",
        indices = {
                @Index(value = {"email"}, unique = true)
        }
)
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;

    private String email;

    private String senha;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] foto;


    public Usuario(String nome, String email, String senha, byte[] foto) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.foto = foto;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}