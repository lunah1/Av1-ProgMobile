package com.example.viagempelomundo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viagempelomundo.R;

public class ContinentesFragment extends Fragment {

    private Spinner spinnerContinente;
    private Spinner spinnerPais;
    private Spinner spinnerCidade;
    private Spinner spinnerTipo;

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

        spinnerContinente =
                view.findViewById(R.id.spinnerContinente);

        spinnerPais =
                view.findViewById(R.id.spinnerPais);

        spinnerCidade =
                view.findViewById(R.id.spinnerCidade);

        spinnerTipo =
                view.findViewById(R.id.spinnerTipo);

        configurarSpinnerContinente();

        return view;
    }
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

                            String continente =
                                    parent.getItemAtPosition(position).toString();

                            atualizarPaises(continente);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    }
            );

        }
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
                arrayPaises = R.array.paises_america;
        }

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        requireContext(),
                        arrayPaises,
                        android.R.layout.simple_spinner_item
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerPais.setAdapter(adapter);
    }
    }