package com.dsy.dsu.Business_logic_Only_Class;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.loader.content.AsyncTaskLoader;

import com.dsy.dsu.CREATE_DATABASE;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;




///////TODO КЛАСС ВСЕ ОПЕРАЦИИ ВСТАВКИ УДАЛЕНИЕ ОБНОВЛЕНИЯ ВЫБОРКА ДАННЫХ В ОДНОМ МЕСТЕ
public class Class_GRUD_SQL_Operations extends CREATE_DATABASE {




    ////

    public AsyncTaskLoader asyncTaskLoaderАунтификацияПользователя = null;

    ///////
    protected Stream Стрим=null;

    ///
    protected LinkedBlockingQueue БлокирующаяОчереть=new LinkedBlockingQueue();


    ///todo визуализаци синхронизации
    /// protected      МенеджерПотоков=null; //newSingleThreadExecutor()

    ///
    private Context contextClass_GRUD_SQL_Operations;
    ////////
    // TODO: 29.08.2021  ДЛЯ ОПЕРАЦИЙ grud РАБОТА С БАЗОЙ

    public    Map<String,Object> concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций = Collections.synchronizedMap(new LinkedHashMap<String,Object>());
    ///

    public Callable<Object> ЛистДляGRUDопераций = null;
    //


    // TODO: 29.08.2021  ДЛЯ ОПЕРАЦИЙ grud РАБОТА С БАЗОЙ

  public  ContentValues contentValuesДляSQLBuilder_Для_GRUD_Операций  = new ContentValues();



    //todo ССЛЫКА НА БАЗОВЫ КЛАСС
  //  CREATE_DATABASE Create_Database_СсылкаНАБазовыйКласс=null;


    private    SQLiteQueryBuilder    SQLBuilder_Для_GRUD_Операций =null;





    // TODO: 27.08.2021  Конструктор Главного Класса для Операций GRUD


    List <String> subQueriesОбьединенныйЗапросыUNION;




    public Class_GRUD_SQL_Operations(@NotNull  Context context) {
        super(context);

        //TODO контроль потоков
        ////
        contextClass_GRUD_SQL_Operations =context;

        subQueriesОбьединенныйЗапросыUNION=Collections.synchronizedList(new ArrayList());

    }













    //TODO КЛАСС ПОЛУЧЕНИЕ ДАННЫХ
    public class  GetData extends Class_GRUD_SQL_Operations {

        public GetData(@NotNull Context context) {
            super(context);

            //todo ПОДКЛЮЯЕМ КЛАСС ВЫШЕСТОЯЩИЙ ДЛЯ РАБОТЫ ОПЕРАЦИЙ grud
            /**
             *
             * @param context
             */
         ///   Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);
            ////
            ///
            /**
             *
             */
            SQLBuilder_Для_GRUD_Операций =new SQLiteQueryBuilder    ();


            //////////


        }

        // TODO: 30.08.2021  НИЖЕ  УКАЗАНЫ ВСЕ МЕТОДЫ ПОЛУЧЕНИЕ ОБНОВЛЕНИЯ ВСТАВКИ УДАЛЕНИЕ ДАННЫХ


        // TODO: 27.08.2021 МЕТОД  ПОЛУЧЕНИЯ ДАННЫХ
        public Object getdata(Map<String, Object> concurrentHashMap, CompletionService МенеджерПотоков, SQLiteDatabase getБазаДанныхДЛяОперацийВнутри) throws ExecutionException, InterruptedException {
            ///////
            Object Getdata=null;
            //////// TODO запуск менеджера потоков
            // TODO: 29.08.2021 СОЗДАЕМ ЗАДАЧУ ДЛЯ ВЫПОЛЕНИЯ ЧЕРЕЗ CALLABLE





        ЛистДляGRUDопераций=new Callable<Object>() {
                @Override
                public Object call() throws Exception {

                    /////TODO начало самого кода

                    Object getdata=null;
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

                        String ПодЗапросНомер3=null;
                        ///
                        String ПодЗапросНомер4=null;

                        String ПодЗапросНомер5=null;


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
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                ///////
                                case "СтолбцыОбработки" :
                                    СтолбцыОбработки=ЗначениеconcurrentHashMap.toString().trim();;
                                    break;
                                ///
                                case "ФорматПосика" :
                                    ФорматПосика=ЗначениеconcurrentHashMap.toString().trim();
                                    break;
                                ///
                                //////
                                case "УсловиеПоиска1" :
                                    ///////
                                    УсловиеПоиска[0]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                case "УсловиеПоиска2" :
                                    ///////
                                    УсловиеПоиска[1]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска3" :
                                    ///////
                                    УсловиеПоиска[2]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска4" :
                                    ///////
                                    УсловиеПоиска[3]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска5" :
                                    ///////
                                    УсловиеПоиска[4]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////

                                //////
                                case "УсловиеПоиска6" :
                                    ///////
                                    УсловиеПоиска[5]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////

                                //////
                                case "УсловиеПоиска7" :
                                    ///////
                                    УсловиеПоиска[6]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска8" :
                                    ///////
                                    УсловиеПоиска[7]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска9" :
                                    ///////
                                    УсловиеПоиска[8]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска10" :
                                    ///////
                                    УсловиеПоиска[9]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска11" :
                                    ///////
                                    УсловиеПоиска[10]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска12" :
                                    ///////
                                    УсловиеПоиска[11]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска13" :
                                    ///////
                                    УсловиеПоиска[12]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска14" :
                                    ///////
                                    УсловиеПоиска[13]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска15" :
                                    ///////
                                    УсловиеПоиска[14]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////

                                //////
                                case "УсловиеПоиска16" :
                                    ///////
                                    УсловиеПоиска[15]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////

                                //////
                                case "УсловиеПоиска17" :
                                    ///////
                                    УсловиеПоиска[16]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////
                                //////
                                case "УсловиеПоиска18" :
                                    ///////
                                    УсловиеПоиска[17]=ЗначениеconcurrentHashMap.toString().trim();

                                    break;
                                //////

// TODO: 27.08.2021  конец столбиков с параметрами условия посика


                                //////
                                case "ПоляГрупировки" :
                                    ПоляГрупировки=ЗначениеconcurrentHashMap.toString().trim();
                                    break;
                                /////
                                case "УсловиеГрупировки" :
                                    УсловиеГрупировки=ЗначениеconcurrentHashMap.toString().trim();
                                    break;
                                //////
                                case "УсловиеСортировки" :
                                    УсловиеСортировки=ЗначениеconcurrentHashMap.toString().trim();
                                    break;
                                //////
                                case "УсловиеЛимита" :
                                    УсловиеЛимита=ЗначениеconcurrentHashMap.toString().trim();
                                    break;
                                //////////
                                //////
                                case "ФлагНепотораяемостиСтрок" :
                                    ФлагНепотораяемостиСтрок=  (Boolean) ЗначениеconcurrentHashMap;
                                    break;
                                //////////

                                // TODO: 09.09.2021 Sub --querty  UNION ПОД ЗАПРОСЫ
                                //////
                                case "ПодЗапросНомер1" :
                                    ПодЗапросНомер1=ЗначениеconcurrentHashMap.toString().trim();
                                    // TODO: 31.01.2022  add union
                                    subQueriesОбьединенныйЗапросыUNION.add(ПодЗапросНомер1);
                                    break;
                                //////////
                                //////
                                case "ПодЗапросНомер2" :
                                    ПодЗапросНомер2=ЗначениеconcurrentHashMap.toString().trim();
                                    // TODO: 31.01.2022  add union
                                    subQueriesОбьединенныйЗапросыUNION.add(ПодЗапросНомер2);
                                    break;
                                //////
                                case "ПодЗапросНомер3" :
                                    ПодЗапросНомер3=ЗначениеconcurrentHashMap.toString().trim();
                                    // TODO: 31.01.2022  add union
                                    subQueriesОбьединенныйЗапросыUNION.add(ПодЗапросНомер3);
                                    break;
                                //////
                                case "ПодЗапросНомер4" :
                                    ПодЗапросНомер4=ЗначениеconcurrentHashMap.toString().trim();
                                    // TODO: 31.01.2022  add union
                                    subQueriesОбьединенныйЗапросыUNION.add(ПодЗапросНомер4);
                                    break;
                                //////
                                case "ПодЗапросНомер5" :
                                    ПодЗапросНомер5=ЗначениеconcurrentHashMap.toString().trim();
                                    // TODO: 31.01.2022  add union
                                    subQueriesОбьединенныйЗапросыUNION.add(ПодЗапросНомер5);
                                    break;
                                //////////
                                // TODO: 27.08.2021  конец присвоение параментов

                                // TODO: 27.08.2021  конец присвоение параментов

////
                            }

                        }

                        // TODO: 27.08.2021  проверка параметров чтоюбы небыло NULL
                        LinkedHashMap<Integer,Object> concurrentHashMapТолькоДляЗбораЗаполенныхПараметровУсловияФильтра=new LinkedHashMap<Integer,Object> ();

                        // TODO: 30.08.2021   цикл упаковываем ппарметры в массик для ЗАПРОСА
                        for (int i=0;i<УсловиеПоиска.length ; i++ ) {

                            //TODO dont null

                            Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), "УсловиеПоиска[i] " + УсловиеПоиска[i]);

                            // TODO: 03.09.2021  ВСТАВЛЯЕМ ТОЛЬКО ТЕ ПАРАРМЕНТЫ КОТОРЫ НЕ NULL

