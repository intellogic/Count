package com.example.count;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements KeyEvent.Callback {
    boolean ifPressedVolumeDown = false;
    boolean ifPressedPowerButton = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about){
            startActivity(new Intent(this, AboutActivity.class));
        } else
        if (item.getItemId() == R.id.action_refresh){
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("0");
                SaveValue();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        SaveValue();
    }
    void SaveValue(){
        SharedPreferences settings = getSharedPreferences("Data", 0);
        SharedPreferences.Editor editor = settings.edit();
        TextView txt = (TextView) findViewById(R.id.textView);
        editor.putInt("Value", Integer.parseInt(txt.getText().toString()));
        editor.commit();
    }

}
