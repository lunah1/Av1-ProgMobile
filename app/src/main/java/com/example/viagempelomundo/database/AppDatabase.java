package com.example.viagempelomundo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.viagempelomundo.dao.SessaoDao;
import com.example.viagempelomundo.dao.UsuarioDao;
import com.example.viagempelomundo.entity.Sessao;
import com.example.viagempelomundo.entity.Usuario;

@Database(
        entities = {
                Usuario.class,
                Sessao.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;


    public abstract UsuarioDao usuarioDao();

    public abstract SessaoDao sessaoDao();


    public static AppDatabase getInstance(Context context) {

        if (INSTANCE == null) {

            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "viagem_database"
            ).build();
        }

        return INSTANCE;
    }
}