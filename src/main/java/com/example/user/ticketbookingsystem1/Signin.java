package com.example.user.ticketbookingsystem1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    private Ticket3 ticket3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        e1=(EditText)findViewById(R.id.editText4);
        e2=(EditText)findViewById(R.id.editText5);
        b1=(Button)findViewById(R.id.button4);
        ticket3=new  com.example.user.ticketbookingsystem1.Ticket3(this);
        ticket3=ticket3.open();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=e1.getText().toString();
                String password=e2.getText().toString();
                String storedPassword=ticket3.getSinlgeEntry(userName);
                if(password.equals(storedPassword)) {
                    Toast.makeText(Signin.this,"Login Successfull",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(Signin.this,Ticketbooking.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Signin.this,"use Name or Password does not match",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
