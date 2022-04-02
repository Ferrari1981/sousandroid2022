package com.dsy.dsu;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import java.util.Date;
import java.util.List;


public class Service_Notificatios_Для_ОбновлениеПО extends Service {////Service


    ////
    //TODO
    Integer СервернаяВерсияПОВнутри = 0;

    String ИмяСлужбыУведомленияДляОбновление = "WorkManager NOtofocationforUpdateSoft";
    ////////
    private String PROCESS_IDSoftUpdate = "19";


    // TODO: 12.10.2021  Ссылка Менеджер Потоков

    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(getApplicationContext().getClass().getName(), " onCreate СЛУЖБА Service_Notificatios_Для_ОбновлениеПО  "
                + " время: "
                + new Date());

    }


// TODO: 16.11.2021

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        try {

            СервернаяВерсияПОВнутри = intent.getIntExtra("НоваяВерсияСерверногоПОПОслеУспешнойЗагрузки", 0);

            Log.d(getApplicationContext().getClass().getName(), " onStartCommand СЛУЖБА Service_Notificatios_Для_ОбновлениеПО "
                    + " время: "
                + new Date()+"\n"+
                "  СервернаяВерсияПОВнутри " +СервернаяВерсияПОВнутри);


        Log.i(getApplicationContext().getClass().getName(), " ЗАПУСК ........" +
                " СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " + new Date()+"\n"+
                " PROCESS_IDSoftUpdate " +PROCESS_IDSoftUpdate);


        // TODO: 18.04.2021 запувскает широковещатель

        if (intent.getAction().equals("ЗакрываемУведомлениеоНовомПО")) {


            // TODO: 17.11.2021
            /////todo NOtofication
            Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v2.vibrate(VibrationEffect.createOneShot(600, VibrationEffect.DEFAULT_AMPLITUDE));
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
            notificationManager.cancel(Integer.parseInt(PROCESS_IDSoftUpdate));

            stopForeground(true);


// TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата         // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата


            Log.i(getApplicationContext().getClass().getName(), " Закрываем   внутри служы ПОЛЬЗОВАТЛЬ НАДАЛ НАКПОКУ ЗАКРЫТЬ" +
                    "Service_Notifocations_Для_Чата (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " + new Date());


            // TODO: 28.12.2021 НЕ ПОСРЕДСТВЕНО ЗАГРУЗКА по ПОЛЬЗОВАТЕЛЮ


        }

            Log.i(getApplicationContext().getClass().getName(), " ЗАПУСК ........" +
                    " СНАРУЖИ Broadcatrecever (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " + new Date() + "\n" +
                    " PROCESS_IDSoftUpdate " + PROCESS_IDSoftUpdate);


            if (intent.getAction().equals("ЗагрузитьНовоеПо")) {


                Log.i(getApplicationContext().getClass().getName(), " ЗАГРУЖАЕМ ПО ПОЛЬЗОВАТЕЛЬ НАЖАЛ НА КОНОПКУ ЗАГУРДИТЬ   " +
                        "Service_Notifocations_Для_Чата (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " + new Date() +
                        "  СервернаяВерсияПОВнутри " + СервернаяВерсияПОВнутри);


                Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    v2.vibrate(200);
                }


                String PROCESS_ID_UpdateSoft = "19";

                NotificationManager notificationManager = (NotificationManager)
                        getApplicationContext().getSystemService(NOTIFICATION_SERVICE);


                notificationManager.cancel(Integer.parseInt(PROCESS_ID_UpdateSoft));


                // TODO: 02.04.2022 зпускаем работут по анализу  СКАЧКИ ПРОГРАММЫ ТАБЕЛТНЫЙ УЧЁТ С СЕРВЕРА


                new Class_Update_Download_File_APK_From_SERVER(getApplicationContext(), null).МетодНачалаЗапускаОбновленияПО(СервернаяВерсияПОВнутри);


                Log.i(getApplicationContext().getClass().getName(), " УЖЕ ЗАГРУзили ПО ПОЛЬЗОВАТЕЛЬ НАЖАЛ НА КОНОПКУ ЗАГУРДИТЬ   " +
                        "Service_Notifocations_Для_Чата (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " + new Date());
            }

            // TODO: 26.03.2022

            // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата         // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата

            Handler.Callback callback = new Handler.Callback() {
                @Override
                public boolean handleMessage(@NonNull android.os.Message msg) {
                    return true;
                }
            };


            Handler handlerЗапускСтатусаWorkManagerДляОбновлениПо = new Handler(callback);

            // TODO: 27.03.2022
            handlerЗапускСтатусаWorkManagerДляОбновлениПо.post(() -> {
                // TODO: 27.03.2022
                WorkManager.getInstance(getApplicationContext().getApplicationContext())
                        .getWorkInfosByTagLiveData(ИмяСлужбыУведомленияДляОбновление).observeForever(new Observer<List<WorkInfo>>() {
                    @Override
                    public void onChanged(List<WorkInfo> workInfos) {


                        Log.w(getApplicationContext().getClass().getName(), " После НАЖАТИЕ НА КНОПКУ ЗАКРЫТЬ  Выкючение в Service_Notificatios_Для_Update_Soft Внутри СЛУЖБЫ " +
                                " MyWork_Notifocations_Уведомления_ДляОбновлениеПо ВНУТРИ Service_Notificatios_Для_ОбновлениеПО " + ИмяСлужбыУведомленияДляОбновление + "\n"
                                + " getState  " +
                                workInfos.get(0).getState().name() + "\n" +
                                " isFinished  " +
                                workInfos.get(0).getState().isFinished() + "\n" +
                                "getTags " +
                                workInfos.get(0).getTags() + "\n" +
                                "getRunAttemptCount " +
                                workInfos.get(0).getRunAttemptCount() + "\n" +
                                "getProgress " +
                                workInfos.get(0).getProgress().toString() + "\n" +
                                " время : " + new Date() +
                                "\n" + "#######################################################################################" + "\n");

                        // TODO: 28.03.2022

                        // TODO: 27.03.2022


                        if (workInfos.get(0).getState().compareTo(WorkInfo.State.BLOCKED) == 0) {
                            // TODO: 27.03.2022
                            WorkManager.getInstance(getApplicationContext()).cancelAllWorkByTag(ИмяСлужбыУведомленияДляОбновление);
                        }


                    }
                });

            });


        } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        Log.e(getApplicationContext().getClass().getName(), " Ошиюбка СЛУЖБА СЛУЖБАService_ДЛЯ ОБНОВЛЕНИЯ ПО  ДЛЯ ЧАТА onHandleWork Exception ");

    }


        return super.onStartCommand(intent, flags, startId);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        try{

        Log.i(getApplicationContext().getClass().getName(), "Стоп Стоп  Стоп !!!!!!!!!!! СЛУЖБА СЛУЖБАService_Notifications  ДЛЯ Обновление ПО  ДЛЯ ЧАТА onDestroy() время "+new Date());

// TODO: 20.04.2021 повторыный запуск широковещательного приемника

        } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
            Log.e(getApplicationContext().getClass().getName(), "С ОШИБКОЙ  Стоп СЛУЖБА СЛУЖБАService_Notifications   Обновление ПО  onDestroy() время " + new Date());

        }


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}