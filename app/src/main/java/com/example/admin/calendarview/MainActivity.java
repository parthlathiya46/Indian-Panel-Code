package com.example.admin.calendarview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button b1;
    private TextView theDate1;
    private TextView theDate2;
    private Button btnGoCalendar1;
    private Button btnGoCalendar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theDate1 = (TextView) findViewById(R.id.date2);
        theDate2 = (TextView) findViewById(R.id.date1);
        b1=(Button)findViewById(R.id.cont);
        btnGoCalendar1=(Button) findViewById(R.id.btnGoCalendar1);
        btnGoCalendar2=(Button) findViewById(R.id.btnGoCalendar2);
        //ImageView imageView = (ImageView) findViewById(R.id.car);
        //imageView.setImageResource(R.drawable.car);

        Intent incomingIntent = getIntent();
        String date1 = incomingIntent.getStringExtra("date1");
        String date2 = incomingIntent.getStringExtra("date2");
        theDate1.setText(date1);
        theDate2.setText(date2);

        btnGoCalendar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);

            }
        });
        btnGoCalendar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalendarActivity1.class);
                startActivity(intent);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, CarList.class);
                startActivity(intent);

            }
        });
    }
}
