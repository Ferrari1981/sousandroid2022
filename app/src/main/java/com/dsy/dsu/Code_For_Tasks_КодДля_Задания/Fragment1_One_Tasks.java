package com.dsy.dsu.Code_For_Tasks_КодДля_Задания;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteCursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.dsy.dsu.Business_logic_Only_Class.Class_GRUD_SQL_Operations;
import com.dsy.dsu.Business_logic_Only_Class.Class_Generation_Errors;
import com.dsy.dsu.Business_logic_Only_Class.Class_Generations_PUBLIC_CURRENT_ID;
import com.dsy.dsu.CREATE_DATABASE;
import com.dsy.dsu.PUBLIC_CONTENT;
import com.dsy.dsu.R;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.ExecutionException;


public class Fragment1_One_Tasks extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    protected View viewДляПервойКнопкиHome_Задания = null;
    // TODO: 01.03.2022
    protected Bundle BungleДанныеДляViewCard;
    // TODO: 01.04.2022
    protected Bundle BungleДанныеДляViewCardBungle;
    // TODO: 01.04.2022
    protected Bundle BungleДанныеДляViewCardBungleID;
    // TODO: 28.02.2022
    protected RecyclerView recyclerView;

    // TODO: 10.03.2022
    private SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1;
    // TODO: 13.03.2022
    private SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1.MyRecycleViewAdapter myRecycleViewAdapter;
    // TODO: 14.03.2022
    private SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1.MyViewHolder myViewHolder;

    // TODO: 02.03.2022
    protected SQLiteCursor Курсор_ГлавныйКурсорДляЗадач;
    // TODO: 02.03.2022
    protected SQLiteCursor Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе = null;
    // TODO: 04.03.2022 Слушатель  recycelview
    protected RecyclerView.AdapterDataObserver adapterDataObserverObserverСлушатель;
    // TODO: 04.03.2022  слушатель курсора
    protected DataSetObserver dataSetObserverДляКурсора;
    // TODO: 14.03.2022
    protected DataSetObserver dataSetObserverДляКурсораТолькоКоличество;
    // TODO: 04.03.2022
    protected Observer observerОБЩАЯДляWORKMANAGERДляРасписания;
    // TODO: 04.03.2022
    protected Observer observerОдноразоваяДляWORKMANAGERДляРасписанияДполнительнаяОтЧата;
    // TODO: 04.03.2022
    protected String ИмяСлужбыОбщейСинхронизацииДляЗадачи = "WorkManager Synchronizasiy_Data";
    // TODO: 04.03.2022
    protected String ИмяСлужбыОдноразоваяСинхронизацииДляЗадачиИзЧата = "WorkManager Synchronizasiy_Data Disposable";
    // TODO: 05.03.2022
    protected BottomNavigationView bottomNavigationViewДляTasks;
    // TODO: 09.03.2022
    protected FragmentManager fragmentManagerДляЗадачи;
    // TODO: 09.03.2022
    protected FragmentTransaction fragmentTransactionляЗадачи;
    // TODO: 10.03.2022
    protected TextView textViewТекущаяЗадача;
    // TODO: 14.03.2022
    protected Integer ПубличныйIDДляФрагмента;
    // TODO: 14.03.2022
    protected LinearLayout linearLayou;
    // TODO: 14.03.2022
    protected Fragment fragment_ТекущийФрагмент;
    // TODO: 09.03.2022
    protected BottomNavigationItemView bottomNavigationКонкретноКнопкаДобавить;
    // TODO: 09.03.2022
    protected BottomNavigationItemView bottomNavigationКонкретноКнопкаКонтролируемыеЗадачи;
    // TODO: 15.03.2022
    AccessibilityNodeInfo accessibilityNodeInfoBundle;
    // TODO: 01.04.2022


    @SuppressLint("RestrictedApi")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            Log.d(this.getClass().getName(), "  onViewCreated  Fragment1_One_Tasks view   " + view);

            Log.d(this.getClass().getName(), "  Fragment1_One_Tasks  viewДляПервойКнопкиHome_Задания " + viewДляПервойКнопкиHome_Задания);

            // TODO: 10.03.2022

            textViewТекущаяЗадача = (TextView) view.findViewById(R.id.activy_task_fragment1_tasksnameеtextview);

            Log.d(this.getClass().getName(), "  Fragment1_One_Tasks  textViewТекущаяЗадача " + textViewТекущаяЗадача + " view " + view);
            // TODO: 14.03.2022
            textViewТекущаяЗадача.setText("Задания".toUpperCase());

            // TODO: 10.03.2022 выбрат


            // TODO: 10.03.2022 manager fragmenot

            fragmentManagerДляЗадачи = getActivity().getSupportFragmentManager();
            // TODO: 14.03.2022

            linearLayou = (LinearLayout) getActivity().findViewById(R.id.activity_main_fisrt_for_tasks);

            // TODO: 14.03.2022
            // TODO: 06.03.2022
            bottomNavigationViewДляTasks = (BottomNavigationView) view.findViewById(R.id.bottomnavigationActiviTask8);

            // TODO: 14.03.2022  тут обьявляем три кнопки доьавить контроль и новая задача

            bottomNavigationКонкретноКнопкаДобавить = bottomNavigationViewДляTasks.findViewById(R.id.id_taskCreateNewTasks);

            // TODO: 14.03.2022  тут обьявляем три кнопки доьавить контроль и новая задача

            bottomNavigationКонкретноКнопкаКонтролируемыеЗадачи = bottomNavigationViewДляTasks.findViewById(R.id.id_taskHome);
            // TODO: 14.03.2022
            //  bottomNavigationКонкретноКнопкаКонтролируемыеЗадачи.performLongClick();
            bottomNavigationКонкретноКнопкаКонтролируемыеЗадачи.setSelected(true);
            // TODO: 16.03.2022

            bottomNavigationКонкретноКнопкаКонтролируемыеЗадачи.setTitle("Контроль");


            // TODO: 15.03.2022 НЕ ПОКАЗЫВАЕМ
            bottomNavigationКонкретноКнопкаДобавить.setVisibility(View.GONE);
            // TODO: 01.04.2022
            BungleДанныеДляViewCardBungle = new Bundle();

            // TODO: 01.04.2022
            BungleДанныеДляViewCardBungleID = new Bundle();
            // TODO: 10.04.2022
            // TODO: 14.03.2022  данные на carvview
            BungleДанныеДляViewCard = new Bundle();
            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 imageView  onViewCreated ");

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

    // TODO: 12.03.2022

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try{

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

        return viewДляПервойКнопкиHome_Задания;
    }


    // TODO: 12.03.2022  метод с бизнес логикой
    @Override
    public void onResume() {
        super.onResume();

        try {
            ///   getResources().getDrawable(this,R.drawable.icon_dsu1_add_organisazio_success
            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 imageView  Fragment1_One_Tasks  onStart");

            // TODO: 02.03.2022
            ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(getContext()).ПолучениеПубличногоТекущегоПользователяID();


            //TODO код для recycleviews
            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1 = new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1(getContext(), getActivity());

            // TODO: 10.03.2022

            Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);

            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1.МетодПолученимТОлькоКоличествоЗадач(ПубличныйIDДляФрагмента);

            Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);


            // TODO: 02.03.2022 получения курсора
            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1.МетодПолучаемГлавныеДанныеДляЗадач(ПубличныйIDДляФрагмента);

            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  " + Курсор_ГлавныйКурсорДляЗадач);

            // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА

            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1.МетодСлушательObserverДляКурсора();




            // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА туту запускам два слушателя дялнаших work manager

            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1.МетодСоздаенияСлушателяДляОбщейWorkMAnager();

            // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА туту запускам два слушателя дялнаших work manager

            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1.МетодСоздаенияСлушателяДляЧатаWorkMAnager();


        //todo метод  ИНИЦИАЛИЗАЦИИ RECYCLEVIEW ДЛЯ АКТИВТИ ЗАДАЧИ

            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1.МетодИнициализацииRecycleViewДляЗадач();

            // TODO: 05.03.2022  ДЛЯ ИНИЗАЛИЗАЦИИ НИЖНИХ КНОПОК
            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1.МетодСозданиеНавигаторКнопок();

            // TODO: 05.03.2022  СТАТУС ЗНАЧКА С ДОПОЛНИТЕЛЬНЫЙ СТАТУСОМ
            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1.МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);

            Log.d(this.getClass().getName(), " нет данных для отображения " +
                    "отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  МетодКпопкаСоЗачкомКраснымДополнительныйСтатус  " + Курсор_ГлавныйКурсорДляЗадач +
                    " Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);

            // TODO: 22.03.2022 observer


            // TODO: 04.03.2022 создаем слушатель    третий класс создаем класс слушаителй  ДАННЫЙ КОД ЗАПУСКАЕТЬСЯ ПОСЛЕ СОЗДАЕНИЯ И УСТАНОВКИ АДАПТЕРА RECYCLEVIEW


            subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1.МетодСлушательObserverДляКурсораТолькоКоличество();


            // TODO: 22.03.2022

            bottomNavigationViewДляTasks.requestLayout();
            // TODO: 22.03.2022
            recyclerView.requestLayout();
            // TODO: 30.03.2022
            recyclerView.invalidate();
            // TODO: 14.03.2022
            linearLayou.requestLayout();

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

    // TODO: 10.03.2022 БИЗНЕС-КОД ПЕРЕНЕСЕН ИЗ АКТИВТИ


    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 onDestroyView  " +
                    "" + adapterDataObserverObserverСлушатель +
                    " dataSetObserverДляКурсора " + dataSetObserverДляКурсора);

            // TODO: 17.03.2022  прОВЕРЯЕМ ПЕРЕД  СНЯТИЕМ СРЕГИСТАЦИИ НАБЛЮДАЛЕТЯД АБЫЛ ИЛ ВООБЩЕ ОН УСТАНОВЛЕН
            boolean ФлагКоторыйПоказываетБылзарегистированлСлушатель = false;
            if (myRecycleViewAdapter != null) {
                // TODO: 22.03.2022
                ФлагКоторыйПоказываетБылзарегистированлСлушатель = myRecycleViewAdapter.hasObservers();
            }

            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 onDestroyView  " +
                    "" + adapterDataObserverObserverСлушатель +
                    " dataSetObserverДляКурсора " + dataSetObserverДляКурсора + " ФлагКоторыйПоказываетБылзарегистированлСлушатель " + ФлагКоторыйПоказываетБылзарегистированлСлушатель);

            // TODO: 04.03.2022 закрываем слушатель  recycreview
            if (adapterDataObserverObserverСлушатель != null && myRecycleViewAdapter != null && ФлагКоторыйПоказываетБылзарегистированлСлушатель == true) {
                // TODO: 04.03.2022
                myRecycleViewAdapter.unregisterAdapterDataObserver(adapterDataObserverObserverСлушатель);
// TODO: 04.03.2022 закрываем слушатель  curcor
            }
            // TODO: 14.03.2022
            if (dataSetObserverДляКурсора != null && Курсор_ГлавныйКурсорДляЗадач != null) {
                // TODO: 04.03.2022
                Курсор_ГлавныйКурсорДляЗадач.unregisterDataSetObserver(dataSetObserverДляКурсора);
            }
            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1   " +
                    "" + adapterDataObserverObserverСлушатель +
                    " dataSetObserverДляКурсора " + dataSetObserverДляКурсора);

            // TODO: 04.03.2022  закрывам сслушатли work manager общего
            if (observerОБЩАЯДляWORKMANAGERДляРасписания != null) {
                // TODO: 04.03.2022
                WorkManager.getInstance(getContext()).getWorkInfosByTagLiveData(ИмяСлужбыОбщейСинхронизацииДляЗадачи).removeObserver(observerОБЩАЯДляWORKMANAGERДляРасписания);
            }
            // TODO: 04.03.2022  закрывам сслушатли work manager чата одноразовга
            if (observerОдноразоваяДляWORKMANAGERДляРасписанияДполнительнаяОтЧата != null) {
                // TODO: 04.03.2022
                WorkManager.getInstance(getContext()).getWorkInfosByTagLiveData(ИмяСлужбыОдноразоваяСинхронизацииДляЗадачиИзЧата)
                        .removeObserver(observerОдноразоваяДляWORKMANAGERДляРасписанияДполнительнаяОтЧата);
            }

