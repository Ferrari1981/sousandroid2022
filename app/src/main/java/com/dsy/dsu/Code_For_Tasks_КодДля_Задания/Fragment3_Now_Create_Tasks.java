package com.dsy.dsu.Code_For_Tasks_КодДля_Задания;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.SeekBar;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.dsy.dsu.CREATE_DATABASE;
import com.dsy.dsu.Class_GRUD_SQL_Operations;
import com.dsy.dsu.Class_Generation_Data;
import com.dsy.dsu.Class_Generation_Errors;
import com.dsy.dsu.Class_Generation_UUID;
import com.dsy.dsu.Code_For_Firebase_AndOneSignal_Здесь_КодДЛяСлужбыУведомленияFirebase.Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal;
import com.dsy.dsu.PUBLIC_CONTENT;
import com.dsy.dsu.R;
import com.dsy.dsu.SubClass_RetryGEtRowInChatsКлассПроверемЕщеРАзПоявилосЛИПуббличныйUUIDМеждуУчасникамиЧата;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;


public class Fragment3_Now_Create_Tasks extends Fragment1_One_Tasks {
    // TODO: 15.03.2022
    // TODO: 28.02.2022
    protected RecyclerView recyclerView;
    // TODO: 16.03.2022
    private SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент3 subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи;
    // TODO: 16.03.2022
    private SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент3.MyRecycleViewAdapter myRecycleViewAdapter;
    // TODO: 16.03.2022
    // TODO: 14.03.2022
    private SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент3.MyViewHolder myViewHolder;
    // TODO: 14.03.2022
    AccessibilityNodeInfo accessibilityNodeInfoДополнительныеДанные;

    // TODO: 16.03.2022
    @SuppressLint("RestrictedApi")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            // TODO: 14.03.2022 ССЫЛКА НА РОДИТЕЛЬСКОЕ ФРАГМЕНТ/
            textViewТекущаяЗадача.setText("Новая".toUpperCase());
            // TODO: 14.03.202


            bottomNavigationКонкретноКнопкаКонтролируемыеЗадачи.setVisibility(View.GONE);
            // TODO: 16.03.2022
            bottomNavigationКонкретноКнопкаДобавить.setVisibility(View.VISIBLE);
            // TODO: 16.03.2022
            bottomNavigationКонкретноКнопкаДобавить.setTitle("Добавленные");

            // TODO: 15.03.2022 НЕ ПОКАЗЫВАЕМ
            /*   bottomNavigationКонкретноКнопкаДобавить.setVisibility(View.GONE);*/
            // TODO: 16.03.2022

            Log.d(this.getClass().getName(), "  Fragment2_Create_Tasks  viewДляПервойКнопкиHome_Задания ---/" + viewДляПервойКнопкиHome_Задания + " recyclerViewДляСозданиеНовойЗадачи");

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
            Log.d(this.getClass().getName(), "  Fragment3_Create_Tasks  viewДляПервойКнопкиHome_Задания " + viewДляПервойКнопкиHome_Задания);
            // TODO: 14.03.2022
            Log.d(this.getClass().getName(), " onCreateView  viewДляПервойКнопкиHome_Задания  Fragment1_One_Tasks  onCreateView ");

            // TODO: 14.03.2022
            viewДляПервойКнопкиHome_Задания = inflater.inflate(R.layout.activity_main_fragment1_for_tasks, container, false);

            // TODO: 12.03.2022
            Log.d(this.getClass().getName(), " onCreateView  viewДляПервойКнопкиHome_Задания  Fragment1_One_Tasks  onCreateView " +
                    "" + viewДляПервойКнопкиHome_Задания);

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getActivity()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///
        }
        return viewДляПервойКнопкиHome_Задания;//  super.onCreateView(inflater, container, savedInstanceState)            todo  super.onCreateView(inflater, container, savedInstanceState);
    }

    // TODO: 12.03.2022


    @Override
    public void onDestroy() {
        super.onDestroy();

        try {
            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 onDestroyView  " +
                    "" + adapterDataObserverObserverСлушатель +
                    " dataSetObserverДляКурсора " + dataSetObserverДляКурсора);

            /////////////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            // TODO: 16.03.2022
            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи = new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент3(getContext(), getActivity());

            // TODO: 12.03.2022
            Log.d(this.getClass().getName(), " отработоатл  subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляРедактирования " +
                    "" + subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи);


            // TODO: 15.03.2022
            Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);

            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи.МетодПолученимТОлькоКоличествоЗадач(ПубличныйIDДляФрагмента);

            Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);


            // TODO: 02.03.2022 получения курсора
            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи.МетодПолучаемГлавныеДанныеДляЗадач(ПубличныйIDДляФрагмента);

            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  " + Курсор_ГлавныйКурсорДляЗадач);



            // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА туту запускам два слушателя дялнаших work manager

            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи.МетодСоздаенияСлушателяДляОбщейWorkMAnager();

            // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА туту запускам два слушателя дялнаших work manager

            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи.МетодСоздаенияСлушателяДляЧатаWorkMAnager();


            //todo метод  ИНИЦИАЛИЗАЦИИ RECYCLEVIEW ДЛЯ АКТИВТИ ЗАДАЧИ

            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи.МетодИнициализацииRecycleViewДляЗадач();

            // TODO: 05.03.2022  ДЛЯ ИНИЗАЛИЗАЦИИ НИЖНИХ КНОПОК
            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи.МетодСозданиеНавигаторКнопок();

            // TODO: 17.03.2022

            // TODO: 05.03.2022  СТАТУС ЗНАЧКА С ДОПОЛНИТЕЛЬНЫЙ СТАТУСОМ
            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи.МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);


            Log.d(this.getClass().getName(), " нет данных для отображения " +
                    "отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  МетодКпопкаСоЗачкомКраснымДополнительныйСтатус  " + Курсор_ГлавныйКурсорДляЗадач +
                    " Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);


            // TODO: 22.03.2022 obsrver


            // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА

            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи.МетодСлушательObserverДляКурсора();


            // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ  второай слушатель только количество данных СЛУШАТЕЛЬ КУРСОРРА

            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи.МетодСлушательObserverДляКурсораТолькоКоличество();

            // TODO: 13.03.2022
            bottomNavigationViewДляTasks.requestLayout();
            // TODO: 13.03.202
            recyclerView.requestLayout();

            // TODO: 14.03.2022
            linearLayou.requestLayout();//


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


    // TODO: 16.03.2022 бизнес логика для третьего фрагмента созданеи нового задачи    // TODO: 16.03.2022 бизнес логика для третьего фрагмента созданеи нового задачи
    // TODO: 16.03.2022 бизнес логика для третьего фрагмента созданеи нового задачи   // TODO: 16.03.2022 бизнес логика для третьего фрагмента созданеи нового задачи

    class SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент3 extends SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 {
        // TODO: 28.02.2022
        public SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент3(Context context, Activity activity) {
            super(context, activity);
            // TODO: 03.03.2022
            Log.d(this.getClass().getName(), "SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент4  " + this.context.getClass().getName());
        }

        // TODO: 28.02.2022 Под Класс порлучение данных для активти
        @Override
        SQLiteCursor МетодПолучаемГлавныеДанныеДляЗадач(Integer ПубличноеIDПолученныйИзСервлетаДляUUID)
                throws ExecutionException, InterruptedException {
            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ
            try {
                ///
                Class_GRUD_SQL_Operations class_grud_sql_operationsIDпользоввателяДляСлужб = new Class_GRUD_SQL_Operations(getContext());
                ///
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", "view_tasks");//old для другой уведомления data_chat
                ///////
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "*");
                //
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "   user_update=? " +
                        " AND message IS NOT NULL  ");
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


                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", ПубличноеIDПолученныйИзСервлетаДляUUID);//todo old ПубличноеIDПолученныйИзСервлетаДляUUID
                // TODO: 02.03.2022
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки", " status_write, date_update DESC ");//todo "date_update DESC, status_write DESC"
                ////
                // class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                ////
                //class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
                ///
                Курсор_ГлавныйКурсорДляЗадач = null;
                // TODO: 03.03.2022  глаВНЫЙ КУРСОР ДЛЯ ЗАДАЧ
                Курсор_ГлавныйКурсорДляЗадач = (SQLiteCursor) class_grud_sql_operationsIDпользоввателяДляСлужб.
                        new GetData(getContext()).getdata(class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        new PUBLIC_CONTENT(context).МенеджерПотоков, new CREATE_DATABASE(context).getССылкаНаСозданнуюБазу());
                // TODO: 02.03.2022
                if (Курсор_ГлавныйКурсорДляЗадач.getCount() > 0) {
                    // TODO: 03.03.2022
                    Log.d(this.getClass().getName(), "Курсор_ГлавныйКурсорДляЗадач " + Курсор_ГлавныйКурсорДляЗадач);
                    // TODO: 03.03.2022
                    Курсор_ГлавныйКурсорДляЗадач.moveToFirst();
                }
                ////////
                Log.d(this.getClass().getName(), "Курсор_ГлавныйКурсорДляЗадач " + Курсор_ГлавныйКурсорДляЗадач);

            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
            }
            return Курсор_ГлавныйКурсорДляЗадач;
        }
