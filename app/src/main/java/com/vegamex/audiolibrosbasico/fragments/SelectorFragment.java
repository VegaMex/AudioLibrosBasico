package com.vegamex.audiolibrosbasico.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.vegamex.audiolibrosbasico.AdaptadorLibros;
import com.vegamex.audiolibrosbasico.Aplicacion;
import com.vegamex.audiolibrosbasico.MainActivity;
import com.vegamex.audiolibrosbasico.R;
import java.util.Vector;

public class SelectorFragment<Libro> extends Fragment {
    private Activity actividad;
    private RecyclerView recyclerView;
    private AdaptadorLibros adaptador;
    private Vector<Libro> vectorLibros;
    @Override public void onAttach(Context contexto) {
        super.onAttach(contexto);
        if (contexto instanceof Activity) {
            this.actividad = (Activity) contexto;
            Aplicacion app = (Aplicacion) actividad.getApplication();
            adaptador = app.getAdaptador();
            vectorLibros = (Vector<Libro>) app.getVectorLibros();
        }
    }
    @Override public View onCreateView(LayoutInflater inflador, ViewGroup
            contenedor, Bundle savedInstanceState) {
        View vista = inflador.inflate(R.layout.fragment_selector,
                contenedor, false);
        recyclerView = (RecyclerView) vista.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(actividad,2));
        recyclerView.setAdapter(adaptador);
        adaptador.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) actividad).mostrarDetalle(
                        recyclerView.getChildAdapterPosition(v));
            }
        });
        return vista;
    }
}