package com.adssystems.integra.util;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.adssystems.integra.R;
import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetUpToolBar implements
        View.OnClickListener {

    private Activity fa;

    private final Toolbar toolbar;
    private final ImageView btnBackArrow;
    private final ImageView imgLogo;
    private final TextView txtTitle;
    private final ImageView btnCustomAction;
    private final CircleImageView circleImageView;

    public SetUpToolBar(Activity fa, boolean isBackArrow, String title) {
        this.fa = fa;
        this.toolbar = this.fa.findViewById(R.id.toolbar);
        this.btnBackArrow = this.fa.findViewById(R.id.btnBackArrow);
        this.imgLogo = this.fa.findViewById(R.id.imgLogo);
        this.txtTitle = this.fa.findViewById(R.id.txtTitle);
        this.btnCustomAction = this.fa.findViewById(R.id.btnCustomAction);
        this.circleImageView = this.fa.findViewById(R.id.imgProfile);
        this.circleImageView.setVisibility(View.GONE);
        this.txtTitle.setText(title);

        if (isBackArrow) {
            this.btnBackArrow.setVisibility(View.VISIBLE);
            this.btnBackArrow.setOnClickListener(this);
        } else {
            this.btnBackArrow.setVisibility(View.GONE);
            this.btnBackArrow.setOnClickListener(null);
        }
    }

    public void setUpCustomAction(Drawable icon, int color, final CustomAction listener) {
        this.btnBackArrow.setVisibility(View.VISIBLE);
        this.btnBackArrow.setOnClickListener(this);
        this.btnCustomAction.setVisibility(View.VISIBLE);
        this.btnCustomAction.setImageDrawable(icon);
        this.btnCustomAction.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
        this.btnCustomAction.setOnClickListener(view -> listener.onClick());
    }

    public void setUpCustomAction(String url, final CustomAction listener) {
        this.circleImageView.setVisibility(View.VISIBLE);
        Glide.with(fa).load(url).into(this.circleImageView);
        this.circleImageView.setOnClickListener(view -> listener.onClick());
    }

    public void setTitle(String title) {
        txtTitle.setText(title);
    }

    public String getTitle() {
        return txtTitle.getText().toString();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBackArrow:
                fa.onBackPressed();
                break;
        }
    }

    public interface CustomAction {
        void onClick();
    }
}