package com.example.viagempelomundo.database;

import android.content.Context;

import com.example.viagempelomundo.dao.PratoDao;
import com.example.viagempelomundo.entity.Prato;
import com.example.viagempelomundo.dao.EstabelecimentoDao;
import com.example.viagempelomundo.entity.Estabelecimento;

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

            EstabelecimentoDao estabelecimentoDao =
                    database.estabelecimentoDao();


            // Só cadastra se o banco estiver vazio
            if (pratoDao.quantidade() == 0) {

                List<Prato> pratos =
                        criarPratosIniciais();

                pratoDao.inserirTodos(
                        pratos
                );
            }

            if (estabelecimentoDao.quantidade() == 0) {

                List<Estabelecimento> estabelecimentos =
                        criarEstabelecimentosIniciais();

                estabelecimentoDao.inserirTodos(
                        estabelecimentos
                );
            }
        });
    }

    private static List<Estabelecimento>
    criarEstabelecimentosIniciais() {

        List<Estabelecimento> estabelecimentos =
                new ArrayList<>();


        // BRASÍLIA

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Central de Brasília",
                        "América",
                        "Brasil",
                        "Brasília",
                        "Restaurante",
                        "Rua Central, 100 - Brasília",
                        "08:00 às 20:00",
                        "Estabelecimento localizado em Brasília.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Imperial de Brasília",
                        "América",
                        "Brasil",
                        "Brasília",
                        "Restaurante",
                        "Avenida Principal, 200 - Brasília",
                        "10:00 às 22:00",
                        "Outra opção de restaurante em Brasília.",
                        "ic_menu_gallery"
                )
        );


        // ASSUNÇÃO

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Central de Assunção",
                        "América",
                        "Paraguai",
                        "Assunção",
                        "Restaurante",
                        "Rua Central, 100 - Assunção",
                        "08:00 às 20:00",
                        "Estabelecimento localizado em Assunção.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Imperial de Assunção",
                        "América",
                        "Paraguai",
                        "Assunção",
                        "Restaurante",
                        "Avenida Principal, 200 - Assunção",
                        "10:00 às 22:00",
                        "Outra opção de restaurante em Assunção.",
                        "ic_menu_gallery"
                )
        );


        // CAIRO

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Central do Cairo",
                        "África",
                        "Egito",
                        "Cairo",
                        "Restaurante",
                        "Rua Central, 100 - Cairo",
                        "08:00 às 20:00",
                        "Estabelecimento localizado no Cairo.",
                        "ic_menu_gallery"
                )
        );


        // ABUJA

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Central de Abuja",
                        "África",
                        "Nigéria",
                        "Abuja",
                        "Restaurante",
                        "Rua Central, 100 - Abuja",
                        "08:00 às 20:00",
                        "Estabelecimento localizado em Abuja.",
                        "ic_menu_gallery"
                )
        );


        // MOSCOU

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Central de Moscou",
                        "Europa",
                        "Rússia",
                        "Moscou",
                        "Restaurante",
                        "Rua Central, 100 - Moscou",
                        "08:00 às 20:00",
                        "Estabelecimento localizado em Moscou.",
                        "ic_menu_gallery"
                )
        );


        // ATENAS

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Central de Atenas",
                        "Europa",
                        "Grécia",
                        "Atenas",
                        "Restaurante",
                        "Rua Central, 100 - Atenas",
                        "08:00 às 20:00",
                        "Estabelecimento localizado em Atenas.",
                        "ic_menu_gallery"
                )
        );


        // SEUL

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Central de Seul",
                        "Ásia",
                        "Coreia do Sul",
                        "Seul",
                        "Restaurante",
                        "Rua Central, 100 - Seul",
                        "08:00 às 20:00",
                        "Estabelecimento localizado em Seul.",
                        "ic_menu_gallery"
                )
        );


        // PEQUIM

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Central de Pequim",
                        "Ásia",
                        "China",
                        "Pequim",
                        "Restaurante",
                        "Rua Central, 100 - Pequim",
                        "08:00 às 20:00",
                        "Estabelecimento localizado em Pequim.",
                        "ic_menu_gallery"
                )
        );


        // CANBERRA

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Central de Canberra",
                        "Oceania",
                        "Austrália",
                        "Canberra",
                        "Restaurante",
                        "Rua Central, 100 - Canberra",
                        "08:00 às 20:00",
                        "Estabelecimento localizado em Canberra.",
                        "ic_menu_gallery"
                )
        );


        // WELLINGTON

        estabelecimentos.add(
                new Estabelecimento(
                        "Restaurante Central de Wellington",
                        "Oceania",
                        "Nova Zelândia",
                        "Wellington",
                        "Restaurante",
                        "Rua Central, 100 - Wellington",
                        "08:00 às 20:00",
                        "Estabelecimento localizado em Wellington.",
                        "ic_menu_gallery"
                )
        );

        // =====================================================
