package com.dsy.dsu;

import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeoutException;
import java.util.function.ToDoubleBiFunction;
import java.util.zip.GZIPOutputStream;

import javax.crypto.CipherOutputStream;

public class Class_Get_For_Server_All_Rows_Json {

    Context contextДляКлассаПолученияВсехСтрочекJSON;
    ///


    ///////TODO
    CREATE_DATABASE   Create_Database_СсылкаНАБазовыйКласс;

    String    ПубличноеИмяПользовательДлСервлета=         new String();

    /////
    String      ПубличноеПарольДлСервлета=         new String();

    public Class_Get_For_Server_All_Rows_Json(Context context) {

        contextДляКлассаПолученияВсехСтрочекJSON=context;
///////TODO
          Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(contextДляКлассаПолученияВсехСтрочекJSON);
    }
    //функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ


    Integer МетодПолучаетОтСервераСтрочкиJSON(String Адресподключения,
                                              int ПортПодключения,
                                              String[]МассивИхДатыДляОтправкиНаСервер)
            throws IOException, ExecutionException, InterruptedException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {

        ///////ПОПЫТКА ПОДКЛЮЧЧЕНИЕ К ИНТРЕНТУ
        // AsyncTask AsyncTaskУнивермальныйДляОбмена=null;


        // TODO: 04.08.2021  данный метод порлучаем фактичесоое количество строк СТРОК НА СЕРВЕРЕ



        ///

        Integer КоличествоСтрочекJSONотСервера =0;


        System.out.println("УниверсальныйБуферПолучениеДанныхсСервера");
        ////////перевод перменных внутрь Анисакска
        ///////// ПРИ НУЛЕВОМ ЗАПУСКЕ ЛОВИМ ЭТОТ МОМЕНТ ДАТОЙ ИЗ ТАБЛИЦЫ АНДОЙД
        //////КОНЕЦ ЛОВЛИ НУЛОЙ ДАТЫ ТАБЛИЦЫ
        Object ОшибкаТекущегоМетода = new Object();
        //////
        Integer  ПубличноеIDПолученныйИзСервлетаДляUUID=0;

                ///
        HttpURLConnection ПодключениеПолученияДанныхсСервер = null;

        ////
        try {
            ////
            // ID


            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ
            Class_GRUD_SQL_Operations class_grud_sql_operationsПолучаемНаБазуUUIDфиоПолучаемИзТаблицыФИОИМЯ= new Class_GRUD_SQL_Operations(contextДляКлассаПолученияВсехСтрочекJSON);
            ///
            class_grud_sql_operationsПолучаемНаБазуUUIDфиоПолучаемИзТаблицыФИОИМЯ. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СамFreeSQLКОд",
                    " SELECT id  FROM successlogin  ORDER BY date_update DESC ;");


            // TODO: 12.10.2021  Ссылка Менеджер Потоков

            PUBLIC_CONTENT  Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new PUBLIC_CONTENT (contextДляКлассаПолученияВсехСтрочекJSON);


            ///////
            SQLiteCursor Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО= (SQLiteCursor) class_grud_sql_operationsПолучаемНаБазуUUIDфиоПолучаемИзТаблицыФИОИМЯ.
                    new GetаFreeData(contextДляКлассаПолученияВсехСтрочекJSON).getfreedata(class_grud_sql_operationsПолучаемНаБазуUUIDфиоПолучаемИзТаблицыФИОИМЯ. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());


            // TODO: 14.10.2021

            Log.d(this.getClass().getName(), " Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО  " + Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО);

            if(Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО.getCount()>0){
                /////
                Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО.moveToFirst();

                /////
                ПубличноеIDПолученныйИзСервлетаДляUUID=         Курсор_ПолучаемИмяСотрудникаИзТаблицыФИО.getInt(0);
///


                Log.d(this.getClass().getName(), " ПубличноеIDПолученныйИзСервлетаДляUUID  " + ПубличноеIDПолученныйИзСервлетаДляUUID);


            }


            String Adress_String = new String();
            ////
            String Params = new String();



            //PUBLIC_CONTENT.ПубличныйАдресGlassFish = "http://tabel.dsu1.ru:8888/"; //http://80.66.149.58:8888   //http://tabel.dsu1.ru/
            ////192.168.254.40
            //  Adress_String = "http://tabel.dsu1.ru:8888/dsu1.glassfish/DSU1JsonServlet=";///СТРОЧКА УКАЗЫВАЕТ НА КАКОЙ СЕРВЕЛ НА СЕРВЕР МЫ БУДЕМ СТУЧАТЬСЯ /// 80.66.149.58
            Adress_String = "http://"+Адресподключения+":"+ПортПодключения+"/dsu1.glassfish/DSU1JsonServlet" +
                    "?organization_rows=" +МассивИхДатыДляОтправкиНаСервер[0]+"&depatment_rows=" +МассивИхДатыДляОтправкиНаСервер[1]+"&fio_rows="
                    +МассивИхДатыДляОтправкиНаСервер[2]+"&region_rows=" +МассивИхДатыДляОтправкиНаСервер[3]
                    +"&cfo_rows=" +МассивИхДатыДляОтправкиНаСервер[4]+"&settings_tabels_rows=" +МассивИхДатыДляОтправкиНаСервер[5]+
                    "&notifications_rows=" +МассивИхДатыДляОтправкиНаСервер[6]+"&templates_rows=" +МассивИхДатыДляОтправкиНаСервер[7]
                    +"&fio_template_rows=" +МассивИхДатыДляОтправкиНаСервер[8]+"&chat_users_rows=" +МассивИхДатыДляОтправкиНаСервер[9]+
                    "&chats_rows=" +МассивИхДатыДляОтправкиНаСервер[10]+"&data_chat_rows=" +МассивИхДатыДляОтправкиНаСервер[11]+
                    "&tabel_rows=" +МассивИхДатыДляОтправкиНаСервер[12]+  "&data_tabels_rows=" +МассивИхДатыДляОтправкиНаСервер[13]+
               "&publicuserforountjosnrows="+ПубличноеIDПолученныйИзСервлетаДляUUID
                    +"&ЗаданиеДляСервлетаВнутриПотока=" +
                    "Хотим%20Получить%20ID%20для%20Генерации%20%20UUID&ДатаНаДанныеВнутриПотока=" +
                    "&alltabels_sendservername=";





            ///СТРОЧКА УКАЗЫВАЕТ НА КАКОЙ СЕРВЕЛ НА СЕРВЕР МЫ БУДЕМ СТУЧАТЬСЯ /// 80.66.149.58
            ///Adress_String = "http://192.168.254.40:8080/dsu1.glassfish/DSU1JsonServlet?ИмяТаблицыОтАндройда=%20&КонкретнаяТаблицаВПотоке=&МакАдресТелефона=&ЗаданиеДляСервлетаВнутриПотока=Хотим%20Получить%20ID%20для%20Генерации%20%20UUID&ДатаНаДанныеВнутриПотока=&IDДляПолучениеКонткртнойНабораТаблиц=";///СТРОЧКА УКАЗЫВАЕТ НА КАКОЙ СЕРВЕЛ НА СЕРВЕР МЫ БУДЕМ СТУЧАТЬСЯ /// 80.66.149.58


           //// String [] ddd= PUBLIC_CONTENT.ИменаТаблицыОтАндройда.toArray(new String[0]);
            /// dsu1.glassfish/DSU1JsonServlet
            ///////////;
            Log.d(this.getClass().getName(), "Adress_String " + Adress_String);

            ////
            Adress_String = Adress_String.replace(" ", "%20");
            ///
            Log.d(this.getClass().getName(), " Adress_String " + Adress_String);


            // TODO: 25.05.2021  адереса

            URL Adress = new URL(Adress_String);
            //
            ПодключениеПолученияДанныхсСервер = (HttpURLConnection) (Adress).openConnection();/////САМ ФАЙЛ JSON C ДАННЫМИ

           // ПодключениеПолученияДанныхсСервер.setDoInput(true);

           /// ПодключениеПолученияДанныхсСервер.setDoOutput(true);

            ПодключениеПолученияДанныхсСервер.setRequestProperty("Content-Type", "application/txt ;charset=UTF-8");

            ПодключениеПолученияДанныхсСервер.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");

            // ПодключениеПолученияДанныхсСервер.setRequestProperty("Nametabelforchatvesion", "chats");
            ПодключениеПолученияДанныхсСервер.setRequestProperty("Connection", "Keep-Alive");

            ПодключениеПолученияДанныхсСервер.setRequestProperty("Accept-Language", "ru-RU");

            ПодключениеПолученияДанныхсСервер.setRequestMethod("HEAD"); ///   HEAD GET //ПРОВЕРЯЕМ ЕСЛИ ПОДКЛЮЧЕНИЕ К СЕВРЛЕТУ НА СЕРВЕР ВЫБРАСЫВАЕМ

            ПодключениеПолученияДанныхсСервер.setReadTimeout(10000); //todo САМ ТАЙМАУТ ПОДКЛЮЧЕНИЕ(30000);

            ПодключениеПолученияДанныхсСервер.setConnectTimeout(10000);//todo САМ ПОТОК ДАННЫХ(1000);

            //     ПодключениеПолученияДанныхсСервер.setChunkedStreamingMode(0);
            ПодключениеПолученияДанныхсСервер.setUseCaches(true);



            //////////



       //TODO ПУБЛИЧНЫЙ ЛОГИН и ПАРОЛЬ

            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ
             class_grud_sql_operationsПолучаемНаБазуUUIDфиоПолучаемИзТаблицыФИОИМЯ= new Class_GRUD_SQL_Operations(contextДляКлассаПолученияВсехСтрочекJSON);
            ///
            class_grud_sql_operationsПолучаемНаБазуUUIDфиоПолучаемИзТаблицыФИОИМЯ. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СамFreeSQLКОд",
                    " SELECT success_users,success_login  FROM successlogin  ORDER BY date_update DESC ;");


