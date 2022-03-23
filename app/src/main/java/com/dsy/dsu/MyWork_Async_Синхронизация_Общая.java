package com.dsy.dsu;

import static android.content.Context.ACTIVITY_SERVICE;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.dsy.dsu.Code_For_Firebase_AndOneSignal_Здесь_КодДЛяСлужбыУведомленияFirebase.Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;


public class MyWork_Async_Синхронизация_Общая extends Worker {
    /////
    Context Контекст;
    //////
    String ИмяСлужбыСинхронизации="WorkManager Synchronizasiy_Data";
    ////////

//
WorkInfo ИнформацияОЗапущенойСлужбе_Общая_Синхронизация;
    Integer РезультатЗапускаФоновойСинхронизацииСтрогоВФОне=0;


    Integer  ПубличныйIDДляОбщейСинхрониазции=0;


    public MyWork_Async_Синхронизация_Общая(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
       this. Контекст = context;


        Log.i(Контекст.getClass().getName(), " public MyWork_Async_Синхронизация_Общая(@NonNull Context context, @NonNull WorkerParameters workerParams) {  Контекст "+"\n"+ Контекст);
    }


    public MyWork_Async_Синхронизация_Общая(@NonNull Context context, @NonNull WorkerParameters workerParams, @NonNull Activity activity) {
        super(context, workerParams);
        Контекст = context;

    }

    @Override
    public void onStopped() {
        super.onStopped();
    }





