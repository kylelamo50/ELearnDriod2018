package com.example.kyle.elearndriod2018;

import android.support.v7.app.AppCompatActivity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button b1,b2,e;
    Spinner spinner1;
    private ImageButton imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button13);
        b1.setOnClickListener(new Button_Clicker());

        e=(Button)findViewById(R.id.button18);
        e.setOnClickListener(new Button_Clicker());

        b2=(Button)findViewById(R.id.button14);
        b2.setOnClickListener(new Button_Clicker());
        imgButton=(ImageButton)findViewById(R.id.imageButton);
        imgButton.setOnClickListener(new Button_Clicker());
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    class Button_Clicker implements Button.OnClickListener

    {

        @Override

        public void onClick(View v) {


            if (v == imgButton) {
                Intent intent = new Intent(getApplicationContext(), quizActivity.class);

                startActivity(intent);
            }

            if(v==b1){
                Intent intent2 = new Intent(getApplicationContext(), Paper1.class);

                startActivity(intent2);

            }
            if(v==b2){
                Intent intent3= new Intent(getApplicationContext(), Paper2.class);

                startActivity(intent3);

            }
            if(v==e){
                Intent intent4= new Intent(getApplicationContext(), ExtraActivity.class);

                startActivity(intent4);

            }

        }
    }

    class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

            if (pos > 0) {
                String a=String.valueOf(spinner1.getSelectedItem());
                Toast.makeText(parent.getContext(), "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();


                if(a.equals("Toast")){
                    Intent intent = new Intent(getApplicationContext(), ToastActivity.class);
                    startActivity(intent);
                 }

                if (a.equals("DatePicker")) {

                    Intent intent2 = new Intent(getApplicationContext(), DatePickerActivity.class);

                    startActivity(intent2);
                }

                if (a.equals("ImageView")) {

                    Intent intent3 = new Intent(getApplicationContext(), ImageViewActivity.class);

                    startActivity(intent3);
                }

                if (a.equals("ListView")) {

                    Intent intent4 = new Intent(getApplicationContext(), ListViewActivity.class);

                    startActivity(intent4);
                }

                if (a.equals("Spinner")) {

                    Intent intent5 = new Intent(getApplicationContext(), SpinnerActivity.class);

                    startActivity(intent5);
                }

                if (a.equals("EditText")) {

                    Intent intent6 = new Intent(getApplicationContext(), EditTextActivity.class);

                    startActivity(intent6);
                }

                if (a.equals("Button")) {

                    Intent intent7 = new Intent(getApplicationContext(), ButtonActivity.class);

                    startActivity(intent7);
                }

                if (a.equals("NumberPicker")) {

                    Intent intent8 = new Intent(getApplicationContext(), NumberPickerActivity.class);

                    startActivity(intent8);
                }

            }
        }


        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
