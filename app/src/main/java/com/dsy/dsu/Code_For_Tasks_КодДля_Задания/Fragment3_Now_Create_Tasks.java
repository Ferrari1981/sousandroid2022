package com.dsy.dsu.Code_For_Tasks_КодДля_Задания;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.Class_Generation_Errors;
import com.dsy.dsu.R;


public class Fragment3_Now_Create_Tasks extends Fragment1_One_Tasks {
    // TODO: 15.03.2022
    View viewДляПервойКнопкиДля_СозданиеНовойЗадачи;
    // TODO: 15.03.2022
    LinearLayout linearLayou;
    // TODO: 15.03.2022
    RecyclerView recyclerViewДляСозданиеНовойЗадачи;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            // TODO: 14.03.2022 ССЫЛКА НА РОДИТЕЛЬСКОЕ ФРАГМЕНТ

            linearLayou = (LinearLayout) getActivity().findViewById(R.id.activity_fragment3_for_create_new_tasks);
            // TODO: 14.03.2022
            textViewТекущаяЗадача.setText("Новое".toUpperCase());

            // TODO: 28.02.2022
            recyclerViewДляСозданиеНовойЗадачи = (RecyclerView) view.findViewById(R.id.recycleviewActivi_create_newTask);

            // TODO: 15.03.2022
            recyclerViewДляСозданиеНовойЗадачи.setVisibility(View.VISIBLE);
            // TODO: 14.03.202
            GridLayoutManager gridLayoutManager;
            // TODO: 14.03.202
            gridLayoutManager = new GridLayoutManager(getActivity(), 1);
            // TODO: 28.02.2022 создаем наш первый RecyclerView
            recyclerViewДляСозданиеНовойЗадачи.setLayoutManager(gridLayoutManager);//TODO new LinearLayoutManager(getContext()) // TODO: 28.02.2022 создаем наш первый RecyclerView recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


            // TODO: 14.03.2022
        /*  bottomNavigationКонкретноКнопкаСоздатьСейчас.setVisibility(View.VISIBLE);
            // TODO: 14.03.2022
            bottomNavigationКонкретноКнопкаСоздатьСейчас.setSelected(true);
            // TODO: 14.03.2022
           bottomNavigationViewДляTasks.requestLayout();
            // TODO: 14.03.2022*/
            recyclerViewДляСозданиеНовойЗадачи.requestLayout();
            // TODO: 15.03.2022
            linearLayou.requestLayout();
            // TODO: 14.03.2022

            Log.d(this.getClass().getName(), "  Fragment2_Create_Tasks  viewДляПервойКнопкиHome_Задания ---/" + viewДляПервойКнопкиHome_Задания + " recyclerViewДляСозданиеНовойЗадачи" +
                    recyclerViewДляСозданиеНовойЗадачи);

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
        try {
            Log.d(this.getClass().getName(), "  Fragment2_Create_Tasks  viewДляПервойКнопкиHome_Задания " + viewДляПервойКнопкиHome_Задания);

            // TODO: 14.03.2022
            viewДляПервойКнопкиДля_СозданиеНовойЗадачи = inflater.inflate(R.layout.activity_main_fragment3_for_create_new_tasks, container, false);

            // TODO: 15.03.2022

            // TODO: 12.03.2022
            Log.d(this.getClass().getName(), " onCreateView  viewДляПервойКнопкиHome_Задания  Fragment1_One_Tasks  onCreateView " +
                    "" + viewДляПервойКнопкиДля_СозданиеНовойЗадачи);

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getActivity()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///


        }
        return viewДляПервойКнопкиДля_СозданиеНовойЗадачи;//todo  super.onCreateView(inflater, container, savedInstanceState);
    }

    // TODO: 12.03.2022


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            // TODO: 12.03.2022
            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  ИмяСлужбыСинхронизацииДляЗадачиИзЧата   Fragment2_Create_Tasks " +
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
}    // TODO: 28.02.2022 конец класса






























