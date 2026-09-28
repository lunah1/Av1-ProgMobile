package com.example.viagempelomundo.database;

import android.content.Context;

import com.example.viagempelomundo.dao.PratoDao;
import com.example.viagempelomundo.entity.Prato;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseInitializer {

    private static final ExecutorService executor =
            Executors.newSingleThreadExecutor();


    public static void inicializar(Context context) {

        executor.execute(() -> {

            AppDatabase database =
                    AppDatabase.getInstance(
                            context.getApplicationContext()
                    );

            PratoDao pratoDao =
                    database.pratoDao();


            // Só cadastra se o banco estiver vazio
            if (pratoDao.quantidade() == 0) {

                List<Prato> pratos =
                        criarPratosIniciais();

                pratoDao.inserirTodos(
                        pratos
                );
            }
        });
    }


    private static List<Prato>
    criarPratosIniciais() {

        List<Prato> pratos =
                new ArrayList<>();


        // =========================
        // BRASIL - BRASÍLIA
        // =========================

        pratos.add(
                new Prato(
                        "Feijoada",
                        "Brasília",
                        "Feijão preto, carnes, linguiça e temperos",
                        "Um dos pratos mais conhecidos da culinária brasileira.",
                        "feijoada",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Pão de Queijo",
                        "Brasília",
                        "Polvilho, queijo, ovos e leite",
                        "Quitute brasileiro muito popular em cafés e lanches.",
                        "pao_de_queijo",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Brigadeiro",
                        "Brasília",
                        "Leite condensado, chocolate e manteiga",
                        "Doce brasileiro muito popular em festas e comemorações.",
                        "brigadeiro",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Coxinha",
                        "Brasília",
                        "Massa, frango desfiado e farinha de rosca",
                        "Salgado muito popular no Brasil.",
                        "coxinha",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Moqueca",
                        "Brasília",
                        "Peixe, tomate, cebola, pimentão e temperos",
                        "Ensopado tradicional da culinária brasileira.",
                        "moqueca",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Acarajé",
                        "Brasília",
                        "Feijão-fradinho, cebola e azeite de dendê",
                        "Prato tradicional especialmente associado à culinária baiana.",
                        "acaraje",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Arroz Carreteiro",
                        "Brasília",
                        "Arroz, carne e temperos",
                        "Prato tradicional brasileiro preparado com arroz e carne.",
                        "arroz_carreteiro",
                        null
                )
        );


        // =========================
        // PARAGUAI - ASSUNÇÃO
        // =========================

        pratos.add(
                new Prato(
                        "Sopa Paraguaia",
                        "Assunção",
                        "Farinha de milho, queijo, cebola, leite e ovos",
                        "Apesar do nome, é um prato sólido tradicional do Paraguai.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Chipa",
                        "Assunção",
                        "Polvilho, queijo, ovos e leite",
                        "Preparação muito popular no Paraguai.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Mbejú",
                        "Assunção",
                        "Amido de mandioca, queijo, manteiga e leite",
                        "Preparação tradicional paraguaia semelhante a uma panqueca.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =========================
        // EGITO - CAIRO
        // =========================

        pratos.add(
                new Prato(
                        "Koshari",
                        "Cairo",
                        "Arroz, lentilha, macarrão e grão-de-bico",
                        "Um dos pratos populares mais conhecidos do Egito.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Falafel",
                        "Cairo",
                        "Grão-de-bico, ervas e temperos",
                        "Preparação muito comum na culinária da região.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Ful Medames",
                        "Cairo",
                        "Favas, azeite, limão e temperos",
                        "Prato tradicional muito consumido no Egito.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =========================
        // NIGÉRIA - ABUJA
        // =========================

        pratos.add(
                new Prato(
                        "Jollof Rice",
                        "Abuja",
                        "Arroz, tomate, cebola, pimentão e temperos",
                        "Prato muito popular na Nigéria e na África Ocidental.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Suya",
                        "Abuja",
                        "Carne bovina, amendoim e temperos",
                        "Espetinho condimentado bastante popular na Nigéria.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =========================
        // RÚSSIA - MOSCOU
        // =========================

        pratos.add(
                new Prato(
                        "Pelmeni",
                        "Moscou",
                        "Massa, carne moída, cebola e temperos",
                        "Bolinhos recheados tradicionais da culinária russa.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Borscht",
                        "Moscou",
                        "Beterraba, legumes, carne e caldo",
                        "Sopa muito conhecida na Rússia e no leste europeu.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Beef Stroganoff",
                        "Moscou",
                        "Carne bovina, creme, cogumelos e temperos",
                        "Prato de origem russa conhecido internacionalmente.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =========================
        // GRÉCIA - ATENAS
        // =========================

        pratos.add(
                new Prato(
                        "Moussaka",
                        "Atenas",
                        "Berinjela, carne, tomate e molho bechamel",
                        "Prato bastante associado à culinária grega.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Souvlaki",
                        "Atenas",
                        "Carne, azeite, ervas e vegetais",
                        "Espetinho tradicional muito popular na Grécia.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =========================
        // COREIA DO SUL - SEUL
        // =========================

        pratos.add(
                new Prato(
                        "Bibimbap",
                        "Seul",
                        "Arroz, legumes, carne, ovo e pasta de pimenta",
                        "Prato tradicional coreano servido com diversos ingredientes.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Tteokbokki",
                        "Seul",
                        "Bolinhos de arroz e molho apimentado",
                        "Comida de rua muito popular na Coreia do Sul.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =========================
        // CHINA - PEQUIM
        // =========================

        pratos.add(
                new Prato(
                        "Pato de Pequim",
                        "Pequim",
                        "Pato assado, panquecas, cebolinha e molho",
                        "Um dos pratos mais conhecidos associados à cidade de Pequim.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Jiaozi",
                        "Pequim",
                        "Massa, carne ou vegetais",
                        "Tipo de dumpling tradicional da culinária chinesa.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =========================
        // AUSTRÁLIA - CANBERRA
        // =========================

        pratos.add(
                new Prato(
                        "Meat Pie",
                        "Canberra",
                        "Massa, carne bovina e molho",
                        "Torta salgada muito popular na Austrália.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Lamington",
                        "Canberra",
                        "Bolo, chocolate e coco ralado",
                        "Doce tradicional bastante conhecido na Austrália.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =========================
        // NOVA ZELÂNDIA - WELLINGTON
        // =========================

        pratos.add(
                new Prato(
                        "Hangi",
                        "Wellington",
                        "Carnes e vegetais",
                        "Método tradicional Māori de preparo de alimentos.",
                        "ic_menu_gallery",
                        null
                )
        );

        pratos.add(
                new Prato(
                        "Pavlova",
                        "Wellington",
                        "Merengue, creme e frutas",
                        "Sobremesa muito popular na Nova Zelândia.",
                        "ic_menu_gallery",
                        null
                )
        );


        return pratos;
    }
}