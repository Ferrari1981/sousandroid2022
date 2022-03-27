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
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteCursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.jetbrains.annotations.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class MyWork_Notifocations_Уведомления_Для_Чата extends Worker {
    ///
    Context Контекст;
    String ИмяСлужбыУведомленияДляЧатаОдноразовая = "WorkManager NOtofocationForChat DISTOY";


    WorkerParameters workerParams;

    NotificationManager mNotificationManagerДляЧАТА = null;

    WorkInfo ИнформацияОЗапущенойСлужбе_Уведомления_ДляЧатаОдноразовое;





    Integer ОбщееКоличествоНЕпрочитанныхСтрок=0;
    ////TODO
    NotificationCompat.Builder builderДляОдноразвойСлужбыУведомления=null;
    //// Notification notificationAfterBuild=null;

    //TODO

    CREATE_DATABASE Create_Database_СсылкаНАБазовыйКласс;

    Class_GRUD_SQL_Operations       class_grud_sql_operationsIDпользоввателяДляСлужб;

    SimpleDateFormat ФоорматДат ;








    ArrayList БуферСамиУведомленияЛинкСамиУведомления;

    int     ID_ТаблицаУвендомлений;


    Intent ИнтентДляЗапускаСлужбыПолсеАнализа;

    Boolean РезультатНужноЗапускатьУведомленияИлиНет=false;
    ////////
    private String PROCESS_ID_УведомленияОдноразовые="16";

    // TODO: 12.10.2021  Ссылка Менеджер Потоков

    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =null;



    // TODO: 03.02.2022  УВЕДОМЛЕНИЯ ДЛЯ ОБШЕЙ СИНХРОНИАЗЦИИ
    NotificationCompat.MessagingStyle messagingStyleДляОдноразовыеУведомления;


    public MyWork_Notifocations_Уведомления_Для_Чата(@NonNull Context context, @NonNull WorkerParameters workerParamsвнутри) {
        super(context, workerParamsвнутри);


        Контекст = context;

        workerParams = workerParamsвнутри;

        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = new PUBLIC_CONTENT(Контекст);
        ////
        class_grud_sql_operationsIDпользоввателяДляСлужб = new Class_GRUD_SQL_Operations(Контекст);
        //TODO

        Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(Контекст);


        messagingStyleДляОдноразовыеУведомления= new NotificationCompat.MessagingStyle(getApplicationContext().getResources().getString(R.string.action_settings))
                .setConversationTitle("Уведомления чата");

   /*     messagingStyleДляОдноразовыеУведомления=   new NotificationCompat.MessagingStyle(getApplicationContext().getResources().getString(R.string.action_settings))
                .setConversationTitle("Уведомления чата");*/
        Log.i(Контекст.getClass().getName(),
                " messagingStyleДляОдноразовыеУведомления "+"\n"+ messagingStyleДляОдноразовыеУведомления.getMessages());

    }


    public MyWork_Notifocations_Уведомления_Для_Чата(@NonNull Context context, @NonNull WorkerParameters workerParams, @Nullable Activity activity) {
        super(context, workerParams);


        Контекст = context;
        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = new PUBLIC_CONTENT(Контекст);
        ////
        class_grud_sql_operationsIDпользоввателяДляСлужб = new Class_GRUD_SQL_Operations(Контекст);
        //TODO

        Create_Database_СсылкаНАБазовыйКласс = new CREATE_DATABASE(Контекст);

        Log.i(Контекст.getClass().getName(),
                " public MyWork_Notifocations_Уведомления_Для_Задачи(@NonNull Context context, @NonNull WorkerParameters workerParams,@Nullable Activity activity) {  Контекст " + "\n" + Контекст);






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

     /*   messagingStyleДляОдноразовыеУведомления= new NotificationCompat.MessagingStyle(getApplicationContext().getResources().getString(R.string.action_settings))
                .setConversationTitle("Уведомления чата");

   *//*     messagingStyleДляОдноразовыеУведомления=   new NotificationCompat.MessagingStyle(getApplicationContext().getResources().getString(R.string.action_settings))
                .setConversationTitle("Уведомления чата");*/
        //todo Прпробуем Запустить в Потоке work manager уведомления чата





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
                            // TODO: 20.02.2022

                            Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         " +
                                    "ТекущаяАктивти.getTaskInfo().numActivities  " + "\n"
                                    + ТекущаяАктивти.getTaskInfo().numActivities);
                            // TODO: 20.02.2022
                            if (ТекущаяАктивти.getTaskInfo().numActivities>0) {
                                // TODO: 20.02.2022

                                АктивностьЕслиЕстьTOPДляЧата = ТекущаяАктивти.getTaskInfo().baseActivity.getClassName().toString();
                            }


                            Log.i(Контекст.getClass().getName(), "ТекущаяАктивти " + ТекущаяАктивти +
                                    " АктивностьЕслиЕстьTOPДляЧата  " + АктивностьЕслиЕстьTOPДляЧата+ " ТекущаяАктивти.getTaskInfo().numActivities " +ТекущаяАктивти.getTaskInfo().numActivities);


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
                                            + new Date() + " СТАТУС WORKMANAGER MyWork_Notifocations_Уведомления  внутри WORK MANAGER "
                                            + КоличествоЗапущенныйПроуессыДляЧата.size() + "\n" +
                                            "   действуещее TOP активти АктивностьЕслиЕстьTOPДляЧата " + АктивностьЕслиЕстьTOPДляЧата);

                                    ///////todo  КОНЕЦ  код запуска уведомлений для чата
                                    break;
                                // TODO: 24.11.2021
                            }
                        }else {


                            ///////todo код запуска уведомлений для чата РЕСКО НЕТ АКТИВТИ

                            МетодЗапускаСлужбыУведомленияДляЧата();

                            ///////todo код запуска уведомлений для чата

                            Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         public Result doWork()  MyWork_Notifocations_Уведомления  внутри WORK MANAGER Зарускает когда Активти РАВНО )" + "\n"
                                    + КоличествоЗапущенныйПроуессыДляЧата);
                        }

                        //todo ЗАПУСК СЛУЖБЫ УВЕДОМЛЕНИ ЗАПУС Ф ФОНЕ



                    }


                    // TODO: 03.12.2021 ПРОСТО ФОНОВАЯ ЗАДАЧА

                } else {



                    ///////todo код запуска уведомлений для чата

                    МетодЗапускаСлужбыУведомленияДляЧата();

                    ///////todo код запуска уведомлений для чата

                    Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         public Result doWork()  MyWork_Notifocations_Уведомления  внутри WORK MANAGER Зарускает когда Активти РАВНО )" + "\n"
                            + КоличествоЗапущенныйПроуессыДляЧата);
                }

            }else{

                ///////todo код запуска уведомлений для чата

                МетодЗапускаСлужбыУведомленияДляЧата();

                ///////todo код запуска уведомлений для чата

                // TODO: 03.12.2021 ПРОСТО ФОНОВАЯ ЗАДАЧА
              ////  МетодЗапускаетУведомленияКогдаВообщенетНиОдногоАктивтиNULL(ФинальныйФлагЛюбогоЗапущеногоАктивти);


                Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода  " +
                        "       public Result doWork()  MyWork_Notifocations_Уведомления  внутри WORK MANAGER Зарускает когда Активти воОБЩЕ НЕТ null" );



            }

            //TODO когда запускам уведомления чата  КОГДА НЕТ АКТИВИТИ И ПРОСТО ЗАПУСКАЕМ

            // TODO: 24.11.2021

            // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления
            ИнформацияОЗапущенойСлужбе_Уведомления_ДляЧатаОдноразовое= WorkManager.getInstance(Контекст.getApplicationContext()).getWorkInfosByTag(ИмяСлужбыУведомленияДляЧатаОдноразовая).get().get(0);
            // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата         // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата

            if (ИнформацияОЗапущенойСлужбе_Уведомления_ДляЧатаОдноразовое!=null ) {

                Log.w(Контекст.getClass().getName(), " Внутри метода public Result doWork()   MyWork_Notifocations_Уведомления_Для_Задачи оДНОРАЗОАПЯ  ИнформацияОЗапущенойСлужбе_Уведомления_ДляЧатаОдноразовое" +
                        "" + ИмяСлужбыУведомленияДляЧатаОдноразовая + "\n"
                        + " getState  " +
                        ИнформацияОЗапущенойСлужбе_Уведомления_ДляЧатаОдноразовое.getState().name() + "\n" +
                        "getTags " +
                        ИнформацияОЗапущенойСлужбе_Уведомления_ДляЧатаОдноразовое.getTags() + "\n" +
                        "getRunAttemptCount " +
                        ИнформацияОЗапущенойСлужбе_Уведомления_ДляЧатаОдноразовое.getRunAttemptCount() + "\n" +
                        "getProgress " +
                        ИнформацияОЗапущенойСлужбе_Уведомления_ДляЧатаОдноразовое.getProgress().toString() + "\n" +
                        " время : " + new Date());
            }


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
                    "MyWork_Notifocations_Уведомления_Для_Задачи ошибка  Exception e в классе MyWork_Notifocations_Уведомления_Для_Задачи " + e.toString());

            //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ
            //  builder=null;
            Log.e(getApplicationContext().getClass().getName(), " Ошибка  MyWork_Notifocations_Уведомления ЧАТ   public Result doWork()    ДЛЯ ЧАТА ");
        }


        // TODO: 14.11.2021  status work manger


        

        Log.i(Контекст.getClass().getName(), "ОбщееКоличествоНЕпрочитанныхСтрок" + ОбщееКоличествоНЕпрочитанныхСтрок);



        // TODO: 03.01.2022

        // TODO: 24.11.2021
        if (РезультатНужноЗапускатьУведомленияИлиНет==true) {

            Log.i(Контекст.getClass().getName(), "     return     return     return     return     return" + "\n" + "   MyWork_Notifocations_Уведомления_Для_Чата " +
                    " РезультатНужноЗапускатьУведомленияИлиНет  Result.success()   " + РезультатНужноЗапускатьУведомленияИлиНет);

            return Result.success();

        } else {
            Log.i(Контекст.getClass().getName(), "    return     return     return     return     return" + "\n" +
                    "  MyWork_Notifocations_Уведомления_Для_Чата " +
                    " РезультатНужноЗапускатьУведомленияИлиНет Result.failure()   " + РезультатНужноЗапускатьУведомленияИлиНет);


            Log.i(Контекст.getClass().getName(), "     return     return     return     return     return" + "\n" + "   MyWork_Notifocations_Уведомления_Для_Чата " +
                    " РезультатНужноЗапускатьУведомленияИлиНет  Result.failure() " + РезультатНужноЗапускатьУведомленияИлиНет + "\n" +
                    " ИнформацияОЗапущенойСлужбе_Уведомления_ДляЧатаОдноразовое.getRunAttemptCount() " + ИнформацияОЗапущенойСлужбе_Уведомления_ДляЧатаОдноразовое.getRunAttemptCount());
                return Result.failure();



        }


    }


    // TODO: 16.12.2021 Метод ЗАпускает в фоне Уведомелния когда вообще нет нет ни одного Активти NULL













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
            МетодЗарускаСозданиеУведомленийДляЧата();


            Log.d(getApplicationContext().getClass().getName(), " Запуск по Расписанию СЛУЖБА МетодЗарускаСозданиеУведомленийДляЧата" +
                    "  Информирования  BroadcastReceiver или  FaceApp " + "  --" + new Date());


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

            notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые));
        }

    }


    /////////////////

    private void МетодЗарускаСозданиеУведомленийДляЧата() {

        try {


            try {


                РезультатНужноЗапускатьУведомленияИлиНет = false;

                ///
                Log.d(getApplicationContext().getClass().getName(), " Внутри Future Результат НужноЗапускать Уведомления Или Нет  СЛУЖБА"
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

                notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые));
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

            notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые));
            // /.cancelAll(); //   mNotificationManagerДляЧАТА.cancelAll();
            //   mNotificationManagerДляЧАТА=null;
            //  builder=null;
            Log.d(getApplicationContext().getClass().getName(), " Стоп СЛУЖБА СЛУЖБАService_Notifications  ДЛЯ ЧАТА onDestroy() Exception ");

        }



    }





    private void МетодКоторыйЗапускаетУвеломленияПослеАнализа(Intent intent, boolean результатНужноЗапускатьУведомленияИлиНет, String ФлагКтоЗапустилСлужбу) {
        ///TODO ЕСЛИ TRUE ТО ЗАПУСКАЕМ УВЕДОМЛЕНИЯ ТОЛЬКО КОГДА  TRUE

try{
        Log.d(this.getClass().getName(), "Результат Нужно Запускать Уведомления Или Нет СЛУЖБА  true and false :: " +
                результатНужноЗапускатьУведомленияИлиНет);


        /////TODO ЗАПУСКАЕМ И СОЗДАЕМ СЕРВИС УВЕДОМЛЕНИЯ

        ///
        Log.d(getApplicationContext().getClass().getName(), " ФлагКтоЗапустилСлужбу " + ФлагКтоЗапустилСлужбу);





        МетодНотификайшенТолькоДля_ЧАТА(ФлагКтоЗапустилСлужбу);


        ///
        Log.d(getApplicationContext().getClass().getName(), " ФлагКтоЗапустилСлужбу " + ФлагКтоЗапустилСлужбу);


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


    }
    }

