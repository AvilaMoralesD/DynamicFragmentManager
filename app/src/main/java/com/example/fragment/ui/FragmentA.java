package com.example.fragment.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.databinding.FragmentABinding;
import com.example.fragment.data.Message;


public class FragmentA extends Fragment {

    FragmentABinding binding;
    OnSetDataMessage listener;
    public final static String TAG = "Fragment A";

    //Se declara una interfaz con el/los métodos que ofrece
    //este Fragment (contrato)
    interface OnSetDataMessage {
        void onSetDataMessage(Message message);
    }

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnSetDataMessage) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " debes implementar la interfaz OnSetDataMessage");
        }
        Log.d(TAG, "Fragment A -> onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Fragment A -> onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater);
        binding.setMessage(new Message());
        binding.btnFA.setOnClickListener(view -> {
            listener.onSetDataMessage(binding.getMessage());
        });
        Log.d(TAG, "Fragment A -> onCreateView()");

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment A -> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Fragment A -> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Fragment A -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment A -> onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment A -> onDestroy()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        Log.d(TAG, "Fragment A -> onDestroyView()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "Fragment A -> onDetach()");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (binding != null) //Sólo cuando existe la vista, se guarda su estado
            outState.putParcelable(Message.KEY, binding.getMessage());
        Log.d(TAG, "Fragment A -> onSaveInstanceState()");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        //Si la vista es null, no se restaura el estado del fragment
        if (savedInstanceState != null) //Si vengo de un cambio de configuracion, recupera el es
            if (binding != null) //Si existe la vista del fragment
                binding.setMessage(savedInstanceState.getParcelable(Message.KEY));
        Log.d(TAG, "Fragment A -> onViewStateRestored()");

    }
}