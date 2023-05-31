package com.example.codenite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity
{
    MaterialButton choice1abutton;
    MaterialButton choice1bbutton;
    MaterialButton choice2abutton;
    MaterialButton choice2bbutton;
    MaterialButton choice3abutton;
    MaterialButton choice3bbutton;
    MaterialButton choice4abutton;
    MaterialButton choice4bbutton;
    MaterialButton choice5abutton;
    MaterialButton choice5bbutton;
    MaterialButton choicedeathbutton;
    MaterialButton choicevictorybutton;
    MaterialButton choice6abutton;
    MaterialButton choice6bbutton;
    TextView shieldamounttext;
    TextView healthamounttext;
    static TextView deathtext;
    TextView eventtext;
    static TextView populationtext;

    static int shieldamount = 0;
    static int healthamount = 100;
    static int populationamount = 100;
    boolean hasScar = false;
    static boolean gotVictory = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //setting up all the objects
        choice1abutton = findViewById(R.id.choice1a);
        choice1bbutton = findViewById(R.id.choice1b);
        choice2abutton = findViewById(R.id.choice2a);
        choice2bbutton = findViewById(R.id.choice2b);
        choice3abutton = findViewById(R.id.choice3a);
        choice3bbutton = findViewById(R.id.choice3b);
        choice4abutton = findViewById(R.id.choice4a);
        choice4bbutton = findViewById(R.id.choice4b);
        choice5abutton = findViewById(R.id.choice5a);
        choice5bbutton = findViewById(R.id.choice5b);
        choice6abutton = findViewById(R.id.choice6a);
        choice6bbutton = findViewById(R.id.choice6b);
        choicedeathbutton = findViewById(R.id.choicedeath);
        choicevictorybutton = findViewById(R.id.choicevictory);
        deathtext = findViewById(R.id.deathtext);
        eventtext = findViewById(R.id.eventtext);
        shieldamounttext = findViewById(R.id.shieldamounttext);
        healthamounttext = findViewById(R.id.healthamounttext);
        populationtext = findViewById(R.id.populationtext);

        //making the other buttons invisible before the game starts
        choice2abutton.setVisibility(View.INVISIBLE);
        choice2bbutton.setVisibility(View.INVISIBLE);
        choice3abutton.setVisibility(View.INVISIBLE);
        choice3bbutton.setVisibility(View.INVISIBLE);
        choice4abutton.setVisibility(View.INVISIBLE);
        choice4bbutton.setVisibility(View.INVISIBLE);
        choice5abutton.setVisibility(View.INVISIBLE);
        choice5bbutton.setVisibility(View.INVISIBLE);
        choicedeathbutton.setVisibility(View.INVISIBLE);
        choicevictorybutton.setVisibility(View.INVISIBLE);
        choice6abutton.setVisibility(View.INVISIBLE);
        choice6bbutton.setVisibility(View.INVISIBLE);

        //when tilted towers is clicked
        choice1abutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after being clicked
                choice1abutton.setVisibility(View.GONE);
                choice1bbutton.setVisibility(View.GONE);

                //after clicking the button, eventtext is updated to be the new result below
                eventtext.setText("You landed in Tilted Towers and walked into the nearest building. A chest contained 25 shield just for you. From outside the building you see a chest on a hill.\n\n");

                //the new buttons are set to be visible so the user can pick new options depending on the new result
                choice2abutton.setVisibility(View.VISIBLE);
                choice2bbutton.setVisibility(View.VISIBLE);

                //below is the actual effects based on what the person clicked
                shieldamount += 25;
                shieldamounttext.setText(" " + shieldamount);

                //calling to method that uses a loop to show how many people died and what happened to them
                deathtext.setText(deathRandomizer(20));
                populationamount -= 20;
                populationtext.setText(" " + populationamount);
            }//end of method
        });//end of event handler

        //when pleasant park is clicked
        choice1bbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after clicked
                choice1abutton.setVisibility(View.GONE);
                choice1bbutton.setVisibility(View.GONE);

                //set text to new result
                eventtext.setText("You landed in Pleasant Park and looked around for loot, you see a person running for a chest on a hill.");

                //make the new buttons visible
                choice2abutton.setVisibility(View.VISIBLE);
                choice2bbutton.setVisibility(View.VISIBLE);

                //calling to method that uses a loop to show how many people died and what happened to them
                deathtext.setText(deathRandomizer(20));
                populationamount -= 20;
                populationtext.setText(" " + populationamount);
            }//end of method
        });//end of event handler

        //when run for the chest is clicked
        choice2abutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after being clicked
                choice2abutton.setVisibility(View.GONE);
                choice2bbutton.setVisibility(View.GONE);

                //after clicking the button, eventtext is updated to be the new result below
                eventtext.setText("You ran for the chest, however a player spotted you and shot you, you were able to run away with only a few wounds.");

                //the new buttons are set to be visible so the user can pick new options depending on the new result
                choice3abutton.setVisibility(View.VISIBLE);
                choice3bbutton.setVisibility(View.VISIBLE);

                //below is the actual effects based on what the person clicked
                if (shieldamount > 0)
                {
                    shieldamount -= 35;
                }
                else
                {
                    healthamount -= 35;
                }

                if (shieldamount < 0)
                {
                    healthamount += shieldamount;
                    shieldamount = 0;
                }
                shieldamounttext.setText(" " + shieldamount);
                healthamounttext.setText(" " + healthamount);

                //calling to method that uses a loop to show how many people died and what happened to them
                deathtext.setText(deathRandomizer(20));
                populationamount -= 20;
                populationtext.setText(" " + populationamount);
            }//end of method
        });//end of event handler

        //when ignore it is clicked
        choice2bbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after being clicked
                choice2abutton.setVisibility(View.GONE);
                choice2bbutton.setVisibility(View.GONE);

                //after clicking the button, eventtext is updated to be the new result below
                eventtext.setText("You ignored the chest and looked around for an alternative plan.");

                //the new buttons are set to be visible so the user can pick new options depending on the new result
                choice3abutton.setVisibility(View.VISIBLE);
                choice3bbutton.setVisibility(View.VISIBLE);

                //calling to method that uses a loop to show how many people died and what happened to them
                deathtext.setText(deathRandomizer(20));
                populationamount -= 20;
                populationtext.setText(" " + populationamount);
            }//end of method
        });//end of event handler

        //when run for shelter is clicked
        choice3abutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after being clicked
                choice3abutton.setVisibility(View.GONE);
                choice3bbutton.setVisibility(View.GONE);

                //after clicking the button, eventtext is updated to be the new result below
                eventtext.setText("You chose to run for shelter and found a big house in the middle of Loot Lake, you went inside it...");

                //the new buttons are set to be visible so the user can pick new options depending on the new result
                choice4abutton.setVisibility(View.VISIBLE);
                choice4bbutton.setVisibility(View.VISIBLE);

                //calling to method that uses a loop to show how many people died and what happened to them
                deathtext.setText(deathRandomizer(20));
                populationamount -= 20;
                populationtext.setText(" " + populationamount);
            }//end of method
        });//end of event handler

        //when loot the nearest shop is clicked
        choice3bbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after being clicked
                choice3abutton.setVisibility(View.GONE);
                choice3bbutton.setVisibility(View.GONE);

                //after clicking the button, eventtext is updated to be the new result below
                eventtext.setText("In the shop, what was obvious was that there was tons of food everywhere. You heal by 10.");

                //the new buttons are set to be visible so the user can pick new options depending on the new result
                choice4abutton.setVisibility(View.VISIBLE);
                choice4bbutton.setVisibility(View.VISIBLE);

                //below is the actual effects based on what the person clicked
                if (healthamount < 100)
                {
                    healthamount += 10;

                    if (healthamount > 100)
                    {
                        healthamount = 100;
                    }
                    else
                    {
                        healthamounttext.setText(" " + healthamount);
                    }

                    healthamounttext.setText(" " + healthamount);
                }
                else
                {
                    healthamounttext.setText(" " + healthamount);
                }

                //calling to method that uses a loop to show how many people died and what happened to them
                deathtext.setText(deathRandomizer(20));
                populationamount -= 20;
                populationtext.setText(" " + populationamount);
            }//end of method
        });//end of event handler

        //when search downstairs is clicked
        choice4abutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after being clicked
                choice4abutton.setVisibility(View.GONE);
                choice4bbutton.setVisibility(View.GONE);

                //after clicking the button, eventtext is updated to be the new result below
                eventtext.setText("You searched downstairs and found a chest that contained a Scar (a rare gun) and 10 more shield.");

                //the new buttons are set to be visible so the user can pick new options depending on the new result
                choice5abutton.setVisibility(View.VISIBLE);
                choice5bbutton.setVisibility(View.VISIBLE);

                //Effects as a result of the choice

                hasScar = true;

                shieldamount += 10;
                shieldamounttext.setText(" " + shieldamount);

                //calling to method that uses a loop to show how many people died and what happened to them
                deathtext.setText(deathRandomizer(20));
                populationamount -= 20;
                populationtext.setText(" " + populationamount);
            }//end of method
        });//end of event handler

        //when search upstairs is clicked
        choice4bbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after being clicked
                choice4abutton.setVisibility(View.GONE);
                choice4bbutton.setVisibility(View.GONE);

                //after clicking the button, eventtext is updated to be the new result below
                eventtext.setText("You searched upstairs and found a chest, however before you could reach it, the storm caught up with you. You died\n:(");

                //the new buttons are set to be visible so the user can pick new options depending on the new result
                choicedeathbutton.setVisibility(View.VISIBLE);

                //Effects as a result of the choice

                healthamount = 0;
                shieldamount = 0;
                healthamounttext.setText(" " + healthamount);
                shieldamounttext.setText(" " + shieldamount);

                deathtext.setText("");
            }//end of method
        });//end of event handler

        //when run out the building is clicked
        choice5abutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after being clicked
                choice5abutton.setVisibility(View.GONE);
                choice5bbutton.setVisibility(View.GONE);

                //after clicking the button, eventtext is updated to be the new result below
                eventtext.setText("You ran out the building and you are left in a 1v1 with the last person standing a few meters in front of you. You hid behind a bush so that you can have the ambush advantage.");

                //the new buttons are set to be visible so the user can pick new options depending on the new result
                choice6abutton.setVisibility(View.VISIBLE);
                choice6bbutton.setVisibility(View.VISIBLE);

                //calling to method that uses a loop to show how many people died and what happened to them
                deathtext.setText(deathRandomizer(18));
                populationamount -= 18;
                populationtext.setText(" " + populationamount);
            }//end of method
        });//end of event handler

        //when glide out the window is clicked
        choice5bbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after being clicked
                choice5abutton.setVisibility(View.GONE);
                choice5bbutton.setVisibility(View.GONE);

                //after clicking the button, eventtext is updated to be the new result below
                eventtext.setText("You glided out the window, but were clumsy and dropped your Scar. You landed in a bush and spotted the last player not so far away.");

                //the new buttons are set to be visible so the user can pick new options depending on the new result
                choice6abutton.setVisibility(View.VISIBLE);
                choice6bbutton.setVisibility(View.VISIBLE);

                //effects based on the decision
                hasScar = false;

                //calling to method that uses a loop to show how many people died and what happened to them
                deathtext.setText(deathRandomizer(18));
                populationamount -= 18;
                populationtext.setText(" " + populationamount);
            }//end of method
        });//end of event handler

        //when wait for the player to get closer is clicked
        choice6abutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after being clicked
                choice6abutton.setVisibility(View.GONE);
                choice6bbutton.setVisibility(View.GONE);

                //after clicking the button, eventtext is updated to be the new result below
                if (hasScar == false)
                {
                    eventtext.setText("You waited, but the storm caught up and hit you slightly, forcing you out of position. The last player spotted you and started to shoot. Without your Scar you were overpowered and you ended up losing the 1v1.");
                    choicedeathbutton.setVisibility(View.VISIBLE);
                }
                else
                {
                    eventtext.setText("Once the player got close enough, the storm caught up with you, forcing you out the hiding spot. Luckily, you had a Scar, and you quickly used it to shoot off the last player. You emoted on their dead body as you ended up winning the 1v1.");
                    choicevictorybutton.setVisibility(View.VISIBLE);
                    populationamount = 1;
                    populationtext.setText(" " + populationamount);
                }

                deathtext.setText("");
            }//end of method
        });//end of event handler

        //when charge out and shoot is clicked
        choice6bbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setting buttons to go away after being clicked
                choice6abutton.setVisibility(View.GONE);
                choice6bbutton.setVisibility(View.GONE);

                //after clicking the button, eventtext is updated to be the new result below
                if (hasScar == false)
                {
                    eventtext.setText("You charged out and tried to shoot but realized you had no gun. The opposing player immediately shot you down and they emoted on your dead body.");
                    choicedeathbutton.setVisibility(View.VISIBLE);
                }
                else
                {
                    eventtext.setText("You charged out and shot with your super cool Scar, killing the last player. You rejoiced with your Victory Royale as you emoted on their dead body.");
                    choicevictorybutton.setVisibility(View.VISIBLE);
                    populationamount = 1;
                    populationtext.setText(" " + populationamount);
                }

                deathtext.setText("");
            }//end of method
        });//end of event handler

        //when death button is clicked
        choicedeathbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //moves to next screen

                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }//end of method
        });//end event handler

        //when victory button is clicked
        choicevictorybutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //moves to next screen

                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
                gotVictory = true;
            }//end of method
        });//end event handler
    }//end of method

    //method that gives how many people died and what happened to them
    public static String deathRandomizer(int totaldeaths)
    {
        String result = "";

        for (int i = 0; i < 3; i++)
        {
            int deathselector = (int) (Math.random() * 10);
            int numdeaths = (int) (Math.random() * 10);

            if (i < 2)
            {
                if (deathselector < 4)
                {
                    result += (numdeaths + " people were shot.\n");
                    totaldeaths -= numdeaths;

                }
                if (deathselector > 3 && deathselector < 7)
                {
                    result += (numdeaths + " people died from fall damage.\n");
                    totaldeaths -= numdeaths;
                }
                if (deathselector > 6)
                {
                    result += (numdeaths + " people died from the storm.\n");
                    totaldeaths -= numdeaths;
                }
            }

            else if (i == 2)
            {
                numdeaths = totaldeaths;

                if (deathselector < 4)
                {
                    result += (numdeaths + " people were shot.\n");
                    totaldeaths -= numdeaths;

                }
                if (deathselector > 3 && deathselector < 7)
                {
                    result += (numdeaths + " people died from fall damage.\n");
                    totaldeaths -= numdeaths;
                }
                if (deathselector > 6)
                {
                    result += (numdeaths + " people died from the storm.\n");
                    totaldeaths -= numdeaths;
                }
            }
        }
        return result;
    }

    public static boolean getVictoryOrDefeat()
    {
        return gotVictory;
    }//end of method

    public static int getPopulationAmount()
    {
        return populationamount;
    }//end of method

    public static int getHealthAmount()
    {
        return healthamount;
    }//end of method

    public static int getShieldamount()
    {
        return shieldamount;
    }//end of method
}//end of class