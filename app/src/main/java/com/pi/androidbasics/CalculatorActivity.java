package com.pi.androidbasics;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    TextView resultTv;
    String lhs = "";
    String savedOperator = "";

    boolean isResultCalcualted = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultTv = findViewById(R.id.result_tv);

    }

    public void onDigitClick(View v) {
        Button clickedButton = (Button) v;
        if (resultTv.getText().toString().contains(".") && clickedButton.getText().toString() == ".")
            return;
        if (isResultCalcualted) {
            resultTv.setText("");
            isResultCalcualted = false;
        }
        resultTv.append(clickedButton.getText());
    }

    public void onEqualClick(View v) {
        if (lhs.isEmpty() || resultTv.getText().toString().isEmpty()){
            Toast.makeText(this, "Invalid operation", Toast.LENGTH_SHORT).show();
            return;
        }
        resultTv.setText(calculate(lhs, savedOperator, resultTv.getText().toString()));
        isResultCalcualted = true;
        lhs = "";
        savedOperator = "";
    }

    public void onOperatorClick(View v) {
        if (resultTv.getText().toString().isEmpty()) return;
        Log.e("onOperatorClick", "resultTv = " + resultTv.getText().toString().toLowerCase());
        Log.e("onOperatorClick", "condition = " + (resultTv.getText().toString().equalsIgnoreCase("infinity")));
        if(resultTv.getText().toString().equalsIgnoreCase("infinity")){
            Toast.makeText(this, "Infinity is not allowed", Toast.LENGTH_SHORT).show();
            resultTv.setText("");
            return;
        }
        Button clickedOperator = (Button) v;
        if (savedOperator.isEmpty()) {
            lhs = resultTv.getText().toString();
        } else {
            lhs = calculate(lhs, savedOperator, resultTv.getText().toString());
        }
        savedOperator = clickedOperator.getText().toString();
        resultTv.setText("");

        Log.e("onOperatorClick", "lhs = " + lhs + ", savedOpreator = " + savedOperator);
    }

    String calculate(String lhs, String operator, String rhs) {
        double n1 = Double.parseDouble(lhs);
        double n2 = Double.parseDouble(rhs);
        switch (operator) {
            case "+":
                return (n1 + n2) + "";
            case "-":
                return (n1 - n2) + "";
            case "/":
                return (n1 / n2) + "";
            default:
                return (n1 * n2) + "";
        }
    }


}
