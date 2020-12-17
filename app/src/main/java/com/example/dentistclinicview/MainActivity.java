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

    private final int[] teethPh;

    // For front teeth
    private final int[] toothNum;
    private final int[] teethId;  // the tooth buttons
    private final int[] t_Id;  // the tooth background
    private final int[] phInput;
    private final int[] phId;

    // For back teeth
    private final int[] back_toothNum;
    private final int[] back_teethId;  // the tooth buttons
    private final int[] back_t_Id;  // the tooth background
    private final int[] back_phInput;
    private final int[] back_phId;

    private boolean showingInput;
    private int currToothId;

    private boolean[] teethExists;

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
        teethExists = new boolean[NUM_TEETH];

        back_toothNum = new int[NUM_TEETH];
        back_teethId = new int[NUM_TEETH];  // the tooth buttons
        back_t_Id = new int[NUM_TEETH];  // the tooth background
        back_phInput = new int[NUM_TEETH];
        back_phId = new int[NUM_TEETH];

        for (int i = 0; i < NUM_TEETH; i++) {
            teethExists[i] = true;
        }

        // Front tooth logic
        toothNum[0] = R.id.frontToothNumber1;
        teethId[0] = R.id.tooth1;
        phInput[0] = R.id.pHInputTooth1;
        phId[0] = R.id.pHTooth1;
        t_Id[0] = R.id.t_1;

        toothNum[1] = R.id.frontToothNumber2;
        teethId[1] = R.id.tooth2;
        phInput[1] = R.id.pHInputTooth2;
        phId[1] = R.id.pHTooth2;
        t_Id[1] = R.id.t_2;

        toothNum[2] = R.id.frontToothNumber3;
        teethId[2] = R.id.tooth3;
        phInput[2] = R.id.pHInputTooth3;
        phId[2] = R.id.pHTooth3;
        t_Id[2] = R.id.t_3;

        toothNum[3] = R.id.frontToothNumber4;
        teethId[3] = R.id.tooth4;
        phInput[3] = R.id.pHInputTooth4;
        phId[3] = R.id.pHTooth4;
        t_Id[3] = R.id.t_4;

        toothNum[4] = R.id.frontToothNumber5;
        teethId[4] = R.id.tooth5;
        phInput[4] = R.id.pHInputTooth5;
        phId[4] = R.id.pHTooth5;
        t_Id[4] = R.id.t_5;

        toothNum[5] = R.id.frontToothNumber6;
        teethId[5] = R.id.tooth6;
        phInput[5] = R.id.pHInputTooth6;
        phId[5] = R.id.pHTooth6;
        t_Id[5] = R.id.t_6;

        toothNum[6] = R.id.frontToothNumber7;
        teethId[6] = R.id.tooth7;
        phInput[6] = R.id.pHInputTooth7;
        phId[6] = R.id.pHTooth7;
        t_Id[6] = R.id.t_7;

        toothNum[7] = R.id.frontToothNumber8;
        teethId[7] = R.id.tooth8;
        phInput[7] = R.id.pHInputTooth8;
        phId[7] = R.id.pHTooth8;
        t_Id[7] = R.id.t_8;

        toothNum[8] = R.id.frontToothNumber9;
        teethId[8] = R.id.tooth9;
        phInput[8] = R.id.pHInputTooth9;
        phId[8] = R.id.pHTooth9;
        t_Id[8] = R.id.t_9;

        toothNum[9] = R.id.frontToothNumber10;
        teethId[9] = R.id.tooth10;
        phInput[9] = R.id.pHInputTooth10;
        phId[9] = R.id.pHTooth10;
        t_Id[9] = R.id.t_10;

        toothNum[10] = R.id.frontToothNumber11;
        teethId[10] = R.id.tooth11;
        phInput[10] = R.id.pHInputTooth11;
        phId[10] = R.id.pHTooth11;
        t_Id[10] = R.id.t_11;

        toothNum[11] = R.id.frontToothNumber12;
        teethId[11] = R.id.tooth12;
        phInput[11] = R.id.pHInputTooth12;
        phId[11] = R.id.pHTooth12;
        t_Id[11] = R.id.t_12;

        toothNum[12] = R.id.frontToothNumber13;
        teethId[12] = R.id.tooth13;
        phInput[12] = R.id.pHInputTooth13;
        phId[12] = R.id.pHTooth13;
        t_Id[12] = R.id.t_13;

        toothNum[13] = R.id.frontToothNumber14;
        teethId[13] = R.id.tooth14;
        phInput[13] = R.id.pHInputTooth14;
        phId[13] = R.id.pHTooth14;
        t_Id[13] = R.id.t_14;

        toothNum[14] = R.id.frontToothNumber15;
        teethId[14] = R.id.tooth15;
        phInput[14] = R.id.pHInputTooth15;
        phId[14] = R.id.pHTooth15;
        t_Id[14] = R.id.t_15;

        toothNum[15] = R.id.frontToothNumber16;
        teethId[15] = R.id.tooth16;
        phInput[15] = R.id.pHInputTooth16;
        phId[15] = R.id.pHTooth16;
        t_Id[15] = R.id.t_16;

        toothNum[16] = R.id.frontToothNumber17;
        teethId[16] = R.id.tooth17;
        phInput[16] = R.id.pHInputTooth17;
        phId[16] = R.id.pHTooth17;
        t_Id[16] = R.id.t_17;

        toothNum[17] = R.id.frontToothNumber18;
        teethId[17] = R.id.tooth18;
        phInput[17] = R.id.pHInputTooth18;
        phId[17] = R.id.pHTooth18;
        t_Id[17] = R.id.t_18;

        toothNum[18] = R.id.frontToothNumber19;
        teethId[18] = R.id.tooth19;
        phInput[18] = R.id.pHInputTooth19;
        phId[18] = R.id.pHTooth19;
        t_Id[18] = R.id.t_19;

        toothNum[19] = R.id.frontToothNumber20;
        teethId[19] = R.id.tooth20;
        phInput[19] = R.id.pHInputTooth20;
        phId[19] = R.id.pHTooth20;
        t_Id[19] = R.id.t_20;

        toothNum[20] = R.id.frontToothNumber21;
        teethId[20] = R.id.tooth21;
        phInput[20] = R.id.pHInputTooth21;
        phId[20] = R.id.pHTooth21;
        t_Id[20] = R.id.t_21;

        toothNum[21] = R.id.frontToothNumber22;
        teethId[21] = R.id.tooth22;
        phInput[21] = R.id.pHInputTooth22;
        phId[21] = R.id.pHTooth22;
        t_Id[21] = R.id.t_22;

        toothNum[22] = R.id.frontToothNumber23;
        teethId[22] = R.id.tooth23;
        phInput[22] = R.id.pHInputTooth23;
        phId[22] = R.id.pHTooth23;
        t_Id[22] = R.id.t_23;

        toothNum[23] = R.id.frontToothNumber24;
        teethId[23] = R.id.tooth24;
        phInput[23] = R.id.pHInputTooth24;
        phId[23] = R.id.pHTooth24;
        t_Id[23] = R.id.t_24;

        toothNum[24] = R.id.frontToothNumber25;
        teethId[24] = R.id.tooth25;
        phInput[24] = R.id.pHInputTooth25;
        phId[24] = R.id.pHTooth25;
        t_Id[24] = R.id.t_25;

        toothNum[25] = R.id.frontToothNumber26;
        teethId[25] = R.id.tooth26;
        phInput[25] = R.id.pHInputTooth26;
        phId[25] = R.id.pHTooth26;
        t_Id[25] = R.id.t_26;

        toothNum[26] = R.id.frontToothNumber27;
        teethId[26] = R.id.tooth27;
        phInput[26] = R.id.pHInputTooth27;
        phId[26] = R.id.pHTooth27;
        t_Id[26] = R.id.t_27;

        toothNum[27] = R.id.frontToothNumber28;
        teethId[27] = R.id.tooth28;
        phInput[27] = R.id.pHInputTooth28;
        phId[27] = R.id.pHTooth28;
        t_Id[27] = R.id.t_28;

        toothNum[28] = R.id.frontToothNumber29;
        teethId[28] = R.id.tooth29;
        phInput[28] = R.id.pHInputTooth29;
        phId[28] = R.id.pHTooth29;
        t_Id[28] = R.id.t_29;

        toothNum[29] = R.id.frontToothNumber30;
        teethId[29] = R.id.tooth30;
        phInput[29] = R.id.pHInputTooth30;
        phId[29] = R.id.pHTooth30;
        t_Id[29] = R.id.t_30;

        toothNum[30] = R.id.frontToothNumber31;
        teethId[30] = R.id.tooth31;
        phInput[30] = R.id.pHInputTooth31;
        phId[30] = R.id.pHTooth31;
        t_Id[30] = R.id.t_31;

        toothNum[31] = R.id.frontToothNumber32;
        teethId[31] = R.id.tooth32;
        phInput[31] = R.id.pHInputTooth32;
        phId[31] = R.id.pHTooth32;
        t_Id[31] = R.id.t_32;

        // back teeth
        // Back tooth logic
        back_toothNum[0] = R.id.backToothNumber1;
        back_teethId[0] = R.id.tooth_back_1;
        back_phInput[0] = R.id.back_pHInputTooth1;
        back_phId[0] = R.id.back_pHTooth1;
        back_t_Id[0] = R.id.t_back_1;

        back_toothNum[1] = R.id.backToothNumber2;
        back_teethId[1] = R.id.tooth_back_2;
        back_phInput[1] = R.id.back_pHInputTooth2;
        back_phId[1] = R.id.back_pHTooth2;
        back_t_Id[1] = R.id.t_back_2;

        back_toothNum[2] = R.id.backToothNumber3;
        back_teethId[2] = R.id.tooth_back_3;
        back_phInput[2] = R.id.back_pHInputTooth3;
        back_phId[2] = R.id.back_pHTooth3;
        back_t_Id[2] = R.id.t_back_3;

        back_toothNum[3] = R.id.backToothNumber4;
        back_teethId[3] = R.id.tooth_back_4;
        back_phInput[3] = R.id.back_pHInputTooth4;
        back_phId[3] = R.id.back_pHTooth4;
        back_t_Id[3] = R.id.t_back_4;

        back_toothNum[4] = R.id.backToothNumber5;
        back_teethId[4] = R.id.tooth_back_5;
        back_phInput[4] = R.id.back_pHInputTooth5;
        back_phId[4] = R.id.back_pHTooth5;
        back_t_Id[4] = R.id.t_back_5;

        back_toothNum[5] = R.id.backToothNumber6;
        back_teethId[5] = R.id.tooth_back_6;
        back_phInput[5] = R.id.back_pHInputTooth6;
        back_phId[5] = R.id.back_pHTooth6;
        back_t_Id[5] = R.id.t_back_6;

        back_toothNum[6] = R.id.backToothNumber7;
        back_teethId[6] = R.id.tooth_back_7;
        back_phInput[6] = R.id.back_pHInputTooth7;
        back_phId[6] = R.id.back_pHTooth7;
        back_t_Id[6] = R.id.t_back_7;

        back_toothNum[7] = R.id.backToothNumber8;
        back_teethId[7] = R.id.tooth_back_8;
        back_phInput[7] = R.id.back_pHInputTooth8;
        back_phId[7] = R.id.back_pHTooth8;
        back_t_Id[7] = R.id.t_back_8;

        back_toothNum[8] = R.id.backToothNumber9;
        back_teethId[8] = R.id.tooth_back_9;
        back_phInput[8] = R.id.back_pHInputTooth9;
        back_phId[8] = R.id.back_pHTooth9;
        back_t_Id[8] = R.id.t_back_9;

        back_toothNum[9] = R.id.backToothNumber10;
        back_teethId[9] = R.id.tooth_back_10;
        back_phInput[9] = R.id.back_pHInputTooth10;
        back_phId[9] = R.id.back_pHTooth10;
        back_t_Id[9] = R.id.t_back_10;

        back_toothNum[10] = R.id.backToothNumber11;
        back_teethId[10] = R.id.tooth_back_11;
        back_phInput[10] = R.id.back_pHInputTooth11;
        back_phId[10] = R.id.back_pHTooth11;
        back_t_Id[10] = R.id.t_back_11;

        back_toothNum[11] = R.id.backToothNumber12;
        back_teethId[11] = R.id.tooth_back_12;
        back_phInput[11] = R.id.back_pHInputTooth12;
        back_phId[11] = R.id.back_pHTooth12;
        back_t_Id[11] = R.id.t_back_12;

        back_toothNum[12] = R.id.backToothNumber13;
        back_teethId[12] = R.id.tooth_back_13;
        back_phInput[12] = R.id.back_pHInputTooth13;
        back_phId[12] = R.id.back_pHTooth13;
        back_t_Id[12] = R.id.t_back_13;

        back_toothNum[13] = R.id.backToothNumber14;
        back_teethId[13] = R.id.tooth_back_14;
        back_phInput[13] = R.id.back_pHInputTooth14;
        back_phId[13] = R.id.back_pHTooth14;
        back_t_Id[13] = R.id.t_back_14;

        back_toothNum[14] = R.id.backToothNumber15;
        back_teethId[14] = R.id.tooth_back_15;
        back_phInput[14] = R.id.back_pHInputTooth15;
        back_phId[14] = R.id.back_pHTooth15;
        back_t_Id[14] = R.id.t_back_15;

        back_toothNum[15] = R.id.backToothNumber16;
        back_teethId[15] = R.id.tooth_back_16;
        back_phInput[15] = R.id.back_pHInputTooth16;
        back_phId[15] = R.id.back_pHTooth16;
        back_t_Id[15] = R.id.t_back_16;

        back_toothNum[16] = R.id.backToothNumber17;
        back_teethId[16] = R.id.tooth_back_17;
        back_phInput[16] = R.id.back_pHInputTooth17;
        back_phId[16] = R.id.back_pHTooth17;
        back_t_Id[16] = R.id.t_back_17;

        back_toothNum[17] = R.id.backToothNumber18;
        back_teethId[17] = R.id.tooth_back_18;
        back_phInput[17] = R.id.back_pHInputTooth18;
        back_phId[17] = R.id.back_pHTooth18;
        back_t_Id[17] = R.id.t_back_18;

        back_toothNum[18] = R.id.backToothNumber19;
        back_teethId[18] = R.id.tooth_back_19;
        back_phInput[18] = R.id.back_pHInputTooth19;
        back_phId[18] = R.id.back_pHTooth19;
        back_t_Id[18] = R.id.t_back_19;

        back_toothNum[19] = R.id.backToothNumber20;
        back_teethId[19] = R.id.tooth_back_20;
        back_phInput[19] = R.id.back_pHInputTooth20;
        back_phId[19] = R.id.back_pHTooth20;
        back_t_Id[19] = R.id.t_back_20;

        back_toothNum[20] = R.id.backToothNumber21;
        back_teethId[20] = R.id.tooth_back_21;
        back_phInput[20] = R.id.back_pHInputTooth21;
        back_phId[20] = R.id.back_pHTooth21;
        back_t_Id[20] = R.id.t_back_21;

        back_toothNum[21] = R.id.backToothNumber22;
        back_teethId[21] = R.id.tooth_back_22;
        back_phInput[21] = R.id.back_pHInputTooth22;
        back_phId[21] = R.id.back_pHTooth22;
        back_t_Id[21] = R.id.t_back_22;

        back_toothNum[22] = R.id.backToothNumber23;
        back_teethId[22] = R.id.tooth_back_23;
        back_phInput[22] = R.id.back_pHInputTooth23;
        back_phId[22] = R.id.back_pHTooth23;
        back_t_Id[22] = R.id.t_back_23;

        back_toothNum[23] = R.id.backToothNumber24;
        back_teethId[23] = R.id.tooth_back_24;
        back_phInput[23] = R.id.back_pHInputTooth24;
        back_phId[23] = R.id.back_pHTooth24;
        back_t_Id[23] = R.id.t_back_24;

        back_toothNum[24] = R.id.backToothNumber25;
        back_teethId[24] = R.id.tooth_back_25;
        back_phInput[24] = R.id.back_pHInputTooth25;
        back_phId[24] = R.id.back_pHTooth25;
        back_t_Id[24] = R.id.t_back_25;

        back_toothNum[25] = R.id.backToothNumber26;
        back_teethId[25] = R.id.tooth_back_26;
        back_phInput[25] = R.id.back_pHInputTooth26;
        back_phId[25] = R.id.back_pHTooth26;
        back_t_Id[25] = R.id.t_back_26;

        back_toothNum[26] = R.id.backToothNumber27;
        back_teethId[26] = R.id.tooth_back_27;
        back_phInput[26] = R.id.back_pHInputTooth27;
        back_phId[26] = R.id.back_pHTooth27;
        back_t_Id[26] = R.id.t_back_27;

        back_toothNum[27] = R.id.backToothNumber28;
        back_teethId[27] = R.id.tooth_back_28;
        back_phInput[27] = R.id.back_pHInputTooth28;
        back_phId[27] = R.id.back_pHTooth28;
        back_t_Id[27] = R.id.t_back_28;

        back_toothNum[28] = R.id.backToothNumber29;
        back_teethId[28] = R.id.tooth_back_29;
        back_phInput[28] = R.id.back_pHInputTooth29;
        back_phId[28] = R.id.back_pHTooth29;
        back_t_Id[28] = R.id.t_back_29;

        back_toothNum[29] = R.id.backToothNumber30;
        back_teethId[29] = R.id.tooth_back_30;
        back_phInput[29] = R.id.back_pHInputTooth30;
        back_phId[29] = R.id.back_pHTooth30;
        back_t_Id[29] = R.id.t_back_30;

        back_toothNum[30] = R.id.backToothNumber31;
        back_teethId[30] = R.id.tooth_back_31;
        back_phInput[30] = R.id.back_pHInputTooth31;
        back_phId[30] = R.id.back_pHTooth31;
        back_t_Id[30] = R.id.t_back_31;

        back_toothNum[31] = R.id.backToothNumber32;
        back_teethId[31] = R.id.tooth_back_32;
        back_phInput[31] = R.id.back_pHInputTooth32;
        back_phId[31] = R.id.back_pHTooth32;
        back_t_Id[31] = R.id.t_back_32;

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
            handleTooth(i, back_toothNum[i], back_teethId[i], back_phInput[i], back_phId[i], back_t_Id[i]);
        }

        TextView frontBackTextView = findViewById(R.id.frontBackTextView);
        radioGroup = (RadioGroup) findViewById(R.id.radioView);
        radioSubmit = (Button) findViewById(R.id.frontBackButton);
        radioSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < NUM_TEETH; i++) {
                    EditText phInputFront = findViewById(phInput[i]);
                    EditText phInputBack = findViewById(back_phInput[i]);
                    phInputFront.setVisibility(View.INVISIBLE);
                    phInputBack.setVisibility(View.INVISIBLE);
                    showingInput = false;
                }
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                if (radioButton.equals(findViewById(R.id.radioFront))) {
                    // The front radio button is selected
                    frontBackTextView.setText("Front View");
                    // make all the front tooth logic show up
                    for (int i = 0; i < NUM_TEETH; i++) {
                        if (teethExists[i]) {
                            // the back layer tooth
                            ImageButton button = findViewById(teethId[i]);
                            button.setVisibility(View.VISIBLE);

                            // the front layer tooth
                            ImageView tooth = findViewById(t_Id[i]);
                            tooth.setVisibility(View.VISIBLE);

                            // the actual ph display
                            TextView phDisplay = findViewById(phId[i]);
                            phDisplay.setVisibility(View.VISIBLE);
                        }
                        // make the tooth number show up
                        TextView toothNumber = findViewById(toothNum[i]);
                        toothNumber.setVisibility(View.VISIBLE);
                    }

                    // Make all of the front teeth tools disappear
                    for (int i = 0; i < NUM_TEETH; i++) {
                        ImageButton button = findViewById(back_teethId[i]);
                        button.setVisibility(View.INVISIBLE);

                        ImageView tooth = findViewById(back_t_Id[i]);
                        tooth.setVisibility(View.INVISIBLE);

                        TextView phDisplay = findViewById(back_phId[i]);
                        phDisplay.setVisibility(View.INVISIBLE);

                        // make the tooth number show up
                        TextView toothNumber = findViewById(back_toothNum[i]);
                        toothNumber.setVisibility(View.INVISIBLE);
                    }
                } else {
                    // The back radio button is selected
                    frontBackTextView.setText("Back View");

                    // Make all of the front teeth tools disappear
                    for (int i = 0; i < NUM_TEETH; i++) {
                        ImageButton button = findViewById(teethId[i]);
                        button.setVisibility(View.INVISIBLE);

                        ImageView tooth = findViewById(t_Id[i]);
                        tooth.setVisibility(View.INVISIBLE);

                        TextView phDisplay = findViewById(phId[i]);
                        phDisplay.setVisibility(View.INVISIBLE);

                        // make the tooth number show up
                        TextView toothNumber = findViewById(toothNum[i]);
                        toothNumber.setVisibility(View.INVISIBLE);
                    }

                    // Make the back teeth logic and tools appear
                    for (int i = 0; i < NUM_TEETH; i++) {
                        if (teethExists[i]) {
                            ImageButton button = findViewById(back_teethId[i]);
                            button.setVisibility(View.VISIBLE);

                            ImageView tooth = findViewById(back_t_Id[i]);
                            tooth.setVisibility(View.VISIBLE);

                            // the actual ph display
                            TextView phDisplay = findViewById(back_phId[i]);
                            phDisplay.setVisibility(View.VISIBLE);
                        }

                        // make the tooth number show up
                        TextView toothNumber = findViewById(back_toothNum[i]);
                        toothNumber.setVisibility(View.VISIBLE);
                    }
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
                                teethExists[tooth] = false;
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
                        // showToast(confirmation);

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
                if (!teethExists[tooth]) {
                    button.setVisibility(View.VISIBLE);
                    phDisplay.setVisibility(View.VISIBLE);
                    frontView.setVisibility(View.VISIBLE);
                    teethExists[tooth] = true;
                }
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
        toast.setDuration(Toast.LENGTH_SHORT);
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
