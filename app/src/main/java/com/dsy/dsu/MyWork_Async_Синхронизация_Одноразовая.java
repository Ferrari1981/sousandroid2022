package com.dsy.dsu;

import static android.content.Context.ACTIVITY_SERVICE;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.dsy.dsu.Business_logic_Only_Class.Class_Engine_SQL;
import com.dsy.dsu.Business_logic_Only_Class.Class_Find_Setting_User_Network;
import com.dsy.dsu.Business_logic_Only_Class.Class_Generation_Errors;
import com.dsy.dsu.Business_logic_Only_Class.Class_Generations_PUBLIC_CURRENT_ID;
import com.dsy.dsu.Business_logic_Only_Class.Class__Generation_Genetal_Tables;
import com.dsy.dsu.Code_For_Firebase_AndOneSignal_Здесь_КодДЛяСлужбыУведомленияFirebase.Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;


public class MyWork_Async_Синхронизация_Одноразовая extends Worker {
    /////
    Context КонтекстОдноразовая;
    //////
    String ИмяСлужбыСинхронизации="WorkManager Synchronizasiy_Data Disposable";
    ////////

//

    Integer РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне=0;


    WorkInfo ИнформацияОЗапущенойСлужбе_Синхрониазция_Одноразовая;


    public MyWork_Async_Синхронизация_Одноразовая(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        КонтекстОдноразовая = context;


        Log.i(КонтекстОдноразовая.getClass().getName(), " public  " +
                "MyWork_Async_Синхронизация_Одноразовая(@NonNull Context context, @NonNull WorkerParameters workerParams) " +
                "{  КонтекстОдноразовая "+"\n"+ КонтекстОдноразовая);
    }


    public MyWork_Async_Синхронизация_Одноразовая(@NonNull Context context, @NonNull WorkerParameters workerParams, @NonNull Activity activity) {
        super(context, workerParams);
        this.КонтекстОдноразовая = context;

    }

    @Override
    public void onStopped() {
        super.onStopped();
    }





