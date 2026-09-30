package com.example.viagempelomundo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import com.example.viagempelomundo.entity.CategoriaComEstabelecimentos;
import com.example.viagempelomundo.entity.Categoria;

import java.util.List;

@Dao
public interface CategoriaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserir(Categoria categoria);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserirTodos(List<Categoria> categorias);


    @Query("SELECT * FROM categorias ORDER BY id")
    LiveData<List<Categoria>> listarTodos();


    @Query("SELECT * FROM categorias WHERE id = :id LIMIT 1")
    Categoria buscarPorId(int id);


    @Query("SELECT * FROM categorias WHERE nome = :nome LIMIT 1")
    Categoria buscarPorNome(String nome);


    @Query("SELECT COUNT(*) FROM categorias")
    int quantidade();

    @Transaction
    @Query("SELECT * FROM categorias WHERE id = :categoriaId")
    LiveData<CategoriaComEstabelecimentos>
    buscarCategoriaComEstabelecimentos(
            int categoriaId
    );
}