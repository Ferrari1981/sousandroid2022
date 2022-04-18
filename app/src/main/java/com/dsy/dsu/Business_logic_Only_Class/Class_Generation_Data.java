package com.dsy.dsu.Business_logic_Only_Class;

import android.content.Context;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Class_Generation_Data {

    Context contextДляКлассаВремени;

    public Class_Generation_Data(Context context) {

        contextДляКлассаВремени=context;

    }
    //функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ
    public String ГлавнаяДатаИВремяОперацийСБазойДанных() {

        Date Дата = null;
        DateFormat dateFormat = null;//"yyyy-MM-dd HH:mm:ss.SSS"//"yyyy-MM-dd'T'HH:mm:ss'Z'"
        try {
            Дата = Calendar.getInstance().getTime();

            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", new Locale("ru"));

            dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));

            Log.d(this.getClass().getName(), " ГЛАВНАЯ ДАТА ПРОГРАММЫ ДСУ-1 : " + dateFormat.format(Дата));

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(contextДляКлассаВремени).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return dateFormat.format(Дата);
    }
}
