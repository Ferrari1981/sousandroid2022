package com.dsy.dsu;


import android.app.Activity;
import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent; ;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.ToDoubleBiFunction;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;


/////--------TODO В ДАННОМ КЛАССЕ СОБРАНЫ ВСЕ СТАТИЧЕСКИЕ ПЕРЕМЕННЫЕ ДЛЯ РАБОТЫ ВСЕГО ПРИЛОЖЕНИЯ DSU-1  ( И БОЛЬШНЕ В КЛАСЕ НИЧЕГО НЕТ )
public  class PUBLIC_CONTENT extends CREATE_DATABASE {

            // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК
    // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК
    // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК


    // TODO: 26.08.2021  МЕНЕДЖЕР ПОТОКВ ДЛЯ GRUD ОПЕРАЦИЙ
            //////////
            CompletableFuture completableFutureМенеджер;




                ScheduledFuture scheduledFuture;

                LinkedBlockingQueue<String> ИменаТаблицыОтАндройда=new LinkedBlockingQueue<String>();

                ///////////
                ArrayList <String> ИменаПроектовОтСервера= new ArrayList <String>(); ////список проектов


                ////ГЛАВНЫЙ СПИСОК ТАБЛИЦ ДЛЯ  ОБМЕНАМИ ДАННЫМИ ИЗ НЕГО БУДЕТ БРАТЬСЯ СПИСКО ТАБЛИЦ
                Map<String, Long> ДатыТаблицыВерсииДанныхОтСервера=Collections.synchronizedMap(new LinkedHashMap<String, Long>());


                // TODO: 26.08.2021  конструктор
           public    CompletionService МенеджерПотоков;




    // TODO: 11.10.2021  конструктор  публичного  контента  
    public PUBLIC_CONTENT(Context context) {

        super(context);
      //////////todo  ГЛАВНЫЙ МЕНЕДЖЕР ПОТОКОВ ПРОЕКТА
        if (МенеджерПотоков==null) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                ///////s
                МенеджерПотоков=  (CompletionService  )  new ExecutorCompletionService<>(Executors.newWorkStealingPool());
            }else{

                МенеджерПотоков=   (  CompletionService)  new ExecutorCompletionService<>(Executors.newCachedThreadPool());   ;
            }
        }
        ////todo*/



    }



}

///////-------------------------TODO    КЛАСС ВСТАВКИ ОШИБОК------------------




