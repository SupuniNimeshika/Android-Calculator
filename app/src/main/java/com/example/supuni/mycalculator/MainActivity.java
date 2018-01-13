package com.example.supuni.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private String display="";
    private String currentOperator="";
    private String result ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (TextView)findViewById(R.id.editText);
        screen.setText(display);
    }

    private void updateScreen(){
        screen.setText(display);
    }

    public void onClickNumber (View  v){
        if(result != "") {
            clear();
            updateScreen();
        }
        Button b= (Button) v;
        display += b.getText();
        updateScreen();
    }

    private boolean isOperator (char op){
        switch (op){
            case '+':
            case '-':
            case '*':
            case '/':return true;
            default:return false;
        }
    }

    public void onClickOperator(View v){
        if(result != ""){
            display =result;
            result = "";
        }

        if(currentOperator != "") {
            display.charAt(display.length()-1);
        }

        Button b =(Button)v;
        display +=b.getText();
        currentOperator=b.getText().toString();
        updateScreen();
    }

    public void clear(){
        display ="";
        currentOperator="";
        result ="";
    }

    public void onClickClear(View v){
        clear();
        updateScreen();
    }

    private double operate (String a, String b, String op){
        switch (op){
            case "+":return Double.valueOf(a) + Double.valueOf(b);
            case "-":return Double.valueOf(a) - Double.valueOf(b);
            case "*":return Double.valueOf(a) * Double.valueOf(b);
            case "/":try {
                return Double.valueOf(a) / Double.valueOf(b);
            }catch (Exception e){
                Log.d("Calc",e.getMessage());
            }
            default:return -1;
        }
    }
    public void onClickEqual(View v){
        String[] operation =display.split(Pattern.quote(currentOperator));
        if(operation.length<2)return;

        result = String.valueOf(operate(operation[0],operation[1],currentOperator));
        screen.setText(display + "\n" +String.valueOf(result));
    }
}
