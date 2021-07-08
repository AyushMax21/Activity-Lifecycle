package com.eggdevs.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class NextActivity extends AppCompatActivity {
//Shift + Alt + Mouse Click
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main2);
      Log.i("LearningLifecycle", "NextActivity: Inside onCreate.");
   }

   @Override
   protected void onStart() {
      super.onStart();
      Log.i("LearningLifecycle", "NextActivity: Inside onStart.");
   }

   @Override
   protected void onResume() {
      super.onResume();
      Log.i("LearningLifecycle", "NextActivity: Inside onResume.");
   }

   @Override
   protected void onPause() {
      super.onPause();
      Log.i("LearningLifecycle", "NextActivity: Inside onPause.");
   }

   @Override
   protected void onStop() {
      super.onStop();
      Log.i("LearningLifecycle", "NextActivity: Inside onStop.");
   }

   @Override
   protected void onDestroy() {
      super.onDestroy();
      Log.i("LearningLifecycle", "NextActivity: Inside onDestroy.");
   }
}