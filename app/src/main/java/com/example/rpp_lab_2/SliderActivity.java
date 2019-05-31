package com.example.rpp_lab_2;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SliderActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabViewAdapter slide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        viewPager = findViewById(R.id.viewpager);
        slide = new TabViewAdapter(this);
        viewPager.setAdapter(slide);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        viewPager.setCurrentItem(position);
    }
}
