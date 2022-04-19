package com.dsy.dsu;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.loader.content.AsyncTaskLoader;

import com.dsy.dsu.Business_logic_Only_Class.Class_Begin_Update_End_Insert_Data_Project;
import com.dsy.dsu.Business_logic_Only_Class.Class_Encryption_Decryption_Login_Password;
import com.dsy.dsu.Business_logic_Only_Class.Class_Find_Setting_User_Network;
import com.dsy.dsu.Business_logic_Only_Class.Class_GRUD_SQL_Operations;
import com.dsy.dsu.Business_logic_Only_Class.Class_Generation_Data;
import com.dsy.dsu.Business_logic_Only_Class.Class_Generation_Errors;
import com.dsy.dsu.Business_logic_Only_Class.Class_MODEL_synchronized;
import com.dsy.dsu.Business_logic_Only_Class.Class_Send_Generation_Errors;
import com.dsy.dsu.Business_logic_Only_Class.Class_Sendiing_Errors;
import com.dsy.dsu.Business_logic_Only_Class.Class_Type_Connenction_Tel;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.zip.GZIPInputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity_Tabels_Users_And_Passwords extends AppCompatActivity {
    ////todo аунтификация
    int ПодсчетОтрицательныйРезультатовАунтификации; ////подсчитываем количество негативныйх попыток долеее 5 послываем программу в спячку

    ///////
    protected Button КнопкаВходавСистему;///КНОПКА ДЛЯ ВХОДЯ В СИСТЕМУ

    protected ProgressBar ПрогрессБарДляВходаСистему;///КНОПКА ДЛЯ ВХОДЯ В СИСТЕМУ

    protected EditText ИмяДляВходаСистему;///КНОПКА ДЛЯ ВХОДЯ В СИСТЕМУ

    protected EditText ПарольДляВходаСистему;///КНОПКА ДЛЯ ВХОДЯ В СИСТЕМУ

    Configuration config;

    Activity activity;

    String КакойРежимСинхрониазции=new String();


    protected Context КонтекстСинхроДляАунтификации;

    // TODO: 12.10.2021  Ссылка Менеджер Потоков

    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =null;


    String ПубличноеИмяПользовательДлСервлета=new String();

    String  ПубличноеПарольДлСервлета=new String();


     Integer ПубличноеIDПолученныйИзСервлетаДляUUID;


    String СтрокаСвязиСсервером=new String();


    ///////TODO
    CREATE_DATABASE   Create_Database_СсылкаНАБазовыйКласс;

    ////шифрование
  SecretKey ГлавныйКлючДляШифрованиеИРасшифровки;
    ////
  Cipher ПолитикаШифрование;
    ///////
     Cipher ПолитикаРасшифровки;








    ////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            ////
            КонтекстСинхроДляАунтификации = this;
            ///
            activity = this;

            ((Activity) КонтекстСинхроДляАунтификации).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


            ((Activity) КонтекстСинхроДляАунтификации).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new  PUBLIC_CONTENT(getApplicationContext());



            Intent ИнтентКакаяПоСчетуСинхронизация = getIntent();



             КакойРежимСинхрониазции = ИнтентКакаяПоСчетуСинхронизация.getStringExtra("РежимЗапускаСинхронизации");


            ///TODO принудительно устанвливаем редим работы синхронизации
            Log.d(this.getClass().getName(), " КакойРежимСинхрониазции "+КакойРежимСинхрониазции);








///////TODO
               Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(getApplicationContext());



            ////todo запрещяет поворот экрана
            //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            setContentView(R.layout.activity_main__authentication);

            getSupportActionBar().hide(); ///скрывать тул бар

            /////todo данная настрока запрещает при запуке активти подскаваать клавиатуре вверх на компонеты eedittext
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


            //   getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION  );
            ////
/*
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                    | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                    | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);*/
            /////
            Log.d(this.getClass().getName(), "   ");
            // Locale locale = Locale.ROOT;
            Locale locale = new Locale("rus");
            Locale.setDefault(locale);
            config =
                    getBaseContext().getResources().getConfiguration();
            config.setLocale(locale);
            createConfigurationContext(config);
            ///TODO разное

            ////
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


            ///TODO компоненты ДЛЯ АУНТИФИКАЦИИИ
        /*    МетодАунтификацииПользователяПриВходевПрограммуДСУ1();//// данный метод в будущем будет запускаться с  кнопки
        // запускаем метод аунтификации пользователя при входе в программу и сучимся на сервлет*/
            Log.d(getPackageName().getClass().getName(), " onCreate(Bundle savedInstanceState)  MainActivity_Tabels_Users_And_Passwords ");


            КнопкаВходавСистему = (Button) findViewById(R.id.КнопкаВходаВПриложение);/////кнопка входа на сервер
            КнопкаВходавСистему.setVisibility(View.VISIBLE);

            ПрогрессБарДляВходаСистему = (ProgressBar) findViewById(R.id.progressBarДляWIFI); ////програссбар при аунтификации при входе в системму
            ПрогрессБарДляВходаСистему.setVisibility(View.INVISIBLE);// по умолчанию прогресс бар делаем не видеым

            ИмяДляВходаСистему = (EditText) findViewById(R.id.ИмяДляВходавПрограмму); ////програссбар при аунтификации при входе в системму
            ПарольДляВходаСистему = (EditText) findViewById(R.id.ПарольДляВходавПрограмму); ////програссбар при аунтификации при входе в системму

            ///////TODO 1


            ///TODO установка разрешений


            String[] permissions = new String[]{
                    Manifest.permission.INTERNET,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.VIBRATE,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.REQUEST_INSTALL_PACKAGES,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
                    Manifest.permission.MANAGE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.ACCESS_MEDIA_LOCATION,
                    Manifest.permission.INSTALL_PACKAGES,
                    Manifest.permission.WRITE_SETTINGS,
                    Manifest.permission.WRITE_SECURE_SETTINGS


            };

            //  startService(new Intent(КонтекстFaceApp, Service_Update_ОбновлениеПО.class));
////TODO УСТАНВЛИВАЕМ РАЗРЕШЕНИЯ НА ВСЕ ПРИЛОЖЕНИЯ НАСТРОЙКИ
            ActivityCompat.requestPermissions(this, permissions, 1);


            /////// МетодПодготовкиДляАунтификации(); ////МЕТОД ПРЕДВАРИТЕЛЬНОГО ПОДГОТОВКИ К АУНТИФИКАЦИИ ПОЛЬЗОВАТЛЕЯ

        } catch (Exception e) {
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " ПодсчетОтрицательныйРезультатовАунтификации " + ПодсчетОтрицательныйРезультатовАунтификации);
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());



            // TODO: 11.05.2021 запись ошибок


            new Class_Send_Generation_Errors(getApplicationContext(), e.toString(), activity);


            Log.d(this.getClass().getName(), "  Полусаем Ошибку e.toString() " + e.toString());
        }
        }









    @Override
    protected void onDestroy() {
        super.onDestroy();

        //////TODO  данный код срабатывает когда произошда ошивка в базе


    }


    @Override
    protected void onResume() {
        super.onResume();
        try {
            ///////
            МетодПодготовкиДляАунтификации(); ////МЕТОД ПРЕДВАРИТЕЛЬНОГО ПОДГОТОВКИ К АУНТИФИКАЦИИ ПОЛЬЗОВАТЛЕЯ

        } catch (Exception e) {
            ///метод запись ошибок в таблицу
            ПодсчетОтрицательныйРезультатовАунтификации++;///подсчитываем ошибки для точго чтобы приложение пошло спать
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " ПодсчетОтрицательныйРезультатовАунтификации " + ПодсчетОтрицательныйРезультатовАунтификации);
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }







    ////////TODO КОТОРЫЙ НАЧИНАЕМ ТОЛЬКО ЕСЛИ ЕСТЬ ИМЯ И ПАРОЛЬ НАЧИНАЕТЬСЯ ТОЛЬКО С НЯЖАТИЕ КНОПКИ ВХОД
    private void МетодПодготовкиДляАунтификации() {
        try {

            КнопкаВходавСистему.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ПрогрессБарДляВходаСистему.setVisibility(View.VISIBLE);// при нажатии делаем видимый програсссбар

                    Log.d(getPackageName().getClass().getName(), "  private void МетодПодготовкиДляАунтификации()");///


                    /////todo два компонета делаем их не видимые
                    Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        v2.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        v2.vibrate(100);
                    }

                    //// TODO имя

                    ПубличноеИмяПользовательДлСервлета = ИмяДляВходаСистему.getText().toString().trim();///получаем из формы имя для того чтобы постучаться на сервер

                    Log.d(getPackageName().getClass().getName(), "ПубличноеИмяПользовательДлСервлета " + ПубличноеИмяПользовательДлСервлета);
                    ////////////TODO пароль

                 ПубличноеПарольДлСервлета = ПарольДляВходаСистему.getText().toString().trim();///////получаем из формы пароль для того чтобы постучаться на сервер


                    Log.d(getPackageName().getClass().getName(), "ПубличноеПарольДлСервлета " +ПубличноеПарольДлСервлета);




                    /////todo данная настрока запрещает при запуке активти подскаваать клавиатуре вверх на компонеты eedittext
                    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

                    ////TODO ----НАЧАЛО АУНТИФИКАЦИИ

                    /////todo НАЧИНАЕМ АУНТИФИКАЦИЮ С СЕРЕВЕРОМ ТОЛЬКО ЕСЛИ ЕСТЬ ИМЯ И ПАРОЛЬ ДЛЯ ПРОДОЛЖЕНИЯ
                    if (ПубличноеИмяПользовательДлСервлета.length() > 0 &&  ПубличноеПарольДлСервлета.length() > 0) {
                        ///


                        ////todo проверяем если подключение к интернуту

                        // TODO: 29.09.2021  перед началом СИНХРОНИЗАЦИИ ПРОВЕРЯЕМ УСТАНОВКИ СЕТИ ПОЛЬЗОВАТЕЛЯ НА АКТИВТИ НАСТРОЙКИ

                        boolean РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию =
                                new Class_Find_Setting_User_Network(getApplicationContext()).МетодПроветяетКакуюУстановкуВыбралПользовательСети();

                        //TODO ФУТУРЕ ЗАВЕРШАЕМ
                        Log.d(this.getClass().getName(), "  РезультатПроВеркиУстановкиПользователяРежимРаботыСети "
                                + РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию);


                        // TODO: 29.09.2021  финальный результат


                        // TODO: 22.04.2021  srart JOBschedele
                        Log.d(this.getClass().getName(), " РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию  "
                                +РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию);


/////todo удаление из памяти

                        /////TODO ПРОВЕРЯЕМ ЕЛСИНЕТ ПОДКЛЮЧЕНИЕ К ИНТРЕНТУ ТО СИНХРОНИЗАЦИЮ НЕ НАЧИНАМЕМ если true то начинаем работать
                        if (РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию == true) {


                            //TODO запукаем метод аунтификции
                            МетодАунтификацииПользователяПриВходевПрограммуДСУ1(v);//// данный метод в будущем будет запускаться с  кнопк


/////////TODO ошибка не найден ни локальный не интренет сервер
                        } else {


                            //TODO ЗАПУСКАЕМ ФУТУРЕ

                            ПрогрессБарДляВходаСистему.setVisibility(View.VISIBLE);// при нажатии делаем видимый програсссбар

                            ///TODO после синхронизации ПОКАЗЫВАЕМ ПОЛЬЗОВАТЕЛЮ ЧТО КОЛИЧЕСТОВ УСПЕШНЫХ ВСТАВОК И ОБНОВЕЛЕНИЙ СИНХРОНИЗАЦИИ В ФОНЕ


                            Snackbar.make(v, "Установленный режим сети не позволяет обмен данными !!! ", Snackbar.LENGTH_LONG).show();

                            try {
                                TimeUnit.MILLISECONDS.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            //TODO ЗАПУСКАЕМ ФУТУРЕ
                            ПрогрессБарДляВходаСистему.setVisibility(View.INVISIBLE);// по умолчанию прогресс бар делаем не видеым


                        }////end проверки если сеть или нет TRUE


                        //TODO ОШИБКА КОГДА ВЫ КАК ПОЛЬЗОВАТЕЛЬ НЕ ВПИСАЛИ  ИМЯ И ПАРОЛЬ ДЛЯ АУНДИФИКАЦИИ
                    } else {
                        //TODO ЗАПУСКАЕМ ФУТУРЕ

                        ПрогрессБарДляВходаСистему.setVisibility(View.VISIBLE);// при нажатии делаем видимый програсссбар
                        /////
                                      /*  Toast aa = Toast.makeText(КонтекстСинхроДляАунтификации, "OPEN",Toast.LENGTH_SHORT);
                                        ImageView cc = new ImageView(КонтекстСинхроДляАунтификации);
                                        cc.setImageResource(R.drawable.icon_dsu1_error_antrficar_users);//icon_dsu1_synchronisazia_dsu1_success
                                        aa.setView(cc);
                                        aa.show();*/

                        ////////
                        // Toast.makeText(getApplicationContext(), "Вы не заполнили Имя/Пароль (заполните все поля и попробуйте еще раз ) !!! ", Toast.LENGTH_SHORT).show();

                        Snackbar.make(v, "Вы не заполнили Имя/Пароль (заполните все поля и попробуйте еще раз !!! )", Snackbar.LENGTH_LONG).show();

                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // TODO: 02.09.2021  посылаем визуал
                        ПрогрессБарДляВходаСистему.setVisibility(View.INVISIBLE);// по умолчанию прогресс бар делаем не видеым

                    }
                }
            });

        } catch (Exception e) {
            ///метод запись ошибок в таблицу
            ПодсчетОтрицательныйРезультатовАунтификации++;///подсчитываем ошибки для точго чтобы приложение пошло спать
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " ПодсчетОтрицательныйРезультатовАунтификации " + ПодсчетОтрицательныйРезультатовАунтификации);
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    ////TODO САМ МЕТОД АУНТИФИКАЦИИ С СЕРВЕРОМ
    private void МетодАунтификацииПользователяПриВходевПрограммуДСУ1(View v) {

        Class_GRUD_SQL_Operations class_grud_sql_operationsАунтификацияПользователя=new Class_GRUD_SQL_Operations(getApplicationContext());

        try {
            //////
            final StringBuffer[] БуферУПолученныйРезультатОтСевлетаДляАунтификации = {new StringBuffer()};


            //////TODO Запуск асинхроного ЛОУДОРА ДЛЯ АУНТИФТИКАЦИИ ПОЛЬЗОВАТЕЛЯ
            class_grud_sql_operationsАунтификацияПользователя.asyncTaskLoaderАунтификацияПользователя
                    = new AsyncTaskLoader(КонтекстСинхроДляАунтификации) {

                HttpURLConnection ПодключениекСерверуДляАунтификацииПользователяПриВходе = null;
                ////////
                String ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = null;


                @Override
                protected void onStartLoading() {
                    super.onStartLoading();
                    ///////
                    ПрогрессБарДляВходаСистему.setVisibility(View.VISIBLE);// по умолчанию прогресс бар делаем не видеым
                    ////////
                    Log.d(this.getClass().getName(), " onStartLoading() asyncTaskLoaderАунтификацияПользователя ");

                    ////TODO запускаем BACkground

                    forceLoad();
                }


                @Nullable
                @Override
                public Object loadInBackground() {

                    StringBuffer ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя = new StringBuffer();

                    BufferedReader БуферПодключениеJSONВерсияSQlserver = null;

                    CipherInputStream GZIPПотокаДляОтправкиНаСервер = null;
                    try {
                        Log.d(this.getClass().getName(), " loadInBackground() asyncTaskLoaderАунтификацияПользователя ");

                        /////

                        // URL  Adress = new URL("http://192.168.254.40:8080/dsu1.glassfish/DSU1JsonServlet"+"?" + "ЗаданиеДляСервлетаВнутриПотока=Хотим Получить ID для Генерации  UUID"); ///ДАННАЯ ССЛЫКА ДЛЯ ПОДКЛЮЧЕНИЯ СВЯЗИ

                        LinkedBlockingDeque<String> linkedBlockingDequeОчередьПодключениюКСерверу = new LinkedBlockingDeque<String>();



                      //  if (PUBLIC_CONTENT.Отладка == false) {//TODO FALSE  ЭТО  РЕЛИЗ


                            //// TODO РЕЛИЗ
                         linkedBlockingDequeОчередьПодключениюКСерверу.add("http://tabel.dsu1.ru:8888/");





                            //// TODO РЕЛИЗ
                            //
                            /////
                    //       linkedBlockingDequeОчередьПодключениюКСерверу.add("http://192.168.254.40:8080/");




                        ////


                        // TODO: 24.08.2021 потокобезопасным цалом рутим данные


                        Iterator spliteratorДляПингаСети = linkedBlockingDequeОчередьПодключениюКСерверу.iterator();

                        ///
                        while (spliteratorДляПингаСети.hasNext()) {

                            String ТекущийАдресСервераДляПинга = new String();

                            try {
                                ТекущийАдресСервераДляПинга = (String) spliteratorДляПингаСети.next();


                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                            //////TODO --операции




                            СтрокаСвязиСсервером = ТекущийАдресСервераДляПинга + "dsu1.glassfish/DSU1JsonServlet" + "?"///      String СтрокаСвязиСсервером=PUBLIC_CONTENT.ПубличныйАдресGlassFish + "dsu1.glassfish/DSU1JsonServlet" + "?"
                                    + "ЗаданиеДляСервлетаВнутриПотока=Хотим Получить ID для Генерации  UUID";

                            // TODO: 24.08.2021
                            СтрокаСвязиСсервером = СтрокаСвязиСсервером.replace(" ", "%20");
                            ///
                            Log.d(this.getClass().getName(), " СтрокаСвязиСсервером " +СтрокаСвязиСсервером);


                     /*   String СтрокаСвязиСсервером=  "http://192.168.254.40:8080/" + "dsu1.glassfish/DSU1JsonServlet" + "?"///      String СтрокаСвязиСсервером=PUBLIC_CONTENT.ПубличныйАдресGlassFish + "dsu1.glassfish/DSU1JsonServlet" + "?"
                                + "ЗаданиеДляСервлетаВнутриПотока=Хотим Получить ID для Генерации  UUID";*/


                            URL Adress = new URL(СтрокаСвязиСсервером); //
                            ////////

                            ///
                            ПодключениекСерверуДляАунтификацииПользователяПриВходе = null;
                            /////////////
                            ПодключениекСерверуДляАунтификацииПользователяПриВходе = (HttpURLConnection) (Adress).openConnection();/////САМ ФАЙЛ JSON C ДАННЫМИ

                            //

                        //    ПодключениекСерверуДляАунтификацииПользователяПриВходе.setDoInput(true);

                         //   ПодключениекСерверуДляАунтификацииПользователяПриВходе.setDoOutput(true);


                            ПодключениекСерверуДляАунтификацииПользователяПриВходе.setRequestProperty("Content-Type", "application/text; charset=UTF-8");

                            ПодключениекСерверуДляАунтификацииПользователяПриВходе.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");

                            ПодключениекСерверуДляАунтификацииПользователяПриВходе.setRequestProperty("Connection", "Keep-Alive");

                            ПодключениекСерверуДляАунтификацииПользователяПриВходе.setRequestProperty("Accept-Language", "ru-RU");

                            ПодключениекСерверуДляАунтификацииПользователяПриВходе.setRequestMethod("GET"); ////GET //ПРОВЕРЯЕМ ЕСЛИ ПОДКЛЮЧЕНИЕ К СЕВРЛЕТУ С АНДРОЙДА НА SQL SERVER

                            ПодключениекСерверуДляАунтификацииПользователяПриВходе.setReadTimeout(10000); //todo чтение потока до 5 секунд

                            ПодключениекСерверуДляАунтификацииПользователяПриВходе.setConnectTimeout(10000);//todo таймайт подключение к самому серверу если вообще подключения

                            ПодключениекСерверуДляАунтификацииПользователяПриВходе.setUseCaches(true);
                            ////////

                            Log.d(this.getClass().getName(), " ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя  " + ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя);


                            // TODO: 11.11.2021  ПЕРЕДОТПРАВКОЙ ШИФРУЕМ ДАННЫЕ \

                            String ЗашифрованныйЛогин=new Class_Encryption_Decryption_Login_Password(getApplicationContext()).МетодПреобразованиеBase64Данных(ПубличноеИмяПользовательДлСервлета);



                            Log.d(this.getClass().getName(), " ЗашифрованныйЛогин  " + ЗашифрованныйЛогин);


                            // TODO: 12.11.2021 ППЕРОБРАЗОВАНИЯ ПАРОЛЬЯ ЧЕРЕЗ BASE64 ПАРОЛЯ ВАРИАНТ 1


                            String ЗашифрованныйПароль=new Class_Encryption_Decryption_Login_Password(getApplicationContext()).МетодПреобразованиеBase64Данных(ПубличноеПарольДлСервлета);



                            Log.d(this.getClass().getName(), " ЗашифрованныйПароль  " + ЗашифрованныйПароль);




                            // TODO: 12.11.2021 КАШИРОВАНИЯ ПАРОЛЯ ВАРИАНТ 2



               /*         String ЗашифрованныйПароль=new Class_Encryption_Decryption_Login_Password(contextСозданиеБАзы).МетодКешированиеДанных(ПубличноеПарольДлСервлета);



                        Log.d(this.getClass().getName(), " ЗашифрованныйПароль  " + ЗашифрованныйПароль);*/



                            /////// TODO set login pasword
                            ПодключениекСерверуДляАунтификацииПользователяПриВходе.setRequestProperty("p_identifier",
                                    ЗашифрованныйПароль);  //"dsu1getsession"
                            ////Dalvik/2.1.0 (Linux; U; Android 7.0; Android SDK built for x86 Build/NYC)


                            ///////посылаем сашифрованные хэдэры
                            ПодключениекСерверуДляАунтификацииПользователяПриВходе.setRequestProperty("identifier",
                                    ЗашифрованныйЛогин  );  //"dsu1getsession"   ПубличноеИмяПользовательДлСервлета






                            Log.d(this.getClass().getName(), "  ПубличноеИмяПользовательДлСервлета  " + ПубличноеИмяПользовательДлСервлета + "\n" +
                                    " ПубличноеПарольДлСервлета    " + ПубличноеПарольДлСервлета);


                            if (ПубличноеИмяПользовательДлСервлета.length()>0 && ПубличноеПарольДлСервлета.length()>0) {
                                //


                                try {

                                    ПодключениекСерверуДляАунтификацииПользователяПриВходе.connect(); /////////////ТОЛЬКО СОЕДИНЕНИЕ
                                    // ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode();///ВАЖНАЯ КОМАНДА  СТУЧИТЬСЯ В СЕРВЛЕТ ECLIPSE СТУЧИМСЯ ВТОРОЙ РАЗ ЧТОБЫ ПОЛУЧИТЬ УЖЕ САМ JSON////РЕАЛЬНОЕ ПОЛУЧЕНИЕ ДАННЫХ С ИНТРЕНЕТА
                                    ////СТУЧИМЬСЯ В СЕРВЛЕТ


                                    ///todo ping
                                    ПодключениекСерверуДляАунтификацииПользователяПриВходе.getContent(); ////РЕАЛЬНОЕ ПОЛУЧЕНИЕ ДАННЫХ С ИНТРЕНЕТА




                                    Log.d(this.getClass().getName(), "ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе "
                                            + ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе);

                                    //todo EXIT
                                    break;

                                } catch (IOException e) {
                                    e.printStackTrace();
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = e.toString();

                                    Log.d(this.getClass().getName(), "ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе "
                                            + ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе);


                                }
                            }


                            // TODO: 24.08.2021 удаление из очериди
                            linkedBlockingDequeОчередьПодключениюКСерверу.peek();
                            // TODO: 13.08.2021  результа от севрера получаем публичный ID*/

                        }


                        // TODO: 13.10.2021  РЕЗУУЛЬТАТ ОТВЕТА ОТ СЕРВЕРА ЛОГИНАИ ПАРОЛЯ




                        Log.d(this.getClass().getName(), "ПодключениекСерверуДляАунтификацииПользователяПриВходе.getContentLength() "
                                + ПодключениекСерверуДляАунтификацииПользователяПриВходе.getHeaderField("stream_size"));

                        Long РазмерПришедшегоПотока = Long.parseLong(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getHeaderField("stream_size"));

                        Log.d(this.getClass().getName(), "РазмерПришедшегоПотока " + РазмерПришедшегоПотока);


                        //todo цикл
                        do {///В ТАБЛИЦЕ КОТОРАЯ ПРИШЛА С SQL SEVER ПЕРЕРБИРАЕМ
                            /////ПОЛУЧАЕМ ЦИФРОВУЮ ВЕРСИЮ  ИМЕНИ ПОЛЬЗЛВАТЕЛЯ ВВ ИДЕ ЦИРЫ С SQL SERVERs
                            if (ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode() == 200 &&
                                    РазмерПришедшегоПотока > 0) {/////ЗАХОДИМ В ФАЙЛ ТОЛЬКО КОГДА НЕТ ОШИБКОВ В ПОТОКА ОТ SQL SEVER
                                //TODO шифровани
                                GZIPПотокаДляОтправкиНаСервер = new CipherInputStream(
                                        new GZIPInputStream(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getInputStream()), ПолитикаРасшифровки);

                                ////TODO буфера проверки пользователя
                                БуферПодключениеJSONВерсияSQlserver = new BufferedReader(new InputStreamReader(
                                        GZIPПотокаДляОтправкиНаСервер,
                                        StandardCharsets.UTF_16));
                                //////


                                ///TODO цикл получение
                                //  final char[] buffer = new char[8192];//1024//8192
                                final char[] buffer = new char[1024];//1024
                                int n;
                                ////TODO цикл
                                while ((n = БуферПодключениеJSONВерсияSQlserver.read(buffer)) > 0) {

                                    /// String ЛинияБуфераРеадер=РидерОтСервераМетодаGET.readLine();
                                    //////////////exit

                                    // TODO: 14.05.2021 получаем данные с сервера

                                    // TODO: 03.06.2021 заполение данными от сервер аот на положительные вставки и обновление
                                    ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя.append(buffer, 0, n);

                                    /////НАЗВАНИЕ ПОТОКА
                                    Log.i(this.getClass().getName(), "НАЗВАНИЕ ПОТОКА В aSYNSTASKПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя "
                                            + Thread.currentThread().getName().toUpperCase() + " ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя "
                                            + ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя.toString());

                                }


                                /////////////САМ ЦИКЛ ЗАПОЛЕНИЯ ИЗ JSON В СТРОКИ

                                //
                                if (ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя.length() > 0) {

                                    Log.d(this.getClass().getName(), " ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя"
                                            + ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя);


                                    ////TODO ДАННЫЙ КОД ОПРЕДЕЛЯЕТ ПРИСЛАЛ ЛИ ОШИБКУ СЕРВЕР НА НЕПРАВИЛЬНЫЙ И ПОЛНОСТЬ ОТСУТВУЮЩИЕ ДАННЫЕ ПОЛЬЗОВАТЕЛЯ, КОТОРЫЙ ХОТЕЛ ЗАЙТИ В  СИСТЕМУ
                                    if (!ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя.toString().trim().equalsIgnoreCase("Вы не прошли Аунтификацию (для вас данных нет)") &&

                                            !ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя.toString().trim().equalsIgnoreCase("True")) {


                                        // TODO: 21.04.2021 успешная унфтикация


                                       ПубличноеIDПолученныйИзСервлетаДляUUID =Integer.parseInt(ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя.toString());

                                        ///ИЗ ОТВЕТА ПОЛУЧАЕМ ID ПОЛЬЗОВАТЕЛЯ ДЛЯ ГЕНЕРАЦИИ  UUID//
                                        Log.d(this.getClass().getName(), "  ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя "
                                                + ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя + "  ПубличноеIDПолученныйИзСервлетаДляUUID " +ПубличноеIDПолученныйИзСервлетаДляUUID);

                                        ///
                                        БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].append(ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя);
                                        ////////
                                        Log.d(this.getClass().getName(), " БуферУПолученныйРезультатОтСевлетаДляАунтификации " + БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].toString());


                                        Integer ПолученинныйПубличныйIDДлчЗаписиВБАзу=Integer.parseInt(БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].toString());
                                        ////////
                                        Log.d(this.getClass().getName(), " ПолученинныйПубличныйIDДлчЗаписиВБАзу " +ПолученинныйПубличныйIDДлчЗаписиВБАзу);
                                        //todo метод после успешной аунтифтфикации записываем саупешное получение данных в базу после успешного вписаниеи пароля и логина


                                        МетодПослеУспешнойАунтификацииЗаписиваемИзменияВБАзуВДвеТаблицы_successlogin_И_Дополнительно_И_таблицуsettings_tabels(ПолученинныйПубличныйIDДлчЗаписиВБАзу);







                                        ////////
                                        Log.d(this.getClass().getName(), " БуферУПолученныйРезультатОтСевлетаДляАунтификации " + БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].toString());





                                        //todo  ERROR USERNAME ответ от сервера когда имя не правильно и аунтифкаумя НЕ ПРОШЁЛ ПОЛЬЗОВАТЕЛЬ И ВЫХОМ ИЗ WHILE  ЦИКЛА
                                    } else {




                                        ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя.toString();
                                        /////////
                                        ПодсчетОтрицательныйРезультатовАунтификации++;///подсчитываем ошибки для точго чтобы приложение пошло спать
                                        // TODO: 10.09.2021  РЕЗУЛЬТАТ ЗАПИСИ СОТРУДНИКА ЗАПИСИ В БАЗУ
                                        Log.d(this.getClass().getName(), " ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе "
                                                +ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе);

                                        Toast.makeText(activity, "  Вы не прошли Аунтификацию c cервером (для вас данных нет) " , Toast.LENGTH_LONG).show();


                                        break;
                                        ////  && !ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя.trim().equalsIgnoreCase("Вы не прошли Аунтификацию (для вас данных нет)"))
                                    }
                                }


                                //TODO BufferedReader api 23 чтение данных сервера

                            }

                            ///TODO

                        } while (ПроверкаПришёлЛиОтветОтСервлетаДляАунтификацииПользователя.length() == 0);/////конец for # количество респонсев
                        ///////
                        Log.d(this.getClass().getName(), " БуферУПолученныйРезультатОтСевлетаДляАунтификации " + БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].toString());


                        if (GZIPПотокаДляОтправкиНаСервер != null) {
                            ///
                            GZIPПотокаДляОтправкиНаСервер.close();
                        }

                        if (БуферПодключениеJSONВерсияSQlserver != null) {
                            /////
                            БуферПодключениеJSONВерсияSQlserver.close();
                        }


                        /////TODO визуализация решения по аунтификац ии  серверу

                        ////TODO визуализация подключение к серверу и его визуализация
                        ////TODO ВЫКИДЫВАЕМ




                        Log.w(this.getClass().getName(), "ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode() "
                                + "       ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе"+     ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе );


                        if (ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode() != 200) {


                            ПодсчетОтрицательныйРезультатовАунтификации++;///подсчитываем ошибки для точго чтобы приложение пошло спать

                            // TODO: 01.09.2021  метод оправки ошибок на почту

                            МетодОтправкиОшибокНаПочту();
                        }





                        //TODO ЗАПУСКАЕМ ФУТУРЕ
                        МетодВизуализацииПоложительныхИлиОтрицательныхПопытокАунтификации(v);


                        // TODO: 03.10.2021   close




                        //
                        //ПодключениекСерверуДляАунтификацииПользователяПриВходе.disconnect();

                    } catch (Exception e) {




                        Log.w(this.getClass().getName(), "ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode() "
                                + "       ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе"+     ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе );
                        ///метод запись ошибок в таблицу
                        ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = e.toString();
                        //////////TODO когда ошибка то увеличичваем счетчик ошибок
                        ПодсчетОтрицательныйРезультатовАунтификации++;///подсчитываем ошибки для точго чтобы приложение пошло спать
                        ////
                        // TODO: 01.09.2021  метод оправки ошибок на почту



                        try{


                            if (!ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе.trim().equalsIgnoreCase(  "java.lang.NumberFormatException: null")) {
                                if(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode()==500){
                                    ///
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "внутренняя ошибка сервера !!!";


                                }else if(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode()==502){
                                    //
                                    ///
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "неверный шлюз !!!";

                                }else if(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode()==400){
                                    //
                                    ///
                                    ///
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "неверный запрос !!!";

                                }else if(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode()==408){
                                    //
                                    ///
                                    ///
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "  Тайм-аут запроса !!!";

                                }else if(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode()==409){
                                    //
                                    ///
                                    ///
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "  конфликт запроса !!!";

                                }else if(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode()==413){
                                    //
                                    ///
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "  слишком большой объект запроса !!!";

                                }else if(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode()==204){
                                    //
                                    ///
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "  нет содержимого !!!";

                                }   else if(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode()==404){
                                //
                                    ///
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "  не найден !!!";

                            }else if(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode()==406){
                                    //
                                    ///
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "  неприемлемо !!!";

                                }else if(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode()==414){
                                    //
                                    ///
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "  слишком большой URI запроса !!!";

                                } else if(ПодключениекСерверуДляАунтификацииПользователяПриВходе.getResponseCode()==-1){
                                //
                                ///
                                ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "  нет связи с сервером !!!";

                            }else
                                {

                                    ///
                                    ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "  нет связи с сервером !!!";
                                }
                            }else{



                                ///
                                ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = "  нет связи с сервером !!!";

                            }


                            ///todo публикум название таблицы или цифру его
                    } catch (Exception ex) {
                        //  Block of code to handle errors
                        ex.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }





                    //  ПодключениекСерверуДляАунтификацииПользователяПриВходе.disconnect();
                        //
                        if (ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе.length() > 0) {

                            // TODO: 01.09.2021  метод оправки ошибок на почту


                            Snackbar snackbar = Snackbar.make(v, ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе +
                                    "(" +"\n" +   ПубличноеИмяПользовательДлСервлета.trim()+ "::" +ПубличноеПарольДлСервлета.trim()+") ", Snackbar.LENGTH_LONG);
                            snackbar.show();


                       ///     МетодОтправкиОшибокНаПочту();

                        }


                        //TODO ПОСЛЕ ПИНГА ВИЗУАЛИЗАЦИЯ
                        МетодВизуализацииПоложительныхИлиОтрицательныхПопытокАунтификации(v);




                        /////todo данный код когда имя и пароль не правильны
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber() + " ПодсчетОтрицательныйРезультатовАунтификации " + ПодсчетОтрицательныйРезультатовАунтификации);
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }


                    /////todo ВЫХОД ПОСЛЕ РАБОТЫ BACKGRAUNG

                    /////
                    return БуферУПолученныйРезультатОтСевлетаДляАунтификации[0];  ///ПодсчетОтрицательныйРезультатовАунтификации
                }










                private void МетодПослеУспешнойАунтификацииЗаписиваемИзменияВБАзуВДвеТаблицы_successlogin_И_Дополнительно_И_таблицуsettings_tabels(Integer ПолученинныйПубличныйIDДлчЗаписиВБАзу ) throws ExecutionException, InterruptedException {
                    //// todo после успешного получение имени и пароля записываем их в базу ЗАПУСК МЕТОДА ВСТАВКИ ИМЕНИ И ПАРОЛЯ ПРИ АУНТИФИКАЦИИ БОЛЕЕ 7 ДНЕЙ


                    try{

                    ContentValues contentValuesДляУспешнойВставкиПароляБолее7ДнейЗаписываемВБАзуВТаблицу_successlogin=new ContentValues();

                        contentValuesДляУспешнойВставкиПароляБолее7ДнейЗаписываемВБАзуВТаблицу_successlogin.put("id", ПолученинныйПубличныйIDДлчЗаписиВБАзу);
                    ///
                        contentValuesДляУспешнойВставкиПароляБолее7ДнейЗаписываемВБАзуВТаблицу_successlogin.put("success_users", ПубличноеИмяПользовательДлСервлета);
                    ///
                    ///
                        contentValuesДляУспешнойВставкиПароляБолее7ДнейЗаписываемВБАзуВТаблицу_successlogin.put("success_login",ПубличноеПарольДлСервлета);


                    Log.d(this.getClass().getName(), " ПубличноеИмяПользовательДлСервлета "
                            + ПубличноеИмяПользовательДлСервлета +
                            " ПубличноеПарольДлСервлета" + ПубличноеПарольДлСервлета);


                    ////TODO ДАТА
                    String ДатаДЛяОчисткиИВстсвкиИмениИПароль=     new Class_Generation_Data(getApplicationContext()).ГлавнаяДатаИВремяОперацийСБазойДанных();

                    ///
                        contentValuesДляУспешнойВставкиПароляБолее7ДнейЗаписываемВБАзуВТаблицу_successlogin.put("date_update", ДатаДЛяОчисткиИВстсвкиИмениИПароль);


                    // TODO: 29.12.2021  запись в  полученого публичного клюяа в две таблицы suceess login  и таблицу настроеки   ПЕРВАЯ ЧАСТЬ ОПЕРАЦИИ








                    //// todo после успешного получение имени и пароля записываем их в базу ЗАПУСК МЕТОДА ВСТАВКИ ИМЕНИ И ПАРОЛЯ ПРИ АУНТИФИКАЦИИ БОЛЕЕ 7 ДНЕЙ
                    Long результатЗаписиНовогоПароляПользователявБазцуsuccesslogin = (Long)
                            new Class_Begin_Update_End_Insert_Data_Project(getApplicationContext()).
                                    МетодСначалоПытаемсяОбновлитьЕслиНеВышлоВставляемДанныхПроекта("SuccessLogin",
                                            contentValuesДляУспешнойВставкиПароляБолее7ДнейЗаписываемВБАзуВТаблицу_successlogin,
                                            ПолученинныйПубличныйIDДлчЗаписиВБАзу ,"id");
                    ////ЗАПУСК МЕТОДА ВСТАВКИ ИМЕНИ И ПАРОЛЯ ПРИ АУНТИФИКАЦИИ БОЛЕЕ 7 ДНЕЙ


                    // TODO: 10.09.2021  РЕЗУЛЬТАТ ЗАПИСИ СОТРУДНИКА ЗАПИСИ В БАЗУ
                    Log.d(this.getClass().getName(), " БуферУПолученныйРезультатОтСевлетаДляАунтификации "
                            + БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].toString() +
                            " УСПЕШАЯ ЗАПИСЬ ПУБЛИЧНОГО id SUCCEESS !!!!  ТАБЛИЦА successlogin  " +
                            "результатЗаписиНовогоПароляПользователявБазцуsuccesslogin " + результатЗаписиНовогоПароляПользователявБазцуsuccesslogin+
                            " ПолученинныйПубличныйIDДлчЗаписиВБАзу " +ПолученинныйПубличныйIDДлчЗаписиВБАзу);


                    // TODO: 29.12.2021  ВТОРАЯ ЗАПИСЬ В ДРУГУЮ ТАБЛИЦУ ТАБЛИЦА НАСТРОЕК ВТОРАЯ ЧАСТЬ ОПЕРАЦИИ


                        contentValuesДляУспешнойВставкиПароляБолее7ДнейЗаписываемВБАзуВТаблицу_successlogin.clear();















                    if (результатЗаписиНовогоПароляПользователявБазцуsuccesslogin>0) {
//////



                        /// TODO: 22.02.2022

                        Long РезультатЗаписиНовгоIDБАзуВТаблицеНАСТРОЕКПОЛЬЗОВТЕЛЯ_ДЛяЗАПИСИВТаблицу_settings_tabels=
                                new Class_MODEL_synchronized(getApplicationContext()).МетодЗАписиПолученогоОтСервреаIDПубличногоВТАблицу_settings_tabels(
                                        ПолученинныйПубличныйIDДлчЗаписиВБАзу);


                        // TODO: 10.09.2021  РЕЗУЛЬТАТ ЗАПИСИ СОТРУДНИКА ЗАПИСИ В БАЗУ
                        Log.d(this.getClass().getName(), " БуферУПолученныйРезультатОтСевлетаДляАунтификации "
                                + БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].toString() +
                                " УСПЕШАЯ ЗАПИСЬ ПУБЛИЧНОГО id SUCCEESS !!!!  " +
                                "ТАБЛИЦА settings_tabels  РезультатЗаписиНовгоIDБАзуВТаблицеНАСТРОЕКПОЛЬЗОВТЕЛЯ_ДЛяЗАПИСИВТаблицу_settings_tabels "
                                + РезультатЗаписиНовгоIDБАзуВТаблицеНАСТРОЕКПОЛЬЗОВТЕЛЯ_ДЛяЗАПИСИВТаблицу_settings_tabels+
                                " ПолученинныйПубличныйIDДлчЗаписиВБАзу " +ПолученинныйПубличныйIDДлчЗаписиВБАзу);
                    }





                    ////
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    // TODO: 01.09.2021 метод вызова
                    new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                }

                }


                // TODO: 01.09.2021  метод отпрвки ошибок на почту

                private void МетодОтправкиОшибокНаПочту() {
                    /////////

                    try {
                        Log.d(this.getClass().getName(), "   БуерДляОшибок" + ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе.toString());
                        ////
                        StringBuffer БуферОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = new StringBuffer(ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе);


                        БуферОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе.append("\n")
                                .append(" имя пользователь : ")
                                .append(ПубличноеIDПолученныйИзСервлетаДляUUID).append(" логин пользователь : ")
                                .append(ПубличноеИмяПользовательДлСервлета).append(" время: ").append(new Date());

                        // TODO: 01.09.2021 ПОСЫЛАЕМ ОШИБКИ СИСТМЕНУМО АДМИНИСТАТОРУ

                        new Class_Sendiing_Errors(activity).МетодПослываемОшибкиАдминистаторуПо(БуферОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе, activity);


                        //////

                    } catch (Exception e) {
                        e.printStackTrace();
///метод запись ошибок в таблицу
///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());

                        // TODO: 01.09.2021 метод вызова
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }


                }


                ///todo метод визуализацци успешных и не успешных аунтифиуаци пользоватле
                private void МетодВизуализацииПоложительныхИлиОтрицательныхПопытокАунтификации(View v) {

                    MainActivity_Tabels_Users_And_Passwords.this.runOnUiThread(new Runnable() {
                        public void run() {


                            Log.d(this.getClass().getName(), " handlerВизуализацияАунтификации ");
                            try {
                                ПрогрессБарДляВходаСистему.setVisibility(View.VISIBLE);// по умолчанию прогресс бар делаем не видеым
                                /////
                                ПрогрессБарДляВходаСистему.setProgress(ПодсчетОтрицательныйРезультатовАунтификации);
///ОШИБКИ

                                Log.d(this.getClass().getName(), " ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе " + ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе
                                        + " БуферУПолученныйРезультатОтСевлетаДляАунтификации.length() " + БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].length());

                                ///todo В ЗАВИССИМОСТИ КАКОЙ РЕЗЗУЛЬТАТ ЗАПУСКАЕМ ИЛИ НЕТ ЗАХОД В ПРОГРАММУ ПРИ НАЛИЧИИ ОШИБОК

                                if (ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе != null
                                        && БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].length() == 0) {////полученный результат обрабатываем для принятия решения прошел ли пользователь аунтификацию
////////посылаем приложенее поспать
///TODO КОГДА 4 ПОПЫТКИ ПРОШЛИ НЕ УСПЕШНО И МЫ ЗАСЫВАЕМ ПРИЛОЖЕНИЯ НА 30 СЕКУНД
                                    if (ПодсчетОтрицательныйРезультатовАунтификации > 4) {////ПОПЫТКИ НЕ УДАЧНОГО ВХОДА В ПРОГРАММУ СВЫШЕ 5  СООБШАЕМ ПОЛЬЗОВАТЛЮ ЧТО ЕГО ИММ ЯИ ИЛИ ПАРОЛЬ НЕ ПРАВИЛЬНЫЙ И ПРИЛОЖЕНИЕ ОПРАЫЛЕМ В СОН
//  Toast.makeText(getApplicationContext(), "Привышен лимит попыток подключения"+"\n"+" (попробйте через ..... 30 секунд )", Toast.LENGTH_LONG).show();
/////

                                        ПодсчетОтрицательныйРезультатовАунтификации = 0;

                                        /////todo два компонета делаем их не видимые
///TODO  метод засыпания ПОТОК

                                        ///todo В ДАННОМ МЕСТЕ НУДЕН ДЛЯ ПОСЛЕДОВАТЕЛЬНОЙ ВИЗАУЛИЗАЦИИ ПРОГРЕССБАРА И tOAST УВИДОМЕЛНИЯ
                                                System.out.println("Another thread was executed");


                                                //TODO ЗАПУСКАЕМ ФУТУРЕ
                                                MainActivity_Tabels_Users_And_Passwords.this.runOnUiThread(new Runnable() {
                                                    public void run() {

                                                        ПрогрессБарДляВходаСистему.setVisibility(View.VISIBLE);// при нажатии делаем видимый програсссбар

                                                        try {
                                                            TimeUnit.SECONDS.sleep(10);
                                                        } catch (InterruptedException e) {
                                                            e.printStackTrace();
                                                        }






                                                            ((Activity) КонтекстСинхроДляАунтификации).runOnUiThread(new Runnable() {
                                                                @Override
                                                                public void run() {


                                                                    ПрогрессБарДляВходаСистему.setVisibility(View.INVISIBLE);// по умолчанию прогресс бар делаем не видеым
                                                                    /////
                                                                    Toast aa = Toast.makeText(КонтекстСинхроДляАунтификации, "OPEN", Toast.LENGTH_SHORT);
                                                                    ImageView cc = new ImageView(КонтекстСинхроДляАунтификации);
                                                                    cc.setImageResource(R.drawable.icon_dsu1_error_antrficar_users);//icon_dsu1_synchronisazia_dsu1_success
                                                                    // aa.setView(cc);
                                                                    //   aa.show();
                                                                    ///
                                                          /*          Toast.makeText(getApplicationContext(), " Логин и Пароль неправильные ( сон на 10 секунд.....)"
                                                                            + " \n" + " Попробуйте еще раз ", Toast.LENGTH_SHORT).show();*/

                                                                    //

                                                                  Snackbar.make(v, " Логин и Пароль неправильные ( сон на 10 секунд.....)", Snackbar.LENGTH_LONG).show();



                                                                    // TODO: 13.10.2021


                                                                    Handler handlerотпракаОшиобокНапочту=new Handler();
                                                                    ///
                                                                    handlerотпракаОшиобокНапочту.postDelayed(new Runnable() {
                                                                        @Override
                                                                        public void run() {
                                                                            ///  Отправка Ошибок НАпочту
                                                                            МетодОтправкиОшибокНаПочту();

                                                                            //

                                                                            Snackbar.make(v, " Отправка Ошибок на Почту", Snackbar.LENGTH_LONG).show();

                                                                        }
                                                                    },5000);



                                                                }
                                                            });



                                                    }
                                                });





///todo показываем кнопку послу засыпания процесса аунтификации


///TODO КОГДА ПРОСТО ИМЯ И ПАРОЛЬ НЕ ПОДХОДЯТ меньше 5 ошибок
                                    } else {////ПОПЫТКИ НЕ УДАЧНОГО ВХОДА В ПРОГРАММУ ДО 5 ПРОСТО СООБШАЕМ ПОЛЬЗОВАТЛЮ ЧТО ЕГО ИММ ЯИ ИЛИ ПАРОЛЬ НЕ ПРАВИЛЬНЫЙ

                                        Log.d(this.getClass().getName(), " ПодсчетОтрицательныйРезультатовАунтификации " + ПодсчетОтрицательныйРезультатовАунтификации);
                                        //TODO ЗАПУСКАЕМ ФУТУРЕ
                                        MainActivity_Tabels_Users_And_Passwords.this.runOnUiThread(new Runnable() {
                                            public void run() {

                                                Toast aa = Toast.makeText(КонтекстСинхроДляАунтификации, "OPEN", Toast.LENGTH_SHORT);
                                                ImageView cc = new ImageView(КонтекстСинхроДляАунтификации);
                                                cc.setImageResource(R.drawable.icon_dsu1_error_antrficar_users);//icon_dsu1_synchronisazia_dsu1_success
                                                aa.setView(cc);
                                                //  aa.show();

                                                ///////TODO
                                                if (ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе.equalsIgnoreCase("True")) {


                                                    Snackbar snackbar = Snackbar.make(v, "Логин/Пароль правильное"
                                                            +"\n" +  ПубличноеИмяПользовательДлСервлета.trim()+ "," +ПубличноеПарольДлСервлета.trim()+")"+"\n"+" "
                                                            +ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе , Snackbar.LENGTH_LONG);
                                                    snackbar.show();



                                                } else{


                                                    Snackbar snackbar = Snackbar.make(v, ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе
                                                            +"\n" +  ПубличноеИмяПользовательДлСервлета.trim()+ "," +ПубличноеПарольДлСервлета.trim()+")"+"\n", Snackbar.LENGTH_LONG);
                                                    snackbar.show();



                                                }

// TODO: 21.04.2021 Сообщение о неправильные ошибвки при входе сообшеение
                                                /*Toast.makeText(getApplicationContext(), "Нет Входа: "

                                                        + " ( Лимит 4 попытки.  ) " + ПодсчетОтрицательныйРезультатовАунтификации+
                                                        "\n" + ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе, Toast.LENGTH_SHORT).show();
                                                Log.d(this.getClass().getName(), "  ПодсчетОтрицательныйРезультатовАунтификации " + ПодсчетОтрицательныйРезультатовАунтификации);*/

                                                ПрогрессБарДляВходаСистему.setVisibility(View.INVISIBLE);// по умолчанию прогресс бар делаем не видеым


                                                /*Toast.makeText(getApplicationContext(), " Запуск  startForegroundService  BroadcastReceiver" +new Date()  , Toast.LENGTH_LONG).show();*/

                                                Log.w(this.getClass().getName(), " Ошибка  имя  и пароль   ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе "
                                                        + ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе);





                                            }
                                        });
                                    }


//////TODO УСПЕХ ИМЯ И ПАРОЛЬ ЕСТЬ


                                    Log.d(this.getClass().getName(), " Пришёл ID от СЕРВЕРА  БуферУПолученныйРезультатОтСевлетаДляАунтификации.length()" + БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].length());
////// TODO ПРИ УСПЕШНОЙ АУНТИФИКАЦИИ БЕЗ ОШИБОЧНОЙ И СОВПАДЕНИИ И МЕНИ  И ПАРОЛЯ ЗАПУСКАЕММ ДАННЫЕ
                                    Log.d(this.getClass().getName(), " Успешная Аунтификация с сервером  БуферУПолученныйРезультатОтСевлетаДляАунтификации :::  "
                                            + БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].toString());


                                    ///TODO ПРОШЛА УСПЕШНАЯ АУНТИФТИКАЦИЯ И МЫ ЗАПУСКАЕМ МЕТОДЫ ПОСЛЕ АУНТИФИКАЦИИ
                                } else if (БуферУПолученныйРезультатОтСевлетаДляАунтификации[0].length() > 0) {////ЗАПУСКАЕМ ДАННЫЕ ТОЛЬКО ПРИ УСПЕШНОЙ АУНТИФИЦИИ

                                    stopLoading();
                                }


                            } catch (Exception e) {
                                e.printStackTrace();
///метод запись ошибок в таблицу
///метод запись ошибок в таблицу
                                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());

                                // TODO: 01.09.2021 метод вызова
                                new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                        this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                            }
                            ////

                        }
                    });
                }







