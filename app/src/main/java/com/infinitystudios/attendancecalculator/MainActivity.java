package com.infinitystudios.attendancecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Attendance, HoursTaken, HoursBunk;
    Button calculate;
    TextView result;
    float attn = 0f;
    int hoursTaken = 0, hoursBunk = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Attendance = (EditText) findViewById(R.id.etAttendance);
        HoursTaken = (EditText) findViewById(R.id.etHoursTaken);
        HoursBunk = (EditText) findViewById(R.id.etHoursBunk);
        calculate = (Button) findViewById(R.id.btnCalculate);
        result = (TextView) findViewById(R.id.tvResult);






        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    hoursTaken = Integer.parseInt(HoursTaken.getText().toString());
                }
                catch (NumberFormatException ex) {
                    hoursTaken = 0;
                }
                try {
                    attn = Float.valueOf(Attendance.getText().toString());
                }
                catch (NumberFormatException ex) {
                    attn = 0f;
                }
                try {
                    hoursBunk = Integer.parseInt(HoursBunk.getText().toString());
                }
                catch (NumberFormatException ex) {
                    hoursBunk = 0;
                }
                result.setText("You have bunked "+String.valueOf( (int) (((100-attn)/100)*hoursTaken)) + " hours.\n" +
                        "If you bunk "+String.valueOf(hoursBunk)+" more hours then your attendance will go down to "+
                        String.valueOf((((attn/100)*hoursTaken - hoursBunk)/hoursTaken)*100));
            }
        });

    }
}
