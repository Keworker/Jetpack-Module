package com.samsung.moduletwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Main extends AppCompatActivity implements View.OnClickListener {

TextView text;
SeekBar sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Integer itog = 2;
        if (MainActivity.retres().equals("инкапсуляция") || MainActivity.retres().equals("Инкапсуляция")) {
            itog++;
            Log.d("qwerty23", itog.toString());
        }
        itog -= MainActivity2.returner()[0];
        Log.d("qwerty23", itog.toString());
        itog += MainActivity2.returner()[1];
        Log.d("qwerty23", itog.toString());
        itog -= MainActivity2.returner()[2];
        Log.d("qwerty23", itog.toString());
        itog += MainActivity2.returner()[3];
        Log.d("qwerty23", itog.toString());
        itog += MainActivity3.returner();
        Log.d("qwerty23", itog.toString());
        if (itog < 0) {
            itog = 0;
        }
        int viewing = 100 * itog / 6;
        text = findViewById(R.id.text);
        text.setText(("Вы набрали " + itog + " из 6 баллов"));
        sp = findViewById(R.id.sp);
        sp.setProgress(viewing);
        sp.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}