    @SuppressLint("RestrictedApi")
    @NonNull
    @Override
    public Result doWork() {

// Do processing
 try{

     // TODO: 11.01.2022  СВОЕЙ ТЕКУЩИЙ ID ПОЛЬЗОВАТЕЛЯ
     Integer  ПубличныйIDДляОбщейСинхрониазции=   new Class_Generations_PUBLIC_CURRENT_ID(Контекст).ПолучениеПубличногоТекущегоПользователяID();

     // TODO: 01.01.2022
     if (ПубличныйIDДляОбщейСинхрониазции==null){

         ПубличныйIDДляОбщейСинхрониазции=0;
     }


     Log.d(this.getClass().getName(), "ПубличныйIDДляОбщейСинхрониазции " + ПубличныйIDДляОбщейСинхрониазции);



// TODO: 07.12.2021
            ActivityManager ЗапущенныйПроуессыДляОбщейСинхрониазации = (ActivityManager) Контекст.getSystemService(ACTIVITY_SERVICE);

// TODO: 25.02.2022


                    //////




                    
                    // TODO: 24.11.2021  чисто ФОНОВЫЙ УРОВЕНЬ ЗАПУСК ПОСЛЕ ПЕРЕЗАГРУЗКИ ТЕЛЕФОНА

                    try {
                        // TODO: 24.11.2021


                        // TODO: 29.09.2021  перед началом СИНХРОНИЗАЦИИ ПРОВЕРЯЕМ УСТАНОВКИ СЕТИ ПОЛЬЗОВАТЕЛЯ НА АКТИВТИ НАСТРОЙКИ

                        if (ЗапущенныйПроуессыДляОбщейСинхрониазации!=null) {

                            // TODO: 24.11.2021
                            List<ActivityManager.AppTask> КоличествоЗапущенныйПроуессы = ЗапущенныйПроуессыДляОбщейСинхрониазации.getAppTasks();


                        if (КоличествоЗапущенныйПроуессы.size() > 0) {



                            Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         public Result doWork()  MyWork_Async_Синхронизация_Общая  КоличествоЗапущенныйПроуессы "+"\n"
                                    + КоличествоЗапущенныйПроуессы.size());


                            // TODO: 01.12.2021
                            for (ActivityManager.AppTask ТекущаяАктивти : КоличествоЗапущенныйПроуессы) {

                                String АктивностьЕслиЕстьTOP = null;
                                // TODO: 20.02.2022
                                if (ТекущаяАктивти!=null) {

                                    // TODO: 20.02.2022
                                    Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         " +
                                            "ТекущаяАктивти.getTaskInfo().numActivities  " + "\n"
                                            + ТекущаяАктивти.getTaskInfo().numActivities);


                                    // TODO: 20.02.2022
                                    if (ТекущаяАктивти.getTaskInfo().numActivities>0) {
                                        // TODO: 20.02.2022

                                        АктивностьЕслиЕстьTOP = ТекущаяАктивти.getTaskInfo().baseActivity.getClassName().toString();
                                    }


                                    // TODO: 20.02.2022


                                    Log.i(Контекст.getClass().getName(), "ТекущаяАктивти " + ТекущаяАктивти +
                                            " АктивностьЕслиЕстьTOP  " + АктивностьЕслиЕстьTOP+
                                            "ТекущаяАктивти.getTaskInfo().numActivities  " + "\n"
                                            + ТекущаяАктивти.getTaskInfo().numActivities);////   case "com.dsy.dsu.Code_For_Chats_КодДля_Чата.MainActivity_List_Chats" :
                                }




                                if (АктивностьЕслиЕстьTOP !=null) {
                                    ///////
                                    switch (АктивностьЕслиЕстьTOP) {// case "com.dsy.dsu.MainActivity_Face_App" :

                                        case "com.dsy.dsu.MainActivity_Visible_Async":
                                        case "com.dsy.dsu.MainActivity_Tabels_Users_And_Passwords":
                                        case "com.dsy.dsu.MainActivity_Face_Start":

                                            break;


                                        // TODO: 01.12.2021 САМ ЗАПУСК WORK MANAGER  СИНХРОНИАЗЦИИ ПРИ ВКЛЮЧЕННОЙ АКТИВТИ
                                        default:

                                            Log.i(Контекст.getClass().getName(), "сРАБОТАЛО ......ТекущаяАктивти " + ТекущаяАктивти +
                                                    " АктивностьЕслиЕстьTOP  " + АктивностьЕслиЕстьTOP);////   case "com.dsy.dsu.Code_For_Chats_КодДля_Чата.MainActivity_List_Chats" :



                                            МетодЗапускаФоновойСинхрониазцииЧистоВФонеБезАктивти();

                                            Log.i(Контекст.getClass().getName(), "ЗАПУСК   ЗАПУСК в АКТВИНОЙ АКТВИТИ   АктивностьЕслиЕстьTOP"+АктивностьЕслиЕстьTOP);

                                            ///////todo  КОНЕЦ  код запуска уведомлений для чата
                                            break;
                                    }
                                }else{
                                    // TODO: 20.02.2022  нет активтиви

                                    МетодЗапускаФоновойСинхрониазцииЧистоВФонеБезАктивти();

                                    Log.i(Контекст.getClass().getName(), "ЗАПУСК   запуск синхрониазции в фоне когда вообще коиличсетво активти РАВНО 0 "+"\n"
                                            + КоличествоЗапущенныйПроуессы);
                                }

                                // TODO: 06.12.2021  кодгда название активти являеться NULL



                            }

                        } else {


                            МетодЗапускаФоновойСинхрониазцииЧистоВФонеБезАктивти();

                            Log.i(Контекст.getClass().getName(), "ЗАПУСК   запуск синхрониазции в фоне когда вообще коиличсетво активти РАВНО 0 "+"\n"
                                    + КоличествоЗапущенныйПроуессы);

                        }


                            // TODO: 31.12.2021  ЗАПУСК В ФОНЕ
                    }else{

                      МетодЗапускаФоновойСинхрониазцииЧистоВФонеБезАктивти();


                            Log.i(Контекст.getClass().getName(), "ЗАПУСК   ЗАПУСК В ФОНЕ    запуск синхрониазции в фоне когда вообще коиличсетво активти не изместно NULL ");



                        }


                        //////////
                    } catch (Exception e) {
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        /////////
                        new Class_Generation_Errors(Контекст).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());

                        Log.e(Контекст.getClass().getName(), " ОШИБКА В WORK MANAGER MyWork_Async_Синхронизация_Общая из FaceApp в MyWork_Async_Синхронизация_Общая Exception  ошибка в классе MyWork_Async_Синхронизация_Общая" + e.toString());


                    }










            // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ СИНХОРОНИАЗЦИИ ДАННЫХ          // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ СИНХОРОНИАЗЦИИ ДАННЫХ
