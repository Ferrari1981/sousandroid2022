package com.dsy.dsu;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.dsy.dsu.Code_For_Chats_КодДля_Чата.MainActivity_List_Chats;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;


public class Service_Notificatios_Для_Чата extends JobIntentService {////Service



    private static final String НазваниеСлужбы=".Service_Notificatios_Для_Чата";
    ////
    //TODO



    ////////
    private String PROCESS_ID;

    String ИмяСлужбыУведомленияДляЧата;
    // TODO: 07.02.2022

    HashMap<String,String> hashMapХэшДляЗапоминиялUUID=new HashMap();
    // TODO: 12.10.2021  Ссылка Менеджер Потоков

    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =null;

    // TODO: 07.02.2022

    Long UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(getApplicationContext().getClass().getName(), " onCreate СЛУЖБА Service_Notificatios_Для_Чата  "
                +" время: "
                +new Date());

    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        try{

        Log.d(getApplicationContext().getClass().getName(), " onStartCommand СЛУЖБА Service_Notificatios_Для_Чата  "
                + " время: "
                + new Date());


// TODO: 01.01.2022

            PROCESS_ID = intent.getDataString();//PROCESS_ID

            // TODO: 11.01.2022


            Set<String> ИмяСлужбыУведомленияДляЧатамассив = intent.getCategories();

            // TODO: 03.03.2022
            Log.d(getApplicationContext().getClass().getName(), " onStartCommand СЛУЖБА Service_Notificatios_Для_Чата PROCESS_ID   "
                    + PROCESS_ID);


            Log.i(getApplicationContext().getClass().getName(), "" + " ИмяСлужбыУведомленияДляЧатамассив " + ИмяСлужбыУведомленияДляЧатамассив);

            if (ИмяСлужбыУведомленияДляЧатамассив != null) {
                // TODO: 07.02.2022



                ИмяСлужбыУведомленияДляЧата=       ИмяСлужбыУведомленияДляЧатамассив.stream()
                        .filter(elem -> elem!=null)
                        .limit(1)
                        .map(String::new )
                        .filter(Objects::nonNull).findFirst().orElse("");
                // TODO: 03.03.2022
                Log.i(getApplicationContext().getClass().getName(), "" + " ИмяСлужбыУведомленияДляЧата" +ИмяСлужбыУведомленияДляЧата);




                // TODO: 07.02.2022

                UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ=ИмяСлужбыУведомленияДляЧатамассив.stream()
                        .skip(1)
                        .map(Long::new)
                        .filter(Objects::nonNull).findFirst().orElse(0l);

                Log.i(getApplicationContext().getClass().getName(), "" + " UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ " +UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ);



                // TODO: 07.02.2022

             /*   UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ= Long.valueOf(ИмяСлужбыУведомленияДляЧатамассив.stream()
                        .map(elem -> new String(elem)).skip(1).findFirst().get());*/

                Log.i(getApplicationContext().getClass().getName(), "" + " UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ " +UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ);



            }





        // TODO: 18.04.2021 запувскает широковещатель

        if (intent.getAction().equals("Закрываем")) {


            // TODO: 17.11.2021
            /////todo NOtofication
            Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26
                v2.vibrate(200);
            }
            // TODO: 17.11.2021
            ///



            // TODO: 14.11.2021
            // TODO: 17.11.2021
                             /*   WorkManager.getInstance().cancelAllWorkByTag(ИмяСлужбыУведомленияДляЧата);

                                // TODO: 17.11.2021
                                Log.d(this.getClass().getName(), " после workInfos.get(i).getState().toString()" + workInfos.get(i).getState().toString());*/
            // TODO: 17.11.2021

                        /*        NotificationCompat.Builder builder = null;

                              startForeground(Integer.parseInt("12"), builder.build());//builder.build()*/

            NotificationManager notificationManager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);



           // notificationManager.cancelAll();
            notificationManager.cancel(Integer.parseInt(PROCESS_ID));

            stopForeground(true);





            // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления
            WorkInfo ИнформацияОЗапущенойСлужбе= null;
            try {
                ИнформацияОЗапущенойСлужбе = WorkManager.getInstance(getApplicationContext().getApplicationContext()).getWorkInfosByTag(ИмяСлужбыУведомленияДляЧата.toString()).get().get(0);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата         // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата

            Log.w(getApplicationContext().getClass().getName(), " После НАЖАТИЕ НА КНОПКУ ЗАКРЫТЬ  Выкючение в Service_Notificatios_Для_Чата Внутри СЛУЖБЫ " +
                    " MyWork_Notifocations_Уведомления_Общая " + ИмяСлужбыУведомленияДляЧата + "\n"
                    + " getState  " +
                    ИнформацияОЗапущенойСлужбе.getState().name() + "\n" +
                    " isFinished  " +
                    ИнформацияОЗапущенойСлужбе.getState().isFinished() + "\n" +
                    "getTags " +
                    ИнформацияОЗапущенойСлужбе.getTags() + "\n" +
                    "getRunAttemptCount " +
                    ИнформацияОЗапущенойСлужбе.getRunAttemptCount() + "\n" +
                    "getProgress " +
                    ИнформацияОЗапущенойСлужбе.getProgress().toString() + "\n" +
                    " время : " + new Date());






// TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата         // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата


/*
            String ИмяСлужбыСинхронизации="WorkManager Synchronizasiy_Data";

            try {
                ИнформацияОЗапущенойСлужбе = WorkManager.getInstance(getApplicationContext().getApplicationContext()).getWorkInfosByTag(ИмяСлужбыСинхронизации).get().get(0);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.w(getApplicationContext().getClass().getName(), " После НАЖАТИЕ НА КНОПКУ ЗАКРЫТЬ  Выкючение в Service_Notificatios_Для_Чата     Внутри СЛУЖБЫ " + "\n"+
                    " MyWork_Async_Синхронизация_Общая " + ИмяСлужбыСинхронизации + "\n"
                    + " getState  " +
                    ИнформацияОЗапущенойСлужбе.getState().name() + "\n" +
                     " isFinished  " +
                    ИнформацияОЗапущенойСлужбе.getState().isFinished() + "\n" +
                    "getTags " +
                    ИнформацияОЗапущенойСлужбе.getTags() + "\n" +
                    "getRunAttemptCount " +
                    ИнформацияОЗапущенойСлужбе.getRunAttemptCount() + "\n" +
                    "getProgress " +
                    ИнформацияОЗапущенойСлужбе.getProgress().toString() + "\n" +
                    " время : " + new Date());*/








            Log.i(getApplicationContext().getClass().getName(), " Закрываем   внутри служы ПОЛЬЗОВАТЛЬ НАДАЛ НАКПОКУ ЗАКРЫТЬ" +
                    "Service_Notificatios_Для_Чата (intent.getAction()   СЛУЖБА" +(intent.getAction().toString())+" время запуска  " +new Date());




            // TODO: 07.02.2022 задание КЛИВАЕМ НА СООБЩЕНИЕ ПЕРЕРХОДИМ НА ЧАТ



        }else if (intent.getAction().equals("ЗапускИзУведомления") ){



            Log.i(getApplicationContext().getClass().getName(), " ЗапускИзУведомления ........ СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" +(intent.getAction().toString())+" время запуска  " +new Date());

            Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26
                v2.vibrate(150);
            }

            // TODO: 17.11.2021
            Intent intentЗапускаемИзУведомленияСамЧат = new Intent(getApplicationContext(), MainActivity_List_Chats.class);

            // TODO: 15.11.2021
            intentЗапускаемИзУведомленияСамЧат.setAction(Intent.ACTION_SCREEN_ON);

