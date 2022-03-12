package com.dsy.dsu;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.UiThread;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Tasks;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Spliterator;
import java.util.TimeZone;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


import static java.util.Calendar.getInstance;

import javax.crypto.NoSuchPaddingException;
import javax.sql.DataSource;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx.Subscription;

public class MainActivity_New_Cusomers extends AppCompatActivity implements DatePickerDialog.OnDateSetListener  {
    ////todo переменные для новго сотрдуника при создание на  активтик
    protected Button КнопкаСозданиеНовогоСотрудника;

    protected EditText ЗначениеФИОСозданиеСотрудника,  ЗначениеСНИЛССозданиеСотрудника;


    protected TextView  ЗначениеДеньРожденияСозданиеСотрудника;

    ///todo переменные для табеля
    String НазваниеТабеляВКоторомИНадоСоздатьНовогоСотрудника;

    String UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника;

    String НазваниеМесяцаТабеляВКоторомИНадоСоздатьНовогоСотрудника;

    String ДепартаментТабеляВКоторомИНадоСоздатьНовогоСотрудника;

    Configuration config;

    String ПубличноеИМяТабеля;

    Long УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель=0l;

    //String ЦифровоеИмяНовгоТабеля;
    String ПолноеИмяТабеляПослеСозданиеНовогоСотрудника;

    String UUIDСтарыйСамогоСозданогоТабелявКоторыйИнужноВставлятьНовгоСотрудника = "";

    String НовоеЗначениеUUIDДляОбновлениеТабеляКоторыйУжеСозданБЫл = "";

    String МесяцТабеляФинал = "";

    String UUIDCтарыйУжеСозданногоТабеляВКоторыйИНужноДобавитьНовгоПользователя = "";

    String ДепартаментТабеляФинал = "";

    Long UUIDДанныйПришелПослеВЫбораУжеСуществующегоСотрудника;

    protected Button КнопкаНазад;

    int ЦифровоеИмяНовгоТабеля;

    LinkedHashMap<String,Integer> ЛистДляАдаптераСпинерОрганизацияСамоЗначениеIDДляЗаписи;

    Long НовыйСгенерированныйUUIDДляТаблицыФИОКогдаСоздаетьсяНовыйСотрудник=0l;

    Activity activity;

    ///////TODO
    CREATE_DATABASE   Create_Database_СсылкаНАБазовыйКласс;
  ///  long    Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицыФИОФИНАЛ;

    Context КонтекстДляАктивтиСозданиеНовогоСотрудника;

    protected Spinner СпинерВыборОрганизацииПриСозданииНовогоСотрудника;/////спинеры для создание табеля

        String ПолученноеТекущееЗначениеСпинераОрганизация;

    long РезультатВставкиНовогоТабеляЧерезКонтрейнерТаблицыФИО;

    int Результат_ПриписиИзменнийВерсииДанныхВФонеПослеОбработкиТекущийТаблицыФИО;
    ///


       Long  НовыйСгенерированныйUUIDДляТаблицы_ДатаТабеля=0l;

    //TODO    28,01,2022--12,29

    Intent ИнтентПришелДепаартаментТабеля;

/*    int ГодПриВставкеНовогоСотрудника = 0;

    ////////
*//*
    ContentValues АдаптерДляСозданиеНовогоСотрудаТАблицаТабель;////контрейнер для нового табеля

    ContentValues АдаптерДляСозданиеНовогоСотрудаТАблицаФИО;////контрейнер для нового табеля
*//*



    int МЕсяцПриВставкеНовогоСотрудника = 0;*/





    // TODO: 12.10.2021  Ссылка Менеджер Потоков


    PUBLIC_CONTENT Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =null;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_create_new_customers);
        //TODO  ОЧИЩАЕМ ПАМТЬ
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);





///////TODO
        Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(getApplicationContext());


        activity=this;
        ////


            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new PUBLIC_CONTENT(getApplicationContext());


        /////todo данная настрока запрещает при запуке активти подскаваать клавиатуре вверх на компонеты eedittext
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD

                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON

                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
     //   getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION  );


        getSupportActionBar().hide(); ///скрывать тул бар
        /////todo данная настрока запрещает при запуке активти подскаваать клавиатуре вверх на компонеты eedittext

        КонтекстДляАктивтиСозданиеНовогоСотрудника=this;

        КнопкаСозданиеНовогоСотрудника = findViewById(R.id.КнопкаСозданиеНовогоТабеля);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
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

////TODO ИНИЗАЛИЗАУМЯ ОБЬЕКТОВ НА АКТИВИТИ
        ЗначениеФИОСозданиеСотрудника = findViewById(R.id.ЗначениеЦФОПриСозданииНовогоТабеля);

        ЗначениеДеньРожденияСозданиеСотрудника = findViewById(R.id.ЗначениеДепартаментаПриСоздаенииНовогоТабеля);

        ЗначениеСНИЛССозданиеСотрудника = findViewById(R.id.ЗначениеДатаСоздаваемогоТабеля);

        ЗначениеСНИЛССозданиеСотрудника = findViewById(R.id.ЗначениеДатаСоздаваемогоТабеля);
        //todo кнопка назад
        КнопкаНазад= findViewById(R.id.imageViewСтрелкаНазадНовыйСотрудник);


                СпинерВыборОрганизацииПриСозданииНовогоСотрудника= findViewById(R.id.значениеИзСпинераОрганизацияДляНовогоСотрудника);


        //todo пришили данные из преедедущего активти с названием табеля сСАМО ИМЯ И ЕГО UUID
        МетодПриемКонтентаОтДругихАктивти();



        МетодСозданиеСпинеровОрганизации(Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков);



