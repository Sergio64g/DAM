package com.example.proyectopmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {
    
    EditText name, password;
    Button login;

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
    }

    private void acciones() {
    login.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.login){
            Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
            startActivity(intent);
            finish();
        }

    }
}
