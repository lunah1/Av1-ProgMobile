package com.example.viagempelomundo;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import androidx.navigation.fragment.NavHostFragment;

import com.example.viagempelomundo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        carregarTema();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment_content_main);

        NavController navController =
                navHostFragment.getNavController();

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
                "Tema claro",
                "Tema escuro"
        };

        new AlertDialog.Builder(this)
                .setTitle("Configurações")
                .setItems(opcoes, (dialog, which) -> {

                    if (which == 0) {
                        salvarTema(false);

                        AppCompatDelegate.setDefaultNightMode(
                                AppCompatDelegate.MODE_NIGHT_NO
                        );
                    }

                    if (which == 1) {
                        salvarTema(true);

                        AppCompatDelegate.setDefaultNightMode(
                                AppCompatDelegate.MODE_NIGHT_YES
                        );
                    }
                })
                .show();
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
}