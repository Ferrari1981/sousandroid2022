
//////КНАЧАЛО  КЛАССА ПО СОЗДАНИЮ СХЕМЫ ДАННЫХ
package com.dsy.dsu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.Date;


//этот класс создает базу данных SQLite
public class CREATE_DATABASE extends SQLiteOpenHelper{ ///SQLiteOpenHelper

    /////TODO ВЕРСИЯ ДАННЫХ МЕНЯЕМ И УДАЛЯЕМ ДАННЫЕ И ЗАГРУЖАЕМ НОВЫЕ
    private static final int VERSION = 734;//ПРИ ЛЮБОМ ИЗМЕНЕНИЕ В СТРУКТУРЕ БАЗЫ ДАННЫХ НУЖНО ДОБАВИТЬ ПЛЮС ОДНУ ЦИФРУ К ВЕРСИИ 1=1+1=2 ИТД.1


    Context contextСозданиеБАзы;

 // 'ЭТА СССЫЛКА ДЛЯ ВСЕХ НА ПОДКЛЮЧЕНИ ДАННЫХ // static   SQLiteDatabase ССылкаНаСозданнуюБазу=null;// 'ЭТА СССЫЛКА ДЛЯ ВСЕХ НА ПОДКЛЮЧЕНИ ДАННЫХ

    ///////
//static private  SQLiteDatabase ССылкаНаСозданнуюБазу;
     private    SQLiteDatabase ССылкаНаСозданнуюБазу;

// TODO: 28.08.2021 менеджер потоков для фоновых операций GRUD



///TODO ДЛЯ ОБРАБОТКИ КОЛИЧЕСТВА ТАБЛИЦ В СИНХРОНИЗХАЦИИ


    public SQLiteDatabase getССылкаНаСозданнуюБазу() {
        //////
        Log.d(this.getClass().getName()," get () БАЗА  ДАННЫХ   ДСУ-1 ОТКРЫТА ССылкаНаСозданнуюБазу.isOpen()  "
                +ССылкаНаСозданнуюБазу);
        /////
        return ССылкаНаСозданнуюБазу;
    }
    ////////////////////


    ///////КОНСТРУКТОР главного класса по созданию базы данных
    public CREATE_DATABASE( @NotNull Context context) {/////КОНСТРУКТОР КЛАССА ПО СОЗДАНИЮ БАЗЫ ДАННЫХ


        super(context, "Database DSU-1.db", null, VERSION ); // определяем имя базы данных  и ее версию
        ///

        try{
            contextСозданиеБАзы=context;
          ///TODO главное подключение  ССылкаНаСозданнуюБазу=  this.getWritableDatabase();;// 'ЭТА СССЫЛКА ДЛЯ ВСЕХ НА ПОДКЛЮЧЕНИ ДАННЫХ

            if (ССылкаНаСозданнуюБазу==null  ) {
                ///////

                //todo connection new
                ССылкаНаСозданнуюБазу = this.getWritableDatabase(); //ссылка на схему базы данных;//ссылка на схему базы данных ГЛАВНАЯ ВСТАВКА НА БАЗУ ДСУ-1
                //////

                Log.d(this.getClass().getName()," БАЗА  ДАННЫХ   ДСУ-1 ОТКРЫВАЕМ  ССылкаНаСозданнуюБазу==null   "
                            +ССылкаНаСозданнуюБазу.isOpen());
                }else{
                //TODO connection  else is onen false
                if (!ССылкаНаСозданнуюБазу.isOpen()) {


                    //todo connection new
                   ССылкаНаСозданнуюБазу = this.getWritableDatabase(); //ссылка на схему базы данных;//ссылка на схему базы данных ГЛАВНАЯ ВСТАВКА НА БАЗУ ДСУ-1
                    //////

                    Log.d(this.getClass().getName()," БАЗА  ДАННЫХ   ДСУ-1 ОТКРЫВАЕМ  ССылкаНаСозданнуюБазу.isOpen()  "
                            +ССылкаНаСозданнуюБазу.isOpen());
                }


            }
////////////




        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
           // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
          this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

        }
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);

        try{

   /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setIdleConnectionTimeout(180000);
        }*/

        setWriteAheadLoggingEnabled(true);
        // TODO: 29.10.2021