    @NonNull
    @Override
    public Result doWork() {

// Do processing
 try{

// TODO: 25.02.2022

      Integer ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle = getInputData().getInt("СообщениеЧатаДляКонктерногоСотрудника",0);


      if(ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle==null){

          // TODO: 04.02.2022
          ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle=0;
      }

     Log.i(КонтекстОдноразовая.getClass().getName(),
             "ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle"+"\n"
             + ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle);


// TODO: 07.12.2021
            ActivityManager ЗапущенныйПроуессыДляОбщейСинхрониазации =
                    (ActivityManager) КонтекстОдноразовая.getSystemService(ACTIVITY_SERVICE);




                    //////
     String АктивностьЕслиЕстьTOP =null;

     // TODO: 03.02.2022

     List<ActivityManager.AppTask> КоличествоЗапущенныйПроуессы=null;
     // TODO: 24.11.2021  чисто ФОНОВЫЙ УРОВЕНЬ ЗАПУСК ПОСЛЕ ПЕРЕЗАГРУЗКИ ТЕЛЕФОНА

                    try {

                        Integer ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(КонтекстОдноразовая).ПолучениеПубличногоТекущегоПользователяID();


                        if (ПубличныйIDДляФрагмента == null) {
                            // TODO: 01.01.2022
                            ПубличныйIDДляФрагмента = 0;
                        }
                        Log.i(КонтекстОдноразовая.getClass().getName(), "ЗАПУСК   зПубличныйIDДляФрагмента "+"\n" + ПубличныйIDДляФрагмента);

                        // TODO: 24.11.2021


                        // TODO: 29.09.2021  перед началом СИНХРОНИЗАЦИИ ПРОВЕРЯЕМ УСТАНОВКИ СЕТИ ПОЛЬЗОВАТЕЛЯ НА АКТИВТИ НАСТРОЙКИ

                        if (ЗапущенныйПроуессыДляОбщейСинхрониазации!=null) {

                            // TODO: 24.11.2021
                            КоличествоЗапущенныйПроуессы = ЗапущенныйПроуессыДляОбщейСинхрониазации.getAppTasks();


                        if (КоличествоЗапущенныйПроуессы.size() > 0) {
// TODO: 02.01.2022  


                            // TODO: 01.12.2021
                            for (ActivityManager.AppTask ТекущаяАктивти : КоличествоЗапущенныйПроуессы) {

                                // TODO: 20.02.2022

                                if (ТекущаяАктивти!=null) {


                                    Log.i(КонтекстОдноразовая.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         " +
                                            "ТекущаяАктивти.getTaskInfo().numActivities  " + "\n"
                                            + ТекущаяАктивти.getTaskInfo().numActivities);
                                    // TODO: 20.02.2022
                                    if (ТекущаяАктивти.getTaskInfo().numActivities>0) {
                                        // TODO: 20.02.2022

                                        АктивностьЕслиЕстьTOP = ТекущаяАктивти.getTaskInfo().baseActivity.getClassName().toString();
                                    }



                                    Log.i(КонтекстОдноразовая.getClass().getName(), "ТекущаяАктивти " + ТекущаяАктивти +
                                            " АктивностьЕслиЕстьTOP  " + АктивностьЕслиЕстьTOP +
                                            "ТекущаяАктивти.getTaskInfo().numActivities  " + "\n"
                                            + ТекущаяАктивти.getTaskInfo().numActivities);////   case "com.dsy.dsu.Code_For_Chats_КодДля_Чата.MainActivity_List_Chats" :

                                }


                                if (АктивностьЕслиЕстьTOP!=null ) {
                                    ///////
                                    switch (АктивностьЕслиЕстьTOP) {// case "com.dsy.dsu.MainActivity_Face_App" :

                                        case "com.dsy.dsu.MainActivity_Visible_Async":
                                        case "com.dsy.dsu.MainActivity_Tabels_Users_And_Passwords":
                                        case "com.dsy.dsu.MainActivity_Face_Start":
                                            Log.i(КонтекстОдноразовая.getClass().getName(), " ВЫХОД  .....ТекущаяАктивтиАктивностьЕслиЕстьTOP" + ТекущаяАктивти +
                                                    " АктивностьЕслиЕстьTOP  " + АктивностьЕслиЕстьTOP);////   case "com.dsy.dsu.Code_For_Chats_КодДля_Чата.MainActivity_List_Chats" :
                                            break;


                                        // TODO: 01.12.2021 САМ ЗАПУСК WORK MANAGER  СИНХРОНИАЗЦИИ ПРИ ВКЛЮЧЕННОЙ АКТИВТИ
                                        default:

                                            Log.i(КонтекстОдноразовая.getClass().getName(), " СРАБОТАЛО .....ТекущаяАктивти " + ТекущаяАктивти +
                                                    " АктивностьЕслиЕстьTOP  " + АктивностьЕслиЕстьTOP);////   case "com.dsy.dsu.Code_For_Chats_КодДля_Чата.MainActivity_List_Chats" :

                                            // TODO: 07.02.2022 Доолнительная проверка уже не запуск Фрагментов

                                            Log.i(КонтекстОдноразовая.getClass().getName(), " СРАБОТАЛО .....Текущий Фрагмент  ПроверкаНаАктивностьФрагментаЧата ");////   case "com.dsy.dsu.Code_For_Chats_КодДля_Чата.MainActivity_List_Chats" :




                                            // TODO: 03.02.2022 запуск синхрониазции внутри одноразвого ворк менеджера

                                            МетодЗапускаКодаВнутриОдноразовойСинхронизации
                                                    (ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle,
                                                            ПубличныйIDДляФрагмента,
                                                            КоличествоЗапущенныйПроуессы, АктивностьЕслиЕстьTOP);


                                            Log.i(КонтекстОдноразовая.getClass().getName(), "ЗАПУСК  АКТИВТИТИ ЕСТЬ НО ОПРЕДЕЛЕННАЯ  ВНУТРИ метода        " + "\n" +
                                                    "  АктивностьЕслиЕстьTOP " + АктивностьЕслиЕстьTOP +
                                                    " public Result doWork()   MyWork_Async_Синхронизация_Одноразовая  внутри WORK MANAGER "
                                                    + new Date() +
                                                    " WorkManager Synchronizasiy_Data  " + " РАБОТАЮЩИЙ ПРОЦЕСС КоличествоЗапущенныйПроуессы.size() " + КоличествоЗапущенныйПроуессы.size()
                                                    + "\n" +
                                                    "  РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне " + РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне);

                                            ///////todo  КОНЕЦ  код запуска уведомлений для чата
                                            break;
                                    }
                                }else{


                                    // TODO: 03.02.2022 запуск синхрониазции внутри одноразвого ворк менеджера  реско не сталь активти

                                    МетодЗапускаКодаВнутриОдноразовойСинхронизации
                                            (ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle,
                                                    ПубличныйIDДляФрагмента,
                                                    КоличествоЗапущенныйПроуессы, АктивностьЕслиЕстьTOP);

                                    Log.i(КонтекстОдноразовая.getClass().getName(), "ЗАПУСК   СТРОГО В ФОНЕ  О ОПРЕДЕЛЕННАЯ  ВНУТРИ метода     РАВНО 0    " + "\n" +
                                            " public Result doWork()   MyWork_Async_Синхронизация_Одноразовая  внутри WORK MANAGER "
                                            + new Date() +
                                            " WorkManager Synchronizasiy_Data  " + " РАБОТАЮЩИЙ ПРОЦЕСС КоличествоЗапущенныйПроуессы.size() " + КоличествоЗапущенныйПроуессы.size()
                                            + "\n" +
                                            "  РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне " + РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне +
                                            " \n" +"  АктивностьЕслиЕстьTOP " +АктивностьЕслиЕстьTOP);

                                }

                                // TODO: 06.12.2021  кодгда название активти являеться NULL



                            }


                        } else {



                            // TODO: 03.02.2022 запуск синхрониазции внутри одноразвого ворк менеджера

                            МетодЗапускаКодаВнутриОдноразовойСинхронизации
                                    (ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle,
                                            ПубличныйIDДляФрагмента,
                                            КоличествоЗапущенныйПроуессы, АктивностьЕслиЕстьTOP);

                            Log.i(КонтекстОдноразовая.getClass().getName(), "ЗАПУСК   СТРОГО В ФОНЕ  О ОПРЕДЕЛЕННАЯ  ВНУТРИ метода     РАВНО 0    " + "\n" +
                                    " public Result doWork()   MyWork_Async_Синхронизация_Одноразовая  внутри WORK MANAGER "
                                    + new Date() +
                                    " WorkManager Synchronizasiy_Data  " + " РАБОТАЮЩИЙ ПРОЦЕСС КоличествоЗапущенныйПроуессы.size() " + КоличествоЗапущенныйПроуессы.size()
                                    + "\n" +
                                    "  РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне " + РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне +
                                    " \n" +"  АктивностьЕслиЕстьTOP " +АктивностьЕслиЕстьTOP);

                        }






                        //TODO ЗАПУСК Ф ОЕН ОДНОРАЗОВОЕ УВЕДОМЕНИЕ
                    }else{



                            // TODO: 03.02.2022 запуск синхрониазции внутри одноразвого ворк менеджера

                            МетодЗапускаКодаВнутриОдноразовойСинхронизации
                                    (ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle,
                                            ПубличныйIDДляФрагмента,
                                            КоличествоЗапущенныйПроуессы, АктивностьЕслиЕстьTOP);

                            Log.i(КонтекстОдноразовая.getClass().getName(), "ЗАПУСК   СТРОГО В ФОНЕ  О ОПРЕДЕЛЕННАЯ  ВНУТРИ метода     вообще NULL  " + "\n" +
                                    " public Result doWork()   MyWork_Async_Синхронизация_Одноразовая  внутри WORK MANAGER "
                                    + new Date() +
                                    " WorkManager Synchronizasiy_Data  " + " РАБОТАЮЩИЙ ПРОЦЕСС КоличествоЗапущенныйПроуессы.size() " + КоличествоЗапущенныйПроуессы.size()
                                    + "\n" +
                                    "  РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне " + РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне +
                                    " \n" +"  АктивностьЕслиЕстьTOP " +АктивностьЕслиЕстьTOP);

                        }


                        //////////
                    } catch (Exception e) {
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        /////////
                        new Class_Generation_Errors(КонтекстОдноразовая).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());

                        Log.e(КонтекстОдноразовая.getClass().getName(), " ОШИБКА В WORK MANAGER  MyWork_Async_Синхронизация_Одноразовая из FaceApp в  MyWork_Async_Синхронизация_Одноразовая Exception  ошибка в классе  MyWork_Async_Синхронизация_Одноразовая" + e.toString());


                    }




            // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ СИНХОРОНИАЗЦИИ ДАННЫХ          // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ СИНХОРОНИАЗЦИИ ДАННЫХ


    // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления
     ИнформацияОЗапущенойСлужбе_Синхрониазция_Одноразовая= WorkManager.getInstance(КонтекстОдноразовая.getApplicationContext()).getWorkInfosByTag(ИмяСлужбыСинхронизации).get().get(0);

                        Log.w(КонтекстОдноразовая.getClass().getName(), " ПОСЛЕ ОТРАБОТКИ МЕТОДА ....Внутри метода public Result doWork()   MyWork_Async_Синхронизация_Одноразовая ИнформацияОЗапущенойСлужбе_Синхрониазция_Одноразовая  " +ИмяСлужбыСинхронизации +"\n"
                                + " getState  "+
                                ИнформацияОЗапущенойСлужбе_Синхрониазция_Одноразовая.getState().name()+"\n"+
                                "getTags "+
                                ИнформацияОЗапущенойСлужбе_Синхрониазция_Одноразовая.getTags()+"\n"+
                                "getRunAttemptCount "+
                                ИнформацияОЗапущенойСлужбе_Синхрониазция_Одноразовая.getRunAttemptCount()+"\n"+
                                "getProgress "+
                                ИнформацияОЗапущенойСлужбе_Синхрониазция_Одноразовая.getState().isFinished()+"\n"+
                                " время : " +new Date());



        //////////
    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        /////////
        new   Class_Generation_Errors(КонтекстОдноразовая).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

        Log.e(КонтекстОдноразовая.getClass().getName(), " ОШИБКА В WORK MANAGER  MyWork_Async_Синхронизация_Одноразовая из FaceApp в  MyWork_Async_Синхронизация_Одноразовая Exception  ошибка в классе  MyWork_Async_Синхронизация_Одноразовая" + e.toString());


    }