try {

    // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления
    ИнформацияОЗапущенойСлужбе_Общая_Синхронизация= WorkManager.getInstance(Контекст.getApplicationContext()).getWorkInfosByTag(ИмяСлужбыСинхронизации).get().get(0);

                        Log.w(Контекст.getClass().getName(), " ПОСЛЕ ОТРАБОТКИ МЕТОДА ....Внутри метода public Result doWork()  MyWork_Async_Синхронизация_Общая ИнформацияОЗапущенойСлужбе_Общая_Синхронизация " +ИмяСлужбыСинхронизации +"\n"
                                + " getState  "+
                                ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getState().name()+"\n"+
                                "getTags "+
                                ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getTags()+"\n"+
                                "getRunAttemptCount "+
                                ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getRunAttemptCount()+"\n"+
                                "getProgress "+
                                ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getState().isFinished()+"\n"+
                                " время : " +new Date());







    // TODO: 14.11.2021 status work

    // TODO: 24.11.2021






            //////////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
         /////////
            new   Class_Generation_Errors(Контекст).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            Log.e(Контекст.getClass().getName(),
                    " ОШИБКА В WORK MANAGER MyWork_Async_Синхронизация_Общая из FaceApp в MyWork_Async_Синхронизация_Общая Exception  ошибка в классе MyWork_Async_Синхронизация_Общая" + e.toString());


        }


        //////////
    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        /////////
        new   Class_Generation_Errors(Контекст).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

        Log.e(Контекст.getClass().getName(), " ОШИБКА В WORK MANAGER MyWork_Async_Синхронизация_Общая из FaceApp в MyWork_Async_Синхронизация_Общая Exception  ошибка в классе MyWork_Async_Синхронизация_Общая" + e.toString());


    }


        Log.i(Контекст.getClass().getName(), "   РЕЗУЛЬТАТ MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER   " +
                "РезультатЗапускаФоновойСинхронизацииСтрогоВФОне    "
                +РезультатЗапускаФоновойСинхронизацииСтрогоВФОне +
                " ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getRunAttemptCount() " +ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getRunAttemptCount());


        // TODO: 03.01.2022  
        if(РезультатЗапускаФоновойСинхронизацииСтрогоВФОне==null){
            // TODO: 03.01.2022  
                    
            РезультатЗапускаФоновойСинхронизацииСтрогоВФОне=0;
        }

        // TODO: 03.02.2022  ответ общей синхрониазции успакшно или нет

        Data myDataОтветОБЩЕЙСИНХРОНИЗАЦИИСлужбы = new Data.Builder()
                .putLong("ОтветПослеВыполения_MyWork_Async_ОБЩЕЙ_Синхронизация",
                        РезультатЗапускаФоновойСинхронизацииСтрогоВФОне)
                .build();

