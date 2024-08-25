package com.rafalopez.practico_1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.rafalopez.practico_1.databinding.ActivityTraducidoBinding;

public class ActivityTraducido extends AppCompatActivity {
    private ActivityTraducidoBinding activityTraducidoBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traducido);
    }
}