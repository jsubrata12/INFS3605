package com.example.infs3605;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;

public class LoadingDialog {

    Activity activity;
    AlertDialog dialog;

    LoadingDialog(Activity myActivity){
        activity= myActivity;
    }

    void startLoadingAnimation(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog,null));
        builder.setCancelable(false);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void dismissDialog() {
        dialog.dismiss();
    }
}
