package com.dsy.dsu.Code_For_Tasks_КодДля_Задания;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dsy.dsu.CREATE_DATABASE;
import com.dsy.dsu.Class_GRUD_SQL_Operations;
import com.dsy.dsu.Class_Generation_Errors;
import com.dsy.dsu.PUBLIC_CONTENT;

import java.util.concurrent.ExecutionException;


public class Fragment2_Create_Tasks extends Fragment1_One_Tasks {
    // TODO: 15.03.2022
    @SuppressLint("RestrictedApi")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            // TODO: 14.03.2022 ССЫЛКА НА РОДИТЕЛЬСКОЕ ФРАГМЕНТ
            // TODO: 14.03.2022
            textViewТекущаяЗадача.setText("Созданные".toUpperCase());
            // TODO: 14.03.2022
            super.bottomNavigationКонкретноКнопкаСоздатьСейчас.setVisibility(View.VISIBLE);
            // TODO: 14.03.2022
            super.bottomNavigationКонкретноКнопкаСоздатьСейчас.setSelected(true);
            // TODO: 15.03.2022
            super.bottomNavigationКонкретноКнопкаСоздатьСейчас.setChecked(true);
            // TODO: 14.03.2022
            super.bottomNavigationViewДляTasks.requestLayout();
            // TODO: 14.03.2022
            super.linearLayou.requestLayout();
            // TODO: 14.03.2022
            // TODO: 15.03.2022


            Log.d(this.getClass().getName(), "  Fragment2_Create_Tasks  viewДляПервойКнопкиHome_Задания ---/" + viewДляПервойКнопкиHome_Задания +
                    " subClassBuccessLogin_главныйКлассБизнесЛогики " + subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1);

        } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getActivity()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///


    }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try{
        Log.d(this.getClass().getName(), "  Fragment2_Create_Tasks  viewДляПервойКнопкиHome_Задания " + viewДляПервойКнопкиHome_Задания);

    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getActivity()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///


    }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    // TODO: 12.03.2022


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try{
            // TODO: 12.03.2022
        Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики  ИмяСлужбыСинхронизацииДляЗадачиИзЧата   Fragment2_Create_Tasks " +
                "" + ИмяСлужбыОдноразоваяСинхронизацииДляЗадачиИзЧата +
                " ИмяСлужбыСинхронизацииДляЗадачи " + ИмяСлужбыОбщейСинхронизацииДляЗадачи);

    } catch (Exception e) {
        e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getActivity()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///


        }
    }

    // TODO: 15.03.2022
    @Override
    public void onStart() {
        super.onStart();

        try {
            // TODO: 15.03.2022

            // TODO: 15.03.2022--ЗАПУСК КЛАСС ДУБЛИРОВАННЫХ
            SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент2 subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент2 = new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент2(getContext(), getActivity());
            //TODO код для recycleviews
            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент2.МетодПолучениеТОлЬКоКурсораДЛяПолучнеиеКоличетсовЗадачТолькоДляКоторыхВРАботе(ПубличныйIDДляФрагмента);


            // TODO: 03.03.2022
            Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе + " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);
            // TODO: 15.03.2022

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    // TODO: 15.03.2022  Класс бизнес логика два для ВТОРГО ФРАГМЕНТА
    class SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент2 extends SubClassBuccessLogin_ГлавныйКлассБизнесЛогики {

        public SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент2(Context context, Activity activity) {
            super(context, activity);

            // TODO: 03.03.2022
            Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);
        }

        // TODO: 14.03.2022
        @Override
        protected SQLiteCursor МетодПолучениеТОлЬКоКурсораДЛяПолучнеиеКоличетсовЗадачТолькоДляКоторыхВРАботе(Integer ПубличноеIDПолученныйИзСервлетаДляUUID) throws ExecutionException, InterruptedException {
            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ
            Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе = null;
            // TODO: 02.03.2022
            try {
                ///
                Class_GRUD_SQL_Operations class_grud_sql_operationsIDпользоввателяДляСлужб = new Class_GRUD_SQL_Operations(getContext());
                ///
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", "view_tasks");//old для другой уведомления data_chat
                ///////
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "*");
                //
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "   user_update=? AND status_write=? " +
                        " AND message IS NOT NULL  ");// TODO: 15.03.2022 id_user
                // TODO: 02.03.2022
                ///"_id > ?   AND _id< ?"
              /*  class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","status_write=?  AND id_user=? " +
                        " AND message IS NOT NULL  ");
                ///"_id > ?   AND _id< ?"
*/
/*
                //////
                class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",1);//todo 0*/
                //
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", ПубличноеIDПолученныйИзСервлетаДляUUID);

                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2", 0);
                // TODO: 02.03.2022

                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки", " status_write, date_update DESC ");//todo "date_update DESC, status_write DESC"
                ////
                // class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                ////
                //class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
                ///
                Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе = null;
                // TODO: 03.03.2022  глаВНЫЙ КУРСОР ДЛЯ ЗАДАЧ
                Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе = (SQLiteCursor) class_grud_sql_operationsIDпользоввателяДляСлужб.
                        new GetData(getContext()).getdata(class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        new PUBLIC_CONTENT(context).МенеджерПотоков, new CREATE_DATABASE(context).getССылкаНаСозданнуюБазу());
                // TODO: 02.03.2022
                if (Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount() > 0) {
                    // TODO: 03.03.2022
                    Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);
                    // TODO: 03.03.2022
                    Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.moveToFirst();
                }
                // TODO: 14.03.2022
                Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
            }
            return Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе;
        }

    }
}    // TODO: 28.02.2022 конец класса






























