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

    String BGcolor;
    String Textcolor;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        database = new Database(this);

        boolean BGtoken = database.getBoolean("BGtoken",false);
        boolean Texttoken = database.getBoolean("Texttoken",false);

        if (BGtoken && !Texttoken)
        {
            String temp = database.getString("colorval","");

            database.storeString("BGcolor",temp);

            changeBGColor = findViewById(R.id.displayColor);

            int TextcolorInt = Color.parseColor(temp);

            changeBGColor.setBackgroundColor(TextcolorInt);
        }
        else if(!BGtoken && Texttoken)
        {
            String temp = database.getString("colorval","");

            database.storeString("Textcolor",temp);

            changeTextColor = findViewById(R.id.Menu_Text_Color);

            int TextcolorInt = Color.parseColor(temp);

            changeTextColor.setBackgroundColor(TextcolorInt);
        }

        textSelectVoice = findViewById(R.id.sound_TTS_change);


        AppCompatButton setBGcolor = findViewById(R.id.colorPicker_button);
        setBGcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.storeBoolean("BGorText",true);
                Intent intent = new Intent(getApplicationContext(),selectcolor.class);
                startActivity(intent);
                finish();
            }
        });

        AppCompatButton setTextcolor = findViewById(R.id.colorPicker_button2);
        setTextcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.storeBoolean("BGorText",false);
                Intent intent = new Intent(getApplicationContext(),selectcolor.class);
                startActivity(intent);
                finish();
            }
        });


    }

}

