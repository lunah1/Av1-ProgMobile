package com.example.viagempelomundo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.viagempelomundo.R;
import com.example.viagempelomundo.adapter.EstabelecimentoAdapter;
import com.example.viagempelomundo.model.Estabelecimento;
import com.example.viagempelomundo.viewmodel.ViagemViewModel;

import android.content.Intent;

import com.example.viagempelomundo.DetalhesActivity;

import java.util.ArrayList;

public class EstabelecimentosFragment extends Fragment {

    private ListView listViewEstabelecimentos;
    private TextView txtContinenteSelecionado;

    private ViagemViewModel viagemViewModel;

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
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_estabelecimentos,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        txtContinenteSelecionado =
                view.findViewById(R.id.txt_continente_selecionado);

        listViewEstabelecimentos =
                view.findViewById(R.id.list_view_estabelecimentos);

        viagemViewModel =
                new ViewModelProvider(requireActivity())
                        .get(ViagemViewModel.class);

        observarFiltros();
    }

    private void observarFiltros() {

        viagemViewModel
                .getContinenteSelecionado()
                .observe(
                        getViewLifecycleOwner(),
                        valor -> {

                            continente = valor;
                            atualizarLista();
                        }
                );

        viagemViewModel
                .getPaisSelecionado()
                .observe(
                        getViewLifecycleOwner(),
                        valor -> {

                            pais = valor;
                            atualizarLista();
                        }
                );

        viagemViewModel
                .getCidadeSelecionada()
                .observe(
                        getViewLifecycleOwner(),
                        valor -> {

                            cidade = valor;
                            atualizarLista();
                        }
                );

        viagemViewModel
                .getTipoSelecionado()
                .observe(
                        getViewLifecycleOwner(),
                        valor -> {

                            tipo = valor;
                            atualizarLista();
                        }
                );
    }

    private void atualizarLista() {

        if (continente == null
                || pais == null
                || cidade == null
                || tipo == null) {

            return;
        }

        txtContinenteSelecionado.setText(
                tipo + " - " + cidade
        );

        ArrayList<Estabelecimento> lista =
                new ArrayList<>();

        lista.add(
                new Estabelecimento(
                        tipo + " Central de " + cidade,
                        continente,
                        pais,
                        cidade,
                        tipo,
                        "Rua Central, 100 - " + cidade,
                        "08:00 às 20:00",
                        "Estabelecimento fictício localizado em "
                                + cidade + ".",
                        android.R.drawable.ic_menu_gallery
                )
        );

        lista.add(
                new Estabelecimento(
                        tipo + " Imperial de " + cidade,
                        continente,
                        pais,
                        cidade,
                        tipo,
                        "Avenida Principal, 200 - " + cidade,
                        "10:00 às 22:00",
                        "Outra opção fictícia de "
                                + tipo + " em " + cidade + ".",
                        android.R.drawable.ic_menu_gallery
                )
        );

        EstabelecimentoAdapter adapter =
                new EstabelecimentoAdapter(
                        requireContext(),
                        lista
                );

        listViewEstabelecimentos.setAdapter(adapter);

        listViewEstabelecimentos.setOnItemClickListener(
                (parent, view, position, id) -> {

                    Estabelecimento estabelecimento =
                            lista.get(position);

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
                            estabelecimento.getImagem()
                    );

                    startActivity(intent);
                }
        );
    }
}