                            if (УсловиеПоиска[i] != null) {
                                ////TOdo ПОЛУЧЕНИЕ ХАША ДЛЯ ЗАПСРОСА
                                concurrentHashMapТолькоДляЗбораЗаполенныхПараметровУсловияФильтра.put(new Random().nextInt(),УсловиеПоиска[i]);
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
                            SQLBuilder_Для_GRUD_Операций.appendWhere(ФорматПосика.toLowerCase());
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
                            getdata =
                                    SQLBuilder_Для_GRUD_Операций.query(getБазаДанныхДЛяОперацийВнутри,new String[]{СтолбцыОбработки},
                                            null,ПолученныеПараметрыДляУсловияПосикаФинал
                                            ,ПоляГрупировки, УсловиеГрупировки, УсловиеСортировки,УсловиеЛимита);//ФорматПосика выше


                            // TODO: 09.09.2021  РЕЗУЛЬТА ПОЛУЧЕНИЕ ДАННЫХ ЧЕРЕЗ НОВЫЙ ДВИЖОК

                            // TODO: 09.09.2021  РЕЗУЛЬТА ПОЛУЧЕНИЕ ДАННЫХ ЧЕРЕЗ НОВЫЙ ДВИЖОК


                            Log.w(this.getClass().getName(), "   РЕЗУЛЬТАТ GetData  ПОЛУЧЕНИЕ  ДАННЫХ    КОЛ СТРОЧКЕ:  "+ ((SQLiteCursor) getdata).getCount());


                        } else {

                            // TODO: 09.09.2021  ВТОРОЙ ВАРИАНТ ПОЛУЧЕНИЕ ДАННЫХ С ПРИМЕНЕНИЕМ SUB- ПОД ЗАПРОСА//"SELECT name_col FROM table1 WHERE " + BAR_COLUMN + "='bar'",
                            //                                "SELECT name_col FROM table1 WHERE " + FOO_COLUMN + " LIKE 'foor''"


                       /*     String[] subQueries = new String[] {
                                    ПодЗапросНомер1,
                                    ПодЗапросНомер2,
                                    ПодЗапросНомер3,
                                    ПодЗапросНомер4,
                                    ПодЗапросНомер5
                            };*/


                            String[] subQueries = subQueriesОбьединенныйЗапросыUNION.toArray(new String[0]);


                            Log.w(this.getClass().getName(), "   РЕЗУЛЬТАТ GetData  ПОЛУЧЕНИЕ  ДАННЫХ  SUB UNION   КОЛ СТРОЧКЕ: UNION  subQueries   "+ subQueries);

                            String query =    SQLBuilder_Для_GRUD_Операций.buildUnionQuery(subQueries, null ,null);

                            // TODO: 01.02.2022

                            query=query.replace("ALL", " ");


                            Log.w(this.getClass().getName(), "   РЕЗУЛЬТАТ GetData  ПОЛУЧЕНИЕ  ДАННЫХ  SUB UNION   КОЛ СТРОЧКЕ: UNION  subQueries   "+ subQueries);

                            ///
                            getdata =   getБазаДанныхДЛяОперацийВнутри.rawQuery(query, null);

                            // TODO: 09.09.2021  РЕЗУЛЬТА ПОЛУЧЕНИЕ ДАННЫХ ЧЕРЕЗ НОВЫЙ ДВИЖОК


                            Log.w(this.getClass().getName(), "   РЕЗУЛЬТАТ GetData  ПОЛУЧЕНИЕ  ДАННЫХ  SUB UNION   КОЛ СТРОЧКЕ:  "+ ((SQLiteCursor) getdata).getCount());


                        }




                        Log.w(this.getClass().getName(), " ЕДИНСТВЕННЫЙ         ПОЛУЧЕНИЯ ДАННЫХ   "
                                + getdata);

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
                    }

                    // TODO: 29.08.2021  MAIN EXE запуск выполения любого кода через  CALLABLE

                    /////TODO конец  самого кода



                    // TODO: 29.10.2021 ВЫКЛЮЧАЕМ БАЗУ

                    return getdata;
                }
            };


            //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

            Getdata=     new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций,МенеджерПотоков);

            ////
            Log.d(this.getClass().getName(), "   рЕЗУЛЬТАТ МЕТОДА ПОЛУЧЕНИЕ ДАННЫХ ЧЕРЕЗ ОДИН МЕТДЖЕР ПОТОКОВ  Getdata "+Getdata);



            //////// TODO конец  менеджера потоков

            return Getdata;
        }

    }

// TODO: 17.09.2021  END GETDATA




































    //TODO КЛАСС Вставки ДАННЫХ
    public class InsertData extends Class_GRUD_SQL_Operations {

        public InsertData(@NotNull Context context) {
            super(context);
            /**
             *
             * @param context
             */
            /// Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);

            /**
             *
             */
            SQLBuilder_Для_GRUD_Операций =new SQLiteQueryBuilder    ();

            //////////

        }


        // TODO: 27.08.2021 МЕТОД  ВСТАВКИ ДАННЫХ
        public Object insertdata(Map<String, Object> concurrentHashMap, ContentValues contentValuesВставкаДанных,
                                 CompletionService МенеджерПотоков,
                                 SQLiteDatabase getБазаДанныхДЛяОперацийВнутри) throws ExecutionException, InterruptedException {
            ///////
            Object InsertData = null;
            //////// TODO запуск менеджера потоков

            try {
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций = new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Object insertData=null;
                        // TODO: 30.08.2021  параметры
                        String  НазваниеОбрабоатываемойТаблицы=null;



   /*                     Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap " + concurrentHashMap.values() +
                                "  contentValuesВставкаДанных " +contentValuesВставкаДанных.valueSet());
*/
                        //TODO ЦИКЛ ПО ПАРАМЕТРАМ
                        for (Object КлючconcurrentHashMap : concurrentHashMap.keySet()) {

                            Object ЗначениеconcurrentHashMap = concurrentHashMap.get(КлючconcurrentHashMap);
                            //

                            Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap.toString() " + concurrentHashMap.toString());

                            // TODO: 27.08.2021  присваевываем значения полям для получение данных

                            switch (КлючconcurrentHashMap.toString().trim()){

                                case "НазваниеОбрабоатываемойТаблицы" :
                                    //////
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString().trim();

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


                        // TODO: 19.11.2021 srart transation

                        
                        /////TODO операция ВСТАВКИ
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            ////////
                            insertData =    SQLBuilder_Для_GRUD_Операций.insert( getБазаДанныхДЛяОперацийВнутри, contentValuesВставкаДанных);
                        } else {
                            /////TODO операция ВСТАВКИ
                            ///
                            insertData =getБазаДанныхДЛяОперацийВнутри.insert(НазваниеОбрабоатываемойТаблицы, null, contentValuesВставкаДанных);

                        }
                        ///////


                        // TODO: 19.11.2021 close transaction

                        /////TODO РЕЗУЛЬТАТ операция ВСТАВКИ
                        ///
                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " РЕЗУЛЬТАТ insertData  ВСТАВКИ ЗНАЧЕНИЯ  " +  insertData.toString() 
                                + " результат вставки Integer.parseInt(insertData.toString()) " +Integer.parseInt(insertData.toString()));
                        //////



                        // TODO: 29.10.2021  clear in memory sqlite



                        return insertData;
                    }
                };


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                InsertData=     new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций,МенеджерПотоков);

                ///
                Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " РЕЗУЛЬТАТ InsertData  ВСТАВКИ ЗНАЧЕНИЯ  " +  InsertData.toString() );
                /////



// TODO: 29.10.2021 ВЫКЛЮЧАЕМ БАЗУ



            } catch (Exception e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());

                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            }
            //////// TODO конец  менеджера потоков

            return InsertData;
        }

    }

    //TODO КЛАСС Вставки ЧЕРЕЗ КОНТЕЙНЕР ДАННЫХ
    class  InsertDataContentResolver extends Class_GRUD_SQL_Operations {

        public InsertDataContentResolver(@NotNull Context context) {
            super(context);
            /**
             *
             * @param context
             */
            /// Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);

            /**
             *
             */
           // SQLBuilder_Для_GRUD_Операций =new SQLiteQueryBuilder    ();

            //////////

        }



        // TODO: 27.08.2021 МЕТОД  ВСТАВКИ ДАННЫХ
        Object insertdataContentResolver(Map<String,Object> concurrentHashMap, ContentValues[] contentValuesВставкаДанных ,
                          CompletionService МенеджерПотоков,
                          SQLiteDatabase getБазаДанныхДЛяОперацийВнутри) throws ExecutionException, InterruptedException {
            ///////
            Object InsertData=null;
            //////// TODO запуск менеджера потоков

            try {
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций = new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Object insertData=null;
                        // TODO: 30.08.2021  параметры
                        String  НазваниеОбрабоатываемойТаблицы=null;



   /*                     Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap " + concurrentHashMap.values() +
                                "  contentValuesВставкаДанных " +contentValuesВставкаДанных.valueSet());
*/
                        //TODO ЦИКЛ ПО ПАРАМЕТРАМ
                        for (Object КлючconcurrentHashMap : concurrentHashMap.keySet()) {

                            Object ЗначениеconcurrentHashMap = concurrentHashMap.get(КлючconcurrentHashMap);
                            //

                            Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap.toString() " + concurrentHashMap.toString());

                            // TODO: 27.08.2021  присваевываем значения полям для получение данных

                            switch (КлючconcurrentHashMap.toString().trim()){

                                case "НазваниеОбрабоатываемойТаблицы" :
                                    //////
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString().trim();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;

                                ///
///
                            }

                        }

                        Log.w(this.getClass().getName(), "   НазваниеОбрабоатываемойТаблицы   "+НазваниеОбрабоатываемойТаблицы);

                        //////TODO конец параменты

                        // TODO: 30.08.2021  ОРМИРУЕМ КОРКАТ БУДЩЕЙ ВСТАВКИ ДАННЫХ



                        Uri uri = Uri.parse("content://MyContentProviderDatabase/" +НазваниеОбрабоатываемойТаблицы + "");


                        ContentResolver resolver = contextClass_GRUD_SQL_Operations.getContentResolver();


                        insertData=   resolver.bulkInsert(uri, contentValuesВставкаДанных);

                        /////TODO РЕЗУЛЬТАТ операция ВСТАВКИ
                        ///
                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " РЕЗУЛЬТАТ insertData  ВСТАВКИ ЗНАЧЕНИЯ  " +  insertData.toString() );
                        //////

                        return insertData;
                    }
                };


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                InsertData=     new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций,МенеджерПотоков);

                ///
                Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " РЕЗУЛЬТАТ InsertData  ВСТАВКИ ЗНАЧЕНИЯ  " +  InsertData.toString() );
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
            }
            //////// TODO конец  менеджера потоков

            return InsertData;
        }

    }












    //TODO КЛАСС Обновление ДАННЫХ
    public class  UpdateData extends Class_GRUD_SQL_Operations {

        public UpdateData(@NotNull Context context) {
            super(context);
            /**
            /**
             *
             * @param context
             */
          //  Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);
            /**
             *
             */
            SQLBuilder_Для_GRUD_Операций =new SQLiteQueryBuilder    ();

            //////////

        }


        // TODO: 27.08.2021 МЕТОД  ПОЛУЧЕНИЯ ДАННЫХ
        public Object updatedata(Map<String, Object> concurrentHashMap, ContentValues contentValuesДляОбновленияДАнных, CompletionService МенеджерПотоков, SQLiteDatabase getБазаДанныхДЛяОперацийВнутри) throws ExecutionException, InterruptedException {
            ///////////
            Object Updatedata=null;
            //////// TODO запуск менеджера потоков
            try {
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций= new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Object updatedata=null;
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
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString().trim();

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


                        // TODO: 19.11.2021 srart transation


                        /////////////
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                            //////////TODO само обновление
                            updatedata =             SQLBuilder_Для_GRUD_Операций.
                                    update(getБазаДанныхДЛяОперацийВнутри,contentValuesДляОбновленияДАнных, Флаг_ЧерезКакоеПолеОбновлением +  ""+ЗнакФлагОбновления+ "?",
                                            new String[]{ЗначениеФлагОбновления});
                        }else{

                            updatedata =           getБазаДанныхДЛяОперацийВнутри
                                    .update(НазваниеОбрабоатываемойТаблицы,contentValuesДляОбновленияДАнных,Флаг_ЧерезКакоеПолеОбновлением +  ""+ЗнакФлагОбновления+ "?", new String[]{ЗначениеФлагОбновления});
                        }

                        /////TODO РЕЗУЛЬТАТ операция Обновление


                        Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " updatedata " + updatedata.toString() + "результат обвноления  Integer.parseInt(updatedata.toString() "+Integer.parseInt(updatedata.toString()));
                        ////////



                        // TODO: 29.10.2021  clear in memory sqlite



                        return updatedata;
                    }
                };


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                Updatedata=     new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций,МенеджерПотоков);

                ///

                /////
                ///
                Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " РЕЗУЛЬТАТ Updatedata  ОБНОВЛЕНИЕ ЗНАЧЕНИЯ  " +  Updatedata.toString() );


