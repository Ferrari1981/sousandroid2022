package com.dsy.dsu;

import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import android.util.Log;

import com.dsy.dsu.Class_GRUD_SQL_Operations;
import com.dsy.dsu.Class_Generation_Errors;
import com.dsy.dsu.Class_Get_For_Server_All_Rows_Json;
import com.dsy.dsu.MODEL_synchronized;
import com.dsy.dsu.PUBLIC_CONTENT;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeoutException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



///////////--------------------------TODO ЭТО ТРЕТИЙ  КОНТРОЛЛЕР ТОЛЬКО ДЛЯ ПОЛУЧЕНИЯ  ТОЛЬКО JSON ПОЛЕЙ  И СКОЛЬКО ТАБЛИЦ НУЖНО БЕЗ  СИНХРОНИЗАЦИИИ---

class Class_Get_All_Rows_Json extends MODEL_synchronized {

    Context contextGetClassNumberAllRowsJSON;

    ////шифрование
  SecretKey ГлавныйКлючДляШифрованиеИРасшифровки;
    ////
    Cipher ПолитикаШифрование;
    ///////
  Cipher ПолитикаРасшифровки;








    public Class_Get_All_Rows_Json(Context context) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        super(context);
        ////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
        /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК

        contextGetClassNumberAllRowsJSON=context;


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








////// TODO ПЕРВЫЙ МЕТОД ОБМЕНА ДАННЫМИ С СЕРВЕРОМ МЕТОД GET JSON только когда иы хотим узнать все строки json  по всем строкам мы запускаем этот код И ВСЕ !!!!


