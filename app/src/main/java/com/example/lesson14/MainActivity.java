package com.example.lesson14;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cargar las animaciones
        Animation fadeInRotate = AnimationUtils.loadAnimation(this, R.anim.fade_in_rotate); // Fade in + Rotate
        Animation fadeInText = AnimationUtils.loadAnimation(this, R.anim.fade_in_text);  // Solo Fade In (para los textos)

        // Encontrar los elementos de la UI
        TextView textViewTopTitle = findViewById(R.id.TextViewTopTitle);
        TextView textViewBottomTitle = findViewById(R.id.TextViewBottomTitle);
        TextView textViewBottomVersion = findViewById(R.id.TextViewBottomVersion);
        ImageView imageView2Left = findViewById(R.id.ImageView2_Left);
        ImageView imageView2Right = findViewById(R.id.ImageView2_Right);
        ImageView imageView3Left = findViewById(R.id.ImageView3_Left);
        ImageView imageView3Right = findViewById(R.id.ImageView3_Right);

        // Inicialmente, ocultar todos los elementos
        textViewTopTitle.setVisibility(View.INVISIBLE);
        textViewBottomTitle.setVisibility(View.INVISIBLE);
        textViewBottomVersion.setVisibility(View.INVISIBLE);
        imageView2Left.setVisibility(View.INVISIBLE);
        imageView2Right.setVisibility(View.INVISIBLE);
        imageView3Left.setVisibility(View.INVISIBLE);
        imageView3Right.setVisibility(View.INVISIBLE);

        // Usar Handler para retrasar las animaciones y ejecutarlas en secuencia
        Handler handler = new Handler();

        // Aplicar animación al texto superior con fade in
        handler.postDelayed(() -> {
            textViewTopTitle.setVisibility(View.VISIBLE); // Hacer visible el texto superior
            textViewTopTitle.startAnimation(fadeInText); // Ejecutar animación
        }, 0);

        // Imágenes de la primera fila (con fade in + rotación)
        handler.postDelayed(() -> {
            imageView2Left.setVisibility(View.VISIBLE); // Hacer visible la imagen izquierda
            imageView2Right.setVisibility(View.VISIBLE); // Hacer visible la imagen derecha
            imageView2Left.startAnimation(fadeInRotate); // Ejecutar animación
            imageView2Right.startAnimation(fadeInRotate); // Ejecutar animación
        }, 500); // Después de 500 ms

        // Texto inferior con fade in
        handler.postDelayed(() -> {
            textViewBottomTitle.setVisibility(View.VISIBLE); // Hacer visible el texto inferior
            textViewBottomTitle.startAnimation(fadeInText); // Ejecutar animación
        }, 1000); // Después de 1000 ms

        // Imágenes de la segunda fila (con fade in + rotación)
        handler.postDelayed(() -> {
            imageView3Left.setVisibility(View.VISIBLE); // Hacer visible la imagen izquierda de la fila 2
            imageView3Right.setVisibility(View.VISIBLE); // Hacer visible la imagen derecha de la fila 2
            imageView3Left.startAnimation(fadeInRotate); // Ejecutar animación
            imageView3Right.startAnimation(fadeInRotate); // Ejecutar animación
        }, 1500); // Después de 1500 ms

        // Información de versión con fade in (sin rotación)
        handler.postDelayed(() -> {
            textViewBottomVersion.setVisibility(View.VISIBLE); // Hacer visible la información de versión
            textViewBottomVersion.startAnimation(fadeInText); // Ejecutar animación
        }, 2000); // Después de 2000 ms
    }
}
