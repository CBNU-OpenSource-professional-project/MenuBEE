package com.example.menubee;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Timer;
import java.util.TimerTask;

public class ViewPager2AutoScrollActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private int currentPage = 0;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2_auto_scroll);

        viewPager2 = findViewById(R.id.viewPager2);

        ImageSliderAdapter adapter = new ImageSliderAdapter(this);
        viewPager2.setAdapter(adapter);

        // 페이지 전환을 위한 타이머 설정
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (currentPage == adapter.getItemCount() - 1) {
                    currentPage = 0;
                }
                viewPager2.setCurrentItem(++currentPage, true);
            }
        }, 3000, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 액티비티가 종료될 때 타이머 취소
        timer.cancel();
    }
}
