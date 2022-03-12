/*
package com.dsy.dsu;

import android.app.Activity;
import android.content.AsyncTaskLoader;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteQueryBuilder   ;
import android.os.Build;
import android.os.Environment;
import android.text.BoringLayout;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor    ;
import java.util.concurrent.ExecutorService  ;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Stream;



import com.google.gson.internal.Streams;

import rx.Observable;


///////TODO КЛАСС ВСЕ ОПЕРАЦИИ ВСТАВКИ УДАЛЕНИЕ ОБНОВЛЕНИЯ ВЫБОРКА ДАННЫХ В ОДНОМ МЕСТЕ
public class Test_ClassFoGRUD extends CREATE_DATABASE {



    // TODO: 26.08.2021  конструктор
    protected  ExecutorService      МенеджерПотоков=null;
    ////
    // TODO: 26.08.2021  конструктор
    protected  ScheduledExecutorService      МенеджерПотоковпоРасписанию=null;

    ///////
    protected Stream Стрим=null;

    ///
    protected LinkedTransferQueue БлокирующаяОчереть=null;


    ///todo визуализаци синхронизации
    /// protected      МенеджерПотоков=null; //newSingleThreadExecutor()

    ///
    private Context contextClass_GRUD_SQL_Operations;
    ////////
    // TODO: 29.08.2021  ДЛЯ ОПЕРАЦИЙ grud РАБОТА С БАЗОЙ

    protected   Map<String,Object> concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций = Collections.synchronizedMap(new LinkedHashMap<String,Object>());
    ///

    protected List<Callable<Object>> ЛистДляGRUDопераций = new CopyOnWriteArrayList<>();
    //


    // TODO: 29.08.2021  ДЛЯ ОПЕРАЦИЙ grud РАБОТА С БАЗОЙ

    ContentValues contentValuesДляSQLBuilder_Для_GRUD_Операций  = new ContentValues();



    //todo ССЛЫКА НА БАЗОВЫ КЛАСС
    CREATE_DATABASE Create_Database_СсылкаНАБазовыйКласс=null;


    private    SQLiteQueryBuilder    SQLBuilder_Для_GRUD_Операций =null;

    // TODO: 27.08.2021  Конструктор Главного Класса для Операций GRUD


    public Test_ClassFoGRUD(@NotNull  Context context) {
        super(context);

        //TODO контроль потоков
        ////
        contextClass_GRUD_SQL_Operations =context;




        // TODO: 26.08.2021  МЕНЕДЖЕР ПОТОКВ ДЛЯ GRUD ОПЕРАЦИЙ
        //////////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ///////s
            МенеджерПотоков=(ExecutorService  )  Executors.newWorkStealingPool();
        }else{

            МенеджерПотоков=   (  ExecutorService)   Executors.newCachedThreadPool();
        }





        // TODO: 26.08.2021  МЕНЕДЖЕР ПОТОКВ ДЛЯ GRUD ОПЕРАЦИЙ--по расписанию
        //////////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ///////s
            МенеджерПотоковпоРасписанию=(ScheduledExecutorService  )  Executors.newWorkStealingPool();
        }else{

            МенеджерПотоковпоРасписанию=   (  ScheduledExecutorService)   Executors.newCachedThreadPool();
        }

    }








    //TODO КЛАСС ПОЛУЧЕНИЕ ДАННЫХ
    class  GetData extends Class_GRUD_SQL_Operations {

        public GetData(@NotNull Context context) {
            super(context);

            //todo ПОДКЛЮЯЕМ КЛАСС ВЫШЕСТОЯЩИЙ ДЛЯ РАБОТЫ ОПЕРАЦИЙ grud
            */
/**
             *
             * @param context
             *//*

            Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);
            ////
            ///
            */
