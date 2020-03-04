package com.andreyjig.moviemvp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.mvp.model.handler.ErrorHandler;
import com.andreyjig.moviemvp.ui.activity.handler.AppBarCustom;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.sergivonavi.materialbanner.Banner;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements AppBarCustom {

    NavController navController;
    View topTextScrim;
    CollapsingToolbarLayout toolbarLayout;
    Toolbar toolbar;
    ImageView imageViewAppBar;
    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topTextScrim = findViewById(R.id.top_text_scrim);
        toolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        toolbar = findViewById(R.id.toolbar);
        imageViewAppBar = findViewById(R.id.image_view_app_bar);
        setSupportActionBar(toolbar);
        toolbarLayout.setTitleEnabled(false);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container);
        banner = findViewById(R.id.error_banner);
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
                .error(R.drawable.ic_video_camera)
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
       banner.setLeftButtonListener(banner -> handler.hideErrorDialog());

        banner.setRightButtonListener(banner -> handler.retryAction());

        banner.setMessage(text);
        banner.setIcon(R.drawable.ic_signal_wifi_off_24dp);
        banner.show();
    }

    @Override
    public void hideErrorBar() {
        banner.setVisibility(View.GONE);
    }
}