/*

                /////TODO МЕТОД ВСТАВКИ ИМЕНИ И ПАРОЛЯ АУНТИФИКАЦИИ БОЛЕЕ 7  ДНЕЙ
                protected Object МетодВставкиИменииПароляПриАунтификацииБолееСемиДней(View v) {/////МЕТОД ВСТАВКИ ИМЕНИ И ПАРОЛЯ АУНТИФИКАЦИИ БОЛЕЕ 7  ДНЕЙ
                    ///
                    Class_GRUD_SQL_Operations concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций = null;

                    Object Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации = 0;

                    try {
                        ////НАЧАЛО ВСТКИ И ОЧИСТКИ ДАННЫХ ПО ВСТКАЕ ИМЕНИ  И ПАРОЛЯ ПРИ АУНТИФИКАЦИИ ПОЛЬЗОВАТЕЛЯ БОЛЕЕ 7 ДНЕЙ
                        ////

                        ///
                        // /// для очистки

                        ////TODO ДАТА
                        String ДатаДЛяОчисткиИВстсвкиИмениИПароль=     new Class_Generation_Data(getApplicationContext()).ГлавнаяДатаИВремяОперацийСБазойДанных();
                        //////////////////////////////////////////////////////////////

                        // TODO: 30.08.2021    КОД ВСТАВКИ  ДАННЫХ   ЧЕРЕЗ

                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций = new Class_GRUD_SQL_Operations(getApplicationContext());


                        ///
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", "SuccessLogin");
                        ///
                        ///
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("Флаг_ЧерезКакоеПолеОбновлением", "id");
                        ///
                        ///
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.
                                concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗначениеФлагОбновления", БуферУПолученныйРезультатОтСевлетаДляАунтификации.toString());
                        ///

                        //

                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.
                                concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ЗнакФлагОбновления","="); //или =   или <   >



                        //TODO коййтенер

                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.contentValuesДляSQLBuilder_Для_GRUD_Операций.put("id", БуферУПолученныйРезультатОтСевлетаДляАунтификации.toString());
                        ///
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.contentValuesДляSQLBuilder_Для_GRUD_Операций.put("success_users", PUBLIC_CONTENT.ПубличноеИмяПользовательДлСервлета);
                        ///
                        ///
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.contentValuesДляSQLBuilder_Для_GRUD_Операций.put("success_login", PUBLIC_CONTENT.ПубличноеПарольДлСервлета);
                        ///
                        concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.contentValuesДляSQLBuilder_Для_GRUD_Операций.put("date_update", ДатаДЛяОчисткиИВстсвкиИмениИПароль);
                        ////
                        ///




                        ///TODO РЕЗУЛЬТАТ ВСТАВКИ ДАННЫХ
                        Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации = (Integer) concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.
                                new UpdateData(getApplicationContext()).updatedata(concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                                concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.contentValuesДляSQLBuilder_Для_GRUD_Операций,
                                Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков);
//

                        Log.d(this.getClass().getName(), "        Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации=0L; " +
                                Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации);


                        ////
                        if (Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации == null) {
                            ////
                            Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации = 0;
                        }
                        /////


                        // TODO: 02.09.2021если успешно прошла обновление если нет то ниже вроизвонитм вставку
                        if (  (Integer) Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации  > 0) { //ПОДТЕРЖДАЕМ ТОЛЬКО ВСТАВКУ НОВГО ИМЕНИ И ПАРОЛЯ
                            // ССылкаНаСозданнуюБазу.

                            // TODO: 02.09.2021  успешная обновление данных
                            Log.d(this.getClass().getName(), "Запущен.... метод  onCreate в классе Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации  ; " +
                                    Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации);


                            //TODO  ессли не удалось обновить то идем вставлять
                        } else {




                            ///TODO РЕЗУЛЬТАТ ВСТАВКИ ДАННЫХ
                            Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации = (Long) concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.
                                    new InsertData(getApplicationContext()).insertdata(concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.contentValuesДляSQLBuilder_Для_GRUD_Операций,
                                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков);
//

                            Log.d(this.getClass().getName(), "Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации " + Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации);


                            ////
                            if (Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации == null) {
                                ////
                                Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации = 0;
                            }
                            /////

                            // TODO: 02.09.2021  успешная вставки данных
                        }


                    } catch (SQLException | ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());

                    }

                    return Результат_АдаптерДляДобавлениеПолученогоУспешноИмяиПарольДляСемидневнойАунтификации;
                    ////// конец записываем полученный имя и пароль во временную таблицу ДЛЯ ТОГО ЧТОБЫ ЕСЛИ НУЖНО ЧЕРЕЗ  7 ДНЕЙ ПОТРЕБУЕТЬСЯ
                }

*/









                ////TODO метод запускаем его ПОСЛЕ УСПЕШНОЙ АУНТИФИКАЦИИ
                @Override
                public void stopLoading() {
                    super.stopLoading();
                    try {
////
                        Log.d(this.getClass().getName(), " stopLoading() asyncTaskLoaderАунтификацияПользователя ");
                        //ПрогрессБарДляВходаСистему.setVisibility(View.INVISIBLE);// по умолчанию прогресс бар делаем не видеым
                        //  TimeUnit.MILLISECONDS.sleep(100);
                        ///
/////
//                        Toast aa = Toast.makeText(КонтекстСинхроДляАунтификации, "OPEN",Toast.LENGTH_SHORT);
//                        ImageView cc = new ImageView(КонтекстСинхроДляАунтификации);
//                        cc.setImageResource(R.drawable.icon_dsu1_success_antrficar_users);//icon_dsu1_synchronisazia_dsu1_success
//                        aa.setView(cc);
//                        aa.show();

                        ///TODO ПОСЛЕ УСПЕШНОЙ УНТИФИКАЦИИ ПОЛЬЗОВАТЛЯ ИМЕНИ И ПАРОЛЯ  ОБНУЛЯЕМ ПЕРЕМЕННЫЕ


                        ///TODO ПЕЕРЕЖД ПЕРРВЫМ ЗАПУСКМО СТАВИМ ФЛАГ ЗАПРЕТА НА ОБНОВЛЕНИЯ

                        //   PUBLIC_CONTENT.ФлагПриПервомЗапускеОграничитьОперациюТолькоВставка=false;

                        ОшибкаПриПодключениекСерверуДляАунтификацииПользователяПриВходе = null;

                        БуферУПолученныйРезультатОтСевлетаДляАунтификации[0] = null;

                        ///TODO УСТАНАВЛИВАЕМ ФЛАГ ПРИ АУНТИФИКАЦИИ И МЯ И ПАРОЛЬ  СТАЫИМ ФЛАГ ОТКЛЮЧИТЬ ОБНОВЛЕНИЕ ПРИ СИНХРОНИЗАЦИИ false по умолчанию проверяем
                        ////todo  ПЫТАЕМСЯ ОРГАНИЗОВАТЬ ОБНОВЛЕНИЕ НО ТОЛЬКО ЕСЛИ ВЛАГ  TRUE


                        Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            v2.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            //deprecated in API 26
                            v2.vibrate(100);
                        }

/////// TODO ПОСЛЕ УСПЕШНОА АУНТИФИТКАЦИИ ИЛИ СИНХРОНИЗАЦИИ ЗАПУСКАЕТЬСЯ ДАННЫХ И ЗАТЕМ ЗАПУСКАЕМ ПРИЛОЖЕНИЯпосле успешной вставки переходим сюда
                        Intent Интент_ЗапускСамогоПриложенияЕслиПользовательПослеУспешнойаунтификации = new Intent();
                        //////


                        Интент_ЗапускСамогоПриложенияЕслиПользовательПослеУспешнойаунтификации.putExtra("РежимЗапускаСинхронизации","СамыйПервыйЗапускСинхронизации");


                        // TODO: 13.10.2021 перердаем публичный  id
                        Интент_ЗапускСамогоПриложенияЕслиПользовательПослеУспешнойаунтификации.putExtra("ПубличноеIDПолученныйИзСервлетаДляUUID",ПубличноеIDПолученныйИзСервлетаДляUUID);

                        // TODO: 13.10.2021 перердаем логин
                        Интент_ЗапускСамогоПриложенияЕслиПользовательПослеУспешнойаунтификации.putExtra("ПубличноеИмяПользовательДлСервлета",ПубличноеИмяПользовательДлСервлета);


                        // TODO: 13.10.2021 перердаем пароль

                        Интент_ЗапускСамогоПриложенияЕслиПользовательПослеУспешнойаунтификации.putExtra("ПубличноеПарольДлСервлета",ПубличноеПарольДлСервлета);



                        // TODO: 13.10.2021 перердаем пароль

                        Интент_ЗапускСамогоПриложенияЕслиПользовательПослеУспешнойаунтификации.putExtra("СтрокаСвязиСсервером",СтрокаСвязиСсервером);



                        Интент_ЗапускСамогоПриложенияЕслиПользовательПослеУспешнойаунтификации.setClass(getApplication(), MainActivity_Visible_Async.class);
                        //////  MainActivity_Face_App.class ТУТ ЗАПВСКАЕТЬСЯ ВЫБОР ПРИЛОЖЕНИЯ КОТОРЫЕ ЕСТЬ FACE APP НА ДАННЫЙ МОМЕТНТ РАЗРАБОТНАО ТАБЕЛЬНЫЙ УЧЁТ
                        Интент_ЗапускСамогоПриложенияЕслиПользовательПослеУспешнойаунтификации.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);/// FLAG_ACTIVITY_SINGLE_TOP
                        ///
                        startActivity(Интент_ЗапускСамогоПриложенияЕслиПользовательПослеУспешнойаунтификации);

                        ////////
                        ////TODO ДАННАЯ КОМАНДА ПЕРЕКРЫВАЕТ НЕ ЗАПУСКАЕМОЕ АКТИВТИ А АКТИВТИ КОТОРЕ ЕГО ЗАПУСТИЛО


                        finish();


                        ///////TODO КОНЕЦ ASYNCTASKLOADER АУНТИФИКАЦИИЯ
                    } catch (Exception e) {
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

                    }
                }

            };


            ///TODO запускаем asyncTaskLoader для акнтификации пользователя проверки этот ли пользователь
            class_grud_sql_operationsАунтификацияПользователя.asyncTaskLoaderАунтификацияПользователя    .startLoading();

            ///////TODO КОНЕЦ ASYNCTASKLOADER АУНТИФИКАЦИИЯ
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }
    }


    /////todo WIFI МЕТОДА ДЛЯ АНТИФИКАЦИИ
    ///////// TODO ПРОВЕРЯЕТ ЕСЛИ ПОДКЛЧБЕНИ В ИНТРЕНТУ

    boolean МетодГлавныйСинхронизацииДанныхКлиентСервер(Context КонтекстКоторыйДляСинхронизации) throws ExecutionException, InterruptedException, TimeoutException {


        /////=----СИНХРОНИЗАЦИЯ
        ///TODO СИНХРОНИЗАЦИЯ ///TODO СИНХРОНИЗАЦИЯ при запуске прилиложения
//TODO ПРОВРЕМ WIFI ПОДКЛЮЧЕН ЛИ
        boolean РезультатПРоверкиПодключениеWIFI = false;



        String Резутьтат_В_Настройки_УстановленныВТелефоне_WifiИлиMobile = new String();


        /////
        try {
            ///TODO ЗАПУСКАЕМ  ПуллПамяти

            /////todo тут МЫ ПОЛУЧАЕМ В КАКОЙ МОМЕНТ ТИП ПОДКЛЮЧЕНИЯ НА ТЕЛЕФОНЕ МОБИЛЯ ИЛИ  WIFI  И В ЗАВИСИМОСТИ ЧТОБЫ ПОНЯТЬ ЧЕ ЗА ДЕЛА
            Резутьтат_В_Настройки_УстановленныВТелефоне_WifiИлиMobile = new Class_Type_Connenction_Tel(getApplicationContext()).МетодОпределяемКакойТипПодключениеWIFIилиMobile();


            //////
            Log.d(this.getClass().getName(), "   РезутьтатПроверкиТипПодключениякИнтернету " + Резутьтат_В_Настройки_УстановленныВТелефоне_WifiИлиMobile);


            // TODO: 02.09.2021 код НАЧАЛО  посика как в телфоне написано режим подключениея к интрениту


            /////TODO ТУТ ПОЛУЧАЕМ  ЗНАЧЕНИЯ ПО УМОЛЧАНИЮ ПРОГРАММЫ РЕЖИМ РАБОТИЫ СИНХРОНИЗАЦИИ ТОЛЬКО ПО  WIFI
            try {

                ////
          Class_GRUD_SQL_Operations       class_grud_sql_operationsГлавныйСинхронизацииДанныхКлиентСервер = new Class_GRUD_SQL_Operations(getApplicationContext());


                // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

                ///
                class_grud_sql_operationsГлавныйСинхронизацииДанныхКлиентСервер.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", "SuccessLogin");
                ///////
                class_grud_sql_operationsГлавныйСинхронизацииДанныхКлиентСервер.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "mode_connection");

                // TODO: 02.09.2021 exe sql

                SQLiteCursor КурсорУзнаемСохраненыйРежимРаботыССетью = (SQLiteCursor) class_grud_sql_operationsГлавныйСинхронизацииДанныхКлиентСервер.
                        new GetData(getApplicationContext()).getdata(class_grud_sql_operationsГлавныйСинхронизацииДанныхКлиентСервер.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

                Log.d(this.getClass().getName(), "GetData "+КурсорУзнаемСохраненыйРежимРаботыССетью);



                String РезутьтатПроверкиВБазуЗаписаннаяНстройкаСетьWifiИлиMobile = new String();


                ///
                Log.d(getApplicationContext().getClass().getName(), " КурсорУзнаемСохраненыйРежимРаботыССетью  " + "--" + КурсорУзнаемСохраненыйРежимРаботыССетью);/////

                //////
                if (КурсорУзнаемСохраненыйРежимРаботыССетью.getCount() > 0) {

                    КурсорУзнаемСохраненыйРежимРаботыССетью.moveToFirst();

                    РезутьтатПроверкиВБазуЗаписаннаяНстройкаСетьWifiИлиMobile = КурсорУзнаемСохраненыйРежимРаботыССетью.getString(0);

                    ///
                    Log.d(getApplicationContext().getClass().getName(), " РезутьтатПроверкиВБазуЗаписаннаяНстройкаСетьWifiИлиMobile  " + "--" + РезутьтатПроверкиВБазуЗаписаннаяНстройкаСетьWifiИлиMobile);/////


                }


                // TODO: 03.10.2021  результата

                if (  (Резутьтат_В_Настройки_УстановленныВТелефоне_WifiИлиMobile.trim().equalsIgnoreCase(РезутьтатПроверкиВБазуЗаписаннаяНстройкаСетьWifiИлиMobile.trim()))

                || Резутьтат_В_Настройки_УстановленныВТелефоне_WifiИлиMobile.equalsIgnoreCase("Mobile")   || Резутьтат_В_Настройки_УстановленныВТелефоне_WifiИлиMobile.equalsIgnoreCase("WIFI")){

                    ///
                    Log.d(getApplicationContext().getClass().getName(), " Резутьтат_В_Настройки_УстановленныВТелефоне_WifiИлиMobile  " + "--" + Резутьтат_В_Настройки_УстановленныВТелефоне_WifiИлиMobile);/////
                    /////

                    РезультатПРоверкиПодключениеWIFI=true;

                }else {

                    ///
                    Log.d(getApplicationContext().getClass().getName(), " РезутьтатПроверкиВБазуЗаписаннаяНстройкаСетьWifiИлиMobile  " + "--" + РезутьтатПроверкиВБазуЗаписаннаяНстройкаСетьWifiИлиMobile);/////

                    //

                    РезультатПРоверкиПодключениеWIFI=false;

                }



                ///поймать ошибку
            } catch (Exception e) {
                //  Block of code to handle errors
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                ///////
            }


            ////
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл
        }



        //TODO ВОЗВРАЩЯЕМ НУЖНО ПОДКЛЮЧАТЬ АУНТИВИКАУИЮ ИЛИ НЕТ
        return РезультатПРоверкиПодключениеWIFI;
    }







    ////TODO метод который отпредеяеть КАКОЙ ТИП ПОДКЛЮЧЕНИ К ИНТРЕНТУ ЧЕРЕЗ WIFI ИЛИ MOBILE








}








