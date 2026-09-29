package com.example.viagempelomundo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.viagempelomundo.entity.Usuario;
import com.example.viagempelomundo.viewmodel.ViagemViewModel;

public class CadastroActivity
        extends AppCompatActivity {

    private ImageView imgPerfil;

    private EditText editNome;
    private EditText editEmail;
    private EditText editSenha;

    private Button btnFoto;
    private Button btnSalvar;
    private Button btnExcluir;

    private TextView txtTitulo;
    private TextView txtErro;

    private ViagemViewModel viagemViewModel;

    private boolean modoEdicao;


    @Override
    protected void onCreate(
            Bundle savedInstanceState
    ) {

        super.onCreate(
                savedInstanceState
        );

        setContentView(
                R.layout.activity_cadastro
        );


        inicializarViews();

        configurarViewModel();

        verificarModo();

        configurarBotoes();
    }


    private void inicializarViews() {

        imgPerfil =
                findViewById(
                        R.id.img_perfil
                );

        editNome =
                findViewById(
                        R.id.edit_nome
                );

        editEmail =
                findViewById(
                        R.id.edit_email_cadastro
                );

        editSenha =
                findViewById(
                        R.id.edit_senha_cadastro
                );

        btnFoto =
                findViewById(
                        R.id.btn_foto
                );

        btnSalvar =
                findViewById(
                        R.id.btn_salvar_perfil
                );

        btnExcluir =
                findViewById(
                        R.id.btn_excluir_perfil
                );

        txtTitulo =
                findViewById(
                        R.id.txt_titulo_cadastro
                );

        txtErro =
                findViewById(
                        R.id.txt_erro_cadastro
                );
    }


    private void configurarViewModel() {

        viagemViewModel =
                new ViewModelProvider(this)
                        .get(
                                ViagemViewModel.class
                        );
    }


    private void verificarModo() {

        modoEdicao =
                getIntent()
                        .getBooleanExtra(
                                "modo_edicao",
                                false
                        );


        if (modoEdicao) {

            txtTitulo.setText(
                    "Editar perfil"
            );

            btnSalvar.setText(
                    "Salvar alterações"
            );

            btnExcluir.setVisibility(
                    View.VISIBLE
            );

        } else {

            txtTitulo.setText(
                    "Criar perfil"
            );

            btnSalvar.setText(
                    "Cadastrar"
            );

            btnExcluir.setVisibility(
                    View.GONE
            );
        }
    }


    private void configurarBotoes() {

        btnSalvar.setOnClickListener(
                v -> {

                    if (modoEdicao) {

                        // Implementaremos na etapa
                        // de edição de perfil.

                    } else {

                        cadastrarUsuario();
                    }
                }
        );


        btnFoto.setOnClickListener(
                v -> {

                    // Implementaremos a câmera
                    // na próxima etapa.
                }
        );
    }


    private void cadastrarUsuario() {

        String nome =
                editNome
                        .getText()
                        .toString()
                        .trim();

        String email =
                editEmail
                        .getText()
                        .toString()
                        .trim();

        String senha =
                editSenha
                        .getText()
                        .toString();


        if (nome.isEmpty()) {

            txtErro.setText(
                    "Informe o nome."
            );

            return;
        }


        if (email.isEmpty()) {

            txtErro.setText(
                    "Informe o e-mail."
            );

            return;
        }


        if (senha.isEmpty()) {

            txtErro.setText(
                    "Informe a senha."
            );

            return;
        }


        Usuario usuario =
                new Usuario(
                        nome,
                        email,
                        senha,
                        null
                );


        viagemViewModel
                .cadastrarUsuario(
                        usuario,
                        (
                                sucesso,
                                mensagem
                        ) -> {

                            runOnUiThread(
                                    () -> {

                                        txtErro.setText(
                                                mensagem
                                        );


                                        if (sucesso) {

                                            finish();
                                        }
                                    }
                            );
                        }
                );
    }
}