// TODO: 04.03.2022
            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  ИмяСлужбыСинхронизацииДляЗадачиИзЧата  " +
                    "" + ИмяСлужбыОдноразоваяСинхронизацииДляЗадачиИзЧата +
                    " ИмяСлужбыСинхронизацииДляЗадачи " + ИмяСлужбыОбщейСинхронизацииДляЗадачи);
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


    // TODO: 02.03.2022

    // TODO: 28.02.2022 бизнес -логика    для активти


    class SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 {
        // TODO: 28.02.2022
        Context context;
        // TODO: 14.03.2022
        Activity activity;

        public SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1(Context context, Activity activity) {
            // TODO: 14.03.2022
            this.context = context;
            // TODO: 14.03.2022
            this.activity = activity;
            Log.d(this.getClass().getName(), "  public SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1(Context context, Activity activity)   " + context);
        }

        // TODO: 14.03.2022

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
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "   id_user=? AND status_write=? " +
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

        // TODO: 28.02.2022 Под Класс порлучение данных для активти
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
                class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "   id_user=? " +
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


        // TODO: 04.03.2022  класс в котором находяться слушатели


            void МетодСлушательObserverДляRecycleView() {
                // TODO: 04.03.2022
                try {
                    // TODO: 02.03.2022
                    adapterDataObserverObserverСлушатель = new RecyclerView.AdapterDataObserver() {
                        @Override
                        public void onChanged() {
                            super.onChanged();
                            // TODO: 02.03.2022
                            Log.d(this.getClass().getName(), "onChanged ");
                            // TODO: 02.03.2022
                            /// subClassBuccessLoginГлавныйКласс_бизнесЛогики.МетодПолучениеДанныхДляЗАДАЧ();
                        }

                        @Override
                        public void onItemRangeChanged(int positionStart, int itemCount) {
                            super.onItemRangeChanged(positionStart, itemCount);
                            // TODO: 02.03.2022
                            Log.d(this.getClass().getName(), "onItemRangeChanged ");
                        }

                        @Override
                        public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
                            super.onItemRangeChanged(positionStart, itemCount, payload);
                            // TODO: 02.03.2022
                            // вибратор.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                            Log.d(this.getClass().getName(), "onItemRangeChanged ");
                        }

                        @Override
                        public void onItemRangeInserted(int positionStart, int itemCount) {
                            super.onItemRangeInserted(positionStart, itemCount);
                            // TODO: 02.03.2022
                            //   вибратор.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                            Log.d(this.getClass().getName(), "onItemRangeInserted ");
                        }

                        @Override
                        public void onItemRangeRemoved(int positionStart, int itemCount) {
                            super.onItemRangeRemoved(positionStart, itemCount);
                            // TODO: 02.03.2022
                            // вибратор.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                            Log.d(this.getClass().getName(), "onItemRangeRemoved ");
                        }

                        @Override
                        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                            super.onItemRangeMoved(fromPosition, toPosition, itemCount);
                            // TODO: 02.03.2022


                            // TODO: 13.03.2022
                            try {
                                // TODO: 05.03.2022  СТАТУС ЗНАЧКА С ДОПОЛНИТЕЛЬНЫЙ СТАТУСОМ
                                МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);

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
                            Log.d(this.getClass().getName(), "onItemRangeMoved ");
                        }
                    };
                    // TODO: 04.03.2022 запускаем слушатель;
                    // TODO: 23.03.2022
                    myRecycleViewAdapter.registerAdapterDataObserver(adapterDataObserverObserverСлушатель);

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
                                // TODO: 05.03.2022  СТАТУС ЗНАЧКА С ДОПОЛНИТЕЛЬНЫЙ СТАТУСОМ

                                МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);

                                // TODO: 04.03.2022
                                recyclerView.getAdapter().notifyDataSetChanged();
                                // TODO: 04.03.2022
                                recyclerView.getAdapter().notifyItemChanged(0);

                                // TODO: 04.03.2022
                                recyclerView.requestLayout();
                                // TODO: 30.03.2022
                                recyclerView.invalidate();

                                Log.d(this.getClass().getName(), "onItemRangeMoved  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);

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
                                    .forEachOrdered((СтастусWorkMangerДляФрагментаЧитатьИПисать) -> {
                                        // TODO: 18.02.2022
                                        try {
                                            // TODO: 14.01.2022
                                            Log.d(this.getClass().getName(), " workInfoОБШАЯ  CallBaskОтWorkManagerОдноразового observerОдноразоваяДляWORKMANAGERДляРасписания/ " +
                                                    СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().name());

                                            // TODO: 31.03.2022 слушаем задачи

                                            if (Курсор_ГлавныйКурсорДляЗадач != null) {
                                                // TODO: 04.03.2022
                                                Курсор_ГлавныйКурсорДляЗадач.deactivate();
                                                // TODO: 04.03.2022 перезапускаем курсор
                                                Курсор_ГлавныйКурсорДляЗадач.requery();
                                            }
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
                                            if (Курсор_ГлавныйКурсорДляЗадач != null) {

                                                Курсор_ГлавныйКурсорДляЗадач.deactivate();
                                                // TODO: 04.03.2022 перезапускаем курсор
                                                Курсор_ГлавныйКурсорДляЗадач.requery();
                                            }
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
            void МетодИнициализацииRecycleViewДляЗадач() {
                try {
                    Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  " + Курсор_ГлавныйКурсорДляЗадач);
                    // TODO: 04.03.2022  В ДАННОМ КОДЕ МЫ ОПЕРДЕЛЯЕМ КАКОЙ ЭКОРАН БУДЕМ ЗАГРУЖАТЬ В ЗАВПИСИМОСТИ ЕСЛИ ЛИ ДАННЫЫЕ ЗАДАЧИ
                    if (Курсор_ГлавныйКурсорДляЗадач.getCount() > 0) {
                        // TODO: 03.03.2022
                        Log.d(this.getClass().getName(), " есть данные для отображения " +
                                "отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  Курсор_ГлавныйКурсорДляЗадач  " + Курсор_ГлавныйКурсорДляЗадач);
                        // TODO: 14.03.2022
                        /*   LinearLayout linearLayou = (LinearLayout) getActivity().findViewById(R.id.activity_main_fisrt_for_tasks);*/
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

                        // TODO: 03.03.2022
                        Log.d(this.getClass().getName(), " есть данные для отображения " +
                                "отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  Курсор_ГлавныйКурсорДляЗадач  " + Курсор_ГлавныйКурсорДляЗадач);


                        // TODO: 28.02.2022
                        myRecycleViewAdapter = new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1.MyRecycleViewAdapter(Курсор_ГлавныйКурсорДляЗадач);

                        // TODO: 04.03.2022

                        recyclerView.setAdapter(myRecycleViewAdapter);

                        // TODO: 13.03.2022
                        // TODO: 04.03.2022
                        recyclerView.getAdapter().notifyDataSetChanged();
                        // TODO: 04.03.2022
                        recyclerView.getAdapter().notifyItemChanged(0);

                        Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 recyclerView   " + recyclerView);

                        // TODO: 05.03.2022  СТАТУС ЗНАЧКА С ДОПОЛНИТЕЛЬНЫЙ СТАТУСОМ когнданет записей  МетодИнициализацииRecycleViewДляЗадачМетодИнициализацииRecycleViewДляЗадач

                        МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);
                        // TODO: 14.03.2022
                        Log.d(this.getClass().getName(), "onItemRangeMoved  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе +
                                " Курсор_ДляПолученияДАнныхДляЗАДАЧTASK " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);
                        // TODO: 14.03.2022
                        linearLayou.requestLayout();


                        // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ  второай слушатель только количество данных СЛУШАТЕЛЬ КУРСОРРА
                        subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1.МетодСлушательObserverДляRecycleView();


                        // TODO: 04.03.2022

                    } else {
                        // TODO: 06.03.2022
                        //bottomNavigationViewДляTasks = (BottomNavigationView) viewДляПервойКнопкиHome_Задания.findViewById(R.id.bottomnavigationActiviTask8);
                        // TODO: 28.02.2022
                        recyclerView = (RecyclerView) viewДляПервойКнопкиHome_Задания.findViewById(R.id.recycleviewActiviTask);
                        // TODO: 28.02.2022
                        recyclerView.setVisibility(View.GONE);
                        // TODO: 28.02.2022
                        // LinearLayout linearLayou = (LinearLayout) getActivity().findViewById(R.id.activity_main_fisrt_for_tasks);
                        // TODO: 05.03.2022  СТАТУС ЗНАЧКА С ДОПОЛНИТЕЛЬНЫЙ СТАТУСОМ когнданет записей  МетодИнициализацииRecycleViewДляЗадачМетодИнициализацииRecycleViewДляЗадач
                        МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);
                        // TODO: 28.02.2022
                        Log.d(this.getClass().getName(), "onItemRangeMoved  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе +
                                " Курсор_ГлавныйКурсорДляЗадач " + Курсор_ГлавныйКурсорДляЗадач);
                        // TODO: 03.03.2022
                        TextView textViewisnull = (TextView) viewДляПервойКнопкиHome_Задания.findViewById(R.id.activy_task_nameеtextviewcursornull);
                        //  TextView textViewisnull=new TextView(activity);
                        textViewisnull.setVisibility(View.VISIBLE);
                        // TODO: 03.03.2022
                        textViewisnull.setText("Нет контролируемых задач !!!".toUpperCase());
                        // TODO: 28.02.2022
                        linearLayou.addView(textViewisnull);
                        // TODO: 06.03.2022
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        // TODO: 28.02.2022
                        linearLayou.setLayoutParams(layoutParams);
                        // TODO: 28.02.2022
                        // TODO: 28.02.2022
                        Log.d(this.getClass().getName(), " нет данных для отображения " +
                                "отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1  Курсор_ГлавныйКурсорДляЗадач  " + Курсор_ГлавныйКурсорДляЗадач);
                    }
                    // TODO: 13.03.2022
                    bottomNavigationViewДляTasks.requestLayout();

                    recyclerView.requestLayout();
                    // TODO: 30.03.2022  r
                    recyclerView.invalidate();

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

            }

            // TODO: 05.03.2022 метод создание кнопок снизу навигатор
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
                                        fragment_ТекущийФрагмент = new Fragment2_Create_Tasks();
                                        // TODO: 11.03.2022
                                        fragmentTransactionляЗадачи.replace(R.id.activity_main_fisrt_for_tasks, fragment_ТекущийФрагмент).commit();//.layout.activity_for_fragemtb_history_tasks
                                        // TODO: 10.03.2022
                                        fragmentTransactionляЗадачи.show(fragment_ТекущийФрагмент);
                                        // TODO: 10.03.2022
                                        Log.d(this.getClass().getName(), " fragmentTransactionляЗадачи " + fragmentTransactionляЗадачи);
                                        // TODO: 10.03.2022

                                        // TODO: 15.03.2022
                                        // TODO: 14.03.2022
                                        //bottomNavigationКонкретноКнопкаСоздатьСейчас.setVisibility(View.GONE);
                                        // TODO: 09.03.2022
                                        bottomNavigationViewДляTasks.requestLayout();
                                        // TODO: 14.03.2022
                                        linearLayou.requestLayout();
                                        Log.d(this.getClass().getName(), " bottomNavigationViewДляTasks.getChildCount() " + bottomNavigationViewДляTasks.getChildCount());
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

            private void МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(@NonNull Cursor cursorДЛяОпределенияНужноПоказыватьЗначеиЛИнЕТ)
                    throws ExecutionException, InterruptedException {
                // TODO: 02.03.2022
                try {
                    // TODO: 02.03.2022
                    Log.d(this.getClass().getName(), "  cursorДЛяОпределенияНужноПоказыватьЗначеиЛИнЕТ " + cursorДЛяОпределенияНужноПоказыватьЗначеиЛИнЕТ);
                    // TODO: 09.03.2022
                    if (cursorДЛяОпределенияНужноПоказыватьЗначеиЛИнЕТ.getCount() > 0) {
                        // TODO: 06.03.2022
                        bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setVisible(true);//.getOrCreateBadge(R.id.id_taskHome).setVisible(true);
                        // TODO: 06.03.2022
                        bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setNumber(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount());//.getOrCreateBadge(R.id.id_taskHome).setVisible(true);
                        // TODO: 09.03.2022
                        bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setBackgroundColor(Color.RED);
                        // TODO: 06.03.2022
                        Log.d(this.getClass().getName(), "  bottomNavigationViewДляTasks " + bottomNavigationViewДляTasks +
                                "  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount()   " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount());
                        // TODO: 05.03.2022
                    } else {
                        // TODO: 06.03.2022
                        bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setVisible(false);//.getOrCreateBadge(R.id.id_taskHome).setVisible(true);
                        // TODO: 09.03.2022
                        bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setNumber(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount());
                        // TODO: 10.03.2022
                        bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setBackgroundColor(Color.BLACK);
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


        // TODO: 15.03.2022  перенесееный код
        // TODO: 28.02.2022 начало  MyViewHolder
        protected class MyViewHolder extends RecyclerView.ViewHolder {// TODO: 28.02.2022 начало  MyViewHolder
            // TODO: 28.02.2022
            TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
            // TODO: 13.03.2022
            MaterialCardView materialCardView;
            // TODO: 29.03.2022
            LocalBroadcastManager localBroadcastManagerПриСменеСтатусаЗадачи;//
            // TODO: 13.03.2022
            BroadcastReceiver broadcastReceiverПриСменеСтатуса;

            // TODO: 02.03.2022
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
                    textView1 = (TextView) itemView.findViewById(R.id.text1_innercardview);
                    // TODO: 02.3.2022  дополнительный
                    textView2 = (TextView) itemView.findViewById(R.id.text2_innercardviewtwo);
                    // TODO: 28.02.2022
                    textView3 = (TextView) itemView.findViewById(R.id.text3_innercardviewtree);
                    // TODO: 28.02.2022
                    textView4 = (TextView) itemView.findViewById(R.id.text4_innercardviewfour);
                    // TODO: 28.02.2022
                    textView5 = (TextView) itemView.findViewById(R.id.text5_innercardviewtype_tasks);
                    // TODO: 13.03.2022
                    Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 materialCardView  textView2 " + textView4);
                    // TODO: 01.03.2022
                    materialCardView = (MaterialCardView) itemView.findViewById(R.id.cardviewmatirealtask);
                    // TODO: 13.03.2022
                    textView6 = (TextView) itemView.findViewById(R.id.text9_innercardview_callsbaks);
                    // TODO: 30.03.2022
                    textView6.setVisibility(View.GONE);
                    // TODO: 31.03.2022
                    textView7 = (TextView) itemView.findViewById(R.id.text0_innercardview_headmessage);
                    // TODO: 31.03.2022
                    // TODO: 30.03.2022
                    textView7.setVisibility(View.GONE);




                    // TODO: 30.03.2022
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


        class MyRecycleViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
            // TODO: 04.03.2022
            SQLiteCursor Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри;

            // TODO: 15.03.2022

            public MyRecycleViewAdapter(@NotNull SQLiteCursor Курсор_ДляПолученияДАнныхДляЗАДАЧTASK) {
                // super();

                // TODO: 04.03.2022
                this.Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK;

                // TODO: 29.03.2022
                if (Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount() > 0) {
                    // TODO: 04.03.2022
                    Log.i(this.getClass().getName(), "   MyRecycleViewAdapter   Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount()>" + Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount());
                }
                Log.i(this.getClass().getName(), "     getItemId holder.position ");
            }


            @Override
            public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull List<Object> payloads) {
                // TODO: 30.03.2022
                Log.i(this.getClass().getName(), "   onBindViewHolder  position" + position);
                // TODO: 02.03.2022 тут РАЗДАЕМ ДАННЫЕ RECYCLERBIEW

                try {


                    if (Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getCount() > 0) {
                        // TODO: 30.03.2022
                        Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.moveToFirst();

     /*  recyclerView.removeAllViews();

       recyclerView.getRecycledViewPool().clear();*/
                        // TODO: 30.03.2022
                        //   Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.moveToNext();
                        Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.moveToPosition(position);

                    }


                    // TODO: 30.03.2022

                    recyclerView.requestLayout();

                    // TODO: 30.03.2022
                    recyclerView.requestFocus();

                    recyclerView.invalidate();

                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }
                super.onBindViewHolder(holder, position, payloads);
            }

            @Override
            public void setHasStableIds(boolean hasStableIds) {
                super.setHasStableIds(hasStableIds);
            }

            @Override
            public void onViewRecycled(@NonNull MyViewHolder holder) {
                super.onViewRecycled(holder);
            }

            @Override
            public boolean onFailedToRecycleView(@NonNull MyViewHolder holder) {
                return super.onFailedToRecycleView(holder);
            }

            @Override
            public void onViewAttachedToWindow(@NonNull MyViewHolder holder) {
                super.onViewAttachedToWindow(holder);
            }

            @Override
            public void onViewDetachedFromWindow(@NonNull MyViewHolder holder) {
                super.onViewDetachedFromWindow(holder);
            }

            @Override
            public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {

                recyclerView.removeAllViews();

                recyclerView.getRecycledViewPool().clear();
                super.onAttachedToRecyclerView(recyclerView);
            }

            @Override
            public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
                super.onDetachedFromRecyclerView(recyclerView);
            }

            @Override
            public int getItemViewType(int position) {
                Log.i(this.getClass().getName(), "      holder.textView1  position " + position);
                try {
                    // TODO: 30.03.2022
                    Log.i(this.getClass().getName(), "   getItemViewType  position" + position);
                    // TODO: 30.03.2022

                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                }

                return super.getItemViewType(position);
            }


            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                // TODO: 10.03.2022
                View viewГлавныйВидДляRecyclleViewДляЗаданий = null;
                try {

                    // TODO: 28.02.2022
                    viewГлавныйВидДляRecyclleViewДляЗаданий = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_for_takst_cardview1, parent, false);//todo old simple_for_takst_cardview1
                    // TODO: 05.03.2022
                    Log.i(this.getClass().getName(), "   viewГлавныйВидДляRecyclleViewДляЗаданий" + viewГлавныйВидДляRecyclleViewДляЗаданий);
                    // TODO: 28.02.2022

                    // TODO: 22.03.2022
                    myViewHolder = new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1.MyViewHolder(viewГлавныйВидДляRecyclleViewДляЗаданий);

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

            @Override
            public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                // TODO: 28.02.2022 привазяваем данные из колекции пряме на наш recycreview
                try {
                    // TODO: 14.03.2022 метод офорленя recycreview

                      /*  // TODO: 02.03.2022 тут РАЗДАЕМ ДАННЫЕ RECYCLERBIEW


                        Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.moveToNext();*/

                    /*   Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.move(position);//todo old  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.move(position);*/
                    // TODO: 04.03.2022 p==osion
                    Log.i(this.getClass().getName(), "  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getPosition() " + Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getPosition());


                    // TODO: 14.03.2022  метод создания само сообщения
                    МетодБиндингаСозданиеСамоСообщения(holder);


                    // TODO: 14.03.2022  метод создания номер задания
                    МетодБиндингаНомерЗадания(holder);


                        // TODO: 14.03.2022  метод создания дата задания
                        МетодБиндингаДатаЗадания(holder);


                        // TODO: 14.03.2022  метод создания ФИО задания
                        МетодБиндингаФИОДляЗадания(holder);


                        // TODO: 13.03.2022 СЛУШАТЕЛЬ для ДОЛГОВО НАЖАТИЯ СМЕНЫ СТАТУСА

                        МетодБиндингаСлушателейДляViewCard(holder);


                        // TODO: 13.03.2022 СЛУШАТЕЛЬ СРАБАТЫВАЕТ КОГДА КОМАДА TOGGER И МЕНЯЕМ СТАТУСТ ЧЕК ОЗНАКОМЛЕНЫЙ ЛИ ИНЕТ

                        МетодБиндингаСлушательisChered(holder);


                        // TODO: 13.03.2022 СЛУШАТЕЛЬ ТРЕТИТЬ ПРОСТОЙ СЛУШАТИЕЛЬ ПРОСТО КЛИК ПО CARD VIEW

                        МетодБиндингаСлушателейТретьийСлушательПростоКликДляCard(holder);


                        // TODO: 03.03.2022 ПОЛУЧАЕМ СТАТУС ЗАДАНИЯ ПРОЧИТАН ИЛИ НЕТ

                        Integer СамСтатусПрочтенияИлиНет = МетодБиндингаПолученияСтатусаЗадачи(holder);


                        // TODO: 02.03.2022#5  получаем ТИП ЗАДАЧИ
                        МетодБиндингПолучаемТипЗадания(holder);


                    // TODO: 02.03.2022#5  заполем ДАННЫМИ BUNGLE САМОЙ ЗАДАЧИ//

                    МетодБиндингаЗаполненияДаннымиBungle(holder, СамСтатусПрочтенияИлиНет);

                    Log.i(this.getClass().getName(), "      holder.textView1  accessibilityNodeInfo " + BungleДанныеДляViewCard + " СамСтатусПрочтенияИлиНет " + СамСтатусПрочтенияИлиНет);


                    // TODO: 02.03.2022#5 создание слушателья для смены статуса дополнительный через Localbrodcast

                    МетодРелистарцииЛокальногоБродкастераПослеСменыСтатусаЗадачи(holder);


                    // TODO: 02.03.2022#5 создание Для заполнения Примечание

                    МетодБиндингаПримечаниеСамогоСообщенияCallBask(holder);

                    // TODO: 31.03.2022  метод для создание Шабка Задачи

                    МетодБиндингаШабкаЗадачи(holder);


                    // TODO: 13.03.2022 настройки для carview

                    holder.materialCardView.toggle();

                    // TODO: 13.03.2022
                    holder.materialCardView.setChecked(true);

                    // TODO: 30.03.2022


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

                    Integer ИндексUUIDДЛяЗАДАНИЯКотореВыбрали = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("uuid");///"uuid_notifications"
                    // TODO: 02.03.2022 получет UUID строчки

                    Long UUIDДЛяЗАДАНИЯКотореВыбрали = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getLong(ИндексUUIDДЛяЗАДАНИЯКотореВыбрали);

                    Log.i(this.getClass().getName(), "  UUIDДЛяЗАДАНИЯКотореВыбрали " + UUIDДЛяЗАДАНИЯКотореВыбрали);

                    // TODO: 13.03.2022


                    Log.i(this.getClass().getName(), "  holder.getAdapterPosition() " + holder.getAdapterPosition());

                    // TODO: 14.03.2022  заполем данными для получение  UUID вышке
                    BungleДанныеДляViewCard.putLong(String.valueOf(holder.getAdapterPosition()), UUIDДЛяЗАДАНИЯКотореВыбрали);


                    Log.i(this.getClass().getName(), "  BungleДанныеДляViewCard   " + BungleДанныеДляViewCard.getBundle(String.valueOf(holder.materialCardView.getId())));

                    // TODO: 13.03.2022  передаем статус задачи


                    // TODO: 03.03.2022 передаем помер позиции position
                    holder.materialCardView.setTag(holder.materialCardView.getId(), СамСтатусПрочтенияИлиНет);


                    // TODO: 01.04.2022  дополнительнео создани  данных по текущей строчке

                    Integer ИндексСамогоПримечаниезадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("callsback_note_task");
                    // TODO: 02.03.2022
                    String СамогоПримечанияЗАДАНИЯ = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getString(ИндексСамогоПримечаниезадачи);


                    // TODO: 01.04.2022 дополнительные данные сощдаем на строчке
                    // TODO: 01.04.2022

                    BungleДанныеДляViewCardBungle.putString(String.valueOf(holder.getLayoutPosition()), СамогоПримечанияЗАДАНИЯ);

                    Log.i(this.getClass().getName(), "  accessibilityNodeInfoBundle   " + accessibilityNodeInfoBundle + " holder.getLayoutPosition() " + holder.getLayoutPosition());


                    // TODO: 01.04.2022  допОЛНИТЕЛЬНЫЙ BUNGLE  ДЛЯ  ID

                    // TODO: 01.04.2022
                    Integer ИндексСамогоПримечаниезадачиID = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("status_write");
                    // TODO: 02.03.2022
                    Integer СамогоПримечанияЗАДАНИЯID = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getInt(ИндексСамогоПримечаниезадачиID);


                    BungleДанныеДляViewCardBungleID.putInt(String.valueOf(holder.getLayoutPosition()), СамогоПримечанияЗАДАНИЯID);

                    Log.i(this.getClass().getName(), "  accessibilityNodeInfoBundle   " + BungleДанныеДляViewCardBungleID + " holder.getLayoutPosition() " + holder.getLayoutPosition());


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
                    Integer ИндексСтатусТипаЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("type_tasks");
                    // TODO: 02.03.2022

                    String СамТипЗадания = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getString(ИндексСтатусТипаЗадачи);

                    Log.i(this.getClass().getName(), "  СамТипЗадания " + СамТипЗадания);

                    holder.textView5.setText("тип: " + СамТипЗадания);
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

                    Integer ИндексСтатусПрочтенияИлиНЕт = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("status_write");
                    // TODO: 02.03.2022

                    СамСтатусПрочтенияИлиНет = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getInt(ИндексСтатусПрочтенияИлиНЕт);
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
                    Integer ИндексКтоНаписалСообщение = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("user_update");
                    // TODO: 02.03.2022
                    Integer КтоНаписалСообщениеФИОдЛПосика = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getInt(ИндексКтоНаписалСообщение);
                    // TODO: 02.03.2022
                    Log.i(this.getClass().getName(), "  КтоНаписалСообщениеФИОдЛПосика " + КтоНаписалСообщениеФИОдЛПосика);
                    // TODO: 02.03.2022
                    String ФИОКотоНаписал = new String();
                    // TODO: 13.03.2022
                    SQLiteCursor sqLiteCursorПолученимНАстоящийФИО = МетодПолучениеДанныхФИОаОснованииID(КтоНаписалСообщениеФИОдЛПосика);
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
                    holder.textView3.setText("от: " + ФИОКотоНаписал.trim());
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

            private void МетодБиндингаДатаЗадания(@NonNull MyViewHolder holder) throws ParseException {
                try {
                    // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3
                    Integer ИндексПолучаемДатыЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("date_update");
                    // TODO: 02.03.2022
                    String СамаДАтаЗадачиТекущей = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getString(ИндексПолучаемДатыЗадачи);
                    // TODO: 03.03.2022 парсинг даты
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", new Locale("ru"));
                    // TODO: 13.03.2022
                    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru"));
                    // TODO: 13.03.2022
                    Date date = dateFormat.parse(СамаДАтаЗадачиТекущей);
                    // TODO: 13.03.2022
                    SimpleDateFormat simpleDateFormatДва = new SimpleDateFormat("dd MMMM yyyy HH:mm", new Locale("ru"));
                    // TODO: 13.03.2022
                    //   simpleDateFormatДва.applyPattern("dd-MM-yyyy HH:mm");//dd-MM-yyyy//// EEEE yyyy HH:mm  /////  dd MMMM yyyy HH:mm
                    СамаДАтаЗадачиТекущей = simpleDateFormatДва.format(date);
                    // TODO: 13.03.2022
                    Log.i(this.getClass().getName(), "  СамаДАтаЗадачиТекущей " + СамаДАтаЗадачиТекущей);
                    // TODO: 28.02.2022
                    holder.textView4.setText("дата: " + СамаДАтаЗадачиТекущей);
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
                    Integer ИндексПолучаемIDЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("id");
                    // TODO: 02.03.2022
                    Integer IDЗадачиТекущей = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getInt(ИндексПолучаемIDЗадачи);
                    // TODO: 02.03.2022
                    Log.i(this.getClass().getName(), "  IDЗадачиТекущей " + IDЗадачиТекущей);


                    // TODO: 28.02.2022
                    holder.textView2.setText("#" + String.valueOf(IDЗадачиТекущей));


                    // TODO: 02.03.2022#5

                    Integer ИндексСтатусПрочтенияИлиНЕт = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("status_write");
                    // TODO: 02.03.2022

                    Integer СамСтатусПрочтенияИлиНет = 0;

                    СамСтатусПрочтенияИлиНет = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getInt(ИндексСтатусПрочтенияИлиНЕт);

                    Log.i(this.getClass().getName(), "  СамСтатусПрочтенияИлиНет " + СамСтатусПрочтенияИлиНет);

                    // TODO: 29.03.2022

                    // TODO: 29.03.2022
                    holder.textView1.requestFocus();

                    // TODO: 29.03.2022
                /*    if (СамСтатусПрочтенияИлиНет == 2) {
                        // TODO: 28.02.2022
                        holder.textView2.setError("Отказ от выполения");
                    } else {

                        // TODO: 28.02.2022
                        holder.textView2.setError(null);
                    }*/
                    holder.textView2.requestLayout();

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
                    Integer ИндексСамогоСообщенияЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("message");
                    // TODO: 02.03.2022
                    String СамогоСообщенияЗадачиДляПользователя = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getString(ИндексСамогоСообщенияЗадачи);
                    // TODO: 02.03.2022
                    Log.i(this.getClass().getName(), "  СамогоСообщенияЗадачиДляПользователя " + СамогоСообщенияЗадачиДляПользователя);
                    // TODO: 28.02.2022
                    holder.textView1.setText(СамогоСообщенияЗадачиДляПользователя);
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

            private void МетодБиндингаПримечаниеСамогоСообщенияCallBask(@NonNull MyViewHolder holder) {

                try {
                    // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1
                    Integer ИндексСамогоПримечаниезадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("callsback_note_task");
                    // TODO: 02.03.2022
                    String СамогоПримечанияЗАДАНИЯ = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getString(ИндексСамогоПримечаниезадачи);
                    // TODO: 02.03.2022
                    Log.i(this.getClass().getName(), "  СамогоСообщенияЗадачиДляПользователя " + СамогоПримечанияЗАДАНИЯ);
                    // TODO: 28.02.2022
                    if (!СамогоПримечанияЗАДАНИЯ.isEmpty()) {
                        // TODO: 30.03.2022
                        holder.textView6.setVisibility(View.VISIBLE);
                        // TODO: 30.03.2022
                        holder.textView6.setText("примечание: " + Optional.ofNullable(СамогоПримечанияЗАДАНИЯ).orElse(""));

                    } else {
                        // TODO: 30.03.2022
                        holder.textView6.setVisibility(View.GONE);

                    }


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

            // TODO: 31.03.2022  метод  примечаение задачи
            private void МетодБиндингаШабкаЗадачи(@NonNull MyViewHolder holder) {

                try {
                    // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1
                    Integer ИндексСамогоШабкаЗАдачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("head_message");
                    // TODO: 02.03.2022
                    String СамогоШабкаЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getString(ИндексСамогоШабкаЗАдачи);
                    // TODO: 02.03.2022
                    Log.i(this.getClass().getName(), "  МетодБиндингаШабкаЗадачи  СамогоШабкаЗадачи " + СамогоШабкаЗадачи);
                    // TODO: 28.02.2022
                    if (!СамогоШабкаЗадачи.isEmpty()) {
                        // TODO: 30.03.2022
                        holder.textView7.setVisibility(View.VISIBLE);
                        // TODO: 30.03.2022
                        holder.textView7.setText("описание: " + Optional.ofNullable(СамогоШабкаЗадачи).orElse(""));

                    } else {
                        // TODO: 30.03.2022
                        holder.textView7.setVisibility(View.GONE);

                    }


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

    /*                holder.materialCardView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            // TODO: 01.03.2022

                            // TODO: 10.03.2022


                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1   ПозицияЭлментаVIewCardДополнительно  " +
                                    " holder.getAdapterPosition() " + holder.getAdapterPosition() + " v.getTag() " + v.getTag(holder.materialCardView.getId()));

                            // TODO: 13.03.2022  статус прочтения ли уде или нет адание

                            Object СтатусПрочтеаУжеЗадачаИлиНет = v.getTag(holder.materialCardView.getId());//TODO holder.materialCardView.getId()


                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1   ПозицияЭлментаVIewCardДополнительно  СтатусПрочтеаУжеЗадачаИлиНет " + СтатусПрочтеаУжеЗадачаИлиНет);
                            // TODO: 04.03.2022  ПОЛУЧЕНИЕ НАЗВАНЕИ ЗАДАЧИ
                     *//*   Long ПолучаемUUIDТекущйПозицииВRecyreView = AccessibilityNodeInfoДанныеДляViewCard.getAvailableExtraData().stream().map(Long::new)
                                .distinct() .sorted(Collections.reverseOrder()).collect(Collectors.toList()).get(holder.getAdapterPosition()).longValue();*//*

                            // TODO: 13.03.2022
                            Long ПолучаемUUIDТекущйПозицииВRecyreView = BungleДанныеДляViewCard.getLong((String.valueOf(holder.getAdapterPosition())), 0l);


                            Log.i(this.getClass().getName(), "  BungleДанныеДляViewCard   " + BungleДанныеДляViewCard.getLong((String.valueOf(holder.getAdapterPosition())), 0l) +
                                    " ПолучаемUUIDТекущйПозицииВRecyreView " + ПолучаемUUIDТекущйПозицииВRecyreView);


// TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  СтатусПрочтеаУжеЗадачаИлиНет " + СтатусПрочтеаУжеЗадачаИлиНет
                                    + " ПолучаемUUIDТекущйПозицииВRecyreView " + ПолучаемUUIDТекущйПозицииВRecyreView);


                            // TODO: 03.03.2022  запускам сменты статуса

                            if (Integer.parseInt(String.valueOf(СтатусПрочтеаУжеЗадачаИлиНет)) == 0 && ПолучаемUUIDТекущйПозицииВRecyreView != null) {

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
                            }

                            // TODO: 03.03.2022 update screewn

                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1" +
                                    "   ПолучаемUUIDТекущйПозицииВRecyreView " + ПолучаемUUIDТекущйПозицииВRecyreView +
                                    " holder.getAdapterPosition() " + holder.getAdapterPosition());

                            // TODO: 13.03.2022
                            // notifyDataSetChanged();

                            return true;

                        }
                    });*/
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

            // TODO: 15.03.2022  третий слушатель просто клик

            private void МетодБиндингаСлушателейТретьийСлушательПростоКликДляCard(MyViewHolder holder) {
                // TODO: 01.03.2022 слушатели

                try {

// TODO: 01.03.2022 слушатели
                    holder.materialCardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // TODO: 01.03.2022
              /*              Integer ИндексСамогоПримечаниезадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("callsback_note_task");
                            // TODO: 02.03.2022
                            String СамогоПримечанияЗАДАНИЯ = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getString(ИндексСамогоПримечаниезадачи);*/

                            String СамогоПримечанияЗАДАНИЯ = BungleДанныеДляViewCardBungle.getString(String.valueOf(holder.getLayoutPosition()));

// TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  СамогоПримечанияЗАДАНИЯ " + СамогоПримечанияЗАДАНИЯ + " holder.getLayoutPosition() " + holder.getLayoutPosition() +
                                    " BungleДанныеДляViewCardBungle " + BungleДанныеДляViewCardBungle);

                            // TODO: 01.04.2022
                            СамогоПримечанияЗАДАНИЯ = Optional.ofNullable(СамогоПримечанияЗАДАНИЯ).orElse("");


                            // TODO: 01.04.2022  дополнительный Bungle для ID

                            Integer СамогоПримечанияЗАДАНИЯ_ID = BungleДанныеДляViewCardBungleID.getInt(String.valueOf(holder.getLayoutPosition()));

                            // TODO: 01.04.2022
                            СамогоПримечанияЗАДАНИЯ_ID = Optional.ofNullable(СамогоПримечанияЗАДАНИЯ_ID).orElse(0);


                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  СамогоПримечанияЗАДАНИЯ " + СамогоПримечанияЗАДАНИЯ_ID + " holder.getLayoutPosition() " + holder.getLayoutPosition() +
                                    " BungleДанныеДляViewCardBungleID " + BungleДанныеДляViewCardBungleID);


                            if (СамогоПримечанияЗАДАНИЯ.isEmpty() && СамогоПримечанияЗАДАНИЯ_ID == 0) {
                                // TODO: 30.03.2022 ЗАПУСКАЕМ ЕЩЕ НЕТ СТАТУСА ЗАДАЧИ
                                Bundle bundleПередачаПараметровФрагментов = new Bundle();

                                // TODO: 13.03.2022
                                Log.d(this.getClass().getName(), "   Fragment4_Now_Views_Task_For_Complete SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1   ПозицияЭлментаVIewCardДополнительно  " +
                                        " holder.getAdapterPosition() " + holder.getAdapterPosition() + " v.getTag() " + v.getTag(holder.materialCardView.getId()));
                                // TODO: 09.03.2022
                                fragmentTransactionляЗадачи = fragmentManagerДляЗадачи.beginTransaction();

                                // TODO: 23.03.2022  переходим на фрагмент для редактирования Fragment4_Now_Views_Task_For_Complete

                                fragment_ТекущийФрагмент = new Fragment4_Now_Views_Task_For_Complete();
                                // TODO: 11.03.2022
                                fragmentTransactionляЗадачи.replace(R.id.activity_main_fisrt_for_tasks, fragment_ТекущийФрагмент).commit();//.layout.activity_for_fragemtb_history_tasks
                                // TODO: 10.03.2022
                                fragmentTransactionляЗадачи.show(fragment_ТекущийФрагмент);


                                // TODO: 10.03.2022
                                Log.d(this.getClass().getName(), " fragmentTransactionляЗадачи " + fragmentTransactionляЗадачи +
                                        " bundleПередачаПараметровФрагментов " + bundleПередачаПараметровФрагментов);


                                // TODO: 13.03.2022
                                Long ПолучаемUUIDТекущйПозицииВRecyreViewДляПередачиВЧетвртыйФрагмент
                                        = BungleДанныеДляViewCard.getLong((String.valueOf(holder.getAdapterPosition())), 0l);

                                // TODO: 24.03.2022

                                bundleПередачаПараметровФрагментов.putLong("ПередаемВЧетвертыйФрагмендляСменыСтатуса", ПолучаемUUIDТекущйПозицииВRecyreViewДляПередачиВЧетвртыйФрагмент);


                                // TODO: 13.03.2022  статус прочтения ли уде или нет адание

                                Object СтатусПрочтеаУжеЗадачаИлиНет = v.getTag(holder.materialCardView.getId());//TODO holder.materialCardView.getId()
                                // TODO: 24.03.2022
                                Integer СтатусПрочтеаУжеЗадачаИлиНетФинал = Integer.parseInt(String.valueOf(СтатусПрочтеаУжеЗадачаИлиНет));

                                // TODO: 24.03.2022
                                Log.d(this.getClass().getName(), " СтатусПрочтеаУжеЗадачаИлиНетФинал " + СтатусПрочтеаУжеЗадачаИлиНетФинал);
                                // TODO: 24.03.2022

                                bundleПередачаПараметровФрагментов.putInt("СтатусПрочтеаУжеЗадачаИлиНет", СтатусПрочтеаУжеЗадачаИлиНетФинал);

                                // TODO: 24.03.2022
                                Integer НомерзадчиДЛяПередачи = Integer.parseInt(String.valueOf(holder.textView2.getText().toString().replaceAll("[^0-9]", "").trim()));

                                // TODO: 24.03.2022
                                bundleПередачаПараметровФрагментов.putInt("НомерЗадачиДляПередачи", НомерзадчиДЛяПередачи);

                                // TODO: 10.03.2022
                                Log.d(this.getClass().getName(), " bundleПередачаПараметровФрагментов " + bundleПередачаПараметровФрагментов +
                                        "   ПолучаемUUIDТекущйПозицииВRecyreViewДляПередачиВЧетвртыйФрагмент " + ПолучаемUUIDТекущйПозицииВRecyreViewДляПередачиВЧетвртыйФрагмент +
                                        "  НомерзадчиДЛяПередачи " + НомерзадчиДЛяПередачи);


                                // TODO: 24.03.2022   передча данных друговвова фрагмента
                                fragment_ТекущийФрагмент.setArguments(bundleПередачаПараметровФрагментов);
                                // TODO: 10.03.2022

                                // TODO: 15.03.2022
                                // TODO: 14.03.2022
                                //bottomNavigationКонкретноКнопкаСоздатьСейчас.setVisibility(View.GONE);
                                // TODO: 09.03.2022
                                bottomNavigationViewДляTasks.requestLayout();
                                // TODO: 24.03.2022
                                recyclerView.requestLayout();
                                // TODO: 30.03.2022
                                recyclerView.invalidate();
                                // TODO: 30.03.2022
                                recyclerView.requestFocus();
                                // TODO: 14.03.2022
                                linearLayou.requestLayout();

                                // TODO: 03.03.2022 update screewn
                            }


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


            // TODO: 29.03.2022  слутаеть смены статуса


            // TODO: 29.03.2022  метод регмстарцмии локального брод кастера доля смен задачи

            private void МетодРелистарцииЛокальногоБродкастераПослеСменыСтатусаЗадачи(MyViewHolder holder) {

                try {

                    Log.d(this.getClass().getName(), "  МетодЗапускПослеНажатияНАНовойФормеНАКнопкуУстановитьПослеУспешнойЗагрузкиНовогоПОТабельныйУчётПоказываемЕгоПользователю");

                    // TODO: 25.03.2022 Создание Локального БродКстаера

                    holder.localBroadcastManagerПриСменеСтатусаЗадачи = LocalBroadcastManager.getInstance(getContext());
                    // TODO: 25.03.2022
                    holder.broadcastReceiverПриСменеСтатуса = new BroadcastReceiver() {
                        @Override
                        public void onReceive(Context context, Intent intent) {

                            // TODO: 29.03.2022

                            recyclerView.requestLayout();

                            recyclerView.invalidate();


                            bottomNavigationViewДляTasks.requestLayout();


                            linearLayou.requestLayout();


                        }
                    };

                    // TODO: 25.03.2022 установливаем настройки Фильмо к Локальному БродКсстеру
                    IntentFilter intentFilterУстановка = new IntentFilter();
                    // TODO: 25.03.2022
                    intentFilterУстановка.addAction("LocalBroadcastManagerСменаСтатусаЗадачи");

                    holder.localBroadcastManagerПриСменеСтатусаЗадачи.registerReceiver(holder.broadcastReceiverПриСменеСтатуса, intentFilterУстановка);


                    // TODO: 01.03.2022*/
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


            private void МетодБиндингаСлушательisChered(MyViewHolder holder) {
                // TODO: 14.03.2022

                try {
                    holder.materialCardView.setOnCheckedChangeListener(new MaterialCardView.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(MaterialCardView card, boolean isChecked) {
                            // TODO: 13.03.2022
                            int ИндексдляНепрочитанный = 0;
                            // TODO: 13.03.2022
                            // TODO: 13.03.2022
                            Drawable drawableИндексдляНепрочитанный;
                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), " card  " + card +
                                    "  holder.getAdapterPosition() " + holder.getAdapterPosition() + " isChecked " + isChecked);

                            // TODO: 02.03.2022#5

                            Integer ИндексСтатусПрочтенияИлиНЕт = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getColumnIndex("status_write");
                            // TODO: 02.03.2022
                            Integer СамСтатусПрочтенияИлиНет = 0;


                            СамСтатусПрочтенияИлиНет = Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getInt(ИндексСтатусПрочтенияИлиНЕт);

                            // TODO: 30.03.2022

                            Log.d(this.getClass().getName(), " card  " + card +
                                    "  holder.getAdapterPosition() " + holder.getAdapterPosition() + " СамСтатусПрочтенияИлиНет " + СамСтатусПрочтенияИлиНет);

                            // TODO: 30.03.2022 делаем дизай про значению какойе прочтиатное или отказаноо
                            switch (СамСтатусПрочтенияИлиНет) {
                                // TODO: 30.03.2022  
                                case 0:
                                    // TODO: 30.03.2022
                                    ИндексдляНепрочитанный = R.drawable.icon_dsu1_for_tasks_new1;// TODO: 30.03.2022   old 1
                                    // TODO: 30.03.2022
                                    card.setCheckedIconTint(ColorStateList.valueOf(Color.BLACK));
                                    break;

                                case 1:
                                    // TODO: 30.03.2022  
                                    ИндексдляНепрочитанный = R.drawable.icon_dsu1_fortasks_cardview_color_geeeey;// TODO: 30.03.2022   old 1
                                    // TODO: 30.03.2022
                                    card.setCheckedIconTint(ColorStateList.valueOf(Color.parseColor("#00CED1")));
                                    // TODO: 30.03.2022  
                                    break;

                                case 2:

                                    // TODO: 25.03.2022
                                    ИндексдляНепрочитанный = R.drawable.icon_dsu1_fragment1_deseble_tasks;  // TODO: 30.03.2022  for 2
                                    // TODO: 30.03.2022
                                    // TODO: 30.03.2022
                                    card.setCheckedIconTint(ColorStateList.valueOf(Color.RED));
                                    break;

                                // TODO: 30.03.2022  

                                default:
                                    // TODO: 30.03.2022

                                    Log.d(this.getClass().getName(), " card  " + card +
                                            "  holder.getAdapterPosition() " + holder.getAdapterPosition() + " isChecked " + isChecked);

                                    break;

                            }
                            // TODO: 30.03.2022  
                            drawableИндексдляНепрочитанный
                                    = getContext().getDrawable(ИндексдляНепрочитанный);
                            // TODO: 13.03.2022
                            card.setCheckedIcon(drawableИндексдляНепрочитанный);
                            // TODO: 13.03.2022
                            card.setCheckedIconResource(ИндексдляНепрочитанный);

                            // TODO: 13.03.2022
                            card.setSelected(true);
                            // TODO: 30.03.2022
                            card.requestFocus();
                            // TODO: 30.03.2022
                            card.requestLayout();
                            // TODO: 30.03.2022
                            card.invalidate();
                            // TODO: 30.03.2022
                            // TODO: 30.03.2022
                            recyclerView.requestLayout();
                            // TODO: 30.03.2022
                            recyclerView.invalidate();

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
            // TODO: 04.03.2022


            @Override
            public long getItemId(int position) {
                // TODO: 04.03.2022

                Log.i(this.getClass().getName(), "     getItemId holder.position " + position);

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

                Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхДляЗАДАЧTASK " + Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри);
                // TODO: 28.02.2022
                return Курсор_ДляПолученияДАнныхДляЗАДАЧTASKВнутри.getCount();
            }
        }//TODO  конец два

    }   // TODO: 28.02.2022 конец класса бизнес логики   // TODO: 28.02.2022 конец класса бизнес логики

    // TODO: 02.03.2022


    // TODO: 28.02.2022 бизнес -логика    для активти


}    // TODO: 28.02.2022 конец класса бизнес логики для фрагмента 1






























