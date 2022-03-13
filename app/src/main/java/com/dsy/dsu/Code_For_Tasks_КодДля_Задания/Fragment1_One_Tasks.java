package com.dsy.dsu.Code_For_Tasks_КодДля_Задания;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
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
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;


public class Fragment1_One_Tasks extends Fragment {

    // TODO: Rename parameter arguments, choose names that match

   View viewДляПервойКнопкиHome_Задания = null;
    // TODO: 10.03.2022

    // TODO: 10.03.2022
    private  SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи;

    // TODO: 10.03.2022
    private   SubClass_GET_Data_Tasks_Adapter subClass_get_data_tasks_adapterТретийЧастьБизнесЛогика;
    // TODO: 15.02.2022

    // TODO: 28.02.2022

    // TODO: 28.02.2022
    private  RecyclerView recyclerView;
    // TODO: 01.03.2022

    private   AccessibilityNodeInfo AccessibilityNodeInfoДанныеДляViewCard;

    // TODO: 13.03.2022
    MyRecycleViewAdapter myRecycleViewAdapter;

    private   MyViewHolder myViewHolder;


    // TODO: 04.03.2022

    // TODO: 28.02.2022
    // listforrecycleview listforrecycleview;
    // TODO: 28.02.2022


    // TODO: 02.03.2022
    SQLiteCursor Курсор_ДляПолученияДАнныхДляЗАДАЧTASK = null;
    // TODO: 02.03.2022
    private SQLiteCursor Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе = null;


// TODO: 04.03.2022 Слушатель  recycelview

    RecyclerView.AdapterDataObserver adapterDataObserverObserverСлушатель;

    // TODO: 04.03.2022  слушатель курсора

    DataSetObserver dataSetObserverДляКурсора;

    // TODO: 04.03.2022


    Observer observerОБЩАЯДляWORKMANAGERДляРасписания;
    // TODO: 04.03.2022
    Observer observerОдноразоваяДляWORKMANAGERДляРасписанияДполнительнаяОтЧата;

    // TODO: 04.03.2022
    String ИмяСлужбыОбщейСинхронизацииДляЗадачи = "WorkManager Synchronizasiy_Data";

    // TODO: 04.03.2022
    String ИмяСлужбыОдноразоваяСинхронизацииДляЗадачиИзЧата = "WorkManager Synchronizasiy_Data Disposable";

    // TODO: 05.03.2022

    private BottomNavigationView bottomNavigationViewДляTasks;

    // TODO: 09.03.2022
    Vibrator вибратор;

    // TODO: 09.03.2022
    FragmentManager fragmentManagerДляЗадачи;
    ///
    private   FragmentTransaction fragmentTransactionляЗадачи;

    // TODO: 10.03.2022

