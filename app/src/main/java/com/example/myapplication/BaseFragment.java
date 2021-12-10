package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract  class BaseFragment extends Fragment {
    protected abstract int getLayoutResId();
    protected abstract int getCurrentFragment();
    protected abstract void loadControlsAndResize(View view);
    protected MainActivity activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        if(activity == null)
            activity = (MainActivity) getActivity();
        loadControlsAndResize(view);
        return view;
    }
}