            intentЗапускаемИзУведомленияСамЧат.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            intentЗапускаемИзУведомленияСамЧат.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);


            getApplicationContext(). startActivity(intentЗапускаемИзУведомленияСамЧат);
            // TODO: 15.11.2021

            Log.i(getApplicationContext().getClass().getName(), " ЗапускИзУведомления ........ СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" +(intent.getAction().toString())+" время запуска  " +new Date());


            // TODO: 07.02.2022 задание НА СОГЛАСОВАНИЕ ЧТО ПОЛЬЗОВАТЕЛЬ ОЗНАКОМЛЕН С ЗАДАНИЕМ
        }else if (intent.getAction().equals("ЗапускСогласованияПришедшегоЗАДАНИЕ") ){
            // TODO: 07.02.2022  
            
            
            Log.i(getApplicationContext().getClass().getName(), "ЗапускСогласованияПришедшегоЗАДАНИЕ   " +
                    "........ СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" +(intent.getAction().toString())+" время запуска  " +new Date()+ "\n"+
                    "  intent.getAction() " +intent.getAction());
            
            



            Log.i(getApplicationContext().getClass().getName(), " ЗапускПаузы ........ СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" +(intent.getAction().toString())+" время запуска  " +new Date()+ "\n"+
                    "  intent.getAction() " +intent.getAction()+
                    " \n"+  " UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ " +UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ);


            // TODO: 07.02.2022  после выполНЕНИЯ ЗАДАЕНИЕ ОДНУЛЯЕМ uuid ДЛЯ СМЕНЫ СТАТУСА


            //TODO метоД СМЕНЫ СТАТУСА ПОЛЬЗОВАТЕЛЕМ КАК ОЗНАКОМЛЕННЫЙ
        Boolean РезультатСменыСтатусаНаОзнакомленный=
                new  SubClass_ДляСменыСтатусаНаОзнаколенный().
                        МетодСменыСтатусаНаОзкомленныйЗадениеСамимПользователем(getApplicationContext(),UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ);




            Log.w(getApplicationContext().getClass().getName(), " конец обоработки статсуса ознакомленый  РезультатСменыСтатусаНаОзнакомленный " +
                    "" +(РезультатСменыСтатусаНаОзнакомленный+
                    " \n"+  " UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ " +UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ));


            if (РезультатСменыСтатусаНаОзнакомленный==true) {




                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);



                // notificationManager.cancelAll();
                notificationManager.cancel(Integer.parseInt(PROCESS_ID));

                stopForeground(true);




                Toast.makeText(getApplicationContext(), " Статус изменился на ознакомленый  !!!" , Toast.LENGTH_LONG).show();
            }else {

                Toast.makeText(getApplicationContext(), " Статус осталься прежним ? " , Toast.LENGTH_LONG).show();

            }


            UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ=0L;






        }

    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        Log.e(getApplicationContext().getClass().getName(), " Ошиюбка СЛУЖБА СЛУЖБАService_Notifications_ДЛЯ ЧАТА  ДЛЯ ЧАТА onHandleWork Exception  PROCESS_ID   "+PROCESS_ID);

    }


        return super.onStartCommand(intent, flags, startId);
    }
