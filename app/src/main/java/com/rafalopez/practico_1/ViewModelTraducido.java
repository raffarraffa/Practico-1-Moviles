package com.rafalopez.practico_1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ViewModelTraducido extends AndroidViewModel {
    private MutableLiveData<Palabra> mutableMsg;
    private  MutableLiveData<Bitmap> mutableImg;
    public ViewModelTraducido(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<Palabra> getMutableMsg() {
        if (mutableMsg==null) {
            mutableMsg = new MutableLiveData<>();
        }
        return mutableMsg;
    }
    public MutableLiveData<Bitmap> getMutableImg() {
        if (mutableImg==null) {
            mutableImg = new MutableLiveData<>();
        }
        return mutableImg;
    }
    public void setPalabra(Intent intent){
        Bundle bundle = new Bundle();
        bundle = intent.getBundleExtra("palabra");
        if(bundle != null){
            Palabra palabra = (Palabra) bundle.getSerializable("palabra");
            mutableMsg.setValue(palabra);
            //mutablePalabra.setValue(palabra.getEng());
            Log.d("salida","TRADUCIDO" + palabra.toString());
        }
    }
    public void setImg(Intent intent, Context context){
        Log.d("salida","TRADUCIDO contexto: " + context.getPackageName());
        Bundle bundle = new Bundle();
        bundle = intent.getBundleExtra("palabra");
        if(bundle != null){
            Palabra palabra = (Palabra) bundle.getSerializable("palabra");

            int imgId = context.getResources().getIdentifier(palabra.getImg(), "drawable",  context.getPackageName());
            //int imgId = context.getResources().getIdentifier(palabra.getImg(), "drawable",mundo
            // context.getPackageName());
            if(imgId == 0){
                Log.d("salida","No se encontro imagen");
                return;
            }
            Bitmap img = BitmapFactory.decodeResource(context.getResources(), imgId);
            mutableImg.setValue(img);
            Log.d("salida","IMAGEN: " + imgId);
       }

    }


}