/**
             *
             *//*

            SQLBuilder_Для_GRUD_Операций =new SQLiteQueryBuilder    ();

        }

        // TODO: 30.08.2021  НИЖЕ  УКАЗАНЫ ВСЕ МЕТОДЫ ПОЛУЧЕНИЕ ОБНОВЛЕНИЯ ВСТАВКИ УДАЛЕНИЕ ДАННЫХ


        // TODO: 27.08.2021 МЕТОД  ПОЛУЧЕНИЯ ДАННЫХ
        Object getdata(Map<String,Object>   concurrentHashMap) throws ExecutionException, InterruptedException {
            ///////
            Object Getdata=null;
            //////// TODO запуск менеджера потоков
            // TODO: 29.08.2021 СОЗДАЕМ ЗАДАЧУ ДЛЯ ВЫПОЛЕНИЯ ЧЕРЕЗ CALLABLE

            ЛистДляGRUDопераций.add(new Callable<Object>() {
                @Override
                public Object call() throws Exception {

                    /////TODO начало самого кода

                    Object РезутьтатРаботыМенеджераПотоковВнутри=null;
                    /////
                    try {
                        // TODO: 27.08.2021 парарменты
                        String НазваниеОбрабоатываемойТаблицы=null;
                        //
                        String    СтолбцыОбработки=null;

                        String ФорматПосика=null;
                        /////
                        String УсловиеПоиска[]=new String[50];
                        //
                        String ПоляГрупировки=null;
                        ///
                        String УсловиеГрупировки=null;
                        ///
                        String УсловиеСортировки=null;
                        ///
                        String УсловиеЛимита=null;

                        ///true and false
                        Boolean ФлагНепотораяемостиСтрок=false;

                        ////Работа с применением подзапросов

                        String ПодЗапросНомер1=null;
                        ///
                        String ПодЗапросНомер2=null;



                        ///TODO конец параментов
                        // TODO: 27.08.2021 само значние
                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap " + concurrentHashMap.values());


                        //TODO ЦИКЛ ПО ПАРАМЕТРАМ
                        for (Object КлючconcurrentHashMap : concurrentHashMap.keySet()) {

                            Object ЗначениеconcurrentHashMap = concurrentHashMap.get(КлючconcurrentHashMap);
                            //

                            Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap.toString() " + concurrentHashMap.toString());

                            // TODO: 27.08.2021  присваевываем значения полям для получение данных

                            switch (КлючconcurrentHashMap.toString().trim()){

                                case "НазваниеОбрабоатываемойТаблицы" :
                                    //////
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString();

                                    break;
                                ///////
                                case "СтолбцыОбработки" :
                                    СтолбцыОбработки=ЗначениеconcurrentHashMap.toString();
                                    break;
                                ///
                                case "ФорматПосика" :
                                    ФорматПосика=ЗначениеconcurrentHashMap.toString();
                                    break;
                                ///
                                //////
                                case "УсловиеПоиска1" :
                                    ///////
                                    УсловиеПоиска[0]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                case "УсловиеПоиска2" :
                                    ///////
                                    УсловиеПоиска[1]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска3" :
                                    ///////
                                    УсловиеПоиска[2]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска4" :
                                    ///////
                                    УсловиеПоиска[3]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска5" :
                                    ///////
                                    УсловиеПоиска[4]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////

                                //////
                                case "УсловиеПоиска6" :
                                    ///////
                                    УсловиеПоиска[5]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////

                                //////
                                case "УсловиеПоиска7" :
                                    ///////
                                    УсловиеПоиска[6]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска8" :
                                    ///////
                                    УсловиеПоиска[7]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска9" :
                                    ///////
                                    УсловиеПоиска[8]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска10" :
                                    ///////
                                    УсловиеПоиска[9]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска11" :
                                    ///////
                                    УсловиеПоиска[10]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска12" :
                                    ///////
                                    УсловиеПоиска[11]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска13" :
                                    ///////
                                    УсловиеПоиска[12]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска14" :
                                    ///////
                                    УсловиеПоиска[13]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска15" :
                                    ///////
                                    УсловиеПоиска[14]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////

                                //////
                                case "УсловиеПоиска16" :
                                    ///////
                                    УсловиеПоиска[15]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////

                                //////
                                case "УсловиеПоиска17" :
                                    ///////
                                    УсловиеПоиска[16]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска18" :
                                    ///////
                                    УсловиеПоиска[17]=ЗначениеconcurrentHashMap.toString();

                                    break;
                                //////

// TODO: 27.08.2021  конец столбиков с параметрами условия посика


                                //////
                                case "ПоляГрупировки" :
                                    ПоляГрупировки=ЗначениеconcurrentHashMap.toString();
                                    break;
                                /////
                                case "УсловиеГрупировки" :
                                    УсловиеГрупировки=ЗначениеconcurrentHashMap.toString();
                                    break;
                                //////
                                case "УсловиеСортировки" :
                                    УсловиеСортировки=ЗначениеconcurrentHashMap.toString();
                                    break;
                                //////
                                case "УсловиеЛимита" :
                                    УсловиеЛимита=ЗначениеconcurrentHashMap.toString();
                                    break;
                                //////////
                                //////
                                case "ФлагНепотораяемостиСтрок" :
                                    ФлагНепотораяемостиСтрок=  (Boolean) ЗначениеconcurrentHashMap;
                                    break;
                                //////////

                                // TODO: 09.09.2021 Sub --querty
                                //////
                                case "ПодЗапросНомер1" :
                                    ПодЗапросНомер1=ЗначениеconcurrentHashMap.toString();
                                    break;
                                //////////
                                //////
                                case "ПодЗапросНомер2" :
                                    ПодЗапросНомер2=ЗначениеconcurrentHashMap.toString();
                                    break;
                                //////////
                                // TODO: 27.08.2021  конец присвоение параментов

                                // TODO: 27.08.2021  конец присвоение параментов

////
                            }

                        }

                        // TODO: 27.08.2021  проверка параметров чтоюбы небыло NULL
                        LinkedHashMap<String,Object> concurrentHashMapТолькоДляЗбораЗаполенныхПараметровУсловияФильтра=new LinkedHashMap<String,Object> ();

                        // TODO: 30.08.2021   цикл упаковываем ппарметры в массик для ЗАПРОСА
                        for (int i=0;i<УсловиеПоиска.length ; i++ ) {

                            //TODO dont null

                            Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), "УсловиеПоиска[i] " + УсловиеПоиска[i]);

                            // TODO: 03.09.2021  ВСТАВЛЯЕМ ТОЛЬКО ТЕ ПАРАРМЕНТЫ КОТОРЫ НЕ NULL

                            if (УсловиеПоиска[i] != null) {
                                ////TOdo ПОЛУЧЕНИЕ ХАША ДЛЯ ЗАПСРОСА
                                concurrentHashMapТолькоДляЗбораЗаполенныхПараметровУсловияФильтра.put(УсловиеПоиска[i],УсловиеПоиска[i]);
                                //
                                Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " concurrentHashMapТолькоДляЗбораЗаполенныхПараметровУсловияФильтра.values().toString()  "
                                        + concurrentHashMapТолькоДляЗбораЗаполенныхПараметровУсловияФильтра.values().toString());

                            }

                        }

                        // TODO: 31.08.2021
                        String[] ПолученныеПараметрыДляУсловияПосикаФинал=null;

                        if (concurrentHashMapТолькоДляЗбораЗаполенныхПараметровУсловияФильтра.size()>0) {
                            /////
                            ПолученныеПараметрыДляУсловияПосикаФинал= concurrentHashMapТолькоДляЗбораЗаполенныхПараметровУсловияФильтра.values().
                                    toArray(new String[ concurrentHashMapТолькоДляЗбораЗаполенныхПараметровУсловияФильтра.size()]);
                        }


                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " ПолученныеПараметрыДляУсловияПосикаФинал  "
                                + ПолученныеПараметрыДляУсловияПосикаФинал);

                        ///TODO тело самого кода    ////
                        ///

                        SQLBuilder_Для_GRUD_Операций.setTables(НазваниеОбрабоатываемойТаблицы);

                        //
                        if (ФорматПосика!=null) {
                            ////
                            SQLBuilder_Для_GRUD_Операций.appendWhere(ФорматПосика);
                        }
                        ////
                        //
                        if (ФлагНепотораяемостиСтрок!=null) {
                            ////
                            SQLBuilder_Для_GRUD_Операций.setDistinct(ФлагНепотораяемостиСтрок);
                        }
                        ////



                        // TODO: 26.08.2021  только выборка данных EXE -- КОМКАНДА
                        Log.w(this.getClass().getName(), "ПодЗапросНомер1   "
                                + ПодЗапросНомер1 + " ПодЗапросНомер2 " +ПодЗапросНомер2);


                        // TODO: 09.09.2021  ЕСЛИ ПОД ЗАПРОССОВ НЕТ ТО ЭТО ПРОСТОЙ ЗАПРОС ПОЛУЧЕНИЕ ДАННЫХ


                        if (ПодЗапросНомер1==null && ПодЗапросНомер2==null) {
                            ////
                            РезутьтатРаботыМенеджераПотоковВнутри =
                                    (SQLiteCursor)    SQLBuilder_Для_GRUD_Операций.query(Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу(),new String[]{СтолбцыОбработки},
                                            null,ПолученныеПараметрыДляУсловияПосикаФинал
                                            ,ПоляГрупировки, УсловиеГрупировки, УсловиеСортировки,УсловиеЛимита);//ФорматПосика выше
                        } else {

                            // TODO: 09.09.2021  ВТОРОЙ ВАРИАНТ ПОЛУЧЕНИЕ ДАННЫХ С ПРИМЕНЕНИЕМ SUB- ПОД ЗАПРОСА//"SELECT name_col FROM table1 WHERE " + BAR_COLUMN + "='bar'",
                            //                                "SELECT name_col FROM table1 WHERE " + FOO_COLUMN + " LIKE 'foor''"


                            String[] subQueries = new String[] {
                                    ПодЗапросНомер1,
                                    ПодЗапросНомер2
                            };
                            String query =    SQLBuilder_Для_GRUD_Операций.buildUnionQuery(subQueries, null ,null);
                            ///
                            РезутьтатРаботыМенеджераПотоковВнутри = (SQLiteCursor)  Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу().rawQuery(query, null);


                        }




                        Log.w(this.getClass().getName(), " ЕДИНСТВЕННЫЙ         ПОЛУЧЕНИЯ ДАННЫХ   "
                                + РезутьтатРаботыМенеджераПотоковВнутри);

                        ///TODO тело самого кода    ////

                    } catch (Exception e) {
                        e.printStackTrace();
                        //  Block of code to handle errors
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                        ///////
                    }finally {
                        //////
                        //////todo ПОСЛУ УСПЕШНОЙ ОПЕРАЦИИ NULL ВНЕШНИЕ КОМПОНЕНТЫ-grud
                        SQLBuilder_Для_GRUD_Операций=null;
                        ////
                        Create_Database_СсылкаНАБазовыйКласс=null;
                    }

                    // TODO: 29.08.2021  MAIN EXE запуск выполения любого кода через  CALLABLE

                    /////TODO конец  самого кода

                    return РезутьтатРаботыМенеджераПотоковВнутри;
                }
            });


            //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

            Getdata=       new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций);

            ////
            Log.d(this.getClass().getName(), "   рЕЗУЛЬТАТ МЕТОДА ПОЛУЧЕНИЕ ДАННЫХ ЧЕРЕЗ ОДИН МЕТДЖЕР ПОТОКОВ  Getdata "+Getdata);



            //////// TODO конец  менеджера потоков

            return Getdata;
        }

    }

































    //TODO КЛАСС Вставки ДАННЫХ
    class  InsertData extends Class_GRUD_SQL_Operations {

        public InsertData(@NotNull Context context) {
            super(context);
            */
