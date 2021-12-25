package com.dev_ver.gueessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int rando=0;
    int i=0;
    int count=0;
    String message;

    public void scoreCounter(View view){
        EditText guessnum=(EditText) findViewById(R.id.guessnum);
        String num=guessnum.getText().toString();
        int gues=Integer.parseInt(num);
        if(gues==rando)
                 {
                    if(count<=5) {
                        i++;
                        count=0;
                        message="Oh My God It's Correct.";
                        show();
                    }
                     Random random = new Random();
                     rando=random.nextInt(30);

                 }
        if((gues!=rando)&&(count>=5))
        {
            Random random = new Random();
            rando=random.nextInt(30);
            count=0;
        }
        String rando1=Integer.toString(rando);
        Log.i("Random number",rando1);
        if(gues>rando){
            message="Lower";
            show();
        }
        if(gues<rando){
            message="Higher";
            show();
        }
        count++;
        //if((count%3)==0)
        //{
          //  Random random = new Random();
            //rando =random.nextInt(31);
        //}
        String si=Integer.toString(i);
        ((TextView) findViewById(R.id.score)).setText(si);
    }

    void show()
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random random = new Random();
        rando=random.nextInt(30);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}