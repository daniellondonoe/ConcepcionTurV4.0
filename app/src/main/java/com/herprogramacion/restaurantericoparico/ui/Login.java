package com.herprogramacion.restaurantericoparico.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.herprogramacion.restaurantericoparico.R;

public class Login extends AppCompatActivity
{

    EditText eUsuario, ePassword;
    Button bIniciar;
    TextView tRegistrarse;
    String username="", password="",correo="";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsuario = (EditText) findViewById(R.id.eUsuario);
        ePassword = (EditText) findViewById(R.id.ePassword);
        bIniciar = (Button) findViewById(R.id.bIniciar);
        tRegistrarse = (TextView) findViewById(R.id.tRegistrarse);

        tRegistrarse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Login.this, Registro.class);
                startActivityForResult(intent,1234);
            }
        }
        );

        bIniciar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //validar que el usuario y contrasña sean iguales a los recibidos y no tengan datos nulos
                if (eUsuario.getText().toString().equals(username) && ePassword.getText().toString().equals(password) && username!="" && password!="")
                {
                   Intent intent = new Intent(Login.this, ActividadPrincipal.class);
                    //Intent intent = new Intent(Login.this, HotelActivity.class);

                    Bundle user = new Bundle();
                    startActivity(intent);
                    intent.putExtra("username", username);
                    intent.putExtra("correo",correo);
                    startActivity(intent);
                }
                else
                {
                    Toast toast1 = Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });
    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode==1234 && resultCode==RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            correo = data.getExtras().getString("correo");
            Log.d("nombre",data.getExtras().getString("username"));
            Log.d("correo",data.getExtras().getString("correo"));
        }
        if (requestCode == 1234 && resultCode==RESULT_CANCELED){
            Toast.makeText(this, "Error en login", Toast.LENGTH_SHORT).show();
        }

    }
}
