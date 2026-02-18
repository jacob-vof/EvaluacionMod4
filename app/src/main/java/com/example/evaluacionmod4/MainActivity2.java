package com.example.evaluacionmod4;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URLEncoder;

public class MainActivity2 extends AppCompatActivity {

    ImageView linkedin, telegram, whatsapp, correo;
    Button btn2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        linkedin = findViewById(R.id.imLink);
        telegram = findViewById(R.id.imTel);
        whatsapp = findViewById(R.id.imWhats);
        correo = findViewById(R.id.imCorre);
        btn2 = findViewById(R.id.btnRegreso);

        linkedin.setOnClickListener(v-> {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.linkedin.com/Alucard"));
            startActivity(intent);


        });


        telegram.setOnClickListener(v-> {

            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("tg://resolve?domain=usuarioAlucard"));
                startActivity(intent);
            } catch (ActivityNotFoundException e) {

                Intent intent = new Intent (Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://t.me/Alucard"));
                startActivity(intent);

            }


        });

        whatsapp.setOnClickListener(v-> {

           try {
               String numero = "66666";
               String mensaje = "Hola, requiero tus servicios";

               mensaje = URLEncoder.encode(mensaje, "UTF-8");

               String url = "https://wa.me/" + numero + "?text=" + mensaje;

               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(url));
               startActivity(intent);
           }catch (Exception e) {
               e.printStackTrace();
           }

        });



        correo.setOnClickListener(v->{

            Intent intent = new Intent (Intent.ACTION_VIEW);
            intent.setData(Uri.parse("mailto:Alucard@castlevania.com"));
            startActivity(intent);


        });


        btn2.setOnClickListener(v-> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);


        });











    }
}