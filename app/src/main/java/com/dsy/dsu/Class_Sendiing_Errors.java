package com.dsy.dsu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

public class Class_Sendiing_Errors {

    Context contextДляПосыланиеОшибок;
    ////

    public Class_Sendiing_Errors(Context context) {
        //
        contextДляПосыланиеОшибок=context;

    }
    //функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ


    void МетодПослываемОшибкиАдминистаторуПо(StringBuffer ЗаписьОшибковВстврочку,Activity activity) {
        try {

            // TODO: 11.05.2021  почта для ошибок
            /// errorstimekeeping@gmail.com

            Intent ИнтентЧтобыСослатьОшибкиНаПочту = new Intent(Intent.ACTION_SEND);

            if (ЗаписьОшибковВстврочку!=null) {

                ИнтентЧтобыСослатьОшибкиНаПочту.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                ИнтентЧтобыСослатьОшибкиНаПочту.setData(Uri.parse("mailto::errorstimekeeping@gmail.com"));

                ИнтентЧтобыСослатьОшибкиНаПочту.setType("message/rfc822");
                //i.setType("text/html");
                ИнтентЧтобыСослатьОшибкиНаПочту.putExtra(Intent.EXTRA_CC, new String[]{"errorstimekeeping@gmail.com"});

                ИнтентЧтобыСослатьОшибкиНаПочту.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                ИнтентЧтобыСослатьОшибкиНаПочту.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

                ИнтентЧтобыСослатьОшибкиНаПочту.putExtra(Intent.EXTRA_EMAIL, new String[]{"errorstimekeeping@gmail.com"});

                ИнтентЧтобыСослатьОшибкиНаПочту.putExtra(Intent.EXTRA_SUBJECT, "Ошибки посылаем Администатору ПО Табельный  Учёт");

                ИнтентЧтобыСослатьОшибкиНаПочту.putExtra(Intent.EXTRA_TEXT, ЗаписьОшибковВстврочку.toString());
            }

            // TODO: 01.09.2021 КОД ПОСЫЛАЕМ НА ПОЧТУ ДАННЫЕ

                activity.startActivity(Intent.createChooser(ИнтентЧтобыСослатьОшибкиНаПочту, "Отправка на Почту......"));


                activity.finish();



            //ловим ошибку
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(contextДляПосыланиеОшибок).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            //закрытие классса и метода
        }


    }
}


