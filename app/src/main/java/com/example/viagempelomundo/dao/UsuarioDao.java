package com.example.viagempelomundo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.viagempelomundo.entity.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {

    @Insert
    long inserir(Usuario usuario);


    @Update
    void atualizar(Usuario usuario);


    @Delete
    void excluir(Usuario usuario);


    @Query("SELECT * FROM usuarios WHERE id = :id LIMIT 1")
    Usuario buscarPorId(int id);


    @Query("SELECT * FROM usuarios WHERE email = :email LIMIT 1")
    Usuario buscarPorEmail(String email);


    @Query("SELECT * FROM usuarios WHERE email = :email AND senha = :senha LIMIT 1")
    Usuario login(String email, String senha);


    @Query("SELECT * FROM usuarios ORDER BY nome")
    LiveData<List<Usuario>> listarTodos();
}
