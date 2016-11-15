package com.example.count;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    int lastLongClickButton;
    public MainActivityFragment() {
    }
    public void Start(Button b1, Button b2, Button b3, Button b4, Button b5, TextView text){
        SharedPreferences Data = getActivity().getSharedPreferences("Data", 0);
        if (!Data.contains("FirstTime")){
            SharedPreferences.Editor editor = Data.edit();
            editor.putBoolean("FirstTime", true);
            editor.putInt("Button1", 1);
            editor.putInt("Button2", 2);
            editor.putInt("Button3", 3);
            editor.putInt("Button4", 4);
            editor.putInt("Button5", 1);
            editor.putInt("Value", 0);
            editor.commit();
        }
        b1.setText("+" + ((Integer)Data.getInt("Button1", 0)).toString());
        b2.setText("+" + ((Integer)Data.getInt("Button2", 0)).toString());
        b3.setText("+" + ((Integer)Data.getInt("Button3", 0)).toString());
        b4.setText("+" + ((Integer)Data.getInt("Button4", 0)).toString());
        b5.setText("-" + ((Integer)Data.getInt("Button5", 0)).toString());
        text.setText(((Integer)Data.getInt("Value", 0)).toString());

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView txt = (TextView)rootView.findViewById(R.id.textView);
        final SharedPreferences settings = getActivity().getSharedPreferences("Data", 0);
        Button b1 = (Button)rootView.findViewById(R.id.Button1);
        Button b2 = (Button)rootView.findViewById(R.id.Button2);
        Button b3 = (Button)rootView.findViewById(R.id.Button3);
        Button b4 = (Button)rootView.findViewById(R.id.Button4);
        Button b5 = (Button)rootView.findViewById(R.id.Button5);

        Start(b1, b2, b3, b4, b5, txt);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(txt.getText().toString());
                int v1 = settings.getInt("Button1", 0);
                res += v1;
                txt.setText(((Integer) res).toString());

            }
        });

        b1.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                lastLongClickButton = 1;
                CountDialog d = new CountDialog();
                d.show(getFragmentManager(), "");
                return true;
            }


        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(txt.getText().toString());
                int v2 = settings.getInt("Button2", 0);
                res += v2;
                txt.setText(((Integer) res).toString());

            }
        });
        b2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                lastLongClickButton = 2;
                CountDialog d = new CountDialog();
                d.show(getFragmentManager(), "");
                return true;
            }


        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(txt.getText().toString());
                int v3 = settings.getInt("Button3", 0);
                res += v3;
                txt.setText(((Integer) res).toString());

            }
        });
        b3.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                lastLongClickButton = 3;
                CountDialog d = new CountDialog();
                d.show(getFragmentManager(), "");
                return true;
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(txt.getText().toString());
                int v4 = settings.getInt("Button4", 0);
                res += v4;
                txt.setText(((Integer) res).toString());
            }
        });
        b4.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                lastLongClickButton = 4;
                CountDialog d = new CountDialog();
                d.show(getFragmentManager(), "");
                return true;
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(txt.getText().toString());
                int v5 = settings.getInt("Button5", 0);
                res -= v5;
                txt.setText(((Integer) res).toString());
            }
        });
        b5.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                lastLongClickButton = 5;
                CountDialog d = new CountDialog();
                d.show(getFragmentManager(), "");
                return true;
            }
        });
        return rootView;
    }

}
