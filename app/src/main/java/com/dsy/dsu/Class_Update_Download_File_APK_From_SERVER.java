package com.dsy.dsu;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


class Class_Update_Download_File_APK_From_SERVER {


    String ТипПодключенияИнтернтаДляСлужбы;

   Integer СервернаяВерсияПОВнутри=0;
   ////
  Integer ЛокальнаяВерсияПО=0;

  String PROCESS_ID_UpdateSoft="19";

Context context;
//
    Activity activity;

    public Class_Update_Download_File_APK_From_SERVER(Context contextВнутри, Activity activityВнутри) {
        ////
        //todo

        context= contextВнутри;

        activity=activityВнутри;


    }
    ////





    // TODO: 02.04.2021 update service po

    void МетодНачалаЗапускаОбновленияПО(Integer СервернаяВерсияПОВнутриИзСлужбы) throws ExecutionException, InterruptedException {
        ////////

        Log.w(this.getClass().getName(), "   МетодНачалаЗапускаОбновленияПО СервернаяВерсияПОВнутри "+ СервернаяВерсияПОВнутри  );
                try {

                    СервернаяВерсияПОВнутри = СервернаяВерсияПОВнутриИзСлужбы;


                    /////todo NOtofication
                    Vibrator v2 = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        v2.vibrate(600);
                    }

                    Log.i(this.getClass().getName(), "СервернаяВерсияПОВнутри " + СервернаяВерсияПОВнутри +
                            " СервернаяВерсияПОВнутриИзСлужбы" + СервернаяВерсияПОВнутриИзСлужбы);

                    ////todo сам код
                    МетодОценкииСетиПередЗагрузкойAPKсСервера();

                    // TODO: 12.05.2021 вторая часть









                ///TODO загруузка приложения  с сервера производиться только когда WIFI



            if (ТипПодключенияИнтернтаДляСлужбы != null) {

                Log.i(this.getClass().getName(), "ТипПодключенияИнтернтаДляСлужбы " + ТипПодключенияИнтернтаДляСлужбы);

                if (ТипПодключенияИнтернтаДляСлужбы.equals("WIFI")  || ТипПодключенияИнтернтаДляСлужбы.equals("Mobile")  ) {





                    //TODO СНАЧАЛА АНАЛИЗИРУЕМ ПРИШЕДНИЙ ФАЙЛ JSON c ВЕРСИЕЙ ДАННЫХ ЕСЛИ ВЕРСИЯ ДАННЫХ НА СЕРВЕР ВЫШЕ ТОГДА ЗАПУСКАЕМ ОБНОВЛЕНЕИ ПРОГРАММНОГО О ВТОРОЙ ЭТАП




///TODO РАБОТА НЕПОСТРДСТВЕННО УЖЕ С .apk
                    МетодОпределнияВерсийПОСервераКлиентаИПринятиеРешенияНаСкачиваниеОбновлениеПО();

                    Log.i(this.getClass().getName(), "МетодОпределнияВерсийПОСервераКлиентаИПринятиеРешенияНаСкачиваниеОбновлениеПО " );

                }else {
                    Log.e(this.getClass().getName(), "неТ СВЯЗИ ДЛЯ ЗАГРУЗКИ ПО ТипПодключенияИнтернтаДляСлужбы "  +ТипПодключенияИнтернтаДляСлужбы  );

                }
                //////
                /////


            }






                } catch (Exception e) {
                    //  Block of code to handle errors
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                            + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                            Thread.currentThread().getStackTrace()[2].getLineNumber());
                }


    }


    void МетодУдалениеСамогоФайлаПрограммыПОТальныйУчётПО_APK() {

        try {


/////TODO  УДАЛЕНИЕ .JSON ФАЙЛА
            /*   File  ФайлыДляОбновлениеПОУдаление = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS + "/" + "*.apk");
*/
            File ФайлыДляОбновлениеПОУдалениеСамФайлJSon = null;

            File[] FilesФайлыУдаления;


            if (Build.VERSION.SDK_INT >= 30) {
                ФайлыДляОбновлениеПОУдалениеСамФайлJSon = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            } else {

                ФайлыДляОбновлениеПОУдалениеСамФайлJSon = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS);

            }
            FilenameFilter filenameFilter1 = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    // TODO: 31.03.2022
                    if (!name.isEmpty()) {
                        Boolean ЕслиТАкойФайл = name.matches("(.*)update_dsu1(.*)");
                        // TODO: 31.03.2022
                        Log.i(this.getClass().getName(), " fileName" + name);
                        // TODO: 31.03.2022
                        if (ЕслиТАкойФайл) {
                            // TODO: 31.03.2022
                            // TODO: 31.03.2022
                            Log.i(this.getClass().getName(), " fileName" + name + "ЕслиТАкойФайл " + ЕслиТАкойФайл);
                            return true;
                        }

                    }
                    return false;
                }
            };

            // TODO: 01.04.2022
            Log.i(this.getClass().getName(), " Files1[i] " + " ФайлыДляОбновлениеПОУдалениеСамФайлJSon " + ФайлыДляОбновлениеПОУдалениеСамФайлJSon);


            // TODO: 01.04.2022 two


            FilenameFilter filenameFilter2 = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    // TODO: 31.03.2022
                    if (!name.isEmpty()) {
                        Boolean ЕслиТАкойФайл = name.matches("(.*)app-release(.*)");
                        // TODO: 31.03.2022
                        Log.i(this.getClass().getName(), " fileName" + name);
                        // TODO: 31.03.2022
                        if (ЕслиТАкойФайл) {
                            // TODO: 31.03.2022
                            // TODO: 31.03.2022
                            Log.i(this.getClass().getName(), " fileName" + name + "ЕслиТАкойФайл " + ЕслиТАкойФайл);
                            return true;
                        }

                    }
                    return false;
                }
            };
            // TODO: 01.04.2022 удалепние файлов
            // TODO: 01.04.2022
            Log.i(this.getClass().getName(), " Files1[i] " + " ФайлыДляОбновлениеПОУдалениеСамФайлJSon " + ФайлыДляОбновлениеПОУдалениеСамФайлJSon);


            // TODO: 01.04.2022  tree

            // TODO: 01.04.2022 удалепние файлов
            // TODO: 01.04.2022 удалепние файлов
            FilesФайлыУдаления = ФайлыДляОбновлениеПОУдалениеСамФайлJSon.listFiles(filenameFilter1);
            // TODO: 01.04.2022 удалепние файлов
            FilesФайлыУдаления = ФайлыДляОбновлениеПОУдалениеСамФайлJSon.listFiles(filenameFilter2);
            // TODO: 01.04.2022 удалепние файлов
            // TODO: 01.04.2022 удалепние файлов
            if (ФайлыДляОбновлениеПОУдалениеСамФайлJSon.exists() == true) {
                // TODO: 01.04.2022
                // TODO: 01.04.2022
                Log.i(this.getClass().getName(), " Files1[i] " + "  УДЛАЕНИЕ ...  ФайлыДляОбновлениеПОУдалениеСамФайлJSon.length() " + ФайлыДляОбновлениеПОУдалениеСамФайлJSon.length());
                // TODO: 01.04.2022 удалепние файлов
                ФайлыДляОбновлениеПОУдалениеСамФайлJSon.delete();
                // TODO: 01.04.2022 удалепние файлов
                ФайлыДляОбновлениеПОУдалениеСамФайлJSon.deleteOnExit();
            }
            // TODO: 01.04.2022
            for (int i = 0; i < FilesФайлыУдаления.length; i++) {

                // TODO: 01.04.2022
                if (FilesФайлыУдаления[i].exists()) {
                    // TODO: 01.04.2022
                    FilesФайлыУдаления[i].delete();
                    // TODO: 01.04.2022
                    // TODO: 01.04.2022
                    FilesФайлыУдаления[i].deleteOnExit();
                    // TODO: 01.04.2022
                    Log.i(this.getClass().getName(), " Files1[i] " + "  УДЛАЕНИЕ ...  ФайлыДляОбновлениеПОУдалениеСамФайлJSon.length() " + ФайлыДляОбновлениеПОУдалениеСамФайлJSon.length());

                }

            }
