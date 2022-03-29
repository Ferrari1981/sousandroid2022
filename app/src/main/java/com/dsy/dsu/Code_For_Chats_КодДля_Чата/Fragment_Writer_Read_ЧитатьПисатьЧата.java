package com.dsy.dsu.Code_For_Chats_КодДля_Чата;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteCursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.android.volley.toolbox.HttpResponse;
import com.dsy.dsu.CREATE_DATABASE;
import com.dsy.dsu.Class_Connections_Server;
import com.dsy.dsu.Class_Engine_SQL;
import com.dsy.dsu.Class_GRUD_SQL_Operations;
import com.dsy.dsu.Class_Generation_Data;
import com.dsy.dsu.Class_Generation_Errors;
import com.dsy.dsu.Class_Generation_UUID;
import com.dsy.dsu.Class_Generations_PUBLIC_CURRENT_ID;
import com.dsy.dsu.Code_For_Firebase_AndOneSignal_Здесь_КодДЛяСлужбыУведомленияFirebase.Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal;
import com.dsy.dsu.MODEL_synchronized;
import com.dsy.dsu.PUBLIC_CONTENT;
import com.dsy.dsu.R;
import com.dsy.dsu.SubClass_RetryGEtRowInChatsКлассПроверемЕщеРАзПоявилосЛИПуббличныйUUIDМеждуУчасникамиЧата;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;


public class Fragment_Writer_Read_ЧитатьПисатьЧата extends Fragment {

    // TODO: Rename parameter arguments, choose names that match

    View viewДляСообщений = null;

    ///////TODO
    CREATE_DATABASE Create_Database_СсылкаНАБазовыйКласс;

    ListView ЛистВьюДляСообщенийЧата = null;

    Long CallBaskОтWorkManagerОдноразового=0l;



    SimpleCursorAdapter АдаптерДляЗаписиЧтенияЧата = null;



    SQLiteCursor КурсорДанныеДлязаписиичтнияЧата = null;

    Class_GRUD_SQL_Operations class_grud_sql_operationsРабоатемВФрагментечитатьПисатьДляПолученияПУбличногоIDПолучениеГлавныхДанные;
    // TODO: 27.10.2021

    // TODO: 05.03.2022

    private Long ПолученыйIDДляЧата = 0l;

    // TODO: 22.12.2021
    String ИмяСлужбыСинхронизацииОбщая = "WorkManager Synchronizasiy_Data";//"WorkManager Synchronizasiy_Data";//  "WorkManager Synchronizasiy_Data"; ///"WorkManager Synchronizasiy_Data";


    // TODO: 22.12.2021
    String ИмяСлужбыСинхронизацииОдноразовая = "WorkManager Synchronizasiy_Data Disposable";//"WorkManager Synchronizasiy_Data";//  "WorkManager Synchronizasiy_Data"; ///"WorkManager Synchronizasiy_Data";

    // TODO: 04.03.2022

    // TODO: 04.03.2022
    String ИмяСлужбыОбщейСинхронизацииДляЗадачи="WorkManager Synchronizasiy_Data";




    private Long ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата = 0l;

    //
    String ПолученыйФИОIDДляЧата = new String();


    FloatingActionButton floatingActionButtonВФагментеReadandWrite;

    Long ПубличныйUUIDКогдаУжеМеждуПользоватлеямиУжеЕстьПерепискаВРодительскоТАблице = 0l;


    TextView textViewФрагментЧитатьПисатьДляЧата;
    //

    EditText editTextТелоНаписаногоСообщенияДругимСотрудникам;

    ///
    String КлючДляFirebaseNotification = "2a1819db-60c8-4ca3-a752-1b6cd9cadfa1";
    // TODO: 11.10.2021

    PUBLIC_CONTENT public_contentМенеджерПотоковПоРасписанию = null;



    MODEL_synchronized modelДляФрагментаДляОперацииЗаписиНовгоСтатусаПрочитанного;



    MODEL modelСсылкаНАВнутренийКлассаДаннгоФрагмента;

    // TODO: 06.08.2021
    // TODO: 06.08.2021

    // TODO: 12.10.2021  Ссылка Менеджер Потоков

    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = null;

    LinkedBlockingQueue<String> ЛистЗапускаемТолькоТаблицыЧатаВСинхронизации = new LinkedBlockingQueue();
    /////////

    Activity ActivityДляСинхронизацииОбмена = null;

    Fragment fragment = null;

    Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal class_generation_sendBroadcastReceiver_and_firebase_oneSignal;
    // TODO: 27.12.2021


    WorkInfo WorkInfoИнформацияОЗапущенойСлужбеОдноразовая;

    WorkInfo WorkInfoИнформацияОЗапущенойОБЩАЯ;
/*
    Boolean  ФлагУказываетНАЗАпускСИнхронизацииИзЧата=true;





    // TODO: 07.07.2021  главный метод фрагмента читать и писать
    Boolean  ФлагУказываетСозданииНовгоСообщенияиИзЧата=true;*/
// TODO: 07.07.2021  главный метод фрагмента читать и писать
// TODO: 26.08.2021  конструктор

    // TODO: 26.08.2021  МЕНЕДЖЕР ПОТОКВ ДЛЯ GRUD ОПЕРАЦИЙ--по расписанию
    //////////


    //
    Integer ПубличныйIDДляФрагмента = 0;


    // TODO: 24.12.2021


    Observer observerОбщейДляWORKMANAGER;

    // TODO: 04.03.2022

    Observer observerОдноразоваяДляWORKMANAGER;

    DataSetObserver dataSetObserver;

    DataSetObserver dataSetObserverПодпискаНаЛокальныйИспользуетьсяКУРСОРОМ;

    // TODO: 10.02.2022
    Integer ПолученноеФИОКемБылоНаписаноСообщение = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        try {

            // TODO: 09.09.2021  поток устанавлваем по рассанию


            class_generation_sendBroadcastReceiver_and_firebase_oneSignal =
                    new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getContext());


///////TODO
            Create_Database_СсылкаНАБазовыйКласс = new CREATE_DATABASE(getContext());


            ActivityДляСинхронизацииОбмена = getActivity();

            ////

            fragment = this;


            // TODO: 27.12.2021


            modelСсылкаНАВнутренийКлассаДаннгоФрагмента = new MODEL(getContext());


            // TODO: 27.12.2021


            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ
            class_grud_sql_operationsРабоатемВФрагментечитатьПисатьДляПолученияПУбличногоIDПолучениеГлавныхДанные = new Class_GRUD_SQL_Operations(getContext());


            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = new PUBLIC_CONTENT(getContext());


            Log.d(getContext().getClass().getName(), "ActivityДляСинхронизацииОбмена " + ActivityДляСинхронизацииОбмена.toString() +
                    "  fragment " + fragment.toString());


            // Inflate the layout for this fragment
            viewДляСообщений = inflater.inflate(R.layout.fragment3_layout, container, false);
            /////
            // Inflate the layout for this fragment


            ////
            ЛистВьюДляСообщенийЧата = (ListView) viewДляСообщений.findViewById(R.id.list);


            floatingActionButtonВФагментеReadandWrite = (FloatingActionButton) viewДляСообщений.findViewById(R.id.floatingActionButtonВФагментеReadandWrite);


            textViewФрагментЧитатьПисатьДляЧата = (TextView) viewДляСообщений.findViewById(R.id.textViewФрагментЧитатьПисатьДляЧата);


            // TODO: 30.06.2021 даннеы


            ПолученыйIDДляЧата = 0l;

            ////


            ПолученыйIDДляЧата = getArguments().getLong("ПолученыйIDДляЧата");


            Log.d(this.getClass().getName(), "   ПолученыйIDДляЧата" + ПолученыйIDДляЧата);


//

            ПолученыйФИОIDДляЧата = new String();


            ПолученыйФИОIDДляЧата = getArguments().getString("ПолученыйФИОIDДляЧата");


            Log.d(this.getClass().getName(), "   ПолученыйФИОIDДляЧата" + ПолученыйФИОIDДляЧата);
            // TODO: 22.12.2021

            ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата = 0l;


            ////


            ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата = getArguments().getLong("ПолученыйUUIDУжеСуществующийПерепискиПользоватлейДляЧата");


            Log.d(this.getClass().getName(), "   ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата" + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата);


            Log.d(this.getClass().getName(), "   ЗАПУСК ФОНОВОЙ СИНХРОНИЗАЦИИИ С mYwORK_sYNCHRONIZACI  СЛУЖБА  WorkManager Synchronizasiy_Data ПолученыйIDДляЧата "
                    + ПолученыйIDДляЧата +
                    "  ПолученыйФИОIDДляЧата "
                    + ПолученыйФИОIDДляЧата +
                    "  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " +
                    ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата);


            // TODO: 05.07.2021 значение написаного сообджгение в чате для другого пользолвателя

            editTextТелоНаписаногоСообщенияДругимСотрудникам = (EditText) viewДляСообщений.findViewById(R.id.editTextТелоНаписаногоСообщенияДругимСотрудникам);

//////////////////


            ////
            ЛистВьюДляСообщенийЧата = (ListView) viewДляСообщений.findViewById(R.id.list);


            floatingActionButtonВФагментеReadandWrite = (FloatingActionButton) viewДляСообщений.findViewById(R.id.floatingActionButtonВФагментеReadandWrite);


            textViewФрагментЧитатьПисатьДляЧата = (TextView) viewДляСообщений.findViewById(R.id.textViewФрагментЧитатьПисатьДляЧата);


            // TODO: 06.10.2021  опредяем какие таблиув для синхрониазцуии с этогй фрагмента для чата
            ЛистЗапускаемТолькоТаблицыЧатаВСинхронизации.add("chats");
            ///
            ЛистЗапускаемТолькоТаблицыЧатаВСинхронизации.add("data_chat");


            Log.d(this.getClass().getName(), "ЛистЗапускаемТолькоТаблицыЧатаВСинхронизации " + ЛистЗапускаемТолькоТаблицыЧатаВСинхронизации);


