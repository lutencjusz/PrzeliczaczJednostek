package com.example.przeliczaczjednostek;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import com.example.przeliczaczjednostek.events.DistanceFragmentActionEvent;
import com.example.przeliczaczjednostek.events.EnActionEvent;
import com.example.przeliczaczjednostek.events.PlActionEvent;
import com.example.przeliczaczjednostek.screens.distance.DistanceFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.przeliczaczjednostek.databinding.ActivityMainBinding;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private Bus bus;
    private Resources resources;
    private Configuration configuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = ((App) getApplication()).getBus();
        resources = getResources();
        configuration = resources.getConfiguration();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.container);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        navigationView.setNavigationItemSelectedListener(this);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        bus.unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.pl_flag) {
            configuration.setLocale(new Locale("pl"));
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            bus.post(new PlActionEvent());
        } else if (id == R.id.eng_flag) {
            configuration.setLocale(new Locale("en"));
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            bus.post(new EnActionEvent());
        } else if (id==R.id.exit){
            this.finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.container);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_distance) {
            showFragment(new DistanceFragment());
        } else if (id == R.id.nav_scale) {

        } else if (id == R.id.nav_capacity) {

        } else if (id == R.id.nav_exit) {
            this.finishAffinity();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Subscribe
    public void onDistanceFragmentActionEvent(DistanceFragmentActionEvent event){
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.menu_distance);
        showFragment(new DistanceFragment());
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}