/**
             *
             * @param context
             *//*

            Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);

            */
/**
             *
             *//*

            SQLBuilder_Для_GRUD_Операций =new SQLiteQueryBuilder    ();
        }



        // TODO: 27.08.2021 МЕТОД  ВСТАВКИ ДАННЫХ
        Object insertdata(Map<String,Object> concurrentHashMap, ContentValues contentValuesВставкаДанных ) throws ExecutionException, InterruptedException {
            ///////
            Object InsertData=null;
            //////// TODO запуск менеджера потоков

            try {
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций.add(new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Long InsertData=0L;
                        // TODO: 30.08.2021  параметры
                        String  НазваниеОбрабоатываемойТаблицы=null;



                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap " + concurrentHashMap.values() +
                                "  contentValuesВставкаДанных " +contentValuesВставкаДанных.valueSet());

                        //TODO ЦИКЛ ПО ПАРАМЕТРАМ
                        for (Object КлючconcurrentHashMap : concurrentHashMap.keySet()) {

                            Object ЗначениеconcurrentHashMap = concurrentHashMap.get(КлючconcurrentHashMap);
                            //

                            Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap.toString() " + concurrentHashMap.toString());

                            // TODO: 27.08.2021  присваевываем значения полям для получение данных

                            switch (КлючconcurrentHashMap.toString().trim()){

                                case "НазваниеОбрабоатываемойТаблицы" :
                                    //////
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;

                                ///
///
                            }

                        }

                        Log.w(this.getClass().getName(), "   НазваниеОбрабоатываемойТаблицы   "+НазваниеОбрабоатываемойТаблицы);

                        //////TODO конец параменты

                        // TODO: 30.08.2021  ОРМИРУЕМ КОРКАТ БУДЩЕЙ ВСТАВКИ ДАННЫХ

                        ////////////
                        SQLBuilder_Для_GRUD_Операций.setTables(НазваниеОбрабоатываемойТаблицы);

                        /////TODO операция ВСТАВКИ
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            ////////
                            InsertData =    SQLBuilder_Для_GRUD_Операций.insert( Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу(), contentValuesВставкаДанных);
                        } else {
                            /////TODO операция ВСТАВКИ
                            ///
                            InsertData = Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу().insert(НазваниеОбрабоатываемойТаблицы, null, contentValuesВставкаДанных);

                        }
                        ///////
                        /////TODO РЕЗУЛЬТАТ операция ВСТАВКИ
                        //////
                        if (InsertData > 0) {
                            ///
                            ////
                            Log.w(this.getClass().getName(), "   рЕЗУЛЬТАТ МЕТОДА ВСТАВКИ ДАННЫХ  УСПЕШНО  InsertData "+InsertData);

                        }else{
                            ////
                            Log.e(this.getClass().getName(), "     рЕЗУЛЬТАТ МЕТОДА  НЕ  ВСТАВКИ ДАННЫХ  НЕ УСПЕШННО  InsertData  "+InsertData);
                        }

                        return InsertData;
                    }
                });


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                InsertData=       new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций);

                ///
                Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " InsertData " + InsertData);
                /////




            } catch (Exception e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());

                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            }finally {
                //////
                //////todo ПОСЛУ УСПЕШНОЙ ОПЕРАЦИИ NULL ВНЕШНИЕ КОМПОНЕНТЫ-grud
                SQLBuilder_Для_GRUD_Операций=null;
                ////
                Create_Database_СсылкаНАБазовыйКласс=null;
            }
            //////// TODO конец  менеджера потоков

            return InsertData;
        }

    }













    //TODO КЛАСС Обновление ДАННЫХ
    class  UpdateData extends Class_GRUD_SQL_Operations {

        public UpdateData(@NotNull Context context) {
            super(context);
            */
