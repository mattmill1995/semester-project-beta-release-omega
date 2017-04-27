package com.bignerdranch.android.finalproject;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by morgan on 4/27/2017.
 */

public class SetScorePopup extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        return new AlertDialog.Builder(getActivity())
                .setTitle("Set Score")
                .setPositiveButton("OK", null)
                .create();
    }
}
