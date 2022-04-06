package com.dsy.dsu;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.dsy.dsu.Code_For_Chats_КодДля_Чата.MainActivity_List_Chats;
import com.dsy.dsu.Code_For_Firebase_AndOneSignal_Здесь_КодДЛяСлужбыУведомленияFirebase.Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal;
import com.dsy.dsu.Code_For_Tasks_КодДля_Задания.MainActivity_Tasks;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

/////////////////////////////////////////////////////////////////////////
public class MainActivity_Face_App extends AppCompatActivity {
    //////////todo

    // TODO: 23.03.2022
    ImageView imageView_ЗначекApp;
    // TODO: 23.03.2022
    protected Button ТекстПриложения;

    ///////TODO
    CREATE_DATABASE Create_Database_СсылкаНАБазовыйКласс;
    // TODO: 23.03.2022
    protected LinearLayout LinearLayoutFaceApp;
    //protected  Class_Engine_SQL УниверсальныйОбмен;
    protected ScrollView ScrollFaceAppСкорол;
    // TODO: 23.03.2022
    Observer observerОдноразоваяFACEAPP;
    // TODO: 23.03.2022
    Activity activity;
    // TODO: 23.03.2022
    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = null;

    //////////////////////
    boolean РежимыПросмотраДанныхЭкрана;
    // TODO: 23.03.2022
    Context КонтекстFaceAppВнешний;
    // TODO: 23.03.2022
    Context КонтекстFaceApp;
    ///    // TODO: 23.03.2022
    String КлючДляFirebaseNotification = "2a1819db-60c8-4ca3-a752-1b6cd9cadfa1";
    // TODO: 23.03.2022
    private MaterialCardView КнопкаЗадачи, КнопкаТабель, КнопкаЧат;

    private ProgressBar progressBarTask, progressBarTabel, progressBarChat;


    // TODO: 22.12.2021
    String ИмяСлужбыСинхронизацииОдноразовая = "WorkManager Synchronizasiy_Data Disposable";//"WorkManager Synchronizasiy_Data";//  "WorkManager Synchronizasiy_Data"; ///"WorkManager Synchronizasiy_Data";

//////////////// TODO FACE APP

    SUBClassBISNESSLOGICA_ForActivityFaceApp bisnesslogicaForActivityFaceApp;

    private LocalBroadcastManager localBroadcastManagerДляФинальнойУстановкиПОТабельныйУчёт;


    private BroadcastReceiver broadcastReceiverУстановкаПО;
    // TODO: 03.04.2022
    private DrawerLayout drawerLayoutFaceApp;
    // TODO: 03.04.2022
    private NavigationView navigationViewFaceApp;
    // TODO: 04.04.2022
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Log.w(getPackageName().getClass().getName(), "Сработал  protected void onCreate(Bundle savedInstanceState)  в MainActivity_Face_App");

            super.onCreate(savedInstanceState);

////////////////////
            String УникальныйИндификаторУстройства = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

            Log.w(getPackageName().getClass().getName(), " уникальный идентификатор устройства " +УникальныйИндификаторУстройства );


            //todo  конец тест код

            ////todo ДАННОЕ АКТИВИТИ ПЕРЕДАЕМ НА ВСЮ СИНХРОНИЗАЦИЮ
            КонтекстFaceApp = this;
            ///


            activity = this;

            КонтекстFaceAppВнешний = this;


            ((Activity) КонтекстFaceApp).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

/////////TODO локальная весрия данных для АНАЛИЗА ПО

            setContentView(R.layout.activity_main_face_app);


            ((Activity) КонтекстFaceApp).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

            //////todo настрока экрана

            //////todo  конец настрока экрана
            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = new PUBLIC_CONTENT(getApplicationContext());

            /////todo данная настрока запрещает при запуке активти подскаваать клавиатуре вверх на компонеты eedittext
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

            //  getSupportActionBar().hide(); ///скрывать тул бар

// TODO: 28.04.2021 Убиваем все службы


///////TODO
            Create_Database_СсылкаНАБазовыйКласс = new CREATE_DATABASE(getApplicationContext());

// TODO: 28.04.2021 разрешаем широковещатльнй приемник


            //////////TODO  КНОПКА ЗАДАЧА
            КнопкаЗадачи = (MaterialCardView) findViewById(R.id.cardview1_For_MainActivity); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА

            //////////TODO  КНОПКА ЗАДАЧА
            КнопкаТабель = (MaterialCardView) findViewById(R.id.cardview2_For_MainActivity); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА

            //////////TODO  КНОПКА ЗАДАЧА
            КнопкаЧат = (MaterialCardView) findViewById(R.id.cardview3_For_MainActivity); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА

            // TODO: 23.03.2022

            ///
            Log.d(this.getClass().getName(), "КнопкаЧат " + КнопкаЧат + " КнопкаЗадачи " + КнопкаЗадачи + " КнопкаТабель " + КнопкаТабель);
            ////
            imageView_ЗначекApp = (ImageView) findViewById(R.id.imageView_ЗначекApp); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА

            //   ScrollFaceAppСкорол = (ScrollView) findViewById(R.id.ScrollFaceApp); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА

            LinearLayoutFaceApp = (LinearLayout) findViewById(R.id.LineLayFaceApp); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА



            //todo тест код

            bisnesslogicaForActivityFaceApp = new SUBClassBISNESSLOGICA_ForActivityFaceApp(getApplicationContext(), activity);


            // TODO: 23.03.2022


            progressBarTask = (ProgressBar) findViewById(R.id.prograessbarTask_inner_ardview_forMainActivity); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА
            // TODO: 23.03.2022
            progressBarTabel = (ProgressBar) findViewById(R.id.prograessbarTabel_inner_ardview_forMainActivity); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА
            // TODO: 23.03.2022
            progressBarChat = (ProgressBar) findViewById(R.id.prograessbarChats_inner_ardview_forMainActivity); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА

            // TODO: 03.04.2022


            // TODO: 03.04.2022
            drawerLayoutFaceApp = (DrawerLayout) findViewById(R.id.drawerLayout_faceapp_menu); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА
            // TODO: 03.04.2022
            navigationViewFaceApp = (NavigationView) findViewById(R.id.navigation_dashboard_faceapp); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА

            // TODO: 04.04.2022


            // TODO: 03.04.2022
            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayoutFaceApp,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            // TODO: 03.04.2022
            drawerLayoutFaceApp.addDrawerListener(actionBarDrawerToggle);
            // TODO: 03.04.2022
            actionBarDrawerToggle.syncState();

            // TODO: 04.04.2022

            actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
            // TODO: 04.04.2022
            actionBarDrawerToggle.setDrawerSlideAnimationEnabled(true);

            Log.w(getPackageName().getClass().getName(), "drawerLayoutFaceApp    " + drawerLayoutFaceApp +
                    "  navigationViewFaceApp " + navigationViewFaceApp);/////////

            navigationViewFaceApp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MenuItem menu = (MenuItem) v;

                    switch (menu.getItemId()) {
                        case R.id.one:
                            ///
                            Log.d(this.getClass().getName(), "КнопкаЧат " + КнопкаЧат + " КнопкаЗадачи " + КнопкаЗадачи + " КнопкаТабель " + КнопкаТабель);
                            break;

                        default:
                            ///
                            Log.d(this.getClass().getName(), "КнопкаЧат " + КнопкаЧат + " КнопкаЗадачи " + КнопкаЗадачи + " КнопкаТабель " + КнопкаТабель);
                            break;
                    }
                }
            });
            // TODO: 05.04.2022

            drawerLayoutFaceApp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MenuItem menu = (MenuItem) v;

                    switch (menu.getItemId()) {
                        case R.id.one:
                            ///
                            Log.d(this.getClass().getName(), "КнопкаЧат " + КнопкаЧат + " КнопкаЗадачи " + КнопкаЗадачи + " КнопкаТабель " + КнопкаТабель);
                            break;

                        default:
                            ///
                            Log.d(this.getClass().getName(), "КнопкаЧат " + КнопкаЧат + " КнопкаЗадачи " + КнопкаЗадачи + " КнопкаТабель " + КнопкаТабель);
                            break;
                    }
                }
            });
// TODO: 06.06.2021 ЗАПУСК ТРЕХ СЛУЖБ


            МетодFaceApp_СлушательПриНажатииНаКнопки();


            // TODO: 06.06.2021 ЗАПУСК ТРЕХ СЛУЖБ

            МетодНажатиеЗначекAPP();






            Log.w(getPackageName().getClass().getName(), "  МЕтодЗапускСЛУЖБЫОбновленияПО  protected void onResume()  " +
                    " запстили МЕтодЗапускДвужWorkManagerДляПовторногоУведомленияиСлужбыОбновленияПО .\n" +
                    "                                    МетодПовторногоЗапускаВсехWorkManagerДляОбновленияПО() " );



            Log.i(this.getClass().getName(), "ПОВТОРНЫЙ ЗАПУСК ONESINGLE КОЛУЧЕНЕИ КЛЮЯА FIREBASE ");


            МетодРегистрацииУстройсвоНАFirebaseAndOneSignal();


            // TODO: 28.12.2021


            Log.i(this.getClass().getName(), "ПОВТОРНЫЙ ЗАПУСК ONESINGLE КОЛУЧЕНЕИ КЛЮЯА FIREBASE ");



            // TODO: 06.06.2021 ЗАПУСК ТРЕХ СЛУЖБ*/

            // TODO: 28.12.2021   Метод  ДАННЫЙ МЕТОД ВСЕГДА ПОСЛЕДНИЙ  если пришло Новоое Обновление По табельный УЧЁТ ПО ЗАПУСКАЕМ ЕГО ВСТАВКИ ПОКАЗЫВАЕМ ПОЛЬЗОВАТЕЛЮ

            МетодПовторныйЗапускОбщейСинхронизацииИзFaceApp();


            // TODO: 28.12.2021   Метод  ДАННЫЙ МЕТОД ВСЕГДА ПОСЛЕДНИЙ  если пришло Новоое Обновление По табельный УЧЁТ ПО ЗАПУСКАЕМ ЕГО ВСТАВКИ ПОКАЗЫВАЕМ ПОЛЬЗОВАТЕЛЮ


        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 11.05.2021 запись ошибок

            new Class_Send_Generation_Errors(getApplicationContext(), e.toString(), activity);

            Log.d(this.getClass().getName(), "  Полусаем Ошибку e.toString() " + e.toString());

        }
        // TODO: 04.04.2022  


    }
