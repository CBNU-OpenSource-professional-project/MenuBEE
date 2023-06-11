package com.example.menubee;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Choice_mode extends AppCompatActivity {

    AppCompatButton gotoorderbtn;
    AppCompatButton gotoplusrequestbtn;
    AppCompatButton gotomainbtn;

    AppCompatButton gotofastorderbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_mode);

        Intent intent = getIntent();
        CharSequence order = intent.getCharSequenceExtra("order");

        gotoorderbtn = findViewById(R.id.gotoorderbtn);

        gotoorderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AdditionalOrder.class);
            }
        });

        gotoplusrequestbtn = findViewById(R.id.gotoplusrequestbtn);

        gotoplusrequestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AdditionalOrder.class);
                startActivity(intent);
            }
        });

        gotomainbtn = findViewById(R.id.gomainbtn);

        gotomainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        gotofastorderbtn = findViewById(R.id.gotofastorderbtn);

        gotofastorderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Choice_mode.class);
                intent.putExtra("order", (CharSequence) order);
                startActivity(intent);
            }
        });
    }

}