// CAFÉS E BARES
// =====================================================


// =========================
// BRASIL - BRASÍLIA
// =========================

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Central de Brasília",
                        "América",
                        "Brasil",
                        "Brasília",
                        "Café",
                        "Avenida Central, 150 - Brasília",
                        "07:00 às 19:00",
                        "Café fictício localizado em Brasília, com bebidas quentes, doces e lanches.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Imperial de Brasília",
                        "América",
                        "Brasil",
                        "Brasília",
                        "Café",
                        "Rua das Flores, 85 - Brasília",
                        "08:00 às 20:00",
                        "Café fictício com ambiente tranquilo e opções de lanches.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Central de Brasília",
                        "América",
                        "Brasil",
                        "Brasília",
                        "Bar",
                        "Avenida Principal, 300 - Brasília",
                        "17:00 às 02:00",
                        "Bar fictício localizado em Brasília.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Imperial de Brasília",
                        "América",
                        "Brasil",
                        "Brasília",
                        "Bar",
                        "Rua Principal, 220 - Brasília",
                        "18:00 às 01:00",
                        "Bar fictício com ambiente descontraído em Brasília.",
                        "ic_menu_gallery"
                )
        );


// =========================
// PARAGUAI - ASSUNÇÃO
// =========================

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Central de Assunção",
                        "América",
                        "Paraguai",
                        "Assunção",
                        "Café",
                        "Rua Central, 120 - Assunção",
                        "07:00 às 19:00",
                        "Café fictício localizado em Assunção.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Imperial de Assunção",
                        "América",
                        "Paraguai",
                        "Assunção",
                        "Café",
                        "Avenida Principal, 180 - Assunção",
                        "08:00 às 20:00",
                        "Café fictício com bebidas e lanches em Assunção.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Central de Assunção",
                        "América",
                        "Paraguai",
                        "Assunção",
                        "Bar",
                        "Rua Noturna, 210 - Assunção",
                        "17:00 às 02:00",
                        "Bar fictício localizado em Assunção.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Imperial de Assunção",
                        "América",
                        "Paraguai",
                        "Assunção",
                        "Bar",
                        "Avenida Principal, 320 - Assunção",
                        "18:00 às 01:00",
                        "Bar fictício com ambiente descontraído em Assunção.",
                        "ic_menu_gallery"
                )
        );


// =========================
// EGITO - CAIRO
// =========================

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Central do Cairo",
                        "África",
                        "Egito",
                        "Cairo",
                        "Café",
                        "Rua Central, 120 - Cairo",
                        "07:00 às 19:00",
                        "Café fictício localizado no Cairo.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Imperial do Cairo",
                        "África",
                        "Egito",
                        "Cairo",
                        "Café",
                        "Avenida Principal, 180 - Cairo",
                        "08:00 às 20:00",
                        "Café fictício com bebidas e lanches no Cairo.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Central do Cairo",
                        "África",
                        "Egito",
                        "Cairo",
                        "Bar",
                        "Rua Principal, 210 - Cairo",
                        "17:00 às 01:00",
                        "Bar fictício localizado no Cairo.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Imperial do Cairo",
                        "África",
                        "Egito",
                        "Cairo",
                        "Bar",
                        "Avenida Central, 320 - Cairo",
                        "18:00 às 02:00",
                        "Bar fictício com ambiente descontraído no Cairo.",
                        "ic_menu_gallery"
                )
        );


