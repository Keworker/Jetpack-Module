package com.samsung.moduletwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Visibility;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String res; //Переменная с текстом, который ввел пользователь

Button n1; //Кнопка next для следующего Activity
EditText editText1; //Поле ввода текста
TextView eror; //Текст ошибки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1); //Находим поле
        n1 = findViewById(R.id.n1); //Находим кнопку
        n1.setOnClickListener(this); //Вызываем слушатель
        eror = findViewById(R.id.eror); //Находим текст ошибки
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.n1:{ //Если кнопка нажата
                String s = editText1.getText().toString(); //Сохраняем значения текстового поля в переменную s
                if (s.equals("")) { //Если ничего не написано
                    eror.setVisibility(View.VISIBLE); //Выводим ошибку (Введите ответ)
                }
                else { //Иначе
                    res = s; //Передаем переменной значение
                    Intent intent = new Intent(this, MainActivity2.class); //Создаем экзэмпляр класса Intent
                    startActivity(intent); //Переходим к следующей Activity
                }
            }
        }
    }
}