/**
             *
             * @param context
             *//*

            Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);
            */
/**
             *
             *//*

            SQLBuilder_Для_GRUD_Операций =new SQLiteQueryBuilder    ();
        }


        // TODO: 27.08.2021 МЕТОД  ПОЛУЧЕНИЯ ДАННЫХ
        Object updatedata(Map<String,Object> concurrentHashMap, ContentValues contentValuesДляОбновленияДАнных) throws ExecutionException, InterruptedException {
            ///////////
            Object Updatedata=null;
            //////// TODO запуск менеджера потоков
            try {
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций.add(new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Integer Updatedata=0;
                        ///
                        // TODO: 30.08.2021  параметры
                        String  НазваниеОбрабоатываемойТаблицы=null;
                        /////
                        String  Флаг_ЧерезКакоеПолеОбновлением=null;

                        //
                        String  ЗначениеФлагОбновления=null;

                        //
                        String ЗнакФлагОбновления=null;


                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap " + concurrentHashMap.values() +
                                "  contentValuesДляОбновленияДАнных " +contentValuesДляОбновленияДАнных.valueSet());

                        //TODO ЦИКЛ ПО ПАРАМЕТРАМ
                        for (Object КлючconcurrentHashMap : concurrentHashMap.keySet()) {

                            Object ЗначениеconcurrentHashMap = concurrentHashMap.get(КлючconcurrentHashMap);
                            //

                            Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap.toString() " + concurrentHashMap.toString());

                            // TODO: 27.08.2021  присваевываем значения полям для получение данных

                            switch (КлючconcurrentHashMap.toString().trim()){

                                //
                                case "НазваниеОбрабоатываемойТаблицы" :
                                    //////
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;
                                ///

                                //
                                case "Флаг_ЧерезКакоеПолеОбновлением" :
                                    //////
                                    Флаг_ЧерезКакоеПолеОбновлением=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;
                                ///

                                //
                                case "ЗначениеФлагОбновления" :
                                    //////
                                    ЗначениеФлагОбновления=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;
                                ///
                                //
                                case "ЗнакФлагОбновления" :
                                    //////
                                    ЗнакФлагОбновления=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;
                                ///




                                ///
///
                            }

                        }

                        Log.w(this.getClass().getName(), "   НазваниеОбрабоатываемойТаблицы   "+НазваниеОбрабоатываемойТаблицы);

                        //////TODO конец параменты

                        // TODO: 30.08.2021  ОРМИРУЕМ КОРКАТ БУДЩЕЙ ВСТАВКИ ДАННЫХ

                        //


                        ////////////
                        SQLBuilder_Для_GRUD_Операций.setTables(НазваниеОбрабоатываемойТаблицы);

                        /////TODO операция ВСТАВКИ

                        /////////////
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                            //////////TODO само обновление
                            Updatedata =             SQLBuilder_Для_GRUD_Операций.
                                    update(Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу(),contentValuesДляОбновленияДАнных, Флаг_ЧерезКакоеПолеОбновлением +  ""+ЗнакФлагОбновления+ "?",
                                            new String[]{ЗначениеФлагОбновления});
                        }else{

                            Updatedata =           Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу()
                                    .update(НазваниеОбрабоатываемойТаблицы,contentValuesДляОбновленияДАнных,Флаг_ЧерезКакоеПолеОбновлением +  ""+ЗнакФлагОбновления+ "?", new String[]{ЗначениеФлагОбновления});
                        }

                        /////TODO РЕЗУЛЬТАТ операция Обновление
                        //////
                        if (Updatedata > 0) {
                            ///
                            ////
                            Log.w(this.getClass().getName(), "   рЕЗУЛЬТАТ МЕТОДА ВСТАВКИ ДАННЫХ  УСПЕШНО  Updatedata "+Updatedata);

                        }else{
                            ////
                            Log.e(this.getClass().getName(), "     рЕЗУЛЬТАТ МЕТОДА  НЕ  ВСТАВКИ ДАННЫХ  НЕ УСПЕШННО  Updatedata  "+Updatedata);
                        }

                        ////////

                        return Updatedata;
                    }
                });


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                Updatedata=       new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций);

                ///
                Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " Updatedata " + Updatedata);
                /////



                /////

            } catch (Exception e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());

                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            }finally {
                //////
                //////todo ПОСЛУ УСПЕШНОЙ ОПЕРАЦИИ NULL ВНЕШНИЕ КОМПОНЕНТЫ-grud
                SQLBuilder_Для_GRUD_Операций=null;
                ////
                Create_Database_СсылкаНАБазовыйКласс=null;
            }
            //////// TODO конец  менеджера потоков

            return Updatedata;
        }

    }




















    //TODO КЛАСС СОН SLEEP ДАННЫХ
    class  SleepData extends Class_GRUD_SQL_Operations {
        public SleepData(@NotNull Context context) {
            super(context);
            */
