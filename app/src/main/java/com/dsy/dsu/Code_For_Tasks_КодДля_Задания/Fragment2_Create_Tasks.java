package com.dsy.dsu.Code_For_Tasks_КодДля_Задания;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dsy.dsu.Class_Generation_Errors;


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

            Log.d(this.getClass().getName(), "  Fragment2_Create_Tasks  viewДляПервойКнопкиHome_Задания ---/" + viewДляПервойКнопкиHome_Задания +
                    " subClassBuccessLogin_главныйКлассБизнесЛогики " + subClassBuccessLogin_главныйКлассБизнесЛогики);


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


}    // TODO: 28.02.2022 конец класса






