            // TODO: 12.10.2021  Ссылка Менеджер Потоков

         Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new PUBLIC_CONTENT (contextДляКлассаПолученияВсехСтрочекJSON);


            ///////
            SQLiteCursor            Курсор_ПолучаемИмяСотрудникаИзТаблицыФИОПолучениеПубличногоЛогинаИПароля=
                    (SQLiteCursor) class_grud_sql_operationsПолучаемНаБазуUUIDфиоПолучаемИзТаблицыФИОИМЯ.
                    new GetаFreeData(contextДляКлассаПолученияВсехСтрочекJSON).getfreedata(class_grud_sql_operationsПолучаемНаБазуUUIDфиоПолучаемИзТаблицыФИОИМЯ. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков
                    ,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());


            /////////////
            Log.d(this.getClass().getName(), "  Курсор_ПолучаемИмяСотрудникаИзТаблицыФИОПолучениеПубличногоЛогинаИПароля "
                    + Курсор_ПолучаемИмяСотрудникаИзТаблицыФИОПолучениеПубличногоЛогинаИПароля);


            if(Курсор_ПолучаемИмяСотрудникаИзТаблицыФИОПолучениеПубличногоЛогинаИПароля.getCount()>0){
                ////
                Курсор_ПолучаемИмяСотрудникаИзТаблицыФИОПолучениеПубличногоЛогинаИПароля.moveToFirst();

                /////
                ПубличноеИмяПользовательДлСервлета=         Курсор_ПолучаемИмяСотрудникаИзТаблицыФИОПолучениеПубличногоЛогинаИПароля.getString(0).trim();

                /////
                ПубличноеПарольДлСервлета=           Курсор_ПолучаемИмяСотрудникаИзТаблицыФИОПолучениеПубличногоЛогинаИПароля.getString(1).trim();



                Log.d(this.getClass().getName(), " ПубличноеИмяПользовательДлСервлета=         " + ПубличноеИмяПользовательДлСервлета+ " ПубличноеПарольДлСервлета" +ПубличноеПарольДлСервлета);
            }


