package com.dsy.dsu;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteCursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

//класс активити MainActivity_New_Tabely
public class MainActivity_New_Tabely extends AppCompatActivity {

    //обьявление полей
    protected EditText ПолеПочты, ПолеПароля, ПолеПовторногоПароля, ПолеМакАдрес, ПолеДатаСоздания, ПолеОтдел;
    protected Button КнопкаСохранениеНовогоТабеляЗаписиВИторию;
    protected EditText ПолеФИО, ПолеДолжность;
    protected Spinner СпинерВыборЦФО,СпинерВыборДата;/////спинеры для создание табеля
    String ПолученноеЗначениеИзСпинераЦФО,ПолученноеЗначениеИзСпинераРаздел; ///результат полученный из спенров
    //////результат что произошла вставка или нет
    String ПолученнаяДатаОтДруговаИнтрентаДляСозданиеТабеля;
    //
    private String СтатусВставкиЛогина;
    protected Button КнопкаСозданиеТабеля;

    String  ПолученноеТекущееЗначениеСпинераЦФО= "";

    String  ПолученноеТекущееЗначениеСпинераПодразделения= "";

    String ПубличноеИмяНовогоТабеля;

 Button КнопкаНазадПриСозданииНовогоТабеля;

    String  ПолученноеТекущееЗначениеСпинераДата;
/////ДВА ХЭШМЭПА ДЛЯ СОЗДАНИЕ НОВОГО ТАБЕЛЯ  СФО И ДЕПАРТАМЕНТ
    LinkedHashMap<String, String> ХэшДанныеИзБазыДляЗАполенияСпинеровыСФО = new LinkedHashMap<String, String>();
    LinkedHashMap<String, String> ХэшДанныеИзБазыДляЗАполенияСпинеровыДепартамент = new LinkedHashMap<String, String>();
    /////ДВА ХЭШМЭПА ДЛЯ СОЗДАНИЕ НОВОГО ТАБЕЛЯ  СФО И ДЕПАРТАМЕНТ
    ///
    String МесяцВырезалиИзБуфераТабель= "";

    String ГодВырезалиИзБуфераТабель= "";

    String ПолученныйГодДляНовогоТабеля;

    String ФинальнаяМЕсяцДляНовогоТабеля;

    ///после успешной вставки сотрудника
    String ПолноеИмяТабеляПослеСозданиеНовогоСотрудника= "";
    //// для вставки данных
    String  IDДляЗаполенияСпинера;

     Long  СгенерированныйUUIDДляНовогоТабеля;


    String ПолученноеТекущееЗначениеСпинераЦФОфинал;
Context Контекст;


protected  long ЦифровоеИмяНовгоТабеля;

protected         int ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО;

    HashMap<Integer, Integer> ХэшДляПубличногоIDДляСозданиеТабеля   =new HashMap() ;

    ///////TODO
    CREATE_DATABASE   Create_Database_СсылкаНАБазовыйКласс;

    // TODO: 12.10.2021  Ссылка Менеджер Потоков

    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =null;


    ////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            //определяем дату вставки
            Log.d(this.getClass().getName(), "Запуск onCreate..  в MainActivity_New_Tabely ");
            //важно пересоздаем  CREATE_DATABASE  в коде Активити
            ///TODO попытка открыть экран как full screan

                super.onCreate(savedInstanceState);

            setContentView(R.layout.activitymain_createtablesavehistory);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            //////todo  конец настрока экрана
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

            getSupportActionBar().hide(); ///скрывать тул бар


            Контекст=this;
            /////

            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new  PUBLIC_CONTENT(getApplicationContext());


            //////todo настрока экрана
         //   getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION  );

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                    | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                    | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

            /////todo данная настрока запрещает при запуке активти подскаваать клавиатуре вверх на компонеты eedittext
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

            getSupportActionBar().hide(); ///скрывать тул бар


            ///todo кнопака создание нового пустого табеля без сотрудников
            КнопкаСозданиеТабеля = findViewById(R.id.КнопкаСозданиеНовогоТабеля);
///todo спинер КУДА ИЗ БАЗЫ ЗАГРУЖАЕТЬСЯ СФО
            СпинерВыборЦФО=findViewById(R.id.ЗначениеЦФОПриСозданииНовогоТабеля);
////TODO BACK КНОПКА
       КнопкаНазадПриСозданииНовогоТабеля  =findViewById(R.id.КнопкаНазадСтрелкаСозданиеНовгоТабеля);





///////TODO
               Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(getApplicationContext());


/////////////////////cСОЗДАНИЕ НОВГО ЛОГИНА

            /////получаем значение от другова активикти
            /////TODO ПОЛУЧАЕМ ДАННЫЕ ОТ ДРУГОВА АКТИВИТИ ТРИ ЗНАЧЕНИЯ ПОЛНОЙ НАЗВНЕИ МЕСЯЦ И ОТДЕЛЬНО МЕСЯЦ И ГОД
            МетодПолученогоИОтправленогоКонтента();


            ///TODO метода запуска
            //////СОЗДАННИЕ СПИНЕРОВ ДЛЯ ВЫБОРА ДАННЫХ
            МетодСозданиеСпинеровДляВыбораЦФОИТД();

            //////метод создание
          new Class_Create_New_Tabel().  МетодСозданиеТабеля();






///TODO BACK
            МетодСозданиеКодBACK();



//// по нажатию на кнопку начинает работать
            // МетодСозданиеНовогоТабелясСохранениемвТаблицуистория(); //// метод создание нового табеля с сохранением в историю

            ///поймать ошибку
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
          // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), 
          this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///////
        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();

        //////TODO  данный код срабатывает когда произошда ошивка в базе

    }






    void МетодПолученогоИОтправленогоКонтента() {
        try{
        Intent ИнтентПолучаемДатуДляСозданиеТабеля=getIntent();////ЛОВИМ ДАТУ

            if (ПолученнаяДатаОтДруговаИнтрентаДляСозданиеТабеля==null) {
                ПолученнаяДатаОтДруговаИнтрентаДляСозданиеТабеля= ИнтентПолучаемДатуДляСозданиеТабеля.getStringExtra("ПолученноеЗначениеИзСпинераДата");
                Log.d(this.getClass().getName(), " ПолученнаяДатаОтДруговаИнтрентаДляСозданиеТабеля  " +ПолученнаяДатаОтДруговаИнтрентаДляСозданиеТабеля);
            }

            if (ПолученныйГодДляНовогоТабеля==null) {
                ПолученныйГодДляНовогоТабеля= ИнтентПолучаемДатуДляСозданиеТабеля.getStringExtra("ПолученныйГодДляНовогоТабеля");
                Log.d(this.getClass().getName(), " ПолученныйГодДляНовогоТабеля " +ПолученныйГодДляНовогоТабеля);
            }

            if (ФинальнаяМЕсяцДляНовогоТабеля==null) {
                ФинальнаяМЕсяцДляНовогоТабеля= ИнтентПолучаемДатуДляСозданиеТабеля.getStringExtra("ФинальнаяМЕсяцДляНовогоТабеля");
                Log.d(this.getClass().getName(), " ФинальнаяМЕсяцДляНовогоТабеля  " +ФинальнаяМЕсяцДляНовогоТабеля);
            }


            if (ПолноеИмяТабеляПослеСозданиеНовогоСотрудника==null) {
                ПолноеИмяТабеляПослеСозданиеНовогоСотрудника  = ИнтентПолучаемДатуДляСозданиеТабеля.getStringExtra("ПолноеИмяТабеляПослеСозданиеНовогоСотрудника");
                Log.d(this.getClass().getName(), " ПолноеИмяТабеляПослеСозданиеНовогоСотрудника  " + ПолноеИмяТабеляПослеСозданиеНовогоСотрудника  );
            }


            if (ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО==0) {
                ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО  = ИнтентПолучаемДатуДляСозданиеТабеля.getIntExtra("ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО",0);
                ///
                Log.d(this.getClass().getName(), " ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО  " + ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО  );
            }


            ///поймать ошибку
    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), 
          this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///////
    }

    }

















    /////todo метод создание BACK
    private void МетодСозданиеКодBACK() {
        try{
            КнопкаНазадПриСозданииНовогоТабеля.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {


                    Log.d(this.getClass().getName(), " кликнем для созданни новго сотрдника при нажатии  ");

                    ///todo код которыц возврящет предыдущий актвитики кнопка back
                    Intent ИнтентВозврящемсяНазад = new Intent();

                    ИнтентВозврящемсяНазад.setClass(getApplication(), MainActivity_List_Tabels.class); // Т

                    ИнтентВозврящемсяНазад.putExtra("ДепартаментТабеляПослеПодбора", ПолученнаяДатаОтДруговаИнтрентаДляСозданиеТабеля);

                    //todo запускаем активти после успешно создданого сотрудка

                    // ТУТ ЗАПВСКАЕТЬСЯ ВЫБОР ПРИЛОЖЕНИЯ КОТОРЫЕ ЕСТЬ FACE APP НА ДАННЫЙ МОМЕТНТ РАЗРАБОТНАО ТАБЕЛЬНЫЙ УЧЁТ
                    ИнтентВозврящемсяНазад.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(ИнтентВозврящемсяНазад);
                    //////
                    //  finish();

                    return false;
                }
            });





        ///поймать ошибку
    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
          this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///////
    }
    }

















































