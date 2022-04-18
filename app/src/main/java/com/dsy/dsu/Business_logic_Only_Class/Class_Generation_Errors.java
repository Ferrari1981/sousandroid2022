package com.dsy.dsu.Business_logic_Only_Class;

import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.util.Log;

import com.dsy.dsu.BuildConfig;
import com.dsy.dsu.CREATE_DATABASE;
import com.dsy.dsu.PUBLIC_CONTENT;

public class Class_Generation_Errors extends Class_GRUD_SQL_Operations {

    Context contextДляОшибок=null;

    Class_GRUD_SQL_Operations classGrudSqlOperationsДляЗаписиНовойОшибки;

    Integer                 ПубличноеIDПолученныйИзСервлетаДляUUID=0;


    CREATE_DATABASE Create_Database_СсылкаНАБазовыйКласс;

    public Class_Generation_Errors(Context context) {
        super(context);

        contextДляОшибок=context;

        Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextДляОшибок);

    }
    //функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ
    // TODO: 05.07.2021

    //// второй метод с современный
    public  void МетодЗаписиВЖурналНовойОшибки(String ТекстОшибки,
                                               String КлассГнерацииОшибки,
                                               String МетодаОшибки,
                                               Integer ЛинияОшибки)



         {


             classGrudSqlOperationsДляЗаписиНовойОшибки=new Class_GRUD_SQL_Operations(contextДляОшибок);;
             ///TODO конец
             Long PезультатВставкиНовойОшибки=0l;

        ////
        try {
            Log.d(  contextДляОшибок.getClass().getName(), " сработала ... ВСТАВКА ОШИБОК В БАЗУ");

            // TODO: 01.09.2021 пример вызова
          /**
           *  new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());*/
            /////////////////
            // ID


            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

            ///
            classGrudSqlOperationsДляЗаписиНовойОшибки. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СамFreeSQLКОд",
                    " SELECT id  FROM successlogin  ORDER BY date_update DESC ;");


            // TODO: 12.10.2021  Ссылка Менеджер Потоков

            PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = new PUBLIC_CONTENT(contextСозданиеБАзы);


            ///////
            SQLiteCursor Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО= (SQLiteCursor) classGrudSqlOperationsДляЗаписиНовойОшибки.
                    new GetаFreeData(contextСозданиеБАзы).getfreedata(classGrudSqlOperationsДляЗаписиНовойОшибки.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

            //////


            Log.d(this.getClass().getName(), " Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО  " + Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО);

            if(Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО.getCount()>0){
  /////

                Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО.moveToFirst();
                /////
                ПубличноеIDПолученныйИзСервлетаДляUUID=         Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО.getInt(0);
///


                Log.d(this.getClass().getName(), " ПубличноеIDПолученныйИзСервлетаДляUUID  " + ПубличноеIDПолученныйИзСервлетаДляUUID);


            }

            // TODO: 30.08.2021    КОД ВСТАВКИ  ДАННЫХ   ЧЕРЕЗ




            ///
            classGrudSqlOperationsДляЗаписиНовойОшибки. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","ErrorDSU1");
            ///

            //TODO коййтенер

            classGrudSqlOperationsДляЗаписиНовойОшибки.contentValuesДляSQLBuilder_Для_GRUD_Операций.put("Error",ТекстОшибки.toLowerCase());



            Log.d(this.getClass().getName(), " ТекстОшибки.toLowerCase()  " + ТекстОшибки.toLowerCase());
            ///
            classGrudSqlOperationsДляЗаписиНовойОшибки.contentValuesДляSQLBuilder_Для_GRUD_Операций.put("Klass",КлассГнерацииОшибки.toUpperCase());
            ///
            ///
            classGrudSqlOperationsДляЗаписиНовойОшибки.contentValuesДляSQLBuilder_Для_GRUD_Операций.put("Metod",МетодаОшибки.toUpperCase());
            ///
            classGrudSqlOperationsДляЗаписиНовойОшибки.contentValuesДляSQLBuilder_Для_GRUD_Операций.put("LineError",ЛинияОшибки);
            ////

            final Object ТекущаяВерсияПрограммы = BuildConfig.VERSION_CODE;

            ///
            Integer   ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());

            classGrudSqlOperationsДляЗаписиНовойОшибки.contentValuesДляSQLBuilder_Для_GRUD_Операций.put("whose_error", ЛокальнаяВерсияПОСравнение);



            ///

            ////TODO ДАТА
            String СгенерированованныйДатаДляВставки=     new Class_Generation_Data(contextДляОшибок).ГлавнаяДатаИВремяОперацийСБазойДанных();
            ///
            classGrudSqlOperationsДляЗаписиНовойОшибки.contentValuesДляSQLBuilder_Для_GRUD_Операций.put("Data_Operazii_E",СгенерированованныйДатаДляВставки);


            ////TODO UUID
            // TODO: 12.10.2021  Ссылка Менеджер Потоков




            ///TODO РЕЗУЛЬТАТ ВСТАВКИ ДАННЫХ
            if (! ТекстОшибки.equalsIgnoreCase("java.net.SocketTimeoutException: timeout")) {
                // TODO: 20.02.2022

                PезультатВставкиНовойОшибки= (Long)  classGrudSqlOperationsДляЗаписиНовойОшибки.
                        new InsertData(contextДляОшибок).insertdata(classGrudSqlOperationsДляЗаписиНовойОшибки. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        classGrudSqlOperationsДляЗаписиНовойОшибки.contentValuesДляSQLBuilder_Для_GRUD_Операций ,
                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,
                        Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());
//
            }

            Log.d(this.getClass().getName(), "PезультатВставкиНовойОшибки " +PезультатВставкиНовойОшибки );

            ////
            if(PезультатВставкиНовойОшибки==null){
                ////
                PезультатВставкиНовойОшибки=0l;
            }
            /////



            if (PезультатВставкиНовойОшибки>0) {
                ///
                Log.d(this.getClass().getName(), "результатВставки Ошибки ERROR " +PезультатВставкиНовойОшибки );



                ///////// удалить потом  ССылкаНаСозданнуюБазу.execSQL("delete from ErrorDSU1 where whose_error < '"+ЛокальнаяВерсияПОСравнение+"'");


           /*     // TODO: 30.08.2021    КОД  удаление     ДАННЫХ   ЧЕРЕЗ
                //////



                classGrudSqlOperations=new Class_GRUD_SQL_Operations(contextДляОшибок);

                ///
                classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","ErrorDSU1");
                ///
                classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("Флаг_ЧерезКакоеПолеУдаление","whose_error");
                ///
                classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗначениеФлагУдаление",ЛокальнаяВерсияПОСравнение);
                //
                classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗнакФлагУдаление","<"); //или =  ?  или <   > ?


                ///TODO конец
                ///
////TODO ДАТА


                Integer PезультатУдаление;

                //TODO РЕЗУЛЬТАТ САМОЙ ОПЕРАИЦИИ УДАЛЕНИЕ
                PезультатУдаление= (Integer)  new Class_GRUD_SQL_Operations(contextДляОшибок).
                        new DeleteData(contextДляОшибок).deletedata(classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций );
//

                Log.d(this.getClass().getName(), "PезультатУдаление " +PезультатУдаление );
                ////
                if(PезультатУдаление==null){
                    ////
                    PезультатУдаление=0;
                }
                /////


                if (PезультатУдаление>0) {
                    ///
                    Log.d(this.getClass().getName(), "PезультатУдаление " +PезультатУдаление );

                    // TODO: 01.09.2021 ПОСЫЛАЕМ ОШИБКИ СИСТМЕНУМО АДМИНИСТАТОРУ

                }else {
                    ///
                    Log.d(this.getClass().getName(), "PезультатУдаление " +PезультатУдаление );
                }
*/

                // TODO: 30.08.2021     КОНЕЦ КОД  удаление     ДАННЫХ   ЧЕРЕЗ


            }
            // TODO: 30.08.2021   КОНЕЦ   КОД ВСТАВКИ  ДАННЫХ   ЧЕРЕЗ



            //ловим ошибку
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e( contextДляОшибок.getClass().getName(), "Ошибка в самом классе создание ОШИБКИ (записи новой ошибки) ERROR  inse ERROR" + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            //закрытие классса и метода
        }

    }



}