 //todO  результат



        // TODO: 14.11.2021 status work  REturn

        Log.i(КонтекстОдноразовая.getClass().getName(), "   РЕЗУЛЬТАТ  MyWork_Async_Синхронизация_Одноразовая  внутри WORK MANAGER   РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне    "
                +РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне );



        // TODO: 03.01.2022
        if(РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне==null){
            // TODO: 03.01.2022

            РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне=0;
        }






        Data myDataОтветОдноразовойСлужбы = new Data.Builder()
                .putLong("ОтветПослеВыполения_MyWork_Async_Синхронизация_Одноразовая",
                        РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне)
                .build();



        if (РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне > 0) {


            // TODO: 15.12.2021  код ЗАПСУКА ПОСЛЕ УСПЕШНОЙ СИНХРОНИАЗЦИИ WORK MANAGER
            Log.w(КонтекстОдноразовая.getClass().getName(), "   MyWork_Async_Синхронизация_Одноразовая return Result.Success.success "+
                            "количество " +"\n"+
                    "ПОПЫТОК СРАБОТКИ WORKMANGER (ИнформацияОЗапущенойСлужбе_Синхрониазция_Одноразовая.getRunAttemptCount()):: "
                            +ИнформацияОЗапущенойСлужбе_Синхрониазция_Одноразовая.getRunAttemptCount()+
                    "\n"+ " РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне " +РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне);


            // TODO: 14.01.2022
            return Result.success(myDataОтветОдноразовойСлужбы);



        }else {
            // TODO: 15.12.2021  код ЗАПСУКА ПОСЛЕ УСПЕШНОЙ СИНХРОНИАЗЦИИ WORK MANAGER


                Log.w(КонтекстОдноразовая.getClass().getName(), "  Result.Failure.failure" +
                        "  MyWork_Async_Синхронизация_Одноразовая  return Result.Failure.failure " +
                        "количество " +"\n"+
                        "ПОПЫТОК СРАБОТКИ WORKMANGER (ИнформацияОЗапущенойСлужбе_Синхрониазция_Одноразовая.getRunAttemptCount()):: "
                        +ИнформацияОЗапущенойСлужбе_Синхрониазция_Одноразовая.getRunAttemptCount()+
                        "\n"+ " РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне " +РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне);


                // TODO: 14.01.2022

                return Result.failure(myDataОтветОдноразовойСлужбы);




        }