// TODO: 02.04.2022  метод для удаленя только json  версии файла



            // TODO: 30.03.2022 СМА УДАЛЕНИЕ ФАЙЛОВ


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                   new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

            Log.d(this.getClass().getName(), " ОШИБКА work manager Обновление ПО onDestroy() Exception ");


        }
    }


    void МетодУдалениеИнформационогоТекстовогоФайлаJSONДляПО() {

        try {


/////TODO  УДАЛЕНИЕ .JSON ФАЙЛА


            File ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо = null;

            File[] FilesФайлыУдаленияДляФайлаJSONАнализаВерсии;


            if (Build.VERSION.SDK_INT >= 30) {
                ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            } else {

                ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS);

            }
            FilenameFilter filenameFilter1 = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    // TODO: 31.03.2022
                    if (!name.isEmpty()) {
                        Boolean ЕслиТАкойФайл = name.matches("(.*)output-metadata.json(.*)");
                        // TODO: 31.03.2022
                        Log.i(this.getClass().getName(), " fileName" + name);
                        // TODO: 31.03.2022
                        if (ЕслиТАкойФайл) {
                            // TODO: 31.03.2022
                            // TODO: 31.03.2022
                            Log.i(this.getClass().getName(), " fileName" + name + "ЕслиТАкойФайл " + ЕслиТАкойФайл);
                            return true;
                        }

                    }
                    return false;
                }
            };

            // TODO: 01.04.2022
            Log.i(this.getClass().getName(), " Files1[i] " + " ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо " + ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо);


            // TODO: 01.04.2022 two


            FilenameFilter filenameFilter2 = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    // TODO: 31.03.2022
                    if (!name.isEmpty()) {
                        Boolean ЕслиТАкойФайл = name.matches("(.*)analysis_version(.*)");
                        // TODO: 31.03.2022
                        Log.i(this.getClass().getName(), " fileName" + name);
                        // TODO: 31.03.2022
                        if (ЕслиТАкойФайл) {
                            // TODO: 31.03.2022
                            // TODO: 31.03.2022
                            Log.i(this.getClass().getName(), " fileName" + name + "ЕслиТАкойФайл " + ЕслиТАкойФайл);
                            return true;
                        }

                    }
                    return false;
                }
            };
            // TODO: 01.04.2022 удалепние файлов
            // TODO: 01.04.2022
            Log.i(this.getClass().getName(), " Files1[i] " + " ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо " + ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо);

            // TODO: 01.04.2022 удалепние файлов
            FilesФайлыУдаленияДляФайлаJSONАнализаВерсии = ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо.listFiles(filenameFilter1);
            // TODO: 01.04.2022 удалепние файлов
            FilesФайлыУдаленияДляФайлаJSONАнализаВерсии = ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо.listFiles(filenameFilter2);
            // TODO: 01.04.2022 удалепние файлов
            // TODO: 01.04.2022 удалепние файлов
            if (ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо.exists() == true) {
                // TODO: 01.04.2022
                // TODO: 01.04.2022
                Log.i(this.getClass().getName(), " Files1[i] " + "  УДЛАЕНИЕ ...  ФайлыДляОбновлениеПОУдалениеПриАнализеJSONВерсии.length() " + ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо.length());
                // TODO: 01.04.2022 удалепние файлов
                ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо.delete();
                // TODO: 01.04.2022 удалепние файлов
                ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо.deleteOnExit();
            }
            // TODO: 01.04.2022
            for (int i = 0; i < FilesФайлыУдаленияДляФайлаJSONАнализаВерсии.length; i++) {

                // TODO: 01.04.2022
                if (FilesФайлыУдаленияДляФайлаJSONАнализаВерсии[i].exists()) {
                    // TODO: 01.04.2022
                    FilesФайлыУдаленияДляФайлаJSONАнализаВерсии[i].delete();
                    // TODO: 01.04.2022
                    // TODO: 01.04.2022
                    FilesФайлыУдаленияДляФайлаJSONАнализаВерсии[i].deleteOnExit();
                    // TODO: 01.04.2022
                    Log.i(this.getClass().getName(), " Files1[i] " + "  УДЛАЕНИЕ ...  ФайлыДляОбновлениеПОУдалениеПриАнализеJSONВерсии.length() " + ФайлыДляУдаланиеИнформационогоТестовогоФайлаJSON_дляПо.length());

                }

            }


            // TODO: 30.03.2022 СМА УДАЛЕНИЕ ФАЙЛОВ


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

            Log.d(this.getClass().getName(), " ОШИБКА work manager Обновление ПО onDestroy() Exception ");


        }
    }



    ////TODO АНАЛИЗИРУЕМ ПРИШЕДШИЙ ФАЙЛ И ПРИНИМАЕМ РЕШЕНИЕ НА СКАЧИВАНЕИ ФАЙЛА ИЛИ НЕТ



    private void МетодОпределнияВерсийПОСервераКлиентаИПринятиеРешенияНаСкачиваниеОбновлениеПО() {

                try {


///////////TODO ПРИСТУПАЕМ К ЗАПУСКУ ОБНОВЛЕНИЕ ФАЙЛА . APK ТОЛЬКО КОГДА ВЕРСИЯ ДАННЫХ НА СЕРВЕРЕ БОЛЬШЕ ЧЕМ НА КЛИЕНТЕ (Android)
                        ///

                            МетодЗагрузкиФайлаAPK();
///////

                            Log.d(this.getClass().getName(), "  СЛУЖБА ЗАПУСКАЕМ...  Обновление  ПО .APK " +
                                    " ЛокальнаяВерсияПО " + ЛокальнаяВерсияПО + "СервернаяВерсияПОВнутри " + СервернаяВерсияПОВнутри);


////////////

                } catch (Exception e) {
                    //  Block of code to handle errors
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                            + Thread.currentThread().getStackTrace()[2].getLineNumber());
                           new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                            Thread.currentThread().getStackTrace()[2].getLineNumber());
                }



        //////hedler end
    }


    private void МетодОценкииСетиПередЗагрузкойAPKсСервера() {



        try {

            /////todo тут МЫ ПОЛУЧАЕМ В КАКОЙ МОМЕНТ ТИП ПОДКЛЮЧЕНИЯ НА ТЕЛЕФОНЕ МОБИЛЯ ИЛИ  WIFI  И В ЗАВИСИМОСТИ ЧТОБЫ ПОНЯТЬ ЧЕ ЗА ДЕЛА



/*
       boolean  РезультатЕслиСвязьСерверомДСУ1 =        new Class_Connections_Server(context).МетодПингаСервераРаботаетИлиНет(context);

            //TODO ФУТУРЕ ЗАВЕРШАЕМ
            Log.d(this.getClass().getName(), "  РезультатЕслиСвязьСерверомДСУ1" + РезультатЕслиСвязьСерверомДСУ1);


            // TODO: 09.09.2021 rsultat


            if (РезультатЕслиСвязьСерверомДСУ1 == true) {*/


                ТипПодключенияИнтернтаДляСлужбы = null;

                ///
                ТипПодключенияИнтернтаДляСлужбы = МетодОпределяемКакойТипПодключениеWIFIилиMobileДляСлужбы(context);

                Log.d(this.getClass().getName(), " ТипПодключенияИнтернтаДляСлужбы  " + ТипПодключенияИнтернтаДляСлужбы);


 /*           }*/


            ///////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
                   new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }


    }











    ////TODO


    protected void МетодЗагрузкиФайлаAPK() {
        ///

        try {
            Log.d(this.getClass().getName(), " СЛУЖБА ... МЕТОД ОБНОВЛЕНИЯ ПО РАБОТАЕТ......"+new Date());
            //////TODO вторая часть ЕСЛИ ВЕРСИЯ ПРОГРАМЫ НА СЕРВЕРЕ ВЫШЕ ЧЕМ НА АЕДРОЙДЕ ТО ЗАПУСКАЕМ  ЗАГРУЗКИ ПРИЛОЖЕНИЯ (НАПРИМЕР НА АНДРОЙДЕ 102 , А НА СЕРВЕРЕ 103, 104,итд.)

                File  ФайлыДляОбновлениеПО=null;


                        Log.d(this.getClass().getName(), "    ПУТИ В ФАЙЛУ   " + "\n"
                        + ФайлыДляОбновлениеПО);


                PackageInfo ИнформацияОФайле =null;

            // TODO: 02.04.2022 зпускаем работут по анализу  СКАЧКИ ПРОГРАММЫ ТАБЕЛТНЫЙ УЧЁТ С СЕРВЕРА


                    ///TODO загрузка apk ФАЙЛА

                    МетодНепостредственннойЗагрузкиAPKФайлов(ФайлыДляОбновлениеПО, ИнформацияОФайле);


                    ////TODO после успешного  СКАЧЧИВАНИЯ ФАЙЛА МЫ С ОТЛОЖЕНИЕ В 10 СЕКУНД УСТАНВЛИВАЕМ ФАЙЛ
                    ////TODO после успешного  СКАЧЧИВАНИЯ ФАЙЛА МЫ С ОТЛОЖЕНИЕ В 10 СЕКУНД УСТАНВЛИВАЕМ ФАЙЛ
                    ////TODO после успешного  СКАЧЧИВАНИЯ ФАЙЛА МЫ С ОТЛОЖЕНИЕ В 10 СЕКУНД УСТАНВЛИВАЕМ ФАЙЛ

                   /// МетодКоторыйЗапускаетОбновлениеПООтложенныйЗапускна10Секунд();


            ///////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
                   new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }











    private void МетодНепостредственннойЗагрузкиAPKФайлов(File файлыДляОбновлениеПО, PackageInfo info) throws IOException {

        try {
            String Adress_String;


/////TODO  загрузка ФАЙЛ.APK ФАЙЛА


            Log.i(this.getClass().getName(), "Запускаем только начало  Observable УниверсальныйБуферAPKФайлаПОсСервера=Observable.fromCallable............ ");


            final File[] УниверсальныйБуферAPKФайлаПОсСервераВнутри = {null};

            ////TODO НАЧИНАЕМ ЗАГРУЗКИ С ИНТРЕНТА ФАЙЛ А ЕСЛИ ТОЛЬКО ЕГО НЕТ УЖЕ НА КЛИЕНТЕ

            Observable УниверсальныйБуферAPKФайлаПОсСервера = Observable.fromCallable(new Callable<File>() {
                @Override
                public File call() throws Exception {

                    // TODO: 19.12.2021  загрузка файда  .apk

                    УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] = new MODEL_synchronized(context).
                            УниверсальныйБуферAPKФайлаПОсСервера("dsu1.glassfish/update_android_dsu1/app-release.apk", "update_dsu1.apk", context, "tabel.dsu1.ru", 8888);


                    Log.i(this.getClass().getName(), "УниверсальныйБуферAPKФайлаПОсСервераВнутри файл записалься на диск   Observable УниверсальныйБуферAPKФайлаПОсСервера = Observable.fromCallable(new Callable<File>()  " +
                            "  УниверсальныйБуферAPKФайлаПОсСервераВнутри " +
                            "\n" + "     УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] " + УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] +
                            "\n"+ " Thread.currentThread().getName() " +Thread.currentThread().getName());

// TODO: 18.12.2021
                    return УниверсальныйБуферAPKФайлаПОсСервераВнутри[0];
                }
            })
                    .flatMap(Observable::fromArray)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());


            // TODO: 18.12.2021
            УниверсальныйБуферAPKФайлаПОсСервера.subscribe(new Observer() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    Log.i(this.getClass().getName(), "УниверсальныйБуферAPKФайлаПОсСервераВнутри файл записалься на диск     УниверсальныйБуферAPKФайлаПОсСервера.subscribe  " +
                            "  УниверсальныйБуферAPKФайлаПОсСервераВнутри " +
                            "\n" + "     УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] " + УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] +
                            "\n"+ " Thread.currentThread().getName() " +Thread.currentThread().getName());


                    Activity activity = null;
                    ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
                    List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
                    try {


                        Log.w(this.getClass().getName(), "УниверсальныйБуферAPKФайлаПОсСервераВнутри localBroadcastManagerОтправляемНаActivityFaceApp "
                                + " СервернаяВерсияПОВнутри " + СервернаяВерсияПОВнутри);

                        String namaa = taskInfo.get(0).topActivity.getClassName().toString();

                        Class<?> myClass = Class.forName(namaa);
                        activity = (Activity) myClass.newInstance();
                        // TODO: 19.12.2021
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "Загрузка..."
                                        + "\n" + "ПО Табельный учёт" + "\n", Toast.LENGTH_LONG).show();
                            }
                        });
                    } catch (Exception e) {
                        //  Block of code to handle errors
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());

                    }

                }

                @Override
                public void onNext(@androidx.annotation.NonNull Object o) {
                    // TODO: 18.12.2021 \

                    Log.i(this.getClass().getName(), "УниверсальныйБуферAPKФайлаПОсСервераВнутри файл записалься на диск     onNext " +
                            "  УниверсальныйБуферAPKФайлаПОсСервераВнутри " +
                            "\n" + "     УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] " + УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] +
                            "\n"+ " Thread.currentThread().getName() " +Thread.currentThread().getName());
