package com.example.viagempelomundo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.viagempelomundo.DetalhesActivity;
import com.example.viagempelomundo.R;
import com.example.viagempelomundo.adapter.EstabelecimentoAdapter;
import com.example.viagempelomundo.entity.Estabelecimento;
import com.example.viagempelomundo.viewmodel.ViagemViewModel;

import java.util.ArrayList;

public class EstabelecimentosFragment
        extends Fragment {

    private ListView listViewEstabelecimentos;

    private TextView txtContinenteSelecionado;

    private Button btnVerPratos;

    private ViagemViewModel viagemViewModel;

    private EstabelecimentoAdapter adapter;

    private final ArrayList<Estabelecimento>
            listaEstabelecimentos =
            new ArrayList<>();


    private String continente;
    private String pais;
    private String cidade;
    private String tipo;


    public EstabelecimentosFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {

        return inflater.inflate(
                R.layout.fragment_estabelecimentos,
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


        txtContinenteSelecionado =
                view.findViewById(
                        R.id.txt_continente_selecionado
                );


        listViewEstabelecimentos =
                view.findViewById(
                        R.id.list_view_estabelecimentos
                );


        btnVerPratos =
                view.findViewById(
                        R.id.btn_ver_pratos
                );


        viagemViewModel =
                new ViewModelProvider(
                        requireActivity()
                ).get(
                        ViagemViewModel.class
                );


        configurarAdapter();

        observarFiltros();


        btnVerPratos.setOnClickListener(
                v ->
                        Navigation
                                .findNavController(v)
                                .navigate(
                                        R.id.action_estabelecimentosFragment_to_pratosFragment
                                )
        );
    }


    // =============================
    // ADAPTER
    // =============================

    private void configurarAdapter() {

        adapter =
                new EstabelecimentoAdapter(
                        requireContext(),
                        listaEstabelecimentos
                );


        listViewEstabelecimentos
                .setAdapter(
                        adapter
                );


        listViewEstabelecimentos
                .setOnItemClickListener(
                        (
                                parent,
                                view,
                                position,
                                id
                        ) -> {

                            Estabelecimento estabelecimento =
                                    listaEstabelecimentos
                                            .get(position);


                            abrirDetalhes(
                                    estabelecimento
                            );
                        }
                );
    }


    // =============================
    // OBSERVA FILTROS
    // =============================

    private void observarFiltros() {

        viagemViewModel
                .getContinenteSelecionado()
                .observe(
                        getViewLifecycleOwner(),
                        valor -> {

                            continente = valor;

                            tentarBuscar();
                        }
                );


        viagemViewModel
                .getPaisSelecionado()
                .observe(
                        getViewLifecycleOwner(),
                        valor -> {

                            pais = valor;

                            tentarBuscar();
                        }
                );


        viagemViewModel
                .getCidadeSelecionada()
                .observe(
                        getViewLifecycleOwner(),
                        valor -> {

                            cidade = valor;

                            tentarBuscar();
                        }
                );


        viagemViewModel
                .getTipoSelecionado()
                .observe(
                        getViewLifecycleOwner(),
                        valor -> {

                            tipo = valor;

                            tentarBuscar();
                        }
                );
    }


    // =============================
    // VERIFICA SE TODOS OS FILTROS
    // JÁ FORAM SELECIONADOS
    // =============================

    private void tentarBuscar() {

        if (continente == null
                || pais == null
                || cidade == null
                || tipo == null) {

            return;
        }


        txtContinenteSelecionado
                .setText(
                        tipo + " - " + cidade
                );


        buscarEstabelecimentos();
    }


    // =============================
    // BUSCA NO ROOM
    // =============================

    private void buscarEstabelecimentos() {

        viagemViewModel
                .buscarEstabelecimentos(
                        continente,
                        pais,
                        cidade,
                        tipo
                )
                .observe(
                        getViewLifecycleOwner(),
                        estabelecimentos -> {

                            listaEstabelecimentos
                                    .clear();


                            if (estabelecimentos != null) {

                                listaEstabelecimentos
                                        .addAll(
                                                estabelecimentos
                                        );
                            }


                            adapter
                                    .notifyDataSetChanged();
                        }
                );
    }


    // =============================
    // DETAILS ACTIVITY
    // =============================

    private void abrirDetalhes(
            Estabelecimento estabelecimento
    ) {

        Intent intent =
                new Intent(
                        requireContext(),
                        DetalhesActivity.class
                );


        intent.putExtra(
                "tipo_item",
                "estabelecimento"
        );


        intent.putExtra(
                "nome",
                estabelecimento.getNome()
        );


        intent.putExtra(
                "endereco",
                estabelecimento.getEndereco()
        );


        intent.putExtra(
                "horario",
                estabelecimento.getHorario()
        );


        intent.putExtra(
                "descricao",
                estabelecimento.getDescricao()
        );


        intent.putExtra(
                "imagem",
                estabelecimento.getCaminhoImagem()
        );


        startActivity(
                intent
        );
    }
}