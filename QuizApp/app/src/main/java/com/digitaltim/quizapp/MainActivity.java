package com.digitaltim.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        // Get the name text
        EditText nameText = (EditText) findViewById(R.id.name_edit_text);
        String nameString = nameText.getText().toString();

        int finalScore = calculateScore(Q1, Q2, Q3, Q3_4, Q4String);//, Q6, Q7, Q8, Q9, Q10);
        String finalQuizMessage = quizSummary(finalScore, nameString);

        TextView scoreText = (TextView) findViewById(R.id.score);
        scoreText.setText(finalQuizMessage);
        Toast.makeText(this, finalQuizMessage, duration).show();
    }

    /**
     * Calculates the price of the order.
     *
     * @param A1 radio button with single correct answer
     * @param A2 radio button with single correct answer
     * @param A3 checkbox with two correct answers
     * @param A3_4 checkbox with two correct answers
     * @param A4 string answer
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
        if (A3 && A3_4) {
            baseScore += 1;
        }
        if (A4.equals("hypotenuse/adjacent")) {
            baseScore +=1;
        }
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
