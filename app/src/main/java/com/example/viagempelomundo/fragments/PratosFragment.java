package com.example.viagempelomundo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.viagempelomundo.DetalhesActivity;
import com.example.viagempelomundo.R;
import com.example.viagempelomundo.adapter.PratoAdapter;
import com.example.viagempelomundo.entity.Prato;
import com.example.viagempelomundo.viewmodel.ViagemViewModel;

import java.util.ArrayList;

public class PratosFragment
        extends Fragment {

    private GridView gridViewPratos;

    private TextView txtTituloPratos;

    private ViagemViewModel viagemViewModel;

    private PratoAdapter adapter;

    private final ArrayList<Prato>
            listaPratos =
            new ArrayList<>();


    public PratosFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {

        return inflater.inflate(
                R.layout.fragment_pratos,
                container,
                false
        );
    }


    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {

        super.onViewCreated(
                view,
                savedInstanceState
        );


        gridViewPratos =
                view.findViewById(
                        R.id.grid_view_pratos
                );


        txtTituloPratos =
                view.findViewById(
                        R.id.txt_titulo_pratos
                );


        viagemViewModel =
                new ViewModelProvider(
                        requireActivity()
                ).get(
                        ViagemViewModel.class
                );


        configurarAdapter();

        observarCidade();
    }


    private void configurarAdapter() {

        adapter =
                new PratoAdapter(
                        requireContext(),
                        listaPratos
                );


        gridViewPratos.setAdapter(
                adapter
        );


        gridViewPratos
                .setOnItemClickListener(
                        (
                                parent,
                                view,
                                position,
                                id
                        ) -> {

                            Prato prato =
                                    listaPratos.get(
                                            position
                                    );


                            abrirDetalhes(
                                    prato
                            );
                        }
                );
    }



    private void observarCidade() {

        viagemViewModel
                .getCidadeSelecionada()
                .observe(
                        getViewLifecycleOwner(),
                        cidade -> {

                            if (cidade != null
                                    && !cidade.isEmpty()) {

                                txtTituloPratos
                                        .setText(
                                                "Pratos e bebidas - "
                                                        + cidade
                                        );


                                buscarPratos(
                                        cidade
                                );
                            }
                        }
                );
    }


    private void buscarPratos(
            String cidade
    ) {

        viagemViewModel
                .buscarPratosPorCidade(
                        cidade
                )
                .observe(
                        getViewLifecycleOwner(),
                        pratos -> {

                            listaPratos.clear();


                            if (pratos != null) {

                                listaPratos.addAll(
                                        pratos
                                );
                            }


                            adapter
                                    .notifyDataSetChanged();
                        }
                );
    }



    private void abrirDetalhes(
            Prato prato
    ) {

        Intent intent =
                new Intent(
                        requireContext(),
                        DetalhesActivity.class
                );


        intent.putExtra(
                "tipo_item",
                "prato"
        );


        intent.putExtra(
                "nome",
                prato.getNome()
        );


        intent.putExtra(
                "ingredientes",
                prato.getIngredientes()
        );


        intent.putExtra(
                "informacao_cultural",
                prato.getInformacaoCultural()
        );


        intent.putExtra(
                "imagem",
                prato.getCaminhoImagem()
        );


        startActivity(
                intent
        );
    }
}