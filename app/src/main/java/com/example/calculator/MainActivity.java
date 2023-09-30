package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.script.*;

public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultsTV;
    String workings ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews() {
        workingsTV=(TextView)findViewById(R.id.working);
        resultsTV=(TextView)findViewById(R.id.result);
    }

    private void setWorkings(String givenValue){

        workings=workings + givenValue;
        workingsTV.setText(workings);
    }

    public void equalsOnClick(View view){
        Double result=null;
        ScriptEngine engine= new ScriptEngineManager().getEngineByName("rhino");

        try {
            result= (double)engine.eval(workings);
        }catch (ScriptException e){

            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
    }

        if (result !=null)
            resultsTV.setText(String.valueOf(result.doubleValue()));

    }

    public void clearOnClick(View view){
        workingsTV.setText("");
        workings="";
        resultsTV.setText("");
    }
    public void divideOnClick(View view){
        setWorkings("/");
    }
    public void multiplyOnClick(View view){
       setWorkings("*");
    }
    public void deleteOnClick(View view){
        int length = workings.length();
        if(length > 0){
            if (length == 1){
                workings = "";
            }else{
                workings = workings.substring(0, length - 1);
            }
            workingsTV.setText(workings);
        }
    }
    public void sevenOnClick(View view){
        setWorkings("7");
    }
    public void eightOnClick(View view){
        setWorkings("8");
    }
    public void nineOnClick(View view){
        setWorkings("9");
    }
    public void fourOnClick(View view){
        setWorkings("4");
    }
    public void fiveOnClick(View view){
        setWorkings("5");
    }
    public void sixOnClick(View view){
        setWorkings("6");
    }
    public void oneOnClick(View view){
        setWorkings("1");
    }
    public void twoOnClick(View view){
        setWorkings("2");
    }
    public void threeOnClick(View view){
        setWorkings("3");
    }
    public void subtractOnClick(View view){
        setWorkings("-");
    }
    public void addOnClick(View view){
        setWorkings("+");
    }
    public void percentageOnClick(View view){
        if (workings.isEmpty()) {
            Toast.makeText(this, "Enter a number first", Toast.LENGTH_SHORT).show();
            return;
        }
        // Convert the workings string to a double
        double number = Double.parseDouble(workings);
        // Divide the number by 100 to get the percentage
        double percentage = number / 100;
        // Update the workings and results TextViews with the percentage
        workings = Double.toString(percentage);
        workingsTV.setText(workings);
        resultsTV.setText(workings);
    }

    public void decimalOnClick(View view){
        setWorkings(".");
    }
    public void zeroOnClick(View view){
        setWorkings("0");
    }

}