package com.example.viagempelomundo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import com.example.viagempelomundo.viewmodel.ViagemViewModel;

import com.example.viagempelomundo.R;

import android.widget.Button;
import androidx.navigation.Navigation;

public class ContinentesFragment extends Fragment {

    private Spinner spinnerContinente;
    private Spinner spinnerPais;
    private Spinner spinnerCidade;
    private Spinner spinnerTipo;

    private Button btnPesquisar;

    private ViagemViewModel viagemViewModel;

    public ContinentesFragment() {
        // Construtor vazio obrigatório
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_continentes,
                container,
                false
        );

        viagemViewModel =
                new ViewModelProvider(requireActivity())
                        .get(ViagemViewModel.class);

        spinnerContinente =
                view.findViewById(R.id.spinnerContinente);

        spinnerPais =
                view.findViewById(R.id.spinnerPais);

        spinnerCidade =
                view.findViewById(R.id.spinnerCidade);

        spinnerTipo =
                view.findViewById(R.id.spinnerTipo);

        btnPesquisar =
                view.findViewById(R.id.btn_pesquisar);

        spinnerPais.setEnabled(false);
        spinnerCidade.setEnabled(false);
        spinnerTipo.setEnabled(false);

        spinnerPais.setAdapter(null);
        spinnerCidade.setAdapter(null);
        spinnerTipo.setAdapter(null);

        configurarSpinnerContinente();

        btnPesquisar.setOnClickListener(v -> {

            Navigation.findNavController(v)
                    .navigate(
                            R.id.action_continentesFragment_to_estabelecimentosFragment
                    );
        });


        return view;
    }

    // CONFIGURA O SPINNER DE CONTINENTES
    private void configurarSpinnerContinente() {

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        requireContext(),
                        R.array.continentes,
                        android.R.layout.simple_spinner_item
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerContinente.setAdapter(adapter);

        spinnerContinente.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {


                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        if (position == 0) {

                            spinnerPais.setAdapter(null);
                            spinnerCidade.setAdapter(null);
                            spinnerTipo.setAdapter(null);

                            spinnerPais.setEnabled(false);
                            spinnerCidade.setEnabled(false);
                            spinnerTipo.setEnabled(false);

                            return;
                        }

                        String continente =
                                parent.getItemAtPosition(position).toString();

                        viagemViewModel.selecionarContinente(continente);

                        atualizarPaises(continente);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                }
        );
    }

    // ATUALIZA OS PAÍSES CONFORME O CONTINENTE

    private void atualizarPaises(String continente) {

        int arrayPaises;

        switch (continente) {

            case "América":
                arrayPaises = R.array.paises_america;
                break;

            case "África":
                arrayPaises = R.array.paises_africa;
                break;

            case "Europa":
                arrayPaises = R.array.paises_europa;
                break;

            case "Ásia":
                arrayPaises = R.array.paises_asia;
                break;

            case "Oceania":
                arrayPaises = R.array.paises_oceania;
                break;

            default:
                return;
        }

        String[] paises =
                getResources().getStringArray(arrayPaises);

        ArrayList<String> listaPaises =
                new ArrayList<>();

        listaPaises.add("Selecione um país");

        for (String pais : paises) {
            listaPaises.add(pais);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        listaPaises
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerPais.setAdapter(adapter);
        spinnerPais.setEnabled(true);

        spinnerCidade.setAdapter(null);
        spinnerTipo.setAdapter(null);

        spinnerCidade.setEnabled(false);
        spinnerTipo.setEnabled(false);

        spinnerPais.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        if (position == 0) {
                            return;
                        }

                        String pais =
                                parent.getItemAtPosition(position).toString();

                        viagemViewModel.selecionarPais(pais);

                        atualizarCidade(pais);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                }
        );
    }

    // ATUALIZA A CIDADE CONFORME O PAÍS
    private void atualizarCidade(String pais) {

        int arrayCidades;

        switch (pais) {

            case "Brasil":
                arrayCidades = R.array.cidades_brasil;
                break;

            case "Paraguai":
                arrayCidades = R.array.cidades_paraguai;
                break;

            case "Egito":
                arrayCidades = R.array.cidades_egito;
                break;

            case "Nigéria":
                arrayCidades = R.array.cidades_nigeria;
                break;

            case "Rússia":
                arrayCidades = R.array.cidades_russia;
                break;

            case "Grécia":
                arrayCidades = R.array.cidades_grecia;
                break;

            case "Coreia do Sul":
                arrayCidades = R.array.cidades_coreia;
                break;

            case "China":
                arrayCidades = R.array.cidades_china;
                break;

            case "Austrália":
                arrayCidades = R.array.cidades_australia;
                break;

            case "Nova Zelândia":
                arrayCidades = R.array.cidades_nova_zelandia;
                break;

            default:
                arrayCidades = R.array.cidades_brasil;
        }


        String[] cidades =
                getResources().getStringArray(arrayCidades);

        ArrayList<String> listaCidades =
                new ArrayList<>();

        listaCidades.add("Selecione uma cidade");

        for (String cidade : cidades) {
            listaCidades.add(cidade);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        listaCidades
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerCidade.setAdapter(adapter);
        spinnerCidade.setEnabled(true);

        spinnerTipo.setAdapter(null);
        spinnerTipo.setEnabled(false);

        spinnerCidade.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        if (position == 0) {
                            return;
                        }

                        String cidade =
                                parent.getItemAtPosition(position).toString();

                        viagemViewModel.selecionarCidade(cidade);

                        configurarSpinnerTipo();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                }
        );
    }

    // CONFIGURA CAFÉ / BAR / RESTAURANTE
    private void configurarSpinnerTipo() {

        String[] tipos =
                getResources().getStringArray(
                        R.array.tipos_estabelecimento
                );

        ArrayList<String> listaTipos =
                new ArrayList<>();

        listaTipos.add("Selecione um tipo");

        for (String tipo : tipos) {
            listaTipos.add(tipo);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        listaTipos
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerTipo.setAdapter(adapter);
        spinnerTipo.setEnabled(true);

        spinnerTipo.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        if (position == 0) {
                            return;
                        }

                        String tipo =
                                parent.getItemAtPosition(position).toString();

                        viagemViewModel.selecionarTipo(tipo);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                }
        );
    }
    }