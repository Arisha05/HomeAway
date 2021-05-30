package com.example.rentchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {

    Button btn_profile,btn_explore,btn_rentReminder,btn_flatmateVacancy,btn_five,btn_six;
    ImageView imageView1 ,imageView2,imageView3,imageView4,imageView5,imageView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btn_profile=(Button) findViewById(R.id.buttonProfile);
        btn_explore=(Button) findViewById(R.id.buttonExplore);
        btn_rentReminder=(Button) findViewById(R.id.buttonRentReminder);
        btn_flatmateVacancy=(Button) findViewById(R.id.buttonFlatmateVacancy);
        btn_five=(Button) findViewById(R.id.buttonFive);
        btn_six=(Button) findViewById(R.id.buttonSix);

        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),UserProfile.class);
                startActivity(intent);
            }
        });

        btn_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),virtualtour.class);
                startActivity(intent);
            }
        });

        btn_rentReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(dashboard.this, "Rent Reminder Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btn_flatmateVacancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(dashboard.this, "Flatmate Vacancy Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });
    }
}
