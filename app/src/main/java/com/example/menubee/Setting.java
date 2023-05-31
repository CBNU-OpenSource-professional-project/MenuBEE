package com.example.menubee;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import com.maxkeppeler.sheets.color.ColorSheet;

public class Setting extends AppCompatActivity {

    private TextView textSelectVoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        textSelectVoice = findViewById(R.id.sound_TTS_change);

        findViewById(R.id.colorPicker_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupColorSheet();
            }
        });
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.voice_options_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.voice_option1:
                        // Handle voice option 1 selection
                        return true;
                    case R.id.voice_option2:
                        // Handle voice option 2 selection
                        return true;
                    case R.id.voice_option3:
                        // Handle voice option 3 selection
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }

    private void setupColorSheet() {
        int[] colors = getResources().getIntArray(R.array.colors);

        ColorSheet.getInstance()
                .cornerRadius(8)
                .colorPicker(colors, selectedColor, new ColorSheet.OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int color) {
                        selectedColor = color;
                        setColor(selectedColor);
                    }
                })
                .show(getSupportFragmentManager(), "colorPicker");
    }

    private void setColor(@ColorInt int color) {
        TextView displayColor = findViewById(R.id.displayColor);
        Button colorPickerButton = findViewById(R.id.colorPicker_button);

        displayColor.setBackgroundTintList(ColorStateList.valueOf(color));
        colorPickerButton.setText(ColorSheetUtils.colorToHex(color));
    }
}
