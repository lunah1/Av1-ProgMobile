package com.example.viagempelomundo.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CategoriaComEstabelecimentos {

    @Embedded
    private Categoria categoria;

    @Relation(
            parentColumn = "id",
            entityColumn = "categoriaId"
    )
    private List<Estabelecimento> estabelecimentos;


    public Categoria getCategoria() {
        return categoria;
    }


    public void setCategoria(
            Categoria categoria
    ) {
        this.categoria = categoria;
    }


    public List<Estabelecimento> getEstabelecimentos() {
        return estabelecimentos;
    }


    public void setEstabelecimentos(
            List<Estabelecimento> estabelecimentos
    ) {
        this.estabelecimentos = estabelecimentos;
    }
}