            Log.d(this.getClass().getName(),"   onOpen БАЗА  ДАННЫХ   ДСУ-1 настройки базы");


    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

    }
    }






  /*
    protected void МетодЗапускаетРежимРаботыБазыДанных(String ВыбранныРежимПользователем) {
        Cursor   csr = null;///WAL TRUNCATE DELETE
        try {
            csr =ССылкаНаСозданнуюБазу.rawQuery("PRAGMA journal_mode = " + ВыбранныРежимПользователем.trim() +  ";", null);

            csr = ССылкаНаСозданнуюБазу.rawQuery("PRAGMA cache=shared", null);


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());


        } finally {
            //
            csr.close();
        }
    }
*/













    // TODO
    //  Cоздание ТАблиц

    @Override
    public void onCreate(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        try {

            Log.d(this.getClass().getName(), "Запущен.... метод  on public void onCreate(SQLiteDatabase ССылкаНаСозданнуюБазу)  ; ");
            /////////ЗАПУСКАМ  ТРАНЗАКЦИЮ ПО СОЗДАНИЮ ТАБЛИЦ ДЛЯ БАЗЫ ДАННЫХ

          //  ССылкаНаСозданнуюБазу.





         //   ССылкаНаСозданнуюБазу.yieldIfContendedSafely();
            ///////
////
            //ССылкаНаСозданнуюБазу.setMaxSqlCacheSize(100);

         /*   // ССылкаНаСозданнуюБазу.rawExecSQL("DETACH DATABASE encrypted;");

            ////
            ССылкаНаСозданнуюБазу.setPageSize(90000000);*/
            ///

///---ТУТ БЛОК ТЕХНИЧЕСКИХ ТАБЛИЦ
            МетодСозданиеТаблицыОшибок(ССылкаНаСозданнуюБазу);


            //таблица SuccessLogin
            МетодСозданиеТаблицыЛогинов(ССылкаНаСозданнуюБазу);


            //таблица MODIFITATION_Client
            МетодСозданиеOLD_ТаблицыОшибок(ССылкаНаСозданнуюБазу);


            //таблица MODIFITATION_Client
            методСозданиеТаблицыМодификацияДанныхКлиента(ССылкаНаСозданнуюБазу);

///---ТУТ КОНЕЦ  БЛОК ТЕХНИЧЕСКИХ ТАБЛИЦ
   /*
        //  ССылкаНаСозданнуюБазу.execSQL("drop table  if exists MODIFITATION_Client");//test
            ССылкаНаСозданнуюБазу.execSQL("Create table  if not exists MODIFITATION_Client (" +
                    "name  TEXT NOT NULL," +
                    "localversionandroid NUMERIC ," +
                    " versionserveraandroid NUMERIC  )");

            /////todo встака данных по умолчанию
            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO MODIFITATION_Client (name) VALUES('organization')");
            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO MODIFITATION_Client (name) VALUES('depatment')");
            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO MODIFITATION_Client (name) VALUES('fio')");
            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO MODIFITATION_Client (name) VALUES('region')");
            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO MODIFITATION_Client (name) VALUES('cfo')");
            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO MODIFITATION_Client (name) VALUES('tabels')");
            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO MODIFITATION_Client (name) VALUES('notification')");
            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO MODIFITATION_Client (name) VALUES('Templates')");
            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO MODIFITATION_Client (name) VALUES('Fio_Template')");

            ////////
            ССылкаНаСозданнуюБазу.execSQL("UPDATE MODIFITATION_Client SET localversionandroid = '1900-01-10 00:00:00',versionserveraandroid ='1900-01-10 00:00:00' WHERE name IN ('tabels','notification','Templates','Fio_Template')");



            ////
*/



      /*      //таблица MODIFITATION_Client
            //ССылкаНаСозданнуюБазу.execSQL("drop table  if exists MODIFITATION_Client");//test
            ССылкаНаСозданнуюБазу.execSQL("Create table  if not exists MODIFITATION_Client (" +
                    "name  TEXT NOT NULL " +
                    ",  localversionandroid NUMERIC DEFAULT '1900-01-10 00:00:00', " +
                    "versionserveraandroid NUMERIC DEFAULT '1900-01-10 00:00:00'   )");*/
            //////////
            Log.d(this.getClass().getName(), " сработала ... INSERT  INTO MODIFITATION_Client");

///---ТУТ КОНЕЦ  БЛОК ТЕХНИЧЕСКИХ ТАБЛИЦ














///// ---ТУТ ДЕЙСТВУЮЩИЕ ТАБЛИЦЫ ПРОЕКТА ТАБЕЛЬНЫЙ УЧЁТ ///// ---ТУТ ДЕЙСТВУЮЩИЕ ТАБЛИЦЫ ПРОЕКТА ТАБЕЛЬНЫЙ УЧЁТ





            //таблица organization            //таблица organization            //таблица organization            //таблица organization
            ССылкаНаСозданнуюБазу.execSQL("drop table  if exists organization");//test

            /////
            ССылкаНаСозданнуюБазу.execSQL("Create table if not exists organization (" +
                    "id  INTEGER    ," +
                    " name TEXT  ," +
                    " fullname  TEXT ," +
                    " inn TEXT ," +
                    " kpp  TEXT  ," +
                    " date_update  NUMERIC," +
                    "  user_update   INTEGER ," +
                    " chosen_organization INTEGER ," +
                    " current_table NUMERIC DEFAULT 0  )");
            Log.d(this.getClass().getName(), " сработала ...  создание таблицы organization");


            //таблица depatment         //таблица depatment         //таблица depatment         //таблица depatment
            ССылкаНаСозданнуюБазу.execSQL("drop table  if exists depatment");//test
            ССылкаНаСозданнуюБазу.execSQL("Create table if not exists depatment (" +
                    "id  INTEGER    ," +
                    " name TEXT  ," +
                    " organization INTEGER ," +
                    " date_update NUMERIC," +
                    " user_update TEXT," +
                    " current_table NUMERIC DEFAULT 0  ," +
                    "FOREIGN KEY(organization) REFERENCES organization  (id)  ON UPDATE CASCADE)");
            Log.d(this.getClass().getName(), " сработала ...  создание таблицы depatment");






            //таблица   fio        //таблица   fio         //таблица   fio         //таблица   fio
            МетодСозданиеТаблицыФИО(ССылкаНаСозданнуюБазу);





            //таблица  cfo      //таблица   cfo     //таблица cfo      //таблица   cfo
            ССылкаНаСозданнуюБазу.execSQL("drop table  if exists   cfo");//test
            ССылкаНаСозданнуюБазу.execSQL("Create table if not exists   cfo (" +
                    "id  INTEGER     ," +
                    " name TEXT ," +
                    " region  INTEGER ," +
                    " boss  INTEGER ," +
                    " kod TEXT  ," +
                    " date_update NUMERIC  ," +
                    " user_update INTEGER  ," +
                    " closed INTEGER  ," +
                    " current_table NUMERIC DEFAULT 0 ," +
                    " organization INTEGER DEFAULT 1 ," +
                    "FOREIGN KEY(boss) REFERENCES fio   (_id)  ON UPDATE CASCADE)");
            Log.d(this.getClass().getName(), " сработала ...  создание таблицы   cfo");





            //таблица  region     //таблица   cfo     //таблица cfo      //таблица   cfo
            ССылкаНаСозданнуюБазу.execSQL("drop table  if exists  region");//test
            ССылкаНаСозданнуюБазу.execSQL("Create table if not exists   region (" +
                    "id  INTEGER     ," +
                    " name TEXT ," +
                    " date_update NUMERIC  ," +
                    " user_update INTEGER ," +
                    " current_table NUMERIC  DEFAULT 0 )");
            Log.d(this.getClass().getName(), " сработала ...  создание таблицы  region");






            //таблица tabels   //таблица tabels   //таблица tabels   //таблица tabels  ///"_id  INTEGER    ," +
         МетодСозданияТаблицыТабелей(ССылкаНаСозданнуюБазу);


// TODO: 25.08.2021  создание новых двух таблиц для табеля раздваиваем таболицу на две табллицы табель и дата табеля
            МетодСоздания_ТаблицыТабель(ССылкаНаСозданнуюБазу);


            // TODO: 25.08.2021  создание новых двух таблиц для табеля раздваиваем таболицу на две табллицы табель и дата табеля

                    МетодСоздания_ТаблицыДатаТабель(ССылкаНаСозданнуюБазу);



















            /////

            // todo таблица  metki_tabel
            МетодСозданиеМетокТабеля(ССылкаНаСозданнуюБазу);





            МетодСозданиеSettingTabels(ССылкаНаСозданнуюБазу);


            //            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO settings_tabels (metka,fullname_metka,id) VALUES('В','Выходной','1')");
//            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO settings_tabels (metka,fullname_metka,id) VALUES('О','Отпуск','2')");
//            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO settings_tabels (metka,fullname_metka,id) VALUES('Б','Больничный','3')");
//            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO settings_tabels (metka,fullname_metka,id) VALUES('А','Отпуск без оплаты','4')");
//            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO settings_tabels (metka,fullname_metka,id) VALUES('П','Прогулы','5')");
//            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO settings_tabels (metka,fullname_metka,id) VALUES('Р','Ремонт','6')");
//            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO settings_tabels (metka,fullname_metka,id) VALUES('Д','Дежурство','7')");

            ////////
            Log.d(this.getClass().getName(), " сработала ...  создание таблицы settings_tabels");
            МетодСозданиеУведомленийИлиЗадания(ССылкаНаСозданнуюБазу);


            // todo таблица Notifications ///Результат_ВставкаДанныхДатойDate_WORk
            ССылкаНаСозданнуюБазу.execSQL("drop table  if exists date_work");//test
            ССылкаНаСозданнуюБазу.execSQL("Create table if not exists    date_work  (" +
                    "id  INTEGER  ," +
                    "date_work NUMERIC,"+
                    " date_update NUMERIC)");
            /////todo встака данных по умолчанию
            /////todo встака данных по умолчанию
            // ССылкаНаСозданнуюБазу.execSQL("INSERT INTO date_work (id) VALUES('1')");
            ////////
            Log.d(this.getClass().getName(), " сработала ...  создание таблицы date_work");


            // todo таблица Templates
            ССылкаНаСозданнуюБазу.execSQL("drop table  if exists templates");//test
            ССылкаНаСозданнуюБазу.execSQL("Create table if not exists    templates  (" +
                    "id  INTEGER ," +
                    " name_templates TEXT  ," +
                    " user_update INTEGER ,"+
                    " date_update NUMERIC,"+
                    " uuid  NUMERIC UNIQUE  ," +
                    " status_send  TEXT," +
                    " current_table NUMERIC  DEFAULT 0 ) ");

            /////todo встака данных по умолчанию

            Log.d(this.getClass().getName(), " сработала ...  создание таблицы Templates");

            // todo таблица Fio_Template
            МетодСозданиеТаблицыFio_TEmplay(ССылкаНаСозданнуюБазу);

            Log.d(this.getClass().getName(), " сработала ...  создание таблицы Fio_Template");







            // todo таблица Code_For_Chats_КодДля_Чата
            МетодСозданияТаблицаChats(ССылкаНаСозданнуюБазу);


            // todo таблица Fio_Template
            МетодСозданияТаблицыData_Chat(ССылкаНаСозданнуюБазу);


            // TODO: 19.03.2021 запуск создание таблиц




///////// КОНЕЦ ФИКСИРУЕМ И ЗАВЕРШАЕМ ТРАНЗАКЦИЮ ПО СОЗДАНИЮ ТАБЛИЦ ДЛЯ БАЗЫ ДАННЫХ





            /////TODO СТАРЫЙ ТЕСТ КОД
/*
                    ССылкаНаСозданнуюБазу.execSQL("drop view  if exists viewtabel");//test
            //ВИД View_TABEL
            ССылкаНаСозданнуюБазу.execSQL("CREATE VIEW if not exists viewtabel AS  SELECT             tabels.id,  tabels.fio,  tabels.cfo,  tabels.year_tabels, " +
                    " tabels.month_tabels,  tabels.d1,  tabels.d2,  tabels.d3,  tabels.d4,  tabels.d5,  tabels.d6,  tabels.d7,  tabels.d8, \n" +
                    "                          tabels.d9,  tabels.d10,  tabels.d11,  tabels.d12,  tabels.d13,  tabels.d14,  tabels.d15,  tabels.d16, " +
                    " tabels.d17,  tabels.d18,  tabels.d19,  tabels.d21,  tabels.d20,  tabels.d22, \n" +
                    "                          tabels.d23,  tabels.d24,  tabels.d27,  tabels.d26,  tabels.d25,  tabels.d29,  tabels.d28,  tabels.d30, " +
                    " tabels.d31,  tabels.uuid,  tabels.date_update,  tabels.status_send, \n" +
                    "                          tabels.department,  tabels.user_update,  tabels.organizations,  tabels.nametabel,  fio.BirthDate,  fio.snils,  fio.name\n" +
                    "FROM             tabels LEFT OUTER JOIN\n" +
                    "                          fio ON  tabels.fio =  fio.uuid");
            Log.d(this.getClass().getName(), " сработала ...  создание вид  viewtabel");
*/




//// TODO ТУТ СОЗДАЕМ ВИДЫ ДАННЫХ

            // ССылкаНаСозданнуюБазу.execSQL("drop view  if exists viewtabel");//test
            //ВИД View_TABEL
            МетодСозданияViewТабеля(ССылкаНаСозданнуюБазу);








//// TODO ТУТ СОЗДАЕМ ВИДЫ ДАННЫХ
            //   ССылкаНаСозданнуюБазу.execSQL("drop view  if exists notification_insider");//test
            //ВИД View_TABEL
            ССылкаНаСозданнуюБазу.execSQL("drop VIEW  if exists notification_insider");//test
            ////
            ССылкаНаСозданнуюБазу.execSQL("CREATE VIEW if not exists notification_insider AS  SELECT notifications.id," +
                    " notifications.user_update, notifications.date_update,   notifications.clock," +
                    "notifications.date_start,notifications.message,date_work.date_work  FROM" +
                    "     notifications  JOIN date_work ON notifications.id = date_work.id");
            //////
            Log.d(this.getClass().getName(), " сработала ...  создание вид  notification_insider");








            МетодСозданияПольЗовательДЛяЧата(ССылкаНаСозданнуюБазу);




            МетодСозданияВидаЧатаViewChat(ССылкаНаСозданнуюБазу);



            МетодСозданиеview_onesignal(ССылкаНаСозданнуюБазу);




            МетодСозданиеУведомленийИлиДАТАЗадания(ССылкаНаСозданнуюБазу);

            МетодСозданияВидаЗадания(ССылкаНаСозданнуюБазу);




        /*    ССылкаНаСозданнуюБазу.execSQL("drop view  if exists viewtabeladapter");//test
            //ВИД View_TABEL
            ССылкаНаСозданнуюБазу.execSQL("CREATE VIEW if not exists viewtabeladapter AS  SELECT tabels.id, tabels.fio, tabels.cfo,  tabels.year_tabels,tabels.month_tabels, tabels.d1," +
                    " tabels.d2, tabels.d3, tabels.d4, tabels.d5," +
                    " tabels.d6, tabels.d7, tabels.d8, tabels.d9, \n" +
                    "                  tabels.d10, tabels.d11, tabels.d12, tabels.d13, tabels.d14, tabels.d15, tabels.d16, tabels.d17," +
                    " tabels.d18, tabels.d19, tabels.d20, tabels.d21, tabels.d22, tabels.d23, tabels.d24, \n" +
                    "                  tabels.d25, tabels.d26, tabels.d27, tabels.d28, tabels.d29, tabels.d30," +
                    " tabels.d31, tabels.uuid," +
                    " tabels.date_update, tabels.status_send, tabels.department, tabels.user_update, tabels.organizations, tabels.nametabel, \n" +
                    "                  fio.BirthDate, fio.snils,fio.name,_id._id  FROM     tabels LEFT OUTER JOIN fio ON tabels.fio = fio.uuid AND _id  LEFT OUTER JOIN fio ON _id._id = fio.id");
            Log.d(this.getClass().getName(), " сработала ...  создание вид  viewtabeladapter");*/









            //end thread-2*/
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());

              // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
          this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

;
            ////

        }
    }

    private void МетодСозданиеУведомленийИлиЗадания(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        // todo таблица Notifications
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists notifications");//test
        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists    notifications  (" +
                "id  INTEGER ," +
                " date_update NUMERIC,"+
                " user_update INTEGER ,"+
                "uuid  NUMERIC UNIQUE ,"+
                "current_table  NUMERIC DEFAULT 0," +
                " id_user INTEGER  )");

        /////todo встака данных по умолчанию

        ////////
        Log.d(this.getClass().getName(), " сработала ...  создание таблицы Notifications");
    }


    private void МетодСозданиеУведомленийИлиДАТАЗадания(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        // todo таблица Notifications
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists data_notification");//test
        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists    data_notification  (" +
                "id  INTEGER ," +
                " message  NUMERIC ," +
                " date_start NUMERIC ," +
                " clock NUMERIC," +
                " date_update NUMERIC," +
                "rights INTEGER   ," +
                "uuid  NUMERIC UNIQUE ," +
                "current_table  NUMERIC DEFAULT 0," +
                " status_write INTEGER DEFAULT 0 ," +
                " uuid_notifications NUMERIC , " +
                " type_tasks TEXT ," +
                " head_message  TEXT )");

        /////todo встака данных по умолчанию

        ////////
        Log.d(this.getClass().getName(), " сработала ...  создание таблицы Notifications");
    }



    private void МетодСозданиеТаблицыFio_TEmplay(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists fio_template");//test

        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists    fio_template  (" +
                "id  INTEGER ," +
                " uuid  NUMERIC UNIQUE," +
                " fio_template NUMERIC ," +
                "fio_uuid  NUMERIC   ,"+
                " date_update NUMERIC,"+
                " user_update INTEGER," +
                " current_table NUMERIC  DEFAULT 0 ," +
                " status_send  TEXT ," +
                "FOREIGN KEY(fio_uuid  ) REFERENCES fio (uuid)  ON UPDATE CASCADE," +
                "FOREIGN KEY( fio_template  ) REFERENCES templates (uuid)  ON UPDATE CASCADE ," +
                "FOREIGN KEY( fio_template  ) REFERENCES templates (uuid)   ON DELETE CASCADE," +
                "PRIMARY KEY(fio_template,fio_uuid )) ");

        Log.d(this.getClass().getName(), " сработала ...  создание таблицы Fio_Template");
        /////todo встака данных по умолчанию
    }

    private void МетодСозданиеSettingTabels(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        // todo таблица  settings_tabels
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists  settings_tabels");//test
        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists    settings_tabels  (" +
                "id  INTEGER  ," +
                " date_update NUMERIC  ," +
                " user_update INTEGER  ," +
                " version_dsu1 INTEGER ," +
                "organizations  INTEGER DEFAULT '1' ," +
                " uuid  NUMERIC ," +
                "  current_table NUMERIC DEFAULT 0, "+
                "  onesignal TEXT   )");

        //////////
        Log.d(this.getClass().getName(), " сработала ... settings_tabels");
        /////todo встака данных по умолчанию
    }



    private void МетодСозданиеview_onesignal(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        // todo таблица  settings_tabels
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists  view_onesignal");//test
        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists    view_onesignal  (" +
                "id  INTEGER  ," +
                "uuid  NUMERIC  UNIQUE ," +
                " onesignal TEXT ," +
                " current_table NUMERIC DEFAULT 0 ," +
                " user_update  INTEGER, "+
                "  date_update NUMERIC  )");
        //////////
        Log.d(this.getClass().getName(), " сработала ... view_onesignal");
        /////todo встака данных по умолчанию
    }

















    private void методСозданиеТаблицыМодификацияДанныхКлиента(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists MODIFITATION_Client");//test
        ССылкаНаСозданнуюБазу.execSQL("Create table  if not exists MODIFITATION_Client (" +
                "name  TEXT NOT NULL UNIQUE " +
                ",  localversionandroid NUMERIC DEFAULT '1900-01-10 00:00:00' , " +
                "versionserveraandroid NUMERIC DEFAULT '1900-01-10 00:00:00' ," +
                " localversionandroid_version NUMERIC DEFAULT '0' , " +
                "versionserveraandroid_version NUMERIC DEFAULT '0'  )");
        //////////
        Log.d(this.getClass().getName(), " сработала ... INSERT  INTO MODIFITATION_Client");
    }


    private void МетодСозданияПольЗовательДЛяЧата(SQLiteDatabase ССылкаНаСозданнуюБазу) {

        /// ССылкаНаСозданнуюБазу.execSQL("drop VIEW  if exists Chat_Users");//test

        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists chat_users");//test
        ///
        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists    chat_users  (" +
                "_id  INTEGER ," +
                " name TEXT  ," +
                " rights INTEGER ,"+
                " telephone TEXT,"+
                " date_update  NUMERIC," +
                "current_table NUMERIC   DEFAULT 0  ," +
                " locked INTEGER )  ");
        ///

        Log.d(this.getClass().getName(), " сработала ...  создание таблицы Chat_Users");
    }







    private void МетодСозданияТаблицыData_Chat(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists data_chat");//test

        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists    data_chat  (" +
                "_id  INTEGER   ," +
                " uuid  NUMERIC UNIQUE," +
                " message TEXT ," +
                " image_chat BLOB ," +
                " status_write NUMERIC DEFAULT 0 ," +
                "chat_uuid  NUMERIC   ,"+
                " user_update INTEGER ,"+
                " date_update NUMERIC,"+
                "current_table NUMERIC DEFAULT 0 ," +
                "FOREIGN KEY(chat_uuid  ) REFERENCES chats (uuid_parent)  ON UPDATE CASCADE ON DELETE CASCADE)");

        /////todo встака данных по умолчанию

        Log.d(this.getClass().getName(), " сработала ...  создание таблицы Data_Chat");




    }








    private void МетодСозданияТаблицаChats(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        ////
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists chats");//test
        //////
        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists    chats  (" +
                "_id  INTEGER   ," +
                " user_update INTEGER ,"+
                " date_update NUMERIC,"+
                " uuid  NUMERIC UNIQUE," +
                " id_user INTEGER  ," +
                "name TEXT  ," +
                "current_table NUMERIC DEFAULT 0," +
                "  uuid_parent NUMERIC)");

        /////todo встака данных по умолчанию

        Log.d(this.getClass().getName(), " сработала ...  создание таблицы Code_For_Chats_КодДля_Чата");// "UNIQUE(id_user,current_chat) )");


    }









    private void МетодСозданияВидаЧатаViewChat(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        // TODO: 09.02.2022  view
        ССылкаНаСозданнуюБазу.execSQL("drop view  if exists viewchat");//test
        //ВИД View_TABEL
        ССылкаНаСозданнуюБазу.execSQL("CREATE VIEW if not exists viewchat AS   SELECT DISTINCT \n" +
                "                          data_chat._id,  data_chat.message,  data_chat.image_chat,  data_chat.status_write," +
                "  data_chat.chat_uuid,  data_chat.user_update,  data_chat.date_update, " +
                " data_chat.current_table, \n" +
                "                          data_chat.uuid,chats.id_user " +
                "FROM             chats LEFT OUTER JOIN\n" +
                "                          data_chat ON  chats.uuid_parent =  data_chat.chat_uuid \n" );
        ////
        Log.d(this.getClass().getName(), " сработала ...  создание вид  viewchat");
    }




    private void МетодСозданияВидаЗадания(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        // TODO: 09.02.2022  view
        ССылкаНаСозданнуюБазу.execSQL("drop view  if exists view_tasks");//test
        //ВИД View_TABEL
        ССылкаНаСозданнуюБазу.execSQL("CREATE VIEW if not exists view_tasks AS  SELECT     " +
                "    data_notification.id,  data_notification.uuid_notifications," +
                "  data_notification.current_table,  data_notification.uuid, " +
                " data_notification.rights,  data_notification.date_update," +
                "  data_notification.clock, \n" +
                "                          data_notification.date_start, " +
                " data_notification.message,  notifications.id_user," +
                "  data_notification.status_write,  notifications.user_update," +
                "  data_notification.type_tasks, \n" +
                "                          data_notification.head_message\n" +
                "FROM             notifications LEFT OUTER JOIN\n" +
                "                          data_notification" +
                " ON  notifications.uuid =  data_notification.uuid_notifications\n" +
                "WHERE        ( data_notification.message IS NOT NULL)");
        ////
        Log.d(this.getClass().getName(), " сработала ...  создание вид  view_tasks");
    }





    private void МетодСозданияViewТабеля(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        //

        // TODO: 26.08.2021 старый view табель

        //ВИД View_TABEL

        ССылкаНаСозданнуюБазу.execSQL("drop view  if exists viewtabel");//test
        //ВИД View_TABEL
        ССылкаНаСозданнуюБазу.execSQL("CREATE VIEW if not exists viewtabel AS  SELECT             data_tabels._id,  tabel.cfo," +
                "  tabel.month_tabels,  tabel.year_tabels,  data_tabels.fio,  data_tabels.d1,  data_tabels.d2, " +
                " data_tabels.d3,  data_tabels.d4,  data_tabels.d5,  data_tabels.d6, \n" +
                "                          data_tabels.d7,  data_tabels.d8,  data_tabels.d9,  data_tabels.d10," +
                "  data_tabels.d11,  data_tabels.d12,  data_tabels.d13,  data_tabels.d14,  data_tabels.d15,  data_tabels.d16, \n" +
                "                          data_tabels.d17,  data_tabels.d18,  data_tabels.d20,  data_tabels.d19," +
                "  data_tabels.d21,  data_tabels.d22,  data_tabels.d23,  data_tabels.d25,  data_tabels.d24,  data_tabels.d26, \n" +
                "                          data_tabels.d27,  data_tabels.d28,  data_tabels.d29,  data_tabels.d30," +
                "  data_tabels.d31,  data_tabels.date_update,  data_tabels.uuid,  data_tabels.uuid_tabel,  data_tabels.user_update, \n" +
                "                          data_tabels.current_table,  data_tabels.status_send,  data_tabels.status_carried_out\n" +
                "FROM             tabel LEFT OUTER JOIN\n" +
                "                          data_tabels ON  tabel.uuid =  data_tabels.uuid_tabel\n" +
                "WHERE        ( data_tabels.fio IS NOT NULL) ");



        Log.d(this.getClass().getName(), " сработала ...  создание вид  viewtabel");


/*        ССылкаНаСозданнуюБазу.execSQL("CREATE VIEW if not exists viewtabel AS  SELECT             tabels._id,  tabels.fio,  tabels.cfo,  tabels.year_tabels, " +
                " tabels.month_tabels,  tabels.d1,  tabels.d2,  tabels.d3,  tabels.d4,  tabels.d5,  tabels.d6,  tabels.d7,  tabels.d8, \n" +
                "                          tabels.d9,  tabels.d10,  tabels.d11,  tabels.d12,  tabels.d13,  tabels.d14,  tabels.d15,  tabels.d16, " +
                " tabels.d17,  tabels.d18,  tabels.d19,  tabels.d21,  tabels.d20,  tabels.d22, \n" +
                "                          tabels.d23,  tabels.d24,  tabels.d27,  tabels.d26,  tabels.d25,  tabels.d29,  tabels.d28,  tabels.d30, " +
                " tabels.d31,  tabels.uuid,  tabels.date_update,  tabels.status_send, \n" +
                "                           tabels.user_update,   fio.BirthDate,  fio.snils,  fio.name,tabels.status_carried_out\n" +
                "FROM             tabels LEFT OUTER JOIN\n" +
                "                          fio ON  tabels.fio =  fio.uuid");
        Log.d(this.getClass().getName(), " сработала ...  создание вид  viewtabel");*/


        // TODO: 26.08.2021 Новый view табель

        ССылкаНаСозданнуюБазу.execSQL("drop view  if exists viewtabels");//test
        //ВИД View_TABEL
/*        ССылкаНаСозданнуюБазу.execSQL("CREATE VIEW if not exists viewtabels AS  SELECT          data_tabels._id,   tabel.cfo,   tabel.month_tabels," +
                "   tabel.year_tabels,   data_tabels.fio,   data_tabels.d1,   data_tabels.d2,   data_tabels.d3,   data_tabels.d4,   data_tabels.d5,   data_tabels.d6, \n" +
                "                           data_tabels.d7,   data_tabels.d8,   data_tabels.d9,   data_tabels.d10,   data_tabels.d11," +
                "   data_tabels.d12,   data_tabels.d13,   data_tabels.d14,   data_tabels.d15,   data_tabels.d16, \n" +
                "                           data_tabels.d17,   data_tabels.d18,   data_tabels.d20,   data_tabels.d19, " +
                "  data_tabels.d21,   data_tabels.d22,   data_tabels.d23,   data_tabels.d25,   data_tabels.d24,   data_tabels.d26, \n" +
                "                           data_tabels.d27,   data_tabels.d28,   data_tabels.d29,   data_tabels.d30," +
                "   data_tabels.d31,   data_tabels.date_update,   data_tabels.current_tabel,   data_tabels.uuid,   data_tabels.uuid_tabel, \n" +
                "                           tabel.status_send,   tabel.status_carried_out,   data_tabels.user_update\n" +
                "FROM              tabel LEFT OUTER JOIN\n" +
                "                           data_tabels ON   tabel.uuid =   data_tabels.uuid_tabel");*/
        Log.d(this.getClass().getName(), " сработала ...  создание вид  viewtabels");





    }

    private void МетодСозданияТаблицыТабелей(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        ////////8/
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists tabels");//test

        /*ССылкаНаСозданнуюБазу.execSQL("Create table if not exists tabels(" +
                "_id  INTEGER    ," +
                " fio NUMERIC," +
                "cfo NUMERIC ," +
                "month_tabels NUMERIC," +
                "year_tabels NUMERIC," +
                "d1 INTEGER  ," +
                "d2 INTEGER    ," +
                "d3 INTEGER      ," +
                "d4 INTEGER      ," +
                "d5 INTEGER    ," +
                "d6 INTEGER    ," +
                "d7 INTEGER      ," +
                "d8 INTEGER      ," +
                "d9 INTEGER    ," +
                "d10 INTEGER    ," +
                "d11 INTEGER      ," +
                "d12 INTEGER    ," +
                "d13 INTEGER      ," +
                "d14 INTEGER    ," +
                "d15 INTEGER      ," +
                "d16 INTEGER      ," +
                "d17 INTEGER    ," +
                "d18 INTEGER      ," +
                "d19 INTEGER    ," +
                "d20 INTEGER      ," +
                "d21 INTEGER  ," +
                "d22 INTEGER     ," +
                "d23 INTEGER     ," +
                "d24 INTEGER     ," +
                "d25 INTEGER     ," +
                "d26 INTEGER     ," +
                "d27 INTEGER    ," +
                "d28 INTEGER     ," +
                "d29 INTEGER     ," +
                "d30 INTEGER     ," +
                "d31 INTEGER     ," +
                "date_update  NUMERIC   ," +
                " uuid  NUMERIC UNIQUE ," +
                " status_send  TEXT ," +
                " user_update INTEGER ," +
                "status_carried_out   INTEGER  ,"+
                "FOREIGN KEY(cfo ) REFERENCES cfo (id)  ON UPDATE CASCADE ,"+/// "FOREIGN KEY(organizations) REFERENCES SuccessLogin (organizations)  ON UPDATE CASCADE ,"+
                "FOREIGN KEY(fio ) REFERENCES fio (uuid)  ON UPDATE CASCADE  ON DELETE CASCADE," +
                "PRIMARY KEY(fio,cfo ,month_tabels,year_tabels)) ");*/
        ///
        ////////////////////
        Log.d(this.getClass().getName(), " сработала ...  создание таблицы  TABELS");//"FOREIGN KEY(organizations) REFERENCES SuccessLogin (organizations)  ON UPDATE CASCADE ,"+
    }





    //TODO новые таблицы для табеля  НОВАЯ ТАБЛИЦА ТАБЕЛЬ



