package com.eggdevs.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   Button btnNext;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Log.i("LearningLifecycle", "MainActivity: Inside onCreate.");

      btnNext = findViewById(R.id.btnNext);

      btnNext.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent i = new Intent(MainActivity.this, NextActivity.class);
            startActivity(i);
            finish();
         }
      });
   }

   @Override
   protected void onStart() {
      super.onStart();
      Log.i("LearningLifecycle", "MainActivity: Inside onStart.");
   }

   @Override
   protected void onResume() {
      super.onResume();
      Log.i("LearningLifecycle", "MainActivity: Inside onResume.");
   }

   @Override
   protected void onPause() {
      super.onPause();
      Log.i("LearningLifecycle", "MainActivity: Inside onPause.");
   }

   @Override
   protected void onStop() {
      super.onStop();
      Log.i("LearningLifecycle", "MainActivity: Inside onStop.");
   }

   @Override
   protected void onDestroy() {
      super.onDestroy();
      Log.i("LearningLifecycle", "MainActivity: Inside onDestroy.");
   }

   @Override
   protected void onRestart() {
      super.onRestart();
      Log.i("LearningLifecycle", "MainActivity: Inside onRestart.");
   }
}