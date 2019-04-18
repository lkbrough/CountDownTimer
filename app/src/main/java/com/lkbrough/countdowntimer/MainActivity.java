package com.lkbrough.countdowntimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {
    CountDownTimer timer;
    int pausedTime = 0;
    TextView timerDisplay;
    ProgressBar progress;
    int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerDisplay = (TextView) findViewById(R.id.timeDisplay);
        progress = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void startTimer(View view) {
        EditText userInputField = (EditText) findViewById(R.id.timeInput); // Find and save our InputBox/EditText
        String userInput = userInputField.getText().toString(); // Get the String from the EditText
        if (pausedTime != 0){
            time = pausedTime + 1;
            pausedTime = 0;
        }
        else {
            time = Integer.parseInt(userInput) + 1; // Convert our String into an int
        }
        timer = new UpdatingCountDownTimer(time, 1, timerDisplay, progress);
        timer.start();
    }

    public void pauseTimer(View view){
        TextView timerDisplay = (TextView) findViewById(R.id.timeDisplay);
        pausedTime = Integer.parseInt((String) timerDisplay.getText());
        timer.cancel();
    }
}
