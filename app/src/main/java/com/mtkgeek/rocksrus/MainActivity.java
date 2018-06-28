package com.mtkgeek.rocksrus;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.mtkgeek.rocksrus.R.string.radio1a;

public class MainActivity extends AppCompatActivity {

    //create a variable to store the score
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //this method is called when the submit button is clicked
    public void submit(View view) {

        //checks if the second radio button was clicked
        RadioButton radio1b = (RadioButton) findViewById(R.id.radio_button1b);
        boolean secondRadioButton = radio1b.isChecked();

        //checks if the seventh radio button was clicked
        RadioButton radio2c = (RadioButton) findViewById(R.id.radio_button2c);
        boolean seventhRadioButton = radio2c.isChecked();

        //checks if the ninth radio button was clicked
        RadioButton radio3a = (RadioButton) findViewById(R.id.radio_button3a);
        boolean ninthRadioButton = radio3a.isChecked();

        // Figure out if the first checkbox was selected
        CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        boolean firstCheckBox = checkbox1.isChecked();

        // Figure out if the second checkbox was selectef
        CheckBox checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        boolean secondCheckBox = checkbox2.isChecked();

        // Figure out if the third checkbox was selectef
        CheckBox checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
        boolean thirdCheckBox = checkbox3.isChecked();

        int finalScore = calculateScore(secondRadioButton, seventhRadioButton, ninthRadioButton, firstCheckBox, secondCheckBox, thirdCheckBox);

        //toast message to show final score
        Toast.makeText(this, getString(R.string.toast_message1) + " " + finalScore + " " + getString(R.string.toast_message2), Toast.LENGTH_SHORT).show();

        //display score in a text field

        displayScore(finalScore);

        score = 0;


    }

    //this method is called when the reset button is clicked
    public void reset(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private int calculateScore(boolean secondRadioButton, boolean seventhRadioButton, boolean ninthRadioButton, boolean firstCheckBox, boolean secondCheckBox, boolean thirdCheckBox) {
        //check if the right answer was picked and add one for every correctly answered question
        if (secondRadioButton) {
            score = score + 1;
        }

        if (seventhRadioButton) {
            score = score + 1;
        }

        if (ninthRadioButton) {
            score = score + 1;
        }

        if (firstCheckBox && secondCheckBox && thirdCheckBox) {
            score = score + 1;

        }

        // Get user's name
        EditText answer = (EditText) findViewById(R.id.input_answer);
        Editable nameEditable = answer.getText();
        String name = nameEditable.toString();

        if (name.equalsIgnoreCase("james hutton")) {
            score = score + 1;
        }

        return score;
    }

    private void displayScore(int score) {
        TextView scoreTextView = (TextView) findViewById(
                R.id.score_display);
        scoreTextView.setText(getString(R.string.display_part1) + " " + score);
        scoreTextView.setBackgroundColor(Color.parseColor("#8fffffff"));
    }

}