/**
             *
             * @param context
             *//*

            Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);

            */
/**
             *
             *//*

            SQLBuilder_Для_GRUD_Операций =new SQLiteQueryBuilder    ();

        }
        // TODO: 27.08.2021 МЕТОД  ПОЛУЧЕНИЯ ДАННЫХ
        Object sleepdata(Map<String,Object> concurrentHashMap, ContentValues contentValuesДляСнаДанных) throws ExecutionException, InterruptedException {
            /////
            Object sleepdata=null;
            //////// TODO запуск менеджера потоков

            try {
                ///TODO тело самого кода List    ////
                //////// TODO запуск менеджера потоков
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций.add(new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Integer sleepdata=0;
                        ///
                        // TODO: 30.08.2021  параметры
                        String  НазваниеОбрабоатываемойТаблицы=null;
                        /////
                        String  Флаг_ЧерезКакоеПолеСнаДанных=null;

                        //
                        String  ЗначениеФлагСнаДанных=null;


                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap " + concurrentHashMap.values() +
                                "  contentValuesДляСнаДанных " +contentValuesДляСнаДанных.valueSet());

                        //TODO ЦИКЛ ПО ПАРАМЕТРАМ
                        for (Object КлючconcurrentHashMap : concurrentHashMap.keySet()) {

                            Object ЗначениеconcurrentHashMap = concurrentHashMap.get(КлючconcurrentHashMap);
                            //

                            Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap.toString() " + concurrentHashMap.toString());

                            // TODO: 27.08.2021  присваевываем значения полям для получение данных

                            switch (КлючconcurrentHashMap.toString().trim()){

                                //
                                case "НазваниеОбрабоатываемойТаблицы" :
                                    //////
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;
                                ///

                                //
                                case "Флаг_ЧерезКакоеПолеСнаДанных" :
                                    //////
                                    Флаг_ЧерезКакоеПолеСнаДанных=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;
                                ///

                                //
                                case "ЗначениеФлагСнаДанных" :
                                    //////
                                    ЗначениеФлагСнаДанных=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;
                                ///



                                ///
///
                            }

                        }

                        Log.w(this.getClass().getName(), "   НазваниеОбрабоатываемойТаблицы   "+НазваниеОбрабоатываемойТаблицы);

                        //////TODO конец параменты

                        // TODO: 30.08.2021  ОРМИРУЕМ КОРКАТ БУДЩЕЙ ВСТАВКИ ДАННЫХ

                        //


                        ////////////
                        SQLBuilder_Для_GRUD_Операций.setTables(НазваниеОбрабоатываемойТаблицы);

                        /////TODO операция ВСТАВКИ

                        /////////////
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                            //////////TODO само обновление
                            sleepdata =             SQLBuilder_Для_GRUD_Операций.
                                    update(Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу(),contentValuesДляСнаДанных, Флаг_ЧерезКакоеПолеСнаДанных + "= ?",
                                            new String[]{ЗначениеФлагСнаДанных});
                        }else{

                            sleepdata =           Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу()
                                    .update(НазваниеОбрабоатываемойТаблицы,contentValuesДляСнаДанных,Флаг_ЧерезКакоеПолеСнаДанных + "= ?", new String[]{ЗначениеФлагСнаДанных});
                        }

                        /////TODO РЕЗУЛЬТАТ операция Обновление
                        //////
                        if (sleepdata > 0) {
                            ///
                            ////
                            Log.w(this.getClass().getName(), "   рЕЗУЛЬТАТ МЕТОДА ВСТАВКИ ДАННЫХ  УСПЕШНО  deletedata "+sleepdata);

                        }else{
                            ////
                            Log.e(this.getClass().getName(), "     рЕЗУЛЬТАТ МЕТОДА  НЕ  ВСТАВКИ ДАННЫХ  НЕ УСПЕШННО  deletedata  "+sleepdata);
                        }

                        ////////

                        return sleepdata;
                    }
                });


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                sleepdata=       new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций);

                ///
                Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " sleepdata " + sleepdata);
                /////

                /////

                ///
                Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " sleepdata " + sleepdata);
                /////

            } catch (Exception e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            }finally {
                //////
                //////todo ПОСЛУ УСПЕШНОЙ ОПЕРАЦИИ NULL ВНЕШНИЕ КОМПОНЕНТЫ-grud
                SQLBuilder_Для_GRUD_Операций=null;
                ////
                Create_Database_СсылкаНАБазовыйКласс=null;
            }

            return sleepdata;
        }

    }


    //TODO










    //TODO КЛАСС Удаление ДАННЫХ
    class  DeleteData extends Class_GRUD_SQL_Operations {
        public DeleteData(@NotNull Context context) {
            super(context);
            */
