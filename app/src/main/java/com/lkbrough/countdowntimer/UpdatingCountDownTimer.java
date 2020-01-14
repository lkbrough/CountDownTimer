package com.lkbrough.countdowntimer;

import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;

public class UpdatingCountDownTimer extends CountDownTimer {
    TextView timerDisplay; // saving the textview for future usage
    ProgressBar progress; // saving the progress bar for future usage
    int time; // saving the starting time so we can calculate how far we've come through the progress bar

    UpdatingCountDownTimer(long secondsInFuture, long countDownIntervalSeconds, TextView display, ProgressBar progress){
        super(secondsInFuture*1000, countDownIntervalSeconds*1000); // super class uses milliseconds. convert the milliseconds into seconds.
        this.progress = progress; // save the actual progress bar that we'll be using
        this.timerDisplay = display; // save the actual display that we'll be using
        this.time = (int) secondsInFuture; // save the starting time
    }

    @Override
    public void onTick(long millisUntilFinished) { // called every time we pass our countDownInterval
        int progressNum = (int) (millisUntilFinished/1000); // convert the milliseconds into seconds
        if(timerDisplay != null) { timerDisplay.setText(Integer.toString(progressNum)); } // if we've been passed a timerDisplay, set the text of it to the time remaining.
        if(progress != null) { progress.setProgress((progress.getMax() / (time - 1)) * progressNum); } // if we've been passed a progress bar, decrease how far we've gone passed on how much time has passed
    }

    @Override
    public void onFinish() { // called when there's no more time to tick
        if(timerDisplay != null) { timerDisplay.setText("0"); } // if we don't set it to 0 at the end it doesn't actually reach zero. Comes from super class.
        if(progress != null) { progress.setProgress(0); } // ditto
    }
}
