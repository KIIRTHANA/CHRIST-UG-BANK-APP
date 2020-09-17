package com.example.christugbank;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    EditText t1, t2, t3, t4;
    TextView tv;
    Switch s1;
    ToggleButton tb;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        tv = findViewById(R.id.tv);
        s1 = findViewById(R.id.s1);
        tb = findViewById(R.id.tb);
        b = findViewById(R.id.b);
            }
        });


    }
    public void openActivity2() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void DoHandle(View v) {
        try {
            if (!s1.isChecked()) {
                setTitle("Bank Closed");
            }
            int acc = Integer.parseInt("" + t2.getText());
            Integer bal = Integer.parseInt("" + t3.getText());
            Integer amm = Integer.parseInt("" + t4.getText());
            if (s1.isChecked() && tb.isChecked()) {
                setTitle("Amount Deposit");
                bal = bal + amm - 5;
                tv.setText("Updated Balance=" + bal);
            } else if (s1.isChecked() && !tb.isChecked() && bal > amm + 5) {
                setTitle("Amount Withdraw");
                bal = bal - amm - 5;
                tv.setText("Updated Balance=" + bal);
            } else if (s1.isChecked() && !tb.isChecked() && bal <= amm + 5) {
                setTitle("Amount Withdraw");
                tv.setText("Insufficient Balance");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            tv.setText(ex.getMessage());

        }
    }

}