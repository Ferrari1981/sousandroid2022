package com.dsy.dsu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.crypto.NoSuchPaddingException;

public class Class_Clears_Tables {

    Context contextДляКлассаОчисткиТаблиц;
//
      Handler handlerУдалениеТаблицПринудительно;


    Class_Engine_SQL Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = null;//

    CREATE_DATABASE Create_Database_СсылкаНАБазовыйКласс;

    // TODO: 24.02.2022




    public Class_Clears_Tables(Context context, Handler handlerУдалениеТаблицПринудительно) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        this.contextДляКлассаОчисткиТаблиц = context;
        //


       this. Class_Engine_SQLГдеНаходитьсяМенеджерПотоков=new Class_Engine_SQL(contextДляКлассаОчисткиТаблиц);

        ////


     this.   Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextДляКлассаОчисткиТаблиц);


this.handlerУдалениеТаблицПринудительно=handlerУдалениеТаблицПринудительно;


    }
    //функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ

    protected Integer ОчисткаТаблицДляПользователяЗапусксFaceApp(Context context,
                                                                 CompletionService МенеджерПотоковВнутрений,
                                                                 Activity activity)
            throws ExecutionException, InterruptedException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {

// TODO: 24.02.2022
        // TODO: 24.02.2022

        final Integer[] РезультатДобавленияДатыВерсииПослеУдаленияФинал = {0};
            ////
         Class_GRUD_SQL_Operations class_grud_sql_operationsОчистакаталиц = new Class_GRUD_SQL_Operations(activity);


        // TODO: 24.02.2022

        ProgressDialog progressDialogДляУдалениеТаблиц;
        // TODO: 26.10.2021
        // TODO: 26.10.2021
        progressDialogДляУдалениеТаблиц = new ProgressDialog(activity);


        //TODO перерд началом синхрониазции запускаем прорасс бар

        progressDialogДляУдалениеТаблиц.setTitle("Смена данных");

        progressDialogДляУдалениеТаблиц.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        progressDialogДляУдалениеТаблиц.setProgress(0);
        ///
        /// progressDialogДляУдаления.setMax(СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.size());


        progressDialogДляУдалениеТаблиц.setCanceledOnTouchOutside(false);

        //progressDialogДляУдаления.setMessage("Удалание...");

        progressDialogДляУдалениеТаблиц.setMessage("Удаление таблицы ..");

        // progressDialogДляУдаления. setIndeterminateDrawable(getApplicationContext().getResources().getDrawable(R.color.accent));
        ///
        progressDialogДляУдалениеТаблиц.show();

// TODO: 24.02.2022

        МетодВизуальнгоотображенияХодаУдаления(progressDialogДляУдалениеТаблиц,activity);



/*        HandlerThread handlerThread = new HandlerThread("Удаление Таблиц");
// TODO: 24.02.2022
        handlerThread.start();*/

// TODO: 09.09.2021 просто очистка таблиц
            // TODO: 19.03.2021 просто очистка таблиц без дат
            class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("errordsu1");//

            class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("successlogin");

            class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("settings_tabels");

            // TODO: 19.03.2021 разниза в том что таблицы ниже участвуют при обменен и им нужно устанивть пепрвоначальные даты после очистки

            class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("tabel");//
            ////
            class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("data_tabels");//

            class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("notifications");


            class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("fio_template");

            class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("templates");

            class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("chats");

            class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("data_chat");

            class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("view_onesignal");

        class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("chat_users");


        class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.offer("data_notification");
        // TODO: 24.02.2022
        

        Thread ПотокДляПрогрессПриУдаленииТаблиц =    new Thread(new Runnable() {
            public void run() {

        // TODO: 24.02.2022
        class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.stream().spliterator().forEachRemaining((текущаяТаблицаДляУдваления)-> {

              // TODO: 09.09.2021 loop
              try {
              ////

              // TODO: 09.09.2021 DELETE УДАЛЕНИЕ ТАБЛИЦ ПЕРЕД УМЕНЫ ПОЛЬЗОВАТЕЛЯ

              Integer РезультатУдалениеДанных=      ОчисткаТаблицысЗаписьюВMODIFITATION_Client( текущаяТаблицаДляУдваления.toString().trim(),context,МенеджерПотоковВнутрений);
              //
              Log.d(this.getClass().getName(), "РезультатУдалениеДанных " + РезультатУдалениеДанных+ " текущаяТаблицаДляУдваления " +текущаяТаблицаДляУдваления);
              //

              // TODO: 09.09.2021  действие второе добалянеим дату

               Integer   РезультатДобавленияДатыВерсииПослеУдаления=           МетодПослеУдаленияДобавляемДатуВерсии(текущаяТаблицаДляУдваления.toString().trim(),МенеджерПотоковВнутрений);
                  //
                  Log.d(this.getClass().getName(), "РезультатДобавленияДатыВерсииПослеУдаления " + РезультатДобавленияДатыВерсииПослеУдаления);

                  // TODO: 19.03.2021 разниза в том что таблицы ниже участвуют при обменен и им нужно устанивть пепрвоначальные даты после очистки

                  // TODO: 21.02.2022
                  // TODO: 09.09.2021 DELETE УДАЛЕНИЕ ТАБЛИЦ ПЕРЕД УМЕНЫ ПОЛЬЗОВАТЕЛЯ

                  // TODO: 21.02.2022

                 // finalHandlerУдалениеТаблицПринудительно.sendEmptyMessage(1);
                  //



/*

                  messageудаление[0] =finalHandlerУдалениеТаблицПринудительно.obtainMessage(РезультатУдалениеДанных,текущаяТаблицаДляУдваления);
                  // TODO: 24.02.2022
                  finalHandlerУдалениеТаблицПринудительно.sendMessage( messageудаление[0]);

*/



                  handlerУдалениеТаблицПринудительно.obtainMessage(РезультатУдалениеДанных,текущаяТаблицаДляУдваления).sendToTarget();


                  Message message=new Message();
                  // TODO: 25.02.2022
                  message.obj=текущаяТаблицаДляУдваления;
                  // TODO: 24.02.2022
                  handlerУдалениеТаблицПринудительно.sendMessageAtFrontOfQueue(message);


                  TimeUnit.MILLISECONDS.sleep(500);

                  Log.d(context.getClass().getName(), "messageудаление " +текущаяТаблицаДляУдваления);


              if (РезультатУдалениеДанных>0) {

                  // TODO: 21.02.2022

              if (РезультатУдалениеДанных>0) {
                  // TODO: 21.02.2022
                      РезультатДобавленияДатыВерсииПослеУдаленияФинал[0]++;
                  }


                  ////

                  Object КакуюТаблицуУдаляемИзНеДанные= class_grud_sql_operationsОчистакаталиц.БлокирующаяОчереть.peek();
                  // TODO: 21.02.2022
                  //
                  Log.d(this.getClass().getName(), "КакуюТаблицуУдаляемИзНеДанные " + КакуюТаблицуУдаляемИзНеДанные);
                  // TODO: 09.09.2021 выидываем отработаную названия таблицы

                          // TODO: 21.02.2022


              }

                  // TODO: 21.02.2022



          } catch (SQLException | ExecutionException | InterruptedException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(contextДляКлассаОчисткиТаблиц).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());

            }
          });
                // TODO: 24.02.2022

                progressDialogДляУдалениеТаблиц.dismiss();
                ////
                progressDialogДляУдалениеТаблиц.cancel();

                handlerУдалениеТаблицПринудительно.removeMessages(1);

                handlerУдалениеТаблицПринудительно.removeCallbacks(null);


                // TODO: 24.02.2022
                МетодПослеУдаленияТаблицЗапускаемСледуюЩеЗанимАктивтиИмяИПароль(activity);
        ///////////////////////
            }
            //////todo
        });

        // TODO: 24.02.2022

        ПотокДляПрогрессПриУдаленииТаблиц.start();
        // TODO: 24.02.2022


        // TODO: 26.10.2021

            ////
        return    РезультатДобавленияДатыВерсииПослеУдаленияФинал[0];
    }


    // TODO: 24.02.2022 метод визуального отобоажегия хода удаения
   void МетодВизуальнгоотображенияХодаУдаления(ProgressDialog progressDialogДляУдалениеТаблиц,
                                               Activity activity) {
       // TODO: 24.02.2022
       try{
       handlerУдалениеТаблицПринудительно = new Handler() {
           public void handleMessage(android.os.Message msg) {


                   // обновляем TextView
                   progressDialogДляУдалениеТаблиц.setMessage("Удаление таблицы ..."+msg.obj);
                   // TODO: 24.02.2022
                   Log.w(this.getClass().getName(), "  Удаление таблицы .. " +
                           "  doOnTerminate Синхронизация Данных с Web-сервера ДСУ-1 ? msg.what "
                           + msg.what+ " msg.obj " +msg.obj);

           };
       };
           // TODO: 24.02.2022
       } catch (Exception e) {
           e.printStackTrace();
///метод запись ошибок в таблицу
           Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread()
                   .getStackTrace()[2].getMethodName() + " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
           new   Class_Generation_Errors(activity).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                   this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
       }
    }

    // TODO: 24.02.2022

    private void МетодПослеУдаленияТаблицЗапускаемСледуюЩеЗанимАктивтиИмяИПароль(Activity activity) {

        Intent Интент_Меню=new Intent();
        try {

            handlerУдалениеТаблицПринудительно.post(new Runnable() {
                @Override
                public void run() {
                    // TODO: 24.02.2022


                    ////////
                    /// КакойРежимСинхрониазции = ИнтентКакаяПоСчетуСинхронизация.getStringExtra("РежимЗапускаСинхронизации");
                    Toast.makeText(activity, " Удаляемая таблица прошло успешно !!! " , Toast.LENGTH_SHORT).show();

                    Интент_Меню.putExtra("РежимЗапускаСинхронизации","ПовторныйЗапускСинхронизации");

                    /////TODO ЗАПУСКАМ ОБНОЛВЕНИЕ ДАННЫХ С СЕРВЕРА ПЕРЕРД ЗАПУСКОМ ПРИЛОЖЕНИЯ ВСЕ ПРИЛОЖЕНИЯ ДСУ-1
                    Интент_Меню.setClass(activity, MainActivity_Tabels_Users_And_Passwords.class); //MainActivity_Visible_Async //MainActivity_Face_App

                    Интент_Меню.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//////FLAG_ACTIVITY_SINGLE_TOP

                    activity. startActivity(Интент_Меню);

                    ////TODO ДАННАЯ КОМАНДА ПЕРЕКРЫВАЕТ НЕ ЗАПУСКАЕМОЕ АКТИВТИ А АКТИВТИ КОТОРЕ ЕГО ЗАПУСТИЛО
                    activity. finish();


                    // TODO: 24.02.2022

                    Toast.makeText(activity,
                            " Успешное смена данных !!! "    , Toast.LENGTH_SHORT).show();
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread()
                    .getStackTrace()[2].getMethodName() + " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(activity).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }






    // TODO: 09.09.2021 delete data for tabels
    protected Integer ОчисткаТаблицысЗаписьюВMODIFITATION_Client(String ИмяТаблицы,Context context
            ,CompletionService МенеджерПотоковВнутрений) throws ExecutionException, InterruptedException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
//
        Integer РезультатУдалениеОчисткиТаблиц = 0;



        try {
            //
            Log.d(this.getClass().getName(), "  ИмяТаблицы " + ИмяТаблицы);
            // TODO: 09.09.2021 первое ДЕЙСТВИЕ УДАЛЕНИЕ ТАБЛИЦЫ
Class_GRUD_SQL_Operations class_grud_sql_operationclass_grud_sql_operationsОчисткаsОчистакаталиц=new Class_GRUD_SQL_Operations(context);

            // TODO: 06.09.2021  ПАРАМЕНТЫ ДЛЯ удаление данных

            class_grud_sql_operationclass_grud_sql_operationsОчисткаsОчистакаталиц.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", ИмяТаблицы);
            //
            ///TODO РЕЗУЛЬТАТ ОБНОВЛЕНИЕ ДАННЫХ


            РезультатУдалениеОчисткиТаблиц = (Integer) class_grud_sql_operationclass_grud_sql_operationsОчисткаsОчистакаталиц.
                    new DeleteData(contextДляКлассаОчисткиТаблиц).deletedataAlltable(class_grud_sql_operationclass_grud_sql_operationsОчисткаsОчистакаталиц.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    МенеджерПотоковВнутрений,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

            ///
            ///
            Log.d(context.getClass().getName(), " РезультатУдалениеОчисткиТаблиц" + "--" + РезультатУдалениеОчисткиТаблиц);/////



    /*        // TODO: 09.09.2021   __old

            ССылкаНаСозданнуюБазу.execSQL("delete from " + ИмяТаблицы+"");
*/

        } catch (SQLException e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(contextДляКлассаОчисткиТаблиц).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

        }
        return РезультатУдалениеОчисткиТаблиц;
    }





    // TODO: 09.09.2021  метод добалвние в таблице даты

    Integer МетодПослеУдаленияДобавляемДатуВерсии(String ИмяТаблицы,CompletionService МенеджерПотоковВнутрений) {


        Integer ДобавлениеДатыПослеУдалниеТаблиц = 0;

        try {

            ContentValues contentValuesОчисткаТаблицДобавлениеДат = new ContentValues();
            ///
            contentValuesОчисткаТаблицДобавлениеДат.put("localversionandroid", "1900-01-10 00:00:00");
            ///
            contentValuesОчисткаТаблицДобавлениеДат.put("versionserveraandroid", "1900-01-10 00:00:00");

            contentValuesОчисткаТаблицДобавлениеДат.put("localversionandroid_version", 0);
            ///
            contentValuesОчисткаТаблицДобавлениеДат.put("versionserveraandroid_version", 0);






            //////TODO вторым флагом запрещем при первом запуске заниматься обновдениям  только вставка  при синхронизации ==false значить обнолвение включено ,,,,,
            // ЗНАЧАЕТ ЧТО ИДЕТ ТОЛЬКО ВСТАВКА ДАННЫХ TRUE
            //   if (     finalФлагПриПервомЗапускеОграничитьОперациюТолькоВставка == true ) {

            Class_GRUD_SQL_Operations  class_grud_sql_operationsПослеУдаленияДобавляемДатуВерсии=new Class_GRUD_SQL_Operations(contextДляКлассаОчисткиТаблиц);
            ///TODO ОБНОЛВЕНИЕ

            // TODO: 06.09.2021  ПАРАМЕНТЫ ДЛЯ ОБНОВЛЕНИЯ

            class_grud_sql_operationsПослеУдаленияДобавляемДатуВерсии.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","MODIFITATION_Client");
            //

            class_grud_sql_operationsПослеУдаленияДобавляемДатуВерсии.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("Флаг_ЧерезКакоеПолеОбновлением","name");

            ///
            //

            class_grud_sql_operationsПослеУдаленияДобавляемДатуВерсии.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗначениеФлагОбновления",ИмяТаблицы);
            ///

            //

            class_grud_sql_operationsПослеУдаленияДобавляемДатуВерсии.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗнакФлагОбновления","=");

            ////TODO КОНТЕЙНЕР ДЛЯ ОБНОВЛЕНИЯ

            class_grud_sql_operationsПослеУдаленияДобавляемДатуВерсии.contentValuesДляSQLBuilder_Для_GRUD_Операций.putAll(contentValuesОчисткаТаблицДобавлениеДат);



            ///TODO РЕЗУЛЬТАТ ОБНОВЛЕНИЕ ДАННЫХ


            ДобавлениеДатыПослеУдалниеТаблиц= (Integer)  class_grud_sql_operationsПослеУдаленияДобавляемДатуВерсии.
                    new UpdateData(contextДляКлассаОчисткиТаблиц).updatedata(class_grud_sql_operationsПослеУдаленияДобавляемДатуВерсии. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    class_grud_sql_operationsПослеУдаленияДобавляемДатуВерсии.contentValuesДляSQLBuilder_Для_GRUD_Операций,
                    МенеджерПотоковВнутрений,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());



            Log.d(this.getClass().getName(), " сработала ...  обнуление версии в MODIFITATION_Client для таблицы " + ИмяТаблицы+
                    " ДобавлениеДатыПослеУдалниеТаблиц  " +ДобавлениеДатыПослеУдалниеТаблиц);




            // TODO: 09.09.2021   ___old

            ////////
            //   long ОчисткаТаблиц=ССылкаНаСозданнуюБазу.update("MODIFITATION_Client", contentValuesОчисткаТаблиц, "name=?", new String[]{ИмяТаблицы}); ////вставка данных имя и пароль

   /*         ОчисткаТаблиц = new    ();
            ОчисткаТаблиц.setTables("MODIFITATION_Client");

*/
/*            /////////////
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                ОчисткаТаблиц =    ОчисткаТаблиц.
                        update(ССылкаНаСозданнуюБазу, contentValuesОчисткаТаблиц, "name=?", new String[]{ИмяТаблицы});
            } else {

                ОчисткаТаблиц = ССылкаНаСозданнуюБазу.update("MODIFITATION_Client", contentValuesОчисткаТаблиц, "name=?", new String[]{ИмяТаблицы});
            }


            if (ОчисткаТаблиц > 0) {
                Log.d(this.getClass().getName(), " сработала ...  обнуление версии в MODIFITATION_Client для таблицы " + ИмяТаблицы);

            }*/

            //TODO тест код





        } catch (SQLException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(contextДляКлассаОчисткиТаблиц).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

        }
        ///////
        return ДобавлениеДатыПослеУдалниеТаблиц;
    }
}