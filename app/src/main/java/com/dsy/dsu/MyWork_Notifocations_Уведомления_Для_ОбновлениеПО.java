package com.dsy.dsu;

import static android.content.Context.ACTIVITY_SERVICE;
import static android.content.Context.NOTIFICATION_SERVICE;

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
import android.media.RingtoneManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.dsy.dsu.Business_logic_Only_Class.Class_GRUD_SQL_Operations;
import com.dsy.dsu.Business_logic_Only_Class.Class_Generation_Errors;
import com.dsy.dsu.Business_logic_Only_Class.Class_Update_Download_File_APK_From_SERVER;

import org.jetbrains.annotations.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MyWork_Notifocations_Уведомления_Для_ОбновлениеПО extends Worker {
    Context Контекст;


    WorkerParameters workerParams;

    NotificationManager mNotificationManagerДляОбновлен=null;

    Integer СервернаяВерсияПОВнутри=0;

    String ИмяСлужбыУведомленияДляОбновлениеПО = "WorkManager NOtofocationforUpdateSoft";



    Integer ОбщееКоличествоНЕпрочитанныхСтрок = 0;
    ////TODO
    NotificationCompat.Builder builder_СлужбаОбновлениеПо = null;
    //// Notification notificationAfterBuild=null;

    //TODO

    CREATE_DATABASE Create_Database_СсылкаНАБазовыйКласс;

    Class_GRUD_SQL_Operations class_grud_sql_operationsIDпользоввателяДляСлужб;

    SimpleDateFormat ФоорматДат ;


    StringBuffer БуферСамиУведомленияЛинкСамиУведомления;

    int     ID_ТаблицаУвендомлений;


    Intent ИнтентДляЗапускаСлужбыПолсеАнализа;

    Boolean РезультатНужноЗапускатьУведомленияИлиНет=false;
    ////////
    private String PROCESS_ID_UpdateSoft="19";

    // TODO: 12.10.2021  Ссылка Менеджер Потоков

    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =null;





    public MyWork_Notifocations_Уведомления_Для_ОбновлениеПО(@NonNull Context context, @NonNull WorkerParameters workerParamsвнутри) {
        super(context, workerParamsвнутри);


        Контекст=context;

        workerParams=workerParamsвнутри;

        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new     PUBLIC_CONTENT(Контекст);
        ////
        class_grud_sql_operationsIDпользоввателяДляСлужб=new Class_GRUD_SQL_Operations(Контекст);
        //TODO

        Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(Контекст);





    }


    public MyWork_Notifocations_Уведомления_Для_ОбновлениеПО(@NonNull Context context, @NonNull WorkerParameters workerParams,@Nullable Activity activity) {
        super(context, workerParams);


        Контекст=context;
        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new     PUBLIC_CONTENT(Контекст);
        ////
        class_grud_sql_operationsIDпользоввателяДляСлужб=new Class_GRUD_SQL_Operations(Контекст);
        //TODO

        Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(Контекст);

        Log.i(Контекст.getClass().getName(),
                " public MyWork_Notifocations_Уведомления_ДляОбновлнение ПО(@NonNull Context context, @NonNull WorkerParameters workerParams,@Nullable Activity activity) {  Контекст "+"\n"+ Контекст);

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


        try {


// TODO: 04.01.2022
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
                            + КоличествоЗапущенныйПроуессыДляЧата.size()+ " ЗапущенныйПроуессыДляУведомленийЧата " +ЗапущенныйПроуессыДляУведомленийЧата);
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

                            // TODO: 20.02.2022
                            Log.i(Контекст.getClass().getName(), "ТекущаяАктивти " + ТекущаяАктивти +
                                    " АктивностьЕслиЕстьTOPДляЧата  " + АктивностьЕслиЕстьTOPДляЧата+"ТекущаяАктивти.getTaskInfo().numActivities  " + "\n"
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


                                    Log.d(this.getClass().getName(), "ЗАПУСК СЛУЖБА ВНУТРИ startService   Вещятеля BroadcastReceiver " +
                                            " Service_Notificatios_Уведомления_ОбновлениеПО  ДЛЯ ЧАТА " + new Date() +
                                            "\n" + " Build.BRAND " + Build.BRAND.toString() + "\n");




                                    ///////todo код запуска уведомлений для чата
                                    МетодЗапукаВоркМенеджераБезАктивити();


                                // TODO: 24.11.2021
                            }
                        }else{
                            // TODO: 20.02.2022  РЕЗКО НЕ СТАЛО АКТИВТИ
                            Log.d(this.getClass().getName(), "ЗАПУСК СЛУЖБА ВНУТРИ startService   Вещятеля BroadcastReceiver " +
                                    " Service_Notificatios_Уведомления_ОбновлениеПО  ДЛЯ ЧАТА " + new Date() +
                                    "\n" + " Build.BRAND " + Build.BRAND.toString() + "\n"+ " ЗапущенныйПроуессыДляУведомленийЧата " +ЗапущенныйПроуессыДляУведомленийЧата);

                            МетодЗапукаВоркМенеджераБезАктивити();
                            
                        }

                        //todo ЗАПУСК СЛУЖБЫ УВЕДОМЛЕНИ ЗАПУС Ф ФОНЕ



                    }


                    // TODO: 03.12.2021 ПРОСТО ФОНОВАЯ ЗАДАЧА

                }else {


                    Log.d(this.getClass().getName(), "ЗАПУСК СЛУЖБА ВНУТРИ startService   Вещятеля BroadcastReceiver " +
                            " Service_Notificatios_Уведомления_ОбновлениеПО  ДЛЯ ЧАТА " + new Date() +
                            "\n" + " Build.BRAND " + Build.BRAND.toString() + "\n"+" ЗапущенныйПроуессыДляУведомленийЧата " +ЗапущенныйПроуессыДляУведомленийЧата);

                    МетодЗапукаВоркМенеджераБезАктивити();
                }

            }else{


                Log.d(this.getClass().getName(), "ЗАПУСК СЛУЖБА ВНУТРИ startService   Вещятеля BroadcastReceiver " +
                        " Service_Notificatios_Уведомления_ОбновлениеПО  ДЛЯ ЧАТА " + new Date() +
                        "\n" + " Build.BRAND " + Build.BRAND.toString() + "\n"+ " ЗапущенныйПроуессыДляУведомленийЧата " +ЗапущенныйПроуессыДляУведомленийЧата);

                МетодЗапукаВоркМенеджераБезАктивити();


            }

            // TODO: 04.01.2022  end




            //////////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            Log.e(Контекст.getClass().getName(), " Стоп СЛУЖБА Service_Notificatios_Уведомления_ОбновлениеПО  ДЛЯ ЧАТА " +
                    "MyWork_Notifocations_Уведомления_ДляОбновлнение ПО ошибка  Exception e в классе MyWork_Notifocations_Уведомления_ДляОбновлнение ПО " + e.toString() );

            //  builder=null;
            Log.e(getApplicationContext().getClass().getName(), " Ошибка  MyWork_MyWork_Notifocations_Уведомления_Для_ОбновлениеПО  public Result doWork()    ДЛЯ ЧАТА ");
        }


        // TODO: 14.11.2021  status work manger



        final Object versio = BuildConfig.VERSION_CODE;
        /////


        Integer ЛокальнаяВерсияПО = Integer.parseInt(versio.toString());

        ///

        Log.d(this.getClass().getName(), "  ЛокальнаяВерсияПО" + ЛокальнаяВерсияПО+   "  СервернаяВерсияПОВнутри " +СервернаяВерсияПОВнутри);

        // TODO: 03.01.2022
        if(СервернаяВерсияПОВнутри==null){
            // TODO: 03.01.2022

            СервернаяВерсияПОВнутри=0;
        }


