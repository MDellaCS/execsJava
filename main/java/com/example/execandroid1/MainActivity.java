package com.example.execandroid1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1;
    private EditText etNum2;
    private EditText etOp;
    private Button btnCalc;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(click -> Calc());

    }

    private void Calc(){

        EditText etNum1 = findViewById(R.id.etNum1);
        EditText etNum2 = findViewById(R.id.etNum2);
        EditText etOp = findViewById(R.id.etOp);
        TextView tvRes = findViewById(R.id.tvRes);

        int num1 = Integer.parseInt(etNum1.getText().toString());
        int num2 = Integer.parseInt(etNum2.getText().toString());
        String op = etOp.getText().toString();

        float res;
        switch(op){
            case "+":
                res = num1 + num2;
                tvRes.setText(Float.toString(res));
                break;
            case "-":
                res = num1 - num2;
                tvRes.setText(Float.toString(res));
                break;
            case "*":
                res = num1 * num2;
                tvRes.setText(Float.toString(res));
                break;
            case "/":
                res = num1 / num2;
                tvRes.setText(Float.toString(res));
                break;
            default: Toast.makeText(this, R.string.error_Op, Toast.LENGTH_LONG).show(); break;
        }

    }

}