package com.geniusforapp.fancysample;

import android.app.Dialog;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.geniusforapp.fancydialog.FancyAlertDialog;


public class MainActivity extends AppCompatActivity {

    private FancyAlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buildAndShowDialog();
            }
        });
        setupDialogToSustainAfterRotation(fab);
    }

    private void buildAndShowDialog() {
        dialog = new FancyAlertDialog.Builder(MainActivity.this)
                .setImageDrawable(getResources().getDrawable(R.drawable.ic_cloud_computing))
                .setTextTitle("UPLOAD")
                .setTextSubTitle("128GB/500GB")
                .setBody("New DATA has ben added to the device. Do you want to sync it with the service?")
                .setPositiveButtonText("Continue")
                .setPositiveColor(R.color.colorPositive)
                .setOnPositiveClicked(new FancyAlertDialog.OnPositiveClicked() {
                    @Override
                    public void OnClick(View view, Dialog dialog) {
                        Toast.makeText(MainActivity.this, "Updating...", Toast.LENGTH_SHORT).show();
                        ((CustomApplication) getApplication()).setDialogOpened(false);
                    }
                }).setAlertFont("Roboto-Bold.ttf")
                .setBodyGravity(FancyAlertDialog.TextGravity.CENTER)
                .setTitleGravity(FancyAlertDialog.TextGravity.CENTER)
                .setSubtitleGravity(FancyAlertDialog.TextGravity.CENTER)
                .setCancelable(false)
                .build();
        ((CustomApplication) getApplication()).setDialogOpened(true);
        dialog.show();
    }

    private void setupDialogToSustainAfterRotation(View viewToPostAfter) {
        // REMEMBER to dismiss dialog in onPause method
        // Make sure that all views are drawn
        viewToPostAfter.post(new Runnable() {
            @Override
            public void run() {
                // then check if dialog was previously opened
                if (((CustomApplication) getApplication()).wasDialogOpened()) {
                    buildAndShowDialog();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (dialog != null) dialog.dismiss();
    }
}
