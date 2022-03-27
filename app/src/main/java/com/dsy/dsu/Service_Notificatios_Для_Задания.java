package com.dsy.dsu;

import android.app.NotificationManager;
import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.dsy.dsu.Code_For_Tasks_КодДля_Задания.MainActivity_Tasks;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;


public class Service_Notificatios_Для_Задания extends Service {////Service


    ////////
    private String PROCESS_ID;

    String ИмяСлужбыУведомленияДляЗадача;
    // TODO: 07.02.2022

    HashMap<String, String> hashMapХэшДляЗапоминиялUUID = new HashMap();
    // TODO: 12.10.2021  Ссылка Менеджер Потоков

    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = null;

    // TODO: 07.02.2022

    Long UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ;

    // TODO: 07.02.2022

    Integer ПередаемСтатусзадачи;

    // TODO: 24.03.2022
    Bundle bundleДляПришлиВСлужбу;


    // TODO: 24.03.2022
    String ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу;



    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(getApplicationContext().getClass().getName(), " onCreate СЛУЖБА Service_Notifocations_Для_заДАЧА "
                + " время: "
                + new Date());

    }
// TODO: 16.11.2021

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        try {

            Log.d(getApplicationContext().getClass().getName(), " onStartCommand СЛУЖБА Service_Notifocations_Для_ЗАДАЧА  "
                    + " время: "
                    + new Date());


            // TODO: 24.03.2022
            bundleДляПришлиВСлужбу = intent.getExtras();

            Log.d(getApplicationContext().getClass().getName(), " onStartCommand СЛУЖБА bundleДляПришлиВСлужбу ЗАДАЧА  " +
                    bundleДляПришлиВСлужбу + " ntent.getAction() " + intent.getAction());


            if (intent.getAction().equalsIgnoreCase("ЗапускаемИзмененияСатусазадачиВыполнил")
                    || intent.getAction().equalsIgnoreCase("ЗапсукаемОтказИзмененияСтатусаВзадаче")) {
                // TODO: 07.02.2022

                // TODO: 24.03.2022
                PROCESS_ID = bundleДляПришлиВСлужбу.getString("PROCESS_ID_Задачи");

                Log.i(getApplicationContext().getClass().getName(), "" + " PROCESS_ID" + PROCESS_ID);
                // TODO: 24.03.2022


                // TODO: 24.03.2022
                ИмяСлужбыУведомленияДляЗадача = bundleДляПришлиВСлужбу.getString("ИмяСлужбыУведомленияДляЧата_Задачи");


                Log.i(getApplicationContext().getClass().getName(), "" + " ИмяСлужбыУведомленияДляЧата" + ИмяСлужбыУведомленияДляЗадача);


                // TODO: 24.03.2022
                UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ = bundleДляПришлиВСлужбу.getLong("UUIDПолучениейЗадачи", 0l);  // TODO: 24.03.2022


                Log.i(getApplicationContext().getClass().getName(), "" + " UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ " + UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ);


                // TODO: 24.03.2022
                ПередаемСтатусзадачи = bundleДляПришлиВСлужбу.getInt("ДляЗадачиПередаемФлагВыполненаЗадчаИлиОтказ", 0);  // TODO: 24.03.2022


                Log.i(getApplicationContext().getClass().getName(), "" + " ПередаемСтатусзадачи " + ПередаемСтатусзадачи);

                // TODO: 24.03.2022
                ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу = bundleДляПришлиВСлужбу.getString("ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу");


                Log.i(getApplicationContext().getClass().getName(), "" + " ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу" + ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу);


                bundleДляПришлиВСлужбу.clear();


                // TODO: 27.03.2022  задача


                МетодВнутриСлужбаЗадача(intent);

                Log.i(getApplicationContext().getClass().getName(), "" + " ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу" + ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу);


            }
// TODO: 26.03.2022 запуск код только при ЗАКРЫТИЕ


            МетодПереходИзУведолменияЗадачиВСумуЗадачу(intent);

            // TODO: 27.03.2022
            Log.i(getApplicationContext().getClass().getName(), "ЗапускСогласованияПришедшегоЗАДАНИЕ   " +
                    "........ СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " + new Date() + "\n" +
                    "  intent.getAction() " + intent.getAction());


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            Log.e(getApplicationContext().getClass().getName(), " Ошиюбка СЛУЖБА СЛУЖБАService_Notifications_ДЛЯ ЧАТА  ДЛЯ ЧАТА onHandleWork Exception  PROCESS_ID   " + PROCESS_ID);

        }


        return super.onStartCommand(intent, flags, startId);
    }

    private void МетодПереходИзУведолменияЗадачиВСумуЗадачу(@NonNull Intent intent) {

        try {
            Log.i(getApplicationContext().getClass().getName(), "ЗапускСогласованияПришедшегоЗАДАНИЕ   " +
                    "........ СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " + new Date() + "\n" +
                    "  intent.getAction() " + intent.getAction());

            if (intent.getAction().equals("ИзУведомленияЗадачаПереходимВАктивтиЗадача")) {
                // TODO: 07.02.2022

                NotificationManager notificationManager = (NotificationManager)
                        getApplicationContext().getSystemService(NOTIFICATION_SERVICE);




// TODO: 26.03.2022  запуск активти из задания из уведомления


                Intent notificationIntentДляЗапускаЗаданияИзУведомленияПослеКлика;
                // TODO: 17.11.2021
                notificationIntentДляЗапускаЗаданияИзУведомленияПослеКлика = new Intent(getApplicationContext(), MainActivity_Tasks.class);
                // TODO: 15.11.2021
                notificationIntentДляЗапускаЗаданияИзУведомленияПослеКлика.setAction(Intent.ACTION_SCREEN_ON);

                // TODO: 26.03.2022
                notificationIntentДляЗапускаЗаданияИзУведомленияПослеКлика.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                // TODO: 27.03.2022
                Bundle bundleДЛяПереходаВСамоЗаданеиИзУведомления = intent.getExtras();

                // TODO: 26.03.2022
                PROCESS_ID = bundleДЛяПереходаВСамоЗаданеиИзУведомления.getString("PROCESS_ID_УведомленияПлановая");

                getApplicationContext().startActivity(notificationIntentДляЗапускаЗаданияИзУведомленияПослеКлика);

                // TODO: 26.03.2022
                Log.i(getApplicationContext().getClass().getName(), "ЗапускСогласованияПришедшегоЗАДАНИЕ   " +
                        "........ СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " +
                        "  PROCESS_ID " + PROCESS_ID);

                // notificationManager.cancelAll();
                notificationManager.cancel(Integer.parseInt(PROCESS_ID));

                stopForeground(true);
            }


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            Log.e(getApplicationContext().getClass().getName(), " Ошиюбка СЛУЖБА СЛУЖБАService_Notifications_ДЛЯ ЧАТА  ДЛЯ ЧАТА onHandleWork Exception  PROCESS_ID   " + PROCESS_ID);

        }


    }

    private void МетодВнутриСлужбаЗадача(@NonNull Intent intent) {
        // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления


        try {

            // TODO: 26.03.2022

            WorkInfo ИнформацияОЗапущенойСлужбе = null;
            try {
                ИнформацияОЗапущенойСлужбе = WorkManager.getInstance(getApplicationContext().getApplicationContext()).getWorkInfosByTag(ИмяСлужбыУведомленияДляЗадача.toString()).get().get(0);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата         // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата

            Log.w(getApplicationContext().getClass().getName(), " После НАЖАТИЕ НА КНОПКУ ЗАКРЫТЬ  Выкючение в Service_Notifocations_Для_Чата Внутри СЛУЖБЫ " +
                    " MyWork_Notifocations_Уведомления_Для_Задачи " + ИмяСлужбыУведомленияДляЗадача + "\n"
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


            // TODO: 26.03.2022

            Log.i(getApplicationContext().getClass().getName(), "ЗапускСогласованияПришедшегоЗАДАНИЕ   " +
                    "........ СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " + new Date() + "\n" +
                    "  intent.getAction() " + intent.getAction());

            // TODO: 18.04.2021 запувскает широковещатель

                // TODO: 07.02.2022

                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);


                // notificationManager.cancelAll();
                notificationManager.cancel(Integer.parseInt(PROCESS_ID));

                stopForeground(true);

                // TODO: 17.11.2021
                /////todo NOtofication
                Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    v2.vibrate(200);
                }


                Log.i(getApplicationContext().getClass().getName(), "ЗапускСогласованияПришедшегоЗАДАНИЕ   " +
                        "........ СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " + new Date() + "\n" +
                        "  intent.getAction() " + intent.getAction());


                Log.i(getApplicationContext().getClass().getName(), " ЗапускПаузы ........ СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " + new Date() + "\n" +
                        "  intent.getAction() " + intent.getAction() +
                        " \n" + " UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ " + UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ);


                // TODO: 07.02.2022  после выполНЕНИЯ ЗАДАЕНИЕ ОДНУЛЯЕМ uuid ДЛЯ СМЕНЫ СТАТУСА


                //TODO метоД СМЕНЫ СТАТУСА ПОЛЬЗОВАТЕЛЕМ КАК ОЗНАКОМЛЕННЫЙ
                Boolean РезультатСменыСтатусаНаОзнакомленный =
                        new SubClass_ДляСменыСтатусаНаОзнаколенный().
                                МетодСменыСтатусаНаОзкомленныйЗадениеСамимПользователем(getApplicationContext(),
                                        UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ
                                        , ПередаемСтатусзадачи,
                                        ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу);


                Log.w(getApplicationContext().getClass().getName(), " конец обоработки статсуса ознакомленый  РезультатСменыСтатусаНаОзнакомленный " +
                        "" + (РезультатСменыСтатусаНаОзнакомленный +
                        " \n" + " UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ " + UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ + "ПередаемСтатусзадачи " + ПередаемСтатусзадачи +
                        "  ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу " + ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу));


                if (РезультатСменыСтатусаНаОзнакомленный == true) {


                    notificationManager = (NotificationManager)
                            getSystemService(NOTIFICATION_SERVICE);


                    // notificationManager.cancelAll();
                    notificationManager.cancel(Integer.parseInt(PROCESS_ID));

                    stopForeground(true);


                    Toast.makeText(getApplicationContext(), " Статус изменен  !!!", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(getApplicationContext(), " Статус осталься прежним ? ", Toast.LENGTH_LONG).show();

                }


                UUIDДляЗапускСогласованияПришедшегоЗАДАНИЕ = 0L;


        } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        Log.e(getApplicationContext().getClass().getName(), " Ошиюбка СЛУЖБА СЛУЖБАService_Notifications_ДЛЯ ЧАТА  ДЛЯ ЧАТА onHandleWork Exception  PROCESS_ID   "+PROCESS_ID);

    }


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
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
            Log.e(getApplicationContext().getClass().getName(), "С ОШИБКОЙ  Стоп СЛУЖБА СЛУЖБАService_Notifications  ДЛЯ ЧАТА   ДЛЯ ЧАТА onDestroy() время " + new Date());

        }


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    // TODO: 07.02.2022 класс смены статуса как ознакомленый

    private class SubClass_ДляСменыСтатусаНаОзнаколенный {


        // TODO: 07.02.2022
        Boolean МетодСменыСтатусаНаОзкомленныйЗадениеСамимПользователем(@NonNull Context context,
                                                                        @NonNull Long UUID_ПоКоторомуМыИИщменимСтатусОзнакомлнныйВТаблицыУведомления,
                                                                        @NonNull Integer ПередаемСтатусзадачи
                , String ПримечанияОтКлинетаВыполнилИлиНетЗадачу) {

            // TODO: 07.02.2022
            Boolean РезультатСменыСтатусаНАОзнакомленый = false;

            try {

                Log.d(getApplicationContext().getClass().getName(), "ПримечанияОтКлинетаВыполнилИлиНетЗадачу "
                        + ПримечанияОтКлинетаВыполнилИлиНетЗадачу);


                SQLiteDatabase sqLiteDatabase_КлонКонкретноДляДАннойОперации = new CREATE_DATABASE(context).getССылкаНаСозданнуюБазу();

                Long РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника = 0l;

                Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДляЛокальногоОбволенияТабеля = new Class_GRUD_SQL_Operations(getApplicationContext());


                ContentValues contentValuesДляОбновленияСтатусаОзнакомлненый = new ContentValues();
                // TODO: 07.02.2022
              String НазваниеТаблицыобработки="data_notification";////notifications

// TODO: 07.02.2022  увеличиваем верисю данных
              РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника=
                      class_grud_sql_operationsПовышаемВерсиюДляЛокальногоОбволенияТабеля.new ChangesVesionData(getApplicationContext()).
                              МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table(НазваниеТаблицыобработки,
                                      "localversionandroid_version",
                                      getApplicationContext()
                                      , sqLiteDatabase_КлонКонкретноДляДАннойОперации);///  current_table    ///  localversionandroid_version


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

                contentValuesДляОбновленияСтатусаОзнакомлненый.put("status_write", ПередаемСтатусзадачи);


                // TODO: 07.02.2022  само заполение примечания от КЛИЕНТ

                contentValuesДляОбновленияСтатусаОзнакомлненый.put("callsback_note_task", ПримечанияОтКлинетаВыполнилИлиНетЗадачу);


                ///TODO ТОЛЬКО ЛОКАЛЬНОЕ ОБНОВЛЕНИЕ НА ТАБЕЛЕ В АКТИВИТИ
                Long РезультатЛокальногоОбновления_ОбновлениеСтатусОЗНАКОМЛЕННЫЙ = new Class_Engine_SQL(getApplicationContext()).
                        МетодЛокальноеОбновлениеВТабеле(contentValuesДляОбновленияСтатусаОзнакомлненый,
                                String.valueOf(UUID_ПоКоторомуМыИИщменимСтатусОзнакомлнныйВТаблицыУведомления),
                                getApplicationContext(), НазваниеТаблицыобработки);


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