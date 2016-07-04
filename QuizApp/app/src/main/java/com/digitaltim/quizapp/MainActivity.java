package com.digitaltim.quizapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;
    int duration = Toast.LENGTH_SHORT;

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitQuiz(View view) {

        // Check if the correct answers were chosen
        RadioButton Q1A1 = (RadioButton) findViewById(R.id.Q1A1_radio_button);
        boolean Q1 = Q1A1.isChecked();
        RadioButton Q2A2 = (RadioButton) findViewById(R.id.Q2A2_radio_button);
        boolean Q2 = Q2A2.isChecked();
        CheckBox Q3A1 =(CheckBox) findViewById(R.id.Q3A1_radio_button);
        boolean Q3 = Q3A1.isChecked();
        CheckBox Q3A4 =(CheckBox) findViewById(R.id.Q3A4_radio_button);
        boolean Q3_4 = Q3A4.isChecked();
        EditText Q4Text = (EditText) findViewById(R.id.Q4_edit_text);
        String Q4String = Q4Text.getText().toString();


//        RadioButton Q3A3 = (RadioButton) findViewById(R.id.Q3A3_radio_button);
//        boolean Q3 = Q1A1.isChecked();
//        RadioButton Q4A4 = (RadioButton) findViewById(R.id.Q4A4_radio_button);
//        boolean Q4 = Q1A1.isChecked();
//        RadioButton Q5A1 = (RadioButton) findViewById(R.id.Q5A1_radio_button);
//        boolean Q5 = Q1A1.isChecked();
//        RadioButton Q6A2 = (RadioButton) findViewById(R.id.Q6A2_radio_button);
//        boolean Q6 = Q1A1.isChecked();
//        RadioButton Q7A3 = (RadioButton) findViewById(R.id.Q7A3_radio_button);
//        boolean Q7 = Q1A1.isChecked();
//        RadioButton Q8A4 = (RadioButton) findViewById(R.id.Q8A4_radio_button);
//        boolean Q8 = Q1A1.isChecked();
//        RadioButton Q9A1 = (RadioButton) findViewById(R.id.Q9A1_radio_button);
//        boolean Q9 = Q1A1.isChecked();
//        RadioButton Q10A2 = (RadioButton) findViewById(R.id.Q10A2_radio_button);
//        boolean Q10 = Q1A1.isChecked();

        // Get the name text
        EditText nameText = (EditText) findViewById(R.id.name_edit_text);
        String nameString = nameText.getText().toString();

        int finalScore = calculateScore(Q1, Q2, Q3, Q3_4, Q4String);//, Q6, Q7, Q8, Q9, Q10);
        String finalQuizMessage = quizSummary(finalScore, nameString);

        TextView scoreText = (TextView) findViewById(R.id.score);
        scoreText.setText(finalQuizMessage);
        Toast.makeText(this, finalQuizMessage, duration).show();

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Quiz score results for " + nameString);
//        intent.putExtra(Intent.EXTRA_TEXT, finalQuizMessage);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }

    /**
     * Calculates the price of the order.
     *
     * @param Q1-Q10 are the radion buttons with the correct answers
     *
     * @return total score as a value of correct answers
     */
    private int calculateScore(boolean A1, boolean A2, boolean A3, boolean A3_4, String A4){//boolean A5, boolean A6, boolean A7, boolean A8, boolean A9, boolean A10) {

        // Score starts at zero correct
        int baseScore = 0;

        // If correct answer was selected add one to baseScore
        if (A1) {
            baseScore += 1;
        }
        if (A2) {
            baseScore += 1;
        }
        if (A3) {
            baseScore += 1;
        } else if (A3_4) {
            baseScore += 1;
        }
        if (A4.equals("hypotenuse/adjacent")) {
            baseScore +=1;
        }

//        if (A5) {
//            baseScore += 1;
//        }
//        if (A6) {
//            baseScore += 1;
//        }
//        if (A7) {
//            baseScore += 1;
//        }
//        if (A8) {
//            baseScore += 1;
//        }
//        if (A9) {
//            baseScore += 1;
//        }
//        if (A10) {
//            baseScore += 1;
//        }
        return (baseScore);
    }

    /**
     * Create order summary
     *
     * @param score from the number of correct in the quiz
     * @param nameText contains the name of the customer
     *
     * @return quizSummary text summary message
     */
    private String quizSummary(int score, String nameText) {
        String quizMessage = "Name: " + nameText;
        quizMessage += "\nYou scored: " + score;
        quizMessage += " out of 4 correct";
        return quizMessage;
    }

}