// TODO: 29.10.2021 ВЫКЛЮЧАЕМ БАЗУ


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
            }
            //////// TODO конец  менеджера потоков

            return Updatedata;
        }

    }


    //TODO КЛАСС СОН SLEEP ДАННЫХ
    public class SleepData extends Class_GRUD_SQL_Operations {
        public SleepData(@NotNull Context context) {
            super(context);
            /**
             *
             * @param context
             */
            //Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);

            /**
             *
             */
            SQLBuilder_Для_GRUD_Операций = new SQLiteQueryBuilder();


        }

        // TODO: 27.08.2021 МЕТОД  ПОЛУЧЕНИЯ ДАННЫХ
        public Object sleepdata(Map<String, Object> concurrentHashMap, ContentValues contentValuesДляСнаДанных, CompletionService МенеджерПотоков, SQLiteDatabase getБазаДанныхДЛяОперацийВнутри) throws ExecutionException, InterruptedException {
            /////
            Object Sleepdata = null;
            //////// TODO запуск менеджера потоков

            try {
                ///TODO тело самого кода List    ////
                //////// TODO запуск менеджера потоков
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций = new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Object sleepdata=null;
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
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString().trim();

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
                                    update(getБазаДанныхДЛяОперацийВнутри,contentValuesДляСнаДанных, Флаг_ЧерезКакоеПолеСнаДанных + "= ?",
                                            new String[]{ЗначениеФлагСнаДанных});
                        }else{

                            sleepdata =           getБазаДанныхДЛяОперацийВнутри
                                    .update(НазваниеОбрабоатываемойТаблицы,contentValuesДляСнаДанных,Флаг_ЧерезКакоеПолеСнаДанных + "= ?", new String[]{ЗначениеФлагСнаДанных});
                        }

                        /////TODO РЕЗУЛЬТАТ операция Обновление
                        //////

                        ////
                        Log.w(this.getClass().getName(), "   рЕЗУЛЬТАТ МЕТОДА ВСТАВКИ ДАННЫХ  УСПЕШНО  deletedata "+sleepdata);

                        ////////

                        return sleepdata;
                    }
                };


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                Sleepdata=   new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций,МенеджерПотоков);

                ///
                Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " РЕЗУЛЬТАТ sleepdata  СНА ДАННЫХ  ЗНАЧЕНИЯ  " +  Sleepdata.toString() );
                /////

                /////

                ///
                Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " sleepdata " + Sleepdata);
                /////

// TODO: 29.10.2021 ВЫКЛЮЧАЕМ БАЗУ


            } catch (Exception e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            }

            return Sleepdata;
        }

    }


    //TODO










    //TODO КЛАСС Удаление ДАННЫХ
    public class  DeleteData extends Class_GRUD_SQL_Operations {
        public DeleteData(@NotNull Context context) {
            super(context);
            /**
             *
             * @param context
             */
            ///Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);
            /**
             *
             */
            SQLBuilder_Для_GRUD_Операций =new SQLiteQueryBuilder    ();



        }
        // TODO: 27.08.2021 МЕТОД  ПОЛУЧЕНИЯ ДАННЫХ
        public Object deletedata(Map<String, Object> concurrentHashMap
                , CompletionService МенеджерПотоков,
                                 SQLiteDatabase getБазаДанныхДЛяОперацийВнутри) throws ExecutionException, InterruptedException {
            /////
            Object Deletedata=null;
            //////// TODO запуск менеджера потоков

            try {
                ///TODO тело самого кода List    ////
                //////// TODO запуск менеджера потоков
                ///TODO тело самого кода List    ////
             ЛистДляGRUDопераций=new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Object deletedata=null;
                        ///
                        // TODO: 30.08.2021  параметры
                        String  НазваниеОбрабоатываемойТаблицы=null;
                        /////
                        String  Флаг_ЧерезКакоеПолеУдаление=null;

                        //
                        String  ЗначениеФлагУдаление=null;

                        //
                        String  ЗначениеФлагУдалениеВторое=null;
                        //
                        String ЗнакФлагУдаление=null;

                        String   СамFreeSQLКОд=null;


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
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString().trim();

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
                                case "ЗначениеФлагУдалениеВторой" :
                                    //////
                                    ЗначениеФлагУдалениеВторое=ЗначениеconcurrentHashMap.toString();

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


                                //
                                case "СамFreeSQLКОд" :
                                    //////
                                    СамFreeSQLКОд=ЗначениеconcurrentHashMap.toString();

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

                        // TODO: 29.12.2021
                        SQLBuilder_Для_GRUD_Операций.appendWhere(Флаг_ЧерезКакоеПолеУдаление);

                        /////TODO операция ВСТАВКИ.rawQuery(СамFreeSQLКОд, null);

                        int РезультатУдаления= 0;


                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {

                         /*   РезультатУдаления = SQLBuilder_Для_GRUD_Операций
                                    .delete(getБазаДанныхДЛяОперацийВнутри,null,null);*/
                   /*         РезультатУдаления =  getБазаДанныхДЛяОперацийВнутри
                                    .delete(НазваниеОбрабоатываемойТаблицы,null, null);*/
                            РезультатУдаления = SQLBuilder_Для_GRUD_Операций.
                            delete(getБазаДанныхДЛяОперацийВнутри, null,
                                    new String[]{ЗначениеФлагУдаление,ЗначениеФлагУдалениеВторое});
                            ///
                            ///
                            Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " РезультатУдаления" + "--" + РезультатУдаления);/////
                        }else{

                            РезультатУдаления =  getБазаДанныхДЛяОперацийВнутри
                                    .delete(НазваниеОбрабоатываемойТаблицы,Флаг_ЧерезКакоеПолеУдаление,
                                            new String[]{ЗначениеФлагУдаление,ЗначениеФлагУдалениеВторое});

                            ///
                            Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " РезультатУдаления" + "--" + РезультатУдаления);/////
                        }

                        Log.d(this.getClass().getName(), "РезультатУдаления "+РезультатУдаления );

            /*            /////////////
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                            //////////TODO само обновление
                            deletedata =             SQLBuilder_Для_GRUD_Операций.
                                    delete(getБазаДанныхДЛяОперацийВнутри, null,
                                            new String[]{ЗначениеФлагУдаление,ЗначениеФлагУдалениеВторое});
                        }else{

                            deletedata =           getБазаДанныхДЛяОперацийВнутри
                                    .delete(НазваниеОбрабоатываемойТаблицы,Флаг_ЧерезКакоеПолеУдаление,
                                            new String[]{ЗначениеФлагУдаление,ЗначениеФлагУдалениеВторое});


                            Log.w(this.getClass().getName(), "   deletedata   "+deletedata);

                            //
                 *//*           deletedata =           Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу()
                                    .delete(НазваниеОбрабоатываемойТаблицы,Флаг_ЧерезКакоеПолеУдаление + ""+ЗнакФлагУдаление+ "?", new String[]{ЗначениеФлагУдаление});*//*
                        }*/

                        /////TODO РЕЗУЛЬТАТ операция Обновление
                        //////


                        ////////

                        return РезультатУдаления;
                    }
                };


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                Deletedata=     new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций,МенеджерПотоков);

                ///
                ///
                Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " РЕЗУЛЬТАТ deletedata  УДАЛЕНИЕ ДАННЫХ  ЗНАЧЕНИЯ  " +  Deletedata.toString() );
                /////

                /////

                ///
                Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " deletedata " + Deletedata);
                /////

