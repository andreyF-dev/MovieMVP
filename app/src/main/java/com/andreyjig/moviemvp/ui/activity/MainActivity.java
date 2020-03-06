package com.andreyjig.moviemvp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.ui.activity.handler.ActivityHandler;
import com.andreyjig.moviemvp.ui.fragment.handler.ErrorHandler;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.sergivonavi.materialbanner.Banner;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements ActivityHandler {

    private NavController navController;
    private View topTextScrim;
    private Toolbar toolbar;
    private ImageView imageViewAppBar;
    private Banner banner;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        topTextScrim = findViewById(R.id.top_text_scrim);
        toolbar = findViewById(R.id.toolbar);
        imageViewAppBar = findViewById(R.id.image_view_app_bar);
        banner = findViewById(R.id.error_banner);
        progressBar = findViewById(R.id.progress_bar);
        setSupportActionBar(toolbar);
        toolbarLayout.setTitleEnabled(false);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container);
        NavigationUI.setupActionBarWithNavController(this, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

    @Override
    public void setAppBarImage(String url) {
        Picasso.get()
                .load(url)
                .into(imageViewAppBar);
        topTextScrim.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideAppBarImage() {
        imageViewAppBar.setImageDrawable(null);
        topTextScrim.setVisibility(View.GONE);

    }

    @Override
    public void setAppBarTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public void showErrorBar(String text, ErrorHandler handler) {
        banner.setLeftButtonListener(banner -> handler.onCancelErrorDialog());
        banner.setRightButtonListener(banner -> handler.onOkErrorDialog());
        banner.setMessage(text);
        banner.setIcon(R.drawable.ic_signal_wifi_off_24dp);
        if (!banner.isActivated()) {
            banner.show();
        }
    }

    @Override
    public void hideErrorBar() {
        banner.animate().cancel();
        banner.dismiss();
    }

    @Override
    public void showPreviewScreen() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePreviewScreen() {
        progressBar.setVisibility(View.GONE);
    }
}
