package com.example.viagempelomundo;

import android.os.Bundle;
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

        Button btnEncerrar =
                findViewById(R.id.btn_encerrar);


        String nomeRecebido =
                getIntent().getStringExtra("nome");

        String enderecoRecebido =
                getIntent().getStringExtra("endereco");

        String horarioRecebido =
                getIntent().getStringExtra("horario");

        String descricaoRecebida =
                getIntent().getStringExtra("descricao");

        int imagemRecebida =
                getIntent().getIntExtra("imagem", 0);


        nome.setText(nomeRecebido);
        endereco.setText(enderecoRecebido);
        horario.setText(horarioRecebido);
        descricao.setText(descricaoRecebida);

        if (imagemRecebida != 0) {
            imagem.setImageResource(imagemRecebida);
        }

        btnEncerrar.setOnClickListener(v -> finish());
    }
}