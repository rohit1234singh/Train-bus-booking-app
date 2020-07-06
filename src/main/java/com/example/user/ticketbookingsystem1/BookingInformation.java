package com.example.user.ticketbookingsystem1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class BookingInformation extends AppCompatActivity {
    TextView t1, t2,t3,t4;
   // EditText t3, t4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_booking_information);
        t1 = (TextView) findViewById(R.id.textView12);
        t2 = (TextView) findViewById(R.id.textView13);
        t3 = (TextView) findViewById(R.id.textView14);
        t4 = (TextView) findViewById(R.id.textView15);

        Intent i2 = getIntent();
        Bundle bundle = i2.getExtras();
        String a = bundle.getString("from");
        String b = bundle.getString("to");
        String c = bundle.getString("fare");
        String d = bundle.getString("date");

        t1.setText(a);
        t2.setText(b);
        t3.setText(c);
        t4.setText(d);

    }
}




