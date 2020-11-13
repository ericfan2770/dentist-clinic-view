package com.example.dentistclinicview;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private String[] pH;

    public MainActivity() {
        pH = new String[32];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button = (ImageButton) findViewById(R.id.tooth1);
        EditText pHInput = (EditText) findViewById(R.id.editTextpHLevel);
        TextView pHPrompt = (TextView) findViewById(R.id.pHLevelPrompt);

        TextView pHDisplay = (TextView) findViewById(R.id.pHTooth1);
        pHDisplay.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Make the pH input field and prompt visible
                pHInput.setVisibility(View.VISIBLE);
                pHPrompt.setVisibility(View.VISIBLE);
            }
        });

        pHInput.setOnKeyListener(new View.OnKeyListener() {
           public boolean onKey(View v, int keyCode, KeyEvent event) {
               if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                   // Get the pH that the client has entered
                   pH[0] = pHInput.getText().toString();

                   // Display pH that user entered
                   String confirmation = "You entered a pH of " + pH[0] + " for tooth 1";
                   showToast(confirmation);

                   // Make the pH input field and prompt invisible
                   pHInput.setVisibility(View.INVISIBLE);
                   pHPrompt.setVisibility(View.INVISIBLE);

                   pHDisplay(pHDisplay, pH[0]);

                   return true;
               }
               return false;
           }
        });


    }

    private void pHDisplay(TextView phDisplay, String pH) {
        phDisplay.setText(pH);
        phDisplay.setVisibility(View.VISIBLE);
    }

    private void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