/*
        if (РезультатЗапускаФоновойСинхронизацииСтрогоВФОне>0) {

            // TODO: 24.12.2021



            Log.i(Контекст.getClass().getName(), "  РЕЗУЛЬТАТ ОБЩЕЙ СИНХРОНИАЗЦИИ" +
                    "Result.success()    РЕЗУЛЬТАТ MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER   РезультатЗапускаФоновойСинхронизацииСтрогоВФОне    "
                    +РезультатЗапускаФоновойСинхронизацииСтрогоВФОне  + " myDataОтветОБЩЕЙСИНХРОНИЗАЦИИСлужбы " +myDataОтветОБЩЕЙСИНХРОНИЗАЦИИСлужбы.size() );
            // TODO: 15.12.2021  код ЗАПСУКА ПОСЛЕ УСПЕШНОЙ СИНХРОНИАЗЦИИ WORK MANAGER


// TODO: 28.02.2022  обнуляем
            ИнформацияОЗапущенойСлужбе_Общая_Синхронизация=null;
            // TODO: 24.12.2021

            return Result.success(myDataОтветОБЩЕЙСИНХРОНИЗАЦИИСлужбы);

        } else {






            if (ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getRunAttemptCount()>10000) {


// TODO: 25.02.2022

                Log.i(Контекст.getClass().getName(), "  РЕЗУЛЬТАТ ОБЩЕЙ СИНХРОНИАЗЦИИ" +
                        "Result.failure()    РЕЗУЛЬТАТ MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER   РезультатЗапускаФоновойСинхронизацииСтрогоВФОне    "
                        +РезультатЗапускаФоновойСинхронизацииСтрогоВФОне +  "myDataОтветОБЩЕЙСИНХРОНИЗАЦИИСлужбы " +myDataОтветОБЩЕЙСИНХРОНИЗАЦИИСлужбы.size()+"\n"+
                        " ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getRunAttemptCount() " +ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getRunAttemptCount());


                // TODO: 24.12.2021
                return Result.failure(myDataОтветОБЩЕЙСИНХРОНИЗАЦИИСлужбы);

            } else {
                // TODO: 25.02.2022
                Log.i(Контекст.getClass().getName(), "  РЕЗУЛЬТАТ ОБЩЕЙ СИНХРОНИАЗЦИИ" +
                        "Result.retry()   РЕЗУЛЬТАТ MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER   РезультатЗапускаФоновойСинхронизацииСтрогоВФОне    "
                        +РезультатЗапускаФоновойСинхронизацииСтрогоВФОне +  "myDataОтветОБЩЕЙСИНХРОНИЗАЦИИСлужбы " +myDataОтветОБЩЕЙСИНХРОНИЗАЦИИСлужбы.size()+"\n"+
                        " ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getRunAttemptCount() " +ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getRunAttemptCount());
                // TODO: 24.12.2021
                return Result.retry();


            }


        }*/
        // TODO: 25.02.2022
        Log.i(Контекст.getClass().getName(), "  РЕЗУЛЬТАТ ОБЩЕЙ СИНХРОНИАЗЦИИ" +
                "Result.retry()   РЕЗУЛЬТАТ MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER   РезультатЗапускаФоновойСинхронизацииСтрогоВФОне    "
                +РезультатЗапускаФоновойСинхронизацииСтрогоВФОне +  "myDataОтветОБЩЕЙСИНХРОНИЗАЦИИСлужбы " +myDataОтветОБЩЕЙСИНХРОНИЗАЦИИСлужбы.size()+"\n"+
                " ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getRunAttemptCount() " +ИнформацияОЗапущенойСлужбе_Общая_Синхронизация.getRunAttemptCount());
        // TODO: 24.12.2021
        return Result.retry();
        // TODO: 24.11.2021  результат фоновой синх work manager

    }




    // TODO: 16.12.2021 МЕтод ЗАпуска  Сихрониазации Чисто В форне без актвтити

    private void МетодЗапускаФоновойСинхрониазцииЧистоВФонеБезАктивти() {
        try {






           // TODO: 24.11.2021  ЗАПУСК СИНХРОНИАЗХЦИИ СТРОГОВ ФОНЕ БЕЗ АКТИВТИ
           РезультатЗапускаФоновойСинхронизацииСтрогоВФОне = МетодЗапускаСинхрониазцииСтрогоВФонеБезАктивити();

// TODO: 28.02.2022


           Log.i(Контекст.getClass().getName(), "ЗАПУСК   ЧИСТЫЙ ФОНОВЫЙ ПОТОК НЕТ АКТИВТИ ПРОГРАММА SWODOWN  ВНУТРИ метода        "+"\n"+
                   " public Result doWork()  MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER "
                   + new Date() + " СТАТУС WORKMANAGER MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER "
                   + WorkManager.getInstance(Контекст).getWorkInfosByTag("WorkManager Synchronizasiy_Data").get().get(0).getProgress() +
                   " WorkManager Synchronizasiy_Data  "
                   +"\n"+
                   "  РезультатЗапускаФоновойСинхронизацииСтрогоВФОне " +РезультатЗапускаФоновойСинхронизацииСтрогоВФОне );

           // TODO: 15.12.2021 ЗАПУСКАЕМ СЛУЖБУ ONESIGNAL
            if (РезультатЗапускаФоновойСинхронизацииСтрогоВФОне>0 ) {
                /////
                Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate for 500 milliseconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.EFFECT_HEAVY_CLICK));
                } else {
                    //deprecated in API 26
                    v2.vibrate(200);
                }


            }





               // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР
               new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаУведомленияОбщего();

               
// TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР



               // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР
               new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаУведомленияДляОдноразовойСинхрониазации();


               Log.i(Контекст.getClass().getName(), "МетодЗапускаONESIGNALИзОбщейСинхронизации      "+"\n"+
                       " public Result doWork()  MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER "
                       + ПубличныйIDДляОбщейСинхрониазции);


           
           //////////
       } catch (Exception e) {
           e.printStackTrace();
           ///метод запись ошибок в таблицу
           Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                   " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
           /////////
           new Class_Generation_Errors(Контекст).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                   Thread.currentThread().getStackTrace()[2].getLineNumber());

           Log.e(Контекст.getClass().getName(), " ОШИБКА В WORK MANAGER MyWork_Async_Синхронизация_Общая из FaceApp в MyWork_Async_Синхронизация_Общая Exception  ошибка в классе MyWork_Async_Синхронизация_Общая" + e.toString());


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

                Log.i(Контекст.getClass().getName(), "ПОСЛЕ MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER  внутри WORK MANGER  "
                        + new Date() + " СТАТУС WORKMANAGER MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER "
                        + WorkManager.getInstance(Контекст).getWorkInfosByTag("WorkManager Synchronizasiy_Data").get().get(0).getState());


                // TODO: 24.11.2021  ЗАПУСК СИНХРОНИАЗХЦИИ СТРОГОВ ФОНЕ БЕЗ АКТИВТИ
               РезультатЗапускаФоновойСинхронизации=  МетодЗапускаСинхрониазцииСтрогоВФонеБезАктивити();



            Log.i(Контекст.getClass().getName(), "ПОСЛЕ MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER  внутри WORK MANGER  "
                    + new Date() + " СТАТУС WORKMANAGER MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER " + WorkManager.getInstance(Контекст).getWorkInfosByTag("WorkManager Synchronizasiy_Data").get().get(0).getState()+
                    "   РЕЗУЛЬТАТ MyWork_Async_Синхронизация_Общая  внутри WORK MANAGER   РезультатЗапускаФоновойСинхронизации    " +РезультатЗапускаФоновойСинхронизации );



    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(Контекст).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

    }
return  РезультатЗапускаФоновойСинхронизации;
}




















    // TODO: 24.11.2021  Метод КОТОРЫЕ   ЗАПСУКАЮ СИНХРОНИАЗЦИЮ БЕЗ АКТИВТИ СТРГО В ФОНЕ

    protected  Integer МетодЗапускаСинхрониазцииСтрогоВФонеБезАктивити() {

     // TODO: 24.11.2021

     boolean РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию=
             new  Class_Find_Setting_User_Network(Контекст).МетодПроветяетКакуюУстановкуВыбралПользовательСети();

     //TODO ФУТУРЕ ЗАВЕРШАЕМ
     Log.d(this.getClass().getName(), "  РезультатПроВеркиУстановкиПользователяРежимРаботыСети " + РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию);

 Integer  РезультатЗапускаФоновойСинхронизации = 0;


     try {

         //TODO ФУТУРЕ ЗАВЕРШАЕМ
         Log.d(this.getClass().getName(), "  РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию "
                 + РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию);







         if (РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию==true) {




             // TODO: 21.11.2021  НАЧАЛО СИХРОНИЗХАЦИИИ


             LinkedBlockingQueue ЗаполненыеСистемныеТаблицыДЛяСинхронизации = new Class__Generation_Genetal_Tables(Контекст).
                     МетодЗаполеннияТаблицДЛяРаботыиСинхрониазции();


             //TODO ФУТУРЕ ЗАВЕРШАЕМ
             Log.d(this.getClass().getName(), "  ЗаполненыеСистемныеТаблицыДЛяСинхронизации " + ЗаполненыеСистемныеТаблицыДЛяСинхронизации.size());



                 ///////
                 РезультатЗапускаФоновойСинхронизации = new Class_Engine_SQL(Контекст).
                         МетодЗАпускаФоновойСинхронизации(Контекст,
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
         new   Class_Generation_Errors(Контекст).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                 Thread.currentThread().getStackTrace()[2].getMethodName(),
                 Thread.currentThread().getStackTrace()[2].getLineNumber());

     }

 //
        return  РезультатЗапускаФоновойСинхронизации ;
    }

/////

}





























