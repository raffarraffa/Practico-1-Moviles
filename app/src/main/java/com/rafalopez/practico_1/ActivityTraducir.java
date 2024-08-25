package com.rafalopez.practico_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.rafalopez.practico_1.databinding.ActivityTraducirBinding;
public class ActivityTraducir extends AppCompatActivity {
    private ActivityTraducirBinding binding;
    private ViewModelTraducir viewModelTraducir;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //*binding*: proporciona referencias a todas las vistas en el diseño sin necesidad de usar
        // findViewById()
        //*inflate*: devuelve una instancia de la clase de binding, que contiene referencias a
        // todas las vistas en el diseño
        binding = ActivityTraducirBinding.inflate(getLayoutInflater());
        //*getRoot()*: se utiliza para obtener la vista raíz del diseño inflado
        setContentView(binding.getRoot());
        // Separo porque no la entiendo toda junta
        //  viewModelTraducir = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelTraducir.class); // leer pa entender
        // instancio del factory para AndroidViewModel
        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        // instancio del ViewModel utilizando el factory
        viewModelTraducir = factory.create(ViewModelTraducir.class);
        // evento click del botón de traducir
        binding.btnTraslate.setOnClickListener(v -> {
            Log.d("salida", "asdads ");
        String inputTextoEsp = binding.inputEsp.getText().toString();
         viewModelTraducir.verPalabras(); // solo para mostrar laa spalbras en el logd

         // envio la plabr al viewModel
         viewModelTraducir.traducirPalabra(inputTextoEsp);
        });





//        if(viewModelTraducir.palabraExiste(inputTextoEsp)){
//            Log.d("salida2", viewModelTraducir.getPalabra(inputTextoEsp).toString());
//            Intent intent = new Intent(ActivityTraducir.this, ActivityTraducido.class);
//            startActivity(intent);
//        }else{
//            binding.msgTraducir.setText("Palabra: "+ inputTextoEsp + " No existe");
//            binding.inputEsp.setText("");
//            Log.d("salida2", "mierda ");
//        }


    }
}