/////TODO Цифроввое имени табеля














    //TODO метод провереям если название табеля в базе
    private boolean МетодПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть(@NotNull String ПубличноеИмяНовогоТабеля ,
                                                                      @NotNull String ГлавнаяДатаИВремяДляТабеля ,
                                                                      @NotNull  String ПолученноЦифровоеОбознаяниеЦФО,
                                                                      @NotNull  CompletionService МенеджерПотоковВнутри) throws InterruptedException, ExecutionException, TimeoutException, ParseException {


        SQLiteCursor Курсор_ПроверяемЕслиТакоеНазваниеТабеляУжеЕстьИлиНет = null;
        //
        Class_GRUD_SQL_Operations class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть;
        try {
            Log.d(this.getClass().getName(), " ГлавнаяДатаИВремяДляТабеля " + ГлавнаяДатаИВремяДляТабеля);

            // TODO: 11.06.2021 что сравнивать
            int НазваниеМЕсяца;

            int UUIDМЕсяца;

            Long UUIDТекущейОрганизацииДЛяТекущегоСотрудникаМЕсяца;



            //TODO ФУНКЙИИ ОПРЕДЕЛЕНИ МЕСЯЦА И ГОДА
            int МесяцДляОпределениееслиТакойНазваниеАбель = МетодПолучениниеМесяцДляОпределенияЕслиТАкойТАбельВБазеКлиента(ГлавнаяДатаИВремяДляТабеля);

            int ГодляОпределениееслиТакойНазваниеАбель = МетодПолучениниеГодЕслиТАкойТАбельВБазеКлиент(ГлавнаяДатаИВремяДляТабеля);

            Log.d(this.getClass().getName(), " МесяцДляОпределениееслиТакойНазваниеАбель " + МесяцДляОпределениееслиТакойНазваниеАбель
                    + " ГодляОпределениееслиТакойНазваниеАбель " + ГодляОпределениееслиТакойНазваниеАбель);

            //TODO данный курсор работает КОГДА СОЗДАЛИ НОВЫЙ ТАБЕЛЬ И ПРИШЛИ ОТ ДРУГОВО АКТИВТИ И ЗАПРОС ПОКАЗЫВАЕТ ТАБЕЛЬ ВСПИНЕР ДАТУ НОВУЮ ДАТУ



            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

            ///
            class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть=new Class_GRUD_SQL_Operations(getApplicationContext());

            ///
            class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","tabel");
            ///////
            class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","cfo, month_tabels ,year_tabels");
            //
            class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","cfo= ? AND month_tabels=? AND year_tabels=? AND status_send!=? ");
                    ///"_id > ?   AND _id< ?"
                    //////
            class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",ПолученноЦифровоеОбознаяниеЦФО);
                    ///
            class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2",МесяцДляОпределениееслиТакойНазваниеАбель);
                    ///
            class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",ГодляОпределениееслиТакойНазваниеАбель);
                    //
            class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4","Удаленная");////УсловиеПоискаv4,........УсловиеПоискаv5 .......

            ////TODO другие поля

            ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
            ////
            //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
            ////
            class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC" );
            ////
            class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

            Курсор_ПроверяемЕслиТакоеНазваниеТабеляУжеЕстьИлиНет=null;

            //////


            //TODO данный курсор работает КОГДА СОЗДАЛИ НОВЫЙ ТАБЕЛЬ И ПРИШЛИ ОТ ДРУГОВО АКТИВТИ И ЗАПРОС ПОКАЗЫВАЕТ ТАБЕЛЬ ВСПИНЕР ДАТУ НОВУЮ ДАТУ

            Курсор_ПроверяемЕслиТакоеНазваниеТабеляУжеЕстьИлиНет= (SQLiteCursor)  class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть.
                    new GetData(getApplicationContext()).getdata(class_grud_sql_operationsПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    МенеджерПотоковВнутри
                    ,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

            Log.d(this.getClass().getName(), "GetData "  +Курсор_ПроверяемЕслиТакоеНазваниеТабеляУжеЕстьИлиНет);





       /*     // TODO: 07.09.2021   _old
                        //TODO данный курсор работает КОГДА СОЗДАЛИ НОВЫЙ ТАБЕЛЬ И ПРИШЛИ ОТ ДРУГОВО АКТИВТИ И ЗАПРОС ПОКАЗЫВАЕТ ТАБЕЛЬ ВСПИНЕР ДАТУ НОВУЮ ДАТУ
                        Курсор_ПроверяемЕслиТакоеНазваниеТабеляУжеЕстьИлиНет=
                                new MODEL_synchronized(getApplicationContext()).КурсорУниверсальныйДляБазыДанных("tabels",
                                new String[]{"cfo", "month_tabels", "year_tabels"}, "cfo= ? AND month_tabels=? AND year_tabels=? AND status_send!=? ",
                                        new String[]{ПолученноеТекущееЗначениеСпинераЦФОфинал,
                                        String.valueOf(МесяцДляОпределениееслиТакойНазваниеАбель),
                                                String.valueOf(ГодляОпределениееслиТакойНазваниеАбель), "Удаленная"},
                                        null, null, null, null);///"SE"SELECT name  FROM MODIFITATION_Client WHERE name=?",НазваниеТаблицНаСервере

*/
                        ///////

        if (   Курсор_ПроверяемЕслиТакоеНазваниеТабеляУжеЕстьИлиНет.getCount() > 0) {


            ///
            Курсор_ПроверяемЕслиТакоеНазваниеТабеляУжеЕстьИлиНет.close();
            return true;

        }else {
            ///
            Курсор_ПроверяемЕслиТакоеНазваниеТабеляУжеЕстьИлиНет.close();
            return false;

        }



        ///поймать ошибку
    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
          this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///////
    }


        return false;
    }








    //МетодКоторыйРазбираетМЕсяцИГОдОтдельноИзТабеляБуфером
    private void МетодИзОбщиеДатыОтТабеляДелимНаМесяциГодОтдельно( ) {
        try{
            //////метод разбивает год и месяц отдельно  для создание табель
            Log.e(this.getClass().getName(),"");
            /////////вставляем месяц и год
            StringBuffer БуферМЕсяцДляСозданиеТабеля=new StringBuffer(ПолученноеТекущееЗначениеСпинераДата);
            int ЕслиПробел= ПолученноеТекущееЗначениеСпинераДата.indexOf(" ");
            МесяцВырезалиИзБуфераТабель=  БуферМЕсяцДляСозданиеТабеля.substring(0,ЕслиПробел);
            ////////месяц переводим из текста в цифру
            switch (МесяцВырезалиИзБуфераТабель) {
                //////месяцы
                case "Январь" :
                    МесяцВырезалиИзБуфераТабель="1";
                    break;
                /////
                //////месяцы
                case "Февраль" :
                    МесяцВырезалиИзБуфераТабель="2";
                    break;
                /////
                //////месяцы
                case "Март" :
                    МесяцВырезалиИзБуфераТабель="3";
                    break;
                /////
                //////месяцы
                case "Апрель" :
                    МесяцВырезалиИзБуфераТабель="4";
                    break;
                /////
                //////месяцы
                case "Май" :
                    МесяцВырезалиИзБуфераТабель="5";
                    break;
                /////
                //////месяцы
                case "Июнь" :
                    МесяцВырезалиИзБуфераТабель="6";
                    break;
                /////
                //////месяцы
                case "Июль" :
                    МесяцВырезалиИзБуфераТабель="7";
                    break;
                /////
                //////месяцы
                case "Август" :
                    МесяцВырезалиИзБуфераТабель="8";
                    break;
                /////
                //////месяцы
                case "Сентябрь" :
                    МесяцВырезалиИзБуфераТабель="9";
                    break;
                /////
                //////месяцы
                case "Октябрь" :
                    МесяцВырезалиИзБуфераТабель="10";
                    break;
                /////
                //////месяцы
                case "Ноябрь" :
                    МесяцВырезалиИзБуфераТабель="11";
                    break;
                /////
                //////месяцы
                case "Декабрь" :
                    МесяцВырезалиИзБуфераТабель="12";
                    break;
                /////
                default:
                    Log.d(this.getClass().getName()," такого месяца нет вообще");

            }

            //////// конец месяц переводим из текста в цифру

            ////////месяц
            StringBuffer БуферГодДляСозданиеТабеля=new StringBuffer(ПолученноеТекущееЗначениеСпинераДата);
            ГодВырезалиИзБуфераТабель=  БуферМЕсяцДляСозданиеТабеля.substring(ЕслиПробел,БуферГодДляСозданиеТабеля.length());

            Log.d(this.getClass().getName()," МесяцВырезалиИзБуфераТабель "+МесяцВырезалиИзБуфераТабель + " ГодВырезалиИзБуфераТабель " +ГодВырезалиИзБуфераТабель);

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
               // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
          this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }








    private void МетодСозданиеСпинеровДляВыбораЦФОИТД() {
        try{
            //////МЕТОД ЗАПОЛЕНИЯ СНИНЕРОВ ДАННЫМИ ИЗ БАЗЫ
       // String[] МассивДляВыбораВСпинереЦФО = {"Выберите цфо","Москва", "Самара", "Вологда", "Волгоград", "Саратов", "Воронеж"};/////ДАННЫЙ МАССИВ БУДЕТ ЗАПОЛНЯТЬ СПИНЕР цфо
                    /////первый спинер
        СпинерВыборЦФО=(Spinner) findViewById(R.id.ЗначениеЦФОПриСозданииНовогоТабеля);

     ArrayList<String> ЛистДанныеДляСпинераЦФО=       МетодЗаполненияДляТабеляСпинераДаннымиИзБазы("cfo","id,name",Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков);

        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner //// simple_list_item_multiple_choice
        ArrayAdapter<String> АдаптерДляСпинераЦФО = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,
                ЛистДанныеДляСпинераЦФО);
        // Определяем разметку для использования при выборе элемента
            АдаптерДляСпинераЦФО.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        СпинерВыборЦФО.setAdapter(АдаптерДляСпинераЦФО);
        
        //////////


            // TODO: 21.09.2021 Long Долгое нажатие
            




            
            
            
            
            
            
            
            
            
            
            
            

        //
            СпинерВыборЦФО.setHorizontalScrollBarEnabled(true);
        ////что быврали
            СпинерВыборЦФО.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                         @Override
                                                         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                                             ////todo когда пользователь выбрал из спинера значение
                                                            if (position>0) {///ставим ограничкния если выбрано не 0 позиция то запонимаеним
                                                               ПолученноеЗначениеИзСпинераЦФО=parent.getItemAtPosition(position).toString();
                                                               //
                                                                //////////


                                                               ////СПИНЕР ЦФО
                                                                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);

                                                                ((TextView) parent.getChildAt(0)).setBackgroundResource(R.drawable.textlines);

                                                                ((TextView) parent.getChildAt(0)).setTextSize(16);

                                                                ((TextView) parent.getChildAt(0)).setLines(5);
                                                                /////

                                                                ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО=0;

                                                                if (position>0) {
                                                                    ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО=     ХэшДляПубличногоIDДляСозданиеТабеля.get(position);

                                                                }


                                                                if (ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО>0) {

                                                                    Log.d(this.getClass().getName(), "IDИЗТАБЛИЦЫСпинераЦФО  " + ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО);
                                                                }


                                                                ((TextView) parent.getChildAt(0)).setTypeface(Typeface.DEFAULT_BOLD);

                                                                ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

                                                                Log.d(this.getClass().getName(), " СпинерВыборЦФО.getCount() " +СпинерВыборЦФО.getCount());
                                                                ////////////////
                                                                 /*Toast toast = Toast.makeText(getApplicationContext(),
                                                                         "Ваш выбор ЦФО : " + ПолученноеЗначениеИзСпинераЦФО + " " + position, Toast.LENGTH_SHORT);
                                                                 toast.show();*/
                                                             }else if (position==0) {

                                                                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);

                                                                ((TextView) parent.getChildAt(0)).setBackgroundResource(R.drawable.textlines);

                                                                ((TextView) parent.getChildAt(0)).setTextSize(16);

                                                                ((TextView) parent.getChildAt(0)).setLines(5);

                                                                ((TextView) parent.getChildAt(0)).setTypeface(Typeface.DEFAULT_BOLD);

                                                                ///

                                                                ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО=0;

                                                                if (position>0) {

                                                                    ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО=     ХэшДляПубличногоIDДляСозданиеТабеля.get(position);
                                                                }


                                                                if (ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО>0) {
                                                                    Log.d(this.getClass().getName(), "IDИЗТАБЛИЦЫСпинераЦФО  " + ПУБЛИЧНЫЙIDИЗТАБЛИЦЫСпинераЦФО);
                                                                }









                                                                ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

                                                                ((TextView) parent.getChildAt(0)).setHint("Выбирете ЦФО");

                                                                ((TextView) parent.getChildAt(0)).setHintTextColor(Color.parseColor("#00ACC1"));

                                                            }
                                                            ///
                                                         }

                                                         @Override
                                                         public void onNothingSelected(AdapterView<?> parent) {
                                                         }
                                                     });

