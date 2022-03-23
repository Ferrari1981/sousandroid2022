package com.dsy.dsu;

import static android.content.Context.ACTIVITY_SERVICE;
import static android.content.Context.NOTIFICATION_SERVICE;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.jetbrains.annotations.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;


public class MyWork_Notifocations_Уведомления_Общая extends Worker {
    Context Контекст;
    ///
    String ИмяСлужбыУведомленияДляЧата="WorkManager NOtofocationForChat";


    WorkerParameters workerParams;

 NotificationManager mNotificationManagerДляЧАТА=null;


    WorkInfo ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая;




Integer ОбщееКоличествоНЕпрочитанныхСтрок=0;
    ////TODO
    NotificationCompat.Builder builder=null;
    //// Notification notificationAfterBuild=null;

    //TODO

    CREATE_DATABASE Create_Database_СсылкаНАБазовыйКласс;

    Class_GRUD_SQL_Operations       class_grud_sql_operationsIDпользоввателяДляСлужб;

    SimpleDateFormat ФоорматДат ;


 //   StringBuffer БуферСамиУведомленияЛинкСамиУведомления;

    int     ID_ТаблицаУвендомлений;


    Intent ИнтентДляЗапускаСлужбыПолсеАнализа;

    Boolean РезультатНужноЗапускатьУведомленияИлиНет=false;
    ////////
    private String PROCESS_ID_УведомленияПлановая="12";

    // TODO: 12.10.2021  Ссылка Менеджер Потоков

    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =null;





    ArrayList БуферСамиУведомленияЛинкСамиУведомления;

    // TODO: 03.02.2022

    // TODO: 03.02.2022  УВЕДОМЛЕНИЯ ДЛЯ ОБШЕЙ СИНХРОНИАЗЦИИ
    NotificationCompat.MessagingStyle messagingStyleДля_ОбщихУведомлений;


    // TODO: 07.02.2022

    Person.Builder person;



    public MyWork_Notifocations_Уведомления_Общая(@NonNull Context context, @NonNull WorkerParameters workerParamsвнутри) {
        super(context, workerParamsвнутри);


            Контекст=context;

        workerParams=workerParamsвнутри;

        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new     PUBLIC_CONTENT(Контекст);
        ////
        class_grud_sql_operationsIDпользоввателяДляСлужб=new Class_GRUD_SQL_Operations(Контекст);
        //TODO

        Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(Контекст);


        messagingStyleДля_ОбщихУведомлений= new NotificationCompat.MessagingStyle(getApplicationContext().getResources().getString(R.string.action_settings))
                .setConversationTitle("Задание");

        Log.i(Контекст.getClass().getName(),
                " messagingStyleДля_ОбщихУведомлений "+"\n"+ messagingStyleДля_ОбщихУведомлений.getMessages());
    }


    public MyWork_Notifocations_Уведомления_Общая(@NonNull Context context, @NonNull WorkerParameters workerParams, @Nullable Activity activity) {
        super(context, workerParams);


        Контекст=context;
        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new     PUBLIC_CONTENT(Контекст);
        ////
        class_grud_sql_operationsIDпользоввателяДляСлужб=new Class_GRUD_SQL_Operations(Контекст);
        //TODO

        Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(Контекст);

        Log.i(Контекст.getClass().getName(),
                " public MyWork_Notifocations_Уведомления_Общая(@NonNull Context context, @NonNull WorkerParameters workerParams,@Nullable Activity activity) {  Контекст "+"\n"+ Контекст);

    }






    @Override
    public void onStopped() {

        super.onStopped();

        Log.i(this.getClass().getName(), " onStopped ()  ");
    }


    // TODO: 17.11.2021  ГЛАВНЫЙ МЕТОД КЛАССА WORK MANEGER  ДЛЯ УВЕЛОДОМЛЕНИЯ ТОЛЬКО ДЛЯ ЧАТА

    @NonNull
    @Override
    public Result doWork() {

        // What happens behind the scene?!


        //todo Прпробуем Запустить в Потоке work manager уведомления чата


        Boolean ФинальныйФлагЛюбогоЗапущеногоАктивти = false;


        try {

            // TODO: 11.12.2021
            // TODO: 17.11.2021

            ActivityManager ЗапущенныйПроуессыДляУведомленийЧата = (ActivityManager) Контекст.getSystemService(ACTIVITY_SERVICE);
            // TODO: 24.11.2021



            // TODO: 16.12.2021
            if (ЗапущенныйПроуессыДляУведомленийЧата!=null) {

                // TODO: 24.11.2021
                List<ActivityManager.AppTask> КоличествоЗапущенныйПроуессыДляЧата = ЗапущенныйПроуессыДляУведомленийЧата.getAppTasks();


            if (КоличествоЗапущенныйПроуессыДляЧата.size() > 0) {

                Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         " +
                        "public Result doWork()  MyWork_Notifocations_Уведомления  внутри WORK MANAGER  КоличествоЗапущенныйПроуессыДляЧата " + "\n"
                        + КоличествоЗапущенныйПроуессыДляЧата.size());
                ///////////////////////////////////////////////////////////////////////////////////////
                // TODO: 01.12.2021
                for (ActivityManager.AppTask ТекущаяАктивти : КоличествоЗапущенныйПроуессыДляЧата) {

                    String АктивностьЕслиЕстьTOPДляЧата = null;

                    // TODO: 20.02.2022
                    if (ТекущаяАктивти!=null) {

                        Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         " +
                                "ТекущаяАктивти.getTaskInfo().numActivities  " + "\n"
                                + ТекущаяАктивти.getTaskInfo().numActivities);
                        // TODO: 20.02.2022
                        if (ТекущаяАктивти.getTaskInfo().numActivities>0) {
                            // TODO: 20.02.2022

                            АктивностьЕслиЕстьTOPДляЧата = ТекущаяАктивти.getTaskInfo().baseActivity.getClassName().toString();
                        }


                        Log.i(Контекст.getClass().getName(), "ТекущаяАктивти " + ТекущаяАктивти +
                                " АктивностьЕслиЕстьTOPДляЧата  " + АктивностьЕслиЕстьTOPДляЧата +
                                "ТекущаяАктивти.getTaskInfo().numActivities  " + "\n"
                                + ТекущаяАктивти.getTaskInfo().numActivities);


                    }



                    if (АктивностьЕслиЕстьTOPДляЧата!=null) {
                        // TODO: 06.12.2021
                        switch (АктивностьЕслиЕстьTOPДляЧата) {

                            case "com.dsy.dsu.MainActivity_Visible_Async":
                            case "com.dsy.dsu.MainActivity_Face_Start":
                            case "com.dsy.dsu.MainActivity_Tabels_Users_And_Passwords":
                                break;


                            // TODO: 01.12.2021 САМ ЗАПУСК WORK MANAGER  СИНХРОНИАЗЦИИ ПРИ ВКЛЮЧЕННОЙ АКТИВТИ
                            default:


                                Log.d(this.getClass().getName(), "ЗАПУСК СЛУЖБА ВНУТРИ startService   Вещятеля BroadcastReceiver  Service_Notificatios_Уведомления_ОбновлениеПО  ДЛЯ ЧАТА " + new Date() +
                                        "\n" + " Build.BRAND " + Build.BRAND.toString() + "\n");

                                ///////todo код запуска уведомлений для чата



                                ///////todo код запуска уведомлений для чата

                                МетодЗапускаСлужбыУведомленияДляЧата();

                                ///////todo код запуска уведомлений для чата

                                Log.i(Контекст.getClass().getName(), "Метод ВНУТРИ РАБОТА... С АКТИВТИ ДЕЙСТВУЩИМ ЧАТА ОТРАБОТАЛ ВНУТРИ метода ЗАПУСКАЕМ БЕЗ activity      " +
                                        "   public Result doWork()  MyWork_Notifocations_Уведомления  внутри WORK MANAGER "
                                        + new Date() +
                                        " WorkManager Synchronizasiy_Data  " + " РАБОТАЮЩИЙ ПРОЦЕСС  КоличествоЗапущенныйПроуессыДляЧата.size()"
                                        + КоличествоЗапущенныйПроуессыДляЧата.size() + "\n" +
                                        "   действуещее TOP активти АктивностьЕслиЕстьTOPДляЧата " + АктивностьЕслиЕстьTOPДляЧата);

                                ///////todo  КОНЕЦ  код запуска уведомлений для чата
                                break;
                            // TODO: 24.11.2021
                        }
                    }else{

                        // TODO: 03.12.2021 ПРОСТО ФОНОВАЯ ЗАДАЧА  РЕЗКО НЕ СТАЛО АКТИВТИ
                        МетодЗапускаетУведомленияКогдаВообщенетНиОдногоАктивтиNULL(ФинальныйФлагЛюбогоЗапущеногоАктивти);

                        Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         public Result doWork()  MyWork_Notifocations_Уведомления  внутри WORK MANAGER Зарускает когда Активти РАВНО )" + "\n"
                                + КоличествоЗапущенныйПроуессыДляЧата);



                    }
                }


