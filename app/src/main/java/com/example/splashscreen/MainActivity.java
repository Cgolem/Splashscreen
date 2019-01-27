package com.example.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Generamos un hilo
        Thread threadSplash = new Thread() {

            //Sobreescribimos el método run()
            @Override
            public void run() {
                try {
                    //Retardo de 3s
                    sleep(3000);

                    //Creamos un objeto Intent, este nos permitirá poder llamar a otra actividad.
                    //Enviaremos el contexto de la app y la clase a la que iremos, es decir, a la cual cambiaremos de
                    //pantalla. pantalla 1 ---> pantalla 2
                    Intent intentSplash = new Intent(getApplicationContext(), Home.class);

                    //Iniciamos nuestro Intent
                    startActivity(intentSplash);

                    //Finalizamos lka actividad en la cual estamos actualmente, es decir "MainActivity"
                    finish();
                } catch (Exception err) {
                    //capturamos la excepcion que pudiera suceder e imprimimos en consola
                    err.printStackTrace();
                }
            }
        };
        threadSplash.start();
    }
}
