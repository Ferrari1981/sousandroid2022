package com.dsy.dsu;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;
import androidx.lifecycle.Observer;
import androidx.work.ListenableWorker;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class Service_Notificatios_Для_ОбновлениеПО extends JobIntentService {////Service



    private static final String НазваниеСлужбы=".Service_Notificatios_Для_ОбновлениеПО";
    ////
    //TODO
   Integer СервернаяВерсияПОВнутри=0;


    ////////
    private String PROCESS_IDSoftUpdate="19";


    // TODO: 12.10.2021  Ссылка Менеджер Потоков

    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(getApplicationContext().getClass().getName(), " onCreate СЛУЖБА Service_Notificatios_Для_ОбновлениеПО  "
                +" время: "
                +new Date());

    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        try{

        СервернаяВерсияПОВнутри=  intent.getIntExtra("НоваяВерсияСерверногоПОПОслеУспешнойЗагрузки",0);

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
                v2.vibrate(600);
            }
            // TODO: 17.11.2021
            ///
            String ИмяСлужбыУведомленияДляОбновление = "WorkManager NOtofocationforUpdateSoft";


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





  /*          // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления
            WorkInfo ИнформацияОЗапущенойСлужбе= null;
            try {
                ИнформацияОЗапущенойСлужбе = WorkManager.getInstance(getApplicationContext().getApplicationContext()).getWorkInfosByTag(ИмяСлужбыУведомленияДляОбновление).get().get(0);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата         // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата



            WorkManager.getInstance(getApplicationContext().getApplicationContext()).getWorkInfosByTagLiveData(ИмяСлужбыУведомленияДляОбновление).observeForever(new Observer<List<WorkInfo>>() {
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
                            " время : " + new Date()+
                            "\n"+"#######################################################################################"+"\n");

                }
            });



// TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата         // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата





            Log.i(getApplicationContext().getClass().getName(), " Закрываем   внутри служы ПОЛЬЗОВАТЛЬ НАДАЛ НАКПОКУ ЗАКРЫТЬ" +
                    "Service_Notificatios_Для_Чата (intent.getAction()   СЛУЖБА" +(intent.getAction().toString())+" время запуска  " +new Date());


            // TODO: 28.12.2021 НЕ ПОСРЕДСТВЕНО ЗАГРУЗКА по ПОЛЬЗОВАТЕЛЮ


        }else  if (intent.getAction().equals("ЗагрузитьНовоеПо")) {


            Log.i(getApplicationContext().getClass().getName(), " ЗАГРУЖАЕМ ПО ПОЛЬЗОВАТЕЛЬ НАЖАЛ НА КОНОПКУ ЗАГУРДИТЬ   " +
                    "Service_Notificatios_Для_Чата (intent.getAction()   СЛУЖБА" +(intent.getAction().toString())+" время запуска  " +new Date()+
                     "  СервернаяВерсияПОВнутри " +СервернаяВерсияПОВнутри);



            new Class_Update_Download_File_APK_From_SERVER(getApplicationContext(),null).МетодНачалаЗапускаОбновленияПО(СервернаяВерсияПОВнутри);



            Log.i(getApplicationContext().getClass().getName(), " УЖЕ ЗАГРУзили ПО ПОЛЬЗОВАТЕЛЬ НАЖАЛ НА КОНОПКУ ЗАГУРДИТЬ   " +
                    "Service_Notificatios_Для_Чата (intent.getAction()   СЛУЖБА" +(intent.getAction().toString())+" время запуска  " +new Date());
        }
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
// TODO: 16.11.2021









    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, Service_Notificatios_Для_ОбновлениеПО.class, 41, intent);

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
           Log.e(getApplicationContext().getClass().getName(), " Ошиюбка СЛУЖБА СЛУЖБАService_ДЛя_ОБновлениеПО  ДЛЯ ЧАТА onHandleWork Exception ");

       }


       // TODO: 08.04.2021 end service thread


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
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
            Log.e(getApplicationContext().getClass().getName(), "С ОШИБКОЙ  Стоп СЛУЖБА СЛУЖБАService_Notifications   Обновление ПО  onDestroy() время "+new Date());

    }


    }












}