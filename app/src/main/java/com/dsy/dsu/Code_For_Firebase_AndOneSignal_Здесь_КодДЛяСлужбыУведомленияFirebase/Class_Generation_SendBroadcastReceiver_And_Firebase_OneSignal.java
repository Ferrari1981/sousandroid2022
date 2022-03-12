 package com.dsy.dsu.Code_For_Firebase_AndOneSignal_Здесь_КодДЛяСлужбыУведомленияFirebase;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;

import com.dsy.dsu.CREATE_DATABASE;
import com.dsy.dsu.Class_Engine_SQL;
import com.dsy.dsu.Class_GRUD_SQL_Operations;
import com.dsy.dsu.Class_Generation_Data;
import com.dsy.dsu.Class_Generation_Errors;
import com.dsy.dsu.Class_Generations_PUBLIC_CURRENT_ID;
import com.dsy.dsu.Code_For_Starting_BroadcastReciever_ЗдесьКодЗапускаБроадКастеров.BroadcastReceiver_Sous_Asyns_Glassfish;
import com.dsy.dsu.Code_For_Starting_BroadcastReciever_ЗдесьКодЗапускаБроадКастеров.BroadcastReceiver_Sous_Notificatioons;
import com.dsy.dsu.Code_For_Starting_BroadcastReciever_ЗдесьКодЗапускаБроадКастеров.BroadcastReceiver_Sous_Notificatioons_ONE_ОдноразовоеУведомление;
import com.dsy.dsu.Code_For_Starting_BroadcastReciever_ЗдесьКодЗапускаБроадКастеров.BroadcastReceiver_Sous_UpdateSoft;
import com.dsy.dsu.Code_For_Starting_BroadcastReciever_ЗдесьКодЗапускаБроадКастеров.Class_StartingOne_Async_winhData_ЗапускОдноразовойСинхронизации;
import com.dsy.dsu.MyFirebaseMessagingService;
import com.dsy.dsu.PUBLIC_CONTENT;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import javax.crypto.NoSuchPaddingException;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

 public class Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal  {

    Context context;
     String ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal = null;

    public Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(Context context) {

        this.context=context;



    }

    // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР СИНХРОГНИАЗУИЯ ДАННЫХ

    protected void МетодПовторногоЗапускаВсехWorkManagerСинхрониазцииданных() {
        ;
        try {

            //TODO start broad caset receiver

            BroadcastReceiver_Sous_Asyns_Glassfish broadcastReceiver_sous_asyns_glassfish= new BroadcastReceiver_Sous_Asyns_Glassfish();

            Intent ИнтретПоЗапускуПовторноШироковещательногоСинхрониазции = new Intent(context, BroadcastReceiver_Sous_Asyns_Glassfish.class);
//


            // TODO: 17.11.2021
            ИнтретПоЗапускуПовторноШироковещательногоСинхрониазции.setAction("BroadcastReceiver_Sous_Asyns_Glassfish");

            // TODO: 10.11.2021

            ////

            // TODO: 25.11.2021

            ИнтретПоЗапускуПовторноШироковещательногоСинхрониазции.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //

            //
            ИнтретПоЗапускуПовторноШироковещательногоСинхрониазции.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            ///

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
             //   context.registerReceiver(broadcastReceiver_sous_asyns_glassfish, new IntentFilter());
            }
            // TODO: 10.11.2021
            context.sendBroadcast(ИнтретПоЗапускуПовторноШироковещательногоСинхрониазции);
            // TODO: 25.11.2021

           // context.unregisterReceiver(broadcastReceiver_sous_asyns_glassfish);

            Log.d(this.getClass().getName(), " ПРОШЕЛ ЗАПУСК      BroadcastReceiver_Sous_Asyns_Glassfish  broadcastReceiver_sous_asyns_glassfish= new BroadcastReceiver_Sous_Asyns_Glassfish(); " );


        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 11.05.2021 запись ошибок


        }

    }


    // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР СИНХРОГНИАЗУИЯ ДАННЫХ

    public void МетодПовторногоЗапускаВсехWorkManager__ОДНОРАЗОВОЙСинхрониазцииданных(Integer ПубличныйIDДляОдноразовойСинхрониазцииДляКонкретногоПользователя, Context context) {

        try {

            //TODO start broad caset receiver

            Class_StartingOne_Async_winhData_ЗапускОдноразовойСинхронизации class_startingOne_async_winhData_запускОдноразовойСинхронизации=
                    new Class_StartingOne_Async_winhData_ЗапускОдноразовойСинхронизации();

            // TODO: 28.02.2022 запускаем метод одноразовой синхронизации

            class_startingOne_async_winhData_запускОдноразовойСинхронизации.МетодЗапускОдноразовойСинхронизации(context,ПубличныйIDДляОдноразовойСинхрониазцииДляКонкретногоПользователя);

            // TODO: 28.02.2022

            Log.d(this.getClass().getName(), " ПРОШЕЛ ЗАПУСК  метода МетодПовторногоЗапускаВсехWorkManager__ОДНОРАЗОВОЙСинхрониазцииданных()   " +
                    "   ПубличныйIDДляОдноразовойСинхрониазцииДляКонкретногоПользователя "+
                    ПубличныйIDДляОдноразовойСинхрониазцииДляКонкретногоПользователя);


        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 11.05.2021 запись ошибок


        }

    }

        // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР уведомления

        public void МетодПовторногоЗапускаУведомленияОбщего() {

            try {



                //TODO start broad caset receiver

                BroadcastReceiver_Sous_Notificatioons broadcastReceiver_sous_notificatioons_общая=   new BroadcastReceiver_Sous_Notificatioons();
//
                Intent ИнтретПоЗапускуПовторноШироковещательногоДляОбщейСинхрониазции=new Intent(context,BroadcastReceiver_Sous_Notificatioons.class);



                // TODO: 10.11.2021
                ИнтретПоЗапускуПовторноШироковещательногоДляОбщейСинхрониазции.setAction("BroadcastReceiver_Sous_Notificatioons");
                ////


                // TODO: 25.11.2021

                ИнтретПоЗапускуПовторноШироковещательногоДляОбщейСинхрониазции.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //

                //
                ИнтретПоЗапускуПовторноШироковещательногоДляОбщейСинхрониазции.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                ///

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    //
                  //  context. registerReceiver(broadcastReceiver_sous_notificatioons,new IntentFilter());
                }
                // TODO: 10.11.2021

                // TODO: 25.11.2021
                context. sendBroadcast(ИнтретПоЗапускуПовторноШироковещательногоДляОбщейСинхрониазции);

                // TODO: 16.12.2021
                Log.d(this.getClass().getName(), "  запуск........BroadcastReceiver_Sous_Notificatioons   УВЕДОМЛЕНИЯ ОБШИЕ  " );


                // TODO: 11.01.2022


            } catch (Exception e) {
                //  Block of code to handle errors
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());

                // TODO: 11.05.2021 запись ошибок


            }




    }

    // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР уведомления

    public void МетодПовторногоЗапускаУведомленияДляОдноразовойСинхрониазации() {

        try {



            //TODO start broad caset receiver

            BroadcastReceiver_Sous_Notificatioons_ONE_ОдноразовоеУведомление broadcastReceiver_sous_notificatioons_ONEUSING =   new BroadcastReceiver_Sous_Notificatioons_ONE_ОдноразовоеУведомление();
//
            Intent ИнтретПоЗапускуПовторноШироковещательногоДляОбноразвойСинхрониащзции=new Intent(context, BroadcastReceiver_Sous_Notificatioons_ONE_ОдноразовоеУведомление.class);



            // TODO: 10.11.2021
            ИнтретПоЗапускуПовторноШироковещательногоДляОбноразвойСинхрониащзции.setAction("BroadcastReceiver_Sous_Notificatioons_ONE_ОдноразовоеУведомление");
            ////

            // TODO: 25.11.2021

            ИнтретПоЗапускуПовторноШироковещательногоДляОбноразвойСинхрониащзции.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //

            //
            ИнтретПоЗапускуПовторноШироковещательногоДляОбноразвойСинхрониащзции.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            ///

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //
                //  context. registerReceiver(broadcastReceiver_sous_notificatioons,new IntentFilter());
            }
            // TODO: 10.11.2021

            // TODO: 25.11.2021
            context. sendBroadcast(ИнтретПоЗапускуПовторноШироковещательногоДляОбноразвойСинхрониащзции);

            // TODO: 16.12.2021
            Log.d(this.getClass().getName(), "  запуск........BroadcastReceiver_Sous_Notificatioons_ONE_ОдноразовоеУведомление  УВЕДОМЛНИЯ ОДНОРАЗОВЫЕ   " );


            // TODO: 11.01.2022


        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 11.05.2021 запись ошибок


        }




    }

    // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР уведомления

    public void МетодПовторногоЗапускаВсехWorkManagerДляОбновленияПО() {

        try {

            //TODO start broad caset receiver



            BroadcastReceiver_Sous_UpdateSoft broadcastReceiver_sous_updateSoft=   new BroadcastReceiver_Sous_UpdateSoft();
//
            Intent ИнтретПоЗапускуПовторноШироковещательногоОбновлениеПО=new Intent(context,BroadcastReceiver_Sous_UpdateSoft.class);



            // TODO: 10.11.2021
            ИнтретПоЗапускуПовторноШироковещательногоОбновлениеПО.setAction("BroadcastReceiver_Sous_UpdateSoft");
            ////




            // TODO: 25.11.2021

            ИнтретПоЗапускуПовторноШироковещательногоОбновлениеПО.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //

            //
            ИнтретПоЗапускуПовторноШироковещательногоОбновлениеПО.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            ///

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //
              //  context. registerReceiver(broadcastReceiver_sous_updateSoft,new IntentFilter());
            }
            // TODO: 10.11.2021

            // TODO: 25.11.2021
            context. sendBroadcast(ИнтретПоЗапускуПовторноШироковещательногоОбновлениеПО);

            // TODO: 16.12.2021


        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 11.05.2021 запись ошибок


        }




    }





    // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР

    public String МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal(@NonNull String КлючДляFirebaseNotification,
                                                                     Integer ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника) {



        ///
        Class_GRUD_SQL_Operations class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal=new Class_GRUD_SQL_Operations(context);
        // TODO: 03.11.2021
        PUBLIC_CONTENT public_contentменеджер=new PUBLIC_CONTENT(context);

        // TODO: 23.12.2021
         String ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl = null;


        try {

            // TODO: 23.12.2021 ЧЕТЫРЕ ПОПЫТКИ ПОДКЛЮЧЕНИЕ В СЕВРЕРУONESIGNAL

          Observable observableПолученияКлючаОтСервераOneSignal=  Observable.interval(5,TimeUnit.SECONDS)
                  .take(1,TimeUnit.MINUTES)
                  .subscribeOn(Schedulers.computation())
                  .flatMap((ТекущаяОперацияОбрабооткиКлючаОтСервера)->{



                      Log.w(context.getClass().getName(), "   Iterable<?> apply МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal"  +"\n"+
                              " Thread.currentThread().getName() " +Thread.currentThread().getName());


                      // TODO: 05.01.2022
                      МетодПолучениеКлючаОтСервераONESIGNALЕслиОЕстьКОнечноВНЕСКОЛЬКОПОпыток(КлючДляFirebaseNotification);

                      // TODO: 06.01.2022
                      Log.w(context.getClass().getName(), "  onNext МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal"  +"\n"+
                              " Thread.currentThread().getName() " +Thread.currentThread().getName()+"\n"+
                               "  ТекущаяОперацияОбрабооткиКлючаОтСервера    "+ТекущаяОперацияОбрабооткиКлючаОтСервера );

                      return  Observable.just(ТекущаяОперацияОбрабооткиКлючаОтСервера);
                  })
                  .doOnError(new Consumer<Throwable>() {
                      @Override
                      public void accept(Throwable throwable) throws Throwable {

                          // TODO: 06.01.2022
                          Log.e(context.getClass().getName(), "  doOnError МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal"  +"\n"+
                                  " Thread.currentThread().getName() " +Thread.currentThread().getName());

                      }
                  })
                  .takeWhile(new Predicate<Object>() {
                      @Override
                      public boolean test(Object o) throws Throwable {
                          // TODO: 26.12.2021

                          Log.w(context.getClass().getName(), "   takeWhile МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal"  +"\n"+
                                  " Thread.currentThread().getName() " +Thread.currentThread().getName()+ "  o " +o);

                          if (   ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal!=null) {

                              Log.w(context.getClass().getName(), "  ДЛЯ ТЕКУЩЕГО ПОЛЬЗОВАТЕЛЯ (телефона)Ключ ПришелОтСЕРВЕРА SUCEESSSSSS !!!@!  " +
                                      " takeWhile МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal САМ КЛЮЧ ::::" +
                                      "  "+"\n"
                                      +ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal  +"\n"+
                                      " Thread.currentThread().getName() " +Thread.currentThread().getName());

                              // TODO: 04.01.2022

                              return false;
                          }else {
                              return true;
                          }
                      }
                  })
                  .doOnComplete(new Action() {
                      @Override
                      public void run() throws Throwable {
                          Log.w(context.getClass().getName(), " doOnTerminate  МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal" +ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal);


                          // TODO: 06.01.2022
                          МетодПослепингаПослеПолученияКлючаСервераOneSingmalЗапускаемЗаписьКлючаНового(class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal,
                                  ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl,
                                  ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника,
                                  public_contentменеджер);



                          // TODO: 06.01.2022
                          Log.w(context.getClass().getName(), "  onComplete МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal"  +"\n"+
                                  " Thread.currentThread().getName() " +Thread.currentThread().getName()); 
                      }
                  })
                  .observeOn(AndroidSchedulers.mainThread());
// TODO: 07.01.2022 GREAT OPERATIONS подпииска на данные  
            observableПолученияКлючаОтСервераOneSignal.subscribe(System.out::println);



            // TODO: 05.01.2022  ДЕЛАЕМ ПОДПИСКУ НА ОСУЩЕСТВЛЛЕНУЮ ДАННЫХ

        } catch (Exception e ) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 11.05.2021 запись ошибок


        }

        return ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl;
    }


    private void МетодПослепингаПослеПолученияКлючаСервераOneSingmalЗапускаемЗаписьКлючаНового(
            Class_GRUD_SQL_Operations class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal,
                           String ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl,
                          Integer ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника,
                           PUBLIC_CONTENT public_contentменеджер) {
        try{

            // TODO: 23.12.2021 второй код получние данных ключа если они еть и записатьв базу


            if (ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal !=null) {


                Log.w("OneSignalExample", "РезультатЗаписиНовогоIDОтСервреаOneSignal "+  "РезультатЗаписиНовогоIDОтСервреаOneSignal   "
                        + ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal);

                // TODO: 14.12.2021 переподписываемемся к серверу onesingle  subscrupve, ДЛЯ ТЕКУЩЕГО ПОЛЬЩОВАТЕЛЯ ПОЛУЧАЕМ ПЕРВЫЙ РАЗ  ИЛИ ПОВТОРНО ПОЛУЧЕНИЕ ID  ПОЛЬЗОВАТЕЛЯ ДЛЯ РАССЫЛКИ ПОСЛЕДУЮЩЕЙ


                ///
     /*           class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal=new Class_GRUD_SQL_Operations(context);
                // TODO: 03.11.2021
                public_contentменеджер=new PUBLIC_CONTENT(context);*/

                ///
                class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","settings_tabels");
                ///////
                class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","onesignal");
                //

                ////

                class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","  onesignal=? ");
                ///"_id > ?   AND _id< ?"
                //////
                class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",
                        ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal.trim());

                // TODO: 29.12.2021

                ////
                class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC");

                // TODO: 29.12.2021

                ////
                class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");

                ////

                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

                SQLiteCursor Курсор_ПолучаемУжеЗагруженныйЕслиНОНЕИзменильсяIDДляONESIGNAL= null;

                Курсор_ПолучаемУжеЗагруженныйЕслиНОНЕИзменильсяIDДляONESIGNAL = (SQLiteCursor)  class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                        new GetData(context).getdata(class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,public_contentменеджер.МенеджерПотоков,new CREATE_DATABASE(context).getССылкаНаСозданнуюБазу());


                Log.d(this.getClass().getName(), "Курсор_ПолучаемУжеЗагруженныйЕслиНОНЕИзменильсяIDДляONESIGNAL "+Курсор_ПолучаемУжеЗагруженныйЕслиНОНЕИзменильсяIDДляONESIGNAL  );









                if(Курсор_ПолучаемУжеЗагруженныйЕслиНОНЕИзменильсяIDДляONESIGNAL.getCount()>0){
                    // TODO: 22.12.2021
                    Курсор_ПолучаемУжеЗагруженныйЕслиНОНЕИзменильсяIDДляONESIGNAL.moveToFirst();

                    // TODO: 22.12.2021
                    ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl=Курсор_ПолучаемУжеЗагруженныйЕслиНОНЕИзменильсяIDДляONESIGNAL.getString(0);
                }


                Log.d(this.getClass().getName(), "ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl "+
                        ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl +"\n"+
                        " ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal " + ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal);



               //// ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl =null;
                // TODO: 15.12.2021 ПРИНИМАЕМ РЕШЕНИЕ ПЕРЕЗАПИСЫВАЕМ СВОЙ id ОТ СЕРВЕРА ONESINGNAL ИЛИ НЕТ


                if (ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl ==null ||
                        ! ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl.
                                equalsIgnoreCase(ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal)) {

                    // TODO: 04.01.2022  ПРИШЕЛ НОВЫЙ КЛЮЧ И ЕГО НАДО ЗАПИСАТЬ ДЛЯ ONESINGNAL


                    new Класс_ЗаписываетНовоеЗначениееслиОноИзменилосьНаСервреаOneSignalДляТекущегоПользователя(context,
                            ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal);


                    Log.w("OneSignalExample", " ВНИМАНИЕ !!!!!!  ЗАПИСЬ НОВОГО КЛЮЧА ДЛЯ ДАННОГО ПОЛЬЗОВАТЕЛЯ ONESIGNAL " +
                            "РезультатЗаписиНовогоIDОтСервреаOneSignal " + "\n"
                            + "РезультатЗаписиНовогоIDОтСервреаOneSignal   " + ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal+"\n"+
                            "ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl "+
                            ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl);





                }else{

                    Log.w("OneSignalExample", "СТАРЫЙ КЛЮЧ ДЕЙСТВУЕТ ДЛЯ КЛЮЧА ДЛЯ ДАННОГО ПОЛЬЗОВАТЕЛЯ ONESIGNAL  РезультатЗаписиНовогоIDОтСервреаOneSignal   "
                            +  "ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl[0]   "
                            + ЛокальныйКлючНААндройдеПолученныйУжеСуществующийКлючНАONESIGNAl
                            +  "РезультатЗаписиНовогоIDОтСервреаOneSignal   "
                            + ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal);





                }


// TODO: 29.12.2021  УДАЛЕНИЯ СТАРЫХ КЛЮЧЕЙ





                // TODO: 09.12.2021 СОЗДАНИЕ ПОЛУЧЕНИЕ ДАННЫХ ИЗ ТАЮЛИЦЫ ВСЕХ ПОЛЬЗОВАТЕЛЕЙ КОТОРЫМ НУЖНО ОТПАПРВИТЬ ДПННЫЕ


                Log.d(this.getClass().getName(), "ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника "+ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника  );



                ///
                class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal=new Class_GRUD_SQL_Operations(context);

                if (ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника>0) {
                    ///
                    class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","view_onesignal");
                    ///////
                    class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","onesignal");
                    //

                    ////

                    class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","  user_update=?  AND onesignal IS NOT NULL");
                    ///"_id > ?   AND _id< ?"
                    //////
                    class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника);



                    Log.w(this.getClass().getName(), "  СРАБОТАЛО ОТПРАВЛЯЕМ СООБЩЕНИЕ СТРОКО ПОЛЬЗОВАТЕЛЮ ............ SEND MESSAGE DSU1 ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника "+ОтправкаСообщенияТолькоСтрогоОдномуУказанномуСотрудника  );

                    ////
                } else {

                    ///
                    class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","view_onesignal");
                    ///////
                    class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","onesignal");
                    //

                    ////

                    class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","  onesignal!=?  ");
                    ///"_id > ?   AND _id< ?"
                    //////
                    class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal);

                    // TODO: 29.12.2021


                    Log.d(this.getClass().getName(), " ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal "+ ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal  );

                    Log.d(this.getClass().getName(), "  СРАБОТАЛО ОТПРАВЛЯЕМ СООБЩЕНИЕ все мпользоватем кторые есть в базе  ............ SEND MESSAGE DSU1  ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal" +
                            ""+ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal );

                }

                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

                SQLiteCursor Курсор_ПолучаемВесьСписокIDДляONESIGNAL= null;

                Курсор_ПолучаемВесьСписокIDДляONESIGNAL = (SQLiteCursor)  class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                        new GetData(context).getdata(class_grud_sql_operationsПолучаемПубличныйПолучениеВсегоСпискаIDДляOneSignal.
                                concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,public_contentменеджер.МенеджерПотоков,
                        new CREATE_DATABASE(context).getССылкаНаСозданнуюБазу());


                Log.d(this.getClass().getName(), "Курсор_ПолучаемВесьСписокIDДляONESIGNAL "+Курсор_ПолучаемВесьСписокIDДляONESIGNAL  );
                // TODO: 15.12.2021
                if(Курсор_ПолучаемВесьСписокIDДляONESIGNAL.getCount()>0){

                    // TODO: 15.12.2021

                    Курсор_ПолучаемВесьСписокIDДляONESIGNAL.moveToFirst();

                    do{


                        String КлючТекущйщийПолученныйДляОбменаOneSignal=  Курсор_ПолучаемВесьСписокIDДляONESIGNAL.getString(0).trim();

                        Log.d(this.getClass().getName(), "КлючТекущйщийПолученныйДляОбменаOneSignal "+КлючТекущйщийПолученныйДляОбменаOneSignal  );



                        // TODO: 15.12.2021 цикл для обработки onesignal


                        // TODO: 10.12.2021


                        // TODO: 15.12.2021
                        Log.d(this.getClass().getName(), " КлючТекущйщийПолученныйДляОбменаOneSignal"+ КлючТекущйщийПолученныйДляОбменаOneSignal+"\n"+
                                "ПоулчаемДляТекущегоПользователяIDОтOneSignal  "+ ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal);
                        // TODO: 13.12.2021


                        Date Дата = null;
                        DateFormat dateFormat = null;//"yyyy-MM-dd HH:mm:ss.SSS"//"yyyy-MM-dd'T'HH:mm:ss'Z'"

                        Дата = Calendar.getInstance().getTime();

                        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", new Locale("ru"));

                        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));

                        String ДатаФинал= dateFormat.format(Дата);

                        try {


                            OneSignal.postNotification(new JSONObject("{" +
                                            " 'include_player_ids': ['" + КлючТекущйщийПолученныйДляОбменаOneSignal + "']," +
                                            " 'app_id': '2a1819db-60c8-4ca3-a752-1b6cd9cadfa1'," +
                                            " 'android_background_data': 'true'," +
                                            " 'content_available': 'true'," +
                                            " 'data': {'grp_msg': 'android'} } "),

                                /*    OneSignal.postNotification(new JSONObject("{" +
                                                    " 'include_player_ids': ['" + ТекущйUUIDКомуНужноСообщение + "']," +
                                                    " 'app_id': '2a1819db-60c8-4ca3-a752-1b6cd9cadfa1'," +
                                                    " 'android_background_data': 'true'," +
                                                    " 'content_available': 'true'," +
                                                    " 'data': {'grp_msg': 'android'} } "),*/


                                    new OneSignal.PostNotificationResponseHandler() {
                                        @Override
                                        public void onSuccess(JSONObject response) {
                                            // TODO: 13.01.2022  успешний пинг с пользователями которым нужноотпавить сообщения
                                            Log.w("OneSignalExample", " УСПЕШНИЙ КОНТАКТ С ДРУГИМИ ПОЛЬЗОВАТЕЛМИ " +"\n"+
                                                    "ONESIGNAL !!!!! ONESIGNAL !!!!!ONESIGNAL !!!!!ONESIGNAL !!!!! " +"\n"+
                                                    "postNotification Success: " + response.toString()+  "ТекущйUUIDКомуНужноСообщение  "+"\n"
                                                    +КлючТекущйщийПолученныйДляОбменаOneSignal
                                                    +"\n"+" МОДЕЛЬ ТЕЛЕФОНА  Build.DEVICE   " +Build.DEVICE );
                                        }
                                        @Override
                                        public void onFailure(JSONObject response) {

                                            // TODO: 13.01.2022  НЕт пинга КЛЮЧ ИЛИ НЕТУ ИЛИ УСТАРЕЛЛ  пинг с пользователями которым нужноотпавить сообщения
                                            Log.e("OneSignalExample", " НЕТ КОНТАКТА С ТЕКУЩЕМ КЛЮЧЕМ ОТ ONESIGNAL" +
                                                    " КОНТАКТ С ДРУГИМИ ПОЛЬЗОВАТЕЛМИ  " +"\n"+
                                                    "postNotification Failure: ONESIGNAL !!!!! ONESIGNAL !!!! "+"\n"
                                                    + response.toString()+  "ТекущйUUIDКомуНужноСообщение   " +КлючТекущйщийПолученныйДляОбменаOneSignal+"\n"+
                                                    "\n"+" МОДЕЛЬ ТЕЛЕФОНА  Build.DEVICE   " +Build.DEVICE);
                                        }

                                    });





                        } catch (JSONException e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                    Thread.currentThread().getStackTrace()[2].getLineNumber());

                            // TODO: 11.05.2021 запись ошибок

                        }




                    }while (Курсор_ПолучаемВесьСписокIDДляONESIGNAL.moveToNext());



                }



            }else{



                Log.e(this.getClass().getName(), " НЕТ ПОКА КЛЮЧА  ДЛЯ , СКОРЕЙ ВСЕГО ПЕРВЫЫЙ ЩЗАПУСК ПОСЛЕ КЛЮЧ ДЛЯ  OneSignal........  2a1819db-60c8-4ca3-a752-1b6cd9cadfa1 "+"\n"+

                        "   OneSignal.getTriggerValueForKey(\"GT_PLAYER_ID\"); " + OneSignal.getTriggerValueForKey("GT_PLAYER_ID")+
                        "     OneSignal.getTriggers() " +   OneSignal.getTriggers()+"\n"+
                        "    ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal " + ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal);
                // TODO: 13.12.2021
            }

        } catch (Exception e ) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 11.05.2021 запись ошибок


        }
    }





    // TODO: 24.12.2021  МетодПолучение Статуса Ключа От Сервера OneSignal

    private void МетодПолучениеКлючаОтСервераONESIGNALЕслиОЕстьКОнечноВНЕСКОЛЬКОПОпыток(@NonNull String КлючДляFirebaseNotification) {
        
        try{
        // TODO: 23.12.2021
        if (ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal ==null) {

            //TODO srating......  oneSignal
            Log.d(this.getClass().getName(), "  КЛЮЧ ДЛЯ  OneSignal........  2a1819db-60c8-4ca3-a752-1b6cd9cadfa1 "+ КлючДляFirebaseNotification +"\n");
            // Enable verbose OneSignal logging to debug issues if needed.

            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

            //String КлючДляFirebaseNotification="2a1819db-60c8-4ca3-a752-1b6cd9cadfa1";


            // todo OneSignal Initialization
            OneSignal.initWithContext(context);

            ///////todo srating Google Notifications wits PUblic Key
            OneSignal.setAppId(КлючДляFirebaseNotification);


            OneSignal.disablePush(false);


            // TODO: 13.12.2021


            //TODO srating.......... firebase cloud --ПРИШЛО СООБЩЕНИЕ

            FirebaseMessagingService firebaseMessagingService =new MyFirebaseMessagingService();



            //TODO srating......  oneSignal
            Log.d(this.getClass().getName(), "  FirebaseMessagingService"  );


            // TODO: 07.12.2021
            firebaseMessagingService.onNewToken("Сообщения от Firebase Cloud Google ");

            Log.d(this.getClass().getName(), "  КЛЮЧ ДЛЯ  КОНЕЦ  OneSignal........  2a1819db-60c8-4ca3-a752-1b6cd9cadfa1 " );


            // TODO: 15.12.2021 настройки onesigmnal


            Map<String, String> params = new HashMap<String, String>();

            OneSignal.sendTag("Authorization", "Basic 2a1819db-60c8-4ca3-a752-1b6cd9cadfa1");

            OneSignal.sendTag("Content-type", "application/json");

            OneSignal.sendTag("grp_msg", "android");

            OneSignal.sendTag("android_background_data", "true");

            OneSignal.sendTag("content_available", "true");

            // TODO: 13.12.2021


            //TODO srating......  oneSignal

            ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal = OneSignal.getDeviceState().getUserId();
            // TODO: 15.12.2021
            Log.d(this.getClass().getName(), "  ПОСЛЕ КЛЮЧ ДЛЯ  OneSignal........  2a1819db-60c8-4ca3-a752-1b6cd9cadfa1 "+"\n"+

                    "   OneSignal.getTriggerValueForKey(\"GT_PLAYER_ID\"); " + OneSignal.getTriggerValueForKey("GT_PLAYER_ID")+
                    "     OneSignal.getTriggers() " +   OneSignal.getTriggers()+"\n"+
                    "    ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal ОТ СЕРВЕРА ::: " + ПоулчаемДляТекущегоПользователяIDОтСЕРВРЕРАOneSignal);
            // TODO: 13.12.2021

            
        }



    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

        // TODO: 11.05.2021 запись ошибок

    }
    }


}


































