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

            // =========================
            // BRASIL - BRASÍLIA
            // =========================
            case "Brasília":

                pratos.add(new Prato(
                        "Feijoada",
                        "Feijão preto, carnes, linguiça e temperos",
                        "Um dos pratos mais conhecidos da culinária brasileira.",
                        R.drawable.feijoada
                ));

                pratos.add(new Prato(
                        "Pão de Queijo",
                        "Polvilho, queijo, ovos e leite",
                        "Quitute brasileiro muito popular em cafés e lanches.",
                        R.drawable.pao_de_queijo
                ));

                pratos.add(new Prato(
                        "Brigadeiro",
                        "Leite condensado, chocolate e manteiga",
                        "Doce brasileiro muito popular em festas e comemorações.",
                        R.drawable.brigadeiro
                ));

                pratos.add(new Prato(
                        "Coxinha",
                        "Massa, frango desfiado e farinha de rosca",
                        "Salgado muito popular no Brasil.",
                        R.drawable.coxinha
                ));

                pratos.add(new Prato(
                        "Moqueca",
                        "Peixe, tomate, cebola, pimentão e temperos",
                        "Ensopado tradicional da culinária brasileira.",
                        R.drawable.moqueca
                ));

                pratos.add(new Prato(
                        "Acarajé",
                        "Feijão-fradinho, cebola e azeite de dendê",
                        "Prato tradicional especialmente associado à culinária baiana.",
                        R.drawable.acaraje
                ));

                pratos.add(new Prato(
                        "Arroz Carreteiro",
                        "Arroz, carne e temperos",
                        "Prato tradicional brasileiro preparado com arroz e carne.",
                        R.drawable.arroz_carreteiro
                ));

                break;


            // =========================
            // PARAGUAI - ASSUNÇÃO
            // =========================
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
                        "Preparação muito popular no Paraguai.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Mbejú",
                        "Amido de mandioca, queijo, manteiga e leite",
                        "Preparação tradicional paraguaia semelhante a uma panqueca.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Vori Vori",
                        "Farinha de milho, queijo, caldo e carne",
                        "Sopa tradicional paraguaia com pequenas bolas de milho.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Pastel Mandi'o",
                        "Mandioca, carne, cebola e temperos",
                        "Pastel tradicional preparado com massa à base de mandioca.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Chipa Guasu",
                        "Milho, queijo, leite, ovos e cebola",
                        "Prato tradicional paraguaio preparado principalmente com milho.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Pajagua Mascada",
                        "Mandioca, carne e temperos",
                        "Preparação tradicional paraguaia feita com mandioca e carne.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;


            // =========================
            // EGITO - CAIRO
            // =========================
            case "Cairo":

                pratos.add(new Prato(
                        "Koshari",
                        "Arroz, lentilha, macarrão e grão-de-bico",
                        "Um dos pratos populares mais conhecidos do Egito.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Falafel",
                        "Grão-de-bico, ervas e temperos",
                        "Preparação muito comum na culinária da região.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Ful Medames",
                        "Favas, azeite, limão e temperos",
                        "Prato tradicional muito consumido no Egito.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Molokhia",
                        "Folhas de molokhia, caldo, alho e temperos",
                        "Preparação tradicional da culinária egípcia.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Hawawshi",
                        "Pão, carne moída, cebola e temperos",
                        "Pão recheado com carne bastante conhecido no Egito.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Basbousa",
                        "Semolina, açúcar, manteiga e calda",
                        "Sobremesa bastante popular no Egito.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Umm Ali",
                        "Massa, leite, açúcar, castanhas e passas",
                        "Sobremesa tradicional egípcia servida quente.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;


            // =========================
            // NIGÉRIA - ABUJA
            // =========================
            case "Abuja":

                pratos.add(new Prato(
                        "Jollof Rice",
                        "Arroz, tomate, cebola, pimentão e temperos",
                        "Prato muito popular na Nigéria e na África Ocidental.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Suya",
                        "Carne bovina, amendoim e temperos",
                        "Espetinho condimentado bastante popular na Nigéria.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Egusi Soup",
                        "Sementes de melão, vegetais, carne e temperos",
                        "Sopa tradicional bastante popular na Nigéria.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Pounded Yam",
                        "Inhame e água",
                        "Acompanhamento tradicional preparado com inhame.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Moi Moi",
                        "Feijão, pimentão, cebola e temperos",
                        "Preparação nigeriana feita principalmente com feijão.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Akara",
                        "Feijão, cebola, pimenta e temperos",
                        "Bolinho frito de feijão muito consumido na Nigéria.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Pepper Soup",
                        "Carne ou peixe, caldo, pimenta e especiarias",
                        "Sopa condimentada bastante conhecida na culinária nigeriana.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;


            // =========================
            // RÚSSIA - MOSCOU
            // =========================
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
                        "Sopa muito conhecida na Rússia e no leste europeu.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Beef Stroganoff",
                        "Carne bovina, creme, cogumelos e temperos",
                        "Prato de origem russa conhecido internacionalmente.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Blini",
                        "Farinha, leite, ovos e manteiga",
                        "Panquecas finas tradicionais da culinária russa.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Shchi",
                        "Repolho, carne, legumes e caldo",
                        "Sopa de repolho tradicional da Rússia.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Salada Olivier",
                        "Batata, cenoura, ervilha, ovos e maionese",
                        "Salada muito conhecida na culinária russa.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Syrniki",
                        "Queijo, farinha, ovos e açúcar",
                        "Pequenas panquecas de queijo tradicionais.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;


            // =========================
            // GRÉCIA - ATENAS
            // =========================
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

                pratos.add(new Prato(
                        "Spanakopita",
                        "Massa filo, espinafre, queijo e temperos",
                        "Torta salgada tradicional da culinária grega.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Tzatziki",
                        "Iogurte, pepino, alho e azeite",
                        "Molho tradicional grego servido como acompanhamento.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Dolmades",
                        "Folhas de uva, arroz, ervas e temperos",
                        "Folhas de uva recheadas muito conhecidas na culinária grega.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Salada Grega",
                        "Tomate, pepino, cebola, azeitona e queijo feta",
                        "Salada tradicional preparada com ingredientes mediterrâneos.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Baklava",
                        "Massa filo, castanhas, manteiga e mel",
                        "Sobremesa em camadas muito popular na região.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;


            // =========================
            // COREIA DO SUL - SEUL
            // =========================
            case "Seul":

                pratos.add(new Prato(
                        "Bibimbap",
                        "Arroz, legumes, carne, ovo e pasta de pimenta",
                        "Prato tradicional coreano servido com diversos ingredientes.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Tteokbokki",
                        "Bolinhos de arroz e molho apimentado",
                        "Comida de rua muito popular na Coreia do Sul.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Bulgogi",
                        "Carne bovina, molho de soja, alho e açúcar",
                        "Carne marinada e grelhada muito conhecida na culinária coreana.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Japchae",
                        "Macarrão de batata-doce, legumes e carne",
                        "Prato coreano preparado com macarrão e vegetais.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Kimchi Jjigae",
                        "Kimchi, tofu, carne e caldo",
                        "Ensopado tradicional preparado com kimchi.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Samgyeopsal",
                        "Barriga de porco e acompanhamentos",
                        "Prato popular de carne grelhada na Coreia do Sul.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Hotteok",
                        "Massa, açúcar, canela e castanhas",
                        "Panqueca doce muito popular como comida de rua.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;


            // =========================
            // CHINA - PEQUIM
            // =========================
            case "Pequim":

                pratos.add(new Prato(
                        "Pato de Pequim",
                        "Pato assado, panquecas, cebolinha e molho",
                        "Um dos pratos mais conhecidos associados à cidade de Pequim.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Jiaozi",
                        "Massa, carne ou vegetais",
                        "Tipo de dumpling tradicional da culinária chinesa.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Zhajiangmian",
                        "Macarrão, carne e molho de soja fermentado",
                        "Prato de macarrão bastante associado à culinária de Pequim.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Baozi",
                        "Massa cozida no vapor e recheio de carne ou vegetais",
                        "Pão cozido no vapor muito popular na China.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Jianbing",
                        "Massa, ovo, cebolinha e molhos",
                        "Panqueca salgada popular como comida de rua.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Tanghulu",
                        "Frutas e calda de açúcar",
                        "Espetinho de frutas caramelizadas tradicional.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Hot Pot",
                        "Caldo, carnes, legumes, cogumelos e macarrão",
                        "Refeição em que os ingredientes são cozidos em caldo quente.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;


            // =========================
            // AUSTRÁLIA - CANBERRA
            // =========================
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
                        "Doce tradicional bastante conhecido na Austrália.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Damper",
                        "Farinha, água, sal e manteiga",
                        "Pão tradicional australiano.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Sausage Roll",
                        "Massa folhada, carne e temperos",
                        "Salgado popular preparado com carne envolvida em massa.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Barramundi",
                        "Peixe, limão, ervas e temperos",
                        "Peixe muito conhecido na culinária australiana.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "ANZAC Biscuit",
                        "Aveia, farinha, coco, manteiga e açúcar",
                        "Biscoito tradicional associado à história da Austrália e Nova Zelândia.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Vegemite Toast",
                        "Pão, manteiga e Vegemite",
                        "Lanche bastante associado à cultura alimentar australiana.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;


            // =========================
            // NOVA ZELÂNDIA - WELLINGTON
            // =========================
            case "Wellington":

                pratos.add(new Prato(
                        "Hangi",
                        "Carnes e vegetais",
                        "Método tradicional Māori de preparo de alimentos.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Pavlova",
                        "Merengue, creme e frutas",
                        "Sobremesa muito popular na Nova Zelândia.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Fish and Chips",
                        "Peixe, batatas, farinha e óleo",
                        "Refeição popular na Nova Zelândia.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Whitebait Fritter",
                        "Peixes pequenos, ovos e temperos",
                        "Preparação tradicional bastante conhecida na Nova Zelândia.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Cheese Roll",
                        "Pão, queijo, cebola e temperos",
                        "Lanche tradicional da Nova Zelândia.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Lamb Roast",
                        "Carne de cordeiro, batatas, legumes e ervas",
                        "Carne de cordeiro é bastante associada à culinária neozelandesa.",
                        android.R.drawable.ic_menu_gallery
                ));

                pratos.add(new Prato(
                        "Hokey Pokey Ice Cream",
                        "Sorvete de baunilha e pedaços de caramelo",
                        "Sabor de sorvete muito popular na Nova Zelândia.",
                        android.R.drawable.ic_menu_gallery
                ));

                break;
        }

        return pratos;
    }
}