                // TODO: 03.12.2021 ПРОСТО ФОНОВАЯ ЗАДАЧА

            } else {


                // TODO: 03.12.2021 ПРОСТО ФОНОВАЯ ЗАДАЧА
                МетодЗапускаетУведомленияКогдаВообщенетНиОдногоАктивтиNULL(ФинальныйФлагЛюбогоЗапущеногоАктивти);

                Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         public Result doWork()  MyWork_Notifocations_Уведомления  внутри WORK MANAGER Зарускает когда Активти РАВНО )" + "\n"
                        + КоличествоЗапущенныйПроуессыДляЧата);
            }

        }else{


            // TODO: 03.12.2021 ПРОСТО ФОНОВАЯ ЗАДАЧА
            МетодЗапускаетУведомленияКогдаВообщенетНиОдногоАктивтиNULL(ФинальныйФлагЛюбогоЗапущеногоАктивти);


                Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         public Result doWork()  MyWork_Notifocations_Уведомления  внутри WORK MANAGER Зарускает когда Активти воОБЩЕ НЕТ null" );



        }

            //TODO когда запускам уведомления чата  КОГДА НЕТ АКТИВИТИ И ПРОСТО ЗАПУСКАЕМ

                        // TODO: 24.11.2021

            // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления
            ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая= WorkManager.getInstance(Контекст.getApplicationContext()).getWorkInfosByTag(ИмяСлужбыУведомленияДляЧата).get().get(0);
                // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата         // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата

                Log.w(Контекст.getClass().getName(), " Внутри метода public Result doWork()   MyWork_Notifocations_Уведомления_Общая  ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая " + ИмяСлужбыУведомленияДляЧата + "\n"
                        + " getState  " +
                        ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getState().name() + "\n" +
                        "getTags " +
                        ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getTags() + "\n" +
                        "getRunAttemptCount " +
                        ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount() + "\n" +
                        "getProgress " +
                        ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getProgress().toString() + "\n" +
                        " время : " + new Date());

            //////////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            Log.e(Контекст.getClass().getName(), " Стоп СЛУЖБА Service_Notificatios_Уведомления_ОбновлениеПО  ДЛЯ ЧАТА " +
                    "MyWork_Notifocations_Уведомления_Общая ошибка  Exception e в классе MyWork_Notifocations_Уведомления_Общая " + e.toString() + "\n" +
                    " ФинальныйФлагЛюбогоЗапущеногоАктивти " + ФинальныйФлагЛюбогоЗапущеногоАктивти);

            //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ
            //  builder=null;
            Log.e(getApplicationContext().getClass().getName(), " Ошибка  MyWork_Notifocations_Уведомления ЧАТ   public Result doWork()    ДЛЯ ЧАТА ");
        }


        // TODO: 14.11.2021  status work manger




        Log.i(Контекст.getClass().getName(), "ОбщееКоличествоНЕпрочитанныхСтрок" + ОбщееКоличествоНЕпрочитанныхСтрок + " РезультатНужноЗапускатьУведомленияИлиНет "+ РезультатНужноЗапускатьУведомленияИлиНет);







        Log.w(Контекст.getClass().getName(), "BACKOFF ПОВТОРЕНИЕ СЛУЖБЫ ОБЩЕГО УВЕДОМЛЕНИЯ  ПОСЛЕ 0 количество  Result.retry() " +"\n"+
                "ПОПЫТОК СРАБОТКИ WORKMANGER (ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()):: "
                +ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()+
                "  РЕЗУЛЬТАТ ОБЩЕЙ СИНХРОНИАЗЦИИ" +
                "Result.retry() РЕЗУЛЬТАТ MyWork_Notifocations_Уведомления_Общая  внутри WORK MANAGER   РезультатЗапускаФоновойСинхронизацииСтрогоВФОне    "
                +РезультатНужноЗапускатьУведомленияИлиНет+ " ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount() " +ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount() );

        // TODO: 25.02.2022 send datas
        Data myDataОтветОбщегоУведомления = new Data.Builder()
                .putBoolean("ОтветПослеВыполения_MyWork_Notifocations_Уведомления_Общая",
                        РезультатНужноЗапускатьУведомленияИлиНет)
                .build();
      /*  // TODO: 24.12.2021
        return Result.retry();*/

    /*    if (РезультатНужноЗапускатьУведомленияИлиНет==true) {



            // TODO: 03.01.2022
            Log.w(Контекст.getClass().getName(), " return return return Result.success()  " +"\n"+
                    "  ПОПЫТОК СРАБОТКИ WORKMANGER   MyWork_Notifocations_Уведомления_Общая  (ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()):: "
                    +ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()+
                    "  РЕЗУЛЬТАТ ОБЩЕЙ СИНХРОНИАЗЦИИ" +
                    "Result.retry() РЕЗУЛЬТАТ MyWork_Notifocations_Уведомления_Общая  внутри WORK MANAGER   РезультатЗапускаФоновойСинхронизацииСтрогоВФОне    "
                    +РезультатНужноЗапускатьУведомленияИлиНет + " ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount() "
                    +ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount() );


            // TODO: 28.02.2022

            // TODO: 28.02.2022  обнялем рещультат флаг после отораюболтки
            РезультатНужноЗапускатьУведомленияИлиНет=false;
            // TODO: 24.11.2021
            return Result.success(myDataОтветОбщегоУведомления);


        } else {


                // TODO: 24.12.2021

            if (ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()>1000) {
                // TODO: 25.02.2022
                Log.w(Контекст.getClass().getName(), "   return return return   BACKOFF ПОВТОРЕНИЕ СЛУЖБЫ ОБЩЕГО УВЕДОМЛЕНИЯ  ПОСЛЕ 0 количество   Result.failure()   " +"\n"+
                        "ПОПЫТОК СРАБОТКИ WORKMANGER  MyWork_Notifocations_Уведомления_Общая (ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()):: "
                        +ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()+
                        "  РЕЗУЛЬТАТ ОБЩЕЙ УВЕДОМЕЛЕНИЯ " +
                        "Result.failure()  РЕЗУЛЬТАТ MyWork_Notifocations_Уведомления_Общая  внутри WORK MANAGER   РезультатЗапускаФоновойСинхронизацииСтрогоВФОне    "
                        +РезультатНужноЗапускатьУведомленияИлиНет
                        +"\n"+  "  MyWork_Notifocations_Уведомления_Общая  ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount() "
                        +ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()  );

                // TODO: 24.11.2021
                return Result.failure(myDataОтветОбщегоУведомления);

                // TODO: 25.02.2022



            } else {
                // TODO: 25.02.2022
                Log.w(Контекст.getClass().getName(), "   return return return   BACKOFF ПОВТОРЕНИЕ СЛУЖБЫ ОБЩЕГО УВЕДОМЛЕНИЯ  ПОСЛЕ 0 количество   Result.failure()   " +"\n"+
                        "ПОПЫТОК СРАБОТКИ WORKMANGER  MyWork_Notifocations_Уведомления_Общая (ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()):: "
                        +ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()+
                        "  РЕЗУЛЬТАТ ОБЩЕЙ УВЕДОМЕЛЕНИЯ " +
                        "Result.retry() РЕЗУЛЬТАТ MyWork_Notifocations_Уведомления_Общая  внутри WORK MANAGER   РезультатЗапускаФоновойСинхронизацииСтрогоВФОне    "
                        +РезультатНужноЗапускатьУведомленияИлиНет
                        +"\n"+  "  MyWork_Notifocations_Уведомления_Общая  ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount() "
                        +ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount() );

                // TODO: 24.11.2021
                return Result.retry();

            }*/
            // TODO: 25.02.2022
            Log.w(Контекст.getClass().getName(), "   return return return   BACKOFF ПОВТОРЕНИЕ СЛУЖБЫ ОБЩЕГО УВЕДОМЛЕНИЯ  ПОСЛЕ 0 количество   Result.failure()   " +"\n"+
                    "ПОПЫТОК СРАБОТКИ WORKMANGER  MyWork_Notifocations_Уведомления_Общая (ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()):: "
                    +ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount()+
                    "  РЕЗУЛЬТАТ ОБЩЕЙ УВЕДОМЕЛЕНИЯ " +
                    "Result.retry() РЕЗУЛЬТАТ MyWork_Notifocations_Уведомления_Общая  внутри WORK MANAGER   РезультатЗапускаФоновойСинхронизацииСтрогоВФОне    "
                    +РезультатНужноЗапускатьУведомленияИлиНет
                    +"\n"+  "  MyWork_Notifocations_Уведомления_Общая  ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount() "
                    +ИнформацияОЗапущенойСлужбе_Уведомления_Одноразовая.getRunAttemptCount() );

            // TODO: 24.11.2021
            return Result.retry();

            // TODO: 03.01.2022


    }

















    // TODO: 16.12.2021 Метод ЗАпускает в фоне Уведомелния когда вообще нет нет ни одного Активти NULL

    private void МетодЗапускаетУведомленияКогдаВообщенетНиОдногоАктивтиNULL(Boolean ФинальныйФлагЛюбогоЗапущеногоАктивти) {
        try{

                          Log.d(this.getClass().getName(), "ЗАПУСК СЛУЖБА ВНУТРИ startService   Вещятеля BroadcastReceiver  Service_Notificatios_Уведомления_ОбновлениеПО  ДЛЯ ЧАТА " + new Date() +
                                  "\n" + " Build.BRAND " + Build.BRAND.toString() + "\n" );

                          ///////todo код запуска уведомлений для чата


                          ///////todo код запуска уведомлений для чата

                          МетодЗапускаСлужбыУведомленияДляЧата();

                          ///////todo код запуска уведомлений для чата

                          Log.i(Контекст.getClass().getName(), "Метод ВНУТРИ ЧИСТО ФОНОВАЯ ЗАДАЧА  ЧАТА ОТРАБОТАЛ ВНУТРИ метода ЗАПУСКАЕМ БЕЗ activity      " +
                                  "   public Result doWork()  MyWork_Notifocations_Уведомления  внутри WORK MANAGER "
                                  + new Date() +
                                  " WorkManager Synchronizasiy_Data  " );

                          ///////todo  КОНЕЦ  код запуска уведомлений для чата




                          //TODO когда запускам уведомления чата  КОГДА НЕТ АКТИВИТИ И ПРОСТО ЗАПУСКАЕМ


                          //////////
                      } catch (Exception e) {
                      e.printStackTrace();
                      ///метод запись ошибок в таблицу
                      Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                              " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                      // TODO: 01.09.2021 метод вызова
                      new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                              this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                              Thread.currentThread().getStackTrace()[2].getLineNumber());

                      Log.e(Контекст.getClass().getName(), " Стоп СЛУЖБА Service_Notificatios_Уведомления_ОбновлениеПО  ДЛЯ ЧАТА " +
                              "MyWork_Notifocations_Уведомления_Общая ошибка  Exception e в классе MyWork_Notifocations_Уведомления_Общая " + e.toString() + "\n" +
                              " ФинальныйФлагЛюбогоЗапущеногоАктивти " + ФинальныйФлагЛюбогоЗапущеногоАктивти);
                      Log.e(getApplicationContext().getClass().getName(), " Ошибка  MyWork_Notifocations_Уведомления ЧАТ   public Result doWork()    ДЛЯ ЧАТА ");
                  }
    }


    // TODO: 17.11.2021










    private void МетодЗапускаСлужбыУведомленияДляЧата() {


        String ЛокальныйФлагУбратьУведомленияСлужбу=new String();

        // TODO: 15.11.2021


        try{

            Log.i(getApplicationContext().getClass().getName(), "Запуск метода МетодЗапускаСлужбыУведомления СЛУЖБА СЛУЖБАService_Notifications ДЛЯ ЧАТА ДЛЯ ЧАТА  "+new Date());

            try {
                ФоорматДат = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", new Locale("ru"));//"yyyy-MM-dd HH:mm:ss.SSS"//"yyyy-MM-dd'T'HH:mm:ss'Z'"
            } catch (Exception e) {
                e.printStackTrace();
                // TODO: 02.08.2021
                ФоорматДат = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru"));//"yyyy-MM-dd HH:mm:ss.SSS"//"yyyy-MM-dd'T'HH:mm:ss'Z'"
            }
            ФоорматДат.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));


