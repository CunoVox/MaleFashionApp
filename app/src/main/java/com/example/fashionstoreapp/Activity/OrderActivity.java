package com.example.fashionstoreapp.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.fashionstoreapp.Adapter.OrderFragmentAdapter;
import com.example.fashionstoreapp.R;
import com.google.android.material.tabs.TabLayout;

public class OrderActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    OrderFragmentAdapter orderFragmentAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        AnhXa();

        FragmentManager fragmentManager = getSupportFragmentManager();
        orderFragmentAdapter = new OrderFragmentAdapter(fragmentManager, getLifecycle());
        viewPager2.setAdapter(orderFragmentAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("All Order"));
        tabLayout.addTab(tabLayout.newTab().setText("Pay On Delivery"));
        tabLayout.addTab(tabLayout.newTab().setText("Pay With ZaloPay"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }

    private void AnhXa() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
    }
}
