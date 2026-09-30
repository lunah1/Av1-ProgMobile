package com.example.viagempelomundo.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.viagempelomundo.dao.CategoriaDao;
import com.example.viagempelomundo.dao.EstabelecimentoDao;
import com.example.viagempelomundo.dao.PratoDao;
import com.example.viagempelomundo.dao.SessaoDao;
import com.example.viagempelomundo.dao.UsuarioDao;
import com.example.viagempelomundo.database.AppDatabase;
import com.example.viagempelomundo.repository.ViagemRepository;
import com.example.viagempelomundo.entity.Estabelecimento;
import com.example.viagempelomundo.entity.Prato;
import com.example.viagempelomundo.entity.Usuario;
import com.example.viagempelomundo.entity.Sessao;
import com.example.viagempelomundo.util.SenhaUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.example.viagempelomundo.entity.CategoriaComEstabelecimentos;

import java.util.List;

public class ViagemRepository {
    private final ExecutorService executor =
            Executors.newSingleThreadExecutor();
    private final UsuarioDao usuarioDao;
    private final SessaoDao sessaoDao;
    private final EstabelecimentoDao estabelecimentoDao;
    private final PratoDao pratoDao;
    private final CategoriaDao categoriaDao;

    public ViagemRepository(Context context) {

        AppDatabase database =
                AppDatabase.getInstance(context);
        usuarioDao =
                database.usuarioDao();
        sessaoDao =
                database.sessaoDao();
        estabelecimentoDao =
                database.estabelecimentoDao();
        pratoDao =
                database.pratoDao();
        categoriaDao =
                database.categoriaDao();
    }

    public LiveData<Usuario> getUsuarioLogado() {

        return sessaoDao.getUsuarioLogado();
    }


    public LiveData<List<Estabelecimento>>
    buscarEstabelecimentos(
            String continente,
            String pais,
            String cidade,
            String tipo
    ) {

        return estabelecimentoDao.filtrar(
                continente,
                pais,
                cidade,
                tipo
        );
    }


    public LiveData<List<Estabelecimento>>
    listarEstabelecimentos() {

        return estabelecimentoDao.listarTodos();
    }


    public LiveData<List<Prato>>
    buscarPratosPorCidade(
            String cidade
    ) {

        return pratoDao.buscarPorCidade(
                cidade
        );
    }


    public LiveData<List<Prato>>
    listarPratos() {

        return pratoDao.listarTodos();
    }

    public LiveData<CategoriaComEstabelecimentos>
    buscarCategoriaComEstabelecimentos(
            int categoriaId
    ) {

        return categoriaDao
                .buscarCategoriaComEstabelecimentos(
                        categoriaId
                );
    }

    public void logout() {

        executor.execute(() -> {

            sessaoDao.encerrarSessao();
        });
    }

    public interface LoginCallback {

        void onResultado(
                boolean sucesso,
                String mensagem
        );
    }

    public void login(
            String email,
            String senha,
            LoginCallback callback
    ) {

        executor.execute(() -> {

            String senhaHash =
                    SenhaUtils.gerarHash(
                            senha
                    );


            Usuario usuario =
                    usuarioDao.login(
                            email,
                            senhaHash
                    );


            if (usuario == null) {

                callback.onResultado(
                        false,
                        "E-mail ou senha inválidos."
                );

                return;
            }


            // Garante que exista apenas
            // uma sessão ativa
            sessaoDao.encerrarSessao();


            Sessao sessao =
                    new Sessao(
                            usuario.getId()
                    );


            sessaoDao.iniciarSessao(
                    sessao
            );


            callback.onResultado(
                    true,
                    "Login realizado com sucesso."
            );
        });
    }

    public interface CadastroCallback {

        void onResultado(
                boolean sucesso,
                String mensagem
        );
    }

    public void cadastrarUsuario(
            Usuario usuario,
            CadastroCallback callback
    ) {

        executor.execute(() -> {

            Usuario existente =
                    usuarioDao.buscarPorEmail(
                            usuario.getEmail()
                    );

            if (existente != null) {

                callback.onResultado(
                        false,
                        "Já existe um usuário com esse e-mail."
                );

                return;
            }


            String senhaHash =
                    SenhaUtils.gerarHash(
                            usuario.getSenha()
                    );

            usuario.setSenha(
                    senhaHash
            );


            long id =
                    usuarioDao.inserir(
                            usuario
                    );


            if (id > 0) {

                callback.onResultado(
                        true,
                        "Cadastro realizado com sucesso."
                );

            } else {

                callback.onResultado(
                        false,
                        "Não foi possível realizar o cadastro."
                );
            }
        });
    }

    public interface UsuarioCallback {

        void onResultado(
                Usuario usuario
        );
    }

    public void buscarUsuarioPorId(
            int id,
            UsuarioCallback callback
    ) {

        executor.execute(() -> {

            Usuario usuario =
                    usuarioDao.buscarPorId(
                            id
                    );


            callback.onResultado(
                    usuario
            );
        });
    }

    public void atualizarUsuario(
            Usuario usuario,
            CadastroCallback callback
    ) {

        executor.execute(() -> {

            try {

                Usuario existente =
                        usuarioDao.buscarPorEmail(
                                usuario.getEmail()
                        );

                if (existente != null
                        && existente.getId()
                        != usuario.getId()) {

                    callback.onResultado(
                            false,
                            "Esse e-mail já está sendo usado por outro perfil."
                    );

                    return;
                }


                usuarioDao.atualizar(
                        usuario
                );


                callback.onResultado(
                        true,
                        "Perfil atualizado com sucesso."
                );

            } catch (Exception e) {

                callback.onResultado(
                        false,
                        "Não foi possível atualizar o perfil."
                );
            }
        });
    }

    public void excluirUsuario(
            Usuario usuario,
            CadastroCallback callback
    ) {

        executor.execute(() -> {

            try {

                // Primeiro encerra a sessão
                sessaoDao.encerrarSessao();

                // Depois exclui o usuário
                usuarioDao.excluir(
                        usuario
                );


                callback.onResultado(
                        true,
                        "Perfil excluído com sucesso."
                );

            } catch (Exception e) {

                callback.onResultado(
                        false,
                        "Não foi possível excluir o perfil."
                );
            }
        });
    }
}