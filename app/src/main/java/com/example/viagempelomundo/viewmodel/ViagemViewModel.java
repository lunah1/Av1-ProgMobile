package com.example.viagempelomundo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViagemViewModel extends ViewModel {

    private final MutableLiveData<String> continenteSelecionado =
            new MutableLiveData<>();

    private final MutableLiveData<String> paisSelecionado =
            new MutableLiveData<>();

    private final MutableLiveData<String> cidadeSelecionada =
            new MutableLiveData<>();

    private final MutableLiveData<String> tipoSelecionado =
            new MutableLiveData<>();


    public void selecionarContinente(String continente) {
        continenteSelecionado.setValue(continente);
    }

    public LiveData<String> getContinenteSelecionado() {
        return continenteSelecionado;
    }


    public void selecionarPais(String pais) {
        paisSelecionado.setValue(pais);
    }

    public LiveData<String> getPaisSelecionado() {
        return paisSelecionado;
    }


    public void selecionarCidade(String cidade) {
        cidadeSelecionada.setValue(cidade);
    }

    public LiveData<String> getCidadeSelecionada() {
        return cidadeSelecionada;
    }


    public void selecionarTipo(String tipo) {
        tipoSelecionado.setValue(tipo);
    }

    public LiveData<String> getTipoSelecionado() {
        return tipoSelecionado;
    }
}