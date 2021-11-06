package com.samsung.moduletwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String res;

Button n1;
EditText editText1;
TextView eror;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        n1 = findViewById(R.id.n1);
        n1.setOnClickListener(this);
        eror = findViewById(R.id.eror);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.n1:{
                String s = editText1.getText().toString();
                if (s.equals("")) {
                    eror.setVisibility(view.getVisibility());
                }
                else {
                    res = s;
                    Intent intent = new Intent(this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        }
    }
    public static String retres() {
        return res;
    }
}