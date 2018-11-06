package com.example.kyle.elearndriod2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ButtonActivity extends AppCompatActivity {
    private android.widget.Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        myButton = (android.widget.Button) findViewById(R.id.button7);
        myButton.setOnClickListener(new Button_Clicker());


    }

    class Button_Clicker implements android.widget.Button.OnClickListener

    {

        @Override

        public void onClick(View v) {


            if (v == myButton) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }
        }
    }
}