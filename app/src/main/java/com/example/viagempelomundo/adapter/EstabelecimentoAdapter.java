package com.example.viagempelomundo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.viagempelomundo.R;
import com.example.viagempelomundo.model.Estabelecimento;

import java.util.List;

public class EstabelecimentoAdapter
        extends ArrayAdapter<Estabelecimento> {

    private final Context context;
    private final List<Estabelecimento> estabelecimentos;

    public EstabelecimentoAdapter(
            Context context,
            List<Estabelecimento> estabelecimentos) {

        super(context, 0, estabelecimentos);

        this.context = context;
        this.estabelecimentos = estabelecimentos;
    }

    @NonNull
    @Override
    public View getView(
            int position,
            @Nullable View convertView,
            @NonNull ViewGroup parent) {

        if (convertView == null) {

            convertView = LayoutInflater
                    .from(context)
                    .inflate(
                            R.layout.item_estabelecimento,
                            parent,
                            false
                    );
        }

        Estabelecimento estabelecimento =
                estabelecimentos.get(position);

        ImageView imagem =
                convertView.findViewById(
                        R.id.img_estabelecimento
                );

        TextView nome =
                convertView.findViewById(
                        R.id.txt_nome_estabelecimento
                );

        TextView endereco =
                convertView.findViewById(
                        R.id.txt_endereco_estabelecimento
                );

        TextView horario =
                convertView.findViewById(
                        R.id.txt_horario_estabelecimento
                );

        TextView descricao =
                convertView.findViewById(
                        R.id.txt_descricao_estabelecimento
                );

        imagem.setImageResource(
                estabelecimento.getImagem()
        );

        nome.setText(
                estabelecimento.getNome()
        );

        endereco.setText(
                estabelecimento.getEndereco()
        );

        horario.setText(
                estabelecimento.getHorario()
        );

        descricao.setText(
                estabelecimento.getDescricao()
        );

        return convertView;
    }
}