// TODO: 17.03.2022 ЕЩЕ КУРСОР ДЛЯ СПИНЕРА фио ДЛЯ КОГО СОЗДАНО ЗАДАНИЕ


        // TODO: 04.03.2022  класс в котором находяться слушатели

        @Override
        void МетодСлушательObserverДляRecycleView() {
            // TODO: 04.03.2022
            try {
                // TODO: 04.03.2022 запускаем слушатель

                // TODO: 04.03.2022 запускаем слушатель
                super.МетодСлушательObserverДляRecycleView();
                // TODO: 16.03.2022
                /*     myRecycleViewAdapter.registerAdapterDataObserver(adapterDataObserverObserverСлушатель);*/

            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///
            }
        }

        // TODO: 04.03.2022 второй метод слушатель для курсора
        @Override
        void МетодСлушательObserverДляКурсора() {
            // TODO: 04.03.2022
            try {
                // TODO: 02.03.2022
                dataSetObserverДляКурсора = new DataSetObserver() {
                    @Override
                    public void onChanged() {
                        super.onChanged();
                        // TODO: 14.03.2022
                        try {

                            // TODO: 05.03.2022  ДЛЯ ИНИЗАЛИЗАЦИИ НИЖНИХ КНОПОК
                            МетодИнициализацииRecycleViewДляЗадач();

                            // TODO: 04.03.2022
                            recyclerView.getAdapter().notifyDataSetChanged();
                            // TODO: 04.03.2022
                            recyclerView.getAdapter().notifyItemChanged(0);
                            // TODO: 04.03.2022
                            recyclerView.requestLayout();

                            // TODO: 28.02.2022
                            linearLayou.requestLayout();

                            Log.d(this.getClass().getName(), "onItemRangeMoved  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);

                            /////////////
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }
                        Log.d(this.getClass().getName(), "onChanged ");
                    }

                    @Override
                    public void onInvalidated() {
                        super.onInvalidated();
                        // TODO: 02.03.2022
                        // TODO: 02.03.2022 получения курсора
                        Log.d(this.getClass().getName(), "onInvalidated ");
                    }
                };
                // TODO: 14.03.2022  подписываемся курссор

                Курсор_ГлавныйКурсорДляЗадач.registerDataSetObserver(dataSetObserverДляКурсора);

            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
            }
        }

        // TODO: 04.03.2022 второй метод слушатель для курсора
        @Override
        void МетодСлушательObserverДляКурсораТолькоКоличество() {
            // TODO: 04.03.2022
            try {
                // TODO: 02.03.2022
                dataSetObserverДляКурсораТолькоКоличество = new DataSetObserver() {
                    @Override
                    public void onChanged() {
                        super.onChanged();
                        // TODO: 14.03.2022
                        try {

                            // TODO: 05.03.2022  ДЛЯ ИНИЗАЛИЗАЦИИ НИЖНИХ КНОПОК

                            // TODO: 04.03.2022
                            recyclerView.getAdapter().notifyDataSetChanged();
                            // TODO: 04.03.2022
                            recyclerView.getAdapter().notifyItemChanged(0);

                            // TODO: 04.03.2022
                            recyclerView.requestLayout();

                            Log.d(this.getClass().getName(), "onItemRangeMoved  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);


                            // TODO: 22.03.2022
                            try {
                                linearLayou.removeAllViews();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            // TODO: 28.02.2022
                            linearLayou.requestLayout();
                            /////////////
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }
                        Log.d(this.getClass().getName(), "onChanged ");
                    }

                    @Override
                    public void onInvalidated() {
                        super.onInvalidated();
                        // TODO: 02.03.2022
                        // TODO: 02.03.2022 получения курсора
                        Log.d(this.getClass().getName(), "onInvalidated ");
                    }
                };
                // TODO: 14.03.2022  подписываемся курссор

                Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.registerDataSetObserver(dataSetObserverДляКурсораТолькоКоличество);

            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
            }
        }

        // TODO: 18.10.2021  СИНХРОНИАЗЦИЯ ЧАТА ПО РАСПИСАНИЮ ЧАТ
        @Override
        void МетодСоздаенияСлушателяДляОбщейWorkMAnager() throws ExecutionException, InterruptedException {
            ///
// TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления
            try {
                // TODO: 16.12.2021  --ОДНОРАЗОВАЯ СИНХРОНИАЗЦИЯ СЛУШАТЕЛЬ
                observerОБЩАЯДляWORKMANAGERДляРасписания = new Observer<List<WorkInfo>>() {
                    @Override
                    public void onChanged(List<WorkInfo> workInfoОБШАЯ) {
                        // TODO: 23.2.2021
                        workInfoОБШАЯ.stream()
                                .filter(СтастусWorkMangerДляФрагментаЧитатьИПисать -> СтастусWorkMangerДляФрагментаЧитатьИПисать != null)
                                .filter(СтастусWorkMangerДляФрагментаЧитатьИПисать ->
                                        СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().compareTo(WorkInfo.State.ENQUEUED) == 0)
                                .forEachOrdered((СтастусWorkMangerДляФрагментаЧитатьИПисать) -> {
                                    // TODO: 18.02.2022
                                    try {
                                        // TODO: 14.01.2022
                                        Log.d(this.getClass().getName(), " workInfoОБШАЯ  CallBaskОтWorkManagerОдноразового observerОдноразоваяДляWORKMANAGERДляРасписания/ " +
                                                СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().name());
                                        // TODO: 04.03.2022
                                        Курсор_ГлавныйКурсорДляЗадач.deactivate();
                                        // TODO: 04.03.2022 перезапускаем курсор
                                        Курсор_ГлавныйКурсорДляЗадач.requery();
                                        // TODO: 29.09.2021  конец синхрониазции по раписанию
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        ///метод запись ошибок в таблицу
                                        Log.e(this.getClass().getName(), "Ошибка  Фрагмент Читать и Писать   observerОдноразоваяДляWORKMANAGER = new Observer<List<WorkInfo>>() {" +
                                                " МетодЗапускаСинхрониазцииПоРАсписаниювНезависимостиОтВставкиНовгоСообщения  " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                        new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                                    }
                                });
                    }
                };
                // TODO: 20.02.2022
                if (observerОБЩАЯДляWORKMANAGERДляРасписания != null) {
                    // TODO: 04.03.2022
                    WorkManager.getInstance(getContext()).getWorkInfosByTagLiveData(ИмяСлужбыОбщейСинхронизацииДляЗадачи).observeForever(observerОБЩАЯДляWORKMANAGERДляРасписания);
                }
                // TODO: 29.09.2021  конец синхрониазции по раписанию
                Log.d(this.getClass().getName(), " WorkInfoИнформацияОЗапущенойСлужбеОдноразовая  СтастусWorkMangerЧата " + " CallBaskОтWorkManagerОдноразового " + ИмяСлужбыОбщейСинхронизацииДляЗадачи);
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            }
        }
// TODO: 04.03.2022


        // TODO: 18.10.2021  СИНХРОНИАЗЦИЯ ЧАТА ПО РАСПИСАНИЮ ЧАТ
        @Override
        void МетодСоздаенияСлушателяДляЧатаWorkMAnager() throws ExecutionException, InterruptedException {
// TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления
            try {
                // TODO: 16.12.2021  --ОДНОРАЗОВАЯ СИНХРОНИАЗЦИЯ СЛУШАТЕЛЬ
                observerОдноразоваяДляWORKMANAGERДляРасписанияДполнительнаяОтЧата = new Observer<List<WorkInfo>>() {
                    @Override
                    public void onChanged(List<WorkInfo> workInfosОдноразовая) {
                        // TODO: 23.12.2021
                        workInfosОдноразовая.stream()
                                .filter(СтастусWorkMangerДляФрагментаЧитатьИПисать -> СтастусWorkMangerДляФрагментаЧитатьИПисать != null)
                                .filter(СтастусWorkMangerДляФрагментаЧитатьИПисать ->
                                        СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().compareTo(WorkInfo.State.SUCCEEDED) == 0)
                                .forEachOrdered((СтастусWorkMangerДляФрагментаЧитатьИПисать) -> {
                                    // TODO: 18.02.2022
                                    try {
                                        // TODO: 14.01.2022
                                        Log.d(this.getClass().getName(), " CallBaskОтWorkManagerОдноразового observerОдноразоваяДляWORKMANAGERДляРасписанияДполнительнаяОтЧата " +
                                                СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().name());
                                        // TODO: 04.03.2022
                                        Курсор_ГлавныйКурсорДляЗадач.deactivate();
                                        // TODO: 04.03.2022 перезапускаем курсор
                                        Курсор_ГлавныйКурсорДляЗадач.requery();
                                        // TODO: 29.09.2021  конец синхрониазции по раписанию
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        ///метод запись ошибок в таблицу
                                        Log.e(this.getClass().getName(), "Ошибка  Фрагмент Читать и Писать   observerОдноразоваяДляWORKMANAGER = new Observer<List<WorkInfo>>() {" +
                                                " МетодЗапускаСинхрониазцииПоРАсписаниювНезависимостиОтВставкиНовгоСообщения  " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                        new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                                    }
                                });
                    }
                };
                // TODO: 20.02.2022
                if (observerОдноразоваяДляWORKMANAGERДляРасписанияДполнительнаяОтЧата != null) {
                    // TODO: 04.03.2022
                    WorkManager.getInstance(getContext()).getWorkInfosByTagLiveData(ИмяСлужбыОдноразоваяСинхронизацииДляЗадачиИзЧата).observeForever(observerОдноразоваяДляWORKMANAGERДляРасписанияДполнительнаяОтЧата);
                }
                // TODO: 29.09.2021  конец синхрониазции по раписанию
                Log.d(this.getClass().getName(), " WorkInfoИнформацияОЗапущенойСлужбеОдноразовая  СтастусWorkMangerЧата " + " ИмяСлужбыСинхронизацииДляЗадачиИзЧата " + ИмяСлужбыОдноразоваяСинхронизацииДляЗадачиИзЧата);
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            }
        }


        // TODO: 04.03.2022 прозвомжность инициализации RecycleView
        @Override
        void МетодИнициализацииRecycleViewДляЗадач() {
            try {
                Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  " + Курсор_ГлавныйКурсорДляЗадач);

                Log.d(this.getClass().getName(), " есть данные для отображения " +
                        "отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  Курсор_ГлавныйКурсорДляЗадач  " + Курсор_ГлавныйКурсорДляЗадач);
                // TODO: 28.02.2022
                recyclerView = (RecyclerView) viewДляПервойКнопкиHome_Задания.findViewById(R.id.recycleviewActiviTask);
                // TODO: 14.03.2022
                recyclerView.setVisibility(View.VISIBLE);
                // TODO: 14.03.202
                GridLayoutManager gridLayoutManager;
                // TODO: 14.03.202
                gridLayoutManager = new GridLayoutManager(getActivity(), 1);
                // TODO: 28.02.2022 создаем наш первый RecyclerView
                recyclerView.setLayoutManager(gridLayoutManager);//TODO new LinearLayoutManager(getContext()) // TODO: 28.02.2022 создаем наш первый RecyclerView recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                // TODO: 04.03.2022  В ДАННЫЙ КОД ЗАХОДИМ КОГДА РЕЖИМ РЕДАКТИРОВАНИЯ И МЫ УЖЕ СОЗДАНУЮ АЗАДЧЦ РЕДАКТИРУЕМ

                    // TODO: 04.03.2022  В ДАННЫЙ КОД ЗАХОДИМ КОГДА МЫ СОЗДАЕМ НОВУЮ ЗАДАЧУ

                LinkedBlockingQueue ОчередьДаныеДляСозданиеНовойЗадачи = new LinkedBlockingQueue();

                // TODO: 16.03.2022

                ОчередьДаныеДляСозданиеНовойЗадачи.offer("СоздатьНовуюЗадачу");

                // TODO: 28.02.2022 переходим в создание новой задачи
                myRecycleViewAdapter = new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент3.MyRecycleViewAdapter(ОчередьДаныеДляСозданиеНовойЗадачи);

                // TODO: 04.03.2022  В ДАННЫЙ КОД ЗАХОДИМ КОГДА МЫ СОЗДАЕМ НОВУЮ ЗАДАЧУ

                recyclerView.setAdapter(myRecycleViewAdapter);
                // TODO: 22.03.2022
                // TODO: 04.03.2022
                recyclerView.getAdapter().notifyDataSetChanged();
                // TODO: 04.03.2022
                recyclerView.getAdapter().notifyItemChanged(0);

                Log.d(this.getClass().getName(), " есть данные для отображения " +
                        "отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  Курсор_ГлавныйКурсорДляЗадач  " + Курсор_ГлавныйКурсорДляЗадач + " myRecycleViewAdapterНоваяЗадача " + myRecycleViewAdapter);


                Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 recyclerView   " + recyclerView);

                // TODO: 05.03.2022  СТАТУС ЗНАЧКА С ДОПОЛНИТЕЛЬНЫЙ СТАТУСОМ когнданет записей  МетодИнициализацииRecycleViewДляЗадачМетодИнициализацииRecycleViewДляЗадач

                // TODO: 14.03.2022
                Log.d(this.getClass().getName(), "onItemRangeMoved  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе +
                        " Курсор_ДляПолученияДАнныхДляЗАДАЧTASK " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);

                // TODO: 04.03.2022 создаем слушатель    третий класс создаем класс слушаителй  ДАННЫЙ КОД ЗАПУСКАЕТЬСЯ ПОСЛЕ СОЗДАЕНИЯ И УСТАНОВКИ АДАПТЕРА RECYCLEVIEW

                subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи.МетодСлушательObserverДляRecycleView();

                // TODO: 14.03.2022
                Log.d(this.getClass().getName(), "      subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент2.МетодСлушательObserverДляRecycleView()  МетодИнициализацииRecycleViewДляЗадач()  " +
                        " subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляРедактирования " + subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент3ЗаполенияЗадачиДляСозданияНовойЗадачи);


                /////////////
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            }

        }

        // TODO: 05.03.2022 метод создание кнопок снизу навигатор
        @Override
        void МетодСозданиеНавигаторКнопок() {
            try {
                // TODO: 05.03.2022
                bottomNavigationViewДляTasks.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @SuppressLint("ResourceType")
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        // TODO: 09.03.2022
                        try {

                            // TODO: 09.03.2022
                            fragmentTransactionляЗадачи = fragmentManagerДляЗадачи.beginTransaction();
                            // TODO: 11.03.2022
                            // TODO: 11.03.2022
                            Log.d(this.getClass().getName(), "  bottomNavigationViewДляTasks " + bottomNavigationViewДляTasks + " fragment_ТекущийФрагмент " + fragment_ТекущийФрагмент);
                            // TODO: 09.03.2022 вешаем слушатель на конткеноую кнопку
                            Log.d(this.getClass().getName(), "  item.getItemId() " + item.getItemId());
                            // TODO: 09.03.2022
                            switch (item.getItemId()) {
                                // TODO: 14.03.2022
                                case R.id.id_taskHome:
                                    // TODO: 22.12.2021  запускам втнутерий класс по созданию бизнес логики для даннго активти
                                    Log.d(this.getClass().getName(), " R.id.id_taskHome отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  fragmentTransactionляЗадачи  "
                                            + fragmentTransactionляЗадачи + " R.id.id_taskHome  item.getItemId() " + item.getItemId());
                                    ///
                                    // TODO: 10.03.2022
                                    item.setChecked(true);
                                    // TODO: 09.03.2022
                                    fragment_ТекущийФрагмент = new Fragment1_One_Tasks();
                                    // TODO: 11.03.2022
                                    fragmentTransactionляЗадачи.replace(R.id.activity_main_fisrt_for_tasks, fragment_ТекущийФрагмент).commit();//.layout.activity_for_fragemtb_history_tasks
                                    // TODO: 10.03.2022
                                    fragmentTransactionляЗадачи.show(fragment_ТекущийФрагмент);
                                    // TODO: 10.03.2022
                                    Log.d(this.getClass().getName(), " fragmentTransactionляЗадачи " + fragmentTransactionляЗадачи);
                                    // TODO: 10.03.2022
                                    // TODO: 15.03.2022
                                    // TODO: 09.03.2022
                                    bottomNavigationViewДляTasks.requestLayout();
                                    // TODO: 14.03.2022
                                    linearLayou.requestLayout();
                                    Log.d(this.getClass().getName(), " bottomNavigationViewДляTasks.getChildCount() " + bottomNavigationViewДляTasks.getChildCount());
                                    break;

                                // TODO: 09.03.2022////

                                case R.id.id_taskCreateNewTasks:
                                    // TODO: 09.03.2022
                                    Log.d(this.getClass().getName(), " R.id.id_taskCreateNewTasks  item.getItemId() " + item.getItemId());
                                    // TODO: 10.03.2022
                                    item.setChecked(true);
                                    // TODO: 09.03.2022
                                    fragment_ТекущийФрагмент = new Fragment2_Create_Tasks();
                                    // TODO: 11.03.2022
                                    fragmentTransactionляЗадачи.replace(R.id.activity_main_fisrt_for_tasks, fragment_ТекущийФрагмент).commit();//.layout.activity_for_fragemtb_history_tasks
                                    // TODO: 10.03.2022
                                    fragmentTransactionляЗадачи.show(fragment_ТекущийФрагмент);
                                    // TODO: 10.03.2022
                                    Log.d(this.getClass().getName(), " fragmentTransactionляЗадачи " + fragmentTransactionляЗадачи);
                                    // TODO: 10.03.2022
                                    // TODO: 14.03.2022
                                    bottomNavigationViewДляTasks.requestLayout();
                                    // TODO: 14.03.2022
                                    linearLayou.requestLayout();
                                    Log.d(this.getClass().getName(), " bottomNavigationViewДляTasks.getChildCount() " + bottomNavigationViewДляTasks.getChildCount());

                                    // TODO: 14.03.2022  дополнительно визуализируем


                                    break;
                                // TODO: 09.03.2022////
                                default:
                                    // TODO: 09.03.2022
                                    // TODO: 09.03.2022
                                    Log.d(this.getClass().getName(), "  никакой не выбрали  item.getItemId() ");
                                    return false;
                            }
                            // TODO: 09.03.2022
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                            ///
                        }
                        return true;
                    }
                });
                /////////////
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            }
        }

        // TODO: 14.03.2022
        // TODO: 14.03.2022

        private void МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(@NonNull Cursor cursorДЛяОпределенияНужноПоказыватьЗначеиЛИнЕТ)
                throws ExecutionException, InterruptedException {
            // TODO: 02.03.2022
            try {
                // TODO: 02.03.2022
                Log.d(this.getClass().getName(), "  cursorДЛяОпределенияНужноПоказыватьЗначеиЛИнЕТ " + cursorДЛяОпределенияНужноПоказыватьЗначеиЛИнЕТ);
                // TODO: 09.03.2022
                if (cursorДЛяОпределенияНужноПоказыватьЗначеиЛИнЕТ.getCount() > 0) {
                    // TODO: 06.03.2022
                    bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskCreateNewTasks).setVisible(true);//.getOrCreateBadge(R.id.id_taskHome).setVisible(true); R.id.id_taskHome todo R.id.id_taskCreateNewTasks
                    // TODO: 06.03.2022
                    bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskCreateNewTasks).setNumber(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount());//.getOrCreateBadge(R.id.id_taskHome).setVisible(true);
                    // TODO: 09.03.2022
                    bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskCreateNewTasks).setBackgroundColor(Color.parseColor("#8B0000"));
                    // TODO: 06.03.2022
                    Log.d(this.getClass().getName(), "  bottomNavigationViewДляTasks " + bottomNavigationViewДляTasks +
                            "  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount()   " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount());
                    // TODO: 05.03.2022
                } else {
                    // TODO: 06.03.2022
                    bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskCreateNewTasks).setVisible(false);//.getOrCreateBadge(R.id.id_taskHome).setVisible(true);
                    // TODO: 09.03.2022
                    bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskCreateNewTasks).setNumber(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount());
                    // TODO: 10.03.2022
                    bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskCreateNewTasks).setBackgroundColor(Color.BLACK);
                }
                Log.d(this.getClass().getName(), "  bottomNavigationViewДляTasks " + bottomNavigationViewДляTasks +
                        "  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount()   " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);
                // TODO: 13.03.2022
                bottomNavigationViewДляTasks.requestLayout();
                // TODO: 13.03.2022
                bottomNavigationViewДляTasks.requestApplyInsets();
                // TODO: 14.03.2022
                linearLayou.requestLayout();
                /////////////
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            }
        }

        // TODO: 23.03.2022  метод получения сколько созданных

        // TODO: 14.03.2022
        @Override
        protected SQLiteCursor МетодПолученимТОлькоКоличествоЗадач(Integer ПубличноеIDПолученныйИзСервлетаДляUUID) throws ExecutionException, InterruptedException {
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
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "   user_update=? AND status_write<>? " +
                        " AND message IS NOT NULL  ");
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

                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2", 5);
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


        // TODO: 15.03.2022  перенесееный код
        // TODO: 28.02.2022 начало  MyViewHolder
        protected class MyViewHolder extends RecyclerView.ViewHolder {// TODO: 28.02.2022 начало  MyViewHolder
            // TODO: 28.02.2022
            TextInputEditText textView1, textView3, textView5;
            // TODO: 17.03.2022
            // TODO: 28.02.2022
            TextView textView2;
            // TODO: 13.03.2022
            MaterialCardView materialCardView;
            // TODO: 16.03.202
            Button buttonДляСозданиеНовогоЗадания;
            // TODO: 02.03.2022
            Spinner spinnerДляСозданиеНовойЗадачи;
            // TODO: 18.03.2022
            SeekBar seekBarДляВЫбораКакаяЗадачаВыполяется;
            // TODO: 18.03.2022
            TextView textView7;
            // TODO: 21.03.2022
            Bundle bundleЗначенияДляНовойЗадачи;
            // TODO: 21.03.2022


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                // TODO: 02.03.2022
                МетодИнициализацииКомпонетовЗаданияCardView(itemView);
                // TODO: 01.03.2022
                Log.d(this.getClass().getName(), "  private class MyViewHolder extends RecyclerView.ViewHolder  itemView   " + itemView);
            }

            // TODO: 14.03.2022

            private void МетодИнициализацииКомпонетовЗаданияCardView(@NonNull View itemView) {
                // TODO: 28.02.2022
                try {
                    // TODO: 01.03.2022 Инициализации компонтов
                    Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 itemView   " + itemView);
                    // TODO: 02.03.2022
                    textView1 = (TextInputEditText) itemView.findViewById(R.id.text1_innercardview);
                    // TODO: 02.3.2022  дополнительный
                    textView2 = (TextView) itemView.findViewById(R.id.text2_innercardviewtwo);
                    // TODO: 28.02.2022
                    textView3 = (TextInputEditText) itemView.findViewById(R.id.text3_innercardviewtree);
                    // TODO: 28.02.2022
                    spinnerДляСозданиеНовойЗадачи = (Spinner) itemView.findViewById(R.id.Spinner_innercardviewfour);
                    // TODO: 28.02.2022
                    // TODO: 13.03.2022
                    Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 materialCardView  textView2 " + spinnerДляСозданиеНовойЗадачи);
                    // TODO: 01.03.2022
                    materialCardView = (MaterialCardView) itemView.findViewById(R.id.cardviewmatirealtask);
                    // TODO: 13.03.2022
                    buttonДляСозданиеНовогоЗадания = (Button) itemView.findViewById(R.id.BottomFor_New_Create_Task);

                    // TODO: 16.03.2022
                    buttonДляСозданиеНовогоЗадания.setBackgroundResource(R.drawable.style_for_task_new_create_save);
                    // TODO: 18.03.2022

                    seekBarДляВЫбораКакаяЗадачаВыполяется = (SeekBar) itemView.findViewById(R.id.seekBar_for_tasks_create_new);
                    // TODO: 18.03.2022
                    textView7 = (TextView) itemView.findViewById(R.id.text2_innercardviewtwoSettasksType);
                    // TODO: 21.03.2022
                    bundleЗначенияДляНовойЗадачи = new Bundle();


                    Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 materialCardView   " + materialCardView);
                    // TODO: 01.03.2022*/
                    ///////
                } catch (Exception e) {
                    //  Block of code to handle errors
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                            + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    // TODO: 01.09.2021 метод вызова
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                            this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                            Thread.currentThread().getStackTrace()[2].getLineNumber());
                }
                /////
            }
        } // TODO: 28.02.2022 конец  MyViewHolder
        // TODO: 28.02.2022 конец  MyViewHolder


        // TODO: 28.02.2022 ViewHolder


        // TODO: 16.03.2022


        class MyRecycleViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
            // TODO: 04.03.2022
            LinkedBlockingQueue ОчередьДаныеДляСозданиеНовойЗадачи;

            // TODO: 15.03.2022 первыЙ КЛАССС ДЛЯ АДАПТЕРА С ДАННЫМИ ПОДНИМАЕМ ДАННЫЕ ДЛЯ РЕДАКТИРОВАНИЯ
            public MyRecycleViewAdapter(@NotNull LinkedBlockingQueue ОчередьДаныеДляСозданиеНовойЗадачи) {
                // super();
                // TODO: 04.03.2022
                this.ОчередьДаныеДляСозданиеНовойЗадачи = ОчередьДаныеДляСозданиеНовойЗадачи;

                Log.i(this.getClass().getName(), "     getItemId holder.position " + "  ОчередьДаныеДляСозданиеНовойЗадачи " + ОчередьДаныеДляСозданиеНовойЗадачи);
            }


            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                // TODO: 10.03.2022
                View viewГлавныйВидДляRecyclleViewДляЗаданий = null;
                try {
                    // TODO: 28.02.2022
                    viewГлавныйВидДляRecyclleViewДляЗаданий = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_for_new_takst_cardview3, parent, false);//todo old simple_for_new_takst_cardview3       R.layout.simple_for_takst_cardview1
                    // TODO: 05.03.2022
                    Log.i(this.getClass().getName(), "   viewГлавныйВидДляRecyclleViewДляЗаданий" + viewГлавныйВидДляRecyclleViewДляЗаданий);
                    // TODO: 28.02.2022

                    // TODO: 22.03.2022
                        myViewHolder = new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент3.MyViewHolder(viewГлавныйВидДляRecyclleViewДляЗаданий);

                    // TODO: 01.03.2022
                    Log.i(this.getClass().getName(), "   myViewHolder" + myViewHolder);
