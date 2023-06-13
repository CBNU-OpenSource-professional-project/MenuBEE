package com.example.menubee;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Setting extends AppCompatActivity {
    TextView textSelectVoice;

    TextView changeBGColor;
    TextView changeTextColor;

    AppCompatButton setBGcolor;
    AppCompatButton setTextcolor;

    AppCompatButton settingdonebtn;

    String BGcolor;
    String Textcolor;
    Database database;

    boolean BGtoken;
    boolean Texttoken;

    int TextcolorInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        database = new Database(this);

        textSelectVoice = findViewById(R.id.sound_TTS_change);


         setBGcolor = findViewById(R.id.colorPicker_button);
        setBGcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.storeBoolean("BGorText",true);
                Intent intent = new Intent(getApplicationContext(),selectcolor.class);
                startActivity(intent);
            }
        });

         setTextcolor = findViewById(R.id.colorPicker_button2);
        setTextcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.storeBoolean("BGorText",false);
                Intent intent = new Intent(getApplicationContext(),selectcolor.class);
                startActivity(intent);
            }
        });

        settingdonebtn = findViewById(R.id.settingdonebtn);
        settingdonebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }

}