/////////TODO запуск нновую нотификашенс устанолвка


    @SuppressLint("NotificationTrampoline")
    private void МетодНотификайшенТолькоДля_ЧАТА(String ФлагКтоЗапустилСлужбу) {
        try {

            Log.d(getApplicationContext().getClass().getName(), " Создание Уведомлеения СЛУЖБА СЛУЖБА Service_Notificatios_Уведомления_ОбновлениеПО ");
///

            PackageManager pm = getApplicationContext().getPackageManager();

            builderДляОдноразвойСлужбыУведомления = null;


// TODO: 17.11.2021 БЛОК КОДА РЕАЛИЗАЦИЯ БУДУШЕГО ЗАПУСКА ПРИ НАЖАТИИ НА УВЕДОСЛЕНИЕ ИЛИ НА КНОПКИ ЗАПУСКАЕТ С УВЕДОМЛЕНИЯ РАЗЛИЧНЫЕ ДЕЙСТВИЯ


            // TODO: 03.03.2022 определяем кода для отложеного запуска службы смены статсу условия задачи
            PendingIntent ЗапускКОдаЧтоПОльзовательЗАкрытиеЧата = new SubClass_Starting_chahge_status_public_Chat_Класс_ДляЧата(getApplicationContext()).
                    МетодЗапускаЧатаЗакваваемВнутриУведомленияPendingIntent(PROCESS_ID_УведомленияОдноразовые, ИмяСлужбыУведомленияДляЧатаОдноразовая,
                            0,
                            0, "");


            ///////TODO запускаем смены стануса задачи черезе PendingIntent
            Log.d(getApplicationContext().getClass().getName(), "PROCESS_ID_УведомленияОдноразовые  ДЛЯ Чата " + PROCESS_ID_УведомленияОдноразовые +
                    " ИмяСлужбыУведомленияДляЧатаОдноразовая " + ИмяСлужбыУведомленияДляЧатаОдноразовая);


            // TODO: 03.03.2022 ВЬТОРОЙ МЕТОД ДЛЯ ЗАДАНИЕ ПЕРЕХОД ИЗ УВЕДОМЛЕНИЯ В ЗАДАНИЕ
            PendingIntent ЗапускПриКликеКодаИзНадоперейтиСУведомленияВСамЧат = new SubClass_Starting_chahge_status_public_Chat_Класс_ДляЧата(getApplicationContext()).
                    МетодПриКликеЗапускаЗаданияИзСамогоУведомленияЧатаПереход(PROCESS_ID_УведомленияОдноразовые, ИмяСлужбыУведомленияДляЧатаОдноразовая,
                            0,
                            0, "");


            ///////TODO запускаем смены стануса задачи черезе PendingIntent
            Log.d(getApplicationContext().getClass().getName(), "PROCESS_ID_УведомленияОдноразовые  ДЛЯ Чата " + PROCESS_ID_УведомленияОдноразовые +
                    " ИмяСлужбыУведомленияДляЧатаОдноразовая " + ИмяСлужбыУведомленияДляЧатаОдноразовая);


            // TODO: 21.12.2021

            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);











            // TODO: 21.12.2021

            final Boolean[] СтатустУведомленияДляУведомленияЧАТА = {false};


            StatusBarNotification[] statusBarNotificationУведомленияЧата=      notificationManager.getActiveNotifications();
            // TODO: 21.12.2021
            Arrays.stream(statusBarNotificationУведомленияЧата).spliterator().forEachRemaining((ТекущийСтатусСлужбы)->{

                // TODO: 02.02.2022


                // TODO: 21.12.2021

                if (ТекущийСтатусСлужбы.getId() == Integer.parseInt(PROCESS_ID_УведомленияОдноразовые)) {

                    // TODO: 21.12.2021
                    СтатустУведомленияДляУведомленияЧАТА[0] = ТекущийСтатусСлужбы.isClearable();
                    // TODO: 21.12.2021

                    Log.d(this.getClass().getName(), " СтатустУведомленияДляУведомленияЧАТА" + СтатустУведомленияДляУведомленияЧАТА[0] +  "  ТекущийСтатусСлужбы.getId() " +ТекущийСтатусСлужбы.getId());


                }
                // TODO: 02.02.2022  втоаря проверка доля Уведомлний Службы что бы ен выскакивала когда уще есть Уведомелния




            });


            Log.d(this.getClass().getName(), " СтатустУведомленияДляУведомленияЧАТА" + СтатустУведомленияДляУведомленияЧАТА[0]);




            ////*/
////TODO в данную переменную мы вписываем все наши задачи

            /// builder.build().flags |= Notification.FLAG_AUTO_CANCEL;
////TODO ПЫТАЕМСЯ УЗНАТЬ СТАТУСТ РАБОАТЕТ ЛИ ФРАГМЕНТ
            МетодПроверкиСтатусаФрагмента();


            Log.d(this.getClass().getName(), " БуферСамиУведомленияЛинкСамиУведомления " + БуферСамиУведомленияЛинкСамиУведомления+
                        " СтатустУведомленияДляУведомленияЧАТА" + СтатустУведомленияДляУведомленияЧАТА[0]);


            // TODO: 21.11.2021 НЕПОСТРЕДСТВЕННО СОЗДАНИЕ УВЕДОМЛЕНИЯ ДЛЯ ЧАТА СОЗДАНИЕ И ЗАПОЛЕНИЕ


            if ( БуферСамиУведомленияЛинкСамиУведомления!=null  && СтатустУведомленияДляУведомленияЧАТА[0] ==false   ) {/// && СтатустУведомленияДляУведомленияЧАТА==false



                Log.d(this.getClass().getName(), "внутри создаени одноразвого уведомления  БуферСамиУведомленияЛинкСамиУведомления " + БуферСамиУведомленияЛинкСамиУведомления+
                        " СтатустУведомленияДляУведомленияЧАТА" + СтатустУведомленияДляУведомленияЧАТА[0]);


                Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v2.vibrate(VibrationEffect.createOneShot(600, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    v2.vibrate(600);
                }

                //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ


                notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые));


                ///notificationManager.cancelAll();


                onStopped();







/*

                String СамоуведомленияПерваяСтрочка= new String();
                // TODO: 03.02.2022
                if (БуферСамиУведомленияЛинкСамиУведомления.size()>=1) {
                    СамоуведомленияПерваяСтрочка = БуферСамиУведомленияЛинкСамиУведомления.get(0).toString();
                }

                String СамоуведомленияВтораяСтрочка= new String();
                // TODO: 03.02.2022  
                if (БуферСамиУведомленияЛинкСамиУведомления.size()>=2) {
                    СамоуведомленияВтораяСтрочка = БуферСамиУведомленияЛинкСамиУведомления.get(1).toString();
                }
                // TODO: 03.02.2022

                String СамоуведомленияТретьяСтрочка= new String();
                // TODO: 03.02.2022  
                if (БуферСамиУведомленияЛинкСамиУведомления.size()>=3) {
                    СамоуведомленияТретьяСтрочка = БуферСамиУведомленияЛинкСамиУведомления.get(2).toString();
                }
                // TODO: 03.02.2022

                if (ОбщееКоличествоНЕпрочитанныхСтрок>=3) {

                    ОбщееКоличествоНЕпрочитанныхСтрок=ОбщееКоличествоНЕпрочитанныхСтрок-3;
                }
*/


                Log.d(this.getClass().getName(), "ОбщееКоличествоНЕпрочитанныхСтрок " + ОбщееКоличествоНЕпрочитанныхСтрок+
                        " PROCESS_ID_УведомленияОдноразовые " +PROCESS_ID_УведомленияОдноразовые);

                Drawable icon = null;
                icon = getApplicationContext().getResources().getDrawable(R.drawable.icon_dsu1_for_fragment1_chat2);
                icon.setBounds(10, 0, 90, 85);



                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    ///"@mipmap/icon_main_tabel_four" ////.setSmallIcon(R.drawable.ic_notifications_black_24dp)
                    builderДляОдноразвойСлужбыУведомления = new NotificationCompat.Builder(getApplicationContext(), PROCESS_ID_УведомленияОдноразовые)
                            /////
                            .setSmallIcon(R.drawable.ic_notifications_black_24dp)////builder.setSmallIcon(R.drawable.ic_launcher_background);//R.mipmap.ic_launcher   ///R.drawable.ic_notifications_black_24dp
                            .setPriority(NotificationCompat.PRIORITY_MAX)
                            .setColor(Color.parseColor("#00ACC1"))
                            .setGroup("SousAndroid")
                            .setContentTitle("Уведомления чата")
                         /*   .setSmallIcon(R.drawable.icon_dsu1_for_fragment1_chat2)*/
                            .setLargeIcon(BitmapFactory.decodeResource(Контекст.getResources(),
                                    R.drawable.ic_notifications_black_24dp)) // большая картинка
                            //.setTicker("Последнее китайское предупреждение!") // до Lollipop
                            .setVibrate(new long[]{0, 250, 100, 250})
                            .setShowWhen(true)
                            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                            .setCategory(Notification.CATEGORY_MESSAGE)
                            .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE | Notification.FLAG_AUTO_CANCEL)
                            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        /*    .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText) ).setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)*/
                       /*     .setStyle(new NotificationCompat.InboxStyle()
                                    // TODO: 03.02.2022  сами служебная инфрмация
                                    // TODO: 03.02.2022  сами уведомления
                                    .addLine( СамоуведомленияПерваяСтрочка)
                            .addLine(СамоуведомленияВтораяСтрочка)
                            .addLine(СамоуведомленияТретьяСтрочка)
                                    // TODO: 03.02.2022  сами служебная инфрмация
                                            .setBigContentTitle("Уведомления чата")
                                            .setSummaryText("+"+ОбщееКоличествоНЕпрочитанныхСтрок+" еще")*/
                            .setStyle(messagingStyleДляОдноразовыеУведомления).setColor(Color.BLUE)
                            .setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE).setGroupSummary(true)
                            .addAction(android.R.drawable.ic_delete, "Закрыть", ЗапускКОдаЧтоПОльзовательЗАкрытиеЧата)
                            .setAutoCancel(false)
                            .setWhen(System.currentTimeMillis()) // автоматически закрыть уведомление после нажатия////.setStyle(new NotificationCompat.BigTextStyle().bigText(bigText) ).setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                            .setContentIntent(ЗапускПриКликеКодаИзНадоперейтиСУведомленияВСамЧат)
                            .setContentInfo("уведомления");
                    ////TODO три кнопки действия PUSH-сообщений
                    /// .setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL)


                } else {
                    builderДляОдноразвойСлужбыУведомления =
                            new NotificationCompat.Builder(getApplicationContext(), PROCESS_ID_УведомленияОдноразовые)
                                    //
                                    .setSmallIcon(R.drawable.ic_notifications_black_24dp)////builder.setSmallIcon(R.drawable.ic_launcher_background);//R.mipmap.ic_launcher   ///R.drawable.ic_notifications_black_24dp
                                    .setPriority(NotificationCompat.PRIORITY_MAX)
                                    .setColor(Color.parseColor("#00ACC1"))
                                   /* .setSmallIcon(R.drawable.icon_dsu1_for_fragment1_chat2)*/
                                    .setLargeIcon(BitmapFactory.decodeResource(Контекст.getResources(),
                                            R.drawable.ic_notifications_black_24dp)) // большая картинка
                                    //.setTicker("Последнее китайское предупреждение!") // до Lollipop
                                    .setVibrate(new long[]{0, 250, 100, 250})
                                    .setShowWhen(true)
                                    .setContentTitle("Уведомления чата")
                                    .setGroup("SousAndroid")
                                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                                    .setCategory(Notification.CATEGORY_MESSAGE)
                                    .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE | Notification.FLAG_AUTO_CANCEL)
                                    .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                                    /*    .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText) ).setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)*/
                                    /*    .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText) ).setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)*/
                                    /*     .setStyle(new NotificationCompat.InboxStyle()
                                                 // TODO: 03.02.2022  сами служебная инфрмация
                                                 // TODO: 03.02.2022  сами уведомления
                                                 .addLine( СамоуведомленияПерваяСтрочка)
                                         .addLine(СамоуведомленияВтораяСтрочка)
                                         .addLine(СамоуведомленияТретьяСтрочка)
                                                 // TODO: 03.02.2022  сами служебная инфрмация
                                                         .setBigContentTitle("Уведомления чата")
                                                         .setSummaryText("+"+ОбщееКоличествоНЕпрочитанныхСтрок+" еще")*/
                                    .setStyle(messagingStyleДляОдноразовыеУведомления)
                                    .setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)
                                    .addAction(android.R.drawable.ic_delete, "Закрыть", ЗапускКОдаЧтоПОльзовательЗАкрытиеЧата)
                                    .setAutoCancel(false)
                                    .setWhen(System.currentTimeMillis()) // автоматически закрыть уведомление после нажатия////.setStyle(new NotificationCompat.BigTextStyle().bigText(bigText) ).setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                                    .setContentIntent(ЗапускПриКликеКодаИзНадоперейтиСУведомленияВСамЧат)
                                    .setContentInfo("уведомления");

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
                            PROCESS_ID_УведомленияОдноразовые,
                            "Channel human readable title",
                            NotificationManager.IMPORTANCE_HIGH);
                    mNotificationManagerДляЧАТА.createNotificationChannel(channel);
                    builderДляОдноразвойСлужбыУведомления.setChannelId(String.valueOf(PROCESS_ID_УведомленияОдноразовые));
                    channel.setDescription("Увеомление для версии выше API 25");
                    // TODO: 18.11.2021  дополнительые настройки

                    builderДляОдноразвойСлужбыУведомления.build().flags  |= Notification.FLAG_FOREGROUND_SERVICE;
                    ///TODO Запускаем увидомления
                    builderДляОдноразвойСлужбыУведомления.build().flags  |= Notification.FLAG_AUTO_CANCEL;
                    // startForeground(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые),builder.build());//builder.build()
                    ///TODO Запускаем увидомления
                    builderДляОдноразвойСлужбыУведомления.build().flags  |= Notification.FLAG_SHOW_LIGHTS;
                    ///TODO Запускаем увидомления
                    builderДляОдноразвойСлужбыУведомления.build().flags  |= Notification.FLAG_INSISTENT;
                    // TODO: 02.12.2021
                    builderДляОдноразвойСлужбыУведомления.setNumber(1);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        mNotificationManagerДляЧАТА.getBubblePreference();
                    }

                    ///TODO Запускаем увидомления
                    // TODO: 02.12.2021  сам запуск уведомления
                    mNotificationManagerДляЧАТА.notify(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые), builderДляОдноразвойСлужбыУведомления.build());////   mNotificationManagerДляЧАТА.notify(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые), builder.build());
                    ///TODO закрытие увидомления
                    //mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();

   /*             Log.i(this.getClass().getName(), "ЗАПУСК СЛУЖБА  УВЕДОМЛЕНИЯ ДЛЯ ЧАТА САМО ПОЯВЛЕНИЕ  ВАРИАНТ -1  startForeground(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые),builder.build());//builder.build()" + new Date()
                        + "\n" + " PROCESS_ID_УведомленияОдноразовые " + PROCESS_ID_УведомленияОдноразовые+"\n"
                        +  "  САМИ СООБЩЕНИЯ : "+БуферСамиУведомленияЛинкСамиУведомления.toString());
*/



                    //    startForeground(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые),builder.build());//builder.build()

                }else{
                    ///TODO Запускаем увидомления

                    // TODO: 27.11.2021 САМ ЗАПУСК УВЕДОМЛЕНИЯ

                    //mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
                    builderДляОдноразвойСлужбыУведомления.build().flags  |= Notification.FLAG_FOREGROUND_SERVICE;
                    ///TODO Запускаем увидомления
                    ///TODO Запускаем увидомления
                    builderДляОдноразвойСлужбыУведомления.build().flags  |= Notification.FLAG_AUTO_CANCEL;
                    ///TODO Запускаем увидомления
                    builderДляОдноразвойСлужбыУведомления.build().flags  |= Notification.FLAG_SHOW_LIGHTS;
                    ///TODO Запускаем увидомления
                    builderДляОдноразвойСлужбыУведомления.build().flags  |= Notification.FLAG_INSISTENT;
                    // TODO: 02.12.2021
                    builderДляОдноразвойСлужбыУведомления.setNumber(1);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        mNotificationManagerДляЧАТА.getBubblePreference();
                    }

                    // TODO: 02.12.2021  сам запуск уведомления

                    mNotificationManagerДляЧАТА.notify(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые), builderДляОдноразвойСлужбыУведомления.build());////   mNotificationManagerДляЧАТА.notify(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые), builder.build());
                    ///TODO закрытие увидомления

                    //     startForeground(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые),builder.build());//builder.build()