// TODO: 01.04.2021 данное условие запускает соаздание уведомления с начала своего ниже код только реагирует на нажатие кнопки удалить уведомление и саму служюу отстановить кнопка ЗАКРЫТЬ






                    /////////TODO запуск нновую нотификашенс устанолвка
                    МетодЗарускаСозданиеУведомлений();




                    Log.d(getApplicationContext().getClass().getName(), " Запуск по Расписанию СЛУЖБА  Информирования  BroadcastReceiver или  FaceApp " + "  --" + new Date());




            // TODO: 06.04.2021 Определяем рабоает ли Служба КОД ПРОВЕРЯТЕТНЕ ЗАПУЩЕНАЛИ СЛУЖЬБА И ЕСЛИНЕ ЗАПУЩЕНА ТОНЕ НАДО ЕЕ УДАЛЯТЬ ИЗ ПАМЯТИ



            // TODO: 06.04.2021 ПРИНИМАЕМ РЕШЕНИЕ О ЗАКРЫТИЕ СЛУЖБЫ ЧЕРЕ З КНОПКУ







            ///////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ

            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

            notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияПлановая));
        }

    }


    /////////////////

    private void МетодЗарускаСозданиеУведомлений() {

        try{


            try{


                РезультатНужноЗапускатьУведомленияИлиНет=false;

                ///
                Log.d(getApplicationContext().getClass().getName(), " Внутри МетодЗарускаСозданиеУведомлений"
                        + "--" + РезультатНужноЗапускатьУведомленияИлиНет);/////


                // TODO: 17.11.2021  ВЫЧИСЛЯЕМ ВООБЩЕ ЕСТЬ СТРОЧКИ В ЧАТЕ НЕ ПРОЧИТАННЫЕ КОТОРЫЕ НАЖДО ПРОЧИТАТЬ -- ВЕРНЁТ TRUE


                РезультатНужноЗапускатьУведомленияИлиНет=МетодВычисляемСтоитСоздаватьИЗапускатьСлужбуНапоминаний();






                ///
                Log.d(getApplicationContext().getClass().getName(), " Внутри Future Результат НужноЗапускать Уведомления Или Нет  СЛУЖБА РезультатНужноЗапускатьУведомленияИлиНет"
                        + "--" + РезультатНужноЗапускатьУведомленияИлиНет);/////

                String ФлагПолучаемИзНутриПрограммы = null;//=// notificationIntentДляУведомлений .getStringExtra("Флаг");

                if(ФлагПолучаемИзНутриПрограммы==null){


                    ФлагПолучаемИзНутриПрограммы=new String();
                }


                ///
                Log.d(getApplicationContext().getClass().getName(), " Определили Результат НужноЗапускать Уведомления Или Нет  СЛУЖБА"
                        + "--" + РезультатНужноЗапускатьУведомленияИлиНет+  " ФлагПолучаемИзНутриПрограммы " +ФлагПолучаемИзНутриПрограммы+ "\n"
                        + "ОбщееКоличествоНЕпрочитанныхСтрок   "+ОбщееКоличествоНЕпрочитанныхСтрок);/////


// TODO: 17.11.2021  ЕСЛИ TRUE ТО НАЧИНАЕМ ЗАПУСКАЕМ УВЕДОМЛЕНИЯ



                if (РезультатНужноЗапускатьУведомленияИлиНет==true ) {


                    //////TODO МЕТОД КОТОРЫЙ ЗАПУСКАЕТ УВЕДОМЛЕНИЯ ПОСЛЕ АНАЛИЗА ДАТ


                    МетодКоторыйЗапускаетУвеломленияПослеАнализа(ИнтентДляЗапускаСлужбыПолсеАнализа, РезультатНужноЗапускатьУведомленияИлиНет, ФлагПолучаемИзНутриПрограммы);//  //ФлагКтоЗапустилСлужбу

                    Log.d(this.getClass().getName(), "ЗАПУСК ПОСЛЕ АНАЛИЗА ДАТ ЗАПУСКАЕМ УВЕДОМЛЕНИЯ  СЛУЖБА  Синхронизация   " + " ВРЕМЯ " + new Date()
                            + "\n" + " РезультатНужноЗапускатьУведомленияИлиНет " + РезультатНужноЗапускатьУведомленияИлиНет);








                }





                ///


                Log.d(getApplicationContext().getClass().getName(), " Определили Результат НужноЗапускать Уведомления Или Нет  СЛУЖБА"
                        + "--" + РезультатНужноЗапускатьУведомленияИлиНет+  " ФлагПолучаемИзНутриПрограммы " +ФлагПолучаемИзНутриПрограммы);/////


                ///////
            } catch (Exception e) {
                //  Block of code to handle errors
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());



                //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ

                NotificationManager notificationManager = (NotificationManager)
                        getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

                notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияПлановая));
            }