    Integer      МетодКоторыйПолучаетКоличествоСтрочекJSON(LinkedBlockingQueue<String> arraylistТаблицыДляСинхронихзацции) throws InterruptedException, ExecutionException, NoSuchAlgorithmException, IOException, KeyManagementException, TimeoutException {

        CopyOnWriteArrayList<Integer> ВсеСтрочкиJSONотСервераВсе=new CopyOnWriteArrayList<>();

        //
        Integer    КоличетвоСтрочекJSONотСервераВсе=0;
        /////
        PUBLIC_CONTENT public_contentДатыДляГлавныхТаблицСинхронизации=new PUBLIC_CONTENT(contextСозданиеБАзы);
        /////////
        String ТекущаяТаблицы=null;

        Class_GRUD_SQL_Operations class_grud_sql_operationsолучаетКоличествоСтрочекJSON=new Class_GRUD_SQL_Operations(contextGetClassNumberAllRowsJSON);
        ////
        SQLiteCursor КурсорДляАнализаВерсииДанныхАндройда=null;

        try{

            Map<String,Integer> concurrentHashMapАдресаПодключенияКСерверу= Collections.synchronizedMap(new LinkedHashMap());
            //
            String ИмяСервераДляJSON=new String();
            //
            Integer ИмяПортаДляJSON=0;


            ////todo ТОЛЬКО КОГДА НЕ ОТЛАДКА




                concurrentHashMapАдресаПодключенияКСерверу.put("tabel.dsu1.ru", 8888);//TODO FALSE  ЭТО  РЕЛИЗ



                ////TODO тест режим
                /////
               // concurrentHashMapАдресаПодключенияКСерверу.put("192.168.254.40", 8080);



            for (Map.Entry<String, Integer> СодержимоеHashMapАдресаПодключенияКСерверу : concurrentHashMapАдресаПодключенияКСерверу.entrySet()) {

                ИмяСервераДляJSON = СодержимоеHashMapАдресаПодключенияКСерверу.getKey();


                ИмяПортаДляJSON = СодержимоеHashMapАдресаПодключенияКСерверу.getValue();

                //TODO ФУТУРЕ ЗАВЕРШАЕМ
                Log.d(this.getClass().getName(), " КоличетвоСтрочекJSONотСервераВсе БЕЛЫЙ АДРЕС    " +КоличетвоСтрочекJSONотСервераВсе  +
                        "  ИмяСервераДляJSON " +ИмяСервераДляJSON+ " ИмяПортаДляJSON " +ИмяПортаДляJSON);


                ///



                LinkedBlockingQueue ЗаполненыеСистемныеТаблицыДЛяСинхронизации = new Class__Generation_Genetal_Tables(contextGetClassNumberAllRowsJSON).
                        МетодЗаполеннияТаблицДЛяРаботыиСинхрониазции();



                //TODO ФУТУРЕ ЗАВЕРШАЕМ
                Log.d(this.getClass().getName(), "  ЗаполненыеСистемныеТаблицыДЛяСинхронизации " + ЗаполненыеСистемныеТаблицыДЛяСинхронизации.size());


                // TODO: 07.10.2021  новый спосоп полуение json rows
                String[]МассивИхДатыДляОтправкиНаСервер=new String[ЗаполненыеСистемныеТаблицыДЛяСинхронизации.size()];


                Long  ВерсияДанныхСКлиента_ТекущийТаблицыДляСинхронизации=0l;

                String  НазваниеанныхСКлиента_ТекущийТаблицыДляСинхронизации=null;

                // TODO: 07.10.2021

                Integer ИндексТекущейСтрочки=0;



            Iterator<String> listIteratorПоТаблицамДляKJSOB= ЗаполненыеСистемныеТаблицыДЛяСинхронизации.iterator();
            //////

            while (listIteratorПоТаблицамДляKJSOB.hasNext()){

                ///////

                ТекущаяТаблицы=        listIteratorПоТаблицамДляKJSOB.next();

                //////


                Log.d(this.getClass().getName(),"  ТекущаяТаблицы "+ТекущаяТаблицы);


                Class_GRUD_SQL_Operations    class_grud_sql_operationsолучаетКоличествоСтрочекJSONПолучениеВерсииДанныхИзАндойда=new Class_GRUD_SQL_Operations(contextСозданиеБАзы);

                ///
                class_grud_sql_operationsолучаетКоличествоСтрочекJSONПолучениеВерсииДанныхИзАндойда. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","MODIFITATION_Client");
                ///////
                class_grud_sql_operationsолучаетКоличествоСтрочекJSONПолучениеВерсииДанныхИзАндойда. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","name,versionserveraandroid_version");
                //
                class_grud_sql_operationsолучаетКоличествоСтрочекJSONПолучениеВерсииДанныхИзАндойда. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","name=? ");
                ///"_id > ?   AND _id< ?"
                //////
                class_grud_sql_operationsолучаетКоличествоСтрочекJSONПолучениеВерсииДанныхИзАндойда. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",ТекущаяТаблицы.trim());
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

                КурсорДляАнализаВерсииДанныхАндройда=null;



                // TODO: 12.10.2021  Ссылка Менеджер Потоков

                PUBLIC_CONTENT  Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new PUBLIC_CONTENT (contextGetClassNumberAllRowsJSON);


                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

                КурсорДляАнализаВерсииДанныхАндройда= (SQLiteCursor)  class_grud_sql_operationsолучаетКоличествоСтрочекJSONПолучениеВерсииДанныхИзАндойда.
                        new GetData(contextСозданиеБАзы).getdata(class_grud_sql_operationsолучаетКоличествоСтрочекJSONПолучениеВерсииДанныхИзАндойда. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

                Log.d(this.getClass().getName(), "GetData "+КурсорДляАнализаВерсииДанныхАндройда  );





/*
                // TODO: 06.09.2021  _old
                   АнализаВерсииДанныхАндройда.setTables("MODIFITATION_Client");

                ////
                SQLiteCursor КурсорДляАнализаВерсииДанныхАндройда =
                        (SQLiteCursor)    АнализаВерсииДанныхАндройда.query(ССылкаНаСозданнуюБазу,new String[]{"name,localversionandroid, versionserveraandroid"},
                                "name=?", new String[]{ТекущаяТаблицы},null, null, null, null);

*/



                if ( КурсорДляАнализаВерсииДанныхАндройда.getCount()>0) {
                    ///

                    КурсорДляАнализаВерсииДанныхАндройда.moveToFirst();


                    // TODO: 07.10.2021  запысываем версии тадиц их даты точнее версии данных


                    Integer ИндексДляТаблицыВерсииДанныхСинхронизации = КурсорДляАнализаВерсииДанныхАндройда.getColumnIndex("versionserveraandroid_version");
                    ///


                    ВерсияДанныхСКлиента_ТекущийТаблицыДляСинхронизации = КурсорДляАнализаВерсииДанныхАндройда.getLong(ИндексДляТаблицыВерсииДанныхСинхронизации);



                    // TODO: 07.10.2021  записываем название

                    МассивИхДатыДляОтправкиНаСервер [ИндексТекущейСтрочки]=String.valueOf(ВерсияДанныхСКлиента_ТекущийТаблицыДляСинхронизации);


                    Log.d(this.getClass().getName(), "ВерсияДанныхСКлиента_ТекущийТаблицыДляСинхронизации  "
                            +ВерсияДанныхСКлиента_ТекущийТаблицыДляСинхронизации);


                }

                // TODO: 15.08.2021  заоплняем полученню дату для отправки на сервер

                Log.d(this.getClass().getName(), "ВерсияДанныхСКлиента_ТекущийТаблицыДляСинхронизации  "
                        +ВерсияДанныхСКлиента_ТекущийТаблицыДляСинхронизации);


                // TODO: 16.08.2021 ping servera

                if (ВерсияДанныхСКлиента_ТекущийТаблицыДляСинхронизации == null) {

                    ВерсияДанныхСКлиента_ТекущийТаблицыДляСинхронизации = 0l;
                }


                // TODO: 16.08.2021 white adresss



                ИндексТекущейСтрочки++;



                //TODO clear from queqe
                arraylistТаблицыДляСинхронихзацции.peek();

            }


                LinkedHashMap<String,Long> linkedHashMapЗаполняемПришедшимиТаблицаСВерсиямиДанных=new LinkedHashMap();










            ///TODO вторая ставдия отправка


                // TODO: 26.08.2021 loop ping




                    КоличетвоСтрочекJSONотСервераВсе =
                            new Class_Get_For_Server_All_Rows_Json(contextGetClassNumberAllRowsJSON).
                                    МетодПолучаетОтСервераСтрочкиJSON(ИмяСервераДляJSON,ИмяПортаДляJSON,   МассивИхДатыДляОтправкиНаСервер);



                    //TODO ФУТУРЕ ЗАВЕРШАЕМ
                    Log.d(this.getClass().getName(), " КоличетвоСтрочекJSONотСервераВсе БЕЛЫЙ АДРЕС    " +КоличетвоСтрочекJSONотСервераВсе  +
                            "  ИмяСервераДляJSON " +ИмяСервераДляJSON+ " ИмяПортаДляJSON " +ИмяПортаДляJSON);

                    ///////

            }

            ///
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///
// TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(contextGetClassNumberAllRowsJSON).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

        }
        ///
        Log.d(this.getClass().getName(), " КоличетвоСтрочекJSONотСервераВсе  " + КоличетвоСтрочекJSONотСервераВсе);






        ///
        Log.d(this.getClass().getName(), "  КоличетвоСтрочекJSONотСервераВсе  " +   КоличетвоСтрочекJSONотСервераВсе);

        return    КоличетвоСтрочекJSONотСервераВсе;
    }

}