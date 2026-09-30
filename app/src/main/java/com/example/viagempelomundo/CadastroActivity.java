package com.example.viagempelomundo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.viagempelomundo.util.SenhaUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import java.io.ByteArrayOutputStream;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import com.example.viagempelomundo.entity.Usuario;
import com.example.viagempelomundo.viewmodel.ViagemViewModel;

public class CadastroActivity
        extends AppCompatActivity {

    private ImageView imgPerfil;
    private EditText editNome;
    private EditText editEmail;
    private EditText editSenha;
    private byte[] fotoBytes;
    private Button btnFoto;
    private Button btnSalvar;
    private Button btnExcluir;
    private TextView txtTitulo;
    private TextView txtErro;
    private Usuario usuarioAtual;
    private int usuarioId;
    private ViagemViewModel viagemViewModel;
    private boolean modoEdicao;

    private final ActivityResultLauncher<Intent>
            cameraLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {

                        if (result.getResultCode() == RESULT_OK
                                && result.getData() != null) {

                            Bundle extras =
                                    result.getData().getExtras();

                            if (extras != null) {

                                Bitmap bitmap =
                                        (Bitmap) extras.get("data");

                                if (bitmap != null) {

                                    imgPerfil.setImageBitmap(
                                            bitmap
                                    );

                                    fotoBytes =
                                            converterBitmapParaBytes(
                                                    bitmap
                                            );
                                }
                            }
                        }
                    }
            );

    private final ActivityResultLauncher<String>
            permissaoCameraLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.RequestPermission(),
                    concedida -> {

                        if (concedida) {

                            abrirCamera();

                        } else {

                            txtErro.setText(
                                    "Permissão da câmera não concedida."
                            );
                        }
                    }
            );

    private byte[] converterBitmapParaBytes(
            Bitmap bitmap
    ) {

        ByteArrayOutputStream stream =
                new ByteArrayOutputStream();


        bitmap.compress(
                Bitmap.CompressFormat.JPEG,
                80,
                stream
        );


        return stream.toByteArray();
    }

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

    private void abrirCamera() {

        Intent intent =
                new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE
                );


        if (intent.resolveActivity(
                getPackageManager()
        ) != null) {

            cameraLauncher.launch(
                    intent
            );

        } else {

            txtErro.setText(
                    "Nenhum aplicativo de câmera disponível."
            );
        }
    }

    private void verificarPermissaoCamera() {

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED) {

            abrirCamera();

        } else {

            permissaoCameraLauncher.launch(
                    Manifest.permission.CAMERA
            );
        }
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

            usuarioId =
                    getIntent()
                            .getIntExtra(
                                    "usuario_id",
                                    -1
                            );


            txtTitulo.setText(
                    "Editar perfil"
            );

            btnSalvar.setText(
                    "Salvar alterações"
            );

            btnExcluir.setVisibility(
                    View.VISIBLE
            );


            carregarUsuario();

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

    private void excluirUsuario() {

        viagemViewModel.excluirUsuario(
                usuarioAtual,
                (sucesso, mensagem) -> {

                    runOnUiThread(
                            () -> {

                                if (sucesso) {

                                    finish();

                                } else {

                                    txtErro.setText(
                                            mensagem
                                    );
                                }
                            }
                    );
                }
        );
    }

    private void confirmarExclusao() {

        if (usuarioAtual == null) {
            return;
        }


        new androidx.appcompat.app.AlertDialog
                .Builder(this)
                .setTitle(
                        "Excluir perfil"
                )
                .setMessage(
                        "Deseja realmente excluir este perfil?"
                )
                .setPositiveButton(
                        "Excluir",
                        (dialog, which) ->
                                excluirUsuario()
                )
                .setNegativeButton(
                        "Cancelar",
                        null
                )
                .show();
    }

    private void configurarBotoes() {

        btnSalvar.setOnClickListener(
                v -> {

                    if (modoEdicao) {

                        atualizarUsuario();

                    } else {

                        cadastrarUsuario();
                    }
                }
        );


        btnFoto.setOnClickListener(
                v -> verificarPermissaoCamera()
        );

        btnExcluir.setOnClickListener(
                v -> confirmarExclusao()
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
                        fotoBytes
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

    private void atualizarUsuario() {

        if (usuarioAtual == null) {

            txtErro.setText(
                    "Usuário ainda não foi carregado."
            );

            return;
        }


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

        String novaSenha =
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

        usuarioAtual.setNome(
                nome
        );

        usuarioAtual.setEmail(
                email
        );

        usuarioAtual.setFoto(
                fotoBytes
        );

        if (!novaSenha.isEmpty()) {

            usuarioAtual.setSenha(
                    SenhaUtils.gerarHash(
                            novaSenha
                    )
            );
        }


        viagemViewModel.atualizarUsuario(
                usuarioAtual,
                (sucesso, mensagem) -> {

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

    private void carregarUsuario() {

        if (usuarioId == -1) {

            txtErro.setText(
                    "Usuário inválido."
            );

            return;
        }


        viagemViewModel
                .buscarUsuarioPorId(
                        usuarioId,
                        usuario -> {

                            runOnUiThread(
                                    () -> {

                                        if (usuario == null) {

                                            txtErro.setText(
                                                    "Usuário não encontrado."
                                            );

                                            return;
                                        }

                                        usuarioAtual =
                                                usuario;


                                        editNome.setText(
                                                usuario.getNome()
                                        );


                                        editEmail.setText(
                                                usuario.getEmail()
                                        );


                                        fotoBytes =
                                                usuario.getFoto();


                                        if (fotoBytes != null
                                                && fotoBytes.length > 0) {

                                            Bitmap bitmap =
                                                    BitmapFactory.decodeByteArray(
                                                            fotoBytes,
                                                            0,
                                                            fotoBytes.length
                                                    );

                                            imgPerfil.setImageBitmap(
                                                    bitmap
                                            );
                                        }


                                        editSenha.setText("");
                                    }
                            );
                        }
                );
    }
}