//
            Log.d(this.getClass().getName(), "AsyncРезультатНужноЗапускатьУведомленияИлиНет " );

 /*       //////TODO МЕТОД КОТОРЫЙ ЗАПУСКАЕТ УВЕДОМЛЕНИЯ ПОСЛЕ АНАЛИЗА ДАТ
            МетодКоторыйЗапускаетУвеломленияПослеАнализа(intent, РезультатНужноЗапускатьУведомленияИлиНет);*/


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();

            //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ

            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

            notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияПлановая));
            // /.cancelAll(); //   mNotificationManagerДляЧАТА.cancelAll();
            //   mNotificationManagerДляЧАТА=null;
            //  builder=null;
            Log.d(getApplicationContext().getClass().getName(), " Стоп СЛУЖБА СЛУЖБАService_Notifications  ДЛЯ ЧАТА onDestroy() Exception ");

        }



    }





    private void МетодКоторыйЗапускаетУвеломленияПослеАнализа(Intent intent, boolean результатНужноЗапускатьУведомленияИлиНет, String ФлагКтоЗапустилСлужбу) {
        ///TODO ЕСЛИ TRUE ТО ЗАПУСКАЕМ УВЕДОМЛЕНИЯ ТОЛЬКО КОГДА  TRUE


        Log.d(this.getClass().getName(), "Результат Нужно Запускать Уведомления Или Нет СЛУЖБА  true and false :: " +
                результатНужноЗапускатьУведомленияИлиНет);


        /////TODO ЗАПУСКАЕМ И СОЗДАЕМ СЕРВИС УВЕДОМЛЕНИЯ

        ///
        Log.d(getApplicationContext().getClass().getName(), " ФлагКтоЗапустилСлужбу " + ФлагКтоЗапустилСлужбу);





            МетодНотификайшенДЛяОбщейСлужбыУведомления(ФлагКтоЗапустилСлужбу);


        ///
        Log.d(getApplicationContext().getClass().getName(), " ФлагКтоЗапустилСлужбу " + ФлагКтоЗапустилСлужбу);



    }

