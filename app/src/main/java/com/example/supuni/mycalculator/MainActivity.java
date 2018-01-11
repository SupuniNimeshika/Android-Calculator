package com.example.supuni.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private String display="";
    private String currentOperator="";

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

    public void onClickNumber (View v){
        Button b= (Button) v;
        display += b.getText();
        updateScreen();
    }

    public void onClickOperator(View v){
        Button b =(Button)v;
        display +=b.getText();
        currentOperator=b.getText().toString();
        updateScreen();
    }

    public void clear(){
        display ="";
        currentOperator="";
        updateScreen();
    }

    public void onClickClear(View v){
        clear();
        updateScreen();
    }

    public void onClickEqual(View v){

    }
}
