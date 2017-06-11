package com.herprogramacion.restaurantericoparico.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.herprogramacion.restaurantericoparico.R;

public class Registro extends AppCompatActivity {

    EditText eRUsuario, eRRepPassword, eRPassword, eCorreo;
    Button bRegistrarse, bCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eRUsuario = (EditText) findViewById(R.id.eRUsuario);
        eRRepPassword = (EditText) findViewById(R.id.eRRepPassword);
        eRPassword = (EditText) findViewById(R.id.eRPassword);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        bRegistrarse = (Button) findViewById(R.id.bRegistarse);
        bCancelar = (Button) findViewById(R.id.bCancelar);


        bCancelar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

        bRegistrarse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                boolean cont = false;
                if (eRPassword.getText().toString().equals(eRRepPassword.getText().toString())) {
                    cont = true;
                }
                else
                {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT);
                    toast1.show();
                    cont = false;
                }
                if (eRUsuario.getText().toString().equals("") || eRPassword.getText().toString().equals("")|| eCorreo.getText().toString().equals("")) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Ha dejado campos vacíos", Toast.LENGTH_SHORT);
                    toast1.show();
                    cont = false;
                }
                if (cont==true){
                    Intent intent = new Intent();
                    intent.putExtra("username", eRUsuario.getText().toString());
                    intent.putExtra("password", eRPassword.getText().toString());
                    intent.putExtra("correo", eCorreo.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

}
