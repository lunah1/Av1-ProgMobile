package com.example.viagempelomundo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.viagempelomundo.entity.Prato;

import java.util.List;

@Dao
public interface PratoDao {

    @Insert
    void inserir(Prato prato);


    @Insert
    void inserirTodos(List<Prato> pratos);


    @Query("SELECT * FROM pratos")
    LiveData<List<Prato>> listarTodos();


    @Query(
            "SELECT * FROM pratos " +
                    "WHERE cidade = :cidade"
    )
    LiveData<List<Prato>> buscarPorCidade(
            String cidade
    );


    @Query("SELECT COUNT(*) FROM pratos")
    int quantidade();
}