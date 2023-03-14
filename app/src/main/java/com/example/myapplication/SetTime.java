package com.example.myapplication;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class SetTime extends Dialog {

    public SetTime(@NonNull Setting context, int code) {
        super(context);
        setContentView(R.layout.set_time);


        TimePicker todoTP = findViewById(R.id.todoTP);
        Button set_time_submit = findViewById(R.id.set_time_submit);
        Button set_time_cancle = findViewById(R.id.set_time_cancle);

        set_time_submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                int selectedHour = todoTP.getHour(); // 선택된 시간
                int selectedMinute = todoTP.getMinute();
                context.setValue(code, selectedHour, selectedMinute);
                dismiss();
            }
        });

        set_time_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}