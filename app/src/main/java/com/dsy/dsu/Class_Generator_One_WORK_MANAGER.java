package com.dsy.dsu;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;

import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import org.jetbrains.annotations.NotNull;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ForegroundInfo;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import javax.sql.DataSource;


public class Class_Generator_One_WORK_MANAGER extends  Class_GRUD_SQL_Operations {

    Context contextДляКлассаОдноразоваяСлужба;


    //
    Class_GRUD_SQL_Operations class_grud_sql_operations=null;

    public Class_Generator_One_WORK_MANAGER(Context context) {
        super(context);

        contextДляКлассаОдноразоваяСлужба=context;

        // TODO: 28.12.2021


    }


    // TODO: 28.12.2021 srart one work manager

    public void МетодОдноразовыйЗапускВоерМенеджера(@NotNull Context context, Integer ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника) {

        // TODO: 02.01.2022
        //////
        String ИмяСлужбыСинхронизацииОдноразовая="WorkManager Synchronizasiy_Data Disposable";
        // com.dsy.dsu.providerdatabase


        Uri uri=Uri.parse("content://data/data/com.dsy.dsu/databases/Database DSU-1.db");

        try {

            Data myData = new Data.Builder()
                    .putInt("СообщениеЧатаДляКонктерногоСотрудника", ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника)
                    .build();





            Constraints constraintsЗапускСинхОдноразоваяСлужба = new Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .setRequiresBatteryNotLow(false)
                    .setRequiresStorageNotLow(false)
                    .build();
            ///


            OneTimeWorkRequest      OneTimeWorkЗапускФОновойСинхрониазциииИзНУтриТабеля =
                    new OneTimeWorkRequest.Builder(MyWork_Async_Синхронизация_Одноразовая.class)
                            .setConstraints(constraintsЗапускСинхОдноразоваяСлужба)
                            .setInputData(myData)
                            .addTag(ИмяСлужбыСинхронизацииОдноразовая)
                            .setBackoffCriteria(
                                    BackoffPolicy.LINEAR,
                                    PeriodicWorkRequest.MIN_BACKOFF_MILLIS,
                                    TimeUnit.MILLISECONDS)
                            .build();//      .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)


// Queue the work
        WorkManager.getInstance(context).enqueueUniqueWork(ИмяСлужбыСинхронизацииОдноразовая,
                ExistingWorkPolicy.APPEND_OR_REPLACE, OneTimeWorkЗапускФОновойСинхрониазциииИзНУтриТабеля);
        // WorkManager.getInstance().enqueue(periodicWorkRequest);// workmanager.enqueueUniquePeriodicWork(TAG, ExistingPeriodicWorkPolicy.KEEP, photoCheckWork)


            // TODO: 28.12.2021

            // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления

            WorkInfo ИнформацияОЗапущенойСлужбе= WorkManager.getInstance(context).getWorkInfosByTag(ИмяСлужбыСинхронизацииОдноразовая).get().get(0);

            // TODO: 13.11.2021

            Log.w(contextДляКлассаОдноразоваяСлужба.getClass().getName(), "СТАТУС WorkManager  MyWork_Async_Синхронизация_Одноразовая   "+"\n"
                    + " ИнформацияОЗапущенойСлужбе.getRunAttemptCount())  "+
                    ИнформацияОЗапущенойСлужбе.getRunAttemptCount()+ " ИнформацияОЗапущенойСлужбе.getState().name() "+ ИнформацияОЗапущенойСлужбе.getState().name()+
                    " ИнформацияОЗапущенойСлужбе.getTags() "+ ИнформацияОЗапущенойСлужбе.getTags()+"\n"+
                    " ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника " +ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника);


            Handler handler=new Handler(Looper.getMainLooper());
            // TODO: 28.02.2022
            handler.post(()->{

            WorkManager.getInstance(context).getWorkInfosByTagLiveData(ИмяСлужбыСинхронизацииОдноразовая).observeForever(new Observer<List<WorkInfo>>() {
                @Override
                public void onChanged(List<WorkInfo> workInfos) {


// TODO: 03.02.2022

                    Log.w(context.getClass().getName(), " observeForever observeForever \" +\"\\n\"+" +
                            " ПОСЛЕ ОТРАБОТКИ МЕТОДА ....Внутри  .Внутри BroadcastReceiver_Sous_Asyns_Glassfish  ИмяСлужбыСинхронизацииОдноразовая " +ИмяСлужбыСинхронизацииОдноразовая +"\n"
                            + " getState  "+
                            workInfos.get(0).getState().name()+"\n"+
                            " isFinished  " +
                            workInfos.get(0).getState().isFinished() + "\n" +
                            "getTags "+
                            workInfos.get(0).getTags()+"\n"+
                            "getRunAttemptCount "+
                            workInfos.get(0).getRunAttemptCount()+"\n"+
                            "getProgress "+
                            workInfos.get(0).getState().isFinished()+"\n"+
                            " время : " +new Date());

                }
            });


                // TODO: 28.02.2022

});




















        } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(contextДляКлассаОдноразоваяСлужба).МетодЗаписиВЖурналНовойОшибки(e.toString()
                , this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());
    }

    }


}