    TextView textViewТекущаяЗадача;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {

            Log.d(this.getClass().getName(), "  onViewCreated  Fragment1_One_Tasks view   "+view);

            // TODO: 28.02.2022
// Inflate the layout for this fragment

            Log.d(this.getClass().getName(), "  Fragment1_One_Tasks  viewДляПервойКнопкиHome_Задания " + viewДляПервойКнопкиHome_Задания);


            // TODO: 10.03.2022

            textViewТекущаяЗадача=(TextView) view.findViewById(R.id.activy_task_fragment1_tasksnameеtextview);


            Log.d(this.getClass().getName(), "  Fragment1_One_Tasks  textViewТекущаяЗадача " + textViewТекущаяЗадача+ " view "+view);


            textViewТекущаяЗадача.setText("Задания".toUpperCase());



            ///   getResources().getDrawable(this,R.drawable.icon_dsu1_add_organisazio_success
            Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи imageView   " );

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

        viewДляПервойКнопкиHome_Задания = inflater.inflate(R.layout.activity_main_fragment1_for_tasks, container, false);

        // TODO: 12.03.2022
        Log.d(this.getClass().getName(), " onCreateView  viewДляПервойКнопкиHome_Задания  Fragment1_One_Tasks " +
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

        try{
        ///   getResources().getDrawable(this,R.drawable.icon_dsu1_add_organisazio_success
        Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи imageView  Fragment1_One_Tasks ");

        // TODO: 10.03.2022 выбратор
        вибратор = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);

        // TODO: 10.03.2022 manager fragmenot


        fragmentManagerДляЗадачи=getActivity().getSupportFragmentManager();



        //TODO код для recycleviews
        subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи = new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи(getContext(), getActivity());

        // TODO: 10.03.2022


        subClass_get_data_tasks_adapterТретийЧастьБизнесЛогика=new SubClass_GET_Data_Tasks_Adapter(getContext());


        // TODO: 02.03.2022 получения курсора
        subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи.МетодПолучениеДанныхДляЗАДАЧ();

        Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  "+Курсор_ДляПолученияДАнныхДляЗАДАЧTASK);

        // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА

        subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи. new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодСлушательObserverДляКурсора();


        // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА туту запускам два слушателя дялнаших work manager

        subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи. new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодСоздаенияСлушателяДляОбщейWorkMAnager();

        // TODO: 04.03.2022 создаем слушатель    третий класс создаем ЗАПУСКАЕМ СЛУШАТЕЛЬ КУРСОРРА туту запускам два слушателя дялнаших work manager

        subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи. new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодСоздаенияСлушателяДляЧатаWorkMAnager();


        //todo метод  ИНИЦИАЛИЗАЦИИ RECYCLEVIEW ДЛЯ АКТИВТИ ЗАДАЧИ

        subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи. new SubClassObsevers_КлассСлушательСобытий(getContext()).  МетодИнициализацииRecycleViewДляЗадач();



        // TODO: 05.03.2022  ДЛЯ ИНИЗАЛИЗАЦИИ НИЖНИХ КНОПОК
        // TODO: 05.03.2022  ДЛЯ ИНИЗАЛИЗАЦИИ НИЖНИХ КНОПОК
        subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи. new SubClassObsevers_КлассСлушательСобытий(getContext()). МетодСозданиеНавигаторКнопок();

        // TODO: 05.03.2022  ДЛЯ ИНИЗАЛИЗАЦИИ НИЖНИХ КНОПОК

        // TODO: 05.03.2022  СТАТУС ЗНАЧКА С ДОПОЛНИТЕЛЬНЫЙ СТАТУСОМ
        subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи. new SubClassObsevers_КлассСлушательСобытий(getContext()). МетодКпопкаСоЗачкомКраснымДополнительныйСтатус();

        Log.d(this.getClass().getName(), " нет данных для отображения " +
                "отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  МетодКпопкаСоЗачкомКраснымДополнительныйСтатус  "+Курсор_ДляПолученияДАнныхДляЗАДАЧTASK);



        ///   getResources().getDrawable(this,R.drawable.icon_dsu1_add_organisazio_success
        Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи imageView   " );


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

            Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи   " +
                    "" + adapterDataObserverObserverСлушатель +
                    " dataSetObserverДляКурсора " + dataSetObserverДляКурсора);


            // TODO: 04.03.2022 закрываем слушатель  recycreview

            if (adapterDataObserverObserverСлушатель != null && myRecycleViewAdapter != null) {
                // TODO: 04.03.2022
                myRecycleViewAdapter.unregisterAdapterDataObserver(adapterDataObserverObserverСлушатель);
// TODO: 04.03.2022 закрываем слушатель  curcor
            }


            if (dataSetObserverДляКурсора != null && Курсор_ДляПолученияДАнныхДляЗАДАЧTASK != null) {
                // TODO: 04.03.2022
                Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.unregisterDataSetObserver(dataSetObserverДляКурсора);
            }


            Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи   " +
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
            Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи  ИмяСлужбыСинхронизацииДляЗадачиИзЧата  " +
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


    class SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи {
        // TODO: 28.02.2022
        Context context;

        public SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи(Context context, Activity activity) {

            this.context = context;

            Log.d(this.getClass().getName(), "  SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи   " + context);


        }


        void МетодПолучениеДанныхДляЗАДАЧ() {
            // TODO: 02.03.2022
            try {


                // TODO: 04.03.2022
                // TODO: 02.03.2022
                Integer ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(getContext()).ПолучениеПубличногоТекущегоПользователяID();
                // TODO: 02.03.2022

                Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);


                Курсор_ДляПолученияДАнныхДляЗАДАЧTASK =subClass_get_data_tasks_adapterТретийЧастьБизнесЛогика.МетодПолучениеТОлЬКоКурсораДЛяПолучнеиеКоличетсовЗадач(ПубличныйIDДляФрагмента);

                // TODO: 02.03.2022
                Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхДляЗАДАЧTASK " + Курсор_ДляПолученияДАнныхДляЗАДАЧTASK);

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
                ///


            }
        }

        // TODO: 04.03.2022  класс в котором находяться слушатели
        protected class SubClassObsevers_КлассСлушательСобытий {

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


                            // TODO: 04.03.2022
                            // TODO: 02.03.2022
                            /// subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи.МетодПолучениеДанныхДляЗАДАЧ();
                            // TODO: 04.03.2022
                            if (Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount() > 0) {

                                // TODO: 04.03.2022
                                Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.moveToFirst();

                            }

                            МетодИнициализацииRecycleViewДляЗадач();

                        }

                        @Override
                        public void onItemRangeChanged(int positionStart, int itemCount) {
                            super.onItemRangeChanged(positionStart, itemCount);
                            // TODO: 02.03.2022
                            /////

                            // Vibrate for 500 milliseconds

                            //  вибратор.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));

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
                            // TODO: 02.03.2022

                            //  recyclerView.updateViewLayout(recyclerView, null);


                            // TODO: 04.03.2022
                            recyclerView.getAdapter().notifyDataSetChanged();

                            // TODO: 04.03.2022
                            recyclerView.getAdapter().notifyItemChanged(0);


                            // TODO: 04.03.2022
                            recyclerView.requestLayout();

                            // TODO: 05.03.2022 change ui nivage buttom
                            // TODO: 05.03.2022  ДЛЯ ИНИЗАЛИЗАЦИИ НИЖНИХ КНОПОК



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

                    Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.registerDataSetObserver(dataSetObserverДляКурсора);


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

            // TODO: 04.03.2022 второй метод слушатель для work manager
            // TODO: 18.10.2021  СИНХРОНИАЗЦИЯ ЧАТА ПО РАСПИСАНИЮ ЧАТ
            void МетодСоздаенияСлушателяДляОбщейWorkMAnager() throws ExecutionException, InterruptedException {
                ///
// TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления

                try {

                    // TODO: 27.10.2021


                    // TODO: 16.12.2021  --ОДНОРАЗОВАЯ СИНХРОНИАЗЦИЯ СЛУШАТЕЛЬ

                    observerОБЩАЯДляWORKMANAGERДляРасписания = new Observer<List<WorkInfo>>() {
                        @Override
                        public void onChanged(List<WorkInfo> workInfoОБШАЯ) {


                            // TODO: 23.12.2021
                            workInfoОБШАЯ.stream()
                                    .filter(СтастусWorkMangerДляФрагментаЧитатьИПисать -> СтастусWorkMangerДляФрагментаЧитатьИПисать != null)
                                    .filter(СтастусWorkMangerДляФрагментаЧитатьИПисать ->
                                            СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().compareTo(WorkInfo.State.ENQUEUED) == 0)
                                    .forEachOrdered((СтастусWorkMangerДляФрагментаЧитатьИПисать) -> {
                                        // TODO: 18.02.2022
                                        try {

                                            //

                                            // TODO: 14.01.2022
                                            //
                                            //
                                            Log.d(this.getClass().getName(), " workInfoОБШАЯ  CallBaskОтWorkManagerОдноразового observerОдноразоваяДляWORKMANAGERДляРасписания " +
                                                    СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().name());

                                            // TODO: 04.03.2022
                                            Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.deactivate();

                                            // TODO: 04.03.2022 перезапускаем курсор
                                            Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.requery();

                                            // TODO: 18.02.2022


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


// TODO: 18.02.2022

                    // TODO: 20.02.2022
                    // TODO: 20.02.2022
                    if (observerОБЩАЯДляWORKMANAGERДляРасписания != null) {// TODO: 04.03.2022

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
                ///
// TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления

                try {

                    // TODO: 27.10.2021


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

                                            //

                                            // TODO: 14.01.2022
                                            //
                                            Log.d(this.getClass().getName(), " CallBaskОтWorkManagerОдноразового observerОдноразоваяДляWORKMANAGERДляРасписанияДполнительнаяОтЧата " +
                                                    СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().name());

                                            // TODO: 04.03.2022
                                            Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.deactivate();

                                            // TODO: 04.03.2022 перезапускаем курсор
                                            Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.requery();
                                            // TODO: 18.02.2022


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
                    // TODO: 20.02.2022
                    if (observerОдноразоваяДляWORKMANAGERДляРасписанияДполнительнаяОтЧата != null) {// TODO: 04.03.2022

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

            // TODO: 09.03.202 перенесенный метод

            // TODO: 04.03.2022 прозвомжность инициализации RecycleView
            void МетодИнициализацииRecycleViewДляЗадач() {


                try {


                    Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  " + Курсор_ДляПолученияДАнныхДляЗАДАЧTASK);


// TODO: 02.03.2022


                    // TODO: 04.03.2022  В ДАННОМ КОДЕ МЫ ОПЕРДЕЛЯЕМ КАКОЙ ЭКОРАН БУДЕМ ЗАГРУЖАТЬ В ЗАВПИСИМОСТИ ЕСЛИ ЛИ ДАННЫЫЕ ЗАДАЧИ

                    if (Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount() > 0) {
                        // TODO: 03.03.2022

                        //    setContentView(R.layout.activity_main_history_tasks);
                        // TODO: 03.03.2022
                        Log.d(this.getClass().getName(), " есть данные для отображения " +

                                "отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  " + Курсор_ДляПолученияДАнныхДляЗАДАЧTASK);

                        LinearLayout linearLayou = (LinearLayout) getActivity().findViewById(R.id.activity_main_fisrt_for_tasks);

                        // TODO: 06.03.2022
                        bottomNavigationViewДляTasks = (BottomNavigationView) viewДляПервойКнопкиHome_Задания.findViewById(R.id.bottomnavigationActiviTask8);


                        // TODO: 28.02.2022
                        recyclerView = (RecyclerView) viewДляПервойКнопкиHome_Задания.findViewById(R.id.recycleviewActiviTask);

                        recyclerView.setVisibility(View.VISIBLE);


                        GridLayoutManager gridLayoutManager;


                        gridLayoutManager = new GridLayoutManager(getActivity(), 1);

                        // TODO: 28.02.2022 создаем наш первый RecyclerView
                        recyclerView.setLayoutManager(gridLayoutManager);//TODO new LinearLayoutManager(getContext()) // TODO: 28.02.2022 создаем наш первый RecyclerView recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


                        //    listforrecycleview=    new listforrecycleview();


                        // TODO: 28.02.2022
                        myRecycleViewAdapter = new MyRecycleViewAdapter(Курсор_ДляПолученияДАнныхДляЗАДАЧTASK);

                        // TODO: 09.03.2022
                        // recyclerView.setHasFixedSize(true);


                        // TODO: 04.03.2022

                        recyclerView.setAdapter(myRecycleViewAdapter);

                        Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи recyclerView   " + recyclerView);

                        linearLayou.requestLayout();


                        // TODO: 01.03.2022
                        // TODO: 04.03.2022 создаем слушатель    третий класс создаем класс слушаителй  ДАННЫЙ КОД ЗАПУСКАЕТЬСЯ ПОСЛЕ СОЗДАЕНИЯ И УСТАНОВКИ АДАПТЕРА RECYCLEVIEW

                        subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи.new SubClassObsevers_КлассСлушательСобытий(getContext()).МетодСлушательObserverДляRecycleView();


                    } else {

                        // TODO: 03.03.2022

                        ///    setContentView(R.layout.activity_main_history_tasks_isnull);


                        // TODO: 06.03.2022

                        // TODO: 06.03.2022
                        bottomNavigationViewДляTasks = (BottomNavigationView) viewДляПервойКнопкиHome_Задания.findViewById(R.id.bottomnavigationActiviTask8);




                        // TODO: 28.02.2022
                        recyclerView = (RecyclerView) viewДляПервойКнопкиHome_Задания.findViewById(R.id.recycleviewActiviTask);

                        recyclerView.setVisibility(View.GONE);

                        LinearLayout linearLayou = (LinearLayout) getActivity().findViewById(R.id.activity_main_fisrt_for_tasks);


                        bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setVisible(false);//.getOrCreateBadge(R.id.id_taskHome).setVisible(true);

                        bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setNumber(Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount());

                        bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setBackgroundColor(Color.MAGENTA);


                        // TODO: 03.03.2022
                        TextView textViewisnull = (TextView) viewДляПервойКнопкиHome_Задания.findViewById(R.id.activy_task_nameеtextviewcursornull);
                        //  TextView textViewisnull=new TextView(activity);
                        textViewisnull.setVisibility(View.VISIBLE);
                        // TODO: 03.03.2022
                        textViewisnull.setText("Нет задач !!!".toUpperCase());


                        linearLayou.addView(textViewisnull);
                        // TODO: 06.03.2022

                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                        linearLayou.setLayoutParams(layoutParams);

                        linearLayou.requestLayout();

                        // TODO: 03.03.2022

                        Log.d(this.getClass().getName(), " нет данных для отображения " +
                                "отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK  " + Курсор_ДляПолученияДАнныхДляЗАДАЧTASK);
                    }


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

            // TODO: 09.03.2022 второй перенесенный метод


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
                                 Fragment fragment1_ДляЗадания;
                                ///
                                fragmentTransactionляЗадачи = fragmentManagerДляЗадачи.beginTransaction();

                                // TODO: 11.03.2022
                                List<Fragment> fragmentsall=      fragmentManagerДляЗадачи.getFragments();
                                // TODO: 11.03.2022
                                Fragment ТекушийФрагмент=    fragmentsall.get(0);
                                // TODO: 11.03.2022
                                Log.d(this.getClass().getName(), "  bottomNavigationViewДляTasks " + bottomNavigationViewДляTasks + " ТекушийФрагмент " +ТекушийФрагмент);



                                Log.d(this.getClass().getName(), "  bottomNavigationViewДляTasks " + bottomNavigationViewДляTasks);

                                // TODO: 09.03.2022 вешаем слушатель на конткеноую кнопку
                                Log.d(this.getClass().getName(), "  item.getItemId() " + item.getItemId());
                                // TODO: 09.03.2022

                                switch (item.getItemId()) {

                                    case R.id.id_taskHome:
                                        // TODO: 09.03.2022
                                        Log.d(this.getClass().getName(), " R.id.id_taskHome  item.getItemId() " + item.getItemId());
                                        // TODO: 10.03.2022
                                        item.setChecked(true);

                                        // TODO: 22.12.2021  запускам втнутерий класс по созданию бизнес логики для даннго активти

                                        Log.d(this.getClass().getName(), " R.id.id_taskHome отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи  fragmentTransactionляЗадачи  " + fragmentTransactionляЗадачи);

                                        // TODO: 09.03.2022
                                        fragment1_ДляЗадания = new Fragment1_One_Tasks();
                                        ///
                                        if (ТекушийФрагмент.isVisible()==false) {
                                            // TODO: 11.03.2022
                                            fragmentTransactionляЗадачи.replace(R.id.activity_main_fisrt_for_tasks, fragment1_ДляЗадания).commit();//.layout.activity_for_fragemtb_history_tasks

                                            // TODO: 10.03.2022
                                            fragmentTransactionляЗадачи.show(fragment1_ДляЗадания);

                                            Log.d(this.getClass().getName(), " fragmentTransactionляЗадачи " + fragmentTransactionляЗадачи);

                                            вибратор.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                                        }

                                        // TODO: 09.03.2022

                                        break;

                                    case R.id.id_taskCreateNewTasks:
                                        // TODO: 09.03.2022
                                        Log.d(this.getClass().getName(), " R.id.id_taskCreateNewTasks  item.getItemId() " + item.getItemId());
                                        // Vibrate for 500 milliseconds

                                        // TODO: 10.03.2022
                                       item.setChecked(true);
                                        // TODO: 10.03.2022

                                        Log.d(this.getClass().getName(),  " R.id.id_taskCreateNewTasks  отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи  fragmentTransactionляЗадачи  " + fragmentTransactionляЗадачи);

                                        // TODO: 09.03.2022
                                        fragment1_ДляЗадания = new Fragment2_Create_Tasks();
                                        ///
                                        fragmentTransactionляЗадачи.replace(R.id.activity_main_fisrt_for_tasks, fragment1_ДляЗадания).commit();//.layout.activity_for_fragemtb_history_tasks

                                        // TODO: 10.03.2022
                                        fragmentTransactionляЗадачи.show(fragment1_ДляЗадания);

                                        Log.d(this.getClass().getName(), " fragmentTransactionляЗадачи " + fragmentTransactionляЗадачи);
                                        // TODO: 10.03.2022
                                        вибратор.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));

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

                    //      BottomNavigationItemView bottomNavigationItemView =activity.findViewById(R.id.bottomnavigationActiviTask8);




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

            private void МетодКпопкаСоЗачкомКраснымДополнительныйСтатус() throws ExecutionException, InterruptedException {
                // TODO: 02.03.2022

                try {
                Integer ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(getContext()).ПолучениеПубличногоТекущегоПользователяID();
                // TODO: 02.03.2022

                Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);

                subClassBusinessLogic_бизнесЛогикаДЛяАктивтиЗадачи.МетодПолучениеТОлЬКоКурсораДЛяПолучнеиеКоличетсовЗадачТолькоДляКоторыхВРАботе(ПубличныйIDДляФрагмента);

                Log.d(this.getClass().getName(), "  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);


                if (Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount() > 0) {
                    // TODO: 06.03.2022
                    bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setVisible(true);//.getOrCreateBadge(R.id.id_taskHome).setVisible(true);

                    // TODO: 06.03.2022

                    bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setNumber(Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount());//.getOrCreateBadge(R.id.id_taskHome).setVisible(true);
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
                    bottomNavigationViewДляTasks.getOrCreateBadge(R.id.id_taskHome).setBackgroundColor(Color.MAGENTA);
                }


                Log.d(this.getClass().getName(), "  bottomNavigationViewДляTasks " + bottomNavigationViewДляTasks +
                        "  Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе.getCount()   " + Курсор_ДляПолученияДАнныхТОлькоДляЗадачВработе);
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

        // TODO: 02.03.2022

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


                ////////

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


    }    // TODO: 28.02.2022 конец класса

    private class MyViewHolder extends RecyclerView.ViewHolder {
        // TODO: 28.02.2022
        TextView textView1, textView2, textView3, textView4,textView5;
        // TODO: 13.03.2022

        MaterialCardView materialCardView;


       // ImageView imageViewIcon;

        // TODO: 02.03.2022

      SubClass_GET_Data_Tasks_Adapter subClass_get_data_tasks_adapter;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            МетодИнициализацииКомпонетовЗаданияCardView(itemView);
            // TODO: 01.03.2022

            Log.d(this.getClass().getName(), "  private class MyViewHolder extends RecyclerView.ViewHolder  itemView   " + itemView);

        }


        private void МетодИнициализацииКомпонетовЗаданияCardView(@NonNull View itemView) {
            // TODO: 28.02.2022
            try {

                // TODO: 01.03.2022 Инициализации компонтов
                Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи itemView   " + itemView);

                // TODO: 02.03.2022
/*
  if (Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount()>0) {
        // TODO: 09.03.2022
      Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.moveToFirst();
    }*/

                // TODO: 02.03.2022

                textView1 = (TextView) itemView.findViewById(R.id.text1_innercardview);
                // TODO: 28.02.2022

                //   imageViewIcon = (ImageView) itemView.findViewById(R.id.imageview_cardviewtask);
                // TODO: 02.03.2022
                // TODO: 02.03.2022  дополнительный

                textView2 = (TextView) itemView.findViewById(R.id.text2_innercardviewtwo);
                // TODO: 28.02.2022


                textView3 = (TextView) itemView.findViewById(R.id.text3_innercardviewtree);
                // TODO: 28.02.2022


                textView4 = (TextView) itemView.findViewById(R.id.text4_innercardviewfour);
                // TODO: 28.02.2022

                // TODO: 28.02.2022
                textView5 = (TextView) itemView.findViewById(R.id.text5_innercardviewtype_tasks);

                // TODO: 13.03.2022

                Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи materialCardView  textView2 " + textView4);



                // TODO: 01.03.2022/
                // TODO: 01.03.2022
                materialCardView = (MaterialCardView) itemView.findViewById(R.id.cardviewmatirealtask);

                Log.d(this.getClass().getName(), " отработоатл new SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи materialCardView   " + materialCardView);
                // TODO: 01.03.2022*/



                Log.d(this.getClass().getName(), "  SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи  accessibilityNodeInfoДоплнительно " );


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


    }    // TODO: 28.02.2022 конец класса


    // TODO: 28.02.2022 ViewHolder

    protected class MyRecycleViewAdapter extends RecyclerView.Adapter<MyViewHolder> {


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
            try{

                // TODO: 28.02.2022
                viewГлавныйВидДляRecyclleViewДляЗаданий = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_for_takst_cardview1, parent, false);
            // TODO: 05.03.2022
                // TODO: 10.03.2022

                Log.i(this.getClass().getName(), "   viewГлавныйВидДляRecyclleViewДляЗаданий"+viewГлавныйВидДляRecyclleViewДляЗаданий);


            // TODO: 28.02.2022
            myViewHolder = new MyViewHolder(viewГлавныйВидДляRecyclleViewДляЗаданий);

// TODO: 02.03.2022


            // TODO: 03.03.2022

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

                if (position <= Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount()) {

                    // TODO: 05.03.2022


                    // TODO: 02.03.2022 тут РАЗДАЕМ ДАННЫЕ RECYCLERBIEW
                    Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.move(position);

                    // TODO: 04.03.2022 p==osion
                    Log.i(this.getClass().getName(), "  Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getPosition() " + Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getPosition());

                    // TODO: 04.03.2022

                    // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

                    Integer ИндексСамогоСообщенияЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("message");
                    // TODO: 02.03.2022

                    String СамогоСообщенияЗадачиДляПользователя = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getString(ИндексСамогоСообщенияЗадачи);
                    // TODO: 02.03.2022

                    Log.i(this.getClass().getName(), "  СамогоСообщенияЗадачиДляПользователя " + СамогоСообщенияЗадачиДляПользователя);
                    // TODO: 28.02.2022

// TODO: 28.02.2022
                    holder.textView1.setText(СамогоСообщенияЗадачиДляПользователя);

                    // TODO: 02.03.2022


                    // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2 // TODO: 02.03.2022#2


                    Integer ИндексПолучаемIDЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("id");
                    // TODO: 02.03.2022

                    Integer IDЗадачиТекущей = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getInt(ИндексПолучаемIDЗадачи);
                    // TODO: 02.03.2022

                    Log.i(this.getClass().getName(), "  IDЗадачиТекущей " + IDЗадачиТекущей);
                    // TODO: 28.02.2022

// TODO: 28.02.2022
                    holder.textView2.setText("#" + String.valueOf(IDЗадачиТекущей));

                    // TODO: 02.03.2022


                    // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3  // TODO: 02.03.2022#3

                    Integer ИндексПолучаемДатыЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("date_update");
                    // TODO: 02.03.2022

                    String СамаДАтаЗадачиТекущей = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getString(ИндексПолучаемДатыЗадачи);
                    // TODO: 02.03.2022

                    // TODO: 03.03.2022 парсинг даты

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", new Locale("ru"));
                    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru"));

                    /////////

                    Date date = dateFormat.parse(СамаДАтаЗадачиТекущей);

                    SimpleDateFormat simpleDateFormatДва = new SimpleDateFormat("dd MMMM yyyy HH:mm", new Locale("ru"));

                    //   simpleDateFormatДва.applyPattern("dd-MM-yyyy HH:mm");//dd-MM-yyyy//// EEEE yyyy HH:mm  /////  dd MMMM yyyy HH:mm

                    СамаДАтаЗадачиТекущей = simpleDateFormatДва.format(date);


                    Log.i(this.getClass().getName(), "  СамаДАтаЗадачиТекущей " + СамаДАтаЗадачиТекущей);


                    // TODO: 28.02.2022

// TODO: 28.02.2022
                    holder.textView4.setText("дата: " + СамаДАтаЗадачиТекущей);

                    // TODO: 02.03.2022


                    // TODO: 02.03.2022#4  // TODO: 02.03.2022#4 // TODO: 02.03.2022#4 // TODO: 02.03.2022#4 // TODO: 02.03.2022#4 // TODO: 02.03.2022#4 // TODO: 02.03.2022#4 // TODO: 02.03.2022#4

                    Integer ИндексКтоНаписалСообщение = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("user_update");
                    // TODO: 02.03.2022

                    Integer КтоНаписалСообщениеФИОдЛПосика = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getInt(ИндексКтоНаписалСообщение);
                    // TODO: 02.03.2022

                    Log.i(this.getClass().getName(), "  КтоНаписалСообщениеФИОдЛПосика " + КтоНаписалСообщениеФИОдЛПосика);


                    // TODO: 02.03.2022

                    // TODO: 02.03.2022
                    String ФИОКотоНаписал = new String();

                    SQLiteCursor sqLiteCursorПолученимНАстоящийФИО = МетодПолучениеДанныхФИОаОснованииID(КтоНаписалСообщениеФИОдЛПосика);

                    // TODO: 02.03.2022
                    Log.i(this.getClass().getName(), "  sqLiteCursorПолученимНАстоящийФИО " + sqLiteCursorПолученимНАстоящийФИО);
                    // TODO: 02.03.2022
                    if (sqLiteCursorПолученимНАстоящийФИО.getCount() > 0) {

                        // TODO: 02.03.2022
                        sqLiteCursorПолученимНАстоящийФИО.moveToFirst();
                        // TODO: 02.03.2022

                        // TODO: 02.03.2022
                        Integer ИндексПолученогоФИО = sqLiteCursorПолученимНАстоящийФИО.getColumnIndex("name");

                        ФИОКотоНаписал = sqLiteCursorПолученимНАстоящийФИО.getString(ИндексПолученогоФИО);


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


                    // TODO: 02.03.2022#5

                    Integer ИндексСтатусПрочтенияИлиНЕт = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("status_write");
                    // TODO: 02.03.2022

                    Integer СамСтатусПрочтенияИлиНет = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getInt(ИндексСтатусПрочтенияИлиНЕт);


                    Log.i(this.getClass().getName(), "  СамСтатусПрочтенияИлиНет " + СамСтатусПрочтенияИлиНет);

                    // TODO: 13.03.2022

                    if (СамСтатусПрочтенияИлиНет > 0) { //СамСтатусПрочтенияИлиНет  holder.getAdapterPosition()

                        Log.i(this.getClass().getName(), "  СамСтатусПрочтенияИлиНет  toggle " + СамСтатусПрочтенияИлиНет);

                        holder.materialCardView.toggle();
                    } else {
                        Log.i(this.getClass().getName(), "  СамСтатусПрочтенияИлиНет " + СамСтатусПрочтенияИлиНет);
                    }


                    // TODO: 13.03.2022
                    holder.materialCardView.setChecked(true);


// TODO: 03.03.2022 добаляем данные на сому кнопку сообщения задания


                    // TODO: 03.03.2022

                    holder.textView1.setTag(СамСтатусПрочтенияИлиНет);


                    // TODO: 10.03.2022
                    // TODO: 01.03.2022 уставнока дополнительный данныых

                    AccessibilityNodeInfoДанныеДляViewCard = holder.materialCardView.createAccessibilityNodeInfo();


                    // TODO: 02.03.2022#5 ТИП ЗАДАЧИ

                    Integer ИндексСтатусТипаЗадачи = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("type_tasks");
                    // TODO: 02.03.2022

                    String СамТипЗадания = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getString(ИндексСтатусТипаЗадачи);


                    Log.i(this.getClass().getName(), "  СамТипЗадания " + СамТипЗадания);


                    holder.textView5.setText("тип: "+СамТипЗадания);


// TODO: 03.03.2022

                    Integer ИндексUUIDДЛяЗАДАНИЯКотореВыбрали = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getColumnIndex("uuid");///"uuid_notifications"
                    // TODO: 02.03.2022 получет UUID строчки

                    Long UUIDДЛяЗАДАНИЯКотореВыбрали = Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getLong(ИндексUUIDДЛяЗАДАНИЯКотореВыбрали);

                    Log.i(this.getClass().getName(), "  UUIDДЛяЗАДАНИЯКотореВыбрали " + UUIDДЛяЗАДАНИЯКотореВыбрали);

                    // TODO: 13.03.2022
                    AccessibilityNodeInfoДанныеДляViewCard.setContentDescription(UUIDДЛяЗАДАНИЯКотореВыбрали.toString());

                    Log.i(this.getClass().getName(), "  AccessibilityNodeInfoДанныеДляViewCard " + AccessibilityNodeInfoДанныеДляViewCard.getContentDescription());

                    // TODO: 13.03.2022  передаем статус задачи

                    Integer позиция = holder.getAdapterPosition();

                    // TODO: 03.03.2022 передаем помер позиции position
                    holder.materialCardView.setTag(holder.materialCardView.getId(), СамСтатусПрочтенияИлиНет);


                    // TODO: 03.03.2022 передаем помер позиции position


                    // TODO: 04.03.2022
                    Log.i(this.getClass().getName(), "      holder.textView1  accessibilityNodeInfo " + AccessibilityNodeInfoДанныеДляViewCard);


                    МетодСлушателейДляViewCard(holder);
                    // TODO: 04.03.2022
                    Log.i(this.getClass().getName(), "      holder.textView1  accessibilityNodeInfo " + AccessibilityNodeInfoДанныеДляViewCard);


                    // TODO: 04.03.2022


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


        // TODO: 13.03.2022



        private void МетодСлушателейДляViewCard(@NonNull MyViewHolder holder) {
            // TODO: 01.03.2022 слушатели

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

                        if (isChecked) {

                            card.setCheckedIcon(drawableПпрочитанные);
                            // TODO: 13.03.2022
                            card.setCheckedIconResource(ИндексПпрочитанные);
                            // TODO: 13.03.2022
                            card.setSelected(true);

                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "   holder.materialCardView.setOnCheckedChangeListener  isChecked    " + isChecked);

                        } else {
                            card.setCheckedIcon(drawableИндексдляНепрочитанный);
                            // TODO: 13.03.2022
                            card.setCheckedIconResource(ИндексдляНепрочитанный);

                            // TODO: 13.03.2022

                            // TODO: 13.03.2022
                            Log.d(this.getClass().getName(), "  holder.materialCardView.setOnCheckedChangeListener  isChecked   " + isChecked);
                        }

                        // TODO: 13.03.2022
                    }
                });


// TODO: 01.03.2022 слушатели

                holder.materialCardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: 01.03.2022

                        // TODO: 13.03.2022
                        Log.d(this.getClass().getName(), "  SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи   ПозицияЭлментаVIewCardДополнительно  " +
                                " holder.getAdapterPosition() " + holder.getAdapterPosition() + " v.getTag() " + v.getTag(holder.materialCardView.getId()));

                        // TODO: 13.03.2022  статус прочтения ли уде или нет адание

                        Object СтатусПрочтеаУжеЗадачаИлиНет = v.getTag(holder.materialCardView.getId());


                        // TODO: 04.03.2022  ПОЛУЧЕНИЕ НАЗВАНЕИ ЗАДАЧИ
                     /*   Long ПолучаемUUIDТекущйПозицииВRecyreView = AccessibilityNodeInfoДанныеДляViewCard.getAvailableExtraData().stream().map(Long::new)
                                .distinct() .sorted(Collections.reverseOrder()).collect(Collectors.toList()).get(holder.getAdapterPosition()).longValue();*/

                        // TODO: 13.03.2022
                        Long ПолучаемUUIDТекущйПозицииВRecyreView = Long.parseLong(String.valueOf(AccessibilityNodeInfoДанныеДляViewCard.getContentDescription()));


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
                                // TODO: 13.03.2022
                                notifyDataSetChanged();

                                Toast.makeText(getActivity(), " Статус сменили на ознакомленный  #" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();

                            }, 5000);

                        }

                        // TODO: 03.03.2022 update screewn

                        // TODO: 13.03.2022
                        Log.d(this.getClass().getName(), "  SubClassBusinessLogic_БизнесЛогикаДЛяАктивтиЗадачи   ПолучаемUUIDТекущйПозицииВRecyreView " + ПолучаемUUIDТекущйПозицииВRecyreView +
                                " holder.getAdapterPosition() " + holder.getAdapterPosition());

                        // TODO: 13.03.2022
                        // notifyDataSetChanged();

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

    protected class SubClass_GET_Data_Tasks_Adapter {
        Context context;

        public SubClass_GET_Data_Tasks_Adapter(Context context) {
            // TODO: 02.03.2022
            this.context = context;
        }


        // TODO: 02.03.2022


        // TODO: 02.03.2022

        SQLiteCursor МетодПолучениеТОлЬКоКурсораДЛяПолучнеиеКоличетсовЗадач(Integer ПубличноеIDПолученныйИзСервлетаДляUUID) throws ExecutionException, InterruptedException {
            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

            Курсор_ДляПолученияДАнныхДляЗАДАЧTASK = null;

            // TODO: 02.03.2022
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
                Курсор_ДляПолученияДАнныхДляЗАДАЧTASK = null;

                // TODO: 03.03.2022  глаВНЫЙ КУРСОР ДЛЯ ЗАДАЧ


                Курсор_ДляПолученияДАнныхДляЗАДАЧTASK = (SQLiteCursor) class_grud_sql_operationsIDпользоввателяДляСлужб.
                        new GetData(getContext()).getdata(class_grud_sql_operationsIDпользоввателяДляСлужб.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        new PUBLIC_CONTENT(context).МенеджерПотоков, new CREATE_DATABASE(context).getССылкаНаСозданнуюБазу());

                // TODO: 02.03.2022

                if (Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.getCount() > 0) {

                    // TODO: 03.03.2022
                    Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхДляЗАДАЧTASK " + Курсор_ДляПолученияДАнныхДляЗАДАЧTASK);
                    // TODO: 03.03.2022

                    Курсор_ДляПолученияДАнныхДляЗАДАЧTASK.moveToFirst();
                }


                ////////

                Log.d(this.getClass().getName(), "Курсор_ДляПолученияДАнныхДляЗАДАЧTASK " + Курсор_ДляПолученияДАнныхДляЗАДАЧTASK);


            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
            }


            return Курсор_ДляПолученияДАнныхДляЗАДАЧTASK;
        }
// TODO: 05.03.2022  еще один метод только для задача в работе


    }



    // TODO: 02.03.2022

    // TODO: 28.02.2022 бизнес -логика    для активти




    }    // TODO: 28.02.2022 конец класса






