//todo настройки


    }




    protected void МетодСозданиеСпинеровОрганизации(CompletionService МенеджерПотоковВнутри) {
        
        // TODO: 24.03.2021 ЕслиВубличногоНЕтТоНАходим ЕГо
        
        ArrayList<String> ЛистДляАдаптераСпинерОрганизация = new ArrayList<>();


         ЛистДляАдаптераСпинерОрганизацияСамоЗначениеIDДляЗаписи = new LinkedHashMap<>();

        SQLiteCursor    Курсор_ИщемВсеОрганизации=null;
        //
        Class_GRUD_SQL_Operations class_grud_sql_operationsСозданиеСпинеровОрганизации;

        try{
            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ
            ///
            class_grud_sql_operationsСозданиеСпинеровОрганизации=new Class_GRUD_SQL_Operations(getApplicationContext());

            ///
            class_grud_sql_operationsСозданиеСпинеровОрганизации. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","organization");
            ///////
            class_grud_sql_operationsСозданиеСпинеровОрганизации. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","*");
            //
            class_grud_sql_operationsСозданиеСпинеровОрганизации. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика"," name IS NOT NULL");
                    ///"_id > ?   AND _id< ?"
                    //////
/*
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",finalПолученныйUUID);
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 ....                  class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",finalПолученныйUUID);
*/
            ////TODO другие поля

            ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
            ////
            //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
            ////
          //  class_grud_sql_operationsПолучениеИмяСистемы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
            ////
            /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

            Курсор_ИщемВсеОрганизации= (SQLiteCursor)  class_grud_sql_operationsСозданиеСпинеровОрганизации.
                    new GetData(getApplicationContext()).getdata(class_grud_sql_operationsСозданиеСпинеровОрганизации. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    МенеджерПотоковВнутри,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());
            ////////////

            Log.d(this.getClass().getName(), "GetData " +Курсор_ИщемВсеОрганизации );

/*


// TODO: 07.09.2021    _old
                Курсор_ИщемВсеОрганизации =
                        new MODEL_synchronized(getApplicationContext()).КурсорУниверсальныйДляБазыДанных("organization",
                                new String[]{"*"}, " name IS NOT NULL", null, null, null, null, null);//


*/

            // TODO: 07.09.2021  полученный результат

                if(Курсор_ИщемВсеОрганизации.getCount()>0){


                    Курсор_ИщемВсеОрганизации.moveToFirst();

                    ЛистДляАдаптераСпинерОрганизация=new ArrayList<>();

                 ЛистДляАдаптераСпинерОрганизация.add("") ;


// TODO: 07.09.2021 _old по данным
                    do{

                        Log.d(this.getClass().getName(), " Курсор_ИщемПУбличныйIDКогдаегоНетВстатике " + Курсор_ИщемВсеОрганизации.getCount());


                        int ПолощениеСамаОрганизация=Курсор_ИщемВсеОрганизации.getColumnIndex("name");

                        String          СамаОрганизация =Курсор_ИщемВсеОрганизации.getString(ПолощениеСамаОрганизация);

                        Log.d(this.getClass().getName(), "  СамаОрганизация" +  СамаОрганизация);

                        ЛистДляАдаптераСпинерОрганизация.add(СамаОрганизация) ;

                        // TODO: 02.11.2021   ВтораяЧасть ПолученияID ДЛЯВставка



                        int ПолощениеСамаОрганизацияIDДЛяЗаписи=Курсор_ИщемВсеОрганизации.getColumnIndex("id");

                        Integer         СамаОрганизацияIDЗаписи =Курсор_ИщемВсеОрганизации.getInt(ПолощениеСамаОрганизацияIDДЛяЗаписи);

                        Log.d(this.getClass().getName(), "  СамаОрганизацияIDЗаписи" +  СамаОрганизацияIDЗаписи);


                        ЛистДляАдаптераСпинерОрганизацияСамоЗначениеIDДляЗаписи.put(СамаОрганизация,СамаОрганизацияIDЗаписи);


                        Log.d(this.getClass().getName(), "  ЛистДляАдаптераСпинерОрганизацияСамоЗначениеIDДляЗаписи" +  ЛистДляАдаптераСпинерОрганизацияСамоЗначениеIDДляЗаписи.values());

                    } while (Курсор_ИщемВсеОрганизации.moveToNext());
                    ////

                }
            // TODO: 07.09.2021 exit
            Курсор_ИщемВсеОрганизации.close();





// Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> АдаптерДляСпинераОрганизация = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,
                ЛистДляАдаптераСпинерОрганизация);
        // Определяем разметку для использования при выборе элемента
        АдаптерДляСпинераОрганизация.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        СпинерВыборОрганизацииПриСозданииНовогоСотрудника.setAdapter(АдаптерДляСпинераОрганизация);

        //
        СпинерВыборОрганизацииПриСозданииНовогоСотрудника.setHorizontalScrollBarEnabled(true);
        ////что быврали
        СпинерВыборОрганизацииПриСозданииНовогоСотрудника.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //////СПИНЕР ДЕПАРТАМЕНТ
                if (position>0) {///ставим ограничкния если выбрано не 0 позиция то запонимаеним

                    ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                    ((TextView) parent.getChildAt(0)).setTextSize(16);
                    ((TextView) parent.getChildAt(0)).setLines(5);
                    ((TextView) parent.getChildAt(0)).setTypeface(Typeface.DEFAULT_BOLD);
                    ((TextView) parent.getChildAt(0)).setHint("Выберете Организацию");
                    ((TextView) parent.getChildAt(0)).setHintTextColor(Color.parseColor("#675757"));
                    ((TextView) parent.getChildAt(0)).setBackgroundResource(R.drawable.textlines);
                    ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

                    ПолученноеТекущееЗначениеСпинераОрганизация = parent.getItemAtPosition(position).toString();

                    Log.d(this.getClass().getName(), "ПолученноеТекущееЗначениеСпинераОрганизация " + ПолученноеТекущееЗначениеСпинераОрганизация);
                        /*Toast toast = Toast.makeText(getApplicationContext(),
                                "Ваш выбор Раздел : " + ПолученноеЗначениеИзСпинераРаздел + " " + position, Toast.LENGTH_SHORT);
                        toast.show();*/

                }else if (position==0){
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                    ((TextView) parent.getChildAt(0)).setBackgroundResource(R.drawable.textlines);
                    ((TextView) parent.getChildAt(0)).setTextSize(16);
                    ((TextView) parent.getChildAt(0)).setLines(5);
                    ((TextView) parent.getChildAt(0)).setTypeface(Typeface.DEFAULT_BOLD);
                    ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                    ((TextView) parent.getChildAt(0)).setHint("Выберете Организацию");
                    ((TextView) parent.getChildAt(0)).setHintTextColor(Color.parseColor("#675757"));
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

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
    }















    @Override
    protected void onDestroy() {
        super.onDestroy();

        //////TODO  данный код срабатывает когда произошда ошивка в базе

    }






    @Override
    protected void onPause() {
        super.onPause();
        try {

          ///  МетодЗапускаЛокальнойСинхронизации();
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
    }









































    protected void МетодПриемКонтентаОтДругихАктивти() {
        ///////////
         ИнтентПришелДепаартаментТабеля = getIntent();
        ///TODO ИМЯ ТАБЕЛЯ
        НазваниеТабеляВКоторомИНадоСоздатьНовогоСотрудника = ИнтентПришелДепаартаментТабеля.getStringExtra("ДепартаментТабеляФинал");
        Log.d(this.getClass().getName(), " ДепартаментТабеляФинал :  " + НазваниеТабеляВКоторомИНадоСоздатьНовогоСотрудника);
        //TODO UUID ТАБЕЛЯ
        UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника = ИнтентПришелДепаартаментТабеля.getStringExtra("UUIDТабеляФинал");
        Log.d(this.getClass().getName(), " UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника :  " + UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника);
        //TODO имя самого месяца например июль 2020  ТАБЕЛЯ'
        НазваниеМесяцаТабеляВКоторомИНадоСоздатьНовогоСотрудника = ИнтентПришелДепаартаментТабеля.getStringExtra("МесяцТабеляФинал");
        Log.d(this.getClass().getName(), " НазваниеМесяцаТабеляВКоторомИНадоСоздатьНовогоСотрудника:  " + НазваниеМесяцаТабеляВКоторомИНадоСоздатьНовогоСотрудника);
/////////////
//TODO имя ПЕРЕД СОЗЖДАНИЕ НОВОГО СОТРУДНИКА ПЕРЕРДАЕМ ИМЯ ДЕПАРТЕМЕНТА
        ДепартаментТабеляВКоторомИНадоСоздатьНовогоСотрудника = ИнтентПришелДепаартаментТабеля.getStringExtra("ДепартаментТабеляВКоторомИНадоСоздатьНовогоСотрудника");
        Log.d(this.getClass().getName(), " НазваниеМесяцаТабеляВКоторомИНадоСоздатьНовогоСотрудника:  " + ДепартаментТабеляВКоторомИНадоСоздатьНовогоСотрудника);
//////
        ПубличноеИМяТабеля = ИнтентПришелДепаартаментТабеля.getStringExtra("СгенерированныйНазваниеНовогоТабеля");
        Log.d(this.getClass().getName(), " ПубличноеИМяТабеля  " + ПубличноеИМяТабеля);


        if( UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника==null){
            UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника= ИнтентПришелДепаартаментТабеля.getStringExtra("UUIDТабеляПослеУспешногоСозданиеСотрудника");
            Log.d(this.getClass().getName(), " UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника :  " + UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника);

        }


        //todo код работает после  подбора уже существующего сотрудника
        if (UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника == null) {
            UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника = UUIDCтарыйУжеСозданногоТабеляВКоторыйИНужноДобавитьНовгоПользователя;
        }


        if (new MainActivity_New_Tabely().СгенерированныйUUIDДляНовогоТабеля == null) {
            УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель = Long.parseLong(UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника.trim());

            ////todo когда ТАБЕЛЬ ТОЛЬКО СДЕЛАЛИ ИЗ ПЕРМЕНОЙ ЧИТАЕМ
        } else {

            ////todo когда ТАБЕЛЬ ТОЛЬКО СДЕЛАЛИ ИЗ ПЕРМЕНОЙ ЧИТАЕМ
            УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель = new MainActivity_New_Tabely().СгенерированныйUUIDДляНовогоТабеля;

        }


        if (УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель==null) {
            //TODO UUID ТАБЕЛЯ
           Long УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабельДополнительный = ИнтентПришелДепаартаментТабеля.getLongExtra("UUIDТабеляПослеУспешногоСозданиеСотрудника",0l);

            УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель= УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабельДополнительный;
        }


        /////
        ///TODO цифровоеимя табеля
        Intent Интент_ПришлиДанныеДляПосикаУжеСуществующегоСотрудникаДляСозданияТабеля = getIntent();
        if (ЦифровоеИмяНовгоТабеля==0) {
            ЦифровоеИмяНовгоТабеля = Интент_ПришлиДанныеДляПосикаУжеСуществующегоСотрудникаДляСозданияТабеля.getIntExtra("ЦифровоеИмяНовгоТабеля",0);
        }

        if (ПолноеИмяТабеляПослеСозданиеНовогоСотрудника==null) {
            ПолноеИмяТабеляПослеСозданиеНовогоСотрудника= ИнтентПришелДепаартаментТабеля.getStringExtra("ПолноеИмяТабеляПослеСозданиеНовогоСотрудника");
        }



        //todo код работает после  подбора уже существующего сотрудника
        if (UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника.length()==0 ) {


            UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника=
                    String.valueOf(ИнтентПришелДепаартаментТабеля.getLongExtra("ГлавныйУниверсальныйUUIDУжеСозданогоТабелявКоторвыйИНУжноВставитьСотрудника",0l));
        }







        //todo код работает после  подбора уже существующего сотрудника
        if (УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель==0 ) {


            УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель= ИнтентПришелДепаартаментТабеля.getLongExtra("РодительскийUUDТаблицыТабель",0l);
        }




        Log.d(this.getClass().getName(), " ЦифровоеИмяНовгоТабеля :  " + ЦифровоеИмяНовгоТабеля+ " ПолноеИмяТабеляПослеСозданиеНовогоСотрудника "
                +ПолноеИмяТабеляПослеСозданиеНовогоСотрудника+
                 "  УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель " +УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель +
                 "  UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника " +UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника);
    }





    @Override
    protected void onStart() {
        super.onStart();





        try{
            /////
            МетодЗапускаКодаПоСозданиюНовогоСотрудникаДляДвухТаблицФиоиДатаТабеля();


        /////
        МетодПолучениеДатыРожденияЧерезКалендарь();



        ////
        МетодВозврещениеНаПредыдущуюАктивтиBACK();

////




        ///
    } catch (Exception e) {
        //  Block of code to handle errors
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///////
    }






    }

///todo метод который возврящаем с текущего активити на предыдущий
///todo метод получение ДАТЫ РОЖДЕНИЯ ИЗ  КАЛЕНЛАРЯ
private void МетодВозврещениеНаПредыдущуюАктивтиBACK() {
    КнопкаНазад.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(this.getClass().getName(), " кликнем для созданни новго сотрдника при нажатии  ");
            ///todo код которыц возврящет предыдущий актвитики кнопка back
            //TODO ПОСЛЕ УСПЕШНОЙ СОЗДАНИЕ НОВОГО СОТРУДНИКА ПЕРЕХОДИМ В ТАБЕЛЯ

            МетодПослеУспешнгоСозданиеНовгоСотрудникаПереходимВТабеля();
            //////

        }
    });
}





