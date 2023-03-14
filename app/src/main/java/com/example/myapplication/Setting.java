package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class Setting extends AppCompatActivity {
    Button setting_alarm_button, setting_todo_button, setting_habit_button, setting_calendar_button, setting_time_button;
    int hour, minute;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        ImageButton Setting_back_button = findViewById(R.id.setting_back_button);
        Setting_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        setting_alarm_button = findViewById(R.id.setting_alarm_button);
        setting_alarm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetTime customDialog = new SetTime(Setting.this,1);
                customDialog.show();
            }
        });

        setting_todo_button = findViewById(R.id.setting_todo_button);
        setting_todo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetTime customDialog = new SetTime(Setting.this,2);
                customDialog.show();
            }
        });

        setting_habit_button = findViewById(R.id.setting_habit_button);
        setting_habit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetTime customDialog = new SetTime(Setting.this,3);
                customDialog.show();
            }
        });

        setting_calendar_button = findViewById(R.id.setting_calendar_button);
        setting_calendar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetTime customDialog = new SetTime(Setting.this,4);
                customDialog.show();
            }
        });

        setting_time_button = findViewById(R.id.setting_time_button);
        setting_time_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetTime customDialog = new SetTime(Setting.this,5);
                customDialog.show();
            }
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        boolean isImmersiveModeEnabled = ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
        if (isImmersiveModeEnabled) {
            Log.i("Is on?", "Turning immersive mode mode off. ");
        } else {
            Log.i("Is on?", "Turning immersive mode mode on.");
        }
        newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);

        SwitchCompat setting_alarm_switch = findViewById(R.id.setting_alarm_switch);
        SwitchCompat setting_todo_switch = findViewById(R.id.setting_todo_switch);
        SwitchCompat setting_habit_switch = findViewById(R.id.setting_habit_switch);
        SwitchCompat setting_calendar_switch = findViewById(R.id.setting_calendar_switch);
        SwitchCompat setting_time_switch = findViewById(R.id.setting_time_switch);

        TextView setting_todo = findViewById(R.id.setting_todo);
        TextView setting_habit = findViewById(R.id.setting_habit);
        TextView setting_calendar = findViewById(R.id.setting_calendar);
        TextView setting_time = findViewById(R.id.setting_time);

        setting_alarm_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치의 상태가 변경되면 호출됩니다.
                if (isChecked) {
                    // 스위치가 On 상태인 경우 처리할 로직을 작성합니다.
                    setting_todo_switch.setVisibility(View.VISIBLE);
                    setting_habit_switch.setVisibility(View.VISIBLE);
                    setting_calendar_switch.setVisibility(View.VISIBLE);
                    setting_time_switch.setVisibility(View.VISIBLE);

                    setting_todo.setTextColor(Color.BLACK);
                    setting_habit.setTextColor(Color.BLACK);
                    setting_calendar.setTextColor(Color.BLACK);
                    setting_time.setTextColor(Color.BLACK);

                    setting_alarm_button.setVisibility(View.VISIBLE);
                    setting_todo_button.setVisibility(View.VISIBLE);
                    setting_habit_button.setVisibility(View.VISIBLE);
                    setting_calendar_button.setVisibility(View.VISIBLE);
                    setting_time_button.setVisibility(View.VISIBLE);

                } else {
                    // 스위치가 Off 상태인 경우 처리할 로직을 작성합니다.
                    setting_todo_switch.setVisibility(View.INVISIBLE);
                    setting_habit_switch.setVisibility(View.INVISIBLE);
                    setting_calendar_switch.setVisibility(View.INVISIBLE);
                    setting_time_switch.setVisibility(View.INVISIBLE);

                    setting_todo.setTextColor(Color.GRAY);
                    setting_habit.setTextColor(Color.GRAY);
                    setting_calendar.setTextColor(Color.GRAY);
                    setting_time.setTextColor(Color.GRAY);

                    setting_todo_button.setVisibility(View.INVISIBLE);
                    setting_habit_button.setVisibility(View.INVISIBLE);
                    setting_calendar_button.setVisibility(View.INVISIBLE);
                    setting_time_button.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
    public void setValue(int code, int hour, int minute){
        this.hour = hour;
        this.minute = minute;

        switch(code){
            case 1:
                setting_alarm_button.setText(hour+":"+minute);
                break;
            case 2:
                setting_todo_button.setText(hour+":"+minute);
                break;
            case 3:
                setting_habit_button.setText(hour+":"+minute);
                break;
            case 4:
                setting_calendar_button.setText(hour+":"+minute);
                break;
            case 5:
                setting_time_button.setText(hour+":"+minute);
                break;
        }
    }
}
