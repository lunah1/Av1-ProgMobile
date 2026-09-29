package com.example.viagempelomundo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.viagempelomundo.entity.Sessao;
import com.example.viagempelomundo.entity.Usuario;

@Dao
public interface SessaoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void iniciarSessao(Sessao sessao);


    @Query("DELETE FROM sessao")
    void encerrarSessao();


    @Query("SELECT * FROM sessao LIMIT 1")
    Sessao buscarSessao();


    @Query(
            "SELECT usuarios.* " +
                    "FROM usuarios " +
                    "INNER JOIN sessao " +
                    "ON usuarios.id = sessao.usuarioId " +
                    "LIMIT 1"
    )
    LiveData<Usuario> getUsuarioLogado();
}