/**
             *
             * @param context
             *//*

            Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);
            */
/**
             *
             *//*

            SQLBuilder_Для_GRUD_Операций =new SQLiteQueryBuilder    ();

        }
        // TODO: 27.08.2021 МЕТОД  ПОЛУЧЕНИЯ ДАННЫХ
        Object deletedata(Map<String,Object> concurrentHashMap) throws ExecutionException, InterruptedException {
            /////
            Object deletedata=null;
            //////// TODO запуск менеджера потоков

            try {
                ///TODO тело самого кода List    ////
                //////// TODO запуск менеджера потоков
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций.add(new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Integer deletedata=0;
                        ///
                        // TODO: 30.08.2021  параметры
                        String  НазваниеОбрабоатываемойТаблицы=null;
                        /////
                        String  Флаг_ЧерезКакоеПолеУдаление=null;

                        //
                        String  ЗначениеФлагУдаление=null;
                        //
                        String ЗнакФлагУдаление=null;


                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap " + concurrentHashMap.values());

                        //TODO ЦИКЛ ПО ПАРАМЕТРАМ
                        for (Object КлючconcurrentHashMap : concurrentHashMap.keySet()) {

                            Object ЗначениеconcurrentHashMap = concurrentHashMap.get(КлючconcurrentHashMap);
                            //

                            Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap.toString() " + concurrentHashMap.toString());

                            // TODO: 27.08.2021  присваевываем значения полям для получение данных

                            switch (КлючconcurrentHashMap.toString().trim()){

                                //
                                case "НазваниеОбрабоатываемойТаблицы" :
                                    //////
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;
                                ///

                                //
                                case "Флаг_ЧерезКакоеПолеУдаление" :
                                    //////
                                    Флаг_ЧерезКакоеПолеУдаление=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;
                                ///

                                //
                                case "ЗначениеФлагУдаление" :
                                    //////
                                    ЗначениеФлагУдаление=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;
                                ///
                                //
                                case "ЗнакФлагУдаление" :
                                    //////
                                    ЗнакФлагУдаление=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;
                                ///






                                ///
///
                            }

                        }

                        Log.w(this.getClass().getName(), "   НазваниеОбрабоатываемойТаблицы   "+НазваниеОбрабоатываемойТаблицы);

                        //////TODO конец параменты

                        // TODO: 30.08.2021  ОРМИРУЕМ КОРКАТ БУДЩЕЙ ВСТАВКИ ДАННЫХ

                        //


                        ////////////
                        SQLBuilder_Для_GRUD_Операций.setTables(НазваниеОбрабоатываемойТаблицы);

                        /////TODO операция ВСТАВКИ

                        /////////////
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                            //////////TODO само обновление
                            deletedata =             SQLBuilder_Для_GRUD_Операций.
                                    delete(Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу(), Флаг_ЧерезКакоеПолеУдаление + ""+ЗнакФлагУдаление+ "?",
                                            new String[]{ЗначениеФлагУдаление});
                        }else{

                            deletedata =           Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу()
                                    .delete(НазваниеОбрабоатываемойТаблицы,Флаг_ЧерезКакоеПолеУдаление + ""+ЗнакФлагУдаление+ "?", new String[]{ЗначениеФлагУдаление});
                        }

                        /////TODO РЕЗУЛЬТАТ операция Обновление
                        //////
                        if (deletedata > 0) {
                            ///
                            ////
                            Log.w(this.getClass().getName(), "   рЕЗУЛЬТАТ МЕТОДА ВСТАВКИ ДАННЫХ  УСПЕШНО  deletedata "+deletedata);

                        }else{
                            ////
                            Log.e(this.getClass().getName(), "     рЕЗУЛЬТАТ МЕТОДА  НЕ  ВСТАВКИ ДАННЫХ  НЕ УСПЕШННО  deletedata  "+deletedata);
                        }

                        ////////

                        return deletedata;
                    }
                });


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                deletedata=       new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций);

                ///
                Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " deletedata " + deletedata);
                /////

                /////

                ///
                Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " deletedata " + deletedata);
                /////

            } catch (Exception e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());

                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            }finally {
                //////
                //////todo ПОСЛУ УСПЕШНОЙ ОПЕРАЦИИ NULL ВНЕШНИЕ КОМПОНЕНТЫ-grud
                SQLBuilder_Для_GRUD_Операций=null;
                ////
                Create_Database_СсылкаНАБазовыйКласс=null;
            }

            return deletedata;
        }

    }



    //TODO   конец КЛАСС Удаление ДАННЫХ























    //TODO КЛАСС Вставки ДАННЫХ
    class  ChangesVesionData extends Class_GRUD_SQL_Operations {

        public ChangesVesionData(@NotNull Context context) {
            super(context);
            */