///////////TODO ПРИСТУПАЕМ К ЗАПУСКУ ОБНОВЛЕНИЕ ФАЙЛА . APK ТОЛЬКО КОГДА ВЕРСИЯ ДАННЫХ НА СЕРВЕРЕ БОЛЬШЕ ЧЕМ НА КЛИЕНТЕ (Android)
        ///
        if (СервернаяВерсияПОВнутри >ЛокальнаяВерсияПО ) {

            // TODO: 24.12.2021

            /////
            Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.EFFECT_HEAVY_CLICK));
            } else {
                //deprecated in API 26
                v2.vibrate(200);
            }

            // TODO: 24.11.2021
            return Result.success();
        } else {
            // TODO: 24.11.2021
            return Result.failure();
        }

    }

    // TODO: 09.01.2022



    private void МетодЗапукаВоркМенеджераБезАктивити() throws ExecutionException, InterruptedException {
        ///////todo код запуска уведомлений для чата
  try {

      // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ ОБНОВЛЕНИЕ ПО


      Log.i(this.getClass().getName(), "       МетодДополнительногоУдалениеJSONФайлов();   удалаение JSON файла АНАЛИЗ ВЕРСИИЯ КАКАЯ ВЕРСИЯ ы");


      // СервернаяВерсияПОВнутри=   new Class_Update_Find_Server_And_Client_VersionSOFT(getApplicationContext()).МетодНачалаЗапускаОбновленияПО();

      СервернаяВерсияПОВнутри = МетодАнализаВерсииПОJSON();


      Log.w(Контекст.getClass().getName(), "              " +
              "new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаВсехWorkManagerДляОбновленияПО();" +
              "\n" + "СервернаяВерсияПОВнутри " + СервернаяВерсияПОВнутри);

        //TODO когда запускам уведомления чата  КОГДА НЕТ АКТИВИТИ И ПРОСТО ЗАПУСКАЕМ
        ///////
    } catch (Exception e ) {
        //  Block of code to handle errors
        e.printStackTrace();
      ///метод запись ошибок в таблицу
      Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
              + Thread.currentThread().getStackTrace()[2].getLineNumber());
      new Class_Generation_Errors(Контекст).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
              Thread.currentThread().getStackTrace()[2].getLineNumber());
  }


    }





    Integer МетодАнализаВерсииПОJSON() {
        ///

        try {

            Log.d(this.getClass().getName(), " СЛУЖБА ... МЕТОД АНАЛИЗА ДАННЫХ РАБОТАЕТ......" + new Date());

            //TODO УДАЛЕНИЕ ФАЙЛОВ ПОЛЕ АНАЛИЗА
            Log.w(Контекст.getClass().getName(), " СервернаяВерсияПОВнутри  ОБНОВЛЕНИЕ ПО  НазваниеТекущего Потока " + Thread.currentThread().getName());
            // TODO: 02.04.2022 передполучаем веприсю ПО  удаляем файцл


            // TODO: 02.04.2022 зпускаем работут по анализу  СКАЧКИ ПРОГРАММЫ ТАБЕЛТНЫЙ УЧЁТ С СЕРВЕРА


            // TODO: 02.04.2022  #1
            new Class_Update_Download_File_APK_From_SERVER(getApplicationContext(), null).МетодУдалениеИнформационогоТекстовогоФайлаJSONДляПО();
            // TODO: 02.04.2022

            //TODO УДАЛЕНИЕ ФАЙЛОВ ПОЛЕ АНАЛИЗА
            Log.w(Контекст.getClass().getName(), " СервернаяВерсияПОВнутри  ОБНОВЛЕНИЕ ПО  НазваниеТекущего Потока " + Thread.currentThread().getName());
            // TODO: 02.04.2022 передполучаем веприсю ПО  удаляем файцл


            СервернаяВерсияПОВнутри = 0;
            // TODO: 17.12.2021 RXJAVA ПОЛУЧАЕМ JSON  ФАЙЛ ВЕРСИИ ПОРГРАМНОГО ПО ТАБЕЛЬНЫЙ УЧЁТ


            Observable observableПолучаемНовуюВерсиюСервернойВерсииФайлаAPK = Observable.interval(10, TimeUnit.SECONDS)
                    .take(2, TimeUnit.MINUTES)
                    .delay(3, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.computation())
                    .flatMap((string) -> {

                        // TODO: 08.01.2022
                        СервернаяВерсияПОВнутри = new MODEL_synchronized(Контекст).
                                УниверсальныйБуферJSONВерсииПОсСервера("dsu1.glassfish/update_android_dsu1/output-metadata.json", Контекст, "tabel.dsu1.ru", 8888);
                        // TODO: 08.01.2022

                        // TODO: 17.12.2021
                        Log.w(Контекст.getClass().getName(), " doOnNext observableVesrionServerSoft   СервернаяВерсияПОВнутри  ОБНОВЛЕНИЕ ПО " +СервернаяВерсияПОВнутри+ "\n"+
                                "  observableПолучаемНовуюВерсиюСервернойВерсииФайлаAPK " +
                                "СервернаяВерсияПОВнутри  ОБНОВЛЕНИЕ ПО  НазваниеТекущего Потока " +Thread.currentThread().getName());



                        Log.w(Контекст.getClass().getName(), " flatMap" +
                                "СервернаяВерсияПОВнутри  ОБНОВЛЕНИЕ ПО  НазваниеТекущего Потока " +Thread.currentThread().getName());
                        return Observable.fromArray(string).doOnComplete(System.out::println);

                    })
                    .doOnError(new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Throwable {

                            // TODO: 06.01.2022
                            Log.e(Контекст.getClass().getName(), "  doOnError observableПолучаемНовуюВерсиюСервернойВерсииФайлаAPK."  +"\n"+
                                    " Thread.currentThread().getName() " +Thread.currentThread().getName()+"\n"+
                                     " throwable " +throwable.getStackTrace());

                        }
                    })
                    .takeWhile(new Predicate<Object>() {
                        @Override
                        public boolean test(Object o) throws Throwable {
                            // TODO: 26.12.2021

                            Log.w(Контекст.getClass().getName(), "   takeWhile observableПолучаемНовуюВерсиюСервернойВерсииФайлаAPK"  +"\n"+
                                    " Thread.currentThread().getName() " +Thread.currentThread().getName()+ "  o " +o);

                            if (   СервернаяВерсияПОВнутри>0) {

                                Log.w(Контекст.getClass().getName(), "СервернаяВерсияПОВнутри  observableПолучаемНовуюВерсиюСервернойВерсииФайлаAPK ::::" +
                                        "  "+"\n"
                                        +СервернаяВерсияПОВнутри  +"\n"+
                                        " Thread.currentThread().getName() " +Thread.currentThread().getName());

                                // TODO: 04.01.2022

                                return false;
                            }else {
                                return true;
                            }
                        }
                    })
                    .doOnComplete(new Action() {
                        @Override
                        public void run() throws Throwable {
                            // TODO: 08.01.2022

                            ///TODO РАБОТА НЕПОСТРДСТВЕННО УЖЕ С .apk
                            if (СервернаяВерсияПОВнутри>0 ) {


                                Log.w(Контекст.getClass().getName(), " doOnComplete  observableПолучаемНовуюВерсиюСервернойВерсииФайлаAPK.  ЗАПУСК ОБНОВЛЕНИЕ ПОСЛЕ  " +
                                        " МетодОпределнияВерсийПОСервераКлиентаИПринятиеРешенияНаСкачиваниеОбновлениеПО " + "\n" +
                                        " СервернаяВерсияПОВнутри " + СервернаяВерсияПОВнутри + " +Thread.currentThread().getName() " + Thread.currentThread().getName());

                                ///////todo код запуска уведомлений для чата

                                МетодЗапускаСлужбыУведомленияДляОбновлениеПО();

                                ///////todo код запуска уведомлений для чата

                                    Log.i(Контекст.getClass().getName(), "Метод ВНУТРИ РАБОТА... С АКТИВТИ ДЕЙСТВУЩИМ УВЕДОМНИЯ ОБНОВЛЕНИЯ ПО ОТРАБОТАЛ ВНУТРИ метода ЗАПУСКАЕМ БЕЗ activity      " +
                                            "   public Result doWork()  MyWork_УВЕДОМНИЯ ОБНОВЛЕНИЯ ПО  внутри WORK MANAGER MyWork_Notifocations_Уведомления_Для_ОбновлениеПО   "
                                            + new Date() + " СТАТУС WORKMANAGER MyWork_Notifocations_Уведомления_Для_ОбновлениеПО" +
                                            " ОБНОВЛЕНИЯ ПО внутри WORK MANAGER "
                                            + WorkManager.getInstance(Контекст).getWorkInfosByTag(ИмяСлужбыУведомленияДляОбновлениеПО).get().get(0).getProgress() +
                                            " WorkManager Synchronizasiy_Data  " + " РАБОТАЮЩИЙ ПРОЦЕСС  КоличествоЗапущенныйПроуессыДляОбновлениеПО.size()" +
                                            "" +
                                            "" + " +Thread.currentThread().getName() " + Thread.currentThread().getName());

                                // TODO: 09.01.2022


                            }

                        }
                    })
              .observeOn(AndroidSchedulers.mainThread());


// TODO: 07.01.2022 GREAT OPERATIONS подпииска на данные
            observableПолучаемНовуюВерсиюСервернойВерсииФайлаAPK.subscribe(СервернаяВерсияПОВнутриКонец ->{
                Log.i(Контекст.getClass().getName(), "      observableПолучаемНовуюВерсиюСервернойВерсииФайлаAPK.subscribe " +
                        "СервернаяВерсияПОВнутри"+"\n"+
                        " СервернаяВерсияПОВнутри  " +СервернаяВерсияПОВнутри +"\n"+
                        " СервернаяВерсияПОВнутриКонец  " + СервернаяВерсияПОВнутриКонец + "\n" +
                        "" + " +Thread.currentThread().getName() " + Thread.currentThread().getName());
            });


            // TODO: 09.01.2022


            // TODO: 05.01.2022
            ///   observableПолучаемНовуюВерсиюСервернойВерсииФайлаAPK.toFuture().get();
            Log.i(Контекст.getClass().getName(), "      observableПолучаемНовуюВерсиюСервернойВерсииФайлаAPK.subscribe " +
                    "СервернаяВерсияПОВнутри" + "\n" +
                    " СервернаяВерсияПОВнутри  " + СервернаяВерсияПОВнутри + "\n" +
                    "" + " +Thread.currentThread().getName() " + Thread.currentThread().getName());


            ///////
        } catch (Exception e ) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(Контекст).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }



        // TODO: 17.12.2021
        Log.w(Контекст.getClass().getName(), " СервернаяВерсияПОВнутри  ОБНОВЛЕНИЕ ПО " +СервернаяВерсияПОВнутри);

        return  СервернаяВерсияПОВнутри;
    }



































    // TODO: 17.12.2021

    private void МетодЗапускаСлужбыУведомленияДляОбновлениеПО() {


        String ЛокальныйФлагУбратьУведомленияСлужбу=new String();

        // TODO: 15.11.2021


        try{

            Log.i(getApplicationContext().getClass().getName(), "Запуск метода МетодЗапускаСлужбыУведомления СЛУЖБА СЛУЖБАService_UpdateSoft ДЛЯ ЧАТА ДЛЯ ЧАТА  "+new Date());

// TODO: 01.04.2021 данное условие запускает соаздание уведомления с начала своего ниже код только реагирует на нажатие кнопки удалить уведомление и саму служюу отстановить кнопка ЗАКРЫТЬ






            /////////TODO запуск нновую нотификашенс устанолвка
            МетодЗарускаСозданиеУведомленийОбновлениеПо();




            Log.d(getApplicationContext().getClass().getName(), " Запуск по Расписанию СЛУЖБА" +
                    "   МетодЗарускаСозданиеУведомленийОбновлениеПо MyWork_Notifocations_Уведомления_Для_ОбновлениеПО " + "  --" + new Date());




            // TODO: 06.04.2021 Определяем рабоает ли Служба КОД ПРОВЕРЯТЕТНЕ ЗАПУЩЕНАЛИ СЛУЖЬБА И ЕСЛИНЕ ЗАПУЩЕНА ТОНЕ НАДО ЕЕ УДАЛЯТЬ ИЗ ПАМЯТИ




            ///////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);


        }

    }


    /////////////////


    private void МетодЗарускаСозданиеУведомленийОбновлениеПо( ) {

        try{


// TODO: 17.12.2021  ЗАПУСК ПОСИКА ВЕРСИИ ДАННЫХ ОБНОВЛЕНИЕ ВЕРСИИ НОВОЙ С СЕРВЕРА








// TODO: 17.11.2021  ЕСЛИ TRUE ТО НАЧИНАЕМ ЗАПУСКАЕМ УВЕДОМЛЕНИЯ
                Log.i(Контекст.getClass().getName(),
                        " СервернаяВерсияПОВнутри  WORK manager "+ СервернаяВерсияПОВнутри);



            ////TODO получаем и записываем локальную верисю ПО



            final Object versio = BuildConfig.VERSION_CODE;
            /////


           Integer ЛокальнаяВерсияПО = Integer.parseInt(versio.toString());

            ///

            Log.d(this.getClass().getName(), "\n"+"##################################"+"\n"+
                    "ПОЛУЧАЕМ ДВЕ ВЕРСИИ ПРОГРАММ ЛОКАЛЬНО И СЕРВЕРНОЙ  SOFT "+"\n"+
                            " ЛокальнаяВерсияПО " + ЛокальнаяВерсияПО+
                    "\n"+  "  СервернаяВерсияПОВнутри " +СервернаяВерсияПОВнутри);




///////////TODO ПРИСТУПАЕМ К ЗАПУСКУ ОБНОВЛЕНИЕ ФАЙЛА . APK ТОЛЬКО КОГДА ВЕРСИЯ ДАННЫХ НА СЕРВЕРЕ БОЛЬШЕ ЧЕМ НА КЛИЕНТЕ (Android)
            ///
            if (СервернаяВерсияПОВнутри >ЛокальнаяВерсияПО ) {


                    //////TODO МЕТОД КОТОРЫЙ ЗАПУСКАЕТ УВЕДОМЛЕНИЯ ПОСЛЕ АНАЛИЗА ДАТ


                    МетодКоторыйЗапускаетУвеломленияПослеАнализа(СервернаяВерсияПОВнутри);//  //ФлагКтоЗапустилСлужбу

                // TODO: 04.01.2022


                    Log.d(this.getClass().getName(),"\n"+"##################################"+"\n"+
                            "ПОЛУЧАЕМ ДВЕ ВЕРСИИ ПРОГРАММ ЛОКАЛЬНО И СЕРВЕРНОЙ   SOFT"+"\n"+
                            " НАДО СКАЧАТЬ ...ЗАПУСК ПОСЛЕ АНАЛИЗА ДАТ ЗАПУСКАЕМ УВЕДОМЛЕНИЯ  СЛУЖБА  Синхронизация   " + " ВРЕМЯ " + new Date()
                            + "\n" + " РезультатНужноЗапускатьУведомленияИлиНет " + РезультатНужноЗапускатьУведомленияИлиНет +
                            "\n" +  " СервернаяВерсияПОВнутри " +СервернаяВерсияПОВнутри+
                            " \n"+
                             " ЛокальнаяВерсияПО " +ЛокальнаяВерсияПО + "\n"+"##################################"+"\n");








                }else{

                Log.d(this.getClass().getName(), " НЕ НАДО ВЕСИЯ СЕРВЕРНАЯ НИЖЕ ИЛИ РАВНА СКАЧАТЬ ...ЗАПУСК ПОСЛЕ АНАЛИЗА ДАТ ЗАПУСКАЕМ УВЕДОМЛЕНИЯ  СЛУЖБА  Синхронизация   "
                        + " ВРЕМЯ " + new Date()
                        + "\n" + " РезультатНужноЗапускатьУведомленияИлиНет " + РезультатНужноЗапускатьУведомленияИлиНет +  " СервернаяВерсияПОВнутри " +СервернаяВерсияПОВнутри+
                        " \n"+
                        " ЛокальнаяВерсияПО " +ЛокальнаяВерсияПО );




            }






                ///


                Log.d(getApplicationContext().getClass().getName(), " Определили Результат НужноЗапускать Уведомления Или Нет  СЛУЖБА"
                        + "--" + РезультатНужноЗапускатьУведомленияИлиНет);/////










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
            //    mNotificationManagerДляОбновлен.cancel(1);///.cancelAll();


            //    mNotificationManagerДляОбновлен=null;
            //  builder=null;
            Log.d(getApplicationContext().getClass().getName(), " Стоп СЛУЖБА СЛУЖБАService_Notifications  ДЛЯ ЧАТА onDestroy() Exception ");

        }



    }






    private void МетодКоторыйЗапускаетУвеломленияПослеАнализа(Integer СервернаяВерсияПОВнутри) {
        ///TODO ЕСЛИ TRUE ТО ЗАПУСКАЕМ УВЕДОМЛЕНИЯ ТОЛЬКО КОГДА  TRUE


        Log.d(this.getClass().getName(), "Результат Нужно Запускать Уведомления Или Нет СЛУЖБА  true and false :: СервернаяВерсияПОВнутри  " +
                СервернаяВерсияПОВнутри);


        /////TODO ЗАПУСКАЕМ И СОЗДАЕМ СЕРВИС УВЕДОМЛЕНИЯ


        ActivityManager ЗапущенныйПроуессыДляУведомленийОбновлениеПО = (ActivityManager) Контекст.getSystemService(ACTIVITY_SERVICE);
        // TODO: 24.11.2021



        // TODO: 16.12.2021
        if (ЗапущенныйПроуессыДляУведомленийОбновлениеПО!=null) {

            // TODO: 24.11.2021
            List<ActivityManager.AppTask> КоличествоЗапущенныйПроуессыДляОбновлениеПО= ЗапущенныйПроуессыДляУведомленийОбновлениеПО.getAppTasks();


            if (КоличествоЗапущенныйПроуессыДляОбновлениеПО.size() > 0) {

                Log.i(Контекст.getClass().getName(), "ЗАПУСК    ВНУТРИ метода         " +
                        "public Result doWork()  MyWork_Notifocations_Уведомления  внутри WORK MANAGER  КоличествоЗапущенныйПроуессыДляОбновлениеПО " + "\n"
                        + КоличествоЗапущенныйПроуессыДляОбновлениеПО.size());
                ///////////////////////////////////////////////////////////////////////////////////////
                // TODO: 01.12.2021
                for (ActivityManager.AppTask ТекущаяАктивти : КоличествоЗапущенныйПроуессыДляОбновлениеПО) {

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
                                " АктивностьЕслиЕстьTOPДляЧатаКоличествоЗапущенныйПроуессыДляОбновлениеПО  " + АктивностьЕслиЕстьTOPДляЧата +
                                "ТекущаяАктивти.getTaskInfo().numActivities  " + "\n"
                                + ТекущаяАктивти.getTaskInfo().numActivities);
                    }




                    if (АктивностьЕслиЕстьTOPДляЧата != null) {

                        // TODO: 06.12.2021
                        switch (АктивностьЕслиЕстьTOPДляЧата) {

                            case "com.dsy.dsu.MainActivity_Visible_Async":
                            case "com.dsy.dsu.MainActivity_Face_Start":
                                break;


                            // TODO: 01.12.2021 САМ ЗАПУСК WORK MANAGER  СИНХРОНИАЗЦИИ ПРИ ВКЛЮЧЕННОЙ АКТИВТИ
                            default:


                                Log.d(this.getClass().getName(), "ЗАПУСК СЛУЖБА ВНУТРИ startService   " +
                                        "Вещятеля BroadcastReceiver  Service_Notificatios_Уведомления_ОбновлениеПО  ДЛЯ ЧАТА " + new Date() +
                                        "\n" + " Build.BRAND " + Build.BRAND.toString() + "\n");

                                ///////todo код запуска уведомлений для чата



                                МетодНотификайшенОбнолвениеПО();


                                ///
                                Log.d(getApplicationContext().getClass().getName(), " СервернаяВерсияПОВнутри " + СервернаяВерсияПОВнутри);


                                ///////todo  КОНЕЦ  код запуска уведомлений для чата
                                break;
                            // TODO: 24.11.2021
                        }
                    }else{


                        // TODO: 20.02.2022  РЕЗКО НЕ СТАЛО АКТИВИВТИ
                        МетодНотификайшенОбнолвениеПО();


                        ///
                        Log.d(getApplicationContext().getClass().getName(), " СервернаяВерсияПОВнутри " + СервернаяВерсияПОВнутри);


                    }


                }


                // TODO: 03.12.2021 ПРОСТО ФОНОВАЯ ЗАДАЧА

            } else {




                МетодНотификайшенОбнолвениеПО();


                ///
                Log.d(getApplicationContext().getClass().getName(), " СервернаяВерсияПОВнутри " + СервернаяВерсияПОВнутри);

            }

        }else{




            МетодНотификайшенОбнолвениеПО();


            ///
            Log.d(getApplicationContext().getClass().getName(), " СервернаяВерсияПОВнутри " + СервернаяВерсияПОВнутри);




        }














    }

