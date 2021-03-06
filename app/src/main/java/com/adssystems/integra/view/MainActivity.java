package com.adssystems.integra.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.adssystems.integra.R;
import com.adssystems.integra.model.Product;
import com.adssystems.integra.util.Common;
import com.adssystems.integra.util.SetUpToolBar;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    private Activity fa;

    private BottomNavigationView bottomNavigationView;
    private SetUpToolBar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComps();
        initActions();
        initStuff();

        SetUpBadge();
    }

    void initComps() {
        fa = this;
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    void initActions() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    void initStuff() {
        toolBar = new SetUpToolBar(fa, false, "Integra");
        toolBar.setTitle(getString(R.string.bottom_nav_home));

        toolBar.setUpCustomAction(Common.getInstance(fa).getUser().url, () -> startActivity(new Intent(fa, ProfileActivity.class)));

        loadFragment(HomeFragment.newInstance());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                toolBar.setTitle(getString(R.string.bottom_nav_home));
                fragment = HomeFragment.newInstance();
                break;
            case R.id.navigation_favorite:
                toolBar.setTitle(getString(R.string.bottom_nav_favorite));
                fragment = null;
                break;
            case R.id.navigation_shopping_cart:
                toolBar.setTitle(getString(R.string.bottom_nav_shopping_cart));
                fragment = ShoppingCartFragment.newInstance();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public void SetUpBadge() {
        BottomNavigationView navigationView = bottomNavigationView;
        if (navigationView == null) return;
        BadgeDrawable badgeDrawable = navigationView.getOrCreateBadge(R.id.navigation_shopping_cart);
        if (badgeDrawable == null) return;
        int count = 0;
        for (Product p : Common.getInstance(fa).getProducts()) {
            count += p.quantity;
        }
        badgeDrawable.setVisible(count != 0);
        badgeDrawable.setNumber(count);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}