// TODO: 01.03.2022
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
                return myViewHolder;

            }


            // TODO: 16.03.2022  перегруженный метод ДЛЯ СОЗДАНЕИ НОВОЙ ЗАДАЧИ И ВСЕ !!!!! 
            // TODO: 16.03.2022  перегруженный метод ДЛЯ СОЗДАНЕИ НОВОЙ ЗАДАЧИ И ВСЕ !!!!! 
            // TODO: 16.03.2022  перегруженный метод ДЛЯ СОЗДАНЕИ НОВОЙ ЗАДАЧИ И ВСЕ !!!!! 

            @Override
            public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                // TODO: 28.02.2022 привазяваем данные из колекции пряме на наш recycreview
                try {
                    // TODO: 14.03.2022

                    // TODO: 02.03.2022 тут РАЗДАЕМ ДАННЫЕ RECYCLERBIEW
                    ;
                    // TODO: 04.03.2022 p==osion
                    Log.i(this.getClass().getName(), "   ОчередьДаныеДляСозданиеНовойЗадачи.peek() " + ОчередьДаныеДляСозданиеНовойЗадачи.peek());


                    // TODO: 14.03.2022  метод создания само сообщения
                    МетодБиндингаСозданиеСамоСообщения(holder);


                    // TODO: 14.03.2022  метод создания номер задания
                    МетодБиндингаНомерЗадания(holder);


                    // TODO: 14.03.2022  метод создания spinnerДляСозданиеНовойЗадачи
                    МетодБиндингаДелаемСлушательДляSpinnerЗадания(holder);

                    // TODO: 14.03.2022  метод создания spinnerДляСозданиеНовойЗадачи
                    МетодБиндингаДатаЗадания(holder);


                    // TODO: 14.03.2022  метод создания ФИО задания
                    МетодБиндингаФИОДляЗадания(holder);


                    // TODO: 13.03.2022 СЛУШАТЕЛЬ для ДОЛГОВО НАЖАТИЯ СМЕНЫ СТАТУСА

                    МетодБиндингаСлушателейДляViewCard(holder);


                    // TODO: 13.03.2022 СЛУШАТЕЛЬ СРАБАТЫВАЕТ КОГДА КОМАДА TOGGER И МЕНЯЕМ СТАТУСТ ЧЕК ОЗНАКОМЛЕНЫЙ ЛИ ИНЕТ

                    МетодБиндингаСлушательisChered(holder);


                    // TODO: 16.03.2022  метод для слушателя для создания данных 
                    МетодБиндингаСлушательДляКнопкиСоздатьНовуюЗадачу(holder);


                    // TODO: 03.03.2022 ПОЛУЧАЕМ СТАТУС ЗАДАНИЯ ПРОЧИТАН ИЛИ НЕТ

                    Integer СамСтатусПрочтенияИлиНет = МетодБиндингаПолученияСтатусаЗадачи(holder);


                    // TODO: 02.03.2022#5  получаем ТИП ЗАДАЧИ
                    МетодБиндингПолучаемТипЗадания(holder);


                    // TODO: 02.03.2022#5  заполем ДАННЫМИ BUNGLE САМОЙ ЗАДАЧИ//

                    МетодБиндингаЗаполненияДаннымиBungle(holder, СамСтатусПрочтенияИлиНет);

                    Log.i(this.getClass().getName(), "      holder.textView1  accessibilityNodeInfo " + BungleДанныеДляViewCard + " СамСтатусПрочтенияИлиНет " + СамСтатусПрочтенияИлиНет);


                    МетодБиндингаДелаемСлушательДляSeedBars(holder);

                    Log.i(this.getClass().getName(), "      МетодБиндингаДелаемСлушательДляSeedBars  holder.seekBarДляВЫбораКакаяЗадачаВыполяется  " + holder.seekBarДляВЫбораКакаяЗадачаВыполяется);


                    // TODO: 13.03.2022 настройки для carview КОНЕЦ ВЫЗЫВАЕМЫХ МЕТОДОВ вызывает событие клика на самой cardview 

                    holder.materialCardView.toggle();

                    // TODO: 13.03.2022
                    holder.materialCardView.setChecked(true);
                    // TODO: 15.03.2022
                    // TODO: 15.03.2022
                    holder.materialCardView.setCardBackgroundColor(Color.parseColor("#FFFAFA"));

// TODO: 28.02.2022

                    // TODO: 09.03.2022

                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
            }


            private void МетодБиндингаЗаполненияДаннымиBungle(@NonNull MyViewHolder holder, Integer СамСтатусПрочтенияИлиНет) {
                // TODO: 03.03.2022
                try {


                    Log.i(this.getClass().getName(), "  BungleДанныеДляViewCard   " + BungleДанныеДляViewCard.getBundle(String.valueOf(holder.materialCardView.getId())));

                    // TODO: 13.03.2022  передаем статус задачи


                    // TODO: 03.03.2022 передаем помер позиции position
                    holder.materialCardView.setTag(holder.materialCardView.getId(), СамСтатусПрочтенияИлиНет);

                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
                // TODO: 03.03.2022 передаем помер позиции position
            }

            private void МетодБиндингПолучаемТипЗадания(@NonNull MyViewHolder holder) {

                try {
                    holder.textView5.setText("тип: ");
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
            }

            @NonNull

            private Integer МетодБиндингаПолученияСтатусаЗадачи(@NonNull MyViewHolder holder) {
                // TODO: 02.03.2022#5
                Integer СамСтатусПрочтенияИлиНет = 0;
                try {
                    // TODO: 03.03.2022

                    holder.textView1.setTag(СамСтатусПрочтенияИлиНет);


                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
                // TODO: 01.03.2022 уставнока дополнительный данныых
                return СамСтатусПрочтенияИлиНет;
            }


            private void МетодБиндингаФИОДляЗадания(@NonNull MyViewHolder holder) throws ExecutionException, InterruptedException {
                try {
                    // TODO: 02.03.2022#4  // TODO: 02.03.2022#4 // TODO: 02.03.2022#4 // TODO: 02.03.2022#4 // TODO: 02.03.2022#4 // TODO: 02.03.2022#4 // TODO: 02.03.2022#4 // TODO: 02.03.2022#4
                    Integer ПозицияДанныхВSpinner = 0;
                    // TODO: 02.03.2022
                    Log.i(this.getClass().getName(), "  КтоНаписалСообщениеФИОдЛПосика ");
                    // TODO: 02.03.2022
                    String ФИОКотоНаписал = new String();
                    // TODO: 13.03.2022
                    SQLiteCursor sqLiteCursorПолученимНАстоящийФИО = МетодПолучениеДанныхФИОаОснованииID(1);//КтоНаписалСообщениеФИОдЛПосика
                    // TODO: 02.03.2022
                    Log.i(this.getClass().getName(), "  sqLiteCursorПолученимНАстоящийФИО " + sqLiteCursorПолученимНАстоящийФИО);
                    // TODO: 02.03.2022
                    if (sqLiteCursorПолученимНАстоящийФИО.getCount() > 0) {
                        // TODO: 02.03.2022
                        sqLiteCursorПолученимНАстоящийФИО.moveToFirst();
                        // TODO: 02.03.2022
                        Integer ИндексПолученогоФИО = sqLiteCursorПолученимНАстоящийФИО.getColumnIndex("name");
                        // TODO: 13.03.2022
                        ФИОКотоНаписал = sqLiteCursorПолученимНАстоящийФИО.getString(ИндексПолученогоФИО);
                        // TODO: 13.03.2022
                        // TODO: 02.03.2022
                        Log.i(this.getClass().getName(), "  ФИОКотоНаписал " + ФИОКотоНаписал);
                    }
                    // TODO: 09.03.2022
                    sqLiteCursorПолученимНАстоящийФИО.close();
                    // TODO: 02.03.2022
                    Log.i(this.getClass().getName(), "  ФИОКотоНаписал " + ФИОКотоНаписал);
                    // TODO: 28.02.2022

// TODO: 28.02.2022
                    holder.textView3.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
            }


            @Override
            public int getItemViewType(int position) {
                return super.getItemViewType(position);
            }

            // TODO: 17.03.2022  получаем данные для спинера
            private void МетодБиндингаДатаЗадания(@NonNull MyViewHolder holder) throws ParseException {
                try {
                    // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3


                    SQLiteCursor sqLiteCursorПолученныйФИОДЛЯSpinnerДляНовойЗадачи = null;
                    // TODO: 17.03.2022
                    sqLiteCursorПолученныйФИОДЛЯSpinnerДляНовойЗадачи = new КлассАдаптерДляСпинера(getContext()).МетодПолучаемГлавныеДанныеДляSpinnerКомуЗадачаФИО();

///TODO ГЛАВНЫЙ АДАПТЕР чата
                    SimpleCursorAdapter АдаптерДляФИОПриСозданииНовойЗадачи = new SimpleCursorAdapter(getContext(), android.R.layout.simple_spinner_item, sqLiteCursorПолученныйФИОДЛЯSpinnerДляНовойЗадачи,
                            new String[]{"name"},
                            new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

                    // TODO: 17.03.2022
                    SimpleCursorAdapter.ViewBinder БиндингДляSpinnerФИОСозданиеНовойЗадачи = new SimpleCursorAdapter.ViewBinder() {
                        @Override
                        public boolean setViewValue(View view, Cursor cursor, int columnIndex) {

                            // TODO: 18.03.2022  получаем ФИО людей для кого задание

                            String ФИОДляПОиска = null;
                            if (columnIndex == cursor.getColumnIndex("name")) {
                                // TODO: 21.03.2022
                                int ИндексФИО = cursor.getColumnIndex("name");

                                ФИОДляПОиска = cursor.getString(ИндексФИО);
                                ////
                                Log.d(this.getClass().getName(), " ФИОДляПОиска  " + ФИОДляПОиска);
                            }

                            // TODO: 18.03.2022  получаем ПУБЛИЧНЫЙ ID длявыбранных ФИО

                            int ИндексПубличныIdДляВыбранныхФИО = cursor.getColumnIndex("_id");

                            Long ПубличныIdДляВыбранныхФИО = cursor.getLong(ИндексПубличныIdДляВыбранныхФИО);
                            ////
                            Log.d(this.getClass().getName(), " ПубличныIdДляВыбранныхФИО  " + ПубличныIdДляВыбранныхФИО);

                            Drawable icon = null;
                            //

                            icon = getResources().getDrawable(R.drawable.icon_dsu1_create_peplefio_tasks);///

                            icon.setBounds(1, 1, 60, 60);

                            ((TextView) view).setPadding(0, 0, 0, 0);

                            ((TextView) view).setCompoundDrawables(icon, null, null, null);

                            Log.d(this.getClass().getName(), " ФИОДляПОиска  " + ФИОДляПОиска +
                                    "    ((TextView) view).getHint() " + ((TextView) view).getHint());
                            // TODO: 18.03.2022  сам слушатель


                            ((TextView) view).setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);


                            if (holder.spinnerДляСозданиеНовойЗадачи.getChildAt(0) != null) {
                                // TODO: 18.03.2022

                                // TODO: 18.03.2022
                                Log.d(this.getClass().getName(), " ФИОДляПОиска  " + ФИОДляПОиска +
                                        "    ((TextView) view).getHint() " + ((TextView) view).getHint() + "         View bb =holder.spinnerДляСозданиеНовойЗадачи.getChildAt(0); " +
                                        holder.spinnerДляСозданиеНовойЗадачи.getChildAt(0).isSelected() + " holder.spinnerДляСозданиеНовойЗадачи.getChildAt(0).isContextClickable() "
                                        + holder.spinnerДляСозданиеНовойЗадачи.getChildAt(0).isPressed() + " position " + holder.spinnerДляСозданиеНовойЗадачи.getChildAt(0).isFocused());

                                ((TextView) view).setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                                // TODO: 17.03.2022 ЗАПОЯЕМ ЗАДАЧУ фио и id на каждого
                                ((TextView) view).setText(ФИОДляПОиска.trim());
                                // TODO: 17.03.2022
                                ((TextView) view).setTextSize(14f);
                                // TODO: 18.03.2022
                                ((TextView) view).setTag(ПубличныIdДляВыбранныхФИО);
                                // TODO: 18.03.2022
                                accessibilityNodeInfoДополнительныеДанные = view.createAccessibilityNodeInfo();

                                // TODO: 21.03.2022

                                // TODO: 18.03.2022
                                accessibilityNodeInfoДополнительныеДанные.setContentDescription(String.valueOf(ПубличныIdДляВыбранныхФИО));
                                // TODO: 18.03.2022
                                Log.d(this.getClass().getName(), " ФИОДляПОиска  " + ФИОДляПОиска + " ПубличныIdДляВыбранныхФИО " + ПубличныIdДляВыбранныхФИО + " view " + view.getTag() +
                                        " АдаптерДляФИОПриСозданииНовойЗадачи " + "     holder.spinnerДляСозданиеНовойЗадачи.getSelectedItemPosition() " + holder.spinnerДляСозданиеНовойЗадачи.getSelectedItemPosition());
                                Log.d(this.getClass().getName(), " ФИОДляПОиска  " + ФИОДляПОиска + " ПубличныIdДляВыбранныхФИО " + ПубличныIdДляВыбранныхФИО + " view " + view.getTag() +
                                        " АдаптерДляФИОПриСозданииНовойЗадачи " + "     holder.spinnerДляСозданиеНовойЗадачи.getSelectedItemPosition() " + holder.spinnerДляСозданиеНовойЗадачи.getSelectedItemPosition() +
                                        " accessibilityNodeInfoДополнительныеДанные " + accessibilityNodeInfoДополнительныеДанные);


                            } else {
                                // TODO: 18.03.2022
                                //((TextView) view).setText("");
                                // TODO: 18.03.2022
                                ((TextView) view).setHint("Кому задание ?");
                                ((TextView) view).setTextSize(15f);
                            }
                            // TODO: 18.03.2022
                            return true;
                        }

                        // TODO: 18.03.2022  перенессыц код


                    };
                    // TODO: 17.03.2022
                    АдаптерДляФИОПриСозданииНовойЗадачи.setViewBinder(БиндингДляSpinnerФИОСозданиеНовойЗадачи);
                    // TODO: 28.02.2022
                    holder.spinnerДляСозданиеНовойЗадачи.setAdapter(АдаптерДляФИОПриСозданииНовойЗадачи);
                    // TODO: 17.03.2022
                    Log.e(this.getClass().getName(), "АдаптерДляФИОПриСозданииНовойЗадачи  ");

                    // TODO: 17.03.2022
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
            }


            // TODO: 18.03.2022  метод делаем слушатель на spinner

            void МетодБиндингаДелаемСлушательДляSpinnerЗадания(@NonNull MyViewHolder holder) throws ParseException {
                try {
                    // TODO: 18.03.2022
                    Log.e(this.getClass().getName(), "МетодБиндингаДелаемСлушательДляSpinnerЗадания  ");
                    //
                    holder.spinnerДляСозданиеНовойЗадачи.setHorizontalScrollBarEnabled(true);
                    // TODO: 18.03.2022  сам слушатель
                    holder.spinnerДляСозданиеНовойЗадачи.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            // TODO: 18.03.2022
                            view.setSelected(true);

                            ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                            // TODO: 18.03.2022

                            // TODO: 18.03.2022

               /*             if (position == 0) {
                                //((TextView) parent.getChildAt(0)).setText("");
                                // TODO: 18.03.2022
                                ((TextView) parent.getChildAt(0)).setHint("Кому задание ?");
                                // TODO: 18.03.2022
                                ((TextView) parent.getChildAt(0)).setTextSize(15f);
                                // TODO: 18.03.2022
                                // TODO: 17.03.2022
                                Log.w(this.getClass().getName(), "АдаптерДляФИОПриСозданииНовойЗадачи position  " + position + " id " + id + " view " + view);
                            } else {

                                view.setSelected(true);
                                // TODO: 18.03.2022
                                Object string = holder.spinnerДляСозданиеНовойЗадачи.getItemAtPosition(position);

                                // TODO: 17.03.2022
                                Log.w(this.getClass().getName(), "АдаптерДляФИОПриСозданииНовойЗадачи  " + string + "  position " + position + " id " + id + " view " + view);
                            }*/

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            Log.w(this.getClass().getName(), "АдаптерДляФИОПриСозданииНовойЗадачи  ");
                        }
                    });
                    // TODO: 18.03.2022
                    // TODO: 17.03.2022
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
            }
            // TODO: 18.03.2022  метод СОДАЕМ СЛУШАТЕЛЬ ДЛЯ ВЫБОРА ПЕРИОДА ЗАДАЧА SEELBAR

            void МетодБиндингаДелаемСлушательДляSeedBars(@NonNull MyViewHolder holder) throws ParseException {
                try {
                    // TODO: 18.03.2022
                    Log.e(this.getClass().getName(), "МетодБиндингаДелаемСлушательДляSeedBars  ");
                    //

                    // TODO: 18.03.2022  сам слушатель  SeekBar

                    holder.seekBarДляВЫбораКакаяЗадачаВыполяется.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            Log.w(this.getClass().getName(), "setOnSeekBarChangeListener  ");
                            // TODO: 18.03.2022
                            // TODO: 10.03.2022

                            // TODO: 18.03.2022
                            seekBar.incrementSecondaryProgressBy(progress);
                            // TODO: 18.03.2022
                            seekBar.setIndeterminate(true);

                            String[] ЗадачиДЛяВЫбора = new String[]{"Одноразовая", "Раз в час", "Раз в сутки", "Раз в неделю", "Раз в месяц"};

                            // TODO: 18.03.2022

                            switch (progress) {
                                // TODO: 18.03.2022
                                case 0:
                                    // TODO: 18.03.2022
                                    holder.textView7.setText("выберете тип задачи");
                                    // TODO: 18.03.2022
                                    Log.w(this.getClass().getName(), "string[0]   " + ЗадачиДЛяВЫбора[0].trim());
// TODO: 18.03.2022
                                    seekBar.setIndeterminate(false);
                                    break;
                                case 1:
                                    // TODO: 18.03.2022
                                    holder.textView7.setText(ЗадачиДЛяВЫбора[0]);
                                    // TODO: 18.03.2022
                                    Log.w(this.getClass().getName(), "string[0]   " + ЗадачиДЛяВЫбора[0].trim());
// TODO: 18.03.2022
                                    seekBar.setIndeterminate(false);
                                    break;
                                case 2:
                                    // TODO: 18.03.2022
                                    holder.textView7.setText(ЗадачиДЛяВЫбора[1]);
                                    // TODO: 18.03.2022
                                    Log.w(this.getClass().getName(), "string[1]   " + ЗадачиДЛяВЫбора[1].trim());
                                    // TODO: 18.03.2022
                                    seekBar.setIndeterminate(false);
                                    break;
                                case 3:
                                    // TODO: 18.03.2022
                                    holder.textView7.setText(ЗадачиДЛяВЫбора[2]);
                                    // TODO: 18.03.2022
                                    Log.w(this.getClass().getName(), "string[2]   " + ЗадачиДЛяВЫбора[2].trim());
                                    // TODO: 18.03.2022
                                    seekBar.setIndeterminate(false);
                                    break;
                                case 4:
                                    // TODO: 18.03.2022
                                    holder.textView7.setText(ЗадачиДЛяВЫбора[3]);
                                    // TODO: 18.03.2022
                                    Log.w(this.getClass().getName(), "string[3]   " + ЗадачиДЛяВЫбора[3].trim());
                                    // TODO: 18.03.2022
                                    seekBar.setIndeterminate(false);
                                    break;
                                case 5:
                                    // TODO: 18.03.2022
                                    holder.textView7.setText(ЗадачиДЛяВЫбора[4]);
                                    // TODO: 18.03.2022
                                    Log.w(this.getClass().getName(), "string[4]   " + ЗадачиДЛяВЫбора[4].trim());
                                    // TODO: 18.03.2022
                                    seekBar.setIndeterminate(false);
                                    break;
                                // TODO: 18.03.2022
                                default:
                                    break;
                            }


                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                            Log.w(this.getClass().getName(), "onStartTrackingTouch  ");
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                            Log.w(this.getClass().getName(), "onStopTrackingTouch  ");
                        }
                    });
                    // TODO: 18.03.2022  второй слушатель

                    holder.seekBarДляВЫбораКакаяЗадачаВыполяется.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                        @Override
                        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                            Log.w(this.getClass().getName(), "onScrollChange  ");

                        }
                    });


                    // TODO: 18.03.2022
                    // TODO: 17.03.2022
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
            }

            private void МетодБиндингаНомерЗадания(@NonNull MyViewHolder holder) {
                try {
                    // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2

                    // TODO: 02.03.2022
                    Log.i(this.getClass().getName(), "  IDЗадачиТекущей ");
                    // TODO: 17.03.2022
                    if (Курсор_ГлавныйКурсорДляЗадач.getCount() > 0) {
                        int результатСколькоЗадачЯУжеСоздал = Курсор_ГлавныйКурсорДляЗадач.getCount();
                        // TODO: 17.03.2022
                        результатСколькоЗадачЯУжеСоздал = результатСколькоЗадачЯУжеСоздал + 1;
                        // TODO: 28.02.2022
                        holder.textView2.setText("#" + результатСколькоЗадачЯУжеСоздал++);//IDЗадачиТекущей
                    } else {
                        // TODO: 28.02.2022
                        holder.textView2.setText("#" + 1);//IDЗадачиТекущей
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
            }

            private void МетодБиндингаСозданиеСамоСообщения(@NonNull MyViewHolder holder) {

                try {
                    // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1
                    // TODO: 02.03.2022
                    Log.i(this.getClass().getName(), "  СамогоСообщенияЗадачиДляПользователя ");
                    // TODO: 28.02.2022
                    holder.textView1.setText("");//СамогоСообщенияЗадачиДляПользователя
                    // TODO: 28.02.2022
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }

            }


            // TODO: 13.03.2022


            private void МетодБиндингаСлушателейДляViewCard(MyViewHolder holder) {
                // TODO: 01.03.2022 слушатели

                try {

// TODO: 01.03.2022 слушатели

                    holder.materialCardView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            // TODO: 01.03.2022
                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1   ПозицияЭлментаVIewCardДополнительно  " +
                                    " holder.getAdapterPosition() " + holder.getAdapterPosition() + " v.getTag() " + v.getTag(holder.materialCardView.getId()));

                            // TODO: 13.03.2022  статус прочтения ли уде или нет адание

                            Object СтатусПрочтеаУжеЗадачаИлиНет = v.getTag(holder.materialCardView.getId());//TODO holder.materialCardView.getId()

                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1   ПозицияЭлментаVIewCardДополнительно  СтатусПрочтеаУжеЗадачаИлиНет " + СтатусПрочтеаУжеЗадачаИлиНет);
                            // TODO: 04.03.2022  ПОЛУЧЕНИЕ НАЗВАНЕИ ЗАДАЧИ
                     /*   Long ПолучаемUUIDТекущйПозицииВRecyreView = AccessibilityNodeInfoДанныеДляViewCard.getAvailableExtraData().stream().map(Long::new)
                                .distinct() .sorted(Collections.reverseOrder()).collect(Collectors.toList()).get(holder.getAdapterPosition()).longValue();*/

                            // TODO: 13.03.2022
                            Long ПолучаемUUIDТекущйПозицииВRecyreView = BungleДанныеДляViewCard.getLong((String.valueOf(holder.getAdapterPosition())), 0l);


                            Log.i(this.getClass().getName(), "  BungleДанныеДляViewCard   " + BungleДанныеДляViewCard.getLong((String.valueOf(holder.getAdapterPosition())), 0l) +
                                    " ПолучаемUUIDТекущйПозицииВRecyreView " + ПолучаемUUIDТекущйПозицииВRecyreView);


// TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  СтатусПрочтеаУжеЗадачаИлиНет " + СтатусПрочтеаУжеЗадачаИлиНет
                                    + " ПолучаемUUIDТекущйПозицииВRecyreView " + ПолучаемUUIDТекущйПозицииВRecyreView);


                            // TODO: 03.03.2022  запускам сменты статуса

                         /*   if (Integer.parseInt(String.valueOf(СтатусПрочтеаУжеЗадачаИлиНет)) == 0 && ПолучаемUUIDТекущйПозицииВRecyreView != null) {

                                ///
                                String ИмяСлужбыУведомленияДляЧата = "WorkManager NOtofocationForTasks";

                                String PROCESS_ID_УведомленияПлановая = "12";

                                // TODO: 03.03.2022

                                SubClass_Starting_chahge_status_public_task_Класс_ДляЗадач subClass_starting_chahge_status_public_notificaton =
                                        new SubClass_Starting_chahge_status_public_task_Класс_ДляЗадач(getContext());

                                // TODO: 03.03.2022 определяем кода для отложеного запуска службы смены статсу условия задачи
                                PendingIntent ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием = subClass_starting_chahge_status_public_notificaton.
                                        МетодЗапускаСменыСтатусаСлужбыЧерезPendingIntent(PROCESS_ID_УведомленияПлановая, ИмяСлужбыУведомленияДляЧата, String.valueOf(ПолучаемUUIDТекущйПозицииВRecyreView));


                                try {

                                    // TODO: 03.03.2022  запускаем службу смены статуса
                                    ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием.send();


                                } catch (PendingIntent.CanceledException e) {
                                    e.printStackTrace();
                                }
                                ///////TODO запускаем смены стануса задачи черезе PendingIntent
                                Log.d(getContext().getClass().getName(), "PROCESS_ID_УведомленияПлановая " + PROCESS_ID_УведомленияПлановая +
                                        " ИмяСлужбыУведомленияДляЧата " + ИмяСлужбыУведомленияДляЧата + " СтатусПрочтеаУжеЗадачаИлиНет " + СтатусПрочтеаУжеЗадачаИлиНет);


                                // TODO: 03.03.2022 update screewn
                                Handler handlerЗапускаемОтсрочнуюСменуСтатуса = new Handler();
                                // TODO: 04.03.2022
                                handlerЗапускаемОтсрочнуюСменуСтатуса.postDelayed(() -> {
                                    // TODO: 04.03.2022

                                    Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.deactivate();
                                    // TODO: 03.03.2022

                                    Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.requery();
                                    // TODO: 13.03.2022

                                    Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.deactivate();
                                    // TODO: 14.03.2022
                                    Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.requery();

                                    // TODO: 13.03.2022
                                    notifyDataSetChanged();

                           *//*     Log.i(getContext().getClass().getName(), "СтатусПрочтеаУжеЗадачаИлиНет Статус Уже Изменен на 0 " + СтатусПрочтеаУжеЗадачаИлиНет);

                                Toast.makeText(getActivity(), " Статус сменили на ознакомленный  #" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();*//*

                                }, 2500);

                            } else {

                                ///////TODO запускаем смены стануса задачи черезе PendingIntent
                                Log.i(getContext().getClass().getName(), "СтатусПрочтеаУжеЗадачаИлиНет Статус Уже Изменен на 1  " + СтатусПрочтеаУжеЗадачаИлиНет);

                                ///   Toast.makeText(getActivity(), " Статус ознакомлена !!!   #" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                            }*/

                            // TODO: 03.03.2022 update screewn

                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1" +
                                    "   ПолучаемUUIDТекущйПозицииВRecyreView " + ПолучаемUUIDТекущйПозицииВRecyreView +
                                    " holder.getAdapterPosition() " + holder.getAdapterPosition());

                            // TODO: 13.03.2022
                            // notifyDataSetChanged();

                            return true;

                        }
                    });
                    // TODO: 13.03.2022
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
            }


            // TODO: 15.03.2022


            private void МетодБиндингаСлушательisChered(MyViewHolder holder) {
                // TODO: 14.03.2022

                try {
                    holder.materialCardView.setOnCheckedChangeListener(new MaterialCardView.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(MaterialCardView card, boolean isChecked) {
                            // TODO: 13.03.2022
                            /*int ИндексдляНепрочитанный = R.drawable.icon_dsu1_fortasks_cardview_color_geeeey;
                            // TODO: 13.03.2022

                            // TODO: 13.03.2022
                            Drawable drawableИндексдляНепрочитанный
                                    = getContext().getDrawable(ИндексдляНепрочитанный);*/
                           /* // TODO: 16.03.2022
                            int ИндексПпрочитанные = R.drawable.icon_dsu1_fortasks_cardview_color_geen;*/
                            // TODO: 13.03.2022
                            // TODO: 16.03.2022
                            int ИндексПпрочитанные; //R.drawable.icon_dsu1_create_new_tasks;
                            // TODO: 16.03.2022  
                            Drawable drawableПпрочитанные;

                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), " card  " + card +
                                    "  holder.getAdapterPosition() " + holder.getAdapterPosition() + " isChecked " + isChecked);

                            // TODO: 13.03.2022

                            // TODO: 02.03.2022#5


                            // TODO: 13.03.2022
                            if (isChecked) {
                                // TODO: 16.03.2022
                                ИндексПпрочитанные = R.drawable.icon_dsu1_create_new_tasks; //R.drawable.icon_dsu1_create_new_tasks;
                                drawableПпрочитанные
                                        = getContext().getDrawable(ИндексПпрочитанные);

                                // TODO: 13.03.2022
                                card.setCheckedIcon(drawableПпрочитанные);
                                // TODO: 13.03.2022
                                card.setCheckedIconResource(ИндексПпрочитанные);
                                // TODO: 16.03.2022
                                card.setCardBackgroundColor(Color.RED);
                                // TODO: 16.03.2022
                                card.setCardBackgroundColor(Color.RED);

                                // TODO: 13.03.2022
                                // TODO: 13.03.2022
                                card.setSelected(true);
                                // TODO: 13.03.2022
                                Log.d(this.getClass().getName(), "  holder.materialCardView.setOnCheckedChangeListener  isChecked   " + isChecked);


                            } else {
                                // TODO: 14.03.2022
                                ИндексПпрочитанные = R.drawable.icon_dsu1_message_add_contact; //R.drawable.icon_dsu1_create_new_tasks;
                                drawableПпрочитанные
                                        = getContext().getDrawable(ИндексПпрочитанные);

                                // TODO: 13.03.2022
                                card.setCheckedIcon(drawableПпрочитанные);
                                // TODO: 13.03.2022
                                card.setCheckedIconResource(ИндексПпрочитанные);
                                // TODO: 16.03.2022
                                card.setCardBackgroundColor(Color.RED);
                                // TODO: 16.03.2022
                                card.setCardBackgroundColor(Color.RED);

                                // TODO: 13.03.2022
                                // TODO: 13.03.2022
                                card.setSelected(true);
                                // TODO: 13.03.2022
                                Log.d(this.getClass().getName(), "   holder.materialCardView.setOnCheckedChangeListener  isChecked    " + isChecked);
                            }

                            // TODO: 13.03.2022
                        }
                    });
                    // TODO: 13.03.2022
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
            }

            // TODO: 04.03.2022 четвертый дополнительный метод СОЗДАНИЕ СЛУШАТЕЛЯ ДЛЯ СОЗДАНИЕ НОВОЙ ЗАДАЧИ
            private void МетодБиндингаСлушательДляКнопкиСоздатьНовуюЗадачу(MyViewHolder holder) {
                // TODO: 14.03.2022

                try {
                    holder.buttonДляСозданиеНовогоЗадания.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // TODO: 16.03.2022

                            // TODO: 01.03.2022

                      /*      // TODO: 10.03.2022
                            вибратор.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));*/

                            // TODO: 21.03.2022  созлаени данных для записи в базу


                            // TODO: 21.03.2022 аписываем данные первую строчки шабка задачи
                            if (!holder.textView1.getText().toString().isEmpty()) {
                                // TODO: 21.03.2022
                                holder.bundleЗначенияДляНовойЗадачи.putString("ШабкаНовойЗадачи", holder.textView1.getText().toString());

                                // TODO: 21.03.2022  ПЕРЕНЕСЕННЫЙ КОД ДЛЯ ЗАПИСИ ЗАДАЧИ В БАЗУ
                                // TODO: 21.03.2022 аписываем данные вторая Сама Задача
                                if (!holder.textView3.getText().toString().isEmpty()) {
                                    // TODO: 21.03.2022
                                    holder.bundleЗначенияДляНовойЗадачи.putString("СообщениеНовойЗадачи", holder.textView3.getText().toString());

                                    // TODO: 21.03.2022  перенесеный код третией

                                    // TODO: 21.03.2022 аписываем данные третья  ФИО
                                    if (!holder.spinnerДляСозданиеНовойЗадачи.getChildAt(0).isPressed()) {


                                        // TODO: 21.03.2022
                                        TextView ПолучаемФИОКомуЗадачаПредназначена = (TextView) holder.spinnerДляСозданиеНовойЗадачи.getChildAt(0);
                                        // TODO: 21.03.2022

                                        if (!ПолучаемФИОКомуЗадачаПредназначена.getText().toString().isEmpty()) {
                                            // TODO: 21.03.2022
                                            Log.d(this.getClass().getName(), "  holder.spinnerДляСозданиеНовойЗадачи.getSelectedItemPosition() " + holder.spinnerДляСозданиеНовойЗадачи.getSelectedItemPosition() +
                                                    "  " + holder.spinnerДляСозданиеНовойЗадачи.getSelectedItem().toString() +
                                                    "  holder.spinnerДляСозданиеНовойЗадачи " + holder.spinnerДляСозданиеНовойЗадачи.getChildAt(0).toString() +
                                                    " holder.spinnerДляСозданиеНовойЗадачи " + holder.spinnerДляСозданиеНовойЗадачи.getItemAtPosition(0) +
                                                    " textView " + ПолучаемФИОКомуЗадачаПредназначена.getText().toString());

                                            // TODO: 21.03.2022
                                            holder.bundleЗначенияДляНовойЗадачи.putString("КомуСообщениеФИО", ПолучаемФИОКомуЗадачаПредназначена.getText().toString());


                                            // TODO: 21.03.2022   шестой переннос

                                            // TODO: 21.03.2022 аписываем данные  четвертая Выбор какая Задача Одноразовая Или По расписания
                                            if (!holder.textView7.getText().toString().isEmpty()) {
                                                // TODO: 21.03.2022

                                                holder.bundleЗначенияДляНовойЗадачи.putString("ЗадачиКакаяЗадачиОдноразоваяИлиНет", holder.textView7.getText().toString());

                                                // TODO: 21.03.2022   перенсенный ятий шаг для создаени задачи

                                                // TODO: 21.03.2022  запускаем создаени задачи только если пользователь выбрал задачу

                                                if (!holder.textView7.getText().toString().equalsIgnoreCase("выберете тип задачи")) {
                                                    // TODO: 21.03.2022  Класс для Создание Нового Задича ПОСЛЕН ПОЛУЧЕНИЯ ДАННЫХ ЧЕРЕЗ bUNGLE

                                                    // TODO: 21.03.2022
                                                    Long ПубличныйIDДляЗаданияКомуПисать = Long.parseLong(ПолучаемФИОКомуЗадачаПредназначена.getTag().toString());

                                                    // TODO: 21.03.2022
                                                    ;

                                                    Log.d(this.getClass().getName(), "  ПубличныйIDДляЗаданияКомуПисать" + ПубличныйIDДляЗаданияКомуПисать +
                                                            " accessibilityNodeInfoДополнительныеДанные.getContentDescription() " + accessibilityNodeInfoДополнительныеДанные.getContentDescription());


                                                    SubClass_CreateNewTasks_КлассДляСозданияНовойЗадачи subClass_createNewTasksКлассДляСозданияНовойЗадачи
                                                            = new SubClass_CreateNewTasks_КлассДляСозданияНовойЗадачи(getContext(), holder.bundleЗначенияДляНовойЗадачи);
                                                    // TODO: 21.03.2022

                                                    Long ОперациСозданияНовойЗадания = subClass_createNewTasksКлассДляСозданияНовойЗадачи.МетодЗаписиНовойЗадачи(ПубличныйIDДляЗаданияКомуПисать);


                                                    Log.d(this.getClass().getName(), "  ОперациСозданияНовойЗадания" + ОперациСозданияНовойЗадания);

                                                    // TODO: 22.03.2022  результат вставки новой задачи успешно или нет


                                                    if (ОперациСозданияНовойЗадания <= 0) {

                                                        // TODO: 21.03.2022 ЗАДАЧА НЕ ВЫЬББРАНА
                                                        Snackbar.make(v, " Ошибка новая задача не создалась !!! ", Snackbar.LENGTH_LONG).show();
                                                        // TODO: 22.03.2022

                                                        Log.e(this.getClass().getName(), "  Ошибка новая задача не создалась !!!" + ОперациСозданияНовойЗадания);
                                                    } else {
                                                        // TODO: 22.03.2022
                                                        Log.w(this.getClass().getName(), "   Успешное Создаение Задачи !!!" + ОперациСозданияНовойЗадания);
                                                        // TODO: 22.03.2022
                                                        // TODO: 09.03.2022
                                                        fragmentTransactionляЗадачи = fragmentManagerДляЗадачи.beginTransaction();

                                                        Log.d(this.getClass().getName(), "  fragmentTransactionляЗадачи" + fragmentTransactionляЗадачи);

                                                        fragment_ТекущийФрагмент = new Fragment2_Create_Tasks();
                                                        // TODO: 11.03.2022
                                                        fragmentTransactionляЗадачи.replace(R.id.activity_main_fisrt_for_tasks, fragment_ТекущийФрагмент).commit();//.layout.activity_for_fragemtb_history_tasks
                                                        // TODO: 10.03.2022
                                                        fragmentTransactionляЗадачи.show(fragment_ТекущийФрагмент);
                                                        // TODO: 10.03.2022
                                                        Log.d(this.getClass().getName(), " fragmentTransactionляЗадачи " + fragmentTransactionляЗадачи);
                                                        // TODO: 10.03.2022
                                                        // TODO: 14.03.2022
                                                        bottomNavigationViewДляTasks.requestLayout();
                                                        // TODO: 22.03.2022
                                                        recyclerView.requestLayout();
                                                        // TODO: 14.03.2022
                                                        linearLayou.requestLayout();
                                                        // TODO: 22.03.2022

                                                        // TODO: 22.03.2022  ПОСЛЕ УСПЕШНОГО СОЗДАНЕИ ОВГО ЗАДАНИЯ ЗАПУСКАЕМ СИНХРОНИАЗЦИЮ


                                                        // TODO: 25.03.2022


                                                        // TODO: 13.01.2022  ЗАПУСК СИХРОНИЗВАЦИИ В ХОЛОСТУЮ ХОД

                                                        new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getContext()).
                                                                МетодПовторногоЗапускаВсехWorkManager__ОДНОРАЗОВОЙСинхрониазцииданных(ПубличныйIDДляФрагмента, getContext());

                                                        // TODO: 22.03.2022

                                                        // TODO: 24.12.2021

                                                        Log.d(this.getClass().getName(), "после СОЗДАНИЕЯ НОВОЙ ЗАДАЧИ ..... ПОСЛЕ ЗУПАСУКА СИНХРОНИАЗЦИИ" +
                                                                "  ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);


                                                        // TODO: 03.03.2022 update screewn
                                                        Handler HandlerЗапускаемОтсрочнуюСменуСтатуса = new Handler(Looper.getMainLooper());
                                                        // TODO: 25.03.2022
                                                        HandlerЗапускаемОтсрочнуюСменуСтатуса.postDelayed(() -> {
                                                            // TODO: 04.03.2022

                                                            Курсор_ГлавныйКурсорДляЗадач.deactivate();
                                                            // TODO: 25.03.2022
                                                            Курсор_ГлавныйКурсорДляЗадач.requery();

                                                            // TODO: 13.03.2022
                                                            notifyDataSetChanged();

                                                            bottomNavigationViewДляTasks.requestLayout();
                                                            // TODO: 22.03.2022
                                                            recyclerView.requestLayout();
                                                            // TODO: 14.03.2022
                                                            linearLayou.requestLayout();

                                                        }, 5000);


                                                    }


                                                    Log.d(this.getClass().getName(), "  ОперациСозданияНовойЗадания" + ОперациСозданияНовойЗадания);


                                                } else {
                                                    // TODO: 21.03.2022 ЗАДАЧА НЕ ВЫЬББРАНА
                                                    Snackbar.make(v, "Вы не выбрали тип задачи !!!  ", Snackbar.LENGTH_LONG).show();

                                                }


                                            } else {
                                                // TODO: 21.03.2022 ЗАДАЧА НЕ ВЫЬББРАНА
                                                Snackbar.make(v, "Вы не выбрали тип задачи !!!  ", Snackbar.LENGTH_LONG).show();

                                            }


                                        } else {
                                            // TODO: 21.03.2022 ЗАДАЧА НЕ ВЫЬББРАНА
                                            Snackbar.make(v, "Вы не выбрали ФИО  !!!  ", Snackbar.LENGTH_LONG).show();

                                        }


                                        // TODO: 21.03.2022 перенесенный четвертыйц код




                                        // TODO: 21.03.2022  запускапм класс с данными BUngle

                                        Log.d(this.getClass().getName(), "  holder.buttonДляСозданиеНовогоЗадания.setOnClickListener   МетодБиндингаСлушательДляКнопкиСоздатьНовуюЗадачу    " +
                                                " holder.bundleЗначенияДляНовойЗадачи " + holder.bundleЗначенияДляНовойЗадачи.toString());


                                    } else {
                                        // TODO: 21.03.2022 ЗАДАЧА НЕ ВЫЬББРАНА
                                        Snackbar.make(v, "Не заполнено   ФИО   !!!  ", Snackbar.LENGTH_LONG).show();

                                    }


                                } else {
                                    // TODO: 21.03.2022 ЗАДАЧА НЕ ВЫЬББРАНА
                                    Snackbar.make(v, "Нет самой задачи !!!  ", Snackbar.LENGTH_LONG).show();

                                }


                                // TODO: 21.03.2022  перенсенный код из задачи

                            } else {
                                // TODO: 21.03.2022 ЗАДАЧА НЕ ВЫЬББРАНА
                                Snackbar.make(v, "Нет загаловка задачи !!!  ", Snackbar.LENGTH_LONG).show();

                            }




                            Log.d(this.getClass().getName(), "  holder.buttonДляСозданиеНовогоЗадания.setOnClickListener   МетодБиндингаСлушательДляКнопкиСоздатьНовуюЗадачу    " +
                                    " holder.bundleЗначенияДляНовойЗадачи " + holder.bundleЗначенияДляНовойЗадачи.toString());

                        }
                    });
                    // TODO: 13.03.2022
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
            }

            @Override
            public long getItemId(int position) {
                // TODO: 04.03.2022

                Log.i(this.getClass().getName(), "     getItemId holder.position  новая задача " + position);

                return super.getItemId(position);

            }


            private SQLiteCursor МетодПолучениеДанныхФИОаОснованииID(Integer КтоНаписалСообщениеФИОдЛПосика) throws ExecutionException, InterruptedException {
                // TODO: 16.11.2021 find FIO
                SQLiteCursor Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал = null;
                try {
                    ///
                    Class_GRUD_SQL_Operations class_grud_sql_operationsФИОКтоНАсамомДелеНАписал = new Class_GRUD_SQL_Operations(getContext());

                    ///
                    class_grud_sql_operationsФИОКтоНАсамомДелеНАписал.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", "chat_users");
                    ///////
                    class_grud_sql_operationsФИОКтоНАсамомДелеНАписал.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "name");
                    //
                    class_grud_sql_operationsФИОКтоНАсамомДелеНАписал.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "_id=?   AND name IS NOT NULL ");
                    ///"_id > ?   AND _id< ?"
                    //////
                    class_grud_sql_operationsФИОКтоНАсамомДелеНАписал.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", КтоНаписалСообщениеФИОдЛПосика);

    /*            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC");
                ////
                class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","5");*/

                    // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
                    ///

                    Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал = (SQLiteCursor) class_grud_sql_operationsФИОКтоНАсамомДелеНАписал.
                            new GetData(getContext()).getdata(class_grud_sql_operationsФИОКтоНАсамомДелеНАписал.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                            new PUBLIC_CONTENT(getContext()).МенеджерПотоков, new CREATE_DATABASE(getContext()).getССылкаНаСозданнуюБазу());

                    ////////

                    Log.d(this.getClass().getName(), "Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал " + Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал);


                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }

                // TODO: 02.03.2022
                return Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал;
            }


            @Override
            public int getItemCount() {

                // TODO: 02.03.2022
                ////////

                Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхДляЗАДАЧTASK " + ОчередьДаныеДляСозданиеНовойЗадачи);
                // TODO: 28.02.2022
                return ОчередьДаныеДляСозданиеНовойЗадачи.size();
            }
        }//TODO  конец два


        // TODO: 17.03.2022  КЛАСС ДЛЯ СПИНЕРА


        private class КлассАдаптерДляСпинера {
            // TODO: 17.03.2022
            Context context;
            // TODO: 17.03.2022
            SQLiteCursor sqLiteCursorКурсорПолучаемВсеФИоДляНовойЗадачиКому;

            public КлассАдаптерДляСпинера(Context context) throws ExecutionException, InterruptedException {
                // TODO: 17.03.2022
                this.context = context;

                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), "  sqLiteCursorКурсорПолучаемВсеФИоДляНовойЗадачиКому " + sqLiteCursorКурсорПолучаемВсеФИоДляНовойЗадачиКому);
            }

            // TODO: 17.03.2022  ПЕРЕНЕСЕНЫЙ МЕТОД ДЛЯ КУРСОР ДЛЯ ФИО ДЛЯ СПИНЕРА

            // TODO: 28.02.2022 Под Класс порлучение данных для активти
            SQLiteCursor МетодПолучаемГлавныеДанныеДляSpinnerКомуЗадачаФИО() throws ExecutionException, InterruptedException {
                // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ
                SQLiteCursor sqLiteCursorКурсорВсеФИОДЛяSpinneraДляКогоЗадание = null;
                try {
                    ///
                    Class_GRUD_SQL_Operations class_grud_sql_operationsIDпользоввателяДляСлужб = new Class_GRUD_SQL_Operations(getContext());
                    ///
                    class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", "chat_users");//old для другой уведомления data_chat
                    ///////
                    class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "*");
                    //
                    class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки", "_id");//todo "date_update DESC, status_write DESC"*/
                    //
                    class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФлагНепотораяемостиСтрок", true);//todo "date_update DESC, status_write DESC"*/
                    //
                    class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "   _id<>? ");
                    //
                    class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", ПубличныйIDДляФрагмента);//todo old ПубличноеIDПолученныйИзСервлетаДляUUID

