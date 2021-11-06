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

    public static int[] res = new int[4]; //Массив значений каждого из флажков

Button n1; //Кнопка перехода к следующей Activity
CheckBox case1, case2, case3, case4; //Флажки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        n1 = findViewById(R.id.n1); //Находим кнопку
        n1.setOnClickListener(this); //Подключаем к ней слушатель
        case1 = findViewById(R.id.case1); //Находим первый флажок
        case1.setOnCheckedChangeListener(this); //Подключаем слушатель
        case2 = findViewById(R.id.case2); //Находим второй флажок
        case2.setOnCheckedChangeListener(this); //Подключаем слушатель
        case3 = findViewById(R.id.case3); //Находим третий флажок
        case3.setOnCheckedChangeListener(this); //Подключаем слушатель
        case4 = findViewById(R.id.case4); //Находим четвертый флажок
        case4.setOnCheckedChangeListener(this); //Подключаем слушатель
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.n1:{ //Если нажата кнопка
                Intent intent = new Intent(this, MainActivity3.class); //Создаем экзэмпляр класса Intent
                startActivity(intent); //Переходим к следующей Activity
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.case1:{ //Если у первого флажка изменилось положение
                if (b) { //Если он включился
                    res[0] = 1; //Делаем его переменную из выходного массива единицей
                }
                else { //Иначе
                    res[0] = 0; //Делаем его нулем
                }
                break; //Лишний раз не проверяем остальные флаги
            }//Во всех остальных кейсах такой же принцип
            case R.id.case2:{
                if (b) {
                    res[1] = 1;
                }
                else {
                    res[1] = 0;
                }
                break;
            }
            case R.id.case3:{
                if (b) {
                    res[2] = 1;
                }
                else {
                    res[2] = 0;
                }
                break;
            }
            case R.id.case4:{
                if (b) {
                    res[3] = 1;
                }
                else {
                    res[3] = 0;
                }
            }
        }
    }
}