// TODO: 29.10.2021 ВЫКЛЮЧАЕМ БАЗУ


            } catch (Exception e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());

                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            }

            return Deletedata;
        }
// TODO: 22.02.2022 данный метод НУЖЕН ТОЛЬЕО ДЛЯ УДАЛЕНИЕ ТАБЛДИЦ ПОЛНОСТЬЮ


        // TODO: 27.08.2021 МЕТОД  ПОЛУЧЕНИЯ ДАННЫХ
        Object deletedataAlltable(Map<String,Object> concurrentHashMap
                ,CompletionService МенеджерПотоков,
                          SQLiteDatabase getБазаДанныхДЛяОперацийВнутри) throws ExecutionException, InterruptedException {
            /////
            Object deletedataAlltable=null;
            //////// TODO запуск менеджера потоков

            try {
                ///TODO тело самого кода List    ////
                //////// TODO запуск менеджера потоков
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций=new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Object deletedata=null;
                        ///
                        // TODO: 30.08.2021  параметры
                        String  НазваниеОбрабоатываемойТаблицы=null;
                        /////
                        String  Флаг_ЧерезКакоеПолеУдаление=null;

                        //
                        String  ЗначениеФлагУдаление=null;

                        //
                        String  ЗначениеФлагУдалениеВторое=null;
                        //
                        String ЗнакФлагУдаление=null;

                        String   СамFreeSQLКОд=null;


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
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString().trim();

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
                                case "ЗначениеФлагУдалениеВторой" :
                                    //////
                                    ЗначениеФлагУдалениеВторое=ЗначениеconcurrentHashMap.toString();

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


                                //
                                case "СамFreeSQLКОд" :
                                    //////
                                    СамFreeSQLКОд=ЗначениеconcurrentHashMap.toString();

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

                        // TODO: 29.12.2021

                        /////TODO операция ВСТАВКИ.rawQuery(СамFreeSQLКОд, null);

                        int РезультатУдаленияВсейТаблицы= 0;


                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {

                         /*   РезультатУдаления = SQLBuilder_Для_GRUD_Операций
                                    .delete(getБазаДанныхДЛяОперацийВнутри,null,null);*/
                   /*         РезультатУдаления =  getБазаДанныхДЛяОперацийВнутри
                                    .delete(НазваниеОбрабоатываемойТаблицы,null, null);*/
                            РезультатУдаленияВсейТаблицы = SQLBuilder_Для_GRUD_Операций
                                    .delete(getБазаДанныхДЛяОперацийВнутри,null,null);
                            ///
                            ///
                            Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " РезультатУдаленияВсейТаблицы" + "--" + РезультатУдаленияВсейТаблицы);/////
                        }else{

                            РезультатУдаленияВсейТаблицы =  getБазаДанныхДЛяОперацийВнутри
                                    .delete(НазваниеОбрабоатываемойТаблицы,null, null);

                            ///
                            Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " РезультатУдаления" + "--" + РезультатУдаленияВсейТаблицы);/////
                        }

                        Log.d(this.getClass().getName(), "РезультатУдаления "+РезультатУдаленияВсейТаблицы );

            /*            /////////////
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                            //////////TODO само обновление
                            deletedata =             SQLBuilder_Для_GRUD_Операций.
                                    delete(getБазаДанныхДЛяОперацийВнутри, null,
                                            new String[]{ЗначениеФлагУдаление,ЗначениеФлагУдалениеВторое});
                        }else{

                            deletedata =           getБазаДанныхДЛяОперацийВнутри
                                    .delete(НазваниеОбрабоатываемойТаблицы,Флаг_ЧерезКакоеПолеУдаление,
                                            new String[]{ЗначениеФлагУдаление,ЗначениеФлагУдалениеВторое});


                            Log.w(this.getClass().getName(), "   deletedata   "+deletedata);

                            //
                 *//*           deletedata =           Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу()
                                    .delete(НазваниеОбрабоатываемойТаблицы,Флаг_ЧерезКакоеПолеУдаление + ""+ЗнакФлагУдаление+ "?", new String[]{ЗначениеФлагУдаление});*//*
                        }*/

                        /////TODO РЕЗУЛЬТАТ операция Обновление
                        //////


                        ////////

                        return РезультатУдаленияВсейТаблицы;
                    }
                };


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                deletedataAlltable=     new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций,МенеджерПотоков);

                ///
                ///
                Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " РЕЗУЛЬТАТ deletedata  УДАЛЕНИЕ ДАННЫХ  ЗНАЧЕНИЯ  " +  deletedataAlltable.toString() );
                /////

                /////

                ///
                Log.d(contextClass_GRUD_SQL_Operations.getClass().getName(), " deletedata " + deletedataAlltable);
                /////

// TODO: 29.10.2021 ВЫКЛЮЧАЕМ БАЗУ


            } catch (Exception e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());

                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            }

            return deletedataAlltable;
        }

    }



    //TODO   конец КЛАСС Удаление ДАННЫХ























    //TODO КЛАСС Вставки ДАННЫХ
    public class  ChangesVesionData extends Class_GRUD_SQL_Operations {

        public ChangesVesionData(@NotNull Context context) {
            super(context);
            /**
             *
             * @param context
             */
      ///      Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);

            /**
             *
             */
            SQLBuilder_Для_GRUD_Операций =new  SQLiteQueryBuilder    ();

            //////////

        }


        // TODO: 27.08.2021 МЕТОД  ИЗМЕНЕНИЯ ПОВЫШЕНИЯ ВЕРСИИ ДЛЯ  ТЕКУЩЕЙ ТАБЛИЦЫ ТАБЛИЦЫ
        public Object changesvesiondata(Map<String, Object> concurrentHashMap,
                                        CompletionService МенеджерПотоков,
                                        SQLiteDatabase getБазаДанныхДЛяОперацийВнутри) throws ExecutionException, InterruptedException {
            ///////
            Object Changesvesiondata = null;
            //////// TODO запуск менеджера потоков


            try {
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций = new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Object changesvesiondata=null;
                        // TODO: 30.08.2021  параметры
                        String  НазваниеОбрабоатываемойТаблицы=null;
                        //

                        String ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба=null;



                        //

                        String ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать=null;


                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap " + concurrentHashMap.values() );


                        //TODO ЦИКЛ ПО ПАРАМЕТРАМ
                        for (Object КлючconcurrentHashMap : concurrentHashMap.keySet()) {

                            Object ЗначениеconcurrentHashMap = concurrentHashMap.get(КлючconcurrentHashMap);
                            //

                            Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap.toString() " + concurrentHashMap.toString());

                            // TODO: 27.08.2021  присваевываем значения полям для получение данных

                            switch (КлючconcurrentHashMap.toString().trim()){

                                case "НазваниеОбрабоатываемойТаблицы" :
                                    //////
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString().trim();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;

                                ///
                                case "ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба" :
                                    //////
                                    ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба=ЗначениеconcurrentHashMap.toString().trim();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;

                                ///

                                ///
                                case "ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать" :
                                    //////
                                    ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать=ЗначениеconcurrentHashMap.toString().trim();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;

                                ///





                            }

                        }

                        // TODO: 23.09.2021  почле цикла
                        Log.d(this.getClass().getName(), "  ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать"
                                +ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать);

                        String СгенерированованныйДата=null;
                        //
                        String ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных=null;




                        ///
                        Long РезультатУвеличинаяВерсияДАных=0L;

                        //////
                        СгенерированованныйДата=     new Class_Generation_Data(contextСозданиеБАзы).ГлавнаяДатаИВремяОперацийСБазойДанных();

                        Log.d(this.getClass().getName(), "   ЗАПУСК ФОНОВОЙ СИНХРОНИЗАЦИИИ С mYwORK_sYNCHRONIZACI  СЛУЖБА  WorkManager Synchronizasiy_Data  СгенерированованныйДата "+СгенерированованныйДата);

// TODO: 30.08.2021  ЗАПОЛЕНЕНИ ПОЛУЧЕННЫМИ ДАННЫМИ НОВОЙ ДАТОЙ И НОВОЙ ВЕРИСЕЙ


                        switch (ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба){





                            ///////////// ПЕРВОЕ ЛОКАЛЬНОЕ
                            case "Локальное":
                                /////////
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("localversionandroid",СгенерированованныйДата);
                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="localversionandroid_version";
                                ///////////////////--old ВЕРСИЯ ПОВЫШЕНИЯ ДАННЫХ

                              /*  РезультатУвеличинаяВерсияДАных=
                                        МетодПолученияУвеличинойВесрииДанныхДляТекущейТолькоДляСистемнойТаблицы_MODIFITATION_Client(
                                                НазваниеОбрабоатываемойТаблицы.toLowerCase(),"localversionandroid_version",contextСозданиеБАзы
                                                ,getБазаДанныхДЛяОперацийВнутри);*/

                                // TODO: 13.01.2022
                                Log.w(this.getClass().getName(), "  ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать"
                                        +ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать);

                                ///
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,
                                        ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать);
                                //
                                break;






                            ///////////// ВТОРОЕ

                            case "Серверный":
                                /////////
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("versionserveraandroid",СгенерированованныйДата);
                                //
                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="versionserveraandroid_version";
                                ////

/*

                                    РезультатУвеличинаяВерсияДАных=
                                            МетодПолученияУвеличинойВесрииДанныхДляТекущейТолькоДляСистемнойТаблицы_MODIFITATION_Client(
                                                    НазваниеОбрабоатываемойТаблицы.toLowerCase(),"localversionandroid_version",contextСозданиеБАзы
                                                    ,getБазаДанныхДЛяОперацийВнутри);
*/

                                // TODO: 13.01.2022
                                Log.w(this.getClass().getName(), "  ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать"
                                        +ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать);

                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,
                                        ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать);
                                //

                                break;


                            ///////////// Третье

                            case "ЛокальныйСерверныйОба":

                                //TODO ПОДНИМАЕМ ЛОКАЛЬНУЮ ВЕРИСЮ ДАННЫХ  ТУТ В ОБА ПОДНИМЕМ И  ЛОКАЛЬНУЮ И СЕРВРНУЮ ТАК КАК ВЫБРАНО СРУЗА ОБРА РЕЖИМА


                                /////////
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("localversionandroid",СгенерированованныйДата);
                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="localversionandroid_version";
                                ///////////////////--old ВЕРСИЯ ПОВЫШЕНИЯ ДАННЫХ


/*
                                РезультатУвеличинаяВерсияДАных=
                                        МетодПолученияУвеличинойВесрииДанныхДляТекущейТолькоДляСистемнойТаблицы_MODIFITATION_Client(
                                                НазваниеОбрабоатываемойТаблицы.toLowerCase(),"localversionandroid_version",contextСозданиеБАзы
                                                ,getБазаДанныхДЛяОперацийВнутри);*/

                                // TODO: 13.01.2022
                                Log.w(this.getClass().getName(), "  ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать"
                                        +ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать);

                                ///
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,
                                        ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать);






                                /////////TODO ВТОРАЯ ОПЕРАЦИЯ ПОДИНМАЕТ СЕРВЕРНУЮ ВЕРИСЮ
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("versionserveraandroid",СгенерированованныйДата);
                                //
                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="versionserveraandroid_version";
                                ////
               /*                 РезультатУвеличинаяВерсияДАных=
                                        МетодПолученияУвеличинойВесрииДанныхДляТекущейТолькоДляСистемнойТаблицы_MODIFITATION_Client(
                                                НазваниеОбрабоатываемойТаблицы.toLowerCase(),"localversionandroid_version",contextСозданиеБАзы
                                                ,getБазаДанныхДЛяОперацийВнутри);*/

                                // TODO: 13.01.2022
                                Log.w(this.getClass().getName(), "  ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать"+
                                        ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать);

                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,
                                        ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать);
                                //

                                break;


















                            default:
                                throw new NullPointerException("Не выбран не одтн режим");


                        }





