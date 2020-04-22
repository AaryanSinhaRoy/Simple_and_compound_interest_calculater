package com.example.simpleandcompundinterestcalculater;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText etRate;
    EditText etPrincipal;
    EditText etTime;
    TextView tvResults;
    Button btnCalculate;
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrincipal=findViewById(R.id.etPrincipal);
        etTime=findViewById(R.id.etTime);
        etRate=findViewById(R.id.etRate);
        btnCalculate=findViewById(R.id.btnCalculate);
        tvResults=findViewById(R.id.tvResults);
        btnClear=findViewById(R.id.btnClear);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(etPrincipal.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "please enter the principal", Toast.LENGTH_SHORT).show();
                }
                else if(etRate.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "please enter rate of interest", Toast.LENGTH_SHORT).show();
                }
                else if(etTime.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "please enter the Time", Toast.LENGTH_SHORT).show();
                }
                else {


                    double  rate = Integer.parseInt(String.valueOf(etRate.getText()));
                    int principal = Integer.parseInt(String.valueOf(etPrincipal.getText()));
                    int time = Integer.parseInt(String.valueOf(etTime.getText()));
                    int si = (int) ((principal * rate * time) / 100);//simple interest calculation

                    double CI= principal * (Math.pow((1 + rate / 100), time));//-principal;
                    DecimalFormat numberFormat = new DecimalFormat("#.000");
                    String text;
                    text = getString(R.string.result) + si +"\n \n"+ getString(R.string.result2) + CI;

                    tvResults.setText(text);

                }
            }
        });
        //end of btn calculate
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPrincipal.getText().clear();
                etTime.getText().clear();
                etRate.getText().clear();
            }
        });

    }
}
