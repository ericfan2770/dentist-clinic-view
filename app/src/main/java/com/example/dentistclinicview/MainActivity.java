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
    public static final int NUM_TEETH = 32;

    private int[] teethPh;
    private int[] teethId;
    private int[] phInput;
    private int[] phId;

    public MainActivity() {
        teethPh = new int[32];
        teethId = new int[32];
        phInput = new int[32];
        phId = new int[32];

        teethId[0] = R.id.tooth1;
        phInput[0] = R.id.pHInputTooth1;
        phId[0] = R.id.pHTooth1;

        teethId[1] = R.id.tooth2;
        phInput[1] = R.id.pHInputTooth2;
        phId[1] = R.id.pHTooth2;

        teethId[2] = R.id.tooth3;
        phInput[2] = R.id.pHInputTooth3;
        phId[2] = R.id.pHTooth3;

        teethId[3] = R.id.tooth4;
        phInput[3] = R.id.pHInputTooth4;
        phId[3] = R.id.pHTooth4;

        teethId[4] = R.id.tooth5;
        phInput[4] = R.id.pHInputTooth5;
        phId[4] = R.id.pHTooth5;

        teethId[5] = R.id.tooth6;
        phInput[5] = R.id.pHInputTooth6;
        phId[5] = R.id.pHTooth6;

        teethId[6] = R.id.tooth7;
        phInput[6] = R.id.pHInputTooth7;
        phId[6] = R.id.pHTooth7;

        teethId[7] = R.id.tooth8;
        phInput[7] = R.id.pHInputTooth8;
        phId[7] = R.id.pHTooth8;

        teethId[8] = R.id.tooth9;
        phInput[8] = R.id.pHInputTooth9;
        phId[8] = R.id.pHTooth9;

        teethId[9] = R.id.tooth10;
        phInput[9] = R.id.pHInputTooth10;
        phId[9] = R.id.pHTooth10;

        teethId[10] = R.id.tooth11;
        phInput[10] = R.id.pHInputTooth11;
        phId[10] = R.id.pHTooth11;

        teethId[11] = R.id.tooth12;
        phInput[11] = R.id.pHInputTooth12;
        phId[11] = R.id.pHTooth12;

        teethId[12] = R.id.tooth13;
        phInput[12] = R.id.pHInputTooth13;
        phId[12] = R.id.pHTooth13;

        teethId[13] = R.id.tooth14;
        phInput[13] = R.id.pHInputTooth14;
        phId[13] = R.id.pHTooth14;

        teethId[14] = R.id.tooth15;
        phInput[14] = R.id.pHInputTooth15;
        phId[14] = R.id.pHTooth15;

        teethId[15] = R.id.tooth16;
        phInput[15] = R.id.pHInputTooth16;
        phId[15] = R.id.pHTooth16;

        teethId[16] = R.id.tooth17;
        phInput[16] = R.id.pHInputTooth17;
        phId[16] = R.id.pHTooth17;

        teethId[17] = R.id.tooth18;
        phInput[17] = R.id.pHInputTooth18;
        phId[17] = R.id.pHTooth18;

        teethId[18] = R.id.tooth19;
        phInput[18] = R.id.pHInputTooth19;
        phId[18] = R.id.pHTooth19;

        teethId[19] = R.id.tooth20;
        phInput[19] = R.id.pHInputTooth20;
        phId[19] = R.id.pHTooth20;

        teethId[20] = R.id.tooth21;
        phInput[20] = R.id.pHInputTooth21;
        phId[20] = R.id.pHTooth21;

        teethId[21] = R.id.tooth22;
        phInput[21] = R.id.pHInputTooth22;
        phId[21] = R.id.pHTooth22;

        teethId[22] = R.id.tooth23;
        phInput[22] = R.id.pHInputTooth23;
        phId[22] = R.id.pHTooth23;

        teethId[23] = R.id.tooth24;
        phInput[23] = R.id.pHInputTooth24;
        phId[23] = R.id.pHTooth24;

        teethId[24] = R.id.tooth25;
        phInput[24] = R.id.pHInputTooth25;
        phId[24] = R.id.pHTooth25;

        teethId[25] = R.id.tooth26;
        phInput[25] = R.id.pHInputTooth26;
        phId[25] = R.id.pHTooth26;

        teethId[26] = R.id.tooth27;
        phInput[26] = R.id.pHInputTooth27;
        phId[26] = R.id.pHTooth27;

        teethId[27] = R.id.tooth28;
        phInput[27] = R.id.pHInputTooth28;
        phId[27] = R.id.pHTooth28;

        teethId[28] = R.id.tooth29;
        phInput[28] = R.id.pHInputTooth29;
        phId[28] = R.id.pHTooth29;

        teethId[29] = R.id.tooth30;
        phInput[29] = R.id.pHInputTooth30;
        phId[29] = R.id.pHTooth30;

        teethId[30] = R.id.tooth31;
        phInput[30] = R.id.pHInputTooth31;
        phId[30] = R.id.pHTooth31;

        teethId[31] = R.id.tooth32;
        phInput[31] = R.id.pHInputTooth32;
        phId[31] = R.id.pHTooth32;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < NUM_TEETH; i++) {
            handleTooth(i, teethId[i], phInput[i], phId[i]);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void handleTooth(int toothNum, int toothId, int inputId, int phId) {
        // Button for tooth1
        ImageButton button = (ImageButton) findViewById(toothId);
        Context contextInstance = getApplicationContext();

        // Input text box for tooth1
        EditText phInput = (EditText) findViewById(inputId);

        // Text display for tooth 1
        TextView phDisplay = (TextView) findViewById(phId);
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
                phDisplay.setVisibility(View.INVISIBLE);
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
                        teethPh[toothNum] = Integer.parseInt(phInput.getText().toString());
                    } catch (NumberFormatException exception) {
                        showToast("Please enter a number between 1 to 14");
                        ok = false;
                    }

                    if (!validPh(teethPh[toothNum])) {
                        showToast("Please enter a number between 1 to 14");
                        ok = false;
                    }
                    if (ok) {
                        setToothColor(button, contextInstance, teethPh[toothNum]);

                        // Display pH that user entered
                        String confirmation = "You entered a pH of " + teethPh[toothNum] + " for tooth " + (toothNum + 1);
                        showToast(confirmation);

                        // Make the pH input field invisible
                        phInput.setVisibility(View.INVISIBLE);
                        pHDisplay(phDisplay, teethPh[toothNum]);

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
