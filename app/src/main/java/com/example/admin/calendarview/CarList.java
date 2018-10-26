package com.example.admin.calendarview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CarList extends AppCompatActivity {

    ListView mListView;
    int[] images = {R.drawable.baleno, R.drawable.ciaz, R.drawable.city, R.drawable.figo, R.drawable.i20, R.drawable.swift};

    String[] names = {"Maruti Suzuki Baleno", "Honda Ciaz", "Honda City", "Ford figo", "I20", "Maruti Suzuki Swift"};
    String[] fare = {"1500₹ Per Day", "2100₹ Per Day", "1200₹ Per Day", "1100₹ Per Day", "1300₹ Per Day", "2000₹ Per Day"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        mListView= (ListView) findViewById(R.id.listView);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        mListView.setAdapter(customAdaptor);


    }

    class CustomAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.customlayout, null );

            ImageView mImageView =(ImageView) view.findViewById(R.id.imageView);
            TextView mTextView = (TextView) view.findViewById(R.id.textView);
            Button button = (Button) view.findViewById(R.id.booknow);
            TextView TextView = (TextView) view.findViewById(R.id.rent);
            mImageView.setImageResource(images[position]);
            mTextView.setText(names[position]);
            TextView.setText(fare[position]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CarList.this, FinalPage.class);
                    startActivity(intent);
                }
            });
            return view;
        }
    }
}
