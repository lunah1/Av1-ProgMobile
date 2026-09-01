package com.example.viagempelomundo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viagempelomundo.R;
import com.example.viagempelomundo.model.Prato;

import java.util.List;

public class PratoAdapter extends BaseAdapter {

    private final Context context;
    private final List<Prato> pratos;

    public PratoAdapter(
            Context context,
            List<Prato> pratos) {

        this.context = context;
        this.pratos = pratos;
    }

    @Override
    public int getCount() {
        return pratos.size();
    }

    @Override
    public Object getItem(int position) {
        return pratos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(
            int position,
            View convertView,
            ViewGroup parent) {

        if (convertView == null) {

            convertView =
                    LayoutInflater
                            .from(context)
                            .inflate(
                                    R.layout.item_prato,
                                    parent,
                                    false
                            );
        }

        Prato prato =
                pratos.get(position);

        ImageView imagem =
                convertView.findViewById(
                        R.id.img_prato
                );

        TextView nome =
                convertView.findViewById(
                        R.id.txt_nome_prato
                );

        imagem.setImageResource(
                prato.getImagem()
        );

        nome.setText(
                prato.getNome()
        );

        return convertView;
    }
}