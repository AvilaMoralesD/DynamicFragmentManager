package com.example.fragment.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.fragment.R;
import com.example.fragment.data.Message;


/**
 * Cuando se utiliza el componente FragmentManager, NUNCA se destruye el FRAGMENT sino que SOLO SE DESTRUYE LA VISTA.
 * y sqeguarda la instancia del objeto Fragment en memoria. Por eso nunca se llama al metodo onDestroy() de
 * los fragment a no ser que se finalicen explicitamente
 */

public class MainActivity extends AppCompatActivity implements FragmentA.OnSetDataMessage {

    private final static String TAG = "MainActivity";
    Fragment fragmentb;
    Fragment fragmenta;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmenta = getSupportFragmentManager().findFragmentByTag(FragmentA.TAG);
        fragmentManager = getSupportFragmentManager();
        fragmenta=new FragmentA(); //MAL
        if (savedInstanceState == null) { //Esta es mi primera ejecución
            fragmenta = new FragmentA(); //MAL
            //Es el gestor a encargado de las transacciones de los fragment
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(android.R.id.content, fragmenta);
            fragmentTransaction.commit();
        }
        Log.d(TAG, "MainActivity -> onCreate()");
    }

    public void onSetDataMessage(Message message) {
        fragmentb = new FragmentB();
        //Cuando se utiliza FragmentManager para cambiar un fragment por otro, la actividad
        //le pasa la informacion a traves del bundle
        Bundle bundle = new Bundle();
        bundle.putParcelable(message.KEY, message);
        fragmentb.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragmentb);
        //Para guardar el fragmensto A en la pila de fragmentos de la activity se llama al metodoÃ§
        //addToBackStack de forma que si el usuario pulsa la tacla Bak en B -> se muestar a
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Log.d(TAG, "MainActivity -> Vengo de un back()");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity -> onStart()");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity -> onResume()");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity -> onPause()");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity -> onStop()");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity -> onDestroy()");

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}