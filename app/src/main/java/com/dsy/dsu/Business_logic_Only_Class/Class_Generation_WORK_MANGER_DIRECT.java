package com.dsy.dsu.Business_logic_Only_Class;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.dsy.dsu.MyWork_Async_Синхронизация_Общая;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Class_Generation_WORK_MANGER_DIRECT {

    Context contextДляКлассаВремени;

    public Class_Generation_WORK_MANGER_DIRECT(Context context) {

        contextДляКлассаВремени=context;

    }
    //функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ
    public void МетодЗапускаСинхоронизацииИзШироковещательногоПриёмника(@NotNull Context context, Integer ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника) {


        // TODO: 15.12.2021




        String ИмяСлужбыСинхронизации="WorkManager Synchronizasiy_Data";

        try{

            Data myDataДляОбщейСинхрониазации = new Data.Builder()
                    .putInt("КтоЗапустилWorkManagerДляСинхронизации", ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника)
                    .build();


            Constraints constraintsСинхронизация= new Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .setRequiresBatteryNotLow(false)
                    .setRequiresStorageNotLow(false)
                    .build();
            ///
         /*   Activity activity = null;
      ;
            new MyWork_Async_Синхронизация_Общая(context.getApplicationContext(),null,activity ).getClass()*/


            // TODO: 15.12.2021


            PeriodicWorkRequest   periodicWorkRequestСинхронизация = new PeriodicWorkRequest.Builder(MyWork_Async_Синхронизация_Общая.class,
                        PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, TimeUnit.MILLISECONDS)//MIN_PERIODIC_FLEX_MILLIS////  PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, TimeUnit.MILLISECONDS
                        .addTag(ИмяСлужбыСинхронизации)
                        .setInputData(myDataДляОбщейСинхрониазации)
                        .setConstraints(constraintsСинхронизация)
                        .setBackoffCriteria(
                                BackoffPolicy.LINEAR,
                                1,
                                TimeUnit.MINUTES)
                        //    .setInputData(new Data.Builder().putString("КтоЗапустилWorkmanager","BroadCastRecieve").build())
                        .build();


// TODO: 23.11.2021 --ГЛАВНЫЙ ЗАПУСКАЮЩИЙ КОД СЛУЖБЫ СИНХРОНИЗАЦИИ

                            // Queue the work

                            WorkManager.getInstance(context.getApplicationContext()).enqueueUniquePeriodicWork(ИмяСлужбыСинхронизации,
                                    ExistingPeriodicWorkPolicy.REPLACE, periodicWorkRequestСинхронизация);




            // TODO: 13.11.2021

            // TODO: 15.12.2021
            Log.w(context.getClass().getName(), " ПОСЛЕ ОТРАБОТКИ МЕТОДА ....Внутри BroadcastReceiver_Sous_Asyns_Glassfish  periodicWorkRequestСинхронизация.getId() "
                    + periodicWorkRequestСинхронизация.getId() + "\n");


            // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления



          new Handler(Looper.getMainLooper()).post(()->{


            WorkManager.getInstance(context).getWorkInfosByTagLiveData(ИмяСлужбыСинхронизации).observeForever(new Observer<List<WorkInfo>>() {
                @Override
                public void onChanged(List<WorkInfo> workInfos) {


// TODO: 03.02.2022
                Integer    CallBaskОтWorkManagerОбщейСинхрониазции=    workInfos.get(0).getOutputData().getInt("ОтветПослеВыполения_MyWork_Async_Синхронизация_Одноразовая",0);

                                            // TODO: 03.02.2022
                        if(CallBaskОтWorkManagerОбщейСинхрониазции==null){

                            CallBaskОтWorkManagerОбщейСинхрониазции=0;
                        }


                    // TODO: 03.02.2022

                    Long РезультатОбщейСинхрониазацииОтветПользователю=  workInfos.get(0).getOutputData().getLong("ОтветПослеВыполения_MyWork_Async_ОБЩЕЙ_Синхронизация",0l);

                    // TODO: 03.02.2022
                    if(РезультатОбщейСинхрониазацииОтветПользователю==null){

                        РезультатОбщейСинхрониазацииОтветПользователю=0l;
                    }



                    Log.w(context.getClass().getName(), " observeForever observeForever \" +\"\\n\"+" +
                            " ПОСЛЕ ОТРАБОТКИ МЕТОДА ....Внутри  .Внутри BroadcastReceiver_Sous_Asyns_Glassfish " +ИмяСлужбыСинхронизации +"\n"
                            + " getState  "+
                            workInfos.get(0).getState().name()+"\n"+
                            " isFinished  " +
                            workInfos.get(0).getState().isFinished() + "\n" +
                            "getTags " +
                            workInfos.get(0).getTags() + "\n" +
                            "getRunAttemptCount " +
                            workInfos.get(0).getRunAttemptCount() + "\n" +
                            "getProgress " +
                            workInfos.get(0).getState().isFinished() + "\n" +
                            " время : " + new Date() + "\n" +
                            " ПУБЛИЧНЫЙ ID КТО ЗАПУСТИЛ ОБЩУЮ СИНХРОНИАЗЦИЮ  CallBaskОтWorkManagerОбщейСинхрониазции " + CallBaskОтWorkManagerОбщейСинхрониазции + "\n" +
                            "  СallBaksPublicAsync РезультатОбщейСинхрониазацииОтветПользователю " + РезультатОбщейСинхрониазацииОтветПользователю);

                    // TODO: 27.03.2022


              /*      if (workInfos.get(0).getState().compareTo(WorkInfo.State.BLOCKED) == 0) {
                        // TODO: 27.03.2022
                        WorkManager.getInstance(context.getApplicationContext()).cancelAllWorkByTag(ИмяСлужбыСинхронизации);
                    }
*/

                }
            });
// TODO: 01.03.2022

          });
// TODO: 23.04.2021  запуск синхронизации
            //////////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(context.getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            Log.e(context.getClass().getName(), " ОШИБКА CATCH   из BroadcastReceiver  СЛУЖБА Service СИНХРОНИЗАЦИИ в BroadCasrReciver private void МетодЗапускаСинхоронизацииИзШироковещательногоПриёмника "+e.toString());


        }

    }


    // TODO: 27.12.2021 ЧАТА
    
    


}
