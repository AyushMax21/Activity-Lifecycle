package com.eggdevs.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

   void createDialog() {
      AlertDialog.Builder exitDialog = new AlertDialog.Builder(MainActivity.this);
      exitDialog.setTitle("Are you sure you want to close this application?");
      exitDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialogInterface, int i) {
            finish();
         }
      });

      exitDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "Negative button pressed.", Toast.LENGTH_SHORT).show();
         }
      });
      exitDialog.setCancelable(false);
      exitDialog.show();
   }

   @Override
   public void onBackPressed() {
      super.onBackPressed();
      Log.i("LearningLifecycle", "MainActivity: Inside onBackPressed.");
      createDialog();
   }

}