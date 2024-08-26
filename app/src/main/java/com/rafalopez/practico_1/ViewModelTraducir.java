package com.rafalopez.practico_1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ViewModelTraducir extends AndroidViewModel {
    private MutableLiveData<String> mutableMsg; //Informa algo a la vista
    private Set<String> engSet = new HashSet<>();
    private Set<String> espSet = new HashSet<>();
    private Set<String> imgSet = new HashSet<>();
    private Map<String, Palabra> palabras = new HashMap<>();

     // equivalnte a patron singleton, me garantiza una unica instancia de mutableMsg
     public MutableLiveData<String> getMutableMsg() {
        if (mutableMsg==null) {
            mutableMsg = new MutableLiveData<>();
        }
        return mutableMsg;
    }
    public ViewModelTraducir(@NonNull Application application) {
        super(application);
        // Palabras harcodeadas
        Palabra p1 = new Palabra("Bell pepper", "Morron", "morron");
        Palabra p2 = new Palabra("Boots", "Botas", "botas");
        Palabra p3 = new Palabra("Horse", "Caballo", "caballo");
        Palabra p4 = new Palabra("Shirt", "Camisa", "camisa");
        Palabra p5 = new Palabra("House", "Casa", "casa");
        Palabra p6 = new Palabra("Pig", "Cerdo", "cerdo");
        Palabra p7 = new Palabra("Cherry", "Cereza", "cereza");
        Palabra p8 = new Palabra("Plum", "Ciruela", "ciruela");
        Palabra p9 = new Palabra("Strawberry", "Frutilla", "frutilla");
        Palabra p10 = new Palabra("Hen", "Gallina", "gallina");
        Palabra p11 = new Palabra("Apple", "Manzana", "manzana");
        addPalabra(p1);
        addPalabra(p2);
        addPalabra(p3);
        addPalabra(p4);
        addPalabra(p5);
        addPalabra(p6);
        addPalabra(p7);
        addPalabra(p8);
        addPalabra(p9);
        addPalabra(p10);
        addPalabra(p11);
    }

    private void addPalabra(Palabra palabra) { // importnat private
        boolean esUnica = engSet.add(palabra.getEng()) &&  espSet.add(palabra.getEsp()) ;
        if (esUnica) {
            imgSet.add(palabra.getImg());
            palabras.put(palabra.getEsp().toLowerCase(), palabra);
        }
    }
    public void verPalabras(){
        palabras.forEach((key, value) ->{
            Log.d("salida", "Palabra: " + key+ " -- " + value.toString());
        });
    }
    public boolean palabraExiste(String palabraKey) {
        return palabras.containsKey(palabraKey.toLowerCase());
    }
    public void traducirPalabra(String palabraKey) {
         Log.d("salida", "traducirPalabra: " + palabraKey);
         if(palabraKey.isEmpty()){
             mutableMsg.setValue("No ingreso palabra");
             Log.d("salida", "MIERDA Palabra vacia ");
             return;
         }

        Palabra palabra=palabras.get(palabraKey.toLowerCase());
        // si palabra no es null la envio a la otra Activity
        if(palabra!=null) {
            Intent intent=new Intent( getApplication(),ActivityTraducido.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("palabra", (Serializable) palabra);
            intent.putExtra("palabra", bundle);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
            Log.d("salida", palabra.toString());
        }else{
            mutableMsg.setValue( palabraKey.toUpperCase() + " no esta disponible ");
            Log.d("salida", "MIERDA Palabra no diponible");
        }
    }
}