// TODO: 16.11.2021









    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, Service_Notificatios_Для_Чата.class, 25, intent);

        Log.d(context.getClass().getName(), " enqueueWork СЛУЖБА Service_Notificatios_Для_Чата  "
                +" время: "
                +new Date());

    }

    @Override
    public boolean onStopCurrentWork() {

        Log.d(getApplicationContext().getClass().getName(), " enqueueWork СЛУЖБА Service_Notificatios_Для_Чата  "
                +" время: "
                +new Date());
        return super.onStopCurrentWork();
    }

    @Override
   protected void onHandleWork(@NonNull Intent intent) {

       ///TODO запускаем дВУХсЛУЖБ

       try {

///
/////////////////////////////

           Log.d(this.getClass().getName(), " СЛУЖБА УВЕДОМЛЕНИЯ  ЧАТА onHandleWork ) "
                   + " время: "
                   + new Date());


/////


       } catch (Exception e) {
           e.printStackTrace();
           ///метод запись ошибок в таблицу
           Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                   " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
           new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                   Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
           Log.e(getApplicationContext().getClass().getName(), " Ошиюбка СЛУЖБА СЛУЖБАService_Notifications_ДЛЯ ЧАТА  ДЛЯ ЧАТА onHandleWork Exception ");

       }


       // TODO: 08.04.2021 end service thread


   }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try{

        Log.i(getApplicationContext().getClass().getName(), "Стоп Стоп  Стоп !!!!!!!!!!! СЛУЖБА СЛУЖБАService_Notifications  ДЛЯ ЧАТА   ДЛЯ ЧАТА onDestroy() время "+new Date());

// TODO: 20.04.2021 повторыный запуск широковещательного приемника

        } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
            Log.e(getApplicationContext().getClass().getName(), "С ОШИБКОЙ  Стоп СЛУЖБА СЛУЖБАService_Notifications  ДЛЯ ЧАТА   ДЛЯ ЧАТА onDestroy() время "+new Date());

    }


    }


    // TODO: 07.02.2022 класс смены статуса как ознакомленый

    private class SubClass_ДляСменыСтатусаНаОзнаколенный {


        // TODO: 07.02.2022
      Boolean МетодСменыСтатусаНаОзкомленныйЗадениеСамимПользователем(@NonNull Context context,
                                                                   @NonNull Long UUID_ПоКоторомуМыИИщменимСтатусОзнакомлнныйВТаблицыУведомления) {

          // TODO: 07.02.2022
          Boolean РезультатСменыСтатусаНАОзнакомленый=false;

          try{
              SQLiteDatabase sqLiteDatabase_КлонКонкретноДляДАннойОперации=new CREATE_DATABASE(context).getССылкаНаСозданнуюБазу();

             Long РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника=0l;

              Class_GRUD_SQL_Operations        class_grud_sql_operationsПовышаемВерсиюДляЛокальногоОбволенияТабеля=new Class_GRUD_SQL_Operations(getApplicationContext());


       ContentValues contentValuesДляОбновленияСтатусаОзнакомлненый=new ContentValues();
              // TODO: 07.02.2022
              String НазваниеТаблицыобработки="data_notification";////notifications

// TODO: 07.02.2022  увеличиваем верисю данных
              РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника=
                      class_grud_sql_operationsПовышаемВерсиюДляЛокальногоОбволенияТабеля. new ChangesVesionData(getApplicationContext()).
                              МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table(НазваниеТаблицыобработки,"localversionandroid_version",
                                      getApplicationContext()
                                      ,sqLiteDatabase_КлонКонкретноДляДАннойОперации);///  current_table    ///  localversionandroid_version


              //TODO  конец курант ча
              //////
              contentValuesДляОбновленияСтатусаОзнакомлненый.put("current_table", РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника);


              Log.d(this.getClass().getName(), "  РезультатУвеличинаяВерсияДАныхЧата " + РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника);


              // TODO: 07.02.2022

              //TODO заполение КОНТЕНЕР для локального обновления--дАТА оПЕРАЦИИ
              ////TODO ДАТА
              String СгенерированованныйДатаДляВставки=     new Class_Generation_Data(getApplicationContext()).ГлавнаяДатаИВремяОперацийСБазойДанных();


              contentValuesДляОбновленияСтатусаОзнакомлненый.put("date_update", СгенерированованныйДатаДляВставки);


// TODO: 07.02.2022  само заполение смены статуса

              contentValuesДляОбновленияСтатусаОзнакомлненый.put("status_write", 1);





              ///TODO ТОЛЬКО ЛОКАЛЬНОЕ ОБНОВЛЕНИЕ НА ТАБЕЛЕ В АКТИВИТИ
           Long   РезультатЛокальногоОбновления_ОбновлениеСтатусОЗНАКОМЛЕННЫЙ = new Class_Engine_SQL(getApplicationContext()).
                      МетодЛокальноеОбновлениеВТабеле(contentValuesДляОбновленияСтатусаОзнакомлненый,
                             String.valueOf( UUID_ПоКоторомуМыИИщменимСтатусОзнакомлнныйВТаблицыУведомления),
                              getApplicationContext(),НазваниеТаблицыобработки);


              Log.d(this.getClass().getName(), "  РезультатЛокальногоОбновления_ОбновлениеСтатусОЗНАКОМЛЕННЫЙ " + РезультатЛокальногоОбновления_ОбновлениеСтатусОЗНАКОМЛЕННЫЙ);

              if (РезультатЛокальногоОбновления_ОбновлениеСтатусОЗНАКОМЛЕННЫЙ>0){


                  // TODO: 01.07.2021  после локальной обнолвения поробуем вотрунть синхронизацию локальную  в фоне и порстмортрим что будет


                  Class_GRUD_SQL_Operations  classGrudSqlOperationsПовышаемВерсиюДАнныхПриЛокальноОбновлениеииДанныхВнутриТабеля;
                  // TODO: 30.08.2021    КОД ОБНОВЛЕНИЕ   ДАННЫХ   ЧЕРЕЗ
                  //////
                  classGrudSqlOperationsПовышаемВерсиюДАнныхПриЛокальноОбновлениеииДанныхВнутриТабеля=new Class_GRUD_SQL_Operations(getApplicationContext());


                  classGrudSqlOperationsПовышаемВерсиюДАнныхПриЛокальноОбновлениеииДанныхВнутриТабеля.
                          concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы",НазваниеТаблицыобработки);
                  ///
                  classGrudSqlOperationsПовышаемВерсиюДАнныхПриЛокальноОбновлениеииДанныхВнутриТабеля.
                          concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба","Локальное");///  "ЛокальныйСерверныйОба"    ПОСЛЕ КАК ПРИШЛИ ВНЕШНИЕ ДАННЫЕ
                  ///
                  ///
                  classGrudSqlOperationsПовышаемВерсиюДАнныхПриЛокальноОбновлениеииДанныхВнутриТабеля.
                          concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put(" " +
                          "ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать",РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника);///  "ЛокальныйСерверныйОба"    ПОСЛЕ КАК ПРИШЛИ ВНЕШНИЕ ДАННЫЕ
                  ///







                  ///TODO РЕЗУЛЬТА изменения версии данных
                  Integer        Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы=
                          (Integer)  classGrudSqlOperationsПовышаемВерсиюДАнныхПриЛокальноОбновлениеииДанныхВнутриТабеля.
                                  new ChangesVesionData(getApplicationContext()).
                                  changesvesiondata(classGrudSqlOperationsПовышаемВерсиюДАнныхПриЛокальноОбновлениеииДанныхВнутриТабеля.
                                                  concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                                          new PUBLIC_CONTENT(context).МенеджерПотоков
                                          ,sqLiteDatabase_КлонКонкретноДляДАннойОперации);
//
                  Log.d(getApplicationContext().getClass().getName(), "Результат_ПриписиИзменнийВерсииДанныхВФонеПриСменеОрганизации "
                          +Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы );


                  // TODO: 07.02.2022  РезультатСменыСтатусаНАОзнакомленый flag

                  Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

                  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                      v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                  } else {
                      //deprecated in API 26
                      v2.vibrate(150);
                  }

                  РезультатСменыСтатусаНАОзнакомленый=true;


              }





          } catch (Exception e) {
              e.printStackTrace();
              ///метод запись ошибок в таблицу
              Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                      " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
              new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                      Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
              //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
              Log.e(getApplicationContext().getClass().getName(), "С ОШИБКОЙ  Стоп СЛУЖБА СЛУЖБАService_Notifications  ДЛЯ ЧАТА   ДЛЯ ЧАТА onDestroy() время "+new Date());

          }
          return РезультатСменыСтатусаНАОзнакомленый;
        }
    }
}