// =========================
// NIGÉRIA - ABUJA
// =========================

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Central de Abuja",
                        "África",
                        "Nigéria",
                        "Abuja",
                        "Café",
                        "Rua Central, 120 - Abuja",
                        "07:00 às 19:00",
                        "Café fictício localizado em Abuja.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Imperial de Abuja",
                        "África",
                        "Nigéria",
                        "Abuja",
                        "Café",
                        "Avenida Principal, 180 - Abuja",
                        "08:00 às 20:00",
                        "Café fictício com bebidas e lanches em Abuja.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Central de Abuja",
                        "África",
                        "Nigéria",
                        "Abuja",
                        "Bar",
                        "Rua Principal, 210 - Abuja",
                        "17:00 às 02:00",
                        "Bar fictício localizado em Abuja.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Imperial de Abuja",
                        "África",
                        "Nigéria",
                        "Abuja",
                        "Bar",
                        "Avenida Central, 320 - Abuja",
                        "18:00 às 01:00",
                        "Bar fictício com ambiente descontraído em Abuja.",
                        "ic_menu_gallery"
                )
        );


// =========================
// RÚSSIA - MOSCOU
// =========================

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Central de Moscou",
                        "Europa",
                        "Rússia",
                        "Moscou",
                        "Café",
                        "Rua Central, 120 - Moscou",
                        "07:00 às 19:00",
                        "Café fictício localizado em Moscou.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Imperial de Moscou",
                        "Europa",
                        "Rússia",
                        "Moscou",
                        "Café",
                        "Avenida Principal, 180 - Moscou",
                        "08:00 às 20:00",
                        "Café fictício com bebidas e lanches em Moscou.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Central de Moscou",
                        "Europa",
                        "Rússia",
                        "Moscou",
                        "Bar",
                        "Rua Principal, 210 - Moscou",
                        "17:00 às 02:00",
                        "Bar fictício localizado em Moscou.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Imperial de Moscou",
                        "Europa",
                        "Rússia",
                        "Moscou",
                        "Bar",
                        "Avenida Central, 320 - Moscou",
                        "18:00 às 02:00",
                        "Bar fictício com ambiente descontraído em Moscou.",
                        "ic_menu_gallery"
                )
        );


// =========================
// GRÉCIA - ATENAS
// =========================

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Central de Atenas",
                        "Europa",
                        "Grécia",
                        "Atenas",
                        "Café",
                        "Rua Central, 120 - Atenas",
                        "07:00 às 19:00",
                        "Café fictício localizado em Atenas.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Imperial de Atenas",
                        "Europa",
                        "Grécia",
                        "Atenas",
                        "Café",
                        "Avenida Principal, 180 - Atenas",
                        "08:00 às 20:00",
                        "Café fictício com bebidas e lanches em Atenas.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Central de Atenas",
                        "Europa",
                        "Grécia",
                        "Atenas",
                        "Bar",
                        "Rua Principal, 210 - Atenas",
                        "17:00 às 02:00",
                        "Bar fictício localizado em Atenas.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Imperial de Atenas",
                        "Europa",
                        "Grécia",
                        "Atenas",
                        "Bar",
                        "Avenida Central, 320 - Atenas",
                        "18:00 às 01:00",
                        "Bar fictício com ambiente descontraído em Atenas.",
                        "ic_menu_gallery"
                )
        );


// =========================
// COREIA DO SUL - SEUL
// =========================

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Central de Seul",
                        "Ásia",
                        "Coreia do Sul",
                        "Seul",
                        "Café",
                        "Rua Central, 120 - Seul",
                        "07:00 às 21:00",
                        "Café fictício localizado em Seul.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Imperial de Seul",
                        "Ásia",
                        "Coreia do Sul",
                        "Seul",
                        "Café",
                        "Avenida Principal, 180 - Seul",
                        "08:00 às 22:00",
                        "Café fictício com bebidas e lanches em Seul.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Central de Seul",
                        "Ásia",
                        "Coreia do Sul",
                        "Seul",
                        "Bar",
                        "Rua Principal, 210 - Seul",
                        "18:00 às 03:00",
                        "Bar fictício localizado em Seul.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Imperial de Seul",
                        "Ásia",
                        "Coreia do Sul",
                        "Seul",
                        "Bar",
                        "Avenida Central, 320 - Seul",
                        "18:00 às 02:00",
                        "Bar fictício com ambiente descontraído em Seul.",
                        "ic_menu_gallery"
                )
        );


