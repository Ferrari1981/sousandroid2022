package com.dsy.dsu;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import javax.crypto.NoSuchPaddingException;

import io.reactivex.Completable;
import io.reactivex.MaybeObserver;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.internal.observers.BlockingLastObserver;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Class_Connections_Server  extends  Class_GRUD_SQL_Operations {

    Context contextДляКлассаКоннеткСервер;
    //
    Class_GRUD_SQL_Operations class_grud_sql_operations=null;

    public Class_Connections_Server(Context context) {
        super(context);

        contextДляКлассаКоннеткСервер=context;
///////

        ////
        class_grud_sql_operations=new Class_GRUD_SQL_Operations(contextДляКлассаКоннеткСервер);

    }















    ///////// TODO ПРОВЕРЯЕТ ЕСЛИ ПОДКЛЧБЕНИ В ИНТРЕНТУ
    public Boolean МетодПингаСервераРаботаетИлиНет(Context КонтекстКоторыйДляСинхронизации) {


        //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

        // TODO: 16.12.2021
         boolean РезультатПингакСервераРаботаетЛиОНРеально = false;
                // TODO: 02.09.2021  сам код
                try {

                    ///todo ПИНГ СЕРВЕРА ПЛЮС ПИНГ САМИХ ДАННЫХ SQL SERVER



                    // Extract Callable from FutureTask

          io.reactivex.rxjava3.core.Maybe<Boolean> singleПингакСервераРаботаетЛиОНРеально=
                  Maybe.fromCallable(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {

                            // TODO: 21.02.2022

                            Boolean результатПрозвонаСокетом = false;

                            Log.w(КонтекстКоторыйДляСинхронизации.getClass().getName(), " РЕЗУЛЬТАТ ПИНГА СЕРВЕРА С ИСПОЛЬЗОВАНИЕ SQL-ЗАПРОСА К САМОЙ БАЗЕ результатПрозвонаСокетом " +
                                    "Observable     observableрезультатПрозвонаСокетом=Observable.fromCallable "+Thread.currentThread().getName());


                            результатПрозвонаСокетом=  МетодПингаСервераРаботаетИлиНетВнутри(КонтекстКоторыйДляСинхронизации);

                            Log.w(КонтекстКоторыйДляСинхронизации.getClass().getName(), " РЕЗУЛЬТАТ ПИНГА СЕРВЕРА С ИСПОЛЬЗОВАНИЕ SQL-ЗАПРОСА К САМОЙ БАЗЕ результатПрозвонаСокетом " +
                                    "Observable     observableрезультатПрозвонаСокетом=Observable.fromCallable "+Thread.currentThread().getName()+
                                    "  результатПрозвонаСокетом " +результатПрозвонаСокетом);

                            return результатПрозвонаСокетом;
                        }
                    })
                  .subscribeOn(Schedulers.computation())
                  .map(Boolean::booleanValue)
                  .onErrorComplete(new Predicate<Throwable>() {
                      @Override
                      public boolean test(Throwable throwable) throws Throwable {
                          // TODO: 21.02.2022
                          Log.e(КонтекстКоторыйДляСинхронизации.getClass().getName(), " onErrorComplete Ошибка ПИНГА СЕРВЕРА С ИСПОЛЬЗОВАНИЕ SQL-ЗАПРОСА К САМОЙ БАЗЕ результатПрозвонаСокетом " +
                                  "Observable     observableрезультатПрозвонаСокетом=Observable.fromCallable "+Thread.currentThread().getName()+
                                  "  throwable " +throwable.fillInStackTrace().getMessage());
                          return false;
                      }
                  });
                    // TODO: 21.02.2022 ПОТПИСЫВАЕПМ НА ОBSERVER ДЛЯ ПИНГА С СЕВРОМ
                    singleПингакСервераРаботаетЛиОНРеально.subscribe(System.out::println);
                    //todo
                    singleПингакСервераРаботаетЛиОНРеально.observeOn(AndroidSchedulers.mainThread());
                    // TODO: 21.02.2022
                    РезультатПингакСервераРаботаетЛиОНРеально=       singleПингакСервераРаботаетЛиОНРеально.blockingGet().booleanValue();

                    Log.w(КонтекстКоторыйДляСинхронизации.getClass().getName(), "ПОЛУЧЕНИЕ СТАТУСА РАБОТЫ GLASSHIS РЕЗУЛЬТАТ ПИНГА СЕРВЕРА " +
                            "С ИСПОЛЬЗОВАНИЕ SQL-ЗАПРОСА К САМОЙ БАЗЕ результатПрозвонаСокетом "
                            +РезультатПингакСервераРаботаетЛиОНРеально+"     +Thread.currentThread().getName()"    +Thread.currentThread().getName());//.toObservable().toFuture().get(10,TimeUnit.SECONDS);





                    //////////
                } catch (Exception e) {

                    //TODO
                    e.printStackTrace();

                    if (! e.toString().equalsIgnoreCase("java.util.concurrent.TimeoutException: The source did not signal an event for 5 seconds and has been terminated.")) {

                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        // TODO: 01.09.2021 метод вызова
                        new   Class_Generation_Errors(КонтекстКоторыйДляСинхронизации).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                        //todo  ФЛАГ  РЕЗУЛЬТАТ  ПИНГА СЕРВЕРА



                        РезультатПингакСервераРаботаетЛиОНРеально = false;
                    }
                    ////TODO ВТОРАЯ ПРОВЕРКА

                    Log.e(КонтекстКоторыйДляСинхронизации.getClass().getName(), " ОШИБКА ПРИ ПОДКЛЮЧЕНИ ЯК СЕРВЕРУ " + e.toString());

                }

        // TODO:.09.2021  EXE ПОСЫЛАЕМ НА ВЫПОЛЕНИЯ
        Log.w(КонтекстКоторыйДляСинхронизации.getClass().getName(), " РЕЗУЛЬТАТ ПИНГА СЕРВЕРА С ИСПОЛЬЗОВАНИЕ SQL-ЗАПРОСА К САМОЙ БАЗЕ результатПрозвонаСокетом результатПрозвонаСокетом "
                + РезультатПингакСервераРаботаетЛиОНРеально);

        return РезультатПингакСервераРаботаетЛиОНРеально;
    }

