/*                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "   user_update=? " +
                        " AND message IS NOT NULL  ");
                // TODO: 02.03.2022
                ///"_id > ?   AND _id< ?"
              *//*  class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","status_write=?  AND id_user=? " +
                        " AND message IS NOT NULL  ");
                ///"_id > ?   AND _id< ?"
*//*
                     *//*
                //////
                class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",1);//todo 0*//*
                //


                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", ПубличноеIDПолученныйИзСервлетаДляUUID);//todo old ПубличноеIDПолученныйИзСервлетаДляUUID
                // TODO: 02.03.2022
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки", " status_write, date_update DESC ");//todo "date_update DESC, status_write DESC"*/
                    ////
                    // class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                    ////
                    //class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                    // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
                    ///
                    sqLiteCursorКурсорВсеФИОДЛяSpinneraДляКогоЗадание = null;
                    // TODO: 03.03.2022  глаВНЫЙ КУРСОР ДЛЯ ЗАДАЧ
                    sqLiteCursorКурсорВсеФИОДЛяSpinneraДляКогоЗадание = (SQLiteCursor) class_grud_sql_operationsIDпользоввателяДляСлужб.
                            new GetData(getContext()).getdata(class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                            new PUBLIC_CONTENT(context).МенеджерПотоков, new CREATE_DATABASE(context).getССылкаНаСозданнуюБазу());
                    // TODO: 02.03.2022
              /*      if (sqLiteCursorКурсорВсеФИОДЛяSpinneraДляКогоЗадание.getCount() > 0) {
                        // TODO: 03.03.2022
                        Log.d(this.getClass().getName(), "Курсор_ГлавныйКурсорДляЗадач " + sqLiteCursorКурсорВсеФИОДЛяSpinneraДляКогоЗадание);
                        // TODO: 03.03.2022
                        sqLiteCursorКурсорВсеФИОДЛяSpinneraДляКогоЗадание.moveToFirst();
                    }*/
                    ////////
                    Log.d(this.getClass().getName(), "Курсор_ГлавныйКурсорДляЗадач " + sqLiteCursorКурсорВсеФИОДЛяSpinneraДляКогоЗадание);

                    // TODO: 21.03.2022

                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
                return sqLiteCursorКурсорВсеФИОДЛяSpinneraДляКогоЗадание;
            }


