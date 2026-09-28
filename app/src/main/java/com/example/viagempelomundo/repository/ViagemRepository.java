package com.example.viagempelomundo.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.viagempelomundo.dao.EstabelecimentoDao;
import com.example.viagempelomundo.dao.PratoDao;
import com.example.viagempelomundo.dao.SessaoDao;
import com.example.viagempelomundo.dao.UsuarioDao;
import com.example.viagempelomundo.database.AppDatabase;
import com.example.viagempelomundo.entity.Estabelecimento;
import com.example.viagempelomundo.entity.Prato;
import com.example.viagempelomundo.entity.Usuario;

import java.util.List;

public class ViagemRepository {

    private final UsuarioDao usuarioDao;
    private final SessaoDao sessaoDao;
    private final EstabelecimentoDao estabelecimentoDao;
    private final PratoDao pratoDao;


    public ViagemRepository(Context context) {

        AppDatabase database =
                AppDatabase.getInstance(context);

        usuarioDao =
                database.usuarioDao();

        sessaoDao =
                database.sessaoDao();

        estabelecimentoDao =
                database.estabelecimentoDao();

        pratoDao =
                database.pratoDao();
    }



    public LiveData<Usuario> getUsuarioLogado() {

        return sessaoDao.getUsuarioLogado();
    }


    public LiveData<List<Estabelecimento>>
    buscarEstabelecimentos(
            String continente,
            String pais,
            String cidade,
            String tipo
    ) {

        return estabelecimentoDao.filtrar(
                continente,
                pais,
                cidade,
                tipo
        );
    }


    public LiveData<List<Estabelecimento>>
    listarEstabelecimentos() {

        return estabelecimentoDao.listarTodos();
    }


    public LiveData<List<Prato>>
    buscarPratosPorCidade(
            String cidade
    ) {

        return pratoDao.buscarPorCidade(
                cidade
        );
    }


    public LiveData<List<Prato>>
    listarPratos() {

        return pratoDao.listarTodos();
    }
}