// TODO: 18.12.2021

                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.e(this.getClass().getName(), "УниверсальныйБуферAPKФайлаПОсСервераВнутри файл записалься на диск    onError" +
                            "  УниверсальныйБуферAPKФайлаПОсСервераВнутри " +
                            "\n" + "     УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] " + УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] +
                            "\n" + " Thread.currentThread().getName() " + Thread.currentThread().getName());
// TODO: 18.12.2021

                }

                // TODO: 25.03.2022

                @Override
                public void onComplete() {
                    //////////todo такой файл УЖЕ ЕСТЬ .APK И ПЫТАЕТЬСЯ ЕЩЁ РАЗ ЗАГРУЗИТЬСЯ
                    Log.w(this.getClass().getName(), "УниверсальныйБуферAPKФайлаПОсСервераВнутри файл записалься на диск    onComplete" +
                            "  УниверсальныйБуферAPKФайлаПОсСервераВнутри " +
                            "\n" + "     УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] " + УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] +
                            "\n" + " Thread.currentThread().getName() " + Thread.currentThread().getName());
                    //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ


                    if (УниверсальныйБуферAPKФайлаПОсСервераВнутри[0].length() > 0) {

                        // TODO: 20.12.2021

                        try {


// TODO: 25.03.2022 ТУТ МЫ ОТПРВЯЛЕМ ВЕРИСЮ ДАННЫХ И ФАЙЛ ПРИУСТАВНВОЕ по ТАБЕЛЬНЫЙ УЧЁТ

                            Intent intentДляУстановеПО = new Intent();
                            // TODO: 25.03.2022
                            intentДляУстановеПО.setAction("CompletePO");
                            // TODO: 25.03.2022
                            Bundle bundleУстановитьПО = new Bundle();
                            // TODO: 25.03.2022
                            bundleУстановитьПО.putInt("СервернаяВерсияПОВнутри", СервернаяВерсияПОВнутри);
                            // TODO: 25.03.2022
                            bundleУстановитьПО.putSerializable("СервернаяВерсияПОCамФайлДляПередачи", УниверсальныйБуферAPKФайлаПОсСервераВнутри[0]);
                            // TODO: 25.03.2022
                            bundleУстановитьПО.putLong("СервернаяВерсияПОРазмерФайла", УниверсальныйБуферAPKФайлаПОсСервераВнутри[0].length());
                            // TODO: 25.03.2022
                            intentДляУстановеПО.putExtras(bundleУстановитьПО);

                            Log.w(this.getClass().getName(), "УниверсальныйБуферAPKФайлаПОсСервераВнутри файл записалься на диск   bundleУстановитьПО  " + bundleУстановитьПО);
                            // TODO: 25.03.2022  локальный бродкастер
                            LocalBroadcastManager localBroadcastManagerОтправляемНаActivityFaceApp = LocalBroadcastManager.getInstance(context);
                            // TODO: 25.03.2022
                            localBroadcastManagerОтправляемНаActivityFaceApp.sendBroadcast(intentДляУстановеПО);
                            // TODO: 25.03.2022

                            Log.w(this.getClass().getName(), "УниверсальныйБуферAPKФайлаПОсСервераВнутри localBroadcastManagerОтправляемНаActivityFaceApp " + localBroadcastManagerОтправляемНаActivityFaceApp
                                    + " СервернаяВерсияПОВнутри " + СервернаяВерсияПОВнутри);


                            Activity activity = null;
                            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
                            List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
                            try {

                                String namaa = taskInfo.get(0).topActivity.getClassName().toString();

                                Class<?> myClass = Class.forName(namaa);
                                activity = (Activity) myClass.newInstance();
                                // TODO: 19.12.2021
                                activity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(context, "Успешно загрузилась"
                                                + "\n" + "ПО Табельный учёт в." + "\n" +
                                                +СервернаяВерсияПОВнутри, Toast.LENGTH_LONG).show();
                                    }
                                });
                            } catch (Exception e) {
                                //  Block of code to handle errors
                                e.printStackTrace();
                                ///метод запись ошибок в таблицу
                                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                        Thread.currentThread().getStackTrace()[2].getLineNumber());

                            }


                        } catch (Exception e) {
                            //  Block of code to handle errors
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                    Thread.currentThread().getStackTrace()[2].getLineNumber());

                        }


                    }

                }



            });