///todo метод получение ДАТЫ РОЖДЕНИЯ ИЗ  КАЛЕНЛАРЯ
    private void МетодПолучениеДатыРожденияЧерезКалендарь() {
        ЗначениеДеньРожденияСозданиеСотрудника.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(this.getClass().getName(), " кликнем для созданни новго сотрдника при нажатии  ");
                МетодВытаскиваемИзКалендаряДиалогаКалендаряДаты();
            }
        });
    }
    ///поймать ошибку
    private void МетодВытаскиваемИзКалендаряДиалогаКалендаряДаты() {///////метод создание календяря даты
/////TODO тут визуализикуеться КАЛЕНДАРЬ
        DatePickerDialog ДатаДляКалендаря=new DatePickerDialog(this, (DatePickerDialog.OnDateSetListener) this,
                GregorianCalendar.getInstance().get(Calendar.YEAR),
                GregorianCalendar.getInstance().get(Calendar.MONTH),
                GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH));
        ДатаДляКалендаря.setIcon(R.drawable.icon_dsu1_new_customer7 );
        ДатаДляКалендаря.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        StringBuffer БуферПолученаяДатаРожденияСотрудника=new StringBuffer();
        //todo make offset
        switch (month){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                month=month+1;
                break;
                /////todo яныварь
            case 0:
                month=month+1;
                break;
        }
//todo выравниваем длину месяца
        String МесяцФинал=String.valueOf(month);
        if (МесяцФинал.length()==1) {
            МесяцФинал = "0" + МесяцФинал;
        }
        ////todo  выравниваем длину день
        String ДеньФинал=String.valueOf(dayOfMonth);
        if (ДеньФинал.length()==1) {
            ДеньФинал = "0" + ДеньФинал;
        }
        БуферПолученаяДатаРожденияСотрудника.append(ДеньФинал).append(".").append(МесяцФинал).append(".").append(year);
        Log.d(this.getClass().getName(), " stringBuffer  "+ БуферПолученаяДатаРожденияСотрудника.toString());
        //TODO ЗАПОЛНЯЕМ
        ЗначениеДеньРожденияСозданиеСотрудника.setText(БуферПолученаяДатаРожденияСотрудника.toString());
    }














    ///todo данный метод начальный для создание нового сотрудника с кнопки
       void МетодЗапускаКодаПоСозданиюНовогоСотрудникаДляДвухТаблицФиоиДатаТабеля()  throws  InterruptedException{


        try {
            ///TODO НАЧИНАЕМ СОЗДАВАТЬ НОВОГО СОТРУДУНИКА ЕСЛИ ПРИШИЛИ НАЗВАНИЕ ТАБЕЛЯ И ЕГО UUID





            ////todo кнопка по нажатию на которуюи создеться табель

            КнопкаСозданиеНовогоСотрудника.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        v2.vibrate(150);
                    }
                    Log.d(this.getClass().getName(), " ЗначениеФИОСозданиеСотрудника  "+ ЗначениеФИОСозданиеСотрудника+
                            " ЗначениеДеньРожденияСозданиеСотрудника  " + ЗначениеДеньРожденияСозданиеСотрудника +
                            " ЗначениеСНИЛССозданиеСотрудника  " +ЗначениеСНИЛССозданиеСотрудника);



                    int ТекущаяПозицияСпинерВыборОрганизацииПриСозданииНовогоСотрудника=СпинерВыборОрганизацииПриСозданииНовогоСотрудника.getSelectedItemPosition();

                    ПолученноеТекущееЗначениеСпинераОрганизация=( СпинерВыборОрганизацииПриСозданииНовогоСотрудника.getItemAtPosition(ТекущаяПозицияСпинерВыборОрганизацииПриСозданииНовогоСотрудника).toString());



                    Log.d(this.getClass().getName(), " ПолученноеТекущееЗначениеСпинераОрганизация  "+ ПолученноеТекущееЗначениеСпинераОрганизация);


/////TODO перед созданием определяем не пустые ли значения
                    if (ЗначениеФИОСозданиеСотрудника.length() > 4

                            && ЗначениеДеньРожденияСозданиеСотрудника.length() > 4

                            && ЗначениеСНИЛССозданиеСотрудника.length()==11 &&


                            ТекущаяПозицияСпинерВыборОрганизацииПриСозданииНовогоСотрудника!=0 &&
                            СпинерВыборОрганизацииПриСозданииНовогоСотрудника.getItemAtPosition(ТекущаяПозицияСпинерВыборОрганизацииПриСозданииНовогоСотрудника).toString()!=null &&


                            СпинерВыборОрганизацииПриСозданииНовогоСотрудника.getItemAtPosition(ТекущаяПозицияСпинерВыборОрганизацииПриСозданииНовогоСотрудника).toString()!="") {


                        // TODO: 23.09.2021  получение из даты месяц и год


                        Log.d(this.getClass().getName(), " НазваниеМесяцаТабеляВКоторомИНадоСоздатьНовогоСотрудника  "
                                + НазваниеМесяцаТабеляВКоторомИНадоСоздатьНовогоСотрудника);

                        int МесяцТекущегоТабеля=0;//

                        int ГодТекущегоТабеля=0;


                        Class_Generation_From_Name_Date_To_Diginal_Name class_generation_from_name_date_to_diginal_nameперерводимИзНАзваниеДатуВЦифру=new Class_Generation_From_Name_Date_To_Diginal_Name(getApplicationContext());

                        //
                        try {
                             МесяцТекущегоТабеля=           class_generation_from_name_date_to_diginal_nameперерводимИзНАзваниеДатуВЦифру. МетодПолучениниеМесяцПриСозданииНовогоСОтрудника(НазваниеМесяцаТабеляВКоторомИНадоСоздатьНовогоСотрудника);

                            ////
                            Log.d(this.getClass().getName(), " МесяцТекущегоТабеля  "+ МесяцТекущегоТабеля);

                            ГодТекущегоТабеля = class_generation_from_name_date_to_diginal_nameперерводимИзНАзваниеДатуВЦифру.МетодПолучениниеГОдПриСозданииНовогоСОтрудника(НазваниеМесяцаТабеляВКоторомИНадоСоздатьНовогоСотрудника);

                            Log.d(this.getClass().getName(), " ГодТекущегоТабеля  "+ ГодТекущегоТабеля);
                            ////////
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }


                        ///TODO создание нового сотрудника

                        try {

                            ///
                            // TODO: 22.09.2021 обработка ТАБЛИЦА ФИО
                            Long  ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_ФИО= null;


                            try {
                                // TODO: 24.09.2021

                                ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_ФИО = new Class_Generator_New_Customer_In_Table_Fio().
                                        МетодСозданиеНовогоСотрудникаДля_Таблицы_ФИО(ТекущаяПозицияСпинерВыборОрганизацииПриСозданииНовогоСотрудника);

                                /////todo


                                // TODO: 22.09.2021 ПОСЛЕ ДВУХ ОБРАБОТКАХ  ФИО И ДАТА_ТАБЕЛЬ ПЕРЕРХОДИМ НА ДРГОЕ АКТИВТИ

                                Log.d(this.getClass().getName(), " ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_ФИО  "
                                        +ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_ФИО);



                            } catch (InterruptedException e) {
                                e.printStackTrace();

                                //  Block of code to handle errors
                                ///метод запись ошибок в таблицу
                                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());






                            } finally {



                            // TODO: 22.09.2021 обработка ТАБЛИЦА ДАТА_ТАБЕЛЯ




                                   Long       ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_Дата_Табеля =0l;




                            Log.d(this.getClass().getName(), " УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель  "
                                    +УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель  +
                                    "  ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_ФИО "+ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_ФИО);

                                //todo код работает после  подбора уже существующего сотрудника
                                if (УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель==0 ) {


                                    УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель= ИнтентПришелДепаартаментТабеля.getLongExtra("РодительскийUUDТаблицыТабель",0l);
                                }




                            if (ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_ФИО>0 && УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель>0) {

                                        // TODO: 22.09.2021 обработка ТАБЛИЦА ДАТА_ТАБЕЛЯ  вторая часть ПРОИЗВОДИМ ВСТАВКУ ВО ТРОРУЮ ТАБЛИЦУ ПОСЛЕ ТАБЛИЦЫ ФИО

                                    ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_Дата_Табеля = new Class_Generator_New_Customer_In_Table_Data_Tables().
                                                МетодСозданиеНовогоСотрудника_вТаблицу_Дата_Табеля(НовыйСгенерированныйUUIDДляТаблицыФИОКогдаСоздаетьсяНовыйСотрудник,
                                                        Long.valueOf(УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель),
                                                        МесяцТекущегоТабеля,
                                                        ГодТекущегоТабеля);


                                        // TODO: 22.09.2021 ПОСЛЕ ДВУХ ОБРАБОТКАХ  ФИО И ДАТА_ТАБЕЛЬ ПЕРЕРХОДИМ НА ДРГОЕ АКТИВТИ

                                        Log.d(this.getClass().getName(), " ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_Дата_Табеля  "+ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_Дата_Табеля);




                                    }else {


                                        activity.runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                /////
                                                Snackbar.make(v, "Ошибка  не создан сотрудник (СНИЛС уже есть )!!! ", Snackbar.LENGTH_LONG).show();

                                                ////
                                                ///Toast.makeText(getApplicationContext(), "Ошибка не создаен сотрудник (в таблице фио) !!! ", Toast.LENGTH_SHORT).show();
                                            }
                                        });


                                    }


                                    //TODO ПОСЛЕ УСПЕШНОЙ СОЗДАНИЕ НОВОГО СОТРУДНИКА ПЕРЕХОДИМ В ТАБЕЛЯ

                                    if (ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_Дата_Табеля>0) {


                                        ////////////
                                        Log.d(this.getClass().getName(), " ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_Дата_Табеля  "+ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_Дата_Табеля);
                                        ///////
                                        МетодПослеУспешнгоСозданиеНовгоСотрудникаПереходимВТабеля();



                                    }else {

                                        ///
                                        Log.d(this.getClass().getName(), " ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_Дата_Табеля  " + ФинальныйРезультатВставкиНовгоСотрудникаВТаюлицу_Дата_Табеля);


                                        activity.runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {

                                                Snackbar.make(v, "Ошибка не создаен сотрудник (в таблице дата_табеля) !!! ", Snackbar.LENGTH_LONG).show();

                                                /////
                                               // Toast.makeText(getApplicationContext(), "Ошибка не создаен сотрудник (в таблице дата_табеля) !!! ", Toast.LENGTH_SHORT).show();
                                            }
                                        });


                                        // TODO: 23.09.2021  exit element

                                    }


                            }

                            ///
                            Log.d(this.getClass().getName(), " ЗАВЕРШИЛИ ВСТАВКИ НОВОГО СОТРУДНИКА СРАЗУ В ДВЕ ТАБЛИЦЫ ФИО И ДАТА ТАБЕЛЬС ");


                            ///поймать ошибку
                        } catch (Exception e) {
                            //  Block of code to handle errors
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                            ///////
                        }


                    } else {


                        Snackbar.make(v, "Не все поля заполены  или некорректно !!! (СНИЛС от 11 знаков) ", Snackbar.LENGTH_LONG).show();
                        //


                        Log.i(this.getClass().getName(), " Не все поля заполены (снилс от 10 знаков) ");


                    /*    Toast aa = Toast.makeText(getApplicationContext(), "Вы не заполнили ФИО/Дата рождения/СНИЛС/Организацию",Toast.LENGTH_SHORT);
                        ImageView cc = new ImageView(getApplicationContext());
                        cc.setImageResource(R.drawable.icon_dsu1_add_organisazio_error);//icon_dsu1_synchronisazia_dsu1_success
                        aa.setView(cc);
                        aa.show();
                    *//*   // Toast.makeText(getApplicationContext(), "Вы не заполнили ФИО/Дата рождения/СНИЛС/Организацию"
                                +"\n"+" (заполните и повторите попытку).", Toast.LENGTH_SHORT).show();*/

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
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///////
        }
    }















































































































































