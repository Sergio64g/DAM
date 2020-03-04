package com.example.proyectopmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectopmdm.Utils.Helper.HelperFavorito;
import com.example.proyectopmdm.Utils.Usuario;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText name, password;
    Button login;
    HelperFavorito helperFavorito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        instancias();
        acciones();
    }


    private void instancias() {
        name = this.findViewById(R.id.name);
        password = this.findViewById(R.id.password);
        login = this.findViewById(R.id.login);
        helperFavorito = new HelperFavorito(getApplicationContext(), HelperFavorito.NOMBRE_DB, null, HelperFavorito.VERSION);
    }

    private void acciones() {
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        HelperFavorito helperFavorito = new HelperFavorito(getApplicationContext(), HelperFavorito.NOMBRE_DB, null, HelperFavorito.VERSION);

        if (v.getId() == R.id.login) {
           Usuario user = new Usuario(name.getText().toString(), password.getText().toString());
            if (loginCorrecto(user)) {
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Login Incorrecto", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public boolean loginCorrecto(Usuario usuario) {
        boolean login = false;

        HelperFavorito helperFavorito = new HelperFavorito(getApplicationContext(), HelperFavorito.NOMBRE_DB, null, HelperFavorito.VERSION);
        if (helperFavorito.usuarioExists(usuario)) {
            login = true;
            Log.v("test", String.valueOf(login));
        }

        return login;
    }
}