/////////TODO запуск нновую нотификашенс устанолвка
























































    @SuppressLint("NotificationTrampoline")
    private void МетодНотификайшенДЛяОбщейСлужбыУведомления(String ФлагКтоЗапустилСлужбу) {
        try {

            Log.d(getApplicationContext().getClass().getName(), " Создание Уведомлеения СЛУЖБА СЛУЖБА Service_Notificatios_Уведомления_ОбновлениеПО ");


            builder=null;


            // TODO: 03.03.2022 определяем кода для отложеного запуска службы смены статсу условия задачи
            PendingIntent ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием =new SubClass_Starting_chahge_status_public_notificaton(getApplicationContext()).
                    МетодЗапускаСменыСтатусаСлужбыЧерезPendingIntent(PROCESS_ID_УведомленияПлановая,ИмяСлужбыУведомленияДляЧата,person.build().getUri());



            ///////TODO запускаем смены стануса задачи черезе PendingIntent
            Log.d(getApplicationContext().getClass().getName(), "PROCESS_ID_УведомленияПлановая "+PROCESS_ID_УведомленияПлановая +
                            " ИмяСлужбыУведомленияДляЧата " +ИмяСлужбыУведомленияДляЧата + " person.build().getUri() " +person.build().getUri());

/*
////TODO
            Intent notificationIntentДляУведомленийЗакрываем ;
            // TODO: 17.11.2021
            notificationIntentДляУведомленийЗакрываем = new Intent(getApplicationContext(), Service_Notificatios_Для_Чата.class);
            notificationIntentДляУведомленийЗакрываем.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //notificationIntentЗакрыть.addCategory(Intent.CATEGORY_LAUNCHER);
            uri = Uri.parse(PROCESS_ID_УведомленияПлановая);
            notificationIntentДляУведомленийЗакрываем.setType(ИмяСлужбыУведомленияДляЧата);
            notificationIntentДляУведомленийЗакрываем.addCategory(ИмяСлужбыУведомленияДляЧата);
            notificationIntentДляУведомленийЗакрываем.setData(uri);
            notificationIntentДляУведомленийЗакрываем.setAction("Закрываем");
            ///////
            PendingIntent ЗапускЗакрытия = null;



            if (notificationIntentДляУведомленийЗакрываем.resolveActivity(pm) != null) {
                ЗапускЗакрытия = PendingIntent.getService(getApplicationContext(),
                        11, notificationIntentДляУведомленийЗакрываем,
                        PendingIntent.FLAG_IMMUTABLE); //PendingIntent.FLAG_UPDATE_CURRENT
                // TODO: 17.11.2021
                Log.i(getApplicationContext().getClass().getName(), " Закрываем   СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" );
               // Service_Notificatios_Для_Чата.enqueueWork(getApplicationContext(),notificationIntentДляУведомленийЗакрываем);
            }
///TODO


            Intent notificationIntentДляУведомленийЗапускИзУведомления ;
            // TODO: 17.11.2021
            notificationIntentДляУведомленийЗапускИзУведомления = new Intent(getApplicationContext(), Service_Notificatios_Для_Чата.class);
            notificationIntentДляУведомленийЗапускИзУведомления.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //   notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
           // notificationIntentДляУведомленийЗапускИзУведомления.putExtra("PROCESS_ID_УведомленияПлановая",16);
            uri = Uri.parse(PROCESS_ID_УведомленияПлановая);
            notificationIntentДляУведомленийЗапускИзУведомления.setData(uri);
            notificationIntentДляУведомленийЗапускИзУведомления.setAction("ЗапускИзУведомления");
            ////////
            PendingIntent ЗапускИзУведомления = null;

            if (notificationIntentДляУведомленийЗапускИзУведомления.resolveActivity(pm) != null) {

                ЗапускИзУведомления = PendingIntent.getService(getApplicationContext(),
                       12, notificationIntentДляУведомленийЗапускИзУведомления,
                        PendingIntent.FLAG_IMMUTABLE); //PendingIntent.FLAG_UPDATE_CURRENT
                // TODO: 17.11.2021
              //  Service_Notificatios_Для_Чата.enqueueWork(getApplicationContext(),notificationIntentДляУведомленийЗапускИзУведомления);
            }



            Log.i(Контекст.getClass().getName(), "ЗАПУСК MyWork_Notifocations_Уведомления_Общая  СЛУЖБА     " +
                    "           Service_Notificatios_Для_Чата.enqueueWork(getApplicationContext(),intentСлужбаУведомленийДЛЯЧата);;");
*/






/*
            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

            StatusBarNotification[] statusBarNotifications= notificationManager.getActiveNotifications();

            for(StatusBarNotification statusBarNotification:statusBarNotifications){

                if(statusBarNotification.getId()!=12)

                    notificationManager.cancel(statusBarNotification.getId());
            }
*/


















            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);





            // TODO: 21.12.2021 В КОДЕ НИЖЕ МЫ ОПРЕДЕЛЯЕМ ЗАПУСКАТЬ НАМ КОД ИЛИ НЕТ

            Boolean СтатустУведомленияДляУведомленияЧАТА=false;


            StatusBarNotification[] statusBarNotificationУведомленияЧата=      notificationManager.getActiveNotifications();
            // TODO: 21.12.2021
            for(StatusBarNotification statusBarNotification1: statusBarNotificationУведомленияЧата) {

                // TODO: 21.12.2021

                if (statusBarNotification1.getId() == Integer.parseInt(PROCESS_ID_УведомленияПлановая)) {

                    // TODO: 21.12.2021
                    СтатустУведомленияДляУведомленияЧАТА = statusBarNotification1.isClearable();
                    // TODO: 21.12.2021

                    Log.d(this.getClass().getName(), " СтатустУведомленияДляУведомленияЧАТА" + СтатустУведомленияДляУведомленияЧАТА);


                }


            }


            Log.d(this.getClass().getName(), "СтатустУведомленияДляУведомленияЧАТА " +СтатустУведомленияДляУведомленияЧАТА+
                    " БуферСамиУведомленияЛинкСамиУведомления " +БуферСамиУведомленияЛинкСамиУведомления );


            // TODO: 21.11.2021 НЕПОСТРЕДСТВЕННО СОЗДАНИЕ УВЕДОМЛЕНИЯ ДЛЯ ЧАТА СОЗДАНИЕ И ЗАПОЛЕНИЕ


                if (БуферСамиУведомленияЛинкСамиУведомления!=null  && СтатустУведомленияДляУведомленияЧАТА==false ) {/// && СтатустУведомленияДляУведомленияЧАТА==false


                    Log.d(this.getClass().getName(), "bigText " +БуферСамиУведомленияЛинкСамиУведомления+ " БуферСамиУведомленияЛинкСамиУведомления.toString() "
                            +БуферСамиУведомленияЛинкСамиУведомления.toString()+"\n"+
                            "ЗАПУСК......НОВОЕ СООБЩЕНИЕ   bigText " +БуферСамиУведомленияЛинкСамиУведомления+"\n"+
                            "  время ::" + new Date());




                    //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ


                    notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияПлановая));


                    ///notificationManager.cancelAll();



                    onStopped();


                    Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        v2.vibrate(VibrationEffect.createOneShot(600, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        v2.vibrate(600);
                    }



// TODO: 21.11.2021  само созданеи уведомления

       /*             Drawable icon = null;
                    icon = getResources().getDrawable(R.drawable.icon_dsu1_for_fragment1_chat2);
                    icon.setBounds(10, 0, 90, 85);*/


         /*           // TODO: 03.02.2022  УВЕДОМЛЕНИЯ ДЛЯ ОБШЕЙ СИНХРОНИАЗЦИИ
                    NotificationCompat.MessagingStyle.Message messagingStyleДля_ОбщихУведомлений =
                            new NotificationCompat.MessagingStyle.Message("Всем привет!", System.currentTimeMillis(), "Ivan");*/

               /*     NotificationCompat.MessagingStyle.Message messagingStyle2 =
                            new NotificationCompat.MessagingStyle.Message("  zЯЯЯ  Всем привет!", System.currentTimeMillis(), (Person) null);*/





                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        ///"@mipmap/icon_main_tabel_four" ////.setSmallIcon(R.drawable.ic_notifications_black_24dp)
                        builder = new NotificationCompat.Builder(getApplicationContext(), PROCESS_ID_УведомленияПлановая)
                                /////
                                .setContentText(БуферСамиУведомленияЛинкСамиУведомления.toString())                 // .setContentText("http://developer.alexanderklimov.ru/android/")
                                .setSmallIcon(R.drawable.ic_notifications_black_24dp)////builder.setSmallIcon(R.drawable.ic_launcher_background);//R.mipmap.ic_launcher   ///R.drawable.ic_notifications_black_24dp
                                .setPriority(NotificationCompat.PRIORITY_MAX)
                                .setColor(Color.parseColor("#00ACC1"))
                                //.setContentTitle("Задание на выполнение")
                                .setSmallIcon(R.drawable.icon_dsu1_for_fragment1_chat2)
                                .setGroup("SousAndroid")
                                .setLargeIcon(BitmapFactory.decodeResource(Контекст.getResources(),
                                        R.drawable.ic_notifications_black_24dp)) // большая картинка
                                //.setTicker("Последнее китайское предупреждение!") // до Lollipop
                                .setVibrate(new long[]{0, 250, 100, 250})
                                .setShowWhen(true)
                                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                                .setCategory(Notification.CATEGORY_MESSAGE)
                                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE | Notification.FLAG_AUTO_CANCEL)
                                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                                .setStyle(new NotificationCompat.BigTextStyle().bigText(БуферСамиУведомленияЛинкСамиУведомления
                                .toString()) ).setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)
                                .setStyle(messagingStyleДля_ОбщихУведомлений).setColor(Color.parseColor(("#FAEBD"+new Random().nextInt(1))))
                                .setGroupSummary(true)
                                .setColor(Color.GREEN)
                                .addAction(android.R.drawable.ic_delete, "Ознакомлен/на", ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием)
                                .setAutoCancel(false)
                                .setWhen(System.currentTimeMillis()) // автоматически закрыть уведомление после нажатия////.setStyle(new NotificationCompat.BigTextStyle().bigText(bigText) ).setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                               ;// .setContentIntent(ЗапускИзУведомления)
                        ////TODO три кнопки действия PUSH-сообщений
                        /// .setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL)


                    } else {
                        builder =
                                new NotificationCompat.Builder(getApplicationContext(), PROCESS_ID_УведомленияПлановая)
                                        //
                                        .setContentText(БуферСамиУведомленияЛинкСамиУведомления.toString())                 // .setContentText("http://developer.alexanderklimov.ru/android/")
                                        .setSmallIcon(R.drawable.ic_notifications_black_24dp)////builder.setSmallIcon(R.drawable.ic_launcher_background);//R.mipmap.ic_launcher   ///R.drawable.ic_notifications_black_24dp
                                        .setPriority(NotificationCompat.PRIORITY_MAX)
                                        .setColor(Color.parseColor("#00ACC1"))
                                      //  .setContentTitle("Задание на выполнение")
                                        .setSmallIcon(R.drawable.icon_dsu1_for_fragment1_chat2)
                                        .setLargeIcon(BitmapFactory.decodeResource(Контекст.getResources(),
                                                R.drawable.ic_notifications_black_24dp)) // большая картинка
                                        //.setTicker("Последнее китайское предупреждение!") // до Lollipop
                                        .setVibrate(new long[]{0, 250, 100, 250})
                                        .setShowWhen(true)
                                        .setGroup("SousAndroid")
                                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                                        .setCategory(Notification.CATEGORY_MESSAGE)
                                        .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE | Notification.FLAG_AUTO_CANCEL)
                                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                                       /* .setStyle(new NotificationCompat.BigTextStyle().bigText(БуферСамиУведомленияЛинкСамиУведомления.toString())
                                        ).setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)*/
                                        .setStyle(messagingStyleДля_ОбщихУведомлений).setColor(Color.parseColor(("#FAEBD"+new Random().nextInt(1))))
                                        .setGroupSummary(true)
                                        .setColor(Color.GREEN)
                                        .addAction(android.R.drawable.ic_delete, "Ознакомлен/на", ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием)
                                        .setAutoCancel(false)
                                        .setWhen(System.currentTimeMillis()) // автоматически закрыть уведомление после нажатия////.setStyle(new NotificationCompat.BigTextStyle().bigText(bigText) ).setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                          ;//              .setContentIntent(ЗапускИзУведомления)

                        // автоматически закрыть уведомление после нажатия
                        // .setContentIntent(ЗапускЗакрытия);
                        ////TODO три кнопки действия PUSH-сообщений



                    }



            // TODO: 27.11.2021 САМ ЗАПУСК УВЕДОМЛЕНИЯ

            mNotificationManagerДляЧАТА = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

            // TODO: 17.11.2021  start
            // === Removed some obsoletes
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(
                        PROCESS_ID_УведомленияПлановая,
                        "Channel human readable title",
                        NotificationManager.IMPORTANCE_HIGH);
                mNotificationManagerДляЧАТА.createNotificationChannel(channel);
                builder.setChannelId(String.valueOf(PROCESS_ID_УведомленияПлановая));
                channel.setDescription("Увеомление для версии выше API 25");
                // TODO: 18.11.2021  дополнительые настройки

                builder.build().flags  |= Notification.FLAG_FOREGROUND_SERVICE;
                ///TODO Запускаем увидомления
                builder.build().flags  |= Notification.FLAG_AUTO_CANCEL;
                // startForeground(Integer.parseInt(PROCESS_ID_УведомленияПлановая),builder.build());//builder.build()
                ///TODO Запускаем увидомления
                builder.build().flags  |= Notification.FLAG_SHOW_LIGHTS;
                ///TODO Запускаем увидомления
                builder.build().flags  |= Notification.FLAG_INSISTENT;
                // TODO: 02.12.2021
                builder.setNumber(1);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    mNotificationManagerДляЧАТА.getBubblePreference();
                }

                ///TODO Запускаем увидомления
                // TODO: 02.12.2021  сам запуск уведомления
                mNotificationManagerДляЧАТА.notify(Integer.parseInt(PROCESS_ID_УведомленияПлановая), builder.build());////   mNotificationManagerДляЧАТА.notify(Integer.parseInt(PROCESS_ID_УведомленияПлановая), builder.build());
                ///TODO закрытие увидомления
                //mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();

   /*             Log.i(this.getClass().getName(), "ЗАПУСК СЛУЖБА  УВЕДОМЛЕНИЯ ДЛЯ ЧАТА САМО ПОЯВЛЕНИЕ  ВАРИАНТ -1  startForeground(Integer.parseInt(PROCESS_ID_УведомленияПлановая),builder.build());//builder.build()" + new Date()
                        + "\n" + " PROCESS_ID_УведомленияПлановая " + PROCESS_ID_УведомленияПлановая+"\n"
                        +  "  САМИ СООБЩЕНИЯ : "+БуферСамиУведомленияЛинкСамиУведомления.toString());
*/



              //    startForeground(Integer.parseInt(PROCESS_ID_УведомленияПлановая),builder.build());//builder.build()

            }else{
                ///TODO Запускаем увидомления

                // TODO: 27.11.2021 САМ ЗАПУСК УВЕДОМЛЕНИЯ

                //mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                builder.build().flags  |= Notification.FLAG_FOREGROUND_SERVICE;
                ///TODO Запускаем увидомления
                ///TODO Запускаем увидомления
                builder.build().flags  |= Notification.FLAG_AUTO_CANCEL;
                ///TODO Запускаем увидомления
                builder.build().flags  |= Notification.FLAG_SHOW_LIGHTS;
                ///TODO Запускаем увидомления
                builder.build().flags  |= Notification.FLAG_INSISTENT;
                // TODO: 02.12.2021
                builder.setNumber(1);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    mNotificationManagerДляЧАТА.getBubblePreference();
                }

                // TODO: 02.12.2021  сам запуск уведомления

                mNotificationManagerДляЧАТА.notify(Integer.parseInt(PROCESS_ID_УведомленияПлановая), builder.build());////   mNotificationManagerДляЧАТА.notify(Integer.parseInt(PROCESS_ID_УведомленияПлановая), builder.build());
                ///TODO закрытие увидомления

           //     startForeground(Integer.parseInt(PROCESS_ID_УведомленияПлановая),builder.build());//builder.build()