// TODO: 22.09.2021  ОБРАБОТКА ТАБЛИЦЫ ДАТА_ТАБЕЛЯ











































/////TODO ДАННЫЙ МЕТОД ОПРЕДЕЛЯЕТ ЧТОБЫ МЫ БУДЕМ ДЕЛАТЬ ВСТАВЛЯТЬ НОВОГО СОТРУДНИКА КАК НОВОГО ИЛИ В БАЗЕ УЖЕ ЕСТЬ ХОТЬ ОДНА ЗАПИСЬ И ЭТО БУДЕТ НЕ ПЕРВЫЙ СОТРУДНИКА В ДАННОМ ТАБЕЛЕ


    private String МетодКоторыйОпределетЧТоБУдемДелатьОбновлятьИлиВставлятьНовгСОтрудника()
            throws ExecutionException, InterruptedException, TimeoutException {
        try{



        Cursor Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем=null;


         Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем =

                МетодПроверяетПустойЛиТабельПервыйЗапускТабеляЧтоДелатьОбновлятьИлиВставлять();

        if (Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.getCount() > 0) { //TODO ЕСЛИ ДАННЫЙ UUID НЕ ПУСТОЙ ЭТО ЗНАЧИТ ЧТО ЭТОТ ТАБЕЛЬ УЖЕ СУЩЕТСВЕТ И НАМ НАДО ОБНОВИТЬ

            ////TODO ТАБЕЛЬ УЖЕ ЕСТЬ И МЫ ЕГО ОБНОЫЛЕНИЯ ПубличноеИмяНовогоТабеля
            Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.moveToFirst();

            Log.d(this.getClass().getName(), " Курсор_ПонятьМыВставляемВПУстойТабельСотрудникаИЛиОбновлеемЕго.getString(1) " +

                    Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.getString(0));


            НовоеЗначениеUUIDДляОбновлениеТабеляКоторыйУжеСозданБЫл =

                    Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.getString(0);

            ////TODO ИЩЕМ СТРАЙ UUID САМОГО ТАБЕЛЯ КОТОРЫЙ УЖЕ СОЗДАН


            //todo close cursor
            Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.close();
        }



    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());
    }



        return НовоеЗначениеUUIDДляОбновлениеТабеляКоторыйУжеСозданБЫл;
    }
















    @NotNull
    private Cursor МетодПроверяетПустойЛиТабельПервыйЗапускТабеляЧтоДелатьОбновлятьИлиВставлять()
            throws ExecutionException, InterruptedException, TimeoutException {

        //
        Class_GRUD_SQL_Operations class_grud_sql_operationsПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем;
        ///


        //
        SQLiteCursor Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем =null;
        try{


        //todo табель еще есть м ыв уже сущетсвещющеуй табель не всталяем  а обнолвяем
////TODO КУРСОР ПРОВЕЯЕТ ПЕРВЫЙ ЭТО ЗАПУСК ИЛИ НЕТ

            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

            ///
            class_grud_sql_operationsПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем=
                    new Class_GRUD_SQL_Operations(getApplicationContext());

            ///
            class_grud_sql_operationsПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","tabels");
            ///////
            class_grud_sql_operationsПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","fio");
            //
            class_grud_sql_operationsПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","uuid=? ");
                    ///"_id > ?   AND _id< ?"
                    //////
            class_grud_sql_operationsПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);
                    ///
        /*            class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
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
      /*      class_grud_sql_operationsПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");*/
            ////
            /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
            ////

            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

            //
       Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем =null;

   /////
            Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем
                    = (SQLiteCursor)  class_grud_sql_operationsПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.
                    new GetData(getApplicationContext()).getdata(class_grud_sql_operationsПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков
                    ,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

            Log.d(this.getClass().getName(), "GetData "  +Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем);




/*

            // TODO: 07.09.2021   _old
 Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем =
                new MODEL_synchronized(this).КурсорУниверсальныйДляБазыДанных("tabels",
                        new String[]{"fio"}, "uuid=?", new String[]{УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель}, null, null, null, null);//"SuccessLogin", "date_update","id=","1",null,null,null,null
        ///TODO УДАЛЕМ ПАМЯТЬ*/


//todo определяем есть uuid в строчке или нет
        Log.d(this.getClass().getName(), "Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем " +
                Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем.getCount());
        /////s



    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

    }

        return Курсор_КоторыйПроверяетЭтоПустаяЯчейкаUUIDЕслиПустоеНоЭтоНовыйТабельБезСотрудниковиМыНеВставляемАОбновлем;
    }

    ////////todo































    //TODO ПОСЛЕ УСПЕШНОЙ СОЗДАНИЕ НОВОГО СОТРУДНИКА ВОЗВРАЩАЕМСЯ ОБРАТНО В ТАБЕЛЬ КУДА ДОБАВЛЯЛИ СОТРУЛНИКА


    private void МетодПослеУспешнгоСозданиеНовгоСотрудникаПереходимВТабеля() {
        try{


            Vibrator v2 = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v2.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26
                v2.vibrate(150);
            }


        Intent ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника = new Intent();


            //   Интент_ПослеПодбораДействуещегоСотрудникаОтпраляемЕгоДляВставки.putExtra("UUIDТабеляПослеПодбораУниверсальный", UUIDТабеляФинал);
            //todo запускаем активти после успешно создданого сотрудка
            ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.setClass(this, MainActivity_List_Employees_Current_Tabel.class); // ТУТ ЗАПВСКАЕТЬСЯ ВЫБОР ПРИЛОЖЕНИЯ КОТОРЫЕ ЕСТЬ FACE APP НА ДАННЫЙ МОМЕТНТ РАЗРАБОТНАО ТАБЕЛЬНЫЙ УЧЁТ
            //////

        ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("НазваниеТабеляВКоторомИНадоСоздатьНовогоСотрудника",   ПолноеИмяТабеляПослеСозданиеНовогоСотрудника );

            ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("ПолноеИмяТабеляПослеСозданиеНовогоСотрудника",   ПолноеИмяТабеляПослеСозданиеНовогоСотрудника );

        ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника", УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);

            ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("РодительскийUUDТаблицыТабель", УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);

            Log.d(this.getClass().getName(), "  УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель " + УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);



        ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("НазваниеМесяцаТабеляВКоторомИНадоСоздатьНовогоСотрудника", НазваниеМесяцаТабеляВКоторомИНадоСоздатьНовогоСотрудника);

        ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("ДепартаментТабеляВКоторомИНадоСоздатьНовогоСотрудника",  ПолноеИмяТабеляПослеСозданиеНовогоСотрудника);

        ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель",
                УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);
        ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("UUIDТабеляПослеПодбораУниверсальный",
                УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);
        ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("UUIDТабеляКнопкаBACKУниверсальный",
                UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника);
        ///todo ПОЛНОЕ ИМЯ ТАБЕЛЯ
        ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("ПолноеИмяТабеляПослеСозданиеНовогоСотрудника", ПолноеИмяТабеляПослеСозданиеНовогоСотрудника);


            ///TODO цифровоеимя табеля
            ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("ЦифровоеИмяНовгоТабеля", ЦифровоеИмяНовгоТабеля);


            // TODO: 22.09.2021  clear operasion

            Log.d(this.getClass().getName(), "  УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель " + УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);

            ///TODO КОДИТЕЛЬСКИЙ uuid ТАБЕЛЯ В КОТОРОМ ПРОЗВОДЯТ ДЕЙСТВИЯ ВСТАВКИ СОТРУДНИКА
            ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.putExtra("РодительскийUUDТаблицыТабель", УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);


            // TODO: 22.09.2021  clear operasion







            ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        startActivity(ИнтентФиналПослеУспешногоСозданиеНовгоСотрудника);
        ////