/////////TODO запуск нновую нотификашенс устанолвка
























































    private void МетодНотификайшенОбнолвениеПО() {
        try {

            Log.d(getApplicationContext().getClass().getName(), " Создание Уведомлеения СЛУЖБА СЛУЖБА Service_Notificatios_Уведомления_ОбновлениеПО ");
///

            PackageManager pm = getApplicationContext().getPackageManager();

            builder_СлужбаОбновлениеПо = null;


            // TODO: 27.03.2022  запускаем обновление ПО табкльный учет


            PendingIntent ЗапускаемОбновлениеПо = МетодЗапускаОбновленияПОИзУведомления(pm);


            ///////TODO ЗАкрыкть  обновление табельный учет


            PendingIntent ЗапускЗакрываемУведомлениеПоОбновление = ЗакрываемУведомленияПоОбновлениПО(pm);


            Log.i(Контекст.getClass().getName(), "ЗАПУСК MyWork_Notifocations_Уведомления_ДляОбновлнение ПО  СЛУЖБА     " +
                    "           Service_Notifocations_Для_Чата.enqueueWork(getApplicationContext(),intentСлужбаУведомленийДЛЯЧата);;");


            // TODO: 27.03.2022 update PO

            Log.d(this.getClass().getName()," СервернаяВерсияПОВнутри"+ СервернаяВерсияПОВнутри);


            // TODO: 21.11.2021 НЕПОСТРЕДСТВЕННО СОЗДАНИЕ УВЕДОМЛЕНИЯ ДЛЯ ЧАТА СОЗДАНИЕ И ЗАПОЛЕНИЕ

            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);









            // TODO: 21.12.2021

            Boolean СтатустУведомленияЧистаяОбновлениПО=false;

                    StatusBarNotification[] statusBarNotificationОбновлениПО=      notificationManager.getActiveNotifications();
            // TODO: 21.12.2021
            for(StatusBarNotification statusBarNotification1: statusBarNotificationОбновлениПО){

                // TODO: 21.12.2021

              if (statusBarNotification1.getId()==Integer.parseInt(PROCESS_ID_UpdateSoft)){

                  // TODO: 21.12.2021
                СтатустУведомленияЧистаяОбновлениПО=   statusBarNotification1.isClearable();
                  // TODO: 21.12.2021

                  Log.d(this.getClass().getName()," СтатустУведомленияЧистаяОбновлениПО"+ СтатустУведомленияЧистаяОбновлениПО);



              }


            }


            if (СервернаяВерсияПОВнутри>0 && СтатустУведомленияЧистаяОбновлениПО==false) {


                String СообщениеОтоМЧТоЕчтьНоваяВерсияПоОтСервера="Вышла новая версия ПО "+"\n"
                        +" Табельный учёт " +"\n"+
                        " версия : (" +СервернаяВерсияПОВнутри+").";

                Log.d(this.getClass().getName(), " СервернаяВерсияПОВнутри" + СервернаяВерсияПОВнутри);
                Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    v2.vibrate(200);
                }

                //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ


                notificationManager.cancel(Integer.parseInt(PROCESS_ID_UpdateSoft));


                onStopped();


// Vibrate for 500 milliseconds


// TODO: 21.11.2021  само созданеи уведомления


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    ///"@mipmap/icon_main_tabel_four" ////.setSmallIcon(R.drawable.ic_notifications_black_24dp)
                    builder_СлужбаОбновлениеПо = new NotificationCompat.Builder(getApplicationContext(), PROCESS_ID_UpdateSoft)
                            /////
                            .setContentText(СообщениеОтоМЧТоЕчтьНоваяВерсияПоОтСервера)                 // .setContentText("http://developer.alexanderklimov.ru/android/")
                            .setSmallIcon(R.drawable.icon_dsu1_download)////builder.setSmallIcon(R.drawable.ic_launcher_background);//R.mipmap.ic_launcher   ///R.drawable.ic_notifications_black_24dp
                            .setPriority(NotificationCompat.PRIORITY_MAX)
                            .setColor(Color.parseColor("#00ACC1"))
                            .setGroup("SousAndroid")
                            .setLargeIcon(BitmapFactory.decodeResource(Контекст.getResources(),
                                    R.drawable.icon_dsu1_download)) // большая картинка
                            //.setTicker("Последнее китайское предупреждение!") // до Lollipop
                            .setVibrate(new long[]{0, 250, 100, 250})
                            .setShowWhen(true)
                            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                            .setCategory(Notification.CATEGORY_MESSAGE)
                            .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE | Notification.FLAG_AUTO_CANCEL)
                            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                            .setStyle(new NotificationCompat.BigTextStyle().bigText(СообщениеОтоМЧТоЕчтьНоваяВерсияПоОтСервера) ).setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)
                            .addAction(android.R.drawable.ic_delete, "Закрыть", ЗапускЗакрываемУведомлениеПоОбновление)
                            .addAction(android.R.drawable.ic_dialog_dialer, "Загрузить", ЗапускаемОбновлениеПо)
                            .setAutoCancel(false)
                            .setWhen(System.currentTimeMillis()) // автоматически закрыть уведомление после нажатия////.setStyle(new NotificationCompat.BigTextStyle().bigText(bigText) ).setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                            .setContentInfo("уведомления");
                    ////TODO три кнопки действия PUSH-сообщений
                    /// .setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL)


                } else {
                    builder_СлужбаОбновлениеПо =
                            new NotificationCompat.Builder(getApplicationContext(), PROCESS_ID_UpdateSoft)
                                    //
                                    .setContentText(СообщениеОтоМЧТоЕчтьНоваяВерсияПоОтСервера)                 // .setContentText("http://developer.alexanderklimov.ru/android/")
                                    .setSmallIcon(R.drawable.icon_dsu1_download)////builder.setSmallIcon(R.drawable.ic_launcher_background);//R.mipmap.ic_launcher   ///R.drawable.ic_notifications_black_24dp
                                    .setPriority(NotificationCompat.PRIORITY_MAX)
                                    .setColor(Color.parseColor("#00ACC1"))
                                    .setLargeIcon(BitmapFactory.decodeResource(Контекст.getResources(),
                                            R.drawable.icon_dsu1_download)) // большая картинка
                                    //.setTicker("Последнее китайское предупреждение!") // до Lollipop
                                    .setVibrate(new long[]{0, 250, 100, 250})
                                    .setShowWhen(true)
                                    .setGroup("SousAndroid")
                                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                                    .setCategory(Notification.CATEGORY_MESSAGE)
                                    .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE | Notification.FLAG_AUTO_CANCEL)
                                    .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                                    .setStyle(new NotificationCompat.BigTextStyle().bigText(СообщениеОтоМЧТоЕчтьНоваяВерсияПоОтСервера) ).setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)
                                    .addAction(android.R.drawable.ic_delete, "Закрыть", ЗапускЗакрываемУведомлениеПоОбновление)
                                    .addAction(android.R.drawable.ic_dialog_dialer, "Загрузить", ЗапускаемОбновлениеПо)
                                    .setAutoCancel(false)
                                    .setWhen(System.currentTimeMillis()) // автоматически закрыть уведомление после нажатия////.setStyle(new NotificationCompat.BigTextStyle().bigText(bigText) ).setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                                    .setContentInfo("уведомления");

                    // автоматически закрыть уведомление после нажатия
                    // .setContentIntent(ЗапускЗакрытия);
                    ////TODO три кнопки действия PUSH-сообщений



                }



                // TODO: 27.11.2021 САМ ЗАПУСК УВЕДОМЛЕНИЯ

                 mNotificationManagerДляОбновлен = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

                // TODO: 17.11.2021  start
                // === Removed some obsoletes
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(
                            PROCESS_ID_UpdateSoft,
                            "Channel human readable title",
                            NotificationManager.IMPORTANCE_HIGH);
                    mNotificationManagerДляОбновлен.createNotificationChannel(channel);
                    builder_СлужбаОбновлениеПо.setChannelId(String.valueOf(PROCESS_ID_UpdateSoft));
                    channel.setDescription("Увеомление для версии выше API 25");
                    // TODO: 18.11.2021  дополнительые настройки

                    builder_СлужбаОбновлениеПо.build().flags |= Notification.FLAG_FOREGROUND_SERVICE;
                    ///TODO Запускаем увидомления
                    builder_СлужбаОбновлениеПо.build().flags |= Notification.FLAG_AUTO_CANCEL;
                    // startForeground(Integer.parseInt(PROCESS_ID_UpdateSoft),builder.build());//builder.build()
                    ///TODO Запускаем увидомления
                    builder_СлужбаОбновлениеПо.build().flags |= Notification.FLAG_SHOW_LIGHTS;
                    ///TODO Запускаем увидомления
                    builder_СлужбаОбновлениеПо.build().flags |= Notification.FLAG_INSISTENT;
                    // TODO: 02.12.2021
                    builder_СлужбаОбновлениеПо.setNumber(1);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                         mNotificationManagerДляОбновлен.getBubblePreference();
                    }

                    ///TODO Запускаем увидомления
                    // TODO: 02.12.2021  сам запуск уведомления
                    mNotificationManagerДляОбновлен.notify(Integer.parseInt(PROCESS_ID_UpdateSoft), builder_СлужбаОбновлениеПо.build());////    mNotificationManagerДляОбновлен.notify(Integer.parseInt(PROCESS_ID_UpdateSoft), builder.build());
                    ///TODO закрытие увидомления
                    // mNotificationManagerДляОбновлен.cancel(1);///.cancelAll();

   /*             Log.i(this.getClass().getName(), "ЗАПУСК СЛУЖБА  УВЕДОМЛЕНИЯ ДЛЯ ЧАТА САМО ПОЯВЛЕНИЕ  ВАРИАНТ -1  startForeground(Integer.parseInt(PROCESS_ID_UpdateSoft),builder.build());//builder.build()" + new Date()
                        + "\n" + " PROCESS_ID_UpdateSoft " + PROCESS_ID_UpdateSoft+"\n"
                        +  "  САМИ СООБЩЕНИЯ : "+БуферСамиУведомленияЛинкСамиУведомления.toString());
*/



                    //    startForeground(Integer.parseInt(PROCESS_ID_UpdateSoft),builder.build());//builder.build()

                }else{
                    ///TODO Запускаем увидомления

                    // TODO: 27.11.2021 САМ ЗАПУСК УВЕДОМЛЕНИЯ

                    // mNotificationManagerДляОбновлен.cancel(1);///.cancelAll();
                    builder_СлужбаОбновлениеПо.build().flags |= Notification.FLAG_FOREGROUND_SERVICE;
                    ///TODO Запускаем увидомления
                    ///TODO Запускаем увидомления
                    builder_СлужбаОбновлениеПо.build().flags |= Notification.FLAG_AUTO_CANCEL;
                    ///TODO Запускаем увидомления
                    builder_СлужбаОбновлениеПо.build().flags |= Notification.FLAG_SHOW_LIGHTS;
                    ///TODO Запускаем увидомления
                    builder_СлужбаОбновлениеПо.build().flags |= Notification.FLAG_INSISTENT;
                    // TODO: 02.12.2021
                    builder_СлужбаОбновлениеПо.setNumber(1);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                         mNotificationManagerДляОбновлен.getBubblePreference();
                    }

                    // TODO: 02.12.2021  сам запуск уведомления

                    mNotificationManagerДляОбновлен.notify(Integer.parseInt(PROCESS_ID_UpdateSoft), builder_СлужбаОбновлениеПо.build());////    mNotificationManagerДляОбновлен.notify(Integer.parseInt(PROCESS_ID_UpdateSoft), builder.build());
                    ///TODO закрытие увидомления

                    //     startForeground(Integer.parseInt(PROCESS_ID_UpdateSoft),builder.build());//builder.build()
