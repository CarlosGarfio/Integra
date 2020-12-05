package com.adssystems.integra.view;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adssystems.integra.R;
import com.adssystems.integra.util.Common;
import com.adssystems.integra.util.SetUpToolBar;
import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private Activity fa;

    private SetUpToolBar toolBar;
    private CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initComps();
        initActions();
        initStuff();
    }

    void initComps() {
        fa = this;
        this.circleImageView = this.findViewById(R.id.imgProfilePhoto);
    }

    void initActions() {
    }

    void initStuff() {
        toolBar = new SetUpToolBar(fa, true, "Perfil");
        Glide.with(fa).load(Common.getInstance(fa).getUser().url).into(this.circleImageView);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}