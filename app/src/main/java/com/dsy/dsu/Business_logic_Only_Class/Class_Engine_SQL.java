package com.dsy.dsu.Business_logic_Only_Class;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dsy.dsu.CREATE_DATABASE;
import com.dsy.dsu.PUBLIC_CONTENT;
import com.dsy.dsu.R;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

;


//////-------TODO  ЭТО ПЕРВЫЙ КОНТРОЛЛЕР КОТОРЫЙ ВИЗУАЛИЗИРУЕТ СИНХРОНИЗАЦИЮ С ПРОГРАССБАРОМ---------------------------------------------------------------


///TODO------------------------------------------------------ ЭТО  ВТОРОЙ КОНТРОЛЛЕР КОТОРЫЙ ЗАПУСКАЕТ СИНХРОНИЗАЦИЮ В ФОНЕ  (ВНУТРИ ПРИЛОЖЕНИЕ)---------------------------------------------------


 public class Class_Engine_SQL extends Class_MODEL_synchronized {

     Context КонтекстСинхроДляКонтроллераВФоне;

     Activity ActivityДляСинхронизацииОбмена;

     Integer ПубличныйРезультатОтветаОтСерврераУспешно = 0;

     Class_GRUD_SQL_Operations class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаID;

     Class_GRUD_SQL_Operations class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаUUIDобваID;

    Integer ГлавноеКоличестовТаблицОбрабатываемВГлавномЦиклеОбмена;

    Float ФиналПроценты = 0f;

    public int УспешноеКоличествоВставокДанныхсСервера;

    public int УспешноеКоличествоОбновлениеДанныхсСервера;

    LinkedBlockingQueue<String> ФлагОбработкаЧастиТаблицНеВсехЗависимостиОбщаяСинхронизацияЗапущенаИлиТолькоЧат=new LinkedBlockingQueue();
    ;
    /////////////


    ///
    // PUBLIC_CONTENT public_contentДатыДляГлавныхТаблицСинхронизации=new PUBLIC_CONTENT(contextСозданиеБАзы);


    private  SQLiteDatabase  Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы=null;



    PUBLIC_CONTENT public_contentДатыДляГлавныхТаблицСинхронизации;


    String КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал=new String();



    Boolean UUIDПолеУжеПроверелиЧерезКурсор=false;
    ///
    Boolean IDПолеУжеПроверелиЧерезКурсор=false;




/*    SQLiteCursor Курсор_УзнатьЕслиНаАндройдеТакойUUID = null;/// ТУТ ОН ЗАПОНИМАЕНТ ПОСЛЕНИЙ UUID НА СТРОЙКИ

    SQLiteCursor Курсор_УзнатьЕслиНаАндройдеТакойID = null;*/

    boolean ФлагУказываетЧтоТОлькоОбработкаТаблицДляЧАТА = false;

    ///
    String ФлагКакуюЧастьСинхронизацииЗапускаем =new String();

    //TODO версия данных с сервера

    Long РезультатВерсииДанныхЧатаНаСервере=0l;


    // TODO: 08.09.2021  КЛАСС СИНХРОНИАЗЦИИ ФОНОВОЙ


    ///TODO  UPDATE КОНТЕЙНЕРЫ
    ContentValues АдаптерПриОбновленияДанныхсСервера=null;


    ///TODO  INSERT КОНТЕЙНЕРЫ
    ContentValues   АдаптерДляВставкиДанныхсСервер=null;

    ///TODO  BULK  INSERT КОНТЕЙНЕРЫ
    ContentValues[] АдаптерДляМассовойВставкиДанныхсСервер=null;




    Integer ИндексТекущейОперацииJSONДляВизуальнойОбработки=0;

    Integer ИндексТекущейОперацииРеальногРезультатОбработкиАтблицы=0;




    Integer ИндексПослеОбработкиВсейТаблицыJSONДляВизуальнойОбработки=0;
    // TODO: 26.08.2021  МЕНЕДЖЕР ПОТОКВ ДЛЯ GRUD ОПЕРАЦИЙ

    ProgressBar progressBar3ГоризонтальныйСинхронизации;


    // TODO: 29.12.2021--21.49

    // TODO: 29.12.2021  ДЛЯ ПОСИКА uuid  ПРИ ОБНОВЛЕНИИ

    String ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде=null;

    //todo обнуляем данные укакзатели перед каждой НОВОЙ СТРЧКОЙ


    // TODO: 29.12.2021  ДЛЯ ПОСИКА id  ПРИ ОБНОВЛЕНИИ

    String ДействительноЛиIDКоторыйПришелсСервераУжеЕстьНаАндройде=null;

    // TODO: 02.01.2022




    Object IDИзПришедшегоJSONВнутри=null;


    Object UUIDПолученныйИзПришедшегоJSONВнутри =null;



    public Class_Engine_SQL(@NotNull Context context) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        super(context);
        ////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
        /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК

        ////todo
        // TODO: 13.10.2021  подключение к БАЗЕ ДАННЫХ  анных делаем одно без многих NEW




        // TODO: 13.10.2021  подключение к  МЕНЕДЖЕРУ ПОТОКОВ делаем одно без многих NEW

        public_contentДатыДляГлавныхТаблицСинхронизации=new PUBLIC_CONTENT(contextСозданиеБАзы);
        // TODO: 29.10.2021  refrens datbase sqlite

        Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы=new CREATE_DATABASE(contextСозданиеБАзы).getССылкаНаСозданнуюБазу();
        ///////
        Log.w(contextСозданиеБАзы.getClass().getName(), "Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы" + Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);






       /// class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаID=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);;


        ////// TODO созданеи шифрование
        if (ГлавныйКлючДляШифрованиеИРасшифровки == null) {

            //TODO ключ для шифрование и расщифровки

            byte[] CipherKey = "[C@3841f624[B@6415a86b[B@143c678".getBytes();

            ГлавныйКлючДляШифрованиеИРасшифровки =
                    new SecretKeySpec(CipherKey,
                            "AES");
            ПолитикаШифрование = Cipher.getInstance("AES");

            ПолитикаШифрование.init(Cipher.ENCRYPT_MODE, ГлавныйКлючДляШифрованиеИРасшифровки);
            ///////
            ПолитикаРасшифровки = Cipher.getInstance("AES");

            ПолитикаРасшифровки.init(Cipher.DECRYPT_MODE, ГлавныйКлючДляШифрованиеИРасшифровки);
            ///// конец шифрование
        }
        ////// конец  TODO созданеи шифрование
    }


    // TODO метод запуска СИНХРОНИЗАЦИИ  в фоне

// TODO: 19.08.2021  ДАННЫЙ МЕТОД ЗАПУСКАЕТ СИНХРОНИЗЦИ ДЛЯ ЧАТА


    // TODO метод запуска СИНХРОНИЗАЦИИ  в фоне
    public Integer МетодЗАпускаФоновойСинхронизации(@NotNull Context contextПриШелИзАктивтиКоторомуНужнаСинхронизация,
                                                    String ФлагКакуюЧастьСинхронизацииЗапускаемВнутри,
                                                    boolean ФлагУказываетЧтоТОлькоОбработкаТаблицДляЧАТАвнутри,
                                                    @Nullable Activity ActivityДляСинхронизацииОбменаВнутри,
                                                    LinkedBlockingQueue ФлагОбработкаЧастиТаблицНеВсехЗависимостиОбщаяСинхронизацияЗапущенаИлиТолькоЧатПришелОтФрагмнтаИлиАктивти,
                                                    String КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная, Integer СколькоСтрочекJSON) throws InterruptedException {
        //
        /////

        Integer      ОбщегоКоличесвоУспешныхВставкоИЛИОбновлениеФоновойСинхронизациивнутри = 0;
        //

        try{



            //TODO какой режим синхрониазуии выбран

            КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал=КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная;

            //
            ФлагОбработкаЧастиТаблицНеВсехЗависимостиОбщаяСинхронизацияЗапущенаИлиТолькоЧат=
                    ФлагОбработкаЧастиТаблицНеВсехЗависимостиОбщаяСинхронизацияЗапущенаИлиТолькоЧатПришелОтФрагмнтаИлиАктивти;


            Log.i(this.getClass().getName(), "ФлагОбработкаЧастиТаблицНеВсехЗависимостиОбщаяСинхронизацияЗапущенаИлиТолькоЧат "
                    + ФлагОбработкаЧастиТаблицНеВсехЗависимостиОбщаяСинхронизацияЗапущенаИлиТолькоЧат+
                    " ФлагОбработкаЧастиТаблицНеВсехЗависимостиОбщаяСинхронизацияЗапущенаИлиТолькоЧатПришелОтФрагмнтаИлиАктивти  "
                    +ФлагОбработкаЧастиТаблицНеВсехЗависимостиОбщаяСинхронизацияЗапущенаИлиТолькоЧатПришелОтФрагмнтаИлиАктивти+"\n"+
                    " КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал " +КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);


            // TODO: 27.10.2021  флаг синхрониазция для чата

            ФлагКакуюЧастьСинхронизацииЗапускаем=ФлагКакуюЧастьСинхронизацииЗапускаемВнутри.trim();


            // TODO: 27.10.2021


            Log.i(this.getClass().getName(), "ФлагКакуюЧастьСинхронизацииЗапускаем " + ФлагКакуюЧастьСинхронизацииЗапускаем);








            /////TODO ПЕРЕОПРЕДЕЛЯЕМ КОНТЕКСТ С РАБОТАЮЩЕГО АКТИВТИ ДЛЯ ИНХРОНИЗАЦИИ
            if (contextПриШелИзАктивтиКоторомуНужнаСинхронизация != null) {
                ////
                КонтекстСинхроДляКонтроллераВФоне = contextПриШелИзАктивтиКоторомуНужнаСинхронизация;
                ///
            } else {
                Log.e(this.getClass().getName(), " Ошибка нет Конкеста  ЗАПУСК ФОНОВОЙ СИНХРОНИЗАЦИИ ....." + new Date());

            }

            Log.d(this.getClass().getName(), "ЗАПУСК ФОНОВОЙ СИНХРОНИЗАЦИИ ....." + new Date());
//              ////////

            if (ActivityДляСинхронизацииОбменаВнутри!=null) {
                /////
                ActivityДляСинхронизацииОбмена=ActivityДляСинхронизацииОбменаВнутри;


                /////
                ////TODO ЗАДЕРЖКА ИТЕРАЦИЯ ДЛЯ СИНРОНИЗАЦИИ В ФОНЕ отправка данных

                Log.d(this.getClass().getName(), "ActivityДляСинхронизацииОбмена....." + ActivityДляСинхронизацииОбмена);
            }


            // TODO: 02.11.2021


            /////



            ОбщегоКоличесвоУспешныхВставкоИЛИОбновлениеФоновойСинхронизациивнутри=         МетодСамогоФоновойСинхронизации(КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная,
                    ФлагОбработкаЧастиТаблицНеВсехЗависимостиОбщаяСинхронизацияЗапущенаИлиТолькоЧат,СколькоСтрочекJSON);


            Log.w(this.getClass().getName(), " ФОНОВАЯ СИНХОРОНИЗАЦИИИ ИДЁТ... СЛУЖБА ");

            Log.w(this.getClass().getName(), "ТРЕТЬЯ... ФОНОВАЯ СЛУЖБА КОЛИЧЕСТВО УСПЕШНЫХ ВСТАКОВ ИЛИ/И ОБНОВЛЕНИЙ " + ОбщегоКоличесвоУспешныхВставкоИЛИОбновлениеФоновойСинхронизациивнутри);














            // TODO: 08.09.2021  clear after async

            /////TODO ПОСЛЕ  СИНХРОНИЗАЦИЕЙ ОБНУЛЯЕМ КОЛИЧЕСТВО СТРОК JSON ОБЩЕЕ  , ПЕРЕД ПОЛУЧЕНИЕМ НОВОГО ЗНАЧЕНИЯ
            ///PUBLIC_CONTENT.СколькоСтрочекJSON = 0;
            /////TODO ПОСЛЕ  СИНХРОНИЗАЦИЕЙ синхронизации по всем таблицам обнулем общее количество успешных вставко и обновлений



            ///////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        /////


        Log.d(this.getClass().getName(), "ОбщегоКоличесвоУспешныхВставкоИЛИОбновлениеФоновойСинхронизациивнутри" + ОбщегоКоличесвоУспешныхВставкоИЛИОбновлениеФоновойСинхронизациивнутри+
                "  ПубличныйРезультатОтветаОтСерврераУспешно " +ПубличныйРезультатОтветаОтСерврераУспешно);



        if (ОбщегоКоличесвоУспешныхВставкоИЛИОбновлениеФоновойСинхронизациивнутри==0){

            // TODO: 28.10.2021
            ОбщегоКоличесвоУспешныхВставкоИЛИОбновлениеФоновойСинхронизациивнутри=ПубличныйРезультатОтветаОтСерврераУспешно;

            // TODO: 28.10.2021

        }


        return ОбщегоКоличесвоУспешныхВставкоИЛИОбновлениеФоновойСинхронизациивнутри;
    }


    // TODO: 25.09.2021 ВТОРАЯ ВЕСРИЯ ЗАПУСКА СИНХРОНМИАЗЦИИИ С ТАБЕЛЯ































// TODO: 19.08.2021  ДАННЫЙ МЕТОД ЗАПУСКАЕТ СИНХРОНИЗЦИ ДЛЯ ЧАТА


    // TODO метод запуска СИНХРОНИЗАЦИИ  в фоне
    protected Integer МетодЗАпускаФоновойСинхронизацииВторойВариантЗапускаемИзТабеля(
            Context contextПриШелИзАктивтиКоторомуНужнаСинхронизация,
            String КтоЗарустилСинхронизацию,
            boolean ФлагУказываетЧтоТОлькоОбработкаТаблицДляЧАТАвнутри,
            Activity ActivityДляСинхронизацииОбменаВнутри,
            String ФлагКакуюЧастьСинхронизацииЗапускаемВнутри,
            String  КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная,
            String ФлагПослеСинхрониазцииПоказываемВыплывающееСообщение) throws InterruptedException {
        //
        final Integer[] РезультатЗапускВизуальнойСинхронизации = {0};


        PUBLIC_CONTENT public_contentДляСинхрониазхцииНеБлокирующейВызываемЕгоКогдаСходимСТАбеляИВсехСотрудников=new PUBLIC_CONTENT(contextСозданиеБАзы);

        try{
            //////


            Completable completableЗАпускаФоновойСинхронизацииВторойВариантЗапускаемИзТабеля=Completable.fromAction(new Action() {
                @Override
                public void run() throws Throwable {

                    Log.d(this.getClass().getName(), "  Completable.fromAction" );



                    // TODO: 28.09.2021  ЗАПУСКАЕМ СИНХРОНИАЗЙИИЮ С АЬБЕЛЯ


                    // TODO: 27.09.2021  start

                    try{


                        // TODO: 01.07.2021  ЗАПУСКАЕМ ВИЗУАЛЬНУЮ СИНХРОНИЗИЦИЮ С АКТИВТИ ЧДЕ КРУТИТЬСЯ ПРОГРЕСС БАР


                        РезультатЗапускВизуальнойСинхронизации[0] =
                                new Class_Engine_SQL(ActivityДляСинхронизацииОбменаВнутри).
                                        МетодЗАпускаФоновойСинхронизации(ActivityДляСинхронизацииОбменаВнутри,
                                                "СинхронизацияОбщая", false, ActivityДляСинхронизацииОбменаВнутри, public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда,
                                                КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная, ГлавноеКоличестовТаблицОбрабатываемВГлавномЦиклеОбмена);  //TODO третить параментр false --указывает что обработка всех таблиц кроме чата



                        Log.d(this.getClass().getName(), "  РезультатЗапускВизуальнойСинхронизации  " + РезультатЗапускВизуальнойСинхронизации[0]);


                        ///////
                    } catch (Exception e) {
                        //  Block of code to handle errors
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        // TODO: 01.09.2021 метод вызова
                        new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }


                }
            }).subscribeOn(io.reactivex.rxjava3.schedulers.Schedulers.computation())
                    .doOnError(new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Throwable {
                            Log.e(this.getClass().getName(), " doOnError" );
                        }
                    })
                    .doOnComplete(new Action() {
                        @Override
                        public void run() throws Throwable {
                            Log.d(this.getClass().getName(), "  doOnComplete" );



                            ///todo

                            //if (ФлагПослеСинхрониазцииПоказываемВыплывающееСообщение.equalsIgnoreCase( "ПоказыватьПослеСинхрониазцииСообщениеВыплывающее")) {
                            ////
                            if (ActivityДляСинхронизацииОбменаВнутри!=null) {
                                ///
                                ActivityДляСинхронизацииОбменаВнутри.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        //

                                        Log.d(this.getClass().getName(), "  СЛУЖБА  ИЗ ТАБЕЛЯ ЛИСТА  ЗАПУСТИЛИ ИЗ FACEAPP ФиналРезультатСинхроиназцииЗапускаЧСтрогоИзТабеляВнутри[0] "
                                                + РезультатЗапускВизуальнойСинхронизации[0]);


                                        //Toast.makeText(ActivityДляСинхронизацииОбменаВнутри, " Обмен Данными ▲ ▼  кол: " + ФиналРезультатСинхроиназцииЗапускаЧСтрогоИзТабеляВнутри[0], Toast.LENGTH_LONG).show();

                                        Toast toast=       Toast.makeText(ActivityДляСинхронизацииОбменаВнутри, null, Toast.LENGTH_LONG);

                                        toast.setText(" Обмен Данными ▲ ▼  кол: " + РезультатЗапускВизуальнойСинхронизации[0]);



                                        //
                                        if (РезультатЗапускВизуальнойСинхронизации[0] ==0) {


                                            // TODO: 31.10.2021

                                        }


                                        // TODO: 31.10.2021
                                        toast.setGravity(Gravity.BOTTOM,0,40);

                                        toast.show();

                                        // TODO: 08.09.2021  clear after async


                                        //}

                                        /////TODO ПОСЛЕ  СИНХРОНИЗАЦИЕЙ ОБНУЛЯЕМ КОЛИЧЕСТВО СТРОК JSON ОБЩЕЕ  , ПЕРЕД ПОЛУЧЕНИЕМ НОВОГО ЗНАЧЕНИЯ
                                        ///PUBLIC_CONTENT.СколькоСтрочекJSON = 0;
                                        /////TODO ПОСЛЕ  СИНХРОНИЗАЦИЕЙ синхронизации по всем таблицам обнулем общее количество успешных вставко и обновлений

                                    }
                                });
                            }




                        }
                    })
                    .onErrorComplete(new Predicate<Throwable>() {
                                         @Override
                                         public boolean test(Throwable throwable) throws Throwable {
                                             Log.e(this.getClass().getName(), "  onErrorComplete" );
                                             return false;


                                         }
                                     }
                    );
            // TODO: 11.01.2022 подписка
            completableЗАпускаФоновойСинхронизацииВторойВариантЗапускаемИзТабеля.blockingSubscribe(System.out::println);
            // TODO: 11.01.2022
            completableЗАпускаФоновойСинхронизацииВторойВариантЗапускаемИзТабеля.
                    toCompletionStage(РезультатЗапускВизуальнойСинхронизации).
                    toCompletableFuture().complete(РезультатЗапускВизуальнойСинхронизации);





            ///////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        /////

        return РезультатЗапускВизуальнойСинхронизации[0];
    }




























































































// TODO: 08.09.2021 НИЖЕ НАЧИНАЮТЬСЯ МЕТОДЫ САМОЙ ФОНОВОЙ СИНХРОНИАЗЦИИ ВНИМАНИЕ !!!!!!!
// TODO: 08.09.2021 НИЖЕ НАЧИНАЮТЬСЯ МЕТОДЫ САМОЙ ФОНОВОЙ СИНХРОНИАЗЦИИ ВНИМАНИЕ !!!!!!!
// TODO: 08.09.2021 НИЖЕ НАЧИНАЮТЬСЯ МЕТОДЫ САМОЙ ФОНОВОЙ СИНХРОНИАЗЦИИ ВНИМАНИЕ !!!!!!!
    // TODO: 08.09.2021 НИЖЕ НАЧИНАЮТЬСЯ МЕТОДЫ САМОЙ ФОНОВОЙ СИНХРОНИАЗЦИИ ВНИМАНИЕ !!!!!!!
// TODO: 08.09.2021 НИЖЕ НАЧИНАЮТЬСЯ МЕТОДЫ САМОЙ ФОНОВОЙ СИНХРОНИАЗЦИИ ВНИМАНИЕ !!!!!!!
    // TODO: 08.09.2021 НИЖЕ НАЧИНАЮТЬСЯ МЕТОДЫ САМОЙ ФОНОВОЙ СИНХРОНИАЗЦИИ ВНИМАНИЕ !!!!!!!
















    ///TODO САМ ФОНОВЫЙ ПОТОК МЕТОД

    Integer МетодСамогоФоновойСинхронизации(String КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная,
                                            LinkedBlockingQueue ФлагОбработкаЧастиТаблицНеВсехЗависимостиОбщаяСинхронизацияЗапущенаИлиТолькоЧат,Integer СколькоСтрочекJSONВнутри) {


        String ТекущаяТаблицаДляОБменаДанными = null;

        ////TODO уставналиваем констанку что метод onStart запускалься только один раз

        Integer ФинальныйРезультаФоновойСинхрониазции=0;
        //
        Class_GRUD_SQL_Operations class_grud_sql_operationsМетодСамогоФоновойСинхронизации=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);



        ///
        try {


            ГлавноеКоличестовТаблицОбрабатываемВГлавномЦиклеОбмена =  СколькоСтрочекJSONВнутри;


            // TODO: 01.05.2021 запускаем если все активти невидны спущены вниз*/

            Log.d(this.getClass().getName(), "ЗАПУСК СЛУЖБА ВНУТРИ startService   Вещятеля BroadcastReceiver  Synchronizasiy_Data " + new Date() +
                    "\n" + " Build.BRAND " + Build.BRAND.toString()+"  СколькоСтрочекJSONВнутри " +СколькоСтрочекJSONВнутри+ " СколькоСтрочекJSON " + ГлавноеКоличестовТаблицОбрабатываемВГлавномЦиклеОбмена);


            ////TODO ТОЛЬКО ПРИ НАЛИЧИИ ИНТРЕНТА  !!!!!!!!!!!!!!!! ЗАПУСК СИНХРОНИЗАЦИИ


            ////
            Long финальныйРезультаФоновойСинхрониазции=0l;


            //////TODO ШАГ ТРЕТИЙ  ЗАПУСКАЕМ САМУ СИНХРОНИЗАЦИЮ  сама синхронизация в фоне
            ФинальныйРезультаФоновойСинхрониазции =            МетодНачалоСихронизациивФоне(КонтекстСинхроДляКонтроллераВФоне,КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная); ////Получение Версии Данных Сервера для дальнейшего анализа


            //todo нет json ля вситавки

            ///TODO ЗАПУСКАЕМ СРАЗУ МЕТОД ONSTOP В ASYNTASKLOADER ПОТОМУ ЧТО НЕТ ИНТРЕНТА И НЕТ СМЫСЛА ДЕЛАТЬ СИНХРОНИЗАЦИЮ
            // финальныйРезультаФоновойСинхрониазции =           МетодПослеФононовойСинхроигзации();

            Log.d(this.getClass().getName(), " ФОНОВАЯ СЛУЖБА КОЛИЧЕСТВО УСПЕШНЫХ ВСТАКОВ ИЛИ/И ОБНОВЛЕНИЙ  ФинальныйРезультаФоновойСинхрониазции " +
                    ПубличныйРезультатОтветаОтСерврераУспешно +  "  ФинальныйРезультаФоновойСинхрониазции " +ФинальныйРезультаФоновойСинхрониазции);



// TODO: 08.09.2021  exe запус синхрониазции в потоке


          /*  ФинальныйРезультаФоновойСинхрониазции=
                    (Long) class_grud_sql_operationsМетодСамогоФоновойСинхронизации.new ClassRuntimeExeGRUDOpertions(contextСозданиеБАзы).
                            МетодЗапускаОперацийGRUD_exe(class_grud_sql_operationsМетодСамогоФоновойСинхронизации.ЛистДляGRUDопераций);*/



            Log.d(this.getClass().getName(), " ФОНОВАЯ СЛУЖБА КОЛИЧЕСТВО УСПЕШНЫХ ВСТАКОВ ИЛИ/И ОБНОВЛЕНИЙ  ФинальныйРезультаФоновойСинхрониазции " +
                    ФинальныйРезультаФоновойСинхрониазции);

/*
           LinkedTransferQueue linkedTransferQueue=new LinkedTransferQueue();
            linkedTransferQueue.transfer(class_grud_sql_operationsМетодСамогоФоновойСинхронизации.ЛистДляGRUDопераций);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                linkedTransferQueue.parallelStream().sorted().forEachOrdered((GG)-> {

                });
            }

          ConcurrentHashMap linkedHashMap=new ConcurrentHashMap();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                linkedHashMap.keySet().stream().sorted().forEachOrdered((Data)->{

                    /////


                });
            }*/


            /////////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }




        if(ФинальныйРезультаФоновойСинхрониазции==0)
        {
            ФинальныйРезультаФоновойСинхрониазции=   ПубличныйРезультатОтветаОтСерврераУспешно;
        }



        return ФинальныйРезультаФоновойСинхрониазции;
    }


























//////ПЕРВЫЙ МЕТОД ОБМЕНА ДАННЫМИ С СЕРВЕРОМ МЕТОД GET

    Integer МетодНачалоСихронизациивФоне(@NotNull Context context, String КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная) throws InterruptedException, ExecutionException, TimeoutException, JSONException {

        Integer результатСинхрониазции=0;

        try {
            ////////todo ОБНУЛЯЕМ КОЛИЧЕСТВО УСПЕШНЫХ ВСТАКОВ ИЛИ ОБНОВЛЕНИЙ

            ////TODO ДАННЫЙ ЦИКЛ НУЖЕН ПЕРВЫЙ ШАГОМ ВЫ ВСТАВЛЯЕМ ДАННЫЕ ЕСЛИ ОНИ ЕСТЬ , А ВТОРЫМ ШАГОМ И ИХ ДОГОНЯЕМ ОБНОВЛЕМ ДАННЫЕ ВОТ ТАК  ДЛЯ СИНХРОНИЗАЦИИ

            //// TODO САМАЯ ПЕРВАЯ КОМАНДА НАЧАЛА ОБМНЕНА ДАННЫМИ В ФОНЕ
            результатСинхрониазции=     МетодПолучениеIDотСервераДляГеренированиеUUID(КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная); ////САМАЯ ПЕРВАЯ КОМАНДА НАЧАЛА ОБМНЕНА ДАННЫМИ///// TODO ГЛАВНЫЙ МЕТОД ОБМЕНА ДАНЫМИ  НА АКТИВИТИ FACE_APP




            ///*/
            Log.d(this.getClass().getName(), " результатСинхрониазции "
                    + результатСинхрониазции);

            ///////////////////////////////
            if(результатСинхрониазции==null){

                ////
                результатСинхрониазции=0;
            }

            Log.d(this.getClass().getName(), " результатСинхрониазции"
                    + результатСинхрониазции);

            ///todo конец финал обрабоатываем обновлениея
            ///todo конец финал обрабоатываем обновлениея

            ///////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }


        if (результатСинхрониазции==0){

            результатСинхрониазции=      ПубличныйРезультатОтветаОтСерврераУспешно;
        }
        /////////////////
        return    результатСинхрониазции;
    }













    // TODO: 13.10.2021 нАЧАЛО сИНХРОНИАЗЦИИ

    Integer МетодПолучениеIDотСервераДляГеренированиеUUID(String КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная) throws JSONException, InterruptedException, ExecutionException, TimeoutException {
        ///
        String ДанныеПришёлЛиIDДЛяГенерацииUUID = new String();


        //
        Integer РезультатСинхрониазции=0;

        ПубличноеIDПолученныйИзСервлетаДляUUID=0;

        /////
        try {
            Log.d(this.getClass().getName(), " public   void МетодПолучениеIDОтСервераДляГеренированиеUUID ()" + " ДанныеПришёлЛиIDДЛяГенерацииUUID " + ДанныеПришёлЛиIDДЛяГенерацииUUID +
                    " ДанныеПришёлЛиIDДЛяГенерацииUUID.length()  " + ДанныеПришёлЛиIDДЛяГенерацииUUID.length());


            ///
            Class_GRUD_SQL_Operations   class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете=new Class_GRUD_SQL_Operations(КонтекстСинхроДляКонтроллераВФоне);
            // TODO: 03.11.2021
            PUBLIC_CONTENT public_contentменеджер=new PUBLIC_CONTENT(contextСозданиеБАзы);

            ///
            class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","SuccessLogin");
            ///////
            class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","id");
            //

            ////
            class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

            SQLiteCursor     Курсор_ВычисляемПУбличныйID= (SQLiteCursor)  class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете.
                    new GetData(КонтекстСинхроДляКонтроллераВФоне).getdata(class_grud_sql_operationsПолучаемПубличныйIDЛокальноИеСЛИЕгоНЕтНАчинаемЕгоИСктьВНИтренете.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,public_contentменеджер.МенеджерПотоков,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

            Log.d(this.getClass().getName(), "GetData "+Курсор_ВычисляемПУбличныйID  );



            StringBuffer БуферПолучениеДанных = new StringBuffer();


            /////
            if (Курсор_ВычисляемПУбличныйID.getCount() > 0) {
                //////////
                Курсор_ВычисляемПУбличныйID.moveToFirst();

                ПубличноеIDПолученныйИзСервлетаДляUUID=Курсор_ВычисляемПУбличныйID.getInt(0);

                // TODO: 03.11.2021

                Log.w(this.getClass().getName(), "  ПубличноеIDПолученныйИзСервлетаДляUUID " + ПубличноеIDПолученныйИзСервлетаДляUUID);


                // TODO: 29.12.2021 ПЕРВФЙ ЗАПСК КОГДА НЕТ id ПОЛЬЗОВАТЕЛЯ ТЕКУЩЕЕ ПУБЛИЧНОГО


            }else{

                // TODO: 28.01.2022
                String НазваниеПорта="tabel.dsu1.ru";
                Integer СамПорт=8888;

     /*       // TODO: 28.01.2022
            String НазваниеПорта="192.168.254.40";
            Integer СамПорт=8080;
            ///*/
                //////TODO САМЫЙ ПЕРВЫЙ ЗАПРОС ОПРЕДЕЛЯЕМ ПУБЛИЧНЫЙ ID С СЕРВЕРА
                БуферПолучениеДанных =
                        УниверсальныйБуферПолучениеДанныхсСервера("", "", "", "application/text", "Хотим Получить ID для Генерации  UUID", 0l, "",10000,null,0l, НазваниеПорта, СамПорт) ;//// БуферПолученнниеДанныхОтМетодаGET.mark(1000); // save the data we are about to readБуферПолученнниеДанныхОтМетодаGET.reset(); // jump back to the marked position


                Log.w(this.getClass().getName(), "  БуферПолучениеДанных.toString()  " + БуферПолучениеДанных.toString());



                ///////
                if (БуферПолучениеДанных != null && БуферПолучениеДанных.toString().toCharArray().length > 0) {
                    ///////

                    Log.w(this.getClass().getName(), "  БуферПолучениеДанных.toString()  " + БуферПолучениеДанных.toString());


                    do {
                        ДанныеПришёлЛиIDДЛяГенерацииUUID = БуферПолучениеДанных.toString();
                        //
                        Log.d(this.getClass().getName(), "  ДанныеПришёлЛиIDДЛяГенерацииUUID  " + ДанныеПришёлЛиIDДЛяГенерацииUUID);




                        //////TODO ПРИСВАИВАЕМ ПОЛУЧЕННЫЙ ID ПУБЛИЧНЫЙ
                        ПубличноеIDПолученныйИзСервлетаДляUUID =Integer.parseInt( БуферПолучениеДанных.toString()); ///ИЗ ОТВЕТА ПОЛУЧАЕМ ID ПОЛЬЗОВАТЕЛЯ ДЛЯ ГЕНЕРАЦИИ  UUID//

                        ///
                        ///todo если мы прошли один раз и нет данных выходим
                        if (ДанныеПришёлЛиIDДЛяГенерацииUUID.length() == 0) {
                            break;
                        }
                    } while (ПубличноеIDПолученныйИзСервлетаДляUUID==0);/////конец for # количество респонсев
                    //////


                    Log.d(this.getClass().getName(), "  ПубличноеIDПолученныйИзСервлетаДляUUID  " + ПубличноеIDПолученныйИзСервлетаДляUUID);


                    // TODO: 29.12.2021  записываеми втую таблицу полученный публичный ID





                    ////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК


                    /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
                    /////////
                } else {////ОШИБКА В ПОЛУЧЕНИИ С СЕРВЕРА ТАБЛИУЦЫ МОДИФИКАЦИИ ДАННЫХ СЕРВЕРА
                    Log.d(this.getClass().getName(), " Данных нет c сервера  ");
                }



            }



            Log.w(this.getClass().getName(), "  ПубличноеIDПолученныйИзСервлетаДляUUID  " + ПубличноеIDПолученныйИзСервлетаДляUUID);

            Курсор_ВычисляемПУбличныйID.close();


            ///
            if (ПубличноеIDПолученныйИзСервлетаДляUUID > 0) {//ЕСЛИ МЫ ПОЛУЧИЛИ ID  и СОЗДАЛИ НА ЕГО БАЗЕ UUID ТО ПРОХОДИИМ К СЛЕДУЮЩЕМУ КОДУ ПОЛУЧАЕМ ВЕРСИЮ ДАННЫХ СЕРВВЕРА


                // TODO: 29.03.2021 записываем полученный пуюдтичны ID
                Log.d(this.getClass().getName(), "  ДанныеПришёлЛиIDДЛяГенерацииUUID  " + ДанныеПришёлЛиIDДЛяГенерацииUUID.length());


                // TODO: 17.11.2021 идем по шагам запускаем синхрогниазцию


                ////TODO создаем списко таблиц запускаем слуд.ющий метод получение версии базы данных
                РезультатСинхрониазции=        МетодПолучениеСпискаТаблицДляОбменаДанными(String.valueOf(ПубличноеIDПолученныйИзСервлетаДляUUID),
                        КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная);//получаем ID для генерирования UUID
//
                if(РезультатСинхрониазции==null){
                    //
                    РезультатСинхрониазции=0;
                }


                Log.d(this.getClass().getName(), " Результат  РезультатСинхрониазции  "+РезультатСинхрониазции);

            }else{

                Log.e(this.getClass().getName(), "  ДЛЯ ПРОДОЛЖЕНИЯ РАБОТЫ НЕТ ПУБЛИЧНОГО ID   "+РезультатСинхрониазции);

            }




        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return  РезультатСинхрониазции;
    }

    ///////////////////метод получение ОТ СЕРВЕРА КОНКРЕТНЫЙ СПИСОК ТАДОИЦЦ ДЛЯ ОБМЕНА

























    ////////////МЕТОД ПОЛУЧЕНИЕ  ВЕРСИИ ДАННЫХ
    Integer МетодПолучениеСпискаТаблицДляОбменаДанными( String ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                                        String КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная)
            throws JSONException, InterruptedException, ExecutionException, TimeoutException {///второй метод получаем версию данных на СЕРВЕР ЧТОБЫ СОПОЧТАВИТЬ ДАТЫ

        Log.d(this.getClass().getName(), " ДанныеПришёлЛиIDДЛяГенерацииUUID" + ДанныеПришёлЛиIDДЛяГенерацииUUID);

        String ДанныеПришлаСпискаТаблицДляОбмена = new String();

        StringBuffer БуферПолученияСпискаТАблицДляОбмена = new StringBuffer();

        Integer РЕЗУЛЬТАТГЛАВНОЙСИНХРОНИАЗЦИИПОТАБЛИЦАМ=0;

        ////TODO ПОСЛЕ ОБРАБОТКИ ТАБЛИЦ ОБНУЛЯЕМ


        try {

            // TODO: 28.01.2022
     String НазваниеПорта="tabel.dsu1.ru";
            Integer СамПорт=8888;

     /*       // TODO: 28.01.2022
            String НазваниеПорта="192.168.254.40";
            Integer СамПорт=8080;
            ///*/

            //////TODO ВТОРОЙ ЗАПРОС ПОУЛЧАЕМ УЖЕ СПИСОК ТАБЛИЦ ОТ СЕРВЕРА/////TODO тест режим
            //           concurrentHashMapАдресаПодключенияКСерверу.put("192.168.254.40", 8080);   original "tabel.dsu1.ru", 8888


            БуферПолученияСпискаТАблицДляОбмена = УниверсальныйБуферПолучениеДанныхсСервера("view_data_modification",
                    "", "",
                    "application/gzip",//application/json
                    "Хотим Получить Версию Данных Сервера",
                    0l,
                    ДанныеПришёлЛиIDДЛяГенерацииUUID, 10000, null, 0l,НазваниеПорта, СамПорт);   //// БуферПолученнниеДанныхОтМетодаGET.mark(1000); // save the data we are about to readБуферПолученнниеДанныхОтМетодаGET.reset(); // jump back to the marked position

            Log.d(this.getClass().getName(), " БуферПолученияСпискаТАблицДляОбмена.toString().toCharArray().length " + БуферПолученияСпискаТАблицДляОбмена.toString().toCharArray().length);


            // TODO: 03.09.2021


            if (БуферПолученияСпискаТАблицДляОбмена != null) {
                ////
                if (БуферПолученияСпискаТАблицДляОбмена.toString().toCharArray().length > 3) {


                    do {

                        ДанныеПришлаСпискаТаблицДляОбмена = БуферПолученияСпискаТАблицДляОбмена.toString();

                        //////
                        БуферПолученияСпискаТАблицДляОбмена.append(ДанныеПришлаСпискаТаблицДляОбмена).append("\n");

                        Log.d(this.getClass().getName(), " ДанныеПришлаЛиВерсияДанныхсСервера " + ДанныеПришлаСпискаТаблицДляОбмена);


                    } while (ДанныеПришлаСпискаТаблицДляОбмена == null);/////конец for # количество респонсев
                    /////


                    Log.d(this.getClass().getName(), "  ПубличноеIDПолученныйИзСервлетаДляUUID  " + ПубличноеIDПолученныйИзСервлетаДляUUID +
                            " БуферПолученияСпискаТАблицДляОбмена " + БуферПолученияСпискаТАблицДляОбмена.toString());
                    ////
                    /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
                    /////////
                    ///ПОЛУЧЕННЫЙ СПИСОК ЗАПИСЫВАЕМ В ТАБЛИЦУ НАШУ ПЕРЕРМЕННЦУЮ
                    JSONObject ОбьектыJSONТаблицыПришлиКонктетоНаЭтогоКлиента = new JSONObject(БуферПолученияСпискаТАблицДляОбмена.toString());///упаковываем в j
                    ///
                    JSONArray МассивJSONТаблиц = ОбьектыJSONТаблицыПришлиКонктетоНаЭтогоКлиента.names();

                    String НазваниеИзПришедшихТаблицДляКлиента;

                    String СодержимоеИзПришедшихТаблицДляКлиента;

                    String JSONСтрочка;

                    String JSONНазваниеСтолбика;

                    String JSONСодержимоеСтолика;

                    Long JSONСодержимоеСтоликаДляХэша=0l;
                    /////ЦИКЛ КРУТИТЬ JSON


                    public_contentДатыДляГлавныхТаблицСинхронизации.     ДатыТаблицыВерсииДанныхОтСервера=Collections.synchronizedMap(new LinkedHashMap<String, Long>());

                    // TODO: 11.10.2021

                    public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда.clear();

                    /////ЦИКЛ КОТРЫЙ БЕЖИТ ПО СТОРОКА ПРИГЕДШЕГО JSON ФАЙЛА И НАХОДИМ НАЩШИ ТАЮЛИЦЫ ДЛЯ УКАЗАННОГО ПОЛЬЗОВАТСЯ
                    for (int ИндексТаблицыДляДанногоКлиента = 0; ИндексТаблицыДляДанногоКлиента < ОбьектыJSONТаблицыПришлиКонктетоНаЭтогоКлиента.names().length(); ИндексТаблицыДляДанногоКлиента++) {
                        ////// распарсиваем  josn
                        НазваниеИзПришедшихТаблицДляКлиента = МассивJSONТаблиц.getString(ИндексТаблицыДляДанногоКлиента);

                        СодержимоеИзПришедшихТаблицДляКлиента = ОбьектыJSONТаблицыПришлиКонктетоНаЭтогоКлиента.getString(НазваниеИзПришедшихТаблицДляКлиента); // Here's

                        JSONObject ОбьектJSON = new JSONObject(СодержимоеИзПришедшихТаблицДляКлиента);

                        JSONСтрочка = String.valueOf(ОбьектJSON.names());


                        /////ЦИКЛ КОТРЫЙ БЕЖИТ ПО СТОЛБЦАМ  ПРИГЕДШЕГО JSON ФАЙЛА И НАХОДИМ НАЩШИ ТАЮЛИЦЫ ДЛЯ УКАЗАННОГО ПОЛЬЗОВАТСЯ
                        for (int ИндексТаблицыДляДанногоКлиентаСтолбцы = 0; ИндексТаблицыДляДанногоКлиентаСтолбцы < ОбьектJSON.length(); ИндексТаблицыДляДанногоКлиентаСтолбцы++) {

                            JSONНазваниеСтолбика = String.valueOf(ОбьектJSON.names().get(ИндексТаблицыДляДанногоКлиентаСтолбцы));

                            JSONСодержимоеСтолика = ОбьектJSON.getString(JSONНазваниеСтолбика);

                            ///ЗАПОЛНЯЕМ ТОЛЬКО НАЗВАНИЯ ТАБЛИЦ  ПРЕДНАЗВАНЧЕН ТОЛЬКО ДЛЯ ДАННГО ПОЛЬЗОВАТЕЛЯ ТАБЛИЦЫ ПО КОТОРЫМ БУДЕТ ОБМЕН
                            ///todo вытаскмваем название таблиц для заполения таблицы модификейшен клеинта на андройде

                            if (JSONНазваниеСтолбика.equalsIgnoreCase("ИМЯ ИЗ МОДИФИКАЦИИ СЕРВЕР")) {////&& !JSONСодержимоеСтолика.equalsIgnoreCase("fio")///&& !JSONСодержимоеСтолика.equalsIgnoreCase("fio")

                                ////////TODO ЗАПОЛНЯЕМ АРАЙЛИСТ ЗНАЧЕНИЯ НАЗВАНИЕ ТАБЛИЦ ДЛЯ ОБРАБОТКИ
                                ////
                                public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда.put(JSONСодержимоеСтолика); //////ЗАПОЛЯНЕМ АРАЙЛИСТ НАЗВАНИЕМ ТОЛЬКО ТАБЛИЦ КОТОРЫ ПРИШИ ДЛЯ КОНКТНОГО ПОЛЬЗОВАТЕЛЯ

                                Log.d(this.getClass().getName(), " JSONСодержимоеСтолика " + JSONСодержимоеСтолика);


                            }



                            /////А ТУТ МЫ ПРОСТО ЗАПОМИНАЕМ НАЗВАНИЕ ТАБЛИЦ С СЕРВЕРА  И ПЛЮС ИХ ДАТЫ ПОСЛЕДНЕГО ИЗМЕНЕНИЕ ДАННЫХ НА ДАННЫХ ТАБЛИЦАХ НА СЕРВЕРЕ
                            if (JSONНазваниеСтолбика.equalsIgnoreCase("ИМЯ ИЗ МОДИФИКАЦИИ СЕРВЕР")) {
                                //////ОТДЕЛЬНО ДляХэшМап TODO заполняем данными
                                JSONСодержимоеСтоликаДляХэша = ОбьектJSON.getLong("ТЕКУЩАЯ ВЕРСИЯ  ТАБЛИЦЫ");/////ТОЛЬКО ДЛЯ HSMAP///"ДАТА ВЕРСИИ СЕРВЕРА"

                                public_contentДатыДляГлавныхТаблицСинхронизации.ДатыТаблицыВерсииДанныхОтСервера.put(JSONСодержимоеСтолика,JSONСодержимоеСтоликаДляХэша); ///// ЗАПОЛНЯЕМ ХЭШМАП ДЛЯ КРНКРЕТНОГО ПОЛЬЗОВАТЕЛЯ ТАБЛИЦ ДЛЯ ТОЛЬКО СЕСИИ

                                Log.d(this.getClass().getName(), " JSONСодержимоеСтолика " + JSONСодержимоеСтолика + "  JSONСодержимоеСтоликаДляХэша  " + JSONСодержимоеСтоликаДляХэша+
                                        "   PUBLIC_CONTENT.ДатыТаблицыВерсииДанныхОтСервера.size() " + public_contentДатыДляГлавныхТаблицСинхронизации.ДатыТаблицыВерсииДанныхОтСервера.size());



                            }
                            //todo проект имена
                            if (JSONНазваниеСтолбика.equalsIgnoreCase("ПРОЕКТЫ")) {

                                public_contentДатыДляГлавныхТаблицСинхронизации.ИменаПроектовОтСервера.add(JSONСодержимоеСтолика); //////ЗАПОЛЯНЕМ АРАЙЛИСТ НАЗВАНИЕМ ТОЛЬКО ТАБЛИЦ КОТОРЫ ПРИШИ ДЛЯ КОНКТНОГО ПОЛЬЗОВАТЕЛЯ

                                Log.d(this.getClass().getName(), " ИменаПроектовОтСервера " + public_contentДатыДляГлавныхТаблицСинхронизации.ИменаПроектовОтСервера.toString());
                            }


                            // TODO: 27.09.2021  new modul
                            //todo проект имена
                            if (JSONНазваниеСтолбика.equalsIgnoreCase("ТЕКУЩАЯ ВЕРСИЯ  ТАБЛИЦЫ")) {

                                ////PUBLIC_CONTENT.ИменаПроектовОтСервера.add(JSONСодержимоеСтолика); //////ЗАПОЛЯНЕМ АРАЙЛИСТ НАЗВАНИЕМ ТОЛЬКО ТАБЛИЦ КОТОРЫ ПРИШИ ДЛЯ КОНКТНОГО ПОЛЬЗОВАТЕЛЯ

                                Log.d(this.getClass().getName(), " ИменаПроектовОтСервера " + public_contentДатыДляГлавныхТаблицСинхронизации.ИменаПроектовОтСервера.toString()+  "  JSONНазваниеСтолбика " +JSONНазваниеСтолбика);
                            }





                        }
                    }
                    //////
                    /////
                } else {////ОШИБКА В ПОЛУЧЕНИИ С СЕРВЕРА ТАБЛИУЦЫ МОДИФИКАЦИИ ДАННЫХ СЕРВЕРА
                    Log.d(this.getClass().getName(), " Данных нет c сервера  ");


                }
            }


            Log.i(this.getClass().getName(), " ИменаТаблицыОтАндройда " + public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда.toString() +
                    " ДатыТаблицыВерсииДанныхОтСервера " +public_contentДатыДляГлавныхТаблицСинхронизации.toString() + "  ДанныеПришлаСпискаТаблицДляОбмена " +ДанныеПришлаСпискаТаблицДляОбмена);


            if ( public_contentДатыДляГлавныхТаблицСинхронизации.ДатыТаблицыВерсииДанныхОтСервера.size() > 0  && public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда.size()>0) {//ЕСЛИ МЫ ПОЛУЧИЛИ ID  и СОЗДАЛИ НА ЕГО БАЗЕ UUID ТО ПРОХОДИИМ К СЛЕДУЮЩЕМУ КОДУ ПОЛУЧАЕМ ВЕРСИЮ ДАННЫХ СЕРВВЕРА
                ////запускаем слуд.ющий метод получение версии базы данных
                //// TODO запускам если ОТ СЕРВЕРА ПРИШЛИ  ДАННЫЕ СПИСОК ТАБЛИЦ ДЛЯ СОЗДАНИЕ СПИСК ДЛЯ ПОЛЬЗОВАТЕЯД


                Log.i(this.getClass().getName(), " ДанныеПришлаСпискаТаблицДляОбмена " + ДанныеПришлаСпискаТаблицДляОбмена+ "  PUBLIC_CONTENT.ДатыТаблицыВерсииДанныхОтСервера.size() " +
                        public_contentДатыДляГлавныхТаблицСинхронизации.ДатыТаблицыВерсииДанныхОтСервера.size());












                Log.i(this.getClass().getName(), "  ГЛАВНЫЙ ЦИКЛ НАЧИНАЕТСЯ.............. РЕЗУЛЬТАТГЛАВНОЙСИНХРОНИАЗЦИИПОТАБЛИЦАМ " + РЕЗУЛЬТАТГЛАВНОЙСИНХРОНИАЗЦИИПОТАБЛИЦАМ);


                Class_Engine_SQL_SubClassMainLoopAsyncTables_КлассСГлавнымЦикломСинхрониазцииТАблиц
                        Class_Engine_SQL_subClassMainLoopAsyncTables_классСГлавнымЦикломСинхрониазцииТАблиц
                        =new Class_Engine_SQL_SubClassMainLoopAsyncTables_КлассСГлавнымЦикломСинхрониазцииТАблиц(contextСозданиеБАзы,
                        Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы
                ,  public_contentДатыДляГлавныхТаблицСинхронизации, ГлавноеКоличестовТаблицОбрабатываемВГлавномЦиклеОбмена,ActivityДляСинхронизацииОбмена);

                ////TODO ТОЛЬКО НЕ ДЛЯ АКТИВТИ АНОНИМНЫЙ ОБМЕН БЕЗ ВИЗУАЛИЗАЦИИ СИНХРОНИЗАЦИИ
                РЕЗУЛЬТАТГЛАВНОЙСИНХРОНИАЗЦИИПОТАБЛИЦАМ=
                        Class_Engine_SQL_subClassMainLoopAsyncTables_классСГлавнымЦикломСинхрониазцииТАблиц.
                                МетодГлавныхЦиклТаблицДляСинхронизации(ДанныеПришёлЛиIDДЛяГенерацииUUID, КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная);




                /////
                if(РЕЗУЛЬТАТГЛАВНОЙСИНХРОНИАЗЦИИПОТАБЛИЦАМ==null){
                    //////
                    РЕЗУЛЬТАТГЛАВНОЙСИНХРОНИАЗЦИИПОТАБЛИЦАМ=0;
                }

                Log.i(this.getClass().getName(), "  ГЛАВНЫЙ ЦИКЛ ПРОШЕЛ .............. РЕЗУЛЬТАТГЛАВНОЙСИНХРОНИАЗЦИИПОТАБЛИЦАМ " + РЕЗУЛЬТАТГЛАВНОЙСИНХРОНИАЗЦИИПОТАБЛИЦАМ);



            }


        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();

            String ОшибкаКоторуюПропускам=e.fillInStackTrace().getMessage().toString();
            // TODO: 20.01.2022
            if (!ОшибкаКоторуюПропускам.equalsIgnoreCase("null")) {
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
            }
        }


        Log.i(this.getClass().getName(), " РЕЗУЛЬТАТГЛАВНОЙСИНХРОНИАЗЦИИПОТАБЛИЦАМ " + РЕЗУЛЬТАТГЛАВНОЙСИНХРОНИАЗЦИИПОТАБЛИЦАМ);
        return  РЕЗУЛЬТАТГЛАВНОЙСИНХРОНИАЗЦИИПОТАБЛИЦАМ;
    }












    /////TODO МЕТОД ЗАПУСКА ЦИКЛА ПО ПОЛУЧЕННЫСМ ТАБЛИЦ С СЕРВЕРА ДАННЫХ ЦИКЛ FOR

    /////TODO МЕТОД ЗАПУСКА ЦИКЛА ПО ПОЛУЧЕННЫСМ ТАБЛИЦ С СЕРВЕРА ДАННЫХ ЦИКЛ FOR


// TODO: 10.09.2021  запускаем метод обработки по таблицам

    Integer МетодЗапускаСинхрониазцииПоАТблицам(String данныеПришёлЛиIDДЛяГенерацииUUID,  String текущаяТаблицаДляОБменаДанными,String КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная,
                                                CompletionService МенеджерПотоковВнутрений,
                                                Integer СколькоСтрочекJSON ,
                                                PUBLIC_CONTENT public_contentДатыДляГлавныхТаблицСинхронизации,Activity ActivityДляСинхронизацииОбмена) {



        Log.d(this.getClass().getName(), " ТекущаяТаблицаДляОБменаДанными " + текущаяТаблицаДляОБменаДанными);

        boolean ОтветЕслиТакаяТаблицаВнутриОбработкиДляПринятияРешениеНачинатьОбрабткуИлиНет = false;
        //todo sleeep
        Integer   РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера=0;



        try {


            ///TODO сон
            РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера=0;
            //////TODO метод обрабтки п таюлицам
            РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера=
                    МетодДляАнализаВерсийДанныхПолучаемДатыСервера(текущаяТаблицаДляОБменаДанными, данныеПришёлЛиIDДЛяГенерацииUUID,
                            КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная,
                            МенеджерПотоковВнутрений,СколькоСтрочекJSON,public_contentДатыДляГлавныхТаблицСинхронизации,
                            ActivityДляСинхронизацииОбмена); ////Получение Версии Данных Сервера для дальнейшего анализа
            ///todo публикум название таблицы или цифру его
            ///TODO увеличиваем таюлицу оработки
            if(РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера==null){
                ////
                РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера=0;
            }


            Log.d(this.getClass().getName(), " РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера "
                    + РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера);




            // TODO: 12.08.2021 код повышает или уменьшает верисю данных ПОСЛЕ ОБРАБОТКИ ТАБЛИЦЫ И ДАТЫ



            /////////////////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }


// TODO: 23.05.2021


        return РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера;
    }

























    // TODO: 12.08.2021  метода повышает ВЕРСИЮ ДАННЫ Х ПОСЛЕ УСПЕШНОЙ СИНХРОНИАЗЦИИ ТАБЛИЦЫ


    Integer МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_ClientКонкретнойТаблицы(
            @NotNull Object ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера,
            @NotNull  String текущаяТаблицаДляОБменаДанными
            ,String  РежимПовышенияВерсииЛокальнаяСервернаяИлиОба
            ,Long РезультатВерсииДанныхЧатаНаСервере,
            CompletionService МенеджерПотоковВнутрений) {

        Integer    Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы=0;


        try{
            // TODO: 05.09.2021

            Long   ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССерверафИНАЛ=
                    Long.parseLong(String.valueOf(ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера));



            Log.i(this.getClass().getName(), "   ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССерверафИНАЛ"
                    +ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССерверафИНАЛ  +"  РезультатВерсииДанныхЧатаНаСервере " +РезультатВерсииДанныхЧатаНаСервере );

///todo ТО ЧТО ПРОШЛА КАКАЯ ТО  ОПЕРАЦИЯ УСПЕШНО ПО ТАБЛИЦЕ


            if (ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССерверафИНАЛ>0  &&  РезультатВерсииДанныхЧатаНаСервере>0) {


                Log.i(this.getClass().getName(), "   РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервераПовышаемДатыИВерсииДанных"
                        +ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера+
                        " ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера"
                        +ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера );


                Log.i(contextСозданиеБАзы.getClass().getName(), "   РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера"
                        + ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера +  "  текущаяТаблицаДляОБменаДанными "+  текущаяТаблицаДляОБменаДанными+
                        "  РезультатВерсииДанныхЧатаНаСервере " +РезультатВерсииДанныхЧатаНаСервере);


                // TODO: 03.09.2021  получение ПО НОВОМУ ДВИЖКУ
                Class_GRUD_SQL_Operations  classGrudSqlOperationsПовышаемВерсиюДАнных;
                // TODO: 30.08.2021    КОД ОБНОВЛЕНИЕ   ДАННЫХ   ЧЕРЕЗ
                //////
                classGrudSqlOperationsПовышаемВерсиюДАнных=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);
                ///
                classGrudSqlOperationsПовышаемВерсиюДАнных.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы",текущаяТаблицаДляОБменаДанными.trim());
                ///
                classGrudSqlOperationsПовышаемВерсиюДАнных.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба",
                        РежимПовышенияВерсииЛокальнаяСервернаяИлиОба.trim());///  "ЛокальныйСерверныйОба"    ПОСЛЕ КАК ПРИШЛИ ВНЕШНИЕ ДАННЫЕ
                ///



                ///
                classGrudSqlOperationsПовышаемВерсиюДАнных.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ДополнительныйФлагДляСинхЧАТАТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба",
                        РезультатВерсииДанныхЧатаНаСервере);///  "ЛокальныйСерверныйОба"    ПОСЛЕ КАК ПРИШЛИ ВНЕШНИЕ ДАННЫЕ
                ///



                ///TODO РЕЗУЛЬТА изменения версии данных
                Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы= (Integer)  classGrudSqlOperationsПовышаемВерсиюДАнных.
                        new ChangesVesionData(contextСозданиеБАзы).
                        changesvesiondata_Для_MODIFITATION_Client_ТОлькоДЛяТаблицИзГлавногоЦиклаВМоментСинхрониазацииДанных(classGrudSqlOperationsПовышаемВерсиюДАнных.
                                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                                МенеджерПотоковВнутрений,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);
//

                Log.d(contextСозданиеБАзы.getClass().getName(), "Результат_ПриписиИзменнийВерсииДанныхВФонеПриСменеОрганизации " +Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы );
                ////

                // TODO: 03.09.2021



                ///todo  конец  ДАННЫЙ КОД ИЗМЕНЯЕТ ВЕРИСЮ ДАННЫХ


                Log.w(contextСозданиеБАзы.getClass().getName(), "   Результат_ПриписиИзменнийВерсииДанныхВФоне:"
                        + Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы + " ТекущаяТаблицаДляОБменаДанными " + текущаяТаблицаДляОБменаДанными +
                        " Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы " + Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы);


                // TODO: 11.08.2021  доаолнительные запись ДАННЫХ СЕРВРЕА ПОСЛЕ УСТАВКИ НОВЫХ ДАННЫХ С СЕРВРЕА
            }


            if(Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы==null){
                ////
                Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы=0;
            }



// TODO: 15.10.2021    Увеличиваем обработунаю таюдиц дял отоброжения в прогресс баре если только таблица была успешно обработана

             /*    if(Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы>0){

                     ИндексТекущейОперацииJSONДляВизуальнойОбработки++;

                     Log.w(contextСозданиеБАзы.getClass().getName(), "   ИндексТекущейОперацииJSONДляВизуальнойОбработки:"
                             + ИндексТекущейОперацииJSONДляВизуальнойОбработки);
                 }
*/




            ///TODO конец повышение версиии
            /////////////////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(contextСозданиеБАзы.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

        return  Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы;

    }


    // TODO: 12.08.2021  МЕТОД ПРОСТОГО ПОВЫШЕНИЯ ВЕРСИИ ДАННЫХ В ПРОЕКТЕ


    public Integer МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_Client(
            @NotNull Object ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера,
            @NotNull String текущаяТаблицаДляОБменаДанными
            , String РежимПовышенияВерсииЛокальнаяСервернаяИлиОба
            , Long ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать,
            CompletionService МенеджерПотоковВнутрений) {

        Integer    Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы=0;


        try{
            // TODO: 05.09.2021

            Long   ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССерверафИНАЛ=
                    Long.parseLong(String.valueOf(ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера));



            Log.i(this.getClass().getName(), "   ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССерверафИНАЛ"
                    +ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССерверафИНАЛ  +"  РезультатВерсииДанныхЧатаНаСервере " +РезультатВерсииДанныхЧатаНаСервере +
                    "  ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать " + ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать);

///todo ТО ЧТО ПРОШЛА КАКАЯ ТО  ОПЕРАЦИЯ УСПЕШНО ПО ТАБЛИЦЕ


            if (ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССерверафИНАЛ>0  &&  ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать>0) {


                Log.i(this.getClass().getName(), "   РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервераПовышаемДатыИВерсииДанных"
                        +ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера+
                        " ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера"
                        +ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера );


                Log.i(contextСозданиеБАзы.getClass().getName(), "   РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера"
                        + ВходящийПараметрПослеУспешнойВсатвкиИлиобвнлденияДаннымиССервера +  "  текущаяТаблицаДляОБменаДанными "+  текущаяТаблицаДляОБменаДанными+
                        "  РезультатВерсииДанныхЧатаНаСервере " +РезультатВерсииДанныхЧатаНаСервере);


                // TODO: 03.09.2021  получение ПО НОВОМУ ДВИЖКУ
                Class_GRUD_SQL_Operations  classGrudSqlOperationsПовышаемВерсиюДАнных;
                // TODO: 30.08.2021    КОД ОБНОВЛЕНИЕ   ДАННЫХ   ЧЕРЕЗ
                //////
                classGrudSqlOperationsПовышаемВерсиюДАнных=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);
                ///
                classGrudSqlOperationsПовышаемВерсиюДАнных.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы",текущаяТаблицаДляОБменаДанными.trim());
                ///
                classGrudSqlOperationsПовышаемВерсиюДАнных.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба",
                        РежимПовышенияВерсииЛокальнаяСервернаяИлиОба.trim());///  "ЛокальныйСерверныйОба"    ПОСЛЕ КАК ПРИШЛИ ВНЕШНИЕ ДАННЫЕ
                ///


                ///
                classGrudSqlOperationsПовышаемВерсиюДАнных.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФлагТипИзменениеВерсииДанныхЛокальнаяСервернаяИлиОба",
                        РежимПовышенияВерсииЛокальнаяСервернаяИлиОба);

                ///
                classGrudSqlOperationsПовышаемВерсиюДАнных.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать",
                        ПередоваемоеЗначенияДляТаблицы_MODIFITATION_Client_КотороеНадоЗаписать);



                ///TODO РЕЗУЛЬТА изменения версии данных
                Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы= (Integer)  classGrudSqlOperationsПовышаемВерсиюДАнных.
                        new ChangesVesionData(contextСозданиеБАзы).
                        changesvesiondata(classGrudSqlOperationsПовышаемВерсиюДАнных.
                                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                                МенеджерПотоковВнутрений,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);
//

                Log.d(contextСозданиеБАзы.getClass().getName(), "Результат_ПриписиИзменнийВерсииДанныхВФонеПриСменеОрганизации "
                        +Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы );
                ////

                // TODO: 03.09.2021



                ///todo  конец  ДАННЫЙ КОД ИЗМЕНЯЕТ ВЕРИСЮ ДАННЫХ


                Log.w(contextСозданиеБАзы.getClass().getName(), "   Результат_ПриписиИзменнийВерсииДанныхВФоне:"
                        + Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы + " ТекущаяТаблицаДляОБменаДанными " + текущаяТаблицаДляОБменаДанными +
                        " Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы " + Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы);


                // TODO: 11.08.2021  доаолнительные запись ДАННЫХ СЕРВРЕА ПОСЛЕ УСТАВКИ НОВЫХ ДАННЫХ С СЕРВРЕА
            }


            if(Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы==null){
                ////
                Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы=0;
            }



// TODO: 15.10.2021    Увеличиваем обработунаю таюдиц дял отоброжения в прогресс баре если только таблица была успешно обработана

             /*    if(Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы>0){

                     ИндексТекущейОперацииJSONДляВизуальнойОбработки++;

                     Log.w(contextСозданиеБАзы.getClass().getName(), "   ИндексТекущейОперацииJSONДляВизуальнойОбработки:"
                             + ИндексТекущейОперацииJSONДляВизуальнойОбработки);
                 }
*/




            ///TODO конец повышение версиии
            /////////////////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(contextСозданиеБАзы.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

        return  Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы;

    }








































    ///TODO вычисляем если такая таблиЦА ВНУТРИ БАЗЫ
    private boolean МетодВЫчисляемВсеТаблицыВнутриКлинета(String ТекущаяТаблицаДляОБменаДанными,CompletionService МенеджерПотоковВнутрений) {
        ////
        boolean ЕслиТАкаяТаблица = false;
        ///
        Class_GRUD_SQL_Operations class_grud_sql_operationsВЫчисляемВсеТаблицыВнутриКлинета;
        ///
        SQLiteCursor КурсорВсехТаблицВнутри =null;

        try {
            ///////
            class_grud_sql_operationsВЫчисляемВсеТаблицыВнутриКлинета=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);


            class_grud_sql_operationsВЫчисляемВсеТаблицыВнутриКлинета=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);

            ///
            class_grud_sql_operationsВЫчисляемВсеТаблицыВнутриКлинета. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","sqlite_master");
            ///////
            class_grud_sql_operationsВЫчисляемВсеТаблицыВнутриКлинета. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","name");
            //
            class_grud_sql_operationsВЫчисляемВсеТаблицыВнутриКлинета. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","  type =  ?  ");
            ///"_id > ?   AND _id< ?"
            //////
            class_grud_sql_operationsВЫчисляемВсеТаблицыВнутриКлинета. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1","table");
            ///
        /*            class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......

            ////TODO другие поля*/

            ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
            ////
            //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
            ////
            //// class_grud_sql_operationsВерсииДаныхЧатаДляОтправкиЕгоНАСервер. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
            ////
            /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////



            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

            КурсорВсехТаблицВнутри= (SQLiteCursor)  class_grud_sql_operationsВЫчисляемВсеТаблицыВнутриКлинета.
                    new GetData(contextСозданиеБАзы).getdata(class_grud_sql_operationsВЫчисляемВсеТаблицыВнутриКлинета. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,МенеджерПотоковВнутрений,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

            Log.d(this.getClass().getName(), "GetData   " +КурсорВсехТаблицВнутри );


/*

            // TODO: 06.09.2021  _old

            Cursor КурсорВсехТаблицВнутри = ССылкаНаСозданнуюБазу.rawQuery("SELECT name FROM sqlite_master WHERE type = 'table'", null);






*/

            if (КурсорВсехТаблицВнутри.getCount() > 0) {
                ///
                КурсорВсехТаблицВнутри.moveToFirst();
                ////
                Log.d(this.getClass().getName(), "  КурсорВсехТаблицВнутри." + КурсорВсехТаблицВнутри.getCount());

                do {
                    ////
                    String ТаблицаИзБазыТекущей=КурсорВсехТаблицВнутри.getString(0);
                    ///
                    Log.d(this.getClass().getName(), "  ТаблицаИзБазыТекущей." +ТаблицаИзБазыТекущей);
                    //////
                    if (ТекущаяТаблицаДляОБменаДанными.equals(ТаблицаИзБазыТекущей)) {
                        Log.d(this.getClass().getName(), "  ТекущаяТаблицаДляОБменаДанными." + ТекущаяТаблицаДляОБменаДанными +
                                "  КурсорВсехТаблицВнутри.getString(0)) " + КурсорВсехТаблицВнутри.getString(0));

                        ЕслиТАкаяТаблица = true;

                        break;
                    }


                    Log.d(this.getClass().getName(), "  ТекущаяТаблицаДляОБменаДанными." + ТекущаяТаблицаДляОБменаДанными +
                            "  КурсорВсехТаблицВнутри.getString(0)) " + КурсорВсехТаблицВнутри.getString(0));


                } while (КурсорВсехТаблицВнутри.moveToNext());
                ////////
                КурсорВсехТаблицВнутри.close();

            } else {
                Log.d(this.getClass().getName(), "  КурсорВсехТаблицВнутри." + КурсорВсехТаблицВнутри.getCount());
                ЕслиТАкаяТаблица = false;
            }


            ///todo публикум название таблицы или цифру его
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

////
        return ЕслиТАкаяТаблица;
    }






















    /////////////////////ИЩЕМ ДАТУ СЕРВЕРВА
    Integer МетодДляАнализаВерсийДанныхПолучаемДатыСервера(String ТекущаяТаблицаДляОБменаДанными,
                                                           String ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                                           @NotNull String КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная,
                                                           CompletionService МенеджерПотоковВнутрений,
                                                           Integer СколькоСтрочекJSON,
                                                           PUBLIC_CONTENT public_contentДатыДляГлавныхТаблицСинхронизации
                                                           ,Activity ActivityДляСинхронизацииОбмена)
            throws JSONException, InterruptedException, ExecutionException, TimeoutException {
        //
        final Integer[] РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера = {0};
        //
        КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал=КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная;

        if (КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал.length()==0) {
            ///

            КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал="ПовторныйЗапускСинхронизации";
        }


///TODO принудительно устанвливаем редим работы синхронизации
        Log.d(this.getClass().getName(), " КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал "+КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);


        Log.d(this.getClass().getName(), " ДанныеПришёлЛиIDДЛяГенерацииUUID  " + ДанныеПришёлЛиIDДЛяГенерацииUUID + " ТекущаяТаблицаДляОБменаДанными "
                + ТекущаяТаблицаДляОБменаДанными +
                 " public_contentДатыДляГлавныхТаблицСинхронизации.ДатыТаблицыВерсииДанныхОтСервера " +public_contentДатыДляГлавныхТаблицСинхронизации.ДатыТаблицыВерсииДанныхОтСервера);


        try {
/////ТУТ -- КОД АНАЛИЗА ДАННЫХ SQL SERVER  ПРИШЕДШЕЙ ТЕКУЩЕЙ ТАБЛИЦЕ ПОЛУЧАЕМ НАЗВАНИЕ БАЗЫ И К НЕЙ ПОЛУЧАЕМ ДАТУ Е НЕЙ
            Observable observableшДляАнализаТекущейТаблицыВерсииДанных=Observable.fromIterable(public_contentДатыДляГлавныхТаблицСинхронизации.ДатыТаблицыВерсииДанныхОтСервера.entrySet())
                    .flatMapStream(new Function<Map.Entry<String, Long>, Stream<?>>() {
                        @Override
                        public Stream<?> apply(Map.Entry<String, Long> ХэшДляАнализаТекущейТаблицыВерсииДанных) throws Throwable {

                            // TODO: 15.02.2022

                            Long Полученная_ВерсияДанныхсSqlServer = 0l;

                            JSONObject ОбьектыJSONФайлJSONсСервераВерсияSQlserver = new JSONObject();

                            String ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных = "";

                            String ИмитацияВремяДляПроверки;

                            Date ИмитациДатыДляПроверки = null;

                            ///////
                            String ТесктДатыSqlServer = null;
                            //////
                            System.out.println(ХэшДляАнализаТекущейТаблицыВерсииДанных.getKey() + " - " + ХэшДляАнализаТекущейТаблицыВерсииДанных.getValue());

                            if (ХэшДляАнализаТекущейТаблицыВерсииДанных.getKey().equalsIgnoreCase(ТекущаяТаблицаДляОБменаДанными)) {///ищем в текущей строчке текущуе название таблицы например CFO==CFO
                                ////записываем в json  получену.юю текущаю названеи табиуви к ней дата ВЕРСИЯ ДАННЫХ
                                /////
                                ОбьектыJSONФайлJSONсСервераВерсияSQlserver.put(ХэшДляАнализаТекущейТаблицыВерсииДанных.getKey(), ХэшДляАнализаТекущейТаблицыВерсииДанных.getValue());
                                /////
                                Log.d(this.getClass().getName(), " ОбьектыJSONФайлJSONсСервераВерсияSQlserver " + ОбьектыJSONФайлJSONсСервераВерсияSQlserver.toString());
                                ////////

                                // TODO: 15.02.2022

                                ////ПЕРЕРДАЕМ ИМЯ ТАБЛИЦЫ ОТ SQL SERVER
                               ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных = ХэшДляАнализаТекущейТаблицыВерсииДанных.getKey();

                                // TODO: 15.02.2022


                                Log.d(this.getClass().getName(), " ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных" + ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных);

                                // TODO: 15.02.2022
                                //// ПЕРЕДАЕМ ДАТУ ИЗ ТАБЛИЦЫ ОТ SQL SERVER
                                Полученная_ВерсияДанныхсSqlServer = ХэшДляАнализаТекущейТаблицыВерсииДанных.getValue();

                                // TODO: 15.02.2022
                                if(Полученная_ВерсияДанныхсSqlServer==null){
                                    // TODO: 15.02.2022  Полученная_ВерсияДанныхсSqlServer
                                    Полученная_ВерсияДанныхсSqlServer=0l;
                                }



                                Log.d(this.getClass().getName(), " Полученная_ВерсияДанныхсSqlServer   " + Полученная_ВерсияДанныхсSqlServer);


                                ////////
                                // TODO: 05.10.2021
                                Log.d(this.getClass().getName(), " РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера " + РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера[0] +
                                        "  Полученная_ВерсияДанныхсSqlServer " + Полученная_ВерсияДанныхсSqlServer);


                                /////////////TODO ИДЕМ ПО ШАГАМ К ЗАПУСКИ СИНХРОГНИАЗЦИИ

                                РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера[0] =
                                        МетодДляВырвниванияНазванийТаблицВВерсияДанныхНаКлиентеСсервером(ОбьектыJSONФайлJSONсСервераВерсияSQlserver,
                                                Полученная_ВерсияДанныхсSqlServer, ТекущаяТаблицаДляОБменаДанными,
                                                ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных,
                                                ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                                МенеджерПотоковВнутрений,
                                                СколькоСтрочекJSON
                                                ,ActivityДляСинхронизацииОбмена);////метод получение даты версии данных из андройда

                                //


                                Log.d(this.getClass().getName(), " РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера " + РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера[0] +
                                        "  Полученная_ВерсияДанныхсSqlServer " + Полученная_ВерсияДанныхсSqlServer);


                                // TODO: 05.10.2021 ЕСЛИ ЛОКАЛЬНАЯ ТАБЛИЦА РАВНА С ТАБЛИЦЕЙ С ССЕРВЕРА ПО НАЗВАНИЮ

                            }


                            return Observable.fromArray(ХэшДляАнализаТекущейТаблицыВерсииДанных.getKey()).blockingStream().filter(РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри->
                                    РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри.equalsIgnoreCase(ТекущаяТаблицаДляОБменаДанными))
                                    .peek(РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри
                                    ->System.out.println(РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри));
                        }
                    })
                    .doOnError(new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Throwable {

                            Log.e(this.getClass().getName(), "   doOnError  ОШИБКА В  цикле ublic_contentДатыДляГлавныхТаблицСинхронизации.ДатыТаблицыВерсииДанныхОтСервера.entrySet() "
                                    + throwable.getStackTrace().toString());
                        }
                    })
                    .onErrorComplete(new Predicate<Throwable>() {
                        @Override
                        public boolean test(Throwable throwable) throws Throwable {

                            Log.e(this.getClass().getName(), "   onErrorComplete  ОШИБКА В  цикле ublic_contentДатыДляГлавныхТаблицСинхронизации.ДатыТаблицыВерсииДанныхОтСервера.entrySet() "
                                    + throwable.getStackTrace().toString());
                            return false;
                        }
                    });
            // TODO: 15.02.2022



// TODO: 14.01.2022 подписка на данные гланого цикла

            observableшДляАнализаТекущейТаблицыВерсииДанных.blockingSubscribe(System.out::println);


            // TODO: 15.02.2022
           // observableшДляАнализаТекущейТаблицыВерсииДанных.unsubscribeOn(Schedulers.computation());

            // TODO: 15.02.2022

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }
        return РезультаУспешнойВсатвкиИлиобвнлденияДаннымиССервера[0];
    }










    /////////////////////TODO метод ВЫРАВНИВАНИЯ ТАБЛИЦ МЕЖДУ КЛИЕНТОМ И СЕРВЕРОМ КОЛИЧЕСТВО ТАБЛИЦ ДОЛЖНО БЫТЬ ОДИНАКОВЫМ
    Integer МетодДляВырвниванияНазванийТаблицВВерсияДанныхНаКлиентеСсервером(JSONObject ФайлJSONcВерсиейДанныхСервера, Long Полученная_ВерсияДанныхсSqlServer,
                                                                             String ИмяТаблицыОтАндройда_Локальноая,
                                                                             String ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных,
                                                                             String ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                                                             CompletionService МенеджерПотоковВнутрений,
                                                                             Integer ГавноеКоличестоОбработываемТаблицвОбменаНаддынхЦикле
    ,Activity  ActivityДляСинхронизацииОбмена)
            throws InterruptedException, ExecutionException, TimeoutException {

        //////////
        Integer РезультатУспешнойВсатвкиИлиОбновлениясСервреа=null;

        Log.d(this.getClass().getName(), " ФайлJSONcВерсиейДанныхСервера " + ФайлJSONcВерсиейДанныхСервера.toString());

        JSONObject ОбьектыJSONvalue;

        JSONArray КлючJSONПолей = null;

        Cursor КурсорДляАнализаВерсииДанныхАндройда;

        String ТекстВерсииБазыАндрод = "";
        ////////
        String ДатаВерсииДанныхНаАндройдеЛокальногоОбновленияДляМетодаGET = null;

        Date ДатаВерсииДанныхНаАндройдеЛокальногоОбновления = null;

        String ДатаВерсииДанныхНаАндройдеДляМетодаGET = null;

        Date ДатаВерсииДанныхНаАндройде = null;

        ///
        Class_GRUD_SQL_Operations class_grud_sql_operationsВырвниванияНазванийТаблицВВерсияДанныхНаКлиентеСсервером=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);


        Class_GRUD_SQL_Operations.GetData class_grud_sql_operationsСамаОперация= class_grud_sql_operationsВырвниванияНазванийТаблицВВерсияДанныхНаКлиентеСсервером.new GetData(contextСозданиеБАзы);

        try {
            //// #1 РАСПАРСИВАЕМ ПРИШЕДШИЙ JSON С СЕРВРЕА ОТ SQL SERVER
            JSONArray КлючиJSONПолей = ФайлJSONcВерсиейДанныхСервера.names();

            // TODO: 15.02.2022 ЦИКЛ ВЫЧИСЛЕМ ВЕРСИИ ТАБЛИЦ ИХ ВЕРСИЯЯ С СЕРВЕРА С КЛИЕНТОМ  

            for (int ИндексПолучениеВерсииДанныхАндройда = 0; ИндексПолучениеВерсииДанныхАндройда < ФайлJSONcВерсиейДанныхСервера.names().length(); ИндексПолучениеВерсииДанныхАндройда++) {
                //
                // TODO: 06.09.2021
                String ИмяПоляДляВставкиВАндйрод = КлючиJSONПолей.getString(ИндексПолучениеВерсииДанныхАндройда); // Here's your key

                Log.d(this.getClass().getName(), " ИмяПоляДляВставкиВАндйрод " + ИмяПоляДляВставкиВАндйрод);

                String СодержимоеПоляДляВставкиВАндйрод = ФайлJSONcВерсиейДанныхСервера.getString(ИмяПоляДляВставкиВАндйрод); // Here's your value

                Log.d(this.getClass().getName(), " ЗначениеСтолбикаНазваниеТаблицНаСервере " + ИмяПоляДляВставкиВАндйрод + " ЗначениеСтолбикаВерсииТаблицНаСервере   " +
                        СодержимоеПоляДляВставкиВАндйрод);


                ///todo  new gRUD-enegree
                class_grud_sql_operationsВырвниванияНазванийТаблицВВерсияДанныхНаКлиентеСсервером.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","MODIFITATION_Client");
                ///////
                class_grud_sql_operationsВырвниванияНазванийТаблицВВерсияДанныхНаКлиентеСсервером.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","name");
                //
                class_grud_sql_operationsВырвниванияНазванийТаблицВВерсияДанныхНаКлиентеСсервером.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","  name=? ");
                ///"_id > ?   AND _id< ?"
                //////
                class_grud_sql_operationsВырвниванияНазванийТаблицВВерсияДанныхНаКлиентеСсервером.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",ИмяПоляДляВставкиВАндйрод);
                ///
        /*            class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......

            ////TODO другие поля*/

                ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
                ////
                //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
                ////
                //// class_grud_sql_operationsВерсииДаныхЧатаДляОтправкиЕгоНАСервер. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
                ////
                /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                ////



                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

                КурсорДляАнализаВерсииДанныхАндройда= (SQLiteCursor)  class_grud_sql_operationsСамаОперация
                        .getdata(class_grud_sql_operationsВырвниванияНазванийТаблицВВерсияДанныхНаКлиентеСсервером. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,МенеджерПотоковВнутрений,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

                Log.d(this.getClass().getName(), "GetData  КурсорДляАнализаВерсииДанныхАндройда  " +КурсорДляАнализаВерсииДанныхАндройда );


/*
                // TODO: 06.09.2021  _old
                ///// #2 ТЕПЕРЬ ПОЛУЧЕНЫЕ ДАННЫЕ А ТОЧНЕЕ НАЗВАНИЕ ТАБЛИЦ ЗАПИСЫВАЕМ В ВЕРСИЮ ДАННЫХ АНДРОЙД
                КурсорДляАнализаВерсииДанныхАндройда = КурсорУниверсальныйДляБазыДанных("MODIFITATION_Client", new String[]{"name"}, "name=?", new String[]{ИмяПоляДляВставкиВАндйрод},
                        null, null, null, null);///"SELECT name  FROM MODIFITATION_Client WHERE name=?",НазваниеТаблицНаСервере
                //"SuccessLogin", "date_update","id=","1",null,null,null,null
                ////////вставляем ноое название талицы если ее нет на андройде в таблице модификаци данных

*/


                /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
                /////////

                // TODO: 05.10.2021 ЗНАЧЕНИЕ КУРСОРА МИНУС 1 КОВОРИТ ОТ ТОМ ЧТО ТАБЛИЦЫ КОТОРАЯ ЕСТЬ НА СЕРВЕРА ПОЧЕМУ ТО ОТСУТСТУЕТ НА КЛИЕНТЕ И НАМ ЕЕ НАДО ДОБАВИТЬ
                //ОЧЕНЬ ВАЖНО ЕСЛИ ЭТОТ КУРСОР ВЕРНЕТЬ ПОЛОЖИТЕЛЬНО ЦИФРУ ЭТО ЗНАЧИИТ ЧТО ТАКАЯ ТАБЛИЦУ УЖЕ ЕСТЬ НА АНДРОЙДЕ И ВСТАВЛЯЕТЬ ЕЕ НЕ НАДО
                if (КурсорДляАнализаВерсииДанныхАндройда.getCount() < 1) {/////ЕСЛИ КУРСОР ВОЗВРЯЩАЕТ ЦИФРУ 1 ТО ТОГДА ДАННАЯ ТАБОИЦА УЖЕ ЕСТЬ В ТАБЛИЦЕ ВЕРСИЙ ДАНЫХ АНДРОЙДА
                    //////
                    Log.d(this.getClass().getName(), " КурсорДляАнализаВерсииДанныхАндройда.getCount() " + КурсорДляАнализаВерсииДанныхАндройда.getCount());

                    ContentValues КонтейнерВствкаНовыхИменТаблицМодифика = new ContentValues();
                    // TODO: 15.02.2022


                    КонтейнерВствкаНовыхИменТаблицМодифика.put("name", ИмяПоляДляВставкиВАндйрод);////ЗАПОЛЯНЕМ КОНТЕРЙНЕР ИМЯ ТАБЛИЦЫ КОТОРОЙ НЕТ ИЗ  СЕРВЕРА
                    //КонтейнерВствкаНовыхИменТаблицМодифика.put("versionserveraandroid", "2001-11-01 00:00:00");////ЗАПОЛЯНЕМ КОНТЕРЙНЕР ДАТУ ГЕНЕРИРУЕМ В ТАБЛИЦУ КОТОРО НЕТ
                    /////записываем если такой таблицы нет  на андройде в таблице модификация данных
// TODO: 15.02.2022

                    КонтейнерВствкаНовыхИменТаблицМодифика.put("localversionandroid","1900-01-10 00:00:00");
                    // TODO: 15.02.2022
                    КонтейнерВствкаНовыхИменТаблицМодифика.put("versionserveraandroid","1900-01-10 00:00:00");
                    // TODO: 15.02.2022


                    КонтейнерВствкаНовыхИменТаблицМодифика.put("localversionandroid_version",0);
                    // TODO: 15.02.2022
                    КонтейнерВствкаНовыхИменТаблицМодифика.put("versionserveraandroid_version",0);



                    // TODO: 15.02.2022  создаем не лостающую таблицу ан клиенте

                    Long РезультатВставкиНовойТаблицыКотройНетВЛокальнойБазе = ВставкаДанныхЧерезКонтейнерУниверсальная("MODIFITATION_Client",
                            КонтейнерВствкаНовыхИменТаблицМодифика,
                            ИмяТаблицыОтАндройда_Локальноая,
                            "",
                            false,
                            0,
                            false,
                            КонтекстСинхроДляКонтроллераВФоне,
                            ActivityДляСинхронизацииОбмена,
                            МенеджерПотоковВнутрений,
                            Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы,
                            ГавноеКоличестоОбработываемТаблицвОбменаНаддынхЦикле,
                            0,
                            ФиналПроценты); ////false  не записывать изменениея в таблице модификавет версия

                    Log.d(this.getClass().getName(), " РезультатВставкиНовойТаблицыКотройНетВЛокальнойБазе " + РезультатВставкиНовойТаблицыКотройНетВЛокальнойБазе);
                    ////
                    /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
                }
                else {

                    if(КурсорДляАнализаВерсииДанныхАндройда.getCount()>0){

                        КурсорДляАнализаВерсииДанныхАндройда.moveToFirst();
                    }
                    Log.i(this.getClass().getName(), " НазваниеТаблицНаСервере  " + ИмяПоляДляВставкиВАндйрод + " ФайлJSONcВерсиейДанныхСервера.names().length() "
                            + ФайлJSONcВерсиейДанныхСервера.names().length() + " КурсорДляАнализаВерсииДанныхАндройда.getCount()  " + КурсорДляАнализаВерсииДанныхАндройда.getCount());
                }



                // TODO: 05.10.2021


                break;
//внутри цикла
            }



            //////
            Log.w(this.getClass().getName(), " ИмяТаблицыОтАндройда_Локальноая " + ИмяТаблицыОтАндройда_Локальноая + " Полученная_ВерсияДанныхсSqlServer "
                    + Полученная_ВерсияДанныхсSqlServer + " ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных "
                    + ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных);



            //// ПОЛУЧИЛИ ДАТУ ОТ SQL SERVER  ДЛЯ ОПРЕЕЛЕННОЙ ТАБЛИЦЫ И ЗАПОЛНИЛИ ТАБЛИЦУ МОДИФИКАЦИЯ ДАНЫХ НА КЛИЕНТЕ  И ИДЕМ УЖЕ АНАЛИЗИРОВАТЬ ИХ НИЖЕ
            if (Полученная_ВерсияДанныхсSqlServer>= 0) {//TODO          if (Полученная_ВерсияДанныхсSqlServer> 0) {
                //////
                Log.d(this.getClass().getName(), " ИмяТаблицыОтАндройда_Локальноая " + ИмяТаблицыОтАндройда_Локальноая + " Полученная_ВерсияДанныхсSqlServer "
                        + Полученная_ВерсияДанныхсSqlServer + " ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных "
                        + ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных);



                //
                РезультатУспешнойВсатвкиИлиОбновлениясСервреа=0;
                //////////метод анализа данных
                РезультатУспешнойВсатвкиИлиОбновлениясСервреа=
                        МетодАнализаВресииДАнныхКлиента(ИмяТаблицыОтАндройда_Локальноая,
                                Полученная_ВерсияДанныхсSqlServer,
                                ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных
                                , ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                МенеджерПотоковВнутрений,ActivityДляСинхронизацииОбмена,ГавноеКоличестоОбработываемТаблицвОбменаНаддынхЦикле);



                /////////
                Log.i(this.getClass().getName(), " РезультатУспешнойВсатвкиИлиОбновлениясСервреа  " + РезультатУспешнойВсатвкиИлиОбновлениясСервреа);

                // TODO: 15.02.2022  версия данных  НА СЕРВЕР РАВНА 0 И ОБМЕН ЕН НУЖЕН
            }else{
                // TODO: 15.02.2022  версия данных  НА СЕРВЕР РАВНА 0 И ОБМЕН ЕН НУЖЕН
                //////
                Log.d(this.getClass().getName(), " ИмяТаблицыОтАндройда_Локальноая " + ИмяТаблицыОтАндройда_Локальноая + " НА сервер  ВЕРСИЯ 0 И ОБМЕНЕ НУЖЕН Полученная_ВерсияДанныхсSqlServer "
                        + Полученная_ВерсияДанныхсSqlServer + " ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных "
                        + ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных);
            }








        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }
        return  РезультатУспешнойВсатвкиИлиОбновлениясСервреа;
    }










    ////////////////////////////ДАННЫЙ МЕТОД ПОСЛЕ ВЫШЕ СТОЯШЕГО ВЫРАВНИЯНИЯ НАЗВАНИЙ ТАБЛИЦ ПРИСТУПАЕТ К САМОМУ АНАЛИЗУ ДАННЫХ ВЕРСИИ ДАННЫХ НАХОДЯЩИХСЯ НА АНДРОЙДЕ
    Integer МетодАнализаВресииДАнныхКлиента(String ИмяТаблицыОтАндройда_Локальноая,
                                            Long Полученная_ВерсияДанныхсSqlServer,
                                            String ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных,
                                            String ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                            CompletionService МенеджерПотоковВнутрений
    ,Activity ActivityДляСинхронизацииОбмена,Integer СколькоСтрочекJSON) {

        Log.d(this.getClass().getName(), " Полученная_ВерсияДанныхсSqlServer " +Полученная_ВерсияДанныхсSqlServer);

        SQLiteCursor КурсорДляАнализаВерсииДанныхАндройда = null;

        ////////////////

        Long ВерсииДанныхНаАндройдеЛокальнаяЛокальная = 0l;

        Long ВерсииДанныхНаАндройдеСерверная = 0l;

        Integer РезультатУспешнойВсатвкиИлиОбвовлениясСервера=0;

        // String ДатаВерсииДанныхНаАндройдеЛокальногоОбновленияДляМетодаGET = null;


        Class_GRUD_SQL_Operations class_grud_sql_operationsАнализаВресииДАнныхКлиента;


        try {

///
            class_grud_sql_operationsАнализаВресииДАнныхКлиента=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);

            // TODO: 15.02.2022
            Class_GRUD_SQL_Operations.GetData class_grud_sql_operationsgetdata=class_grud_sql_operationsАнализаВресииДАнныхКлиента.new GetData(contextСозданиеБАзы);

            ///
            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","MODIFITATION_Client");
            ///////
            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","name,localversionandroid_version, versionserveraandroid_version");
            //
            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","name=? ");
            ///"_id > ?   AND _id< ?"
            //////
            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",ИмяТаблицыОтАндройда_Локальноая);
            ///
/*            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......

            ////TODO другие поля

            ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);*/
            ////
            //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
            ////
            // class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
            ////
            /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

            КурсорДляАнализаВерсииДанныхАндройда= (SQLiteCursor)  class_grud_sql_operationsgetdata
                    .getdata(class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,МенеджерПотоковВнутрений,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

            Log.d(this.getClass().getName(), "GetData "+КурсорДляАнализаВерсииДанныхАндройда  );




            ///// todo
            // УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
            /////////ВАЖНО ЕСЛИ БОЛЬШЕ НУЛ ЗНАЧИТ В АНДРОЙДЕ ТАБЛИЦА С ТАКИМ НАЗВАНИЕМ УЖЕ ЕСТЬ

            /////
            if (КурсорДляАнализаВерсииДанныхАндройда.getCount() > 0) {////ВЫЖНОЕ УСЛОВИЕ ЕСЛИ КУРСОР ВЕРНУЛ БОЛЬШЕ НУЛЯ  ДАННАЕ ТОЛЬКО ТОГДА НАЧИНАЕМ АНАЛИЗ ВЕРСИИ ДАННЫХ НА АНДРОЙДЕ

                КурсорДляАнализаВерсииДанныхАндройда.moveToFirst();

                Log.d(this.getClass().getName(), "  Курсор_УзнаемВерсиюБазыНаАдройде.getCount() " + КурсорДляАнализаВерсииДанныхАндройда.getCount());
                //////////////


                // TODO: 05.10.2021  получаем верию данных лолькано    --- локльную

                ВерсииДанныхНаАндройдеЛокальнаяЛокальная = КурсорДляАнализаВерсииДанныхАндройда.getLong(КурсорДляАнализаВерсииДанныхАндройда.getColumnIndex("localversionandroid_version"));


                Log.d(this.getClass().getName(), "   ВерсииДанныхНаАндройдеЛокальнаяЛокальная " + ВерсииДанныхНаАндройдеЛокальнаяЛокальная+" ИмяТаблицыОтАндройда_Локальноая " +ИмяТаблицыОтАндройда_Локальноая);


                // TODO: 05.10.2021  получаем верию данных лолькано  - ерверную


                ВерсииДанныхНаАндройдеСерверная = КурсорДляАнализаВерсииДанныхАндройда.getLong(КурсорДляАнализаВерсииДанныхАндройда.getColumnIndex("versionserveraandroid_version"));


                Log.d(this.getClass().getName(), "   ВерсииДанныхНаАндройдеСерверная " +ВерсииДанныхНаАндройдеСерверная+"  ИмяТаблицыОтАндройда_Локальноая  "+ИмяТаблицыОтАндройда_Локальноая);

                ///////////ОПРЕДЕЛЯЕМ ДАТУ АНДРОЙДА ДЛЯ СОСТЫКОВКИ С ДАТОЙ SQ; SERVER//// ПОЛУЧАЕМ ДАТУ НА АНДРОЙДЕ ПОЛСЕДНЕЕ ИЗМЕНЕНИЯ ПРИШЕДЩИЕ ДАННЫЕ С СЕРВЕРА

            } else {


                Log.d(this.getClass().getName(), "  НЕт такой таблицы и нет Данных КурсорДляАнализаВерсииДанныхАндройда.getCount()" + КурсорДляАнализаВерсииДанныхАндройда.getCount());
            }


            // TODO: 05.10.2021  КОГДА ВСЕ ДАННЫЕ ЕСТЬ ТРИ ПЕРЕМЕННЫЕ ПОЛУЧЕНИЕ ПЕРЕХОИМ ДАЛЬШЕ ПОЛЯ ЛОКАЛЬНАЯ ВЕРСИЯ ДАННЫХ, СЕРВЕНАЯ ВЕРСИЯ ДАННЫХ, И ТЕРТЬЯ ВЕРИСЯ С СЕРВЕРА ПО ДАННОЙ ТАБЕЛИЦВ



            Log.d(this.getClass().getName(), "   ВерсииДанныхНаАндройдеСерверная " +ВерсииДанныхНаАндройдеСерверная+
                    "   ВерсииДанныхНаАндройдеЛокальнаяЛокальная " + ВерсииДанныхНаАндройдеЛокальнаяЛокальная
                    +"   Полученная_ВерсияДанныхсSqlServer " +Полученная_ВерсияДанныхсSqlServer);


            // TODO: 05.10.2021 ПРИ НАЛИЧИИ ВСЕХ ТРЕХ ПОЗИЦИЙ ЛОКАЛЬНАЯ ВЕРСИЯ С АНДРОЙДА   И СЕРВРНАЯ ВЕРСИЯ С АНДРОЙДА И  ПРИШЕДШЕЯ ВЕРСИЯ С СЕРВЕРА


            ///
            if (ВерсииДанныхНаАндройдеЛокальнаяЛокальная !=null  && ВерсииДанныхНаАндройдеСерверная!=null && Полученная_ВерсияДанныхсSqlServer!=null) {


                // TODO: 05.10.2021

                РезультатУспешнойВсатвкиИлиОбвовлениясСервера=0;
                ///////////////


                //TODO СЛЕДУЮЩИЙ ЭТАМ РАБОТЫ ОПРЕДЕЛЯЕМ ЧТО МЫ ДЕЛАЕМ ПОЛУЧАЕМ ДАННЫЕ С СЕВРЕРА ИЛИ НА ОБОРОТ  ОТПРАВЛЯЕМ ДАННЫЕ НА СЕРВЕР
                РезультатУспешнойВсатвкиИлиОбвовлениясСервера=       МетодПринятияРешенияПолучитьДанныесСервераИлиОтправитьДанныесКлиента(
                        ВерсииДанныхНаАндройдеЛокальнаяЛокальная,
                        ВерсииДанныхНаАндройдеСерверная,
                        Полученная_ВерсияДанныхсSqlServer,
                        ИмяТаблицыОтАндройда_Локальноая,
                        ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных,
                        ДанныеПришёлЛиIDДЛяГенерацииUUID,
                        МенеджерПотоковВнутрений
                ,ActivityДляСинхронизацииОбмена
                ,СколькоСтрочекJSON);///СЛЕДУЮЩИЙ ЭТАМ РАБОТЫ ОПРЕДЕЛЯЕМ ЧТО МЫ ДЕЛАЕМ ПОЛУЧАЕМ ДАННЫЕ С СЕВРЕРА ИЛИ НА ОБОРОТ  ОТПРАВЛЯЕМ ДАННЫЕ НА СЕРВЕР

                Log.d(this.getClass().getName(), "   РезультатУспешнойВсатвкиИлиОбвовлениясСервера " +РезультатУспешнойВсатвкиИлиОбвовлениясСервера);








            }else{

                // TODO: 15.02.2022  НЕТ ДАННЫ Х ДЛЯ ОДМЕНА ПО ТАБЛИЦЫЕ ТЕКУЩЕЙ

         new Handler(     contextСозданиеБАзы.getMainLooper()).post(()->{

             Toast.makeText(contextСозданиеБАзы, "Нет данных для обмена текущие таблицы:  "+ИмяТаблицыОтАндройда_Локальноая , Toast.LENGTH_LONG).show();


         });

                Log.e(this.getClass().getName(), "   Нет данных для обмена текущие таблицы " +ИмяТаблицыОтАндройда_Локальноая);


            }
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл

        }
        return  РезультатУспешнойВсатвкиИлиОбвовлениясСервера;
    }














    //TODO СЛЕДУЮЩИЙ ЭТАМ РАБОТЫ ОПРЕДЕЛЯЕМ ЧТО МЫ ДЕЛАЕМ ПОЛУЧАЕМ ДАННЫЕ С СЕВРЕРА ИЛИ НА ОБОРОТ  ОТПРАВЛЯЕМ ДАННЫЕ НА СЕРВЕР
    Integer МетодПринятияРешенияПолучитьДанныесСервераИлиОтправитьДанныесКлиента(Long ВерсииДанныхНаАндройдеЛокальнаяЛокальная,
                                                                                 Long ВерсииДанныхНаАндройдеСерверная,
                                                                                 Long Полученная_ВерсияДанныхсSqlServer,
                                                                                 String ИмяТаблицыОтАндройда_Локальноая,
                                                                                 String ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных,
                                                                                 String ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                                                                 CompletionService МенеджерПотоковВнутрений
    ,Activity ActivityДляСинхронизацииОбмена
    ,Integer СколькоСтрочекJSON) {
        //
        Log.d(this.getClass().getName(), " ВерсииДанныхНаАндройдеЛокальнаяЛокальная " + ВерсииДанныхНаАндройдеЛокальнаяЛокальная +
                " ВерсииДанныхНаАндройдеСерверная " + ВерсииДанныхНаАндройдеСерверная
                + " Полученная_ВерсияДанныхсSqlServer " + Полученная_ВерсияДанныхсSqlServer+
                "  ИмяТаблицыОтАндройда_Локальноая " +ИмяТаблицыОтАндройда_Локальноая+
                " ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных " +ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных+
                "  ДанныеПришёлЛиIDДЛяГенерацииUUID " +ДанныеПришёлЛиIDДЛяГенерацииUUID
                + " ФлагКакуюЧастьСинхронизацииЗапускаем " + ФлагКакуюЧастьСинхронизацииЗапускаем+
                 "  ActivityДляСинхронизацииОбмена " +ActivityДляСинхронизацииОбмена+ " СколькоСтрочекJSON "+СколькоСтрочекJSON);


        // TODO: 05.10.2021

        Integer Результат_ПосылаемНа_Сервер=0;//РезультатУспешнойВставкиИлИОбвновленияССервера

        Integer Результат_СсервераПолучаем_Сервер=0;//РезультатУспешнойВставкиИлИОбвновленияССервера

        try {




///// TODO НАЗВАНИЯ  ОБЯЗАТОЛЬНОЕ УСЛОВИЕ НАЗВАНИЕ ТАБЛИЦ ДОЛЖНО БЫТЬ ОДИНАКОВЫМ НАПРИМЕР  CFO==CFO
            if (ИмяТаблицыНаSqlServerИзТаблицыВерсииДанных.equalsIgnoreCase(ИмяТаблицыОтАндройда_Локальноая)) {//////ОБЯЗАТОЛЬНОЕ УСЛОВИЕ НАЗВАНИЕ ТАБЛИЦ ДОЛЖНО БЫТЬ ОДИНАКОВЫМ НАПРИМЕР  CFO==CFO


                // TODO: 01.08.2021  ОБРАБОТКА ТОЛЬКО ДЛЯ ТАЮДИЦ КРОМЕ ЧАТА   (ОБРАБОТКА ВСЕХ ТАБЛИЦ , КРОМЕ ТАБЛИЦ ЧАТА )  (ОБРАБОТКА ВСЕХ ТАБЛИЦ , КРОМЕ ТАБЛИЦ ЧАТА )

                Log.d(this.getClass().getName(),
                        " ФлагУказываетЧтоТОлькоОбработкаТаблицДляЧАТА" + ФлагУказываетЧтоТОлькоОбработкаТаблицДляЧАТА + " ИмяТаблицыОтАндройда_Локальноая " + ИмяТаблицыОтАндройда_Локальноая);
                //TODO вычисялем локалнуюю версию чата curennt cat local


                // TODO: 11.08.2021 --  ПЕРВОЕ ДЕЙСТИЕ ОТПРАВЛЯЕМ МЕТОД POS()-> НА СЕРВЕР   // TODO: 11.08.2021 --  ПЕРВОЕ ДЕЙСТИЕ ОТПРАВЛЯЕМ МЕТОД POS()-> НА СЕРВЕР   // TODO: 11.08.2021 --  ПЕРВОЕ ДЕЙСТИЕ ОТПРАВЛЯЕМ МЕТОД POS()-> НА СЕРВЕР


                // TODO: 11.08.2021  ЛОКАЛЬНАЯ СЕРВЕРНАЯ НА АНДРОЙДЕ

                Long РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера = 0l;

                // TODO: 12.08.2021 СЕРВЕРАНАЯ ДАТА ЛОКАЛЬНАЯ

                РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера =
                        МетодПолученияЛокальнойВерсииДаныхЧатаДляОтправкиЕгоНАСервер("MODIFITATION_Client", "versionserveraandroid_version",
                                contextСозданиеБАзы, ИмяТаблицыОтАндройда_Локальноая);


                Log.d(this.getClass().getName(),
                        " РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера" +
                                РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // TODO: 11.08.2021  ЛОКАЛЬНАЯ СЕРВЕРНАЯ НА АНДРОЙДЕ

                Long РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее = 0l;

                // TODO: 12.08.2021 ЛОКАЛЬНАЯ ДАТА ЛОКАЛЬНАЯ

                РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее =
                        МетодПолученияЛокальнойВерсииДаныхЧатаДляОтправкиЕгоНАСервер("MODIFITATION_Client", "localversionandroid_version",
                                contextСозданиеБАзы, ИмяТаблицыОтАндройда_Локальноая);


                Log.d(this.getClass().getName(),
                        " РезультаПолученаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее"
                                + РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее+ " ИмяТаблицыОтАндройда_Локальноая " +ИмяТаблицыОтАндройда_Локальноая);








                // TODO: 05.10.2021  ПЕРЕМЕННЫЕ ТОЛЬКО ДЛЯ ВТОРОГО МЕТОДА ПОЛУЧЕНИЯ ДАННЫХ С СЕРВРЕА


                РезультатВерсииДанныхЧатаНаСервере = 0l;


                Log.d(this.getClass().getName(),
                        " Полученная_ВерсияДанныхсSqlServer " + Полученная_ВерсияДанныхсSqlServer +
                                "  РезультатВерсииДанныхЧатаНаСервере " + РезультатВерсииДанныхЧатаНаСервере+ " ИмяТаблицыОтАндройда_Локальноая " +ИмяТаблицыОтАндройда_Локальноая);


                ////////
                РезультатВерсииДанныхЧатаНаСервере = Полученная_ВерсияДанныхсSqlServer;


                // TODO: 11.08.2021 НОВЫЙ ОБМЕН ДАННЫМИС СЕРВЕРРОМ НА ОСНОВЕ ВЕРСИЙ ДАННЫХ  ПОКА ТОЛЬКО ДЛЯ ЧАТА


                Log.d(this.getClass().getName(),
                        " РезультатВерсииДанныхЧатаНаСервере  " + РезультатВерсииДанныхЧатаНаСервере +
                                "  РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера " + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
                                + " ФлагКакуюЧастьСинхронизацииЗапускаем " + ФлагКакуюЧастьСинхронизацииЗапускаем+ " ИмяТаблицыОтАндройда_Локальноая " +ИмяТаблицыОтАндройда_Локальноая);


                // TODO: 05.10.2021  ПЕРЕМЕННЫЕ ТОЛЬКО ДЛЯ ВТОРОГО МЕТОДА ПОЛУЧЕНИЯ ДАННЫХ С СЕРВРЕА











// TODO: 19.10.2021   post()-> 1


                // TODO: 05.10.2021  ПЕРВОЕ ДЕЙСТВИЕ  ДЕЙСТВИЕ ЕСЛИ НЕТ ОТПРАВЛЕНИЕ ВЫШЕ ДАННЫХ      // TODO: 05.10.2021  ПЕРВОЕ ДЕЙСТВИЕ  ДЕЙСТВИЕ ЕСЛИ НЕТ ОТПРАВЛЕНИЕ ВЫШЕ ДАННЫХ     // TODO: 05.10.2021  ПЕРВОЕ ДЕЙСТВИЕ  ДЕЙСТВИЕ ЕСЛИ НЕТ ОТПРАВЛЕНИЕ ВЫШЕ ДАННЫХ

                ////// TODO запуск отпарвки  ЛОКАЛЬНАЯ ПРОВЕРКА ВЕРСИИ ДАНННЫХ  #1 НА АНДРОЙДЕ ВЕРСИЯ ДАННЫХ ПОСЛЕДНАЯЯ НАДО С АНДРОЙДА ПОСЛАТЬ ДАННЫЕ НА СЕРВЕР
                if (РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее > // TODO original РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее
                        РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
                        && ! ИмяТаблицыОтАндройда_Локальноая.equalsIgnoreCase("view_onesignal")) {  ///  && ФлагКакуюЧастьСинхронизацииЗапускаем.equalsIgnoreCase("Запускаем Только Отправления Синхронизации")//ПРОВЕРЯЕМ ДАТЫ КАКАЯ БОЛЬШЕ МЕНЬШЕ тут больше что слева sql server
                    //////  НАЧАЛО  ЛОКАЛЬНАЯ ПРОВЕРКА ВНУТИРИ АНДРОЙДА ПО ДАТАМ МЕЖДУ СОБОЙ



                    Log.d(this.getClass().getName(),
                            " РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее  " + РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее +
                                    "  РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера " + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
                                    + " ФлагКакуюЧастьСинхронизацииЗапускаем " + ФлагКакуюЧастьСинхронизацииЗапускаем+ " ИмяТаблицыОтАндройда_Локальноая " +ИмяТаблицыОтАндройда_Локальноая);






                    Результат_ПосылаемНа_Сервер = МетодОбменаЗаданиеДляСервера_ПосылаемНа_Сервер(ИмяТаблицыОтАндройда_Локальноая,
                            МенеджерПотоковВнутрений, Результат_ПосылаемНа_Сервер,
                            Результат_СсервераПолучаем_Сервер,
                            РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера,
                            РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее);


                    // TODO: 19.10.2021   get()->


                    if(Результат_ПосылаемНа_Сервер>0 ){
                        ///
                        ПубличныйРезультатОтветаОтСерврераУспешно=    Результат_ПосылаемНа_Сервер ;

                        //МетодДляЧатаПоказываемВизуальноОтправкуИИлиПолучениеДанных();
                    }


                    // TODO: 05.10.2021  ДЕЙСТИВЕ ТРЕТЬЕ ОТПРАВЛЯЕМ ЕСЛИ ЕСТЬ В ТАБЛИЦЕ ТЕКУЩЕЙ NULL ПОЛЕ В СТОЛИЬКЕ ID

                    Log.d(this.getClass().getName(),
                            " РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее  "
                                    + РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее +
                                    "  РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера "
                                    + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
                                    + " Результат_ПосылаемНа_Сервер " + Результат_ПосылаемНа_Сервер);

                    // TODO: 05.10.2021  ДЕЙСТИВЕ ВТОРОЕ ПОЛУЧАЕМ ДАННЫЕ ОТ СЕРВЕРА ДЛЯ ТЕКЦЩЕЙ ТАБЛИЦЫ


                    // TODO: 11.08.2021 --ДОПОЛНИТЕЛЬНЫЙ МЕТОД ВНУТРИ ОТПРАВКИ КОДЕ ИМЫ ЕСЛИ ПРОШЛО УСПЕШНОЕ ОТПАРВКА ДАННЫХ МЫ ДОПОЛНИЬТЕЛЬНО,
                    //  ДЛЯ ПРОВЕРКА ПОПЫТАЕМСЯ ПОЛУЧИТЬ С СЕРАРП ДанныеПришёлЛиIDДЛяГенерацииUUID

                    if (Результат_ПосылаемНа_Сервер>0) {
                        // TODO: 18.01.2022




                        // TODO: 11.08.2021 --ДОПОЛНИТЕЛЬНЫЙ МЕТОД ВНУТРИ ОТПРАВКИ КОДЕ ИМЫ ЕСЛИ ПРОШЛО УСПЕШНОЕ ОТПАРВКА ДАННЫХ МЫ ДОПОЛНИЬТЕЛЬНО,

                        // TODO: 11.08.2021 --ДОПОЛНИТЕЛЬНЫЙ МЕТОД ВНУТРИ ОТПРАВКИ КОДЕ ИМЫ ЕСЛИ ПРОШЛО УСПЕШНОЕ ОТПАРВКА ДАННЫХ МЫ ДОПОЛНИЬТЕЛЬНО,

                        if (РезультатВерсииДанныхЧатаНаСервере > РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
                        || РезультатВерсииДанныхЧатаНаСервере.compareTo(РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера)==0) { // С СЕРВЕРА//&& ФлагКакуюЧастьСинхронизацииЗапускаем.equalsIgnoreCase("Запускаем Только Получения Синхронизации")
                            //////


                            // TODO: 11.08.2021 --ДОПОЛНИТЕЛЬНЫЙ МЕТОД ВНУТРИ ОТПРАВКИ КОДЕ ИМЫ ЕСЛИ ПРОШЛО УСПЕШНОЕ ОТПАРВКА ДАННЫХ МЫ ДОПОЛНИЬТЕЛЬНО,

                            Log.d(this.getClass().getName(),
                                    " РезультатВерсииДанныхЧатаНаСервере  " + РезультатВерсииДанныхЧатаНаСервере +
                                            "  РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера " + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
                                            + " ФлагКакуюЧастьСинхронизацииЗапускаем " + ФлагКакуюЧастьСинхронизацииЗапускаем+ " ИмяТаблицыОтАндройда_Локальноая " +ИмяТаблицыОтАндройда_Локальноая);

                            // TODO: 05.10.2021  ДЕЙСТИВЕ ВТОРОЕ ПОЛУЧАЕМ ДАННЫЕ ОТ СЕРВЕРА ДЛЯ ТЕКЦЩЕЙ ТАБЛИЦЫ
                            Результат_СсервераПолучаем_Сервер = МетодОбменаЗаданиеСервера_сервераПолучаем_Сервер(ВерсииДанныхНаАндройдеЛокальнаяЛокальная,
                                    ИмяТаблицыОтАндройда_Локальноая, ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                    МенеджерПотоковВнутрений, Результат_СсервераПолучаем_Сервер,
                                    РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера,ActivityДляСинхронизацииОбмена,СколькоСтрочекJSON);


                            // TODO: 05.10.2021  ДЕЙСТИВЕ ТРЕТЬЕ ОТПРАВЛЯЕМ ЕСЛИ ЕСТЬ В ТАБЛИЦЕ ТЕКУЩЕЙ NULL ПОЛЕ В СТОЛИЬКЕ ID

                            // TODO: 28.10.2021 ПЕРЕРДАЕМ ВОЗМОЖНЫЙ ОТВЕТ

                            if(Результат_СсервераПолучаем_Сервер>0 ){
                                ///
                                ПубличныйРезультатОтветаОтСерврераУспешно=Результат_СсервераПолучаем_Сервер;

                                // МетодДляЧатаПоказываемВизуальноОтправкуИИлиПолучениеДанных();
                            }

                            Log.d(this.getClass().getName(),
                                    " РезультатВерсииДанныхЧатаНаСервере  " + РезультатВерсииДанныхЧатаНаСервере +
                                            "  РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера "
                                            + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
                                            + " ФлагКакуюЧастьСинхронизацииЗапускаем " + ФлагКакуюЧастьСинхронизацииЗапускаем+
                                            "  Результат_СсервераПолучаем_Сервер " +Результат_СсервераПолучаем_Сервер);
                            // TODO: 05.10.2021  ДЕЙСТИВЕ ТРЕТЬЕ ОТПРАВЛЯЕМ ЕСЛИ ЕСТЬ В ТАБЛИЦЕ ТЕКУЩЕЙ NULL ПОЛЕ В СТОЛИЬКЕ ID
                            // TODO: 05.10.2021  ДЕЙСТИВЕ ТРЕТЬЕ ОТПРАВЛЯЕМ ЕСЛИ ЕСТЬ В ТАБЛИЦЕ ТЕКУЩЕЙ NULL ПОЛЕ В СТОЛИЬКЕ ID
                        }
                    }
























                    // TODO: 05.10.2021  ДЕЙСТИВЕ ВТОРОЕ ПОЛУЧАЕМ ДАННЫЕ ОТ СЕРВЕРА ДЛЯ ТЕКЦЩЕЙ ТАБЛИЦЫ
                    // TODO: 05.10.2021  ДЕЙСТИВЕ ВТОРОЕ ПОЛУЧАЕМ ДАННЫЕ ОТ СЕРВЕРА ДЛЯ ТЕКЦЩЕЙ ТАБЛИЦЫ

                } else {


                    // TODO: 19.10.2021   get()->

                    // TODO: 05.10.2021  ДЕЙСТИВЕ ВТОРОЕ ПОЛУЧАЕМ ДАННЫЕ ОТ СЕРВЕРА ДЛЯ ТЕКЦЩЕЙ ТАБЛИЦЫ
                    // TODO: 05.10.2021  ДЕЙСТИВЕ ВТОРОЕ ПОЛУЧАЕМ ДАННЫЕ ОТ СЕРВЕРА ДЛЯ ТЕКЦЩЕЙ ТАБЛИЦЫ
                    // TODO: 05.10.2021  ДЕЙСТИВЕ ВТОРОЕ ПОЛУЧАЕМ ДАННЫЕ ОТ СЕРВЕРА ДЛЯ ТЕКЦЩЕЙ ТАБЛИЦЫ





                    // TODO: 12.08.2021 START GET()-> // TODO: 12.08.2021 START GET()->  // TODO: 12.08.2021 START GET()->  // TODO: 12.08.2021 START GET()->  // TODO: 12.08.2021 START GET()->
                    // TODO: 12.08.2021 СЕРВЕРАНАЯ ДАТА ЛОКАЛЬНАЯ


                    // TODO: 11.08.2021 --ПЕРВОЕ УСЛОВИЕ НОВОГО МЕХАНИЗМА  ПРОВЕРЯЕМ НЕ БОЛЬШЕ ЛИ ВЕРСИЯ ДАННЫХ НА СЕРВЕРЕ ???  GET()->

                    if (РезультатВерсииДанныхЧатаНаСервере > РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера) { // С СЕРВЕРА//&& ФлагКакуюЧастьСинхронизацииЗапускаем.equalsIgnoreCase("Запускаем Только Получения Синхронизации")
                        //////

                        Log.d(this.getClass().getName(),
                                " РезультатВерсииДанныхЧатаНаСервере  " + РезультатВерсииДанныхЧатаНаСервере +
                                        "  РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера " + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
                                        + " ФлагКакуюЧастьСинхронизацииЗапускаем " + ФлагКакуюЧастьСинхронизацииЗапускаем+ " ИмяТаблицыОтАндройда_Локальноая " +ИмяТаблицыОтАндройда_Локальноая);





                        // TODO: 05.10.2021  ДЕЙСТИВЕ ВТОРОЕ ПОЛУЧАЕМ ДАННЫЕ ОТ СЕРВЕРА ДЛЯ ТЕКЦЩЕЙ ТАБЛИЦЫ

                        Результат_СсервераПолучаем_Сервер = МетодОбменаЗаданиеСервера_сервераПолучаем_Сервер(ВерсииДанныхНаАндройдеЛокальнаяЛокальная,
                                ИмяТаблицыОтАндройда_Локальноая, ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                МенеджерПотоковВнутрений, Результат_СсервераПолучаем_Сервер,
                                РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера ,ActivityДляСинхронизацииОбмена,СколькоСтрочекJSON);


                        // TODO: 05.10.2021  ДЕЙСТИВЕ ТРЕТЬЕ ОТПРАВЛЯЕМ ЕСЛИ ЕСТЬ В ТАБЛИЦЕ ТЕКУЩЕЙ NULL ПОЛЕ В СТОЛИЬКЕ ID

                        // TODO: 28.10.2021 ПЕРЕРДАЕМ ВОЗМОЖНЫЙ ОТВЕТ

                        if(Результат_СсервераПолучаем_Сервер>0 ){
                            ///
                            ПубличныйРезультатОтветаОтСерврераУспешно=Результат_СсервераПолучаем_Сервер;

                            //  МетодДляЧатаПоказываемВизуальноОтправкуИИлиПолучениеДанных();
                        }

                        Log.d(this.getClass().getName(),
                                " РезультатВерсииДанныхЧатаНаСервере  " + РезультатВерсииДанныхЧатаНаСервере +
                                        "  РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера "
                                        + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
                                        + " ФлагКакуюЧастьСинхронизацииЗапускаем " + ФлагКакуюЧастьСинхронизацииЗапускаем+
                                        "  Результат_СсервераПолучаем_Сервер " +Результат_СсервераПолучаем_Сервер);
                        // TODO: 05.10.2021  ДЕЙСТИВЕ ТРЕТЬЕ ОТПРАВЛЯЕМ ЕСЛИ ЕСТЬ В ТАБЛИЦЕ ТЕКУЩЕЙ NULL ПОЛЕ В СТОЛИЬКЕ ID
                        // TODO: 05.10.2021  ДЕЙСТИВЕ ТРЕТЬЕ ОТПРАВЛЯЕМ ЕСЛИ ЕСТЬ В ТАБЛИЦЕ ТЕКУЩЕЙ NULL ПОЛЕ В СТОЛИЬКЕ ID
                    }


                }




                // TODO: 05.10.2021  ДЕЙСТИВЕ ТРЕТЬЕ ОТПРАВЛЯЕМ ЕСЛИ ЕСТЬ В ТАБЛИЦЕ ТЕКУЩЕЙ NULL ПОЛЕ В СТОЛИЬКЕ ID
//                        // TODO: 05.10.2021  ДЕЙСТИВЕ ТРЕТЬЕ ОТПРАВЛЯЕМ ЕСЛИ ЕСТЬ В ТАБЛИЦЕ ТЕКУЩЕЙ NULL ПОЛЕ В СТОЛИЬКЕ ID
//                        // TODO: 05.10.2021  ДЕЙСТИВЕ ТРЕТЬЕ ОТПРАВЛЯЕМ ЕСЛИ ЕСТЬ В ТАБЛИЦЕ ТЕКУЩЕЙ NULL ПОЛЕ В СТОЛИЬКЕ ID
//
//


            }


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }



        Log.i(this.getClass().getName(), "   Результат_ПосылаемНа_Сервер"
                + Результат_ПосылаемНа_Сервер + "  ПубличныйРезультатОтветаОтСерврераУспешно " +ПубличныйРезультатОтветаОтСерврераУспешно+
                "  ИмяТаблицыОтАндройда_Локальноая " +ИмяТаблицыОтАндройда_Локальноая+
                " Результат_СсервераПолучаем_Сервер " +Результат_СсервераПолучаем_Сервер);
        ///////



        Log.i(this.getClass().getName(), "  ПубличныйРезультатОтветаОтСерврераУспешно " +ПубличныйРезультатОтветаОтСерврераУспешно);

        // TODO: 28.10.2021

        return  ПубличныйРезультатОтветаОтСерврераУспешно;
    }





/*    //TODO после успешного полцчение или отправки данных с серврер на клиент и обратно показываем пользователю это при чате

    private void МетодДляЧатаПоказываемВизуальноОтправкуИИлиПолучениеДанных() {
        // TODO: 28.10.2021  визуально офрмление для чата


        try {


            Log.i(this.getClass().getName(), "   МетодДляЧатаПоказываемВизуальноОтправкуИИлиПолучениеДанных  ");

            // TODO: 03.11.2021




                        EditText editTextТелоНаписаногоСообщенияДругимСотрудникам = null;

            if (ActivityДляСинхронизацииОбмена!=null) {

                // TODO: 18.01.2022
                editTextТелоНаписаногоСообщенияДругимСотрудникам= (EditText)  ActivityДляСинхронизацииОбмена.findViewById(R.id.editTextТелоНаписаногоСообщенияДругимСотрудникам);
            }
            ///
                        if (editTextТелоНаписаногоСообщенияДругимСотрудникам!=null) {

                            // TODO: 28.10.2021
                            editTextТелоНаписаногоСообщенияДругимСотрудникам.setHintTextColor(Color.parseColor("#E0FFFF"));
                            ///////
                            //
                            editTextТелоНаписаногоСообщенияДругимСотрудникам.setHint("Обмен данными....");
                            // TODO: 28.10.2021


                            // TODO: 08.11.2021

                        *//*    Vibrator v2 = (Vibrator) ActivityДляСинхронизацииОбмена.getSystemService(Context.VIBRATOR_SERVICE);
                            // Vibrate for 500 milliseconds
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                v2.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.EFFECT_DOUBLE_CLICK));
                            } else {
                                //deprecated in API 26
                                v2.vibrate(250);
                            }*//*


                            EditText finalEditTextТелоНаписаногоСообщенияДругимСотрудникам = editTextТелоНаписаногоСообщенияДругимСотрудникам;
                            editTextТелоНаписаногоСообщенияДругимСотрудникам.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    // TODO: 19.10.2021
                                    finalEditTextТелоНаписаногоСообщенияДругимСотрудникам.setHintTextColor(Color.parseColor("#00ACC1"));
                                    //

                                    finalEditTextТелоНаписаногоСообщенияДругимСотрудникам.setHint("Напишите сообщение !!!");

                                }
                            },500);
                        }

                // TODO: 28.10.2021






    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ////// начало запись в файл
    }

}*/

    @NonNull
    private Integer МетодОбменаЗаданиеДляСервера_ПосылаемНа_Сервер(String ИмяТаблицыОтАндройда_Локальноая,
                                                                   CompletionService МенеджерПотоковВнутрений,
                                                                   Integer Результат_ПосылаемНа_Сервер,
                                                                   Integer Результат_СсервераПолучаем_Сервер,
                                                                   Long РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
            , Long РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее) {




        try{
        Log.d(this.getClass().getName(),
                " ЛОКАЛЬНАЯ ВЕРСИЯ (последнего серверного обновления) ЧАТ   РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера   "
                        + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
                        + "  ЛОКАЛЬНАЯ ЛОКАЛЬНАЯ ВЕРСИЯ (локальные обновления созданые на андройде) ЧАТ   РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее   "
                        + РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее +
                        " ФлагКакуюЧастьСинхронизацииЗапускаем " + ФлагКакуюЧастьСинхронизацииЗапускаем
                        + "РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера  "
                        + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера +
                        "  ИмяТаблицыОтАндройда_Локальноая " + ИмяТаблицыОтАндройда_Локальноая +
                        "  ПОСЛЕДНИЙ УСПЕШНЫЙ ОБНОВЛЕНИЕ С СЕРВРЕА " + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера + "\n" +
                        "  ПОСЛЕДНИЙ УСПЕШНЫЙ ДОБАЛВЕНИЯ НОВОГО СООБЩЕНИЯ " + РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее);


        // TODO: 04.11.2021


        // TODO: 03.11.2021

        ////// todo МЕТОД POST
        Результат_ПосылаемНа_Сервер =
                МетодПосылаемДанныеНаСервервФоне(ИмяТаблицыОтАндройда_Локальноая, РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера,
                        МенеджерПотоковВнутрений);
        ////// todo МЕТОД POST() в фоне

        ////// todo ВНИМАНИЕ ТУТ КОД НА АНДРОЙДЕ ВЕРСИЯ ДАННЫХ БОЛЬШЕ  ЧЕМ НА СЕРВЕРЕ   ,,,,,,, И МЫ ДОЛЖНЫ С ТЕЛЕФОНА ОТОСЛАТЬ ДАННЫЕ НА СЕВРЕР SQL SEVER   POST ()
        ///
        Log.d(this.getClass().getName(),
                "    Результат_ПосылаемНа_Сервер  " + Результат_ПосылаемНа_Сервер +
                        " РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера "
                        + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера +
                        "  РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее "
                        + РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее + " ИмяТаблицыОтАндройда_Локальноая " + ИмяТаблицыОтАндройда_Локальноая);

        // TODO: 04.11.2021


        Log.d(this.getClass().getName(),
                "    Результат_ПосылаемНа_Сервер  " + Результат_ПосылаемНа_Сервер +
                        " РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера "
                        + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера +
                        "  РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее "
                        + РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее +
                        " ИмяТаблицыОтАндройда_Локальноая " + ИмяТаблицыОтАндройда_Локальноая + "  РезультатВерсииДанныхЧатаНаСервере " + РезультатВерсииДанныхЧатаНаСервере
                        + " Результат_СсервераПолучаем_Сервер " + Результат_СсервераПолучаем_Сервер);

        //////// TODO  В ДАННОМ СЛУЧАЕ НА СЕРВРЕР ВЕРСИЯ  ДАННЫХ СТАРШЕ ЧЕМ НА АНДЙРОДЕ , И МЫ ПОЛУЧАЕМ ДАННЫЕ С СЕРВЕРА  GET()


        if (Результат_ПосылаемНа_Сервер > 0) {
            // TODO: 04.11.2021

            // TODO: 03.11.2021  УВЕЛИЧЕНИЕ ПОСЛЕ ВСТАВКИ


            Log.i(this.getClass().getName(), "   РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее"
                    + РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее);


            // TODO: 12.08.2021 код повышает или уменьшает верисю данных
            Integer РезультатПовышенияВерсииДанныхДатыиВерсии =
                    МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_ClientКонкретнойТаблицы(Результат_ПосылаемНа_Сервер,
                            ИмяТаблицыОтАндройда_Локальноая, "ЛокальныйСерверныйОба",//"Серверный" "ЛокальныйСерверныйОба"
                            РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее,
                            МенеджерПотоковВнутрений);//ЛокальныйСерверныйОба /// "Серверный"

            Log.i(this.getClass().getName(), "   ИмяТаблицыОтАндройда_Локальноая"
                    + ИмяТаблицыОтАндройда_Локальноая + " Результат_ПосылаемНа_Сервер " + Результат_ПосылаемНа_Сервер +
                    "  РезультатПовышенияВерсииДанныхДатыиВерсии " + РезультатПовышенияВерсииДанныхДатыиВерсии);


        }
    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ////// начало запись в файл
    }


        // TODO: 12.08.2021 код повышает или уменьшает верисю данных при отправке данных
        return Результат_ПосылаемНа_Сервер;
    }

    @NonNull
    private Integer МетодОбменаЗаданиеСервера_сервераПолучаем_Сервер(Long ВерсииДанныхНаАндройдеЛокальнаяЛокальная,
                                                                     String ИмяТаблицыОтАндройда_Локальноая,
                                                                     String ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                                                     CompletionService МенеджерПотоковВнутрений,
                                                                     Integer Результат_СсервераПолучаем_Сервер,
                                                                     Long РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера
    ,Activity ActivityДляСинхронизацииОбмена
    ,Integer СколькоСтрочекJSON) {
        // TODO: 05.10.2021  ДЕЙСТИВЕ ВТОРОЕ ПОЛУЧАЕМ ДАННЫЕ ОТ СЕРВЕРА ДЛЯ ТЕКЦЩЕЙ ТАБЛИЦЫ
        // TODO: 05.10.2021  ДЕЙСТИВЕ ВТОРОЕ ПОЛУЧАЕМ ДАННЫЕ ОТ СЕРВЕРА ДЛЯ ТЕКЦЩЕЙ ТАБЛИЦЫ
        try{

        ///////
        Log.d(this.getClass().getName(), " НА SQL SERVER  ДАТА больше версия" +
                "  ЛОКАЛЬНАЯ ВЕРСИЯ (последнего серверного обновления) ЧАТ  РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера " + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера +
                " и  ТЕКУЩАЯ СЕРВЕРНАЯ ВЕРСИЯ  ЧАТ РезультатВерсииДанныхЧатаНаСервере " + РезультатВерсииДанныхЧатаНаСервере + ИмяТаблицыОтАндройда_Локальноая);

        // TODO: 19.08.2021 уменьшаемм для повторгого повторной отправки

        // TODO: 04.11.2021


        // TODO: 03.11.2021

        //   Integer НесколькоПопытокПолучитьДанные = 3;
        // TODO: 04.11.2021


        //////////TODO МЕТОД get
        Результат_СсервераПолучаем_Сервер =
                МетодПолучаемДаннныесСервера(ИмяТаблицыОтАндройда_Локальноая,
                        РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера,
                        ДанныеПришёлЛиIDДЛяГенерацииUUID,
                        ВерсииДанныхНаАндройдеЛокальнаяЛокальная,
                        РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера,
                        МенеджерПотоковВнутрений,ActivityДляСинхронизацииОбмена, СколькоСтрочекJSON);/// ЗАПУСКАМ МЕТОД ПОЛУЧЕНИЕ ДАННЫХ С СЕРВЕРА    МЕТОД GET


        Log.d(this.getClass().getName(), " ПОСЛЕ УСПЕШНОЙ ОТПАРВКИ ДАННЫХ НА СЕРВЕР" +
                " Результат_СсервераПолучаем_Сервер " + Результат_СсервераПолучаем_Сервер +
                "  РезультатВерсииДанныхЧатаНаСервере" + РезультатВерсииДанныхЧатаНаСервере + "  ИмяТаблицыОтАндройда_Локальноая " + ИмяТаблицыОтАндройда_Локальноая + "\n" +
                "  РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера " + РезультаПолученаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);
        /////В ДАНОМ СЛУЧАЕ ДАННЫЕ СИНХРОНИЗИРОВАТЬ НЕ НАДО ВЕСРИЯ ДАННЫХ НА СЕРВРЕР И НА КЛИЕНТЕ ОДИНАКОВЫ
        // TODO: 17.11.2021


        ////TODO КОГДА ДАТЫ РАВНЫ И НЕ ПОЛУЧАТЬ ДАННЫЕ И ОТСЫЛАТЬ НЕ НАДО GET() И POST() ОБА НЕ СРАБОТАЛИ

        if (Результат_СсервераПолучаем_Сервер > 0) {

            // TODO: 04.11.2021
            ///РезультатВерсииДанныхЧатаНаСервере=РезультатВерсииДанныхЧатаНаСервере+1;

            // TODO: 16.07.2021
            Log.d(this.getClass().getName(), "РезультатВерсииДанныхЧатаНаСервере  " + РезультатВерсииДанныхЧатаНаСервере);

            Integer РезультатПовышенияВерсииДанныхДатыиВерсии = 0;


            // TODO: 16.07.2021
            Log.d(this.getClass().getName(), "КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал  " + КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);


            // TODO: 12.08.2021 код повышает или уменьшает верисю данных
            РезультатПовышенияВерсииДанныхДатыиВерсии =
                    МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_ClientКонкретнойТаблицы(Результат_СсервераПолучаем_Сервер,
                            ИмяТаблицыОтАндройда_Локальноая,
                            "ЛокальныйСерверныйОба",//"Серверный"  //"ЛокальныйСерверныйОба"
                            РезультатВерсииДанныхЧатаНаСервере,
                            МенеджерПотоковВнутрений);//ЛокальныйСерверныйОба ////"Серверный"


            // TODO: 04.11.2021

            Log.i(this.getClass().getName(), "   ИмяТаблицыОтАндройда_Локальноая"
                    + ИмяТаблицыОтАндройда_Локальноая + " Результат_СсервераПолучаем_Сервер " + Результат_СсервераПолучаем_Сервер +
                    "  РезультатПовышенияВерсииДанныхДатыиВерсии " + РезультатПовышенияВерсииДанныхДатыиВерсии);





        }


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }




        return Результат_СсервераПолучаем_Сервер;
    }


    // TODO: 19.08.2021 Класс ВЫЧИСЛЯЕТ ЕЩЕ НЕ ОТРРВЛЕННЫЕ СООБЩЕНИЯ НА СЕРВЕР ИЗ ЧАТА
    class ClassCalculateInFieldIDNULLMeanDataValueNotyetsent  {
        ////

        private     String  ТекущаяТаблицаГдеЕстьвIdПолеNULL;

        public ClassCalculateInFieldIDNULLMeanDataValueNotyetsent(Context context,String  ТекущаяТаблицаГдеЕстьвIdПолеNULL) {


            Log.d(this.getClass().getName(), "ТекущаяТаблицаГдеЕстьвIdПолеNULL "
                    +ТекущаяТаблицаГдеЕстьвIdПолеNULL);
        }

        public String getТекущаяТаблицаГдеЕстьвIdПолеNULL() {
            return ТекущаяТаблицаГдеЕстьвIdПолеNULL;
        }

        public void setТекущаяТаблицаГдеЕстьвIdПолеNULL(String текущаяТаблицаГдеЕстьвIdПолеNULL) {
            ТекущаяТаблицаГдеЕстьвIdПолеNULL = текущаяТаблицаГдеЕстьвIdПолеNULL;
        }



        // TODO: 19.08.2021 МЕТОД ВЫЧИСЛЯЕТ ЕЩЕ НЕ ОТРРВЛЕННЫЕ СООБЩЕНИЯ НА СЕРВЕР ИЗ ЧАТА


        private Long МетодВычисляемЕщенеОтправленныеСообщенияНаСервер(CompletionService МенеджерПотоковВнутрений) {

            Long ЕслиВПолеIdЗначениеNUll=0l;

            //
            SQLiteCursor Курсор_ЗначениемФИО_ВообщеЕстьЛиНеОтправленныеСтрочкиСNULLЗначениямивСтолбикеID=null;
            ////
            Class_GRUD_SQL_Operations class_grud_sql_operationsВычисляемЕщенеОтправленныеСообщенияНаСервер;

            try{


                Log.d(this.getClass().getName(), "ТекущаяТаблицаГдеЕстьвIdПолеNULL "
                        +ТекущаяТаблицаГдеЕстьвIdПолеNULL);

                class_grud_sql_operationsВычисляемЕщенеОтправленныеСообщенияНаСервер=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);



                switch (ТекущаяТаблицаГдеЕстьвIdПолеNULL.trim()){



                    case "tabels":
                    case "chats":
                    case "data_chat":
                    case "chat_users":
                    case "fio":
                    case "tabel":
                    case "data_tabels":








                        //    ИщемЗначенияNULLВТаблицахЧат.appendWhere("_id  IS NULL ");//_id =  ?


                   /*  sqLiteCursorКурсорсоЗначениемФИО=
                                       КтоНаписалСообщениеФИО.query(ССылкаНаСозданнуюБазу,new String[]{"*"},"_id",new String[]{String.valueOf(ПолученноеФИОКемБылоНаписаноСообщение)},null,null,null,null);*/
                        ///
                        class_grud_sql_operationsВычисляемЕщенеОтправленныеСообщенияНаСервер. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы",ТекущаяТаблицаГдеЕстьвIdПолеNULL);
                        ///////
                        class_grud_sql_operationsВычисляемЕщенеОтправленныеСообщенияНаСервер. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","uuid");
                        //
                        class_grud_sql_operationsВычисляемЕщенеОтправленныеСообщенияНаСервер. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","  _id  IS  NULL    ");
                        ///"_id > ?   AND _id< ?"
                        //////
                        ///  class_grud_sql_operationsВычисляемЕщенеОтправленныеСообщенияНаСервер. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",0);
                        ///
                        //////
                        // class_grud_sql_operationsВычисляемЕщенеОтправленныеСообщенияНаСервер. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",0);



/*            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......

            ////TODO другие поля

            ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);*/
                        ////
                        //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
                        ////
                        // class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
                        ////
                        /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                        ////

                        // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

                        Курсор_ЗначениемФИО_ВообщеЕстьЛиНеОтправленныеСтрочкиСNULLЗначениямивСтолбикеID= (SQLiteCursor)  class_grud_sql_operationsВычисляемЕщенеОтправленныеСообщенияНаСервер.
                                new GetData(contextСозданиеБАзы).getdata(class_grud_sql_operationsВычисляемЕщенеОтправленныеСообщенияНаСервер.
                                concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,МенеджерПотоковВнутрений,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

                        Log.d(this.getClass().getName(), "GetData "+Курсор_ЗначениемФИО_ВообщеЕстьЛиНеОтправленныеСтрочкиСNULLЗначениямивСтолбикеID  );


/*


            // TODO: 06.09.2021  _old
            sqLiteCursorКурсорсоЗначениемФИО=
                    (SQLiteCursor)    ИщемЗначенияNULLВТаблицахЧат.query(ССылкаНаСозданнуюБазу,new String[]{"uuid" }
                            ,null,null,null,null,null);
*/


                        if(Курсор_ЗначениемФИО_ВообщеЕстьЛиНеОтправленныеСтрочкиСNULLЗначениямивСтолбикеID.getCount()>0){
                            //
                            Курсор_ЗначениемФИО_ВообщеЕстьЛиНеОтправленныеСтрочкиСNULLЗначениямивСтолбикеID.moveToFirst();
                            /////
                            ЕслиВПолеIdЗначениеNUll = Курсор_ЗначениемФИО_ВообщеЕстьЛиНеОтправленныеСтрочкиСNULLЗначениямивСтолбикеID.getLong(0);
                            //

                            Log.d(this.getClass().getName(), "  СЛУЖБА ДА ДА ДА Сработала !!!!  в таблице ЧАТА chats and data_chat   " +
                                    "есть NULL (не отправленные сообщения на сервер ) ФиоКтоНАписалСообщение  " + ЕслиВПолеIdЗначениеNUll  + "\n"+
                                    "  ТекущаяТаблицаГдеЕстьвIdПолеNULL " +ТекущаяТаблицаГдеЕстьвIdПолеNULL);
                        }

                        /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК






                        //
                        break;

                }



            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ////// начало запись в файл
            }

            return  ЕслиВПолеIdЗначениеNUll;
        }

    }





    // TODO: 19.08.2021   КОнец Класс ВЫЧИСЛЯЕТ ЕЩЕ НЕ ОТРРВЛЕННЫЕ СООБЩЕНИЯ НА СЕРВЕР ИЗ ЧАТА
    // TODO: 19.08.2021   КОнец Класс ВЫЧИСЛЯЕТ ЕЩЕ НЕ ОТРРВЛЕННЫЕ СООБЩЕНИЯ НА СЕРВЕР ИЗ ЧАТА




























    /////МЕТОД КОГДА НА СЕРВЕРЕ ВЕРСИЯ ДАННЫХ ВЫШЕ И МЫ ПОЛУЧАЕМ ДАННЫЕ С СЕРВРА
    Integer МетодПолучаемДаннныесСервера(String имяТаблицыОтАндройда_локальноая,
                                         Long ВерсииДанныхНаАндройдеСерверная,
                                         String ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                         Long ВерсииДанныхНаАндройдеЛокальнаяЛокальная
            ,Long  РезультаПолученаяЛокальнаяВерсияДанныхДляОтправкиНаСервер,
                                         CompletionService МенеджерПотоковВнутрений ,
                                         Activity ActivityДляСинхронизацииОбмена
    ,Integer СколькоСтрочекJSON) {
        ////
        Log.d(this.getClass().getName(), "  ДанныеПришёлЛиIDДЛяГенерацииUUID " + ДанныеПришёлЛиIDДЛяГенерацииUUID);

        Integer РезультатФоновнойСинхронизации=0;
        ////
        StringBuffer БуферПолученныйJSON = null;
        try {
            Log.d(this.getClass().getName(), "  МетодПолучаемДаннныесСервера" + "  имяТаблицыОтАндройда_локальноая" + имяТаблицыОтАндройда_локальноая);

            //////САМ МЕТОД КОТОРЫМ ЗАПУСКАЕМ ПРОЦЕССС ОБМЕНА ДАННЫХ
            StringBuffer БуферПолучениеДанных = new StringBuffer();



            //

            // TODO: 15.06.2021 получение данных ссервера в фоне

            try {
// TODO: 27.01.2022 два разынх адреса пига получени данных        //// TODO РЕЛИЗ
//                           // linkedBlockingDequeОчередьПодключениюКСерверу.add("http://tabel.dsu1.ru:8888/");
//
//
//                            //// TODO РЕЛИЗ
//                            //
//                            /////
//                           linkedBlockingDequeОчередьПодключениюКСерверу.add("http://192.168.254.40:8080/");


                // TODO: 28.01.2022
                String НазваниеПорта="tabel.dsu1.ru";

                // TODO: 16.02.2022
                Integer СамПорт=8888;

     /*       // TODO: 28.01.2022
            String НазваниеПорта="192.168.254.40";
            Integer СамПорт=8080;
            ///*/

                ////////////////
                БуферПолучениеДанных = УниверсальныйБуферПолучениеДанныхсСервера(имяТаблицыОтАндройда_локальноая, "",
                        "", "application/gzip", "Хотим Получить  JSON",
                        ВерсииДанныхНаАндройдеСерверная,
                        ДанныеПришёлЛиIDДЛяГенерацииUUID,60000,null,
                        РезультаПолученаяЛокальнаяВерсияДанныхДляОтправкиНаСервер,
                        НазваниеПорта, СамПорт);//TODO "http://192.168.254.40:8080/"      /      // TODO     "http://tabel.dsu1.ru:8888/"   original     "tabel.dsu1.ru", 8888);




                // TODO: 25.10.2021
                if(БуферПолучениеДанных==null){
                    ///
                    БуферПолучениеДанных = new StringBuffer();
                }


                Log.d(this.getClass().getName(), "  МетодПолучаемДаннныесСервера" + "  БуферПолучениеДанных" + БуферПолучениеДанных.toString()+"\n"
                        + "  БуферПолучениеДанных.length()" + БуферПолучениеДанных.length());




            } catch (IOException e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            }



// TODO: 05.10.2021  ПОЛУЧЕННЫЙ JSON ПОТОК ОТ СЕРВЕРА

            if ( БуферПолучениеДанных.toString().toCharArray().length > 3) {
                /////

                /////ЦИКЛ ПЕРЕБОРА JSON КОТОРЫЙ ПРИШЁЛ\
                Log.d(this.getClass().getName(), "  БуферПолучениеДанных.toString()) " + БуферПолучениеДанных.toString()+"\n"
                        + "  БуферПолучениеДанных.length()" + БуферПолучениеДанных.length());



                БуферПолученныйJSON = new StringBuffer();

                /////ЦИКЛ ПЕРЕБОРА JSON КОТОРЫЙ ПРИШЁЛ\
                Log.d(this.getClass().getName(), "  БуферПолучениеДанных.toString()) " + БуферПолучениеДанных.toString());


                // TODO: 05.10.2021  loop

                do {
                    БуферПолученныйJSON.append(БуферПолучениеДанных.toString());



                    Log.d(this.getClass().getName(), " БуферПолученныйJSON внутри цикла  " + БуферПолученныйJSON.toString());


                } while (БуферПолучениеДанных == null);
                //////



                ////////Присылаем количестов строчек обработанных на сервлете
                Log.d(this.getClass().getName(), " БуферПолученныйJSON.length()  " + БуферПолученныйJSON.length());
                //////
                Log.d(this.getClass().getName(), " БуферПолученныйJSON  " + БуферПолученныйJSON.toString());
                ////
                /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
                int Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы = 0;


                Log.i(this.getClass().getName(), "   Результат_ПриписиИзменнийВерсииДанныхВФоне:"
                        + Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы + " имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);





                // TODO: 05.10.2021   ПОЛУЧИЛИ ДАННЫХ С СЕРВЕРА
                // TODO: 05.10.2021   ПОЛУЧИЛИ ДАННЫХ С СЕРВЕРА

                try {
                    //////TODO запускаем метод распарстивая JSON
                    РезультатФоновнойСинхронизации=        МетодПарсингJSONФайлаОтСервреравФоне(БуферПолученныйJSON,
                            имяТаблицыОтАндройда_локальноая,МенеджерПотоковВнутрений,ActivityДляСинхронизацииОбмена,СколькоСтрочекJSON);/////ЗАПУСК МЕТОДА ПАСРИНГА JSON



                    Log.i(this.getClass().getName(), " РезультатФоновнойСинхронизации  "  +РезультатФоновнойСинхронизации);

                    //поймать ошибку всего классаIOException | MyException e    NumberFormatException
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    // TODO: 01.09.2021 метод вызова
                    new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                }





                /////////
            } else {////ОШИБКА В ПОЛУЧЕНИИ С СЕРВЕРА ТАБЛИУЦЫ МОДИФИКАЦИИ ДАННЫХ СЕРВЕРА
                Log.d(this.getClass().getName(), " Данных нет c сервера сам файл JSON   пришел от сервера БуферПолучениеДанных   "+БуферПолучениеДанных);
            }

            //////




        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }
        Log.i(this.getClass().getName(), " РезультатФоновнойСинхронизации "+РезультатФоновнойСинхронизации);


        /////
        return РезультатФоновнойСинхронизации;
    }












    /////// TODO МЕТОД ПАСРИНГА ПРИШЕДШЕГО  С СЕРВЕРА ВНУТРИ ASYNSTASK В ФОНЕ
    Integer МетодПарсингJSONФайлаОтСервреравФоне(StringBuffer БуферПолученныйJSON,
                                                 String имяТаблицыОтАндройда_локальноая,
                                                 CompletionService МенеджерПотоковВнутрений,
                                                 Activity ActivityДляСинхронизацииОбмена
    ,Integer СколькоСтрочекJSON) throws InterruptedException, JSONException {
        ///
        Integer РезулттаВставкиИЛИОбвлоенияФФоне = 0;

        try {
            Log.d(this.getClass().getName(), " БуферПолученныйJSON " + БуферПолученныйJSON.toString());


            ////TODO ЗАДЕРЖКА ИТЕРАЦИЯ ДЛЯ СИНРОНИЗАЦИИ В ФОНЕ отправка данных

            //////
            //////
            ////TODO ДВИЖОК ПАРСИНГ JSON     //// ДВИЖОК ПАРСИНГ JSON     //// ДВИЖОК ПАРСИНГ JSON     //// ДВИЖОК ПАРСИНГ JSON     //// ДВИЖОК ПАРСИНГ JSON     //// ДВИЖОК ПАРСИНГ JSON     //// ДВИЖОК ПАРСИНГ JSON
            JSONObject JSON_ПерваяЧасть = new JSONObject(БуферПолученныйJSON.toString());/////ВАЖНО ПОЛУЧЕНИЕ JSON ОБЬЕКТОВ ИЗ БУФЕРА , ЧТОБЫ ДАЛЛЕ РАЗНЕСТИ ЕГО ПО СТРОЧКАМ
            ////TODO ДВИЖОК ПАРСИНГ JSON
            JSONArray JSON_ВтораяЧасть = JSON_ПерваяЧасть.names();////КОЛИЧЕСТВВОсТРОЧЕК В JSON
            //////todoОбнуялем
            ///TODO
            boolean СработалПоворот = false;
            ///////TODO ОПРЕДЕЛЯЕМ ОБЩЕЕ КОЛИЧЕСТВО JSON ВСЕГО МЕТОД
            ///TODO симофор устанавлием


            ///TODO Для Получение данных с сервера

/*            ContentValues АдаптерПриОбновленияДанныхсСервера = new ContentValues();
            //////
            ContentValues    АдаптерДляВставкиДанныхсСервер = new ContentValues();*/

            HashMap<String, Integer> ХэшIDУведомленияДляПриняитиеРешениеУлалениеЛишнихСтрочек = new HashMap<>();

            //TODO САМОЕ ВАЖНОЕ ПРЕОБРАЗОВАНИЕ ИТЕРАТОР ДЕЛАЕМ ПО СТРОЧКАМ  ВНИМАНИЕ !!!!!!!!!


          Iterator<String> iteratorJSON = JSON_ПерваяЧасть.keys();

            Log.d(this.getClass().getName(), " САМЫЙЙ ГЛАВНЫЙ iteratorJSON " + iteratorJSON);


            // TODO: 16.02.2022
            Stream<String> ГлавныйStreamОбменаПОСтрокам = StreamSupport.stream(
                    Spliterators.spliteratorUnknownSize(iteratorJSON, Spliterator.ORDERED | Spliterator.NONNULL),
                    true);


            // TODO: 16.02.2022

   /*         Stream<String> targetStream = Stream.generate(iteratorJSON::next);

            // TODO: 16.02.2022
            Stream<String> targetStreamдВА = StreamSupport.stream(
                    Spliterators.spliteratorUnknownSize(iteratorJSON, Spliterator.ORDERED),
                    true);

            Log.d(this.getClass().getName(), " САМЫЙЙ ГЛАВНЫЙ targetStream " + targetStream+ " targetStreamдВА " +targetStreamдВА);*/

         //   Iterator<String> iteratorJSON = (Iterator<String>) Observable.fromArray(JSON_ПерваяЧасть.keys()).blockingNext().;

         //   Iterator<String> iteratorJSON =Observable.fromIterable( JSON_ПерваяЧасть.keys());

            // TODO: 29.10.2021
           /* targetStreamдВА.parallel().forEachOrdered((ТекущаяСтрочка)->{
                Log.d(this.getClass().getName(), " САМЫЙЙ ГЛАВНЫЙ ТекущаяСтрочка " + ТекущаяСтрочка);
            });*/

            //////TODO ИДЁМ ПО СТРОКАМ --JSON
          Integer[] Результат_ОбновлениеДаннымисСервера = {0};///////после того как
            ////
         Long[] Результат_ВставкаДаннымисСервера = {0l};///////после того как

            Log.d(this.getClass().getName(), " JSON_ПерваяЧасть.names() " + JSON_ПерваяЧасть.names()+ "  ГлавныйStreamОбменаПОСтрокам " +ГлавныйStreamОбменаПОСтрокам);
//////////

            Integer ИндексТекущееСтрочкиДляКонтейнераВставки = 0;


            Long СколькоСтрочек = 0l;

            /// ИндексПослеОбработкиВсейТаблицыJSONДляВизуальнойОбработки=0;
            // TODO: 17.10.2021
            ИндексТекущейОперацииJSONДляВизуальнойОбработки = 0;


            if (ActivityДляСинхронизацииОбмена != null) {
                /////
                ActivityДляСинхронизацииОбмена.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        ///TODO ОБВНОВЛЕНИЕ false это првидбно начит это не первый запуск и нужно и обновление

                        progressBar3ГоризонтальныйСинхронизации = (ProgressBar) ActivityДляСинхронизацииОбмена.findViewById(R.id.progressBar3ГоризонтальныйСинхронизации);


                        if (progressBar3ГоризонтальныйСинхронизации != null) {

                            int МаксималноеКоличествоСтрочекJSON = 0;
                            ////
                            if (JSON_ПерваяЧасть.names().length() > 0) {

                                МаксималноеКоличествоСтрочекJSON = JSON_ПерваяЧасть.names().length();
                            }
                            /////
                            if (МаксималноеКоличествоСтрочекJSON > 0) {
                                progressBar3ГоризонтальныйСинхронизации.setMax(МаксималноеКоличествоСтрочекJSON);
                            }
                            ///todo
                            /////
                            progressBar3ГоризонтальныйСинхронизации.setProgress(0);


                            progressBar3ГоризонтальныйСинхронизации.getProgressDrawable().setColorFilter(  Color.parseColor("#00ACC1"), android.graphics.PorterDuff.Mode.SRC_IN);
                        }

                        ///

                        //////////

                    }
                });
            }

            // TODO: 05.10.2021  ВИЗУАЛЬАНОЕ ОТОБРАЖЕННИЕ В ПРОГРЕСС БАРЕ


            LinkedBlockingQueue<String> ЗаполненыеСистемныеТаблицыДляПроВизуализацииПрогрессБара = new Class__Generation_Genetal_Tables(contextСозданиеБАзы).
                    МетодЗаполеннияТаблицДЛяРаботыиСинхрониазции();


// TODO: 18.10.2021  Индекс для Массовго Конетйнера

            final Integer[] ИндексДляМассовогоКонтейнер = {0};


            // TODO: 18.10.2021  ГЛАВНЫЙ ЦИКЛ РАСПАРИСВАНИЯ JSON// TODO: 18.10.2021  ГЛАВНЫЙ ЦИКЛ РАСПАРИСВАНИЯ JSON// TODO: 18.10.2021  ГЛАВНЫЙ ЦИКЛ РАСПАРИСВАНИЯ JSON
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                // TODO: 29.10.2021
                АдаптерДляМассовойВставкиДанныхсСервер = null;


                АдаптерДляМассовойВставкиДанныхсСервер = new ContentValues[JSON_ПерваяЧасть.names().length()];//JSON_ПерваяЧасть.names().length()


                // TODO: 29.10.2021


                for (int i = 0; i < АдаптерДляМассовойВставкиДанныхсСервер.length; i++) {

                    АдаптерДляМассовойВставкиДанныхсСервер[i] = new ContentValues();
                }
                // TODO: 29.10.2021
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    Log.w(this.getClass().getName(), "count " + АдаптерДляМассовойВставкиДанныхсСервер.length);
                }

            }


            // TODO: 03.11.2021   показываем какая таблицы обрабоатываемться



            //TODO ФУТУРЕ ЗАВЕРШАЕМ
            Log.d(this.getClass().getName(), "  ЗаполненыеСистемныеТаблицыДЛяСинхронизации " + ЗаполненыеСистемныеТаблицыДляПроВизуализацииПрогрессБара.size());
            Integer ИндексТекущееТаллицыДляПониманияВизуальнойОтобрабжения=1;

            Iterator<String> iteratorДляПониманияПоложенияТаблицы=    ЗаполненыеСистемныеТаблицыДляПроВизуализацииПрогрессБара.iterator();


//TODO БЕЖИМ ПО СТРОЧКАМ ПОТОКА JSON ->

            while( iteratorДляПониманияПоложенияТаблицы.hasNext()) {

                String ПолученааяТаблицы=   iteratorДляПониманияПоложенияТаблицы.next();

                /////
                if (  имяТаблицыОтАндройда_локальноая.contentEquals(ПолученааяТаблицы)) {
                    // TODO: 18.10.2021

                    ИндексПослеОбработкиВсейТаблицыJSONДляВизуальнойОбработки=ИндексТекущееТаллицыДляПониманияВизуальнойОтобрабжения;

                    // TODO: 18.10.2021
                    break;

                }
                ИндексТекущееТаллицыДляПониманияВизуальнойОтобрабжения++;

            }

            //
            if (ActivityДляСинхронизацииОбмена!=null) {
                // TODO: 17.11.2021
                new Class_Visible_Processing_Async(contextСозданиеБАзы).МетодВизуальногоОтображенияХодаВизуальнойСинхронизации(0,
                        true,
                        (Activity) ActivityДляСинхронизацииОбмена,
                        ИндексПослеОбработкиВсейТаблицыJSONДляВизуальнойОбработки ,
                        СколькоСтрочекJSON,ФиналПроценты);
            }


            Log.d(this.getClass().getName(), "  ИндексПослеОбработкиВсейТаблицыJSONДляВизуальнойОбработки " + ИндексПослеОбработкиВсейТаблицыJSONДляВизуальнойОбработки
                    + " ИндексТекущейОперацииJSONДляВизуальнойОбработки " +ИндексТекущейОперацииJSONДляВизуальнойОбработки);







            // TODO: 18.10.2021  ГЛАВНЫЙ ЦИКЛ РАСПАРИСВАНИЯ JSON// TODO: 18.10.2021  ГЛАВНЫЙ ЦИКЛ РАСПАРИСВАНИЯ JSON// TODO: 18.10.2021  ГЛАВНЫЙ ЦИКЛ РАСПАРИСВАНИЯ JSON


         //   while (iteratorJSON.hasNext()) {
            ГлавныйStreamОбменаПОСтрокам.parallel()
                    .filter(ТекущаяСтрочкаJSONВГлавномЦиклеИдемПоСтрочкам->!ТекущаяСтрочкаJSONВГлавномЦиклеИдемПоСтрочкам.equalsIgnoreCase(""))
                    .forEachOrdered((ТекущаяСтрочкаJSONВГлавномЦиклеИдемПоСтрочкам)->{
                //////TODO ИДЁМ ПО СТРОКАМ --JSON

                //// todo парсинг данных которы е пришли с сервера JSON ОБРАБОТКАТ СТРОК
                        try{

                //TODO ЗАСЫПАЕТ ЦИКЛ ВАЖНО ДЛЯ ОТОБРАЖЕНИЯ КОЛИЧЕСТВРОСТРОК ПРИ РАСПАРСИВАНИИ JSON ПЕРВЫЙ  ---ПОЛУЧЕНИЕ ДАННЫХ


                            Log.d(this.getClass().getName(),
                                    "    ГлавныйStreamОбменаПОСтрокам.parallel().forEachOrdered((ТекущаяСтрочкаJSONВГлавномЦиклеИдемПоСтрочкам)->{"
                                            + " ТекущаяСтрочкаJSONВГлавномЦиклеИдемПоСтрочкам" + ТекущаяСтрочкаJSONВГлавномЦиклеИдемПоСтрочкам);
                ////


                /// ////TODO ЗАДЕРЖКА ИТЕРАЦИЯ ДЛЯ СИНРОНИЗАЦИИ В ФОНЕ


                ///////  ----- TODO НЕПОСРЕДСТВЕННО САМ JSON
                String JSON_ТретьяЧасть = null;

                ////TODO СДВИГАЕМ ИТЕРАТОР ПРИ СИНХРОНИЗАЦИИИ НЕ СНАЧАЛА

                ///TODO без сдвига
                JSON_ТретьяЧасть = (String) ТекущаяСтрочкаJSONВГлавномЦиклеИдемПоСтрочкам ;  // todo old iteratorJSON.next();//// iteratorГлавныйПарсингJSONОтСервера.next();
                /////
                Log.d(this.getClass().getName(), " Текущая строка json которй пришел сервера " + " JSON_ТретьяЧасть " + JSON_ТретьяЧасть);

////todo передаем количество операций для визуализации обновлениея  вставки

                ///

                Log.d(this.getClass().getName(), " JSON_ТретьяЧасть  " + JSON_ТретьяЧасть + " JSON_ТретьяЧасть   " + JSON_ТретьяЧасть.length());
                /////
                JSONObject JSON_ЧетвертаяЧасть = null;

                JSON_ЧетвертаяЧасть = JSON_ПерваяЧасть.getJSONObject(JSON_ТретьяЧасть);

                Log.d(this.getClass().getName(), " JSON_ЧетвертаяЧасть " + JSON_ЧетвертаяЧасть.toString() + " JSON_ЧетвертаяЧасть " + JSON_ЧетвертаяЧасть.length());
                //////
                JSONObject JSON_ПятаяЧасть = null;


                JSON_ПятаяЧасть = new JSONObject(String.valueOf(JSON_ЧетвертаяЧасть));

                Log.d(this.getClass().getName(), " ОбьектыJSONvalue" + JSON_ПятаяЧасть.toString());

                ///TODO  UPDATE КОНТЕЙНЕРЫ


                //todo обнуляем данные укакзатели перед каждой НОВОЙ СТРЧКОЙ
                ///TODO  UPDATE КОНТЕЙНЕРЫ    //todo обнуляем данные укакзатели перед каждой НОВОЙ СТРЧКОЙ

                АдаптерПриОбновленияДанныхсСервера = new ContentValues();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Log.d(this.getClass().getName(), "JSON_ПерваяЧасть.names().length() " + JSON_ПерваяЧасть.names().length() + " \n" +
                            " JSON_ПерваяЧасть.names().length() " + Stream.of(JSON_ПерваяЧасть.names().length()).count());
                }

                ///TODO  INSERT КОНТЕЙНЕРЫ    //todo обнуляем данные укакзатели перед каждой НОВОЙ СТРЧКОЙ
                АдаптерДляВставкиДанныхсСервер = new ContentValues();


///TODO  ОБНУЯЛЕМ ПЕРЕД НОВОЙ СТРОЧКОЙ    //todo обнуляем данные укакзатели перед каждой НОВОЙ СТРЧКОЙ

            Long UUIDПолученныйИзПришедшегоJSON =0l;
                ///TODO  ОБНУЯЛЕМ ПЕРЕД НОВОЙ СТРОЧКОЙ    //todo обнуляем данные укакзатели перед каждой НОВОЙ СТРЧКОЙ
              Integer IDИзПришедшегоJSON = 0;
//

                //todo обнуляем данные укакзатели перед каждой НОВОЙ СТРЧКОЙ

                Boolean ЕслиВСтоликахUUIDПоле = false;
                //todo обнуляем данные укакзатели перед каждой НОВОЙ СТРЧКОЙ
                Boolean ЕслиВСтоликахIDПоле = false;
                ///

                //todo обнуляем данные укакзатели перед каждой НОВОЙ СТРЧКОЙ

                UUIDПолеУжеПроверелиЧерезКурсор = false;
                //todo обнуляем данные укакзатели перед каждой НОВОЙ СТРЧКОЙ
                IDПолеУжеПроверелиЧерезКурсор = false;


                // TODO: 29.12.2021  ДЛЯ ПОСИКА uuid  ПРИ ОБНОВЛЕНИИ

                ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде = null;

                //todo обнуляем данные укакзатели перед каждой НОВОЙ СТРЧКОЙ


                // TODO: 29.12.2021  ДЛЯ ПОСИКА id  ПРИ ОБНОВЛЕНИИ

                ДействительноЛиIDКоторыйПришелсСервераУжеЕстьНаАндройде = null;


                // TODO: 02.01.2022


                IDИзПришедшегоJSONВнутри = null;


                UUIDПолученныйИзПришедшегоJSONВнутри = null;

                            class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаUUIDобваID=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);

                            String ПолеЧерезКотороеСостываваемОбновлениеДанных = null;



                System.out.println("  ДействительноЛиIDКоторыйПришелсСервераУжеЕстьНаАндройде  " + ДействительноЛиIDКоторыйПришелсСервераУжеЕстьНаАндройде + "\n" +

                        " ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде "
                        + ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде + " IDИзПришедшегоJSONВнутри " + IDИзПришедшегоJSONВнутри +
                        "  UUIDПолученныйИзПришедшегоJSONВнутри " + UUIDПолученныйИзПришедшегоJSONВнутри);


// TODO: 16.02.2022
                JSONObject finalJSON_ПятаяЧасть = JSON_ПятаяЧасть;

                // TODO: 16.02.2022 ОБСЕРВЕР ДЛЯ СТОЛБИКОВ ПРИШЕДШЕГО JSON


                // TODO: 16.02.2022

                /////TODO ПАРСИНГ JSON ПРИШЁЛ С СЕРВЕРА SQL SERVER
                String JSON_ИмяСтолбца = new String();

                String JSON_ИмяСтолбцаПосик = new String();

                String JSON_ИмяСодержимое = new String();

                //////TODO ИДЁМ ПО СТОЛБЦАМ --JSON
                for (int ИндексПеремещенияПоСтрокеJSON = 0; ИндексПеремещенияПоСтрокеJSON < JSON_ЧетвертаяЧасть.length(); ИндексПеремещенияПоСтрокеJSON++) {


                try {

                    // TODO: 16.02.2022  and code copy #1
                    // TODO: 16.02.2022  бежим по колонкам
                    //////TODO ИДЁМ ПО СТРОКАМ --JSON
                    //TODO сомо имя json
                    JSON_ИмяСтолбца = (String) finalJSON_ПятаяЧасть.names().get(ИндексПеремещенияПоСтрокеJSON);
                    /////////////
                    JSON_ИмяСтолбца = JSON_ИмяСтолбца.trim();
                    /////////////////////
                    System.out.println("  JSON_ИмяСтолбца  " + JSON_ИмяСтолбца);


                    ////TODO само значение json

                    JSON_ИмяСодержимое = String.valueOf(finalJSON_ПятаяЧасть.get(String.valueOf(JSON_ИмяСтолбца)));
                    ///
                    JSON_ИмяСодержимое = JSON_ИмяСодержимое.trim();
//////////////////////////
                    System.out.println("  JSON_ИмяСодержимое  " + JSON_ИмяСодержимое);


                    // TODO: 14.10.2021 ТОЛЬКО ID КОГДА НЕТ ID

                    // TODO: 16.07.2021
                    Log.d(this.getClass().getName(), "КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал  " + КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал +
                            " имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);


                    // TODO: 15.09.2021
                    if (КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал.equalsIgnoreCase("ПовторныйЗапускСинхронизации")
                            || имяТаблицыОтАндройда_локальноая.equalsIgnoreCase("settings_tabels")) {
                        // TODO: 16.07.2021


                        Log.d(this.getClass().getName(), "КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал  " + КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал +
                                " имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);


                        // TODO: 14.10.2021 ТОЛЬКО ID КОГДА НЕТ UUID

                        /////TODO если  ID

                        Log.d(this.getClass().getName(), " КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал" +
                                " " + КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал +
                                " UUIDПолученныйИзПришедшегоJSONВнутри " + UUIDПолученныйИзПришедшегоJSONВнутри);


                        //////
                        if (UUIDПолученныйИзПришедшегоJSONВнутри == null) {
                            // TODO: 02.01.2022
                            if (finalJSON_ПятаяЧасть.has("uuid") == true) {
                                // TODO: 14.10.2021 ТОЛЬКО ID КОГДА НЕТ UUID
                                //////
                                UUIDПолученныйИзПришедшегоJSONВнутри = finalJSON_ПятаяЧасть.get("uuid");
                                ///
                                UUIDПолученныйИзПришедшегоJSON = Long.parseLong(String.valueOf(UUIDПолученныйИзПришедшегоJSONВнутри));

                                Log.d(this.getClass().getName(), " UUIDПолученныйИзПришедшегоJSON " + UUIDПолученныйИзПришедшегоJSON+
                                        " UUIDПолученныйИзПришедшегоJSONВнутри " + UUIDПолученныйИзПришедшегоJSONВнутри);


                                // TODO: 14.10.2021 ТОЛЬКО ID КОГДА НЕТ ID
                            } else {


                                /////TODO если  ID

                                Log.d(this.getClass().getName(), " UUIDПолученныйИзПришедшегоJSON " + UUIDПолученныйИзПришедшегоJSON + " IDИзПришедшегоJSONВнутри " + IDИзПришедшегоJSONВнутри);

                                if (IDИзПришедшегоJSONВнутри == null) {
                                    // TODO: 02.01.2022
                                    if (finalJSON_ПятаяЧасть.has("id") == true) {
                                        ///
                                        IDИзПришедшегоJSONВнутри = finalJSON_ПятаяЧасть.get("id");
                                        ///
                                        IDИзПришедшегоJSON = Integer.parseInt(String.valueOf(IDИзПришедшегоJSONВнутри));
                                        /////
                                        Log.d(this.getClass().getName(), " IDИзПришедшегоJSON " + IDИзПришедшегоJSON + " IDИзПришедшегоJSONВнутри " + IDИзПришедшегоJSONВнутри);
                                    }
                                }

                            }
                        }


                        Log.d(this.getClass().getName(), " JSON_ИмяСтолбца " + JSON_ИмяСтолбца + " JSON_ИмяСодержимое  " + JSON_ИмяСодержимое + " IDИзПришедшегоJSON "
                                + IDИзПришедшегоJSON + "  JSON_ИмяСодержимое.length() " + JSON_ИмяСодержимое.length());


                        // TODO: 27.05.2021 механиз удаление из таблицы Уведомлений Лишних Значений


                        if (имяТаблицыОтАндройда_локальноая.equalsIgnoreCase("notification") && JSON_ИмяСтолбцаПосик.equalsIgnoreCase("id")) {

                            // TODO: 27.05.2021  заполянем ХЭШ для только дтаблица Уведомления
                            ХэшIDУведомленияДляПриняитиеРешениеУлалениеЛишнихСтрочек.put(JSON_ИмяСтолбцаПосик, IDИзПришедшегоJSON);

                            ///////
                            Log.d(this.getClass().getName(), "   ХэшIDУведомленияДляПриняитиеРешениеУлалениеЛишнихСтрочек " +
                                    ХэшIDУведомленияДляПриняитиеРешениеУлалениеЛишнихСтрочек.values());
                        }


                        // TODO: 14.09.2021
                        Log.d(this.getClass().getName(), " JSON_ИмяСтолбца.toString() " + JSON_ИмяСтолбца);


                        /////todo метод заполенения получым json файлом В АДАПТЕР ВСТАВКИ И/ИЛИ ОБНОВЛЕНИЕ ПРОСТО ЗАПОЛЯНЕМ

                        // TODO: 16.07.2021
                        Log.d(this.getClass().getName(), "КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал  " + КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);
                        //////


                        // TODO: 15.09.2021  ДВА МЕТОДА ЗАПОЛЕНИЯ КОНТЕРЙНЕРА  ЧЕРЕЗ ID, ТОЛЬКО ПРИ НАЛИИ ЗАПОЛНЕНОГО ПОЛЯ ID НЕ NULL


                        Log.d(this.getClass().getName(), " UUIDПолученныйИзПришедшегоJSON " + UUIDПолученныйИзПришедшегоJSON + " ПолеЧерезКотороеСостываваемОбновлениеДанных " +ПолеЧерезКотороеСостываваемОбновлениеДанных);


                        if (UUIDПолученныйИзПришедшегоJSON > 0) {
                            ///
                            ПолеЧерезКотороеСостываваемОбновлениеДанных="uuid";

                            Log.d(this.getClass().getName(), " UUID  UUIDПолученныйИзПришедшегоJSON " + UUIDПолученныйИзПришедшегоJSON);
                            ////
                            МетодАнализаUUIDиID_ОбаТутОборабоатыаем_СинхрониазциявФоне(UUIDПолученныйИзПришедшегоJSON,
                                    JSON_ИмяСтолбца, JSON_ИмяСодержимое, имяТаблицыОтАндройда_локальноая, МенеджерПотоковВнутрений,
                                    ИндексТекущееСтрочкиДляКонтейнераВставки,ПолеЧерезКотороеСостываваемОбновлениеДанных);//////МЕТОД ЗАПОЛЕНЕНИЯ JSON ПОЛЕЙ ПОЛУЧЕННЫЙ С СЕРВЕРА В КОНТЕЙНЕР  ДЛЯ ОПРЕДЕЛЕНИЯ ВСТАВЛЯИ ИЛИ ОБНОВЛЯТЬ




                            // TODO: 17.10.2021

                            Log.d(this.getClass().getName(), " АдаптерПриОбновленияДанныхсСервера  :: " + АдаптерПриОбновленияДанныхсСервера.size() + "\n" +
                                    "  АдаптерДляВставкиДанныхсСервер.length " + АдаптерДляВставкиДанныхсСервер.size() +
                                    "  ИндексТекущееСтрочкиДляКонтейнераВставки " + ИндексТекущееСтрочкиДляКонтейнераВставки + " имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);
                        } else {





                            Log.d(this.getClass().getName(), " IDИзПришедшегоJSON " + IDИзПришедшегоJSON);

                            if (IDИзПришедшегоJSON > 0) {


                                //
                                ПолеЧерезКотороеСостываваемОбновлениеДанных="id";

                                // TODO: 24.02.2022


                                Log.d(this.getClass().getName(), " IDИзПришедшегоJSON " + IDИзПришедшегоJSON);
                                ///
                                Log.d(this.getClass().getName(), "  ID  UUIDПолученныйИзПришедшегоJSON " + UUIDПолученныйИзПришедшегоJSON);
                                ////
                                МетодАнализаUUIDиID_ОбаТутОборабоатыаем_СинхрониазциявФоне(UUIDПолученныйИзПришедшегоJSON,
                                        JSON_ИмяСтолбца, JSON_ИмяСодержимое, имяТаблицыОтАндройда_локальноая, МенеджерПотоковВнутрений,
                                        ИндексТекущееСтрочкиДляКонтейнераВставки,ПолеЧерезКотороеСостываваемОбновлениеДанных);/////

                                Log.d(this.getClass().getName(), " АдаптерПриОбновленияДанныхсСервера  :: " + АдаптерПриОбновленияДанныхсСервера.size() + "\n" +
                                        "  АдаптерДляВставкиДанныхсСервер.length " + АдаптерДляВставкиДанныхсСервер.size() +
                                        "  ИндексТекущееСтрочкиДляКонтейнераВставки " + ИндексТекущееСтрочкиДляКонтейнераВставки + " имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);
                            }
                        }















                        // TODO: 24.02.2022  ПЕРВАЯ СИНХРОНИАЗЦИИЯ ПРИ ЗАПУСКА ПЕРВЫЙ РАЗ УСТРОЙСТВА И НАМ НУЖНА ТОЛЬКО ВСТАВКА ДАННЫХ


                        //todo КОНЕЦ ВЫБОРА ПЕРВЫЙ ИЛИ ВТРОЙ ЗАПУСК СИНХРОНИЗАИИИ  ТОЛЬКО ВСТАВКА
                    } else {    //todo КОНЕЦ ВЫБОРА ПЕРВЫЙ ИЛИ ВТРОЙ ЗАПУСК СИНХРОНИЗАИИИ





// TODO: 24.02.2022  ПЕРВАЯ СИНХРОНИАЗЦИИЯ ПРИ ЗАПУСКА ПЕРВЫЙ РАЗ УСТРОЙСТВА И НАМ НУЖНА ТОЛЬКО ВСТАВКА ДАННЫХ


                        // TODO: 16.07.2021
                        МетодПервогоЗапсукаУстройстваКогдаНамНужнаТОлькоВставкаДАнных(имяТаблицыОтАндройда_локальноая, JSON_ИмяСтолбца, JSON_ИмяСодержимое);

// TODO: 24.02.2022


                        Log.d(this.getClass().getName(), " МЕТОД ПЕРВОГО ЗАПУСКА УСТРОЙСТВА И НА МНУЖАН О ТОЛЬКО ВСТАВКА ДАНННЫХ" +
                                "АдаптерПриОбновленияДанныхсСервера  :: " + АдаптерПриОбновленияДанныхсСервера.size() + "\n" +
                                "  АдаптерДляВставкиДанныхсСервер.length " + АдаптерДляВставкиДанныхсСервер.size() +
                                "  ИндексТекущееСтрочкиДляКонтейнераВставки " + ИндексТекущееСтрочкиДляКонтейнераВставки + " имяТаблицыОтАндройда_локальноая " +
                                имяТаблицыОтАндройда_локальноая);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    // TODO: 01.09.2021 метод вызова
                    new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    ////// начало запись в файл
                }

                Log.d(this.getClass().getName(), " Observable.just(ИндексПеремещенияПоСтрокеJSON).blockingIterable()  ИндексПеремещенияПоСтрокеJSON  " + ИндексПеремещенияПоСтрокеJSON);
                // TODO: 16.02.2022 end code copy @#2






/*
                //////TODO ИДЁМ ПО СТОЛБЦАМ --JSON
                for (int ИндексПеремещенияПоСтрокеJSON = 0; ИндексПеремещенияПоСтрокеJSON < JSON_ЧетвертаяЧасть.length(); ИндексПеремещенияПоСтрокеJSON++) {



                }///todo end for СТОЛБЦЫ
*/
                    // TODO: 24.02.2022  КОНЕЦ ОБОАТОТКИ ОДНОЙ СТРОКИ !!!!!!! М

            }// TODO: 24.02.2022  КОНЕЦ ОБОАТОТКИ ОДНОЙ СТРОКИ !!!!!!! // TODO: 24.02.2022  КОНЕЦ ОБОАТОТКИ ОДНОЙ СТРОКИ !!!!!!! // TODO: 24.02.2022  КОНЕЦ ОБОАТОТКИ ОДНОЙ СТРОКИ !!!!!!!
                
                
                
                
                
                
                
                
                
// TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ ВСТАВКА  // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ ВСТАВКА   // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ ВСТАВКА





                // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ    ОБНОВЛНИЕ     // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ    ОБНОВЛНИЕ
                Log.d(this.getClass().getName(), " КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал :::  "
                        + КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал +"\n"+
                        "  АдаптерДляВставкиДанныхсСервер.size() " +АдаптерДляВставкиДанныхсСервер.size());


                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {


                                // TODO: 17.10.2021  ONLY INSERT ROW    МАССОВАЯ ВСТАВКА ДЛЯ МЕТОДА BULRINSERT         // TODO: 17.10.2021  ONLY INSERT ROW

                                МетодЗаполенияКонтефнераДляМассовойВставкиBulkInsert(ActivityДляСинхронизацииОбмена, ИндексДляМассовогоКонтейнер);

                                //////// TODO МЕТОД ПЕРОСРЕДСТВЕНОЙ ЗАПИСЬ В  БАЗУ АНДРОЙДА ДАННЫМИС SQL SERVER метод конкретной записо заполеного контерйнра json в  базуу

                                Log.d(this.getClass().getName(), " массова вставка burkinsert АдаптерДляВставкиДанныхсСервер.size() :::  " + АдаптерДляВставкиДанныхсСервер.size());




                            }else{

                                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                                    // TODO: 17.10.2021  ONLY INSERT ROW     ОБЫЧНАЯ ВСТАВКА           // TODO: 17.10.2021  ONLY INSERT ROW
                                    МетодЗаполенияКонтейнерапДЛяВставкиОбычный(имяТаблицыОтАндройда_локальноая,
                                            МенеджерПотоковВнутрений,
                                            ActivityДляСинхронизацииОбмена,
                                            СколькоСтрочекJSON,
                                            Результат_ВставкаДаннымисСервера);


                                    Log.d(this.getClass().getName(), " обычная ВСТВКА  АдаптерПриОбновленияДанныхсСервера.size()  :::  " + АдаптерПриОбновленияДанныхсСервера.size()  +
                                            "  КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал " +КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);




                                }

                            }



                            // TODO: 17.10.2021  ONLY UPDATE ROW     // TODO: 17.10.2021  ONLY UPDATE ROW
                // TODO: 17.10.2021  ONLY UPDATE ROW     // TODO: 17.10.2021  ONLY UPDATE ROW
                // TODO: 17.10.2021  ONLY UPDATE ROW     // TODO: 17.10.2021  ONLY UPDATE ROW
                // TODO: 17.10.2021  ONLY UPDATE ROW     // TODO: 17.10.2021  ONLY UPDATE ROW

                            МетодЗаполенияКонтейнераТолькоДляОбновленияДанных(имяТаблицыОтАндройда_локальноая, МенеджерПотоковВнутрений,
                                    ActivityДляСинхронизацииОбмена, СколькоСтрочекJSON,
                                    Результат_ОбновлениеДаннымисСервера,
                                    UUIDПолученныйИзПришедшегоJSON,
                                    IDИзПришедшегоJSON);


/////TODO СЛИЯНИЕ ОПЕРАЦИЙ ВСТАВКИ И ОБНОВЛЕНИЯ ОПЕРАЦИЙ В ОДНУ

                Log.d(this.getClass().getName(), " Результат_ОбновлениеДаннымисСервера :::  "
                        + Результат_ОбновлениеДаннымисСервера[0] + "  Результат_ВставкаДаннымисСервера "
                        + Результат_ВставкаДаннымисСервера[0]);




                /// iteratorJSON.remove();

                } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ////// начало запись в файл
            }
                // TODO: 25.08.2021 выкидываем из памяти


            });// TODO: 17.10.2021  END end  LOOP WHILE JSON TABELS


            // TODO: 30.10.2021  ПОСЛЕ ЦИКЛА DO  WHILE

            МетодМасоввойВставкиДаныхBulkINSERTРабоатетПослеОбработкиВскеСтрочкекПослеЦиклаWHILE(имяТаблицыОтАндройда_локальноая,
                    ActivityДляСинхронизацииОбмена,
                    JSON_ПерваяЧасть,
                    " Результат_ОбновлениеДаннымисСервера :::  "
                    + Результат_ОбновлениеДаннымисСервера[0]
                            + "  Результат_ВставкаДаннымисСервера "
                    + Результат_ВставкаДаннымисСервера[0]
                            + " ИндексТекущейОперацииJSONДляВизуальнойОбработки  "
                            + ИндексТекущейОперацииJSONДляВизуальнойОбработки, Результат_ВставкаДаннымисСервера);


            //
            Log.d(this.getClass().getName(), " Конец  ПАРСИНГА ОБРАБОАТЫВАЕМОМЙ ТАБЛИЦЫ  ::::: "
                    + имяТаблицыОтАндройда_локальноая+" ИндексТекущейОперацииJSONДляВизуальнойОбработки " +ИндексТекущейОперацииJSONДляВизуальнойОбработки);
            /////
            // TODO: 14.10.2021 обьядиняем две операции вставки и обновлении слияние для ответа произвошли изменения вообщем по таблице






            //todo end for

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }


        //////////
        Log.d(this.getClass().getName(), "  ИндексТекущейОперацииРеальногРезультатОбработкиАтблицы " + ИндексТекущейОперацииРеальногРезультатОбработкиАтблицы);
        /////////////
        return ИндексТекущейОперацииРеальногРезультатОбработкиАтблицы;
    }





    private void МетодПервогоЗапсукаУстройстваКогдаНамНужнаТОлькоВставкаДАнных(String имяТаблицыОтАндройда_локальноая, String JSON_ИмяСтолбца, String JSON_ИмяСодержимое) {
        Log.d(this.getClass().getName(), "КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал  "
                + КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал + "  имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);

        try{

        String ИндификаторДляIDВзависмостиОтТаблицы = "id";
        ///
//////наобород
        switch (имяТаблицыОтАндройда_локальноая.trim().toLowerCase()) {

            case "tabels":
            case "chats":
            case "data_chat":
            case "chat_users":
            case "fio":
            case "tabel":
            case "data_tabels":
                //


                Log.d(this.getClass().getName(), " _id   КлючJsonСтроки  " + JSON_ИмяСтолбца);

                ИндификаторДляIDВзависмостиОтТаблицы = "_id";

                if (JSON_ИмяСтолбца.equals("id")) {
                    //TODO сам столбиц
                    JSON_ИмяСтолбца = ИндификаторДляIDВзависмостиОтТаблицы;
                }

                break;

            // TODO: 02.01.2022

            default:

                Log.d(this.getClass().getName(), " _id   КлючJsonСтроки  " + JSON_ИмяСтолбца);

                ИндификаторДляIDВзависмостиОтТаблицы = "id";

                break;
        }

        ///
        ///TODO ВСТАВКА ЧЕРЕЗ UUID     ДЛЯ КУРСОРА BULK INSERT   ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID

        if (! JSON_ИмяСодержимое.contentEquals("null")  ) {
            ///TODO ВСТАВКА ЧЕРЕЗ UUID     ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID

            АдаптерДляВставкиДанныхсСервер.put(JSON_ИмяСтолбца, JSON_ИмяСодержимое);
        }

        Log.d(this.getClass().getName(), " АдаптерДляВставкиДанныхсСервер UUID " + АдаптерДляВставкиДанныхсСервер + " имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);



        //todo end for

    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
        new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ////// начало запись в файл
    }

}







    private void МетодМасоввойВставкиДаныхBulkINSERTРабоатетПослеОбработкиВскеСтрочкекПослеЦиклаWHILE
            (String имяТаблицыОтАндройда_локальноая,
             Activity ActivityДляСинхронизацииОбмена,
             JSONObject JSON_ПерваяЧасть, String msg,
             Long[] результат_ВставкаДаннымисСервера) {
        Log.d(this.getClass().getName(), msg);


        try{


        if (АдаптерДляМассовойВставкиДанныхсСервер!=null) {
//todO ВНИМАНИЕ ТОЛЬКО РАБОАТЕТ BULKiNSERT ТОЛЬКО НА api ВЫШЕ ю 29  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            Log.w(contextСозданиеБАзы.getClass().getName(), " АдаптерДляМассовойВставкиДанныхсСервер.length  " + АдаптерДляМассовойВставкиДанныхсСервер.length
                    + " Arrays.stream(АдаптерДляМассовойВставкиДанныхсСервер).count() "+
                    Arrays.stream(АдаптерДляМассовойВставкиДанныхсСервер).count());/////
        }

        if (АдаптерДляВставкиДанныхсСервер!=null) {
            //todO ВНИМАНИЕ ТОЛЬКО РАБОАТЕТ BULKiNSERT ТОЛЬКО НА api ВЫШЕ ю 29  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            Log.w(contextСозданиеБАзы.getClass().getName(), " АдаптерДляМассовойВставкиДанныхсСервер.length  "+
                    "\n" + " АдаптерДляВставкиДанныхсСервер.size()  " +АдаптерДляВставкиДанныхсСервер.size());/////
        }


        // TODO: 17.10.2021  ONLY INSERT ROW              // TODO: 17.10.2021  ONLY INSERT ROW
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R )  {

            if (Arrays.stream(АдаптерДляМассовойВставкиДанныхсСервер).count() > 0 && АдаптерДляВставкиДанныхсСервер.size()>0 ) {

                //TODO  ПОСЛЕ ОБРАБОТКИ ВСЕЙ ТАБЛИЦЫ ТЕСТОВО ЗАПУСКАЕМ ЕТОД МАССОВОЙ ВСТАВКИ ЧЕРЕЗ КОНТЕНТ ПРОВАЙДЕР МЕТОД BurkInset
                Log.w(contextСозданиеБАзы.getClass().getName(), " АдаптерДляМассовойВставкиДанныхсСервер.length  " + АдаптерДляМассовойВставкиДанныхсСервер.length+
                        "\n" + " АдаптерДляВставкиДанныхсСервер.size()  " +АдаптерДляВставкиДанныхсСервер.size());/////
                // TODO: 17.10.2021  ONLY INSERT ROW

                // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ ВСТАВКА  // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ ВСТАВКА   // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ ВСТАВКА
                результат_ВставкаДаннымисСервера[0] = 0l;
                //////////////

 /*       Результат_ВставкаДаннымисСервера = МетодаЗаписиВБазуКонтейнераВСТАВКАJSONвФоне(имяТаблицыОтАндройда_локальноая,
                МенеджерПотоковВнутрений,
                Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы, СколькоСтрочекJSON,
                ИндексТекущейОперацииJSONДляВизуальнойОбработки, ФиналПроценты);*/
                ///

                //TODO ВАЖНО ЗАПИСЫВАЕМ ВСЕ ЗАПИСИ ПОНОВОМУ ОДНИМ МЕТОДОМ BULKiNSETY  ТОЛЬКО РАБОТАЕТ ОТ >  29 Api

                //  Uri uri=Uri.parse("content://com.dsy.dsu.providerdatabase/tabel");
                Uri uri = Uri.parse("content://com.dsy.dsu.providerdatabase/" + имяТаблицыОтАндройда_локальноая + "");////organization ///data_tabels

                Log.w(contextСозданиеБАзы.getClass().getName(), " uri  " + uri);/////


                ContentResolver contentResolver;
                // TODO: 17.11.2021
                if (ActivityДляСинхронизацииОбмена!=null) {
                    // TODO: 17.11.2021
                    contentResolver = ActivityДляСинхронизацииОбмена.getContentResolver();
                } else {
                    // TODO: 17.11.2021
                    contentResolver = contextСозданиеБАзы.getContentResolver();
                }


                int РезультатВставкиМассовой = contentResolver.bulkInsert(uri, АдаптерДляМассовойВставкиДанныхсСервер);
                // TODO: 27.10.2021

                if (РезультатВставкиМассовой>0) {
                    // TODO: 14.12.2021
                    ИндексТекущейОперацииРеальногРезультатОбработкиАтблицы++;


                    //
                    АдаптерДляВставкиДанныхсСервер.clear();

                    // TODO: 15.12.2021
                    АдаптерДляМассовойВставкиДанныхсСервер=null;
                }




                Log.w(contextСозданиеБАзы.getClass().getName(), " РезультатВставкиМассовой contentResolver.bulkInsert   " + РезультатВставкиМассовой+"\n"+
                        "  имяТаблицыОтАндройда_локальноая " +имяТаблицыОтАндройда_локальноая);/////

                результат_ВставкаДаннымисСервера[0] = Long.valueOf(РезультатВставкиМассовой);

                // TODO: 30.10.2021







                Integer ВерхнениеЗначениеПришедшегоJSONСтрочек = JSON_ПерваяЧасть.names().length();

                Log.d(this.getClass().getName(), " Результат_ВставкаДаннымисСервера :::  " + результат_ВставкаДаннымисСервера[0] + " ВерхнениеЗначениеПришедшегоJSONСтрочек "
                        + ВерхнениеЗначениеПришедшегоJSONСтрочек);










                Log.d(this.getClass().getName(), " КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал :::  " + КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);


                //// TODO не повтрорный запуск синхрониазци
                if (!КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал.equalsIgnoreCase("ПовторныйЗапускСинхронизации")) {

                    // TODO: 12.01.2022
                    if (ActivityДляСинхронизацииОбмена != null) {
                        ///
                        Long finalРезультат_ВставкаДаннымисСервера = результат_ВставкаДаннымисСервера[0];


                        ActivityДляСинхронизацииОбмена.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ///TODO ОБВНОВЛЕНИЕ false это првидбно начит это не первый запуск и нужно и обновление

                                // TODO: 30.10.2021
                                Log.d(this.getClass().getName(), " progressBar3ГоризонтальныйСинхронизации:::  " + progressBar3ГоризонтальныйСинхронизации+
                                        " finalРезультат_ВставкаДаннымисСервера " +finalРезультат_ВставкаДаннымисСервера+
                                        " ВерхнениеЗначениеПришедшегоJSONСтрочек " +ВерхнениеЗначениеПришедшегоJSONСтрочек);


// TODO: 15.12.2021 ловим ошибку когда не равно количество строчек пришедщих и количесвто строчек вставленных

                                if (finalРезультат_ВставкаДаннымисСервера < ВерхнениеЗначениеПришедшегоJSONСтрочек) {
                                    // TODO: 30.10.2021
                                    Long РазницаНЕдовставленныхДанных = ВерхнениеЗначениеПришедшегоJSONСтрочек - finalРезультат_ВставкаДаннымисСервера;
                                    // TODO: 30.10.2021
                                    Toast.makeText(contextСозданиеБАзы, "  Вставка (ошибка) данных произошла не полностью   (кол строк:) " + РазницаНЕдовставленныхДанных+"\n"+
                                                    "  Текущая Таблица Обработки " +имяТаблицыОтАндройда_локальноая
                                            , Toast.LENGTH_LONG).show();
                                    // TODO: 30.10.2021
                                    Log.e(this.getClass().getName(), " ОШИБКА ПРИ МАССОВОЙ ЗАПИСИ НЕ СООТВЕТЫВИКИЕ ПРИШЕДЩИХ СТОЧКЕ И ВСТАВЛНОГО КОЛИЧЕСТВА   " + progressBar3ГоризонтальныйСинхронизации+
                                            " finalРезультат_ВставкаДаннымисСервера " +finalРезультат_ВставкаДаннымисСервера+
                                            " ВерхнениеЗначениеПришедшегоJSONСтрочек " +ВерхнениеЗначениеПришедшегоJSONСтрочек+
                                            "  имяТаблицыОтАндройда_локальноая  " +имяТаблицыОтАндройда_локальноая );




                                }

                            }
                        });


                    }
                }

            } else {


                Log.w(this.getClass().getName(), "Контейнер для Массвой вставки пуст ");
            }
        }


        //todo end for

    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
        new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ////// начало запись в файл
    }









}

    private void МетодЗаполенияКонтейнераТолькоДляОбновленияДанных
            (String имяТаблицыОтАндройда_локальноая,
             CompletionService МенеджерПотоковВнутрений,
             Activity ActivityДляСинхронизацииОбмена,
             Integer СколькоСтрочекJSON,
             Integer[] Результат_ОбновлениеДаннымисСервера,
             Long UUIDПолученныйИзПришедшегоJSON,
             Integer IDИзПришедшегоJSON) {
        ////

        try {

        if (АдаптерПриОбновленияДанныхсСервера.size() > 0 ) {


            // TODO: 17.10.2021  ONLY UPDATE ROW
            // TODO: 15.10.2021  UPDATE
            Результат_ОбновлениеДаннымисСервера[0] = 0;
            /////////
            Результат_ОбновлениеДаннымисСервера[0] = МетодаЗаписиВБазуКонтейнераОБНОВЛЕНИЕJSONвФоне(имяТаблицыОтАндройда_локальноая,
                    UUIDПолученныйИзПришедшегоJSON, IDИзПришедшегоJSON, МенеджерПотоковВнутрений,
                    Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы, СколькоСтрочекJSON,
                    ИндексТекущейОперацииJSONДляВизуальнойОбработки, ФиналПроценты);

            /////

            Log.d(this.getClass().getName(), " Результат_ОбновлениеДаннымисСервера  :: " + Результат_ОбновлениеДаннымисСервера[0]);


            //

            if (Результат_ОбновлениеДаннымисСервера[0] >0) {
                // TODO: 14.12.2021
                ИндексТекущейОперацииРеальногРезультатОбработкиАтблицы++;
            }
            // TODO: 17.10.2021

            if (Результат_ОбновлениеДаннымисСервера[0] > 0) {
                ////
                АдаптерПриОбновленияДанныхсСервера.clear();

                /////////
                ИндексТекущейОперацииJSONДляВизуальнойОбработки++;
            }


            // TODO: 17.10.2021  ПОСЛЕ ОТРАОБОТКИ ПОКАЗЫВАЕМ ПРОЦЕНТЫ

            //
            ////
            ////
            if (ActivityДляСинхронизацииОбмена != null) {
                ///
                ActivityДляСинхронизацииОбмена.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ///TODO ОБВНОВЛЕНИЕ false это првидбно начит это не первый запуск и нужно и обновление

                        progressBar3ГоризонтальныйСинхронизации = ActivityДляСинхронизацииОбмена.findViewById(R.id.progressBar3ГоризонтальныйСинхронизации);
                        /////
                        if (progressBar3ГоризонтальныйСинхронизации != null) {
                            ///
                            if (ИндексТекущейОперацииJSONДляВизуальнойОбработки > 0) {
                                /////
                                progressBar3ГоризонтальныйСинхронизации.setProgress(ИндексТекущейОперацииJSONДляВизуальнойОбработки);

                                ///

                                progressBar3ГоризонтальныйСинхронизации.setSecondaryProgress(ИндексТекущейОперацииJSONДляВизуальнойОбработки+2);

                                // TODO: 31.10.2021

                                if (progressBar3ГоризонтальныйСинхронизации.getMax()==ИндексТекущейОперацииJSONДляВизуальнойОбработки) {

                                    progressBar3ГоризонтальныйСинхронизации.getProgressDrawable().setColorFilter(  Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                                }
                            }
                        }
                    }
                });

                Log.d(this.getClass().getName(), " progressBar3ГоризонтальныйСинхронизации:::  " + progressBar3ГоризонтальныйСинхронизации);
            }
            ///todo текущая таблица
            ///todo текущая таблица

            Log.d(this.getClass().getName(), " progressBar3ГоризонтальныйСинхронизации:::  " + progressBar3ГоризонтальныйСинхронизации);
        }



        //todo end for

    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
        new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ////// начало запись в файл
    }

}

    private void МетодЗаполенияКонтейнерапДЛяВставкиОбычный(String имяТаблицыОтАндройда_локальноая,
                                                            CompletionService МенеджерПотоковВнутрений,
                                                            Activity ActivityДляСинхронизацииОбмена,
                                                            Integer СколькоСтрочекJSON, Long[]
                                                                    Результат_ВставкаДаннымисСервера) {

        try {


            if (АдаптерДляВставкиДанныхсСервер.size() > 0) {


                // TODO: 17.10.2021  ONLY INSERT ROW

                // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ ВСТАВКА  // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ ВСТАВКА   // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ ВСТАВКА
                Результат_ВставкаДаннымисСервера[0] = 0l;
                //////////////

                Результат_ВставкаДаннымисСервера[0] = МетодаЗаписиВБазуКонтейнераВСТАВКАJSONвФоне(имяТаблицыОтАндройда_локальноая,
                        МенеджерПотоковВнутрений,
                        Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы, СколькоСтрочекJSON,
                        ИндексТекущейОперацииJSONДляВизуальнойОбработки, ФиналПроценты);
                ///


                Результат_ВставкаДаннымисСервера[0]++;


                if (Результат_ВставкаДаннымисСервера[0] >0) {
                    // TODO: 14.12.2021
                    ИндексТекущейОперацииРеальногРезультатОбработкиАтблицы++;
                }


                Log.d(this.getClass().getName(), " Результат_ВставкаДаннымисСервера :::  " + Результат_ВставкаДаннымисСервера[0]);
            }

            // TODO: 17.10.2021  clear
            if (Результат_ВставкаДаннымисСервера[0] > 0) {
                //
                АдаптерДляВставкиДанныхсСервер.clear();


                /////////
                ИндексТекущейОперацииJSONДляВизуальнойОбработки++;
            }

            // TODO: 17.10.2021  ПОСЛЕ ОТРАОБОТКИ ПОКАЗЫВАЕМ ПРОЦЕНТЫ

            //
            ////
            if (ActivityДляСинхронизацииОбмена != null) {
                ///
                ActivityДляСинхронизацииОбмена.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ///TODO ОБВНОВЛЕНИЕ false это првидбно начит это не первый запуск и нужно и обновление

                        //   ProgressBar progressBar3ГоризонтальныйСинхронизации = ActivityДляСинхронизацииОбмена.findViewById(R.id.progressBar3ГоризонтальныйСинхронизации);
                        /////
                        if (progressBar3ГоризонтальныйСинхронизации != null) {
                            ///
                            if (ИндексТекущейОперацииJSONДляВизуальнойОбработки > 0) {
                                /////
                                progressBar3ГоризонтальныйСинхронизации.setProgress(ИндексТекущейОперацииJSONДляВизуальнойОбработки);

                                ///

                                progressBar3ГоризонтальныйСинхронизации.setSecondaryProgress(ИндексТекущейОперацииJSONДляВизуальнойОбработки+2);
                                // TODO: 31.10.2021

                                if (progressBar3ГоризонтальныйСинхронизации.getMax()==ИндексТекущейОперацииJSONДляВизуальнойОбработки) {

                                    progressBar3ГоризонтальныйСинхронизации.getProgressDrawable().setColorFilter(  Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                                }
                            }
                        }
                    }
                });
            }
            ///todo текущая таблица





        //todo end for

    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
        new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ////// начало запись в файл
    }
    }

    private void МетодЗаполенияКонтефнераДляМассовойВставкиBulkInsert(Activity ActivityДляСинхронизацииОбмена, Integer[] ИндексДляМассовогоКонтейнер) {

        try{
        // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ   ДЛя МАССОВГО КОНТЕЙНЕРА А   ОБНОВЛНИЕ     // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ    ОБНОВЛНИЕ


            if (АдаптерДляВставкиДанныхсСервер.size() > 0) {

                // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ   ДЛя МАССОВГО КОНТЕЙНЕРА А   ОБНОВЛНИЕ     // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ    ОБНОВЛНИЕ


                АдаптерДляМассовойВставкиДанныхсСервер[ИндексДляМассовогоКонтейнер[0]].putAll(АдаптерДляВставкиДанныхсСервер);




                // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ    ОБНОВЛНИЕ     // TODO: 09.09.2021 ДВЕ ОПЕРАЦИИ    ОБНОВЛНИЕ
                Log.d(this.getClass().getName(), " АдаптерДляМассовойВставкиДанныхсСервер.length :::  "
                        + АдаптерДляМассовойВставкиДанныхсСервер.length);
                // TODO: 29.10.2021

                ///TODO повышаем индекс для массовой вставки

                ИндексДляМассовогоКонтейнер[0]++;

                // TODO: 17.10.2021  clear
                if (ИндексДляМассовогоКонтейнер[0] > 0) {
                    //
                    /// АдаптерДляВставкиДанныхсСервер.clear();


                    /////////
                    ИндексТекущейОперацииJSONДляВизуальнойОбработки++;
                }

                ////
                if (ActivityДляСинхронизацииОбмена != null) {
                    ///
                    ActivityДляСинхронизацииОбмена.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ///TODO ОБВНОВЛЕНИЕ false это првидбно начит это не первый запуск и нужно и обновление

                            //   ProgressBar progressBar3ГоризонтальныйСинхронизации = ActivityДляСинхронизацииОбмена.findViewById(R.id.progressBar3ГоризонтальныйСинхронизации);
                            /////
                            if (progressBar3ГоризонтальныйСинхронизации != null) {
                                ///
                                if (ИндексТекущейОперацииJSONДляВизуальнойОбработки > 0) {
                                    /////
                                    progressBar3ГоризонтальныйСинхронизации.setProgress(ИндексТекущейОперацииJSONДляВизуальнойОбработки);

                                    ///
                                    progressBar3ГоризонтальныйСинхронизации.setSecondaryProgress(ИндексТекущейОперацииJSONДляВизуальнойОбработки+2);
                                    // TODO: 31.10.2021

                                    if (progressBar3ГоризонтальныйСинхронизации.getMax()==ИндексТекущейОперацииJSONДляВизуальнойОбработки) {

                                        progressBar3ГоризонтальныйСинхронизации.getProgressDrawable().setColorFilter(  Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                                    }
                                }
                            }
                        }
                    });
                }
                ///todo текущая таблица

            }


        //todo end for

    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
        new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ////// начало запись в файл
    }
    }


// TODO: 15.09.2021  ЗАПОЛНЕНИЯ КОНТЕЙНЕРА ТОЛЬКО UUID

    //////МЕТОД ТОЛЬКО ЗАПОЛЕНИЕЯ КОНТЕЙНЕРА ВСТАВКИ И ОБНОВЛЕНИЕ ДАННЫХ КОТОРЫЕ ПРИШЛИ С СЕРВЕРА
    Integer МетодЗаполнениеПолученымJSONсСервераВКонтейнерТолькоПОUUIDвФоне( Long UUIDПолученныйИзПришедшегоJSON,
                                                                             String JSON_ИмяСтолбца,
                                                                             String JSON_ИмяСодержимое
            , String имяТаблицыОтАндройда_локальноая,
                                                                             CompletionService МенеджерПотоковВнутрений,
                                                                             Integer ИндексТекущееСтрочкиДляКонтейнераВставки
    ,String ПолеЧерезКотороеСостываваемОбновлениеДанных) { /////МЕТОД ЗАПОЛЕНЕИЯ КОНТЕЙНЕРОМ JSON ПОЛЯМИы
        //
        Integer  РезультатЗаполенияКонтейнераДляВставкиИДляОбновления=0;
        //////TODO анализиует СТОЛЮИК UUID

        try {


            ///TODO ДАННЫЙ КОД ОБРЕЗАЮТ ДАТУ А ТРИ НАЗАД ЕСЛИ ДЛИНА ДАТЫ РОВНЯЕТЬСЯ 22 СИМВОЛА
/*            if (JSON_ИмяСтолбца.equalsIgnoreCase("date_update")) {
                //Todo цикл обработаки лишних символом даты date_update
                while (true) {
                    if (JSON_ИмяСодержимое.length() > 19) {
                        ////TODO УДАЛЯЕМ СИЩГИЕ СИМВОЛЫ В  ДАТЕ
                        JSON_ИмяСодержимое = JSON_ИмяСодержимое.substring(0, JSON_ИмяСодержимое.length() - 1);

                    } else {
                        // code block to be executed
                        Log.d(this.getClass().getName(), " JSON_ИмяСодержимое " + JSON_ИмяСодержимое + " JSON_ИмяСодержимое.length()  " + JSON_ИмяСодержимое.length());
                        break;
                    }

                }
            }*/

            ////ДЛЯ НАЧАЛО ОЦЕНИВАЕМ ЕСЛИ UUID В ЭТОЙ ТЕКУЩЕЙ ЗАПИСИ ,, ЗАПОМИНАЕМ ЕГО И ДАЛЕЕ ОТ РЕЗУЛЬТАТО В НАЧИНАЕМ ЛИБО ВСТАКУ ЛИБО ОБНОВЛЕНИЕ АДАЕЫХ
            ////////ПРОВЕРЯЕМ UUID ЕСЛИ Т ЕКУЩЕЕ ПОЛЕ UUID
            Log.d(this.getClass().getName(), " JSON_ИмяСтолбца " + JSON_ИмяСтолбца + " ПолеЧерезКотороеСостываваемОбновлениеДанных " +ПолеЧерезКотороеСостываваемОбновлениеДанных);





            //////TODO А ТУТ ОБНОВЛЕНИЕ ДАННЫХ      //////TODO А ТУТ ОБНОВЛЕНИЕ ДАННЫХ        //////TODO А ТУТ ОБНОВЛЕНИЕ ДАННЫХ

            //////TODO вторым флагом запрещем при первом запуске заниматься обновдениям  только вставка  при синхронизации ==false значить обнолвение включено ,,,,, ЗНАЧАЕТ ЧТО ИДЕТ ТОЛЬКО ВСТАВКА ДАННЫХ TRUE
            // final boolean ДанныйФлагРазрешаетОбновлеениеТОлькоПослеПерсвойСинхронизации = PUBLIC_CONTENT.ФлагПриПервомЗапускеОграничитьОперациюТолькоВставка;


//final boolean СтатусРеазрешеноЛиОбновлениеПриПервойЧинхронизации=PUBLIC_CONTENT.ФлагРазрешаетОбновлениеПриСинхронизации;
            //////TODO анализиует СТОЛЮИК ID             //////TODO анализиует СТОЛЮИК ID             //////TODO анализиует СТОЛЮИК ID             //////TODO анализиует СТОЛЮИК ID


            //////
            // TODO: 16.03.2021 выбираем как обнолять через uuid and id

                //////

                /////TODO запрет на обновление если Первая Синхронизация

                Log.d(this.getClass().getName(), " UUIDПолученныйИзПришедшегоJSON " + UUIDПолученныйИзПришедшегоJSON + "JSON_ИмяСтолбца " + JSON_ИмяСтолбца);

                //TODO UUID
                РезультатЗаполенияКонтейнераДляВставкиИДляОбновления=
                        МетодАнализаUUIDиID_ОбаТутОборабоатыаем_СинхрониазциявФоне(UUIDПолученныйИзПришедшегоJSON,
                                JSON_ИмяСтолбца, JSON_ИмяСодержимое, имяТаблицыОтАндройда_локальноая,МенеджерПотоковВнутрений,
                                ИндексТекущееСтрочкиДляКонтейнераВставки,ПолеЧерезКотороеСостываваемОбновлениеДанных);
                //////////todo
                Log.d(this.getClass().getName(), " РезультатЗаполенияКонтейнераДляВставкиИДляОбновления " +РезультатЗаполенияКонтейнераДляВставкиИДляОбновления);

                //////TODO анализиует СТОЛЮИК UUID



                Log.d(this.getClass().getName(), " РезультатЗаполенияКонтейнераДляВставкиИДляОбновления " +РезультатЗаполенияКонтейнераДляВставкиИДляОбновления);

                // TODO: 16.03.2021 когда нет UUID


            // Log.d(this.getClass().getName(), " СтатусРеазрешеноЛиОбновлениеПриПервойЧинхронизации " + СтатусРеазрешеноЛиОбновлениеПриПервойЧинхронизации);


            //////TODO А ТУТ ВСТАВКА ДАННЫХ       //////TODO А ТУТ ВСТАВКА ДАННЫХ       //////TODO А ТУТ ВСТАВКА ДАННЫХ       //////TODO А ТУТ ВСТАВКА ДАННЫХ       //////TODO А ТУТ ВСТАВКА ДАННЫХ       //////TODO А ТУТ ВСТАВКА ДАННЫХ


            ////TODO САМО ДЕЛЕНИЕ ДАННЫХ С СЕРВЕРА НА ВСТАВКУ ДАННЫХ ИЛИ ЕЕ ОБНОВЛЕНИЯ ЗАВИСМОСТИ ЕСЛИ  UUID ИЛИ ID


            ////
            /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }
        return  РезультатЗаполенияКонтейнераДляВставкиИДляОбновления;
    }


































    //////////////TODO метод непосредвственой запись в базу данных json КОТОРЫЙ ПРИШЁЛ С СЕРВЕРА---!!!!! ПЕРВАЯ ОПЕРПЦИЯ ВСТАВКА
    Long МетодаЗаписиВБазуКонтейнераВСТАВКАJSONвФоне(String имяТаблицыОтАндройда_локальноая,
                                                     @NotNull CompletionService МенеджерПотоков,
                                                     SQLiteDatabase getБазаДанныхДЛяОперацийВнутри
            ,Integer СколькоСтрочекJSON,
                                                     Integer ИндексТекущейОперацииJSONДляВизуальнойОбработки,
                                                     Float ФиналПроценты ) {////запись полученого json   от сервера через контейнер

        Log.d(this.getClass().getName(), " ИндексТекущейОперацииJSONДляВизуальнойОбработки  " +  ИндексТекущейОперацииJSONДляВизуальнойОбработки + " МенеджерПотоков "+ МенеджерПотоков
                + "  ФиналПроценты " +ФиналПроценты+ " имяТаблицыОтАндройда_локальноая " +имяТаблицыОтАндройда_локальноая+  "СколькоСтрочекJSON " +СколькоСтрочекJSON);

        Long РезультатВставкиЧерезКонтрейнер = 0l;

        try {


            //////////todo ВСТАВКА JSON НА КЛИЕНТА ДАННЫЕ С СЕРВЕРА

            Log.i(this.getClass().getName(), "  АдаптерДляВставкиДанныхсСервер      " + АдаптерДляВставкиДанныхсСервер.size());


            ////////ВЫЗЫВАЕМ ВСТАВКУ ДАННЫХ

            // TODO: 10.09.2021 сама операция всатвки

            РезультатВставкиЧерезКонтрейнер = ВставкаДанныхЧерезКонтейнерУниверсальнаяЧерезContentResolver(имяТаблицыОтАндройда_локальноая,
                    АдаптерДляВставкиДанныхсСервер, имяТаблицыОтАндройда_локальноая,
                    "", true,
                    СколькоСтрочекJSON, true, contextСозданиеБАзы,ActivityДляСинхронизацииОбмена,МенеджерПотоков,getБазаДанныхДЛяОперацийВнутри,СколькоСтрочекJSON,
                    ИндексТекущейОперацииJSONДляВизуальнойОбработки,ФиналПроценты);


            /*    ///
            РезультатВставкиЧерезКонтрейнер = ВставкаДанныхЧерезКонтейнерУниверсальная(имяТаблицыОтАндройда_локальноая, АдаптерДляВставкиДанныхсСервер, имяТаблицыОтАндройда_локальноая,
                    "", true,
                    СколькоСтрочекJSON, true, КонтекстСинхроДляКонтроллераВФоне,ActivityДляСинхронизацииОбмена,МенеджерПотоков,getБазаДанныхДЛяОперацийВнутри,СколькоСтрочекJSON,
                    ИндексТекущейОперацииJSONДляВизуальнойОбработки,ФиналПроценты);*/
            ///
            Log.d(this.getClass().getName(), "РезультатВставкиЧерезКонтрейнер   " + РезультатВставкиЧерезКонтрейнер);




            /// после вствки в базу обнуляем контейнер данные от сервера
            if (РезультатВставкиЧерезКонтрейнер > 0) {
                //////
                //// todo ПРИ УСПЕШНОЙ ВСТАВКИ ДАННЫХ  ПЕРЕДАЕМ СТАТИЧНОМУ СЁЧИКК  ОБНОВЛЕНИЙ ЧТО НАДО УВЕЛИЧИТ ЗНАЧЕНИЕ НА 1+

                /////TODO ВАЖНО ПОСЛЕ УСПЕШНОЙ ОБРАБОТКИ ПРИСВАИВАЕМ ЗНАЧЕНИЕ присваиваем наверх факсическое значение идущего цикла После Успешного прохода ТАБЛИЦЫ одной ИЗ
                Log.d(this.getClass().getName(), " РезультатВставкиЧерезКонтрейнер" + РезультатВставкиЧерезКонтрейнер);
                ///TODO переводим ввобщим в универсальный индификатор


                ///


            }
            ///





            //////////todo ВСТАВКА JSON НА КЛИЕНТА ДАННЫЕ С СЕРВЕРА


            ////////// TODO ОБНОВЛЕНИЕ JSON НА КЛИЕНТА


            ///TODO если что -то открыта закрыть

            /////////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }/*finally {
            //////Удаляем из памяти Асинтаск
            if (Курсор_УзнатьЕслиНаАндройдеТакойUUID != null) {

                if(!Курсор_УзнатьЕслиНаАндройдеТакойUUID.isClosed()) {

                    Курсор_УзнатьЕслиНаАндройдеТакойUUID.close();

                    Курсор_УзнатьЕслиНаАндройдеТакойUUID = null;
                }

            }

            ////
            if (Курсор_УзнатьЕслиНаАндройдеТакойID != null) {

                if (!Курсор_УзнатьЕслиНаАндройдеТакойID.isClosed()){

                    Курсор_УзнатьЕслиНаАндройдеТакойID.close();

                    Курсор_УзнатьЕслиНаАндройдеТакойID = null;
                }


            }
        }*/
        return  РезультатВставкиЧерезКонтрейнер;
    }


// TODO: 09.09.2021  КОНЕЦ ОПЕРАЦИИ ВСТАВКИ















    //////////////TODO метод непосредвственой запись в базу данных json КОТОРЫЙ ПРИШЁЛ С СЕРВЕРА  ВТОРАЯ ОПЕРАЦИЯ ОБНОВЛЕНИЯ !!!!!!!
    Integer МетодаЗаписиВБазуКонтейнераОБНОВЛЕНИЕJSONвФоне( @NotNull  String имяТаблицыОтАндройда_локальноая,
                                                            @NotNull Long UUIDПолученныйИзПришедшегоJSON,
                                                            @NotNull    Integer IDИзПришедшегоJSON,
                                                            @NotNull CompletionService МенеджерПотоков,

                                                            SQLiteDatabase getБазаДанныхДЛяОперацийВнутри,
                                                            Integer СколькоСтрочекJSON,
                                                            Integer ИндексТекущейОперацииJSONДляВизуальнойОбработки,
                                                            Float ФиналПроценты) {////запись полученого json   от сервера через контейнер

        Log.d(this.getClass().getName(), " UUIDПолученныйИзПришедшегоJSON  " + UUIDПолученныйИзПришедшегоJSON+ "  СколькоСтрочекJSON " +СколькоСтрочекJSON);

        ////
        Integer РезультатОбновлениеЧерезКонтрейнер = 0;


        try {


            //////////todo ВСТАВКА JSON НА КЛИЕНТА ДАННЫЕ С СЕРВЕРА

            ////////// TODO ОБНОВЛЕНИЕ JSON НА КЛИЕНТА
            Log.i(this.getClass().getName(), "  АдаптерДляОбновленияПриВставкиДанныхсСервера " + АдаптерПриОбновленияДанныхсСервера.size());

            ////////ВЫЗЫВАЕМ ОБНОВЛЕНИЕ


            /////TODO делим обновление на два вида если есть UUID ИЛИ НЕТ А ЕСТЬ ID

            ///TODO когда есть только UUID
            if (UUIDПолученныйИзПришедшегоJSON>0) {

                //////todo UUID UPDATE
                РезультатОбновлениеЧерезКонтрейнер = ОбновлениеДанныхЧерезКонтейнерУниверсальная(имяТаблицыОтАндройда_локальноая, АдаптерПриОбновленияДанныхсСервера,
                        String.valueOf(UUIDПолученныйИзПришедшегоJSON),
                        СколькоСтрочекJSON, true, contextСозданиеБАзы,
                        "uuid",ActivityДляСинхронизацииОбмена,МенеджерПотоков,getБазаДанныхДЛяОперацийВнутри,СколькоСтрочекJSON,ИндексТекущейОперацииJSONДляВизуальнойОбработки,ФиналПроценты);

                //

                Log.d(this.getClass().getName(), "РезультатОбновлениеЧерезКонтрейнер"
                        + РезультатОбновлениеЧерезКонтрейнер);
                ///TODO когда есть только ID




            }

            // TODO: 08.04.2021 НЕТ UUID И ОБНОВЛЕМ ПО ID
            if (IDИзПришедшегоJSON >0) {
                ///todo
// TODO: 08.04.2021 НЕТ UUID И ОБНОВЛЕМ ПО ID

                String ВзависимостиТакаяТабицаЧерезЭтотИнфдификатораИОбновлеяемДляTables__ID = null;

                ////TODO в обратную сторону обмена из _id в таблице tabels на id меняем ы фоне

                switch (имяТаблицыОтАндройда_локальноая.trim().toLowerCase()) {

                    case "tabels":
                    case "chats":
                    case "data_chat":
                    case "chat_users":
                    case "fio":
                    case "tabel":
                    case "data_tabels":
                        //
                        System.out.println("  ВзависимостиТакаяТабицаЧерезЭтотИнфдификатораИОбновлеяемДляTables__ID  " + ВзависимостиТакаяТабицаЧерезЭтотИнфдификатораИОбновлеяемДляTables__ID +
                                " имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);

                        ////////
                        ВзависимостиТакаяТабицаЧерезЭтотИнфдификатораИОбновлеяемДляTables__ID = "_id";


                        break;
                    //
                    default:
                        //
                        ВзависимостиТакаяТабицаЧерезЭтотИнфдификатораИОбновлеяемДляTables__ID = "id";
                        ///

                        System.out.println("  ВзависимостиТакаяТабицаЧерезЭтотИнфдификатораИОбновлеяемДляTables__ID  " + ВзависимостиТакаяТабицаЧерезЭтотИнфдификатораИОбновлеяемДляTables__ID +
                                " имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);
                }

                /////


                //////todo ID UPDATE
                РезультатОбновлениеЧерезКонтрейнер = ОбновлениеДанныхЧерезКонтейнерУниверсальная(имяТаблицыОтАндройда_локальноая, АдаптерПриОбновленияДанныхсСервера,
                        String.valueOf(IDИзПришедшегоJSON),
                        СколькоСтрочекJSON,
                        true, contextСозданиеБАзы, ВзависимостиТакаяТабицаЧерезЭтотИнфдификатораИОбновлеяемДляTables__ID,ActivityДляСинхронизацииОбмена,МенеджерПотоков,
                        Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы,СколькоСтрочекJSON,ИндексТекущейОперацииJSONДляВизуальнойОбработки,ФиналПроценты);
                //

                Log.d(this.getClass().getName(), "РезультатОбновлениеЧерезКонтрейнер"
                        + РезультатОбновлениеЧерезКонтрейнер);


            }



            /// после обновление  в базу обнуляем контейнер  данные от сервера
            if (РезультатОбновлениеЧерезКонтрейнер > 0) {
//////////////////
                /////TODO ВАЖНО ПОСЛЕ УСПЕШНОЙ ОБРАБОТКИ ПРИСВАИВАЕМ ЗНАЧЕНИЕ присваиваем наверх факсическое значение идущего цикла После Успешного прохода ТАБЛИЦЫ одной ИЗ
                Log.d(this.getClass().getName(), " КоличествоУспешныхОбновлений JSON РезультатОбновлениеЧерезКонтрейнер " + РезультатОбновлениеЧерезКонтрейнер);
                ///TODO переводим ввобщим в универсальный индификатор

                /////TODO ВАЖНО ПОСЛЕ УСПЕШНОЙ ОБРАБОТКИ ПРИСВАИВАЕМ ЗНАЧЕНИЕ присваиваем наверх факсическое значение идущего цикла После Успешного прохода ТАБЛИЦЫ одной ИЗ


            }




            ////TODO вставка





            ///TODO если что -то открыта закрыть

            /////////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }/*finally {
            //////Удаляем из памяти Асинтаск
            if (Курсор_УзнатьЕслиНаАндройдеТакойUUID != null) {

                if(!Курсор_УзнатьЕслиНаАндройдеТакойUUID.isClosed()) {

                    Курсор_УзнатьЕслиНаАндройдеТакойUUID.close();

                    Курсор_УзнатьЕслиНаАндройдеТакойUUID = null;
                }

            }

            ////
            if (Курсор_УзнатьЕслиНаАндройдеТакойID != null) {

                if (!Курсор_УзнатьЕслиНаАндройдеТакойID.isClosed()){

                    Курсор_УзнатьЕслиНаАндройдеТакойID.close();

                    Курсор_УзнатьЕслиНаАндройдеТакойID = null;
                }


            }
        }*/
        return РезультатОбновлениеЧерезКонтрейнер;
    }



















































    ///----------- ТУТ КОД УЖЕ ПОСЫЛАНИЕ ДАННЫХ НА СЕРВЕР МЕТОДУ POST (данные андройда посылаються на сервер)


    /////todo POST МЕТОД КОГДА НА АНДРОЙДЕ ВЕРСИЯ ДАННЫХ ВЫШЕ ЧЕМ НА СЕРВРЕР И МЫ  JSON ФАЙЛ ТУДА МЕТОД POST
    Integer МетодПосылаемДанныеНаСервервФоне(String имяТаблицыОтАндройда_локальноая,
                                             Long РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера,
                                             CompletionService МенеджерПотоковВнутрений) {
        ////

        Integer РезультатОтветаОтСервераУспешнаяВставкаИлиОбновление=0;
        ///
        Log.d(this.getClass().getName(), "  имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);
        ////
        Long Версия_ДанныхАндройДляОтправкиДанныхНАсервер = 0l;
        ////
        int КоличествоСтрокПолученыеДляОтпарвкиПоДатеОтпарвки = 0;
        //////
        Integer КоличествоКолоноквОтправвляемойТаблице = 0;
        ////


        // TODO: 06.09.2021
        ///// Class_GRUD_SQL_Operations class_grud_sql_operationsПосылаемДанныеНаСервервФоне;

        try {
            Log.d(this.getClass().getName(), "  МетодПосылаемДанныеНаСервер в фоне ");


            Class_GRUD_SQL_Operations  class_grud_sql_operationsПосылаемДанныеНаСервервФоне = new Class_GRUD_SQL_Operations(contextСозданиеБАзы);


            // TODO: 15.02.2022  

            Class_GRUD_SQL_Operations.GetData class_grud_sql_operationsДляВыполенияОперацииGEtData=class_grud_sql_operationsПосылаемДанныеНаСервервФоне.new GetData(contextСозданиеБАзы);
            
            
            

            // TODO: 15.02.2022  
            class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", "MODIFITATION_Client");
            ///////
            class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "versionserveraandroid_version");
            //
            class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", " name=?   ");
            ///"_id > ?   AND _id< ?"
            //////
            class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", имяТаблицыОтАндройда_локальноая);
            ///
/*            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
            class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......

            ////TODO другие поля

            ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);*/
            ////
            //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
            ////
            // class_grud_sql_operationsАнализаВресииДАнныхКлиента. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
            ////
            /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

            SQLiteCursor КурсорДляАнализаДатыПоследнейОтпракиНаСервер = null;
            ///////
            КурсорДляАнализаДатыПоследнейОтпракиНаСервер = (SQLiteCursor) class_grud_sql_operationsДляВыполенияОперацииGEtData
                    .getdata(class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    МенеджерПотоковВнутрений,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

            Log.d(this.getClass().getName(), "GetData  КурсорДляАнализаДатыПоследнейОтпракиНаСервер "+КурсорДляАнализаДатыПоследнейОтпракиНаСервер );




     /*       // TODO: 06.09.2021  _old
            КурсорДляАнализаДатыПоследнейОтпракиНаСервер= КурсорУниверсальныйДляБазыДанных("MODIFITATION_Client", new String[]{"versionserveraandroid"},
                    "name=?", new String[]
                            {имяТаблицыОтАндройда_локальноая}, null, null, null, null);
            ////////
*/
            //////ОЧИСТКА ПАМЯТИ ОТ ASYNSTASK

            /////////todo  result

            //// КУРСОР ПО ПОИСКУ ДАТФ ПОСЛЕДНЕЙ ОТПРАВКИ НА СЕРВЕР
            ////////
            if (КурсорДляАнализаДатыПоследнейОтпракиНаСервер.getCount()>0) {

                ///// todo УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
                Log.i(this.getClass().getName(), " КурсорДляАнализаДатыПоследнейОтпракиНаСервер.getCount() " + КурсорДляАнализаДатыПоследнейОтпракиНаСервер.getCount());

                КурсорДляАнализаДатыПоследнейОтпракиНаСервер.moveToFirst();




                Integer ИндексГлдеНаходитьсяСлолбикСВерисеДанныхСервернойЛОкальноНаТелефоне=КурсорДляАнализаДатыПоследнейОтпракиНаСервер.getColumnIndex( "versionserveraandroid_version");



                Версия_ДанныхАндройДляОтправкиДанныхНАсервер = 0l;

                // TODO: 05.10.2021

                Версия_ДанныхАндройДляОтправкиДанныхНАсервер = КурсорДляАнализаДатыПоследнейОтпракиНаСервер.getLong(ИндексГлдеНаходитьсяСлолбикСВерисеДанныхСервернойЛОкальноНаТелефоне);
                ///TODO ЕСЛИ НЕТ ДАТЫ НЕЧЕГО ОТПРАВЛЯТЬ




                if (Версия_ДанныхАндройДляОтправкиДанныхНАсервер >=0) {

                    Log.d(this.getClass().getName(), " Версия_ДанныхАндройДляОтправкиДанныхНАсервер " + Версия_ДанныхАндройДляОтправкиДанныхНАсервер +
                            "  имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);

                    int КоличествоСтрокПолученыеДляОтпарвкиПоДате = КурсорДляАнализаДатыПоследнейОтпракиНаСервер.getCount();

                    Log.d(this.getClass().getName(), " КоличествоСтрокПолученыеДляОтпарвкиПоДате   " + КоличествоСтрокПолученыеДляОтпарвкиПоДате);


                    ///todo


                }

            }
            // TODO: 06.09.2021  закрываем
            ///todo закрываем куроср
            КурсорДляАнализаДатыПоследнейОтпракиНаСервер.close();


            // TODO: 21.09.2021  ВТОРАЯ ЧАСТЬ    НЕПОСРЕДСТВЕННО ВЫЯСНИВ ЕСЛИ ДАННЫЕ ДЛЯ ОТПРАВКИ ,      ПОЛУЧАЕМ ДАННЫЕ ДЛЯ САМОЙ ОТПРАВКИ ЧРЕЗ КУРСОР ВТОРОЙ   КурсорДляОтправкиДанныхНаСервер







            
            ///todo закрываем куроср
            Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая   " + имяТаблицыОтАндройда_локальноая);


            SQLiteCursor КурсорДляОтправкиДанныхНаСервер = null;



            Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая   " + имяТаблицыОтАндройда_локальноая);


            class_grud_sql_operationsПосылаемДанныеНаСервервФоне = new Class_GRUD_SQL_Operations(contextСозданиеБАзы);


            class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", имяТаблицыОтАндройда_локальноая);
            ///////
            class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "*");
            //


     /*       //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
            class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);

            Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая   "
                            + имяТаблицыОтАндройда_локальноая+ "  РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера ");*/

            // TODO: 12.10.2021

            Integer ПубличныйIDДляФрагмента=0;


            // TODO: 31.01.2022 ОПРЕДЕЛЯЕМ ПУБЛИЧНЫЙ id
            ПубличныйIDДляФрагмента = getInteger(имяТаблицыОтАндройда_локальноая, РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера, class_grud_sql_operationsПосылаемДанныеНаСервервФоне);




            Log.d(this.getClass().getName(), " ПубличныйIDДляФрагмента   " + ПубличныйIDДляФрагмента);



            //////TODO ВКЛЮЧАЕМ ФЛАГ НЕ ПОВТОРАЕМОСТИ СТРОК
            class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФлагНепотораяемостиСтрок",true);

            Log.d(this.getClass().getName(), "     class_grud_sql_operationsПосылаемДанныеНаСервервФоне.\n" +
                    "                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций   " +     class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций);


            // TODO: 15.02.2022  код обработка таблиц синхрониазции

            class_grud_sql_operationsПосылаемДанныеНаСервервФоне = МетодТаблицСинхрониазцииОбменаВыбираемДляКаждойТаблицыСвоиКурсоры(имяТаблицыОтАндройда_локальноая,
                    РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера, 
                    Версия_ДанныхАндройДляОтправкиДанныхНАсервер, ПубличныйIDДляФрагмента);


            
            
            
            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
          class_grud_sql_operationsДляВыполенияОперацииGEtData=class_grud_sql_operationsПосылаемДанныеНаСервервФоне.new GetData(contextСозданиеБАзы);

            // TODO: 15.02.2022
            КурсорДляОтправкиДанныхНаСервер = null;


            КурсорДляОтправкиДанныхНаСервер = (SQLiteCursor) class_grud_sql_operationsДляВыполенияОперацииGEtData
                    .getdata(class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    МенеджерПотоковВнутрений,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

            Log.d(this.getClass().getName(), "GetData " + КурсорДляОтправкиДанныхНаСервер);




            //////ОЧИСТКА ПАМЯТИ ОТ ASYNSTASK
            Log.d(this.getClass().getName(), "КурсорДляОтправкиДанныхНаСервер.getCount()  ЕСЛИ 0 СТРОЧЕК ТО ДЕЛАЕМ ЕЩЕ ОДИН ПРОВЕРКУ НА null " + КурсорДляОтправкиДанныхНаСервер.getCount());
            /////TODO результаты   количество отправляемой информации на сервера

            if (КурсорДляОтправкиДанныхНаСервер.getCount() > 0) {/////работаем уже в сгенерированных даннных которые мы отправим на сервер
                /////
                КурсорДляОтправкиДанныхНаСервер.moveToFirst();
                ////
                КоличествоСтрокПолученыеДляОтпарвкиПоДатеОтпарвки = КурсорДляОтправкиДанныхНаСервер.getCount();////КОЛИЧЕСТВО СТРОК В АНДРОЙДЕ ДАННЫЕ КОТОРЫЕ НУЖНО ПОСЛЛАТЬ
                ///
                КоличествоКолоноквОтправвляемойТаблице = КурсорДляОтправкиДанныхНаСервер.getColumnCount();/////КОЛИЧЕСТВО СТОЛЮЦОВ НА АНДРОДЕ БАЗЕ КОТОРОЫЕ НУЖНО ОТОСЛАТЬ
                ////
                Log.d(this.getClass().getName(), " КоличествоСтрокПолученыеДляОтпарвкиПоДатеОтпарвки  " + КоличествоСтрокПолученыеДляОтпарвкиПоДатеОтпарвки +
                        "  КоличествоКолоноквОтправвляемойТаблице  " + КоличествоКолоноквОтправвляемойТаблице +
                        "  КурсорДляОтправкиДанныхНаСервер.getCount() " +КурсорДляОтправкиДанныхНаСервер.getCount());


                // TODO: 06.09.2021  полчено отправляем


                ////TODO провеояем чтобы  JSON ФАЙЛ БЫЛ НЕ ПУСТЫМ ДЛЯ ОТПРПВИК ЕГО НЕ СЕРВЕР
                if (КоличествоСтрокПолученыеДляОтпарвкиПоДатеОтпарвки > 0) {

                    РезультатОтветаОтСервераУспешнаяВставкаИлиОбновление = 0;

                    Log.d(this.getClass().getName(), "КоличествоСтрокПолученыеДляОтпарвкиПоДатеОтпарвки " + КоличествоСтрокПолученыеДляОтпарвкиПоДатеОтпарвки);



                    //////// todo упаковываем в  json ПЕРЕХОДИМ НА СЛЕДУЩИМ МЕТОД для отрправки на сервер метод POST() POST() POST() POST() POST() POST()POST()

                    РезультатОтветаОтСервераУспешнаяВставкаИлиОбновление =
                            МетодГенеррируемJSONИзНашыхДанныхвФоне(КурсорДляОтправкиДанныхНаСервер, КоличествоСтрокПолученыеДляОтпарвкиПоДатеОтпарвки,
                                    КоличествоКолоноквОтправвляемойТаблице, имяТаблицыОтАндройда_локальноая,МенеджерПотоковВнутрений);
                    //

                    Log.d(this.getClass().getName(), "РезультатОтветаОтСервераУспешнаяВставкаИлиОбновление " + РезультатОтветаОтСервераУспешнаяВставкаИлиОбновление);



                }

                // TODO: 21.09.2021 close cursor



                // TODO: 27.09.2021     Нет данных для отправки  И ДЕЛАЕМ ЕЩЕ ОДНУ ПОПЫТКУ ОТПРАЛЯЕМ NULL ЗНАЧЕНИЯ
            }



            ///todo закрываем куроср
            КурсорДляОтправкиДанныхНаСервер.close();

            // TODO: 15.02.2022

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }
        return  РезультатОтветаОтСервераУспешнаяВставкаИлиОбновление;
    }


    // TODO: 15.02.2022 синхрогниазции таблиц
    @NonNull
    private Class_GRUD_SQL_Operations МетодТаблицСинхрониазцииОбменаВыбираемДляКаждойТаблицыСвоиКурсоры(String имяТаблицыОтАндройда_локальноая,
                                                                   Long РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера,
                                                                   Long Версия_ДанныхАндройДляОтправкиДанныхНАсервер,
                                                                   Integer ПубличныйIDДляФрагмента) {
        Class_GRUD_SQL_Operations class_grud_sql_operationsПосылаемДанныеНаСервервФоне = null;






        // TODO: 31.01.2022  ---ВЫБОР В ЗАВИСИМОСТИ ОТ ТЕКУЩЕЙ ТАБЛИЦЫ БЫБИРАЕМ ПО АКОЙ ТАЛИЦЕ БУДЕТ ПРОИЗВЕДЕНА ВЫБОРКА

        try{

            Log.w(this.getClass().getName(), "имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);

        switch (имяТаблицыОтАндройда_локальноая.trim()) {


            case "tabels":
            case "chat_users":
            case "fio":
            case "tabel":
            case "data_tabels":

                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая  Для tabels  chat_users  fio  tabel  data_tabels  " + имяТаблицыОтАндройда_локальноая);
                // TODO: 19.10.2021


                class_grud_sql_operationsПосылаемДанныеНаСервервФоне = new Class_GRUD_SQL_Operations(contextСозданиеБАзы);


                // TODO: 01.02.2022 БЛОК КОДА ДЛЯ ВСЕХ ТАБОИЦ БЕЗ ПОД ЗАПРОСОD SUB QUERY
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","*");
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", имяТаблицыОтАндройда_локальноая);


                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);

                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая   "
                        + имяТаблицыОтАндройда_локальноая + "  РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера " + РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);


                // TODO: 31.01.2022

                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2", ПубличныйIDДляФрагмента);



                // TODO: 19.10.2021

                class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                        .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПодЗапросНомер1"," SELECT * FROM " + имяТаблицыОтАндройда_локальноая +
                        " WHERE current_table > "+ РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера +"  AND date_update IS NOT NULL   ");//AND _id IS NULL//"  current_table > ? OR _id IS NULL  AND date_update IS NOT NULL "
                ///"_id > ?   AND _id< ?"

                class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                        .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПодЗапросНомер2","  SELECT * FROM " + имяТаблицыОтАндройда_локальноая +" " +
                        "  WHERE user_update=" + ПубличныйIDДляФрагмента +"  AND _id IS NULL  AND date_update IS NOT NULL ");//AND _id IS NULL//"  current_table > ? OR _id IS NULL  AND date_update IS NOT NULL "
                ///"_id > ?   AND _id< ?"



                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая Все остальные  _id " + имяТаблицыОтАндройда_локальноая);

                /////////

                ///TODO
                break;







//TOdo две табЛИЦЫ ДЛЯ ЧАТА  1
            case "chats":

                // TODO: 19.10.2021

                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая  Для chats " + имяТаблицыОтАндройда_локальноая);

                // TODO: 11.01.2022 ПУБЛИЧНЫЙ ID ТЕКУЩЕГО ПОЛЬЗОВТЕЛЯ
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне = new Class_GRUD_SQL_Operations(contextСозданиеБАзы);


                ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(contextСозданиеБАзы).ПолучениеПубличногоТекущегоПользователяID();

                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая  Для Чата с _id " + имяТаблицыОтАндройда_локальноая);

                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", ПубличныйIDДляФрагмента);

                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2", РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);
                // TODO: 18.02.2022


                // TODO: 01.02.2022 БЛОК КОДА ДЛЯ ВСЕХ ТАБОИЦ БЕЗ ПОД ЗАПРОСОD SUB QUERY
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","*");
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", имяТаблицыОтАндройда_локальноая);



                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая   "
                        + имяТаблицыОтАндройда_локальноая + "  РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера ");

                // TODO: 19.10.2021

                class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                        .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","  user_update = ?" +
                        " AND current_table > ? AND date_update IS NOT NULL  AND _id IS NULL ");//AND _id IS NULL//"  current_table > ? OR _id IS NULL  AND date_update IS NOT NULL "
                ///"_id > ?   AND _id< ?"
                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая  Для Чата с _id " + имяТаблицыОтАндройда_локальноая);

                /////////

                ///TODO
                break;





//TOdo две табЛИЦЫ ДЛЯ ЧАТА  2

            case "data_chat":

                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая  Для data_chat  " + имяТаблицыОтАндройда_локальноая);
                // TODO: 19.10.2021

              /*  class_grud_sql_operationsПосылаемДанныеНаСервервФоне = new Class_GRUD_SQL_Operations(contextСозданиеБАзы);




                //TODO OR oretrtion не мои ЗАПИСИ А ДРУГОВО ПОЛЬЗОВАТЕЛЯ КОТОРЫЙ МЕН НАПИСАЛ

                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);
                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ПубличныйIDДляФрагмента);

                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска5",1);
                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска6",ПубличныйIDДляФрагмента);*/

                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА  old version

           /*     ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(contextСозданиеБАзы).ПолучениеПубличногоТекущегоПользователяID();

                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая  Для Чата с _id " + имяТаблицыОтАндройда_локальноая);

                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",ПубличныйIDДляФрагмента);

                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2",РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);
                // TODO: 19.10.2021

                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);
                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ПубличныйIDДляФрагмента);
                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска5",1);
                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска6",ПубличныйIDДляФрагмента);
                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА*/
                // TODO: 19.10.2021  old data_chat

      /*          class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                        .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика"," " +
                        "  current_table > ? AND user_update=?   AND date_update IS NOT NULL" +
                        " OR    current_table > ? AND id_user=?  AND status_write=?  AND date_update IS NOT NULL "+
                        " OR   user_update=?  AND _id IS NULL  AND date_update IS NOT NULL ");
*/
                // TODO: 19.10.2021

                class_grud_sql_operationsПосылаемДанныеНаСервервФоне = new Class_GRUD_SQL_Operations(contextСозданиеБАзы);
                // TODO: 19.10.2021
// TODO: 15.02.2022  тут КОД ОТПРАВЛЯЕТ СВОИ СООБЩЕНИЯ НАПИСАННЫЕ САМИМ 
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                        .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПодЗапросНомер1"," SELECT * FROM " + имяТаблицыОтАндройда_локальноая +
                        " WHERE current_table > "+ РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера +
                      "  AND user_update= "+ ПубличныйIDДляФрагмента +
                        " AND date_update IS NOT NULL   ");//AND _id IS NULL//"  current_table > ? OR _id IS NULL  AND date_update IS NOT NULL "
                ///"_id > ?   AND _id< ?"

                // TODO: 15.02.2022  тут сообещния написнные другим пользователем но тоже отпралвем когда мы имзенили статус на прочитанный и с столбике wtire изменил на 1 и отпрадем на сервер как прочитанные

                class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                        .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПодЗапросНомер2"," SELECT * FROM " + имяТаблицыОтАндройда_локальноая +
                        " WHERE current_table > "+ РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера +
                        "  AND status_write=1 "+
                        " AND date_update IS NOT NULL   ");//AND _id IS NULL//"  current_table > ? OR _id IS NULL  AND date_update IS NOT NULL "

                // TODO: 15.02.2022  тут сообещния написнные другим пользователем но тоже отпралвем когда мы имзенили статус на прочитанный и с столбике wtire изменил на 1 и отпрадем на сервер как прочитанные 

                class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                        .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПодЗапросНомер3","  SELECT * FROM " + имяТаблицыОтАндройда_локальноая +" " +
                        "  WHERE user_update=" + ПубличныйIDДляФрагмента +"  AND _id IS NULL  AND date_update IS NOT NULL ");//AND _id IS NULL//"  current_table > ? OR _id IS NULL  AND date_update IS NOT NULL "
                ///"_id > ?   AND _id< ?"


                ///"_id > ?   AND _id< ?"
                // TODO: 19.01.2022  old version         class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                //                            .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика"," " +
                //                            " user_update = ?  AND current_table > ?   AND date_update IS NOT NULL "
                //                            + "  OR  current_table > ?  AND id_user=?  and status_write=?  "
                //                            + "  OR  user_update = ?  AND _id IS NULL   AND date_update IS NOT NULL   ");//AND _id IS NULL//"  current_table > ? OR _id IS NULL  AND date_update IS NOT NULL "
                //                    ///"_id > ?   AND _id< ?"
                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая  Для Чата с _id " + имяТаблицыОтАндройда_локальноая);

                /////////

                ///TODO
                break;













            case "settings_tabels":

                // TODO: 15.02.2022
                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая  Для settings_tabels  " + имяТаблицыОтАндройда_локальноая);

                class_grud_sql_operationsПосылаемДанныеНаСервервФоне = new Class_GRUD_SQL_Operations(contextСозданиеБАзы);

                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА


                // TODO: 01.02.2022 БЛОК КОДА ДЛЯ ВСЕХ ТАБОИЦ БЕЗ ПОД ЗАПРОСОD SUB QUERY
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","*");
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", имяТаблицыОтАндройда_локальноая);



                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);

                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая   "
                        + имяТаблицыОтАндройда_локальноая + "  РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера ");
                // TODO: 19.10.2021

                // TODO: 19.10.2021

                class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                        .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","  current_table > ?   AND date_update IS NOT NULL  ");//AND _id IS NULL//"  current_table > ? OR _id IS NULL  AND date_update IS NOT NULL "
                ///"_id > ?   AND _id< ?"
                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая  Для Чата с _id " + имяТаблицыОтАндройда_локальноая);

                /////////

                ///TODO
                break;





            default:


                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая  Для          default: " + имяТаблицыОтАндройда_локальноая);

                class_grud_sql_operationsПосылаемДанныеНаСервервФоне = new Class_GRUD_SQL_Operations(contextСозданиеБАзы);

                // TODO: 19.10.2021

                //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);

                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая   "
                        + имяТаблицыОтАндройда_локальноая + "  РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера ");




                // TODO: 01.02.2022 БЛОК КОДА ДЛЯ ВСЕХ ТАБОИЦ БЕЗ ПОД ЗАПРОСОD SUB QUERY
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","*");
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", имяТаблицыОтАндройда_локальноая);



                // TODO: 19.10.2021

                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "  current_table > ?   AND date_update IS NOT NULL  ");//AND _id IS NULL///"  current_table > ? OR id IS NULL  AND date_update IS NOT NULL "
                ///"_id > ?   AND _id< ?"
                Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая   " + имяТаблицыОтАндройда_локальноая);

                //////
                class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",
                        Версия_ДанныхАндройДляОтправкиДанныхНАсервер);
                ///

                ///////
                ///TODO
                break;

        }


        // TODO: 15.02.2022

    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ////// начало запись в файл
    }





        return class_grud_sql_operationsПосылаемДанныеНаСервервФоне;
    }














    private Integer getInteger(String имяТаблицыОтАндройда_локальноая, Long РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера, Class_GRUD_SQL_Operations class_grud_sql_operationsПосылаемДанныеНаСервервФоне) {
        Integer ПубличныйIDДляФрагмента;
        // TODO: 11.01.2022 ПУБЛИЧНЫЙ ID ТЕКУЩЕГО ПОЛЬЗОВТЕЛЯ

//////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
        class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", РезультаПолученаяЛокальнаяСервернуюВерсиюДанныхКогдаПоследнийРазПришлиДанныесСерера);

        //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА  old version

        ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(contextСозданиеБАзы).ПолучениеПубличногоТекущегоПользователяID();

        Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая  Для Чата с _id " + имяТаблицыОтАндройда_локальноая);

        //////TODO dверсия данных для ВСЕХ ТАБЛИЦ КРОМЕ , ТАБЛИЦ ЧАТА
        class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2",ПубличныйIDДляФрагмента);
        return ПубличныйIDДляФрагмента;
    }


    // TODO: 04.11.2021  метод ПОСЫЛАЕМ ТОЛЬКО NULL В ПОЛЕ ID  НА СЕРВЕР








    /////todo POST МЕТОД КОГДА НА АНДРОЙДЕ ВЕРСИЯ ДАННЫХ ВЫШЕ ЧЕМ НА СЕРВРЕР И МЫ  JSON ФАЙЛ ТУДА МЕТОД POST






    // TODO: 18.10.2021  метод дОВОЛТИЛЬЕНО  ПРОВЕРКИ ЕСЛИ ЗНАЧЕНИ НУЛЛВ ПОЛНЕ ID
    private SQLiteCursor МетодДополнительнойПроверкиНаЗначниеКоторыеЩЕНеОтправленны_СтолбикеID_ЕстьЗначенияNULL(String имяТаблицыОтАндройда_локальноая,
                                                                                                                CompletionService МенеджерПотоковВнутрений
    ) throws ExecutionException, InterruptedException {
        Class_GRUD_SQL_Operations class_grud_sql_operationsПосылаемДанныеНаСервервФоне;

        SQLiteCursor КурсорДляОтправкиДанныхНаСервер=null;

        try{
            //todo ЕСЛИ НЕЧЕГО ОТПРАВЛЯЕТЬ ТО ДОПОЛНТЕЛЬНО ПРОВЕРЯЕМ МОЖЕТ ЕЩЕ ОТПРАВИТЬ НА СЕРВЕР



            Log.d(this.getClass().getName(), " имяТаблицыОтАндройда_локальноая   " + имяТаблицыОтАндройда_локальноая);

            // TODO: 06.09.2021 ДОПОЛНИТЕЛЬНЫЙ МЕХАНИЗСМ ОТПРВКИ ДАНННЫХС NULL В ID ПОЛЕ ДЛЯ ЧАТА

            class_grud_sql_operationsПосылаемДанныеНаСервервФоне = new Class_GRUD_SQL_Operations(contextСозданиеБАзы);


            class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                    .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы",
                    имяТаблицыОтАндройда_локальноая);


            // TODO: 12.10.2021 выбор двух вариантов отправки с _id and id


            // TODO: 12.10.2021

            switch (имяТаблицыОтАндройда_локальноая.trim()) {


                case "tabels":
                case "chats":
                case "data_chat":
                case "chat_users":
                case "fio":
                case "tabel":
                case "data_tabels":



                    Log.d(this.getClass().getName(), "имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);
                    ///////
                    class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "_id");

                    //
                    class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                            .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "  _id IS NULL    AND date_update IS NOT NULL   ");
                    ///"_id > ?   AND _id< ?"
                    break;


                default:

                    Log.d(this.getClass().getName(), "имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);
                    ///////
                    class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "id");
                    //
                    class_grud_sql_operationsПосылаемДанныеНаСервервФоне
                            .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "  id IS NULL     AND date_update IS NOT NULL   ");
                    ///"_id > ?   AND _id< ?"

            }


            //////
            /// class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", "");
            ///

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

            КурсорДляОтправкиДанныхНаСервер = null;

            КурсорДляОтправкиДанныхНаСервер = (SQLiteCursor) class_grud_sql_operationsПосылаемДанныеНаСервервФоне.
                    new GetData(contextСозданиеБАзы).getdata(class_grud_sql_operationsПосылаемДанныеНаСервервФоне.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    МенеджерПотоковВнутрений,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

            Log.d(this.getClass().getName(), "GetData " + КурсорДляОтправкиДанныхНаСервер);


            if(КурсорДляОтправкиДанныхНаСервер.getCount()>0){
                ////
                КурсорДляОтправкиДанныхНаСервер.moveToFirst();

            }

            // TODO: 06.09.2021  old
/*
            КурсорДляОтправкиДанныхНаСервер = КурсорУниверсальныйДляБазыДанных(имяТаблицыОтАндройда_локальноая, new String[]{"*"}, " _id IS NULL  OR _id = ? ",
                    new String[]{""}, null, null, null, null);*/
            ///


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }

        return КурсорДляОтправкиДанныхНаСервер;
    }














    ////////TODO     МЕТОД ГЕНЕРИРОУЕМ JSON ПОЛЯ НА ОСНОВАНИЕ НАШИХ ДАННЫХ ДЛЯ ПОСЛЕДЖУЮЩЕ ОТПРАВКИ  POST()->
    ////////TODO     МЕТОД ГЕНЕРИРОУЕМ JSON ПОЛЯ НА ОСНОВАНИЕ НАШИХ ДАННЫХ ДЛЯ ПОСЛЕДЖУЮЩЕ ОТПРАВКИ  POST()->
    ////////TODO     МЕТОД ГЕНЕРИРОУЕМ JSON ПОЛЯ НА ОСНОВАНИЕ НАШИХ ДАННЫХ ДЛЯ ПОСЛЕДЖУЮЩЕ ОТПРАВКИ  POST()->

    Integer МетодГенеррируемJSONИзНашыхДанныхвФоне( Cursor КурсорДляОтправкиДанныхНаСерверОтАндройда, int КоличествоСтрокПолученыеДляОтпарвкиПоДатеОтпарвки,
                                                    Integer КоличествоКолоноквОтправвляемойТаблице, String имяТаблицыОтАндройда_локальноая,CompletionService МенеджерПотоковВнутрений) {
        ///
        Log.d(this.getClass().getName(), " КоличествоСтрокПолученыеДляОтпарвкиПоДатеОтпарвки " + КоличествоСтрокПолученыеДляОтпарвкиПоДатеОтпарвки);
        Integer РезультатОтветаОтСервреУспешнаяВставкаИлиОбновления = 0;

        final int[] ЕслиUUIDПриЗабросеДанныхНаСервер = {0};

        final int[] ЕслиIDПриЗабросеДанныхНаСервер = {0};

        JSONObject ГенерацияJSONполейФинал = new JSONObject();///генериция финального поля дляJSON;  ////ПОЛЯ  ДЛЯ  JSON

        try {
///////метод создание josn из наших данных на отправку
            ////
            final String[] ПерхнееПолеJSONПоследнаяОперация = {null};////ПЕРЕРВОДИМ ИЗ INT TO STRING


            Log.d(this.getClass().getName(), " КурсорДляОтправкиДанныхНаСервер.getCount())   "
                    + КурсорДляОтправкиДанныхНаСерверОтАндройда.getCount() + " имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);

            boolean СработалПоворот = false;

            ///// ДО DO WHILE ОБЯЗАТЕЛЬНО

            if (КурсорДляОтправкиДанныхНаСерверОтАндройда.getCount()>0) {
                ///////////
                КурсорДляОтправкиДанныхНаСерверОтАндройда.moveToFirst();
                // TODO: 06.09.2021
                Log.d(contextСозданиеБАзы.getClass().getName(), "КурсорДляОтправкиДанныхНаСерверОтАндройда.getCount() " + КурсорДляОтправкиДанныхНаСерверОтАндройда.getCount());


            }

            final int[] КакаяСтрочкаОбработкиТекущаяя = {1};/////ОСТЛЕЖИВАЕМ ТЕКУЩУЮ СТРОЧКУ ОБРАБОТКИ
            ///TODO ЗАПУСКАЕМ  ПуллПамяти
            ////TODO ЗАДЕРЖКА ИТЕРАЦИЯ ДЛЯ СИНРОНИЗАЦИИ В ФОНЕ отправка данных

            //todo бежим по строчкам json
            do {/////КРУТИТЬ ДАННЫЕ ЧЕРЕЗ ЦИКЛ ОТВЕТЫ ОТ МЕТОДА POST

                /// ////TODO ЗАДЕРЖКА ИТЕРАЦИЯ ДЛЯ СИНРОНИЗАЦИИ В ФОНЕ
                ////TODO ЗАДЕРЖКА ИТЕРАЦИЯ ДЛЯ СИНРОНИЗАЦИИ В ФОНЕ отправка данных
                /// ////TODO ЗАДЕРЖКА ИТЕРАЦИЯ ДЛЯ СИНРОНИЗАЦИИ В ФОНЕ


                /////////////////
                JSONObject ГенерацияJSONполей = new JSONObject();  ////ПОЛЯ  ДЛЯ  JSON ///ВАЖНО ГЕНЕРАЦИЯ НОВЫХ ОБЬЕКТОВ JSON НУЖНО СТАВИТЬ ВНУТРИ DO WHILE  НО ДО FOR ЦИКЛА МЕЖДУ НИМИ

                /////
                LinkedBlockingQueue<Integer> linkedBlockingDequeГенерируемJSONИзНашихДанныхДляОтправкиНаСервре=new LinkedBlockingQueue<Integer>();
                //

                for (Integer i = 0; i < КоличествоКолоноквОтправвляемойТаблице; i++) {
                    ////
                    linkedBlockingDequeГенерируемJSONИзНашихДанныхДляОтправкиНаСервре.put(i);
                }


                ///
                Iterator iteratorГенерируемJSONИзНашихДанныхДляОтправкиНаСервре=linkedBlockingDequeГенерируемJSONИзНашихДанныхДляОтправкиНаСервре.iterator();



                //todo бежим по столбцам
                while (iteratorГенерируемJSONИзНашихДанныхДляОтправкиНаСервре.hasNext()) {
                    try {

                        //////////TODO ЭКСПЕРЕМЕНТ С JSON

                        Integer ИндексПоТАблицамДляОтправки= (Integer) iteratorГенерируемJSONИзНашихДанныхДляОтправкиНаСервре.next();


                        Log.d(this.getClass().getName(), "  ИндексПоТАблицамДляОтправки " +ИндексПоТАблицамДляОтправки );




                        //////ПОЛЯ ДЛЯ ВСТВКИ В JSON  ДЛЯ ОТПРАВКИ ЕГО НА СЕРВЕЛТ
                        String КлючJsonСтроки = КурсорДляОтправкиДанныхНаСерверОтАндройда.getColumnName(ИндексПоТАблицамДляОтправки);


                        //TODO сомо имя json
                        System.out.println(" КлючJsonСтроки  " + КлючJsonСтроки);


                        /////////
                        Object ЗначниеJsonСтроки = КурсорДляОтправкиДанныхНаСерверОтАндройда.getString(ИндексПоТАблицамДляОтправки);

                        Log.d(this.getClass().getName(), " КлючJsonСтроки ::    "
                                + КлючJsonСтроки + "  ЗначниеJsonСтроки " + ЗначниеJsonСтроки);


                        //TODO НАЧИНАЕМ ОБРАБАТЫВАТЬ КОГДА ЗНАЧЕНИЕ ПО СТОЛБИКУ ОТРУСТУЕТ VALUE==BULL  #ПЕРВАЯ ЧАСТЬ
                        Log.d(this.getClass().getName(), " КлючJsonСтроки " + КлючJsonСтроки);
                        if (ЗначниеJsonСтроки == null) {
                              /*      ////todo если пустые значение по столбику имитируем его как текст но и как цифра для столиков fio and uuid
                                    Log.d(this.getClass().getName(), " КлючJsonСтроки " +КлючJsonСтроки );
                                    if (КлючJsonСтроки.equalsIgnoreCase("fio") || КлючJsonСтроки.equalsIgnoreCase("uuid") || КлючJsonСтроки.equalsIgnoreCase("id")){
                                        //ЗначниеJsonСтроки=null;////чтобы небыло ошибки ПРИНУДИТЕЛЬНО В СОДРЕЖИСОА JSON ГЕНЕРИРУЕМОГО ДОБАВЛЯЕМ ПРОБЕЛЫ ЧТОБЫ JSON ПОД ДАНОМУ ПОЛЮ БЫЛ ЗОЗДАН
                                        ////////// TODO КОНКРЕТАНАЯ ГЕНЕРАЦИЯ  JSON СТРОКИ
                                                ////разрешаем вставку с NULL
                                                if (КлючJsonСтроки!=null ) {
                                                    ///todo генерация самой строки json ниже ключ к нему после for
                                                    ГенерацияJSONполей.put(КлючJsonСтроки, ЗначниеJsonСтроки); ////заполение полей JSON
                                                    ///
                                                    Log.d(this.getClass().getName(), " КлючJsonСтроки  " + КлючJsonСтроки + "  ЗначниеJsonСтроки " +ЗначниеJsonСтроки );
                                                    //todo обнуление после вставки
                                                    КлючJsonСтроки=null;
                                                    ЗначниеJsonСтроки=null;
                                                }
                                    }
            */

                            //TODO НАЧИНАЕМ ОБРАБАТЫВАТЬ КОГДА ЗНАЧЕНИЕ ПО СТОЛБИКУ ЕСТЬ , ВСЕ  ХОРОШО И ИМЯ СТОБЛИКА ЕСТЬИ ЕГО ЗНАЧЕНИЕ ТОЖЕ ЕСТЬ #ВТОРАЯ ЧАСТЬ
                            Log.d(this.getClass().getName(), " КлючJsonСтроки " + КлючJsonСтроки);
                        } else if (ЗначниеJsonСтроки != null) {
                            ////////// TODO КОНКРЕТАНАЯ ГЕНЕРАЦИЯ  JSON СТРОКИ
                            if (КлючJsonСтроки != null && ЗначниеJsonСтроки != null) {//ПРОИЗВОДИМ ВСТАВКИ JSON ПОЛЕЙ ТОЛЬКО ЕСЛИ ОНИ НЕ NULL


                                ////TODO в обратную сторону обмена из _id в таблице tabels на id меняем ы фоне


                                // TODO: 24.06.2021 меняем местави приотправки на сервер данные однго столика с _id на id

                                switch (имяТаблицыОтАндройда_локальноая.trim().toLowerCase()) {

                                    case "tabels":
                                    case "chats":
                                    case "data_chat":
                                    case "chat_users":
                                    case "fio":
                                    case "tabel":
                                    case "data_tabels":
                                        //
                                        System.out.println("  КлючJsonСтроки  " + КлючJsonСтроки);

                                        if (КлючJsonСтроки.equals("_id")) {

                                            КлючJsonСтроки = "id";
                                            //
                                            System.out.println("  КлючJsonСтроки  " + КлючJsonСтроки);
                                        }

                                        break;
                                }


                                //////

                                /////TODO вытаемся отслидить хотябы один заполненый день
                                Log.d(this.getClass().getName(), "КлючJsonСтроки " + "--" + КлючJsonСтроки + " З начниеJsonСтроки " + ЗначниеJsonСтроки);/////


                                ///todo генерация самой строки json ниже ключ к нему после for//   && ЗначниеJsonСтроки.toString().matches("[1-9]"
                                if (КлючJsonСтроки.matches("[d].*") && КлючJsonСтроки.length() <= 3) {
                                    ///////
                                    ГенерацияJSONполей.put(КлючJsonСтроки, ЗначниеJsonСтроки); ////заполение полей JSON

                                } else if (ЗначниеJsonСтроки != null && ! ЗначниеJsonСтроки.toString().equalsIgnoreCase("null")) {
                                    ///////
                                    ГенерацияJSONполей.put(КлючJsonСтроки, ЗначниеJsonСтроки); ////заполение полей JSON
                                }


                                ///
                                Log.d(this.getClass().getName(), " КлючJsonСтроки  " + КлючJsonСтроки + "  ЗначниеJsonСтроки " + ЗначниеJsonСтроки);
                                //todo обнуление после вставки
                                КлючJsonСтроки = null;
                                ЗначниеJsonСтроки = null;
                            }
                            ///////////////ДОБАЛВЕНИЕ ВЕПХНЕГО ID ПО ВЕРХ JSON ПОЛЕЙ
                        }


                        //////////TODO  КОНЕЦ ЭКСПЕРЕМЕНТ С JSON
                        ///todo  только uuid
                        ЕслиUUIDПриЗабросеДанныхНаСервер[0] = КурсорДляОтправкиДанныхНаСерверОтАндройда.getColumnIndex("uuid");

                        if (ЕслиUUIDПриЗабросеДанныхНаСервер[0] >= 0) {

                            Log.d(this.getClass().getName(), "ЕслиUUIDИлиIDПриЗабросеДанныхНаСервер " + ЕслиUUIDПриЗабросеДанныхНаСервер[0]);
                            ///////////////ЕСЛИ ID ПОЛЕ ПУСТОЕ ТО ЗАПОЛНЕМЕМ ЕГО ВТОРЫМ ПОЛЕМ
                            int ИндексДвижениеПОПОлямДЛяФОрмированиеID = КурсорДляОтправкиДанныхНаСерверОтАндройда.getColumnIndex("uuid");
                            ////todo
                            ПерхнееПолеJSONПоследнаяОперация[0] = КурсорДляОтправкиДанныхНаСерверОтАндройда.getString(ИндексДвижениеПОПОлямДЛяФОрмированиеID);

                        }


                        ///todo  только id
                        ЕслиIDПриЗабросеДанныхНаСервер[0] = КурсорДляОтправкиДанныхНаСерверОтАндройда.getColumnIndex("id");

                        if (ЕслиIDПриЗабросеДанныхНаСервер[0] >= 0 && ПерхнееПолеJSONПоследнаяОперация[0] == null) {

                            Log.d(this.getClass().getName(), "ЕслиUUIDИлиIDПриЗабросеДанныхНаСервер " + ЕслиIDПриЗабросеДанныхНаСервер[0]);
                            ///////////////ЕСЛИ ID ПОЛЕ ПУСТОЕ ТО ЗАПОЛНЕМЕМ ЕГО ВТОРЫМ ПОЛЕМ
                            int ИндексДвижениеПОПОлямДЛяФОрмированиеID = КурсорДляОтправкиДанныхНаСерверОтАндройда.getColumnIndex("id");
                            ////todo
                            ПерхнееПолеJSONПоследнаяОперация[0] = КурсорДляОтправкиДанныхНаСерверОтАндройда.getString(ИндексДвижениеПОПОлямДЛяФОрмированиеID);

                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        // TODO: 01.09.2021 метод вызова
                        new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        ////// начало запись в файл
                    }




                    ////todo выкидываем из очереди отработнаную строчку

                    linkedBlockingDequeГенерируемJSONИзНашихДанныхДляОтправкиНаСервре.peek();
                }
                ///future


                ////TODO упаковываем jon если хоть какое поле есть   , ЕСЛИ ЕСТЬ ИЛИ ID ИЛИ UUID
                if (ПерхнееПолеJSONПоследнаяОперация[0] != null && ГенерацияJSONполей != null && ГенерацияJSONполей.length() > 0) {


                    /// todo МЕЖДУ FOR И WHILE
                    Log.i(this.getClass().getName(), " ПерхнееПолеJSONПоследнаяОперация  :     " + ПерхнееПолеJSONПоследнаяОперация[0]
                            + " ГенерацияJSONполей " + ГенерацияJSONполей.toString());


                    /////////
                    try {
                        //////////todo КОНКРЕТАНАЯ ГЕНЕРАЦИЯ  JSON ВЕРХНЕГО КЛЮЧА
                        ГенерацияJSONполейФинал.put(ПерхнееПолеJSONПоследнаяОперация[0], ГенерацияJSONполей);////ВСТАВЛЯЕМ ОДИН JSON в ДРУГОЙ JSON ПОЛУЧАЕМ ФИНАЛЬНЫЙ РЕЗУЛЬТАТ JSON"А

                    } catch (Exception e) {
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        // TODO: 01.09.2021 метод вызова
                        new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        ////// начало запись в файл
                    }

                }


                КакаяСтрочкаОбработкиТекущаяя[0]++;////ЛОВИМ ТЕКУУЩЮ СТРОЧКУ ОБРАБОТКИ


                //todo ////


                //todo  ////

                ////// todo  КОНЕЦ МЕЖДУ FOR И WHILE
                ///todo идем по сторчкам  json
            } while (КурсорДляОтправкиДанныхНаСерверОтАндройда.moveToNext());////ДАННЫЕ КРУТИЯТЬСЯ ДО КОНЦА ДАННЫХ И ГЕНЕРИРУЮ JSON
            ///todo




            ///////// TODO ФИНАЛ ПРОСМАТРИВАЕМ СГЕНЕРИРОВАНЫЙ JSON  ФАЙЛ ПОСЛЕ ЦИКЛА DO WHILE СОЗДАИНИЕ НА СТОРОНЕ АНДРОЙДА JSON ПОЛЕЙ
            Log.d(this.getClass().getName(), " ГенерацияJSONполейФинал  " + ГенерацияJSONполейФинал + " ГенерацияJSONполейФинал " + ГенерацияJSONполейФинал.toString() +
                    " ГенерацияJSONполейФинал.length() " + ГенерацияJSONполейФинал.length());



            /////////
            if (ГенерацияJSONполейФинал.toString().length() > 3) {

                ///////// TODO ФИНАЛ ПРОСМАТРИВАЕМ СГЕНЕРИРОВАНЫЙ JSON  ФАЙЛ ПОСЛЕ ЦИКЛА DO WHILE СОЗДАИНИЕ НА СТОРОНЕ АНДРОЙДА JSON ПОЛЕЙ
                Log.d(this.getClass().getName(), " ГенерацияJSONполейФинал  " + ГенерацияJSONполейФинал + " ГенерацияJSONполейФинал " + ГенерацияJSONполейФинал.toString() +
                        " ГенерацияJSONполейФинал.length() " + ГенерацияJSONполейФинал.length());


                //TODO ЗАКРЫВАЕМ КУРСОР
                РезультатОтветаОтСервреУспешнаяВставкаИлиОбновления = 0;
                ///todo МЫ СОЗДАЛИ ФАЙЛ JSON  И ПОСЫЛАЕМ ЕГО НА СЕРВЕР


                SubClass_Klacc_Otprabki_класс_ОтправкиДанных subClass_klacc_otprabki_класс_отправкиДанных = new SubClass_Klacc_Otprabki_класс_ОтправкиДанных(contextСозданиеБАзы);


                РезультатОтветаОтСервреУспешнаяВставкаИлиОбновления =
                        subClass_klacc_otprabki_класс_отправкиДанных.МетодПосылаетНаСерверСозданныйJSONФайлвФоне(ГенерацияJSONполейФинал, имяТаблицыОтАндройда_локальноая, МенеджерПотоковВнутрений); ////СГЕНЕРИРОВАНЫЙ JSON ФАЙЛ ЕСЛИ БОЛЬШЕ 2 ССИМВОЛОМ В НЕМ ТО ОТПРАВЛЯЕМ
                //

                Log.d(this.getClass().getName(), " РезультатОтветаОтСервреУспешнаяВставкаИлиОбновления  " + РезультатОтветаОтСервреУспешнаяВставкаИлиОбновления);
            }else {
                ///////// TODO ФИНАЛ ПРОСМАТРИВАЕМ СГЕНЕРИРОВАНЫЙ JSON  ФАЙЛ ПОСЛЕ ЦИКЛА DO WHILE СОЗДАИНИЕ НА СТОРОНЕ АНДРОЙДА JSON ПОЛЕЙ
                Log.d(this.getClass().getName(), " НЕТ ДАННЫХ ДЛЯ ОТПРАВКИ  ГенерацияJSONполейФинал  " + ГенерацияJSONполейФинал + " ГенерацияJSONполейФинал " + ГенерацияJSONполейФинал.toString() +
                        " ГенерацияJSONполейФинал.length() " + ГенерацияJSONполейФинал.length());

            }





            /////todo exit cursor
            КурсорДляОтправкиДанныхНаСерверОтАндройда.close();


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл

        }

        //
        return  РезультатОтветаОтСервреУспешнаяВставкаИлиОбновления;
    }


     ///TODO ОТТВЕТ ОТ СЕРВЕРАР ОТ МЕТОДА POST() С РЕЗУЛЬТАТАМИ ВСТАВКИ И ЛИ ОБНОВЛЕНЕИ ДАННЫХ


    /////// данные код анализирует успешные и/ил обновление данных на серврер кторые ему присла пользователь
    void МетодАнализаОтветаОтСервераУспешныеВставкиИлиОбновлениевФоне(String ДанныеПришёлВОтветОтМетодаPOST, String имяТаблицыОтАндройда_локальноая,CompletionService МенеджерПотоковВнутрений) {
        //////

        Log.d(this.getClass().getName(), "  ДанныеПришёлВОтветОтМетодаPOST " + ДанныеПришёлВОтветОтМетодаPOST);


        StringBuffer ОтветОтСервераДляВставки = new StringBuffer();


        try {
            Log.d(this.getClass().getName(), " ДанныеПришёлВОтветОтМетодаPOST             " + ДанныеПришёлВОтветОтМетодаPOST);
/////// данные код анализирует успешные и/ил обновление данных на серврер кторые ему присла пользователь

            ////todo обновление ответной от сервера
            int УспешноеОбновлениеНаСерверe = 0;

            int УспешноеВставкаНаСервере = 0;

            String ВытащилиUUIDИзPOST = "";

            //TODO ОБНОВЛНИЕ
            int УспешныеЛиОтветыОтСервераИлиНет = ДанныеПришёлВОтветОтМетодаPOST.indexOf("::");///TODO если в теле ответа от сервера POSt вообще ::

            if (УспешныеЛиОтветыОтСервераИлиНет > 0) {
                ///////
                for (String ЧтоВнутриПришедшегоПоложитльеногоОбновлениеСесвера : ДанныеПришёлВОтветОтМетодаPOST.split("::")) {
                    /////
                    if (УспешноеОбновлениеНаСерверe == 0) {

                        УспешноеОбновлениеНаСерверe = ЧтоВнутриПришедшегоПоложитльеногоОбновлениеСесвера.indexOf("Обновление");
                    }

                    if (УспешноеВставкаНаСервере == 0) {

                        УспешноеВставкаНаСервере = ЧтоВнутриПришедшегоПоложитльеногоОбновлениеСесвера.indexOf("Вставка");
                    }
                    //////////
                    for (String ЧтоВнутриПришедшегоПоложитльеногоОбновлениеСесвераВнутрений : ЧтоВнутриПришедшегоПоложитльеногоОбновлениеСесвера.split(" ")) {

                        Log.d(this.getClass().getName(), "  ЧтоВнутриПришедшегоПоложитльеногоОбновлениеСесвераВнутрений " + ЧтоВнутриПришедшегоПоложитльеногоОбновлениеСесвераВнутрений);

                        boolean РезультатЯвляетьсяЦифройВесьТекст = МетодОпределениеВселиЦифрыВстроке(ЧтоВнутриПришедшегоПоложитльеногоОбновлениеСесвераВнутрений);

                        Log.d(this.getClass().getName(), " РезультатЯвляетьсяЦифройВесьТекст            " + РезультатЯвляетьсяЦифройВесьТекст);

                        if (РезультатЯвляетьсяЦифройВесьТекст == true) {

                            ВытащилиUUIDИзPOST = ЧтоВнутриПришедшегоПоложитльеногоОбновлениеСесвераВнутрений;
                            ////
                            long РезультатПослеОбновлениеЧерезКонтрейнер = 0;


                            РезультатПослеОбновлениеЧерезКонтрейнер = ОбновлениеДанныхЧерезКонтейнерВозвращениеРезультатаОтСервераУниверсальная(имяТаблицыОтАндройда_локальноая,
                                    Long.parseLong(ВытащилиUUIDИзPOST));
                            /// после обновление  в базу обнуляем контейнер  данные от сервера


/////TODO РЕЗУЛЬТАТА ВСТАВКИ ОТВЕТА ОТ СЕРВРЕ НА КЛИНЕТ ПРИ УСПЕШНОЙ ОБНОВЛЕНИИ ИЛИ ВСТАВКЕ
                            if (РезультатПослеОбновлениеЧерезКонтрейнер > 0) {
                                //todo обявлем успешное встаку
                                if (УспешноеОбновлениеНаСерверe > 0) {


                                    Log.d(this.getClass().getName(), " УспешноеОбновлениеНаСерверe "+ УспешноеОбновлениеНаСерверe);
                                    ///////
                                    УспешноеОбновлениеНаСерверe = 0;

                                    ////TODOECGTI
                                } else if (УспешноеВставкаНаСервере > 0) {

                                    //////
                                    Log.d(this.getClass().getName(), " УспешноеОбновлениеНаСерверe "+ УспешноеОбновлениеНаСерверe);
                                    ////todo после успешной операции обнуяем
                                    УспешноеВставкаНаСервере = 0;
                                }
                                ////TODO метод POST ответ от сервера
                                Log.d(this.getClass().getName(), " УспешноеОбновлениеНаСерверe "+ УспешноеОбновлениеНаСерверe);
                            }
                        }
                    }
                    ////// todo Удаляем из памяти Асинтаск

                }
            }


            //////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }
    }


    ///todo являеться ли весь текст числом
    boolean МетодОпределениеВселиЦифрыВстроке(String ВселиЦифрыВтексе) {
        boolean Результат = false;
        try {
            Long.parseLong(ВселиЦифрыВтексе);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
    ///TODO подсчет часов

    protected int МетодПосчётаЧасовПоСотруднику(Cursor курсор_ЗагружаемТабеляСозданный) {
        int СуммаЧасов = 0;
        if (курсор_ЗагружаемТабеляСозданный.getCount() > 0) {
            курсор_ЗагружаемТабеляСозданный.moveToFirst();
        }
        do {

            for (int ИндексДляИзмененияДней = 1; ИндексДляИзмененияДней < 32; ИндексДляИзмененияДней++) {

                int ИндексЧассыСотрудника = курсор_ЗагружаемТабеляСозданный.getColumnIndex("d" + ИндексДляИзмененияДней);

                int ЧассыСотрудника = курсор_ЗагружаемТабеляСозданный.getInt(ИндексЧассыСотрудника);

                СуммаЧасов = СуммаЧасов + ЧассыСотрудника;

                Log.d(this.getClass().getName(), "    СуммаЧасов " + СуммаЧасов);

            }///TODO END FOR  ПО СТОЛБЦАМ БЕЖИМ

        } while (курсор_ЗагружаемТабеляСозданный.moveToNext());
        ////TODO ПРИСВАИВАЕМ ПОЛУЧЕННЫЕ ЧАСЫ ИЗ БАЗЫ УЖЕ ПЕРЕДЕМ ЕЕ НА АКТИВТИ
        ////todo и ставим курсор на место на первое
        курсор_ЗагружаемТабеляСозданный.moveToFirst();
        return СуммаЧасов;
    }


     ///todo метод подсчёта сотрудниколв их ЧАСЫ
     public String МетодПосчётаЧасовСотрудниковВТабеле(Context КонтекстДляЧасов, long UUIDТабеляПослеУспешногоСозданиеСотрудникаВсехСотридников, int месяцДляПермещенияПоТабелю, int годДляПермещенияПоТабелю) {
         ///////

         String ОбщееКоличествоЛюдейВТабелеТекущемВнутри = null;


         try {
             Cursor Курсор_ЗагружаемТабеляДляПодсчетаЧасов = new Class_MODEL_synchronized(КонтекстДляЧасов).
                     МетодЗагружетУжеготовыеТабеля(КонтекстДляЧасов, UUIDТабеляПослеУспешногоСозданиеСотрудникаВсехСотридников, месяцДляПермещенияПоТабелю, годДляПермещенияПоТабелю);


            //TODO цикл ПЕРЕБОРКИ ДАННЫХ
            ОбщееКоличествоЛюдейВТабелеТекущемВнутри = String.valueOf(new Class_Engine_SQL(КонтекстДляЧасов).
                    МетодПосчётаЧасовПоСотруднику(Курсор_ЗагружаемТабеляДляПодсчетаЧасов));

            Log.d(this.getClass().getName(), "  ОбщееКоличествоЛюдейВТабелеТекущемВнутри " + ОбщееКоличествоЛюдейВТабелеТекущемВнутри);

            Курсор_ЗагружаемТабеляДляПодсчетаЧасов.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName()
                    + " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

        return ОбщееКоличествоЛюдейВТабелеТекущемВнутри;
    }
    //////ТУТ БУДЕТ ЗАПИСЫВАТЬСЯ УСПЕШНОЕ ОБНЛВДЕНИ И ВСТАВКИ ДАННЫХ НА СЕРВЕРЕ ДЛЯ КЛИЕНТА


     /////TODO ЛОКАЛЬНАЯ ОБНОВЛЕНИЕ ВНУТРИ ТАБЕЛЯ

     public Long МетодЛокальноеОбновлениеВТабеле(ContentValues КонтейнерЗаполненияДаннымиПриЛокальномОбновлении,
                                                 String ПолучениеЗначениеСтолбикUUID,
                                                 Context КонтексДляЛокальногоОбновления,
                                                 String таблицаДляЛокальногоОбонвления) throws InterruptedException, ExecutionException, TimeoutException {
         //////


         Integer результатОбновлениеЧерезКонтрейнер = 0;
         ////TODO ДАТА

         try {
             ///////TODO САМ ВЫЗОВ МЕТОДА ОБНОВЛЕНИЕ ЛОКАЛЬНОГО обновление uuid
             результатОбновлениеЧерезКонтрейнер = new Class_Engine_SQL(КонтексДляЛокальногоОбновления).
                     ЛокальногоОбновлениеДанныхЧерезКонтейнерУниверсальная(таблицаДляЛокальногоОбонвления,
                            КонтейнерЗаполненияДаннымиПриЛокальномОбновлении,
                            Long.parseLong(ПолучениеЗначениеСтолбикUUID), "uuid");


            Log.d(this.getClass().getName(),
                    "  результатОбновлениеЧерезКонтрейнер[0] " + результатОбновлениеЧерезКонтрейнер);


        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName()
                    + " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }


        return Long.parseLong(String.valueOf(результатОбновлениеЧерезКонтрейнер));//5,TimeUnit.SECONDS

    }















    //TODO Метод ПОДЧСЧЕТА ЧАСОВ ПО ВСЕМ ТАБЕЛЯМ СРАЗУ
    String МетодДосчётаЧасовПоВсемТабелям(long finalПолученныйUUID, Context КонтекстДЛляПодсчетаЧасовПоВсемТабелям,

                                          int месяцДляПермещенияПоТабелю, int годДляПермещенияПоТабелю) {

         /* return (String) new AsyncTaskLoader(КонтекстДЛляПодсчетаЧасовПоВсемТабелям) {
              @Override
              public Object loadInBackground() {*/
        String ПолученыеСуммаЧасовСотрудникаВнутри = null;
        try {
            //TODO вытастиваем непостредственный табель для которго и нужно посчитать часы
            Cursor Курсор_ЗагружаемТабеляДляПодсчетаЧасовПовсемТАбелям = new Class_MODEL_synchronized(КонтекстДЛляПодсчетаЧасовПоВсемТабелям).
                    МетодЗагружетУжеготовыеТабеля(КонтекстДЛляПодсчетаЧасовПоВсемТабелям, finalПолученныйUUID, месяцДляПермещенияПоТабелю, годДляПермещенияПоТабелю);


            //TODO Считаем Сумму часов по всем табелям
            ПолученыеСуммаЧасовСотрудникаВнутри = String.valueOf(new Class_Engine_SQL(КонтекстДЛляПодсчетаЧасовПоВсемТабелям).
                    МетодПосчётаЧасовПоСотруднику(Курсор_ЗагружаемТабеляДляПодсчетаЧасовПовсемТАбелям));



        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    /*              return ПолученыеСуммаЧасовСотрудникаВнутри;
              }
          }.loadInBackground();
      }*/

        return ПолученыеСуммаЧасовСотрудникаВнутри;

    }











    ///todo АНАЛИЗ UUID
    Integer МетодАнализаUUIDиID_ОбаТутОборабоатыаем_СинхрониазциявФоне(@NotNull Long UUIDПолученныйИзПришедшегоJSON,
                                               String JSON_ИмяСтолбца,
                                               String JSON_ИмяСодержимое,
                                               String имяТаблицыОтАндройда_локальноая,
                                               CompletionService МенеджерПотоковВнутрений
            ,Integer ИндексТекущееСтрочкиДляКонтейнераВставки,
    String ПолеЧерезКотороеСостываваемОбновлениеДанных)
            throws ExecutionException, InterruptedException, TimeoutException {



        Integer РезультатЕстьUUIDОБАIDилНет=0;
        ///////

        try {


            ////// TODO ИЗ ПРАВИЛА ЧТО НЕЛЬЗЯ ОБНОЛВЛЯТЬ ПОЕЛ UUID ПРОПУСКАЕМ ЕГО ЭТО КОГДА СТОЛБИК ID ПРОПУСКАЕМ


//////наобород
//////наобород
            switch (имяТаблицыОтАндройда_локальноая.trim().toLowerCase()) {

                case "tabels":
                case "chats":
                case "data_chat":
                case "chat_users":
                case "fio":
                case "tabel":
                case "data_tabels":
                    //
                    System.out.println("  КлючJsonСтроки  " + JSON_ИмяСтолбца+ " ПолеЧерезКотороеСостываваемОбновлениеДанных " +ПолеЧерезКотороеСостываваемОбновлениеДанных+
                            " JSON_ИмяСтолбца "+JSON_ИмяСтолбца);


                    if (JSON_ИмяСтолбца.contentEquals("id")) {
// TODO: 25.02.2022

                        JSON_ИмяСтолбца="_id";
                    }



                    if (ПолеЧерезКотороеСостываваемОбновлениеДанных.equalsIgnoreCase("id")) {
                        // TODO: 25.02.2022



                        ПолеЧерезКотороеСостываваемОбновлениеДанных="_id";
                    }
                    //
                        System.out.println("  КлючJsonСтроки  " + JSON_ИмяСтолбца
                                +" ПолеЧерезКотороеСостываваемОбновлениеДанных " +ПолеЧерезКотороеСостываваемОбновлениеДанных);


                    break;

                // TODO: 25.02.2022
                default:
                    //
                    System.out.println("  КлючJsonСтроки  " + JSON_ИмяСтолбца
                            +" ПолеЧерезКотороеСостываваемОбновлениеДанных " +ПолеЧерезКотороеСостываваемОбновлениеДанных);
                    break;

            }


            ///


            System.out.println("  JSON_ИмяСтолбца  " + JSON_ИмяСтолбца + " имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);


/////

            ////
            ////todo  ПЫТАЕМСЯ ОРГАНИЗОВАТЬ ОБНОВЛЕНИЕ НО ТОЛЬКО ЕСЛИ ВЛАГ  TRUE


            ///
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаUUIDобваID.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций
                    .put("НазваниеОбрабоатываемойТаблицы", имяТаблицыОтАндройда_локальноая);
            ///////
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаUUIDобваID.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки",
                    ПолеЧерезКотороеСостываваемОбновлениеДанных);
            //
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаUUIDобваID.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", ПолеЧерезКотороеСостываваемОбновлениеДанных+"=? ");
            ///"_id > ?   AND _id< ?"
            //////
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаUUIDобваID
                    .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", UUIDПолученныйИзПришедшегоJSON);
            ///
   /*         class_grud_sql_operationsАнализаUUIDСинхрониазциявФоне. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФоне. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФоне. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......

            ////TODO другие поля

            ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
            ////
            //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
            ////
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФоне. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
            ////*/
            /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

            SQLiteCursor Курсор_УзнатьЕслиНаАндройдеТакойUUID = null;


            ///////
            Log.d(this.getClass().getName(), "ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде " +
                    ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде + " имяТаблицыОтАндройда_локальноая " +имяТаблицыОтАндройда_локальноая);


             if(имяТаблицыОтАндройда_локальноая.equalsIgnoreCase("settings_tabels")){

                 // TODO: 22.02.2022
                 ///////
                 Log.d(this.getClass().getName(), "ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде " +
                         ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде + " имяТаблицыОтАндройда_локальноая " +имяТаблицыОтАндройда_локальноая+"" +
                         " КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал " +КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);

                 // TODO: 22.02.2022
                 //////
                 Курсор_УзнатьЕслиНаАндройдеТакойUUID = (SQLiteCursor) class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаUUIDобваID.
                         new GetData(contextСозданиеБАзы).getdata(class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаUUIDобваID.
                         concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций, МенеджерПотоковВнутрений, Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

                 ///////
                 Log.d(this.getClass().getName(), "ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде " +
                         ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде + " имяТаблицыОтАндройда_локальноая " +имяТаблицыОтАндройда_локальноая+"" +
                         " КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал " +КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);


                 // TODO: 22.02.2022  
             }else{
                 
                 
                 // TODO: 22.02.2022  заходим в код елси не первый запуск синхрониазции

                 if (ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде == null &&
                         КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал.equalsIgnoreCase("ПовторныйЗапускСинхронизации")) {
                     //////
                     Курсор_УзнатьЕслиНаАндройдеТакойUUID = (SQLiteCursor) class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаUUIDобваID.
                             new GetData(contextСозданиеБАзы).getdata(class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаUUIDобваID.
                             concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций, МенеджерПотоковВнутрений, Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);


                     ///////
                     Log.d(this.getClass().getName(), " Курсор_УзнатьЕслиНаАндройдеТакойUUID " + Курсор_УзнатьЕслиНаАндройдеТакойUUID + "ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде " +
                             ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде+
                             " КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал " +КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);

                 }



                Log.d(this.getClass().getName(), "GetData " +Курсор_УзнатьЕслиНаАндройдеТакойUUID );
            }




            //TODO  влавное мы тут и узнаем если тако йUUID или нет


            if (Курсор_УзнатьЕслиНаАндройдеТакойUUID!=null ) {
                // TODO: 22.02.2022
                if (Курсор_УзнатьЕслиНаАндройдеТакойUUID.getCount() > 0) {
                    ///
                    //////
                    Курсор_УзнатьЕслиНаАндройдеТакойUUID.moveToFirst();


                    ///
                    ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде = Курсор_УзнатьЕслиНаАндройдеТакойUUID.getString(0).trim();
                    ///////
                    Log.d(this.getClass().getName(), " ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде " + ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде);


                    ////////
                    Log.d(this.getClass().getName(), " UUIDПолученныйИзПришедшегоJSON "  + " Курсор_УзнатьЕслиНаАндройдеТакойUUID.getCount()  "
                            + Курсор_УзнатьЕслиНаАндройдеТакойUUID.getCount());

                    UUIDПолеУжеПроверелиЧерезКурсор = true;
                }
            }


            // TODO: 31.10.2021
            if (Курсор_УзнатьЕслиНаАндройдеТакойUUID!=null ) {
                // TODO: 24.02.2022
                Курсор_УзнатьЕслиНаАндройдеТакойUUID.close();
            }


/*
            ////////TODO _old

            Курсор_УзнатьЕслиНаАндройдеТакойUUID = КурсорУниверсальныйДляБазыДанных(имяТаблицыОтАндройда_локальноая,
                    new String[]{"uuid"}, "uuid=?", new String[]{UUIDПолученныйИзПришедшегоJSON}, null, null,
                    null, null);//"SuccessLogin", "date_update","id=","1",null,null,null,null
*/


            ////////



            /////
            if (  UUIDПолеУжеПроверелиЧерезКурсор==true) {
                /////
                ///
                РезультатЕстьUUIDОБАIDилНет++;





                Log.d(this.getClass().getName(), " JSON_ИмяСтолбца " + JSON_ИмяСтолбца + " JSON_ИмяСодержимое " + JSON_ИмяСодержимое);
                //////МЕТОДКОТРЫЙ ПРИ ОТСТВИИИ UUID ЕГО ГЕНЕРИРЕТ НА ПРИШЕЛДХИ ДАННЫХ

                /////второе условие чтобы uuid не вставлем тоже


                if ( !JSON_ИмяСодержимое.contentEquals("null")  ) {
                    /// TODO ТУТ ПРОИЗВОДИТЬСЯ ОБНОВЛЕНИЕ ДАННЫХ
                    АдаптерПриОбновленияДанныхсСервера.put(JSON_ИмяСтолбца, JSON_ИмяСодержимое);////заполняем контрейнер обнолвеними
                }

                ////
                Log.d(this.getClass().getName(), " Курсор_УзнатьЕслиНаАндройдеТакойUUID " + Курсор_УзнатьЕслиНаАндройдеТакойUUID + " АдаптерПриОбновленияДанныхсСервера.size() "
                        + АдаптерПриОбновленияДанныхсСервера.size());


                ///TODO ВСТАВКА ЧЕРЕЗ UUID     ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID
            } else {
                ///TODO ВСТАВКА ЧЕРЕЗ UUID     ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID     ///TODO ВСТАВКА ЧЕРЕЗ ID


                if (! JSON_ИмяСодержимое.contentEquals("null")  ) {

                    // TODO: 17.02.2022
                    АдаптерДляВставкиДанныхсСервер.put(JSON_ИмяСтолбца, JSON_ИмяСодержимое);

                }
                Log.d(this.getClass().getName(), " АдаптерДляВставкиДанныхсСервер UUID " + АдаптерДляВставкиДанныхсСервер.size()+ " имяТаблицыОтАндройда_локальноая " +имяТаблицыОтАндройда_локальноая);

            }


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

        // TODO: 14.09.2021 Результат Контейнер
        Log.d(this.getClass().getName(), "  РезультатЕстьUUIDОБАIDилНет " + РезультатЕстьUUIDОБАIDилНет);


        return  РезультатЕстьUUIDОБАIDилНет;


    }


////////















    ///////todo АНАЛИХ ID
    Integer МетодАнализаIDСинхрониазциивФоне(String JSON_ИмяСтолбца, String JSON_ИмяСодержимое,
                                             String имяТаблицыОтАндройда_локальноая, String IDИзПришедшегоJSON,
                                             CompletionService МенеджерПотоковВнутрений,Integer ИндексТекущееСтрочкиДляКонтейнераВставки) throws ExecutionException, InterruptedException, TimeoutException {



        Integer  ЕстьIDДляЭтойЗаписиИлиНет=0;
        ////////


        try {

            String ИндификаторДляIDВзависмостиОтТаблицы = "id";
            ///
//////наобород
            switch (имяТаблицыОтАндройда_локальноая.trim().toLowerCase()) {

                case "tabels":
                case "chats":
                case "data_chat":
                case "chat_users":
                case "fio":
                case "tabel":
                case "data_tabels":
                    //
                    System.out.println("  КлючJsonСтроки  " + JSON_ИмяСтолбца);

                    ИндификаторДляIDВзависмостиОтТаблицы = "_id";

                    if (JSON_ИмяСтолбца.equals("id")) {
                        //TODO сам столбиц
                        JSON_ИмяСтолбца = ИндификаторДляIDВзависмостиОтТаблицы;
                    }

                    break;
            }

            ///


            System.out.println("  JSON_ИмяСтолбца  " + JSON_ИмяСтолбца + " ИндификаторДляIDВзависмостиОтТаблицы " + ИндификаторДляIDВзависмостиОтТаблицы);



            ////todo  ПЫТАЕМСЯ ОРГАНИЗОВАТЬ ОБНОВЛЕНИЕ НО ТОЛЬКО ЕСЛИ ВЛАГ  TRUE

            SQLiteCursor   SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID=null;

// TODO: 06.09.2021  start new ende



            ///
            ///
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаID. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы",имяТаблицыОтАндройда_локальноая);
            ///////
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаID. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки",ИндификаторДляIDВзависмостиОтТаблицы);
            //
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаID. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика",ИндификаторДляIDВзависмостиОтТаблицы+"=? ");
            ///"_id > ?   AND _id< ?"
            //////
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаID. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",IDИзПришедшегоJSON);
            ///
   /*         class_grud_sql_operationsАнализаUUIDСинхрониазциявФоне. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФоне. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФоне. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......

            ////TODO другие поля

            ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
            ////
            //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
            ////
            class_grud_sql_operationsАнализаUUIDСинхрониазциявФоне. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
            ////*/
            /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
            if(имяТаблицыОтАндройда_локальноая.equalsIgnoreCase("settings_tabels")){

                // TODO: 22.02.2022
                ///////
                Log.d(this.getClass().getName(), "ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде " +
                        ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде + " имяТаблицыОтАндройда_локальноая " +имяТаблицыОтАндройда_локальноая+"" +
                        " КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал " +КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);

                // TODO: 22.02.2022
                //////
                SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID = (SQLiteCursor) class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаID.
                        new GetData(contextСозданиеБАзы).getdata(class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаID.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций, МенеджерПотоковВнутрений, Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

                ///////
                Log.d(this.getClass().getName(), "ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде " +
                        ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде + " имяТаблицыОтАндройда_локальноая " +имяТаблицыОтАндройда_локальноая+"" +
                        " КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал " +КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);


                // TODO: 22.02.2022
            }else{


                // TODO: 22.02.2022  заходим в код елси не первый запуск синхрониазции

                if (ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде == null &&
                        КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал.equalsIgnoreCase("ПовторныйЗапускСинхронизации")) {
                    //////
                    SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID = (SQLiteCursor) class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаID.
                            new GetData(contextСозданиеБАзы).getdata(class_grud_sql_operationsАнализаUUIDСинхрониазциявФонеДЛяАнализаID.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций, МенеджерПотоковВнутрений, Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);


                    ///////
                    Log.d(this.getClass().getName(), " Курсор_УзнатьЕслиНаАндройдеТакойUUID " + SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID + "ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде " +
                            ДействительноЛиUUIDКоторыйПришелсСервераУжеЕстьНаАндройде+
                            " КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал " +КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторнаяФинал);

                }




                Log.d(this.getClass().getName(), "GetData "+SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID   );
            }




//TODO ГЛАВНОЕ МЫ ТУТ ПРОВЕРЯЕМ ЕСЛИ ID  ОБНОВЛЯТЬ И ЛИ ВСТАВЛЯТЬ ОПЕРАЦУИЮ ПРОИЗВОДИТЬ О КАК ПО ПРИШЕДШЕМУ ID
            if (SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID!=null ) {

                // TODO: 22.02.2022
                if ( SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID.getCount() > 0) {

                    //////////
                    SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID.moveToFirst();

                    ДействительноЛиIDКоторыйПришелсСервераУжеЕстьНаАндройде = SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID.getString(0);
                    Log.d(this.getClass().getName(), "ДействительноЛиIDКоторыйПришелсСервераУжеЕстьНаАндройде" + ДействительноЛиIDКоторыйПришелсСервераУжеЕстьНаАндройде);


                    ////////
                    Log.d(this.getClass().getName(), " Курсор_УзнатьЕслиНаАндройдеТакойID.getCount() " + SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID.getCount() +
                            " IDИзПришедшегоJSON " + IDИзПришедшегоJSON);

                    IDПолеУжеПроверелиЧерезКурсор=true;

                }
            }


            // TODO: 31.10.2021
            SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID.close();

/*
            // TODO: 06.09.2021  _old
            //////
            Курсор_УзнатьЕслиНаАндройдеТакойID = КурсорУниверсальныйДляБазыДанных(имяТаблицыОтАндройда_локальноая,
                    new String[]{ИндификаторДляIDВзависмостиОтТаблицы}, ИндификаторДляIDВзависмостиОтТаблицы + "=?", new String[]{IDИзПришедшегоJSON}, null, null,
                    null, null);//"SuccessLogin", "date_update","id=","1",null,null,null,null
*/

///////



            ///
            if ( IDПолеУжеПроверелиЧерезКурсор==true) {
                //


                ЕстьIDДляЭтойЗаписиИлиНет++;


                Log.d(this.getClass().getName(), " JSON_ИмяСтолбца " + JSON_ИмяСтолбца + " JSON_ИмяСодержимое " + JSON_ИмяСодержимое);
                //////МЕТОДКОТРЫЙ ПРИ ОТСТВИИИ UUID ЕГО ГЕНЕРИРЕТ НА ПРИШЕЛДХИ ДАННЫХ

                /////второе условие чтобы uuid не вставлем тоже


                ////// TODO ИЗ ПРАВИЛА ЧТО НЕЛЬЗЯ ОБНОЛВЛЯТЬ ПОЕЛ UUID ПРОПУСКАЕМ ЕГО ЭТО КОГДА СТОЛБИК ID ПРОПУСКАЕМ

                if ( !JSON_ИмяСодержимое.contentEquals("null")  ) {
                    ///TODO ОБНОВЛЕНИЕ ЧЕРЕЗ ID          ///TODO ОБНОВЛЕНИЕ ЧЕРЕЗ ID          ///TODO ОБНОВЛЕНИЕ ЧЕРЕЗ ID          ///TODO ОБНОВЛЕНИЕ ЧЕРЕЗ ID          ///TODO ОБНОВЛЕНИЕ ЧЕРЕЗ ID
                    АдаптерПриОбновленияДанныхсСервера.put(JSON_ИмяСтолбца, JSON_ИмяСодержимое);////заполняем контрейнер обнолвеними

                    ////
                }
                Log.d(this.getClass().getName(), " Курсор_УзнатьЕслиНаАндройдеТакойUUID " + SQLiteCursorКурсор_УзнатьЕслиНаАндройдеТакойID + " АдаптерПриОбновленияДанныхсСервера.size() "
                        + АдаптерПриОбновленияДанныхсСервера.size());


                ///TODO ВСТАВКА ЧЕРЕЗ ID       ///TODO ВСТАВКА ЧЕРЕЗ ID
            } else {
                ///TODO ВСТАВКА ЧЕРЕЗ ID

                if ( !JSON_ИмяСодержимое.contentEquals("null")  ) {

                    АдаптерДляВставкиДанныхсСервер.put(JSON_ИмяСтолбца, JSON_ИмяСодержимое);

                }
                Log.d(this.getClass().getName(), " АдаптерДляВставкиДанныхсСервер ID " + АдаптерДляВставкиДанныхсСервер.size());


                /////
            }//todo end     ///////TODO КОГДА ЕСТЬ ТОЛЬКО ID ШНИК ОБНОВЛЕНИЕ




        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }/*finally {
            if (Курсор_УзнатьЕслиНаАндройдеТакойID != null) {
                if(!Курсор_УзнатьЕслиНаАндройдеТакойID.isClosed()){
                    //
                    Курсор_УзнатьЕслиНаАндройдеТакойID.close();
                }
            }
        }*/
        // TODO: 14.09.2021 Результат Контейнер

        return  ЕстьIDДляЭтойЗаписиИлиНет;
    }




































    // TODO: 13.09.2021 МЕТОД ОЧИСТКИ ТАБЛИЦ
    public void МетодОчищаемИзБазыNULLЗначенияя(CompletionService МенеджерПотоковВнутрений) {


        Class_GRUD_SQL_Operations class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя;

        Long РезультатУдалениеОчисткиТаблиц=0l;
        try {

            // TODO: 26.03.2021 ДОПОЛНИТЕЛЬНО ОБНУЛЯЕМ ВСЕ ТАБЕЛЯ С NULL В ФИО ЧТО БЫ ОБМЕН НЕ РУГАЛЬСЯ
            //  ССылкаНаСозданнуюБазу.

            ////
            class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);
            ///
            class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);


            LinkedBlockingQueue<String> linkedBlockingQueueДляУдалениеТаблиц= new LinkedBlockingQueue();

            linkedBlockingQueueДляУдалениеТаблиц.put("fio");
            ////
            linkedBlockingQueueДляУдалениеТаблиц.put("cfo");
            ////
            linkedBlockingQueueДляУдалениеТаблиц.put("tabels");
            ////
            linkedBlockingQueueДляУдалениеТаблиц.put("fio");
            ////
            linkedBlockingQueueДляУдалениеТаблиц.put("tabels");
            ////
            Iterator<String> iteratorДляУдалениеНазваниеТаблиц
                    =linkedBlockingQueueДляУдалениеТаблиц.iterator();

            ////
            ArrayList<String> arrayListСтобцыДляУдаления=new ArrayList();


            while (iteratorДляУдалениеНазваниеТаблиц.hasNext()){
                ////
                String ТекущаяНазваниеТаблицыДляУдаления=iteratorДляУдалениеНазваниеТаблиц.next();
                //
                Log.d(this.getClass().getName(), "ТекущаяНазваниеТаблицыДляУдаления"+
                        ТекущаяНазваниеТаблицыДляУдаления);

                //
                switch (ТекущаяНазваниеТаблицыДляУдаления.trim()){

                    case "tabels":
                        //

                        arrayListСтобцыДляУдаления.add("fio");//
                        //
                        arrayListСтобцыДляУдаления.add("cfo");//
                        ///
                        arrayListСтобцыДляУдаления.add("nametabel_typename");//
                        ////
                        arrayListСтобцыДляУдаления.add("uuid");//




                        ///TODO ОБНОЛВЕНИЕ
                        for (int i = 0; i < arrayListСтобцыДляУдаления.size(); i++) {


                            // TODO: 06.09.2021  ПАРАМЕНТЫ ДЛЯ ОБНОВЛЕНИЯ

                            class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","tabels");
                            //

                            class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("Флаг_ЧерезКакоеПолеУдаление", arrayListСтобцыДляУдаления.get(i)+" IS NULL");
                            ///

                            class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗнакФлагУдаление","=");


                            ///TODO РЕЗУЛЬТАТ ОБНОВЛЕНИЕ ДАННЫХ


                            РезультатУдалениеОчисткиТаблиц= (Long)  class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя.
                                    new DeleteData(contextСозданиеБАзы).deletedata(class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,МенеджерПотоковВнутрений,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

                            ///
                            ///
                            Log.d(contextСозданиеБАзы.getClass().getName(), " РезультатУдалениеОчисткиТаблиц" + "--" + РезультатУдалениеОчисткиТаблиц);/////

                        }

                        // TODO: 06.09.2021  clsear
                        arrayListСтобцыДляУдаления.clear();

           /*                 // TODO: 06.09.2021  _old

                            ССылкаНаСозданнуюБазу.execSQL("DELETE FROM tabels   WHERE fio IS NULL");

                            ССылкаНаСозданнуюБазу.execSQL("DELETE FROM tabels   WHERE cfo IS NULL");

                            ССылкаНаСозданнуюБазу.execSQL("DELETE FROM tabels   WHERE nametabel_typename IS NULL");

                            ССылкаНаСозданнуюБазу.execSQL("DELETE FROM tabels   WHERE uuid IS NULL");*/


                        break;
///////
                    case "fio":
                        //
                        arrayListСтобцыДляУдаления.add("uuid");//
                        //
                        ///TODO ОБНОЛВЕНИЕ
                        for (int i = 0; i < arrayListСтобцыДляУдаления.size(); i++) {


                            // TODO: 06.09.2021  ПАРАМЕНТЫ ДЛЯ ОБНОВЛЕНИЯ

                            class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","fio");
                            //

                            class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("Флаг_ЧерезКакоеПолеУдаление", arrayListСтобцыДляУдаления.get(i)+" IS NULL");
                            ///

                            class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗнакФлагУдаление","=");


                            ///TODO РЕЗУЛЬТАТ ОБНОВЛЕНИЕ ДАННЫХ


                            РезультатУдалениеОчисткиТаблиц= (Long) class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя.
                                    new DeleteData(contextСозданиеБАзы).deletedata(class_grud_sql_operationsОчищаемИзБазыNULLЗначенияя. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,МенеджерПотоковВнутрений,Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);

                            ///
                            ///
                            Log.d(contextСозданиеБАзы.getClass().getName(), " РезультатУдалениеОчисткиТаблиц" + "--" + РезультатУдалениеОчисткиТаблиц);/////

                        }

                        // TODO: 06.09.2021  clsear
                        arrayListСтобцыДляУдаления.clear();
                        // TODO: 06.09.2021   _old
/*
                            ССылкаНаСозданнуюБазу.execSQL("DELETE FROM fio   WHERE uuid IS NULL");*/

                        break;
///////

                }


                // TODO: 13.09.2021 выкидываем из очереди после обработки

                linkedBlockingQueueДляУдалениеТаблиц.peek();

            }


            Log.d(this.getClass().getName(), "Удаление даных перед Синхронизацией NULL значения ");

            ///////todo\
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }









/*    // TODO: 05.07.2021 код запуска метода для данных

    protected Long МетодЗапускаСинхронизацииПередСозданеимНовгоСообщенияДляЧата(Context context) {
        //
        Long РезультатСинхронизацииДОСозданиеЯСообщения = 0l;

        try {

            Log.d(this.getClass().getName(), "  МетодЗаписиНовгоСообщенияСамимКлиентом");


            /////TODO ВТОРОЙ ШАГ СИНХРОНИЗАЦИИ ПОЛУЧАЕМ СПИСОК ТАБЛИЦ КОТОРЫЕ НУЖНО  СИНХРОНИЗИРОВАТЬ 100% процентов , И ПРОВЕРМЯЕМ ЕСЛИ СВЯЗЬ С ИНТЕНТОМ

            boolean РезультатЕслиСвязьСерверомДСУ = false;

            РезультатЕслиСвязьСерверомДСУ =new Class_Connections_Server(context).МетодПингаСервераРаботаетИлиНет(context);

            //TODO ФУТУРЕ ЗАВЕРШАЕМ
            Log.d(this.getClass().getName(), "  РезультатЕслиСвязьСерверомДСУ " + РезультатЕслиСвязьСерверомДСУ);


            // TODO: 29.04.2021 вуключаем

            ////TODO ТОЛЬКО ПРИ НАЛИЧИИ ИНТРЕНТА  !!!!!!!!!!!!!!!! ЗАПУСК СИНХРОНИЗАЦИИ

            if (РезультатЕслиСвязьСерверомДСУ == true) {

*//*

                РезультатСинхронизацииДОСозданиеЯСообщения = new Class_Engine_SQL(context).
                        МетодЗАпускаФоновойСинхронизацииДляТабеляиДляЧата(context, "СинхронизацияДляЧата", true,ActivityДляСинхронизацииОбмена,null);
*//*



             РезультатСинхронизацииДОСозданиеЯСообщения=         new Class_Engine_SQL(context).
                        МетодЗАпускаФоновойСинхронизации(context, "СинхронизацияДляЧата", true,ActivityДляСинхронизацииОбмена,null,"ПовторныйЗапускСинхронизации");//"СамыйПервыйЗапускСинхронизации"



                ///
                Log.w(this.getClass().getName(), "МетодЗапускаЛокальнойСинхронизации() СЛУЖБА синхронизации запускаем через  getApplication()  СЛУЖБА фоновая СИНХРОНИЗАЦИЯ" + РезультатСинхронизацииДОСозданиеЯСообщения);

            }

            ///
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());

// TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(КонтекстСинхроДляКонтроллераВФоне).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

        }
        return РезультатСинхронизацииДОСозданиеЯСообщения;
    }
// TODO: 27.07.2021 для чата*/

































































































//todo  ПОД КЛАСС  С ГЛАВНМ ЦИКЛОМ ОБМЕНА ДАННЫМИ ТАБЛИЦЫ

//todo  ПОД КЛАСС  С ГЛАВНМ ЦИКЛОМ ОБМЕНА ДАННЫМИ ТАБЛИЦЫ

     private class Class_Engine_SQL_SubClassMainLoopAsyncTables_КлассСГлавнымЦикломСинхрониазцииТАблиц extends Class_Engine_SQL {


         SQLiteDatabase  Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы=null;

         PUBLIC_CONTENT  public_contentДатыДляГлавныхТаблицСинхронизации;

         Integer ГлавноеКоличествоОбрабоатываемыхТаблицОбменаССервером;

         Activity ActivityДляСинхронизацииОбмена;

         public Class_Engine_SQL_SubClassMainLoopAsyncTables_КлассСГлавнымЦикломСинхрониазцииТАблиц(@NotNull Context context,
                                                                                                    SQLiteDatabase Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы
                 , PUBLIC_CONTENT  public_contentДатыДляГлавныхТаблицСинхронизации,
                                                                                                    Integer ГлавноеКоличествоОбрабоатываемыхТаблицОбменаССервером
                 , Activity ActivityДляСинхронизацииОбмена)
                 throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
             super(context);

             this.Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы=Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы;

             // TODO: 23.01.2022
             this.public_contentДатыДляГлавныхТаблицСинхронизации= public_contentДатыДляГлавныхТаблицСинхронизации;

             this.ГлавноеКоличествоОбрабоатываемыхТаблицОбменаССервером = ГлавноеКоличествоОбрабоатываемыхТаблицОбменаССервером;


             this.ActivityДляСинхронизацииОбмена=ActivityДляСинхронизацииОбмена;


             /// ТУТ МЫ ЗАПУСКАЕМ ЦИКЛ С ПОЛУЧЕНЫМИ ДО  ЭТГО ТАБЛИЦАП КОНКРЕТНО ДЛЯ  ЭТОГО ПОДЛЬЗОВАТЛЯ
             Log.i(this.getClass().getName(), " Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы " + Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы
                     + " public_contentДатыДляГлавныхТаблицСинхронизации= "
                     + public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда+
                     " СколькоСтрочекJSON " + ГлавноеКоличествоОбрабоатываемыхТаблицОбменаССервером +" ActivityДляСинхронизацииОбмена" +ActivityДляСинхронизацииОбмена);

         }

         Integer МетодГлавныхЦиклТаблицДляСинхронизации(String ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                                        String КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная) throws ExecutionException, InterruptedException {//КонтекстСинхроДляКонтроллера

             final Integer[] РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри = {0};


             try {

                 /// ТУТ МЫ ЗАПУСКАЕМ ЦИКЛ С ПОЛУЧЕНЫМИ ДО  ЭТГО ТАБЛИЦАП КОНКРЕТНО ДЛЯ  ЭТОГО ПОДЛЬЗОВАТЛЯ
                 Log.i(this.getClass().getName(), " ИменаТаблицыОтАндройда " + public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда.toString()
                         + " ДатыТаблицыВерсииДанныхОтСервера "
                         + public_contentДатыДляГлавныхТаблицСинхронизации.ДатыТаблицыВерсииДанныхОтСервера.toString()
                         + " СколькоСтрочекJSON " + ГлавноеКоличествоОбрабоатываемыхТаблицОбменаССервером);
                 ////TODO настройки поо расширению количесво потоков в момент выполенния
                 ////TODO текущая ТАБЛИЦА ПРИ ОБРАБОТКИ СИНХРОНИЗАЦИИ КОТОРАЯ УВЕЛИЧИВАЕТЬСЯ В ЦИКДЕ ПРИ ОБМЕНЕН
                 //////TODO выводими обратно в UI вставка

                 /////todo КОНЕЦ цикла фор
                 ////////


                 Log.i(this.getClass().getName(), "  Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы " + Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы);


                 //ВСЕГДА СНАРУЖИ
                 final Integer[] КоличествоТаблицВОбработке = {1};//

                 ПубличныйРезультатОтветаОтСерврераУспешно = 0;


                 // TODO: 14.10.2021  НАЧИНАЕМ ОБРАБОТКУ ТАБЛИЦ  ГОАВНЫЙ ЦЫКЛ ПРОЕКТА ОБРАБОТКА ВСЕХ ТАБЛИЦ ДЛЯ СИНХРОНИАЗЦИИ
                 // TODO: 14.10.2021  НАЧИНАЕМ ОБРАБОТКУ ТАБЛИЦ  ГОАВНЫЙ ЦЫКЛ ПРОЕКТА ОБРАБОТКА ВСЕХ ТАБЛИЦ ДЛЯ СИНХРОНИАЗЦИИ
                 // TODO: 14.10.2021  НАЧИНАЕМ ОБРАБОТКУ ТАБЛИЦ  ГОАВНЫЙ ЦЫКЛ ПРОЕКТА ОБРАБОТКА ВСЕХ ТАБЛИЦ ДЛЯ СИНХРОНИАЗЦИИ
                 // TODO: 14.10.2021  НАЧИНАЕМ ОБРАБОТКУ ТАБЛИЦ  ГОАВНЫЙ ЦЫКЛ ПРОЕКТА ОБРАБОТКА ВСЕХ ТАБЛИЦ ДЛЯ СИНХРОНИАЗЦИИ

                 // TODO: 14.10.2021  НАЧИНАЕМ ОБРАБОТКУ ТАБЛИЦ  ГОАВНЫЙ ЦЫКЛ ПРОЕКТА ОБРАБОТКА ВСЕХ ТАБЛИЦ ДЛЯ СИНХРОНИАЗЦИИ


                 Observable observableГлавныйЦиклСинхрониазацииПрограммыТабельныйУчёт = Observable.fromIterable(public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда)
                         .subscribeOn(Schedulers.computation())
                         .flatMapStream(new Function<String, Stream<?>>() {
                             @Override
                             public Stream<?> apply(String ТекущаяТаблицаИзПотока) throws Throwable {
                                 // TODO: 13.01.2022 start test code
                                 Log.i(this.getClass().getName(), " public_contentМенеджерПотоковВнутрений.МенеджерПотоков " + public_contentДатыДляГлавныхТаблицСинхронизации.МенеджерПотоков + "\n" +
                                         " ТекущаяТаблицаИзПотока " + ТекущаяТаблицаИзПотока);

                                 // TODO: 22.11.2021 НАЧАЛО ГЛАВНОГО КОДА ЦИКЛА


                                 // TODO: 05.11.2021 ВНУТРИ ВСЕГДА
                                 ИндексТекущейОперацииРеальногРезультатОбработкиАтблицы = 0;


                                 //////todo ДВИГАЕМСЯ ПО ТАБЛИЦАМ


                                 Log.w(this.getClass().getName(), " ПЕРЕД ОБРАБОТКЙОЙ ВСЕХ ТАБЛИЦ ДОЛЖНА БЫТЬ ОТКРЫТОЙ ОБРАБОТКИ ВСЕХ ТАБЛИЦ Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы.isOpen() "
                                         + Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы.isOpen());


                                 // TODO: 24.12.2021  САМЫЙ ГЛАВНЫЙ ЦИКЛ ОБРАБОТКИ ТАБЛИЦ СИНХРОНИАЗЦИИ         // TODO: 24.12.2021  САМЫЙ ГЛАВНЫЙ ЦИКЛ ОБРАБОТКИ ТАБЛИЦ СИНХРОНИАЗЦИИ


                                 try {

                                     ////// TODO ГЛАВНЫЙ ПЕРВЫЙ ЦИКЛ ОБМЕНА ДАННЫХ в фоне         //////ГЛАВНЫЙ ПЕРВЫЙ ЦИКЛ ОБМЕНА ДАННЫХ         //////ГЛАВНЫЙ ПЕРВЫЙ ЦИКЛ ОБМЕНА ДАННЫХ
                                     //////
                                     // TODO: 30.03.2021 синхронизация в фоне


                                     Log.d(this.getClass().getName(), " ИменаТаблицыОтАндройда " + public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда.size() +
                                             " ТекущаяТаблицаИзПотока " + ТекущаяТаблицаИзПотока + " СколькоСтрочекJSON  " + ГлавноеКоличествоОбрабоатываемыхТаблицОбменаССервером);
                                     //////

                                     String ТекущаяТаблицаДляОБменаДанными = (String) ТекущаяТаблицаИзПотока;


                                     Log.d(this.getClass().getName(), " ТекущаяТаблицаДляОБменаДанными главный цикл " + ТекущаяТаблицаДляОБменаДанными + "\n" +
                                             " ФлагКакуюЧастьСинхронизацииЗапускаем " + ФлагКакуюЧастьСинхронизацииЗапускаем + "\n" +
                                             "\n" + " Thread.currentThread().getName() " + Thread.currentThread().getName() + "\n" + "############################################################" + "\n");

                                     // TODO: 24.01.2022
                                     if(ГлавноеКоличествоОбрабоатываемыхТаблицОбменаССервером ==null){
                                         ГлавноеКоличествоОбрабоатываемыхТаблицОбменаССервером =0;
                                     }
                                     // TODO: 27.10.2021  запуск синхрониазции только по условию  ВСЕ ДРУГИЕ ТАБЛИЦЫ КРОМЕ ТАБЛИЧ ЧАТА


                                     // TODO: 27.10.2021  запуск синхрониазции только по условию
                                     РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри[0] = МетодЗапускаСинхрониазцииПоАТблицам(ДанныеПришёлЛиIDДЛяГенерацииUUID,
                                             ТекущаяТаблицаДляОБменаДанными, КакойРежимСинхрониазцииПерваяСинхронизациИлиПовторная,
                                             public_contentДатыДляГлавныхТаблицСинхронизации.МенеджерПотоков,
                                             ГлавноеКоличествоОбрабоатываемыхТаблицОбменаССервером,public_contentДатыДляГлавныхТаблицСинхронизации
                                             ,ActivityДляСинхронизацииОбмена);


                                     Log.d(this.getClass().getName(), " ТекущаяТаблицаДляОБменаДанными " + ТекущаяТаблицаДляОБменаДанными +
                                             "  ЗАКОНЧИЛИ ОБРАБОТКУ ОТДЕЛЬНОЙ ТАЛИЦЫ  ФлагУказываетЧтоТОлькоОбработкаТаблицДляЧАТА " +
                                             ТекущаяТаблицаДляОБменаДанными + " ФлагУказываетЧтоТОлькоОбработкаТаблицДляЧАТА "
                                             + ФлагУказываетЧтоТОлькоОбработкаТаблицДляЧАТА + "  РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри "
                                             + РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри[0] + " СколькоСтрочекJSON " + ГлавноеКоличествоОбрабоатываемыхТаблицОбменаССервером);


                                     // TODO: 05.10.2021  вторая часть после успешной обработки таблицы увеличиваем версию данных если сешно вставка или обовление


// TODO: 10.09.2021 выкидываем из ПАМЯТИ ОТРАБОТАННУЮ ТАБЛИЦУ

                                     Log.i(this.getClass().getName(), "  PUBLIC_CONTENT.ИменаТаблицыОтАндройда.size()   " + public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда.size() +
                                             " РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри " + РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри[0]);

                                     ///////


                                     ПубличныйРезультатОтветаОтСерврераУспешно = РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри[0];


                                     Log.d(this.getClass().getName(), " Не допушена к Обработке РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри "
                                             + РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри[0] +
                                             " ПубличныйРезультатОтветаОтСерврераУспешно " + ПубличныйРезультатОтветаОтСерврераУспешно);

                                     РезультатВерсииДанныхЧатаНаСервере = 0l;


                                     // TODO: 06.10.2021  таблицы не допущенны к обработке


                                     // TODO: 10.10.2021 clear from queueu

                                     Log.d(this.getClass().getName(), " public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда "
                                             + public_contentДатыДляГлавныхТаблицСинхронизации.ИменаТаблицыОтАндройда);


                                 } catch (Exception e) {
                                     //  Block of code to handle errors
                                     e.printStackTrace();
                                     ///метод запись ошибок в таблицу
                                     Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                             + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                     // TODO: 01.09.2021 метод вызова
                                     new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                             this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                             Thread.currentThread().getStackTrace()[2].getLineNumber());
                                 }


                                 // TODO: 13.01.2022 end test code

                                 return  Observable.fromArray(ТекущаяТаблицаИзПотока).blockingStream().peek(РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри
                                         ->System.out.println(РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри));
                             }
                         })
                         .doOnError(new Consumer<Throwable>() {
                             @Override
                             public void accept(Throwable throwable) throws Throwable {
                                 Log.e(this.getClass().getName(), "   doOnError  ОШИБКА В ГЛАВНОМ ЦИКЛЕ ПО ТАБЛИЦАМ В ОБМЕНЕ .111!!!!!!!!!throwable "
                                         + throwable.getStackTrace().toString());
                             }
                         })

                         .doOnComplete(new Action() {
                             @Override
                             public void run() throws Throwable {
                                 Log.i(this.getClass().getName(), " doOnTerminate  CLOSE ЗАКРЫВАЕМ БАЗУ ПОСЛЕ ОБРАБОТКИ ВСЕХ ТАБЛИЦ Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы.isOpen() "
                                         + Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы.isOpen());
                                 /// todo после обработки

                                 if (Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы.isOpen()) {

                                     Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы.close();

                                     Create_Database_СамаБАзаSQLite_КЛОННастоящейБазы = null;
                                 }

                             }
                         })
                         .onErrorComplete(new Predicate<Throwable>() {
                             @Override
                             public boolean test(Throwable throwable) throws Throwable {
                                 Log.e(this.getClass().getName(), "   onErrorComplete  ОШИБКА В ГЛАВНОМ ЦИКЛЕ ПО ТАБЛИЦАМ В ОБМЕНЕ .111!!!!!!!!!throwable "
                                         + throwable.getStackTrace().toString());
                                 return false;
                             }
                         });


                 Log.w(this.getClass().getName(), " doOnTerminate ОБРАБОТКА ВСЕХ ТАБЛИЦ ЗАВЫЕРШИЛАСЬ В ГЛАВНОМ ЦИКЛЕ ПО ТАБЛИЦАМ В ОБМЕНЕ ");


// TODO: 14.01.2022 подписка на данные гланого цикла

                 observableГлавныйЦиклСинхрониазацииПрограммыТабельныйУчёт.blockingSubscribe(System.out::println);


                 Log.w(this.getClass().getName(), " doOnTerminate ОБРАБОТКА ВСЕХ ТАБЛИЦ ЗАВЫЕРШИЛАСЬ В ГЛАВНОМ ЦИКЛЕ ПО ТАБЛИЦАМ В ОБМЕНЕ ");


                 //TODO отписаться

                 observableГлавныйЦиклСинхрониазацииПрограммыТабельныйУчёт.unsubscribeOn(Schedulers.computation());

                 // TODO: 26.12.2021
             } catch (Exception e) {
                 //  Block of code to handle errors
                 e.printStackTrace();
                 ///метод запись ошибок в таблицу
                 Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                         + Thread.currentThread().getStackTrace()[2].getLineNumber());
                 // TODO: 01.09.2021 метод вызова
                 new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                         this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                         Thread.currentThread().getStackTrace()[2].getLineNumber());
             }

             // TODO: 28.10.2021
             Log.d(this.getClass().getName(), " РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри[0] "
                     + РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри[0]);


             return РезультатОбработкиТекущейтаблицыСинхрониазцииВнутриЦиклаВнутри[0];
         }


     }


     // TODO: 22.03.2022  ДЛЯ ОТПРАВКИ ДАННЫХ НА СЕРВЕР


     private class SubClass_Klacc_Otprabki_класс_ОтправкиДанных extends Class_Engine_SQL {
         public SubClass_Klacc_Otprabki_класс_ОтправкиДанных(@NotNull Context context) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
             super(context);
         }
         // TODO: 22.03.2022

         //////todo МЕТОД НЕПОСТРЕДСТВЕННО ОТПРАВЛЯЕМ ДАННЫЕ НА СЕРВЕР МЕТОД POST
         Integer МетодПосылаетНаСерверСозданныйJSONФайлвФоне(@NonNull JSONObject ГенерацияJSONполейФиналДляОтправкиНаСеврерОтАндройда, @NonNull String имяТаблицыОтАндройда_локальноая,
                                                             CompletionService МенеджерПотоковВнутрений) {
             /////
             Integer РезультатУспешнойВставкиИлиОбновлениеCallBacksОтСервера = 0;

             String ДанныеПришёлВОтветОтМетодаPOST = new String();
             ///

             StringBuffer БуферОтправкаДанныхвФоне = new StringBuffer();
             //


             Class_GRUD_SQL_Operations class_grud_sql_operations;
             ///
             class_grud_sql_operations = new Class_GRUD_SQL_Operations(contextСозданиеБАзы);


             try {
                 Log.d(this.getClass().getName(), "  МЕТОД НЕПОСТРЕДСТВЕННО ОТПРАВЛЯЕМ ДАННЫЕ НА СЕРВЕР МЕТОД POST ");

                 // TODO: 15.06.2021 проверяем если таблица табель то еси в нутри потока отпралеемого хоть один день d1,d2,d3 защита от пустого траыфика\
                 Log.d(this.getClass().getName(), " ГенерацияJSONполейФиналДляОтправкиНаСеврерОтАндройда.toString() "
                         + ГенерацияJSONполейФиналДляОтправкиНаСеврерОтАндройда.toString() +
                         " ГенерацияJSONполейФиналДляОтправкиНаСеврерОтАндройда.toString().toCharArray().length  "
                         + ГенерацияJSONполейФиналДляОтправкиНаСеврерОтАндройда.toString().toCharArray().length +
                         " имяТаблицыОтАндройда_локальноая " + имяТаблицыОтАндройда_локальноая);
                 ///todo


                 try {
                     // TODO: 28.01.2022
                     String НазваниеПорта = "tabel.dsu1.ru";
                     // TODO: 16.02.2022
                     Integer СамПорт = 8888;

        /*       // TODO: 28.01.2022
               String НазваниеПорта="192.168.254.40";
               Integer СамПорт=8080;
               ///*/

                     //////todo МЕТОД НЕПОСТРЕДСТВЕННО ОТПРАВЛЯЕМ ДАННЫЕ НА СЕРВЕР МЕТОД POST
                     БуферОтправкаДанныхвФоне = УниверсальныйБуферОтправкиДанныхНаСервера(ГенерацияJSONполейФиналДляОтправкиНаСеврерОтАндройда,
                             ПубличноеIDПолученныйИзСервлетаДляUUID, имяТаблицыОтАндройда_локальноая,
                             "Получение JSON файла от Андройда", 60000, НазваниеПорта, СамПорт); ///БУФЕР ОТПРАВКИ ДАННЫХ НА СЕРВЕР  //TODO original "tabel.dsu1.ru", 8888        //TODO "192.168.254.40", 8080

                     Log.d(this.getClass().getName(), "  СЛУЖБА ВЕРНУЛЬСЯ ОТВЕТ ОТ СЕРВЕРА ОБРАТНО АНДРОЙДУ  БуферОтправкаДанных.toString() " + БуферОтправкаДанныхвФоне.toString());


                     if (БуферОтправкаДанныхвФоне == null) {

                         БуферОтправкаДанныхвФоне = new StringBuffer();

                     }


                     if (БуферОтправкаДанныхвФоне.length() > 0) {

                         ПубличныйРезультатОтветаОтСерврераУспешно = 0;
                         ////
                         ПубличныйРезультатОтветаОтСерврераУспешно = БуферОтправкаДанныхвФоне.length();
                     }

                     Log.d(this.getClass().getName(), "БуферОтправкаДанныхвФоне.length() " + БуферОтправкаДанныхвФоне.length() +
                             " БуферОтправкаДанныхвФоне " + БуферОтправкаДанныхвФоне.toString());


                     ////
                 } catch (Exception e) {
                     e.printStackTrace();
                     ///метод запись ошибок в таблицу
                     Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                             " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                     // TODO: 01.09.2021 метод вызова
                     new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                             Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                     ////// начало запись в файл
                 }

                 // TODO: 18.10.2021


                 // TODO: 18.10.2021 exit iwait

                 ////TODO  ОТВЕТ ОТ СЕРВЕРА ПОСЛЕ ОТПРАВКИ ДАННЫХ НА СЕРВЕР
                 if (БуферОтправкаДанныхвФоне != null) {
                     ///


                     if (БуферОтправкаДанныхвФоне.length() > 0) {

                         Log.d(this.getClass().getName(), "  БуферОтправкаДанныхвФоне.toString()  " + БуферОтправкаДанныхвФоне.toString());
                         do {
                             ДанныеПришёлВОтветОтМетодаPOST = БуферОтправкаДанныхвФоне.toString();

                             Log.d(this.getClass().getName(), "  ДанныеПришёлВОтветОтМетодаPOST  " + ДанныеПришёлВОтветОтМетодаPOST);

                             //
                             if (ДанныеПришёлВОтветОтМетодаPOST != null) {
                                 //
                                 break;
                             }

                         } while (ДанныеПришёлВОтветОтМетодаPOST == null);/////конец for # количество респонсев
                     }


                     ////TODO ответ от сервера РЕЗУЛЬТАТ
                     Log.d(this.getClass().getName(), "Успешный Ответ от сервера ДанныеПришёлВОтветОтМетодаPOST в фоне " + ДанныеПришёлВОтветОтМетодаPOST);
                     ///
                     if (ДанныеПришёлВОтветОтМетодаPOST.length() > 5) {
                         ///
                         //
                         //// TimeUnit.MILLISECONDS.sleep(500);
                         //
                         РезультатУспешнойВставкиИлиОбновлениеCallBacksОтСервера = ДанныеПришёлВОтветОтМетодаPOST.length();

                         Log.d(this.getClass().getName(), " СЛУЖБА УСПЕШНЫЙ ОТВКЕТ ОТ СЕРВЕРА ОТВЕТ CALBACKS  ДанныеПришёлВОтветОтМетодаPOST.length()  "
                                 + ДанныеПришёлВОтветОтМетодаPOST.length() + " ДанныеПришёлВОтветОтМетодаPOST " + ДанныеПришёлВОтветОтМетодаPOST.toString());
                     } else {
                         Log.d(this.getClass().getName(), " NULL НОЛЬ ОБНОВЛЕНИЙ ИЛИ ВСТАВОК С СЕРВЕРА  СЛУЖБА УСПЕШНЫЙ ОТВКЕТ ОТ СЕРВЕРА ОТВЕТ CALBACKS  ДанныеПришёлВОтветОтМетодаPOST.length() ");
                     }


                     // TODO: 15.07.2021  только для таблиц указываем ответ от сервер успешно лдии ывставли или обновли данные


                     /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
                     /////////
                 } else {////ОШИБКА В ПОЛУЧЕНИИ С СЕРВЕРА ТАБЛИУЦЫ МОДИФИКАЦИИ ДАННЫХ СЕРВЕРА


                     Log.d(this.getClass().getName(), " Данных нет c сервера  БуферОтправкаДанных.length() в фоне " + БуферОтправкаДанныхвФоне.length());
                 }

                 Log.d(this.getClass().getName(), " ДанныеПришёлВОтветОтМетодаPOST " + ДанныеПришёлВОтветОтМетодаPOST);

                 if (ДанныеПришёлВОтветОтМетодаPOST.length() > 0) {

                     /////// данные код анализирует успешные и/ил обновление данных на серврер кторые ему присла пользователь
                     МетодАнализаОтветаОтСервераУспешныеВставкиИлиОбновлениевФоне(ДанныеПришёлВОтветОтМетодаPOST, имяТаблицыОтАндройда_локальноая, МенеджерПотоковВнутрений);

                 }
             } catch (Exception e) {
                 e.printStackTrace();
                 ///метод запись ошибок в таблицу
                 Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                         " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                 // TODO: 01.09.2021 метод вызова
                 new Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                         Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                 ////// начало запись в файл
             }
             return РезультатУспешнойВставкиИлиОбновлениеCallBacksОтСервера;
         }
     }
 }