// TODO: 15.12.2021 КЛАСС ЗАПИСЫВАЕТ ЕСЛИ ИЗМЕННЕНОЕ ЗНАЧЕНИЕ НА СЕРВЕРА ДЛЯ ТЕКУЩЕГО ПОЛЬЗВОАТЕЛЯ ИЗМЕНИЛОСЬ НА ONESIGNAL

   class Класс_ЗаписываетНовоеЗначениееслиОноИзменилосьНаСервреаOneSignalДляТекущегоПользователя{

       public Класс_ЗаписываетНовоеЗначениееслиОноИзменилосьНаСервреаOneSignalДляТекущегоПользователя(Context context,String НовыйIdОТСервтераOneSignal) {


           Class_GRUD_SQL_Operations   class_grud_sql_operationsОбновлениеДляТаблицыOneSignal=new Class_GRUD_SQL_Operations(context);

           Class_GRUD_SQL_Operations        class_grud_sql_operationsПовышаемВерсиюДанныхДляOneSignal=new Class_GRUD_SQL_Operations(context);

           CREATE_DATABASE create_databaseДЛяOneSignal=new CREATE_DATABASE(context);

           try{
// TODO: 22.12.2021  находими пуличный id


               // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР
               // TODO: 30.09.2021 МЕТОД ЗАПУСКА СИНХРОНИЗАЦИИ ЧАТА ПО РАСПИСАНИЮ , НЕ ВЗАВИСИМОСТИ ОТ СОЗДАВАЛ ЛИ СООБЩЕНИЕ ИЛИ НЕТ

               Integer  ПубличныйIDДляОдноразовойСинхрониазции=   new Class_Generations_PUBLIC_CURRENT_ID(context).ПолучениеПубличногоТекущегоПользователяID();


               Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента  ИЗ ВСЕХ ТАБЕЛЕЙ ПубличныйIDДляОдноразовойСинхрониазции "
                       + ПубличныйIDДляОдноразовойСинхрониазции);




               /// TODO ########################################################втоаря часть  settings_tabels    ПЕРВАЯ ОБРАБОТКА ТАБЛИЦА  settings_tabels


               Observable observableСменыКлючаИЗАписьНовогоOneSinglal=   Observable.fromArray("settings_tabels","view_onesignal")
                       .subscribeOn(Schedulers.computation())
                       .observeOn(AndroidSchedulers.mainThread())
                       .flatMapStream(new Function<String, Stream<?>>() {
                           @Override
                           public Stream<?> apply(String ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL) throws Throwable {

                               // TODO: 24.02.2022
// TODO: 13.01.2022 САМА ВСТАВКА НОВОГО КЛЮЧА В ТАБЛИЦУ НАСТРОЙКИ СИСТЕМЫ

                               Integer   РезультатОбновленияКлючаДляПервойТаблицыsettings_tabelssОбаview_onesignal=
                                       МетодПервыйОбоаботкиПервойТаблицыПриИзмененияКлюча_settings_tabelsОбаview_onesignal(context,
                                       НовыйIdОТСервтераOneSignal,
                                       class_grud_sql_operationsОбновлениеДляТаблицыOneSignal,
                                       class_grud_sql_operationsПовышаемВерсиюДанныхДляOneSignal,
                                       create_databaseДЛяOneSignal, ПубличныйIDДляОдноразовойСинхрониазции
                                       ,ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL);


                               Log.i(this.getClass().getName(), "  РезультатОбновленияКлючаДляПервойТаблицыsettings_tabelssОбаview_onesignal   "
                                       + РезультатОбновленияКлючаДляПервойТаблицыsettings_tabelssОбаview_onesignal);
                               ////TODO УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННЫХ  В ТАБЛИЦЕ MODIFICATION CLIENT

                               /// TODO ########################################################ЧАСТЬ ТРЕТЬЯ УДАЛЕНИЯ ДАННЫХ В ТАБЛИЦАХ настройки системы


                               if (РезультатОбновленияКлючаДляПервойТаблицыsettings_tabelssОбаview_onesignal>0) {


                                   // TODO: 29.12.2021 ЧАСТЬ ТЕРТЬЯ УДАЛАЕНИЯ ЛИШНЕХ КЛЮЧЕЙ СТАРЫХ ИЗ ДВУХ ТАБЛЦ ПО ТЕКУЩЕМУ ПОЛЬЗОВАТЕЛЮ


                                   Integer РезультатПосикаИУдалениявТаблицах_settings_tabels = МетодПослеУспешнойОбновленияКлючаОтOneSignalИщемУдаляемДубли(context,
                                           ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL,
                                           ПубличныйIDДляОдноразовойСинхрониазции,
                                           НовыйIdОТСервтераOneSignal);


                                   // TODO: 29.12.2021 ПОСЛЕ УСПЕШНОГО ЗАПИСАВАНИЕ НВОГО КЛЮЧА УДАЛЯЕМ ДУБЛИЗЗНАПЧЕНИЙ ЕСЛИ  ОНОИ ИИСТЬ

                                   Log.d(this.getClass().getName(), "РезультатПосикаИУдалениявТаблицах_settings_tabels "
                                           + РезультатПосикаИУдалениявТаблицах_settings_tabels+ "  ПубличныйIDДляФрагмента " +ПубличныйIDДляОдноразовойСинхрониазции+
                                           " НовыйIdОТСервтераOneSignal " +НовыйIdОТСервтераOneSignal+
                                           " ТаблицаКоторуюнадоДляПосикаИУдаленияБудлейКлбчейONESIGNAL_ДЛЯ_ТАБЛИЦЫ_settings_tabels "
                                           +ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL);


                                   // TODO: 24.02.2022


                                   // TODO: 24.02.2022 увеличение данных после смены ключа

                                   if (ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL.equalsIgnoreCase("settings_tabels")) {
                                       // TODO: 24.02.2022


                                       МетодУвеличениеВерсииДанныхПриСменеКлючаOneSingnal(context,
                                               ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL,
                                               РезультатОбновленияКлючаДляПервойТаблицыsettings_tabelssОбаview_onesignal);

                                       // TODO: 29.12.2021 ПОСЛЕ УСПЕШНОГО ЗАПИСАВАНИЕ НВОГО КЛЮЧА УДАЛЯЕМ ДУБЛИЗЗНАПЧЕНИЙ ЕСЛИ  ОНОИ ИИСТЬ

                                       Log.d(this.getClass().getName(), "РезультатПосикаИУдалениявТаблицах_settings_tabels "
                                               + РезультатПосикаИУдалениявТаблицах_settings_tabels+ "  ПубличныйIDДляФрагмента " +ПубличныйIDДляОдноразовойСинхрониазции+
                                               " НовыйIdОТСервтераOneSignal " +НовыйIdОТСервтераOneSignal+
                                               " ТаблицаКоторуюнадоДляПосикаИУдаленияБудлейКлбчейONESIGNAL_ДЛЯ_ТАБЛИЦЫ_settings_tabels "
                                               +ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL);
                                   }


                               }

                               ////TODO УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННЫХ  В ТАБЛИЦЕ MODIFICATION CLIENT  после ЗАПИСИ НОВГО КЛЮЧА ОТ СЕРВЕРА  ONE SIGNAL



                               // TODO: 24.02.2022
                               return Observable.just(ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL).blockingStream();
                           }
                       })
                       .onErrorComplete(new Predicate<Throwable>() {
                           @Override
                           public boolean test(Throwable throwable) throws Throwable {


                               Log.e(this.getClass().getName(), " onErrorComplete РезультатПосикаИУдалениявТаблицах_settings_tabels  throwable "+ throwable.getMessage().toString());
                               return false;
                           }
                       })
                       .doOnComplete(new Action() {
                           @Override
                           public void run() throws Throwable {

                               Log.w(this.getClass().getName(), " doOnComplete РезультатПосикаИУдалениявТаблицах_settings_tabels  throwable ");
                           }
                       });

// TODO: 24.02.2022
               observableСменыКлючаИЗАписьНовогоOneSinglal.subscribe(System.out::println);

               // TODO: 25.02.2022


               Object ФиналРЕзультатКЛЮЧНОВЫЙ  =observableСменыКлючаИЗАписьНовогоOneSinglal.blockingStream().findAny().get();

               // TODO: 25.02.2022


                   // TODO: 04.11.2021   ЗАПУСКАЕМ СИНХРОНИАХЦИИЮ  через ONESIGNAL
                       Log.d(this.getClass().getName(), "РезультатCallsBackСинхрониазцииЧата РезультатРаботы  РезультатРаботыПереписываютНовгоКлюча "
                               +ФиналРЕзультатКЛЮЧНОВЫЙ.toString()+ " ФиналРЕзультатКЛЮЧНОВЫЙ " +ФиналРЕзультатКЛЮЧНОВЫЙ);



               if (ФиналРЕзультатКЛЮЧНОВЫЙ!=null) {

                   // TODO: 24.12.2021 ЗАПУСКАЕМ СИНХРОНИАЗУАЦИЮ ПОСЛЕ УСПЕШНОГО ПОЛУЧЕНИЯ КЛЮЧА И ЗАПИСИ ЕГО В БАЗУ ДЛЯ ONESIGNAL

                   new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(context).
                           МетодПовторногоЗапускаВсехWorkManager__ОДНОРАЗОВОЙСинхрониазцииданных(ПубличныйIDДляОдноразовойСинхрониазции,context);

                   Log.d(this.getClass().getName(), " ИЗ ВСЕХ ТАБЕЛЕЙ   ОДНОРАЗОВАЯ СИНХРОНИЗАЦИЯ ");
               }





           } catch (Exception e ) {
               //  Block of code to handle errors
               e.printStackTrace();
               ///метод запись ошибок в таблицу
               Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                       + Thread.currentThread().getStackTrace()[2].getLineNumber());
               new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                       Thread.currentThread().getStackTrace()[2].getLineNumber());

               // TODO: 11.05.2021 запись ошибок


           }

       }

       private void МетодУвеличениеВерсииДанныхПриСменеКлючаOneSingnal(Context context
       ,String ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL
       ,Integer РезультатОбновленияКлючаДляПервойТаблицыsettings_tabelssОбаview_onesignal)
               throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
           ////TODO УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННЫХ  В ТАБЛИЦЕ MODIFICATION CLIENT после успешной вствки ключа от ЗАПИСЬ ПЕРВОЙ ТАБЛИЦЫ

           try{

           Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДанныхПриПолученииНовогоКлючаONESINGLE=new Class_GRUD_SQL_Operations(context);

           Long  РезультатУвеличинаяВерсияПриУвеличенияПриПолученияКлючаONESINGLE =
                   class_grud_sql_operationsПовышаемВерсиюДанныхПриПолученииНовогоКлючаONESINGLE.new ChangesVesionData(context)
                           .МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table(
                                   ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL,
                                   "localversionandroid_version",
                                   context,
                                   new CREATE_DATABASE(context).getССылкаНаСозданнуюБазу());




           Log.i(this.getClass().getName(), "РезультатУвеличинаяВерсияПриУвеличенияПриПолученияКлючаONESINGLE"
                   +РезультатУвеличинаяВерсияПриУвеличенияПриПолученияКлючаONESINGLE);



           // TODO: 13.01.2022 посел усапкшной увеличение версии данных только по системной таблице   MODIFITATION_Client

           Integer Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицыДляОбменасOneSignal =
                   new Class_Engine_SQL(context).МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_Client(
                           РезультатОбновленияКлючаДляПервойТаблицыsettings_tabelssОбаview_onesignal ,ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL,
                           "Локальное",РезультатУвеличинаяВерсияПриУвеличенияПриПолученияКлючаONESINGLE,
                           new PUBLIC_CONTENT(context).МенеджерПотоков);


           Log.i(this.getClass().getName(), " Результат Изменеие Данных и Для Обмена в Таблица  обмена OneSignal   "+
                   " Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы "
                   +Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицыДляОбменасOneSignal+
                   "  ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL " +ТаблицаКоторуюнадоИзменитьВерсиюДанныхТАюдицы_VIEW_ONESIGNAL);


       } catch (Exception e ) {
           //  Block of code to handle errors
           e.printStackTrace();
           ///метод запись ошибок в таблицу
           Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                   + Thread.currentThread().getStackTrace()[2].getLineNumber());
           new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                   Thread.currentThread().getStackTrace()[2].getLineNumber());

           // TODO: 11.05.2021 запись ошибок


       }


       }


       @NonNull
       private Integer МетодПервыйОбоаботкиПервойТаблицыПриИзмененияКлюча_settings_tabelsОбаview_onesignal(Context context,
                                  String НовыйIdОТСервтераOneSignal,
                                  Class_GRUD_SQL_Operations class_grud_sql_operationsОбновлениеДляТаблицыOneSignal,
                                  Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДанныхДляOneSignal,
                                  CREATE_DATABASE create_databaseДЛяOneSignal, Integer ПубличныйIDДляФрагмента,
                                                                                          String ТаблицаОбрработкиВСдлужбеOneSignal)
               throws ExecutionException, InterruptedException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
           Integer РезультатОбновленияКлючаOneSignal = 0;


           try{
           ContentValues АдаптерВставкиПолученогоПубличногоID = new ContentValues();

               // TODO: 29.12.2021 one table

           // TODO: 15.12.2021  запусываем новый Индефикатор для Работы OneSignal

           Log.d(this.getClass().getName(), "НовыйIdОТСервтераOneSignal " + НовыйIdОТСервтераOneSignal+  " ТаблицаОбрработкиВСдлужбеOneSignal " +ТаблицаОбрработкиВСдлужбеOneSignal);


           АдаптерВставкиПолученогоПубличногоID.put("onesignal", НовыйIdОТСервтераOneSignal);





           ////TODO ДАТА
           String СгенерированованныйДатаДляЗАписиПолученогоОтСервреаIDПубличного=
                   new Class_Generation_Data(context).ГлавнаяДатаИВремяОперацийСБазойДанных();


           АдаптерВставкиПолученогоПубличногоID.put("date_update", СгенерированованныйДатаДляЗАписиПолученогоОтСервреаIDПубличного);

           // TODO: 29.12.2021

           АдаптерВставкиПолученогоПубличногоID.put("uuid", ПубличныйIDДляФрагмента);


           // TODO: 13.12.2021


           Long РезультатУвеличинаяВерсияДАныхЧата=0L;

           РезультатУвеличинаяВерсияДАныхЧата=         class_grud_sql_operationsПовышаемВерсиюДанныхДляOneSignal. new ChangesVesionData(context).
                   МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table(ТаблицаОбрработкиВСдлужбеOneSignal,"localversionandroid_version", context
                           , create_databaseДЛяOneSignal.getССылкаНаСозданнуюБазу());



               // TODO: 27.08.2021 само значние
               Log.w(context.getClass().getName(), "РезультатУвеличинаяВерсияДАныхЧата  получлили увеличиную верисю данных в чате новоом КЛЮЧЕ " + РезультатУвеличинаяВерсияДАныхЧата);

           //TODO  конец курант ча
           //////
           АдаптерВставкиПолученогоПубличногоID.put("current_table", РезультатУвеличинаяВерсияДАныхЧата);

           /////////


           ///TODO ОБНОЛВЕНИЕ

           // TODO: 06.09.2021  ПАРАМЕНТЫ ДЛЯ ОБНОВЛЕНИЯ

           class_grud_sql_operationsОбновлениеДляТаблицыOneSignal.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы",ТаблицаОбрработкиВСдлужбеOneSignal);
           //

           class_grud_sql_operationsОбновлениеДляТаблицыOneSignal.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("Флаг_ЧерезКакоеПолеОбновлением","user_update");




           ///
               class_grud_sql_operationsОбновлениеДляТаблицыOneSignal.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗнакФлагОбновления","uuid=");


           //

           class_grud_sql_operationsОбновлениеДляТаблицыOneSignal.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗначениеФлагОбновления", ПубличныйIDДляФрагмента);
           ///

           //

           class_grud_sql_operationsОбновлениеДляТаблицыOneSignal.
                   concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗнакФлагОбновления","=");

           ////TODO КОНТЕЙНЕР ДЛЯ ОБНОВЛЕНИЯ

           class_grud_sql_operationsОбновлениеДляТаблицыOneSignal.contentValuesДляSQLBuilder_Для_GRUD_Операций.putAll(АдаптерВставкиПолученогоПубличногоID);


           ///TODO РЕЗУЛЬТАТ ОБНОВЛЕНИЕ ДАННЫХ


           РезультатОбновленияКлючаOneSignal = 0;

           РезультатОбновленияКлючаOneSignal = (Integer)  class_grud_sql_operationsОбновлениеДляТаблицыOneSignal.
                   new UpdateData(context).updatedata(class_grud_sql_operationsОбновлениеДляТаблицыOneSignal. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                   class_grud_sql_operationsОбновлениеДляТаблицыOneSignal.contentValuesДляSQLBuilder_Для_GRUD_Операций,
                   new PUBLIC_CONTENT(context). МенеджерПотоков, create_databaseДЛяOneSignal.getССылкаНаСозданнуюБазу());


           // TODO: 15.12.2021  увеличиваем версию данных в таблице обшей модификацион клиенв
           Log.i(this.getClass().getName(), "  РезультатОбновленияКлючаOneSignal " +РезультатОбновленияКлючаOneSignal);
           ////TODO УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННЫХ  В ТАБЛИЦЕ MODIFICATION CLIENT


       } catch (Exception e ) {
           //  Block of code to handle errors
           e.printStackTrace();
           ///метод запись ошибок в таблицу
           Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                   + Thread.currentThread().getStackTrace()[2].getLineNumber());
           new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                   Thread.currentThread().getStackTrace()[2].getLineNumber());

           // TODO: 11.05.2021 запись ошибок


       }
           return РезультатОбновленияКлючаOneSignal;
       }




























       // TODO: 29.12.2021
         protected  Integer МетодПослеУспешнойОбновленияКлючаОтOneSignalИщемУдаляемДубли(Context context,
                                                                                         String ТаблицаКоторуюнадоДляПосикаИУдаленияБудлейКлбчейONESIGNAL,
                                                                                         Integer ПубличныйIDДляФрагмента
         ,String НовыйIdОТСервтераOneSignal) {

    Integer РЕзультаПосикаИУдаления=0;
           try{

               // TODO: 15.12.2021  увеличиваем версию данных в таблице обшей модификацион клиенв
               Log.i(this.getClass().getName(), "  пОИСК ИУДАЛЕНИЯ ДУБЛЕЙ В ТАБЛИЦАХ КЛЮЧЕЙ" +
                       "ТаблицаКоторуюнадоДляПосикаИУдаленияБудлейКлбчейONESIGNAL  "+ТаблицаКоторуюнадоДляПосикаИУдаленияБудлейКлбчейONESIGNAL+ " ПубличныйIDДляФрагмента " +ПубличныйIDДляФрагмента+
                        "  НовыйIdОТСервтераOneSignal " +НовыйIdОТСервтераOneSignal);
               ////TODO УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННЫХ  В ТАБЛИЦЕ MODIFICATION CLIENT




               Class_GRUD_SQL_Operations class_grud_sql_operationclass_grud_sql_operationsОчисткаsОчистакаталиц=new Class_GRUD_SQL_Operations(context);

               // TODO: 06.09.2021  ПАРАМЕНТЫ ДЛЯ удаление данных

               class_grud_sql_operationclass_grud_sql_operationsОчисткаsОчистакаталиц.
                       concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", ТаблицаКоторуюнадоДляПосикаИУдаленияБудлейКлбчейONESIGNAL);
               //

               class_grud_sql_operationclass_grud_sql_operationsОчисткаsОчистакаталиц.
                       concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("Флаг_ЧерезКакоеПолеУдаление", "onesignal <> ? AND  user_update =?");
            ///

             class_grud_sql_operationclass_grud_sql_operationsОчисткаsОчистакаталиц
                       .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗначениеФлагУдаление",НовыйIdОТСервтераOneSignal);
               class_grud_sql_operationclass_grud_sql_operationsОчисткаsОчистакаталиц
                       .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗначениеФлагУдалениеВторой", ПубличныйIDДляФрагмента);



               ///TODO РЕЗУЛЬТАТ ОБНОВЛЕНИЕ ДАННЫХ


               РЕзультаПосикаИУдаления = (Integer) class_grud_sql_operationclass_grud_sql_operationsОчисткаsОчистакаталиц.
                       new DeleteData(context).deletedata(class_grud_sql_operationclass_grud_sql_operationsОчисткаsОчистакаталиц.
                               concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                      new PUBLIC_CONTENT(context). МенеджерПотоков,new CREATE_DATABASE(context).getССылкаНаСозданнуюБазу());


               Log.i(this.getClass().getName(), "  РЕзультаПосикаИУдаления" +
                       РЕзультаПосикаИУдаления);






           } catch (Exception e ) {
               //  Block of code to handle errors
               e.printStackTrace();
               ///метод запись ошибок в таблицу
               Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                       + Thread.currentThread().getStackTrace()[2].getLineNumber());
               new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                       Thread.currentThread().getStackTrace()[2].getLineNumber());

               // TODO: 11.05.2021 запись ошибок


           }
           return РЕзультаПосикаИУдаления;
       }






   }