// TODO: 30.08.2021  СОЗДАНИЕ ТРИГЕРА


                        ////

                        /////
                        String ТаблицаОбработки="MODIFITATION_Client";

                        SQLBuilder_Для_GRUD_Операций.setTables(ТаблицаОбработки.toLowerCase());


                        // TODO: 19.11.2021 srart transation


                        /////////////
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            ////////
                            changesvesiondata =             SQLBuilder_Для_GRUD_Операций.
                                    update(getБазаДанныхДЛяОперацийВнутри,
                                            contentValuesДляSQLBuilder_Для_GRUD_Операций,"name=?", new String[]{НазваниеОбрабоатываемойТаблицы.toLowerCase()});
                        }else{
                            ///////////////

                            changesvesiondata =           getБазаДанныхДЛяОперацийВнутри
                                    .update(ТаблицаОбработки,contentValuesДляSQLBuilder_Для_GRUD_Операций,"name=?", new String[]{НазваниеОбрабоатываемойТаблицы.toLowerCase()});
                        }

                        // TODO: 22.11.2021  ПОСЛЕ УСПЕШНОЙ ОПЕРАЦИИ ПОДТВЕРЖДАЕМ ТРАНЗАУЙИЮ




                        // TODO: 19.11.2021 close transaction

                        //
                        Log.d(this.getClass().getName(), "  СОЗДАН ТРИГЕР ДЛЯ ТАБЛИЦЫ  tabels  update     " + СгенерированованныйДата);


                        Log.d(this.getClass().getName(), "РезультатИзменениеВерсииДанных " +changesvesiondata+
                                " результат изменения данных Integer.parseInt(changesvesiondata.toString()) " +Integer.parseInt(changesvesiondata.toString()));


                        return changesvesiondata;
                    }
                };


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                Changesvesiondata =    new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций,МенеджерПотоков);

                ///
                ///
                Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " РЕЗУЛЬТАТ changesvesiondata  ИЗМЕНЕНИЯ ДАННЫХ  ЗНАЧЕНИЯ  " +  Changesvesiondata.toString() );
                /////





// TODO: 29.10.2021 ВЫКЛЮЧАЕМ БАЗУ




            } catch (Exception e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());

                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            }
            //////// TODO конец  менеджера потоков

            return Changesvesiondata;
        }
///// todo конец первой повышени  данных







                // TODO: 27.08.2021 ПОВЫШЕНИЯ ВЕРСИИ ДАННЫХ В ТОЛЬКО ТАБЛИЦЕ  MODIFITATION_Client , ТОЛЬКО ПОСЛЕ УСПЕШНОЙ СИНХРОНИАЗЦИИ
                Object changesvesiondata_Для_MODIFITATION_Client_ТОлькоДЛяТаблицИзГлавногоЦиклаВМоментСинхрониазацииДанных(Map<String,Object> concurrentHashMap
                ,CompletionService
                                                                                                                           МенеджерПотоков,
                                                                                                                   SQLiteDatabase getБазаДанныхДЛяОперацийВнутри)

                throws ExecutionException, InterruptedException {
            ///////
            Object ChangesvesiondataДля_MODIFITATION_Client_СинхрониазацииДанных=null;
            //////// TODO запуск менеджера потоков



            try {
                ///TODO тело самого кода List    ////
                ЛистДляGRUDопераций=new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        /////
                        Object changesvesiondata_MODIFITATION_Client_СинхрониазацииДанных =null;
                        // TODO: 30.08.2021  параметры
                        String  НазваниеОбрабоатываемойТаблицы=null;
                        //

                        String ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба=null;

                        Long ДополнительныйФлагДляСинхЧАТАТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба=0l;

                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap " + concurrentHashMap.values() );


                        //TODO ЦИКЛ ПО ПАРАМЕТРАМ
                        for (Object КлючconcurrentHashMap : concurrentHashMap.keySet()) {

                            Object ЗначениеconcurrentHashMap = concurrentHashMap.get(КлючconcurrentHashMap);
                            //

                            Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "concurrentHashMap.toString() " + concurrentHashMap.toString());

                            // TODO: 27.08.2021  присваевываем значения полям для получение данных

                            switch (КлючconcurrentHashMap.toString().trim()){

                                case "НазваниеОбрабоатываемойТаблицы" :
                                    //////
                                    НазваниеОбрабоатываемойТаблицы=ЗначениеconcurrentHashMap.toString().trim();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;

                                ///
                                case "ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба" :
                                    //////
                                    ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба=ЗначениеconcurrentHashMap.toString().trim();

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;

                                ///

                                ///
                                case "ДополнительныйФлагДляСинхЧАТАТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба" :
                                    //////
                                    ДополнительныйФлагДляСинхЧАТАТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба=Long.parseLong(ЗначениеconcurrentHashMap.toString().trim());

                                    // TODO: 27.08.2021  конец присвоение параментов
                                    break;

                                ///


///
                            }

                        }

                        // TODO: 23.09.2021  почле цикла


                        String СгенерированованныйДата=null;
                        //
                        String ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных=null;




                        ///
                        Long РезультатУвеличинаяВерсияДАных=0L;

                        //////
                        СгенерированованныйДата=     new Class_Generation_Data(contextСозданиеБАзы).ГлавнаяДатаИВремяОперацийСБазойДанных();

                        Log.d(this.getClass().getName(), "   ЗАПУСК ФОНОВОЙ СИНХРОНИЗАЦИИИ С mYwORK_sYNCHRONIZACI  СЛУЖБА  WorkManager Synchronizasiy_Data  СгенерированованныйДата "+СгенерированованныйДата);









// TODO: 30.08.2021  ЗАПОЛЕНЕНИ ПОЛУЧЕННЫМИ ДАННЫМИ НОВОЙ ДАТОЙ И НОВОЙ ВЕРИСЕЙ


                        switch (ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба){



                     /*       /////////////ПЕРВОЕ
                            case "Локальное":
                                /////////
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("localversionandroid",СгенерированованныйДата);
                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="localversionandroid_version";
                                ///////////////////--old ВЕРСИЯ ПОВЫШЕНИЯ ДАННЫХ

                                ///
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,ДополнительныйФлагДляСинхЧАТАТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба);



                                Log.d(this.getClass().getName(), " Локальное contentValuesДляSQLBuilder_Для_GRUD_Операций.valueSet() "+contentValuesДляSQLBuilder_Для_GRUD_Операций.valueSet()
                                        +"\n"+
                                         " contentValuesДляSQLBuilder_Для_GRUD_Операций.keySet() " + contentValuesДляSQLBuilder_Для_GRUD_Операций.keySet());
                                //
                                break;






                            /////////////ВТОРОЙ
                            case "Серверный":
                                /////////
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("versionserveraandroid",СгенерированованныйДата);
                                //
                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="versionserveraandroid_version";
                                ////

                                ///
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,ДополнительныйФлагДляСинхЧАТАТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба);
                                //


                                Log.d(this.getClass().getName(), " Серверный contentValuesДляSQLBuilder_Для_GRUD_Операций.valueSet() "+contentValuesДляSQLBuilder_Для_GRUD_Операций.valueSet()
                                        +"\n"+
                                        " contentValuesДляSQLBuilder_Для_GRUD_Операций.keySet() " + contentValuesДляSQLBuilder_Для_GRUD_Операций.keySet());


                                break;*/










                            ///////////// ТРЕТИЙ
                            case "ЛокальныйСерверныйОба":


                                // TODO: 04.10.2021  ВТОРАЯ ЧАСТЬ ПОЛЯ В ТАБЛИЦЕ ЭТО КОГДА МЫ ВЫБПВАЛИ ИЗМЕНЕНИЯ СРАЗУ ПО БВУМ ПОЛЯМ И ЛОКАЛЬНАЯ И ССЕРВЕРВАЯ
                                /////////
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("localversionandroid",СгенерированованныйДата);
                                ///
                                /////////
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put("versionserveraandroid",СгенерированованныйДата);

                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="localversionandroid_version";
                                ////


                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,ДополнительныйФлагДляСинхЧАТАТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба);
                                //

                                // TODO: 04.10.2021  ТОЛЬКО ВРЕМЯ




                                /////////
                                ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных="versionserveraandroid_version";
                                ////
                                ///
                                contentValuesДляSQLBuilder_Для_GRUD_Операций.put(ПолеНаОснованииКотрогоУвеличиваемВерсиюДанных,ДополнительныйФлагДляСинхЧАТАТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба);
                                //

                                Log.d(this.getClass().getName(), " Локальное contentValuesДляSQLBuilder_Для_GRUD_Операций.valueSet() "+contentValuesДляSQLBuilder_Для_GRUD_Операций.valueSet()
                                        +"\n"+
                                        " contentValuesДляSQLBuilder_Для_GRUD_Операций.keySet() " + contentValuesДляSQLBuilder_Для_GRUD_Операций.keySet());

                                break;


                            default:
                                throw new NullPointerException("Не выбран не одтн режим");




                        }
















