package com.samsung.moduletwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    public static int[] res = new int[4];

Button n1;
TextView eror;
CheckBox case1, case2, case3, case4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        n1 = findViewById(R.id.n1);
        n1.setOnClickListener(this);
        eror = findViewById(R.id.eror);
        case1 = findViewById(R.id.case1);
        case1.setOnCheckedChangeListener(this);
        case2 = findViewById(R.id.case2);
        case2.setOnCheckedChangeListener(this);
        case3 = findViewById(R.id.case3);
        case3.setOnCheckedChangeListener(this);
        case4 = findViewById(R.id.case4);
        case4.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.n1:{
                Intent intent = new Intent(this, MainActivity3.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        boolean eins;
        boolean zwei;
        boolean drei;
        boolean viere;
        switch (compoundButton.getId()) {
            case R.id.case1:{
                if (b == true) {
                    res[0] = 1;
                }
                else {
                    res[0] = 0;
                }
                break;
            }
            case R.id.case2:{
                if (b == true) {
                    res[1] = 1;
                }
                else {
                    res[1] = 0;
                }
                break;
            }
            case R.id.case3:{
                if (b == true) {
                    res[2] = 1;
                }
                else {
                    res[2] = 0;
                }
                break;
            }
            case R.id.case4:{
                if (b == true) {
                    res[3] = 1;
                }
                else {
                    res[3] = 0;
                }
                break;
            }
        }
    }

    public static  int[] returner() {
        return res;
    }
}