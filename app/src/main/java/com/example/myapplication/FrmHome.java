package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FrmHome extends BaseFragment {

    private ImageView imgLogo;
    @Override
    protected int getLayoutResId() {
        return R.layout.frm_home;
    }

    @Override
    protected int getCurrentFragment() {
        return 0;
    }

    @Override
    protected void loadControlsAndResize(View view) {
        imgLogo = view.findViewById(R.id.imgLogo);
        imgLogo.getLayoutParams().width = activity.getSizeWithScale(100);
        imgLogo.getLayoutParams().height = activity.getSizeWithScale(51);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}