// TODO: 30.08.2021  СОЗДАНИЕ ТРИГЕРА


                        ////

                        /////
                        String ТаблицаОбработки="MODIFITATION_Client";

                        SQLBuilder_Для_GRUD_Операций.setTables(ТаблицаОбработки.toLowerCase());


                        // TODO: 14.01.2022


                        // TODO: 19.11.2021 srart transation
                     getБазаДанныхДЛяОперацийВнутри.beginTransaction();

                        /////////////
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            ////////
                            changesvesiondata_MODIFITATION_Client_СинхрониазацииДанных =             SQLBuilder_Для_GRUD_Операций.
                                    update(getБазаДанныхДЛяОперацийВнутри,
                                            contentValuesДляSQLBuilder_Для_GRUD_Операций,"name=?", new String[]{НазваниеОбрабоатываемойТаблицы.toLowerCase()});
                        }else{
                            ///////////////

                            changesvesiondata_MODIFITATION_Client_СинхрониазацииДанных =           getБазаДанныхДЛяОперацийВнутри
                                    .update(ТаблицаОбработки,contentValuesДляSQLBuilder_Для_GRUD_Операций,"name=?", new String[]{НазваниеОбрабоатываемойТаблицы.toLowerCase()});
                        }

                        // TODO: 22.11.2021  ПОСЛЕ УСПЕШНОЙ ОПЕРАЦИИ ПОДТВЕРЖДАЕМ ТРАНЗАУЙИЮ

                      if (Integer.parseInt(changesvesiondata_MODIFITATION_Client_СинхрониазацииДанных.toString())>0) {
                            // TODO: 12.01.2022 set success tra 
                        getБазаДанныхДЛяОперацийВнутри.setTransactionSuccessful();
                        }
                        // TODO: 19.11.2021 close transaction
                       getБазаДанныхДЛяОперацийВнутри.endTransaction();


                        //
                        Log.d(this.getClass().getName(), "  СОЗДАН ТРИГЕР ДЛЯ ТАБЛИЦЫ  tabels  update  Для_MODIFITATION_Client_СинхрониазацииДанных     " + СгенерированованныйДата);


                        Log.d(this.getClass().getName(), "РезультатИзменениеВерсииДанных  changesvesiondata_MODIFITATION_Client_СинхрониазацииДанных  Для_MODIFITATION_Client_СинхрониазацииДанных " +
                                "" +changesvesiondata_MODIFITATION_Client_СинхрониазацииДанных+
                                " результат изменения данных Integer.parseInt(changesvesiondata.toString()) " +Integer.parseInt(changesvesiondata_MODIFITATION_Client_СинхрониазацииДанных.toString()));


                        return changesvesiondata_MODIFITATION_Client_СинхрониазацииДанных;
                    }
                };


                //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                ChangesvesiondataДля_MODIFITATION_Client_СинхрониазацииДанных =    new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций,МенеджерПотоков);

                ///
                ///
                Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), " РЕЗУЛЬТАТ changesvesiondata  ИЗМЕНЕНИЯ ДАННЫХ  ЗНАЧЕНИЯ  ChangesvesiondataДля_MODIFITATION_Client_СинхрониазацииДанных" +
                        " " +  ChangesvesiondataДля_MODIFITATION_Client_СинхрониазацииДанных.toString() );
                /////





// TODO: 29.10.2021 ВЫКЛЮЧАЕМ БАЗУ




            } catch (Exception e) {
                ///////TODO error
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());

                new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                /////
            }


            //////// TODO конец  менеджера потоков

            return ChangesvesiondataДля_MODIFITATION_Client_СинхрониазацииДанных;
        }




























        // TODO: 23.09.2021 МЕТОД ДЛЯ КЛАССА ИЗМЕНИЯ ДАННЫХ КОТОРЫЙ ВЫЧИСЛЕТ ИЗМЕНИЯ И В ТАБЛИЦКЕ МОДИФИКАЦИОНОЙ СЕРВЕР И ПЛЮС ПО ТЕКУЩЕЙ ТАБЛИЦ


        // TODO: 10.08.2021  получение УВЕЛИЧИНОЙ ВЕРСИИ ДАННЫХ ДЛЯ ЧАТА
        public Long МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table(String Текущаятаблицы,
                                                                                                                             String ТекущаяяКолонкаТаблицы,
                                                                                                                             @NotNull Context contextУвеличинойВесрииДанных,
                                                                                                                             SQLiteDatabase getБазаДанныхДЛяОперацийВнутри) {
            ////
            Long  ЗначениеДляПовышениеВерсии_Для_Поля_current_table=1l;


            /////
            SQLiteCursor Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных=null;
            //

            ////
            try{

                // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

                ///



                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ --ПЕРВЫЙ ВАРИАНТ

/*             Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных= (SQLiteCursor)
                        getБазаДанныхДЛяОперацийВнутри.rawQuery(" SELECT MAX ( current_table  ) AS MAX_R  FROM " +  Текущаятаблицы+"" , null);*/

                Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных=null;


                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ --ВТОРОЙ ВАРИАНТ

            Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных= (SQLiteCursor)
                        getБазаДанныхДЛяОперацийВнутри.rawQuery(" SELECT MAX ( " +ТекущаяяКолонкаТаблицы.trim() + "  ) AS MAX_MODIFITATION_Client  FROM " +
                                "  MODIFITATION_Client  WHERE  name = '" + Текущаятаблицы.trim().toLowerCase() +"'  ;", null);
                ///

              /*  Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных= (SQLiteCursor)
                        Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу().rawQuery(" SELECT MAX ( " +ТекущаяяКолонкаТаблицы + "  ) AS MAX_R  FROM  " + ТаблицаДляПовышениеВерсииДанных + "   " +
                                " WHERE name = '" + Текущаятаблицы + "' ;", null);*/

           /*     Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных= (SQLiteCursor)
                        Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу().rawQuery(" SELECT MAX ( " +ТекущаяяКолонкаТаблицы + "  ) AS MAX_R  FROM  " + Текущаятаблицы +";", null);
                ///*/


                Log.d(this.getClass().getName(), "GetData "+Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных  );




/*

            // TODO: 06.09.2021  _old

            Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных=    new CREATE_DATABASE(context).
                    ССылкаНаСозданнуюБазу.rawQuery(" SELECT MAX("+ТекущаяяКолонкаТаблицы+") from  "+Текущаятаблицы+" ", null);//data_chat
            // TODO: 10.08.2021
*/







                if(Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.getCount()>0){

                    //
                    Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.moveToFirst();
                    //
                    Integer  ИндексГдеСтолбикМах=Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.getColumnIndex("MAX_MODIFITATION_Client");
                    //
                    ЗначениеДляПовышениеВерсии_Для_Поля_current_table=Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.getLong(ИндексГдеСтолбикМах);
                    //
                    Log.d(this.getClass().getName(), "  ДО   ЗначениеДляПовышениеВерсии "+ЗначениеДляПовышениеВерсии_Для_Поля_current_table);



















                    //TODO  ДОПОЛНИТЕЛЬНЫЙ ЗАППРОС НА ДАННЫЕ ВЕРИСЮ ПОТОМО ЧТО УЗНАТЬ ГДЕ  ВЫШЕ ВЕРСИЯ ТУ И СТАВИМ             //TODO  ДОПОЛНИТЕЛЬНЫЙ ЗАППРОС НА ДАННЫЕ ВЕРИСЮ ПОТОМО ЧТО УЗНАТЬ ГДЕ  ВЫШЕ ВЕРСИЯ ТУ И СТАВИМ

                    SQLiteCursor  Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанныхДополнительныйКурсорИщемЗначениеИвтаблицеВсамойИИщемГдеВыше=null;






                    //TODO  ДОПОЛНИТЕЛЬНЫЙ ЗАППРОС НА ДАННЫЕ ВЕРИСЮ ПОТОМО ЧТО УЗНАТЬ ГДЕ  ВЫШЕ ВЕРСИЯ ТУ И СТАВИМ             //TODO  ДОПОЛНИТЕЛЬНЫЙ ЗАППРОС НА ДАННЫЕ ВЕРИСЮ ПОТОМО ЧТО УЗНАТЬ ГДЕ  ВЫШЕ ВЕРСИЯ ТУ И СТАВИМ

                      Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанныхДополнительныйКурсорИщемЗначениеИвтаблицеВсамойИИщемГдеВыше= (SQLiteCursor)
                      getБазаДанныхДЛяОперацийВнутри.rawQuery(" SELECT MAX ( current_table ) AS MAX_current_table  FROM  " + Текущаятаблицы.trim().toLowerCase() + "  ;", null);








                    // TODO: 11.01.2022
                    if (Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанныхДополнительныйКурсорИщемЗначениеИвтаблицеВсамойИИщемГдеВыше.getCount()>0){

                        // TODO: 11.01.2022
                        //
                        Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанныхДополнительныйКурсорИщемЗначениеИвтаблицеВсамойИИщемГдеВыше.moveToFirst();
                        //
                        Integer  ИндексГдеСтолбикМахДополнительный=Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанныхДополнительныйКурсорИщемЗначениеИвтаблицеВсамойИИщемГдеВыше.getColumnIndex("MAX_current_table");
                        //
                     Long  ЗначениеДляПовышениеВерсииДополнитеныйИзСомойТекущейТалиции=
                             Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанныхДополнительныйКурсорИщемЗначениеИвтаблицеВсамойИИщемГдеВыше.getLong(ИндексГдеСтолбикМахДополнительный);
                        //
                        Log.d(this.getClass().getName(), "  ДО   ЗначениеДляПовышениеВерсииДополнитеныйИзСомойТекущейТалиции "+ЗначениеДляПовышениеВерсииДополнитеныйИзСомойТекущейТалиции);







                        //TODO НИЖЕ ПРИНИМАЕМ РЕШЕНИЕ КАКАЯ ВЕРСИЯ ДАННЫХ ЦИФРА БОЛЬШЕ ЛИБО В ТЕКУЩЕЙ ТАБЛИЦЕ ЛИБО В СИСТЕМНОЙ ТАБЛИЦЕ МОДИИКАШЕН КЛИЕНТ,

                        //TODO И КАКАЯ БОЛЬШЕ ТУ И ВСТАЛЯЕМ АГА В ТЕБКУЩУЮ ТАЮДИЦУ ПО ПОЛЮ  current_table


                        if ( ЗначениеДляПовышениеВерсии_Для_Поля_current_table>=     ЗначениеДляПовышениеВерсииДополнитеныйИзСомойТекущейТалиции) {


                            Log.d(this.getClass().getName(), " ЗначениеДляПовышениеВерсии"

                                    +ЗначениеДляПовышениеВерсии_Для_Поля_current_table + " ЗначениеДляПовышениеВерсииДополнитеныйИзСомойТекущейТалиции " +ЗначениеДляПовышениеВерсииДополнитеныйИзСомойТекущейТалиции);

                            //////todo увеличиваем версию данных непостредственно втаблице обработки

                            ЗначениеДляПовышениеВерсии_Для_Поля_current_table++;


                        } else   if (   ЗначениеДляПовышениеВерсииДополнитеныйИзСомойТекущейТалиции > ЗначениеДляПовышениеВерсии_Для_Поля_current_table ) {



                            Log.d(this.getClass().getName(), " ЗначениеДляПовышениеВерсии"

                                    +ЗначениеДляПовышениеВерсии_Для_Поля_current_table + " ЗначениеДляПовышениеВерсииДополнитеныйИзСомойТекущейТалиции " +ЗначениеДляПовышениеВерсииДополнитеныйИзСомойТекущейТалиции);

                            ЗначениеДляПовышениеВерсии_Для_Поля_current_table=ЗначениеДляПовышениеВерсииДополнитеныйИзСомойТекущейТалиции;
                            //////todo увеличиваем версию данных непостредственно втаблице обработки

                            ЗначениеДляПовышениеВерсии_Для_Поля_current_table++;


                        }


                    }
                    Log.d(this.getClass().getName(), "  Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанныхДополнительныйКурсорИщемЗначениеИвтаблицеВсамойИИщемГдеВыше.getCount() "

                            +Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанныхДополнительныйКурсорИщемЗначениеИвтаблицеВсамойИИщемГдеВыше.getCount());



                    // TODO: 12.01.2022 ЗАКРЫВАЕМ КУРСОРЫ
                    //
                    Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанныхДополнительныйКурсорИщемЗначениеИвтаблицеВсамойИИщемГдеВыше.close();








                    Log.d(this.getClass().getName(), "   ПОСЛЕ ЗначениеДляПовышениеВерсии_Для_Поля_current_table "+ЗначениеДляПовышениеВерсии_Для_Поля_current_table);
                }else {

                    //////TODO увеличиваем значени версии данных
                    ЗначениеДляПовышениеВерсии_Для_Поля_current_table=1l;

                    Log.d(this.getClass().getName(), "ЗначениеДляПовышениеВерсии "+ЗначениеДляПовышениеВерсии_Для_Поля_current_table);

                }


                Log.d(this.getClass().getName(), "ЗначениеДляПовышениеВерсии "+ЗначениеДляПовышениеВерсии_Для_Поля_current_table);



                // TODO: 12.01.2022 ЗАКРЫВАЕМ КУРСОРЫ
                //
                Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.close();

                // TODO: 12.01.2022  ЗАКРЫВАЕМ ТРАНЗАКЦИЮ


                
/*
                    new CREATE_DATABASE(getContext()).    ССылкаНаСозданнуюБазу.execSQL(
                            "CREATE TRIGGER cust_addr_chng_data_chat "+
                                    " AFTER INSERT  ON  chats"+
                                    " BEGIN     INSERT INTO chats(current_chat)    VALUES("+ЗначениеДляПовышениеВерсии+"); END; ");*/
                ///
                Log.d(this.getClass().getName(), " сработала ...  создание таблицы Data_Chat TRIGGER ЗначениеДляПовышениеВерсии_Для_Поля_current_table " +
                        ""+ЗначениеДляПовышениеВерсии_Для_Поля_current_table);


// TODO: 29.10.2021 ВЫКЛЮЧАЕМ БАЗУ


                /////////////
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new   Class_Generation_Errors(contextУвеличинойВесрииДанных).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

                //////
                ЗначениеДляПовышениеВерсии_Для_Поля_current_table=1l;

                Log.d(this.getClass().getName(), "ЗначениеДляПовышениеВерсии "+ЗначениеДляПовышениеВерсии_Для_Поля_current_table);
            }


            Log.w(this.getClass().getName(), "ЗначениеДляПовышениеВерсии "+ЗначениеДляПовышениеВерсии_Для_Поля_current_table);

            return  ЗначениеДляПовышениеВерсии_Для_Поля_current_table;
        }