// TODO: 03.04.2022





    @Override
    protected void onStart() {
        super.onStart();

        // TODO: 23.03.2022
        try {

            // TODO: 23.03.2022

            КнопкаЧат.setBackgroundColor(Color.parseColor("#F0FFFF"));


            КнопкаТабель.setBackgroundColor(Color.parseColor("#F0FFFF"));

            КнопкаЗадачи.setBackgroundColor(Color.parseColor("#F0FFFF"));

            // TODO: 23.03.2022

            progressBarTask.setVisibility(View.INVISIBLE);

            progressBarTabel.setVisibility(View.INVISIBLE);

            progressBarChat.setVisibility(View.INVISIBLE);

            // TODO: 27.02.2022


            // TODO: 28.12.2021


            МетодПовторногоЗапускаУведомленияОБщихДляЧатаиДАнных();

            Log.w(getPackageName().getClass().getName(), "  FAceAPP повторный запуск Уведломления Одноразового" +
                    "" +
                    "" +
                    "" +
                    "  МетодПовторногоЗапускаУведомленияОБщихДляЧатаиДАнных() ");

            // TODO: 28.12.2021
            Log.w(getPackageName().getClass().getName(), "  SRART UPDAET SOFT");


            МЕтодЗапускСЛУЖБЫОбновленияПО();


            // TODO: 28.12.2021
            Log.w(getPackageName().getClass().getName(), "  SRART UPDAET SOFT");


            МетодВActivityFaveApp_УстанавливаетПрограммноеОбеспечениеПОТабельныйУчёт();


        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

        }
    }

    private void МетодПовторныйЗапускОбщейСинхронизацииИзFaceApp() {
        // TODO: 27.02.2022  

        try {

            // TODO: 27.02.2022
            Integer ПубличныйIDДляФрагмента = new SubClass_Connection_BroadcastReceiver_Sous_Asyns_Glassfish().МетодПолучениеяПубличногоID(getApplicationContext());

            Log.i(this.getClass().getName(), " ВЫХОД ИЗ МЕТОДА     МетодЗапускаСинхоронизацииИзШироковещательногоПриёмника(context); " +
                " BroadcastReceiver_Sous_Asyns_Glassfish (intent.getAction()   СЛУЖБА кто ЗАПУСТИЛ САМ bRODCAST ? :::" +"\n"+
                " Build.BRAND.toString() Название Телефона " +Build.BRAND.toString());

        // TODO: 29.09.2021     ЗАПУСК BROADCAST СИНХРОНИАЗЦИИ


        // TODO: 10.11.2021

        new Class_Generation_WORK_MANGER_DIRECT(getApplicationContext()).МетодЗапускаСинхоронизацииИзШироковещательногоПриёмника(getApplicationContext(),ПубличныйIDДляФрагмента);

        // TODO: 15.12.2021
        Log.w(getApplicationContext().getClass().getName(), " ПОСЛЕ ОТРАБОТКИ МЕТОДА есть входящий пользолватель " +
                "....Внутри BroadcastReceiver_Sous_Asyns_Glassfish  periodicWorkRequestСинхронизация.getId() ВходящиеПараментыБродКсстера "
                + ПубличныйIDДляФрагмента+ "\n");


        // TODO: 27.02.2022  

    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

        // TODO: 11.05.2021 запись ошибок

       /* new Class_Send_Generation_Errors(getApplicationContext(), e.toString(), activity);*/

        Log.d(this.getClass().getName(), "  Полусаем Ошибку e.toString() " + e.toString());

    }
    }

    // TODO: 07.01.2022

    // TODO: 26.12.2021  метод регистации на СЕРВЕРА ONESIGNAL

    private void МетодРегистрацииУстройсвоНАFirebaseAndOneSignal() {

        try{
            ///
            String КлючДляFirebaseNotification="2a1819db-60c8-4ca3-a752-1b6cd9cadfa1";
            // TODO: 17.12.2021

            Integer  ПубличныйIDДляФрагмента=   new Class_Generations_PUBLIC_CURRENT_ID(getApplicationContext()).ПолучениеПубличногоТекущегоПользователяID();

            // TODO: 01.01.2022

            new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).
                    МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal(КлючДляFirebaseNotification,ПубличныйIDДляФрагмента);


            //TODO ФУТУРЕ ЗАВЕРШАЕМ
            Log.d(this.getClass().getName(), "  МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal(КлючДляFirebaseNotification,0); " +
                    " РезультатЗаписиНовогоIDОтСервреаOneSignal  " );


            //
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в ВсеСтрокиJSONДляВставкиОтСервера
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ////// начало запись в файл

        }
    }











    private void МетодПовторногоЗапускаУведомленияОБщихДляЧатаиДАнных() {

        try{

        ////  TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР
            new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаУведомленияЗадач();


        Log.w(getPackageName().getClass().getName(), "  " +
                " new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).    МетодПовторногоЗапускаУведомленияОбщего() "  );

            ////  TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР
            new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаУведомленияЧата();


            Log.w(getPackageName().getClass().getName(), "  " +
                    " new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаУведомленияДляОдноразовойСинхрониазации()"  );

    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

        // TODO: 11.05.2021 запись ошибок

    }


    }









    // TODO: 20.12.2021 метод запуска повторного уведомлениия  и загрузки ПО ОБновлени файла

    private void МЕтодЗапускСЛУЖБЫОбновленияПО() {




        try{




        // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ ОБНОВЛЕНИЕ ПО


        //////////////////////TODO SERVICE

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

        //  startService(new Intent(КонтекстFaceApp, Service_UpdateSoft.class));
////TODO УСТАНВЛИВАЕМ РАЗРЕШЕНИЯ НА ВСЕ ПРИЛОЖЕНИЯ НАСТРОЙКИ

            ActivityCompat.requestPermissions(activity, permissions, 1);



        // TODO: 15.12.2021 ЗАПУСКАЕМ СЛУЖБУ ONESIGNAL




        /////  TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР
        new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).
                МетодПовторногоЗапускаВсехWorkManagerДляОбновленияПО();




        Log.w(getPackageName().getClass().getName(), " new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).\n" +
                "                                    МетодПовторногоЗапускаВсехWorkManagerДляОбновленияПО() " );





    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());

        // TODO: 11.05.2021 запись ошибок

    }
    }
















    // TODO: 28.04.2021 принудительная синхронизация



    // TODO: 28.12.2021  метоД КОТРЙ ПОКАЗЫВАЕМ ЧТО ЗАГРУЗИЛОСЬ НОВОЕ ПО ТАБЕЛЬНЫЙ УЧЁТ СКАЧАЛОСЬ ИНАДО ПРИНЯТЬ РЕШЕНИЕ ОБНОВЛЕНМ ИЛИ НЕТ

    private void МетодВActivityFaveApp_УстанавливаетПрограммноеОбеспечениеПОТабельныйУчёт() {

        try {

            Log.d(this.getClass().getName(), "  МетодЗапускПослеНажатияНАНовойФормеНАКнопкуУстановитьПослеУспешнойЗагрузкиНовогоПОТабельныйУчётПоказываемЕгоПользователю");


            // TODO: 25.03.2022 Создание Локального БродКстаера

            localBroadcastManagerДляФинальнойУстановкиПОТабельныйУчёт = LocalBroadcastManager.getInstance(getApplicationContext());
            // TODO: 25.03.2022
            broadcastReceiverУстановкаПО = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

                    Log.d(this.getClass().getName(), " localBroadcastManagerДляФинальнойУстановкиПОТабельныйУчёт  intent " + intent);

                    // TODO: 25.03.2022

                    Bundle bundle = intent.getExtras();
                    // TODO: 25.03.2022

                    Log.d(this.getClass().getName(), " localBroadcastManagerДляФинальнойУстановкиПОТабельныйУчёт  bundle " + bundle);

                    // TODO: 25.03.2022

                    Integer ЗагрузиласьНоваяВерисяПОПровремяем = bundle.getInt("СервернаяВерсияПОВнутри", 0);
                    // TODO: 25.03.2022


                    File ЗагрузкиФайлаОбновенияПОДополнительный = (File) bundle.getSerializable("СервернаяВерсияПОCамФайлДляПередачи");

                    // TODO: 25.03.2022
                    Long СервернаяВерсияПОРазмерФайла = bundle.getLong("СервернаяВерсияПОРазмерФайла", 0l);


                    Log.d(this.getClass().getName(), " ЗагрузиласьНоваяВерисяПОПровремяем  intent " + ЗагрузиласьНоваяВерисяПОПровремяем + "ЗагрузкиФайлаОбновенияПОДополнительный " + ЗагрузкиФайлаОбновенияПОДополнительный
                            + " СервернаяВерсияПОРазмерФайла " + СервернаяВерсияПОРазмерФайла);

                    // TODO: 25.03.2022

                    if (СервернаяВерсияПОРазмерФайла > 0) {

                        // TODO: 25.03.2022
                        МетодУстановкиНовойВерсииПОТабельныйУчётПоднимаетЕгоНаActrivity(ЗагрузиласьНоваяВерисяПОПровремяем, ЗагрузкиФайлаОбновенияПОДополнительный);
                    }

                    Log.d(this.getClass().getName(), " localBroadcastManagerДляФинальнойУстановкиПОТабельныйУчёт  intent " + intent);

                }
            };

            // TODO: 25.03.2022 установливаем настройки Фильмо к Локальному БродКсстеру
            IntentFilter intentFilterУстановка = new IntentFilter();
            // TODO: 25.03.2022
            intentFilterУстановка.addAction("CompletePO");
            localBroadcastManagerДляФинальнойУстановкиПОТабельныйУчёт.registerReceiver(broadcastReceiverУстановкаПО, intentFilterУстановка);



        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 11.05.2021 запись ошибок

        }


        // TODO: 28.12.2021


    }


    //todo Финальный метод в ОБНОВЛЕНИИ ПО УСТАВНКА НЕПОСРЕДСВЕННО ФАЙЛА НА АКТИВТИ ПОЛЬЗОВАТЛЕМ

    private void МетодУстановкиНовойВерсииПОТабельныйУчётПоднимаетЕгоНаActrivity(@NonNull Integer СервернаяВерсияПОВнутри,
                                                                                 @NonNull File ЗагрузкиФайлаОбновенияПОДополнительный) {

        try {
            File ФайлыДляОбновлениеВычисляемНомерВерсииПО = null;


            final PackageManager pm = getPackageManager();
            String apkName = "update_dsu1.apk";


            String fullPath = Environment.getExternalStorageDirectory() + "/" + apkName;
            if (Build.VERSION.SDK_INT >= 30) {

                fullPath = Environment.getExternalStorageState() + "/" + apkName;
            } else {

                fullPath = Environment.getExternalStorageDirectory() + "/" + apkName;

            }
            fullPath = Environment.DIRECTORY_DOWNLOADS + "/" + apkName;

            PackageInfo info = pm.getPackageArchiveInfo(fullPath, 0);

            if (info != null) {

                Log.d(this.getClass().getName(), "VersionCode : " + info.versionCode + ", VersionName : " + info.versionName);

                СервернаяВерсияПОВнутри = info.versionCode;
            }
            // TODO: 02.04.2022


            final Object ТекущаяВерсияПрограммы = BuildConfig.VERSION_CODE;

            ///
            Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
//////сам вид
            AlertDialog alertDialog = new MaterialAlertDialogBuilder(this)///       final AlertDialog alertDialog =new AlertDialog.Builder( MainActivity_Face_App.КонтекстFaceApp)
                    .setTitle("Установщик")
                    .setMessage("Пришло Обновление,"
                           + "\n" + "ПО Табельный учёт ,"
                           + "\n" + "локальная версия. " + ЛокальнаяВерсияПОСравнение + ","
                           + "\n" + "новая версия. " + СервернаяВерсияПОВнутри + ","
                           + "\n" + "реализовано:"
                           + "\n" + "Задачи" + "\n"
                           + "\n")
                   .setPositiveButton("Установить", null)
                   .setNegativeButton("Позже", null)
                    .setIcon(R.drawable.icon_dsu1_updates_po_success)
                    .show();
/////////кнопка
            final Button MessageBoxUpdateОбновитьПО = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);




            MessageBoxUpdateОбновитьПО.setOnClickListener(new View.OnClickListener() {
                ///MessageBoxUpdate метод CLICK для DIALOBOX
                @Override
                public void onClick(View v) {
                    //удаляем с экрана Диалог


                    Log.d(this.getClass().getName(), "Установка Обновления .APK СЛУЖБА");


                    //////
                    String ФинальныйПутьДляЗагрузкиФайлаОбновения = null;
                    ////
                    if (Build.VERSION.SDK_INT >= 30) {

                        ФинальныйПутьДляЗагрузкиФайлаОбновения = getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + "/";  //null
                    } else {

                        ФинальныйПутьДляЗагрузкиФайлаОбновения = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/";

                    }


                    Log.d(this.getClass().getName(), "Установка Обновления .APK СЛУЖБА  ФинальныйПутьДляЗагрузкиФайлаОбновения " + ФинальныйПутьДляЗагрузкиФайлаОбновения);


                    String НазваниеФайлаОбновления = "update_dsu1.apk";

                    ////
                    ФинальныйПутьДляЗагрузкиФайлаОбновения += НазваниеФайлаОбновления;


                    Uri URIПутиДляЗагрузкиФайловЧерезПровайдер = FileProvider.getUriForFile(getApplicationContext(),
                            getApplicationContext().getPackageName() + ".provider",
                            ЗагрузкиФайлаОбновенияПОДополнительный);

             /*       Uri URIПутиДляЗагрузкиФайловЧерезПровайдер = FileProvider.getUriForFile(getApplicationContext(),
                            getApplicationContext().getPackageName() + ".provider",
                            new File(ФинальныйПутьДляЗагрузкиФайлаОбновения));*/

                    // TODO: 25.03.2022


                    Log.d(this.getClass().getName(), "Установка ЗагрузкиФайлаОбновенияПОДополнительный  " + ЗагрузкиФайлаОбновенияПОДополнительный);


                    Intent intentОбновлениеПО = new Intent(Intent.ACTION_INSTALL_PACKAGE);
                    ////////
                    intentОбновлениеПО.setDataAndType(URIПутиДляЗагрузкиФайловЧерезПровайдер, "application/vnd.android.package-archive");

                    intentОбновлениеПО.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION |

                            Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION | Intent.FLAG_GRANT_PREFIX_URI_PERMISSION
                            | Intent.FLAG_ACTIVITY_NEW_TASK);

                    intentОбновлениеПО.putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true);

                    intentОбновлениеПО.putExtra(Intent.EXTRA_STREAM, URIПутиДляЗагрузкиФайловЧерезПровайдер);
                    // intent.addCategory("android.intent.category.APP_MARKET");

                    // TODO: 18.05.2021 PackegeManger проверка может ли с указаными выше условиями загрузиться файл

// подтвердите, что устройство может открыть этот файл!
                    PackageManager МеханизмПроверкиЗапуститьсяНашИнтентИлиНЕт = activity.getPackageManager();

                    ///
                    if (intentОбновлениеПО.resolveActivity(МеханизмПроверкиЗапуститьсяНашИнтентИлиНЕт) != null) {
                        //////todo запуск установкика .apk
                        ///     context. startActivity(intent); ////   ((Activity) MainActivity_Face_App.КонтекстFaceApp). startActivity(intent);//  MainActivity_Face_App.КонтекстFaceApp. startActivity(intent);

                        Log.d(this.getClass().getName(), " СЛУЖБА УСТАНОВКА... ОБНОВЛЕНИЯ НА ТЕЛЕФОН (.APK файл)  МеханизмПроверкиЗапуститьсяНашИнтентИлиНЕт "
                                + МеханизмПроверкиЗапуститьсяНашИнтентИлиНЕт);


                        ////TODO непосрдствено сам запуск новго .apk файла


                        //////todo Удаляем все зайдгний план установкика .apk


                        startActivity(intentОбновлениеПО);

                        finishAndRemoveTask(); //// ((Activity) MainActivity_Face_App.КонтекстFaceApp).finish();


                        Log.w(this.getClass().getName(), " ура !!!! УРА !!!!  уСПЕШНАЫЙ ЗАПУСК СКАЧЕННОГО ОБНОВЛЕНЕИ ПО " +
                                "МетодУстановкиНовойВерсииПОТабельныйУчётПоднимаетЕгоНаActrivity  ");

                        ///TODO УСТАНАВЛИВАЕМ ФЛАГ ЧТО МУ УЖЕ СКАЧИВАЛИ ЭТО ПРИЖЕНИЕ


                    } else {
                        ///////TODO ОСТАНАВЛИВАЕМ СЛУЖБУ ЧЕРЕЗ 20 СЕКУНД
                        Log.d(this.getClass().getName(), "Ошибка файл .APK не устнаовлен ОШИБКА СЛУЖБА ОБНОВЛЕНИЯ ...  "
                                + new Date() + " МеханизмПроверкиЗапуститьсяНашИнтентИлиНЕт " + МеханизмПроверкиЗапуститьсяНашИнтентИлиНЕт);
                    }

                    ///////////

                }
            });

            final Button MessageBoxUpdateНеуСтанавливатьПО = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            MessageBoxUpdateНеуСтанавливатьПО.setOnClickListener(new View.OnClickListener() {
                ///MessageBoxUpdate метод CLICK для DIALOBOX
                @Override
                public void onClick(View v) {
                    //удаляем с экрана Диалог
                    alertDialog.dismiss();
                    Log.d(this.getClass().getName(), "MessageBoxUpdateНеуСтанавливатьПО  ОТМЕНА УСТАНВОКИ НОВГО ПО   dismiss ");
                    alertDialog.cancel();
                    // activity.finishAndRemoveTask(); //// ((Activity) MainActivity_Face_App.КонтекстFaceApp).finish();


                    ///////////

                }
            });



        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 11.05.2021 запись ошибок

        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {


            ////TODO запуск службы справочкиа FIO
            bisnesslogicaForActivityFaceApp.new SubClass_Closeo_bserverОдноразоваяFACEAPP_to_MainActivity_Face_App().
                    МетодОдписыОТСлушателяРезультатПринудительноСинхрониазцииЗапущенойСFACEAPP(getApplicationContext(), observerОдноразоваяFACEAPP, ИмяСлужбыСинхронизацииОдноразовая);

            ///TODO ЗАПУСК СЛУЖБЫ СПРАВОЧНИКА ФИО

            localBroadcastManagerДляФинальнойУстановкиПОТабельныйУчёт.unregisterReceiver(broadcastReceiverУстановкаПО);


        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 11.05.2021 запись ошибок

        }

    }




    /////TODO метод синхронизхации данных обмен данными при запуске программы




    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(this.getClass().getName(), "onRestart()  FAce app " );


        try{
/*

            /////  TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР
            new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаВсехWorkManagerУведедомления();



         */
/*   // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК Facebase and OneSignal  ///  КлючДляFirebaseNotification
            new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).  МетодПовторногоЗапускаFacebaseCloud_And_OndeSignal(КлючДляFirebaseNotification);
*//*



*/

/*            // TODO: 06.06.2021 ЗАПУСК ТРЕХ СЛУЖБ


            МетодЗапускПослеНажатияНАНовойФормеНАКнопкуУстановитьПослеУспешнойЗагрузкиНовогоПОТабельныйУчётПоказываемЕгоПользователю();


            Log.w(getPackageName().getClass().getName(), "   protected void onRestart()   запстили МЕтодЗапускДвужWorkManagerДляПовторногоУведомленияиСлужбыОбновленияПО .\n" +
                    "                                    МетодПовторногоЗапускаВсехWorkManagerДляОбновленияПО() " );*/


        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 11.05.2021 запись ошибок

        }
        }






    @Override
    protected void onStop() {
        super.onStop();

        //
        try{


                ////TODO запуск службы справочкиа FIO
            bisnesslogicaForActivityFaceApp.    new SubClass_Closeo_bserverОдноразоваяFACEAPP_to_MainActivity_Face_App().
                        МетодОдписыОТСлушателяРезультатПринудительноСинхрониазцииЗапущенойСFACEAPP(getApplicationContext(),observerОдноразоваяFACEAPP,ИмяСлужбыСинхронизацииОдноразовая);

                ///TODO ЗАПУСК СЛУЖБЫ СПРАВОЧНИКА ФИО
                //////TODO  данный код срабатывает когда произошда ошивка в базе


            ///////TODO ОСТАНАВЛИВАЕМ СЛУЖБУ ЧЕРЕЗ 20 СЕКУНД
            Log.d(this.getClass().getName(), " new SubClass_pertaining_to_MainActivity_Face_App().    МетодОдписыОТСлушателяРезультатПринудительноСинхрониазцииЗапущенойСFACEAPP(getApplicationContext(),observerОдноразоваяFACEAPP);");
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        //////TODO  данный код срабатывает когда произошда ошивка в базе

    /*    if(ССылкаНаСозданнуюБазу.isOpen()){
            if(ССылкаНаСозданнуюБазу.inTransaction()){

    ;
            }
            ССылкаНаСозданнуюБазу.close();
        }*/

    }


    private void МетодНажатиеЗначекAPP() {

        //todo метод возврата к предыдущему активт

        try {

            imageView_ЗначекApp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 04.04.2022

                    Log.d(this.getClass().getName(), " кликнем для созданни новго сотрдника при нажатии v " + v);

                    // TODO: 05.04.2022
                    //drawerLayoutFaceApp.open();

                    drawerLayoutFaceApp.closeDrawers();


                }
            });
            // TODO: 05.04.2022
            Log.d(this.getClass().getName(), " кликнем для созданни новго сотрдника при нажатии  drawerLayoutFaceApp.getForegroundGravity() " + drawerLayoutFaceApp.getForegroundGravity());

            drawerLayoutFaceApp.addDrawerListener(new DrawerLayout.DrawerListener() {
                @Override
                public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                    // TODO: 05.04.2022
                    Log.d(this.getClass().getName(), " кликнем для созданни новго сотрдника при нажатии  drawerLayoutFaceApp.getForegroundGravity() " + drawerLayoutFaceApp.getForegroundGravity());

                }

                @Override
                public void onDrawerOpened(@NonNull View drawerView) {
                    // TODO: 05.04.2022
                    Log.d(this.getClass().getName(), " кликнем для созданни новго сотрдника при нажатии  drawerLayoutFaceApp.getForegroundGravity() "
                            + drawerLayoutFaceApp.getForegroundGravity());

                }

                @Override
                public void onDrawerClosed(@NonNull View drawerView) {
                    // TODO: 05.04.2022
                    Log.d(this.getClass().getName(), " кликнем для созданни новго сотрдника при нажатии  drawerLayoutFaceApp.getForegroundGravity() "
                            + drawerLayoutFaceApp.getForegroundGravity());

                }

                @Override
                public void onDrawerStateChanged(int newState) {
                    // TODO: 05.04.2022
                    Log.d(this.getClass().getName(), " кликнем для созданни новго сотрдника при нажатии  drawerLayoutFaceApp.getForegroundGravity() "
                            + drawerLayoutFaceApp.getForegroundGravity());

                }
            });
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());


        }


    }


    //todo  ТАБЕЛЬНЫЙ УЧЁТ
    //// TODO  ЗАПУСКАЕМ ПО НОЖАТИЕ НА КНОППКУ ТАБЕЛЬНЫЙ УЧЁТ НА АКТИВИТИ FACE_APP МЕТОД СРАБОАТЫВАЕТ КОГДА НАЖИМАЕМ НА КНОППКУ ТАБЕЛЬНЫЙ УЧЕТ И ПЕРЕРХОДИМ НА СОЗДАНИЕ ТАБЕЛЯ
    void МетодFaceApp_СлушательПриНажатииНаКнопки() {
        try {

            ////TODO  слушатель первый для ЗАдач

            КнопкаЗадачи.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        // TODO: 23.03.2022

                        progressBarTask.setVisibility(View.VISIBLE);

                        КнопкаЗадачи.setBackgroundColor(Color.GRAY);

                        //todo запускаем  получент ПУБЛИЧНЫЙ ID ИЛИ ИЗ БАЗЫ ЛИБО С ИНТРЕНТА
                        // TODO: 23.04.2021 запуск чата
                        Log.d(this.getClass().getName(), "Запускает Чат из меню   ");

                        Intent intentЗапускЗаданияВ_Faceapp = new Intent();
                        //////

                        intentЗапускЗаданияВ_Faceapp.setClass(getApplicationContext(), MainActivity_Tasks.class);//рабочий

                        intentЗапускЗаданияВ_Faceapp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        startActivity(intentЗапускЗаданияВ_Faceapp);
                        ///finish();

                        КонтекстFaceAppВнешний = null;

                        //////
                    } catch (Exception e) {
                        //  Block of code to handle errors
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }


            });
            ////TODO  слушатель второй для Табель

            КнопкаТабель.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {

                        // TODO: 23.03.2022
                        progressBarTabel.setVisibility(View.VISIBLE);
                        // TODO: 23.03.2022
                        КнопкаТабель.setBackgroundColor(Color.GRAY);

                        //todo запускаем  получент ПУБЛИЧНЫЙ ID ИЛИ ИЗ БАЗЫ ЛИБО С ИНТРЕНТА
                        Intent Интент_ЗапускТабельногоУчётаПервыйШаг = new Intent();
                        /////
                        // Интент_ЗапускТабельногоУчётаПервыйШаг.setClass(getApplication(),  MainActivity_List_Tabels.class); // ТУТ ЗАПВСКАЕТЬСЯ ВЫБОР ПРИЛОЖЕНИЯ КОТОРЫЕ ЕСТЬ FACE APP НА ДАННЫЙ МОМЕТНТ РАЗРАБОТНАО ТАБЕЛЬНЫЙ УЧЁТ

                        Интент_ЗапускТабельногоУчётаПервыйШаг.setClass(getApplication(), MainActivity_List_Tabels.class); //  ТЕСТ КОД КОТОРЫЙ ЗАПУСКАЕТ ACTIVITY VIEWDATA  ПРОВЕРИТЬ ОБМЕН

                        Интент_ЗапускТабельногоУчётаПервыйШаг.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        ///
                        ///////TODO ОСТАНАВЛИВАЕМ СЛУЖБУ ЧЕРЕЗ 20 СЕКУНД
                        Log.d(this.getClass().getName(), "" +
                                "    КнопкаТабельныйУчёт.setOnClickListener(new View.OnClickListener() {");
                        //////
                        startActivity(Интент_ЗапускТабельногоУчётаПервыйШаг);
                        //////
                        ///finish();

                        КонтекстFaceAppВнешний = null;

                        //////
                    } catch (Exception e) {
                        //  Block of code to handle errors
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }


            });
            ///////КнопкаЧатКнопкаЧат
            ////TODO  слушатель второй  для Чат

            КнопкаЧат.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        // TODO: 23.03.2022
                        progressBarChat.setVisibility(View.VISIBLE);

                        // TODO: 23.03.2022
                        КнопкаЧат.setBackgroundColor(Color.GRAY);

                        //todo запускаем  получент ПУБЛИЧНЫЙ ID ИЛИ ИЗ БАЗЫ ЛИБО С ИНТРЕНТА

                        Log.d(this.getClass().getName(), "Запускает Чат из меню   ");

                        Intent intentЗапускЧатаВнутри_FaceApp = new Intent();
                        //////
                        // intentЗапускЧата.setClass(getApplicationContext(), MainActivity_history_chat_test.class);

                        intentЗапускЧатаВнутри_FaceApp.setClass(getApplicationContext(), MainActivity_List_Chats.class);//рабочий

                        intentЗапускЧатаВнутри_FaceApp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        startActivity(intentЗапускЧатаВнутри_FaceApp);
                        //////
                        ///finish();

                        КонтекстFaceAppВнешний = null;

                        //////
                    } catch (Exception e) {
                        //  Block of code to handle errors
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }


            });


        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }








    /// TODO МЕНЮ ГЛАВНОЕ НА АКТИВИТИ ПРОСМОТР ДАННЫХ/// МЕНЮ ГЛАВНОЕ НА АКТИВИТИ ПРОСМОТР ДАННЫХ/// МЕНЮ ГЛАВНОЕ НА АКТИВИТИ ПРОСМОТР ДАННЫХ/// МЕНЮ ГЛАВНОЕ НА АКТИВИТИ ПРОСМОТР ДАННЫХ/// МЕНЮ ГЛАВНОЕ НА АКТИВИТИ ПРОСМОТР ДАННЫХ
