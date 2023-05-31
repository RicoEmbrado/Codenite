package com.example.codenite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity
{
    private static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up objects
        EditText usernametext = (EditText)findViewById(R.id.usernametext);
        MaterialButton startbutton = (MaterialButton)findViewById(R.id.startbutton);

        //when start button is clicked
        startbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                username = String.valueOf(usernametext.getText());
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }//end of method
        });//end of event handler
    }//end of method

    public static String getUsername()
    {
        return username;
    }//end of method
}//end of class