/**
             *
             * @param context
             *//*

            Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);

            */
/**
             *
             *//*

            SQLBuilder_Для_GRUD_Операций =new  SQLiteQueryBuilder    ();
        }



        // TODO: 27.08.2021 МЕТОД  ВСТАВКИ ДАННЫХ
        Object changesvesiondata(Map<String,Object> concurrentHashMap, ContentValues contentValuesВставкаДанных ) throws ExecutionException, InterruptedException {
            ///////
            Object changesvesiondata=null;
            //////// TODO запуск менеджера потоков



            try {
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций.add(new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Long changesvesiondata=0L;
                        // TODO: 30.08.2021  параметры
                        String  НазваниеОбрабоатываемойТаблицы=null;
                        //

                        String ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба=null;

                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap " + concurrentHashMap.values() +
                                "  contentValuesВставкаДанных " +contentValuesВставкаДанных.valueSet());


                        //TODO ЦИКЛ ПО ПАРАМЕТРАМ
                        for (Object КлючconcurrentHashMap : concurrentHashMap.keySet()) {

                            Object ЗначениеconcurrentHashMap = concurrentHashMap.get(КлючconcurrentHashMap);
                            //

                            Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap.toString() " + concurrentHashMap.toString());

                            // TODO: 27.08.2021  присваевываем значения полям для получение данных

                            switch (КлючconcurrentHashMap.toString().trim()){

                                case "НазваниеОбрабоатываемойТаблицы" :
                                    //////
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;

                                ///
                                case "ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба" :
                                    //////
                                    ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба=ЗначениеconcurrentHashMap.toString();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;

                                ///



///
                            }

                        }


                        String СгенерированованныйДата=null;
                        //
                        String ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных=null;

                        //////
                        СгенерированованныйДата=     new Class_Generation_Data(contextСозданиеБАзы).ГлавнаяДатаИВремяОперацийСБазойДанных();



                        ///
                        Long РезультатУвеличинаяВерсияДАных=0L;




// TODO: 30.08.2021  ЗАПОЛЕНЕНИ ПОЛУЧЕННЫМИ ДАННЫМИ НОВОЙ ДАТОЙ И НОВОЙ ВЕРИСЕЙ


                        switch (ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба){
                            /////////////
                            case "Локальное":
                                /////////
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("localversionandroid",СгенерированованныйДата);
                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="localversionandroid_version";
                                ///////////////////
                                РезультатУвеличинаяВерсияДАных=          new Class_Generation_Current_Version(contextСозданиеБАзы).
                                        МетодПолученияУвеличинойВесрииДанных(НазваниеОбрабоатываемойТаблицы,ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,contextСозданиеБАзы);
                                ///
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,РезультатУвеличинаяВерсияДАных);
                                //
                                break;
                            /////////////
                            case "Серверный":
                                /////////
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("versionserveraandroid",СгенерированованныйДата);
                                //
                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="versionserveraandroid_version";
                                ////
                                РезультатУвеличинаяВерсияДАных=          new Class_Generation_Current_Version(contextСозданиеБАзы).
                                        МетодПолученияУвеличинойВесрииДанных(НазваниеОбрабоатываемойТаблицы,ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,contextСозданиеБАзы);
                                ///
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,РезультатУвеличинаяВерсияДАных);
                                //

                                ///
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,РезультатУвеличинаяВерсияДАных);

                                break;
                            /////////////
                            case "ЛокальныйСерверныйОба":
                                /////////
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("localversionandroid",СгенерированованныйДата);
                                ///
                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="localversionandroid_version";
                                ////
                                РезультатУвеличинаяВерсияДАных=          new Class_Generation_Current_Version(contextСозданиеБАзы).
                                        МетодПолученияУвеличинойВесрииДанных(НазваниеОбрабоатываемойТаблицы,ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,contextСозданиеБАзы);
                                ///
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,РезультатУвеличинаяВерсияДАных);
                                //


                                /////////
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("versionserveraandroid",СгенерированованныйДата);
                                //

                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="versionserveraandroid_version";
                                ////
                                РезультатУвеличинаяВерсияДАных=          new Class_Generation_Current_Version(contextСозданиеБАзы).
                                        МетодПолученияУвеличинойВесрииДанных(НазваниеОбрабоатываемойТаблицы,ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,contextСозданиеБАзы);

                                ///
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,РезультатУвеличинаяВерсияДАных);
                                //

                                break;


                            default:
                                throw new NullPointerException("Не выбран не одтн режим");


                        }
















// TODO: 30.08.2021  СОЗДАНИЕ ТРИГЕРА

                        Integer   РезультатИзменениеВерсииДанных=0;
                        ////

                        /////
                        String ТаблицаОбработки="MODIFITATION_Client";

                        SQLBuilder_Для_GRUD_Операций.setTables(ТаблицаОбработки);


                        /////////////
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            РезультатИзменениеВерсииДанных =             SQLBuilder_Для_GRUD_Операций.
                                    update(Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу(),contentValuesДляSQLBuilder_Для_GRUD_Операций,"name=?", new String[]{НазваниеОбрабоатываемойТаблицы});
                        }else{

                            РезультатИзменениеВерсииДанных =           Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу()
                                    .update(ТаблицаОбработки,contentValuesДляSQLBuilder_Для_GRUD_Операций,"name=?", new String[]{НазваниеОбрабоатываемойТаблицы});
                        }



                        if(РезультатИзменениеВерсииДанных>0){
                            Log.d(this.getClass().getName(), " сработала ...  обнуление версии в MODIFITATION_Client для таблицы " + НазваниеОбрабоатываемойТаблицы);

                        }
                        //
                        Log.d(this.getClass().getName(), "  СОЗДАН ТРИГЕР ДЛЯ ТАБЛИЦЫ  tabels  update     " + СгенерированованныйДата);


                        Log.d(this.getClass().getName(), "РезультатИзменениеВерсииДанных " +РезультатИзменениеВерсииДанных );

                        return РезультатИзменениеВерсииДанных;
                    }
                });


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                changesvesiondata=       new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций);

                ///
                Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " changesvesiondata " + changesvesiondata);
                /////




            } catch (Exception e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());

                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            }finally {


                //////todo ПОСЛУ УСПЕШНОЙ ОПЕРАЦИИ NULL ВНЕШНИЕ КОМПОНЕНТЫ-grud
                SQLBuilder_Для_GRUD_Операций=null;
                ////
                Create_Database_СсылкаНАБазовыйКласс=null;
            }
            //////// TODO конец  менеджера потоков

            return changesvesiondata;
        }

    }








































    // TODO: 28.08.2021 гдавный метод выполения операций EXE
    // TODO: 28.08.2021 гдавный метод выполения операций EXE
    //TODO КЛАСС ИСПОЛЕНИЯ В ПОТОКЕ
    class  ClassRuntimeExeGRUDOpertions extends Class_GRUD_SQL_Operations {
        public ClassRuntimeExeGRUDOpertions(@NotNull Context context) {
            super(context);
        }
        // TODO: 27.08.2021  МЕТОД ИСПОЛЕНИЯ В ПОТОКЕ
        protected    Object МетодЗапускаОперацийGRUD_exe( List<Callable<Object>> ЗадачаКоторуюнадоВыполнить) throws ExecutionException, InterruptedException {

            Object FinalResultRuntimeExeGRUDOpertions=null;

            //////// TODO запуск менеджера потоков
            List<Future<Object>> БудущееВЫполненнаяЗадачаGRUDОпераций=null;

            try {

                // TODO: 28.08.2021  ЗАПУСКАЕМ ЗАДАЧУ
                БудущееВЫполненнаяЗадачаGRUDОпераций= МенеджерПотоков.invokeAll(ЗадачаКоторуюнадоВыполнить);

                ///
                Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " ClassRuntimeExeGRUDOpertions  ГЛАВНЫЙ МЕТОД ВЫПОЛЕНИЯ GRUD-ОПЕРАЦИЙ  EXE   БудущееВЫполненнаяЗадачаGRUDОпераций " + БудущееВЫполненнаяЗадачаGRUDОпераций.toString());
                //

                // TODO: 28.08.2021 exit exe
            } catch (InterruptedException e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());

                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            } finally{
                ////TODO off
                МенеджерПотоков.shutdown();
                //
                while (!МенеджерПотоков.isShutdown());
                //////
                while (!МенеджерПотоков.isTerminated());

                //
                for (Future<Object> будущаяяоперациявыполенаяGRUDоперация : БудущееВЫполненнаяЗадачаGRUDОпераций) {
                    ////////////
                    FinalResultRuntimeExeGRUDOpertions    =   будущаяяоперациявыполенаяGRUDоперация.get();
                }
                //
                for (Future<Object> будущаяяоперациявыполенаяGRUDоперация : БудущееВЫполненнаяЗадачаGRUDОпераций) {
                    //
                    while (!будущаяяоперациявыполенаяGRUDоперация.isDone());
                    ///
                    будущаяяоперациявыполенаяGRUDоперация.cancel(false);
                }

                // TODO: 01.09.2021 nulls
                МенеджерПотоков=null;


            }
            //
            //////////
            Log.d(this.getClass().getName(), " сработала ... ClassRuntimeExeGRUDOpertions    "+FinalResultRuntimeExeGRUDOpertions);
            //////// TODO конец  менеджера потоков
            return FinalResultRuntimeExeGRUDOpertions;
        }

    }



    //TODO  для визуальной синхрониазциии


// TODO: 28.08.2021  КОНЕЦ гдавный метод выполения операций EXE
    // TODO: 28.08.2021 гдавный метод выполения операций EXE
    //TODO КЛАСС ИСПОЛЕНИЯ В ПОТОКЕ


























































































}


























*/
