package com.example.fragment.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.data.Message;
import com.example.fragment.databinding.FragmentBBinding;


public class FragmentB extends Fragment {
    FragmentBBinding binding;
    private final static String TAG = "Fragment B";

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBBinding.inflate(inflater);
        if (savedInstanceState != null)
            binding.setMessage(savedInstanceState.getParcelable(Message.KEY));
        else {
            binding.setMessage(getArguments().getParcelable(Message.KEY));
        }
        Log.d(TAG, "Fragment B -> onCreateView()");
        return binding.getRoot();
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment B -> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Fragment B -> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Fragment B -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment B -> onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "Fragment B -> onDestroy()");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(Message.KEY, binding.getMessage());
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null)
            binding.setMessage(savedInstanceState.getParcelable(Message.KEY));

    }
}