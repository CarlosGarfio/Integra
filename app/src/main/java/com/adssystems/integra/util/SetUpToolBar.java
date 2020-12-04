package com.adssystems.integra.util;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.adssystems.integra.R;

public class SetUpToolBar implements
        View.OnClickListener {

    private Activity fa;

    private Toolbar toolbar;
    private ImageView btnBackArrow;
    private ImageView imgLogo;
    private TextView txtTitle;
    private ImageView btnCustomAction;

    public SetUpToolBar(Activity fa, String title) {
        this.fa = fa;
        this.toolbar = this.fa.findViewById(R.id.toolbar);
        this.btnBackArrow = this.fa.findViewById(R.id.btnBackArrow);
        this.imgLogo = this.fa.findViewById(R.id.imgLogo);
        this.txtTitle = this.fa.findViewById(R.id.txtTitle);
        this.btnCustomAction = this.fa.findViewById(R.id.btnCustomAction);
        this.btnBackArrow.setVisibility(View.GONE);
        this.txtTitle.setText(title);
    }

    public void setUpCustomAction(Drawable icon, int color, final CustomAction listener) {
        this.btnBackArrow.setVisibility(View.VISIBLE);
        this.btnBackArrow.setOnClickListener(this);
        this.btnCustomAction.setVisibility(View.VISIBLE);
        this.btnCustomAction.setImageDrawable(icon);
        this.btnCustomAction.setColorFilter(color, android.graphics.PorterDuff.Mode.MULTIPLY);
        this.btnCustomAction.setOnClickListener(view -> listener.onClick());
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