// =========================
// CHINA - PEQUIM
// =========================

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Central de Pequim",
                        "Ásia",
                        "China",
                        "Pequim",
                        "Café",
                        "Rua Central, 120 - Pequim",
                        "07:00 às 20:00",
                        "Café fictício localizado em Pequim.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Imperial de Pequim",
                        "Ásia",
                        "China",
                        "Pequim",
                        "Café",
                        "Avenida Principal, 180 - Pequim",
                        "08:00 às 21:00",
                        "Café fictício com bebidas e lanches em Pequim.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Central de Pequim",
                        "Ásia",
                        "China",
                        "Pequim",
                        "Bar",
                        "Rua Principal, 210 - Pequim",
                        "18:00 às 02:00",
                        "Bar fictício localizado em Pequim.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Imperial de Pequim",
                        "Ásia",
                        "China",
                        "Pequim",
                        "Bar",
                        "Avenida Central, 320 - Pequim",
                        "18:00 às 01:00",
                        "Bar fictício com ambiente descontraído em Pequim.",
                        "ic_menu_gallery"
                )
        );


// =========================
// AUSTRÁLIA - CANBERRA
// =========================

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Central de Canberra",
                        "Oceania",
                        "Austrália",
                        "Canberra",
                        "Café",
                        "Rua Central, 120 - Canberra",
                        "07:00 às 19:00",
                        "Café fictício localizado em Canberra.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Imperial de Canberra",
                        "Oceania",
                        "Austrália",
                        "Canberra",
                        "Café",
                        "Avenida Principal, 180 - Canberra",
                        "08:00 às 20:00",
                        "Café fictício com bebidas e lanches em Canberra.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Central de Canberra",
                        "Oceania",
                        "Austrália",
                        "Canberra",
                        "Bar",
                        "Rua Principal, 210 - Canberra",
                        "17:00 às 02:00",
                        "Bar fictício localizado em Canberra.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Imperial de Canberra",
                        "Oceania",
                        "Austrália",
                        "Canberra",
                        "Bar",
                        "Avenida Central, 320 - Canberra",
                        "18:00 às 01:00",
                        "Bar fictício com ambiente descontraído em Canberra.",
                        "ic_menu_gallery"
                )
        );


// =========================
// NOVA ZELÂNDIA - WELLINGTON
// =========================

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Central de Wellington",
                        "Oceania",
                        "Nova Zelândia",
                        "Wellington",
                        "Café",
                        "Rua Central, 120 - Wellington",
                        "07:00 às 19:00",
                        "Café fictício localizado em Wellington.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Café Imperial de Wellington",
                        "Oceania",
                        "Nova Zelândia",
                        "Wellington",
                        "Café",
                        "Avenida Principal, 180 - Wellington",
                        "08:00 às 20:00",
                        "Café fictício com bebidas e lanches em Wellington.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Central de Wellington",
                        "Oceania",
                        "Nova Zelândia",
                        "Wellington",
                        "Bar",
                        "Rua Principal, 210 - Wellington",
                        "17:00 às 02:00",
                        "Bar fictício localizado em Wellington.",
                        "ic_menu_gallery"
                )
        );

        estabelecimentos.add(
                new Estabelecimento(
                        "Bar Imperial de Wellington",
                        "Oceania",
                        "Nova Zelândia",
                        "Wellington",
                        "Bar",
                        "Avenida Central, 320 - Wellington",
                        "18:00 às 01:00",
                        "Bar fictício com ambiente descontraído em Wellington.",
                        "ic_menu_gallery"
                )
        );


        return estabelecimentos;
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