package com.example.menubee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Camera_capture extends AppCompatActivity {

    AppCompatButton select_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_capture);


        // 선택 버튼 클릭시
        select_btn = findViewById(R.id.selectimg);
        select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewPager2AutoScrollActivity.class);
                startActivity(intent);
            }
        });


    }
}