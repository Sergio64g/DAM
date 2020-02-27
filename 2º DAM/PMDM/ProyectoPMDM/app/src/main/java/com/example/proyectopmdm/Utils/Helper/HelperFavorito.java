package com.example.proyectopmdm.Utils.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyectopmdm.Utils.Equipo;
import com.example.proyectopmdm.Utils.Favorito;
import com.example.proyectopmdm.Utils.Schemas.SchemaBDEquipo;
import com.example.proyectopmdm.Utils.Schemas.SchemaBDFavorito;
import com.example.proyectopmdm.Utils.Schemas.SchemaBDUsuario;
import com.example.proyectopmdm.Utils.Usuario;

import java.util.ArrayList;

public class HelperFavorito extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String NOMBRE_DB = "EquiposFav.db";
    SQLiteDatabase sqLiteDatabase;

    public HelperFavorito(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
//TODO Update estructura
        sqLiteDatabase.execSQL("CREATE TABLE " + SchemaBDEquipo.NOMBRE_TABLA + " ("
                + SchemaBDEquipo.NOMBRE + " TEXT PRIMARY KEY,"
                + SchemaBDEquipo.DETALLES + " TEXT NOT NULL,"
                + SchemaBDEquipo.IMAGEN + "TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + SchemaBDFavorito.NOMBRE_TABLA + " ("
                + SchemaBDFavorito._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SchemaBDFavorito.FAVORITO + " TEXT NOT NULL,"
                + SchemaBDFavorito.EQUIPO + " TEXT NOT NULL,"
                + SchemaBDFavorito.USUARIO + " TEXT NOT NULL," +
                "  FOREIGN KEY (" + SchemaBDFavorito.EQUIPO + ") REFERENCES " + SchemaBDEquipo.NOMBRE_TABLA + "(" + SchemaBDEquipo.NOMBRE + ")," +
                " FOREIGN KEY (" + SchemaBDFavorito.USUARIO + ") REFERENCES " + SchemaBDUsuario.NOMBRE_TABLA + "(" + SchemaBDUsuario.NOMBRE + "))");


        sqLiteDatabase.execSQL("CREATE TABLE " + SchemaBDUsuario.NOMBRE_TABLA + " ("
                + SchemaBDUsuario.NOMBRE + " TEXT PRIMARY KEY,"
                + SchemaBDUsuario.PASSWORD + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SchemaBDFavorito.NOMBRE_TABLA);
        onCreate(sqLiteDatabase);
    }


    public void insertEquipo(Equipo e) {
        SQLiteDatabase dbUsuariosEscritura = this.getWritableDatabase();
        ContentValues nuevoRegistro = new ContentValues();
        String query = "INSERT INTO %s VALUES ('%s','%s','%s')";
       /* nuevoRegistro.put(SchemaBDEquipo.NOMBRE, e.getNombre());
        nuevoRegistro.put(SchemaBDEquipo.DETALLES, e.getDetalles());
        nuevoRegistro.put(SchemaBDEquipo.IMAGEN, e.getImagenEquipo());*/
//TODO Error al insertar
        //dbUsuariosEscritura.insert(SchemaBDEquipo.NOMBRE_TABLA, null, nuevoRegistro);
        dbUsuariosEscritura.execSQL(String.format(query, SchemaBDEquipo.NOMBRE_TABLA, SchemaBDEquipo.NOMBRE, SchemaBDEquipo.DETALLES,SchemaBDEquipo.IMAGEN));
        dbUsuariosEscritura.close();
    }

    public void insertUsuario(Usuario u) {
        SQLiteDatabase dbUsuariosEscritura = this.getWritableDatabase();
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put(SchemaBDUsuario.NOMBRE, u.getNombreUsuario());
        nuevoRegistro.put(SchemaBDUsuario.PASSWORD, u.getPassword());

        dbUsuariosEscritura.insert(SchemaBDEquipo.NOMBRE_TABLA, null, nuevoRegistro);
        dbUsuariosEscritura.close();
    }

    public void insertFavorito(Favorito fav) {
        SQLiteDatabase dbUsuariosEscritura = this.getWritableDatabase();
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put(SchemaBDFavorito.FAVORITO, fav.getIdFavorito());
        nuevoRegistro.put(SchemaBDFavorito.EQUIPO, fav.getEquipo().getNombre());
        nuevoRegistro.put(SchemaBDFavorito.USUARIO, fav.getUsuario().getNombreUsuario());

        dbUsuariosEscritura.insert(SchemaBDEquipo.NOMBRE_TABLA, null, nuevoRegistro);
        dbUsuariosEscritura.close();
    }

    public void deleteEquipo(Equipo e) {
        SQLiteDatabase dbUsuariosEscritura = this.getWritableDatabase();
        dbUsuariosEscritura.delete(SchemaBDEquipo.NOMBRE_TABLA, SchemaBDEquipo.NOMBRE + "=?", new String[]{e.getNombre()});
        dbUsuariosEscritura.close();

    }

    public void deleteUsuario(Usuario u) {
        SQLiteDatabase dbUsuariosEscritura = this.getWritableDatabase();
        dbUsuariosEscritura.delete(SchemaBDUsuario.NOMBRE_TABLA, SchemaBDUsuario.NOMBRE + "=?", new String[]{u.getNombreUsuario()});
        dbUsuariosEscritura.close();

    }

    public void deleteFavorito(Favorito f) {
        SQLiteDatabase dbUsuariosEscritura = this.getWritableDatabase();
        dbUsuariosEscritura.delete(SchemaBDFavorito.NOMBRE_TABLA, SchemaBDFavorito.FAVORITO + "=?", new String[]{f.getIdFavorito()});
        dbUsuariosEscritura.close();

    }

    public ArrayList<Usuario> listaUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        SQLiteDatabase dbUsuariosLectura = this.getReadableDatabase();
        Cursor cursor = dbUsuariosLectura.rawQuery("SELECT * FROM " + SchemaBDUsuario.NOMBRE_TABLA, null);
        while (cursor.moveToNext()) {
            String nombre = cursor.getString(cursor.getColumnIndex(SchemaBDUsuario.NOMBRE));
            String password = cursor.getString(cursor.getColumnIndex(SchemaBDUsuario.PASSWORD));
            Usuario usuario = new Usuario(nombre, password);
            listaUsuarios.add(usuario);

        }
        return listaUsuarios;
    }

    public ArrayList<Equipo> listaEquipos() {
        ArrayList<Equipo> listaEquipos = new ArrayList();
        SQLiteDatabase dbUsuariosLectura = this.getReadableDatabase();
        Cursor cursor = dbUsuariosLectura.rawQuery("SELECT * FROM " + SchemaBDEquipo.NOMBRE_TABLA, null);
        while (cursor.moveToNext()) {
            String nombre = cursor.getString(cursor.getColumnIndex(SchemaBDEquipo.NOMBRE));
            String detalles = cursor.getString(cursor.getColumnIndex(SchemaBDEquipo.DETALLES));
            String imagen = cursor.getString(cursor.getColumnIndex(SchemaBDEquipo.IMAGEN));
            Equipo equipo = new Equipo(nombre, imagen, detalles);
            listaEquipos.add(equipo);

        }
        return listaEquipos;
    }

    public ArrayList<Favorito> listaFavoritos() {
        ArrayList<Favorito> listaFavoritos = new ArrayList();
        SQLiteDatabase dbUsuariosLectura = this.getReadableDatabase();
        Equipo equipo = null;
        Usuario usuario = null;
        Cursor cursor = dbUsuariosLectura.rawQuery("SELECT * FROM " + SchemaBDFavorito.NOMBRE_TABLA, null);
        while (cursor.moveToNext()) {
            String idFavorito = cursor.getString(cursor.getColumnIndex(SchemaBDFavorito.FAVORITO));
            String nombreEquipo = cursor.getString(cursor.getColumnIndex(SchemaBDFavorito.EQUIPO));
            String nombreUsuario = cursor.getString(cursor.getColumnIndex(SchemaBDFavorito.USUARIO));

            String query = "select * from %s where %s='%s'";

            // String sql = "select * from %s where %s= '%s'";
            Cursor cursorEquipo = dbUsuariosLectura.rawQuery(String.format(query, SchemaBDEquipo.NOMBRE_TABLA, SchemaBDEquipo.NOMBRE, nombreEquipo), null);
            while (cursorEquipo.moveToNext()) {
                String nombre = cursorEquipo.getString(cursor.getColumnIndex(SchemaBDEquipo.NOMBRE));
                String detalles = cursorEquipo.getString(cursor.getColumnIndex(SchemaBDEquipo.DETALLES));
                String imagen = cursorEquipo.getString(cursor.getColumnIndex(SchemaBDEquipo.IMAGEN));
                equipo = new Equipo(nombre, imagen, detalles);
            }

            query = "SELECT * FROM " + SchemaBDUsuario.NOMBRE_TABLA + "where" + SchemaBDUsuario.NOMBRE + "=?";
            Cursor cursorUsuario = dbUsuariosLectura.rawQuery(query, new String[]{nombreUsuario});
            while (cursorEquipo.moveToNext()) {
                String nombre = cursorUsuario.getString(cursor.getColumnIndex(SchemaBDUsuario.NOMBRE));
                String password = cursorUsuario.getString(cursor.getColumnIndex(SchemaBDUsuario.PASSWORD));
                usuario = new Usuario(nombre, password);
            }
            //TODO pasar al favorito el  euipo y el usuario
            Favorito favorito = new Favorito(idFavorito, equipo, usuario);
            listaFavoritos.add(favorito);

        }
        return listaFavoritos;
    }

    public boolean equipoExists(Equipo e) {
        boolean exists = false;
        for (Equipo equipo : listaEquipos()) {
            if (equipo.getNombre().equalsIgnoreCase(e.getNombre())) {
                exists = true;
            }
        }
        return exists;
    }

    public boolean usuarioExists(Usuario u) {
        boolean exists = false;
        for (Usuario usuario : listaUsuarios()) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(u.getNombreUsuario()) && usuario.getPassword().equals(u.getPassword())) {
                exists = true;
            }
        }
        return exists;
    }


}