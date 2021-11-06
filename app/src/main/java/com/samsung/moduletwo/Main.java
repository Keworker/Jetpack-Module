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

public class Main extends AppCompatActivity {

TextView text; //Сообщение о результате
SeekBar sp; //Отображение ползунка в процентах для пользователя

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        int itog = 2; //Переменная результата
        if (MainActivity.res.equals("инкапсуляция") || MainActivity.res.equals("Инкапсуляция")) {
            itog++; //Если ответ правильный, добавляем 1 балл
        }
        itog -= MainActivity2.res[0]; //Этот вариант не правильный, если он нажат - балл
        itog += MainActivity2.res[1]; //Этот вариант правильный, если он нажат + балл
        itog -= MainActivity2.res[2]; //Этот вариант не верный, если он нажат - балл
        itog += MainActivity2.res[3]; //Этот вариант верный, если он нажат + балл
        itog += MainActivity3.res; //Прибавляем баллы (0-1) за последний вопрос
        int viewing = 100 * itog / 6; //Переменная для представления итога в процентах
        text = findViewById(R.id.text); //Находим текст
        text.setText(("Вы набрали " + itog + " из 6 баллов")); //Пишем результат текстом
        sp = findViewById(R.id.sp); //Находим сикбар
        sp.setProgress(viewing); //Заполняем его на необходимое число процентов
        sp.setOnTouchListener(new View.OnTouchListener(){ //Перезаписываем метод прикосновения к сикбару,
            @Override //Что бы пользователь не мог поменять его положение
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }
}
