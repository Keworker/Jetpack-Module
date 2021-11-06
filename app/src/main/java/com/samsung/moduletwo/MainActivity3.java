package com.samsung.moduletwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    public static int res = 0;

TextView qwer;
RadioGroup gr;
Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        but = findViewById(R.id.but);
        but.setOnClickListener(this);
        gr = findViewById(R.id.gr);
        qwer = findViewById(R.id.qwer);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but:{
                if (gr.getCheckedRadioButtonId() == R.id.b) {
                    res = 1;
                }
                else if (gr.getCheckedRadioButtonId() == -1) {
                    qwer.setVisibility(but.getVisibility());
                    return;
                }
                Intent intent = new Intent(this, Main.class);
                startActivity(intent);
            }
        }
    }

    public static int returner() {
        return res;
    }
}