////TODO  100% процентов обязательная команда КОРОТАЯ УБИРАЕТ ИЗ ПАМЯТИ ВСЕ ПЕРЕКРЕСТНЫЕ ЗАПРОСЫ ОТ ТЕКУЩЕГО АКТИВТИ  ПОМТОМУ ЧТО В ПУЛЕ ЗАПРОССО ВЧТО ОТСАЕТЬСЯ
            finish();




        } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
    }





    ///todo сообщение на активти создание новго сотрудника спрашиваем нужно ли создать
    @UiThread
    protected void СообщениеСообщаетОСоздаенииНовогоСотрудника(String ШабкаДиалога, final String СообщениеДиалога, boolean статус) {
        ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ
        int ФлагЗнака;
        if (статус) {
            ФлагЗнака = R.drawable.icon_dsu1_new_customer_success;
        } else {
            ФлагЗнака = R.drawable.icon_dsu1_new_customer_error;
        }

        try {
//////сам вид
            final AlertDialog alertDialog = new MaterialAlertDialogBuilder(КонтекстДляАктивтиСозданиеНовогоСотрудника)
                    .setTitle(ШабкаДиалога)
                    .setMessage(СообщениеДиалога)
                    .setPositiveButton("ОК", null)
                    .setIcon(ФлагЗнака)
                    .show();
/////////кнопка
            final Button MessageBoxUpdateСоздатьТабель = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
            MessageBoxUpdateСоздатьТабель.setOnClickListener(new View.OnClickListener() {
                ///MessageBoxUpdate метод CLICK для DIALOBOX
                @Override
                public void onClick(View v) {
                    //удаляем с экрана Диалог
                    alertDialog.dismiss();
                    Log.d(this.getClass().getName(), "  ФИНАЛ создание нового сотрудника ");

                    if (статус) {
                        ///todo после как мы либо создали новогосо остружника или обновли его в табел то обнуляем



                        //todo обнуляем ПОСЛЕ ВСТАВКИ НОВГО СОТРУДНИКА

                        ЗначениеФИОСозданиеСотрудника=null;

                        ЗначениеДеньРожденияСозданиеСотрудника=null;

                        ЗначениеСНИЛССозданиеСотрудника=null;

///TODO метод запуска формы после вставки
                        //TODO ПОСЛЕ УСПЕШНОЙ СОЗДАНИЕ НОВОГО СОТРУДНИКА ПЕРЕХОДИМ В ТАБЕЛЯ



                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    /////////todo проверика подключение к wi fi












































    // TODO: 22.09.2021   KLASS GENERATOR NEW CUSTOMERS  IN TABLE FIO


    class  Class_Generator_New_Customer_In_Table_Fio   {
        /////////
        public Class_Generator_New_Customer_In_Table_Fio() {


        }

        // TODO: 22.09.2021   обработка ТАБЛИЦЫ ФИО



        // TODO: 22.09.2021  ЗАПИСЬ НОВОГО СОТДУНИКА ПЕРВОЕ  ДЕЙСТИЕ ЗАПИСЬВ ТАБЛИЦУ ФИО



      protected Long МетодСозданиеНовогоСотрудникаДля_Таблицы_ФИО(int ПолученноеТекущееЗначениеСпинераОрганизацияЦифра) throws InterruptedException {


            Log.d(this.getClass().getName(), " МетодСозданиеНовогоСотрудникаДля_Таблицы_ФИО");

            Long РезультаВставкиДАнныхНовогоСОтрудникаВТаблицу_ФИО=0l;


            try {
                // TODO: 22.09.2021  начинаем заполнять табдицу ФИО


                ContentValues АдаптерДляСозданиеНовогоСотрудаТАблицаФИО = new ContentValues();////контрейнер для нового табеля


                ////TODO
                String НазваниеФИО=ЗначениеФИОСозданиеСотрудника.getText().toString();
                //
                String ЗначениеДеньРождения=ЗначениеДеньРожденияСозданиеСотрудника.getText().toString();
                //

                Object  ПолученныйСНИЛСНовогоСотрудникаПереход=ЗначениеСНИЛССозданиеСотрудника.getText().toString().replaceAll("[^0-9]","").trim();


                Long ПолученныйСНИЛСНовогоСотрудника=Long.parseLong(ПолученныйСНИЛСНовогоСотрудникаПереход.toString());


                // TODO: 22.09.2021

                Log.w(getApplicationContext().getClass().getName(), "    НазваниеФИО    " + НазваниеФИО +
                        " ЗначениеДеньРождения "+ЗначениеДеньРождения+
                        "  ПолученныйСНИЛСНовогоСотрудника "+ПолученныйСНИЛСНовогоСотрудника);

                // TODO: 25.03.2021 начинаем заполнятьконтейнеры информацией

                АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("name",НазваниеФИО);


                // TODO: 23.09.2021  дополнительное заполения трех полей фио

        Integer ЕслиПробел=        НазваниеФИО.indexOf(" ");

                Log.w(getApplicationContext().getClass().getName(), "    ЕслиПробел    " +ЕслиПробел);


                if (ЕслиПробел>=0) {

              /*      long occurrencesCount =0;

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                        ////
                       occurrencesCount = НазваниеФИО.chars().filter(ch -> ch == ',').count();
                    }*/

                    int КоличествоПробелов = НазваниеФИО.length() - НазваниеФИО.replace(" ", "").length();

                    Log.w(getApplicationContext().getClass().getName(), "    occurrencesCount    " +КоличествоПробелов);

                    ////
                    String s1[]=НазваниеФИО.split("\\s+");


                    // TODO: 02.11.2021
                    //
                    if (КоличествоПробелов==1) {
                        if (s1[0]!=null) {
                            АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("f",s1[0]);
                        }
                        // TODO: 02.11.2021
                        if (s1[1]!=null) {
                            АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("n",s1[1]);
                        }

                    }else {

                        if (КоличествоПробелов>=2) {
                            /////
                            if (s1[0]!=null) {
                                АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("f",s1[0]);
                            }
                            //////////
                            if (s1[1]!=null) {
                                АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("n",s1[1]);
                            }

                            if (s1[2]!=null) {
                                АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("o",s1[2]);
                            }
                        }
                    }
                    //


                }
                Log.d(this.getClass().getName(), "  АдаптерДляСозданиеНовогоСотрудаТАблицаФИО " + АдаптерДляСозданиеНовогоСотрудаТАблицаФИО);

                // TODO: 23.09.2021  повыщаем верисю

            Long    РезультатВычисляемВреисюДанных=
                    new Class_GRUD_SQL_Operations(getApplicationContext()).new ChangesVesionData(getApplicationContext()).
                            МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table("fio",
                            "localversionandroid_version",getApplicationContext()
                                    ,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());
            ///

                Log.d(this.getClass().getName(), "  current_table УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННЫХ ВНУТРИ ТАБЛИЦЫ  РезультатВычисляемВреисюДанных " + РезультатВычисляемВреисюДанных);
                ////

                // TODO: 23.09.2021  повышаем верисю таблицы фио

                АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("current_table",РезультатВычисляемВреисюДанных);





                //
                АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("BirthDate",ЗначениеДеньРождения);
                ///
                АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("snils",ПолученныйСНИЛСНовогоСотрудника);




                // TODO: 01.11.2021  ПРОВЛДИМ АНАЛИЗ НЕТ ЛИ СЛУЧАЙНО СОЗДАВАЕМОГО СОТРУДНИКА В ТАБЛИЦЕ ФИО

                Class_GRUD_SQL_Operations class_grud_sql_operationsИщемВТАблицеФИОНЕтЛИСлучайноТАковожеСотрудника=new Class_GRUD_SQL_Operations( getApplicationContext());

                ///
                class_grud_sql_operationsИщемВТАблицеФИОНЕтЛИСлучайноТАковожеСотрудника.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы", "fio");
                ///////
                class_grud_sql_operationsИщемВТАблицеФИОНЕтЛИСлучайноТАковожеСотрудника.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки", "snils");
                //
                class_grud_sql_operationsИщемВТАблицеФИОНЕтЛИСлучайноТАковожеСотрудника.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика",
                        " snils=?  ");
                ///"_id > ?   AND _id< ?"
                //////
                class_grud_sql_operationsИщемВТАблицеФИОНЕтЛИСлучайноТАковожеСотрудника.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",ПолученныйСНИЛСНовогоСотрудника);
                ///
                // TODO: 01.11.2021

                //////

                  /*  class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","Удаленная");
                    ///
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",МЕсяцДляКурсораТабелей);
                    //
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4",ГодДляКурсораТабелей);////УсловиеПоискаv4,........УсловиеПоискаv5 .......

                    ////TODO другие поля*/

                ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
                ////
                //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
                ////
                class_grud_sql_operationsИщемВТАблицеФИОНЕтЛИСлучайноТАковожеСотрудника.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки", "date_update DESC");
                ////
                class_grud_sql_operationsИщемВТАблицеФИОНЕтЛИСлучайноТАковожеСотрудника.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита", "1");
                ////

                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
                SQLiteCursor Курсор_ИщемПроверяемНетЛиСлучайноУжеУказаногСОтрудникаВТАблицеФИО = null;


                Курсор_ИщемПроверяемНетЛиСлучайноУжеУказаногСОтрудникаВТАблицеФИО = (SQLiteCursor) class_grud_sql_operationsИщемВТАблицеФИОНЕтЛИСлучайноТАковожеСотрудника.
                        new GetData(getApplicationContext()).getdata(class_grud_sql_operationsИщемВТАблицеФИОНЕтЛИСлучайноТАковожеСотрудника.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков, Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

                Log.d(this.getClass().getName(), "Курсор_ИщемПроверяемНетЛиСлучайноУжеУказаногСОтрудникаВТАблицеФИО " + Курсор_ИщемПроверяемНетЛиСлучайноУжеУказаногСОтрудникаВТАблицеФИО+ " ПолученныйСНИЛСНовогоСотрудника " +ПолученныйСНИЛСНовогоСотрудника);

                // TODO: 01.11.2021

                if( Курсор_ИщемПроверяемНетЛиСлучайноУжеУказаногСОтрудникаВТАблицеФИО.getCount()==0){










                ///todo перед СОЗДАНИЕ/ДОБАЛВЕНИМ НОВГО СОТРУДНИКА ОПЕРДЕЛЯЕМ UUID ЧИТАЕМ ЕГО ИЗ ТАБЛИЦЫ НА КОНКТЕРНЫЙ ТЕКУЩИЙ ТАБЕЛЬ ИЛИ ТАБЕЛЬ ТОЛЬКО СДЕЛАЛИ И UUID СЧИТЫВАЕМ С ПЕРЕМЕННОЙ
                ///todo ДАННОЕ ЗНАЧЕНИЕ НУЖНО УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель ТОЛЬКО ДЛЯ ОБНОЛВЕНИЕ ЗАПИСИ ЧТОБЫ ПОНЯТЬ В UPDATE КАКУЮ СТОРЧКУ ОБНОВЕЯТЬ



                Log.d(this.getClass().getName(), "  УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель " + УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);


/////TODO ГЕНЕРИРУЕМ НОВЫЙ UUID ДЛЯ ТАБЕЛЯ ПРИ СОЗДАНИИ НОВОГО СОТРУДНИКА ТУТ НОВЫЙ UUID ТОЛЬКО СОЗДАННЫЙ

    /*            /////
                UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника =  (String)  new Class_Generation_UUID(getApplicationContext()).МетодГенерацииUUID(getApplicationContext());

                Log.d(this.getClass().getName(), " UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника    " + UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника);
*/


                ////todo создаение UUID
               НовыйСгенерированныйUUIDДляТаблицыФИОКогдаСоздаетьсяНовыйСотрудник=0l;
                /////
                 НовыйСгенерированныйUUIDДляТаблицыФИОКогдаСоздаетьсяНовыйСотрудник= (Long) new Class_Generation_UUID(getApplicationContext()).МетодГенерацииUUID(getApplicationContext());
                ///

                Log.d(this.getClass().getName(), " НовыйСгенерированныйUUIDДляТаблицыФИОКогдаСоздаетьсяНовыйСотрудник " + НовыйСгенерированныйUUIDДляТаблицыФИОКогдаСоздаетьсяНовыйСотрудник);

                ///
                АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("uuid",НовыйСгенерированныйUUIDДляТаблицыФИОКогдаСоздаетьсяНовыйСотрудник);




/////TODO ГЕНЕРИРУЕМ НОВЫЙ UUID ДЛЯ ТАБЕЛЯ ПРИ СОЗДАНИИ НОВОГО СОТРУДНИКА
                /////

                Log.d(this.getClass().getName(), " UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника " + UUIDТабеляВКоторомИНадоСоздатьНовогоСотрудника);



                String ДатаПРиСозданииНовогоСотрудника=null;



                ////TODO ДАТА
                String СгенерированованныйДатаДляДаннойОперации=     new Class_Generation_Data(getApplicationContext()).ГлавнаяДатаИВремяОперацийСБазойДанных();

                //////////////////////

                ДатаПРиСозданииНовогоСотрудника = СгенерированованныйДатаДляДаннойОперации;

                Log.d(this.getClass().getName(), " ДатаПРиСозданииНовогоСотрудника" + ДатаПРиСозданииНовогоСотрудника);

                АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("date_update",ДатаПРиСозданииНовогоСотрудника);



                ////todo месяц и год нового сотрудника



                if (ЦифровоеИмяНовгоТабеля>0) {

                    // TODO: 25.03.2021 текущая оргниазция дтя аьдицы ФИО

                 //   ПолученноеТекущееЗначениеСпинераОрганизация

                         //   ЛистДляАдаптераСпинерОрганизацияСамоЗначениеIDДляЗаписи


                Integer ПолученныйIDОрганизации=  (Integer)  ЛистДляАдаптераСпинерОрганизацияСамоЗначениеIDДляЗаписи.get(ПолученноеТекущееЗначениеСпинераОрганизация);

                    Log.d(this.getClass().getName(), "ПолученныйIDОрганизации "+ПолученныйIDОрганизации   + " ПолученноеТекущееЗначениеСпинераОрганизацияЦифра " +ПолученноеТекущееЗначениеСпинераОрганизацияЦифра);

                    // TODO: 02.11.2021

                    АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("current_organization",ПолученныйIDОрганизации); ///1

                    // TODO: 22.04.2021  srart JOBschedele
                    Log.d(this.getClass().getName(), "ПолученноеТекущееЗначениеСпинераОрганизация "+ПолученноеТекущееЗначениеСпинераОрганизация +
                            "  ПолученныйIDОрганизации " +ПолученныйIDОрганизации);

                    // TODO: 25.03.2021 заполяем  user_update

                    // TODO: 24.03.2021 ЕслиВубличногоНЕтТоНАходим ЕГо
                    int ПолученныйID = 0;

                    // TODO: 07.09.2021

                    // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ


                    Class_GRUD_SQL_Operations class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике;
                    ///
                    class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике=new Class_GRUD_SQL_Operations(getApplicationContext());

                    ///
                    class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","SuccessLogin");
                    ///////
                    class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","id");
                    //
                    class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","id IS NOT NULL");
                    ///"_id > ?   AND _id< ?"
                    //////
           /*         class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",finalПолученныйUUID);
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
                    class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
                    ////
                    /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                    ////

                    // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

                    SQLiteCursor Курсор_ИщемПУбличныйIDКогдаегоНетВстатике = null;


                    Курсор_ИщемПУбличныйIDКогдаегоНетВстатике= (SQLiteCursor)  class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике.
                            new GetData(getApplicationContext()).getdata(class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков
                            ,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());
                    ////////

                    Log.d(this.getClass().getName(), "GetData "  +Курсор_ИщемПУбличныйIDКогдаегоНетВстатике);



/*

                        // TODO: 07.09.2021      _old вариант

                        Курсор_ИщемПУбличныйIDКогдаегоНетВстатике =
                                new MODEL_synchronized(getApplicationContext()).КурсорУниверсальныйДляБазыДанных("SuccessLogin",
                                        new String[]{"id"}, " id IS NOT NULL", null, null, null, null, null);//
*/


                    // TODO: 07.09.2021  результат
                    if (Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.getCount() > 0) {
                        /////////////
                        Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.moveToFirst();
                        ////
                        Log.d(this.getClass().getName(), " Курсор_ИщемПУбличныйIDКогдаегоНетВстатике " + Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.getCount());

                        ПолученныйID = Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.getInt(0);


                    }


                    Log.d(this.getClass().getName(), "   ПолученныйID " + ПолученныйID);






                    if (ПолученныйID > 0) {
                        /////
                        АдаптерДляСозданиеНовогоСотрудаТАблицаФИО.put("user_update", ПолученныйID);

                    }


///////TODO САМ ВЫЗОВ МЕТОДА ОБНОВЛЕНИЕ ЛОКАЛЬНОГО-------СКОПИРОВАН КОД ИЗ УДАЕННОГО МЕТОДА



                    // TODO: 25.03.2021 получеам текущую организацию
                    // TODO: 24.03.2021 ЕслиВубличногоНЕтТоНАходим ЕГо
                    final int[] ТекущуюОрганизацию = {0};


                    final Cursor[] Курсор_ИщемТекущуюОрганизациюКоторуюВыбраСОтрудник = {null};


                    Log.d(this.getClass().getName(),"ТекущуюОрганизацию[0] " + ТекущуюОрганизацию[0] );




                    //// TODO КОНЕЦ СамаВставка нового сотрудника в новый табель
                }else{
                    Log.e(this.getClass().getName(), " нет данных из предцдуещго табеля");
                }

                // TODO: 23.09.2021  повышаем верисю таблицы фио









                // TODO: 08.09.2021  метод после заполения данными

                РезультаВставкиДАнныхНовогоСОтрудникаВТаблицу_ФИО=       new Class_Generations_New_Customers_For_Tabels(getApplicationContext()).
                        МетодЗаписиСозданогоСотрудникаВБазуПоТаблицы_ФИО(АдаптерДляСозданиеНовогоСотрудаТАблицаФИО,activity);

////////

                Log.w(this.getClass().getName(), " РезультаВставкиДАнныхНовогоСОтрудникаВТаблицу_ФИО  "+РезультаВставкиДАнныхНовогоСОтрудникаВТаблицу_ФИО);







                if (РезультаВставкиДАнныхНовогоСОтрудникаВТаблицу_ФИО>0) {
                    Long РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПриСозданииНовогоТабеля = 0l;

                    // TODO: 12.08.2021 ЛОКАЛЬНАЯ ДАТА ЛОКАЛЬНАЯ

                    String ТекущаяТаблицаОбработкиДляПовышенияВерсии="fio";


                    Log.d(this.getClass().getName()," current_table УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННЫХ ВНУТРИ ТАБЛИЦЫ  РезультатУвеличинаяВерсияДАныхЧата  " +РезультатВычисляемВреисюДанных );


                    // TODO: 12.08.2021 код повышает или уменьшает верисю данных
                    Integer РезультатПовышенияВерсииДанныхДатыиВерсии =new Class_Engine_SQL(getApplicationContext()).
                            МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_Client(РезультаВставкиДАнныхНовогоСОтрудникаВТаблицу_ФИО ,
                                    ТекущаяТаблицаОбработкиДляПовышенияВерсии,
                                    "Локальное",
                                    РезультатВычисляемВреисюДанных,
                                    new PUBLIC_CONTENT(getApplicationContext()).МенеджерПотоков);//ЛокальныйСерверныйОба

                    Log.i(this.getClass().getName(), "   ИмяТаблицыОтАндройда_Локальноая"
                            + ТекущаяТаблицаОбработкиДляПовышенияВерсии + " РезультатУспешнойВставкиИлИОбвновленияССервера " + РезультатПовышенияВерсииДанныхДатыиВерсии +
                            "  РезультатПовышенияВерсииДанныхДатыиВерсии " + РезультатПовышенияВерсииДанныхДатыиВерсии);
                }










                }else{


                    Toast.makeText(getApplicationContext(), "Ошибка данный сотрудник уже есть в таблице СНИЛС : "+ПолученныйСНИЛСНовогоСотрудника , Toast.LENGTH_LONG).show();
                }



//TODO ОКОНЧИАЕМ ВСТАВКУ ДАННЫХ


            } catch (Exception e) {
                e.printStackTrace();
                ///метод запись ошибок в таблицу
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
            }

            /////
            return  РезультаВставкиДАнныхНовогоСОтрудникаВТаблицу_ФИО;

        }












        // TODO: 22.09.2021  МЕТОД НЕПОСТРЕДВСТЕННОЙ ЗАПИСИ ДАННЫХ В ТАБЛИЦУ ФИО




    }

// TODO: 22.09.2021








































































    // TODO: 22.09.2021   KLASS GENERATOR NEW CUSTOMERS  IN TABLE data_tabels
    // TODO: 22.09.2021   KLASS GENERATOR NEW CUSTOMERS  IN TABLE data_tabels
    // TODO: 22.09.2021   KLASS GENERATOR NEW CUSTOMERS  IN TABLE data_tabels


    class   Class_Generator_New_Customer_In_Table_Data_Tables   {
        ///////


        public Class_Generator_New_Customer_In_Table_Data_Tables() {


        }

    // TODO: 22.09.2021  ТАБЛИЦА ДАТА_ТАБЕЛЬ







    // TODO: 22.09.2021  ЗАПИСЬ НОВОГО СОТДУНИКА ВТОРОЕ ДЕЙСТИЕ ЗАПИСЬВ ТАБЛИЦУ ДАТА_ТАБЕЛЯ





    //TODO метод записи нового сотрудника в базу
   protected Long МетодСозданиеНовогоСотрудника_вТаблицу_Дата_Табеля(Long НовыйСгенерированныйUUIDДляТаблицыФИОКогдаСоздаетьсяНовыйСотрудник,
                                                                     Long УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель,
                                                                     int ГодПриВставкеНовогоСотрудника,
                                                                   int  МЕсяцПриВставкеНовогоСотрудника) throws InterruptedException {



        Long РезультатВставкиВтаблицу_Дата_табеля=0l;


        Log.d(this.getClass().getName(), " МетодСозданиеНовогоСотрудника_вТаблицу_Дата_Табеля    ");

        ContentValues  АдаптерДляСозданиеНовогоСотрудаТАблицаТабель=new ContentValues();

        try {

            ///todo перед СОЗДАНИЕ/ДОБАЛВЕНИМ НОВГО СОТРУДНИКА ОПЕРДЕЛЯЕМ UUID ЧИТАЕМ ЕГО ИЗ ТАБЛИЦЫ НА КОНКТЕРНЫЙ ТЕКУЩИЙ ТАБЕЛЬ ИЛИ ТАБЕЛЬ ТОЛЬКО СДЕЛАЛИ И UUID СЧИТЫВАЕМ С ПЕРЕМЕННОЙ
            ///todo ДАННОЕ ЗНАЧЕНИЕ НУЖНО УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель ТОЛЬКО ДЛЯ ОБНОЛВЕНИЕ ЗАПИСИ ЧТОБЫ ПОНЯТЬ В UPDATE КАКУЮ СТОРЧКУ ОБНОВЕЯТЬ



            long UUIDTabelзначениеСамогоПустогоТабеляБезСотрудников = 0;
            ///




            /////TODO ТАБЕЛЬ УЖЕ СУЩЕСТВАОЛАЛ И МЫ ЧИТАЕМ UUID  ТАБЕЛЯ ИЗ БАЗЫ

            //todo  из текста в цифру UUID ---ВНИМАНИЕ ЭТО СТАРЫЙ UUID СУЩЕСТВУЮЩЕГО ТАБЕЛЯ

          //  UUIDTabelзначениеСамогоПустогоТабеляБезСотрудников = Long.parseLong(УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);

            Log.d(this.getClass().getName(), "  УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель " + УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель
                    + " new MainActivity_New_Tabely().СгенерированныйUUIDДляНовогоТабеля   "  + UUIDTabelзначениеСамогоПустогоТабеляБезСотрудников);


/////TODO ГЕНЕРИРУЕМ НОВЫЙ UUID ДЛЯ ТАБЕЛЯ ПРИ СОЗДАНИИ НОВОГО СОТРУДНИКА ТУТ НОВЫЙ UUID ТОЛЬКО СОЗДАННЫЙ




        /*    /////
          Long  UUID_НовыйСгенерированыйтолькоДЛяТАблицыДатаТАбель =  (Long)  new Class_Generation_UUID(getApplicationContext()).МетодГенерацииUUID(getApplicationContext());

            Log.d(this.getClass().getName(), " UUID_НовыйСгенерированыйтолькоДЛяТАблицыДатаТАбель    " + UUID_НовыйСгенерированыйтолькоДЛяТАблицыДатаТАбель);
*/



            // TODO: 25.03.2021 вписываем сгенерированный UUID ДАННЫЙ UUID  ПРИШЕЛ ОТ ТПБЛИЦЫ ФИО

            АдаптерДляСозданиеНовогоСотрудаТАблицаТабель.put("fio",НовыйСгенерированныйUUIDДляТаблицыФИОКогдаСоздаетьсяНовыйСотрудник);

            Log.d(this.getClass().getName(), " НовыйСгенерированныйUUIDДляТаблицыФИОКогдаСоздаетьсяНовыйСотрудник    " + НовыйСгенерированныйUUIDДляТаблицыФИОКогдаСоздаетьсяНовыйСотрудник);




            // TODO: 25.03.2021 вписываем сгенерированный UUID  ПРИШЕЛ ОТ РОДИТЕЛЬСКОЙ ТАБЛИЦЫ таьбель

            АдаптерДляСозданиеНовогоСотрудаТАблицаТабель.put("uuid_tabel",УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);

            Log.d(this.getClass().getName(), " УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель    " + УниверсальныйUUIDДляСОзданиеНовогоСотрудникаНаКонкретныйТабель);




            // TODO: 06.10.2021 СТАТУС ПРОВЕДЕНИЯ    ПО УМОЛЧПНИЮ
            АдаптерДляСозданиеНовогоСотрудаТАблицаТабель.putNull("_id");

            // TODO: 06.10.2021 СТАТУС ПРОВЕДЕНИЯ    ПО УМОЛЧПНИЮ
            АдаптерДляСозданиеНовогоСотрудаТАблицаТабель.put("status_carried_out", 0);








            // TODO: 23.09.2021  повыщаем верисю

            Long    РезультатПовышаемВреисюДанныхТаблицы_Дата_Табеля=
                    new Class_GRUD_SQL_Operations(getApplicationContext()).new ChangesVesionData(getApplicationContext()).
                            МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table("data_tabels",
                            "localversionandroid_version",getApplicationContext()
                                    ,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());
            ///

            Log.d(this.getClass().getName(), " current_table УВЕЛИЧИВАЕМ ВЕРИСЮ ДАННЫХ ВНУТРИ ТАБЛИЦЫ  РезультатУвеличинаяВерсияДАныхЧата  " +
                    " РезультатПовышаемВреисюДанныхТаблицы_Дата_Табеля " + РезультатПовышаемВреисюДанныхТаблицы_Дата_Табеля);
            ////

            // TODO: 23.09.2021  повышаем верисю таблицы фио

            АдаптерДляСозданиеНовогоСотрудаТАблицаТабель.put("current_table",РезультатПовышаемВреисюДанныхТаблицы_Дата_Табеля);












            ////TODO ДАТА

            String ДатаПРиСозданииНовогоСотрудника=null;


            String СгенерированованныйДатаДляДаннойОперации=     new Class_Generation_Data(getApplicationContext()).ГлавнаяДатаИВремяОперацийСБазойДанных();

            ДатаПРиСозданииНовогоСотрудника = СгенерированованныйДатаДляДаннойОперации;

            Log.d(this.getClass().getName(), " ДатаПРиСозданииНовогоСотрудника" + ДатаПРиСозданииНовогоСотрудника);


            АдаптерДляСозданиеНовогоСотрудаТАблицаТабель.put("date_update",ДатаПРиСозданииНовогоСотрудника);

            // TODO: 23.09.2021
            Log.d(this.getClass().getName(), " ДатаПРиСозданииНовогоСотрудника" + ДатаПРиСозданииНовогоСотрудника);








            // TODO: 23.09.2021  uuid

        НовыйСгенерированныйUUIDДляТаблицы_ДатаТабеля=0l;
            /////
          НовыйСгенерированныйUUIDДляТаблицы_ДатаТабеля =  (Long)  new Class_Generation_UUID(getApplicationContext()).МетодГенерацииUUID(getApplicationContext());

            Log.d(this.getClass().getName(), " НовыйСгенерированныйUUIDДляТаблицы_ДатаТабеля    " + НовыйСгенерированныйUUIDДляТаблицы_ДатаТабеля);




            // TODO: 23.09.2021  новый UUID  для таблицы Дата_Табель

            АдаптерДляСозданиеНовогоСотрудаТАблицаТабель.put("uuid",НовыйСгенерированныйUUIDДляТаблицы_ДатаТабеля);








                // TODO: 24.03.2021 ЕслиВубличногоНЕтТоНАходим ЕГо
            Integer   ПубличноеIDПолученныйИзСервлетаДляUUID=0;

                // TODO: 07.09.2021

                // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ


                Class_GRUD_SQL_Operations class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике;
                ///
                class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике=new Class_GRUD_SQL_Operations(getApplicationContext());

                ///
                class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","SuccessLogin");
                ///////
                class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","id");
                //
                class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","id IS NOT NULL");
                ///"_id > ?   AND _id< ?"
                //////
           /*         class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",finalПолученныйUUID);
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
                class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
                ////
                /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
                ////

                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ

                SQLiteCursor Курсор_ИщемПУбличныйIDКогдаегоНетВстатике = null;


                Курсор_ИщемПУбличныйIDКогдаегоНетВстатике= (SQLiteCursor)  class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике.
                        new GetData(getApplicationContext()).getdata(class_grud_sql_operationsИщемПУбличныйIDКогдаегоНетВстатике. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков
                        ,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());
                ////////

                Log.d(this.getClass().getName(), "GetData "  +Курсор_ИщемПУбличныйIDКогдаегоНетВстатике);



/*

                        // TODO: 07.09.2021      _old вариант

                        Курсор_ИщемПУбличныйIDКогдаегоНетВстатике =
                                new MODEL_synchronized(getApplicationContext()).КурсорУниверсальныйДляБазыДанных("SuccessLogin",
                                        new String[]{"id"}, " id IS NOT NULL", null, null, null, null, null);//
*/


                // TODO: 07.09.2021  результат
                if (Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.getCount() > 0) {
                    /////////////
                    Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.moveToFirst();
                    ////
                    Log.d(this.getClass().getName(), " Курсор_ИщемПУбличныйIDКогдаегоНетВстатике " + Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.getCount());

                    ПубличноеIDПолученныйИзСервлетаДляUUID = Курсор_ИщемПУбличныйIDКогдаегоНетВстатике.getInt(0);


                }


                Log.d(this.getClass().getName(), "   ПубличноеIDПолученныйИзСервлетаДляUUID " + ПубличноеIDПолученныйИзСервлетаДляUUID);





                if (ПубличноеIDПолученныйИзСервлетаДляUUID > 0) {
                    /////

                    АдаптерДляСозданиеНовогоСотрудаТАблицаТабель .put("user_update", ПубличноеIDПолученныйИзСервлетаДляUUID);


                }

            Log.d(this.getClass().getName(), "  PUBLIC_CONTENT.ПубличноеIDПолученныйИзСервлетаДляUUID" + ПубличноеIDПолученныйИзСервлетаДляUUID);

///////TODO САМ ВЫЗОВ МЕТОДА ОБНОВЛЕНИЕ ЛОКАЛЬНОГО-------СКОПИРОВАН КОД ИЗ УДАЕННОГО МЕТОДА



                // TODO: 25.03.2021 получеам текущую организацию
                // TODO: 24.03.2021 ЕслиВубличногоНЕтТоНАходим ЕГо
                final int[] ТекущуюОрганизацию = {0};


                final Cursor[] Курсор_ИщемТекущуюОрганизациюКоторуюВыбраСОтрудник = {null};


            // TODO: 23.09.2021  повышаем верисю таблицы фио

            АдаптерДляСозданиеНовогоСотрудаТАблицаТабель.put("status_send", " ");





            Log.d(this.getClass().getName(),"ТекущуюОрганизацию[0] " + ТекущуюОрганизацию[0] );




                //// TODO КОНЕЦ СамаВставка нового сотрудника в новый табель








            // TODO: 08.09.2021  метод после заполения данными

            РезультатВставкиВтаблицу_Дата_табеля=   new Class_Generations_New_Customers_For_Tabels(getApplicationContext()). МетодЗаписиСозданогоСотрудникаВБазуПоТаблицы_Дата_Табеля(
                    АдаптерДляСозданиеНовогоСотрудаТАблицаТабель
                    ,activity,
                    ГодПриВставкеНовогоСотрудника,
                    МЕсяцПриВставкеНовогоСотрудника, НовыйСгенерированныйUUIDДляТаблицы_ДатаТабеля);/////TODO НОВЫЙ НУЖЕН НЕ ДЛЯ ВСТАВКИ А ДЛЯ ВТОРОГО ДЕЙСТВИЯ ЗАПОЛЕНИЯ ВЫХОДНЫМИ ЕСЛИ НВ НАСТРОЙКАХ ЕСТЬ КАКАЯ ФУЕНКЦИЯ И ОНА ВКЛЮЧЕНА



            Log.e(this.getClass().getName(), " РезультатВставкиВтаблицу_Дата_табеля" + РезультатВставкиВтаблицу_Дата_табеля);


//TODO ОКОНЧИАЕМ ВСТАВКУ ДАННЫХ


            // TODO: 11.08.2021  ЛОКАЛЬНАЯ СЕРВЕРНАЯ НА АНДРОЙДЕ

            if (РезультатВставкиВтаблицу_Дата_табеля>0) {
                Long РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПриСозданииНовогоТабеля = 0l;

                // TODO: 12.08.2021 ЛОКАЛЬНАЯ ДАТА ЛОКАЛЬНАЯ

                String ТекущаяТаблицаОбработкиДляПовышенияВерсии="data_tabels";

                Log.d(this.getClass().getName(),
                        " РезультатПовышаемВреисюДанныхТаблицы_Дата_Табеля" + РезультатПовышаемВреисюДанныхТаблицы_Дата_Табеля);


                // TODO: 12.08.2021 код повышает или уменьшает верисю данных
                Integer РезультатПовышенияВерсииДанныхДатыиВерсии =new Class_Engine_SQL(getApplicationContext()).
                        МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_Client(РезультатВставкиВтаблицу_Дата_табеля ,
                        ТекущаяТаблицаОбработкиДляПовышенияВерсии,
                                "Локальное",
                                РезультатПовышаемВреисюДанныхТаблицы_Дата_Табеля,
                                new PUBLIC_CONTENT(getApplicationContext()).МенеджерПотоков);//ЛокальныйСерверныйОба

                Log.i(this.getClass().getName(), "   ИмяТаблицыОтАндройда_Локальноая"
                        + ТекущаяТаблицаОбработкиДляПовышенияВерсии + " РезультатУспешнойВставкиИлИОбвновленияССервера " + РезультатПовышенияВерсииДанныхДатыиВерсии +
                        "  РезультатПовышенияВерсииДанныхДатыиВерсии " + РезультатПовышенияВерсииДанныхДатыиВерсии);
            }


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

        //////////

        return  РезультатВставкиВтаблицу_Дата_табеля;

    }

    // TODO: 22.09.2021   метод записи дата_табельс



    }

}