/*

                Log.i(this.getClass().getName(), "ЗАПУСК СЛУЖБА  УВЕДОМЛЕНИЯ ДЛЯ ЧАТА САМО ПОЯВЛЕНИЕ  ВАРИАНТ -2  startForeground(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые),builder.build());/" + new Date()
                        + "\n" + " PROCESS_ID_УведомленияОдноразовые " + PROCESS_ID_УведомленияОдноразовые+"\n"
                        +  "  САМИ СООБЩЕНИЯ : "+БуферСамиУведомленияЛинкСамиУведомления.toString());*/
                }
                /// startForeground(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые),builder.build());//builder.build()


            }else{
                Log.i(this.getClass().getName(), " БуферСамиУведомленияЛинкСамиУведомления  ПУСТОЙ СЛУЖБЫ " + БуферСамиУведомленияЛинкСамиУведомления);
            }

            //////

            // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления
            WorkInfo ИнформацияОЗапущенойСлужбе= WorkManager.getInstance(Контекст.getApplicationContext()).getWorkInfosByTag(ИмяСлужбыУведомленияДляЧатаОдноразовая).get().get(0);

            Log.w(Контекст.getClass().getName(), " ПОСЛЕ ОТРАБОТКИ МЕТОДА ....Внутри метода public Result doWork() BroadcastReceiver_Sous_Notificatioons  ОДНОРАЗОВАЯ " +ИмяСлужбыУведомленияДляЧатаОдноразовая +"\n"
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

        }







    }

    private void МетодПроверкиСтатусаФрагмента() {
        // TODO: 11.03.2022

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            // TODO: 11.03.2022
           getApplicationContext().getMainExecutor().execute(new Runnable() {
                @Override
                public void run() {

                    // TODO: 11.03.2022


                    // TODO: 11.03.2022

                    Log.d(getApplicationContext().getClass().getName(), " Стоп СЛУЖБА СЛУЖБАService_Notifications ДЛЯ ЧАТА " +
                            " onDestroy() Exception viewГлавныйВидДляRecyclleViewДляЗаданий ");
                }
            });
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


            // TODO: 26.05.2021 данные по высичлению ID



            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

            ///
            class_grud_sql_operationsIDпользоввателяДляСлужб=new Class_GRUD_SQL_Operations(getApplicationContext());

            ///
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","data_chat");
            ///////
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","*");
            //
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","status_write=? AND user_update <> ?    " +
                    " AND message IS NOT NULL    AND chat_uuid IS NOT NULL    ");        //

            // TODO: 15.02.2022  old code
          /*  class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","status_write=?  AND user_update !=? " +
                    " AND message IS NOT NULL    AND chat_uuid IS NOT NULL    ");*/
            ///"_id > ?   AND _id< ?"
            //////
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",0);
            //
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2",  ПубличноеIDПолученныйИзСервлетаДляUUID);




            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки"," date_update  ");//"date_update DESC");
            ////
            // class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
            ///
            SQLiteCursor   Курсор_ДляСлужбыУведомлений_ТолькоДляЧата=null;


            Курсор_ДляСлужбыУведомлений_ТолькоДляЧата= (SQLiteCursor)  class_grud_sql_operationsIDпользоввателяДляСлужб.
                    new GetData(getApplicationContext()).getdata(class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу() );


            ////////

            Log.d(this.getClass().getName(), "Курсор_ДляСлужбыУведомлений_ТолькоДляЧата "  +Курсор_ДляСлужбыУведомлений_ТолькоДляЧата);





            // TODO: 26.05.2021 данные по высичлению ID


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


                РезультатНужноЗапускатьУведомленияИлиНет=true;

                ОбщееКоличествоНЕпрочитанныхСтрок=       Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getCount();

                Log.w(this.getClass().getName(), "  ОбщееКоличествоНЕпрочитанныхСтрок  " +ОбщееКоличествоНЕпрочитанныхСтрок);
                // TODO: 19.11.2021
                if(ОбщееКоличествоНЕпрочитанныхСтрок>=2){
                    // TODO: 19.11.2021
                    ОбщееКоличествоНЕпрочитанныхСтрок=ОбщееКоличествоНЕпрочитанныхСтрок-2;
                    // TODO: 19.11.2021

                    Log.w(this.getClass().getName(), "  ОбщееКоличествоНЕпрочитанныхСтрок  " +ОбщееКоличествоНЕпрочитанныхСтрок);
                }



                // TODO: 19.11.2021
                if(ОбщееКоличествоНЕпрочитанныхСтрок==1){
                    // TODO: 19.11.2021
                    ОбщееКоличествоНЕпрочитанныхСтрок=ОбщееКоличествоНЕпрочитанныхСтрок-1;
                    // TODO: 19.11.2021

                    Log.w(this.getClass().getName(), "  ОбщееКоличествоНЕпрочитанныхСтрок  " +ОбщееКоличествоНЕпрочитанныхСтрок);
                }



                // TODO: 20.05.2021  продолжение уведомления определяем даты после того как получили права на сотрудника

                МетодПолучениеДатыПослеПолучениеПравСотрудникаДляУведомления(Курсор_ДляСлужбыУведомлений_ТолькоДляЧата);




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

            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

            notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые));
        }

        // TODO: 20.05.2021  результат
        return РезультатНужноЗапускатьУведомленияИлиНет ;
    }











    // TODO: 20.05.2021  продолжение уведомления определяем даты после того как получили права на сотрудника



    private void МетодПолучениеДатыПослеПолучениеПравСотрудникаДляУведомления(SQLiteCursor  Курсор_ДляСлужбыУведомлений_ТолькоДляЧата) throws ParseException {
        // TODO: 20.05.2021 действие вьторое

        try{

            Log.d(this.getClass().getName(), "   Курсор_ДляСлужбыУведомлений_ТолькоДляЧата "+Курсор_ДляСлужбыУведомлений_ТолькоДляЧата);


            ////TODO start do

            //TODO перед созданеим

            БуферСамиУведомленияЛинкСамиУведомления=new ArrayList();

            // TODO: 03.02.2022

 Integer ИндексДвиженияПоСообщения=1;

            do {
                ////
                /////

                /////
                Integer КтоНаписалСообщениеID  = Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getInt(6);
                //
                String КтоНаписалСообщениеФИО=new String();

                Log.d(this.getClass().getName(), "КтоНаписалСообщениеID " + КтоНаписалСообщениеID);


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
                }

                ////////

                Log.d(this.getClass().getName(), "КтоНаписалСообщениеФИО "  +КтоНаписалСообщениеФИО);







                // TODO: 15.11.2021

                String ВремНеПРочитаногоСообщения= Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getString(7);

                Integer ИндексПоследнейТОчки=    ВремНеПРочитаногоСообщения.lastIndexOf(".");

                ВремНеПРочитаногоСообщения=ВремНеПРочитаногоСообщения.substring(0,ВремНеПРочитаногоСообщения.lastIndexOf(":"));

                Log.d(this.getClass().getName(), " ВремНеПРочитаногоСообщения  " + ВремНеПРочитаногоСообщения);
                // TODO: 15.11.2021

                Log.d(this.getClass().getName(), " ВремНеПРочитаногоСообщения  " + ВремНеПРочитаногоСообщения);


                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm", new Locale("ru"));
                //


                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));

                Date date = null;
                date = simpleDateFormat.parse(ВремНеПРочитаногоСообщения);

                simpleDateFormat.applyPattern(" HH:mm");//dd-MM-yyyy  // EEEE yyyy HH:mm"
                //simpleDateFormat.applyPattern(" dd EEEE yyyy HH:mm");//dd-MM-yyyy  // EEEE yyyy HH:mm"

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




                // TODO: 16.11.2021  само сообщение
                /////
                String СамиУведомленияВЧатеНеПрочитанный = Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getString(2).trim();



                БуферСамиУведомленияЛинкСамиУведомления=new ArrayList();

                БуферСамиУведомленияЛинкСамиУведомления.add(СамиУведомленияВЧатеНеПрочитанный +"\n"+
                        "время :"+ФиналВремНеПРочитаногоСообщения+".");


                СамиУведомленияВЧатеНеПрочитанный=null;

                СамиУведомленияВЧатеНеПрочитанный=БуферСамиУведомленияЛинкСамиУведомления.toString().replace("[","");

                СамиУведомленияВЧатеНеПрочитанный=СамиУведомленияВЧатеНеПрочитанный.replace("]","");

                // TODO: 03.02.2022  УВЕДОМЛЕНИЯ ДЛЯ ОБШЕЙ СИНХРОНИАЗЦИИ

                Person.Builder person=new Person.Builder();
                // TODO: 07.02.2022
                person.setKey(СамиУведомленияВЧатеНеПрочитанный);
                // TODO: 07.02.2022
                person.setBot(true);

                person.setName(КтоНаписалСообщениеФИО);
                // TODO: 07.02.2022 \
                person.setIcon( IconCompat.createWithResource(Контекст, R.drawable.icon_dsu1_for_fragment1_chat2));

                // TODO: 07.02.2022
                person .setUri("tel:9876543210");
                // TODO: 07.02.2022  person
                person.build();

                // TODO: 07.02.2022
                    messagingStyleДляОдноразовыеУведомления.addMessage(person.build().getKey(), System.currentTimeMillis(), "от:"+ person.build().getName()
                                    +" +" +
                                    "("+ОбщееКоличествоНЕпрочитанныхСтрок+")");


                    Log.d(this.getClass().getName(), "СамиУведомленияВЧатеНеПрочитанный "
                            + СамиУведомленияВЧатеНеПрочитанный +" БуферСамиУведомленияЛинкСамиУведомления.size() "
                            +БуферСамиУведомленияЛинкСамиУведомления.size()+ " messagingStyleДляОдноразовыеУведомления " +messagingStyleДляОдноразовыеУведомления+ "  СамиУведомленияВЧатеНеПрочитанный " +СамиУведомленияВЧатеНеПрочитанный+
                            " +("+Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getCount()+")");


                // TODO: 03.02.2022  УВЕДОМЛЕНИЯ ДЛЯ ОБШЕЙ СИНХРОНИАЗЦИИ


                // TODO: 03.02.2022  УВЕДОМЛЕНИЯ ДЛЯ ОБШЕЙ СИНХРОНИАЗЦИИ


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

            if (!Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.isClosed()) {
                Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.close();
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

            notificationManager.cancel(Integer.parseInt(PROCESS_ID_УведомленияОдноразовые));
        }




    }











    // TODO: 17.11.2021  end classs worl manager

}






























