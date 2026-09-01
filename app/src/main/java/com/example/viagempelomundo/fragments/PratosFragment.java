package com.example.viagempelomundo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viagempelomundo.R;
import com.example.viagempelomundo.adapter.PratoAdapter;
import com.example.viagempelomundo.model.Prato;

import java.util.ArrayList;

public class PratosFragment extends Fragment {

    private GridView gridViewPratos;

    public PratosFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_pratos,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        gridViewPratos =
                view.findViewById(R.id.grid_view_pratos);

        // APENAS PARA TESTAR POR ENQUANTO
        ArrayList<Prato> pratos =
                criarPratos("Brasília");

        PratoAdapter adapter =
                new PratoAdapter(
                        requireContext(),
                        pratos
                );

        gridViewPratos.setAdapter(adapter);
    }

    private ArrayList<Prato> criarPratos(String cidade) {

        ArrayList<Prato> pratos =
                new ArrayList<>();

        switch (cidade) {

            case "Brasília":

                pratos.add(new Prato(
                        "Feijoada",
                        "Feijão preto, carnes e temperos",
                        "Prato tradicional brasileiro.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Pão de Queijo",
                        "Polvilho, queijo, ovos e leite",
                        "Quitute muito popular no Brasil.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;


            case "Cairo":

                pratos.add(new Prato(
                        "Koshari",
                        "Arroz, lentilha, macarrão e grão-de-bico",
                        "Prato popular da culinária egípcia.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Falafel",
                        "Grão-de-bico, ervas e temperos",
                        "Preparação muito comum na região.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;


            case "Seul":

                pratos.add(new Prato(
                        "Bibimbap",
                        "Arroz, legumes, carne e ovo",
                        "Prato tradicional coreano.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Tteokbokki",
                        "Bolinhos de arroz e molho apimentado",
                        "Comida de rua popular na Coreia do Sul.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;


            case "Pequim":

                pratos.add(new Prato(
                        "Pato de Pequim",
                        "Pato, panquecas, cebolinha e molho",
                        "Um dos pratos mais conhecidos de Pequim.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Jiaozi",
                        "Massa, carne ou vegetais",
                        "Tipo de dumpling tradicional chinês.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;
        }

        return pratos;
    }
}