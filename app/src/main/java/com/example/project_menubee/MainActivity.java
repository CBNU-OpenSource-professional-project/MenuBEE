package com.example.project_menubee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    boolean view_tip = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnstartclicked(View v)
    {
        if (view_tip) {
            Tip tip = new Tip(view_tip);
            Intent intent = new Intent(this, Tip.class);
            startActivity(intent);
            view_tip = tip.giveviewtip();
        } else {
            Intent intent = new Intent(this, Choice_mode.class);
            startActivity(intent);
        }
    }
}