package com.example.viagempelomundo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.viagempelomundo.entity.Estabelecimento;
import com.example.viagempelomundo.entity.Prato;
import com.example.viagempelomundo.entity.Usuario;
import com.example.viagempelomundo.repository.ViagemRepository;
import com.example.viagempelomundo.entity.CategoriaComEstabelecimentos;

import java.util.List;

public class ViagemViewModel
        extends AndroidViewModel {
    private final ViagemRepository repository;
    private final MutableLiveData<String>
            continenteSelecionado =
            new MutableLiveData<>();

    private final MutableLiveData<String>
            paisSelecionado =
            new MutableLiveData<>();

    private final MutableLiveData<String>
            cidadeSelecionada =
            new MutableLiveData<>();

    private final MutableLiveData<String>
            tipoSelecionado =
            new MutableLiveData<>();


    public ViagemViewModel(
            @NonNull Application application
    ) {

        super(application);

        repository =
                new ViagemRepository(application);
    }

    public void buscarUsuarioPorId(
            int id,
            ViagemRepository.UsuarioCallback callback
    ) {

        repository.buscarUsuarioPorId(
                id,
                callback
        );
    }

    public void selecionarContinente(
            String continente
    ) {

        continenteSelecionado.setValue(
                continente
        );
    }


    public LiveData<String>
    getContinenteSelecionado() {

        return continenteSelecionado;
    }


    public void selecionarPais(
            String pais
    ) {

        paisSelecionado.setValue(
                pais
        );
    }


    public LiveData<String>
    getPaisSelecionado() {

        return paisSelecionado;
    }


    public void selecionarCidade(
            String cidade
    ) {

        cidadeSelecionada.setValue(
                cidade
        );
    }


    public LiveData<String>
    getCidadeSelecionada() {

        return cidadeSelecionada;
    }


    public void selecionarTipo(
            String tipo
    ) {

        tipoSelecionado.setValue(
                tipo
        );
    }


    public LiveData<String>
    getTipoSelecionado() {

        return tipoSelecionado;
    }


    public LiveData<Usuario>
    getUsuarioLogado() {

        return repository.getUsuarioLogado();
    }



    public LiveData<List<Estabelecimento>>
    buscarEstabelecimentos(
            String continente,
            String pais,
            String cidade,
            String tipo
    ) {

        return repository.buscarEstabelecimentos(
                continente,
                pais,
                cidade,
                tipo
        );
    }

    public LiveData<CategoriaComEstabelecimentos>
    buscarCategoriaComEstabelecimentos(
            int categoriaId
    ) {

        return repository
                .buscarCategoriaComEstabelecimentos(
                        categoriaId
                );
    }

    public LiveData<List<Prato>>
    buscarPratosPorCidade(
            String cidade
    ) {

        return repository.buscarPratosPorCidade(
                cidade
        );
    }

    public void cadastrarUsuario(
            Usuario usuario,
            ViagemRepository.CadastroCallback callback
    ) {

        repository.cadastrarUsuario(
                usuario,
                callback
        );
    }

    public void login(
            String email,
            String senha,
            ViagemRepository.LoginCallback callback
    ) {

        repository.login(
                email,
                senha,
                callback
        );
    }

    public void logout() {

        repository.logout();
    }

    public void atualizarUsuario(
            Usuario usuario,
            ViagemRepository.CadastroCallback callback
    ) {

        repository.atualizarUsuario(
                usuario,
                callback
        );
    }


    public void excluirUsuario(
            Usuario usuario,
            ViagemRepository.CadastroCallback callback
    ) {

        repository.excluirUsuario(
                usuario,
                callback
        );
    }
}