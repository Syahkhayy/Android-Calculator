package com.syahkhay.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAC, btnDel,
            btnPlus, btnMinus, btnDiv,btnMulti,btnEquals,btnDot;

    private TextView tvResult, tvHistory;
    private String number = null;

    double firstNum = 0, lastNum = 0;

    String status=null;

    DecimalFormat myFormat=new DecimalFormat("####.######");

    String history, currentResult;

    boolean dot = true, btnACcontrol=true, operator=false, btnEqualsControl=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnPlus=findViewById(R.id.btnPlus);
        btnMinus=findViewById(R.id.btnMinus);
        btnDiv=findViewById(R.id.btnDiv);
        btnMulti=findViewById(R.id.btnMulti);
        btnAC=findViewById(R.id.btnAC);
        btnDel=findViewById(R.id.btnDel);
        btnDot=findViewById(R.id.btnDot);
        btnEquals=findViewById(R.id.btnEqual);
        tvResult=findViewById(R.id.tvResult);
        tvHistory=findViewById(R.id.tvHistory);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(btnACcontrol){
                    tvResult.setText("0");
                }else{
                    //Buang nombor belakang
                    number = number.substring(0, number.length()-1);

                    if(number.length()==0){
                        btnDel.setClickable(false);
                    }else if(number.contains(".")){
                        dot=false;
                    }else{
                        dot=true;
                    }

                    if(number.length()==0){
                        tvResult.setText("0");
                    }else{
                        tvResult.setText(number);
                    }

                }
            }
        });


        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=null;
                status=null;
                tvResult.setText("0");
                tvHistory.setText("");
                firstNum=0;
                lastNum=0;
                dot=true;
                btnACcontrol=true;
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {

//          Check ada operation or not before click, kalau ada, kira dulu
            @Override
            public void onClick(View view) {

                history = tvHistory.getText().toString();
                currentResult=tvResult.getText().toString();
                tvHistory.setText(history+currentResult+"+");

                if(operator==true){
                    if(status=="multiplication"){
                        multiply();
                    }else if(status=="division"){
                        divide();
                    }else if(status=="subtraction"){
                        minus();
                    }else{
                        plus();
                    }
                }
                status="sum";
                operator=false;
                number=null;
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {

            //          Check ada operation or not before click, kalau ada, kira dulu
            @Override
            public void onClick(View view) {


                history = tvHistory.getText().toString();
                currentResult=tvResult.getText().toString();
                tvHistory.setText(history+currentResult+"-");

                if(operator==true) {
                    if (status == "multiplication") {
                        multiply();
                    } else if (status == "division") {
                        divide();
                    }else if(status=="sum"){
                        plus();
                    }else{
                        minus();
                    }
                }
                status="subtraction";
                operator=false;
                number=null;
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {

            //          Check ada operation or not before click, kalau ada, kira dulu
            @Override
            public void onClick(View view) {


                history = tvHistory.getText().toString();
                currentResult=tvResult.getText().toString();
                tvHistory.setText(history+currentResult+"x");

                if(operator==true) {
                    if (status == "subtraction") {
                        minus();
                    } else if (status == "division") {
                        divide();
                    }else if(status=="sum"){
                        plus();
                    }else{
                        multiply();
                    }
                }
                status="multiplication";
                operator=false;
                number=null;
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {

            //          Check ada operation or not before click, kalau ada, kira dulu
            @Override
            public void onClick(View view) {


                history = tvHistory.getText().toString();
                currentResult=tvResult.getText().toString();
                tvHistory.setText(history+currentResult+"/");

                if(operator==true) {
                    if (status == "subtraction") {
                        minus();
                    } else if (status == "multiplication") {
                        multiply();
                    }else if(status=="sum"){
                        plus();
                    }else{
                        divide();
                    }
                }
                status="division";
                operator=false;
                number=null;
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dot){
                    if(number==null){
                        number="0.";
                    }else{
                        number=number + ".";
                    }
                    tvResult.setText(number);
                    dot=false;
                }
            }
        });
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(operator==true){
                    if(status=="sum"){
                        plus();
                    }else if(status=="multiplication"){
                        multiply();
                    }else if(status=="division"){
                        divide();
                    }else if(status=="subtraction"){
                        minus();
                    }else{
                        firstNum=Double.parseDouble(tvResult.getText().toString());
                    }
                }
                operator=false;
                btnEqualsControl=true;
            }
        });


    }

    public void numberClick(String view){

        if(number==null){
            number = view;
        }else if (btnEqualsControl){
            firstNum = 0;
            lastNum = 0;
            number = view;
        }
        else{
            number=number + view;
        }

        tvResult.setText(number);
        operator=true;
        btnACcontrol=false;
        btnDel.setClickable(true);
        btnEqualsControl=false;
    }

    public void plus(){
        lastNum = Double.parseDouble(tvResult.getText().toString());
        firstNum += lastNum;
        tvResult.setText(myFormat.format(firstNum));
        dot=true;
    }

    public void minus(){
        if(firstNum == 0){
            firstNum=Double.parseDouble(tvResult.getText().toString());
        }else{
            lastNum=Double.parseDouble(tvResult.getText().toString());
            firstNum-=lastNum;
        }
        tvResult.setText(myFormat.format(firstNum));
        dot=true;
    }

    public void multiply(){
        if(firstNum==0){
            firstNum=1;
            lastNum=Double.parseDouble(tvResult.getText().toString());
            firstNum*=lastNum;
        }else{
            lastNum=Double.parseDouble(tvResult.getText().toString());
            firstNum*=lastNum;
        }
        tvResult.setText(myFormat.format(firstNum));
        dot=true;
    }

    public void divide(){
        if(firstNum==0){
            lastNum=Double.parseDouble(tvResult.getText().toString());
            firstNum=lastNum/1;
        }else{
            lastNum=Double.parseDouble(tvResult.getText().toString());
            firstNum=firstNum/lastNum;
        }
        tvResult.setText(myFormat.format(firstNum));
        dot=true;
    }
}