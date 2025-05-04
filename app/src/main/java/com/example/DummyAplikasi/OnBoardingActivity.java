package com.example.DummyAplikasi; // ganti sesuai package kamu

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;

import java.util.Arrays;
import java.util.List;

class OnboardingActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        viewPager = findViewById(R.id.viewPager);
        btnNext = findViewById(R.id.btnNext);

        // Daftar layout slide
        List<Integer> slides = Arrays.asList(
                R.layout.slide1,
                R.layout.slide2,
                R.layout.slide3
        );

        SliderAdapter adapter = new SliderAdapter(slides);
        viewPager.setAdapter(adapter);

        btnNext.setOnClickListener(v -> {
            int current = viewPager.getCurrentItem();
            if (current < slides.size() - 1) {
                viewPager.setCurrentItem(current + 1);
            } else {
                startActivity(new Intent(OnboardingActivity.this, MainActivity.class));
                finish();
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (position == slides.size() - 1) {
                    btnNext.setText("Mulai");
                } else {
                    btnNext.setText("Next");
                }
            }
        });
    }
}