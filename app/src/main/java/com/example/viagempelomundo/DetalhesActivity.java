package com.example.viagempelomundo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalhesActivity extends AppCompatActivity {

    private ImageView imgDetalhe;

    private TextView txtNome;
    private TextView txtDescricao;
    private TextView txtInformacaoExtra;


    @Override
    protected void onCreate(
            Bundle savedInstanceState
    ) {

        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.activity_detalhes
        );


        inicializarViews();

        carregarDados();
    }


    private void inicializarViews() {

        imgDetalhe =
                findViewById(
                        R.id.img_detalhe
                );

        txtNome =
                findViewById(
                        R.id.txt_nome_detalhe
                );

        txtDescricao =
                findViewById(
                        R.id.txt_descricao_detalhe
                );

        txtInformacaoExtra =
                findViewById(
                        R.id.txt_informacao_extra
                );
    }


    private void carregarDados() {

        String tipoItem =
                getIntent().getStringExtra(
                        "tipo_item"
                );


        String nome =
                getIntent().getStringExtra(
                        "nome"
                );


        String caminhoImagem =
                getIntent().getStringExtra(
                        "imagem"
                );


        txtNome.setText(
                nome != null
                        ? nome
                        : "Detalhes"
        );


        carregarImagem(
                caminhoImagem
        );


        if ("prato".equals(tipoItem)) {

            carregarPrato();

        } else if ("estabelecimento".equals(tipoItem)) {

            carregarEstabelecimento();
        }
    }


    private void carregarPrato() {

        String ingredientes =
                getIntent().getStringExtra(
                        "ingredientes"
                );


        String informacaoCultural =
                getIntent().getStringExtra(
                        "informacao_cultural"
                );


        txtDescricao.setText(
                "Ingredientes:\n\n"
                        + textoSeguro(
                        ingredientes
                )
        );


        txtInformacaoExtra.setText(
                "Informação cultural:\n\n"
                        + textoSeguro(
                        informacaoCultural
                )
        );


        txtInformacaoExtra.setVisibility(
                View.VISIBLE
        );
    }


    private void carregarEstabelecimento() {

        String endereco =
                getIntent().getStringExtra(
                        "endereco"
                );


        String horario =
                getIntent().getStringExtra(
                        "horario"
                );


        String descricao =
                getIntent().getStringExtra(
                        "descricao"
                );


        txtDescricao.setText(
                textoSeguro(
                        descricao
                )
        );


        txtInformacaoExtra.setText(
                "Endereço:\n"
                        + textoSeguro(endereco)
                        + "\n\nHorário:\n"
                        + textoSeguro(horario)
        );


        txtInformacaoExtra.setVisibility(
                View.VISIBLE
        );
    }


    private void carregarImagem(
            String caminhoImagem
    ) {

        if (caminhoImagem == null
                || caminhoImagem.isEmpty()) {

            imgDetalhe.setImageResource(
                    android.R.drawable.ic_menu_gallery
            );

            return;
        }


        int resourceId =
                getResources().getIdentifier(
                        caminhoImagem,
                        "drawable",
                        getPackageName()
                );


        if (resourceId != 0) {

            imgDetalhe.setImageResource(
                    resourceId
            );

        } else {

            imgDetalhe.setImageResource(
                    android.R.drawable.ic_menu_gallery
            );
        }
    }


    private String textoSeguro(
            String texto
    ) {

        if (texto == null
                || texto.trim().isEmpty()) {

            return "Informação não disponível.";
        }

        return texto;
    }
}