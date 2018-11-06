package com.example.kyle.elearndriod2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.app.Activity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class quizActivity extends AppCompatActivity {
    private Button home,mit,callback;
    private RadioGroup rg1,rg2,rg3,rg4,rg5;
    private RadioButton rb1,rb2,rb3,rb4,rb5;
    private int quizScore=0;
    private static final String FILE_NAME="high_scores.txt";
    private int count =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        home = (Button) findViewById(R.id.button9);
        home.setOnClickListener(new Button_Clicker());
        callback = (Button) findViewById(R.id.button11);
        callback.setOnClickListener(new Button_Clicker());
        rg1=(RadioGroup)findViewById(R.id.radioGroup1);
        rg2=(RadioGroup)findViewById(R.id.radioGroup2);
        rg3=(RadioGroup)findViewById(R.id.radioGroup3);
        rg4=(RadioGroup)findViewById(R.id.radioGroup4);
        rg5=(RadioGroup)findViewById(R.id.radioGroup5);
        mit = (Button) findViewById(R.id.button10);
        mit.setOnClickListener(new Button_Clicker());




    }

    public void checkButton1(View v) {
        int r1;//,r2,r3,r4,r5;
        r1 = rg1.getCheckedRadioButtonId();
        rb1 = findViewById(r1);
        if(rb1.getText().toString().equals("True")){
            quizScore++;

        }
        Toast.makeText(quizActivity.this, rb1.getText() + " Selected", Toast.LENGTH_SHORT).show();

    }
    public void checkButton2(View v) {
        int r2;
        r2 = rg2.getCheckedRadioButtonId();
        rb2 = findViewById(r2);
        if(rb2.getText().toString().equals("True")){
            quizScore++;

        }
        Toast.makeText(quizActivity.this, rb2.getText() + " Selected", Toast.LENGTH_SHORT).show();

    }
    public void checkButton3(View v) {
        int r3;
        r3 = rg3.getCheckedRadioButtonId();
        rb3= findViewById(r3);
        if(rb3.getText().toString().equals("False")){
            quizScore++;

        }
        Toast.makeText(quizActivity.this, rb3.getText() + " Selected", Toast.LENGTH_SHORT).show();

    }
    public void checkButton4(View v) {
        int r4;
        r4 = rg4.getCheckedRadioButtonId();
        rb4 = findViewById(r4);
        if(rb4.getText().toString().equals("True")){
            quizScore++;

        }
        Toast.makeText(quizActivity.this, rb4.getText() + " Selected", Toast.LENGTH_SHORT).show();

    }
    public void checkButton5(View v) {
        int r5;
        r5 = rg5.getCheckedRadioButtonId();
        rb5 = findViewById(r5);
        if(rb5.getText().toString().equals("False")){
            quizScore++;

        }
        Toast.makeText(quizActivity.this, rb5.getText() + " Selected", Toast.LENGTH_SHORT).show();


    }






    class Button_Clicker implements Button.OnClickListener

    {

        @Override

        public void onClick(View v) {


            if (v == home) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }

            if(v==mit &&  count==1){
                Toast.makeText(quizActivity.this,"Submit clicked",Toast.LENGTH_SHORT).show();
                Toast.makeText(quizActivity.this,"Your Score is " + quizScore,Toast.LENGTH_SHORT).show();
                String q=Integer.toString(quizScore);
                 FileOutputStream fos = null;
                 try{
                     fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
                     fos.write(q.getBytes());

                     Toast.makeText(quizActivity.this,"Your Score is Saved to" + getFilesDir()+ "/"+FILE_NAME,Toast.LENGTH_SHORT).show();
                 }catch (FileNotFoundException e){
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }finally {
                     if(fos!=null){
                         try {
                             fos.close();
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     }
                 }

            }

            if(v==mit &&  count>1){
                Toast.makeText(quizActivity.this,"Submit clicked",Toast.LENGTH_SHORT).show();
                String text="";
                try{
                    FileInputStream i= openFileInput("high_scores.txt");
                    int size=i.available();
                    byte[] buffer= new  byte[size];
                    i.read(buffer);
                    i.close();
                    text=new  String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(quizActivity.this,"Your previous Score fetched from highScore.txt is " + text,Toast.LENGTH_LONG).show();

                Toast.makeText(quizActivity.this,"Your New Score is " + quizScore,Toast.LENGTH_SHORT).show();
                String q=Integer.toString(quizScore);
                FileOutputStream fos = null;
                try{
                    fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
                    fos.write(q.getBytes());

                    Toast.makeText(quizActivity.this,"Your Score is updated and Saved to" + getFilesDir()+ "/"+FILE_NAME,Toast.LENGTH_LONG).show();
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(fos!=null){
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
            if(v==callback){
                Toast.makeText(quizActivity.this,"Going to calculate percentage correct in quiz",Toast.LENGTH_SHORT).show();
                String q=Integer.toString(quizScore);
                Intent intent1 = new Intent(getApplicationContext(), Calulation.class);

                intent1.putExtra("Extra",q);

                startActivityForResult(intent1, 1);

            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Toast.makeText(quizActivity.this,
                        "DATA From Calculation Screen ="+result, Toast.LENGTH_LONG).show();

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

}
