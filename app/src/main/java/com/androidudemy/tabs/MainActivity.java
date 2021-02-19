package com.androidudemy.tabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.androidudemy.tabs.Fragment.HomeFragment;
import com.androidudemy.tabs.Fragment.SubscriptionsFragment;
import com.androidudemy.tabs.Fragment.TrendingFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.viewPagerTab);
        viewPager = findViewById(R.id.viewPager);

        getSupportActionBar().setElevation(50);

        //Adpter for tabs
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                      .add("Home", HomeFragment.class)
                      .add("Subscriptions", SubscriptionsFragment.class)
                      .add("Trending", TrendingFragment.class)
                .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}