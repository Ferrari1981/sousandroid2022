package com.dsy.dsu.Code_For_Tasks_КодДля_Задания;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.dsy.dsu.Class_Generation_Errors;
import com.dsy.dsu.R;


public class MainActivity_Tasks extends FragmentActivity {


    // TODO: 28.02.2022
    private Activity activity;
    // TODO: 28.02.2022

    // TODO: 09.03.2022
    private FragmentManager fragmentManagerДляЗадачи;
    ///
    private FragmentTransaction fragmentTransactionляЗадачи;
    // TODO: 09.03.2022

    private Fragment fragment_дляЗадачиПерваяКнопка;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            /*   setContentView(R.layout.activity_main_fragment1_for_tasks);//R.layout.activity_main_history_chat  //TODO old R.layout.activity_main_history_tasks*/
            setContentView(R.layout.activity_main_fisrt_for_tasks);//R.layout.activity_main_history_chat  //TODO old R.layout.activity_main_history_tasks

            // TODO: 27.04.2021 формируем внешний вид Чата через фрагменты

            activity = this;
            // TODO: 28.02.2022
            ////
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

            /////

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                    | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                    | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);






// TODO: 03.03.2022  ЗАПУСКАЕМ БИЗНЕС ЛОГИКУ НА АКТИВТИ ДЛЯ ФРАГМЕНТОВ ДЛЯ ЗАДАНИЯ

          new SubClass_Only_ActivyMain_Buccess_Logic(getApplicationContext(),activity).МетодЗапускФрагментаЗадачиСАктивти();





            Log.d(this.getClass().getName(), " fragmentTransactionляЗадачи " + fragmentTransactionляЗадачи);

            // TODO: 01.03.2022*/
            /////////////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }



    // TODO: 10.03.2022




    private class SubClass_Only_ActivyMain_Buccess_Logic {
        public SubClass_Only_ActivyMain_Buccess_Logic(Context context,Activity activity) {
            // TODO: 10.03.2022
        }

        // TODO: 10.03.2022

    private void МетодЗапускФрагментаЗадачиСАктивти() {

        try{
            Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи   ");

            fragmentManagerДляЗадачи = getSupportFragmentManager();
            ///
            fragmentTransactionляЗадачи = fragmentManagerДляЗадачи.beginTransaction();

            // TODO: 22.12.2021  запускам втнутерий класс по созданию бизнес логики для даннго активти

            Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи  fragmentTransactionляЗадачи  " + fragmentTransactionляЗадачи);

            Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи imageView   ");

            // TODO: 09.03.2022
            fragment_дляЗадачиПерваяКнопка = new Fragment1_One_Tasks();
            ///
            fragmentTransactionляЗадачи.replace(R.id.activity_main_fisrt_for_tasks, fragment_дляЗадачиПерваяКнопка).commit();//.layout.activity_for_fragemtb_history_tasks

            // TODO: 10.03.2022
            fragmentTransactionляЗадачи.show(fragment_дляЗадачиПерваяКнопка);

            Log.d(this.getClass().getName(), " fragmentTransactionляЗадачи " + fragmentTransactionляЗадачи);

            /////////////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
    }
}





    // TODO: 28.02.2022 конец класса

// TODO: 28.02.2022  old test code













