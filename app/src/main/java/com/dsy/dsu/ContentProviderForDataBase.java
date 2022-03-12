package com.dsy.dsu;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Stream;

public class ContentProviderForDataBase extends ContentProvider {


    UriMatcher uriMatcherДЛяПровайдераКонтентБазаДанных;
    // TODO: 28.10.2021
    SQLiteDatabase Create_Database_СамаБАзаSQLite;
    // TODO: 28.10.2021
    PUBLIC_CONTENT public_contentМенеджерПотоковМассвойОперацииВставки;






    public ContentProviderForDataBase() {

        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных=new UriMatcher(14);
        // TODO: 27.10.2021

        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","organization",1);
        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","depatment",2);
        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","fio",3);

        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","region",4);
        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","cfo",5);
        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","settings_tabels",6);

        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","notifications",7);
        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","templates",8);
        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","fio_template",9);

        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","chat_users",10);
        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","chats",11);
        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","data_chat",12);
        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","tabel",13);
        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","data_tabels",14);

        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","view_onesignal",15);

        // TODO: 27.10.2021
        uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.dsy.dsu.providerdatabase","data_notification",16);
    }





    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.

        Log.w(this.getClass().getName(), "  КОНТЕНТ ПРОВАЙДЕР delete  uri " +uri + " getContext()) " +getContext());
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        Log.w(this.getClass().getName(), "  КОНТЕНТ ПРОВАЙДЕР insert  uri " +uri + " getContext()) " +getContext());
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {

        // TODO: 30.10.2021

        int РезультатМассовогоВсатвкиДанных=0;
        // TODO: 30.10.2021
        public_contentМенеджерПотоковМассвойОперацииВставки=new PUBLIC_CONTENT(getContext());

        try {

        // TODO: 30.10.2021 thread
        public_contentМенеджерПотоковМассвойОперацииВставки.МенеджерПотоков.submit(()->{

            final int[] count = {0};

            Create_Database_СамаБАзаSQLite.beginTransaction();
            // TODO: 29.10.2021

            // TODO: 29.10.2021
            try {

                String table = new String();

                Log.d(this.getClass().getName(), " uri"+uri );

                switch (uriMatcherДЛяПровайдераКонтентБазаДанных.match(uri)) {


                    // TODO: 30.10.2021 КАКАЯ ТАБЛИЦА ТЕКУЩАЯ ДЛЯ ВСТАВКИ BURKINSERT


                    // TODO: 30.10.2021
                    case 1:

                        table = "organization";
                        break;
                    // TODO: 30.10.2021

                    // TODO: 30.10.2021
                    case 2:

                        table = "depatment";
                        break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 3:

                        table = "fio";
                        break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 4:

                        table = "region";
                        break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 5:

                        table = "cfo";
                        break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 6:

                        table = "settings_tabels";
                        break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 7:

                        table = "notifications";
                        break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 8:

                        table = "templates";
                        break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 9:


                        table = "fio_template";
                        break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 10:

                        table = "chat_users";
                        break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 11:

                        table = "chats";
                        break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 12:

                        table = "data_chat";
                        break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 13:

                        table = "tabel";
                        break;

                    // TODO: 30.10.2021
                    // TODO: 30.10.2021
                    case 14:

                        table = "data_tabels";
                        break;
                    // TODO: 30.10.2021


                    // TODO: 30.10.2021
                    case 15:
                        table = "view_onesignal";
                        break;


                    // TODO: 30.10.2021

                    case 16:
                    table = "data_notification";
                    break;
                    // TODO: 30.10.2021
                    // TODO: 30.10.2021

                        // TODO: 30.10.2021
                    default:

                        Log.w(getContext().getClass().getName(),
                                " defaluit table  " + table);/////



                }



                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    // TODO: 29.10.2021
                    Stream<ContentValues> stream = Stream.of(values);


                    // TODO: 29.10.2021
                    String finalTable = table;
                    // TODO: 22.11.2021 ЗАПУСК СТРИМА ВНУТРИ cONTENTvALUES

                    stream.parallel().spliterator().forEachRemaining((ТекущаяСтрочкаИзМассо) -> {

                        // TODO: 29.10.2021

                        Log.w(this.getClass().getName(), "ТекущаяСтрочкаИзМассо " + ТекущаяСтрочкаИзМассо);
                        // TODO: 29.10.2021




                        Log.w(getContext().getClass().getName(),
                                " table  " + finalTable);/////







                        long id = 0;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                            if (ТекущаяСтрочкаИзМассо.isEmpty() == false) {

                                id  = Create_Database_СамаБАзаSQLite.insert(finalTable, null, ТекущаяСтрочкаИзМассо);

                                Log.w(this.getClass().getName(), " Вставка массовая через burkInsert " + count[0]);
                            }
                        }
                        // TODO: 29.10.2021

                        if (0 < id) count[0]++;
                        // TODO: 29.10.2021
                        Log.w(this.getClass().getName(), "count " + count[0]);

                        // TODO: 29.10.2021
                        Log.w(this.getClass().getName(), "count " + count[0]);
                        // TODO: 29.10.2021
                    });
                    Log.w(this.getClass().getName(), "count " + count[0]);
                    // TODO: 30.10.2021

                }
                Log.w(this.getClass().getName(), "count " + count[0]);


                Log.w(this.getClass().getName(), "count " + count[0]);
                //TODO

                if (count[0]> 0) {

                    Create_Database_СамаБАзаSQLite.setTransactionSuccessful();
                }
                // TODO: 30.10.2021




                ///
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
            }finally {
                // TODO: 30.10.2021
                Create_Database_СамаБАзаSQLite.endTransaction();
                // TODO: 30.10.2021
                getContext().getContentResolver().notifyChange(uri, null);
            }


            Log.w(this.getClass().getName(), "count " + count[0]);

            return  count[0] ;
        });
        // TODO: 30.10.2021




