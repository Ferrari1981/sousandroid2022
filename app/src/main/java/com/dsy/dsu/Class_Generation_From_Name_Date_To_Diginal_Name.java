package com.dsy.dsu;

import static java.util.Calendar.getInstance;

import android.content.Context;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Class_Generation_From_Name_Date_To_Diginal_Name {

    Context contextДляКлассаПереводимИзНазваниеДатыВЦифруМесяцОтвдельноГодОтдельно;

    public Class_Generation_From_Name_Date_To_Diginal_Name(Context context) {

        contextДляКлассаПереводимИзНазваниеДатыВЦифруМесяцОтвдельноГодОтдельно=context;

    }
    //функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ


    //TODO метод получени месяа для записи в одну колонку

    int МетодПолучениниеМесяцПриСозданииНовогоСОтрудника(String ДатаКоторуюНадоПеревестиИзТекставЦифру) throws ParseException {
        ///////
        System.out.println(" " + ДатаКоторуюНадоПеревестиИзТекставЦифру + " " + ДатаКоторуюНадоПеревестиИзТекставЦифру);
        //
        int month = 0;
        ///
        try{

            SimpleDateFormat formatмесяц = new SimpleDateFormat("LLLL  yyyy", new Locale("ru"));

            // formatмесяц.setTimeZone(TimeZone.getTimeZone("UTC-03:00"));
            formatмесяц.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));

            Date date = formatмесяц.parse(ДатаКоторуюНадоПеревестиИзТекставЦифру);

            Calendar calendar = getInstance(new Locale("ru"));

            calendar.setTime(date);

            Calendar calendar2 = new GregorianCalendar();

            calendar.setTime(date);



            if (ДатаКоторуюНадоПеревестиИзТекставЦифру.matches("(.*)Январь(.*)")) {

                month = calendar.get(Calendar.MONTH) +1;

            } else

                month = calendar.get(Calendar.MONTH) + 1;
            ////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(contextДляКлассаПереводимИзНазваниеДатыВЦифруМесяцОтвдельноГодОтдельно).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        ////
        return month;
    }

// TODO: 23.09.2021



    //TODO метод получени месяа для записи в одну колонку

    int МетодПолучениниеГОдПриСозданииНовогоСОтрудника(String ДатаКоторуюНадоПеревестиИзТекставЦифру) throws ParseException {

        System.out.println("ДатаКоторуюНадоПеревестиИзТекставЦифру " + ДатаКоторуюНадоПеревестиИзТекставЦифру);

        int year= 0;

        try{

            SimpleDateFormat formatгод = new SimpleDateFormat("LLLL  yyyy", new Locale("ru"));

            // formatгод.setTimeZone(TimeZone.getTimeZone("UTC-03:00"));
            formatгод.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));

            Date date = formatгод.parse(ДатаКоторуюНадоПеревестиИзТекставЦифру);

            Calendar calendar = getInstance(new Locale("ru"));

            calendar.setTime(date);



            if (ДатаКоторуюНадоПеревестиИзТекставЦифру.matches("(.*)Январь(.*)")) {

                year = calendar.get(Calendar.YEAR);

            } else
                year = calendar.get(Calendar.YEAR);

            ////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(contextДляКлассаПереводимИзНазваниеДатыВЦифруМесяцОтвдельноГодОтдельно).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return year;
    }
    //функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ






}
