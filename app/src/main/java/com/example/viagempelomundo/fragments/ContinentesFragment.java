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

        return view;

    }
}