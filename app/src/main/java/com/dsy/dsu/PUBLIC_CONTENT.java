package com.dsy.dsu;


import android.content.Context;
import android.os.Build;
import android.os.Handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;

;


/////--------TODO В ДАННОМ КЛАССЕ СОБРАНЫ ВСЕ СТАТИЧЕСКИЕ ПЕРЕМЕННЫЕ ДЛЯ РАБОТЫ ВСЕГО ПРИЛОЖЕНИЯ DSU-1  ( И БОЛЬШНЕ В КЛАСЕ НИЧЕГО НЕТ )
public  class PUBLIC_CONTENT extends CREATE_DATABASE {

            // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК
    // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК
    // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК   // TODO: 13.10.2021  НОРМАЛЬНЫЕ ПЕРЕМЕННЫЕ --НЕ СТАТИК


    // TODO: 26.08.2021  МЕНЕДЖЕР ПОТОКВ ДЛЯ GRUD ОПЕРАЦИЙ
            //////////
            CompletableFuture completableFutureМенеджер;




                ScheduledFuture scheduledFuture;

                public LinkedBlockingQueue<String> ИменаТаблицыОтАндройда = new LinkedBlockingQueue<String>();

    ///////////
    public ArrayList<String> ИменаПроектовОтСервера = new ArrayList<String>(); ////список проектов


    ////ГЛАВНЫЙ СПИСОК ТАБЛИЦ ДЛЯ  ОБМЕНАМИ ДАННЫМИ ИЗ НЕГО БУДЕТ БРАТЬСЯ СПИСКО ТАБЛИЦ
    public Map<String, Long> ДатыТаблицыВерсииДанныхОтСервера = Collections.synchronizedMap(new LinkedHashMap<String, Long>());


                // TODO: 26.08.2021  конструктор
           public    CompletionService МенеджерПотоков;

    public Handler.Callback callback;


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




