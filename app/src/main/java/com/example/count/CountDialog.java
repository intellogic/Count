package com.example.count;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

/**
 * Created by Илья on 24.02.2016.
 */
public class CountDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View rootView = inflater.inflate(R.layout.countdialog, null);
        MainActivityFragment fr = (MainActivityFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
        final int lastClick = fr.lastLongClickButton;
        final SharedPreferences settings = getActivity().getSharedPreferences("Data", 0);
        final NumberPicker picker = (NumberPicker) rootView.findViewById(R.id.numberPicker);
        picker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        picker.setMinValue(0);
        picker.setMaxValue(500);
        switch (lastClick){
            case 1: picker.setValue((Integer)settings.getInt("Button1", 0));
                break;
            case 2: picker.setValue((Integer)settings.getInt("Button2", 0));
                break;
            case 3: picker.setValue((Integer)settings.getInt("Button3", 0));
                break;
            case 4: picker.setValue((Integer)settings.getInt("Button4", 0));
                break;
            case 5: picker.setValue((Integer)settings.getInt("Button5", 0));
                break;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyDialogTheme);
        builder
                .setPositiveButton("APPLY", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        int t = picker.getValue();

                        settings.edit();
                        SharedPreferences.Editor editor = settings.edit();
                        if (lastClick == 1)  {
                                editor.putInt("Button1", t);
                                Button bt1 = (Button)getActivity().findViewById(R.id.Button1);
                                bt1.setText("+" + ((Integer) t).toString());
                        }
                        else if (lastClick == 2) {
                                editor.putInt("Button2", t);
                                Button bt1 = (Button)getActivity().findViewById(R.id.Button2);
                                bt1.setText("+" + ((Integer) t).toString());
                            }
                        else if (lastClick == 3) {
                                editor.putInt("Button3", t);
                                Button bt1 = (Button) getActivity().findViewById(R.id.Button3);
                                bt1.setText("+" + ((Integer) t).toString());
                        }
                        else if (lastClick == 4) {
                                editor.putInt("Button4", t);
                                Button bt1 = (Button)getActivity().findViewById(R.id.Button4);
                                bt1.setText("+" + ((Integer) t).toString());
                        }
                        else if (lastClick == 5) {
                            editor.putInt("Button5", t);
                            Button bt1 = (Button)getActivity().findViewById(R.id.Button5);
                            bt1.setText("-" + ((Integer) t).toString());
                        }
                        editor.commit();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                })
                .setView(rootView)
        ;
        // Create the AlertDialog object and return it
        return builder.create();
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Button pButton =  ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_POSITIVE);
        Button nButton =  ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_NEGATIVE);
        nButton.setTextColor(Color.WHITE);
        pButton.setTextColor(Color.WHITE);
    }
}