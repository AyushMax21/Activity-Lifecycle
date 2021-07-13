package com.eggdevs.androidlifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class NextActivity extends AppCompatActivity {

   TextView tvTimer;

//counting total seconds
   int seconds = 0;

//state of the timer
   boolean running = false;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main2);

//if bundle(previous configuration) is not null
//take values from there
//otherwise use default values
      if (savedInstanceState != null) {

//get seconds by passing the unique key in ""
         seconds = savedInstanceState.getInt("seconds");

//get running by passing the unique key in ""
         running = savedInstanceState.getBoolean("running");
      }

//start the timer on start timer button press and set
// running = true
      findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            startTimer();
         }
      });

//stop the timer on stop timer button press and set
// running = false
      findViewById(R.id.btnStop).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            stopTimer();
         }
      });

//reset the timer on reset timer button press and set
// running = false and seconds = 0
      findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            resetTimer();
         }
      });

      tvTimer = findViewById(R.id.tvTime);

//method to create the timer
      createTimer();
   }

   

//method to create the timer that will run in 
//background and it never ends
   private void createTimer() {

//use handler to call a piece of code repeatedly
//after a certain time interval and infinite number
//of times
      Handler timeRepeater = new Handler();

//pass a new runnable/task to handler using
//the post method
      timeRepeater.post(new Runnable() {
         @Override

//this run method will contain the actual code 
//that will run in the background
         public void run() {

//extracting hours, minutes and seconds passed from 
//the seconds counter
            int hours = seconds/3600;
            int minutes = (seconds % 3600) / 60;
            int secs = seconds % 60;

// 00 : 00 : 00

   //type identifiers : %d: integer, %02d: integer upto two digit
   //printf("%d = %d", i, j);
//formatting the string to show timer in the textview
            String time = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, secs);

//set the timer value in textview
            tvTimer.setText(time);

//actual timer code, all the work is happening here only.
//checks if timer running or not to increment
//the seconds counter after 1 second.
            if (running == true) {
               seconds++;
            }

//also important, calling postDelayed method on the same handler 
//variable by passing this for the same runnable and 1000 for
//1 sec.
            timeRepeater.postDelayed(this, 1000);
         }
      });
   }

   private void startTimer() {
      running = true;
   }

   private void stopTimer() {
      running = false;
   }

   private void resetTimer() {
      running = false;
      seconds = 0;
   }

//start the timer on start if something stops the app
   @Override
   protected void onStart() {
      super.onStart();
      running = true;
   }

//stop the timer on stop if something stops the app
   @Override
   protected void onStop() {
      super.onStop();
      running = false;
   }

//save the configuration before the activity is destroyed
//(portait to landscape and vice versa) using 
//onSaveInstantState method
   @Override
   protected void onSaveInstanceState(@NonNull Bundle outState) {
      super.onSaveInstanceState(outState);

//put the values of running and seconds with a unique key that 
//will be used later
      outState.putBoolean("running", running);
      outState.putInt("seconds", seconds);
   }
}