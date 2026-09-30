package com.example.viagempelomundo;

import android.content.Intent;
import android.os.Bundle;
import com.example.viagempelomundo.database.DatabaseInitializer;
import com.google.android.material.snackbar.Snackbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import com.example.viagempelomundo.entity.Usuario;
import com.example.viagempelomundo.viewmodel.ViagemViewModel;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import androidx.navigation.fragment.NavHostFragment;
import com.example.viagempelomundo.databinding.ActivityMainBinding;
import android.content.SharedPreferences;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    private ViagemViewModel viagemViewModel;
    private NavController navController;
    private Usuario usuarioLogado;
    private ImageView imgUsuarioToolbar;
    private TextView txtUsuarioToolbar;
    private MenuItem itemUsuarioToolbar;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        carregarTema();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DatabaseInitializer.inicializar(this);

        setSupportActionBar(binding.toolbar);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager()
                        .findFragmentById(
                                R.id.nav_host_fragment_content_main
                        );

        navController =
                navHostFragment.getNavController();


        appBarConfiguration =
                new AppBarConfiguration.Builder(
                        R.id.loginFragment,
                        R.id.continentesFragment
                ).build();


        NavigationUI.setupActionBarWithNavController(
                this,
                navController,
                appBarConfiguration
        );


        viagemViewModel =
                new ViewModelProvider(this)
                        .get(
                                ViagemViewModel.class
                        );


        observarSessao();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(
                R.menu.menu_main,
                menu
        );


        itemUsuarioToolbar =
                menu.findItem(
                        R.id.action_usuario
                );


        View actionView =
                itemUsuarioToolbar.getActionView();


        if (actionView != null) {

            imgUsuarioToolbar =
                    actionView.findViewById(
                            R.id.img_usuario_toolbar
                    );


            txtUsuarioToolbar =
                    actionView.findViewById(
                            R.id.txt_usuario_toolbar
                    );


            actionView.setOnClickListener(
                    v -> mostrarConfiguracoes()
            );
        }


        atualizarUsuarioToolbar();


        return true;
    }

    private void atualizarUsuarioToolbar() {

        if (itemUsuarioToolbar == null) {
            return;
        }


        if (usuarioLogado == null) {

            itemUsuarioToolbar.setVisible(
                    false
            );

            return;
        }


        itemUsuarioToolbar.setVisible(
                true
        );


        if (txtUsuarioToolbar != null) {

            txtUsuarioToolbar.setText(
                    usuarioLogado.getNome()
            );
        }


        if (imgUsuarioToolbar != null) {

            byte[] foto =
                    usuarioLogado.getFoto();


            if (foto != null
                    && foto.length > 0) {

                Bitmap bitmap =
                        BitmapFactory.decodeByteArray(
                                foto,
                                0,
                                foto.length
                        );


                imgUsuarioToolbar.setImageBitmap(
                        bitmap
                );

            } else {

                imgUsuarioToolbar.setImageResource(
                        R.mipmap.ic_launcher
                );
            }
        }
    }

    private void observarSessao() {

        viagemViewModel
                .getUsuarioLogado()
                .observe(
                        this,
                        usuario -> {

                            usuarioLogado = usuario;
                            atualizarUsuarioToolbar();

                            if (usuario == null) {

                                // Não existe usuário logado.
                                // Deve estar no Login.

                                if (navController.getCurrentDestination() != null
                                        && navController
                                        .getCurrentDestination()
                                        .getId()
                                        != R.id.loginFragment) {

                                    navController.navigate(
                                            R.id.action_global_loginFragment
                                    );
                                }

                            } else {

                                // Existe sessão ativa.

                                if (navController.getCurrentDestination() != null
                                        && navController
                                        .getCurrentDestination()
                                        .getId()
                                        == R.id.loginFragment) {

                                    navController.navigate(
                                            R.id.action_loginFragment_to_continentesFragment
                                    );
                                }
                            }
                        }
                );
    }

    @Override
    public void onBackPressed() {

        if (usuarioLogado != null
                && navController != null
                && navController.getCurrentDestination() != null
                && navController.getCurrentDestination().getId()
                == R.id.continentesFragment) {

            // Usuário está logado e está na tela principal.
            // Voltar NÃO deve abrir Login.

            finish();

            return;
        }


        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {

            mostrarConfiguracoes();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
    private void mostrarConfiguracoes() {

        String[] opcoes = {
                "Editar Perfil",
                "Tema claro",
                "Tema escuro",
                "Sair"
        };

        new AlertDialog.Builder(this)
                .setTitle("Configurações")
                .setItems(
                        opcoes,
                        (dialog, which) -> {

                            if (which == 0) {

                                abrirEdicaoPerfil();
                            }


                            if (which == 1) {

                                salvarTema(false);

                                AppCompatDelegate
                                        .setDefaultNightMode(
                                                AppCompatDelegate.MODE_NIGHT_NO
                                        );
                            }


                            if (which == 2) {

                                salvarTema(true);

                                AppCompatDelegate
                                        .setDefaultNightMode(
                                                AppCompatDelegate.MODE_NIGHT_YES
                                        );
                            }


                            if (which == 3) {

                                confirmarLogout();
                            }
                        }
                )
                .show();
    }

    private void abrirEdicaoPerfil() {

        if (usuarioLogado == null) {
            return;
        }


        Intent intent =
                new Intent(
                        this,
                        CadastroActivity.class
                );


        intent.putExtra(
                "modo_edicao",
                true
        );


        intent.putExtra(
                "usuario_id",
                usuarioLogado.getId()
        );


        startActivity(
                intent
        );
    }

    private void salvarTema(boolean escuro) {

        SharedPreferences preferences =
                getSharedPreferences(
                        "configuracoes",
                        MODE_PRIVATE
                );

        preferences
                .edit()
                .putBoolean("tema_escuro", escuro)
                .apply();
    }

    private void carregarTema() {

        SharedPreferences preferences =
                getSharedPreferences(
                        "configuracoes",
                        MODE_PRIVATE
                );

        boolean escuro =
                preferences.getBoolean(
                        "tema_escuro",
                        false
                );

        if (escuro) {

            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES
            );

        } else {

            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO
            );
        }
    }

    private void confirmarLogout() {

        new AlertDialog.Builder(this)
                .setTitle("Sair")
                .setMessage(
                        "Deseja realmente sair da sua conta?"
                )
                .setPositiveButton(
                        "Sair",
                        (dialog, which) -> {

                            viagemViewModel.logout();
                        }
                )
                .setNegativeButton(
                        "Cancelar",
                        null
                )
                .show();
    }
}