// TODO: 13.01.2022 повышения ВКЕРСИИ ДАННЫХ ТОЛЬКО В СИСТЕМНОЙ ТАБЛИЦЕ МОДИФИКАФЕН КЛИЕНТ













        // TODO: 10.08.2021  получение УВЕЛИЧИНОЙ ВЕРСИИ ДАННЫХ ДЛЯ ЧАТА
        Long МетодПолученияУвеличинойВесрииДанныхДляТекущейТолькоДляСистемнойТаблицы_MODIFITATION_Client(String Текущаятаблицы ,
                                                                                                 String ТекущаяяКолонкаТаблицы,
                                                                                                 @NotNull  Context contextУвеличинойВесрииДанных,
                                                                                                 SQLiteDatabase getБазаДанныхДЛяОперацийВнутри) {
            ////
            Long  ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client=1l;


            /////
            SQLiteCursor Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных=null;
            //

            ////
            try{

                // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

                ///



                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ --ПЕРВЫЙ ВАРИАНТ

/*             Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных= (SQLiteCursor)
                        getБазаДанныхДЛяОперацийВнутри.rawQuery(" SELECT MAX ( current_table  ) AS MAX_R  FROM " +  Текущаятаблицы+"" , null);*/

                Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных=null;


                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ --ВТОРОЙ ВАРИАНТ

                Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных= (SQLiteCursor)
                        getБазаДанныхДЛяОперацийВнутри.rawQuery(" SELECT MAX ( " +ТекущаяяКолонкаТаблицы.trim() + "  ) AS MAX_MODIFITATION_Client  FROM " +
                                "  MODIFITATION_Client  WHERE  name = '" + Текущаятаблицы.trim().toLowerCase() +"'  ;", null);
                ///

              /*  Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных= (SQLiteCursor)
                        Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу().rawQuery(" SELECT MAX ( " +ТекущаяяКолонкаТаблицы + "  ) AS MAX_R  FROM  " + ТаблицаДляПовышениеВерсииДанных + "   " +
                                " WHERE name = '" + Текущаятаблицы + "' ;", null);*/

           /*     Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных= (SQLiteCursor)
                        Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу().rawQuery(" SELECT MAX ( " +ТекущаяяКолонкаТаблицы + "  ) AS MAX_R  FROM  " + Текущаятаблицы +";", null);
                ///*/


                Log.d(this.getClass().getName(), "GetData "+Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных  );



/*

            // TODO: 06.09.2021  _old

            Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных=    new CREATE_DATABASE(context).
                    ССылкаНаСозданнуюБазу.rawQuery(" SELECT MAX("+ТекущаяяКолонкаТаблицы+") from  "+Текущаятаблицы+" ", null);//data_chat
            // TODO: 10.08.2021
*/







                if(Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.getCount()>0){

                    //
                    Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.moveToFirst();
                    //
                    Integer  ИндексГдеСтолбикМах=Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.getColumnIndex("MAX_MODIFITATION_Client");
                    //
                    ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client=Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.getLong(ИндексГдеСтолбикМах);
                    //
                    Log.d(this.getClass().getName(), "  ДО   ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client "+ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client);



                    Log.d(this.getClass().getName(), " ЗначениеДляПовышениеВерсии"

                            +ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client + " ЗначениеДляПовышениеВерсии "
                            +ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client+ " Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.getCount() "
                            +Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.getCount());

                    //////todo увеличиваем версию данных непостредственно втаблице обработки

                   /// ЗначениеДляПовышениеВерсии++;



                }else {

                    //////TODO увеличиваем значени версии данных
                    ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client=1l;

                    Log.d(this.getClass().getName(), "ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client "+ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client);

                }


                Log.d(this.getClass().getName(), "ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client "+ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client);



                // TODO: 12.01.2022 ЗАКРЫВАЕМ КУРСОРЫ
                //
                Курсор_КоторыйПолучаетМаксимальюнуВерсиюДанных.close();

                // TODO: 12.01.2022  ЗАКРЫВАЕМ ТРАНЗАКЦИЮ

              //  getБазаДанныхДЛяОперацийВнутри.setTransactionSuccessful();

              //  getБазаДанныхДЛяОперацийВнутри.endTransaction();


/*
                    new CREATE_DATABASE(getContext()).    ССылкаНаСозданнуюБазу.execSQL(
                            "CREATE TRIGGER cust_addr_chng_data_chat "+
                                    " AFTER INSERT  ON  chats"+
                                    " BEGIN     INSERT INTO chats(current_chat)    VALUES("+ЗначениеДляПовышениеВерсии+"); END; ");*/
                ///
                Log.d(this.getClass().getName(), " сработала ...  создание таблицы Data_Chat TRIGGER"+ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client);


// TODO: 29.10.2021 ВЫКЛЮЧАЕМ БАЗУ


                /////////////
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new   Class_Generation_Errors(contextУвеличинойВесрииДанных).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

                //////
                ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client=1l;

                Log.d(this.getClass().getName(), "ЗначениеДляПовышениеВерсии "+ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client);
            }


            Log.w(this.getClass().getName(), "ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client "+ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client);

            return  ЗначениеДляПовышениеВерсии_ТолькоДля_MODIFITATION_Client;
        }
    }


    // TODO: 28.08.2021 гдавный метод выполения операций EXE
    // TODO: 28.08.2021 гдавный метод выполения операций EXE
    //TODO КЛАСС ИСПОЛЕНИЯ В ПОТОКЕ
    public class ClassRuntimeExeGRUDOpertions extends Class_GRUD_SQL_Operations {
        //////
        public ClassRuntimeExeGRUDOpertions(@NotNull Context context) {

            super(context);


        }

        // TODO: 27.08.2021  МЕТОД ИСПОЛЕНИЯ В ПОТОКЕ
        public Object МетодЗапускаОперацийGRUD_exe(Callable<Object> ЗадачаКоторуюнадоВыполнить, CompletionService МенеджерПотоков) throws ExecutionException, InterruptedException {


            // TODO: 14.10.2021  Будущий результат
            Object ФинальныйПолученныйРезультатОперацийGRUD = null;

            //////// TODO запуск менеджера потоков

            try {


                // TODO: 28.08.2021  ЗАПУСКАЕМ ЗАДАЧУ

                МенеджерПотоков.submit(ЗадачаКоторуюнадоВыполнить);

                ///
                Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(), "ФИНАЛ   МЕНЕДЖЕРА ПОТОКОВ " +
                        " GRUD-ОПЕРАЦИЙ  EXE add Callable  ЗадачаКоторуюнадоВыполнить "+ ЗадачаКоторуюнадоВыполнить );
                //


                } catch (Exception e) {
                    ///////TODO error
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                            + Thread.currentThread().getStackTrace()[2].getLineNumber());

                    new   Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                            this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                            Thread.currentThread().getStackTrace()[2].getLineNumber());
                    /////

                /////

                МенеджерПотоков.take().cancel(false);

                // TODO: 28.08.2021 exit exe
            } finally {


                try {


                    ////TODO off Менеджер ПОтоков
                    ФинальныйПолученныйРезультатОперацийGRUD= (Object)  МенеджерПотоков.take().get();


                    ////TODO ПОСЛЕ ПОЛУЧЕНИЕ ОТВЕТА

                    Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(),
                            " ФИНАЛ   .GET()  МЕНЕДЖЕРА ПОТОКОВ  GRUD-ОПЕРАЦИЙ     "
                                    + ФинальныйПолученныйРезультатОперацийGRUD + "\n" +
                                    "  .GET() размер ответа  " +ФинальныйПолученныйРезультатОперацийGRUD.toString().length());

                    // TODO: 04.10.2021  ЖДЕМ ВЫПОЛЕНИЯ  МЕНЕДЖЕРА ПОТОКОВ  РЕЗУЛЬТАТ МЕНЕДЖЕРА ПОТОКОВ
                //   while(!БудущийРезультат_GRUD_операци.isDone());





                    // TODO: 04.10.2021 ПОЛУЧЕННЫЙ РЕЗУЛЬТАТ МЕНЕДЖЕРА ПОТОКОВ ПРОВЕРЯЕМ СТАТУС ЗАДАЧИ
/*
                        if (БудущийРезультат_GRUD_операци.isDone()) {
                        ///
                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(),
                                "  В РАБОТЕ ..............    ФИНАЛ   .GET()  МЕНЕДЖЕРА ПОТОКОВ  GRUD-ОПЕРАЦИЙ  EXE   submit -  +БудущийРезультат_GRUD_операци.isDone() "
                                        +БудущийРезультат_GRUD_операци.isDone());



                        // TODO: 04.10.2021 ПОЛУЧЕННЫЙ РЕЗУЛЬТАТ МЕНЕДЖЕРА ПОТОКОВ
                   //     ФинальныйПолученныйРезультатОперацийGRUD=БудущийРезультат_GRUD_операци.get();
                        ///
                        Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(),
                                " ФИНАЛ   .GET()  МЕНЕДЖЕРА ПОТОКОВ  GRUD-ОПЕРАЦИЙ  EXE   submit - метод БудущийРезультат_GRUD_операци  "
                                        + ФинальныйПолученныйРезультатОперацийGRUD + "\n" +
                                        "  ПОСЛЕ ПОЛУЧЕНИЕ РЕЗУЛЬТАТА СТАТУС ЗАДАЧИ");



                        // TODO: 04.10.2021 ПРОВЕРЯЕМ СТАТУС МЕНЕДЖЕРА ПОТОКОВ

                            // TODO: 13.10.2021 exit loop
                            БудущийРезультат_GRUD_операци.cancel(false);

                            ///
                            Log.w(contextClass_GRUD_SQL_Operations.getClass().getName(),
                                    "  ВЫКЛЮЧАЕМ  Future    ФИНАЛ   .GET()  МЕНЕДЖЕРА ПОТОКОВ  GRUD-ОПЕРАЦИЙ  EXE   submit -  " +
                                            "+ Название ПОТОКА " +Thread.currentThread().getName()+ "\n"+
                                     " Thread.currentThread().isInterrupted() Поток Статус "  +Thread.currentThread().isAlive());




                    }*/


                    //TODO ВЫКЛЮЧЕНИЕ МЕНЕДЖЕРАПОТОКОВ
                    //
                } catch (ExecutionException e) {
                    ///////TODO error
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                            + Thread.currentThread().getStackTrace()[2].getLineNumber());

                    new Class_Generation_Errors(contextClass_GRUD_SQL_Operations).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                            this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                            Thread.currentThread().getStackTrace()[2].getLineNumber());
                    /////
                    /////

                    МенеджерПотоков.take().cancel(false);
                }
            }
            //
            //////////
            //////// TODO конец  менеджера потоков
            return ФинальныйПолученныйРезультатОперацийGRUD;
        }

    }



    //TODO  для визуальной синхрониазциии


