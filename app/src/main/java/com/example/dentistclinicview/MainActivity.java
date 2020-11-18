package com.example.dentistclinicview;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private int[] teethPh;

    public MainActivity() {
        teethPh = new int[32];
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handleTooth();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void handleTooth() {
        // Button for tooth1
        ImageButton button = (ImageButton) findViewById(R.id.tooth1);
        Context contextInstance = getApplicationContext();

        // Input text box for tooth1
        EditText phInput = (EditText) findViewById(R.id.editTextpHLevel);

        // Text display for tooth 1
        TextView phDisplay = (TextView) findViewById(R.id.pHTooth1);
        phDisplay.setVisibility(View.INVISIBLE);

        // Desired action to be performed when the tooth button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Make the pH input field visible
                phInput.setVisibility(View.VISIBLE);

                // Make the pH of the tooth, if already there, invisible (because we are about
                // to change the pH)
                phDisplay.setVisibility(View.INVISIBLE);
            }
        });

        // Handle the case when the button is long-clicked
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                button.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        // Desired action to be performed when the enter button is clicked
        phInput.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                boolean ok = true;
                // If the user has clicked enter
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    // Get the pH that the client has entered
                    try {
                        teethPh[0] = Integer.parseInt(phInput.getText().toString());
                    } catch (NumberFormatException exception) {
                        showToast("Please enter a number between 1 to 14");
                        ok = false;
                    }

                    if (!validPh(teethPh[0])) {
                        showToast("Please enter a number between 1 to 14");
                        ok = false;
                    }
                    if (ok) {
                        setToothColor(button, contextInstance, teethPh[0]);

                        // Display pH that user entered
                        String confirmation = "You entered a pH of " + teethPh[0] + " for tooth 1";
                        showToast(confirmation);

                        // Make the pH input field invisible
                        phInput.setVisibility(View.INVISIBLE);
                        pHDisplay(phDisplay, teethPh[0]);

                        // Drop the keyboard out of sight
                        closeKeyboard();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void pHDisplay(TextView phDisplay, int pH) {
        phDisplay.setText("" + pH);
        phDisplay.setVisibility(View.VISIBLE);
    }

    public void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    public boolean validPh(int ph) {
        if (ph < 1 || ph > 14) {
            return false;
        }
        return true;
    }

    // Set the button color depending on what pH the user has entered for a specific tooth
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setToothColor(ImageButton button, Context contextInstance, int ph) {
        if (ph == 1) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.red));
        } else if (ph == 2) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.pink));
        } else if (ph == 3) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.orange));
        } else if (ph == 4) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.beige));
        } else if (ph == 5) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.yellow));
        } else if (ph == 6) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.limegreen));
        } else if (ph == 7) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.green));
        } else if (ph == 8) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.darkgreen));
        } else if (ph == 9) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.turquoise));
        } else if (ph == 10) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.paleblue));
        } else if (ph == 11) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.blue));
        } else if (ph == 12) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.darkblue));
        } else if (ph == 13) {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.violet));
        } else {
            button.setImageTintList(contextInstance.getResources().getColorStateList(R.color.purple));
        }
    }
}
