package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragmentToMain(new FrmHome());
    }
    public void addFragmentToMain(Fragment f) {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment currentFragment = fragmentManager.findFragmentById(R.id.frameMenuContainer);
            if (currentFragment != null) {
                fragmentManager.beginTransaction()
                        .remove(currentFragment)
                        .commitAllowingStateLoss();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        addOrReplaceFragment(R.id.frameParent, f);
    }
    public void addOrReplaceFragment(int idContent, Fragment f){
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment currentFragment = fragmentManager.findFragmentById(idContent);
            if(currentFragment!=null){
                fragmentManager.beginTransaction()
                        .replace(idContent, f)
//					.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right)
                        .commitAllowingStateLoss();
            }else {
                fragmentManager.beginTransaction()
                        .add(idContent, f)
//					.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right)
                        .commitAllowingStateLoss();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //TODO size manager
    private int screenWidth = 0;
    private float scaleValue = 0;
    private DisplayMetrics displayMetrics;
    private DisplayMetrics getDisplayMetrics() {
        if (displayMetrics == null)
            displayMetrics = getResources().getDisplayMetrics();
        return displayMetrics;
    }
    public int getScreenWidth() {
        if (screenWidth == 0)
            screenWidth = getDisplayMetrics().widthPixels;
        return screenWidth;
    }

    private float getScaleValue() {
        if (scaleValue == 0)
            scaleValue = getScreenWidth() * 1f / AppConstants.SCREEN_WIDTH_DESIGN;
        return scaleValue;
    }
    public int getSizeWithScale(double sizeDesign) {
        return (int) (sizeDesign * getScaleValue());
    }
}