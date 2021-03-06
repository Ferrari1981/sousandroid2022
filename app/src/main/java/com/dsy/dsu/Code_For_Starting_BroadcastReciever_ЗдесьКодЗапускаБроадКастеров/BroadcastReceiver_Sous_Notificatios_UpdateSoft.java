package com.dsy.dsu.Code_For_Starting_BroadcastReciever_ЗдесьКодЗапускаБроадКастеров;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.dsy.dsu.Business_logic_Only_Class.Class_Generation_Errors;
import com.dsy.dsu.MyWork_Notifocations_Уведомления_Для_ОбновлениеПО;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BroadcastReceiver_Sous_Notificatios_UpdateSoft extends BroadcastReceiver {

    //WorkManager workManagerДЛяСлужбПроекта;


    public BroadcastReceiver_Sous_Notificatios_UpdateSoft() {
        super();
        Log.i(this.getClass().getName(), " ЗАПУСК  КОНСТРКТОР  BroadcastReceiver_Sous_Notificatios_UpdateSoft   " +
                " public void onReceive(Context context, Intent intent) ........ СНАРУЖИ  BroadcastReceiver_Sous_Notificatios_UpdateSoft  (intent.getAction()   СЛУЖБА" + new Date() + "\n" +
                " Build.BRAND.toString() Название Телефона " + Build.BRAND.toString());

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ////
        Log.i(this.getClass().getName(), " ЗАПУСК BroadcastReceiver_Sous_Notificatios_UpdateSoft  " +
                "  public void onReceive(Context context, Intent intent) ........ СНАРУЖИ  BroadcastReceiver_Sous_Notificatios_UpdateSoft  (intent.getAction()   СЛУЖБА"
                + (intent.getAction().toString()) + " время запуска  " + new Date() + "\n" +
                " Build.BRAND.toString() Название Телефона " + Build.BRAND.toString());

        try {

            Log.i(this.getClass().getName(), " ЗАПУСК BroadcastReceiver_Sous_Notificatios_UpdateSoft    public void onReceive(Context context, Intent intent) " +
                    "........ СНАРУЖИ  BroadcastReceiver_Sous_Notificatios_UpdateSoft  (intent.getAction()   СЛУЖБА" + (intent.getAction().toString()) + " время запуска  " + new Date());

            // TODO: 18.04.2021 запувскает широковещатель

            ///
            Log.i(this.getClass().getName(), " Внутри Broadcatrecever (intent.getAction()   СЛУЖБА кто ЗАПУСТИЛ САМ bRODCAST ? :::" + (intent.getAction().toString()) + "\n" +
                    " Build.BRAND.toString() Название Телефона " + Build.BRAND.toString());

            // TODO: 07.10.2021


            /////

                try {



                    // TODO: 29.09.2021     ЗАПУСК BROADCAST УВЕДОМЕЛНИЯ  ТОЛЬКО ДЛЯ ЧАТА

                  МетодЗапускаWorkManager_УведомленияДляОбновления(context);



                    Log.i(this.getClass().getName(), "ПОСЛЕ ВЫХПОЛЕНИЯ МЕТОДА              " +
                            "МетодЗапускаWorkManager_УведомленияДляОбновлениеПО(context); Broadcatrecever (intent.getAction()   СЛУЖБА кто ЗАПУСТИЛ САМ bRODCAST ? :::"
                            +(intent.getAction().toString())+"\n"+
                            " Build.BRAND.toString() Название Телефона " +Build.BRAND.toString());


                    // TODO: 07.07.2021
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(context.getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                            this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                            Thread.currentThread().getStackTrace()[2].getLineNumber());;

                    Log.e(context.getClass().getName(), " ОШИБКА В BroadcastReceiver_Sous_Notificatios_UpdateSoft  СЛУЖБА  public void onReceive  " + " ОШИБКА ::" + e.toString());


                }
                /////


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(context.getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());;
            Log.e(context.getClass().getName(), " ОШИБКА В BroadcastReceiver_Sous_Notificatios_UpdateSoft  СЛУЖБА  public void onReceive  " + " ОШИБКА ::" + e.toString());


        }


    }




















    // TODO: 02.04.2021 метод запуска службы из BroadCastas


    private void МетодЗапускаWorkManager_УведомленияДляОбновления(@NotNull Context context) {


        ///
        String ИмяСлужбыУведомленияДляОбновлениеСофт="WorkManager NOtofocationforUpdateSoft";

        try{


            Log.i(context.getClass().getName(), "ЗАПУСК из BroadcastReceiver СЛУЖБА  УВЕДОМЛЕНИЯ  Обновлнение ПО  ДЛя Чата doWork   время "+"\n"
                    +new Date() + " СТАТУС WORKMANAGER" + WorkManager.getInstance(context.getApplicationContext()).getWorkInfosByTag(ИмяСлужбыУведомленияДляОбновлениеСофт));





            Constraints constraintsУведомленияДляОбновлениеПО= new Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .setRequiresBatteryNotLow(false)
                    .setRequiresStorageNotLow(false)
                    .build();
///


            OneTimeWorkRequest periodicWorkRequestУведомленияДляОбновлениеПО=new OneTimeWorkRequest.Builder(MyWork_Notifocations_Уведомления_Для_ОбновлениеПО.class)//MIN_PERIODIC_FLEX_MILLIS
                    .setConstraints(constraintsУведомленияДляОбновлениеПО)
                    .addTag(ИмяСлужбыУведомленияДляОбновлениеСофт)
                    .setBackoffCriteria(
                            BackoffPolicy.LINEAR,
                            4,
                            TimeUnit.MINUTES)
                    //.setInputData(new Data.Builder().putString("КтоЗапустилWorkmanager","BroadCastRecieve").build())
                    .build();



// Queue the work
            WorkManager.getInstance(context.getApplicationContext()).enqueueUniqueWork(ИмяСлужбыУведомленияДляОбновлениеСофт,
                    ExistingWorkPolicy.APPEND_OR_REPLACE,periodicWorkRequestУведомленияДляОбновлениеПО);




            // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата         // TODO: 13.11.2021  ПОКАЗЫВАЕМ СТАТУС ПОСЛЕ ОТРАБОТАНГНЙО WORK MANAGER  ПРИ Уведомления для Чата

          new Handler(Looper.getMainLooper()).post(()->{



            WorkManager.getInstance(context.getApplicationContext()).getWorkInfosByTagLiveData(ИмяСлужбыУведомленияДляОбновлениеСофт).observeForever(new Observer<List<WorkInfo>>() {
                @Override
                public void onChanged(List<WorkInfo> workInfos) {


                    Log.w(context.getClass().getName(), " observeForever observeForever " + "\n" +
                            " ПОСЛЕ ОТРАБОТКИ МЕТОДА ....Внутри  BroadcastReceiver_Sous_Notificatios_UpdateSoft  Бродкастер " + ИмяСлужбыУведомленияДляОбновлениеСофт + "\n"
                            + " getState  " +
                            workInfos.get(0).getState().name() + "\n" +
                            " isFinished  " +
                            workInfos.get(0).getState().isFinished() + "\n" +
                            "getTags " +
                            workInfos.get(0).getTags() + "\n" +
                            "getRunAttemptCount " +
                            workInfos.get(0).getRunAttemptCount() + "\n" +
                            "getProgress " +
                            workInfos.get(0).getState().isFinished() + "\n" +
                            " время : " + new Date());


                    if (workInfos.get(0).getState().compareTo(WorkInfo.State.BLOCKED) == 0) {
                        // TODO: 27.03.2022
                        WorkManager.getInstance(context.getApplicationContext()).cancelAllWorkByTag(ИмяСлужбыУведомленияДляОбновлениеСофт);
                    }


                }
            });

          });







            //////////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(context.getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());;

            Log.e(context.getClass().getName(), "ОШИБКА CATCH  из BroadcastReceiver  СЛУЖБА УВЕДОМЛЕНИЯ для UpdateSoft  в BroadCasrReciver    private void МетодЗапускаWorkManager_УведомленияДляЧата "+e.toString());


        }


    }























}