/*

                Log.i(this.getClass().getName(), "ЗАПУСК СЛУЖБА  УВЕДОМЛЕНИЯ ДЛЯ ЧАТА САМО ПОЯВЛЕНИЕ  ВАРИАНТ -2  startForeground(Integer.parseInt(PROCESS_ID_UpdateSoft),builder.build());/" + new Date()
                        + "\n" + " PROCESS_ID_UpdateSoft " + PROCESS_ID_UpdateSoft+"\n"
                        +  "  САМИ СООБЩЕНИЯ : "+БуферСамиУведомленияЛинкСамиУведомления.toString());*/
                }
                /// startForeground(Integer.parseInt(PROCESS_ID_UpdateSoft),builder.build());//builder.build()


            }else{
                Log.i(this.getClass().getName(), "bigText ПУСТОЙ СЛУЖБЫ обновлние ПО пустой " );
            }

            //////

            // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления
            WorkInfo ИнформацияОЗапущенойСлужбе= WorkManager.getInstance(Контекст.getApplicationContext()).getWorkInfosByTag(ИмяСлужбыУведомленияДляОбновлениеПО).get().get(0);

            Log.w(Контекст.getClass().getName(), " ПОСЛЕ ОТРАБОТКИ МЕТОДА ....Внутри метода public Result doWork() BroadcastReceiver_Sous_Notificatios_UpdateSoft " + ИмяСлужбыУведомленияДляОбновлениеПО + "\n"
                    + " getState  " +
                    ИнформацияОЗапущенойСлужбе.getState().name() + "\n" +
                    " isFinished  " +
                    ИнформацияОЗапущенойСлужбе.getState().isFinished() + "\n" +
                    "getTags " +
                    ИнформацияОЗапущенойСлужбе.getTags() + "\n" +
                    "getRunAttemptCount " +
                    ИнформацияОЗапущенойСлужбе.getRunAttemptCount() + "\n" +
                    "getProgress " +
                    ИнформацияОЗапущенойСлужбе.getState().isFinished() + "\n" +
                    " время : " +new Date());


            // TODO: 28.12.2021

            // TODO: 21.12.2021



        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //    mNotificationManagerДляОбновлен.cancel(1);///.cancelAll();

            Log.d(getApplicationContext().getClass().getName(), " Стоп СЛУЖБА СЛУЖБАService_Notifications ДЛЯ ЧАТА  onDestroy() Exception ");

        }


    }

    @androidx.annotation.Nullable
    private PendingIntent МетодЗапускаОбновленияПОИзУведомления(PackageManager pm) {
        // TODO: 17.11.2021 БЛОК КОДА РЕАЛИЗАЦИЯ БУДУШЕГО ЗАПУСКА ПРИ НАЖАТИИ НА УВЕДОСЛЕНИЕ ИЛИ НА КНОПКИ ЗАПУСКАЕТ С УВЕДОМЛЕНИЯ РАЗЛИЧНЫЕ ДЕЙСТВИЯ
        PendingIntent ЗапускаемОбновлениеПо = null;


        try {

            Intent notificationIntentДляУведомленийОбновлениеПоЗагрузить;
            // TODO: 17.11.2021
            notificationIntentДляУведомленийОбновлениеПоЗагрузить = new Intent(getApplicationContext(), Service_Notificatios_Для_ОбновлениеПО.class);
            notificationIntentДляУведомленийОбновлениеПоЗагрузить.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //notificationIntentЗакрыть.addCategory(Intent.CATEGORY_LAUNCHER);
            notificationIntentДляУведомленийОбновлениеПоЗагрузить.setAction("ЗагрузитьНовоеПо");
            // TODO: 28.12.2021


            Log.i(getApplicationContext().getClass().getName(), "СервернаяВерсияПОВнутри  " + СервернаяВерсияПОВнутри);

            if (СервернаяВерсияПОВнутри > 0) {
                // TODO: 27.03.2022  отпарвялем настояшщую версию серврного даннных пролидоженеми ПО
                notificationIntentДляУведомленийОбновлениеПоЗагрузить.putExtra("НоваяВерсияСерверногоПОПОслеУспешнойЗагрузки", СервернаяВерсияПОВнутри);
            }
            ///////


            if (notificationIntentДляУведомленийОбновлениеПоЗагрузить.resolveActivity(pm) != null) {
                ЗапускаемОбновлениеПо = PendingIntent.getService(getApplicationContext(),
                        70, notificationIntentДляУведомленийОбновлениеПоЗагрузить,
                        PendingIntent.FLAG_MUTABLE | PendingIntent.FLAG_UPDATE_CURRENT); //PendingIntent.FLAG_UPDATE_CURRENT
                // TODO: 17.11.2021
                // TODO: 17.11.2021
                Log.i(getApplicationContext().getClass().getName(), " Загружаем   СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА");
            }

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //    mNotificationManagerДляОбновлен.cancel(1);///.cancelAll();

            Log.d(getApplicationContext().getClass().getName(), " Стоп СЛУЖБА СЛУЖБАService_Notifications ДЛЯ ЧАТА  onDestroy() Exception ");

        }

///TODO
        return ЗапускаемОбновлениеПо;
    }

    @androidx.annotation.Nullable
    private PendingIntent ЗакрываемУведомленияПоОбновлениПО(PackageManager pm) {
        ////TODO

        PendingIntent ЗапускЗакрываемУведомлениеПоОбновление = null;

        try {
            Intent notificationIntentДляУведомленийОбновлениеЗакрываем;
            // TODO: 17.11.2021
            notificationIntentДляУведомленийОбновлениеЗакрываем = new Intent(getApplicationContext(), Service_Notificatios_Для_ОбновлениеПО.class);
            notificationIntentДляУведомленийОбновлениеЗакрываем.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //notificationIntentЗакрыть.addCategory(Intent.CATEGORY_LAUNCHER);
            notificationIntentДляУведомленийОбновлениеЗакрываем.setAction("ЗакрываемУведомлениеоНовомПО");
            ///////

            if (notificationIntentДляУведомленийОбновлениеЗакрываем.resolveActivity(pm) != null) {
                ЗапускЗакрываемУведомлениеПоОбновление = PendingIntent.getService(getApplicationContext(),
                        71, notificationIntentДляУведомленийОбновлениеЗакрываем,
                        PendingIntent.FLAG_MUTABLE | PendingIntent.FLAG_UPDATE_CURRENT); //PendingIntent.FLAG_UPDATE_CURRENT
                // TODO: 17.11.2021
                Log.i(getApplicationContext().getClass().getName(), " Закрываем   СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА");
                // Service_Notifocations_Для_Чата.enqueueWork(getApplicationContext(),notificationIntentДляУведомленийЗакрываем);
            }


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //    mNotificationManagerДляОбновлен.cancel(1);///.cancelAll();

            Log.d(getApplicationContext().getClass().getName(), " Стоп СЛУЖБА СЛУЖБАService_Notifications ДЛЯ ЧАТА  onDestroy() Exception ");

        }
///TODO
        return ЗапускЗакрываемУведомлениеПоОбновление;
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
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","status_write=?  AND id_user=? " +
                    " AND message IS NOT NULL    AND chat_uuid IS NOT NULL    ");
            ///"_id > ?   AND _id< ?"
            //////
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",0);
            //
            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2",  ПубличноеIDПолученныйИзСервлетаДляUUID);




            class_grud_sql_operationsIDпользоввателяДляСлужб. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC");
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
                if(ОбщееКоличествоНЕпрочитанныхСтрок>0){
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
            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);


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
            БуферСамиУведомленияЛинкСамиУведомления=null;

            БуферСамиУведомленияЛинкСамиУведомления=new StringBuffer();

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





                // TODO: 16.11.2021  само сообщение
                /////
                String СамиУведомленияВЧатеНеПрочитанный = Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.getString(2).trim();

                Log.d(this.getClass().getName(), "СамиУведомленияВЧатеНеПрочитанный " + СамиУведомленияВЧатеНеПрочитанный);

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

                simpleDateFormat.applyPattern(" dd EEEE yyyy HH:mm");//dd-MM-yyyy  // EEEE yyyy HH:mm"

                String ФиналВремНеПРочитаногоСообщения = simpleDateFormat.format(date);

                Log.d(this.getClass().getName(), "ФиналВремНеПРочитаногоСообщения " + ФиналВремНеПРочитаногоСообщения+"\n"+
                        "  СамиУведомленияВЧатеНеПрочитанный  " +СамиУведомленияВЧатеНеПрочитанный);

                ///TODO ДАТА ОТ СЕРВЕРА
                //////todoСамиУведомленияВЧатеНеПрочитанный.matches("[а-яА-Я]")///[m-nM-N]
                if (СамиУведомленияВЧатеНеПрочитанный.matches(("(.*)[а-яА-Я](.*)"))) {

                    БуферСамиУведомленияЛинкСамиУведомления.append("\n").
                            append("от: ").append(КтоНаписалСообщениеФИО).append("\n")
                            .append( "сообщение: " ).append(СамиУведомленияВЧатеНеПрочитанный).append("\n")
                            .append("время : ").append(ФиналВремНеПРочитаногоСообщения).append("\n")
                            .append("(").append("+").append(ОбщееКоличествоНЕпрочитанныхСтрок) .append(")").append(" сообщений.");
                }

                Log.d(this.getClass().getName(), "СамиУведомления " + БуферСамиУведомленияЛинкСамиУведомления.toString() +
                        " Дата_Начала_ТаблицаУвендомленийТекст " + БуферСамиУведомленияЛинкСамиУведомления.length());

                // TODO: 19.11.2021  после обработки одно записи выходим

                break;

                //todo while
            } while (Курсор_ДляСлужбыУведомлений_ТолькоДляЧата.moveToNext());


            // TODO: 19.11.2021 после обработки добавляем

            // БуферСамиУведомленияЛинкСамиУведомления.append(" +").append("(").append(ОбщееКоличествоНЕпрочитанныхСтрок) .append(")").append(" сообщений.") ;
            // TODO: 19.11.2021
            Log.d(this.getClass().getName(), "СамиУведомления " + БуферСамиУведомленияЛинкСамиУведомления.toString() +
                    " Дата_Начала_ТаблицаУвендомленийТекст " + БуферСамиУведомленияЛинкСамиУведомления.length());


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
            NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);


        }




    }











    // TODO: 17.11.2021  end classs worl manager

}






























