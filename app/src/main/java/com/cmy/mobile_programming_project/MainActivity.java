package com.cmy.mobile_programming_project;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.cmy.mobile_programming_project.adapter.FragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_main);
        tabLayout = findViewById(R.id.tabs_main);
        viewPager = findViewById(R.id.view_pager_main);
        setSupportActionBar(toolbar);
        setupViewPager();
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_medicine);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_supplement);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_haircare);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_healthcare);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        Toast.makeText(MainActivity.this, "Medicine is selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Supplement is selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Haircare is selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Health Care is selected", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    public void setupViewPager(){
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MedicinesFragment(), "Medicine");
        adapter.addFrag(new SupplementFragment(), "Supplement");
        adapter.addFrag(new HairCareFragment(), "Haircare");
        adapter.addFrag(new HealthcareFragment(), "Health Care");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
