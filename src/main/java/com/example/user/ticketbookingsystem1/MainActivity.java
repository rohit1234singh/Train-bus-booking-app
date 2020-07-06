package com.example.user.ticketbookingsystem1;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.sql.SQLException;

import static java.nio.channels.AsynchronousServerSocketChannel.open;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    com.example.user.ticketbookingsystem1.Ticket3 ticket;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ticket=new com.example.user.ticketbookingsystem1.Ticket3(this);

            ticket=  ticket.open();



        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUP = new Intent(getApplicationContext(), Signup.class);
                startActivity(intentSignUP);


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(),Signin.class);
                startActivity(i2);
            }
        });

    }
}



