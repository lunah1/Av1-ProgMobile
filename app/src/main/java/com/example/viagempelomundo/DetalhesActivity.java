package com.example.viagempelomundo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalhes);

        ImageView imagem =
                findViewById(R.id.img_detalhe);

        TextView nome =
                findViewById(R.id.txt_nome_detalhe);

        TextView endereco =
                findViewById(R.id.txt_endereco_detalhe);

        TextView horario =
                findViewById(R.id.txt_horario_detalhe);

        TextView descricao =
                findViewById(R.id.txt_descricao_detalhe);

        TextView ingredientes =
                findViewById(R.id.txt_ingredientes_detalhe);

        TextView cultural =
                findViewById(R.id.txt_cultural_detalhe);

        Button btnEncerrar =
                findViewById(R.id.btn_encerrar);


        String tipoItem =
                getIntent().getStringExtra("tipo_item");

        String nomeRecebido =
                getIntent().getStringExtra("nome");

        int imagemRecebida =
                getIntent().getIntExtra(
                        "imagem",
                        0
                );


        nome.setText(nomeRecebido);

        if (imagemRecebida != 0) {
            imagem.setImageResource(imagemRecebida);
        }


        if ("prato".equals(tipoItem)) {

            // Esconde os campos de estabelecimento

            endereco.setVisibility(View.GONE);
            horario.setVisibility(View.GONE);
            descricao.setVisibility(View.GONE);


            String ingredientesRecebidos =
                    getIntent().getStringExtra(
                            "ingredientes"
                    );

            String culturalRecebida =
                    getIntent().getStringExtra(
                            "informacao_cultural"
                    );


            ingredientes.setText(
                    "Ingredientes: "
                            + ingredientesRecebidos
            );

            cultural.setText(
                    "Informação cultural: "
                            + culturalRecebida
            );

        } else {

            // É um estabelecimento

            ingredientes.setVisibility(View.GONE);
            cultural.setVisibility(View.GONE);


            String enderecoRecebido =
                    getIntent().getStringExtra(
                            "endereco"
                    );

            String horarioRecebido =
                    getIntent().getStringExtra(
                            "horario"
                    );

            String descricaoRecebida =
                    getIntent().getStringExtra(
                            "descricao"
                    );


            endereco.setText(
                    "Endereço: "
                            + enderecoRecebido
            );

            horario.setText(
                    "Horário: "
                            + horarioRecebido
            );

            descricao.setText(
                    descricaoRecebida
            );
        }


        btnEncerrar.setOnClickListener(
                v -> finish()
        );
    }
}