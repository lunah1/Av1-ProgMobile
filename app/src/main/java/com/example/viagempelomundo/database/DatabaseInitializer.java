package com.example.viagempelomundo.database;

import android.content.Context;

import com.example.viagempelomundo.dao.CategoriaDao;
import com.example.viagempelomundo.dao.EstabelecimentoDao;
import com.example.viagempelomundo.dao.PratoDao;

import com.example.viagempelomundo.entity.Categoria;
import com.example.viagempelomundo.entity.Estabelecimento;
import com.example.viagempelomundo.entity.Prato;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseInitializer {



    private static final int CATEGORIA_RESTAURANTE = 1;
    private static final int CATEGORIA_CAFE = 2;
    private static final int CATEGORIA_BAR = 3;


    private static final ExecutorService executor =
            Executors.newSingleThreadExecutor();


    private DatabaseInitializer() {

    }



    public static void inicializar(Context context) {

        executor.execute(() -> {

            AppDatabase database =
                    AppDatabase.getInstance(
                            context.getApplicationContext()
                    );


            CategoriaDao categoriaDao =
                    database.categoriaDao();

            EstabelecimentoDao estabelecimentoDao =
                    database.estabelecimentoDao();

            PratoDao pratoDao =
                    database.pratoDao();



            if (categoriaDao.quantidade() == 0) {

                categoriaDao.inserirTodos(
                        criarCategoriasIniciais()
                );
            }


            if (estabelecimentoDao.quantidade() == 0) {

                estabelecimentoDao.inserirTodos(
                        criarEstabelecimentosIniciais()
                );
            }



            if (pratoDao.quantidade() == 0) {

                pratoDao.inserirTodos(
                        criarPratosIniciais()
                );
            }
        });
    }


    // =========================================================
    // CATEGORIAS
    // =========================================================

    private static List<Categoria>
    criarCategoriasIniciais() {

        List<Categoria> categorias =
                new ArrayList<>();


        categorias.add(
                new Categoria(
                        CATEGORIA_RESTAURANTE,
                        "Restaurante"
                )
        );


        categorias.add(
                new Categoria(
                        CATEGORIA_CAFE,
                        "Café"
                )
        );


        categorias.add(
                new Categoria(
                        CATEGORIA_BAR,
                        "Bar"
                )
        );


        return categorias;
    }


    // =========================================================
    // ESTABELECIMENTOS
    // =========================================================

    private static List<Estabelecimento>
    criarEstabelecimentosIniciais() {

        List<Estabelecimento> estabelecimentos =
                new ArrayList<>();


        // =====================================================
        // AMÉRICA
        // =====================================================

        adicionarEstabelecimentos(
                estabelecimentos,
                "América",
                "Brasil",
                "Brasília"
        );


        adicionarEstabelecimentos(
                estabelecimentos,
                "América",
                "Paraguai",
                "Assunção"
        );


        // =====================================================
        // ÁFRICA
        // =====================================================

        adicionarEstabelecimentos(
                estabelecimentos,
                "África",
                "Egito",
                "Cairo"
        );


        adicionarEstabelecimentos(
                estabelecimentos,
                "África",
                "Nigéria",
                "Abuja"
        );


        // =====================================================
        // EUROPA
        // =====================================================

        adicionarEstabelecimentos(
                estabelecimentos,
                "Europa",
                "Rússia",
                "Moscou"
        );


        adicionarEstabelecimentos(
                estabelecimentos,
                "Europa",
                "Grécia",
                "Atenas"
        );


        // =====================================================
        // ÁSIA
        // =====================================================

        adicionarEstabelecimentos(
                estabelecimentos,
                "Ásia",
                "Coreia do Sul",
                "Seul"
        );


        adicionarEstabelecimentos(
                estabelecimentos,
                "Ásia",
                "China",
                "Pequim"
        );


        // =====================================================
        // OCEANIA
        // =====================================================

        adicionarEstabelecimentos(
                estabelecimentos,
                "Oceania",
                "Austrália",
                "Canberra"
        );


        adicionarEstabelecimentos(
                estabelecimentos,
                "Oceania",
                "Nova Zelândia",
                "Wellington"
        );


        return estabelecimentos;
    }


    // =========================================================
    // ADICIONA AS 3 CATEGORIAS DE UMA CIDADE
    // =========================================================

    private static void adicionarEstabelecimentos(
            List<Estabelecimento> lista,
            String continente,
            String pais,
            String cidade
    ) {

        adicionarCategoria(
                lista,
                continente,
                pais,
                cidade,
                CATEGORIA_RESTAURANTE,
                "Restaurante"
        );


        adicionarCategoria(
                lista,
                continente,
                pais,
                cidade,
                CATEGORIA_CAFE,
                "Café"
        );


        adicionarCategoria(
                lista,
                continente,
                pais,
                cidade,
                CATEGORIA_BAR,
                "Bar"
        );
    }


    // =========================================================
    // CRIA 5 ESTABELECIMENTOS DE UMA CATEGORIA
    // =========================================================

    private static void adicionarCategoria(
            List<Estabelecimento> lista,
            String continente,
            String pais,
            String cidade,
            int categoriaId,
            String categoriaNome
    ) {

        String[] complementos = {
                "Central",
                "Imperial",
                "da Praça",
                "Cultural",
                "do Mundo"
        };


        String[] horarios = {
                "08:00 às 22:00",
                "09:00 às 23:00",
                "10:00 às 00:00",
                "07:00 às 21:00",
                "11:00 às 23:30"
        };


        for (int i = 0; i < 5; i++) {

            String nome =
                    categoriaNome
                            + " "
                            + complementos[i]
                            + " - "
                            + cidade;


            String endereco =
                    "Região Central, "
                            + (i + 1) * 100
                            + " - "
                            + cidade
                            + ", "
                            + pais;


            String descricao =
                    categoriaNome
                            + " localizado em "
                            + cidade
                            + ", "
                            + pais
                            + ". Estabelecimento selecionado pelo "
                            + "guia Viagem pelo Mundo para apresentar "
                            + "opções gastronômicas e culturais locais.";


            lista.add(
                    new Estabelecimento(
                            nome,
                            continente,
                            pais,
                            cidade,
                            categoriaId,
                            endereco,
                            horarios[i],
                            descricao,
                            "ic_menu_gallery"
                    )
            );
        }
    }


    // =========================================================
    // PRATOS
    // =========================================================

    private static List<Prato>
    criarPratosIniciais() {

        List<Prato> pratos =
                new ArrayList<>();


        // =====================================================
        // BRASIL - BRASÍLIA
        // =====================================================

        pratos.add(
                new Prato(
                        "Feijoada",
                        "Brasília",
                        "Feijão preto, carnes suínas, linguiça e temperos.",
                        "Um dos pratos mais conhecidos da culinária brasileira.",
                        "feijoada",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Pão de Queijo",
                        "Brasília",
                        "Polvilho, queijo, leite, ovos e óleo.",
                        "Muito associado à culinária de Minas Gerais e popular em todo o Brasil.",
                        "pao_de_queijo",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Brigadeiro",
                        "Brasília",
                        "Leite condensado, chocolate e manteiga.",
                        "Doce tradicional brasileiro muito presente em festas.",
                        "brigadeiro",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Coxinha",
                        "Brasília",
                        "Massa, frango desfiado, farinha e temperos.",
                        "Salgado muito popular no Brasil.",
                        "coxinha",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Moqueca",
                        "Brasília",
                        "Peixe, tomate, cebola, pimentão e temperos.",
                        "Prato tradicional brasileiro com diferentes versões regionais.",
                        "moqueca",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Acarajé",
                        "Brasília",
                        "Feijão-fradinho, cebola e azeite de dendê.",
                        "Prato profundamente ligado à cultura afro-brasileira.",
                        "acaraje",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Arroz Carreteiro",
                        "Brasília",
                        "Arroz, carne, cebola, alho e temperos.",
                        "Prato tradicional associado à região Sul do Brasil.",
                        "arroz_carreteiro",
                        null
                )
        );


        // =====================================================
        // PARAGUAI - ASSUNÇÃO
        // =====================================================

        pratos.add(
                new Prato(
                        "Sopa Paraguaia",
                        "Assunção",
                        "Farinha de milho, queijo, cebola, ovos e leite.",
                        "Apesar do nome, é um bolo salgado tradicional do Paraguai.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Chipa",
                        "Assunção",
                        "Polvilho, queijo, ovos e leite.",
                        "Preparação tradicional paraguaia muito consumida no cotidiano.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Mbejú",
                        "Assunção",
                        "Fécula de mandioca, queijo e gordura.",
                        "Alimento tradicional da cultura guarani-paraguaia.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Vori Vori",
                        "Assunção",
                        "Caldo, farinha de milho, queijo e carne.",
                        "Sopa tradicional com pequenas bolinhas de milho e queijo.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Pastel Mandi'o",
                        "Assunção",
                        "Mandioca, farinha de milho e carne.",
                        "Pastel tradicional paraguaio feito com massa de mandioca.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Chipa Guasu",
                        "Assunção",
                        "Milho, queijo, leite, ovos e cebola.",
                        "Prato típico paraguaio preparado principalmente com milho.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Pajagua Mascada",
                        "Assunção",
                        "Mandioca, carne e temperos.",
                        "Preparação tradicional paraguaia à base de mandioca.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =====================================================
        // EGITO - CAIRO
        // =====================================================

        pratos.add(
                new Prato(
                        "Koshari",
                        "Cairo",
                        "Arroz, lentilha, macarrão, grão-de-bico e molho de tomate.",
                        "Um dos pratos populares mais conhecidos do Egito.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Falafel",
                        "Cairo",
                        "Favas ou grão-de-bico, ervas e especiarias.",
                        "Preparação muito tradicional no Egito e em outros países da região.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Ful Medames",
                        "Cairo",
                        "Favas cozidas, azeite, limão e temperos.",
                        "Prato tradicional egípcio consumido frequentemente no café da manhã.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Molokhia",
                        "Cairo",
                        "Folhas de molokhia, caldo, alho e coentro.",
                        "Prato tradicional presente na culinária egípcia.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Hawawshi",
                        "Cairo",
                        "Pão, carne moída, cebola e especiarias.",
                        "Comida popular egípcia feita com pão recheado.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Basbousa",
                        "Cairo",
                        "Sêmola, açúcar, manteiga e calda.",
                        "Sobremesa tradicional bastante difundida no Oriente Médio.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Umm Ali",
                        "Cairo",
                        "Massa, leite, açúcar, castanhas e frutas secas.",
                        "Sobremesa egípcia tradicional servida quente.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =====================================================
        // NIGÉRIA - ABUJA
        // =====================================================

        pratos.add(
                new Prato(
                        "Jollof Rice",
                        "Abuja",
                        "Arroz, tomate, pimentão, cebola e especiarias.",
                        "Prato muito popular na África Ocidental.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Suya",
                        "Abuja",
                        "Carne grelhada e mistura de especiarias.",
                        "Espetinho muito popular nas ruas nigerianas.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Egusi Soup",
                        "Abuja",
                        "Sementes de melão, vegetais, carne e especiarias.",
                        "Sopa tradicional encontrada em várias regiões da Nigéria.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Pounded Yam",
                        "Abuja",
                        "Inhame cozido e amassado.",
                        "Acompanhamento tradicional nigeriano.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Moi Moi",
                        "Abuja",
                        "Feijão, pimentão, cebola e especiarias.",
                        "Pudim salgado tradicional preparado com feijão.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Akara",
                        "Abuja",
                        "Feijão, cebola e temperos.",
                        "Bolinho frito tradicional da culinária nigeriana.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Pepper Soup",
                        "Abuja",
                        "Carne ou peixe, caldo e especiarias.",
                        "Sopa picante bastante conhecida na Nigéria.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =====================================================
        // RÚSSIA - MOSCOU
        // =====================================================

        pratos.add(
                new Prato(
                        "Pelmeni",
                        "Moscou",
                        "Massa recheada com carne e temperos.",
                        "Um dos pratos tradicionais mais conhecidos da Rússia.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Borscht",
                        "Moscou",
                        "Beterraba, vegetais e caldo.",
                        "Sopa muito conhecida no Leste Europeu.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Beef Stroganoff",
                        "Moscou",
                        "Carne, creme, cebola e cogumelos.",
                        "Prato de origem russa conhecido internacionalmente.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Blini",
                        "Moscou",
                        "Farinha, leite, ovos e manteiga.",
                        "Panqueca tradicional russa servida com diversos acompanhamentos.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Shchi",
                        "Moscou",
                        "Repolho, vegetais e caldo.",
                        "Sopa tradicional da culinária russa.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Salada Olivier",
                        "Moscou",
                        "Batata, cenoura, ervilha, ovos e maionese.",
                        "Salada tradicional muito popular na Rússia.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Syrniki",
                        "Moscou",
                        "Queijo fresco, farinha, ovos e açúcar.",
                        "Panquecas de queijo tradicionais.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =====================================================
        // GRÉCIA - ATENAS
        // =====================================================

        pratos.add(
                new Prato(
                        "Moussaka",
                        "Atenas",
                        "Berinjela, carne, tomate e molho cremoso.",
                        "Um dos pratos gregos mais conhecidos internacionalmente.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Souvlaki",
                        "Atenas",
                        "Carne grelhada, pão pita e temperos.",
                        "Comida popular e tradicional da Grécia.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Spanakopita",
                        "Atenas",
                        "Massa filo, espinafre e queijo feta.",
                        "Torta salgada tradicional grega.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Tzatziki",
                        "Atenas",
                        "Iogurte, pepino, alho e azeite.",
                        "Acompanhamento muito conhecido da culinária grega.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Dolmades",
                        "Atenas",
                        "Folhas de uva, arroz, ervas e temperos.",
                        "Preparação tradicional encontrada na Grécia.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Salada Grega",
                        "Atenas",
                        "Tomate, pepino, azeitona, cebola e queijo feta.",
                        "Salada tradicional associada à culinária mediterrânea grega.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Baklava",
                        "Atenas",
                        "Massa filo, castanhas, mel ou calda.",
                        "Sobremesa tradicional encontrada na Grécia e em outras regiões.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =====================================================
        // COREIA DO SUL - SEUL
        // =====================================================

        pratos.add(
                new Prato(
                        "Bibimbap",
                        "Seul",
                        "Arroz, vegetais, carne, ovo e molho.",
                        "Prato coreano conhecido pela combinação de ingredientes.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Tteokbokki",
                        "Seul",
                        "Bolos de arroz e molho picante.",
                        "Comida de rua muito popular na Coreia do Sul.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Bulgogi",
                        "Seul",
                        "Carne marinada, molho de soja e temperos.",
                        "Carne marinada e grelhada bastante tradicional.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Japchae",
                        "Seul",
                        "Macarrão de batata-doce, vegetais e carne.",
                        "Prato coreano preparado com macarrão translúcido.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Kimchi Jjigae",
                        "Seul",
                        "Kimchi, tofu, carne e caldo.",
                        "Ensopado tradicional feito com kimchi.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Samgyeopsal",
                        "Seul",
                        "Barriga de porco grelhada e acompanhamentos.",
                        "Prato muito comum em refeições coreanas compartilhadas.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Hotteok",
                        "Seul",
                        "Massa, açúcar, canela e sementes.",
                        "Panqueca doce popular como comida de rua.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =====================================================
        // CHINA - PEQUIM
        // =====================================================

        pratos.add(
                new Prato(
                        "Pato de Pequim",
                        "Pequim",
                        "Pato assado, panquecas finas e acompanhamentos.",
                        "Prato tradicional fortemente associado à cidade de Pequim.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Jiaozi",
                        "Pequim",
                        "Massa recheada com carne ou vegetais.",
                        "Tipo tradicional de dumpling chinês.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Zhajiangmian",
                        "Pequim",
                        "Macarrão e molho à base de pasta fermentada.",
                        "Prato de macarrão tradicional de Pequim.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Baozi",
                        "Pequim",
                        "Massa cozida no vapor com recheio.",
                        "Pão recheado muito difundido na culinária chinesa.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Jianbing",
                        "Pequim",
                        "Massa fina, ovo, molho e acompanhamentos.",
                        "Comida de rua chinesa semelhante a uma panqueca.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Tanghulu",
                        "Pequim",
                        "Frutas cobertas por calda de açúcar.",
                        "Doce de rua tradicional encontrado no norte da China.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Hot Pot",
                        "Pequim",
                        "Caldo, carnes, vegetais e outros acompanhamentos.",
                        "Forma de refeição compartilhada popular em várias regiões chinesas.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =====================================================
        // AUSTRÁLIA - CANBERRA
        // =====================================================

        pratos.add(
                new Prato(
                        "Meat Pie",
                        "Canberra",
                        "Massa e recheio de carne.",
                        "Torta de carne muito popular na Austrália.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Lamington",
                        "Canberra",
                        "Bolo, chocolate e coco.",
                        "Doce tradicional australiano.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Damper",
                        "Canberra",
                        "Farinha, água e sal.",
                        "Pão tradicional associado à história rural australiana.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Sausage Roll",
                        "Canberra",
                        "Massa folhada e linguiça ou carne.",
                        "Salgado bastante popular na Austrália.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Barramundi",
                        "Canberra",
                        "Peixe barramundi e temperos.",
                        "Peixe muito associado à gastronomia australiana.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "ANZAC Biscuit",
                        "Canberra",
                        "Aveia, farinha, coco e açúcar.",
                        "Biscoito associado à história australiana e neozelandesa.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Vegemite Toast",
                        "Canberra",
                        "Pão, manteiga e Vegemite.",
                        "Combinação muito conhecida na cultura alimentar australiana.",
                        "ic_menu_gallery",
                        null
                )
        );


        // =====================================================
        // NOVA ZELÂNDIA - WELLINGTON
        // =====================================================

        pratos.add(
                new Prato(
                        "Hangi",
                        "Wellington",
                        "Carnes e vegetais preparados tradicionalmente em forno de terra.",
                        "Método culinário tradicional da cultura Māori.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Pavlova",
                        "Wellington",
                        "Merengue, creme e frutas.",
                        "Sobremesa muito conhecida na Nova Zelândia.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Fish and Chips",
                        "Wellington",
                        "Peixe empanado e batatas fritas.",
                        "Refeição popular na Nova Zelândia.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Whitebait Fritter",
                        "Wellington",
                        "Peixes pequenos, ovos e temperos.",
                        "Prato associado à culinária neozelandesa.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Cheese Roll",
                        "Wellington",
                        "Pão, queijo e temperos.",
                        "Preparação bastante conhecida em regiões da Nova Zelândia.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Lamb Roast",
                        "Wellington",
                        "Carne de cordeiro, vegetais e ervas.",
                        "O cordeiro tem presença importante na gastronomia neozelandesa.",
                        "ic_menu_gallery",
                        null
                )
        );


        pratos.add(
                new Prato(
                        "Hokey Pokey Ice Cream",
                        "Wellington",
                        "Sorvete de baunilha e pedaços de caramelo.",
                        "Sabor de sorvete muito popular na Nova Zelândia.",
                        "ic_menu_gallery",
                        null
                )
        );


        return pratos;
    }
}