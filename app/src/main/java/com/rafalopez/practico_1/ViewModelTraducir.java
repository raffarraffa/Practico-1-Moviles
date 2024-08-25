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
    // equivalnte a patron singleto, me garnatiza una unic ainstancioa de getmesg
     public LiveData<String> getMutableMsg() {
        if (mutableMsg==null) {
            mutableMsg = new MutableLiveData<>();
        }
        return mutableMsg;
    }
    public ViewModelTraducir(@NonNull Application application) {
        super(application);
        // Palabras harcodeadas
        Palabra p1 = new Palabra("hello", "hola", "image1.png");
        Palabra p2 = new Palabra("world", "mundo", "image2.png");
        Palabra p3 = new Palabra("apple", "manzana", "image3.png");
        Palabra p4 = new Palabra("tree", "arbol");
        addPalabra(p1);
        addPalabra(p2);
        addPalabra(p3);
        addPalabra(p4);
    }

    public void addPalabra(Palabra palabra) {
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
         if(palabraKey==null){
             mutableMsg.setValue("No ingreso palabra");
             Log.d("salida", "MIERDA Palabra vacia ");
             return;
         }
        Palabra palabra=palabras.get(palabraKey.toLowerCase());
        // si palabra no es null la envio a la otra Activity
        if(palabra!=null) {
            Log.d("salida", palabra.toString());
        }else{
            mutableMsg.setValue("No dispongo de  esta palabra");
            Log.d("salida", "MIERDA Palabra no diponible");
        }
    }
}