///////второй спинер

           // String[] МассивДляВыбораВСпинереРазделы = {"Выберите департамент","Москва", "Самара", "Вологда", "Волгоград", "Саратов", "Воронеж"};/////ДАННЫЙ МАССИВ БУДЕТ ЗАПОЛНЯТЬ СПИНЕР РАЗДЕЛ






            ///// todo ТРЕТИЙ СПИНЕР дата
            СпинерВыборДата=(Spinner) findViewById(R.id.ЗначениеДатаСоздаваемогоТабеля);////СЮДА ДАТА ПРИШЛА ОТ ДРУГОВВА АКТИВТИ


            String[] МассивДляВыбораВСпинереДаты = {ПолученнаяДатаОтДруговаИнтрентаДляСозданиеТабеля};/////ДАННЫЙ МАССИВ БУДЕТ ЗАПОЛНЯТЬ СПИНЕР РАЗДЕЛ
// Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner


            ArrayAdapter<String> АдаптерДляСпинераРазделДаты = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, МассивДляВыбораВСпинереДаты);
            // Определяем разметку для использования при выборе элемента
            АдаптерДляСпинераРазделДаты.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Применяем адаптер к элементу spinner
            СпинерВыборДата.setAdapter(АдаптерДляСпинераРазделДаты);
            ////что быврали
            СпинерВыборДата.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if (position>0) {///ставим ограничкния если выбрано не 0 позиция то запонимаеним
                        ПолученноеЗначениеИзСпинераРаздел=parent.getItemAtPosition(position).toString();
                        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                        ((TextView) parent.getChildAt(0)).setTextSize(16);
                        ((TextView) parent.getChildAt(0)).setLines(5);
                        ((TextView) parent.getChildAt(0)).setTypeface(Typeface.DEFAULT_BOLD);
                        ((TextView) parent.getChildAt(0)).setBackgroundResource(R.drawable.textlines);
                        ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                       /* Toast toast = Toast.makeText(getApplicationContext(),
                                "Ваш выбор Раздел : " + ПолученноеЗначениеИзСпинераРаздел + " " + position, Toast.LENGTH_SHORT);
                        toast.show()*/
                    }else{
                        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                        ((TextView) parent.getChildAt(0)).setBackgroundResource(R.drawable.textlines);
                        ((TextView) parent.getChildAt(0)).setTextSize(16);
                        ((TextView) parent.getChildAt(0)).setLines(5);
                        ((TextView) parent.getChildAt(0)).setTypeface(Typeface.DEFAULT_BOLD);
                        ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


                ///поймать ошибку
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
          this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///////
        }
    }


    ////МЕТОД ЗАПОЛЕНИЯ ДАННЫМИ ИЗ БАЗЫ В СПИНЕР
    ArrayList<String>   МетодЗаполненияДляТабеляСпинераДаннымиИзБазы(String ИмяТаблицыДляСпинера,String СтолбикДляЗагурзкиВСпинер,CompletionService МенеджерПотоковВнутри) {
        ///
        Log.d(this.getClass().getName()," МетодЗаполениеяСпинераДаннымиИзБазы() ");
        ArrayList<String> АрайЛИстДанныеИзБазыДляЗАполенияСпинеровы= new ArrayList <String>(); ////ГЛАВНЫЙ СПИСОК ТАБЛИЦ ДЛЯ  ОБМЕНАМИ ДАННЫМИ ИЗ НЕГО БУДЕТ БРАТЬСЯ СПИСКО ТАБЛИЦ





        SQLiteCursor   Курсор_ЗагружаетДанныеПриСозданииТабеля=null;
        ///
        Class_GRUD_SQL_Operations class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы;

        try{
            Log.d(this.getClass().getName()," ИмяТаблицыДляСпинера() "+ИмяТаблицыДляСпинера);


            // TODO: 07.09.2021  взависмости какая таблица обработывается

            if(ИмяТаблицыДляСпинера.equals("depatment")){


                // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

                ///
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы=new Class_GRUD_SQL_Operations(getApplicationContext());

                ///
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","organization");
                ///////
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","id");
                //
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","chosen_organization=?");
                    ///"_id > ?   AND _id< ?"
                    //////
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1","1");
                    ///
    /*            class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......

                ////TODO другие поля*/

                ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
                ////
                //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
                ////
             //   class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
                ////
                /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                ////

                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

                SQLiteCursor           КурсорВытаскиваетЗначениеОргниазцииТекущейКороруюВыбраКлиент =null;


                КурсорВытаскиваетЗначениеОргниазцииТекущейКороруюВыбраКлиент= (SQLiteCursor) class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы.
                        new GetData(getApplicationContext()).getdata(class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        МенеджерПотоковВнутри,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

                Log.d(this.getClass().getName(), "GetData "  +КурсорВытаскиваетЗначениеОргниазцииТекущейКороруюВыбраКлиент);






         /*       // TODO: 07.09.2021    _old

                ////TODO ИЩЕМ ОРГАНИЗАЦИЮ КОТРОУЮ ВЫБРАЛ СОТРУДНИК УЖЕ ЗАХОДИЛ И ВЫБРАЛ НА АКТИВТИ цифра один ставитсья всегда каторую выбрали
                КурсорВытаскиваетЗначениеОргниазцииТекущейКороруюВыбраКлиент =  new MODEL_synchronized(getApplicationContext()).КурсорУниверсальныйДляБазыДанных("organization", new String[]
                        {"id"}, "chosen_organization=?",new String[] {"1"}, null, null,null, null);///"SELECT name  FROM MODIFITATION_Client WHERE name=?",НазваниеТаблицНаСервере
                //
*/



                // TODO: 07.09.2021
                if(КурсорВытаскиваетЗначениеОргниазцииТекущейКороруюВыбраКлиент.getCount()>0){


                    КурсорВытаскиваетЗначениеОргниазцииТекущейКороруюВыбраКлиент.moveToFirst();
                    ////
                    int ВЫбранаяОрганизациСотрудников=КурсорВытаскиваетЗначениеОргниазцииТекущейКороруюВыбраКлиент.getInt(0);




                    // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

                    ///
                    class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы=new Class_GRUD_SQL_Operations(getApplicationContext());
                    ///
                    ///
                    class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы",ИмяТаблицыДляСпинера);
                    ///////
                    class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки",СтолбикДляЗагурзкиВСпинер);
                    //
                    class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","organization=?");
                    ///"_id > ?   AND _id< ?"
                    //////
                    class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",ВЫбранаяОрганизациСотрудников);
                    ///
             /*       class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......
*/
                    ////TODO другие поля

                    ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
                    ////
                    //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
                    ////
         /*           class_grud_sql_operationsПолучениеИмяСистемы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");*/
                    ////
                    /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                    ////

                    // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ



                    // TODO: 07.09.2021
                    Курсор_ЗагружаетДанныеПриСозданииТабеля=null;

                    ///
                    Курсор_ЗагружаетДанныеПриСозданииТабеля= (SQLiteCursor)  class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы.
                            new GetData(getApplicationContext()).getdata(class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                            МенеджерПотоковВнутри,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

                    Log.d(this.getClass().getName(), "GetData "  +Курсор_ЗагружаетДанныеПриСозданииТабеля);



    /*                // TODO: 07.09.2021  _old
                            ///// КОД ЗАПОЛЕНЕИЯ ДАННЫМИ В СПИНЕР ЦФО ДЕПАРТАМЕНТ МЕСЯЦ
                            Курсор_ЗагружаетДанныеПриСозданииТабеля=  new MODEL_synchronized(getApplicationContext()).КурсорУниверсальныйДляБазыДанных(ИмяТаблицыДляСпинера, new String[]
                                            {СтолбикДляЗагурзкиВСпинер}, "organization=?",
                                    new String[]{String.valueOf(ВЫбранаяОрганизациСотрудников)}, null, null,null, null);///"SELECT name  FROM MODIFITATION_Client WHERE name=?",НазваниеТаблицНаСервере
                            ////
*/

                        }






                        // TODO: 24.03.2021 таблица CFO

                    }else      if(ИмяТаблицыДляСпинера.equals("cfo")){

                // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

                ///
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы=new Class_GRUD_SQL_Operations(getApplicationContext());


                // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

                ///
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы",ИмяТаблицыДляСпинера);
                ///////
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки",СтолбикДляЗагурзкиВСпинер);
                //
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","closed=? ");
                    ///"_id > ?   AND _id< ?"
                    //////
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1","0");
                    ///
         /*           class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......
*/
                ////TODO другие поля

                ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
                ////
                //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
                ////
                class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","name");
                ////
                /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                ////

                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

                Курсор_ЗагружаетДанныеПриСозданииТабеля=null;

                ///

                Курсор_ЗагружаетДанныеПриСозданииТабеля= (SQLiteCursor)  class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы.
                        new GetData(getApplicationContext()).getdata(class_grud_sql_operationsЗаполненияДляТабеляСпинераДаннымиИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

                Log.d(this.getClass().getName(), "GetData "  +Курсор_ЗагружаетДанныеПриСозданииТабеля);



   /*             // TODO: 07.09.2021    _old

                        ///// КОД ЗАПОЛЕНЕИЯ ДАННЫМИ В СПИНЕР ЦФО ДЕПАРТАМЕНТ МЕСЯЦ
                        Курсор_ЗагружаетДанныеПриСозданииТабеля=  new MODEL_synchronized(getApplicationContext()).КурсорУниверсальныйДляБазыДанных(ИмяТаблицыДляСпинера, new String[]
                                        {СтолбикДляЗагурзкиВСпинер}, "closed=?",
                                new String[]{"0"}, null, null,"name", null);///"SELECT name  FROM MODIFITATION_Client WHERE name=?",НазваниеТаблицНаСервере

                */
                        ////
                    }










        /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
    /////
    String ЗначениеДляЗаполенияСпинера= "";

////////
    if ( Курсор_ЗагружаетДанныеПриСозданииТабеля.getCount()>0) {/////ЗАГРУЖАЕМ ДАННЫЕ ИЗ ТАБЛИЦЫ CFO ДЛЯ СПИНЕРА И СОЗДАНИЯ ТАБЕЛЯ
        /////
        Курсор_ЗагружаетДанныеПриСозданииТабеля.moveToFirst();
        ////первый элемент в спинре
        АрайЛИстДанныеИзБазыДляЗАполенияСпинеровы.add("") ;


int ИндексХэшДляПубличногоIDДляСозданиеТабеля=0;

        ХэшДляПубличногоIDДляСозданиеТабеля.clear();
        ///
        ХэшДанныеИзБазыДляЗАполенияСпинеровыСФО.clear();
        ////сам цикл заполения спинеров
        do{

            ///////вытаскиваем данные из базы столбкик ЗАПОЛЕНИЕ ХЕША
            //TODO ID
            int ИндексПОСтолбикуIDBKилиUUID= Курсор_ЗагружаетДанныеПриСозданииТабеля.getColumnIndex("id");

            IDДляЗаполенияСпинера = Курсор_ЗагружаетДанныеПриСозданииТабеля.getString(ИндексПОСтолбикуIDBKилиUUID);

            //TODO UUID  ВСЛУЧАЕ ЕЛСИ ID ПУСТОЙ ТО ЗАПОЛЯЕМ ПОЛЯ UUID

            if (IDДляЗаполенияСпинера==null){
                int ИндексПОСтолбикуUUID= Курсор_ЗагружаетДанныеПриСозданииТабеля.getColumnIndex("uuid");

                IDДляЗаполенияСпинера = Курсор_ЗагружаетДанныеПриСозданииТабеля.getString(ИндексПОСтолбикуIDBKилиUUID);
            }

            ////todo само значение для спинера назвние услуги РЕМОНТ ШУЯ Кинешма например
            ЗначениеДляЗаполенияСпинера = Курсор_ЗагружаетДанныеПриСозданииТабеля.getString(1).trim();
            /////
            Log.d(this.getClass().getName(), " ЗначениеДляЗаполенияСпинера " + ЗначениеДляЗаполенияСпинера );

            boolean ДлинаСтрокивСпиноре=   ЗначениеДляЗаполенияСпинера.length()>45;


            if (ДлинаСтрокивСпиноре) {
                StringBuffer sb = new StringBuffer(ЗначениеДляЗаполенияСпинера);
                sb.insert(45,"-");
                sb.insert(46,System.lineSeparator());
                //
               /* sb.insert(80,"-");
                sb.insert(81,System.lineSeparator());*/
               // sb.insert(41,"\n");//


                ЗначениеДляЗаполенияСпинера=null;
                // TODO: 14.05.2021 вставка
                ЗначениеДляЗаполенияСпинера=sb.toString();


                ///
                Log.d(getApplicationContext().getClass().getName(), " ЗначениеДляЗаполенияСпинера " + "--" + ЗначениеДляЗаполенияСпинера);/////

            }
            // TODO: 14.05.2021 80









            ///
            Log.d(this.getClass().getName(), " IDДляЗаполенияСпинера " + IDДляЗаполенияСпинера +"  ЗначениеДляЗаполенияСпинера "  +ЗначениеДляЗаполенияСпинера + " ЗначениеДляЗаполенияСпинера.length()  " +ЗначениеДляЗаполенияСпинера.length());





            Log.d(this.getClass().getName(), " IDДляЗаполенияСпинера " + IDДляЗаполенияСпинера + " СпинерВыборЦФО.getId() " + СпинерВыборЦФО.getId());

/*
            boolean ДлинаСтрокивСпиноре=   ЗначениеДляЗаполенияСпинера.length()>40;

            if (ДлинаСтрокивСпиноре) {
                StringBuffer sb = new StringBuffer(ЗначениеДляЗаполенияСпинера);
                sb.insert(40,",");
                ЗначениеДляЗаполенияСпинера=    sb.toString();



            }
            Log.d(this.getClass().getName(), " ЗначениеДляЗаполенияСпинера " + ЗначениеДляЗаполенияСпинера );
*/






///ЗАПОЛЯНЕМ ААРАЛИСТ
            //////ЗАПОЛЕНИЕ ПЕРВОЕ И ВАЖНОЕ АРАЛИЛСИАТ
            АрайЛИстДанныеИзБазыДляЗАполенияСпинеровы.add(ЗначениеДляЗаполенияСпинера) ; /////ЗАПОЛЯНЕМ АРАЙЛИСТА ДЛЯ ОТОБРАЖЕНИЯ НАЗВАНИЕ ТАБЕЛЯ В АКТИВТИ
///ЗАПОЛЯНЕМ ХЭША
            //////ЗАПОЛЕЯНИМ ХЭШМАП ВЗАВИСИМОСТИ ОТ НАЗВАНИЯ ТАБЛИЦЫ
            switch (ИмяТаблицыДляСпинера) {
                case  "cfo" :
                    ХэшДанныеИзБазыДляЗАполенияСпинеровыСФО.put(IDДляЗаполенияСпинера,ЗначениеДляЗаполенияСпинера);////ЗАПОЛЯЕМ  ДОПОЛНИТЕЛЬНО  ХЭШМАП ДЛЯ РАБОТЫ ВСТМВКИ В БАЗУ ДОПОЛНИТЕЛЬНО
/////////////////////////
                    ХэшДляПубличногоIDДляСозданиеТабеля.put(ИндексХэшДляПубличногоIDДляСозданиеТабеля,Integer.parseInt(IDДляЗаполенияСпинера));

                    ИндексХэшДляПубличногоIDДляСозданиеТабеля++;
                    //


                    break;

            }




        }while (Курсор_ЗагружаетДанныеПриСозданииТабеля.moveToNext());

        Log.d(this.getClass().getName(), "  АрайЛИстДанныеИзБазыДляЗАполенияСпинеровы.size()  " +АрайЛИстДанныеИзБазыДляЗАполенияСпинеровы.size() +
                "  ХэшДанныеИзБазыДляЗАполенияСпинеровыСФО.size() " +ХэшДанныеИзБазыДляЗАполенияСпинеровыСФО.size()
                + "  ХэшДанныеИзБазыДляЗАполенияСпинеровыДепартамент.size() " +ХэшДанныеИзБазыДляЗАполенияСпинеровыДепартамент.size());

    }

        ///поймать ошибку
    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
          this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///////
    }
////ВОЗВРЯЩАЕМ  МетодЗаполненияДляТабеляСпинераДаннымиИзБазы
return АрайЛИстДанныеИзБазыДляЗАполенияСпинеровы;

}













///////код только как пример



    ////СООБЩЕНИЕ ИЗ ИТОРИИИ ТАБЛЕЙ ОТПРАВЛЯЕМ СООБЩЕНЕИ И ЗНАЧЕНИЕ В ДУГОЕ АКТИВТИ О СОЗДАНИЮ НОВОГО ТАБЕЛЯ
    @UiThread
    protected void СообщениеФинальноеКотороеСообщаетПользователюВстакиНовгоТАбеля(String ШабкаДиалога, final String СообщениеДиалога, boolean статус) {
        ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ
        int Значек = 0;
        if (статус){
            Значек =R.drawable.icon_dsu1_new_create_tabel4;
        }else{
            Значек =R.drawable.icon_dsu1_new_create_tabel5error;
        }
        try{
//////сам вид
            final AlertDialog DialogBoxsПростомрДанных = new MaterialAlertDialogBuilder(this)
                    .setTitle(ШабкаДиалога)
                    .setMessage(СообщениеДиалога)
                    .setNegativeButton("ОК", null)
                    .setIcon( Значек)
                    .show();
/////////кнопка
            final Button MessageBoxUpdateЗАкрытьСозданиеТабеля = DialogBoxsПростомрДанных.getButton(AlertDialog.BUTTON_NEGATIVE);
            MessageBoxUpdateЗАкрытьСозданиеТабеля.setOnClickListener(new View.OnClickListener() {
                ///MessageBoxUpdate метод CLICK для DIALOBOX
                @Override
                public void onClick(View v) {
                    //удаляем с экрана Диалог
                    DialogBoxsПростомрДанных.dismiss();
///запуск метода обновления через DIALOGBOX ФИНАЛ СОЗДАННЫЙ НОВЫЙ ТАБЕЛЬ
                    if (статус){
// TODO после успеного создание нового таблеоя на месяц отправляем подученое название месяйа нового табеля на активити MainActivity_List_Tabels

                        МетодПослеСозданеиУспешногоТабеля();

                    }}



            });

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
               // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
          this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }












    void МетодПослеСозданеиУспешногоТабеля() {

        Intent Интент_ФинальныйПослеВставкиНовогоТабеля=new Intent();

        try{

        Интент_ФинальныйПослеВставкиНовогоТабеля.setClass(getApplication(),  MainActivity_List_Tabels.class); // ТУТ ЗАПВСКАЕТЬСЯ ВЫБОР ПРИЛОЖЕНИЯ

        Интент_ФинальныйПослеВставкиНовогоТабеля.putExtra("ГодВырезалиИзБуфераТабель", ГодВырезалиИзБуфераТабель);


        Интент_ФинальныйПослеВставкиНовогоТабеля.putExtra("МесяцВырезалиИзБуфераТабель", МесяцВырезалиИзБуфераТабель);

        Интент_ФинальныйПослеВставкиНовогоТабеля.putExtra("ПолученноеТекущееЗначениеСпинераДата", ПолученноеТекущееЗначениеСпинераДата);

        Интент_ФинальныйПослеВставкиНовогоТабеля.putExtra("СгенерированныйUUIDДляНовогоТабеля", СгенерированныйUUIDДляНовогоТабеля);

        Интент_ФинальныйПослеВставкиНовогоТабеля.putExtra("СгенерированныйНазваниеНовогоТабеля", ПолученноеТекущееЗначениеСпинераЦФО+ " / "+  "\n"+ ПолученноеТекущееЗначениеСпинераПодразделения);

        Интент_ФинальныйПослеВставкиНовогоТабеля.putExtra("ПолноеИмяТабеляПослеСозданиеНовогоСотрудника",  ПолученноеТекущееЗначениеСпинераЦФО+ " / "+  "\n"+ ПолученноеТекущееЗначениеСпинераПодразделения);

        Интент_ФинальныйПослеВставкиНовогоТабеля.putExtra("ЦифровоеИмяНовгоТабеля", String.valueOf(ЦифровоеИмяНовгоТабеля));

        ///TODO после спешного созданого табеля

        /////
        Log.d(this.getClass().getName(), " ГодВырезалиИзБуфераТабель"+ГодВырезалиИзБуфераТабель+ " МесяцВырезалиИзБуфераТабель " +МесяцВырезалиИзБуфераТабель);

        startActivity(Интент_ФинальныйПослеВставкиНовогоТабеля);
        // finish();

    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());
    }

    }







    ////СООБЩЕНИЕ ИЗ ИТОРИИИ ТАБЛЕЙ ОТПРАВЛЯЕМ СООБЩЕНЕИ И ЗНАЧЕНИЕ В ДУГОЕ АКТИВТИ О СОЗДАНИЮ НОВОГО ТАБЕЛЯ

  /*  Iterator<Entry<String, String>>iterator=map.entrySet();
while(iterator.hasNext()){
        final Entry<String, String>next=iterator.next();
        next.getKey(); next.getValue();
    }*/




    private int  МетодПолучениниеМесяцДляОпределенияЕслиТАкойТАбельВБазеКлиента(String ДатаКоторуюНадоПеревестиИзТекставЦифру) throws ParseException {

        System.out.println( " " +ДатаКоторуюНадоПеревестиИзТекставЦифру);

        int month = 0;

        try{

        SimpleDateFormat formatмесяц = new SimpleDateFormat("LLLL  yyyy",new Locale("ru")); //yyyy-MM-dd HH:mm:ss.SSS

        Date date = formatмесяц .parse(ДатаКоторуюНадоПеревестиИзТекставЦифру.trim());

        Calendar calendar = Calendar.getInstance(new Locale("ru"));

        calendar.setTime(date);

        Calendar calendar2 = new GregorianCalendar();

        calendar.setTime(date );

         month = calendar.get(Calendar.MONTH) + 1;

    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
           // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), 
          this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
        return   month;
    }























    //TODO метод получени месяа для записи в одну колонку

    private int  МетодПолучениниеГодЕслиТАкойТАбельВБазеКлиент(String ДатаКоторуюНадоПеревестиИзТекставЦифру) throws ParseException {
        int year = 0;
        System.out.println( " " +ДатаКоторуюНадоПеревестиИзТекставЦифру);
        try{
        SimpleDateFormat formatмесяц = new SimpleDateFormat("LLLL  yyyy",new Locale("ru")); //yyyy-MM-dd HH:mm:ss.SSS
        Date date = formatмесяц .parse(ДатаКоторуюНадоПеревестиИзТекставЦифру.trim());
        Calendar calendar = Calendar.getInstance(new Locale("ru"));
        calendar.setTime(date);
      year = calendar.get(Calendar.YEAR);
    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
           // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), 
          this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
        return   year ;
    }




    // TODO: 25.03.2021 получаем организацию выбраную в спиноре

    int МетодПолучениеОрганизацииНепосрдственодляДанногоID() throws InterruptedException, ExecutionException, TimeoutException {

////TODO КУРСОР ПРОВЕЯЕТ ПЕРВЫЙ ЭТО ЗАПУСК ИЛИ НЕТ
    SQLiteCursor Курсор_КоторыйВЫгружемНазваниеОрганизацииДляЭтогоСотркдникаТекущего = null;

        // TODO: 24.03.2021 ЕслиВубличногоНЕтТоНАходим ЕГо
     int ПолученныйID = 0;

     ////
        Class_GRUD_SQL_Operations class_grud_sql_operationsПолучениеОрганизацииНепосрдственодляДанногоID=new Class_GRUD_SQL_Operations(getApplicationContext());

        try {
            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

            ///
            ///
            class_grud_sql_operationsПолучениеОрганизацииНепосрдственодляДанногоID. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","SuccessLogin");
            ///////
            class_grud_sql_operationsПолучениеОрганизацииНепосрдственодляДанногоID. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","id");
            //
            class_grud_sql_operationsПолучениеОрганизацииНепосрдственодляДанногоID. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика"," id IS NOT NULL ");
                    ///"_id > ?   AND _id< ?"
                    //////
/*
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",finalПолученныйUUID);
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......
*/

            ////TODO другие поля

            ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
            ////
            //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
            ////
            class_grud_sql_operationsПолучениеОрганизацииНепосрдственодляДанногоID. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
            ////
            class_grud_sql_operationsПолучениеОрганизацииНепосрдственодляДанногоID. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
            Курсор_КоторыйВЫгружемНазваниеОрганизацииДляЭтогоСотркдникаТекущего=null;

            Курсор_КоторыйВЫгружемНазваниеОрганизацииДляЭтогоСотркдникаТекущего= (SQLiteCursor)  class_grud_sql_operationsПолучениеОрганизацииНепосрдственодляДанногоID.
                    new GetData(getApplicationContext()).getdata(class_grud_sql_operationsПолучениеОрганизацииНепосрдственодляДанногоID. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

            Log.d(this.getClass().getName(), "GetData "  +Курсор_КоторыйВЫгружемНазваниеОрганизацииДляЭтогоСотркдникаТекущего);










/*


            // TODO: 07.09.2021   _old
            Курсор_КоторыйВЫгружемНазваниеОрганизацииДляЭтогоСотркдникаТекущего =
                                new MODEL_synchronized(getApplicationContext()).КурсорУниверсальныйДляБазыДанных("SuccessLogin",
                                        new String[]{"id"}, " id IS NOT NULL", null, null, null, "date_update", "1");//

            //////TODO результат
*/



            // TODO: 07.09.2021   --получение результат


                        if(Курсор_КоторыйВЫгружемНазваниеОрганизацииДляЭтогоСотркдникаТекущего.getCount()>0){

                            Курсор_КоторыйВЫгружемНазваниеОрганизацииДляЭтогоСотркдникаТекущего.moveToFirst();
                            ////
                            Log.d(this.getClass().getName(), " Курсор_КоторыйВЫгружемНазваниеОрганизацииДляЭтогоСотркдникаТекущего " + Курсор_КоторыйВЫгружемНазваниеОрганизацииДляЭтогоСотркдникаТекущего.getCount());

                             ПолученныйID =Курсор_КоторыйВЫгружемНазваниеОрганизацииДляЭтогоСотркдникаТекущего.getInt(0);


                        }

                        Log.d(this.getClass().getName(), "    ПолученныйID " +    ПолученныйID);








/////
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                            + Thread.currentThread().getStackTrace()[2].getLineNumber());
                       // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
          this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                            Thread.currentThread().getStackTrace()[2].getLineNumber());
                }

        ///todo вырубаем курсор
        Курсор_КоторыйВЫгружемНазваниеОрганизацииДляЭтогоСотркдникаТекущего.close();

        //
        return     ПолученныйID;
    }

    //TODO метод получени месяа для записи в одну колонку




























































    // TODO: 20.09.2021  класс по созаднию нового втабеля

    class Class_Create_New_Tabel{


        public Class_Create_New_Tabel() {
        }






    /////////КНОПКА СОЗДАНИЕ НОВОГО ТАБЕЛЯ НА МЕСЯЦ (АКВИТИ СОЗДАНИНЕ НОВГО ТАБЕЛЯ НА МЕСЯЦ)
    private void МетодСозданиеТабеля() {
/////////////
        try{

            ////TODO создание табеля после выбора СФО и Департамент
            //////////
            КнопкаСозданиеТабеля.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /////TODO после выбора цфо и подразделение создаем табель
                    int ТекущаяПозицияСпинераЦФО=СпинерВыборЦФО.getSelectedItemPosition();

                    Log.d(this.getClass().getName()," ТекущаяПозицияСпинераЦФО "
                            +ТекущаяПозицияСпинераЦФО);



                    ///TODO УСТАНВЛИВАЕМ ОГОНИЧЕНИЯ НЕ ПУСТОЙ ВЫБОР И НЕ 0 ПОЛОЖЕНИЕ
                    if ( ТекущаяПозицияСпинераЦФО==0  &&

                            СпинерВыборЦФО.getItemAtPosition(ТекущаяПозицияСпинераЦФО).toString()==null  &&

                            СпинерВыборЦФО.getItemAtPosition(ТекущаяПозицияСпинераЦФО).toString()==""  ){

// todo  заходим сюда когда пользователь не выбрал не название сфо не навзвание депратмента
                        //////спрашиваем пользователя хочел ли он создать табел
////todo сообщаем пользователю что он не выбрал ничего сфо и/или департметем
                        Toast.makeText(getApplicationContext(), "Создание Табель" + " Вы не выбрали цфо и/или подраздение (заполните и пропробуйте еще раз)" , Toast.LENGTH_LONG).show();
                        // ТАБЕЛЯ СПРАВИШАЕМ НУЖНА ЛИ СОЗДАТЬ ТАБЕЛЬ НА ЛРУГОМ АКТТИВИТИ

                        ///TODO создание табеля новго
                    } else{
                        Log.d(this.getClass().getName()," СпинерВыборЦФО.getItemAtPosition(ТекущаяПозицияСпинераЦФО).toString() "
                                +СпинерВыборЦФО.getItemAtPosition(ТекущаяПозицияСпинераЦФО).toString()
                                + "  СпинерВыборРаздел.getItemAtPosition(ТекущаяПозицияСпинераЦФО).toString() ");
                        //////спрашиваем пользователя хочел ли он создать табель
                        ///СообщениеКотороеСпрашиветНадоСоздатьНовыйТабельИлиНет("Создание Табель", "Перейти на созданный Табель ? ", true);///ПОСЛЕ ВЫБОРА ИЛИ СОЗДАНИЕ МАКЕТА
                        // ТАБЕЛЯ СПРАВИШАЕМ НУЖНА ЛИ СОЗДАТЬ ТАБЕЛЬ НА ЛРУГОМ АКТТИВИТИ
/////TODO создаем новыфй табель
                        МетодПереходаНаСозданныйТабельсНовымМесяцем();

                    }
                }

            });


            ///поймать ошибку
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///////
        }
    }


    //TODO ТАБЕЛЯ
    private void МетодПереходаНаСозданныйТабельсНовымМесяцем() {
        try{

/////////////Вычисчем Значение Текущее в Спинере ЦФО
            //////КРУТИМ СПИНЕР И НАХОДИМ В НЕМ ТЕКУЩЕЕ ЗНАЧЕНИЕ
            int ТекущаяПозицияСпинераЦФО=СпинерВыборЦФО.getSelectedItemPosition();


            ПолученноеТекущееЗначениеСпинераЦФО=(СпинерВыборЦФО.getItemAtPosition(ТекущаяПозицияСпинераЦФО).toString());


            Log.i(this.getClass().getName()," ПолученноеТекущееЗначениеСпинераЦФО " +ПолученноеТекущееЗначениеСпинераЦФО);





            //////ВЫТАСКИВАЕМ НАСТЯЩИЕ ДАННЫЗ ИЗ ХЭШМЭПА ДЛЯ ВСТВКИ В БАЗУ ДАННЫХ

            for (Map.Entry<String, String> ХэшПосикаСоздаваемогоТабеля : ХэшДанныеИзБазыДляЗАполенияСпинеровыСФО.entrySet()) {

                if (ХэшПосикаСоздаваемогоТабеля.getValue().trim().equalsIgnoreCase(ПолученноеТекущееЗначениеСпинераЦФО)) {

                    Log.d(this.getClass().getName(),"ХэшПосикаСоздаваемогоТабеля.getKey() "  + ХэшПосикаСоздаваемогоТабеля.getKey());
                    //////финальное значение от сфо
                    ПолученноеТекущееЗначениеСпинераЦФОфинал=ХэшПосикаСоздаваемогоТабеля.getKey();

                    Log.d(this.getClass().getName(), "ПолученноеТекущееЗначениеСпинераЦФОфинал "
                            +ПолученноеТекущееЗначениеСпинераЦФОфинал);

                    break;
                }
            }
            ///////ОЧИЩАЕМ ПАМЯТЬ ОТ  ХЭШМЕПОВ
            ХэшДанныеИзБазыДляЗАполенияСпинеровыСФО.clear();
///////////// КОНЕЦ Вычисчем Значение Текущее в Спинере ЦФО



            /////////////Вычисчем Значение Текущее в Спинере ДЕПАРТАМЕНТ



            ///////////КРУТИ ХЭШМЭП ДЛЯ ДЕПАРТАМЕНТА





/////////////Вычисчем Значение Текущее в Спинере ДАТА
            int ТекущаяПозицияСпинераДАТА= СпинерВыборДата.getSelectedItemPosition();

            ПолученноеТекущееЗначениеСпинераДата=( СпинерВыборДата.getItemAtPosition(ТекущаяПозицияСпинераДАТА).toString());

            Log.i(this.getClass().getName()," ПолученноеТекущееЗначениеСпинераДата" +ПолученноеТекущееЗначениеСпинераДата);







            //////// ТУТ-------КОНКРЕТАНЫЙ МЕТОД ВСТАКИ НОВГО ТАБЕЛЯ
//////todo МЕТОД ЗАПИСИ ЗАПОЛЕНИЕ БАЗЫ ДАННЫХ НОВЫМИ ПОЛУЧЕННЫМИ ДАННЫМИ
            МетодЗаполениеБазыДанныхПолученнымиНовымиСведениямиНовогоТабеля(ПолученноеТекущееЗначениеСпинераДата);



            ///поймать ошибку
        } catch (Exception e) {
            //  Block of code to handle errors
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///////
        }
    }








    //////ДАННЫЙ МЕТОД НЕПОСТРДСТВЕННО ЗАПИСЫВАЕТ ДАННЫХ Е БАЗУ ДАННЫХ В ТАБЛИЦУ СОЗДАНИЕ ТАБЕЛЕЙ

    protected void МетодЗаполениеБазыДанныхПолученнымиНовымиСведениямиНовогоТабеля(String  ПолученноеТекущееЗначениеСпинераДата) {

        SQLiteCursor Курсор_ИщемПУбличныйIDКогдаегоНетВстатике=null;

        Class_GRUD_SQL_Operations class_grud_sql_operationsаполениеБазыДанныхПолученнымиНовымиСведениямиНовогоТабеля=null;





        ////////
        ContentValues АдаптерВставкиНовгоТабеля = new ContentValues();////контрейнер для нового табеля





        try {
            /////////////
            Log.d(this.getClass().getName()," ПолученноеТекущееЗначениеСпинераЦФОфинал " +ПолученноеТекущееЗначениеСпинераЦФОфинал +
                    ПолученноеТекущееЗначениеСпинераДата +  ПолученноеТекущееЗначениеСпинераДата);





////////заполение контейнера данными новго табеля ////todo ПРИ СОЗДАЕНИИИ


            СгенерированныйUUIDДляНовогоТабеля=  (Long)   new Class_Generation_UUID(getApplicationContext()).МетодГенерацииUUID(getApplicationContext());
            ///

            Log.d(this.getClass().getName(), " СгенерированныйUUIDДляНовогоТабеля " + СгенерированныйUUIDДляНовогоТабеля);

            АдаптерВставкиНовгоТабеля.put("uuid", СгенерированныйUUIDДляНовогоТабеля);


            /////


            ////TODO ДАТА
            String СгенерированованныйДатаДляДаннойОперации=     new Class_Generation_Data(getApplicationContext()).ГлавнаяДатаИВремяОперацийСБазойДанных();


            АдаптерВставкиНовгоТабеля.put("date_update",СгенерированованныйДатаДляДаннойОперации);





            // TODO: 24.03.2021 ЕслиВубличногоНЕтТоНАходим ЕГо

            final int[] ПолученнаяUUIDОрганизацииДляПроверкиПередВставкоНовгоТабеля = {0};


            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

            ///
            class_grud_sql_operationsаполениеБазыДанныхПолученнымиНовымиСведениямиНовогоТабеля=new Class_GRUD_SQL_Operations(getApplicationContext());

            ///
            class_grud_sql_operationsаполениеБазыДанныхПолученнымиНовымиСведениямиНовогоТабеля.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","SuccessLogin");
            ///////
            class_grud_sql_operationsаполениеБазыДанныхПолученнымиНовымиСведениямиНовогоТабеля.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","id");
            //
            class_grud_sql_operationsаполениеБазыДанныхПолученнымиНовымиСведениямиНовогоТабеля. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","id IS NOT NULL");
            ///"_id > ?   AND _id< ?"
            //////
    /*                class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",finalПолученныйUUID);
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......
*/
            ////TODO другие поля

            ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
            ////
            //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
            ////
            class_grud_sql_operationsаполениеБазыДанныхПолученнымиНовымиСведениямиНовогоТабеля.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
            ////
            class_grud_sql_operationsаполениеБазыДанныхПолученнымиНовымиСведениямиНовогоТабеля.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

            Курсор_ИщемПУбличныйIDКогдаегоНетВстатике=null;
            /////

            Курсор_ИщемПУбличныйIDКогдаегоНетВстатике= (SQLiteCursor)  class_grud_sql_operationsаполениеБазыДанныхПолученнымиНовымиСведениямиНовогоТабеля.
                    new GetData(getApplicationContext()).getdata(class_grud_sql_operationsаполениеБазыДанныхПолученнымиНовымиСведениямиНовогоТабеля.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

            Log.d(this.getClass().getName(), "GetData "  +Курсор_ИщемПУбличныйIDКогдаегоНетВстатике);



      /*      // TODO: 07.09.2021  _old
                Курсор_ИщемПУбличныйIDКогдаегоНетВстатике =
                        new MODEL_synchronized(getApplicationContext()).КурсорУниверсальныйДляБазыДанных("SuccessLogin",
                                new String[]{"id"}, " id IS NOT NULL", null, null, null, "date_update", "1");//

*/

            /////////TODO результат
            if(Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.getCount()>0){
                ////
                Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.moveToFirst();
                ////
                Log.d(this.getClass().getName(), " Курсор_ИщемПУбличныйIDКогдаегоНетВстатике " + Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.getCount());

                ПолученнаяUUIDОрганизацииДляПроверкиПередВставкоНовгоТабеля[0] =Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.getInt(0);

            }


            Log.d(this.getClass().getName(), "   ПолученнаяUUIDОрганизацииДляПроверкиПередВставкоНовгоТабеля[0] " +  ПолученнаяUUIDОрганизацииДляПроверкиПередВставкоНовгоТабеля[0]);
            ///поймать ошибку






            АдаптерВставкиНовгоТабеля.put("user_update", String.valueOf(ПолученнаяUUIDОрганизацииДляПроверкиПередВставкоНовгоТабеля[0]));




   /*         /////

            АдаптерВставкиНовгоТабеля.put("current_table", String.valueOf(ПолученнаяUUIDОрганизацииДляПроверкиПередВставкоНовгоТабеля[0]));*/



            // TODO: 08.10.2021 повышаем версию


            Class_GRUD_SQL_Operations        class_grud_sql_operationsПовышаемВерсиюДанныхПриСозданеииИзШаблонаСотрудника=new Class_GRUD_SQL_Operations(getApplicationContext());

            Long РезультатУвеличинаяВерсияДАныхЧата=0L;

            РезультатУвеличинаяВерсияДАныхЧата=         class_grud_sql_operationsПовышаемВерсиюДанныхПриСозданеииИзШаблонаСотрудника. new ChangesVesionData(getApplicationContext()).
                    МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table(
                            "tabel","localversionandroid_version",
                            getApplicationContext(),
                            Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());


            //TODO  конец курант ча
            //////
            АдаптерВставкиНовгоТабеля.put("current_table", РезультатУвеличинаяВерсияДАныхЧата);











            //// todo САМО ИМЯ ТАБЕЛЯ которую видии пользователь
            ПубличноеИмяНовогоТабеля = ПолученноеТекущееЗначениеСпинераЦФО ;

            // ПубличноеИмяНовогоТабеля = ПолученноеТекущееЗначениеСпинераЦФО + " / " + "\n" + ПолученноеТекущееЗначениеСпинераПодразделения;
            //
            Log.d(this.getClass().getName(), " ПубличноеИмяНовогоТабеля " +ПубличноеИмяНовогоТабеля + " ПолученноеТекущееЗначениеСпинераДата " +ПолученноеТекущееЗначениеСпинераДата);

            ///TODO вычсиляем UUIDТекущйОрагнизации


            //////TODO  Метод определяем елси такое Навание Табеля Проверраем
            boolean РезультатЕслиТакоеНазвание = МетодПроверяемЕслиТакойНазваниеТабеляВБазеУжеЕсть(ПубличноеИмяНовогоТабеля,ПолученноеТекущееЗначениеСпинераДата.trim(),

                    ПолученноеТекущееЗначениеСпинераЦФОфинал,Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков);


            Log.d(this.getClass().getName(), " ПолученнаяUUIDОрганизацииДляПроверкиПередВставкоНовгоТабеля" +ПолученнаяUUIDОрганизацииДляПроверкиПередВставкоНовгоТабеля+"\n"
                    + " РезультатЕслиТакоеНазвание  " +РезультатЕслиТакоеНазвание );

            ///todo ЕСЛИ FALSE ЗНАЧИТ ЗНАЧЕНИЙ ТАКХ НЕТ И МЫ МОЖЕМ ВСТАВИТЬ НОВЫЙ ТАБЕЛЬ
            if (РезультатЕслиТакоеНазвание==true){ ///true значит  уже есть такой табель  и не удаленный статус
                //////todo НАЗВАНИЕ ТАКОГО ТАБЕЛЯ УЖЕ ЕСТЬ ОШИБКА ВСТАВЛЯТЬ НЕ НАДО
                СообщениеФинальноеКотороеСообщаетПользователюВстакиНовгоТАбеля("Создание Табеля", "Такой табель уже есть (выберите другой цфо/дату ) !!! ",false );
            }else {




                ///todo данные настоящие приходят сфо которое получено из активти


                // TODO: 25.03.2021 получеам значение cfo

                // TODO: 24.03.2021 ЕслиВубличногоНЕтТоНАходим ЕГо






                Log.d(this.getClass().getName(), "ПолученноеТекущееЗначениеСпинераЦФОфинал"+ ПолученноеТекущееЗначениеСпинераЦФОфинал);






                АдаптерВставкиНовгоТабеля.put("cfo",String.valueOf(ПолученноеТекущееЗначениеСпинераЦФОфинал));

                ///todo данные настоящие приходят департамент  которое получено из активти



                /////ТОЛЬКО КАК ТЕКСТ
                //АдаптерВставкиНовгоТабеля.put("fio", "2");
                Log.d(this.getClass().getName(), " ПолученноеТекущееЗначениеСпинераЦФОфинал   "
                        + ПолученноеТекущееЗначениеСпинераЦФОфинал);
                //
                //МетодКоторыйРазбираетМЕсяцИГОдОтдельноИзТабеляБуфером

                /////////TODO дробим дату
                МетодИзОбщиеДатыОтТабеляДелимНаМесяциГодОтдельно();





                ////TODO вставляем организацию текущего сотрудника который и созад данный табель


                final int[] IDДЛяорганизацииПриСозданииНовогоТабеля = {0};



///////////ВСТАВКА ОТДЕЛЬНО В КОНТРЕЙНЕР МЕСЯЦ ИЛИ ГОД ДЛЯ ТАБЕЛЬ ОТДЕЛЬНО
                /////TODO заполяем данными уже в сам табель новые цифра нового табеля
                АдаптерВставкиНовгоТабеля.put("year_tabels", ПолученныйГодДляНовогоТабеля);

                АдаптерВставкиНовгоТабеля.put("month_tabels", ФинальнаяМЕсяцДляНовогоТабеля);

                АдаптерВставкиНовгоТабеля.put("status_send", " ");



                АдаптерВставкиНовгоТабеля.  putNull("_id");


                ////

                // TODO: 25.03.2021 холостой встака данных
             /*     АдаптерВставкиНовгоТабеля.put("status_send", " ");
                  //  АдаптерВставкиНовгоТабеля.put("status_send", "");*/




//////////////////////////////////////////////////////////////////////////////////
///TODO ВСТАВКА НОВГО ТАБЕЛЯ В ТАБЛИЦУ
                final long[] РезультатВставкиНовогоТабеляЧерезКонтрейнер = {0};

                final String finalПолученноеТекущееЗначениеСпинераЦФОфинал=ПолученноеТекущееЗначениеСпинераЦФОфинал;






 PUBLIC_CONTENT public_content_create_tabel=new PUBLIC_CONTENT(getApplicationContext());


;
                //////TODO вставляем данные
                if (finalПолученноеТекущееЗначениеСпинераЦФОфинал.length()>0) {
                    // TODO: 11.06.2021  сама встака новго табел
                    /**
                     * ПРОИЩЗВОДИМ СТАВАКУ ТОЛЬКО КОГДА ЕСТЬ СФО
                     *
                     *
                     */
                    РезультатВставкиНовогоТабеляЧерезКонтрейнер[0] = new MODEL_synchronized(Контекст).
                            ВставкаДанныхЧерезКонтейнерТолькоПриСозданииНовогоСотрудникаУниверсальная("tabel",
                                    АдаптерВставкиНовгоТабеля, "tabel", "");
                }
                /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
                ///поймать ошибку



                /////
                Log.d(this.getClass().getName(), "  РезультатВставкиНовогоТабеляЧерезКонтрейнер[0]  "+ РезультатВставкиНовогоТабеляЧерезКонтрейнер[0]);



                /// после вствки в базу обнуляем контейнер данные от сервера

                if (РезультатВставкиНовогоТабеляЧерезКонтрейнер[0] > 0 ) {
                    ///
                    АдаптерВставкиНовгоТабеля.clear();
                    //////Удаляем из памяти Асинтаск
                    // TODO: 11.08.2021  ЛОКАЛЬНАЯ СЕРВЕРНАЯ НА АНДРОЙДЕ

                    Long РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПриСозданииНовогоТабеля = 0l;

        /*            // TODO: 12.08.2021 ЛОКАЛЬНАЯ ДАТА ЛОКАЛЬНАЯ

                        String ТекущаяТаблицаОбработкиДляПовышенияВерсии="tabel";

                *//*    РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПриСозданииНовогоТабеля =
                            new Class_Engine_SQL(getApplicationContext()).  МетодПолученияЛокальнойВерсииДаныхЧатаДляОтправкиЕгоНАСервер("MODIFITATION_Client", "localversionandroid_version",
                                    getApplicationContext(), ТекущаяТаблицаОбработкиДляПовышенияВерсии);


                    Log.d(this.getClass().getName(),
                            " РезультаПолученаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее" + РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПриСозданииНовогоТабеля);*//*

                    Log.d(this.getClass().getName()," current_table УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННЫХ ВНУТРИ ТАБЛИЦЫ  РезультатУвеличинаяВерсияДАныхЧата  РезультатУвеличинаяВерсияДАныхЧата  " +РезультатУвеличинаяВерсияДАныхЧата );

                    // TODO: 12.08.2021 код повышает или уменьшает верисю данных
                    Integer РезультатПовышенияВерсииДанныхДатыиВерсии =new Class_Engine_SQL(getApplicationContext()).
                            МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_Client(РезультатВставкиНовогоТабеляЧерезКонтрейнер[0] ,
                            ТекущаяТаблицаОбработкиДляПовышенияВерсии,
                                    "Локальное",
                                    РезультатУвеличинаяВерсияДАныхЧата,
                                    new PUBLIC_CONTENT(getApplicationContext()).МенеджерПотоков);//ЛокальныйСерверныйОба

                    Log.i(this.getClass().getName(), "   ИмяТаблицыОтАндройда_Локальноая"
                            + ТекущаяТаблицаОбработкиДляПовышенияВерсии + " РезультатУспешнойВставкиИлИОбвновленияССервера " + РезультатПовышенияВерсииДанныхДатыиВерсии +
                            "  РезультатПовышенияВерсииДанныхДатыиВерсии " + РезультатПовышенияВерсииДанныхДатыиВерсии);
*/














                    /////TODO успешное создание НОВГО ТАБЕЛЯ
         /*           if (PUBLIC_CONTENT.Отладка==true) {
                        СообщениеФинальноеКотороеСообщаетПользователюВстакиНовгоТАбеля("Создание Табеля", "Успешное создание нового Табеля."
                                +"\n"  +"Название :" +ПубличноеИмяНовогоТабеля+"."+
                                "\n"  + "За период : " + ПолученноеТекущееЗначениеСпинераДата+".", true);
                    } else {*/
                        МетодПослеСозданеиУспешногоТабеля();




                } else if (ПолученнаяUUIDОрганизацииДляПроверкиПередВставкоНовгоТабеля[0]==0){
                    Toast.makeText(getApplicationContext(),
                            " Не был создан Табель (Вы не выбрали организацию зайдите в настройки выберите, и попробуйте еще раз)"    , Toast.LENGTH_SHORT).show();
                    //////todo ошибка табель не сотздан
                } else {
                    СообщениеФинальноеКотороеСообщаетПользователюВстакиНовгоТАбеля("Создание Табеля", "Нет создание нового табеля", false);
                }
                ///TODO  НОВЫЙ ТАБЕЛЬ НЕ СОЗДАН ТАКОЙ УЖЕ ЕСТЬ
            }

            /////ловим ошибку

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }







    }
}





