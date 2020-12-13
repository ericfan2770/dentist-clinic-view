package com.example.dentistclinicview;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final int NUM_TEETH = 32;

    private final int[] toothNum;
    private final int[] teethPh;
    private final int[] teethId;  // the tooth buttons
    private final int[] t_Id;  // the tooth background
    private final int[] phInput;
    private final int[] phId;
    private boolean showingInput;
    private int currToothId;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button radioSubmit;

    public MainActivity() {
        toothNum = new int[NUM_TEETH];
        teethPh = new int[NUM_TEETH];
        teethId = new int[NUM_TEETH];
        phInput = new int[NUM_TEETH];
        phId = new int[NUM_TEETH];
        t_Id = new int[NUM_TEETH];

        toothNum[0] = R.id.toothNumber1;
        teethId[0] = R.id.tooth1;
        phInput[0] = R.id.pHInputTooth1;
        phId[0] = R.id.pHTooth1;
        t_Id[0] = R.id.t_1;

        toothNum[1] = R.id.toothNumber2;
        teethId[1] = R.id.tooth2;
        phInput[1] = R.id.pHInputTooth2;
        phId[1] = R.id.pHTooth2;
        t_Id[1] = R.id.t_2;

        toothNum[2] = R.id.toothNumber3;
        teethId[2] = R.id.tooth3;
        phInput[2] = R.id.pHInputTooth3;
        phId[2] = R.id.pHTooth3;
        t_Id[2] = R.id.t_3;

        toothNum[3] = R.id.toothNumber4;
        teethId[3] = R.id.tooth4;
        phInput[3] = R.id.pHInputTooth4;
        phId[3] = R.id.pHTooth4;
        t_Id[3] = R.id.t_4;

        toothNum[4] = R.id.toothNumber5;
        teethId[4] = R.id.tooth5;
        phInput[4] = R.id.pHInputTooth5;
        phId[4] = R.id.pHTooth5;
        t_Id[4] = R.id.t_5;

        toothNum[5] = R.id.toothNumber6;
        teethId[5] = R.id.tooth6;
        phInput[5] = R.id.pHInputTooth6;
        phId[5] = R.id.pHTooth6;
        t_Id[5] = R.id.t_6;

        toothNum[6] = R.id.toothNumber7;
        teethId[6] = R.id.tooth7;
        phInput[6] = R.id.pHInputTooth7;
        phId[6] = R.id.pHTooth7;
        t_Id[6] = R.id.t_7;

        toothNum[7] = R.id.toothNumber8;
        teethId[7] = R.id.tooth8;
        phInput[7] = R.id.pHInputTooth8;
        phId[7] = R.id.pHTooth8;
        t_Id[7] = R.id.t_8;

        toothNum[8] = R.id.toothNumber9;
        teethId[8] = R.id.tooth9;
        phInput[8] = R.id.pHInputTooth9;
        phId[8] = R.id.pHTooth9;
        t_Id[8] = R.id.t_9;

        toothNum[9] = R.id.toothNumber10;
        teethId[9] = R.id.tooth10;
        phInput[9] = R.id.pHInputTooth10;
        phId[9] = R.id.pHTooth10;
        t_Id[9] = R.id.t_10;

        toothNum[10] = R.id.toothNumber11;
        teethId[10] = R.id.tooth11;
        phInput[10] = R.id.pHInputTooth11;
        phId[10] = R.id.pHTooth11;
        t_Id[10] = R.id.t_11;

        toothNum[11] = R.id.toothNumber12;
        teethId[11] = R.id.tooth12;
        phInput[11] = R.id.pHInputTooth12;
        phId[11] = R.id.pHTooth12;
        t_Id[11] = R.id.t_12;

        toothNum[12] = R.id.toothNumber13;
        teethId[12] = R.id.tooth13;
        phInput[12] = R.id.pHInputTooth13;
        phId[12] = R.id.pHTooth13;
        t_Id[12] = R.id.t_13;

        toothNum[13] = R.id.toothNumber14;
        teethId[13] = R.id.tooth14;
        phInput[13] = R.id.pHInputTooth14;
        phId[13] = R.id.pHTooth14;
        t_Id[13] = R.id.t_14;

        toothNum[14] = R.id.toothNumber15;
        teethId[14] = R.id.tooth15;
        phInput[14] = R.id.pHInputTooth15;
        phId[14] = R.id.pHTooth15;
        t_Id[14] = R.id.t_15;

        toothNum[15] = R.id.toothNumber16;
        teethId[15] = R.id.tooth16;
        phInput[15] = R.id.pHInputTooth16;
        phId[15] = R.id.pHTooth16;
        t_Id[15] = R.id.t_16;

        toothNum[16] = R.id.toothNumber17;
        teethId[16] = R.id.tooth17;
        phInput[16] = R.id.pHInputTooth17;
        phId[16] = R.id.pHTooth17;
        t_Id[16] = R.id.t_17;

        toothNum[17] = R.id.toothNumber18;
        teethId[17] = R.id.tooth18;
        phInput[17] = R.id.pHInputTooth18;
        phId[17] = R.id.pHTooth18;
        t_Id[17] = R.id.t_18;

        toothNum[18] = R.id.toothNumber19;
        teethId[18] = R.id.tooth19;
        phInput[18] = R.id.pHInputTooth19;
        phId[18] = R.id.pHTooth19;

        toothNum[19] = R.id.toothNumber20;
        teethId[19] = R.id.tooth20;
        phInput[19] = R.id.pHInputTooth20;
        phId[19] = R.id.pHTooth20;
        t_Id[19] = R.id.t_20;

        toothNum[20] = R.id.toothNumber21;
        teethId[20] = R.id.tooth21;
        phInput[20] = R.id.pHInputTooth21;
        phId[20] = R.id.pHTooth21;
        t_Id[20] = R.id.t_21;

        toothNum[21] = R.id.toothNumber22;
        teethId[21] = R.id.tooth22;
        phInput[21] = R.id.pHInputTooth22;
        phId[21] = R.id.pHTooth22;
        t_Id[21] = R.id.t_22;

        toothNum[22] = R.id.toothNumber23;
        teethId[22] = R.id.tooth23;
        phInput[22] = R.id.pHInputTooth23;
        phId[22] = R.id.pHTooth23;
        t_Id[22] = R.id.t_23;

        toothNum[23] = R.id.toothNumber24;
        teethId[23] = R.id.tooth24;
        phInput[23] = R.id.pHInputTooth24;
        phId[23] = R.id.pHTooth24;
        t_Id[23] = R.id.t_24;

        toothNum[24] = R.id.toothNumber25;
        teethId[24] = R.id.tooth25;
        phInput[24] = R.id.pHInputTooth25;
        phId[24] = R.id.pHTooth25;
        t_Id[24] = R.id.t_25;

        toothNum[25] = R.id.toothNumber26;
        teethId[25] = R.id.tooth26;
        phInput[25] = R.id.pHInputTooth26;
        phId[25] = R.id.pHTooth26;
        t_Id[25] = R.id.t_26;

        toothNum[26] = R.id.toothNumber27;
        teethId[26] = R.id.tooth27;
        phInput[26] = R.id.pHInputTooth27;
        phId[26] = R.id.pHTooth27;
        t_Id[26] = R.id.t_27;

        toothNum[27] = R.id.toothNumber28;
        teethId[27] = R.id.tooth28;
        phInput[27] = R.id.pHInputTooth28;
        phId[27] = R.id.pHTooth28;
        t_Id[27] = R.id.t_28;

        toothNum[28] = R.id.toothNumber29;
        teethId[28] = R.id.tooth29;
        phInput[28] = R.id.pHInputTooth29;
        phId[28] = R.id.pHTooth29;
        t_Id[28] = R.id.t_29;

        toothNum[29] = R.id.toothNumber30;
        teethId[29] = R.id.tooth30;
        phInput[29] = R.id.pHInputTooth30;
        phId[29] = R.id.pHTooth30;
        t_Id[29] = R.id.t_30;

        toothNum[30] = R.id.toothNumber31;
        teethId[30] = R.id.tooth31;
        phInput[30] = R.id.pHInputTooth31;
        phId[30] = R.id.pHTooth31;
        t_Id[30] = R.id.t_31;

        toothNum[31] = R.id.toothNumber32;
        teethId[31] = R.id.tooth32;
        phInput[31] = R.id.pHInputTooth32;
        phId[31] = R.id.pHTooth32;
        t_Id[31] = R.id.t_32;

        showingInput = false;
        currToothId = -1;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < NUM_TEETH; i++) {
            handleTooth(i, toothNum[i], teethId[i], phInput[i], phId[i], t_Id[i]);
        }

        TextView frontBackTextView = findViewById(R.id.frontBackTextView);
        radioGroup = (RadioGroup) findViewById(R.id.radioView);
        radioSubmit = (Button) findViewById(R.id.frontBackButton);
        radioSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                if (radioButton.equals(findViewById(R.id.radioFront))) {
                    // The front radio button is selected
                    frontBackTextView.setText("Front View");
                } else {
                    // The back radio button is selected
                    frontBackTextView.setText("Back View");
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void handleTooth(int tooth, int toothNum, int toothId, int inputId, int phId, int t_id) {
        // Button for tooth1
        ImageButton button = findViewById(toothId);
        ImageView frontView = findViewById(t_id);

        Context contextInstance = getApplicationContext();

        // Input text box for tooth
        EditText phInput = findViewById(inputId);

        // pH display for tooth
        TextView phDisplay = findViewById(phId);
        phDisplay.setVisibility(View.INVISIBLE);

        // Tooth number display for tooth
        TextView toothNumDisplay = findViewById(toothNum);

        // Desired action to be performed when the tooth button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!showingInput) {
                    // Make the pH input field visible
                    phInput.setVisibility(View.VISIBLE);

                    // Make the pH of the tooth, if already there, invisible (because we are about
                    // to change the pH)
                    phDisplay.setVisibility(View.INVISIBLE);

                    // Indicate that we are currently waiting for input
                    showingInput = true;

                    currToothId = toothId;
                } else {
                    if (currToothId == toothId) {
                        // Make the pH input field invisible
                        phInput.setVisibility(View.INVISIBLE);

                        // Make the pH of the tooth, visible
                        phDisplay.setVisibility(View.VISIBLE);

                        // Drop the keyboard out of sight
                        closeKeyboard();

                        // Indicate that we are no longer waiting for input
                        showingInput = false;
                    }
                }
            }
        });

        // Handle the case when the button is long-clicked
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Are you sure you want to delete tooth " + (tooth + 1)+ "?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                frontView.setVisibility(View.INVISIBLE);
                                button.setVisibility(View.INVISIBLE);
                                phDisplay.setVisibility(View.INVISIBLE);
                                phInput.setVisibility(View.INVISIBLE);

                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

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
                        teethPh[tooth] = Integer.parseInt(phInput.getText().toString());
                    } catch (NumberFormatException exception) {
                        showToast("Please enter a number between 1 to 14");
                        ok = false;
                    }

                    if (!validPh(teethPh[tooth])) {
                        showToast("Please enter a number between 1 to 14");
                        ok = false;
                    }
                    if (ok) {
                        // Indicate that we are no longer waiting for user input
                        showingInput = false;

                        setToothColor(button, contextInstance, teethPh[tooth]);

                        // Display pH that user entered
                        String confirmation = "You entered a pH of " + teethPh[tooth] + " for tooth " + (tooth + 1);
                        showToast(confirmation);

                        // Make the pH input field invisible
                        phInput.setVisibility(View.INVISIBLE);
                        pHDisplay(phDisplay, teethPh[tooth]);

                        // Drop the keyboard out of sight
                        closeKeyboard();
                        return true;
                    }
                }
                return false;
            }
        });

        // Display the tooth and the pH once the tooth number is clicked
        toothNumDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.VISIBLE);
                phDisplay.setVisibility(View.VISIBLE);
                frontView.setVisibility(View.VISIBLE);
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

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void showToast(String text) {
        //Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView textView = (TextView) layout.findViewById(R.id.text);
        textView.setText(text);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP, 0, 865);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public boolean validPh(int ph) {
        return ph >= 1 && ph <= 14;
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