// TODO: 28.08.2021  КОНЕЦ гдавный метод выполения операций EXE
    // TODO: 28.08.2021 гдавный метод выполения операций EXE
    //TODO КЛАСС ИСПОЛЕНИЯ В ПОТОКЕ

















































































    //TODO КЛАСС ПОЛУЧЕНИЕ ДАННЫХ Free
    public class  GetаFreeData extends Class_GRUD_SQL_Operations {

        public GetаFreeData(@NotNull Context context) {
            super(context);

            //todo ПОДКЛЮЯЕМ КЛАСС ВЫШЕСТОЯЩИЙ ДЛЯ РАБОТЫ ОПЕРАЦИЙ grud
            /**
             *
             * @param context
             */
       ////     Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextClass_GRUD_SQL_Operations);
            ////
            ///
            /**
             *
             */
            SQLBuilder_Для_GRUD_Операций =new SQLiteQueryBuilder    ();


            //////////


        }

        // TODO: 30.08.2021  НИЖЕ  УКАЗАНЫ ВСЕ МЕТОДЫ ПОЛУЧЕНИЕ ОБНОВЛЕНИЯ ВСТАВКИ УДАЛЕНИЕ ДАННЫХ


        // TODO: 27.08.2021 МЕТОД  ПОЛУЧЕНИЯ ДАННЫХ
        public Object getfreedata(Map<String, Object> concurrentHashMap, CompletionService МенеджерПотоков, SQLiteDatabase getБазаДанныхДЛяОперацийВнутри) throws ExecutionException, InterruptedException {
            ///////
            Object GetFreedata=null;
            //////// TODO запуск менеджера потоков
            // TODO: 29.08.2021 СОЗДАЕМ ЗАДАЧУ ДЛЯ ВЫПОЛЕНИЯ ЧЕРЕЗ CALLABLE





            ЛистДляGRUDопераций=new Callable<Object>() {
                @Override
                public Object call() throws Exception {

                    /////TODO начало самого кода

                    Object getfreedata=null;
                    /////
                    try {
                        // TODO: 27.08.2021 парарменты
                        String НазваниеОбрабоатываемойТаблицы=null;
                        //
                        String    СамFreeSQLКОд=null;



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
                                case "СамFreeSQLКОд" :
                                    СамFreeSQLКОд=ЗначениеconcurrentHashMap.toString();
                                    break;
                                ///

// TODO: 27.08.2021  конец столбиков с параметрами условия посика


///
                            }

                        }


                        // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ


                        getfreedata= (SQLiteCursor) getБазаДанныхДЛяОперацийВнутри.rawQuery(СамFreeSQLКОд, null);

                        Log.d(this.getClass().getName(), "getfreedata "+getfreedata  );


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
                    }

                    // TODO: 29.08.2021  MAIN EXE запуск выполения любого кода через  CALLABLE



                    /////TODO конец  самого кода

                    return getfreedata;
                }
            };


            //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

            GetFreedata=     new ClassRuntimeExeGRUDOpertions(contextClass_GRUD_SQL_Operations).МетодЗапускаОперацийGRUD_exe(ЛистДляGRUDопераций,МенеджерПотоков);

            ////
            Log.d(this.getClass().getName(), "   рЕЗУЛЬТАТ МЕТОДА ПОЛУЧЕНИЕ ДАННЫХ ЧЕРЕЗ ОДИН МЕТДЖЕР ПОТОКОВ  GetFreedata "+GetFreedata);



// TODO: 29.10.2021 ВЫКЛЮЧАЕМ БАЗУ


            //////// TODO конец  менеджера потоков

            return GetFreedata;
        }

    }

// TODO: 17.09.2021  END GETDATA


















}


























