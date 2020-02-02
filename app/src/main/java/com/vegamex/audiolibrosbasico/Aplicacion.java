package com.vegamex.audiolibrosbasico;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import java.util.Vector;

public class Aplicacion extends Application {

    public static final String CHANNEL_ID = "canalServicios";
    private Vector<Libro> vectorLibros;
    private AdaptadorLibrosFiltro adaptador;
    @Override
    public void onCreate() {
        super.onCreate();
        crearCanalNotificador();
        vectorLibros = Libro.ejemploLibros();
        adaptador = new AdaptadorLibrosFiltro(this, vectorLibros);
    }
    public AdaptadorLibrosFiltro getAdaptador() {
        return adaptador;
    }
    public Vector<Libro> getVectorLibros() {
        return vectorLibros;
    }

    public void crearCanalNotificador(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel canalServicios = new NotificationChannel(
                    CHANNEL_ID, "Canal para Servicios",
                    NotificationManager.IMPORTANCE_LOW
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(canalServicios);
        }
    }
}
