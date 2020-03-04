package com.example.proyectopmdm.Utils.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        sqLiteDatabase.execSQL("CREATE TABLE " + SchemaBDEquipo.NOMBRE_TABLA + " ("
                + SchemaBDEquipo.NOMBRE + " TEXT PRIMARY KEY,"
                + SchemaBDEquipo.DETALLES + " TEXT NOT NULL,"
                + SchemaBDEquipo.IMAGEN + " TEXT NOT NULL,"
                + SchemaBDEquipo.FAV + " INTEGER NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + SchemaBDFavorito.NOMBRE_TABLA + " ("
                + SchemaBDFavorito._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
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
        String query = "INSERT INTO %s VALUES ('%s','%s','%s','%d')";
        dbUsuariosEscritura.execSQL(String.format(query, SchemaBDEquipo.NOMBRE_TABLA, e.getNombre(), e.getDetalles(), e.getImagenEquipo(), e.isFavorito()));
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
        String query = "INSERT INTO %s (%s, %s) VALUES ('%s','%s')";

        dbUsuariosEscritura.execSQL(String.format(query, SchemaBDFavorito.NOMBRE_TABLA, SchemaBDFavorito.EQUIPO, SchemaBDFavorito.USUARIO, fav.getEquipo().getNombre(), fav.getUsuario().getNombreUsuario()));
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
        String query = "DELETE FROM %s WHERE %s = '%s' AND %s = '%s'";
        dbUsuariosEscritura.execSQL(String.format(query, SchemaBDFavorito.NOMBRE_TABLA, SchemaBDFavorito.EQUIPO, f.getEquipo(), SchemaBDFavorito.USUARIO, f.getUsuario()));
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
        dbUsuariosLectura.close();
        return listaUsuarios;
    }

    public ArrayList<Equipo> listaEquipos() {
        ArrayList<Equipo> listaEquipos = new ArrayList();
        SQLiteDatabase dbUsuariosLectura = this.getReadableDatabase();
        Cursor cursor = dbUsuariosLectura.rawQuery("SELECT * FROM " + SchemaBDEquipo.NOMBRE_TABLA, null);
        Log.v("test", String.valueOf(cursor.getColumnCount()));
        while (cursor.moveToNext()) {
            String nombre = cursor.getString(cursor.getColumnIndex(SchemaBDEquipo.NOMBRE));
            String detalles = cursor.getString(cursor.getColumnIndex(SchemaBDEquipo.DETALLES));
            String imagen = cursor.getString(cursor.getColumnIndex(SchemaBDEquipo.IMAGEN));
            Equipo equipo = new Equipo(nombre, imagen, detalles);
            listaEquipos.add(equipo);
            //Log.v("test", String.valueOf(cursor.getCount()));
        }
        return listaEquipos;
    }

    public Equipo seleccionarEquipo(String nombreEquipo) {
        Equipo e = null;
        SQLiteDatabase dbUsuariosLectura = this.getReadableDatabase();
        String query = "SELECT * FROM %s where %s = '%s'";
        Cursor cursor = dbUsuariosLectura.rawQuery(String.format(query, SchemaBDEquipo.NOMBRE_TABLA, SchemaBDEquipo.NOMBRE, nombreEquipo), null);
        while (cursor.moveToNext()) {
            String nombre = cursor.getString(cursor.getColumnIndex(SchemaBDEquipo.NOMBRE));
            String imagen = cursor.getString(cursor.getColumnIndex(SchemaBDEquipo.IMAGEN));
            String detalles = cursor.getString(cursor.getColumnIndex(SchemaBDEquipo.DETALLES));
            e = new Equipo(nombre, imagen, detalles);
        }
        return e;
    }

    public Usuario seleccionarUsuario(String nombreUsuario) {
        Usuario u = null;
        SQLiteDatabase dbUsuariosLectura = this.getReadableDatabase();
        String query = "SELECT * FROM %s where %s = '%s'";
        Cursor cursor = dbUsuariosLectura.rawQuery(String.format(query, SchemaBDUsuario.NOMBRE_TABLA, SchemaBDUsuario.NOMBRE, nombreUsuario), null);
        while (cursor.moveToNext()) {
            String nombre = cursor.getString(cursor.getColumnIndex(SchemaBDUsuario.NOMBRE));
            String password = cursor.getString(cursor.getColumnIndex(SchemaBDUsuario.PASSWORD));
            u = new Usuario(nombre, password);
        }
        return u;
    }


    public ArrayList<Favorito> listaFavoritos() {
        ArrayList<Favorito> listaFavoritos = new ArrayList();
        SQLiteDatabase dbUsuariosLectura = this.getReadableDatabase();
        Cursor cursor = dbUsuariosLectura.rawQuery("SELECT * FROM " + SchemaBDFavorito.NOMBRE_TABLA, null);
        while (cursor.moveToNext()) {
            String idFavorito = cursor.getString(cursor.getColumnIndex(SchemaBDFavorito.FAVORITO));
            String nombreEquipo = cursor.getString(cursor.getColumnIndex(SchemaBDFavorito.EQUIPO));
            String nombreUsuario = cursor.getString(cursor.getColumnIndex(SchemaBDFavorito.USUARIO));

            Favorito favorito = new Favorito(idFavorito, seleccionarEquipo(nombreEquipo), seleccionarUsuario(nombreUsuario));
            listaFavoritos.add(favorito);
        }
        return listaFavoritos;
    }

    public ArrayList<Equipo> listaFavoritosUsuario(Usuario u) {
        ArrayList<Equipo> listaFavoritosUsuario = new ArrayList();
        SQLiteDatabase dbUsuariosLectura = this.getReadableDatabase();
        String query = "SELECT * FROM %s where %s = '%s'";
        Cursor cursor = dbUsuariosLectura.rawQuery(String.format(query, SchemaBDFavorito.NOMBRE_TABLA, SchemaBDFavorito.USUARIO, u.getNombreUsuario()), null);
        Log.v("test", u.getNombreUsuario());
        while (cursor.moveToNext()) {
            String nombreEquipo = cursor.getString(cursor.getColumnIndex(SchemaBDFavorito.EQUIPO));
            Log.v("test", nombreEquipo);

            listaFavoritosUsuario.add(seleccionarEquipo(nombreEquipo));
        }
        return listaFavoritosUsuario;
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

    public boolean favoritoExists(Favorito fav) {
        boolean exists = false;
        for (Favorito f : listaFavoritos()) {
            if (fav.getEquipo().getNombre().equalsIgnoreCase(f.getEquipo().getNombre()) && (f.getUsuario().getNombreUsuario().equals(fav.getUsuario().getNombreUsuario()))) {
                exists = true;
            }
        }
        return exists;
    }


}