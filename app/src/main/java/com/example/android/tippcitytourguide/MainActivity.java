package com.example.android.tippcitytourguide;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.tippcitytourguide.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set up Data Binding and set the content.
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        // Set the Toolbar.
        setSupportActionBar(binding.appToolbar);

        // Create an adapter that knows which fragment should be shown on each page.
        CategoryPagerAdapter adapter = new CategoryPagerAdapter(this,
                getSupportFragmentManager());

        // Set the adapter onto the view pager.
        binding.viewpager.setAdapter(adapter);

        // Setup the TabLayout with the ViewPager so the user can swipe between fragments.
        binding.tabs.setupWithViewPager(binding.viewpager);
    }
}
