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

        textSelectVoice = findViewById(R.id.sound_TTS_change);


        AppCompatButton setBGcolor = findViewById(R.id.colorPicker_button);
        setBGcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),selectcolor.class);
                startActivity(intent);

                database.storeString("BGcolor",database.getString("selectcolor",""));

                changeBGColor = findViewById(R.id.displayColor);

                BGcolor = database.getString("BGcolor","");

                int BGcolorInt = Color.parseColor(BGcolor);

                changeBGColor.setBackgroundColor(BGcolorInt);
            }
        });

        AppCompatButton setTextcolor = findViewById(R.id.colorPicker_button2);
        setTextcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),selectcolor.class);
                startActivity(intent);

                database.storeString("Textcolor",database.getString("selectcolor",""));

                changeTextColor = findViewById(R.id.Menu_Text_Color);

                Textcolor = database.getString("Textcolor","");

                int TextcolorInt = Color.parseColor(Textcolor);

                changeTextColor.setBackgroundColor(TextcolorInt);
            }
        });


    }


}