            //////////
            Log.d(this.getClass().getName(), "  PUBLIC_CONTENT.ПубличноеИмяПользовательДлСервлета  " + ПубличноеИмяПользовательДлСервлета +
                    " PUBLIC_CONTENT.ПубличноеПарольДлСервлета " + ПубличноеПарольДлСервлета);
            /////
            ПодключениеПолученияДанныхсСервер.setRequestProperty(ПубличноеИмяПользовательДлСервлета, ПубличноеПарольДлСервлета);





            //

            // TODO: 15.08.2021ПОСЫЛАЕМ НА СЕРВЕР ХЭШ С ИМЕНАМИ ТАЛИЦ И ДАТЫ К НЕЙ
            /////
     /*       ПодключениеПолученияДанныхсСервер.setRequestProperty("dateforrowsjson", ДатаДляОтправкиЕеНаСерверДляПолученияJSON);
            ///////
            ПодключениеПолученияДанныхсСервер.setRequestProperty("nametableforjson", ТаблицыДляОтправкиЕеНаСерверДляПолученияJSON);

            /////TODo public user


            ПодключениеПолученияДанныхсСервер.setRequestProperty("publicuserforountjosnrows",PUBLIC_CONTENT.ПубличноеIDПолученныйИзСервлетаДляUUID) ;
*/