            // TODO: 24.12.2021





        // TODO: 24.11.2021  результат фоновой синх work manager

    }

    private void МетодЗапускаКодаВнутриОдноразовойСинхронизации
            (Integer ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle,
             Integer ПубличныйIDДляФрагмента,
             List<ActivityManager.AppTask> КоличествоЗапущенныйПроуессы, String АктивностьЕслиЕстьTOP) {


        try{
        //  РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне=0;

        // TODO: 24.11.2021  ЗАПУСК СИНХРОНИАЗХЦИИ СТРОГОВ ФОНЕ БЕЗ АКТИВТИ
        РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне = МетодЗапускаСинхрониазцииСтрогоВФонеБезАктивити();


        Log.i(КонтекстОдноразовая.getClass().getName(), "ЗАПУСК  АКТИВТИТИ ЕСТЬ НО ОПРЕДЕЛЕННАЯ  ВНУТРИ метода        " + "\n" +
                "  АктивностьЕслиЕстьTOP " + АктивностьЕслиЕстьTOP +
                " public Result doWork()   MyWork_Async_Синхронизация_Одноразовая  внутри WORK MANAGER "
                + new Date() +
                " WorkManager Synchronizasiy_Data  " + " РАБОТАЮЩИЙ ПРОЦЕСС КоличествоЗапущенныйПроуессы.size() " + КоличествоЗапущенныйПроуессы.size()
                + "\n" +
                "  РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне " +
                РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне + " ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle " +ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle);

        // TODO: 15.12.2021 ЗАПУСКАЕМ СЛУЖБУ ONESIGNAL ПОСЛЕ СИНХРОНИЗАЦИИ


        if (РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне > 0) {

            МетодОбщийПослеОтработкиОдноразовойСинхрониазацииМыЗапускаемПовторноКведомленияИПосылаемСигналНаOneSingnal
                    (ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle, ПубличныйIDДляФрагмента);


        }


    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(КонтекстОдноразовая).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

        // TODO: 11.05.2021 запись ошибок


    }


    }














    private void МетодОбщийПослеОтработкиОдноразовойСинхрониазацииМыЗапускаемПовторноКведомленияИПосылаемСигналНаOneSingnal
            (Integer ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle, Integer ПубличныйIDДляФрагмента) {


        try{


        Log.i(КонтекстОдноразовая.getClass().getName(), "ЗАПУСК   зПубличныйIDДляФрагмента "+"\n"
                + ПубличныйIDДляФрагмента + " РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне  "  +РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне+
                " ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle " +ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle);


        // TODO: 14.11.2021  ПОВТОРНО ЗАПУСКАЕМ УВЕДОМЛЕНИЯ ТОЛЬКО ДЛЯ ОДНОРАЗОВАЯ СЛУЖБА
        new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаУведомленияЧата();


        /////
        Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.EFFECT_HEAVY_CLICK));
        } else {
            //deprecated in API 26
            v2.vibrate(200);
        }


            // TODO: 14.11.2021  ПОВТОРНО ЗАПУСКАЕМ УВЕДОМЛЕНИЯ ТОЛЬКО ДЛЯ ОДНОРАЗОВАЯ СЛУЖБА
            new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаУведомленияЗадач();



            Log.i(КонтекстОдноразовая.getClass().getName(), "ЗАПУСК   зПубличныйIDДляФрагмента "+"\n"
                    + ПубличныйIDДляФрагмента + " new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаУведомленияОбщего()" +
                    " "  +РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне);





        Log.i(КонтекстОдноразовая.getClass().getName(), "ЗАПУСК   зПубличныйIDДляФрагмента "+"\n"
                + ПубличныйIDДляФрагмента + " РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне  "  +РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне);


        // TODO: 14.11.2021  из оДНОРАЗОВГО ВОРК МЕНЕДЖЕРА ЗАПУСКАЕМ ONE SINGNAL


        МетодИзОдноразовойWORKMANAGERЗАПУскаемOneSignal(ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle, ПубличныйIDДляФрагмента);

            Log.i(КонтекстОдноразовая.getClass().getName(), "ЗАПУСК   зПубличныйIDДляФрагмента "+"\n"
                    + ПубличныйIDДляФрагмента + " РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне  "  +РезультатЗапускаФоновойОдноразовойСинхронизацииСтрогоВФОне+
                    " ПубличныйIDДляФрагмента " +ПубличныйIDДляФрагмента + " ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle " +ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle );

    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(КонтекстОдноразовая).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

        // TODO: 11.05.2021 запись ошибок


    }




    }




















    private void МетодИзОдноразовойWORKMANAGERЗАПУскаемOneSignal(Integer ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle, Integer ПубличныйIDДляФрагмента) {
        ///
        String КлючДляFirebaseNotification = "2a1819db-60c8-4ca3-a752-1b6cd9cadfa1";

        // TODO: 11.01.2022

        try{



        // TODO: 04.11.2021   ЗАПУСКАЕМ СИНХРОНИАХЦИИЮ  через ONESIGNAL
        Log.d(this.getClass().getName(), "ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle "
                + ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle +
                " ПубличныйIDДляФрагмента " +ПубличныйIDДляФрагмента);



        if ( ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle.compareTo(ПубличныйIDДляФрагмента)!=0)  {

            // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК Facebase and OneSignal  ///  КлючДляFirebaseNotification
            new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).
                    МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal(КлючДляFirebaseNotification,
                            ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle);


            // TODO: 04.11.2021   ЗАПУСКАЕМ СИНХРОНИАХЦИИЮ  через ONESIGNAL
            Log.d(this.getClass().getName(), "РезультатCallsBackСинхрониазцииЧата " + "\n" + " МОДЕЛЬ ТЕЛЕФОНА  Build.DEVICE   " + Build.DEVICE +
                    "  ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle " + ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle+
                    " ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle "+ ПубличныйIDКомуНАдоОтправитьСообщениеЧерезOneSingle);







/*                    // TODO: 11.01.2022 синхрониазация через ONESINGNAL НА СЕБЯ

            Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);

            // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК Facebase and OneSignal  ///  КлючДляFirebaseNotification
            new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).
                    МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal(КлючДляFirebaseNotification, ПубличныйIDДляФрагмента);

            // TODO: 04.11.2021   ЗАПУСКАЕМ СИНХРОНИАХЦИИЮ  через ONESIGNAL
            Log.d(this.getClass().getName(), "РезультатCallsBackСинхрониазцииЧата " + "\n" + " МОДЕЛЬ ТЕЛЕФОНА  Build.DEVICE   " + Build.DEVICE +
                    "  ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника " + ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника);*/





        }

    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(КонтекстОдноразовая).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

    }
    }





    // TODO: 24.11.2021  Метод КОТОРЫЕ ОПРЕДЕЛЯЕТ КАК МЫ БУДЕМ ЗАПУСКАТЬ СИНХРОНИЗАЦИЮ В ФОНЕ ИЛИ НЕТ ВЗАВИСИМОСТИ КАКАЯ АКТИВИТИ АКТИВНА

   protected Integer МетодЗапускаемприменяяДваВидаЕстьАктивнаяАктивтиИлиСтроговФоне() throws ExecutionException, InterruptedException {


       Integer РезультатЗапускаФоновойСинхронизации = 0;
        ///////
        boolean ФлагЗапущенолиКакоеннибутьАктивтиИлинет = false;

        try{
        ////////

        ///
        Log.d(this.getClass().getName(), "ЗАПУСК СЛУЖБА  Синхронизация фоновой (внутри потока) " + new Date()+
                "  ФлагЗапущенолиКакоеннибутьАктивтиИлинет "+ФлагЗапущенолиКакоеннибутьАктивтиИлинет );

// TODO: 02.07.2021 не запускать службу синхронизации



            // TODO: 29.09.2021  перед началом СИНХРОНИЗАЦИИ ПРОВЕРЯЕМ УСТАНОВКИ СЕТИ ПОЛЬЗОВАТЕЛЯ НА АКТИВТИ НАСТРОЙКИ

                Log.i(КонтекстОдноразовая.getClass().getName(), "ПОСЛЕ  MyWork_Async_Синхронизация_Одноразовая  внутри WORK MANAGER  внутри WORK MANGER  "
                        + new Date() + " СТАТУС WORKMANAGER  MyWork_Async_Синхронизация_Одноразовая  внутри WORK MANAGER "
                        + WorkManager.getInstance(КонтекстОдноразовая).getWorkInfosByTag("WorkManager Synchronizasiy_Data").get().get(0).getState());


                // TODO: 24.11.2021  ЗАПУСК СИНХРОНИАЗХЦИИ СТРОГОВ ФОНЕ БЕЗ АКТИВТИ
               РезультатЗапускаФоновойСинхронизации=  МетодЗапускаСинхрониазцииСтрогоВФонеБезАктивити();



            Log.i(КонтекстОдноразовая.getClass().getName(), "ПОСЛЕ  MyWork_Async_Синхронизация_Одноразовая  внутри WORK MANAGER  внутри WORK MANGER  "
                    + new Date() + " СТАТУС WORKMANAGER  MyWork_Async_Синхронизация_Одноразовая  внутри WORK MANAGER " + WorkManager.getInstance(КонтекстОдноразовая).getWorkInfosByTag("WorkManager Synchronizasiy_Data").get().get(0).getState()+
                    "   РЕЗУЛЬТАТ  MyWork_Async_Синхронизация_Одноразовая  внутри WORK MANAGER   РезультатЗапускаФоновойСинхронизации    " +РезультатЗапускаФоновойСинхронизации );



    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(КонтекстОдноразовая).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

    }
return  РезультатЗапускаФоновойСинхронизации;
}




















    // TODO: 24.11.2021  Метод КОТОРЫЕ   ЗАПСУКАЮ СИНХРОНИАЗЦИЮ БЕЗ АКТИВТИ СТРГО В ФОНЕ

    protected  Integer МетодЗапускаСинхрониазцииСтрогоВФонеБезАктивити() {

     // TODO: 24.11.2021

        boolean РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию =
                new Class_Find_Setting_User_Network(КонтекстОдноразовая).МетодПроветяетКакуюУстановкуВыбралПользовательСети();

     //TODO ФУТУРЕ ЗАВЕРШАЕМ
     Log.d(this.getClass().getName(), "  РезультатПроВеркиУстановкиПользователяРежимРаботыСети " + РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию);

 Integer  РезультатЗапускаФоновойСинхронизации = 0;


     try {

         //TODO ФУТУРЕ ЗАВЕРШАЕМ
         Log.d(this.getClass().getName(), "  РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию "
                 + РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию);







         if (РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию==true) {




             // TODO: 21.11.2021  НАЧАЛО СИХРОНИЗХАЦИИИ


             LinkedBlockingQueue ЗаполненыеСистемныеТаблицыДЛяСинхронизации = new Class__Generation_Genetal_Tables(КонтекстОдноразовая).
                     МетодЗаполеннияТаблицДЛяРаботыиСинхрониазции();


             //TODO ФУТУРЕ ЗАВЕРШАЕМ
             Log.d(this.getClass().getName(), "  ЗаполненыеСистемныеТаблицыДЛяСинхронизации " + ЗаполненыеСистемныеТаблицыДЛяСинхронизации.size());



                 ///////
                 РезультатЗапускаФоновойСинхронизации = new Class_Engine_SQL(КонтекстОдноразовая).
                         МетодЗАпускаФоновойСинхронизации(КонтекстОдноразовая,
                                 "СинхронизацияОбщая", false, null, ЗаполненыеСистемныеТаблицыДЛяСинхронизации,
                                 "ПовторныйЗапускСинхронизации",0);  //TODO третить параментр false --указывает что обработка всех таблиц кроме чата

                 //
                 // TODO: 22.04.2021  srart JOBschedele
                 Log.w(this.getClass().getName(), " СЛУЖБА  РезультатЗапускаФоновойСинхронизации  ИЗ ФОНА   "+ РезультатЗапускаФоновойСинхронизации);


         }

     } catch (Exception e) {
         //  Block of code to handle errors
         e.printStackTrace();
         ///метод запись ошибок в таблицу
         Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                 + Thread.currentThread().getStackTrace()[2].getLineNumber());
         new   Class_Generation_Errors(КонтекстОдноразовая).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                 Thread.currentThread().getStackTrace()[2].getMethodName(),
                 Thread.currentThread().getStackTrace()[2].getLineNumber());

     }

 //
        return  РезультатЗапускаФоновойСинхронизации ;
    }

/////

}





