/*

                Log.i(this.getClass().getName(), "ЗАПУСК СЛУЖБА  УВЕДОМЛЕНИЯ ДЛЯ ЧАТА САМО ПОЯВЛЕНИЕ  ВАРИАНТ -2  startForeground(Integer.parseInt(PROCESS_ID_УведомленияПлановая),builder.build());/" + new Date()
                        + "\n" + " PROCESS_ID_УведомленияПлановая " + PROCESS_ID_УведомленияПлановая+"\n"
                        +  "  САМИ СООБЩЕНИЯ : "+БуферСамиУведомленияЛинкСамиУведомления.toString());*/
            }
            /// startForeground(Integer.parseInt(PROCESS_ID_УведомленияПлановая),builder.build());//builder.build()


                }else{
                    Log.i(this.getClass().getName(), " ОБЩЕЕ УВЕДОМЛЕНИЯ НЕТ ДАГЫХ ЧТО ЗАПОЛНИТЬ УСЛОВИЯ ПУСТОЙ СЛУЖБЫ БуферСамиУведомленияЛинкСамиУведомления  " +БуферСамиУведомленияЛинкСамиУведомления.toString());
                }


            //////

            // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления
            WorkInfo ИнформацияОЗапущенойСлужбе= WorkManager.getInstance(Контекст.getApplicationContext()).getWorkInfosByTag(ИмяСлужбыУведомленияДляЧата).get().get(0);

            Log.w(Контекст.getClass().getName(), " ПОСЛЕ ОТРАБОТКИ МЕТОДА ....Внутри метода public Result doWork() BroadcastReceiver_Sous_Notificatioons  " +ИмяСлужбыУведомленияДляЧата +"\n"
                    + " getState  "+
                    ИнформацияОЗапущенойСлужбе.getState().name()+"\n"+
                    " isFinished  " +
                    ИнформацияОЗапущенойСлужбе.getState().isFinished() + "\n" +
                    "getTags "+
                    ИнформацияОЗапущенойСлужбе.getTags()+"\n"+
                    "getRunAttemptCount "+
                    ИнформацияОЗапущенойСлужбе.getRunAttemptCount()+"\n"+
                    "getProgress "+
                    ИнформацияОЗапущенойСлужбе.getState().isFinished()+"\n"+
                    " время : " +new Date());




        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();

            //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ

            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

            notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияПлановая));


            // /.cancelAll(); //   mNotificationManagerДляЧАТА.cancelAll();
            //   mNotificationManagerДляЧАТА=null;
            //  builder=null;
            Log.d(getApplicationContext().getClass().getName(), " Стоп СЛУЖБА СЛУЖБАService_Notifications ДЛЯ ЧАТА  onDestroy() Exception ");

        }







    }




    ///TODO метод определяем стоит запускать и создвать службу напоминаний или нет

    private boolean МетодВычисляемСтоитСоздаватьИЗапускатьСлужбуНапоминаний() {
        // final boolean[] РезультатВнутриЗапускатьУведомленияИлиНет = {false};
        try {



            ////

            Log.d(this.getClass().getName(), "  СЛУЖБА..... ДЛЯ проверяем нужно ли создвать и запускать службу нпоминаний работа с датами");

            /////todo если не изместен локальная версия являеться null перед проверкой то еще раз применяем выясняем локальную версиюПО для проверки

            long РезультатОбновлениеЛокальнойВерсииПО = 0;
            /////////
            /////TODO когда локальное ПО версию не нашли вытаемся ее увидить в базе

            int ПолучениеПравДляТаблицыПрава=0;

            Integer ПубличноеIDПолученныйИзСервлетаДляUUID=0;

            // TODO: 26.05.2021  перед обработкой уведомлений функция удаления Уведомлениц Сообщений не относящиеся к Пользователю
            ///
            Class_GRUD_SQL_Operations   class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете=new Class_GRUD_SQL_Operations(getApplicationContext());
            // TODO: 03.11.2021
            PUBLIC_CONTENT public_contentменеджер=new PUBLIC_CONTENT(getApplicationContext());

            ///
            class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","SuccessLogin");
            ///////
            class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","id");
            //

            ////
            class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");



            ////
            SQLiteCursor Курсор_ВычисляемПУбличныйID=null;
            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

            Курсор_ВычисляемПУбличныйID= (SQLiteCursor)
                    class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете.
                    new GetData(getApplicationContext()).getdata(class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,public_contentменеджер.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу() );

            Log.d(this.getClass().getName(), "GetData "+Курсор_ВычисляемПУбличныйID  );


            /////
            if (Курсор_ВычисляемПУбличныйID.getCount() > 0) {
                //////////
                Курсор_ВычисляемПУбличныйID.moveToFirst();

                ПубличноеIDПолученныйИзСервлетаДляUUID=Курсор_ВычисляемПУбличныйID.getInt(0);

                // TODO: 03.11.2021



                Log.w(this.getClass().getName(), "  ПубличноеIDПолученныйИзСервлетаДляUUID " + ПубличноеIDПолученныйИзСервлетаДляUUID);


            }

            // TODO: 02.03.2022

            if(ПубличноеIDПолученныйИзСервлетаДляUUID==null){
                // TODO: 02.03.2022
                ПубличноеIDПолученныйИзСервлетаДляUUID=0;

            }





            // TODO: 26.05.2021 данные по высичлению ID



            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

            ///
            class_grud_sql_operationsIDпользоввателяДляСлужб=new Class_GRUD_SQL_Operations(getApplicationContext());

            ///
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","view_tasks");//old для другой уведомления data_chat
            ///////
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","*");
            //
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","status_write=?  AND id_user=? " +
                    " AND message IS NOT NULL  ");
            ///"_id > ?   AND _id< ?"


            //////
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",0);
            //
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2",  ПубличноеIDПолученныйИзСервлетаДляUUID);


            // TODO: 02.03.2022

            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC");
            ////
          // class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
            ///
            SQLiteCursor   Курсор_ДляСлужбыУведомлений_ТолькоДляЧата=null;


            Курсор_ДляСлужбыУведомлений_ТолькоДляЧата= (SQLiteCursor)  class_grud_sql_operationsIDпользоввателяДляСлужб.
                    new GetData(getApplicationContext()).getdata(class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу() );


            ////////

            Log.d(this.getClass().getName(), "Курсор_ДляСлужбыУведомлений_ТолькоДляЧата "  +Курсор_ДляСлужбыУведомлений_ТолькоДляЧата);





            // TODO: 26.05.2021 данные по высичлению ID

            SQLiteCursor Курсор_ДляСлужбыУведомлений_ТолькоДляЧатаТОлькоКоличествоЗадач = МетодПолучениеТОлЬКоКурсораДЛяПолучнеиеКоличетсовЗадач(ПубличноеIDПолученныйИзСервлетаДляUUID);



            ////////

            Log.d(this.getClass().getName(), "Курсор_ДляСлужбыУведомлений_ТолькоДляЧатаТОлькоКоличествоЗадач "  +Курсор_ДляСлужбыУведомлений_ТолькоДляЧатаТОлькоКоличествоЗадач);




/*
            // TODO: 09.09.2021   ____old
             Курсор_IDпользоввателяДляСлужб=
                                    CREATE_DATABASE.ССылкаНаСозданнуюБазу.rawQuery("SELECT *  From notification", null);

*/


            ОбщееКоличествоНЕпрочитанныхСтрок=0;


            // TODO: 09.09.2021  resltat

            if ( Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getCount()>0) {
                //////

                Log.d(this.getClass().getName(), "Курсор_ДляСлужбыУведомлений_ТолькоДляЧат количествро сттрочек  :::  "
                        +Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getCount());


                Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.moveToFirst();
                // TODO: 02.03.2022

                Курсор_ДляСлужбыУведомлений_ТолькоДляЧатаТОлькоКоличествоЗадач.moveToFirst();


                РезультатНужноЗапускатьУведомленияИлиНет=true;

                ОбщееКоличествоНЕпрочитанныхСтрок=       Курсор_ДляСлужбыУведомлений_ТолькоДляЧатаТОлькоКоличествоЗадач.getCount();

                Log.w(this.getClass().getName(), "  ОбщееКоличествоНЕпрочитанныхСтрок  " +ОбщееКоличествоНЕпрочитанныхСтрок);
                // TODO: 19.11.2021


                // TODO: 19.11.2021
                if(ОбщееКоличествоНЕпрочитанныхСтрок>=1){
                    // TODO: 19.11.2021
                    ОбщееКоличествоНЕпрочитанныхСтрок=ОбщееКоличествоНЕпрочитанныхСтрок-1;
                    // TODO: 19.11.2021

                    Log.w(this.getClass().getName(), "  ОбщееКоличествоНЕпрочитанныхСтрок  " +ОбщееКоличествоНЕпрочитанныхСтрок);
                }


                // TODO: 20.05.2021  продолжение уведомления определяем даты после того как получили права на сотрудника

                МетодПолучениеДатыПослеПолучениеПравСотрудникаДля_ОбщихУведомления(Курсор_ДляСлужбыУведомлений_ТолькоДляЧата);




            } else {
                Log.w(this.getClass().getName(), "  СЛУЖБА...  НЕТ СООБЩЕНИ ДЛЯ ОТОБРАЖЕНИЯ В ЧАТЕ НЕТ ПРОПУСКАЕМ ХОЛОСТОЙ ХОД СЛУЖБЫ УВЕДОМЛЕНИЯ ЧАТ " +ПолучениеПравДляТаблицыПрава);

                // TODO: 15.11.2021
                РезультатНужноЗапускатьУведомленияИлиНет=false;

            }




        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ

         /*   NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

            notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияПлановая))*/;
        }

        // TODO: 20.05.2021  результат
        return РезультатНужноЗапускатьУведомленияИлиНет ;
    }


    // TODO: 02.03.2022

    private SQLiteCursor МетодПолучениеТОлЬКоКурсораДЛяПолучнеиеКоличетсовЗадач(Integer ПубличноеIDПолученныйИзСервлетаДляUUID) throws ExecutionException, InterruptedException {
        // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

        SQLiteCursor   Курсор_ДляСлужбыУведомлений_ТолькоДляЧатаТОлькоКоличествоЗадач=null;
     try{
        ///
        class_grud_sql_operationsIDпользоввателяДляСлужб=new Class_GRUD_SQL_Operations(getApplicationContext());

        ///
        class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","view_tasks");//old для другой уведомления data_chat
        ///////
        class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","*");
        //
        class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","status_write=?  AND id_user=? " +
                " AND message IS NOT NULL  ");
        ///"_id > ?   AND _id< ?"


        //////
        class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",0);
        //
        class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2", ПубличноеIDПолученныйИзСервлетаДляUUID);


        // TODO: 02.03.2022

        class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC");
        ////
        // class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
        ////
        //class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
        // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
        ///



        Курсор_ДляСлужбыУведомлений_ТолькоДляЧатаТОлькоКоличествоЗадач= (SQLiteCursor)  class_grud_sql_operationsIDпользоввателяДляСлужб.
                new GetData(getApplicationContext()).getdata(class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу() );


        ////////

        Log.d(this.getClass().getName(), "Курсор_ДляСлужбыУведомлений_ТолькоДляЧатаТОлькоКоличествоЗадач "  +Курсор_ДляСлужбыУведомлений_ТолькоДляЧатаТОлькоКоличествоЗадач);


    } catch (Exception e)

    {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
    }


        return Курсор_ДляСлужбыУведомлений_ТолькоДляЧатаТОлькоКоличествоЗадач;
    }


    // TODO: 20.05.2021  продолжение уведомления определяем даты после того как получили права на сотрудника



    private void МетодПолучениеДатыПослеПолучениеПравСотрудникаДля_ОбщихУведомления(SQLiteCursor  Курсор_ДляСлужбыУведомлений_ТолькоДляЧата) throws ParseException {
        // TODO: 20.05.2021 действие вьторое

        try{

            Log.d(this.getClass().getName(), "   Курсор_ДляСлужбыУведомлений_ТолькоДляЧата "+Курсор_ДляСлужбыУведомлений_ТолькоДляЧата);


            ////TODO start do


            do {
                ////

                //TODO перед созданеим

                БуферСамиУведомленияЛинкСамиУведомления=new ArrayList();

                // TODO: 03.02.2022
                person=new Person.Builder();


                /////
                /////
                Integer ИндексКтоНаписалСообщениеID  = Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getColumnIndex("user_update");///id_user
                /////
                Integer КтоНаписалСообщениеID  = Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getInt(ИндексКтоНаписалСообщениеID);
                //
                String КтоНаписалСообщениеФИО=new String();

                Log.d(this.getClass().getName(), "КтоНаписалСообщениеID " + КтоНаписалСообщениеID);

                // TODO: 07.02.2022 вытаскием текущий uuid для того чтобы далее установить сатутсс о ознакомлен

                /////
                Integer ИндексКтоНаписалСообщениеUUID  = Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getColumnIndex("uuid");///id_user
                /////
                Long КтоНаписалСообщениеUUID  = Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getLong(ИндексКтоНаписалСообщениеUUID);

                Log.d(this.getClass().getName(), "КтоНаписалСообщениеUUID " + КтоНаписалСообщениеUUID);

                // TODO: 16.11.2021 find FIO
                ///
                class_grud_sql_operationsIDпользоввателяДляСлужб=new Class_GRUD_SQL_Operations(getApplicationContext());

                ///
                class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","chat_users");
                ///////
                class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","name");
                //
                class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","_id=?   AND name IS NOT NULL ");
                ///"_id > ?   AND _id< ?"
                //////
                class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",КтоНаписалСообщениеID);

    /*            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC");
                ////
                class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","5");*/

                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
                ///
                SQLiteCursor   Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал=null;


                Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал= (SQLiteCursor)  class_grud_sql_operationsIDпользоввателяДляСлужб.
                        new GetData(getApplicationContext()).getdata(class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу() );


                ////////

                Log.d(this.getClass().getName(), "Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал "  +Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал);

                if (Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал.getCount()>0) {
                    //TODO

                    Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал.moveToFirst();
                    КтоНаписалСообщениеФИО=      Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал.getString(0).trim();

                  //  КтоНаписалСообщениеФИО=      Курсор_ДляСлужбыУведомлений_ВычисляемНстоящееФИОКтоНаписал.getString(0).trim();
                }

                ////////

                Log.d(this.getClass().getName(), "КтоНаписалСообщениеФИО "  +КтоНаписалСообщениеФИО);









                // TODO: 15.11.2021
                Integer ИНдексПРочитаногоСообщенияUUID= Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getColumnIndex("uuid");

                Long UUIDРочитаногоЗаданиеДляКотрогоДалееБудетПроизведенаСменаСтсусаНАОзнакомленный= Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getLong(ИНдексПРочитаногоСообщенияUUID);


                Log.d(this.getClass().getName(), "UUIDРочитаногоЗаданиеДляКотрогоДалееБудетПроизведенаСменаСтсусаНАОзнакомленный "  +UUIDРочитаногоЗаданиеДляКотрогоДалееБудетПроизведенаСменаСтсусаНАОзнакомленный);





              Integer ИНдексПРочитаногоСообщения = Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getColumnIndex("date_update");//TODO OLD date_start

                String ВремНеПРочитаногоСообщения= Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getString(ИНдексПРочитаногоСообщения);


                Log.d(this.getClass().getName(), " ВремНеПРочитаногоСообщения  " + ВремНеПРочитаногоСообщения);
                // TODO: 15.11.2021

                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", new Locale("ru"));//yyyy-MM-dd HH:mm:ss.SSS  ///TODO yyyy-MM-dd HH:mm
                //

                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));

                Date date = null;
                date = simpleDateFormat.parse(ВремНеПРочитаногоСообщения);

                simpleDateFormat.applyPattern(" dd EEEE yyyy HH:mm");//dd-MM-yyyy  // EEEE yyyy HH:mm"

                String ФиналВремНеПРочитаногоСообщения = simpleDateFormat.format(date);

                Log.d(this.getClass().getName(), "ФиналВремНеПРочитаногоСообщения " + ФиналВремНеПРочитаногоСообщения+"\n");

                ///TODO заполенения ДАННЫХ УВЕДОМЛЕНИЯ ОДНОРАЗОВАГО ДЛЯ ЧАТА
                // TODO: 03.02.2022

      /*          // TODO: 03.02.2022
                БуферСамиУведомленияЛинкСлужебнаИнформация.add("\n"+"автор:"+КтоНаписалСообщениеФИО);
                // TODO: 03.02.2022
                // TODO: 03.02.2022
                БуферСамиУведомленияЛинкСлужебнаИнформация.add("количество сообщений: +("+ОбщееКоличествоНЕпрочитанныхСтрок+")");*/
                // TODO: 03.02.2022
                //////todoСамиУведомленияВЧатеНеПрочитанный.matches("[а-яА-Я]")///[m-nM-N]

                // TODO: 04.02.2022
                // TODO: 15.11.2021
                Integer ИндексСтатусПрочтенияПриВыданнйоЗадании=   Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getColumnIndex("status_write");

               Integer СамСтатусПрочтенияПриВыданнйоЗадании= Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getInt(ИндексСтатусПрочтенияПриВыданнйоЗадании);



                Log.d(this.getClass().getName(), " СамСтатусПрочтенияПриВыданнйоЗадании  " + СамСтатусПрочтенияПриВыданнйоЗадании);



                // TODO: 15.11.2021
                Integer ИндексЗаданияID=   Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getColumnIndex("id");


                Integer СамСтатусIDЗадание=0;

                 СамСтатусIDЗадание= Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getInt(ИндексЗаданияID);



                Log.d(this.getClass().getName(), " СамСтатусIDЗадание  " + СамСтатусIDЗадание);





                String СтатусДошлоПользователюЗадача;

                // TODO: 04.02.2022
                if (СамСтатусПрочтенияПриВыданнйоЗадании==0) {

                    СтатусДошлоПользователюЗадача="доставлено";

                    Log.d(this.getClass().getName(), " СамСтатусПрочтенияПриВыданнйоЗадании  " + СамСтатусПрочтенияПриВыданнйоЗадании);
                } else {
                    СтатусДошлоПользователюЗадача="уже отработано";

                    Log.d(this.getClass().getName(), " СамСтатусПрочтенияПриВыданнйоЗадании  " + СамСтатусПрочтенияПриВыданнйоЗадании);
                }


                // TODO: 16.11.2021  само сообщение

                // TODO: 15.11.2021
                Integer ИндексСамогоЗадании=   Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getColumnIndex("message");
                /////
                String СамиУведомленияВЧатеНеПрочитанный = Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getString(ИндексСамогоЗадании).trim();


                Log.d(this.getClass().getName(), " СамиУведомленияВЧатеНеПрочитанный  " + СамиУведомленияВЧатеНеПрочитанный+
                        " СамСтатусIDЗадание " +СамСтатусIDЗадание);






                БуферСамиУведомленияЛинкСамиУведомления.add("Задание"+"#"+СамСтатусIDЗадание+"\n"
                        +СамиУведомленияВЧатеНеПрочитанный +"\n"+
                        "создано :("+ФиналВремНеПРочитаногоСообщения+")");

                // TODO: 02.03.2022




                МетодПослеЗапоелнияВЦиклеЗадачЗаполянем(КтоНаписалСообщениеФИО, UUIDРочитаногоЗаданиеДляКотрогоДалееБудетПроизведенаСменаСтсусаНАОзнакомленный);

                Log.d(this.getClass().getName(), " БуферСамиУведомленияЛинкСамиУведомления  " + БуферСамиУведомленияЛинкСамиУведомления.toString());



                // TODO: 19.11.2021  после обработки одно записи выходим
                //todo while
            } while (Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.moveToNext());







            // TODO: 19.11.2021 после обработки добавляем

            // БуферСамиУведомленияЛинкСамиУведомления.append(" +").append("(").append(ОбщееКоличествоНЕпрочитанныхСтрок) .append(")").append(" сообщений.") ;
            // TODO: 19.11.2021
            Log.d(this.getClass().getName(), "СамиУведомления " + БуферСамиУведомленияЛинкСамиУведомления.toString() +
                    " БуферСамиУведомленияЛинкСамиУведомления " + БуферСамиУведомленияЛинкСамиУведомления.size()+
                    "   БуферСамиУведомленияЛинкСамиУведомления " + БуферСамиУведомленияЛинкСамиУведомления.size());


            ////TODO закрываем курсор

            if (Курсор_ДляСлужбыУведомлений_ТолькоДляЧата!=null) {

                if (!Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.isClosed()) {

                    Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.close();
                }
            }


            // TODO: 19.05.2021  ошибки
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ

            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

            notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияПлановая));
        }




    }

    private void МетодПослеЗапоелнияВЦиклеЗадачЗаполянем(String КтоНаписалСообщениеФИО,
                                                         Long UUIDРочитаногоЗаданиеДляКотрогоДалееБудетПроизведенаСменаСтсусаНАОзнакомленный) {

        // TODO: 02.03.2022


        try{
            Log.d(this.getClass().getName(),"   onOpen БАЗА  ДАННЫХ   ДСУ-1 настройки базы КтоНаписалСообщениеФИО "+КтоНаписалСообщениеФИО+
                    " UUIDРочитаногоЗаданиеДляКотрогоДалееБудетПроизведенаСменаСтсусаНАОзнакомленный "+UUIDРочитаногоЗаданиеДляКотрогоДалееБудетПроизведенаСменаСтсусаНАОзнакомленный);
            // TODO: 02.03.2022

        String СамиУведомленияВЧатеНеПрочитанный;
        // TODO: 04.02.2022

        СамиУведомленияВЧатеНеПрочитанный=null;

        СамиУведомленияВЧатеНеПрочитанный=БуферСамиУведомленияЛинкСамиУведомления.toString().replace("[","");

        СамиУведомленияВЧатеНеПрочитанный=СамиУведомленияВЧатеНеПрочитанный.replace("]","");


        // TODO: 07.02.2022 заполения сообщения для ОБШЕЙ УВЕДОМЛЕНИЯ

        // TODO: 07.02.2022
        person.setKey(СамиУведомленияВЧатеНеПрочитанный);
        // TODO: 07.02.2022
        person.setBot(true);

        person.setName(КтоНаписалСообщениеФИО);
        // TODO: 07.02.2022 \
        // person.setIcon( IconCompat.createWithResource(Контекст, R.drawable.icon_dsu1_for_fragment1_chat2));
        // TODO: 07.02.2022

        person.setIcon( IconCompat.createWithResource(Контекст, R.drawable.icon_dsu1_for_fragment1_chat2_for_public));

        // TODO: 07.02.2022устанавливаем записываем текущий UUID для того чтобы потом перердатьего для Озванкомления

        HashMap<Integer,Long> hashMapХэшДляЗапоминиялUUID=new HashMap();
        // TODO: 07.02.2022
        hashMapХэшДляЗапоминиялUUID.put(new Random().nextInt(), UUIDРочитаногоЗаданиеДляКотрогоДалееБудетПроизведенаСменаСтсусаНАОзнакомленный)      ;

        person .setUri(String.valueOf(hashMapХэшДляЗапоминиялUUID));
        // TODO: 07.02.2022  person
        person.build();


        // TODO: 03.02.2022  УВЕДОМЛЕНИЯ ДЛЯ ОБШЕЙ СИНХРОНИАЗЦИИ
        messagingStyleДля_ОбщихУведомлений.addMessage(person.build().getKey(), System.currentTimeMillis(), "от:"+ person.build().getName()
                +" +" +
                "("+ОбщееКоличествоНЕпрочитанныхСтрок+")");


        Log.d(this.getClass().getName(), "СамиУведомленияВЧатеНеПрочитанный "
                + СамиУведомленияВЧатеНеПрочитанный +" БуферСамиУведомленияЛинкСамиУведомления.size() "
                +БуферСамиУведомленияЛинкСамиУведомления.size()+ " messagingStyleДля_ОбщихУведомлений " +messagingStyleДля_ОбщихУведомлений+ "  СамиУведомленияВЧатеНеПрочитанный " +СамиУведомленияВЧатеНеПрочитанный);




    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

    }
    }


    // TODO: 17.11.2021  end classs worl manager

    }






























