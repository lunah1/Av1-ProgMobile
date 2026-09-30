package com.example.viagempelomundo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.viagempelomundo.entity.Estabelecimento;

import java.util.List;

@Dao
public interface EstabelecimentoDao {

    @Insert
    void inserir(
            Estabelecimento estabelecimento
    );


    @Insert
    void inserirTodos(
            List<Estabelecimento> estabelecimentos
    );


    @Query("SELECT * FROM estabelecimentos")
    LiveData<List<Estabelecimento>> listarTodos();


    @Query(
            "SELECT e.* " +
                    "FROM estabelecimentos e " +
                    "INNER JOIN categorias c " +
                    "ON e.categoriaId = c.id " +
                    "WHERE e.continente = :continente " +
                    "AND e.pais = :pais " +
                    "AND e.cidade = :cidade " +
                    "AND c.nome = :tipo"
    )
    LiveData<List<Estabelecimento>> filtrar(
            String continente,
            String pais,
            String cidade,
            String tipo
    );


    @Query("SELECT COUNT(*) FROM estabelecimentos")
    int quantidade();
}