            // TODO: 30.10.2021
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }finally {
            // TODO: 22.11.2021

            try {
                // TODO: 22.11.2021
                РезультатМассовогоВсатвкиДанных=(int) public_contentМенеджерПотоковМассвойОперацииВставки.МенеджерПотоков.take().get();
                
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ///
            Log.w(this.getClass().getName(), " РезультатМассовогоВсатвкиДанных  " + РезультатМассовогоВсатвкиДанных);

        }
        //super.bulkInsert(uri, values)
        return    РезультатМассовогоВсатвкиДанных;
    }




    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.


        Create_Database_СамаБАзаSQLite=new CREATE_DATABASE(getContext()).getССылкаНаСозданнуюБазу();
        // TODO: 28.10.2021


        if (Create_Database_СамаБАзаSQLite!=null) {

            // TODO: 29.10.2021
            Log.w(this.getClass().getName(), "Create_Database_СамаБАзаSQLite " + Create_Database_СамаБАзаSQLite);
            // TODO: 29.10.2021
            return true;

        }
        // TODO: 29.10.2021
        Log.w(this.getClass().getName(), "Create_Database_СамаБАзаSQLite " + Create_Database_СамаБАзаSQLite + " getContext()) " +getContext());

        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

      CREATE_DATABASE create_database=new CREATE_DATABASE(getContext());

        Cursor cursor =   create_database.getССылкаНаСозданнуюБазу().rawQuery("SELECT * FROM fio", null);

        Log.w(this.getClass().getName(), "  КОНТЕНТ ПРОВАЙДЕР query  111 uri " +uri + " getContext()) " +getContext());
        return cursor;
    }

/*
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder, @Nullable CancellationSignal cancellationSignal) {
        Log.w(this.getClass().getName(), "  КОНТЕНТ ПРОВАЙДЕР query  222 uri " +uri + " getContext()) " +getContext());
        return super.query(uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable Bundle queryArgs, @Nullable CancellationSignal cancellationSignal) {
        Log.w(this.getClass().getName(), "  КОНТЕНТ ПРОВАЙДЕР query  222 uri " +uri + " getContext()) " +getContext());
        return super.query(uri, projection, queryArgs, cancellationSignal);
    }
*/


    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        Log.w(this.getClass().getName(), "  КОНТЕНТ ПРОВАЙДЕР update  uri " +uri + " getContext()) " +getContext());
        return Integer.parseInt("1");
    }
}

