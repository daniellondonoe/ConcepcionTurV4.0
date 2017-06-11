package com.herprogramacion.restaurantericoparico.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.herprogramacion.restaurantericoparico.R;

/**
 * Fragmento para la pestaña "PERFIL" De la sección "Mi Cuenta"
 */
public class FragmentoPerfil extends Fragment {

    TextView tUsername;
    TextView tCorreo;
    String username,correo;

    public FragmentoPerfil() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        username =getArguments().getString("nombre");
        correo =getArguments().getString("correo");

        View v =  inflater.inflate(R.layout.fragmento_perfil, container, false);
        if(v != null){
            tUsername = (TextView) v.findViewById(R.id.tUsename);
            tCorreo = (TextView) v.findViewById(R.id.tCorreo);
        }
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tUsername.setText(username);
        tCorreo.setText(correo);
    }
}
