package com.rafalopez.practico_1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.rafalopez.practico_1.databinding.ActivityTraducidoBinding;

public class ActivityTraducido extends AppCompatActivity {
    private ActivityTraducidoBinding binding;
    private ViewModelTraducido viewModelTraducido;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTraducidoBinding.inflate(getLayoutInflater());
        viewModelTraducido =ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelTraducido.class);
        intent = getIntent();
        viewModelTraducido.getMutableImg().observe(this, new Observer<Bitmap>(){
            @Override
            public void onChanged(Bitmap img) {
                binding.imgTraducido.setImageBitmap(img);
            }
        });
        viewModelTraducido.getMutableMsg().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra msg) {
                binding.msgTraduccion.setText(msg.getEng());
            }

        });
        viewModelTraducido.setPalabra(intent);
        viewModelTraducido.setImg(intent, this);


        // Evento click del botón de home
        binding.btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityTraducido.this, ActivityTraducir.class);
            startActivity(intent);
        });




        setContentView(binding.getRoot());


    }
}