// TODO: 18.12.2021
        /*    УниверсальныйБуферAPKФайлаПОсСервера.toFuture().get();

            // TODO: 20.12.2021


            //////////todo такой файл УЖЕ ЕСТЬ .APK И ПЫТАЕТЬСЯ ЕЩЁ РАЗ ЗАГРУЗИТЬСЯ
            Log.i(this.getClass().getName(), " УСПЕШНО ЗАШРУЗИЛОСЬ" +
                    "УниверсальныйБуферAPKФайлаПОсСервераВнутри файл записалься на диск Телефона  УниверсальныйБуферAPKФайлаПОсСервера.toFuture().get(30, TimeUnit.SECONDS  УниверсальныйБуферAPKФайлаПОсСервераВнутри " + "\n" +
                    " УниверсальныйБуферAPKФайлаПОсСервераВнутри[0] " + УниверсальныйБуферAPKФайлаПОсСервераВнутри[0].length());*/


        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }


        // TODO: 20.12.2021


    }


    // TODO: 02.04.2022  метод анализа


    // TODO: 28.12.2021  МЕТОД ПОКАЗЫВАЕМ ПОЛЬЗОВАТЕЛЮ ЗАГРУЖЕННЫЙ файл обновления\




















    ////TODO метод который отпредеяеть КАКОЙ ТИП ПОДКЛЮЧЕНИ К ИНТРЕНТУ ЧЕРЕЗ WIFI ИЛИ MOBILE
    private String МетодОпределяемКакойТипПодключениеWIFIилиMobileДляСлужбы(Context КонтекстКоторыйДляСинхронизации) {

        try{

        ConnectivityManager cm = (ConnectivityManager) КонтекстКоторыйДляСинхронизации.getSystemService(Context.CONNECTIVITY_SERVICE);
        ////////
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);


        if ( wifiInfo.isConnected()) {

            Log.d(MODEL_synchronized.class.getName(), " подключние к интренту через wifi");

            return "WIFI";
        }else{

            //

            ////////
            NetworkInfo wifiInfoMObile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (wifiInfoMObile.isConnected()) {

                Log.d(MODEL_synchronized.class.getName(), " подключние к интренту через mobile");

                return "Mobile";
            }
        }



    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());
    }

        return null;
    }

    ///TODO  конец  методы перерд перед  СИНХРОНИЗАЦИЯ ///TODO СИНХРОНИЗАЦИЯ при запуске прилиложения

































}