            // TODO: 30.09.2021 МЕТОД ЗАПУСКА СИНХРОНИЗАЦИИ ЧАТА ПО РАСПИСАНИЮ , НЕ ВЗАВИСИМОСТИ ОТ СОЗДАВАЛ ЛИ СООБЩЕНИЕ ИЛИ НЕТ

            ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(getContext()).ПолучениеПубличногоТекущегоПользователяID();


            Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);




            //todo

            //editTextТелоНаписаногоСообщенияДругимСотрудникам.setBackgroundColor();


            editTextТелоНаписаногоСообщенияДругимСотрудникам.setBackgroundResource(R.drawable.style_for_chat_for_fragmaent_read_wirte_new_messages);

















            // TODO: 16.12.2021  --ОДНОРАЗОВАЯ СИНХРОНИАЗЦИЯ СЛУШАТЕЛЬ

            ПолученноеФИОКемБылоНаписаноСообщение=   new Class_Generations_PUBLIC_CURRENT_ID(getContext()).ПолучениеПубличногоТекущегоПользователяID();

            //    МетододеноразовойСлужбыСинхрониазции();

            Log.d(this.getClass().getName(), "  ПРОШЕЛ ПРОЦЕСС ЗАПУСКА СЛУЖБ И oBSERVER МетодЗапускаСинхрониазцииПоРАсписаниювНезависимостиОтВставкиНовгоСообщения(); "+ПолученноеФИОКемБылоНаписаноСообщение);
            // TODO: 16.12.2021   ПРОВЕРКА И ЗАПУСК ИЗМНЕНИЯ РАБОЧЕГО СТОЛКА КОГДА В ВОРК МЕНЕДЖЕРЕ ИЗМЕНИНИЯ ПРОИЗОЩЛИВ БАЗЕ


            //TODO сама всатвка  ПЕРВЫЙ  ЗАПУСКАЕМ МЕНЕДЖЕР ПОТОКОВ


            МетодЗапускаСинхрониазцииПоРАсписаниювНезависимостиОтВставкиНовгоСообщения();


            Log.d(this.getClass().getName(), "  ПРОШЕЛ ПРОЦЕСС ЗАПУСКА СЛУЖБ И oBSERVER МетодЗапускаСинхрониазцииПоРАсписаниювНезависимостиОтВставкиНовгоСообщения(); ");


            // TODO: 04.03.2022  запуск ВТОРОГО СЛУШАТЕЛЯ ОЮЩЕЙ СИНХРОНИАЗЦИИ ДЛЯ ЧАТА

            МетодЗапускаВторогоСлушателяОбщегоWorkManager();


            Log.d(this.getClass().getName(), "  ПРОШЕЛ ПРОЦЕСС ЗАПУСКА СЛУЖБ И oBSERVER МетодЗапускаВторогоСлушателяОбщегоWorkManager(); ");


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///


        }
        return viewДляСообщений;
    }


    private void МетододеноразовойСлужбыСинхрониазции() {
        // TODO: 28.12.2021

        try {

            // TODO: 28.12.2021  ЗАПУСК ОДНОРАЗОВОЙ СЛУЖБЫ

            // TODO: 04.11.2021   ЗАПУСКАЕМ СИНХРОНИАХЦИИЮ  через ONESIGNAL

            // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР
            // TODO: 30.09.2021 МЕТОД ЗАПУСКА СИНХРОНИЗАЦИИ ЧАТА ПО РАСПИСАНИЮ , НЕ ВЗАВИСИМОСТИ ОТ СОЗДАВАЛ ЛИ СООБЩЕНИЕ ИЛИ НЕТ


            Log.d(this.getClass().getName(), " ИЗ ВСЕХ ТАБЕЛЕЙ   ОДНОРАЗОВАЯ СИНХРОНИЗАЦИЯ ");


            // TODO: 04.11.2021   ЗАПУСКАЕМ СИНХРОНИАХЦИИЮ  через ONESIGNAL
            Log.d(this.getClass().getName(), "РезультатCallsBackСинхрониазцииЧата ");


            new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getContext()).
                    МетодПовторногоЗапускаВсехWorkManager__ОДНОРАЗОВОЙСинхрониазцииданных(ПубличныйIDДляФрагмента, getContext());

            // TODO: 30.12.2021

            Log.w(getContext().getClass().getName(), " ПЕРВЫЙ ЗАПУСК НА ФРАГМЕНТЕ ЧИТАТЬ И ПИСАТЬ  " + ПубличныйIDДляФрагмента + "\n");


            // TODO: 04.11.2021   ЗАПУСКАЕМ СИНХРОНИАХЦИИЮ  через ONESIGNAL

            WorkInfoИнформацияОЗапущенойСлужбеОдноразовая =
                    WorkManager.getInstance(getContext().getApplicationContext()).getWorkInfosByTag(ИмяСлужбыСинхронизацииОдноразовая).get().get(0);


            Log.w(getContext().getClass().getName(), " ПОСЛЕ ОТРАБОТКИ МЕТОДА ..." +
                    ".Внутри метода public Result doWork()  MyWork_Async_Синхронизация_ОДНОРАЗОВАЯ " + ИмяСлужбыСинхронизацииОдноразовая + "\n"
                    + " getState  " +
                    WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().name() + "\n" +
                    "getTags " +
                    WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getTags() + "\n" +
                    "getRunAttemptCount " +
                    WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getRunAttemptCount() + "\n" +
                    "getProgress " +
                    WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().isFinished() + "\n" +
                    " время : " + new Date());


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///


        }
    }


    @Override
    public void onStart() {
        super.onStart();
        try {
            /////todo данная настрока запрещает при запуке активти подскаваать клавиатуре вверх на компонеты eedittext
            //


            Log.d(this.getClass().getName(), "////МетодЗапускаСинхрониазцииПоРАсписаниювНезависимостиОтВставкиНовгоСообщения ");


            // TODO: 15.07.2021    ////////////////////////////////МОДЕЛЬ MVC ////////////////////////////////////////////////////////////////////////////////////////////////


            new Fragment_Writer_Read_ЧитатьПисатьЧата.MODEL(getContext()).МетодПолучениеДанныхдляФрагментаЧитатьиПисатьЧат();

            // TODO: 21.12.2021


            new Fragment_Writer_Read_ЧитатьПисатьЧата.VIEW(getContext());

            // TODO: 21.12.2021


            new Fragment_Writer_Read_ЧитатьПисатьЧата.CONTROLLER(getContext());
            //

            Log.d(this.getClass().getName(), "////МетодЗапускаСинхрониазцииПоРАсписаниювНезависимостиОтВставкиНовгоСообщения ");
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///


        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();


        try {
            // TODO: 13.01.2022


/*    Operation operation=  WorkManager.getInstance(getContext()).cancelAllWorkByTag(ИмяСлужбыСинхронизацииОдноразовая);





    Log.w(getContext().getClass().getName(), " ВЫХОД ИЗ ФРАГМЕНТА ЧИТАТЬИ ПИСАТЬ ЧАТ ПОСЛЕ ОТРАБОТКИ МЕТОДА  onDestroy ..." +
            ".Внутри метода Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal Observer " + ИмяСлужбыСинхронизацииОдноразовая + "\n"
            + " getState  " +
            WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().name() + "\n" +
            "getTags " +
            WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getTags() + "\n" +
            "getRunAttemptCount " +
            WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getRunAttemptCount() + "\n" +
            "getProgress " +
            WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().isFinished() + "\n" +
            " время : " + new Date()+" \n" +
            "   operation.getState() " + operation.getState());


*/


            Log.d(this.getClass().getName(), "////МетодЗапускаСинхрониазцииПоРАсписаниювНезависимостиОтВставкиНовгоСообщения onDestroy ");

            // TODO: 16.12.2021

            if (dataSetObserverПодпискаНаЛокальныйИспользуетьсяКУРСОРОМ != null && КурсорДанныеДлязаписиичтнияЧата != null) {
                // TODO: 02.02.2022
                КурсорДанныеДлязаписиичтнияЧата.unregisterDataSetObserver(dataSetObserverПодпискаНаЛокальныйИспользуетьсяКУРСОРОМ);
            }


            if (observerОдноразоваяДляWORKMANAGER != null && ИмяСлужбыСинхронизацииОдноразовая != null) {
                // TODO: 30.12.2021   --ОТПИСЫВАЕМСЯ
                WorkManager.getInstance(getContext()).getWorkInfosByTagLiveData(ИмяСлужбыСинхронизацииОдноразовая).removeObserver(observerОдноразоваяДляWORKMANAGER);
            }

            // TODO: 04.03.2022

            if (observerОбщейДляWORKMANAGER != null && ИмяСлужбыОбщейСинхронизацииДляЗадачи != null) {
                // TODO: 30.12.2021   --ОТПИСЫВАЕМСЯ
                WorkManager.getInstance(getContext()).getWorkInfosByTagLiveData(ИмяСлужбыОбщейСинхронизацииДляЗадачи).removeObserver(observerОбщейДляWORKMANAGER);
            }


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///


        }

    }


    // TODO: 18.10.2021  СИНХРОНИАЗЦИЯ ЧАТА ПО РАСПИСАНИЮ ЧАТ
    private void МетодЗапускаСинхрониазцииПоРАсписаниювНезависимостиОтВставкиНовгоСообщения() throws ExecutionException, InterruptedException {
        ///
// TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления

        try {

            // TODO: 27.10.2021


            // TODO: 16.12.2021  --ОДНОРАЗОВАЯ СИНХРОНИАЗЦИЯ СЛУШАТЕЛЬ

            observerОдноразоваяДляWORKMANAGER = new Observer<List<WorkInfo>>() {
                @Override
                public void onChanged(List<WorkInfo> workInfosОдноразовая) {


                    // TODO: 23.12.2021
                    workInfosОдноразовая.stream()
                            .filter(СтастусWorkMangerДляФрагментаЧитатьИПисать -> СтастусWorkMangerДляФрагментаЧитатьИПисать != null)
                            .filter(СтастусWorkMangerДляФрагментаЧитатьИПисать ->
                                    СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().compareTo(WorkInfo.State.SUCCEEDED) == 0)
                            .forEachOrdered((СтастусWorkMangerДляФрагментаЧитатьИПисать) -> {
                                // TODO: 18.02.2022
                                try {

                                    //
                                    Log.d(this.getClass().getName(), " WorkInfoИнформацияОЗапущенойСлужбеОдноразовая  СтастусWorkMangerЧата " + СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().name());
                                    CallBaskОтWorkManagerОдноразового = 0l;

                                    CallBaskОтWorkManagerОдноразового = СтастусWorkMangerДляФрагментаЧитатьИПисать.getOutputData().getLong("ОтветПослеВыполения_MyWork_Async_Синхронизация_Одноразовая", 0l);

                                    // TODO: 18.02.2022
                                    if (CallBaskОтWorkManagerОдноразового == null) {
                                        // TODO: 18.02.2022
                                        CallBaskОтWorkManagerОдноразового = 0l;
                                    }
                                    // TODO: 14.01.2022
                                    //
                                    Log.d(this.getClass().getName(), " CallBaskОтWorkManagerОдноразового " + CallBaskОтWorkManagerОдноразового);


                                    if (CallBaskОтWorkManagerОдноразового > 0) {
                                        // TODO: 23.12.2021  ЗАПУСКАЕМ ПОВТРОНУЮ СИНХРОНИАЗУИБЮ
                                        if (КурсорДанныеДлязаписиичтнияЧата != null) {

                                            КурсорДанныеДлязаписиичтнияЧата.deactivate();
                                            // TODO: 27.12.2021

                                            КурсорДанныеДлязаписиичтнияЧата.requery();
                                        }

                                        ////
                                        if (ЛистВьюДляСообщенийЧата != null && АдаптерДляЗаписиЧтенияЧата != null) {
                                            // TODO: 19.02.2022
                                            ЛистВьюДляСообщенийЧата.setSelection(АдаптерДляЗаписиЧтенияЧата.getCount() - 1);
                                        }

                                        // TODO: 18.02.2022

                                    }
                                    if (СтастусWorkMangerДляФрагментаЧитатьИПисать != null) {
                                        // TODO: 20.02.2022
                                        Log.d(this.getClass().getName(), " WorkInfoИнформацияОЗапущенойСлужбеОдноразовая  СтастусWorkMangerЧата " + СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().name() +
                                                " CallBaskОтWorkManagerОдноразового " + CallBaskОтWorkManagerОдноразового);
                                    }

                                    // TODO: 29.09.2021  конец синхрониазции по раписанию
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    ///метод запись ошибок в таблицу
                                    Log.e(this.getClass().getName(), "Ошибка  Фрагмент Читать и Писать   observerОдноразоваяДляWORKMANAGER = new Observer<List<WorkInfo>>() {" +
                                            " МетодЗапускаСинхрониазцииПоРАсписаниювНезависимостиОтВставкиНовгоСообщения  " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                                }
                            });



                }
            };


// TODO: 18.02.2022

            if (observerОдноразоваяДляWORKMANAGER!=null) {
                // TODO: 20.02.2022
                // TODO: 20.02.2022
                WorkManager.getInstance(getContext()).getWorkInfosByTagLiveData(ИмяСлужбыСинхронизацииОдноразовая).observeForever(observerОдноразоваяДляWORKMANAGER);
            }


            // TODO: 29.09.2021  конец синхрониазции по раписанию



            Log.d(this.getClass().getName(), " WorkInfoИнформацияОЗапущенойСлужбеОдноразовая  СтастусWorkMangerЧата "+" CallBaskОтWorkManagerОдноразового " +CallBaskОтWorkManagerОдноразового);





        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }


    }

    // TODO: 18.10.2021  СИНХРОНИАЗЦИЯ ЧАТА ПО РАСПИСАНИЮ ЧАТ
    private void МетодЗапускаВторогоСлушателяОбщегоWorkManager() throws ExecutionException, InterruptedException {
        ///
// TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления

        try {

            // TODO: 27.10.2021


            // TODO: 16.12.2021  --ОДНОРАЗОВАЯ СИНХРОНИАЗЦИЯ СЛУШАТЕЛЬ

            observerОбщейДляWORKMANAGER = new Observer<List<WorkInfo>>() {
                @Override
                public void onChanged(List<WorkInfo> workInfosОдноразовая) {



                    // TODO: 23.12.2021
                    workInfosОдноразовая.stream()
                            .filter(СтастусWorkMangerДляФрагментаЧитатьИПисать -> СтастусWorkMangerДляФрагментаЧитатьИПисать!=null)
                            .filter(СтастусWorkMangerДляФрагментаЧитатьИПисать ->
                                    СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().compareTo(WorkInfo.State.ENQUEUED) == 0)
                            .forEachOrdered((СтастусWorkMangerДляФрагментаЧитатьИПисать) ->{
                                // TODO: 18.02.2022
                                try {

                                    //
                                    Log.d(this.getClass().getName(), " WorkInfoИнформацияОЗапущенойСлужбеОдноразовая  СтастусWorkMangerЧата " + СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().name());
                                    CallBaskОтWorkManagerОдноразового=0l;

                                    CallBaskОтWorkManagerОдноразового=   СтастусWorkMangerДляФрагментаЧитатьИПисать.getOutputData().getLong("ОтветПослеВыполения_MyWork_Async_Синхронизация_Одноразовая",0l);

                                    // TODO: 18.02.2022
                                    if (CallBaskОтWorkManagerОдноразового==null) {
                                        // TODO: 18.02.2022
                                        CallBaskОтWorkManagerОдноразового=0l;
                                    }
                                    // TODO: 14.01.2022
                                    //
                                    Log.d(this.getClass().getName(), " CallBaskОтWorkManagerОдноразового " + CallBaskОтWorkManagerОдноразового);


                                    if (CallBaskОтWorkManagerОдноразового>0) {
                                        // TODO: 23.12.2021  ЗАПУСКАЕМ ПОВТРОНУЮ СИНХРОНИАЗУИБЮ
                                        if (КурсорДанныеДлязаписиичтнияЧата!=null) {

                                            КурсорДанныеДлязаписиичтнияЧата.deactivate();
                                            // TODO: 27.12.2021

                                            КурсорДанныеДлязаписиичтнияЧата.requery();
                                        }

                                        ////
                                        if (ЛистВьюДляСообщенийЧата!=null  && АдаптерДляЗаписиЧтенияЧата!=null) {
                                            // TODO: 19.02.2022
                                            ЛистВьюДляСообщенийЧата.setSelection(АдаптерДляЗаписиЧтенияЧата.getCount() - 1);
                                        }

                                        // TODO: 18.02.2022

                                    }
                                    if (СтастусWorkMangerДляФрагментаЧитатьИПисать!=null ) {
                                        // TODO: 20.02.2022
                                        Log.d(this.getClass().getName(), " WorkInfoИнформацияОЗапущенойСлужбеОдноразовая  СтастусWorkMangerЧата " + СтастусWorkMangerДляФрагментаЧитатьИПисать.getState().name()+
                                                " CallBaskОтWorkManagerОдноразового " +CallBaskОтWorkManagerОдноразового);
                                    }

                                    // TODO: 29.09.2021  конец синхрониазции по раписанию
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    ///метод запись ошибок в таблицу
                                    Log.e(this.getClass().getName(), "Ошибка  Фрагмент Читать и Писать   observerОдноразоваяДляWORKMANAGER = new Observer<List<WorkInfo>>() {" +
                                            " МетодЗапускаСинхрониазцииПоРАсписаниювНезависимостиОтВставкиНовгоСообщения  " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                                }
                            });



                }
            };


// TODO: 18.02.2022

            if (observerОбщейДляWORKMANAGER!=null) {
                // TODO: 20.02.2022
                // TODO: 20.02.2022
                WorkManager.getInstance(getContext()).getWorkInfosByTagLiveData(ИмяСлужбыОбщейСинхронизацииДляЗадачи).observeForever(observerОбщейДляWORKMANAGER);
            }


            // TODO: 29.09.2021  конец синхрониазции по раписанию



            Log.d(this.getClass().getName(), " WorkInfoИнформацияОЗапущенойСлужбеОдноразовая  СтастусWorkMangerЧата "+" CallBaskОтWorkManagerОдноразового " +CallBaskОтWorkManagerОдноразового);





        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }


    }


    // TODO: 19.08.2021 Асинхронно  запуск синхронизации ЧАТА

    // TODO: 22.12.2021 ЗАПИСИ НОВГО СОООБЩЕНИЯ ТОЛЬКО В ДОЧЕРНУЮ ТАБЛИЦУ ДАТА ЧАТ ТАК,  КАК УЖЕ ЕСТЬ ПЕРЕРПИСКА МЕЖДУ НИМИ ПОЛЬЗВАОТЕЛЯМИ И ЕСТЬ UUID
    @NonNull
    private Long МетодОперацииВставкиТолькоРодительскуюТаблицу_ЧАТ_КогдаЕщеНЕтПерепискиМеждуПользователями(
            Integer ПубличныйIDДляФрагмента, Long НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID)
            throws ExecutionException,
            InterruptedException,
            TimeoutException,
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException {


        // TODO: 22.12.2021

        String ПерваяТаблицыОбработкиТаблицаЧат = "chats";

        final Long[] РезультатВставки_НовойЗаписиРодительскуюТаблицыЧАТ = {0l};
        // TODO: 22.12.2021

        // TODO: 21.12.2021
        try {


            //
            Log.d(this.getClass().getName(), "  ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);


            Log.d(this.getClass().getName(), "   НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID " + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID +
                    " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);

            // TODO: 08.02.2022 заполяем чтобы два раза записть две строчки

            LinkedBlockingQueue<Integer> linkedBlockingQueueДляЗаписиСразуДвестрокиЧатОДляКого = new LinkedBlockingQueue();
            // TODO: 08.02.2022
            linkedBlockingQueueДляЗаписиСразуДвестрокиЧатОДляКого.offer(ПубличныйIDДляФрагмента);  //todo Я ---
            // TODO: 08.02.2022
            linkedBlockingQueueДляЗаписиСразуДвестрокиЧатОДляКого.offer(Integer.parseInt(String.valueOf(ПолученыйIDДляЧата)));//TODO КОМУ ПИШЕМ


            linkedBlockingQueueДляЗаписиСразуДвестрокиЧатОДляКого.forEach((ТекущееЗначениеДляЗаписиВЦиклеВДваСтлбика) -> {

                try {


                    // TODO: 08.02.2022 записи значения в таблицу CHATS

                    /////КОНТЕЙГНЕР
                    ContentValues contentValuesЗаписьНовогоСообщения_ТаблицаЧат = new ContentValues();


                    ////TODO ДАТА
                    String СгенерированованныйДатаДляФрагмента = new Class_Generation_Data(getContext()).ГлавнаяДатаИВремяОперацийСБазойДанных();

                    Log.d(this.getClass().getName(), "   СгенерированованныйДатаДляФрагмента " + СгенерированованныйДатаДляФрагмента);


                    contentValuesЗаписьНовогоСообщения_ТаблицаЧат.put("date_update", СгенерированованныйДатаДляФрагмента);
                    ///////////////////////////////////////

                    contentValuesЗаписьНовогоСообщения_ТаблицаЧат.put("user_update", ПубличныйIDДляФрагмента);
                    //////

                    contentValuesЗаписьНовогоСообщения_ТаблицаЧат.put("id_user", (Integer) ТекущееЗначениеДляЗаписиВЦиклеВДваСтлбика);////бышвий user_for     ПолученыйIDДляЧата

                    contentValuesЗаписьНовогоСообщения_ТаблицаЧат.putNull("_id");////бышвий user_for


                    Log.d(this.getClass().getName(), "  ПолученыйIDДляЧата  " + ПолученыйIDДляЧата + "  ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента
                            + "ТекущееЗначениеДляЗаписиВЦиклеВДваСтлбика " + ТекущееЗначениеДляЗаписиВЦиклеВДваСтлбика);

                    // TODO: 22.12.2021  один на две таблицы UUID


                    ////
                    Long ЛокльныйUUIDТОлькоДЛЯОднойТаблицыChats = 0l;
                    ЛокльныйUUIDТОлькоДЛЯОднойТаблицыChats =
                            (Long) new Class_Generation_UUID(getContext()).МетодГенерацииUUID(getContext());

                    //
                    Log.d(this.getClass().getName(), "ЛокльныйUUIDТОлькоДЛЯОднойТаблицыChats "
                            + ЛокльныйUUIDТОлькоДЛЯОднойТаблицыChats);
// TODO: 10.02.2022

                    ЛокльныйUUIDТОлькоДЛЯОднойТаблицыChats = ЛокльныйUUIDТОлькоДЛЯОднойТаблицыChats + 1;

                    contentValuesЗаписьНовогоСообщения_ТаблицаЧат.put("uuid", ЛокльныйUUIDТОлькоДЛЯОднойТаблицыChats);

                    // TODO: 08.02.2022

                    //
                    Log.d(this.getClass().getName(), "НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID "
                            + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID);


                    // TODO: 22.12.2021  один на две таблицы UUID

                    contentValuesЗаписьНовогоСообщения_ТаблицаЧат.put("uuid_parent", НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID);


                    Log.d(this.getClass().getName(), "ЛокльныйUUIDТОлькоДЛЯОднойТаблицыChats   "
                            + ЛокльныйUUIDТОлькоДЛЯОднойТаблицыChats +
                            " НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID " + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID);


                    // TODO: 10.02.2022

                    ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата = НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID;

                    Log.d(this.getClass().getName(), " ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата "
                            + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата + " НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID " + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID);

                    //TODO курант чат

                    Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть = new Class_GRUD_SQL_Operations(getContext());


                    Long РезультатУвеличинаяВерсияДАныхЧата = 0L;

                    РезультатУвеличинаяВерсияДАныхЧата = class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.new ChangesVesionData(getContext()).
                            МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table(ПерваяТаблицыОбработкиТаблицаЧат, "localversionandroid_version", getContext()
                                    , Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());


                    //TODO  конец курант ча
                    //////
                    contentValuesЗаписьНовогоСообщения_ТаблицаЧат.put("current_table", РезультатУвеличинаяВерсияДАныхЧата);


                    Log.d(this.getClass().getName(), "РезультатУвеличинаяВерсияДАныхЧата   " + РезультатУвеличинаяВерсияДАныхЧата);


                    // TODO: 05.07.2021 вставка новго сообщения в деве таблоицы Code_For_Chats_КодДля_Чата and DATA_Chat


                    // TODO: 15.08.2021  начало транзакции
                    ///PUBLIC_CONTENT.ССылкаНаСозданнуюБазу.execSQL(" BEGIN DEFERRED TRANSACTION ");


                    РезультатВставки_НовойЗаписиРодительскуюТаблицыЧАТ[0] = new MODEL_synchronized(getContext())
                            .ВставкаДанныхЧерезКонтейнерТолькоПриСозданииНСообщенияДЛЯЧата("chats",
                                    contentValuesЗаписьНовогоСообщения_ТаблицаЧат, ПерваяТаблицыОбработкиТаблицаЧат, "",
                                    true);

                    Log.d(this.getClass().getName(), " РезультатВставки_НовойЗаписиРодительскуюТаблицыЧАТ "
                            + РезультатВставки_НовойЗаписиРодительскуюТаблицыЧАТ[0]);


                    ////////

                    // TODO: 23.07.2021 борьба с гонками потоков

                    ////
                    if (РезультатВставки_НовойЗаписиРодительскуюТаблицыЧАТ[0] > 0) {

                        //TODO ДОПОЛНИТЕЛЬНОЕ СОХРАНИЕНИ  ДАННЫХ С ПИМИМИНЕНИЕМ ВЕРСИЙ ДАННЫХ (ВМЕСТО ДАТЫ)
// TODO: 28.09.2021

                        contentValuesЗаписьНовогоСообщения_ТаблицаЧат.clear();
                        ////TODO ДАТА  ПОВЫШАЕМ ВЕРИСЮ ДАННЫХ

                        ////TODO УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННЫХ  В ТАБЛИЦЕ MODIFICATION CLIENT

                        Integer Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы =
                                new Class_Engine_SQL(getContext()).МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_Client(
                                        РезультатВставки_НовойЗаписиРодительскуюТаблицыЧАТ[0]
                                        , ПерваяТаблицыОбработкиТаблицаЧат,
                                        "Локальное", РезультатУвеличинаяВерсияДАныхЧата,
                                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков);


                        Log.i(this.getClass().getName(), "   РезультатВставки_НовойЗаписиРодительскуюТаблицыЧАТ" + РезультатВставки_НовойЗаписиРодительскуюТаблицыЧАТ[0] +
                                "  Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы " + Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы);


                    }

                    // TODO: 22.12.2021

                    Object вЫКИДИВАЕМоТРАБТАННЫЙэЛЕМЕНТ = linkedBlockingQueueДляЗаписиСразуДвестрокиЧатОДляКого.poll();

                    // TODO: 22.12.2021
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    // TODO: 01.09.2021 метод вызова
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                            this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    ///

                }

            });


            // TODO: 22.12.2021
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///

        }


        return РезультатВставки_НовойЗаписиРодительскуюТаблицыЧАТ[0];
    }


// TODO: 01.07.2021 метод когда нет данных в курсоре и отображаем сообщени что сообщений нет в фрагменте

    // TODO: 22.12.2021 ЗАПИСИ НОВГО СОООБЩЕНИЯ ТОЛЬКО В ДОЧЕРНУЮ ТАБЛИЦУ ДАТА ЧАТ ТАК,  КАК УЖЕ ЕСТЬ ПЕРЕРПИСКА МЕЖДУ НИМИ ПОЛЬЗВАОТЕЛЯМИ И ЕСТЬ UUID
    @NonNull
    private Long МетодОперацииВставкиТолькоДочернуюТаблицу_ДАТА_ЧАТ_ПотомуЧтоУжестьМеждуНимиПерписка(
            Integer ПубличныйIDДляФрагмента, Long НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID)
            throws ExecutionException,
            InterruptedException,
            TimeoutException,
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException {


        // TODO: 22.12.2021
        Long РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка = 0l;

        // TODO: 22.12.2021

        // TODO: 28.09.2021  запись в таблицу Data_tabels

        String ТаблицаВторойОбработкиДляТаблицыДата_Табеля = "data_chat";
        // TODO: 22.12.2021
        String ДатаПриСоздаенииНовгоСообщениявЧате;
        // TODO: 21.12.2021
        try {


            //
            Log.d(this.getClass().getName(), "  ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента + "НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID " + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID);


            // TODO: 21.12.2021 сгеенрированный UUID только для таблицы Chat


            Log.d(this.getClass().getName(), "  НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID " + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID);


            if (НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID > 0) {

                ///         ///TODO --вторая вставка   ТАБЛИЦА  DATA_TABELS   вторая вставка   ТАБЛИЦА  DATA_TABELS   вторая вставка   ТАБЛИЦА  DATA_TABELS  вторая вставка   ТАБЛИЦА  DATA_TABELS

                ///TODO --вторая вставка

                //TODO курант чат

                Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДанныхДевятаяЧасть = new Class_GRUD_SQL_Operations(getContext());

                // TODO: 20.07.2021
                //////
                /////
                ContentValues contentValuesЗаписьНовогоСообщения_ТаблицыDATA_CHAT = new ContentValues();
                ////////


                //////
                ////TODO ДАТА
                String СгенерированованныйДатаДляДаннойОперации = new Class_Generation_Data(getContext()).ГлавнаяДатаИВремяОперацийСБазойДанных();


                ///

                Log.d(this.getClass().getName(), "   НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID " + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID +
                        " ПриСоздаенииНовгоСообщениявЧате " + СгенерированованныйДатаДляДаннойОперации);


                /////////


                contentValuesЗаписьНовогоСообщения_ТаблицыDATA_CHAT.put("date_update", СгенерированованныйДатаДляДаннойОперации);

                //////
                contentValuesЗаписьНовогоСообщения_ТаблицыDATA_CHAT.put("user_update", ПубличныйIDДляФрагмента);
                ///

                Log.d(this.getClass().getName(), "   НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID " + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID +
                        " ПриСоздаенииНовгоСообщениявЧате " + СгенерированованныйДатаДляДаннойОперации + " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);


                ////     contentValuesЗаписьНовогоСообщения_ТаблицыDATA_CHAT.put("id_user", ПолученыйIDДляЧата);////бышвий user_for

                ////

                Log.d(this.getClass().getName(), "   НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID " + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID +
                        " ПриСоздаенииНовгоСообщениявЧате " + СгенерированованныйДатаДляДаннойОперации + " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента + " ПолученыйIDДляЧата " + ПолученыйIDДляЧата);


                Log.d(this.getClass().getName(), "   НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID " + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID +
                        " ПриСоздаенииНовгоСообщениявЧате " + СгенерированованныйДатаДляДаннойОперации);


                Log.d(this.getClass().getName(),
                        " ПолученныйУжеСуществующийUUIDСТрочкаИСоздаватьНЕНадоИзТаблицыCHATS " + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID);
                ////
                contentValuesЗаписьНовогоСообщения_ТаблицыDATA_CHAT.put("chat_uuid", НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID);


                Log.d(this.getClass().getName(),
                        " РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка " + РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка);

                // TODO: 22.12.2021 НовыйUUIDДляТаблицыДатаЧат  для таблицы дата_чат
                ////
                Long ЛокальныйUUIDДляТаблицыДатаЧатВтораяТаблица = (Long) new Class_Generation_UUID(getContext()).МетодГенерацииUUID(getContext());
                //

                Log.d(this.getClass().getName(),
                        " ЛокальныйUUIDДляТаблицыДатаЧатВтораяТаблица " + ЛокальныйUUIDДляТаблицыДатаЧатВтораяТаблица);
                ////
                contentValuesЗаписьНовогоСообщения_ТаблицыDATA_CHAT.put("uuid", ЛокальныйUUIDДляТаблицыДатаЧатВтораяТаблица);


                // TODO: 11.08.2021 up current chat vesion

                Long РезультатУвеличинаяВерсияДАныхДатЧата = 0L;


                РезультатУвеличинаяВерсияДАныхДатЧата =
                        class_grud_sql_operationsПовышаемВерсиюДанныхДевятаяЧасть.new ChangesVesionData(getContext()).
                                МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table
                                        (ТаблицаВторойОбработкиДляТаблицыДата_Табеля, "localversionandroid_version", getContext()
                                                , Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

                //TODO  конец курант чат
                ///


                //////
                contentValuesЗаписьНовогоСообщения_ТаблицыDATA_CHAT.put("current_table", РезультатУвеличинаяВерсияДАныхДатЧата);


                Log.d(this.getClass().getName(), "РезультатУвеличинаяВерсияДАныхДатЧата   " + РезультатУвеличинаяВерсияДАныхДатЧата);


                // TODO: 05.07.2021 само тело новго сообщения
                String СамоСообщенияНовоеДляЧата = new String();
                //////
                СамоСообщенияНовоеДляЧата = editTextТелоНаписаногоСообщенияДругимСотрудникам.getText().toString().trim();


                Log.i(this.getClass().getName(), "   Создано новое сообщение :::" +
                        " СамоСообщенияНовоеДляЧата " + СамоСообщенияНовоеДляЧата);


                ////
                if (СамоСообщенияНовоеДляЧата.length() > 0) {
                    ///////
                    contentValuesЗаписьНовогоСообщения_ТаблицыDATA_CHAT.put("message", СамоСообщенияНовоеДляЧата.trim());


                    /////////TODO ЗАМА ЗАПИСЬ НОВГО СООБЩЕНИЯ ЧАТА В ТАБЛИЦУ В ТОРОЙ УЖЕ ЕСТЬ ЗАПИСЬ
                    ///
                    РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка = new MODEL_synchronized(getContext()).
                            ВставкаДанныхЧерезКонтейнерТолькоПриСозданииНСообщенияДЛЯЧата(ТаблицаВторойОбработкиДляТаблицыДата_Табеля,
                                    contentValuesЗаписьНовогоСообщения_ТаблицыDATA_CHAT, ТаблицаВторойОбработкиДляТаблицыДата_Табеля, "",
                                    true);


                    Log.d(this.getClass().getName(),
                            " РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка " + РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка);


                    //////
                    contentValuesЗаписьНовогоСообщения_ТаблицыDATA_CHAT.clear();


                    ////TODO УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННЫХ  В ТАБЛИЦЕ MODIFICATION CLIENT
                    if (РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка > 0) {

                             /* //TODO ДОПОЛНИТЕЛЬНОЕ СОХРАНИЕНИ  ДАННЫХ С ПИМИМИНЕНИЕМ ВЕРСИЙ ДАННЫХ (ВМЕСТО ДАТЫ)
                              int РезультатЗаписиВерсииДанныхвБазе=    new MODEL_synchronized(getContext()).
                                      МетодЗаписьЧтоОрацияПрошлаЗаписьВБазуСПрименениемВерсииДанных("data_chat", new Date(),null,"localversionandroid_version",Integer.parseInt(String.valueOf(РезультатУвеличинаяВерсияДАныхДатЧата)));

*/
                        ////TODO ДАТА  ПОВЫШАЕМ ВЕРИСЮ ДАННЫХ

                        Integer Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы =
                                new Class_Engine_SQL(getContext()).МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_Client(
                                        РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка,
                                        ТаблицаВторойОбработкиДляТаблицыДата_Табеля,
                                        "Локальное", РезультатУвеличинаяВерсияДАныхДатЧата,
                                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков);


                        Log.i(this.getClass().getName(), "   PUBLIC_CONTENT.СколькоСтрочекJSONПоКонкретнойТаблице:" +
                                " РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка " + РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка +
                                "  Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы " + Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы);


                        // TODO: 26.07.2021  обняем после синхрониазции
                        if (Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы > 0) {

                            // TODO: 22.12.2021

                            РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка++;
                            ////
                            editTextТелоНаписаногоСообщенияДругимСотрудникам.setText("");

                            ///

                        }

                    }

                }


            }


            // TODO: 22.12.2021
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///

        }


        return РезультатВставки_ТолькоВДочернуюТаблицуТакаКакВСтрашойТАблицуУжеЕстьПереписка;
    }

    // TODO: 18.06.2021  класс вью
    private class VIEW {

        public VIEW(Context context) {


            try {

                //   RequestFuture<JSONObject> requestFuture=RequestFuture.newFuture();
                HttpResponse httpResponse;
                // JsonObjectRequest myReq = new JsonObjectRequest(Request.Method.POST, "ss", jsonObj, requestFuture, requestFuture);


                /////

                Log.d(this.getClass().getName(), "  VIEW   ");

                if (КурсорДанныеДлязаписиичтнияЧата != null) {
                    ///
                    if (КурсорДанныеДлязаписиичтнияЧата.getCount() > 0) {
                        Log.d(this.getClass().getName(), "  КурсорДанныеДлязаписиичтнияЧата   " + КурсорДанныеДлязаписиичтнияЧата.getCount());

                        // TODO: 01.07.2021  МЕТОД ЗАГРУЖЕТ ДАННЫЕ НА ФРАГМЕНТ ЧАТА ЧИТАТЬ И ПИСАТЬ ПРИ НАЛИЧИИ ИХ В КУРСОРЕ
                        МетодЗагрузкиданныхНаФрагментКогдаЕстьДанные();


                        // TODO: 05.07.2021 КОД КОТОРЫЙ ЗАПИСЫВАЕМ 1 И ПОКАЗЫВАЕТ ЧТО АТ ПРОЧИТАН И НЕ НАДО ЕГО ВЫДЕЛЯТЬ ЖИРНЫМ ЦВЕТОМ


                        ////////
                    } else {

                        // TODO: 01.07.2021  МЕТОД НЕ ЗАГРУЖАЕТ НА ФРАГМЕНТ ПОТОМУ ЧТО В КУРСОРРЕ НЕТ ДАННЫХ  ПОЛЬЗОТЕЛЮ МЫ ПРОСТОПОКАЗЫВЕМ СООБШЩЕНИЕ ЧТО НЕТ СООБЩЕНИЙ ПОКА
                        МетодЗагрузкиданныхНаФрагментКогдаНетДанных();

                        Log.d(this.getClass().getName(), "  нет данных для заргузки КурсорДанныеДлязаписиичтнияЧата   " + КурсорДанныеДлязаписиичтнияЧата.getCount());


                    }
                }else{



                    // TODO: 01.07.2021  МЕТОД НЕ ЗАГРУЖАЕТ НА ФРАГМЕНТ ПОТОМУ ЧТО В КУРСОРРЕ НЕТ ДАННЫХ  ПОЛЬЗОТЕЛЮ МЫ ПРОСТОПОКАЗЫВЕМ СООБШЩЕНИЕ ЧТО НЕТ СООБЩЕНИЙ ПОКА
                    МетодЗагрузкиданныхНаФрагментКогдаНетДанных();

                    Log.d(this.getClass().getName(), "  нет данных для заргузки КурсорДанныеДлязаписиичтнияЧата   ");
                }

                Log.d(this.getClass().getName(), "  МетодЗагрузкиданныхНаФрагментКогдаНетДанных   ");


                ///


                ////


            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///


            }
        }




        //TODO после успешного полцчение или отправки данных с серврер на клиент и обратно показываем пользователю это при чате

        private void МетодДляЧатаПоказываемВизуальноОтправкуИИлиПолучениеДанных(String СообщениеДействияИлиОжидания,Integer ВремяОжидания) {
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
                    //   editTextТелоНаписаногоСообщенияДругимСотрудникам.setHintTextColor(Color.parseColor("#E0FFFF"));
                    ///////
                    //

                    EditText finalEditTextТелоНаписаногоСообщенияДругимСотрудникам1 = editTextТелоНаписаногоСообщенияДругимСотрудникам;
                    editTextТелоНаписаногоСообщенияДругимСотрудникам.post(new Runnable() {
                        @Override
                        public void run() {

                            // TODO: 19.10.2021
                            finalEditTextТелоНаписаногоСообщенияДругимСотрудникам1.setHintTextColor(Color.parseColor("#00ACC1"));
                            //

                            finalEditTextТелоНаписаногоСообщенияДругимСотрудникам1.setHint(СообщениеДействияИлиОжидания);
                        }
                    });


                    EditText finalEditTextТелоНаписаногоСообщенияДругимСотрудникам = editTextТелоНаписаногоСообщенияДругимСотрудникам;
                    editTextТелоНаписаногоСообщенияДругимСотрудникам.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            // TODO: 19.10.2021
                            finalEditTextТелоНаписаногоСообщенияДругимСотрудникам.setHintTextColor(Color.parseColor("#00ACC1"));
                            //

                            finalEditTextТелоНаписаногоСообщенияДругимСотрудникам.setHint("Напишите сообщение  ►►");

                        }
                    },ВремяОжидания);
                }

                // TODO: 28.10.2021






            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new   Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ////// начало запись в файл
            }

        }


























        // TODO: 01.07.2021  метод загружаем на фрагмент данные когда в курсоре есть данные

        private void МетодЗагрузкиданныхНаФрагментКогдаЕстьДанные() throws ExecutionException, InterruptedException {
            // КурсорДанныеДлязаписиичтнияЧата
            //

            MODEL modelДляФрагментаЧитатьИлиПисать = new MODEL(getContext());

            // TODO: 03.01.2022
            CONTROLLER controllerДляФрагментаЧитатьИлиПисать = new CONTROLLER(getContext());


            Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть = new Class_GRUD_SQL_Operations(getContext());


            modelДляФрагментаДляОперацииЗаписиНовгоСтатусаПрочитанного = new MODEL_synchronized(getContext());

            Class_Engine_SQL Class_Engine_SQLДляИзмененияСтатусаЗаписиПрочтитаноИлиНет = null;

            Log.i(this.getClass().getName(), "   КурсорДанныеДлязаписиичтнияЧата  "+КурсорДанныеДлязаписиичтнияЧата.getCount());
            ////
            try {
                Class_Engine_SQLДляИзмененияСтатусаЗаписиПрочтитаноИлиНет=new Class_Engine_SQL(getContext());
                // TODO: 03.01.2022
                // КурсорДанныеДлязаписиичтнияЧата.requery();

                ///TODO ГЛАВНЫЙ АДАПТЕР чата
                АдаптерДляЗаписиЧтенияЧата = new SimpleCursorAdapter(getContext(), R.layout.simple_for_chats_read_write, КурсорДанныеДлязаписиичтнияЧата,
                        new String[]{"user_update", "date_update"},
                        new int[]{android.R.id.text1, android.R.id.text2}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);


                // TODO: 05.07.2021 set FIO
                АдаптерДляЗаписиЧтенияЧата.runQueryOnBackgroundThread("Поток ДЛЯ АДПТЕРА ");


                if (ПолученыйФИОIDДляЧата != null && ПолученыйФИОIDДляЧата.length() > 0) {
                    ///
                    textViewФрагментЧитатьПисатьДляЧата.setText(ПолученыйФИОIDДляЧата);

                    //


                    // TODO: 06.07.2021 после как мы зашли в чат в строчку конткетную делаем его ка прочитанный не жирный


                } else {
                    ///
                    textViewФрагментЧитатьПисатьДляЧата.setText("ЧАТ");
                }


                //
                Class_Engine_SQL finalClass_Engine_SQLДляИзмененияСтатусаЗаписиПрочтитаноИлиНет = Class_Engine_SQLДляИзмененияСтатусаЗаписиПрочтитаноИлиНет;

                // TODO: 14.02.2022

                SimpleCursorAdapter.ViewBinder БиндингДляСообщенийЧата = new SimpleCursorAdapter.ViewBinder() {
                    @Override
                    public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
                        // TODO: 22.06.2021 выравниваем тексвид
                        ////todo
                        if (cursor.getCount() > 0) {
                            ///
                            switch (view.getId()) {

                                case android.R.id.text1:
                                    ///////
                                    Log.d(this.getClass().getName(), " ClassActitytyClassActityty  view.getId() " + view.getId());
                                    //TODO  метод визуального ОФРМЕЛНИЯ ЧАТА

                                    MaterialButton textViewСамоСообщение = view.findViewById(android.R.id.text1);

                                    // TODO: 29.03.2022
                                    // TODO: 29.03.2022
                                    ((MaterialButton) view).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

                                    Log.d(this.getClass().getName(), " ClassActitytyClassActityty  textViewСамоСообщение " + textViewСамоСообщение);

                                    // TODO: 29.06.2021 сами сообщения для с выбранным сотрудником

                                    int ИндексТелоСообщенийВсехСВыбраннымСотрудником = cursor.getColumnIndex("message");

                                    // TODO: 29.04.2021
                                    /////////////////
                                    String ПолученноеТелоСообщения = cursor.getString(ИндексТелоСообщенийВсехСВыбраннымСотрудником);

                                    Log.d(this.getClass().getName(), " метод посика уже существующего сотрудника в базе андройжа ПолученныйФИО"
                                            + ПолученноеТелоСообщения);

                                    // TODO: 08.11.2021  new style disian

                                    // TODO: 30.06.2021 форматирование кто написал
                                    int ИндексКтоНаписалСообщениеСотрудником = cursor.getColumnIndex("user_update");

                                    // TODO: 29.04.2021
                                    /////////////////
                                    int ПолученноеКтоНаписал = cursor.getInt(ИндексКтоНаписалСообщениеСотрудником);



                                    Log.d(this.getClass().getName(), " метод посика уже существующего сотрудника в базе андройжа ПолученныйФИО"
                                            + ПолученноеТелоСообщения);


                                    // TODO: 30.06.2021 форматирование кто написал
                                    int ИндексUUIDЧатаМнеНаписали = cursor.getColumnIndex("chat_uuid");

                                    // TODO: 29.04.2021
                                    Long UUIDЧатаКтоНАписалМнеНаписали = 0l;
                                    /////////////////
                                    UUIDЧатаКтоНАписалМнеНаписали = cursor.getLong(ИндексUUIDЧатаМнеНаписали);
                                    // TODO: 27.10.2021

                                    Log.w(this.getClass().getName(), " UUIDЧатаКтоНАписалМнеНаписали " + UUIDЧатаКтоНАписалМнеНаписали);


                                    // TODO: 29.03.2022  заполняем важной информацией инфификатор для всех и свои х СООБЩЕНИЙ И ЧУЖИХ

                                    ((MaterialButton) view).setTag(UUIDЧатаКтоНАписалМнеНаписали);

                                    // TODO: 23.11.2021 сам компонет ТЕКС1 само сообщение

                                    Log.d(this.getClass().getName(), " ПолученноеКтоНаписал " + ПолученноеКтоНаписал

                                            + " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента + " textViewСамоСообщение " + textViewСамоСообщение.getText().toString());


                                    /////
                                    Log.d(this.getClass().getName(), " Я ПолученноеКтоНаписал " + ПолученноеКтоНаписал + "\n" +
                                            " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);


                                    //TODO сообщение написано мной ВНИМАНИЕ !!!!!


                                    if (ПолученноеКтоНаписал == ПубличныйIDДляФрагмента) {

                                        /////
                                        Log.d(this.getClass().getName(), " Я ПолученноеКтоНаписал " + ПолученноеКтоНаписал + "\n" +
                                                " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);


                                        //TODO сообщения НАПИСАНЫ МНЕ --СООБЩЕНИЯ ЧУЖИЕ ОТ ДРУГОВО ПОЛЬЗОВАТЕЛЯ

                                        МетодОбрабатываетСвоиСообщенияДляЧатаText1((MaterialButton) view, cursor, ПолученноеТелоСообщения, ПолученноеКтоНаписал);


                                        ////todo ПОКАЗЫВАЕМ ФЛАГ ЕСЛИ ДАННЫЕ УСПЕШНО ОПРАВИЛИЬС ИЛИ ВРЕНУЛСЬ СС СЕРВРА ТО СООБШЕНИЯ ОКРАШИВАЕМ В СИНИЯ ЦВЕТ
                                        МетодИзменяетСтильСтрочкиСообщенияВМоментеЕслиССервераПришелОтветОПолжительнойВставкеСообщенияВремяОжиданияText1((MaterialButton) view, ПолученноеТелоСообщения);


                                        // TODO: 29.03.2022  меняем цвет сообещния в засимости я написал его или мне написли


                                        МетодМеняемЦветСообщениявЗависимостиЯНаписалЕгоИлиМне((MaterialButton) view,
                                                textViewСамоСообщение,
                                                ПолученноеКтоНаписал,
                                                "#80D8FF");


                                        // TODO: 29.03.2022  
                                        Log.d(this.getClass().getName(), " ПолученноеКтоНаписал " + ПолученноеКтоНаписал
                                                + " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента + " textViewСамоСообщение " + textViewСамоСообщение.getText().toString());
                                        // TODO: 03.01.2022  код не текущего пользователя кто МЕН НАПИСАЛ


                                    } else {


                                        //TODO сообщение написано другим ПОЛЬЗОВАТЕЛЕММ  ВНИМАНИЕ !!!!!

                                        Log.d(this.getClass().getName(), " я сам автор ПолученноеКтоНаписал " + ПолученноеКтоНаписал

                                                + " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента + " textViewСамоСообщение " + textViewСамоСообщение.getText().toString());

                                        // TODO: 23.11.2021  данные код МЕНЯТЕТ СТАТУС СООБЩЕНИЕ КОТОРЕ ПРИШЛО НАПИСАНО МНЕ И Я  ЕГО МЕНЯЮ А ПРОЧИТАННОЙ

                                        МетодСменаСтатусаНеНашихСообщенийЧатаText2(cursor,
                                                ПолученноеКтоНаписал, (TextView) textViewСамоСообщение);


                                        ///////TODO ОТОБРОЖЕНИЯ СООБШЕНИЙ КОТОРЫЕ НЕ МОИ

                                        МетодФормленияСообщениеййНаписаннымиНеНамиАДругимиУчастиникамиЧатаText2((TextView) view, ПолученноеТелоСообщения);


                                        // TODO: 29.03.2022  меняем цвет сообещния в засимости я написал его или мне написли


                                        МетодМеняемЦветСообщениявЗависимостиЯНаписалЕгоИлиМне((MaterialButton) view,
                                                textViewСамоСообщение,
                                                ПолученноеКтоНаписал,
                                                "#FFFF9E80");


                                        Log.d(this.getClass().getName(), " Кому написано  ПолученноеКтоНаписал " + ПолученноеКтоНаписал

                                                + " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента + " textViewСамоСообщение " + textViewСамоСообщение.getText().toString());


                                    }


                                    // TODO: 20.01.2022  положтельный ответ для SimplrCurcor

                                    return true;


                                // TODO: 29.06.2021


                                case android.R.id.text2:
                                    ///////TODO фрагмент читать и писать
                                    Log.d(this.getClass().getName(), " ClassActitytyClassActityty  view.getId() МетодВФрагментеЧитатьИПисатьДляВторойВторостипеннойTEXT2  " + view.getId());


                                    // TODO: 18.02.2022 когда есть ID  от сервера

                                    MaterialButton text2ViewКтоПаисалИВремя = view.findViewById(android.R.id.text2);

                                    МетодВФрагментеЧитатьИПисатьДляВторойВторостипеннойTEXT2((MaterialButton) view, cursor);

                                    // TODO: 20.01.2022  положтельный ответ для SimplrCurcor


                                    // TODO: 04.02.2022  еще один код кторе изменяет СТИЛЬ СТРОЧКИ ЕСЛИ С СЕРВЕРА ПИШЕЛ ID

                                    МетодИзменяетСтильСтрочкиСообщенияЕслиСервераПришелЗаполеныйID((MaterialButton) view, cursor);


                                    // TODO: 30.06.2021 ДАННЫЙ МЕТОД ВЫЧИСЛЯЕТ ПО ПОЛЮ В СООБЩИИ ПРОЧИТАЛ ЛИ ДАННОЕ СООБЩЕНИЕ КОНТАК КОТРОМУ МЫ МЫ И ПИСАЛИ ПИСЬМО
                                    МетодКоторыйВычисляемПрочиталЛиДанноеСообщениеКомуПисали((MaterialButton) view, cursor);


                                    return true;
                                // TODO: 20.01.2022  положтельный ответ для SimplrCurcor


                                default:
                                    // TODO: 20.01.2022  положтельный ответ для SimplrCurcor
                                    return false;


                            }






                            ///////TODO фрагмент читать и писать  когда нет данных курсор 0
                        } else {


                            ///////TODO фрагмент читать и писать  когда нет данных курсор 0
                            Log.d(this.getClass().getName(), " ODO фрагмент читать и писать  когда нет данных курсор 0   view.getId() МетодКогдаВообщеНетВКурсореДанныхДляДаногоЧата  " + view.getId());

                            return МетодКогдаВообщеНетВКурсореДанныхДляДаногоЧата ((TextView) view);


                        }

                        /////TODO

                        //////////////////

                        //////////////////

                    }

                    private void МетодМеняемЦветСообщениявЗависимостиЯНаписалЕгоИлиМне(MaterialButton view, MaterialButton textViewСамоСообщение, int ПолученноеКтоНаписал
                            , String CамЦветУстановочный) {
                        // TODO: 29.03.2022   изменяем дизайн  сообщения мне НАПИСАЛИ И ЛИ Я

                        try {

                            ((MaterialButton) view).setBackgroundColor(Color.parseColor(CамЦветУстановочный));

                            // TODO: 29.03.2022
                            Log.d(this.getClass().getName(), " ПолученноеКтоНаписал " + ПолученноеКтоНаписал
                                    + " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента + " textViewСамоСообщение " + textViewСамоСообщение.getText().toString());
                            // TODO: 03.01.2022  код не текущего пользователя кто МЕН НАПИСАЛ

                            ////
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }
                    }


                    private void МетодОбрабатываетСвоиСообщенияДляЧатаText1(MaterialButton view, Cursor cursor, String ПолученноеТелоСообщения, int ПолученноеКтоНаписал) {
                        // TODO: 29.04.2021 ПрисваемваемКАЖДОМУ СОТРУДНИКУ ID
                        try {
                            // TODO: 25.02.2022 форматирование текста
                            view.setText(ПолученноеТелоСообщения);

                            Log.d(this.getClass().getName(), " статус нет нет  ID  ОТ СЕРВЕРА  ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента +
                                    " ПолученноеКтоНаписал " + ПолученноеКтоНаписал);
                            ////
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }
                    }


                    private void МетодКоторыйВычисляемПрочиталЛиДанноеСообщениеКомуПисали(MaterialButton view, Cursor cursor) {
                        // TODO: 30.06.2021 ДАННЫЙ МЕТОД ВЫЧИСЛЯЕТ ПО ПОЛЮ В СООБЩИИ ПРОЧИТАЛ ЛИ ДАННОЕ СООБЩЕНИЕ КОНТАК КОТРОМУ МЫ МЫ И ПИСАЛИ ПИСЬМО

                        try {

                            int ИндексЗначенияПоПолюПрочиталЛИНашеСообщениеТотКомуОноБылоПослано = cursor.getColumnIndex("status_write");//TODO _id status_write

                            // TODO: 29.04.2021
                            Integer наченияПоПолюПрочиталЛИНашеСообщениеТотКомуОноБылоПослано = 0;
                            /////////////////
                            наченияПоПолюПрочиталЛИНашеСообщениеТотКомуОноБылоПослано = cursor.getInt(ИндексЗначенияПоПолюПрочиталЛИНашеСообщениеТотКомуОноБылоПослано);


                            Log.d(this.getClass().getName(), " наченияПоПолюПрочиталЛИНашеСообщениеТотКомуОноБылоПослано " + наченияПоПолюПрочиталЛИНашеСообщениеТотКомуОноБылоПослано);


                            ////todo ПОКАЗЫВАЕМ ФЛАГ ЕСЛИ ДАННЫЕ УСПЕШНО ОПРАВИЛИЬС ИЛИ ВРЕНУЛСЬ СС СЕРВРА ТО СООБШЕНИЯ ОКРАШИВАЕМ В СИНИЯ ЦВЕТ
                            if (наченияПоПолюПрочиталЛИНашеСообщениеТотКомуОноБылоПослано > 0) {

                                // TODO: 25.02.2022 форматирование текста

                                ((MaterialButton) view).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_dsu1_for_chat_status, 0);

                                //  ((TextView) view).setBackgroundResource(R.drawable.style_for_chat);
                                Log.d(this.getClass().getName(), " статус нет нет  ID  ОТ СЕРВЕРА  ПCallBaskОтWorkManagerОдноразового" +
                                        " " + CallBaskОтWorkManagerОдноразового);

                            }/*else{

                                view.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_dsu1_for_chats_exists_publicid2, 0);

                                //  ((TextView) view).setBackgroundResource(R.drawable.style_for_chat);
                                Log.d(this.getClass().getName(), " статус нет нет  ID  ОТ СЕРВЕРА  ПCallBaskОтWorkManagerОдноразового" +
                                        " " + CallBaskОтWorkManagerОдноразового);

                            }*/

                            //  ((TextView) view).setBackgroundResource(R.drawable.style_for_chat);
                            Log.d(this.getClass().getName(), " статус нет нет  ID  ОТ СЕРВЕРА  ПCallBaskОтWorkManagerОдноразового" +
                                    " " + CallBaskОтWorkManagerОдноразового);


                            ////
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }
                    }

                    private void МетодИзменяетСтильСтрочкиСообщенияВМоментеЕслиССервераПришелОтветОПолжительнойВставкеСообщенияВремяОжиданияText1(MaterialButton view, String ПолученноеТелоСообщения) {


                        try {
                            // TODO: 04.02.2022
                            if (CallBaskОтWorkManagerОдноразового > 0) {


                                CallBaskОтWorkManagerОдноразового = 0l;

                                //todo визальноеотображения хода синхрониазции

                                new VIEW(getContext()).МетодДляЧатаПоказываемВизуальноОтправкуИИлиПолучениеДанных("Успешно !!!", 2000);

                                // TODO: 15.01.2022 после выполения изменения цвета на одной конкретноя строчке обнуляем перменую

                                Log.d(this.getClass().getName(), " CallBaskОтWorkManagerОдноразового " + CallBaskОтWorkManagerОдноразового);
                            }

                            ////
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }

                    }

                    private void МетодИзменяетСтильСтрочкиСообщенияЕслиСервераПришелЗаполеныйID(MaterialButton view, Cursor cursor) {

                        try {
                            int ИндексУзнатьIDКогдаЗаписьВозвращяетьсяССервера = cursor.getColumnIndex("_id");//TODO _id status_write

                            // TODO: 29.04.2021
                            /////////////////
                            Integer ПолучаемID_ДляПроверкиКогдаПриходитССервера = cursor.getInt(ИндексУзнатьIDКогдаЗаписьВозвращяетьсяССервера);
                            // TODO: 04.02.2022

                            Log.d(this.getClass().getName(), " ПолучаемID_ДляПроверкиКогдаПриходитССервера " + ПолучаемID_ДляПроверкиКогдаПриходитССервера);

                            if (ПолучаемID_ДляПроверкиКогдаПриходитССервера > 0) {

                                ((MaterialButton) view).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_dsu1_for_chats_exists_publicid2, 0);

                                // TODO: 15.01.2022 после выполения изменения цвета на одной конкретноя строчке обнуляем перменую
                                Log.d(this.getClass().getName(), " CallBaskОтWorkManagerОдноразового " + CallBaskОтWorkManagerОдноразового);
                                // TODO: 18.02.2022

                            } else {
                                ((MaterialButton) view).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

                                // TODO: 15.01.2022 после выполения изменения цвета на одной конкретноя строчке обнуляем перменую
                                Log.d(this.getClass().getName(), " CallBaskОтWorkManagerОдноразового " + CallBaskОтWorkManagerОдноразового);
                                // TODO: 18.02.2022

                            }


                            // TODO: 29.03.2022


                            ////
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }


                    }


                    // TODO: 29.03.2022  мне написали
                    private void МетодФормленияСообщениеййНаписаннымиНеНамиАДругимиУчастиникамиЧатаText2(TextView view, String ПолученноеТелоСообщения) {

                        try {

                            // TODO: 04.11.2021
                            view.setText(" " + ПолученноеТелоСообщения);


                            Log.d(this.getClass().getName(), " метод посика уже существующего сотрудника в базе андройжа ПолученныйФИО"
                                    + ПолученноеТелоСообщения);


                            ////
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }

                    }

                    private void МетодСменаСтатусаНеНашихСообщенийЧатаText2(Cursor cursor, int ПолученноеКтоНаписал, TextView textViewСамоСообщение) {
                        Boolean РезультатИзмененияСтатусаПрочитанныйИПолученияСтатусаГотовыхСтрочек = false;
                        //TODO изменяем статус записи
                        try {


                            //todo САСИСЬ СТАТУСА
                            РезультатИзмененияСтатусаПрочитанныйИПолученияСтатусаГотовыхСтрочек =
                                    new ПодКлассФрагментаЧитатьПисатьПоИзеннениюСтатусаЗАписивЧатеПрочитаноИлиНет().
                                            Метода_ФрагметаПрочитано_НаписаноИзменяемИПроверемСтатусПрочитаногоСТрочкиТекущийВчате(cursor,
                                                    textViewСамоСообщение,
                                                    class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть,
                                                    modelДляФрагментаЧитатьИлиПисать,
                                                    controllerДляФрагментаЧитатьИлиПисать,
                                                    finalClass_Engine_SQLДляИзмененияСтатусаЗаписиПрочтитаноИлиНет,
                                                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков);

                            // TODO: 29.03.2022


                            Log.d(this.getClass().getName(), " метод посика уже существующего сотрудника РезультатИзмененияСтатусаПрочитанныйИПолученияСтатусаГотовыхСтрочек"
                                    + РезультатИзмененияСтатусаПрочитанныйИПолученияСтатусаГотовыхСтрочек);
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            // TODO: 01.09.2021 метод вызова
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                    this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                            ///


                        }
                        ////

                        Log.d(this.getClass().getName(), "Мне Написал Кото то ПолученноеКтоНаписал " + ПолученноеКтоНаписал + "\n" +
                                " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента+  "  РезультатИзмененияСтатусаПрочитанныйИПолученияСтатусаГотовыхСтрочек "
                                +РезультатИзмененияСтатусаПрочитанныйИПолученияСтатусаГотовыхСтрочек);
                    }

                    private boolean МетодКогдаВообщеНетВКурсореДанныхДляДаногоЧата(TextView view) {
                        StringBuffer БуферКогдаНетСообщенийВооюоще = new StringBuffer("* Нет сообщений !!! *");

                        view.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

                        view.setBackgroundColor(Color.parseColor("#F5FFFA"));

                        view.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

                        // TODO: 28.06.2021 данный код когда нет вообще данных в курсоре и нет сообдений
                        //     ((TextView) view).setText(БуферКогдаНетСообщенийВооюоще.toString());


                        return false;
                    }






                    // TODO: 07.02.2022 МЕТОД ДЛЯ НИЖНЕГО TEXTVIEW TEXT2

                    private boolean МетодВФрагментеЧитатьИПисатьДляВторойВторостипеннойTEXT2(TextView view, Cursor cursor) {


                        String ФиналДата = null;

                        String ФиналДатаДлиннная = null;
                        //
                        try {

                            // TODO: 30.06.2021  дата сообщения
                            Integer ИндексДатаСообщенийВсехСВыбраннымСотрудником = cursor.getColumnIndex("date_update");

                            /////////////////даты
                            String ПолученноеДатыСообщенияСообщения = cursor.getString(ИндексДатаСообщенийВсехСВыбраннымСотрудником).trim();

                            // TODO: 29.04.2021
                            Log.d(this.getClass().getName(), " ПолученноеДатыСообщенияСообщения" + ПолученноеДатыСообщенияСообщения);

                                // TODO: 28.06.2021 даты обработка

                                Log.d(this.getClass().getName(), " ПолученноеДатыСообщенияСообщения" + ПолученноеДатыСообщенияСообщения);


                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", new Locale("ru"));
                                Date date = null;
                                try {
                                    date = dateFormat.parse(ПолученноеДатыСообщенияСообщения);
                                } catch (ParseException e) {

                                    ////////
                                    ///todo публикум название таблицы или цифру его
                                    //  Block of code to handle errors
                                    e.printStackTrace();
                                    ///метод запись ошибок в таблицу
                                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                            + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                            this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                            Thread.currentThread().getStackTrace()[2].getLineNumber());


                                    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru"));

                                    /////////

                                    date = dateFormat.parse(ПолученноеДатыСообщенияСообщения);


                                }

                                Log.d(this.getClass().getName(), "  date  " + date.toString() + "  ПолученноеДатыСообщенияСообщения " + ПолученноеДатыСообщенияСообщения);
                                /////////


                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm", new Locale("ru"));
                                //
                                simpleDateFormat.applyPattern("HH:mm");//dd-MM-yyyy//// EEEE yyyy HH:mm  /////  dd MMMM yyyy HH:mm
                                // simpleDateFormat.applyPattern(" dd EEEE yyyy HH:mm");//dd-MM-yyyy//// EEEE yyyy HH:mm  /////  dd MMMM yyyy HH:mm

                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));


                                ФиналДата = simpleDateFormat.format(date);


                                Log.d(this.getClass().getName(), "  ФиналДата  " + ФиналДата);




                            // TODO: 18.08.2021 Определяем от кого было написано сообещгия

                            int ИндексКемБылоНаписаноСообщение = cursor.getColumnIndex("user_update");


                            // TODO: 29.04.2021
                            String ФиоКтоНАписалСообщение = new String();

                            /////////////////даты
                            Integer ПолученноеФИОКемБылоНаписаноСообщениеДляПосикаФИО = cursor.getInt(ИндексКемБылоНаписаноСообщение);
                            //

                            Log.d(this.getClass().getName(), "  ПолученноеФИОКемБылоНаписаноСообщениеДляПосикаФИО  " + ПолученноеФИОКемБылоНаписаноСообщениеДляПосикаФИО);
                            // TODO: 09.09.2021  ПОЛУЧЕНИЕ ДАННЫХ
                            // TODO: 09.09.2021  ПОЛУЧЕНИЕ ДАННЫХ

                            /////
                            ФиоКтоНАписалСообщение = modelДляФрагментаЧитатьИлиПисать.МетодКемБЫлоНАписаноСообщение(ПолученноеФИОКемБылоНаписаноСообщениеДляПосикаФИО);

                            Log.d(this.getClass().getName(), "  ФиоКтоНАписалСообщение  " + ФиоКтоНАписалСообщение
                                    + " Кем написано  ПолученноеФИОКемБылоНаписаноСообщение " + ПолученноеФИОКемБылоНаписаноСообщение + "Кому  ПолученыйIDДляЧата "
                                    + ПолученыйIDДляЧата + " ПолученноеФИОКемБылоНаписаноСообщениеДляПосикаФИО " + ПолученноеФИОКемБылоНаписаноСообщениеДляПосикаФИО);



                            // TODO: 30.06.2021 форматирование кто написал
                            int ИндексКтоНаписалСообщениеСотрудникомДляtext2 = cursor.getColumnIndex("user_update");

                            // TODO: 29.04.2021
                            /////////////////
                            int ПолученноеКтоНаписалДляtext2 = cursor.getInt(ИндексКтоНаписалСообщениеСотрудникомДляtext2);


                            // TODO: 07.02.2022   мои сообщения  ОБРАБОТКА TEXT2

                            if (ПолученноеКтоНаписалДляtext2 == ПубличныйIDДляФрагмента) {

                                // TODO: 07.02.2022  вЫЧИСЛЕМ оТПРАВЛИ м сООБЗЕНЕИ НА СЕРВРО ИЛИ ПОЛЬЗОВАТЕЛЬ ИЗХ ПРОЧИТАЛ
// TODO: 18.02.2022  сообщение прочитанно другим  КОМУ ПРЕДНАЗНАЧАЛОСЬ
                                //view.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_dsu1_add_organisazio_success, 0, 0, 0);
                                ((MaterialButton) view).setText(ФиналДата);///ПолученыйФИОIDДляЧата
                                ////
                                Log.d(this.getClass().getName(), "  ПолученноеКтоНаписалДляtext2  " + ПолученноеКтоНаписалДляtext2 + " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);


                            } else {

                                // TODO: 29.03.2022
                                ((MaterialButton) view).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

                                //   view.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_dsu1_add_organisazio_error, 0, 0, 0);
                                ((MaterialButton) view).setText(ФиоКтоНАписалСообщение.trim() + " " + ФиналДата);///ПолученыйФИОIDДляЧата
                                ////
                                Log.d(this.getClass().getName(), "  ПолученноеКтоНаписалДляtext2  " + ПолученноеКтоНаписалДляtext2 + " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);

                            }


                            ////
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }


                        ///////

                        return true;

                        // TODO: 29.06.2021 defalut
                    }


                };


                ////
                АдаптерДляЗаписиЧтенияЧата.setViewBinder(БиндингДляСообщенийЧата);
                ///

                // TODO: 01.02.2022
                ЛистВьюДляСообщенийЧата.setAdapter(АдаптерДляЗаписиЧтенияЧата);
                // TODO: 01.02.2022
                ЛистВьюДляСообщенийЧата.requestLayout();

                // TODO: 25.03.2022


            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///


            }
        }


        /////

        // TODO: 01.07.2021  метод не загружаем даннные потомц что нет данных в курсоре и даем пользователю сообщение

        private void МетодЗагрузкиданныхНаФрагментКогдаНетДанных() throws ExecutionException, InterruptedException {
            // КурсорДанныеДлязаписиичтнияЧата

            try {


                /////


                ///
                ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
                LinkedHashMap<String, String> ДанныйХЭШНуженКогдаНЕтДАнныхВпереписке = new LinkedHashMap<>();;

// Досье на первого кота


                ДанныйХЭШНуженКогдаНЕтДАнныхВпереписке.put("Name", "* Начните Чат  !!! *");//todo Начните Чат

                arrayList.add(ДанныйХЭШНуженКогдаНЕтДАнныхВпереписке);
                ///
                Log.d(this.getClass().getName(), "arrayList  "  + arrayList.stream().count());

                // TODO: 09.09.2021 АДАПТЕР НЕ БЕЗ КОНЕЧНЫЙ
                // TODO: 09.09.2021 АДАПТЕР НЕ БЕЗ КОНЕЧНЫЙ
                // TODO: 09.09.2021 АДАПТЕР НЕ БЕЗ КОНЕЧНЫЙ


/*                        АдаптерДляЗаписиЧтенияЧатаВнутри = new SimpleCursorAdapter(getContext(), R.layout.simple_for_chats_read_write,КурсорДанныеДлязаписиичтнияЧата,
                                new String[]{"user_update", "date_update"},
                                new int[]{android.R.id.text1, android.R.id.text2},0);*/

                ////////
                SimpleAdapter АдаптерДляЗаписиЧтенияКогдаНетДанных = null;
///
                АдаптерДляЗаписиЧтенияКогдаНетДанных = new SimpleAdapter(getContext(), arrayList, R.layout.simple_for_chats_read_write,
                        new String[]{"name", "date_update"},
                        new int[]{android.R.id.text1, android.R.id.text2});


                ///


                // TODO: 08.07.2021 Binf view
                //
                SimpleAdapter.ViewBinder БиндингДляСообщенийЧатаКогдаНетДанных = new SimpleAdapter.ViewBinder() {
                    @Override
                    public boolean setViewValue(View view, Object data, String textRepresentation) {
                        //here goes the code
                        Log.d(this.getClass().getName(), " ClassActitytyClassActityty  ");

                        ((TextView) view).setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

                        // TODO: 05.07.2021

                        textViewФрагментЧитатьПисатьДляЧата.setText(ПолученыйФИОIDДляЧата);

                        switch (view.getId()) {
                            ////////////
                            case android.R.id.text1:

                                ///
                                ((TextView) view).setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                                //
                                ((TextView) view).setPadding(0, 0, 0, 450);
                                ////

                                ((TextView) view).setText(data.toString());
                                ////
                                ((TextView) view).setTextColor(Color.parseColor("#00BBC1"));
                                ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
                                ((TextView) view).setBackgroundColor(Color.parseColor("#F5FFFA"));

                                ////////

                                ((TextView) view).getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                                /////
                                ((TextView) view).setSelected(true);
                                ////////

                                ((TextView) view).getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;


                                return true;
                            ///
                            ////////////
                            case android.R.id.text2:

                                ///
                                ((TextView) view).setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                                //
                                ((TextView) view).setPadding(0, 0, 0, 650);
                                ////

                                //   ((TextView) view).setText(data.toString());
                                ////
                                //((TextView) view).setTextColor(Color.parseColor("#00BBC1"));
                                ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
                                ((TextView) view).setBackgroundColor(Color.parseColor("#F5FFFA"));

                                ////////

                                ((TextView) view).getLayoutParams().height = 0;
                                /////

                                ////////

                                ((TextView) view).getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;


                                return true;
                            ///


                            default:
                                //////
                                ////
                                return false;
                        }


                        /////TODO

                        //////////////////

                        //////////////////

                    }
                };


                ////
                АдаптерДляЗаписиЧтенияКогдаНетДанных.setViewBinder(БиндингДляСообщенийЧатаКогдаНетДанных);
                ///
                ЛистВьюДляСообщенийЧата.setAdapter(АдаптерДляЗаписиЧтенияКогдаНетДанных);

                ////
                // ЛистВьюДляСообщенийЧата.setSelection(ЛистВьюДляСообщенийЧата.getCount() - 1);


                Log.d(this.getClass().getName(), "                   ЛистВьюДляСообщенийЧата.setSelection(ЛистВьюДляСообщенийЧата.getCount() - 1); "
                        + ЛистВьюДляСообщенийЧата.getCount());

            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///


            }
        }
    }

    class CONTROLLER extends com.dsy.dsu.Code_For_Chats_КодДля_Чата.CONTROLLER implements AdapterView.OnItemClickListener {
        /////
        public CONTROLLER(Context context) {
            try {

                Log.d(this.getClass().getName(), "  CONTROLLER  ");


                // TODO: 30.06.2021 клик
                МетодКликаПоЛистуЧитатьПисать();

// TODO: 30.06.2021  клик по круглой кнопки
                МетодКруглаяКнопкаНаФрагментеЧитатьПисать();

                // TODO: 07.07.2021

            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///


            }
        }



        private void МетодКликаПоЛистуЧитатьПисать() {
            ЛистВьюДляСообщенийЧата.setOnItemClickListener(this);
            ///
   /*         viewДляСообщений.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Log.d(this.getClass().getName(), "  onClick  MyWork_Update_ОбновлениеПО СЛУЖБА  " + viewДляСообщений.getId());
                }
            });*/
            //  Курсор_ДляЗагрузкиСотрудников.close();
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            try {
                Log.d(this.getClass().getName(), " onItemClick MyWork_Update_ОбновлениеПО СЛУЖБА  " + view.getId());


                /////


///
                Object ХэшДанныеВВидеОбьекта = parent.getItemAtPosition(position);


                ///
                TextView textView = view.findViewById(android.R.id.text1);

                ///
                ((TextView) textView).setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);

                Long ПолученныйUUIDЗаписи = Long.parseLong(textView.getTag().toString());


                Log.d(this.getClass().getName(), " item кликнули по строчке ПолученныйUUIDЗаписи " + ПолученныйUUIDЗаписи);

                try {

            /*   Integer РезультатЗаписиСменыСтатусаПрочнтенияСообщения=     МетодКоторыйМеняетСтатусНаПрочитанныйТекущуюЗаписьМеняетСтатусСКлика((TextView) textView,ПолученныйUUIDЗаписи);

                    Log.d(this.getClass().getName(), "РезультатЗаписиСменыСтатусаПрочнтенияСообщения " + РезультатЗаписиСменыСтатусаПрочнтенияСообщения );
*/

                    // TODO: 16.11.2021
                } catch (Exception e) {
                    //  Block of code to handle errors
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                            + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                            this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                            Thread.currentThread().getStackTrace()[2].getLineNumber());

                    // TODO: 11.05.2021 запись ошибок

                }


            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///


            }
        }


        // TODO: 23.11.2021


        void МетодКруглаяКнопкаНаФрагментеЧитатьПисать() {
            try {
                ////
                final Long[] futureрезультатФинальнойСинхрнизации = {0l};
                ////
                ////
                final Long[] futureрезультатФинальнойСинхрнизациихОЛОСТОЙхОД = {0l};


                // TODO: 23.07.2021 код при нажатии на БОЛЬШУЮ КРУГЛУЮ КНОПКУ
                //////////////////////////////
                floatingActionButtonВФагментеReadandWrite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: 24.07.2021


                        //
                        ////////////////////
                        Log.d(this.getClass().getName(), " Нажатие на кнопку floatingActionButtonВФагментеReadandWrite");
                        try {


                            floatingActionButtonВФагментеReadandWrite.setImageResource(R.drawable.icon_dsu1_chat_messgae_sync_up);


                            Log.d(this.getClass().getName(), "   запуск кнпоки синхрогизации в чате   editTextТелоНаписаногоСообщенияДругимСотрудникам.getText().toString() "
                                    + editTextТелоНаписаногоСообщенияДругимСотрудникам.getText().toString());

                            // TODO: 05.07.2021 ЗАПУСКАЕМ СОЗДАНЕИ НОВОЙ ЗАПИСИ ЕСЛИ ЕСЛИ  ХОТЬ ОДИТ СМВОЛ НАПИСАННЫМ ПОЛЬЗОВАТЕМ


                            // TODO: 22.12.2021 ПЕРЕД СОЗДАНИЕМ  СООБЩЕНИЕМ

                            /////
                            if (editTextТелоНаписаногоСообщенияДругимСотрудникам.getText().toString() != null &&
                                    //////
                                    editTextТелоНаписаногоСообщенияДругимСотрудникам.getText().toString().length() > 0) {


                                ///todo когда данных не для встаки тогда запускаем синхронизация для чата

                                МетодВизуальногОформелнияКнопкиПриНАжатии();


                                // TODO: 05.07.2021 клавиатура вниз


// TODO: 10.08.2021 создание новго сообщения

                                Integer РезультатЗапускаСозданииНовгоСообщения = 0;

                                //
                                final Integer РезультатЗапускаСинхронизацииЧатаОтправка = 0;

//todo ВЫКЛЮЧАЕМ НА ВРЕСИЯ МЕНЕДЖЕР ПОТОКОВ ПО РАСПИСНИЮ
                                try {







                                    // TODO: 03.11.2021 выключаем синхрониазцию на время

                                    // TODO: 11.08.2021 дейстиве заключительно после синхронизации перерисовываем внешний вид чатат

                                    Log.d(this.getClass().getName(), " editTextТелоНаписаногоСообщенияДругимСотрудникам "
                                            + editTextТелоНаписаногоСообщенияДругимСотрудникам.getText().toString() +
                                            " СТАТУС МЕНЕДЖЕРА ОТПАРВКИ ПОДУЧЕНИ ДАННЫХ НА СЕРВЕР МенеджерПОтокПоРАсписанию.isTerminated() ");//TODO сама всатвка НОВОГО СООБЩЕНИЯ


                                    // TODO: 11.01.2022 ОСТАНАВЛИВАЕМ СЛУЖБУ ПЕРЕД СОЗДАНИЕ СНОВГО СООБЩЕГИТЯ


                                    //todo визальноеотображения хода синхрониазции

                                    new VIEW(getContext()).МетодДляЧатаПоказываемВизуальноОтправкуИИлиПолучениеДанных("Выполянется...", 2000);


                                    CallBaskОтWorkManagerОдноразового = 0l;


                                    // TODO: 18.11.2021 НЕПОСТРЕДСТВЕННО СОЗДАНИЕ НОВОГО СООБЩЕНИЯ  ПРИ НАЛИЧИИ 0 ОЧЕРЕДИ


                                    РезультатЗапускаСозданииНовгоСообщения = МетодСозданииНовогоСообщениявЧате(v);


                                    // TODO: 11.08.2021 дейстиве заключительно после синхронизации перерисовываем внешний вид чатат
                                    Log.d(this.getClass().getName(), "  мЕТОД  созадние чата   РезультатЗапускаСозданииНовгоСообщения = МетодСозданииНовогоСообщениявЧате(v);" +
                                            " ЧАТ РезультатЗапускаСозданииНовгоСообщения  "
                                            + РезультатЗапускаСозданииНовгоСообщения +
                                            "  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата + " КурсорДанныеДлязаписиичтнияЧата " + КурсорДанныеДлязаписиичтнияЧата);


                                    // TODO: 02.02.2022  начинает работать когда люди первый раз друг другу ПИШУТ И НАДО ПЕРЕОПРЕДЕЛИТЬ АДПТЕР И КУРСОР
                                    МетодКогдаДругДругуПервыйРазПишутЛюди(РезультатЗапускаСозданииНовгоСообщения);

                                    // TODO: 11.08.2021 дейстиве заключительно после синхронизации перерисовываем внешний вид чатат
                                    Log.d(this.getClass().getName(), "  мЕТОД  созадние чата   РезультатЗапускаСозданииНовгоСообщения = МетодСозданииНовогоСообщениявЧате(v);" +
                                            " ЧАТ РезультатЗапускаСозданииНовгоСообщения  "
                                            + РезультатЗапускаСозданииНовгоСообщения+
                                            "  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " +ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата + " КурсорДанныеДлязаписиичтнияЧата " +КурсорДанныеДлязаписиичтнияЧата);


                                    // TODO: 10.02.2022 после создание сообщения подписывемся на данные КУРСОРА OBCERVER


                                    ////
                                    new MODEL(getContext()).  МетодПослеСозданиеНовогоСообщенияПодписываемсяНАДанныеИзКурсораObserver();



                                    // TODO: 11.08.2021 дейстиве заключительно после синхронизации перерисовываем внешний вид чатат
                                    Log.d(this.getClass().getName(), "  мЕТОД  созадние чата   РезультатЗапускаСозданииНовгоСообщения = МетодСозданииНовогоСообщениявЧате(v);" +
                                            " ЧАТ РезультатЗапускаСозданииНовгоСообщения  "
                                            + РезультатЗапускаСозданииНовгоСообщения+
                                            "  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " +ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата + " КурсорДанныеДлязаписиичтнияЧата " +КурсорДанныеДлязаписиичтнияЧата);



                                    // TODO: 11.08.2021 дейстиве заключительно после синхронизации перерисовываем внешний вид чатат
                                    Log.d(this.getClass().getName(), "  мЕТОД  созадние чата   РезультатЗапускаСозданииНовгоСообщения = МетодСозданииНовогоСообщениявЧате(v);" +
                                            " ЧАТ РезультатЗапускаСозданииНовгоСообщения  "
                                            + РезультатЗапускаСозданииНовгоСообщения+
                                            "  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " +ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата+ " КурсорДанныеДлязаписиичтнияЧата " +КурсорДанныеДлязаписиичтнияЧата);



                                    if (РезультатЗапускаСозданииНовгоСообщения>0) {


                                        // TODO: 21.01.2022
                                        Log.d(this.getClass().getName(), " РезультатЗапускаСозданииНовгоСообщения"
                                                + РезультатЗапускаСозданииНовгоСообщения);


                                        // TODO: 23.12.2021  ЗАПУСКАЕМ ПОВТРОНУЮ СИНХРОНИАЗУИБЮ
                                        КурсорДанныеДлязаписиичтнияЧата.deactivate();

                                        // TODO: 23.12.2021  ЗАПУСКАЕМ ПОВТРОНУЮ СИНХРОНИАЗУИБЮ
                                        КурсорДанныеДлязаписиичтнияЧата.requery();


                                        // TODO: 23.12.2021  ЗАПУСКАЕМ ПОВТРОНУЮ СИНХРОНИАЗУИБЮ

                                        // TODO: 27.12.2021

                                        // TODO: 23.12.2021  ЗАПУСКАЕМ ПОВТРОНУЮ СИНХРОНИАЗУИБЮ
                                        ////
                                        editTextТелоНаписаногоСообщенияДругимСотрудникам.setText("");





// TODO: 02.02.2022 куртитьм по ЦИКЛУ СУЖБУ ЕСЛИ ОНА ЕЩЕ ВЫПОЛЕТЬСЯ

                                        WorkInfoИнформацияОЗапущенойСлужбеОдноразовая =
                                                WorkManager.getInstance(getContext().getApplicationContext()).getWorkInfosByTag(ИмяСлужбыСинхронизацииОдноразовая).get().get(0);



                                        // TODO: 21.01.2022
                                        Log.d(this.getClass().getName(), " ПЕРЕД ВСТАВКОЙ  while ( WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().compareTo(WorkInfo.State.RUNNING)==0){ "
                                                + WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().name());




                                        // TODO: 30.12.2021 ПЕРЕД СОЗДАНИЕМ НОВГО СООБЕЩЕНИЯ  !!!!!


                                        // TODO: 27.10.2021 ЗАПУСК ЧИНХРОНИАЗЦИИ ОДНОРАЗОВОЙ ПОСЛЕ СОЗЛАНИЕ НОВГО СООБЕШИЯ LONG ,ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата

                                        new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getContext()).
                                                МетодПовторногоЗапускаВсехWorkManager__ОДНОРАЗОВОЙСинхрониазцииданных(Integer.parseInt(ПолученыйIDДляЧата.toString()), getContext());


                                        // TODO: 04.11.2021   ЗАПУСКАЕМ СИНХРОНИАХЦИИЮ  через ONESIGNAL
                                        Log.d(this.getClass().getName(), "РезультатCallsWorkInfoИнформацияОЗапущенойСлужбеОдноразовая " + " getState  " +
                                                WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().name() + "\n" +
                                                "getTags " +
                                                WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getTags() + "\n" +
                                                " ПолученыйIDДляЧата " + ПолученыйIDДляЧата);



                                        // TODO: 27.12.2021
                                        // TODO: 23.12.2021  ЗАПУСКАЕМ ПОВТРОНУЮ СИНХРОНИАЗУИБЮ
                                        КурсорДанныеДлязаписиичтнияЧата.deactivate();

                                        КурсорДанныеДлязаписиичтнияЧата.requery();

                                        ////
                                        ЛистВьюДляСообщенийЧата.setSelection(АдаптерДляЗаписиЧтенияЧата.getCount() - 1);

                                    }else {

                                        Toast.makeText(getContext(), "Новое сообщение не создалось, попробуйте еще раз !!!", Toast.LENGTH_SHORT).show();

                                        Log.e(this.getClass().getName(), "ОШИБКА РезультатЗапускаСозданииНовгоСообщения"
                                                + РезультатЗапускаСозданииНовгоСообщения);


                                    }





                                    // TODO: 11.08.2021 дейстиве заключительно после синхронизации перерисовываем внешний вид чатат
                                    Log.d(this.getClass().getName(), " РезультатЗапускаСозданииНовгоСообщения  "
                                            + РезультатЗапускаСозданииНовгоСообщения);










                                    //////
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    ///метод запись ошибок в таблицу
                                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                    // TODO: 01.09.2021 метод вызова
                                    new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                            this.getClass().getName(),
                                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                                    ///

                                }

































                                ///todo ПРОСТО ПРОВЕРКА ДАННЫХ ПРОСТО ПРИ НАЖАТИИ  ДАННЫХ


                            } else {


                                ///todo ПРОСТО ПРОВЕРКА ДАННЫХ ПРОСТО ПРИ НАЖАТИИ  ДАННЫХ


                                ///todo когда данных не для встаки тогда запускаем синхронизация для чата

                                МетодВизуальногОформелнияКнопкиПриНАжатии();

// TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления





                                // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР

                                //todo визальноеотображения хода синхрониазции

                                //todo визальноеотображения хода синхрониазции

                                new VIEW(getContext()).   МетодДляЧатаПоказываемВизуальноОтправкуИИлиПолучениеДанных("Выполянется...",2000);


                                // TODO: 02.02.2022 куртитьм по ЦИКЛУ СУЖБУ ЕСЛИ ОНА ЕЩЕ ВЫПОЛЕТЬСЯ

                                WorkInfoИнформацияОЗапущенойСлужбеОдноразовая =
                                        WorkManager.getInstance(getContext().getApplicationContext()).getWorkInfosByTag(ИмяСлужбыСинхронизацииОдноразовая).get().get(0);


                                Log.w(getContext().getClass().getName(), " В ОЖИДАНИИ AWAIT.... ПОСЛЕ ОТРАБОТКИ МЕТОДА ..." +
                                        ".Внутри метода public Result doWork()  MyWork_Async_Синхронизация_ОДНОРАЗОВАЯ " + ИмяСлужбыСинхронизацииОдноразовая + "\n"
                                        + " getState  " +
                                        WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().name() + "\n" +
                                        "getTags " +
                                        WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getTags() + "\n" +
                                        "getRunAttemptCount " +
                                        WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getRunAttemptCount() + "\n" +
                                        "getProgress " +
                                        WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().isFinished() + "\n" +
                                        " время : " + new Date());





                                /*       Operation operation= WorkManager.getInstance(getContext()).cancelAllWorkByTag(ИмяСлужбыСинхронизацииОдноразовая);

                                 */
                                CallBaskОтWorkManagerОдноразового = 0l;


                                // TODO: 23.12.2021  ЗАПУСКАЕМ ПОВТРОНУЮ СИНХРОНИАЗУИБЮ

                                // TODO: 27.12.2021









                                // TODO: 21.01.2022
                                Log.d(this.getClass().getName(), "ПРИ ХОЛОСТОМ ХОДЕ  while ( WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().compareTo(WorkInfo.State.RUNNING)==0){ "
                                        + WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().name());

                                // TODO: 23.12.2021  ЗАПУСКАЕМ ПОВТРОНУЮ СИНХРОНИАЗУИБЮ


                                // TODO: 13.01.2022  ЗАПУСК СИХРОНИЗВАЦИИ В ХОЛОСТУЮ ХОД

                                new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getContext()).
                                        МетодПовторногоЗапускаВсехWorkManager__ОДНОРАЗОВОЙСинхрониазцииданных(ПубличныйIDДляФрагмента, getContext());


                                // TODO: 24.12.2021

                                Log.d(this.getClass().getName(), "Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal " +
                                        "" + WorkInfoИнформацияОЗапущенойСлужбеОдноразовая.getState().name() +
                                        "  ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);


                                // TODO: 23.12.2021  ЗАПУСКАЕМ ПОВТРОНУЮ СИНХРОНИАЗУИБЮ
                                КурсорДанныеДлязаписиичтнияЧата.deactivate();

                                КурсорДанныеДлязаписиичтнияЧата.requery();
                                ////
                                ЛистВьюДляСообщенийЧата.setSelection(АдаптерДляЗаписиЧтенияЧата.getCount() - 1);


                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            // TODO: 01.09.2021 метод вызова
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                    this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                            ///
                        }

                    }









                    // TODO: 02.02.2022 метод когда перавй раз пишут друг друг польвощователи

                    private void МетодКогдаДругДругуПервыйРазПишутЛюди(Integer РезультатЗапускаСозданииНовгоСообщения) throws ExecutionException, InterruptedException {


                        try {

                            if (ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата == 0
                                    || РезультатЗапускаСозданииНовгоСообщения > 0) {


                                // TODO: 02.02.2022


                                Log.d(this.getClass().getName(), "GetData " + КурсорДанныеДлязаписиичтнияЧата +
                                        "  РезультатЗапускаСозданииНовгоСообщения " + РезультатЗапускаСозданииНовгоСообщения + " ПолученыйIDДляЧата " + ПолученыйIDДляЧата);

                                new MODEL(getContext()).МетодПолучениеДанныхдляФрагментаЧитатьиПисатьЧат();
                                ////


                                // TODO: 11.08.2021 дейстиве заключительно после синхронизации перерисовываем внешний вид чатат
                                Log.d(this.getClass().getName(), "  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата  "
                                        + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата);


                                // TODO: 22.12.2021 КОГДА УЖЕ ЕСТЬ ПРЕПИСКА МЕЖДУ ЛЮДИМИ ТО ЗАРГУЖАЕМ ТАК ЧЕРЕЗЩ УЖЕ СУЩЕСТВУЮЩИЙ uuid

                                if (КурсорДанныеДлязаписиичтнияЧата.getCount() > 0) {


                                    Log.d(this.getClass().getName(), "GetData " + КурсорДанныеДлязаписиичтнияЧата);
                                    ///TODO ГЛАВНЫЙ АДАПТЕР чата
                                    new VIEW(getContext()).МетодЗагрузкиданныхНаФрагментКогдаЕстьДанные();

                                    // TODO: 11.10.2021

                                    Log.d(this.getClass().getName(), "GetData " + КурсорДанныеДлязаписиичтнияЧата);
                                }


                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            // TODO: 01.09.2021 метод вызова
                            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                    this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                            ///
                        }
                    }

                    // TODO: 23.07.2021 синхронизация для холостого хода
                });


            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///


            }
        }


        // TODO: 03.11.2021

        private void МетодВизуальногОформелнияКнопкиПриНАжатии() {

            try {


                // TODO: 05.07.2021 клавиатура вниз


                //
                InputMethodManager imm = (InputMethodManager) viewДляСообщений.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                ///
                imm.hideSoftInputFromWindow(viewДляСообщений.getWindowToken(), 0);


                floatingActionButtonВФагментеReadandWrite.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //
                        //   floatingActionButtonВФагментеReadandWrite.setImageResource(R.drawable.icon_dsu1_chat_messgae_sync_up);
                        floatingActionButtonВФагментеReadandWrite.setImageResource(R.drawable.icon_dsu1_singlescroll_forfart);
                        ;

                        ////

                        floatingActionButtonВФагментеReadandWrite.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //
                                floatingActionButtonВФагментеReadandWrite.setImageResource(R.drawable.icon_dsu1_chat_messgae_sync_up);

                                //  floatingActionButtonВФагментеReadandWrite.setImageResource(R.drawable.icon_dsu1_singlescroll_forfart);

                            }
                        }, 2500);


                    }
                }, 1000);
// TODO: 26.07.2021  холостой ход



            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///


            }
        }


        // TODO: 14.07.2021

        protected void МетодПослеВставкиНовгоСообщенияИлиПослеХолостогоХода(View v, Long РезультатЗапускаХолостогоХода, String ФлагОтправитьПолучить) {
            try {

                /////


                new Fragment_Writer_Read_ЧитатьПисатьЧата.MODEL(getContext()).МетодПолучениеДанныхдляФрагментаЧитатьиПисатьЧат();
                ////


                АдаптерДляЗаписиЧтенияЧата.changeCursor(КурсорДанныеДлязаписиичтнияЧата);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        if (АдаптерДляЗаписиЧтенияЧата != null) {
                            ///////
                            АдаптерДляЗаписиЧтенияЧата.changeCursor(КурсорДанныеДлязаписиичтнияЧата);

                            //////////
                            АдаптерДляЗаписиЧтенияЧата.notifyDataSetChanged();
                            //
                            АдаптерДляЗаписиЧтенияЧата.notifyDataSetInvalidated();

                        }



                        ///
                        if (ЛистВьюДляСообщенийЧата!=null) {
                            ///
                            ЛистВьюДляСообщенийЧата.deferNotifyDataSetChanged();

                            ///
                            ЛистВьюДляСообщенийЧата.refreshDrawableState();


                         /*   ЛистВьюДляСообщенийЧата.setItemChecked(ЛистВьюДляСообщенийЧата.getCheckedItemPosition() + 1, true);
                            ///
                            ЛистВьюДляСообщенийЧата.setSelection(ЛистВьюДляСообщенийЧата.getCount() - 1);


                            setSelection*/

                            ЛистВьюДляСообщенийЧата.setSelection(АдаптерДляЗаписиЧтенияЧата.getCount() - 1);

                            ЛистВьюДляСообщенийЧата.invalidateViews();
                        }


                        // TODO: 30.09.2021
                        if (РезультатЗапускаХолостогоХода >= 1) {


                        }

                        ///todo когда данных не для встаки тогда запускаем синхронизация для чата
/*
                                }
                            },500);*/

                        floatingActionButtonВФагментеReadandWrite.setImageResource(R.drawable.icon_dsu1_chat_messgae_sync_up);


                        ///
                        //   ЛистВьюДляСообщенийЧата.setSelection(ЛистВьюДляСообщенийЧата.getCount() - 1);

                        ЛистВьюДляСообщенийЧата.setSelection(АдаптерДляЗаписиЧтенияЧата.getCount() - 1);

                    }
                });
                /////////////////////////////////////////////////////////////////////////////////
                //
                //  Snackbar.make(v, ""+ФлагОтправитьПолучить+" (" + РезультатЗапускаХолостогоХода +") сообщений!!!",Snackbar.LENGTH_LONG).setAction("Action",null).show();

            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///


            }
        }


        // TODO: 29.07.2021
        private boolean isMyServiceRunning(Class<?> serviceClass) {
            ActivityManager manager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
            for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
                if (serviceClass.getName().equals(service.service.getClassName())) {
                    return true;
                }
            }
            return false;
        }


        // TODO: 05.07.2021 код запуска метода для данных

        protected Integer МетодЗапускСинхронизацииДляЧатаПоРАсписанию(View v, String ФлагКакуюЧастьСинхронизацииЗапускаем) {
            //
            Integer РезультатСинхронизацииДОСозданиеЯСообщения = 0;


            boolean РезультатЕслиСвязьСерверомДСУ = false;

            try {

                Log.d(this.getClass().getName(), "  МетодЗаписиНовгоСообщенияСамимКлиентом");

                Log.d(this.getClass().getName(), "  МетодЗаписиНовгоСообщенияСамимКлиентом");


                /////TODO ВТОРОЙ ШАГ СИНХРОНИЗАЦИИ ПОЛУЧАЕМ СПИСОК ТАБЛИЦ КОТОРЫЕ НУЖНО  СИНХРОНИЗИРОВАТЬ 100% процентов , И ПРОВЕРМЯЕМ ЕСЛИ СВЯЗЬ С ИНТЕНТОМ


                /////TODO ВТОРОЙ ШАГ СИНХРОНИЗАЦИИ ПОЛУЧАЕМ СПИСОК ТАБЛИЦ КОТОРЫЕ НУЖНО  СИНХРОНИЗИРОВАТЬ 100% процентов , И ПРОВЕРМЯЕМ ЕСЛИ СВЯЗЬ С ИНТЕНТОМ


                РезультатЕслиСвязьСерверомДСУ = new Class_Connections_Server(getContext()).МетодПингаСервераРаботаетИлиНет(getContext());

                //TODO ФУТУРЕ ЗАВЕРШАЕМ
                Log.d(this.getClass().getName(), "  РезультатЕслиСвязьСерверомДСУ " + РезультатЕслиСвязьСерверомДСУ);

                ////TODO ТОЛЬКО ПРИ НАЛИЧИИ ИНТРЕНТА  !!!!!!!!!!!!!!!! ЗАПУСК СИНХРОНИЗАЦИИ

                if (РезультатЕслиСвязьСерверомДСУ == true) {


                    РезультатСинхронизацииДОСозданиеЯСообщения = new Class_Engine_SQL(getContext()).
                            МетодЗАпускаФоновойСинхронизации(getContext(), "СинхронизацияОбщая",
                                    true, ActivityДляСинхронизацииОбмена,
                                    ЛистЗапускаемТолькоТаблицыЧатаВСинхронизации,
                                    "ПовторныйЗапускСинхронизации", 0);  //МетодЗАпускаСинхронизациивФонеТолькоСинхронно   //МетодЗАпускаСинхронизациивФоне
                    ///
                    Log.d(this.getClass().getName(), "МетодЗапускаЛокальнойСинхронизации() СЛУЖБА синхронизации запускаем через  getApplication()" + РезультатСинхронизацииДОСозданиеЯСообщения);


/*
                                // TODO: 07.07.2021 sleep
                                TimeUnit.MILLISECONDS.sleep(1000);*/


                }

                Log.d(this.getClass().getName(), "  СЛУЖБА ТОЛЬКО ДЛЯ ЧАТА  РезультатСинхронизацииДОСозданиеЯСообщения  "
                        + РезультатСинхронизацииДОСозданиеЯСообщения +
                        " ИндексКоличествоПопытокОтправкиЧата ");

                // TODO: 29.04.2021 вуключаем


                ///
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///


            }
            return РезультатСинхронизацииДОСозданиеЯСообщения;
        }


        //todo


        // TODO: 11.08.2021  метод ССОЗДАНИИ НОВГО СООБЩЕНИЯ В ЧАТЕ
        protected Integer МетодСозданииНовогоСообщениявЧате(View v) throws InterruptedException, ExecutionException {
            ///
            ////////

            // TODO: 25.07.2021  ОБЩИЙ РЕЗУЛЬТАТ РАБОТЫ ВСТАВКИ ДАННЫХ СОЗДАНИЕ НОВОГО СООБЩЕНИЯ
            Integer РезультатВставки_ОбоихОперацийТОлькоДляДочернейТаблицыИлиДЛяОбеихИДочернейИРолдительской = 0;


            Long РезультатВставкиПервогоСообщения = 0l;
            ////
            Long РезультатВставкиВторогоСообщения = 0l;
            ///


            //
            try {
                /////


                ////
                SQLiteCursor Курсор_ПосикUUIDУжеСозданныйУжеЧатМеждуользователсиИЛНЕТ = null;

                //TODO УСУСЕТЛВЕМ ПОИСК ЕЛСИ ПРИШЛО ТОЖЕ НЕТ ЧАТА

                Log.d(this.getClass().getName(), "ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата);


                Log.d(this.getClass().getName(), "ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата + "\n");


                // TODO: 22.12.2021 СОЗДАЕМ НОВОЕ СООБЩЕНЕИ В ОДИН ХОД ТОЛКО В ВТОРУЮ ТАБЛИЦУ data_chat   -----!!!! МЕЖДУ ПОЛЬЗОВАТЕЛЯМИ УЖЕ ЕСТЬ ПЕРЕПИСКА ,  МЫ ЕЕ ПРОСТО ПРОДОЛЖАЕМ


                // TODO: 22.12.2021 ПРИ ПЕРВОМ СОЗДНИ СООБЩЕНИ МЕЖДУ ДАННЫМИ КЛИЕНТАМИ ПОТВТОРНО ПРОВРЕРЕ ЕСЛИ МЕЖДУ НИМИ ПВБЛИЧНЫЙ UUID
                if (ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата == 0) {

                    ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата
                            = new SubClass_RetryGEtRowInChatsКлассПроверемЕщеРАзПоявилосЛИПуббличныйUUIDМеждуУчасникамиЧата()
                            .МетодПовторноПроверетНеПовилосьЛиМеждеУчаникамиперепискиПубличныйUUID(getContext(),
                                    ПолученыйIDДляЧата,
                                    ПубличныйIDДляФрагмента
                                    , Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,
                                    Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

                    // TODO: 10.02.2022
                    Log.d(this.getClass().getName(), " повторно ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата+"\n" );

                }


                // TODO: 10.02.2022
                Log.d(this.getClass().getName(), " повторно ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата+"\n" );

                if (ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата > 0) {


                    // TODO: 21.12.2021  СОЗДАЕМ НОВЕ СООБЩЕНИЕ УЖЕ В ДЕЙСТВУЕЩЕЙ ПЕРЕРПИСКИ МЕЖДУ СОТРУДУНИКАМИ

                    Long РезультатВставки_ТолькоДочернуюТаблицуПотомуЧтоМеждуПользователямиУжеЕстьПереписка =
                            МетодОперацииВставкиТолькоДочернуюТаблицу_ДАТА_ЧАТ_ПотомуЧтоУжестьМеждуНимиПерписка(
                                    ПубличныйIDДляФрагмента,ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата);


                    Log.d(this.getClass().getName(), "РезультатВставки_ТолькоДочернуюТаблицуПотомуЧтоМеждуПользователямиУжеЕстьПереписка  УЖЕ В ДЕЙСТВУЩЕЕЙ ЧАТЕ МЕЖДУ СОТРУДНИКАМИ " +
                            "УЖЕ ЕСТЬ ПЕРЕРПИСКА"
                            + РезультатВставки_ТолькоДочернуюТаблицуПотомуЧтоМеждуПользователямиУжеЕстьПереписка +"  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата   " +ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата);


                    if (РезультатВставки_ТолькоДочернуюТаблицуПотомуЧтоМеждуПользователямиУжеЕстьПереписка > 0) {

                        // TODO: 22.12.2021

                        РезультатВставки_ОбоихОперацийТОлькоДляДочернейТаблицыИлиДЛяОбеихИДочернейИРолдительской++;

                        // TODO: 22.12.2021  после успешного создание нового сообщения

                        ////
                        editTextТелоНаписаногоСообщенияДругимСотрудникам.setText("");

                    }


                    Log.d(this.getClass().getName(), "РезультатВставки_ТолькоДочернуюТаблицуПотомуЧтоМеждуПользователямиУжеЕстьПереписка " +
                            " РезультатВставки_ОбоихОперацийТОлькоДляДочернейТаблицыИлиДЛяОбеихИДочернейИРолдительской  УЖЕ В ДЕЙСТВУЩЕЕЙ ЧАТЕ МЕЖДУ СОТРУДНИКАМИ " +
                            "УЖЕ ЕСТЬ ПЕРЕРПИСКА"
                            + РезультатВставки_ОбоихОперацийТОлькоДляДочернейТаблицыИлиДЛяОбеихИДочернейИРолдительской);








                    // TODO: 21.12.2021  СОЗДАЕМ НОВОЕ СООБЩЕНИЯ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ СТРОЧЕК CHATS AND DATA_CHATS ВТОРОЙ ХОД ------КОГДА ЕЩЕ НЕТ ПЕРЕРПИСКИ  ОДИН И ДВА


                    // TODO: 21.12.2021  СОЗДАЕМ НОВОЕ СООБЩЕНИЯ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ СТРОЧЕК CHATS AND DATA_CHATS ВТОРОЙ ХОД ------КОГДА ЕЩЕ НЕТ ПЕРЕРПИСКИ  ОДИН И ДВА

                    // TODO: 21.12.2021  СОЗДАЕМ НОВОЕ СООБЩЕНИЯ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ СТРОЧЕК CHATS AND DATA_CHATS ВТОРОЙ ХОД ------КОГДА ЕЩЕ НЕТ ПЕРЕРПИСКИ  ОДИН И ДВА
                    //
                    //                    // TODO: 21.12.2021  СОЗДАЕМ НОВОЕ СООБЩЕНИЯ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ СТРОЧЕК CHATS AND DATA_CHATS ВТОРОЙ ХОД ------КОГДА ЕЩЕ НЕТ ПЕРЕРПИСКИ  ОДИН И ДВА


                    // TODO: 21.12.2021  СОЗДАЕМ НОВОЕ СООБЩЕНИЯ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ СТРОЧЕК CHATS AND DATA_CHATS ВТОРОЙ ХОД ------КОГДА ЕЩЕ НЕТ ПЕРЕРПИСКИ  ОДИН И ДВА
                    // TODO: 21.12.2021  СОЗДАЕМ НОВОЕ СООБЩЕНИЯ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ СТРОЧЕК CHATS AND DATA_CHATS ВТОРОЙ ХОД ------КОГДА ЕЩЕ НЕТ ПЕРЕРПИСКИ  ОДИН И ДВА


                    // TODO: 21.12.2021  СОЗДАЕМ НОВОЕ СООБЩЕНИЯ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ СТРОЧЕК CHATS AND DATA_CHATS ВТОРОЙ ХОД ------КОГДА ЕЩЕ НЕТ ПЕРЕРПИСКИ  ОДИН И ДВА
                    // TODO: 21.12.2021  СОЗДАЕМ НОВОЕ СООБЩЕНИЯ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ СТРОЧЕК CHATS AND DATA_CHATS ВТОРОЙ ХОД ------КОГДА ЕЩЕ НЕТ ПЕРЕРПИСКИ  ОДИН И ДВА


                    // TODO: 21.12.2021  СОЗДАЕМ НОВОЕ СООБЩЕНИЯ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ СТРОЧЕК CHATS AND DATA_CHATS ВТОРОЙ ХОД ------КОГДА ЕЩЕ НЕТ ПЕРЕРПИСКИ  ОДИН И ДВА


                    Log.d(this.getClass().getName(),  "\n" +
                            "  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата);
                } else {

                    ////
                    Long НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID =
                            (Long) new Class_Generation_UUID(getContext()).МетодГенерацииUUID(getContext());

                    //
                    Log.d(this.getClass().getName(), "НовыйUUIDДляДляОбеихТАблицЧатиДата_Чатс_Когда_МеждуПользователямиЕщеНетСообещенийИЭтоПервое "
                            + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID);



                    Log.d(this.getClass().getName(), "  ПЕРЕОПРЕДЕЛЕН   ДЛЯ ДВУХ ТАБЛИЦ   СОЗДАНИЕ СООБЩЕНИЯ " +
                            "ПЕРВОГО МЕЖДУ СОТРУДУНИКАМИ И ПЕРЕРПИСКИ МЕЖДУ НИМИ ЕЩЕ ЗАПИСЬ ПРОИЗВОДИТЬСЯ И ТАБЛИЦУ ЧАТ И В ТАБЛИЦУ ДАТА_ЧАТ" +
                            Log.d(this.getClass().getName(), "  ПЕРЕОПРЕДЕЛЕН   ДЛЯ ДВУХ ТАБЛИЦ   СОЗДАНИЕ " +
                                    "СООБЩЕНИЯ ПЕРВОГО МЕЖДУ СОТРУДУНИКАМИ И ПЕРЕРПИСКИ МЕЖДУ НИМИ ЕЩЕ ЗАПИСЬ ПРОИЗВОДИТЬСЯ И ТАБЛИЦУ ЧАТ И В ТАБЛИЦУ ДАТА_ЧАТ" +
                                    " НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID "
                                    + НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID));


                    // TODO: 22.12.2021  ########################################################################################-1

                    // TODO: 21.12.2021   СОЗДАЕМ НОВОЕ СООБЩЕНИ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ  CHAT ПЕРВЫЙ ХОД

                    Long МетодОперацииВставкиТолькоРодительскуюТаблицу_ЧАТ_КогдаУжесуществуетПерепискаМеждуПользователями =
                            МетодОперацииВставкиТолькоРодительскуюТаблицу_ЧАТ_КогдаЕщеНЕтПерепискиМеждуПользователями(
                                    ПубличныйIDДляФрагмента,НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID);


                    Log.d(this.getClass().getName(), "МетодОперацииВставкиТолькоРодительскуюТаблицу_ЧАТ_КогдаУжесуществуетПерепискаМеждуПользователями "
                            + МетодОперацииВставкиТолькоРодительскуюТаблицу_ЧАТ_КогдаУжесуществуетПерепискаМеждуПользователями);


                    // TODO: 22.12.2021  ####################################################################################################################-2




                    // TODO: 21.12.2021   СОЗДАЕМ НОВОЕ СООБЩЕНИ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ  DATA_CHATS ВТОРОЙ ХОД


                    if (МетодОперацииВставкиТолькоРодительскуюТаблицу_ЧАТ_КогдаУжесуществуетПерепискаМеждуПользователями > 0) {


                        // TODO: 21.12.2021  СОЗДАЕМ НОВОЕ СООБЩЕНИ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ  DATA_CHATS ВТОРОЙ ХОД

                        Long РезультатВставки_ТолькоДочернуюТаблицуПотомуЧтоМеждуПользователямиУжеЕстьПереписка =
                                МетодОперацииВставкиТолькоДочернуюТаблицу_ДАТА_ЧАТ_ПотомуЧтоУжестьМеждуНимиПерписка(
                                        ПубличныйIDДляФрагмента,НовыйUUIDДляОбеихТаблицЧАТиДАТАЧАТдляПоляPARENT_UUID);


                        Log.d(this.getClass().getName(), "РезультатВставки_ТолькоДочернуюТаблицуПотомуЧтоМеждуПользователямиУжеЕстьПереписка "
                                + РезультатВставки_ТолькоДочернуюТаблицуПотомуЧтоМеждуПользователямиУжеЕстьПереписка);


                        if (РезультатВставки_ТолькоДочернуюТаблицуПотомуЧтоМеждуПользователямиУжеЕстьПереписка > 0) {

                            // TODO: 22.12.2021

                            РезультатВставки_ОбоихОперацийТОлькоДляДочернейТаблицыИлиДЛяОбеихИДочернейИРолдительской++;

                            // TODO: 22.12.2021  после успешного создание нового сообщения

                            ////
                            editTextТелоНаписаногоСообщенияДругимСотрудникам.setText("");

                        }

                        // TODO: 21.12.2021  СОЗДАЕМ НОВОЕ СООБЩЕНИ  ИЗ ДВУХ ЧАСТЬЕЙ СОЗДАНИЕ В ДВУХ ТАБЛИЦАХ СТРОЧЕК CHATS AND DATA_CHATS ВТОРОЙ ХОД
                    }

                }


                // TODO: ЗАКРЫВАЕМ КУРСОР ПОСЛЕ ОТРАБОТКИ


                Log.d(this.getClass().getName(), "Курсор_ПосикUUIDУжеСозданныйУжеЧатМеждуользователсиИЛНЕТ "
                        + Курсор_ПосикUUIDУжеСозданныйУжеЧатМеждуользователсиИЛНЕТ + "КурсорДанныеДлязаписиичтнияЧата " +КурсорДанныеДлязаписиичтнияЧата);

                if (Курсор_ПосикUUIDУжеСозданныйУжеЧатМеждуользователсиИЛНЕТ!=null){

                    Курсор_ПосикUUIDУжеСозданныйУжеЧатМеждуользователсиИЛНЕТ.close();
                }





                // TODO: 22.12.2021
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///

            }

            Log.i(this.getClass().getName(), "   РезультатВставки_ОбоихОперацийТОлькоДляДочернейТаблицыИлиДЛяОбеихИДочернейИРолдительской" +
                    " " + РезультатВставки_ОбоихОперацийТОлькоДляДочернейТаблицыИлиДЛяОбеихИДочернейИРолдительской);

            return РезультатВставки_ОбоихОперацийТОлькоДляДочернейТаблицыИлиДЛяОбеихИДочернейИРолдительской;
            // TODO: 05.07.2021 после успешной вставки новой записи обновляем UI
        }












        // TODO: 05.07.2021 код запуска метода ЗАПИСИВ БАУЗ СТАТУСА КАК ПРОЧИТАННЫЙ

        Integer МетодЗаписиЧтоТекущийПользовательПрочиталСообщениеОтДруговоПользователя(Long ПолученныйUUIDТекущейСтрочкиКоторуюПрочитали, String СамоЗначенияИндифкатора
                , Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть) {

            // TODO: 05.07.2021 вставка новго сообщения в деве таблоицы Code_For_Chats_КодДля_Чата and DATA_Chat
            Integer РезультатОбновленияСтатусЧатаКакПрочитанный = 0;

            Long РезультатУвеличинаяВерсияДАныхЧата = 0L;

            // TODO: 08.02.2022
            String ТаблицаОбработкиВнутриЧтатаПриУвеличсенииВерсииДаннвъКоглаПрочинаноСообещния="data_chat";

            try {


                Log.d(this.getClass().getName(), "  МетодЗаписиСтатусаНеЖиныйПослеПросмотраЗаписиВЧате  ПолученныйUUIDТекущейСтрочкиКоторуюПрочитали "
                        + ПолученныйUUIDТекущейСтрочкиКоторуюПрочитали);


                //     <Long>     ОбновленияСтатусаПрочитанный=new Executor    (Executors.newCachedThreadPool());
                //////

                /////КОНТЕЙГНЕР
                ContentValues contentValuesОбновленниВТАблицеКакПрочитанныйМеняемСтатусЗаписисВчатеПостлеПросмотра = new ContentValues();

                ////////

                contentValuesОбновленниВТАблицеКакПрочитанныйМеняемСтатусЗаписисВчатеПостлеПросмотра.put("status_write", 1);
                //////

                // TODO: 13.01.2022

          /*      ////TODO ДАТА
                String СгенерированованныйДатаДЛяИзмененияСтатусаЗаписиКакПрочитаннаяВЧате=
                        new Class_Generation_Data(getContext()).ГлавнаяДатаИВремяОперацийСБазойДанных();


                contentValuesОбновленниВТАблицеКакПрочитанныйМеняемСтатусЗаписисВчатеПостлеПросмотра.put("date_update", СгенерированованныйДатаДЛяИзмененияСтатусаЗаписиКакПрочитаннаяВЧате);*/
                ////МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table  ///МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table

            /*    РезультатУвеличинаяВерсияДАныхЧата = class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.new ChangesVesionData(getContext()).
                        МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table("data_chat", "localversionandroid_version", getContext()
                                , Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());
*/


                РезультатУвеличинаяВерсияДАныхЧата = 0L;

                РезультатУвеличинаяВерсияДАныхЧата =
                        class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.new ChangesVesionData(getContext()).
                                МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table
                                        (ТаблицаОбработкиВнутриЧтатаПриУвеличсенииВерсииДаннвъКоглаПрочинаноСообещния, "localversionandroid_version", getContext()
                                                , Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());


                //TODO  конец курант ча
                //////
                contentValuesОбновленниВТАблицеКакПрочитанныйМеняемСтатусЗаписисВчатеПостлеПросмотра.put("current_table", РезультатУвеличинаяВерсияДАныхЧата);
                //////


                // TODO: 05.07.2021 вставка новго сообщения в деве таблоицы Code_For_Chats_КодДля_Чата and DATA_Chat
                РезультатОбновленияСтатусЧатаКакПрочитанный = 0;

                ///TODO ВТОРАЯ ТРАНЗАКЦИЯ ВСТАВКИ ДАННЫХ
                РезультатОбновленияСтатусЧатаКакПрочитанный = modelДляФрагментаДляОперацииЗаписиНовгоСтатусаПрочитанного.
                        ЛокальногоОбновлениеДанныхЧерезКонтейнерУниверсальная(ТаблицаОбработкиВнутриЧтатаПриУвеличсенииВерсииДаннвъКоглаПрочинаноСообещния,
                                contentValuesОбновленниВТАблицеКакПрочитанныйМеняемСтатусЗаписисВчатеПостлеПросмотра,
                                ПолученныйUUIDТекущейСтрочкиКоторуюПрочитали, СамоЗначенияИндифкатора);


                ///TODO ПЕРОВЕ ТРАНЗАКЦИЯ ВСТАВКИ ДАННЫХ
                Log.d(this.getClass().getName(), " Результат_ПриписиИзменнийВерсииДанных   " + РезультатОбновленияСтатусЧатаКакПрочитанный);

                Log.d(this.getClass().getName(), " Результат_ПриписиИзменнийВерсииДанныхДляЧата   " + РезультатОбновленияСтатусЧатаКакПрочитанный);

                ////


                ///////
                Log.d(this.getClass().getName(), "   РезультатОбновленияСтатусЧатаКакПрочитанный " + РезультатОбновленияСтатусЧатаКакПрочитанный);


                if (РезультатОбновленияСтатусЧатаКакПрочитанный > 0) {
                    //

                    Log.d(this.getClass().getName(), " УСПЕШНОЕ СОЗДАНИЕ НОВОГО СООБЩЕНИЯ   РезультатОбновленияСтатусЧатаКакПрочитанный " + РезультатОбновленияСтатусЧатаКакПрочитанный);
                    /////


                    // TODO: 05.07.2021 ПОСЛЕ УСПЕШНОЙ ВСТАВКИ ДАННЫХ ОБНОВЛЕНИЕ UI ЗАПУСКАЕМ СИНХРОНИЗАЦИЮ  С СЕРВЕРОМ


                } else {
                    Log.d(this.getClass().getName(), "  НЕТ УСПЕШНОГО СООБШЕИЯ  РезультатОбновленияСтатусЧатаКакПрочитанный " + РезультатОбновленияСтатусЧатаКакПрочитанный);

                }


                // TODO: 05.07.2021 после успешной вставки новой записи обновляем UI


            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///


            }

            Log.d(this.getClass().getName(), "  РезультатОбновленияСтатусЧатаКакПрочитанный " + РезультатОбновленияСтатусЧатаКакПрочитанный +
                    " РезультатУвеличинаяВерсияДАныхЧата " + РезультатУвеличинаяВерсияДАныхЧата);

            if (РезультатОбновленияСтатусЧатаКакПрочитанный > 0) {

                РезультатОбновленияСтатусЧатаКакПрочитанный = Integer.parseInt(String.valueOf(РезультатУвеличинаяВерсияДАныхЧата));
            }


            return РезультатОбновленияСтатусЧатаКакПрочитанный;   // TODO: 05.07.2021 вставка новго сообщения в деве таблоицы Code_For_Chats_КодДля_Чата and DATA_Chat

        }








    }


    // TODO: 14.01.2022 новый класс модель

    public  class MODEL {
        /////
        public MODEL(Context context) {
            try {


            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///


            }


        }


        // TODO: 09.09.2021

        void МетодПолучениеДанныхдляФрагментаЧитатьиПисатьЧат() throws ExecutionException, InterruptedException {
            try {

                // TODO: 05.07.2021  получаем публичный ID
                // TODO: 09.09.2021 первый  курсор


// TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ через брдкастер синхронизхации и уведомления


                Log.d(this.getClass().getName(), "  ПубличныйIDДляФрагмента  " + ПубличныйIDДляФрагмента+ " ПолученыйIDДляЧата " +ПолученыйIDДляЧата);


                // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ
                class_grud_sql_operationsРабоатемВФрагментечитатьПисатьДляПолученияПУбличногоIDПолучениеГлавныхДанные = new Class_GRUD_SQL_Operations(getContext());
                ///


                Log.d(this.getClass().getName(), "  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата  " + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата);

                // TODO: 22.12.2021 КОГДА УЖЕ ЕСТЬ ПРЕПИСКА МЕЖДУ ЛЮДИМИ ТО ЗАРГУЖАЕМ ТАК ЧЕРЕЗЩ УЖЕ СУЩЕСТВУЮЩИЙ uuid
                if (ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата >0) {

                    Log.d(this.getClass().getName(), " ЕСТЬ  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата  "
                            + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата
                            + "ПолученноеФИОКемБылоНаписаноСообщение " +ПолученноеФИОКемБылоНаписаноСообщение+
                            " ПолученыйIDДляЧата " +ПолученыйIDДляЧата);


                    //TODO: 22.12.2021  // TODO: 22.12.2021 КОГДА УЖЕ ЕСТЬ ПРЕПИСКА МЕЖДУ ЛЮДИМИ ТО ЗАРГУЖАЕМ ТАК ЧЕРЕЗЩ УЖЕ СУЩЕСТВУЮЩИЙ uuid //СамFreeSQLКОд
                    class_grud_sql_operationsРабоатемВФрагментечитатьПисатьДляПолученияПУбличногоIDПолучениеГлавныхДанные.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПодЗапросНомер1",

                            " SELECT   * FROM data_chat  WHERE  chat_uuid  =" + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата +
                                    "  AND   message IS NOT NULL    " +
                                    "AND   date_update IS NOT NULL   " +
                                    " ORDER BY  current_table    ASC   ");// current_table    ///   date_update


                    // TODO: 05.03.2022 old_code

            /*        " SELECT   * FROM data_chat  WHERE  chat_uuid  =" + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата +
                            "  AND   message IS NOT NULL    " +
                            "AND   date_update IS NOT NULL   " +
                            " ORDER BY  date_update   ASC   ");// current_table    ///   date_update*/

        /*            " SELECT   * FROM viewchat  WHERE  chat_uuid  =" + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата +
                            "   AND id_user  ="+  ПолученыйIDДляЧата +
                            "   AND user_update !  ="+     ПолученноеФИОКемБылоНаписаноСообщение +
                            "  AND   message IS NOT NULL    " +
                            "AND   date_update IS NOT NULL   " +
                            " ORDER BY  date_update  ASC   ");// current_table    ///   date_update*/

                    //TODO: 22.12.2021  // TODO: 22.12.2021 КОГДА УЖЕ ЕСТЬ ПРЕПИСКА МЕЖДУ ЛЮДИМИ ТО ЗАРГУЖАЕМ ТАК ЧЕРЕЗЩ УЖЕ СУЩЕСТВУЮЩИЙ uuid //СамFreeSQLКОд


                    Log.w(this.getClass().getName(), " Запрос НА Данные  С УЖЕ СУЩЕСТВУЮЩИЕМ UUID ПЕРЕРПИСКА МЕЖДУ ПОЛЬЗОВАТЕЛЯМИ ЕСТЬ УЖЕ " +
                            " МетодПолучениеДанныхдляФрагментаЧитатьиПисатьЧат " +
                            "  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата);



                    КурсорДанныеДлязаписиичтнияЧата = null;

                    ///////
                    КурсорДанныеДлязаписиичтнияЧата = (SQLiteCursor) class_grud_sql_operationsРабоатемВФрагментечитатьПисатьДляПолученияПУбличногоIDПолучениеГлавныхДанные.
                            new GetData(getContext()).getdata(class_grud_sql_operationsРабоатемВФрагментечитатьПисатьДляПолученияПУбличногоIDПолучениеГлавныхДанные.
                                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков
                            , Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());








                    if (КурсорДанныеДлязаписиичтнияЧата != null ) {

                        // TODO: 10.02.2022
                        ///////
                        if (КурсорДанныеДлязаписиичтнияЧата.getCount()>0) {
                            // TODO: 02.02.2022

                            // TODO: 10.02.2022


                            Log.d(this.getClass().getName(), "КурсорДанныеДлязаписиичтнияЧата "  + КурсорДанныеДлязаписиичтнияЧата.getCount());

                            КурсорДанныеДлязаписиичтнияЧата.moveToFirst();


                            ////
                            new MODEL(getContext()).МетодПослеСозданиеНовогоСообщенияПодписываемсяНАДанныеИзКурсораObserver();

                            Log.d(this.getClass().getName(), "КурсорДанныеДлязаписиичтнияЧата "  + КурсорДанныеДлязаписиичтнияЧата.getCount());
                        }

                        Log.w(this.getClass().getName(), "GetData  КурсорДанныеДлязаписиичтнияЧата.getCount() " + КурсорДанныеДлязаписиичтнияЧата.getCount());
                        // TODO: 01.02.2022  подписка на данные



                    }
                    // TODO: 11.10.2021

                    Log.d(this.getClass().getName(), "GetData " + КурсорДанныеДлязаписиичтнияЧата);



                    // TODO: 22.12.2021 _Old query ДАННЫЙ ЗАПРОС ПРОИЗВОДИМ КОГДА МЕЖДУ ПОЛЬЗОВАТЕЛЯ ЕЩЕ НЕТ ПЕРЕПИСКИ И ОНИ ПЕРВЫЙ РАЗ ПИШУТСЯ И МЯ ИХ СОЕДНИЯЕМ ЧРЕЗ ДВОЙНОЙ ЗАПРОС
                }


                // TODO: Сам курсор получение даданных В ФРАГМЕНТЕ ЧИТЬ И ПИСАТЬ



                /*else {

                    // TODO: 22.12.2021 _Old query
   *//*                 class_grud_sql_operationsРабоатемВФрагментечитатьПисатьДляПолученияПУбличногоIDПолучениеГлавныхДанные.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СамFreeSQLКОд",


                            " SELECT   * FROM viewchat " +
                                    "  WHERE  user_update  = " + ПолученыйIDДляЧата +
                                    " AND  id_user  = " + ПубличныйIDДляФрагмента +
                                    "  UNION " +
                                    " SELECT   * FROM viewchat " +
                                    "  WHERE  user_update  =" + ПубличныйIDДляФрагмента +
                                    " AND  id_user = " + ПолученыйIDДляЧата +
                                    " AND   message IS NOT NULL    AND   date_update IS NOT NULL    ORDER BY  current_table   ASC   ");// current_table    ///   date_update

*//*


                    Log.d(this.getClass().getName(), " НЕТУ  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата  " + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата);



                    // TODO: 22.12.2021 _Old query ДАННЫЙ ЗАПРОС ПРОИЗВОДИМ КОГДА МЕЖДУ ПОЛЬЗОВАТЕЛЯ ЕЩЕ НЕТ ПЕРЕПИСКИ И ОНИ ПЕРВЫЙ РАЗ ПИШУТСЯ И МЯ ИХ СОЕДНИЯЕМ ЧРЕЗ ДВОЙНОЙ ЗАПРОС

                    class_grud_sql_operationsРабоатемВФрагментечитатьПисатьДляПолученияПУбличногоIDПолучениеГлавныхДанные
                            .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПодЗапросНомер1"," SELECT   * FROM viewchat " +
                            "  WHERE  user_update  = " + ПолученыйIDДляЧата +
                            " AND  id_user  = " + ПубличныйIDДляФрагмента +
                            " AND   message IS NOT NULL    AND   date_update IS NOT NULL   ");//AND _id IS NULL//"  current_table > ? OR _id IS NULL  AND date_update IS NOT NULL "
                    ///"_id > ?   AND _id< ?"

                    class_grud_sql_operationsРабоатемВФрагментечитатьПисатьДляПолученияПУбличногоIDПолучениеГлавныхДанные
                            .concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПодЗапросНомер2"," SELECT   * FROM viewchat " +
                                    "  WHERE  id_user  =" +ПолученыйIDДляЧата  +
                                    " AND  user_update = " + ПубличныйIDДляФрагмента +
                                    " AND   message IS NOT NULL    AND   date_update IS NOT NULL    ORDER BY  date_update   ASC   ");/// current_table
                    ///"_id > ?   AND _id< ?"



                    // TODO: 30.12.2021
                    Log.w(this.getClass().getName(), " Запрос НА Данные  ПЕРВОЕ СООБЩЕНИЕ  МЕЖДУ ПОЛЬЗОВАТЕЛЯМИ ЕСТЬ УЖЕ " +
                            " МетодПолучениеДанныхдляФрагментаЧитатьиПисатьЧат " +
                            "  ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата " + ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата);

                }*/


                  /*              " SELECT   * FROM viewchat  WHERE  user_update  ="+ПолученыйIDДляЧата  +
                                        " AND  id_user  IN  ( "+ПубличныйIDДляФрагмента  +")   " +
                                        "  UNION " +
                                        " SELECT   * FROM viewchat  WHERE  user_update  ="+ПубличныйIDДляФрагмента  +""+
                                        " AND  id_user  IN  ( "+ПолученыйIDДляЧата  +") "+

                                        " AND   message IS NOT NULL    AND   date_update IS NOT NULL    ORDER BY  date_update   ASC   ");// current_table    ///   date_update*/

                // "   id_user  IN  ( " + ПолученыйIDДляЧата + ","+ПубличныйIDДляФрагмента + ")" +
                         /*       " SELECT   * FROM viewchat  WHERE " +
                                        "  EXISTS ( SELECT   * FROM viewchat  WHERE   id_user =" + ПолученыйIDДляЧата + ")" +
                                        " AND  EXISTS ( SELECT   * FROM viewchat  WHERE  user_update=" + ПубличныйIDДляФрагмента + ")" +
                                        " AND  EXISTS ( SELECT   * FROM viewchat  WHERE   id_user =" + ПубличныйIDДляФрагмента + ")" +
                                        " AND  EXISTS ( SELECT   * FROM viewchat  WHERE  user_update=" + ПолученыйIDДляЧата + ")" +
                                        " AND   message IS NOT NULL    AND   date_update IS NOT NULL    ORDER BY  date_update   ASC   ");// current_table    ///   date_update


                                */





               /*                 " SELECT   * FROM viewchat  WHERE " +
                                        "  EXISTS ( SELECT   * FROM viewchat  WHERE   user_update =" + ПолученыйIDДляЧата + " ) " +
                                        "   AND EXISTS ( SELECT   * FROM viewchat  WHERE   id_user =" + ПолученыйIDДляЧата + " ) " +
                                        "   AND EXISTS ( SELECT   * FROM viewchat  WHERE   user_update =" + ПубличныйIDДляФрагмента + " ) " +
                                        "   AND EXISTS ( SELECT   * FROM viewchat  WHERE   id_user =" + ПубличныйIDДляФрагмента + " ) " +
                                        " AND   message IS NOT NULL    ORDER BY  current_table    ");
*/
                ///date_update
                               /* +" UNION " +




                                                " SELECT   * FROM viewchat  WHERE user_update  = "+  ПубличныйIDДляФрагмента  +   " AND  user_update =" + ПолученыйIDДляЧата  +
                                " AND EXISTS ( SELECT   * FROM viewchat  WHERE id_user  = "+
                                ПубличныйIDДляФрагмента  +   " AND  id_user =" + ПолученыйIDДляЧата  + ") " +
                                " AND   message IS NOT NULL    ORDER BY  current_table    "); ///date_update
                               /* +" UNION " +

                                " SELECT   * FROM viewchat  WHERE user_update = " + ПолученыйIDДляЧата  + " AND EXISTS ( SELECT   * FROM viewchat  WHERE id_user = "+ ПубличныйIDДляФрагмента  + " ) " +

                                " AND   message IS NOT NULL    ORDER BY date_update  ;");//date_updatecurrent_table*/




/*
                " SELECT   * FROM viewchat  WHERE user_update = "+  ПубличныйIDДляФрагмента  +" AND EXISTS ( SELECT   * FROM viewchat  WHERE id_user = " + ПолученыйIDДляЧата + " )  "
                        +" UNION " +

                        " SELECT   * FROM viewchat  WHERE user_update = " + ПолученыйIDДляЧата  + " AND EXISTS ( SELECT   * FROM viewchat  WHERE id_user = "+ ПубличныйIDДляФрагмента  + " ) " +

                        " AND   message IS NOT NULL    ORDER BY date_update  ;");//date_updatecurrent_table
*/










   /*             // TODO: 22.12.2021 КОГДА УЖЕ ЕСТЬ ПРЕПИСКА МЕЖДУ ЛЮДИМИ ТО ЗАРГУЖАЕМ ТАК ЧЕРЕЗЩ УЖЕ СУЩЕСТВУЮЩИЙ uuid
                if (ПолученыйУжеСуществующийUUIDИзПерепискиДляЧата ==0) {

                    ///TODO ГЛАВНЫЙ АДАПТЕР чата
                    new Fragment_Writer_Read_ЧитатьПисатьЧата.VIEW(getContext()).        МетодЗагрузкиданныхНаФрагментКогдаЕстьДанные();

                    // TODO: 11.10.2021

                    Log.d(this.getClass().getName(), "GetData " + КурсорДанныеДлязаписиичтнияЧата);
                }

*/











            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///
            }

        }


        // TODO: 27.10.2021 КЬТО НАПИСАЛ СООБЩЕНИЕ

        String МетодКемБЫлоНАписаноСообщение(Integer ПолученноеФИОКемБылоНаписаноСообщение) {

            String КтопанисалСообщениеФИО = null;


            try {


                Log.d(this.getClass().getName(), "ПолученноеФИОКемБылоНаписаноСообщение " + ПолученноеФИОКемБылоНаписаноСообщение);
                ///
                Class_GRUD_SQL_Operations class_grud_sql_operationsКурсорсоЗначениемФИОПятаяЧасть = new Class_GRUD_SQL_Operations(getContext());

                ///
                class_grud_sql_operationsКурсорсоЗначениемФИОПятаяЧасть.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", "fio");
                ///////
                class_grud_sql_operationsКурсорсоЗначениемФИОПятаяЧасть.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "name");
                //
                class_grud_sql_operationsКурсорсоЗначениемФИОПятаяЧасть.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "user_update = ? ");

                class_grud_sql_operationsКурсорсоЗначениемФИОПятаяЧасть.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", ПолученноеФИОКемБылоНаписаноСообщение);


                ///"_id > ?   AND _id< ?"
                //////
   /*                                 class_grud_sql_operationsКурсорсоЗначениемФИО. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",ПолученноеФИОКемБылоНаписаноСообщение);
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......

                                    ////TODO другие поля

                                    ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
                                    ////
                                    //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
                                    ////
                                    class_grud_sql_operationsПолучениеИмяСистемы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
                                    ////*/
                class_grud_sql_operationsКурсорсоЗначениемФИОПятаяЧасть.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита", "1");
                ////
                SQLiteCursor Курсор_соЗначениемФИО = null;

                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ


                Курсор_соЗначениемФИО = (SQLiteCursor) class_grud_sql_operationsКурсорсоЗначениемФИОПятаяЧасть.
                        new GetData(getContext()).getdata(class_grud_sql_operationsКурсорсоЗначениемФИОПятаяЧасть.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков
                        , Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());
                /////


                Log.d(this.getClass().getName(), "GetData " + Курсор_соЗначениемФИО);

                if (Курсор_соЗначениемФИО.getCount() > 0) {
                    //
                    Курсор_соЗначениемФИО.moveToFirst();
                    //

                    КтопанисалСообщениеФИО = Курсор_соЗначениемФИО.getString(0).trim();

                    Log.d(this.getClass().getName(), "КтопанисалСообщениеФИО " + КтопанисалСообщениеФИО);
                }


            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///
            }

            return КтопанисалСообщениеФИО;

        }


        // TODO: 27.10.2021  Метод полдучение СТАТУСА ЖИРНЫЙ ДОЯ ТЕКЦУЩЕЙ ЗАПИСИ
        Boolean МетодПолучаемНаТекущуюЗаписьПрочитанноеСообщениеИлиНЕТ(Long ПлученныйТЕкущийUUIDЗаписи,

                                                                       Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть) {


            // TODO: 27.10.2021
            Boolean ПолученныйРезультаЗаписьЖирнаяИлиНет = false;

            try {
                Log.d(this.getClass().getName(), "  MODEL  ");


                // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

                ///


                ///
                class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", "data_chat");
                ///////
                class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "status_write");
                //
                class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика", "uuid=?  AND status_write =? AND user_update!=?");
                ///"_id > ?   AND _id< ?"
                //////
                class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1", ПлученныйТЕкущийUUIDЗаписи);

                //////
                class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2", 0);

                //////
                class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3", ПубличныйIDДляФрагмента);

                class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита", 1);

                ///
                /*    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......
**/
                ////TODO другие поля

                ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
                ////
                //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
                ////
                // class_grud_sql_operationsПолучениеИмяСистемы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
                ////
/*    class_grud_sql_operationsДанныеДлязаписиичтнияЧатаИщеммСтатусЖирныйИлиНетЧетвертаяЧасть.
            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");*/
                ////

                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ


                SQLiteCursor КурсорДанныеДлязаписиичтнияЧатаИщеммСтатусЖирныйИлиНет = null;

                // TODO: 03.01.2022


                КурсорДанныеДлязаписиичтнияЧатаИщеммСтатусЖирныйИлиНет =
                        (SQLiteCursor) class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.
                                new GetData(getContext()).getdata(class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть.
                                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                                Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков
                                , Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());


                Log.d(this.getClass().getName(), "GetData " + КурсорДанныеДлязаписиичтнияЧатаИщеммСтатусЖирныйИлиНет);


                // TODO: 09.09.2021 получаемыйц результат
                if (КурсорДанныеДлязаписиичтнияЧатаИщеммСтатусЖирныйИлиНет.getCount() > 0) {
                    //
                    ПолученныйРезультаЗаписьЖирнаяИлиНет = true;
                    // TODO: 27.10.2021

                    Log.d(this.getClass().getName(), "ПолученныйРезультаЗаписьЖирнаяИлиНет " + ПолученныйРезультаЗаписьЖирнаяИлиНет +
                            " КурсорДанныеДлязаписиичтнияЧатаИщеммСтатусЖирныйИлиНет.getCount() " + КурсорДанныеДлязаписиичтнияЧатаИщеммСтатусЖирныйИлиНет.getCount());

                } else {

                    ПолученныйРезультаЗаписьЖирнаяИлиНет = false;
                }

                /////////////////
                // TODO: 27.10.2021
                КурсорДанныеДлязаписиичтнияЧатаИщеммСтатусЖирныйИлиНет.close();
                ///////


                ///поймать ошибку
            } catch (Exception e) {
                //  Block of code to handle errors
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +

                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///////

                //TODO
                ПолученныйРезультаЗаписьЖирнаяИлиНет = false;
            }

            return ПолученныйРезультаЗаписьЖирнаяИлиНет;

        }

        void МетодПослеСозданиеНовогоСообщенияПодписываемсяНАДанныеИзКурсораObserver() {


            try {
                // TODO: 02.02.2022

                dataSetObserverПодпискаНаЛокальныйИспользуетьсяКУРСОРОМ = new DataSetObserver() {
                    @Override
                    public void onChanged() {
                        super.onChanged();
                        // TODO: 23.12.2021


                        if (АдаптерДляЗаписиЧтенияЧата != null) {

                            АдаптерДляЗаписиЧтенияЧата.changeCursor(КурсорДанныеДлязаписиичтнияЧата);

                            АдаптерДляЗаписиЧтенияЧата.notifyDataSetChanged();

                            АдаптерДляЗаписиЧтенияЧата.notifyDataSetInvalidated();


                        }


                        if (ЛистВьюДляСообщенийЧата != null) {

                            ЛистВьюДляСообщенийЧата.requestLayout();

                            // ЛистВьюДляСообщенийЧата.invalidateViews();

                            ЛистВьюДляСообщенийЧата.refreshDrawableState();

                            ЛистВьюДляСообщенийЧата.deferNotifyDataSetChanged();



                            ////
                            //ЛистВьюДляСообщенийЧата.setSelection(ЛистВьюДляСообщенийЧата.getCount() - 1);

                            ЛистВьюДляСообщенийЧата.setSelection(АдаптерДляЗаписиЧтенияЧата.getCount() - 1);
                        }


                        Log.w(this.getClass().getName(), " СРАБОТАЛ registerDataSetObserver  --- фрагменты ПИСАТЬ ЧИТАТЬ ЧАТ КурсорДанныеДлязаписиичтнияЧата.registerDataSetObserver" +
                                dataSetObserverПодпискаНаЛокальныйИспользуетьсяКУРСОРОМ.toString());
                    }
                };


                // TODO: 02.02.2022


                if (КурсорДанныеДлязаписиичтнияЧата!=null) {
                    // TODO: 20.02.2022
                    КурсорДанныеДлязаписиичтнияЧата.registerDataSetObserver(dataSetObserverПодпискаНаЛокальныйИспользуетьсяКУРСОРОМ);
                }

            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                // TODO: 01.09.2021 метод вызова
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///
            }
        }
    }


    // TODO: 01.07.2021  метод


    class тестдляОбмена {

        public тестдляОбмена() {

            SSLSocketFactory socketFactory = null;
            KeyManagerFactory keyManagerFactory = null;
            try {
                keyManagerFactory = KeyManagerFactory.getInstance("SunX509");

                KeyStore keyStore = null;

                keyStore = KeyStore.getInstance("PKCS12");

                keyManagerFactory.init(keyStore, "password".toCharArray());
                SSLContext context = SSLContext.getInstance("TLS");
                context.init(keyManagerFactory.getKeyManagers(), null, new SecureRandom());


                socketFactory = context.getSocketFactory();

            } catch (NoSuchAlgorithmException | KeyStoreException e) {
                e.printStackTrace();
            } catch (UnrecoverableKeyException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }

            ConnectionSpec connectionSpec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                    .allEnabledCipherSuites()
                    .allEnabledTlsVersions()
                    .cipherSuites(
                            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                            CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                            CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
                    .build();

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectionSpecs(Collections.singletonList(connectionSpec))
                    .readTimeout(10, TimeUnit.SECONDS)
                    .callTimeout(1, TimeUnit.MICROSECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .build();
/*


        //////
        // TODO: 30.07.2021   тест для полученеи и отправки данных   тест
        String postBody = "test post";

        Request request = new Request.Builder()
                .url(URL_SECURED_BY_BASIC_AUTHENTICATION)
                .addHeader("Authorization", Credentials.basic("username", "password"))
                .
                    .post(RequestBody.create(
                MediaType.parse("text/x-markdown), postBody))
                        .build();

        Call call = client.newCall(request);
        okhttp3.Response response = call.execute();

        assertThat(response.code(), equalTo(200));



        String json = "{\"id\":1,\"name\":\"John\"}";

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);

        Request request = new Request.Builder()
                .url(BASE_URL + "/users/detail")
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        assertThat(response.code(), equalTo(200));
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", "test")
                .addFormDataPart("password", "test")
                .addFormDataPart("file", "file.txt",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("src/test/resources/test.txt")))
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/users/multipart")
                .post(requestBody)
                .build();

        Call call = client.newCall(request);
        okhttp3.Response response = call.execute();

        assertThat(response.code(), equalTo(200));

        OkHttpClient client = new OkHttpClient();


        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client2 = new OkHttpClient();
        RequestBody body2 = RequestBody.create(JSON, params);
        Request request2 = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        okhttp3.Response response1= null;
        response1 = client.newCall(request).execute();
*/
      /*  OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0])
                .certificatePinner(certPinner)
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();*/

            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }


            };


        /*PrivateKey priv = null;
        KeyFactory fact = null;
        try {
            fact = KeyFactory.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] clear = Base64.decode("ppppppppppppppp", 0).toString().getBytes();
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(clear);
        try {
            priv = fact.generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            sslContext.init(null, trustAllCerts, 787878787);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }*/
            // Create an ssl socket factory with our all-trusting manager
    /*    final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        ///
        final MediaType JSON3 = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client2;
        client2 = new OkHttpClient.Builder()
                .sslSocketFactory()
                .certificatePinner(
                        new CertificatePinner.Builder()
                                .add("publicobject.com", "sha256/afwiKY3RxoMmLkuRW1l7QsPZTJPwDS2pdDROQjXw8ig=")
                                .build())
                .build();*/

     /*   JsonStreamParser jsonStreamParser;
        jsonStreamParser.*/



/*
        RequestBody body = RequestBody.create(JSON, params);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = null;
        response = client.newCall(request).execute();
        String responseBody = response.body().string();

        client.newCall(request).execute().;
        CipherSuite
        try {
            Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
            Charset charset = Charset.forName("ASCII");
            Charset charset = StandardCharsets.UTF_16;

            byte[] byteA hrrray = inputString.getBytes(charset);

            byte[] byteArrray = inputString.getBytes(charset);
            //
            String dd = "IBM01140";
            byte[] byteArrray2 = dd.getBytes();
            try {
                c.doFinal(byteArrray2);
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

        //

        SecretKeyFactory factory = null;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        KeySpec spec = new PBEKeySpec("222".toCharArray(), "11".getBytes(), 65536, 256);
        try {
            SecretKey secret = new SecretKeySpec(factory.generateSecret(spec)
                    .getEncoded(), "AES");
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        String dd = "IBM01140";
        byte[] byteArrray3 = dd.getBytes();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        cipher.init(Cipher.ENCRYPT_MODE, spec, byteArrray3);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);




        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText));
        return new String(plainText);

        String input = "baeldung";
        SecretKey key = factory.generateKey(128);
        IvParameterSpec ivParameterSpec = AESUtil.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(algorithm);
        IvParameterSpec ivParameterSpec = AESUtil.generateIv();
        cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
*/


            // TODO: 30.07.2021  конец получение и отпаврк данных на сервер и с сервера тест
        }
    }


}

class ПодКлассФрагментаЧитатьПисатьПоИзеннениюСтатусаЗАписивЧатеПрочитаноИлиНет  extends Fragment_Writer_Read_ЧитатьПисатьЧата {




/*
    MODEL modelДляФрагментаЧитатьИлиПисать = new MODEL(getContext());
    CONTROLLER controllerДляФрагментаЧитатьИлиПисать = new CONTROLLER(getContext());
    Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть=new Class_GRUD_SQL_Operations(getContext());*/

    Boolean Метода_ФрагметаПрочитано_НаписаноИзменяемИПроверемСтатусПрочитаногоСТрочкиТекущийВчате(Cursor cursor,
                                                                                                   TextView textViewСамоСообщение,
                                                                                                   Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть,
                                                                                                   MODEL modelДляФрагментаЧитатьИлиПисать,
                                                                                                   CONTROLLER controllerДляФрагментаЧитатьИлиПисать,
                                                                                                   Class_Engine_SQL
                                                                                                           Class_Engine_SQLДляИзмененияСтатусаЗаписиПрочтитаноИлиНет,
                                                                                                   PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        // TODO: 16.11.2021  МЕНЯЕМ ТЕКУЩЮУ ЗАПИСЬ ДЕЛАЕМ ПРОЧИТАНОЙ

        Boolean РезультатСтатусСообщения = false;
        try {


            // TODO: 30.06.2021 форматирование кто написал
            int ИндексЗначениеяIDПоляКтоПанисалДанномуПользователю = cursor.getColumnIndex("uuid");///old_chat_uuid"

            // TODO: 29.04.2021
            Long ЗамоЗначениеТекущегоСообщения = 0l;
            /////////////////
            ЗамоЗначениеТекущегоСообщения = cursor.getLong(ИндексЗначениеяIDПоляКтоПанисалДанномуПользователю);
            // TODO: 27.10.2021
            // TODO: 09.09.2021  получение данных СТАТУСА ЖИРНЫЙ


            Log.d(this.getClass().getName(), " ЧУЖОЙ  UUID ЗамоЗначениеТекущегоСообщения"
                    + ЗамоЗначениеТекущегоСообщения);


            РезультатСтатусСообщения = МетодМеняетСтатусЗаписиТекущеКаПрочитаноСтатусПрочитанный(textViewСамоСообщение,
                    ЗамоЗначениеТекущегоСообщения,
                    class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть,
                    modelДляФрагментаЧитатьИлиПисать,
                    controllerДляФрагментаЧитатьИлиПисать,
                    Class_Engine_SQLДляИзмененияСтатусаЗаписиПрочтитаноИлиНет,
                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков);


            Log.d(this.getClass().getName(), " ЧУЖОЙ  UUID ЗамоЗначениеТекущегоСообщения"
                    + ЗамоЗначениеТекущегоСообщения);

            // TODO: 29.04.2021 ПрисваемваемКАЖДОМУ СОТРУДНИКУ ID


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return РезультатСтатусСообщения;
    }

    private Boolean МетодМеняетСтатусЗаписиТекущеКаПрочитаноСтатусПрочитанный(TextView textViewСамоСообщение,
                                                                              Long ЗамоЗначениеТекущегоСообщения,
                                                                              Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть,
                                                                              MODEL modelДляФрагментаЧитатьИлиПисать,
                                                                              CONTROLLER controllerДляФрагментаЧитатьИлиПисать,
                                                                              Class_Engine_SQL Class_Engine_SQLДляИзмененияСтатусаЗаписиПрочтитаноИлиНет
            , PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков) {

        Boolean РезультатИзмененияСтатусаПрочитаногоСообщенияОдинИлиНоль = false;

        if (ЗамоЗначениеТекущегоСообщения > 0) {


            try {





                РезультатИзмененияСтатусаПрочитаногоСообщенияОдинИлиНоль =
                        МетодКоторыйМеняетСтатусНаПрочитанныйТекущуюЗапись(textViewСамоСообщение,
                                ЗамоЗначениеТекущегоСообщения
                                , class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть,
                                modelДляФрагментаЧитатьИлиПисать,
                                controllerДляФрагментаЧитатьИлиПисать,
                                Class_Engine_SQLДляИзмененияСтатусаЗаписиПрочтитаноИлиНет,
                                Class_Engine_SQLГдеНаходитьсяМенеджерПотоков);

                // TODO: 16.11.2021
                Log.d(this.getClass().getName(), " РезультатИзмененияСтатусаПрочитаногоСообщенияОдинИлиНоль "
                        + РезультатИзмененияСтатусаПрочитаногоСообщенияОдинИлиНоль);

            } catch (Exception e) {
                //  Block of code to handle errors
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());

                // TODO: 11.05.2021 запись ошибок

            }
        }

        return  РезультатИзмененияСтатусаПрочитаногоСообщенияОдинИлиНоль;
    }

    // TODO: 16.11.2021  МЕНЯЕМ НА ТЕКУЩУЮ ЗАПИСЬ ЧТО ОНА ПРОЧИТАНА

    Boolean МетодКоторыйМеняетСтатусНаПрочитанныйТекущуюЗапись(TextView view
            , Long ЗамоЗначениеТекущегоСообщения,
                                                               Class_GRUD_SQL_Operations class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть,
                                                               MODEL modelДляФрагментаЧитатьИлиПисать,
                                                               CONTROLLER controllerДляФрагментаЧитатьИлиПисать,
                                                               Class_Engine_SQL Class_Engine_SQLДляИзмененияСтатусаЗаписиПрочтитаноИлиНет
            , PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        ///

        Integer РезультатВставкиНовогоФлагаЧтоТекущееСообщенеиОтДруговоПользоватлеяБылоПрочитанно = 0;
        // TODO: 29.04.2021
        Boolean ПолученноеСтатусПрочитанноСообщениеТекущееИлиНетНольСтоитИЛиЦифраОДИН = false;

        // TODO: 16.01.2022
        String ТекущаяТаблицыОбработкиПриИзмененияСтатусаПрочнетие= "data_chat";
        //////
        try {

            // TODO: 09.09.2021 получаемыйц результат

            ПолученноеСтатусПрочитанноСообщениеТекущееИлиНетНольСтоитИЛиЦифраОДИН =
                    modelДляФрагментаЧитатьИлиПисать.МетодПолучаемНаТекущуюЗаписьПрочитанноеСообщениеИлиНЕТ(ЗамоЗначениеТекущегоСообщения,

                            class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть);


            Log.d(this.getClass().getName(), " ПолученноеСтатусПрочитанноСообщениеТекущееИлиНетНольСтоитИЛиЦифраОДИН "
                    + ПолученноеСтатусПрочитанноСообщениеТекущееИлиНетНольСтоитИЛиЦифраОДИН
                    + " ЗамоЗначениеТекущегоСообщения " + ЗамоЗначениеТекущегоСообщения + "ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);

            // TODO: 16.07.2021

            if (ПолученноеСтатусПрочитанноСообщениеТекущееИлиНетНольСтоитИЛиЦифраОДИН == true) {
                ////


                // TODO: 13.07.2021  важный код отмечаем сообзения что они уже прочитаны и меняе СТАТУС ПРОЧЬТЕНИЯ НА 1

                РезультатВставкиНовогоФлагаЧтоТекущееСообщенеиОтДруговоПользоватлеяБылоПрочитанно =
                        controllerДляФрагментаЧитатьИлиПисать.
                                МетодЗаписиЧтоТекущийПользовательПрочиталСообщениеОтДруговоПользователя(ЗамоЗначениеТекущегоСообщения,
                                        "uuid",
                                        class_grud_sql_operationsПовышаемВерсиюДанныхВосьмаяЧасть);
                //

                Log.d(this.getClass().getName(), " onItemClick MyWork_Update_ОбновлениеПО СЛУЖБА  РезультатВставкиНовогоФлагаЧтоТекущееСообщенеиОтДруговоПользоватлеяБылоПрочитанно  "
                        + РезультатВставкиНовогоФлагаЧтоТекущееСообщенеиОтДруговоПользоватлеяБылоПрочитанно);


                if (РезультатВставкиНовогоФлагаЧтоТекущееСообщенеиОтДруговоПользоватлеяБылоПрочитанно > 0) {

                    Integer Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы =
                            Class_Engine_SQLДляИзмененияСтатусаЗаписиПрочтитаноИлиНет.
                                    МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_Client(
                                            РезультатВставкиНовогоФлагаЧтоТекущееСообщенеиОтДруговоПользоватлеяБылоПрочитанно,
                                            ТекущаяТаблицыОбработкиПриИзмененияСтатусаПрочнетие,
                                            "Локальное",
                                            Long.parseLong(String.valueOf(РезультатВставкиНовогоФлагаЧтоТекущееСообщенеиОтДруговоПользоватлеяБылоПрочитанно)),
                                            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков);


                    Log.i(this.getClass().getName(), " +РезультатВставкиНовогоФлагаЧтоТекущееСообщенеиОтДруговоПользоватлеяБылоПрочитанно "
                            + РезультатВставкиНовогоФлагаЧтоТекущееСообщенеиОтДруговоПользоватлеяБылоПрочитанно +
                            "  Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы "
                            + Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицы);

                    //
                    view.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);

                } else {

                    view.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

                }


            } else {
                //
                view.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);


                Log.d(this.getClass().getName(), " ПолученноеСтатусПрочитанноСообщениеТекущееИлиНетНольСтоитИЛиЦифраОДИН " + ПолученноеСтатусПрочитанноСообщениеТекущееИлиНетНольСтоитИЛиЦифраОДИН
                        + " ЗамоЗначениеТекущегоСообщения " + ЗамоЗначениеТекущегоСообщения + "ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);
            }

            //////

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///


        }
        return ПолученноеСтатусПрочитанноСообщениеТекущееИлиНетНольСтоитИЛиЦифраОДИН;
    }

    // TODO: 19.01.2022 визуального отбражения что началось оьмен с серверром или пропытка


}