            ПодключениеПолученияДанныхсСервер.connect(); /////////////ТОЛЬКО СОЕДИНЕНИЕ

            // ПодключениеПолученияДанныхсСервер.getResponseCode();///ВАЖНАЯ КОМАНДА  СТУЧИТЬСЯ В СЕРВЛЕТ ECLIPSE СТУЧИМСЯ ВТОРОЙ РАЗ ЧТОБЫ ПОЛУЧИТЬ УЖЕ САМ JSON

            ПодключениеПолученияДанныхсСервер.getContent(); ////РЕАЛЬНОЕ ПОЛУЧЕНИЕ ДАННЫХ С ИНТРЕНЕТА



            ///



            Log.d(this.getClass().getName(), "ПодключениеИнтернетДляОтправкиНаСервер.getContentLength() "
                    + ПодключениеПолученияДанныхсСервер.getHeaderField("stream_current_get_json_rows_prograssbar"));//stream_current_get_json_rows

            КоличествоСтрочекJSONотСервера = Integer.parseInt(ПодключениеПолученияДанныхсСервер.getHeaderField("stream_current_get_json_rows_prograssbar"));//stream_current_get_json_rows

            Log.d(this.getClass().getName(), "КоличествоСтрочекJSONотСервера " + КоличествоСтрочекJSONотСервера);


            ////TODO И ЕСЛИ ПРИШЕЛ ОТ СЕРВЕРА ОТВЕТ ПОЛОЖИТЕЛЬНО ТО ТОГДА ЗАПУСКАМ ПРОЧТЕНИЯ ПОТОКА ПРИШЕДШЕГО С СЕРВЕРА
            if (ПодключениеПолученияДанныхсСервер.getResponseCode() == 200 && КоличествоСтрочекJSONотСервера > 0) {
                //TODO шифровани
                // Log.d(this.getClass().getName(), "  ПолитикаРасшифровки  " +PUBLIC_CONTENT. ПолитикаРасшифровки);

                Log.d(this.getClass().getName(), " КоличествоСтрочекJSONотСервера"
                        + КоличествоСтрочекJSONотСервера);
                ////

            }     ////TODO нет ответа от сервер или поток нулевой
            else {
                Log.i(this.getClass().getName(), "ПОТОК ПРИШЕЛ НУЛОВОЙ ОТ СЕРВЕРА  " + ПодключениеПолученияДанныхсСервер.getInputStream().available());
            }



            /////////////////////////
            ПодключениеПолученияДанныхсСервер.disconnect();

            ///////
        } catch (IOException ex) {
            ex.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(MODEL_synchronized.class.getName(), "Ошибка " + ОшибкаТекущегоМетода + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " ОшибкаТекущегоМетода " + ОшибкаТекущегоМетода.toString());
            new   Class_Generation_Errors(contextДляКлассаПолученияВсехСтрочекJSON).МетодЗаписиВЖурналНовойОшибки(ex.toString(), MODEL_synchronized.class.getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

        }

        //// todo get ASYNtASK
        return КоличествоСтрочекJSONотСервера;


    }


}
