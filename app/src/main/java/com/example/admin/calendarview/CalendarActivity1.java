package com.example.admin.calendarview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

public class CalendarActivity1 extends AppCompatActivity {
    private static final String TAG = "CalendarActivity";
    private CalendarView mCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar1);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                String date2 = i2 + "/" + (i1+1) + "/" + i;
                Log.d(TAG , "onSelectDayChange: dd/mm/yy: " + date2);

                Intent intent = new Intent(CalendarActivity1.this, MainActivity.class);
                intent.putExtra("date2", date2);
                startActivity(intent);


            }
        });
    }
}
