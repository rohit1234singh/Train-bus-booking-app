package com.example.user.ticketbookingsystem1;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

 public class Ticketbooking extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
     Button b1, b2;
     Spinner ssource, sdestination;
     String source, destination;
     int cost = 0;
     TextView t1, mdisplaydate;
     DatePickerDialog.OnDateSetListener mdatesetlist;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         requestWindowFeature(Window.FEATURE_NO_TITLE);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
         setContentView(R.layout.activity_ticketbooking);
         b1 = (Button) findViewById(R.id.button5);
         b2 = (Button) findViewById(R.id.button6);

         t1 = (TextView) findViewById(R.id.textView10);
         mdisplaydate = (TextView) findViewById(R.id.textView11);
         mdisplaydate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Calendar cal = Calendar.getInstance();
                 int year = cal.get(Calendar.YEAR);
                 int month = cal.get(Calendar.MONTH);
                 int day = cal.get(Calendar.DAY_OF_MONTH);

                 DatePickerDialog dialog = new DatePickerDialog(Ticketbooking.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mdatesetlist, year, month, day);
                 dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                 dialog.show();
             }
         });
         mdatesetlist = new DatePickerDialog.OnDateSetListener() {
             @Override
             public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                 month = month + 1;
                 String date = dayOfMonth + "/" + month + "/" + year;
                 mdisplaydate.setText(date);

             }
         };
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 // String a = mdisplaydate.getText().toString();

                 // if (a.equals("Click Here")) {
                 //Toast.makeText(Ticketbooking.this, "Please Choose Travel Date", Toast.LENGTH_LONG).show();
                 //} else {
                 Intent i2 = new Intent(Ticketbooking.this, BookingInformation.class);
                 i2.putExtra("from", source);
                 i2.putExtra("to", destination);
                 i2.putExtra("fare", t1.getText().toString());
                 i2.putExtra("date", mdisplaydate.getText().toString());
                 startActivity(i2);

             }


         });
         b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 AlertDialog.Builder alert = new AlertDialog.Builder(Ticketbooking.this);
                 alert.setMessage("Are you Sure?")
                         .setCancelable(false)
                         .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 finish();
                             }
                         })
                         .setNegativeButton("No", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 dialog.cancel();
                             }
                         });
                 AlertDialog dialogg = alert.create();
                 dialogg.show();
             }
         });

         ssource = (Spinner) findViewById(R.id.spinner);
         sdestination = (Spinner) findViewById(R.id.spinner5);

         List<String> locations = new ArrayList<String>();
         locations.add("Hajipur");
         locations.add("Durgapur");
         locations.add("Kolkata");
         locations.add("Guwhati");
         locations.add("Delhi");
         locations.add("Mumbai");

         source = locations.get(0);
         destination = locations.get(0);

         ArrayAdapter<String> adapterSpinnerSource = new ArrayAdapter<String>(Ticketbooking.this, android.R.layout.simple_spinner_dropdown_item, locations);
         ArrayAdapter<String> adapterSpinnerDestination = new ArrayAdapter<String>(Ticketbooking.this, android.R.layout.simple_spinner_dropdown_item, locations);
         ssource.setAdapter(adapterSpinnerSource);

         sdestination.setAdapter(adapterSpinnerDestination);

         ssource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 source = parent.getItemAtPosition(position).toString();
                 calculatecost();


             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });
         sdestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 destination = parent.getItemAtPosition(position).toString();

                 calculatecost();
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });


     }

     public void calculatecost() {
         if ((source.equals("Hajipur") && destination.equals("Durgapur")) || (source.equals("Durgapur") && destination.equals("Hajipur"))) {
             cost = 1000;
         } else if ((source.equals("Hajipur") && destination.equals("Delhi")) || (source.equals("Delhi") && destination.equals("Hajipur"))) {
             cost = 1500;
         } else if ((source.equals("Hajipur") && destination.equals("Mumbai")) || (source.equals("Mumbai") && destination.equals("Hajipur"))) {
             cost = 2000;
         } else if ((source.equals("Hajipur") && destination.equals("Kolkata")) || (source.equals("Kolkata") && destination.equals("Hajipur"))) {
             cost = 3000;
         } else if ((source.equals("Hajipur") && destination.equals("Guwhati")) || (source.equals("Guwhati") && destination.equals("Hajipur"))) {
             cost = 40;
         } else if ((source.equals("Guwhati") && destination.equals("Durgapur")) || (source.equals("Durgapur") && destination.equals("Guwhati"))) {
             cost = 50;
         } else if ((source.equals("Guwhati") && destination.equals("Mumbai")) || (source.equals("Mumbai") && destination.equals("Guwhati"))) {
             cost = 10;
         } else if ((source.equals("Delhi") && destination.equals("Guwhati")) || (source.equals("Guwhati") && destination.equals("Delhi"))) {
             cost = 10;
         } else if ((source.equals("Kolkata") && destination.equals("Guwhati")) || (source.equals("Guwhati") && destination.equals("Kolkata"))) {
             cost = 0;
         } else if ((source.equals("Kolkata") && destination.equals("Guwhati")) || (source.equals("Guwhati") && destination.equals("Kolkata"))) {
             cost = 20;
         } else if ((source.equals("Delhi") && destination.equals("Mumbai")) || (source.equals("Mumbai") && destination.equals("Delhi"))) {
             cost = 3000;
         } else if ((source.equals("Mumbai") && destination.equals("Durgapur")) || (source.equals("Durgapur") && destination.equals("Mumbai"))) {
             cost = 40;
         } else if ((source.equals("Mumbai") && destination.equals("Guwhati")) || (source.equals("Guwhati") && destination.equals("Mumbai"))) {
             cost = 20;
         } else if ((source.equals("Mumbai") && destination.equals("Delhi")) || (source.equals("Delhi") && destination.equals("Mumbai"))) {
             cost = 10;
         } else if ((source.equals("Mumbai") && destination.equals("Guwhati")) || (source.equals("Guwhati") && destination.equals("Mumbai"))) {
             cost = 0;
         } else if ((source.equals("Mumbai") && destination.equals("Kolkata")) || (source.equals("Kolkata") && destination.equals("Mumbai"))) {
             cost = 10;
         } else if ((source.equals("Durgapur") && destination.equals("Kolkata")) || (source.equals("kolkata") && destination.equals("Kolkata"))) {
             cost = 20;
         } else if ((source.equals("Durgapur") && destination.equals("Mumbai")) || (source.equals("Mumbai") && destination.equals("Durgapur"))) {
             cost = 3000;
         } else if ((source.equals("Delhi") && destination.equals("Kolkata")) || (source.equals("Kolkata") && destination.equals("Delhi"))) {
             cost = 3500;
         } else if ((source.equals("Delhi") && destination.equals("Mumbai")) || (source.equals("Mumbai") && destination.equals("Delhi"))) {
             cost = 2000;
         } else if ((source.equals("Delhi") && destination.equals("Hajipur")) || (source.equals("Hajipur") && destination.equals("Delhi"))) {
             cost = 250;
         } else if ((source.equals("Delhi") && destination.equals("Guwhati")) || (source.equals("Guwhati") && destination.equals("Delhi"))) {
             cost = 1600;
         } else if ((source.equals("Delhi") && destination.equals("Durgapur")) || (source.equals("Durgapur") && destination.equals("Delhi"))) {
             cost = 20;
         } else if ((source.equals("Guwhati") && destination.equals("Durgapur")) || (source.equals("Durgapur") && destination.equals("Guwhati"))) {
             cost = 3000;
         } else if ((source.equals("Guwhati") && destination.equals("Durgapur")) || (source.equals("Durgapur") && destination.equals("Guwhati"))) {
             cost = 10;
         } else if ((source.equals("Guwhati") && destination.equals("Mumbai")) || (source.equals("Mumbai") && destination.equals("Guwhati"))) {
             cost = 1600;
         } else if ((source.equals("Guwhati") && destination.equals("Kolkata")) || (source.equals("Kolkata") && destination.equals("Guwhati"))) {
             cost = 1000;
         } else if ((source.equals("Guwhati") && destination.equals("Durgapur")) || (source.equals("Durgapur") && destination.equals("Guwhati"))) {
             cost = 20;
         } else if ((source.equals("Guwhati") && destination.equals("Hajipur")) || (source.equals("Hajipur") && destination.equals("Guwhati"))) {
             cost = 3000;
         }

         t1.setText(String.valueOf(cost));

     }


     @Override
     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

     }

     @Override
     public void onNothingSelected(AdapterView<?> parent) {

     }
 }





            