/////////////////////////////////////////////
        }


        // TODO: 21.03.2022  класс создаения класс после получения данных из  Bungle

        private class SubClass_CreateNewTasks_КлассДляСозданияНовойЗадачи {
            // TODO: 21.03.2022
            Bundle bundleПолученныйеДанныеДляСозданияЗадачи;

            // TODO: 21.03.2022
            public SubClass_CreateNewTasks_КлассДляСозданияНовойЗадачи(@NonNull Context context, @NonNull Bundle bundleПолученныйеДанныеДляСозданияЗадачи) {

                try {
                    // TODO: 21.03.2022
                    this.bundleПолученныйеДанныеДляСозданияЗадачи = bundleПолученныйеДанныеДляСозданияЗадачи;
                    ////////
                    Log.d(this.getClass().getName(), "bundleПолученныйеДанныеДляСозданияЗадачи " + bundleПолученныйеДанныеДляСозданияЗадачи);


                    // TODO: 21.03.2022
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }


            }

            // TODO: 21.03.2022  --метод записи новой задачи
            Long МетодЗаписиНовойЗадачи(@NonNull Long ПубличныйIDДляЗаданияКомуПисать) {

                CompletionService completionServiceНоваяЗадача;
                // TODO: 21.03.2022
                Long[] Результат_ВставкиДанныхПриСозданииНовойЗадачи = {0l};

                // TODO: 21.03.2022
                SQLiteDatabase sqLiteDatabaseДляНовгоЗадания;

                try {

                    // TODO: 30.08.2021    КОД ОБНОВЛЕНИЕ   ДАННЫХ   ЧЕРЕЗ

                    // TODO: 21.03.2022
                    completionServiceНоваяЗадача = new PUBLIC_CONTENT(getContext()).МенеджерПотоков;
                    //TODO заполение КОНТЕНЕР для локального обновления--дАТА оПЕРАЦИИ
                    sqLiteDatabaseДляНовгоЗадания = new CREATE_DATABASE(getContext()).getССылкаНаСозданнуюБазу();


                    // TODO: 21.03.2022
                    LinkedBlockingQueue<String> linkedBlockingQueueДвеТаблицыСозданиеНовойЗадачи = new LinkedBlockingQueue();


                    // TODO: 21.03.2022  вычисляем данные между двумя публичный я и меня кому задания


                    Long ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем
                            = new SubClass_RetryGEtRowInChatsКлассПроверемЕщеРАзПоявилосЛИПуббличныйUUIDМеждуУчасникамиЧата()
                            .МетодПовторноПроверетНеПовилосьДЛЯЗАДАЧПубличныйUUID(getContext(),
                                    ПубличныйIDДляЗаданияКомуПисать,
                                    ПубличныйIDДляФрагмента
                                    , completionServiceНоваяЗадача,
                                    sqLiteDatabaseДляНовгоЗадания);

                    Log.d(this.getClass().getName(), " повторно ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем " + ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем + "\n");


                    // TODO: 21.03.2022  если UUID есть значит между текущий пользователь и пользователь кому пишут  НОВОЕ ЗАДАНИЕ

                    if (ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем > 0) {
                        // TODO: 21.03.2022
                        linkedBlockingQueueДвеТаблицыСозданиеНовойЗадачи.offer("data_notification");
                    } else {
                        // TODO: 21.03.2022
                        linkedBlockingQueueДвеТаблицыСозданиеНовойЗадачи.offer("notifications");
                        // TODO: 21.03.2022
                        linkedBlockingQueueДвеТаблицыСозданиеНовойЗадачи.offer("data_notification");

                    }

                    // TODO: 22.12.2021 НовыйUUIDДляТаблицыДатаЧат  для таблицы дата_чат
                    ////
                    Long ЛокальныйUUIDДляОбоихТаблиц = (Long) new Class_Generation_UUID(getContext()).МетодГенерацииUUID(getContext());
                    // TODO: 21.03.2022  если UUID есть значит НОВОЕ СООБЩЕНИЕ ПЕРВОЕ

                    Log.d(this.getClass().getName(), " повторно ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем " + ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем + "\n");

                    // TODO: 21.03.2022
                    ContentValues contentValuesДляСозданияНовойЗадачиДляДвухТаблиц = new ContentValues();

                    // TODO: 21.03.2022 ЦИКЛ СОЗДАНЕИ НВОЙ ЗАДАЧИ
                    linkedBlockingQueueДвеТаблицыСозданиеНовойЗадачи.spliterator().forEachRemaining((ТаблицаОбработки) -> {
                        // TODO: 21.03.2022

                        try {
                            // TODO: 22.03.2022
                            //////
                            Class_GRUD_SQL_Operations classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи = new Class_GRUD_SQL_Operations(getContext());

                            Log.d(this.getClass().getName(), "  ТаблицаОбработки " + ТаблицаОбработки);

                            // TODO: 21.03.2022 #1 для первой таблицы

                            Long РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудникаПервая =
                                    classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи.new ChangesVesionData(getContext()).
                                            МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table(
                                                    ТаблицаОбработки, "localversionandroid_version",
                                                    getContext()
                                                    , sqLiteDatabaseДляНовгоЗадания);///  current_table    ///  localversionandroid_version

                            Log.d(this.getClass().getName(), "  РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудникаПервая " + РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудникаПервая);

                            // TODO: 21.03.2022
                            // TODO: 08.10.2021 повышаем версию

                            contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.put("current_table", РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудникаПервая);

                            // TODO: 21.03.2022

                            Log.d(this.getClass().getName(),
                                    " ЛокальныйUUIDДляТаблицыДатаЧатВтораяТаблица " + ЛокальныйUUIDДляОбоихТаблиц);

                            ////TODO ДАТА
                            String СгенерированованныйДатаДляДаннойОперации = new Class_Generation_Data(getContext()).ГлавнаяДатаИВремяОперацийСБазойДанных();

                            /////////
                            contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.put("date_update", СгенерированованныйДатаДляДаннойОперации);

                            Log.d(this.getClass().getName(), "   СгенерированованныйДатаДляДаннойОперации " + СгенерированованныйДатаДляДаннойОперации);
                            // TODO: 22.03.2022  для всех заполяется столбик


                            contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.putNull("id");


                            // TODO: 21.03.2022 выбираем какую точно нужно обработать

                            switch (ТаблицаОбработки) {
                                // TODO: 21.03.2022

                                case "notifications":
                                    // TODO: 21.03.2022


                                    ///////// вставляем ПУБЛИЧНЫЙ ID текущего пользователя
                                    contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.put("user_update", ПубличныйIDДляФрагмента);

                                    Log.d(this.getClass().getName(), "   ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);


                                    ///////// вставляем id_user
                                    contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.put("id_user", ПубличныйIDДляЗаданияКомуПисать);

                                    Log.d(this.getClass().getName(), "   ПубличныйIDДляЗаданияКомуПисать " + ПубличныйIDДляЗаданияКомуПисать);


                                    ////todo # 1 первой таблицы
                                    contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.put("uuid", ЛокальныйUUIDДляОбоихТаблиц);

                                    // TODO: 21.03.2022
                                    Log.d(this.getClass().getName(),
                                            " ТаблицаОбработки " + ТаблицаОбработки + " bundleПолученныйеДанныеДляСозданияЗадачи " + bundleПолученныйеДанныеДляСозданияЗадачи +
                                                    "  ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем  +ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем" +
                                                    " ЛокальныйUUIDДляОбоихТаблиц " + ЛокальныйUUIDДляОбоихТаблиц);

                                    break;

                                case "data_notification":
                                    // TODO: 21.03.2022

                                    ////todo # 2 первой таблицы
                                    if (ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем > 0) {
                                        // TODO: 21.03.2022
                                        contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.put("uuid_notifications", ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем);
                                    } else {
                                        // TODO: 21.03.2022
                                        contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.put("uuid_notifications", ЛокальныйUUIDДляОбоихТаблиц);

                                    }

                                    // TODO: 22.03.2022
                                    ////
                                    Long ЛокальныйUUIDДляТолькоДляВторойТаблицы = (Long) new Class_Generation_UUID(getContext()).МетодГенерацииUUID(getContext()) + 1;
                                    ////todo # 2 первой таблицы
                                    contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.put("uuid", ЛокальныйUUIDДляТолькоДляВторойТаблицы);

                                    // TODO: 21.03.2022
                                    Log.d(this.getClass().getName(),
                                            " ТаблицаОбработки " + ТаблицаОбработки + " ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем" +
                                                    " " + ПолученыйUUIDУУжеЕслиСуществуетЗаданияТекущегоПользователясКомуПишем
                                                    + " bundleПолученныйеДанныеДляСозданияЗадачи " + bundleПолученныйеДанныеДляСозданияЗадачи +
                                                    " bundleПолученныйеДанныеДляСозданияЗадачи.getString(\"ШабкаНовойЗадачи\") " + bundleПолученныйеДанныеДляСозданияЗадачи.getString("ШабкаНовойЗадачи"));


// TODO: 21.03.2022   add headr new task
                                    contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.put("head_message", bundleПолученныйеДанныеДляСозданияЗадачи.getString("ШабкаНовойЗадачи"));
// TODO: 21.03.2022   add message  new task
                                    contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.put("message", bundleПолученныйеДанныеДляСозданияЗадачи.getString("СообщениеНовойЗадачи"));
// TODO: 21.03.2022   type  message  new task
                                    contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.put("type_tasks", bundleПолученныйеДанныеДляСозданияЗадачи.getString("ЗадачиКакаяЗадачиОдноразоваяИлиНет"));


                                    // TODO: 21.03.2022
                                    Log.d(this.getClass().getName(),
                                            " ТаблицаОбработки " + ТаблицаОбработки + " contentValuesДляСозданияНовойЗадачиДляДвухТаблиц " + contentValuesДляСозданияНовойЗадачиДляДвухТаблиц +
                                                    " ТаблицаОбработки " + ТаблицаОбработки);

                                    ////


                                    // TODO: 12.10.2021  Ссылка Менеджер Потоков
                                    // TODO: 21.03.2022
                                    break;


                                default:
                                    // TODO: 21.03.2022
                                    break;
                            }

                            // TODO: 21.03.2022

                            ///

                            // TODO: 06.09.2021 ПАРАМЕТРЫ ДЛЯ ВСТАВКИ ДАННЫХ ЧАТА

                            classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", ТаблицаОбработки);

                            // TODO: 06.09.2021 КОНТЕЙНЕР ДЛЯ ВСТАВКИ ДАННЫХ ЧАТА
                            classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи.contentValuesДляSQLBuilder_Для_GRUD_Операций.putAll(contentValuesДляСозданияНовойЗадачиДляДвухТаблиц);
                            ///TODO РЕЗУЛЬТА вставка ДАННЫХ НОВАЯ ЗАДАЧА

                            // TODO: 22.03.2022 сама вставка новой задачи
                            Результат_ВставкиДанныхПриСозданииНовойЗадачи[0] = (Long) classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи.
                                    new InsertData(context).insertdata(classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                                    classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи.contentValuesДляSQLBuilder_Для_GRUD_Операций,
                                    completionServiceНоваяЗадача,
                                    sqLiteDatabaseДляНовгоЗадания);


                            // TODO: 21.03.2022
                            Log.d(this.getClass().getName(),
                                    " ТаблицаОбработки " + ТаблицаОбработки + " Результат_ВставкиДанныхПриСозданииНовойЗадачи " + Результат_ВставкиДанныхПриСозданииНовойЗадачи[0]);


                            ///TODO РЕЗУЛЬТА вставка ДАННЫХ  ПОСЛЕ ВСТВКИ НОВОЙ ЗАДАЧИ УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННФЫХ


                            if (Результат_ВставкиДанныхПриСозданииНовойЗадачи[0] > 0) {

                                Integer РезультатПослеВставкиДанныхУвеличиваемВерсиюДанных =
                                        МетодПослеУспешнойЗаписиЗначенияВТаблицуПоднимаемВерсиюДанных(classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи,
                                                sqLiteDatabaseДляНовгоЗадания,
                                                РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудникаПервая, ТаблицаОбработки);
                                // TODO: 21.03.2022
                                // TODO: 21.03.2022
                                Log.d(this.getClass().getName(),
                                        " ТаблицаОбработки " + ТаблицаОбработки + " РезультатПослеВставкиДанныхУвеличиваемВерсиюДанных " + РезультатПослеВставкиДанныхУвеличиваемВерсиюДанных);
                            }
// TODO: 22.03.2022

                            contentValuesДляСозданияНовойЗадачиДляДвухТаблиц.clear();


                            // TODO: 21.03.2022
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                        }


                        // TODO: 21.03.2022

                        Object objectТекущаяТалицаДляНовойЗадачи = linkedBlockingQueueДвеТаблицыСозданиеНовойЗадачи.poll();
                        // TODO: 21.03.2022

                        Log.d(this.getClass().getName(), " linkedBlockingQueueДвеТаблицыСозданиеНовойЗадачи " + linkedBlockingQueueДвеТаблицыСозданиеНовойЗадачи +
                                " objectТекущаяТалицаДляНовойЗадачи " + objectТекущаяТалицаДляНовойЗадачи);

                    });

                    Log.d(this.getClass().getName(), " linkedBlockingQueueДвеТаблицыСозданиеНовойЗадачи " + linkedBlockingQueueДвеТаблицыСозданиеНовойЗадачи);


                    // TODO: 21.03.2022
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
                // TODO: 21.03.2022
                return Результат_ВставкиДанныхПриСозданииНовойЗадачи[0];
            }


            private Integer МетодПослеУспешнойЗаписиЗначенияВТаблицуПоднимаемВерсиюДанных
                    (Class_GRUD_SQL_Operations classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи,
                     SQLiteDatabase sqLiteDatabaseДляНовгоЗадания,
                     Long РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника, String таблицаОбработкиПослеУспешнойВсатвкиНовойЗадачи) throws ExecutionException, InterruptedException {

                // TODO: 21.03.2022
                Integer Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы = 0;


                // TODO: 21.03.2022
                try {
                    Log.d(getContext().getClass().getName(), "таблицаОбработкиПослеУспешнойВсатвкиНовойЗадачи "
                            + таблицаОбработкиПослеУспешнойВсатвкиНовойЗадачи);


                    classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы",
                            таблицаОбработкиПослеУспешнойВсатвкиНовойЗадачи);
                    ///
                    classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба",
                            "Локальное");///  "ЛокальныйСерверныйОба"    ПОСЛЕ КАК ПРИШЛИ ВНЕШНИЕ ДАННЫЕ
                    ///
                    ///
                    classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put(" " +
                                    "ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать",
                            РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника);///  "ЛокальныйСерверныйОба"    ПОСЛЕ КАК ПРИШЛИ ВНЕШНИЕ ДАННЫЕ
                    ///


                    ///TODO РЕЗУЛЬТА изменения версии данных
                    Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы =
                            (Integer) classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи.
                                    new ChangesVesionData(getContext()).
                                    changesvesiondata(classGrudSqlOperationsДляОперацииСозданеиНовойЗадачи.
                                                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                                            new PUBLIC_CONTENT(getContext()).МенеджерПотоков
                                            , sqLiteDatabaseДляНовгоЗадания);
//
                    Log.d(getContext().getClass().getName(), "Результат_ПриписиИзменнийВерсииДанныхВФонеПриСменеОрганизации "
                            + Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы);

                    // TODO: 21.03.2022
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }

                // TODO: 21.03.2022
                return Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы;
            }

        }


    }   // TODO: 28.02.2022 конец класса бизнес логики   // TODO: 28.02.2022 конец класса бизнес логики

    // TODO: 02.03.2022


    // TODO: 28.02.2022 бизнес -логика    для активти


}    // TODO: 28.02.2022 конец класса






