//#1
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(this.getClass().getName(), "  Меню  запустилось на Активити FACE_APP");
        try{

            if (  Build.VERSION.SDK_INT >23) {

                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.viewsdata_menu, menu);

            }else{
// добавляем пункты меню
                menu.add(0, 1, 0, "■ Отчёт Ошибок");
                menu.add(0, 2, 0, "■ Настройка");
                menu.add(0, 3, 3, "■ Пользователи");
                menu.add(1, 4, 1, "■ Обмен с данными");
                menu.add(1, 5, 2, "■ Шаблоны");
                menu.add(1, 6, 4, "■ Обновление ПО");
                menu.add(1, 7, 5, "■ Чат");

                ///////TODO ОСТАНАВЛИВАЕМ СЛУЖБУ ЧЕРЕЗ 20 СЕКУНД
                Log.d(this.getClass().getName(), "" +
                        "    public boolean onCreateOptionsMenu(Menu menu) {");

                return super.onCreateOptionsMenu(menu);
            }
            ///////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return true;
    }

    //#2

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(this.getClass().getName(), "  Меню  запустилось на Активити FACE_APP");
        try{
            ///////
            switch (item.getItemId()) {
                ////

//////ПЕРВЫЙ ПРОСМОТР ОШИБОК//////ПЕРВЫЙ ПРОСМОТР ОШИБОК//////ПЕРВЫЙ ПРОСМОТР ОШИБОК//////ПЕРВЫЙ ПРОСМОТР ОШИБОК//////ПЕРВЫЙ ПРОСМОТР ОШИБОК
                case R.id.ПунктМенюПервый:
                case 1:
                    Log.e(this.getClass().getName(), "Хотите посмотреть ошибки ?");


                /*    if (PUBLIC_CONTENT.Отладка==true) {
                        МетодДиалогаДляМеню("Ошибки системы", "Посмотреть ошибки ?");*/



                        try{
                            ///TODO тестовый код
                            ////   МетодТестовыйЗапускВизуальноФайлаApK();

                            /////
                            Intent  Интент_Меню = new Intent(getApplication(), MainActivity_Errors.class);

                            Интент_Меню.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//////FLAG_ACTIVITY_SINGLE_TOP


                            ///////TODO ОСТАНАВЛИВАЕМ СЛУЖБУ ЧЕРЕЗ 20 СЕКУНД
                            Log.d(this.getClass().getName(), "" +
                                    "                     case R.id.ПунктМенюПервый:");

                            startActivity(Интент_Меню);

                            ///TODO запуск службы
                            ///////
                        } catch (Exception e) {
                            //  Block of code to handle errors
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                    Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }




                    return true;

//////ПЕРВЫЙ ОБНОВЛЕНИЕ ДАННЫХ//////ПЕРВЫЙ ОБНОВЛЕНИЕ ДАННЫХ//////ПЕРВЫЙ ОБНОВЛЕНИЕ ДАННЫХ//////ПЕРВЫЙ ОБНОВЛЕНИЕ ДАННЫХ//////ПЕРВЫЙ ОБНОВЛЕНИЕ ДАННЫХ

                case R.id.ПунктМенюВторой:
                    ///
                case 2:
                    Log.w(this.getClass().getName(), "Хотите перерйти в натройки");

                /*    if (PUBLIC_CONTENT.Отладка==true) {
                        МетодДиалогаДляМеню("Настройка системы", "Перейти к настройкам системы ?");
                */


            bisnesslogicaForActivityFaceApp.     new   SubClassВызоваАктивтиИзМеню().МетодЗапускаИзМенюНастроек();


                    return true;







////ТРЕТИЙ ПУНКТ ДОБАВЛЕНИЕ ДАННЫХ////ТРЕТИЙ ПУНКТ ДОБАВЛЕНИЕ ДАННЫХ////ТРЕТИЙ ПУНКТ ДОБАВЛЕНИЕ ДАННЫХ////ТРЕТИЙ ПУНКТ ДОБАВЛЕНИЕ ДАННЫХ////ТРЕТИЙ ПУНКТ ДОБАВЛЕНИЕ ДАННЫХ
                case R.id.ПунктМенюТретий:
                    ///
                case 3:
                    Log.d(this.getClass().getName(), "Сменить пользователя и смена данных  ?");



                    ////////////
              Boolean РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизцииПередСменыДанных= new Class_Connections_Server(getApplicationContext()).
                            МетодПингаСервераРаботаетИлиНетТОлькоДЛяACTIVITYFACEAPP(getApplicationContext());


                    Log.d(this.getClass().getName(), "  Completable.fromAction  " +
                            "РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизцииПередСменыДанных "+
                            РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизцииПередСменыДанных);


                    String ПолученыйТекущееИмяПользователя= null;


                    if (РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизцииПередСменыДанных==true) {
                        // TODO: 06.07.2021  пользователь СМЕНИТЬ

                        ПолученыйТекущееИмяПользователя = new MODEL_synchronized(getApplicationContext()).МетодПолучениеИмяСистемыДляСменыПользователя(getApplicationContext());
                        // TODO: 23.02.2022
                        Log.d(this.getClass().getName(), "  ПолученыйТекущееИмяПользователя " +
                                ПолученыйТекущееИмяПользователя);


                        //////
                        bisnesslogicaForActivityFaceApp. МетодДиалогаДляМеню("Пользователи Системы", "При смене пользователя,"
                                 +"\n"+" поменяються и данные системы." +"\n"
                                 + "Поменять пользователя ?" + "\n"
                                 + " (текущий пользователь : ) " + ПолученыйТекущееИмяПользователя.toUpperCase());


                        // TODO: 23.02.2022
                    }else{
                        Toast.makeText(getApplicationContext(), "Для смены данных, нужно подключение к серверу !!! "
                                + "\n" , Toast.LENGTH_LONG).show();


                    }


                    ////////////////


                    ///////TODO ОСТАНАВЛИВАЕМ СЛУЖБУ ЧЕРЕЗ 20 СЕКУНД
                    Log.d(this.getClass().getName(), "" +
                            "            МетодДиалогаДляМеню(\"Пользователи Системы\", \"При смене пользователя,\"" +ПолученыйТекущееИмяПользователя );





                    return true;


// TODO СИНХРОНИЗАЦИЯ ДАННЫХ ПУКТО МЕНЮ
                case R.id.ПунктМенюЧетвертый:
                    ///
                case 4:
                    Log.d(this.getClass().getName(), "Запуск... Из Меню Активти FACEAPP  Синхронизация Данных с Web-сервера ДСУ-1 ?");


                    // TODO: 17.03.2021 метд дополнительного удаления  И ПЛЮС ОБНОВЛЕНЕИ ПО
                    МетодПодключениеObserverДляБазы();

                    // TODO: 17.03.2021 метд дополнительного удаления  И ПЛЮС ОБНОВЛЕНЕИ ПО
                    МетодЗапускаСинихрниазцииИзМенюНаАктивтиFACEAPP();


                    Log.d(this.getClass().getName(), "Отработала синх.. Из Меню Активти FACEAPP Синхронизация Данных с Web-сервера ДСУ-1 ?");


                    Log.d(this.getClass().getName(), "Отработала синх.. Из Меню Активти FACEAPP Синхронизация Данных с Web-сервера ДСУ-1 ?");


                    return true;


//todo конец синхрониазции ПРИНАДАТИИ Н АКПОНКУ

                //шаблоны
                case R.id.ПунктМенюШестрой:
                    ///
                case 5:

                    if (РежимыПросмотраДанныхЭкрана==true) {


                        Log.d(this.getClass().getName(), "Шаблоны из меню?");

                        Intent Интент_BackВозвращаемАктивти = new Intent();
                        Интент_BackВозвращаемАктивти.setClass(getApplicationContext(), MainActivity_New_Templates_Tabels.class); // Т

                        ////todo запускаем активти
                        Интент_BackВозвращаемАктивти.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

                        Интент_BackВозвращаемАктивти.putExtra("ЗапускШаблоновFaceAppБлокировкаКнопкиДа",true);

                        ////

                        startActivity( Интент_BackВозвращаемАктивти);

                    }
                    /// МетодДиалогаДляМеню(" Вид Просмотра Данных", "Просмотр во весь экран ?");
                    return true;

                // TODO: 17.03.2021 обновление ПО
                case R.id.ПунктМенюСедьмой:
                    ///
                case 6:




                    Log.d(getApplicationContext().getClass().getName(), " ЗАПУСК ИЗ МЕНЮ ОБНОВЛЕНИЕ ПО С ДВУМЯ ДЕЙСТИЯ УДАЛЕНИЕ ЛЮБОЙ УЖЕ СКАЧЕННОЙ ВЕРСИИ И ПОЛУЧЕНИЕ НОВОЙ " + "--" + new Date());/////
                    ////


                    МетодОбновленияПОИзДвухДействийСначалоУдалениеЛюбойВерсииИЗатемСкачиваемЗановоИОбновляемПО();


                    // TODO: 17.03.2021 метд дополнительного удаления  И ПЛЮС ОБНОВЛЕНЕИ ПО

                    Log.d(getApplicationContext().getClass().getName(), " ЗАПУСК ИЗ МЕНЮ ОБНОВЛЕНИЕ ПО ПРОШЛО " + "--" + new Date());/////

                    /// МетодДиалогаДляМеню(" Вид Просмотра Данных", "Просмотр во весь экран ?");
                    return true;



////ПРОСТО ТАК НЕ ВЫБРАЛИ НИЧЕГО////ПРОСТО ТАК НЕ ВЫБРАЛИ НИЧЕГО////ПРОСТО ТАК НЕ ВЫБРАЛИ НИЧЕГО////ПРОСТО ТАК НЕ ВЫБРАЛИ НИЧЕГО////ПРОСТО ТАК НЕ ВЫБРАЛИ НИЧЕГО
                default:
                    Log.d(this.getClass().getName(), " МЕНЮ default:" + item.getItemId());

                    return super.onOptionsItemSelected(item);
                // break;

            } // конец switch (item.getItemId())





            ///////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return super.onOptionsItemSelected(item);

    }

    private void МетодПодключениеObserverДляБазы() {



        // TODO: 16.12.2021  --ОДНОРАЗОВАЯ СИНХРОНИАЗЦИЯ СЛУШАТЕЛЬ

         observerОдноразоваяFACEAPP = new Observer<List<WorkInfo>>() {
            @Override
            public void onChanged(List<WorkInfo> workInfosОдноразовая) {


                try {
                    // TODO: 23.12.2021
                    workInfosОдноразовая.stream()
                            .filter(ТекущийСтатусОбноразоваяСинхрониазации ->
                                    ТекущийСтатусОбноразоваяСинхрониазации.getState().compareTo(WorkInfo.State.SUCCEEDED)==0)
                            .forEachOrdered((ТекущийСтатусОбноразоваяСинхрониазации) ->{
                                // TODO: 24.02.2022
                                    //
                                    Log.d(this.getClass().getName(), " observerОдноразоваяFACEAPP WorkInfoИнформацияОЗапущенойСлужбеОдноразовая  ТекущийСтатусОбноразоваяСинхрониазации "
                                            + ТекущийСтатусОбноразоваяСинхрониазации.getState().name());

                                 Long   CallBaskОтWorkManagerОдноразового=0l;

                                    CallBaskОтWorkManagerОдноразового=   ТекущийСтатусОбноразоваяСинхрониазации
                                            .getOutputData().getLong("ОтветПослеВыполения_MyWork_Async_Синхронизация_Одноразовая",0l);

                                    // TODO: 14.01.2022

                                    if(CallBaskОтWorkManagerОдноразового==null){

                                        // TODO: 23.02.2022
                                        CallBaskОтWorkManagerОдноразового=0l;
                                    }

                                    //
                                    Log.d(this.getClass().getName(), " CallBaskОтWorkManagerОдноразового " + CallBaskОтWorkManagerОдноразового+
                                            " workInfo " +ТекущийСтатусОбноразоваяСинхрониазации.getState().name());

                                    // TODO: 02.02.2022

                                    if (CallBaskОтWorkManagerОдноразового>0) {

                                        // TODO: 23.02.2022
                                        


                                        Toast toast=       Toast.makeText(getApplicationContext(), null, Toast.LENGTH_LONG);

                                        // TODO: 23.12.2021  ЗАПУСКАЕМ ПОВТРОНУЮ СИНХРОНИАЗУИБЮ

                                        toast.setText(" Обмен Данными ▲ ▼  кол: " + CallBaskОтWorkManagerОдноразового);

                                        // TODO: 31.10.2021
                                        toast.setGravity(Gravity.BOTTOM,0,40);

                                        toast.show();
                                    }
                                    //
                                        //
                                        Log.d(this.getClass().getName(), " CallBaskОтWorkManagerОдноразового " + CallBaskОтWorkManagerОдноразового+
                                                " workInfo " +ТекущийСтатусОбноразоваяСинхрониазации.getState().name());

                                        // TODO: 31.10.2021
                                        if (CallBaskОтWorkManagerОдноразового>0) {
                                            // Vibrate for 500 milliseconds


                                        }
                                        //
                                        Log.d(this.getClass().getName(), " CallBaskОтWorkManagerОдноразового "
                                                + CallBaskОтWorkManagerОдноразового+
                                                " workInfo " +ТекущийСтатусОбноразоваяСинхрониазации.getState().name());
                                    // TODO: 07.02.2022

                            });


                    // TODO: 29.09.2021  конец синхрониазции по раписанию
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка ОодрорраазоовйЗ " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                }

            }
        };

// TODO: 07.02.2022  одписываемсч от WOrk СЛУШАТЕЛЯ ВОР МЕНЕДЖЕРА   


        if (observerОдноразоваяFACEAPP!=null) {
            // TODO: 23.02.2022
            WorkManager.getInstance(getApplicationContext()).getWorkInfosByTagLiveData(ИмяСлужбыСинхронизацииОдноразовая).observeForever(observerОдноразоваяFACEAPP);
        }


    }






    private boolean МетодЗапускаСинихрниазцииИзМенюНаАктивтиFACEAPP() {
        try{




        ///////TODO ТУТ ЗАПУСКАЕМ СИНХРОНИЗАЦИЮ В  ФОНЕ КОТОРАЯ НАХОДИТЬСЯ ЗАПУСКАЮЩИЙ МЕТОД В АКТИВИТИ  MainActivity_Tabel_Only_Single_Employee() СОТРУДНИКИ



                // TODO: 09.04.2021 запуск синхронизации фоновой по расписанию
                boolean РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию=
                        new  Class_Find_Setting_User_Network(getApplicationContext()).МетодПроветяетКакуюУстановкуВыбралПользовательСети();



                //TODO ФУТУРЕ ЗАВЕРШАЕМ
                Log.d(this.getClass().getName(), "  РезультатПроВеркиУстановкиПользователяРежимРаботыСети "
                        + РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию);





                ///////////////
            final Boolean[] РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции = {false};




   Class_Connections_Server class_connections_serverПингаСерераИзАктивтиМеню=         new Class_Connections_Server(getApplicationContext());

          // TODO: 01.10.2021

                PUBLIC_CONTENT public_contentЗапусСинхрониазцииИМеню=new PUBLIC_CONTENT(getApplicationContext());
                //

                final Integer[] ФинальныйРезультатФоновойСинхронизации = {0};
                ///
                ProgressDialog progressDialogДляСинхронизации;
                // TODO: 26.10.2021
                // TODO: 26.10.2021
                progressDialogДляСинхронизации = new ProgressDialog(activity);

                // TODO: 12.10.2021  Ссылка Менеджер Потоков




                      //TODO перерд началом синхрониазции запускаем прорасс бар

                            progressDialogДляСинхронизации.setTitle("Синхронизация");

                                progressDialogДляСинхронизации.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                                progressDialogДляСинхронизации.setProgress(0);
                                ///
                                /// progressDialogДляУдаления.setMax(СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.size());


                                progressDialogДляСинхронизации.setCanceledOnTouchOutside(false);

                                //progressDialogДляУдаления.setMessage("Удалание...");

                                progressDialogДляСинхронизации.setMessage("Обмен данными ....");

                                // progressDialogДляУдаления. setIndeterminateDrawable(getApplicationContext().getResources().getDrawable(R.color.accent));
                                ///
                                progressDialogДляСинхронизации.show();


            // TODO: 02.02.2022 запуск синхрониазции из Активти из МЕНЮ FACEAPP
            Observable observableЗапускамСинхронизацииИзАктивтиFACEAPP=Observable.fromAction(new Action() {
                @Override
                public void run() throws Throwable {


                    // TODO: 01.10.2021
                    if (РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию==true) {


                        ////////////
                        РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0] = class_connections_serverПингаСерераИзАктивтиМеню.
                                МетодПингаСервераРаботаетИлиНетТОлькоДЛяACTIVITYFACEAPP(getApplicationContext());


                        Log.d(this.getClass().getName(), "  Completable.fromAction  " +
                                "РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции "+
                                РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0]);

                    }


                }
            }).subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .delay(2,TimeUnit.SECONDS)
                    .take(1,TimeUnit.MINUTES)
                    .doOnError(new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Throwable {
                            ////
                            Log.e(this.getClass().getName(), "  doOnError " +
                                    "Синхронизация Данных с Web-сервера ДСУ-1 ?  ФинальныйРезультатФоновойСинхронизации "+ ФинальныйРезультатФоновойСинхронизации[0]+
                                    "Thread.currentThread().getName() "+Thread.currentThread().getName()+ " throwable "+throwable.fillInStackTrace().getMessage() );
                            ////
                        }
                    })
                    .doOnComplete(new Action() {
                        @Override
                        public void run() throws Throwable {

                            // TODO: 02.02.2022
                            Log.w(this.getClass().getName(), "  doOnComplete " +
                                    "Синхронизация Данных с Web-сервера ДСУ-1 ? РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0]  "
                                    + РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0]);

                            if (  РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0]  ==false ) {


                                activity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast toast=       Toast.makeText(getApplicationContext(), "Режим работы сети не позволяет обмен данными !!!!!", Toast.LENGTH_LONG);
                                        toast.setGravity(Gravity.BOTTOM,0,40);
                                        toast.show();
                                    }
                                });


                            }else {


                                ///////
                                LinkedBlockingQueue ЗаполненыеСистемныеТаблицыДЛяСинхронизации = new Class__Generation_Genetal_Tables(getApplicationContext()).
                                        МетодЗаполеннияТаблицДЛяРаботыиСинхрониазции();
                                //TODO ФУТУРЕ ЗАВЕРШАЕМ
                                Log.d(this.getClass().getName(), "  ЗаполненыеСистемныеТаблицыДЛяСинхронизации " + ЗаполненыеСистемныеТаблицыДЛяСинхронизации.size());


                                // TODO: 01.07.2021  ЗАПУСКАЕМ ВИЗУАЛЬНУЮ СИНХРОНИЗИЦИЮ С АКТИВТИ ЧДЕ КРУТИТЬСЯ ПРОГРЕСС БАР
                                Integer  ПубличныйIDДляОдноразовойСинхрониазции=
                                        new Class_Generations_PUBLIC_CURRENT_ID(getApplicationContext()).ПолучениеПубличногоТекущегоПользователяID();


                                Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента  ИЗ ВСЕХ ТАБЕЛЕЙ ПубличныйIDДляОдноразовойСинхрониазции " + ПубличныйIDДляОдноразовойСинхрониазции);

                                // TODO: 27.10.2021 ЗАПУСК ЧИНХРОНИАЗЦИИ ОДНОРАЗОВОЙ ПОСЛЕ СОЗЛАНИЕ НОВГО СООБЕШИЯ

                                new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).
                                        МетодПовторногоЗапускаВсехWorkManager__ОДНОРАЗОВОЙСинхрониазцииданных(Integer.parseInt(ПубличныйIDДляОдноразовойСинхрониазции.toString()),
                                                getApplicationContext());

                                //  МетодПринудительногоАЗпускаУведомлений();
                                Log.d(this.getClass().getName(), "Синхронизация Данных с Web-сервера ДСУ-1 ?  ФинальныйРезультатФоновойСинхронизации[0] "+
                                        ФинальныйРезультатФоновойСинхронизации[0]);

                            }

                            Log.w(this.getClass().getName(), "  doOnComplete " +
                                    "Синхронизация Данных с Web-сервера ДСУ-1 ? РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0] "
                                    + РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0]);

                        }
                    })
                    .onErrorComplete(new Predicate<Throwable>() {
                        @Override
                        public boolean test(Throwable throwable) throws Throwable {
                            ////
                            Log.e(this.getClass().getName(), "  onErrorComplete " +
                                    "Синхронизация Данных с Web-сервера ДСУ-1 ?  ФинальныйРезультатФоновойСинхронизации "+ ФинальныйРезультатФоновойСинхронизации[0]+
                                    "Thread.currentThread().getName() "+Thread.currentThread().getName()+ " throwable "+throwable.fillInStackTrace().getMessage() );
                            return false;
                        }
                    })
                    .doOnTerminate(new Action() {
                        @Override
                        public void run() throws Throwable {
                            activity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialogДляСинхронизации.dismiss();
                                    ////
                                    progressDialogДляСинхронизации.cancel();
                                    // TODO: 26.10.2021
                                    System.out.println( "doOnTerminate  Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков.poll().get() ");
                                    Log.w(this.getClass().getName(), "  doOnComplete " +
                                            "  doOnTerminate Синхронизация Данных с Web-сервера ДСУ-1 ? РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0] "
                                            + РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0]);

                                }
                            });
                        }
                    });

            // TODO: 02.02.2022

            observableЗапускамСинхронизацииИзАктивтиFACEAPP.subscribe(System.out::println);


            Log.w(this.getClass().getName(), "  doOnComplete " +
                    "Синхронизация Данных с Web-сервера ДСУ-1 ? РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0] "+ РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0]);


        //////////
} catch (Exception e) {
    e.printStackTrace();
    ///метод запись ошибок в таблицу
    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
    new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            return true;
}
        return false;
    }






















    //TODO метод состоит из двух операцию удаление любой уже скаченой версии программы и обновление новой ПО
    private void МетодОбновленияПОИзДвухДействийСначалоУдалениеЛюбойВерсииИЗатемСкачиваемЗановоИОбновляемПО() {
        // TODO: 11.05.2021 ЗПУСКАЕМ СЛУЖБУ ОБНОВЛЕНИЕ ПО

            try{

                // TODO: 21.10.2021  # 1
                // TODO: 09.04.2021 запуск синхронизации фоновой по расписанию
                boolean РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию=
                        new  Class_Find_Setting_User_Network(getApplicationContext()).МетодПроветяетКакуюУстановкуВыбралПользовательСети();

                //TODO ФУТУРЕ ЗАВЕРШАЕМ
                Log.d(this.getClass().getName(), "  РезультатПроВеркиУстановкиПользователяРежимРаботыСети " + РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию);

                if (РезультатПроВеркиУстановкиПользователяРежимРаботыСетиСтоитЛиЗапускатьСсинхронизацию==true) {


                    ////////////
/*                    Boolean РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции =
                            new Class_Connections_Server(getApplicationContext()).МетодПингаСервераРаботаетИлиНет(getApplicationContext());*/



                    //TODO конец выполения кода через Callble  , отправляем его в главный менеджер пОТОКОВ

                    final Boolean[] РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции = {false};

                    // TODO: 02.09.2021  сам код

                    // TODO: 16.12.2021 НЕПОСРЕДСТВЕННЫЙ ПИНГ СИСТЕНМ ИНТРЕНАТ НА НАЛИЧЕНИ СВАЗИ С БАЗОЙ SQL SERVER
                    РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0]  =
                            new Class_Connections_Server(getApplicationContext()).МетодПингаСервераРаботаетИлиНет(getApplicationContext());


                    //TODO ФУТУРЕ ЗАВЕРШАЕМ
                    Log.d(this.getClass().getName(), "  РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0]  " + РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0] );

                        ///todo ПИНГ СЕРВЕРА ПЛЮС ПИНГ САМИХ ДАННЫХ SQL SERVER


                                if (РезультатЕслиСвязьСерверомПередНачаломВизуальнойСинхронизции[0] == true) {


                                    // TODO: 12.11.2021  ПЕРВАЯ ОПЕРАЦИЯ УДАЛЕНИЕ ЛЮБОЙ УЖЕ СУЩЕСТВУЮЩЩИЙ ЛОКАЛЬНОЙ ВЕРИСИЙ ПРОГРАММЫ
                                    МЕтодЗапускСЛУЖБЫОбновленияПО();
                                    // TODO: 28.12.2021   Метод  ДАННЫЙ МЕТОД ВСЕГДА ПОСЛЕДНИЙ  если пришло Новоое Обновление По табельный УЧЁТ ПО ЗАПУСКАЕМ ЕГО ВСТАВКИ ПОКАЗЫВАЕМ ПОЛЬЗОВАТЕЛЮ


                                    // МетодВActivityFaveApp_УстанавливаетПрограммноеОбеспечениеПОТабельныйУчёт();


                                    //TODO ФУТУРЕ ЗАВЕРШАЕМ
                                    Log.d(this.getClass().getName(), "        МетодВActivityFaveApp_УстанавливаетПрограммноеОбеспечениеПОТабельныйУчёт(); ");


                                } else {


                                    activity.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast toast = Toast.makeText(getApplicationContext(), "Нет связи c Cервер !!!", Toast.LENGTH_LONG);
                                            toast.setGravity(Gravity.BOTTOM, 0, 40);
                                            toast.show();

                                            //TODO ФУТУРЕ ЗАВЕРШАЕМ
                                            Log.d(this.getClass().getName(), "  НЕТ СВЯЗИ С СЕРВЕРОМ  МетодВActivityFaveApp_УстанавливаетПрограммноеОбеспечениеПОТабельныйУчёт();  ");
                                        }
                                    });


                                }


                        // TODO: 18.12.2021






                }
                ///
            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
            }
    }





























    private Integer МетодДополнительногоУдалениеФайлов() {


        Integer РезультатУдаления=0;
        try{


/////TODO  УДАЛЕНИЕ .JSON ФАЙЛА
               /* File  ФайлыДляОбновлениеПОУдаление = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS + "/" + "*.json");*/

            File  ФайлыДляОбновлениеПОУдалениеПриАнализеJSONВерсии = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS );

            File[] Files = ФайлыДляОбновлениеПОУдалениеПриАнализеJSONВерсии.listFiles();

            if(Files != null) {
                int j;
                for(j = 0; j < Files.length; j++) {
                    String ИмяФайла=Files[j].getName();
                    boolean ПосикПоНазваниюФайла=ИмяФайла.matches("(.*)json(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");
                    boolean ПосикПоНазваниюФайлаРасширенная=ИмяФайла.matches("(.*)analysis_version(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");

                    if(ПосикПоНазваниюФайла==true || ПосикПоНазваниюФайлаРасширенная==true) {
                        Files[j].delete();
                        //
                        /////
                        if (!Files[j].isFile()) {
                            Log.d(this.getClass().getName(), " СЛУЖБА  ТАКОГО ФАЙЛА БОЛЬШЕ НЕТ  .JSON АНАЛИЗ " + Files[j].length()
                                    + "   путь файла " +  Files[j].getAbsolutePath() + "   --- "  +new Date() + " ИмяФайла "+ИмяФайла);
                        }
                    }
                    ////    ФайлыДляОбновлениеПОУдаление.delete();

                }//ещыыщ
            }





            /////TODO  УДАЛЕНИЕ .JSON ФАЙЛА
               /* File  ФайлыДляОбновлениеПОУдаление = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS + "/" + "*.json");*/

            if(Files != null) {
                int j;
                for(j = 0; j < Files.length; j++) {
                    String ИмяФайла=Files[j].getName();
                    boolean ПосикПоНазваниюФайла = ИмяФайла.matches("(.*)apk(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");
                    boolean ПосикПоНазваниюФайлаРасширенная = ИмяФайла.matches("(.*)update_dsu1(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");

                    if(ПосикПоНазваниюФайла==true || ПосикПоНазваниюФайлаРасширенная==true) {
                        Files[j].delete();
                        //
                        /////
                        if (!Files[j].isFile()) {
                            Log.d(this.getClass().getName(), " СЛУЖБА  ТАКОГО ФАЙЛА БОЛЬШЕ НЕТ  .JSON АНАЛИЗ " + Files[j].length()
                                    + "   путь файла " +  Files[j].getAbsolutePath() + "   --- "  +new Date() + " ИмяФайла "+ИмяФайла);
                        }
                    }
                    ////    ФайлыДляОбновлениеПОУдаление.delete();

                }//ещыыщ
            }










        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

            Log.d(this.getClass().getName(), " ошибка  faceapp из меню МетодДополнительногоУдалениеФайлов Обновление ПО ");

            РезультатУдаления=null;

        }
        return РезультатУдаления;
    }


    /////////TODO ЗАУСК APK

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void МетодТестовыйЗапускВизуальноФайлаApK() throws IOException, JSONException {

        try{




   /*     String destination = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/";
        String fileName = "update_dsu1.apk";
        destination += fileName;
        Uri uri = Uri.parse("file://" + destination);*/

            File ФайлыДляОбновлениеПО = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS + "/" + "update_dsu1.apk");


            Log.d(this.getClass().getName(), "    ПУТИ В ФАЙЛУ   " + "\n"
                    + ФайлыДляОбновлениеПО);


            if (ФайлыДляОбновлениеПО.isFile()) {

                Log.d(this.getClass().getName(), "  storageDir.getAbsolutePath()  " + ФайлыДляОбновлениеПО.getAbsolutePath() + "\n" +
                        "  storageDir.getCanonicalPath()   " + ФайлыДляОбновлениеПО.getCanonicalPath() + "\n" +
                        " storageDir.getName() " + ФайлыДляОбновлениеПО.getName() + "\n" +
                        "  storageDir.exists() " + ФайлыДляОбновлениеПО.exists() + "\n" +
                        "+storageDir.length() " + ФайлыДляОбновлениеПО.length());





                ///TODO  ЗАПУСКА APK ФАЙЛОВ

           /* Uri uri = Uri.parse("file:///sdcard/xxx/log.txt");
            Intent viewTestLogFileIntent = new Intent(Intent.ACTION_EDIT);
            viewTestLogFileIntent.setData(uri);
            viewTestLogFileIntent.setType("text/plain");
            code3: который я пробовал и работал нормально

            Uri uri = Uri.parse("file:///sdcard/xxx/log.txt");
            Intent viewTestLogFileIntent = new Intent(Intent.ACTION_EDIT);
            viewTestLogFileIntent.setDataAndType(uri,"text/plain");*/



                File ФайлыДляОбновлен = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS + "/" + "analysis_version.txt");///analysis_version.json //analysis_version.txt  //update_dsu1.apk


                if (ФайлыДляОбновлен.isFile()) {
                    Uri uri = Uri.parse("file://" + "analysis_version.txt");

       /*         Uri videoUri = FileProvider.getUriForFile(this,
                        getApplicationContext().getPackageName() + ".provider",
                        new File(destination));

// устанавливаем флаг для того, чтобы дать внешнему приложению пользоваться нашим FileProvider
                String destination2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/";
                String fileName2 = "analysis_version.txt";
                destination2 += fileName2;
                Uri textUri = FileProvider.getUriForFile(this,
                        getApplicationContext().getPackageName() + ".provider",
                        new File(destination));*/

                }




                String destination = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/";
                String fileName = "update_dsu1.apk";
                destination += fileName;





                Uri textUri3 = FileProvider.getUriForFile(this,
                        getApplicationContext().getPackageName() + ".provider",
                        new File(destination));

                Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
                intent.setDataAndType(textUri3, "application/vnd.android.package-archive");
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION |
                        Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION| Intent.FLAG_GRANT_PREFIX_URI_PERMISSION
                        | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true);



