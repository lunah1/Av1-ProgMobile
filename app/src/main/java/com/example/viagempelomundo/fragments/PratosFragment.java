package com.example.viagempelomundo.fragments;

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

import com.example.viagempelomundo.R;
import com.example.viagempelomundo.adapter.PratoAdapter;
import com.example.viagempelomundo.model.Prato;
import com.example.viagempelomundo.viewmodel.ViagemViewModel;
import android.content.Intent;

import com.example.viagempelomundo.DetalhesActivity;

import java.util.ArrayList;

public class PratosFragment extends Fragment {

    private GridView gridViewPratos;
    private TextView txtTituloPratos;

    private ViagemViewModel viagemViewModel;

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

        txtTituloPratos =
                view.findViewById(R.id.txt_titulo_pratos);

        // Mesmo ViewModel usado pelos outros Fragmentos
        viagemViewModel =
                new ViewModelProvider(requireActivity())
                        .get(ViagemViewModel.class);

        observarCidade();
    }

    private void observarCidade() {

        viagemViewModel
                .getCidadeSelecionada()
                .observe(
                        getViewLifecycleOwner(),
                        cidade -> {

                            if (cidade != null) {
                                atualizarPratos(cidade);
                            }
                        }
                );
    }

    private void atualizarPratos(String cidade) {

        txtTituloPratos.setText(
                "Pratos e bebidas - " + cidade
        );

        ArrayList<Prato> pratos = criarPratos(cidade);

        PratoAdapter adapter = new PratoAdapter(
                        requireContext(),
                        pratos
                );

        gridViewPratos.setAdapter(adapter);

        gridViewPratos.setOnItemClickListener(
                (parent, view, position, id) -> {

                    Prato prato = pratos.get(position);

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
                            prato.getImagem()
                    );

                    startActivity(intent);
                }
        );
    }

    private ArrayList<Prato> criarPratos(String cidade) {

        ArrayList<Prato> pratos = new ArrayList<>();

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

            case "Assunção":

                pratos.add(new Prato(
                        "Sopa Paraguaia",
                        "Farinha de milho, queijo, cebola, leite e ovos",
                        "Apesar do nome, é um prato sólido tradicional do Paraguai.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Chipa",
                        "Polvilho, queijo, ovos e leite",
                        "Pão de queijo tradicional muito popular no Paraguai.",
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

            case "Abuja":

                pratos.add(new Prato(
                        "Jollof Rice",
                        "Arroz, tomate, cebola, pimentão e temperos",
                        "Prato muito popular na Nigéria.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Suya",
                        "Carne bovina, amendoim e temperos",
                        "Espetinho condimentado popular na Nigéria.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;

            case "Moscou":

                pratos.add(new Prato(
                        "Pelmeni",
                        "Massa, carne moída, cebola e temperos",
                        "Bolinhos recheados tradicionais da culinária russa.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Borscht",
                        "Beterraba, legumes, carne e caldo",
                        "Sopa muito conhecida no leste europeu.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;

            case "Atenas":

                pratos.add(new Prato(
                        "Moussaka",
                        "Berinjela, carne, tomate e molho bechamel",
                        "Prato bastante associado à culinária grega.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Souvlaki",
                        "Carne, azeite, ervas e vegetais",
                        "Espetinho tradicional muito popular na Grécia.",
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

            case "Canberra":

                pratos.add(new Prato(
                        "Meat Pie",
                        "Massa, carne bovina e molho",
                        "Torta salgada muito popular na Austrália.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Lamington",
                        "Bolo, chocolate e coco ralado",
                        "Doce tradicional australiano.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;

            case "Wellington":

                pratos.add(new Prato(
                        "Hangi",
                        "Carnes e vegetais",
                        "Preparação tradicional Māori.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Pavlova",
                        "Merengue, creme e frutas",
                        "Sobremesa muito popular na Nova Zelândia.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;
        }

        return pratos;
    }
}