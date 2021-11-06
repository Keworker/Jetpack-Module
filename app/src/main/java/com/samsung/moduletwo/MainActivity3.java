package com.samsung.moduletwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    public static int res = 0; //Создаем переменную, обозначающую сколько баллов мы даем за этот вопрос

TextView qwerty; //Сообщение об ошибке
RadioGroup gr; //Группа кнопок (нажать можно только 1)
Button but; //Кнопка перехода на следующий Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        but = findViewById(R.id.but); //Находим кнопку
        but.setOnClickListener(this); //Ставим слушатель
        gr = findViewById(R.id.gr); //Находим группу "Radio" кнопок
        qwerty = findViewById(R.id.qwer); //Находим сообщение об ошибке
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but:{ //Если кнопка перехода нажата
                if (gr.getCheckedRadioButtonId() == R.id.b) { //Если нажата кнопка правильного ответа
                    res = 1; //К баллам прибавляется 1
                }
                else if (gr.getCheckedRadioButtonId() == -1) { //Иначе, если не нажато ничего
                    qwerty.setVisibility(View.VISIBLE); //Выводим сообщение об ошибке
                    return; //Выходим из функции
                }
                Intent intent = new Intent(this, Main.class); //Сохдаем экзэмпляр класса Intent
                startActivity(intent); //Переходим к следующей Activity
            }
        }
    }
}
