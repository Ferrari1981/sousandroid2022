package com.dsy.dsu.Code_For_Tasks_КодДля_Задания;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteCursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.dsy.dsu.CREATE_DATABASE;
import com.dsy.dsu.Class_GRUD_SQL_Operations;
import com.dsy.dsu.Class_Generation_Errors;
import com.dsy.dsu.Class_Generations_PUBLIC_CURRENT_ID;
import com.dsy.dsu.PUBLIC_CONTENT;
import com.dsy.dsu.R;
import com.dsy.dsu.SubClass_Starting_chahge_status_public_notificaton;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;


public class Fragment1_One_Tasks extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    protected View viewДляПервойКнопкиHome_Задания = null;
    // TODO: 10.03.2022
    protected SubClassBuccessLogin_ГлавныйКлассБизнесЛогики subClassBuccessLogin_главныйКлассБизнесЛогики;
    // TODO: 28.02.2022
    protected RecyclerView recyclerView;
    // TODO: 01.03.2022
    protected Bundle BungleДанныеДляViewCard;
    // TODO: 13.03.2022
    protected MyRecycleViewAdapter myRecycleViewAdapter;
    // TODO: 14.03.2022
    protected MyViewHolder myViewHolder;
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
    protected Vibrator вибратор;
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
    protected BottomNavigationItemView bottomNavigationКонкретноКнопкаСоздатьСейчас;
    // TODO: 09.03.2022
    protected BottomNavigationItemView bottomNavigationКонкретноКнопкаКонтролируемыеЗадачи;


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

            // TODO: 14.03.2022  данные на carvview
            BungleДанныеДляViewCard = new Bundle();

            // TODO: 10.03.2022 выбратор
            вибратор = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);


            // TODO: 10.03.2022 manager fragmenot

            fragmentManagerДляЗадачи = getActivity().getSupportFragmentManager();
            // TODO: 14.03.2022

            linearLayou = (LinearLayout) getActivity().findViewById(R.id.activity_main_fisrt_for_tasks);

            // TODO: 14.03.2022
            // TODO: 06.03.2022
            bottomNavigationViewДляTasks = (BottomNavigationView) viewДляПервойКнопкиHome_Задания.findViewById(R.id.bottomnavigationActiviTask8);

            // TODO: 14.03.2022  тут обьявляем три кнопки доьавить контроль и новая задача

            bottomNavigationКонкретноКнопкаДобавить = bottomNavigationViewДляTasks.findViewById(R.id.id_taskCreateNewTasks);

            // TODO: 14.03.2022  тут обьявляем три кнопки доьавить контроль и новая задача

            bottomNavigationКонкретноКнопкаСоздатьСейчас = bottomNavigationViewДляTasks.findViewById(R.id.id_taskNowCreateNewTask);
            // TODO: 14.03.2022  тут обьявляем три кнопки доьавить контроль и новая задача

            bottomNavigationКонкретноКнопкаКонтролируемыеЗадачи = bottomNavigationViewДляTasks.findViewById(R.id.id_taskHome);
            // TODO: 14.03.2022
            //  bottomNavigationКонкретноКнопкаКонтролируемыеЗадачи.performLongClick();
            bottomNavigationКонкретноКнопкаСоздатьСейчас.setSelected(true);
            // TODO: 15.03.2022
            bottomNavigationКонкретноКнопкаСоздатьСейчас.setVisibility(View.GONE);

            // TODO: 14.03.2022 перегрузка фрагмента
            bottomNavigationViewДляTasks.requestLayout();
            // TODO: 14.03.2022
            linearLayou.requestLayout();

            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики imageView  onViewCreated ");

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
    public void onStart() {
        super.onStart();

        try {
            ///   getResources().getDrawable(this,R.drawable.icon_dsu1_add_organisazio_success
            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики imageView  Fragment1_One_Tasks  onStart");

            // TODO: 02.03.2022
            ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(getContext()).ПолучениеПубличногоТекущегоПользователяID();


            //TODO код для recycleviews
            subClassBuccessLogin_главныйКлассБизнесЛогики = new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики(getContext(), getActivity());

            // TODO: 10.03.2022

            Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);

            subClassBuccessLogin_главныйКлассБизнесЛогики.МетодПолучениеТОлЬКоКурсораДЛяПолучнеиеКоличетсовЗадачТолькоДляКоторыхВРАботе(ПубличныйIDДляФрагмента);

            Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);


            // TODO: 02.03.2022 получения курсора
            subClassBuccessLogin_главныйКлассБизнесЛогики.МетодПолучениеДанныхДляЗАДАЧ();

            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  " + Курсор_ГлавныйКурсорДляЗадач);

            // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА

            subClassBuccessLogin_главныйКлассБизнесЛогики.new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодСлушательObserverДляКурсора();


            // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ  второай слушатель только количество данных СЛУШАТЕЛЬ КУРСОРРА

            subClassBuccessLogin_главныйКлассБизнесЛогики.new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодСлушательObserverДляКурсораТолькоКоличество();

            // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА туту запускам два слушателя дялнаших work manager

            subClassBuccessLogin_главныйКлассБизнесЛогики.new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодСоздаенияСлушателяДляОбщейWorkMAnager();

            // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА туту запускам два слушателя дялнаших work manager

            subClassBuccessLogin_главныйКлассБизнесЛогики.new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодСоздаенияСлушателяДляЧатаWorkMAnager();


        //todo метод  ИНИЦИАЛИЗАЦИИ RECYCLEVIEW ДЛЯ АКТИВТИ ЗАДАЧИ

            subClassBuccessLogin_главныйКлассБизнесЛогики.new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодИнициализацииRecycleViewДляЗадач();

            // TODO: 05.03.2022  ДЛЯ ИНИЗАЛИЗАЦИИ НИЖНИХ КНОПОК
            subClassBuccessLogin_главныйКлассБизнесЛогики.new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодСозданиеНавигаторКнопок();

            // TODO: 05.03.2022  СТАТУС ЗНАЧКА С ДОПОЛНИТЕЛЬНЫЙ СТАТУСОМ
            subClassBuccessLogin_главныйКлассБизнесЛогики.new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);

            Log.d(this.getClass().getName(), " нет данных для отображения " +
                    "отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  МетодКпопкаСоЗачкомКраснымДополнительныйСтатус  " + Курсор_ГлавныйКурсорДляЗадач +
                    " Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);

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
    public void onDestroyView() {
        super.onDestroyView();
        try {
            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики onDestroyView  " +
                    "" + adapterDataObserverObserverСлушатель +
                    " dataSetObserverДляКурсора " + dataSetObserverДляКурсора);
            // TODO: 04.03.2022 закрываем слушатель  recycreview
            if (adapterDataObserverObserverСлушатель != null && myRecycleViewAdapter != null) {
                // TODO: 04.03.2022
                myRecycleViewAdapter.unregisterAdapterDataObserver(adapterDataObserverObserverСлушатель);
// TODO: 04.03.2022 закрываем слушатель  curcor
            }
            // TODO: 14.03.2022
            if (dataSetObserverДляКурсора != null && Курсор_ГлавныйКурсорДляЗадач != null) {
                // TODO: 04.03.2022
                Курсор_ГлавныйКурсорДляЗадач.unregisterDataSetObserver(dataSetObserverДляКурсора);
            }
            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики   " +
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
                WorkManager.getInstance(getContext()).getWorkInfosByTagLiveData(ИмяСлужбыОдноразоваяСинхронизацииДляЗадачиИзЧата).removeObserver(observerОдноразоваяДляWORKMANAGERДляРасписанияДполнительнаяОтЧата);
            }

// TODO: 04.03.2022
            Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики  ИмяСлужбыСинхронизацииДляЗадачиИзЧата  " +
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


    class SubClassBuccessLogin_ГлавныйКлассБизнесЛогики {
        // TODO: 28.02.2022
        Context context;
        // TODO: 14.03.2022
        Activity activity;
        public SubClassBuccessLogin_ГлавныйКлассБизнесЛогики(Context context, Activity activity) {
            // TODO: 14.03.2022
            this.context = context;
            // TODO: 14.03.2022
            this.activity = activity;
            Log.d(this.getClass().getName(), "  public SubClassBuccessLogin_ГлавныйКлассБизнесЛогики(Context context, Activity activity)   " + context);
        }

        // TODO: 14.03.2022
        void МетодПолучениеДанныхДляЗАДАЧ() {
            // TODO: 02.03.2022
            try {
                // TODO: 02.03.2022
                Integer ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(getContext()).ПолучениеПубличногоТекущегоПользователяID();
                // TODO: 02.03.2022
                Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);
                // TODO: 14.03.2022
                Курсор_ГлавныйКурсорДляЗадач = МетодПолучениеТОлЬКоКурсораДЛяПолучнеиеКоличетсовЗадач(ПубличныйIDДляФрагмента);
                // TODO: 02.03.2022
                Log.d(this.getClass().getName(), "Курсор_ГлавныйКурсорДляЗадач " + Курсор_ГлавныйКурсорДляЗадач);
                // TODO: 02.03.2022
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
        SQLiteCursor МетодПолучениеТОлЬКоКурсораДЛяПолучнеиеКоличетсовЗадач(Integer ПубличноеIDПолученныйИзСервлетаДляUUID)
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
        protected class SubClassObsevers_КлассСлушательСобытий {
            // TODO: 14.03.2022
            public SubClassObsevers_КлассСлушательСобытий(Context context) {
            }

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
                            // TODO: 04.03.2022
                            if (Курсор_ГлавныйКурсорДляЗадач.getCount() > 0) {
                                // TODO: 04.03.2022
                                Курсор_ГлавныйКурсорДляЗадач.moveToFirst();
                            }
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
                            вибратор.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));

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
                    // TODO: 04.03.2022 запускаем слушатель
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
            void МетодИнициализацииRecycleViewДляЗадач() {
                try {
                    Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  " + Курсор_ГлавныйКурсорДляЗадач);
                    // TODO: 04.03.2022  В ДАННОМ КОДЕ МЫ ОПЕРДЕЛЯЕМ КАКОЙ ЭКОРАН БУДЕМ ЗАГРУЖАТЬ В ЗАВПИСИМОСТИ ЕСЛИ ЛИ ДАННЫЫЕ ЗАДАЧИ
                    if (Курсор_ГлавныйКурсорДляЗадач.getCount() > 0) {
                        // TODO: 03.03.2022
                        Log.d(this.getClass().getName(), " есть данные для отображения " +
                                "отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики  Курсор_ГлавныйКурсорДляЗадач  " + Курсор_ГлавныйКурсорДляЗадач);
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
                                "отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики  Курсор_ГлавныйКурсорДляЗадач  " + Курсор_ГлавныйКурсорДляЗадач);


                        // TODO: 28.02.2022
                        myRecycleViewAdapter = new MyRecycleViewAdapter(Курсор_ГлавныйКурсорДляЗадач);
                        // TODO: 04.03.2022
                        recyclerView.setAdapter(myRecycleViewAdapter);
                        // TODO: 13.03.2022
                        Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики recyclerView   " + recyclerView);
                        // TODO: 05.03.2022  СТАТУС ЗНАЧКА С ДОПОЛНИТЕЛЬНЫЙ СТАТУСОМ когнданет записей  МетодИнициализацииRecycleViewДляЗадачМетодИнициализацииRecycleViewДляЗадач
                        МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);
                        // TODO: 14.03.2022
                        Log.d(this.getClass().getName(), "onItemRangeMoved  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе +
                                " Курсор_ДляПолученияДАнныхДляЗАДАЧTASK " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);
                        // TODO: 14.03.2022
                        linearLayou.requestLayout();
                        // TODO: 04.03.2022 создаем слушатель    третий класс создаем класс слушаителй  ДАННЫЙ КОД ЗАПУСКАЕТЬСЯ ПОСЛЕ СОЗДАЕНИЯ И УСТАНОВКИ АДАПТЕРА RECYCLEVIEW
                        subClassBuccessLogin_главныйКлассБизнесЛогики.new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодСлушательObserverДляRecycleView();

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
                        textViewisnull.setText("Нет задач !!!".toUpperCase());
                        // TODO: 28.02.2022
                        linearLayou.addView(textViewisnull);
                        // TODO: 06.03.2022
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        // TODO: 28.02.2022
                        linearLayou.setLayoutParams(layoutParams);
                        // TODO: 28.02.2022
                        linearLayou.requestLayout();
                        // TODO: 28.02.2022
                        Log.d(this.getClass().getName(), " нет данных для отображения " +
                                "отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики  Курсор_ГлавныйКурсорДляЗадач  " + Курсор_ГлавныйКурсорДляЗадач);
                    }
                    // TODO: 13.03.2022
                    bottomNavigationViewДляTasks.requestLayout();
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
                                        Log.d(this.getClass().getName(), " R.id.id_taskHome отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики  fragmentTransactionляЗадачи  "
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
                                        вибратор.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                                        // TODO: 15.03.2022
                                        // TODO: 14.03.2022
                                        bottomNavigationКонкретноКнопкаСоздатьСейчас.setVisibility(View.GONE);
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
                                        вибратор.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                                        // TODO: 14.03.2022
                                        bottomNavigationViewДляTasks.requestLayout();
                                        // TODO: 14.03.2022
                                        linearLayou.requestLayout();
                                        Log.d(this.getClass().getName(), " bottomNavigationViewДляTasks.getChildCount() " + bottomNavigationViewДляTasks.getChildCount());

                                        // TODO: 14.03.2022  дополнительно визуализируем


                                        break;
                                    // TODO: 09.03.2022////

                                    case R.id.id_taskNowCreateNewTask:
                                        // TODO: 09.03.2022
                                        Log.d(this.getClass().getName(), " R.id.id_taskCreateNewTasks  item.getItemId() " + item.getItemId());
                                        // TODO: 10.03.2022
                                        item.setChecked(true);
                                        // TODO: 09.03.2022
                                        fragment_ТекущийФрагмент = new Fragment3_Now_Create_Tasks();
                                        // TODO: 11.03.2022
                                        fragmentTransactionляЗадачи.replace(R.id.activity_main_fisrt_for_tasks, fragment_ТекущийФрагмент).commit();//.layout.activity_for_fragemtb_history_tasks
                                        // TODO: 10.03.2022
                                        fragmentTransactionляЗадачи.show(fragment_ТекущийФрагмент);
                                        // TODO: 10.03.2022
                                        Log.d(this.getClass().getName(), " fragmentTransactionляЗадачи " + fragmentTransactionляЗадачи);
                                        // TODO: 10.03.2022
                                        вибратор.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                                        // TODO: 09.03.2022
                                        bottomNavigationViewДляTasks.requestLayout();
                                        // TODO: 14.03.2022
                                        linearLayou.requestLayout();
                                        Log.d(this.getClass().getName(), " bottomNavigationViewДляTasks.getChildCount() " + bottomNavigationViewДляTasks.getChildCount());

                                        // TODO: 14.03.2022  дополнительно визуализируем


                                        break;
                                    // TODO: 09.03.2022
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
        }

    }

    // TODO: 28.02.2022 конец класса
    private class MyViewHolder extends RecyclerView.ViewHolder {
        // TODO: 28.02.2022
        TextView textView1, textView2, textView3, textView4, textView5;
        // TODO: 13.03.2022
        MaterialCardView materialCardView;
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
                Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики itemView   " + itemView);
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
                Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики materialCardView  textView2 " + textView4);
                // TODO: 01.03.2022
                materialCardView = (MaterialCardView) itemView.findViewById(R.id.cardviewmatirealtask);
                // TODO: 13.03.2022
                Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогики materialCardView   " + materialCardView);
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
    }


    // TODO: 28.02.2022 ViewHolder

    protected class MyRecycleViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
        // TODO: 04.03.2022
        SQLiteCursor Курсор_ДляПолученияДАнныхДляЗАДАЧTASK;
        public MyRecycleViewAdapter(@NotNull SQLiteCursor Курсор_ДляПолученияДАнныхДляЗАДАЧTASK) {
            // super();
            // TODO: 04.03.2022
            this.Курсор_ДляПолученияДАнныхДляЗАДАЧTASK = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK;
            if (Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount() > 0) {
                // TODO: 04.03.2022
                Log.i(this.getClass().getName(), "   MyRecycleViewAdapter   Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount()>" + Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount());
            }
            Log.i(this.getClass().getName(), "     getItemId holder.position ");
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // TODO: 10.03.2022
            View viewГлавныйВидДляRecyclleViewДляЗаданий=null ;
            try {
                // TODO: 28.02.2022
                viewГлавныйВидДляRecyclleViewДляЗаданий = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_for_takst_cardview1, parent, false);
                // TODO: 05.03.2022
                Log.i(this.getClass().getName(), "   viewГлавныйВидДляRecyclleViewДляЗаданий" + viewГлавныйВидДляRecyclleViewДляЗаданий);
                // TODO: 28.02.2022
                myViewHolder = new MyViewHolder(viewГлавныйВидДляRecyclleViewДляЗаданий);
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
                // TODO: 14.03.2022
                if (position <= Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount()) {

                    // TODO: 02.03.2022 тут РАЗДАЕМ ДАННЫЕ RECYCLERBIEW

                    Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.move(position);
                    // TODO: 04.03.2022 p==osion
                    Log.i(this.getClass().getName(), "  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getPosition() " + Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getPosition());


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


                    // TODO: 03.03.2022 ПОЛУЧАЕМ СТАТУС ЗАДАНИЯ ПРОЧИТАН ИЛИ НЕТ

                    Integer СамСтатусПрочтенияИлиНет = МетодБиндингаПолученияСтатусаЗадачи(holder);


                    // TODO: 02.03.2022#5  получаем ТИП ЗАДАЧИ
                    МетодБиндингПолучаемТипЗадания(holder);


                    // TODO: 02.03.2022#5  заполем ДАННЫМИ BUNGLE САМОЙ ЗАДАЧИ//

                    МетодБиндингаЗаполненияДаннымиBungle(holder, СамСтатусПрочтенияИлиНет);

                    Log.i(this.getClass().getName(), "      holder.textView1  accessibilityNodeInfo " + BungleДанныеДляViewCard + " СамСтатусПрочтенияИлиНет " + СамСтатусПрочтенияИлиНет);


                    // TODO: 13.03.2022 настройки для carview

                    holder.materialCardView.toggle();

                    // TODO: 13.03.2022
                    holder.materialCardView.setChecked(true);

// TODO: 28.02.2022
                }
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

                Integer ИндексUUIDДЛяЗАДАНИЯКотореВыбрали = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("uuid");///"uuid_notifications"
                // TODO: 02.03.2022 получет UUID строчки

                Long UUIDДЛяЗАДАНИЯКотореВыбрали = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getLong(ИндексUUIDДЛяЗАДАНИЯКотореВыбрали);

                Log.i(this.getClass().getName(), "  UUIDДЛяЗАДАНИЯКотореВыбрали " + UUIDДЛяЗАДАНИЯКотореВыбрали);

                // TODO: 13.03.2022

                Integer позиция = holder.getAdapterPosition();

                Log.i(this.getClass().getName(), "  позиция " + позиция);

                    // TODO: 14.03.2022  заполем данными для получение  UUID вышке
                    BungleДанныеДляViewCard.putLong(String.valueOf(позиция), UUIDДЛяЗАДАНИЯКотореВыбрали);



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
                Integer ИндексСтатусТипаЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("type_tasks");
                // TODO: 02.03.2022

                String СамТипЗадания = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getString(ИндексСтатусТипаЗадачи);

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

                Integer ИндексСтатусПрочтенияИлиНЕт = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("status_write");
                // TODO: 02.03.2022

                СамСтатусПрочтенияИлиНет = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getInt(ИндексСтатусПрочтенияИлиНЕт);
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
                Integer ИндексКтоНаписалСообщение = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("user_update");
                // TODO: 02.03.2022
                Integer КтоНаписалСообщениеФИОдЛПосика = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getInt(ИндексКтоНаписалСообщение);
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
                Integer ИндексПолучаемДатыЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("date_update");
                // TODO: 02.03.2022
                String СамаДАтаЗадачиТекущей = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getString(ИндексПолучаемДатыЗадачи);
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
                Integer ИндексПолучаемIDЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("id");
                // TODO: 02.03.2022
                Integer IDЗадачиТекущей = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getInt(ИндексПолучаемIDЗадачи);
                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), "  IDЗадачиТекущей " + IDЗадачиТекущей);
                // TODO: 28.02.2022
                holder.textView2.setText("#" + String.valueOf(IDЗадачиТекущей));
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
                Integer ИндексСамогоСообщенияЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("message");
                // TODO: 02.03.2022
                String СамогоСообщенияЗадачиДляПользователя = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getString(ИндексСамогоСообщенияЗадачи);
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


        // TODO: 13.03.2022


        private void МетодБиндингаСлушателейДляViewCard(MyViewHolder holder) {
            // TODO: 01.03.2022 слушатели

            try {

// TODO: 01.03.2022 слушатели

                holder.materialCardView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        // TODO: 01.03.2022

                        // TODO: 10.03.2022
                        вибратор.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));

                        // TODO: 13.03.2022
                        Log.d(this.getClass().getName(), "  SubClassBuccessLogin_ГлавныйКлассБизнесЛогики   ПозицияЭлментаVIewCardДополнительно  " +
                                " holder.getAdapterPosition() " + holder.getAdapterPosition() + " v.getTag() " + v.getTag(holder.materialCardView.getId()));

                        // TODO: 13.03.2022  статус прочтения ли уде или нет адание

                        Object СтатусПрочтеаУжеЗадачаИлиНет = v.getTag(holder.materialCardView.getId());//TODO holder.materialCardView.getId()


                        // TODO: 13.03.2022
                        Log.d(this.getClass().getName(), "  SubClassBuccessLogin_ГлавныйКлассБизнесЛогики   ПозицияЭлментаVIewCardДополнительно  СтатусПрочтеаУжеЗадачаИлиНет " + СтатусПрочтеаУжеЗадачаИлиНет);
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

                        if (Integer.parseInt(String.valueOf(СтатусПрочтеаУжеЗадачаИлиНет)) == 0 && ПолучаемUUIDТекущйПозицииВRecyreView != null) {

                            ///
                            String ИмяСлужбыУведомленияДляЧата = "WorkManager NOtofocationForChat";

                            String PROCESS_ID_УведомленияПлановая = "12";

                            // TODO: 03.03.2022

                            SubClass_Starting_chahge_status_public_notificaton subClass_starting_chahge_status_public_notificaton =
                                    new SubClass_Starting_chahge_status_public_notificaton(getContext());

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

                           /*     Log.i(getContext().getClass().getName(), "СтатусПрочтеаУжеЗадачаИлиНет Статус Уже Изменен на 0 " + СтатусПрочтеаУжеЗадачаИлиНет);

                                Toast.makeText(getActivity(), " Статус сменили на ознакомленный  #" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();*/

                            }, 2500);

                        } else {

                            ///////TODO запускаем смены стануса задачи черезе PendingIntent
                            Log.i(getContext().getClass().getName(), "СтатусПрочтеаУжеЗадачаИлиНет Статус Уже Изменен на 1  " + СтатусПрочтеаУжеЗадачаИлиНет);

                            ///   Toast.makeText(getActivity(), " Статус ознакомлена !!!   #" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                        }

                        // TODO: 03.03.2022 update screewn

                        // TODO: 13.03.2022
                        Log.d(this.getClass().getName(), "  SubClassBuccessLogin_ГлавныйКлассБизнесЛогики" +
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

        private void МетодБиндингаСлушательisChered(MyViewHolder holder) {
            // TODO: 14.03.2022

            try {
                holder.materialCardView.setOnCheckedChangeListener(new MaterialCardView.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(MaterialCardView card, boolean isChecked) {
                        // TODO: 13.03.2022
                        int ИндексдляНепрочитанный = R.drawable.icon_dsu1_fortasks_cardview_color_geeeey;
                        // TODO: 13.03.2022
                        int ИндексПпрочитанные = R.drawable.icon_dsu1_fortasks_cardview_color_geen;
                        // TODO: 13.03.2022

                        Drawable drawableПпрочитанные
                                = getContext().getDrawable(ИндексПпрочитанные);
                        // TODO: 13.03.2022
                        Drawable drawableИндексдляНепрочитанный
                                = getContext().getDrawable(ИндексдляНепрочитанный);
                        // TODO: 13.03.2022
                        Log.d(this.getClass().getName(), " card  " + card +
                                "  holder.getAdapterPosition() " + holder.getAdapterPosition() + " isChecked " + isChecked);

                        // TODO: 13.03.2022

                        // TODO: 02.03.2022#5

                        Integer ИндексСтатусПрочтенияИлиНЕт = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("status_write");
                        // TODO: 02.03.2022

                        Integer СамСтатусПрочтенияИлиНет = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getInt(ИндексСтатусПрочтенияИлиНЕт);

                        // TODO: 13.03.2022
                        if (isChecked && СамСтатусПрочтенияИлиНет > 0) {


                            // TODO: 13.03.2022
                            card.setCheckedIcon(drawableИндексдляНепрочитанный);
                            // TODO: 13.03.2022
                            card.setCheckedIconResource(ИндексдляНепрочитанный);

                            // TODO: 13.03.2022
                            // TODO: 13.03.2022
                            card.setSelected(true);
                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  holder.materialCardView.setOnCheckedChangeListener  isChecked   " + isChecked);


                        } else {
                            // TODO: 14.03.2022
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

            Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхДляЗАДАЧTASK " + Курсор_ДляПолученияДАнныхДляЗАДАЧTASK);
            // TODO: 28.02.2022
            return Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount();
        }
    }


    // TODO: 02.03.2022







    // TODO: 28.02.2022 бизнес -логика    для активти




    }    // TODO: 28.02.2022 конец класса






























