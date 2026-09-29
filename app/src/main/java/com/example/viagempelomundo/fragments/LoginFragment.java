package com.example.viagempelomundo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.viagempelomundo.CadastroActivity;

import com.example.viagempelomundo.R;

public class LoginFragment extends Fragment {

    private EditText editEmail;
    private EditText editSenha;

    private Button btnLogin;
    private Button btnCadastrar;

    private TextView txtErroLogin;


    public LoginFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {

        return inflater.inflate(
                R.layout.fragment_login,
                container,
                false
        );
    }


    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {

        super.onViewCreated(
                view,
                savedInstanceState
        );


        editEmail =
                view.findViewById(
                        R.id.edit_email
                );


        editSenha =
                view.findViewById(
                        R.id.edit_senha
                );


        btnLogin =
                view.findViewById(
                        R.id.btn_login
                );


        btnCadastrar =
                view.findViewById(
                        R.id.btn_cadastrar
                );


        txtErroLogin =
                view.findViewById(
                        R.id.txt_erro_login
                );


        configurarBotoes();
    }


    private void configurarBotoes() {

        btnLogin.setOnClickListener(
                v -> validarCampos()
        );


        btnCadastrar.setOnClickListener(
                v -> abrirCadastro()
        );
    }


    private void validarCampos() {

        String email =
                editEmail
                        .getText()
                        .toString()
                        .trim();


        String senha =
                editSenha
                        .getText()
                        .toString()
                        .trim();


        if (email.isEmpty()) {

            txtErroLogin.setText(
                    "Informe o e-mail."
            );

            return;
        }


        if (senha.isEmpty()) {

            txtErroLogin.setText(
                    "Informe a senha."
            );

            return;
        }


        txtErroLogin.setText("");

    }

    private void abrirCadastro() {

        Intent intent =
                new Intent(
                        requireContext(),
                        CadastroActivity.class
                );

        intent.putExtra(
                "modo_edicao",
                false
        );

        startActivity(
                intent
        );
    }
}