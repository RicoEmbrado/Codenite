package com.example.codenite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.Locale;

public class MainActivity3 extends AppCompatActivity
{
    TextView resulttext;
    TextView rateheretext;
    TextView endresultratingtext;
    MaterialButton submitbutton;

    int healthandshieldamount = MainActivity2.getHealthAmount() + MainActivity2.getShieldamount();
    String determinedrating;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //setting up the objects
        resulttext = findViewById(R.id.resulttext);
        endresultratingtext = findViewById(R.id.endresultrating);
        rateheretext = findViewById(R.id.rateheretext);
        submitbutton = findViewById(R.id.submitbutton);

        //When the user moves onto this screen
        if (MainActivity2.getVictoryOrDefeat() == true)
        {
            resulttext.setText(MainActivity.getUsername().toUpperCase(Locale.ROOT) + " GOT A VICTORY ROYALE!");
        }
        else
        {
            resulttext.setText(MainActivity.getUsername().toUpperCase(Locale.ROOT) + " PLACED #" + MainActivity2.getPopulationAmount() + "!");
        }

        //when submit button is clicked
        submitbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (healthandshieldamount == 135)
                {
                    determinedrating = "5";
                }
                else if (healthandshieldamount < 135 && healthandshieldamount > 100)
                {
                    determinedrating = "4";
                }
                else if (healthandshieldamount < 101 && healthandshieldamount > 90)
                {
                    determinedrating = "3";
                }
                else if (healthandshieldamount < 91 && healthandshieldamount > 75)
                {
                    determinedrating = "2";
                }
                else
                {
                    determinedrating = "1";
                }

                if (rateheretext.getText().toString().equals(determinedrating))
                {
                    endresultratingtext.setText("You rated yourself: " + rateheretext.getText() + ". Great Guess! We also rated you a " + determinedrating + "!");
                }
                else
                {
                    endresultratingtext.setText("You rated yourself: " + rateheretext.getText() + ". Nice try, but we actually rated you a " + determinedrating + "!");
                }
            }//end of method
        });//end event handler
    }//end of method
}//end of clas