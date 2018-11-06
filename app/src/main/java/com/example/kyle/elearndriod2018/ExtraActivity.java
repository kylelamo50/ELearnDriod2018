package com.example.kyle.elearndriod2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ExtraActivity extends AppCompatActivity {
    ImageView image;
    private Button button;
    private EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        button=(Button)findViewById(R.id.button17);
        button.setOnClickListener(new Button_Clicker());
        image=(ImageView)findViewById(R.id.imageView3);
        e=(EditText)findViewById(R.id.editText);
    }


    class Button_Clicker implements Button.OnClickListener

    {

        @Override

        public void onClick(View v) {

            if (v == button) {
                if(e.getText().toString().trim().length() > 0) {
                    image.setImageResource(R.drawable.bat);
                }
                else {
                    Toast.makeText(ExtraActivity.this, "Please make a guess ", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
