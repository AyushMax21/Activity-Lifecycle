package com.eggdevs.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

   TextView tvTimer;
   int seconds = 0;
   boolean running = false;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main2);

      findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            startTimer();
         }
      });

      findViewById(R.id.btnStop).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            stopTimer();
         }
      });

      findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            resetTimer();
         }
      });

      tvTimer = findViewById(R.id.tvTime);

      createTimer();
   }

   private void createTimer() {
      tvTimer.setText(String.valueOf(seconds));
   }

   private void startTimer() {
      running = true;
      seconds++;
      tvTimer.setText(String.valueOf(seconds));
   }

   private void stopTimer() {
      running = false;
      seconds--;
      tvTimer.setText(String.valueOf(seconds));
   }

   private void resetTimer() {
      running = false;
      seconds = 0;
      tvTimer.setText(String.valueOf(seconds));
   }

}