// подтвердите, что устройство может открыть этот файл!
                PackageManager pm = getApplicationContext().getPackageManager();
                if (intent.resolveActivity(pm) != null) {
                    startActivity(intent);
                    finishAndRemoveTask();
                }







                Log.d(this.getClass().getName(), "  ФайлыДляОбновлениеПО " + ФайлыДляОбновлен.exists() + " ФайлыДляОбновлен.length() " +ФайлыДляОбновлен.length());







            } else {
                Log.d(this.getClass().getName(), "  ОШИБКА НЕТ КАКОГО ФАЙЛА  . APK" + ФайлыДляОбновлениеПО.length());
            }











        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }





    }



}



// TODO: 23.02.2022 ВТОРОЙ SUB СЛАСС

class SUBClassBISNESSLOGICA_ForActivityFaceApp extends  MainActivity_Face_App{

    Context context;
    // TODO: 23.02.2022
    Activity activity;


    public SUBClassBISNESSLOGICA_ForActivityFaceApp(Context context , Activity activity) {
        this.context = context;
        // TODO: 23.02.2022
        this.activity=activity;
    }

    ///MESSGABOX ДЛЯ ГЛАВНОГО МЕНЮ    ///MESSGABOX ДЛЯ ГЛАВНОГО МЕНЮ    ///MESSGABOX ДЛЯ ГЛАВНОГО МЕНЮ    ///MESSGABOX ДЛЯ ГЛАВНОГО МЕНЮ    ///MESSGABOX ДЛЯ ГЛАВНОГО МЕНЮ    ///MESSGABOX ДЛЯ ГЛАВНОГО МЕНЮ    ///MESSGABOX ДЛЯ ГЛАВНОГО МЕНЮ
    @UiThread
    protected void МетодДиалогаДляМеню(String ШаблонСообщения, String Самообщение) {
        try {
//////сам вид
            final AlertDialog DialogBox = new MaterialAlertDialogBuilder(activity)
                    .setTitle(ШаблонСообщения)
                    .setMessage(Самообщение)
                    .setPositiveButton("Да", null)
                    .setNegativeButton("Нет", null)
                    .setIcon(R.drawable.icon_dsu1_web_success)
                    .show();
            final Button MessageBox = DialogBox.getButton(AlertDialog.BUTTON_POSITIVE);
            MessageBox.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onClick(View v) {
///запуск метода обновления через DIALOGBOX
                    try {
//удаляем с экрана Диалог
                        DialogBox.dismiss();
                        Intent Интент_Меню = new Intent();
                        //////
                        switch (ШаблонСообщения.trim()){
                            ///////todo по словам запускаем то что выбралив меню
                            case "Ошибки системы":

                                //todo ТЕКСТ КОД

                                try{
                                    ///TODO тестовый код
                                    ////   МетодТестовыйЗапускВизуальноФайлаApK();

                                    /////
                                    Интент_Меню = new Intent(getApplication(), MainActivity_Errors.class);

                                    Интент_Меню.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//////FLAG_ACTIVITY_SINGLE_TOP

                                    startActivity(Интент_Меню);

                                    ///TODO запуск службы
                                    ///////
                                } catch (Exception e) {
                                    //  Block of code to handle errors
                                    e.printStackTrace();
                                    ///метод запись ошибок в таблицу
                                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                            + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                    new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                            Thread.currentThread().getStackTrace()[2].getLineNumber());
                                }




                                break;
                            ///////
                            case "Данных системы":

                        /*        Toast.makeText(getApplicationContext(),
                                        "запуск обмена данными."    , Toast.LENGTH_SHORT).show();*/
                 /*               ///TODO УСТАНАВЛИВАЕМ ФЛАГ ПРИ АУНТИФИКАЦИИ И МЯ И ПАРОЛЬ  СТАЫИМ ФЛАГ ОТКЛЮЧИТЬ ОБНОВЛЕНИЕ ПРИ СИНХРОНИЗАЦИИ false по умолчанию проверяем
                                new Class_Engine_SQL(getApplicationContext()).  МетодЗАпускаСинхронизациивФоне(КонтекстFaceApp);*/

                                try{


                                  //TODO запуск синхрониазции

                                    // TODO: 01.01.2022


                                    Integer ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(getApplicationContext()).ПолучениеПубличногоТекущегоПользователяID();


                                    if (ПубличныйIDДляФрагмента == null) {
                                        // TODO: 01.01.2022
                                        ПубличныйIDДляФрагмента = 0;
                                    }


                                    new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).
                                            МетодПовторногоЗапускаВсехWorkManager__ОДНОРАЗОВОЙСинхрониазцииданных(ПубличныйIDДляФрагмента,getApplicationContext());


                                    // TODO: 24.12.2021




                                    Log.d(this.getClass().getName(), "    case \"Данных системы\": запуск синхрониазции из активти Одноразвой Службой  ");



                                    //////////
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    ///метод запись ошибок в таблицу
                                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                    new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

                                }



                                break;







                            ///////
                            case "Пользователи Системы":
                                /////todo меняем пользователя и меняем его данные под корень и ПЛЮЧ МЕНЯЕМ ВЕРСИЮ ДАННЫХ


                                    ///TODO УСТАНАВЛИВАЕМ ФЛАГ ПРИ АУНТИФИКАЦИИ И МЯ И ПАРОЛЬ  СТАЫИМ ФЛАГ ОТКЛЮЧИТЬ ОБНОВЛЕНИЕ ПРИ СИНХРОНИЗАЦИИ false по умолчанию проверяем

                                    // PUBLIC_CONTENT.ФлагПриПервомЗапускеОграничитьОперациюТолькоВставка=false;

                                    //////TODO  данный код срабатывает когда произошда ошивка в базе  ОЧИСТКА БАЗЫ И ПРИ СМЕНЕ ПОЛЬЗОВАТЕЛДЯ

                                Integer РезультатОчистикТАблицИДобалениеДаты=0;

                                    try{
                                        Handler handlerУдалениеТаблицПринудительно=new Handler();
                                        //////TODO  данный код срабатывает когда произошда ошивка в базе  ОЧИСТКА БАЗЫ И ПРИ СМЕНЕ ПОЛЬЗОВАТЕЛДЯ

                                        PUBLIC_CONTENT                 Class_Engine_SQLГдеНаходитьсяМенеджерПотоков=new PUBLIC_CONTENT(activity);

                       РезультатОчистикТАблицИДобалениеДаты=
                                 new Class_Clears_Tables(activity,handlerУдалениеТаблицПринудительно)
                                         .ОчисткаТаблицДляПользователяЗапусксFaceApp(activity,
                                 Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,
                                                 activity);
                                                //


                                        Log.d(this.getClass().getName(), "   ЗАПУСК ФОНРезультатОчистикТАблицИДобалениеДаты "+
                                                РезультатОчистикТАблицИДобалениеДаты);




                                    } catch (Exception e) {
                                        //  Block of code to handle errors
                                        e.printStackTrace();
                                        ///метод запись ошибок в таблицу
                                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                                    }





                                ////
                                break;
                            ///////
                            case "Настройка системы":
                                /////данные с потока
                                /////TODO ЗАПУСКАМ ОБНОЛВЕНИЕ ДАННЫХ С СЕРВЕРА ПЕРЕРД ЗАПУСКОМ ПРИЛОЖЕНИЯ ВСЕ ПРИЛОЖЕНИЯ ДСУ-1
                                Интент_Меню.setClass(getApplication(),  MainActivity_Settings.class); //MainActivity_Visible_Async //MainActivity_Face_App
                                Интент_Меню.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//////FLAG_ACTIVITY_SINGLE_TOP
                                startActivity( Интент_Меню);
                                ////TODO ДАННАЯ КОМАНДА ПЕРЕКРЫВАЕТ НЕ ЗАПУСКАЕМОЕ АКТИВТИ А АКТИВТИ КОТОРЕ ЕГО ЗАПУСТИЛО
                                finish();
                                break;
                        }

//ловим ошибки
                    } catch (Exception e) {
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                        // конец запись в файл
                    }

                }






            });

        } catch (Exception e) {
            e.printStackTrace();
///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
           new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        ///////////СЕРВЕР  ///////////СЕРВЕР  ///////////СЕРВЕР  ///////////СЕРВЕР  ///////////СЕРВЕР  ///////////СЕРВЕР  ///////////СЕРВЕР  ///////////СЕРВЕР  ///////////СЕРВЕР

    }

    private void МетодПослеУдаленияТаблицЗапускаемСледуюЩеЗанимАктивтиИмяИПароль(Intent Интент_Меню) {
        Intent finalИнтент_Меню = Интент_Меню;

        try {
        ////////
        /// КакойРежимСинхрониазции = ИнтентКакаяПоСчетуСинхронизация.getStringExtra("РежимЗапускаСинхронизации");
        Toast.makeText(getApplicationContext(), " Удаляемая таблица прошло успешно !!! " , Toast.LENGTH_SHORT).show();

        finalИнтент_Меню.putExtra("РежимЗапускаСинхронизации","ПовторныйЗапускСинхронизации");

        /////TODO ЗАПУСКАМ ОБНОЛВЕНИЕ ДАННЫХ С СЕРВЕРА ПЕРЕРД ЗАПУСКОМ ПРИЛОЖЕНИЯ ВСЕ ПРИЛОЖЕНИЯ ДСУ-1
        finalИнтент_Меню.setClass(КонтекстFaceApp, MainActivity_Tabels_Users_And_Passwords.class); //MainActivity_Visible_Async //MainActivity_Face_App

        finalИнтент_Меню.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//////FLAG_ACTIVITY_SINGLE_TOP

        startActivity(finalИнтент_Меню);

        ////TODO ДАННАЯ КОМАНДА ПЕРЕКРЫВАЕТ НЕ ЗАПУСКАЕМОЕ АКТИВТИ А АКТИВТИ КОТОРЕ ЕГО ЗАПУСТИЛО
        finish();

    } catch (Exception e) {
        e.printStackTrace();
///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
    }


    protected class SubClassВызоваАктивтиИзМеню {



    // TODO: 23.02.2022 вызов настроек

   protected void МетодЗапускаИзМенюНастроек() {
        try{
            ///TODO тестовый код
            ////   МетодТестовыйЗапускВизуальноФайлаApK();

            /////
            Intent      Интент_Меню = new Intent(context, MainActivity_Settings.class);

            Интент_Меню.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//////FLAG_ACTIVITY_SINGLE_TOP



            ///////TODO ОСТАНАВЛИВАЕМ СЛУЖБУ ЧЕРЕЗ 20 СЕКУНД
            Log.d(this.getClass().getName(), "" +
                    "          case R.id.ПунктМенюВторой:");

            context.      startActivity(Интент_Меню);

            ///TODO запуск службы
            ///////
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
}
// TODO: 07.02.2022  под класс который закрываемт слушатель на активити FACAPP


protected class SubClass_Closeo_bserverОдноразоваяFACEAPP_to_MainActivity_Face_App  {

    // TODO: 23.02.2022


    void МетодОдписыОТСлушателяРезультатПринудительноСинхрониазцииЗапущенойСFACEAPP(Context context
            ,Observer  observerОдноразоваяFACEAPP,
                                                                                    String ИмяСлужбыСинхронизацииОдноразовая) {
        try{
            if (observerОдноразоваяFACEAPP!=null) {

                WorkManager.getInstance(context).getWorkInfosByTagLiveData(ИмяСлужбыСинхронизацииОдноразовая).removeObserver(observerОдноразоваяFACEAPP);
                // TODO: 23.02.2022

                WorkManager.getInstance(context).cancelAllWorkByTag(ИмяСлужбыСинхронизацииОдноразовая);

            }
            Log.w(this.getClass().getName(), "removeObserver  removeObserver ОТПИСКА ОТ СЛУШАТЕЛЯ НА АКТИВТИ FACE_APP" );

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


}
}