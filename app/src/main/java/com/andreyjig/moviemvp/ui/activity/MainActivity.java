package com.andreyjig.moviemvp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import com.andreyjig.moviemvp.R;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container);
//        NavigationUI.setupActionBarWithNavController(this, navController);
    }
/*
    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }
    */
}
