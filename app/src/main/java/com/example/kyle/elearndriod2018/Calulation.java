package com.example.kyle.elearndriod2018;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Calulation extends AppCompatActivity {
    private Button Cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calulation);

        Toast.makeText(Calulation.this,"Calculating % of correct answers",Toast.LENGTH_SHORT).show();
        Cal=(Button)findViewById(R.id.button12) ;
        Cal.setOnClickListener(new Button_Clicker());


    }

    class Button_Clicker implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == Cal) {
                Calculations();
                Cal.setText("% calculated");
                Toast.makeText(Calulation.this,"returning result to quiz screen",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    public  void Calculations(){


        String qScore= getIntent().getStringExtra("Extra");
        int score=Integer.parseInt(qScore);
        double dPercent=(score * 100)/(5*1.0);

        String sPercent=Double.toString(dPercent);
        sPercent=sPercent+"%";
        Intent returnIntent = new Intent();

        returnIntent.putExtra("result",sPercent);
        setResult(Activity.RESULT_OK,returnIntent);




    }

}