// TODO: 01.02.2022


    ///////// TODO ПРОВЕРЯЕТ ЕСЛИ ПОДКЛЧБЕНИ В ИНТРЕНТУ
    Boolean МетодПингаСервераРаботаетИлиНетТОлькоДЛяACTIVITYFACEAPP( @NotNull Context КонтекстКоторыйДляСинхронизации)
            throws ExecutionException, InterruptedException, TimeoutException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

        Boolean результатПрозвонаСокетом = false;
        PUBLIC_CONTENT public_contentМенеджерПОтоков=new PUBLIC_CONTENT(КонтекстКоторыйДляСинхронизации);

        // TODO: 02.02.2022

        public_contentМенеджерПОтоков.МенеджерПотоков.submit(()->{

            Boolean результатПрозвонаСокетаВнутри = false;

        try {

            ///todo ПИНГ СЕРВЕРА ПЛЮС ПИНГ САМИХ ДАННЫХ SQL SERVER

            результатПрозвонаСокетаВнутри = МетодПингаСервераРаботаетИлиНетВнутри(КонтекстКоторыйДляСинхронизации);

            // TODO: 02.02.2022
            Log.w(КонтекстКоторыйДляСинхронизации.getClass().getName(),
                    " РЕЗУЛЬТАТ ПИНГА СЕРВЕРА С ИСПОЛЬЗОВАНИЕ SQL-ЗАПРОСА К САМОЙ БАЗЕ результатПрозвонаСокетом результатПрозвонаСокетом "
                    + результатПрозвонаСокетаВнутри);

        } catch (ExecutionException e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e.toString() + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(КонтекстКоторыйДляСинхронизации).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            //todo  ФЛАГ  РЕЗУЛЬТАТ  ПИНГА СЕРВЕРА

        }

            return результатПрозвонаСокетаВнутри;
        });

        результатПрозвонаСокетом=  (Boolean) public_contentМенеджерПОтоков.МенеджерПотоков.take().get(10,TimeUnit.SECONDS);

        Log.w(КонтекстКоторыйДляСинхронизации.getClass().getName(), " РЕЗУЛЬТАТ ПИНГА СЕРВЕРА С ИСПОЛЬЗОВАНИЕ SQL-ЗАПРОСА К САМОЙ БАЗЕ результатПрозвонаСокетом результатПрозвонаСокетом "
                + результатПрозвонаСокетом);

        return результатПрозвонаСокетом;
    }








    ///////// TODO ПРОВЕРЯЕТ ЕСЛИ ПОДКЛЧБЕНИ В ИНТРЕНТУ
    Boolean МетодПингаСервераРаботаетИлиНетВнутри( @NotNull Context КонтекстКоторыйДляСинхронизации)
            throws ExecutionException, InterruptedException, TimeoutException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {


        //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ
         Boolean результатПрозвонаСокетом = false;

        // TODO: 16.12.2021

        // TODO: 02.09.2021  сам код
        try {

            ///
            System.out.println("УниверсальнайМетодПроверкиПодключениекWIFI ");

            Map<String,Integer> concurrentHashMapАдресаПодключенияКСерверу= Collections.synchronizedMap(new LinkedHashMap());
            //
            String ИмяСервера=new String();
            //
            Integer ИмяПорта=0;

            //concurrentHashMapАдресаПодключенияКСерверу.put("169.254.52.68", 8080);
            ////todo ТОЛЬКО КОГДА НЕ ОТЛАДКА

         concurrentHashMapАдресаПодключенияКСерверу.put("tabel.dsu1.ru", 8888);//TODO FALSE  ЭТО  РЕЛИЗ

            /////TODO тест режим
     // concurrentHashMapАдресаПодключенияКСерверу.put("192.168.254.40", 8080);


            // TODO: 26.08.2021 loop ping

            for (Map.Entry<String, Integer> СодержимоеHashMapАдресаПодключенияКСерверу : concurrentHashMapАдресаПодключенияКСерверу.entrySet()) {

                ИмяСервера=    СодержимоеHashMapАдресаПодключенияКСерверу.getKey();


                ИмяПорта=     СодержимоеHashMapАдресаПодключенияКСерверу.getValue();


                Log.d(MODEL_synchronized.class.getName()," ИмяСервера"+ ИмяСервера+" ИмяПорта "+ИмяПорта);

                /////todo код ping ip второйвариант




////////////////
              Integer  БуферПолучениеДанныхРЕальныйСтатусРАботыSQLServer =
                      new MODEL_synchronized(contextДляКлассаКоннеткСервер).
                              УниверсальныйБуферПолучениеДанныхсСервераТОлькоДляПинга(null, "",
                        "", "application/gzip", "Хотим Получить Статус Реальной Работы SQL SERVER",
                                      0l, "",10000,"",
                        0l,ИмяСервера, ИмяПорта);//application/gzip



                Log.d(MODEL_synchronized.class.getName(), "  БуферПолучениеДанныхРЕальныйСтатусРАботыSQLServer" + БуферПолучениеДанныхРЕальныйСтатусРАботыSQLServer);
                ///TODO определяем какой вид подкобченеи mobile and wifi







                    //Integer РазмерПришедшегоПотока =Integer.parseInt(ПодключениеКСерверуЧерезБелыйАдрес.getHeaderField("stream_size"));

                Log.d(this.getClass().getName(), "БуферПолучениеДанныхРЕальныйСтатусРАботыSQLServer " + БуферПолучениеДанныхРЕальныйСтатусРАботыSQLServer);


                    if (БуферПолучениеДанныхРЕальныйСтатусРАботыSQLServer==null) {
                        // TODO: 16.12.2021

                        БуферПолучениеДанныхРЕальныйСтатусРАботыSQLServer=0;
                        // TODO: 16.12.2021
                        Log.d(this.getClass().getName(), "РазмерПришедшегоПотока " + БуферПолучениеДанныхРЕальныйСтатусРАботыSQLServer);
                    }

                    // TODO: 16.12.2021  положитльеный результат пинга
                    if (БуферПолучениеДанныхРЕальныйСтатусРАботыSQLServer>0) {


                        результатПрозвонаСокетом = true;



                        // TODO: 16.12.2021  
                        Log.w(MODEL_synchronized.class.getName(), "  УСПЕХ ЕСТЬ СВЗЬ С СЕРВЕРОММ результатПрозвонаСокетом[0] " + результатПрозвонаСокетом);
                        
                    }else{


                        результатПрозвонаСокетом = false;

                        // TODO: 16.12.2021
                        Log.e(MODEL_synchronized.class.getName(), " ОШИБКА НЕТ СВЯЗИ С СЕВРЕРОМ  результатПрозвонаСокетом[0] " + результатПрозвонаСокетом);
                    }
                    ////////////////////////////

                    // TODO: 24.07.2021  ДОПОЛНИТЕЛЬНАЯ ПРОВЕРКА РАБОТАЕ ЛИ СЕРВЕР В МЕСТЕ С ДАННЫМИ

                    Log.d(MODEL_synchronized.class.getName(), "  результатПрозвонаСокетом[0] " + результатПрозвонаСокетом);
                    ///TODO определяем какой вид подкобченеи mobile and wifi





                break;


            }
            //////////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(КонтекстКоторыйДляСинхронизации).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            //todo  ФЛАГ  РЕЗУЛЬТАТ  ПИНГА СЕРВЕРА
            результатПрозвонаСокетом = false;
            ////TODO ВТОРАЯ ПРОВЕРКА

            Log.e(КонтекстКоторыйДляСинхронизации.getClass().getName(), " ОШИБКА ПРИ ПОДКЛЮЧЕНИ ЯК СЕРВЕРУ " + e.toString());

        }

        // TODO: 29.09.2021

        // TODO: 29.09.2021  проверяем равны ли выбранный режим с режимо выбранным пользователм



        // TODO: 02.09.2021  EXE ПОСЫЛАЕМ НА ВЫПОЛЕНИЯ


        Log.d(MODEL_synchronized.class.getName(), "  результатПрозвонаСокетом[0] " + результатПрозвонаСокетом);

        return результатПрозвонаСокетом;
    }





}