/*
        // TODO: 25.08.2021  тригер для   старой таблицы  tabels
        ССылкаНаСозданнуюБазу.execSQL("drop TRIGGER  if exists triger_auto_uuid_tabels");//test
        ССылкаНаСозданнуюБазу.execSQL(" CREATE  temp TRIGGER   if not  EXISTS triger_auto_uuid_tabels BEFORE INSERT  ON  tabels  " +
                "BEGIN     " +
                " INSERT INTO tabels (uuid) VALUES(ГенерацияНовогоUUID) ;" +
                " END; ");
*//*






        ///
        ////////////////////
        Log.d(this.getClass().getName(), " сработала ...  создание  тригера  МетодСозданияТригераДляАвтоматическойВсатвкиUUID");//"FOREIGN KEY(organizations) REFERENCES SuccessLogin (organizations)  ON UPDATE CASCADE ,"+
    }
*/












    private void МетодСоздания_ТаблицыТабель(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists tabel");//test
        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists tabel(" +
                "_id  INTEGER    ," +
                "cfo NUMERIC ," +
                "month_tabels NUMERIC," +
                "year_tabels NUMERIC," +
                "date_update  NUMERIC   ," +
                " uuid  NUMERIC UNIQUE ," +
                " status_send  TEXT ," +
                " user_update INTEGER ," +
                "current_table  NUMERIC DEFAULT 0   ,"+
                "FOREIGN KEY(cfo ) REFERENCES cfo (id)  ON UPDATE CASCADE )");//   "PRIMARY KEY(_id)) ");
        ///
        ////////////////////
        Log.d(this.getClass().getName(), " сработала ...  создание таблицы   новая tabel");//"FOREIGN KEY(organizations) REFERENCES SuccessLogin (organizations)  ON UPDATE CASCADE ,"+
    }




    //TODO новые таблицы для табеля  НОВАЯ ТАБЛИЦА   ДАТА ТАБЕЛЬ



    private void МетодСоздания_ТаблицыДатаТабель(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        ////
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists data_tabels");//test
        ///
        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists data_tabels(" +
                "_id  INTEGER     ," +
                "fio NUMERIC ," +
                "d1 INTEGER  DEFAULT 0   ," +
                "d2 INTEGER  DEFAULT 0    ," +
                "d3 INTEGER     DEFAULT 0    ," +
                "d4 INTEGER    DEFAULT 0     ," +
                "d5 INTEGER    DEFAULT 0   ," +
                "d6 INTEGER   DEFAULT 0    ," +
                "d7 INTEGER   DEFAULT 0      ," +
                "d8 INTEGER    DEFAULT 0     ," +
                "d9 INTEGER   DEFAULT 0   ," +
                "d10 INTEGER    DEFAULT 0  ," +
                "d11 INTEGER   DEFAULT 0     ," +
                "d12 INTEGER   DEFAULT 0   ," +
                "d13 INTEGER   DEFAULT 0     ," +
                "d14 INTEGER  DEFAULT 0    ," +
                "d15 INTEGER    DEFAULT 0    ," +
                "d16 INTEGER    DEFAULT 0    ," +
                "d17 INTEGER   DEFAULT 0   ," +
                "d18 INTEGER    DEFAULT 0    ," +
                "d19 INTEGER  DEFAULT 0    ," +
                "d20 INTEGER  DEFAULT 0      ," +
                "d21 INTEGER   DEFAULT 0  ," +
                "d22 INTEGER   DEFAULT 0    ," +
                "d23 INTEGER   DEFAULT 0    ," +
                "d24 INTEGER   DEFAULT 0    ," +
                "d25 INTEGER    DEFAULT 0   ," +
                "d26 INTEGER   DEFAULT 0    ," +
                "d27 INTEGER   DEFAULT 0   ," +
                "d28 INTEGER   DEFAULT 0    ," +
                "d29 INTEGER   DEFAULT 0    ," +
                "d30 INTEGER   DEFAULT 0    ," +
                "d31 INTEGER   DEFAULT 0    ," +
                "date_update  NUMERIC   ," +
                " uuid_tabel  NUMERIC  ," +
                " current_table  NUMERIC DEFAULT 0  ," +
                " uuid NUMERIC UNIQUE ," +
                " user_update INTEGER  ," +
                "status_send TEXT ," +
                "status_carried_out   INTEGER DEFAULT 0   ,"+
                "FOREIGN KEY(fio ) REFERENCES fio (uuid)  ON UPDATE CASCADE ) ");//  "PRIMARY KEY(fio,uuid_tabel)) ");
        ///             "FOREIGN KEY(uuid_tabel ) REFERENCES tabel (uuid)  ON UPDATE CASCADE  ON DELETE CASCADE," +
        ////////////////////
        Log.d(this.getClass().getName(), " сработала ...  создание таблицы   новая data_tabels");//"FOREIGN KEY(organizations) REFERENCES SuccessLogin (organizations)  ON UPDATE CASCADE ,"+
    }





















































    private void МетодСозданиеТаблицыФИО(SQLiteDatabase ССылкаНаСозданнуюБазу) {

        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists   fio");//test

        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists   fio (" +
                "_id  INTEGER   ," +
                " name TEXT  ," +
                " f TEXT ," +
                " n TEXT," +
                " o TEXT  ," +
                " BirthDate NUMERIC," +
                " snils TEXT," +
                " date_update NUMERIC," +
                " user_update INTEGER," +
                " uuid  NUMERIC UNIQUE," +
                " current_organization INTEGER," +
                " current_table  NUMERIC DEFAULT 0 ," +
                "FOREIGN KEY(user_update) REFERENCES users  (id)  ON UPDATE CASCADE," +
                "FOREIGN KEY(current_organization) REFERENCES organization  (id)  ON UPDATE CASCADE)");
        
        Log.d(this.getClass().getName(), " сработала ...  создание таблицы   fio");
    }












    private void МетодСозданиеМетокТабеля(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists  metki_tabel");//test
        ССылкаНаСозданнуюБазу.execSQL("Create table if not exists    metki_tabel  (" +
                "id  INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " metka TEXT ," +
                " fullname_metka TEXT ," +
                " date_update NUMERIC  ," +
                " user_update INTEGER )");
        /////todo встака данных по умолчанию
        ССылкаНаСозданнуюБазу.execSQL("INSERT INTO metki_tabel (metka,fullname_metka) VALUES('В','Выходной')");
        ССылкаНаСозданнуюБазу.execSQL("INSERT INTO metki_tabel (metka,fullname_metka) VALUES('О','Отпуск')");
        ССылкаНаСозданнуюБазу.execSQL("INSERT INTO metki_tabel (metka,fullname_metka) VALUES('Б','Больничный')");
        ССылкаНаСозданнуюБазу.execSQL("INSERT INTO metki_tabel (metka,fullname_metka) VALUES('А','Отпуск без оплаты')");
        ССылкаНаСозданнуюБазу.execSQL("INSERT INTO metki_tabel (metka,fullname_metka) VALUES('П','Прогулы')");
        ССылкаНаСозданнуюБазу.execSQL("INSERT INTO metki_tabel (metka,fullname_metka) VALUES('Р','Ремонт')");
        ССылкаНаСозданнуюБазу.execSQL("INSERT INTO metki_tabel (metka,fullname_metka) VALUES('Д','Дежурство')");
        ССылкаНаСозданнуюБазу.execSQL("INSERT INTO metki_tabel (metka,fullname_metka) VALUES('К','Командировка')");

        ////////
        Log.d(this.getClass().getName(), " сработала ...  создание таблицы metki_tabel");
    }

    private void МетодСозданиеТаблицыЛогинов(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        ССылкаНаСозданнуюБазу.execSQL("drop table  if exists successlogin");//test
        ССылкаНаСозданнуюБазу.execSQL("Create table  if not exists successlogin (" +
                " id   INTEGER ," +
                " success_users  TEXT  ," +
                " success_login  TEXT ,  " +
                " date_update  NUMERIC," +
                " mode_weekend  TEXT DEFAULT 'Включить'," +///Включить   //  Выключить
                "mode_connection TEXT DEFAULT 'Mobile' )");
        //ССылкаНаСозданнуюБазу.execSQL("INSERT INTO SuccessLogin (id) VALUES('')");
        Log.d(this.getClass().getName(), " сработала ...  создание таблицы  successlogin");
    }





    // TODO: 08.06.2021 перед созданием делем Old копию базы данных

    private void МетодСозданиеOLD_ТаблицыОшибок(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        try{
            ССылкаНаСозданнуюБазу.execSQL("drop table  if exists old_errordsu1 ");//ТАБЛИЦА ГЕНЕРАЦИИ ОШИБОК
            ССылкаНаСозданнуюБазу.execSQL("Create table if not exists old_errordsu1 (" +
                    "ID_Table_ErrorDSU1 INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                    " Error TEXT    NOT NULL  ," +
                    "Klass TEXT NOT NULL ," +
                    "Metod TEXT NOT NULL," +
                    "LineError INTEGER NOT NULL ," +
                    "Data_Operazii_E NUMERIC NOT NULL ,"+
                    "whose_error INTEGER NOT NULL )");
            //
            ССылкаНаСозданнуюБазу.execSQL("INSERT INTO old_errorDSU1  (Error,Klass,Metod,LineError,Data_Operazii_E,whose_error) SELECT Error,Klass,Metod,LineError,Data_Operazii_E,whose_error FROM errordsu1;");



        } catch (SQLException e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            Log.d(this.getClass().getName(), " сработала ...  создание таблицы Old_ErrorDSU1 ");

        }
    }










    private void МетодСозданиеТаблицыОшибок(SQLiteDatabase ССылкаНаСозданнуюБазу) {
        try{
            ССылкаНаСозданнуюБазу.execSQL("drop table  if exists errordsu1 ");//ТАБЛИЦА ГЕНЕРАЦИИ ОШИБОК
            ССылкаНаСозданнуюБазу.execSQL("Create table if not exists errordsu1 (" +
                    "ID_Table_ErrorDSU1 INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                    " Error TEXT    NOT NULL  ," +
                    "Klass TEXT NOT NULL ," +
                    "Metod TEXT NOT NULL," +
                    "LineError INTEGER NOT NULL ," +
                    "Data_Operazii_E NUMERIC NOT NULL ,"+
                    "whose_error INTEGER NOT NULL )");
            Log.d(this.getClass().getName(), " сработала ...  создание таблицы ErrorDSU1 ");

        } catch (SQLException e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextСозданиеБАзы).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

        }
    }





    @Override
    public void onUpgrade(SQLiteDatabase ССылкаНаСозданнуюБазу, int oldVersion, int newVersion) {
        //принудительное запускаем заново для создание новых таблиц


        if (newVersion == 734) {

            //TODo созадем таблицу сос старами ошибками

            МетодСозданиеУведомленийИлиДАТАЗадания(ССылкаНаСозданнуюБазу);
            // TODO: 22.03.2022  

            МетодСозданиеУведомленийИлиЗадания(ССылкаНаСозданнуюБазу);


            //  МетодСозданияВидаЗадания(ССылкаНаСозданнуюБазу);


            // TODO: 10.03.2022

            // МетодСозданияВидаЗадания(ССылкаНаСозданнуюБазу);
            
            
      /*      МетодСозданияТаблицаChats(ССылкаНаСозданнуюБазу);

            МетодСозданияТаблицыData_Chat(ССылкаНаСозданнуюБазу);

           /// МетодСозданияТаблицыData_Chat(ССылкаНаСозданнуюБазу);*/

   /*    МетодСозданияВидаЧатаViewChat(ССылкаНаСозданнуюБазу);*/


        /*    МетодСозданиеУведомленийИлиЗадания(ССылкаНаСозданнуюБазу);


                    МетодСозданиеУведомленийИлиДАТАЗадания(ССылкаНаСозданнуюБазу);


            МетодСозданияВидаЗадания(ССылкаНаСозданнуюБазу);
*/


            // todo таблица Code_For_Chats_КодДля_Чата
        ///    МетодСозданияТаблицаChats(ССылкаНаСозданнуюБазу);


/*
            МетодСозданиеУведомленийИлиЗадания(ССылкаНаСозданнуюБазу);*/
            ///
            Log.d(this.getClass().getName(), " СЛУЖБА  содание базы newVersion > oldVersion   " + new Date() + "  newVersion " +newVersion);

/*            МетодСозданиеТаблицыFio_TEmplay(ССылкаНаСозданнуюБазу);

                  МетодСозданияТаблицаChats(ССылкаНаСозданнуюБазу);

           МетодСозданияТаблицыData_Chat(ССылкаНаСозданнуюБазу);
            */
            

           // МетодСозданияВидаЧатаViewChat(ССылкаНаСозданнуюБазу);


          ////  МетодСозданиеview_onesignal(ССылкаНаСозданнуюБазу);






         /*   МетодСозданиеOLD_ТаблицыОшибок(ССылкаНаСозданнуюБазу);

            //
            МетодСозданияViewТабеля(ССылкаНаСозданнуюБазу);*/

            // TODO: 08.06.2021 создание Базы Данных  ВНИМАНИЕ !!!! ВРЕМЕНО РАЗМЕЩЕНО МЕТОД  //// onCreate(ССылкаНаСозданнуюБазу)


     //  МетодСозданияViewТабеля(ССылкаНаСозданнуюБазу);

            ///onCreate(ССылкаНаСозданнуюБазу);

           // МетодСозданиеТаблицыФИО(ССылкаНаСозданнуюБазу);

        /*    МетодСоздания_ТаблицыДатаТабель(ССылкаНаСозданнуюБазу);

            МетодСозданияТаблицыТабелей(ССылкаНаСозданнуюБазу);*/


          //  МетодСозданияТригераДляАвтоматическойВсатвкиUUID(ССылкаНаСозданнуюБазу);

        /*  МетодСозданияТаблицаChats(ССылкаНаСозданнуюБазу);

           МетодСозданияТаблицыData_Chat(ССылкаНаСозданнуюБазу);



           ///
           МетодСозданияВидаЧатаViewChat(ССылкаНаСозданнуюБазу);*/



          //  МетодСозданияВидаЧатаViewChat(ССылкаНаСозданнуюБазу);

            ///
            Log.d(this.getClass().getName(), " СЛУЖБА  содание базы newVersion==  652   (например)   " + new Date());
        }else{


            if (newVersion > oldVersion) {


                //TODo созадем таблицу сос старами ошибками
                МетодСозданиеOLD_ТаблицыОшибок(ССылкаНаСозданнуюБазу);





                // TODO: 08.06.2021 создание Базы Данных

                onCreate(ССылкаНаСозданнуюБазу);
                //
                ///
                Log.d(this.getClass().getName(), " СЛУЖБА  содание базы newVersion > oldVersion   " + new Date());


            }

        }
        /**
         * заверешение создагние базы
         */




        Log.i(this.getClass().getName(), "  Создана/Изменена База Данных !!! "+new Date());



    }





    @Override
    public void onDowngrade(SQLiteDatabase ССылкаНаСозданнуюБазу, int oldVersion, int newVersion) {
        onCreate(ССылкаНаСозданнуюБазу);
    }

/*
    //функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ
    public String ГлавнаяДатаИВремяОперацийСБазойДанных() {
        Date Дата = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", new Locale("ru"));//"yyyy-MM-dd HH:mm:ss.SSS"//"yyyy-MM-dd'T'HH:mm:ss'Z'"
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        Log.d(this.getClass().getName(), " ГЛАВНАЯ ДАТА ПРОГРАММЫ ДСУ-1 : " + dateFormat.format(Дата));
        return dateFormat.format(Дата);
    }
*/







































}// конец public class CREATE_DATABASE extends SQLiteOpenHelper





































































































