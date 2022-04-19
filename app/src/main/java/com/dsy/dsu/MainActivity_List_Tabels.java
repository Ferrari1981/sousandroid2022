package com.dsy.dsu;

import static java.util.Locale.setDefault;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.dsy.dsu.Business_logic_Only_Class.Class_GRUD_SQL_Operations;
import com.dsy.dsu.Business_logic_Only_Class.Class_Generation_Errors;
import com.dsy.dsu.Business_logic_Only_Class.Class_MODEL_synchronized;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Locale;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity_List_Tabels extends AppCompatActivity  {




    protected Spinner СпинерВыборДату;/////спинеры для создание табеляСпинерТабельДепратамент

    String ПолученноеЗначениеИзСпинераДата; ///результат полученный из спенров

    String КакойКонтекст;





    protected ScrollView ScrollНаАктивтиСозданныхТабелей;

    protected LinearLayout LinearLayoutСозданныхТабелей;
    protected LinearLayout LinearLayoutДляЛинии;


    protected  ProgressDialog progressDialogДляУдаления;
    boolean РежимыПросмотраДанныхЭкрана;

    protected EditText ПрослойкаМеждуТабелей;

    //protected  TextView ТекстСообщениеЧТоТабеляЕщеНеСозданны;
     Configuration config;

    String ПослеСозданиеовгоТабеляГОд= "";

    String ПослеСозданиеовгоТабеляМЕсяц= "";

    String ПослеСозданиеовгоТабеляВместеГодИМесяц= "";

    String ПолученноеЗначениеИзТолькоСпинераДата= "";
    /////static
     String  ПослеСозданияНовогоТабеляЕгоUUID;

     String   ПослеСозданияНовогоТабеляЕгоПолноеНазвание= "";

    String ПубличноеИмяКнопкиТабеля;
    ///
  String ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре;
    ////
    View.OnLongClickListener СлушательУдаланиеСамогоТабеля;
    /////TODO СОЗДАННЫЕ КНОПКИ НАЗВАНИЯ ТАБЕЛЕЙ
    Button ТабелявВидеКнопок=null;

    //TODO полученые месяц и год для создаени нового табеля
    String ПолученныйГодДляНовогоТабеля= "";

    String ФинальнаяМЕсяцДляНовогоТабеля= "";

   /// String   ПравильныйВозвратИзДруговоАктивтиBACK;

 //   String ЦифровоеИмяНовгоТабеля;

    //////
    //String[]    МассивДляВыбораВСпинерДата = {ГлавнаяДатаИВремяОперацийСБазойДанных(), "Выберите Дату Табеля" ,""};/////ДАННЫЙ МАССИВ БУДЕТ ЗАПОЛНЯТЬ СПИНЕР РАЗДЕЛ
    LinkedList<String> МассивДляВыбораВСпинерДата = new LinkedList<>(); //////АКАРЛИСТ ДЛЯ ПОЛУЧЕНЫЙ НОВЫХ ДАТ
    ////
    int МЕсяцВвидеЦифрыДляКурсора;


    int ГОДВвидеЦифрыДляКурсора;

    int ЦифровоеИмяНовгоТабеля;

 Context КонтекстИсторииВсехТабелейВыбранных;

    Context  КонтекстИсторииВсехТабелейВыбранныхВнешний;

    String  МесяцТабеляФиналИзВсехСотрудниковВТАбеле;

    String ГодТабеляФиналИзВсехСотрудниковВТАбел;

    /////////////////////////////////////////////////////////////
    Button    КнопкаНазадВсеТабеля;


    ///////TODO
    CREATE_DATABASE   Create_Database_СсылкаНАБазовыйКласс;


    LinkedBlockingQueue<Long> СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником;


    Long ПолученнаяUUIDНазванияОрганизации;

TextView textViewКоличествоТабелей;

    FloatingActionButton КруглаяКнопкаСозданиеНовогоТабеля;

    int ПолучеаемЦифруСФО;

    Activity activity=this;



    Integer   ПубличноеIDПолученныйИзСервлетаДляUUID=0;

    // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ


   private Class_GRUD_SQL_Operations class_grud_sql_operationsДляАктивтиТабель ;



    PUBLIC_CONTENT  Class_Engine_SQLГдеНаходитьсяМенеджерПотоков ;





//todo 28.01.2022--12.54

    Long   РодительскийUUDТаблицыТабель=0l;







    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try{

        super.onCreate(savedInstanceState);




            /////todo ориентация строго портрет

            setContentView(R.layout.activity_main__historytabely);

            getSupportActionBar().hide(); ///скрывать тул бар




            class_grud_sql_operationsДляАктивтиТабель      = new Class_GRUD_SQL_Operations(getApplicationContext());




        КонтекстИсторииВсехТабелейВыбранных=this;

        КонтекстИсторииВсехТабелейВыбранныхВнешний=this;

            activity=this;



///////TODO
              Create_Database_СсылкаНАБазовыйКласс=new CREATE_DATABASE(getApplicationContext());

            ////
            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new PUBLIC_CONTENT (getApplicationContext());



        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ////todo запрещяет поворот экрана






        /////todo данная настрока запрещает при запуке активти подскаваать клавиатуре вверх на компонеты eedittext
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION  );


        /////
        ScrollНаАктивтиСозданныхТабелей = (ScrollView) findViewById(R.id.ScrollViewСамТабеля); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА

        LinearLayoutСозданныхТабелей = (LinearLayout) findViewById(R.id.ГлавныйКонтейнерТабель); /////КНОПКА ТАБЕЛЬНОГО УЧЕТА


        //todo кнопка назад
        КнопкаНазадВсеТабеля= findViewById(R.id.КонопкаНазадСтрелкаВсеТабеля);



        textViewКоличествоТабелей= findViewById(R.id.textViewКоличествоТабелей);








        //////todo  конец настрока экрана
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);


        // Locale locale = Locale.ROOT;
        Locale locale = new Locale("rus");
        setDefault(locale );
        config =
                getBaseContext().getResources().getConfiguration();
        config.setLocale(locale);
        createConfigurationContext(config);

/////////////// //TODO пришли два значения месяц и год после успешного создание ТАБЕЛЯ










        ///////// todo Круглая Кнопка
         КруглаяКнопкаСозданиеНовогоТабеля = findViewById(R.id.КруглаяКнопкаСамТабель);//////КНОПКА СОЗДАНИЕ НОВГО ТАБЕЛЯ ИЗ ИСТОРИИ ВТОРОЙ ШАГ СОЗДАНИЯ ТАБЕЛЯ СНАЧАЛА ИСТРОИЯ ПОТОМ НА БАЗЕ ЕГО СОЗЗДАНИЕ
        /////КЛИК ПО КНОПКЕ

        ///
        КруглаяКнопкаСозданиеНовогоТабеля.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO СОЗДАНИЕ НОВОГО ТАБЕЛЯ

/*
            if (PUBLIC_CONTENT.Отладка==true) {
                    СообщениеСпрашиваемПользователяЧтоОнТОчноХочетьСоздатьНовыйТабель("Табеля", "Создать новый Табель ?."+"\n", true);
          */






                    Log.d(this.getClass().getName()," создание нового сотрудника " );


                    ///TODO создание нового ТАБЕЛЯ
                    МетодСозданиеДиалогаКалендаряДаты();////ЗПАСУКАЕМ МЕТОД КОГДА НАДО ВЫБРВТЬ ДАТУ С КАЛЕНДАРКА




            }

        });


        /////

        //todo метод возврата к предыдущему активти
        ////
            МетодНазадBACKНААктивти();


        } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }



    }

    private void МетодНазадBACKНААктивти() {
        КнопкаНазадВсеТабеля.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    Log.d(this.getClass().getName(), " кликнем для созданни новго сотрдника при нажатии  ");
                    ///todo код которыц возврящет предыдущий актвитики кнопка back






                    Intent Интент_BackВозвращаемАктивти = new Intent();


                    Интент_BackВозвращаемАктивти.setClass(getApplication(), MainActivity_Face_App.class); // Т
                    ////todo запускаем активти
                    Интент_BackВозвращаемАктивти.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ////

                    startActivity( Интент_BackВозвращаемАктивти);
                    ////
                   /// finish();



                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    // TODO: 01.09.2021 метод вызова
                    new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                            this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                }
            }


        });
    }


    void МетодПолучениеДанныхДляДаногоАктивтиИсторияТАбеля() {
        ////////

        try{
        Intent Интент_ПослеУспешноСозданогоНовогоТабеляПередаемСюдаЦифруМесяцаИЦифруГода = getIntent();
        ////////
        ПослеСозданиеовгоТабеляГОд= Интент_ПослеУспешноСозданогоНовогоТабеляПередаемСюдаЦифруМесяцаИЦифруГода.getStringExtra("ГодВырезалиИзБуфераТабель");
        ///
        ПослеСозданиеовгоТабеляМЕсяц= Интент_ПослеУспешноСозданогоНовогоТабеляПередаемСюдаЦифруМесяцаИЦифруГода.getStringExtra("МесяцВырезалиИзБуфераТабель");
        ////
        ПослеСозданиеовгоТабеляВместеГодИМесяц= Интент_ПослеУспешноСозданогоНовогоТабеляПередаемСюдаЦифруМесяцаИЦифруГода.getStringExtra("ПолученноеТекущееЗначениеСпинераДата");
        ////
        ПослеСозданияНовогоТабеляЕгоUUID= Интент_ПослеУспешноСозданогоНовогоТабеляПередаемСюдаЦифруМесяцаИЦифруГода.getStringExtra("СгенерированныйUUIDДляНовогоТабеля");
        /////
        ПослеСозданияНовогоТабеляЕгоПолноеНазвание= Интент_ПослеУспешноСозданогоНовогоТабеляПередаемСюдаЦифруМесяцаИЦифруГода.getStringExtra("СгенерированныйНазваниеНовогоТабеля");
/////////
            ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре= Интент_ПослеУспешноСозданогоНовогоТабеляПередаемСюдаЦифруМесяцаИЦифруГода.getStringExtra("ДепартаментТабеляПослеПодбораBACK");

/////////
            ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре= Интент_ПослеУспешноСозданогоНовогоТабеляПередаемСюдаЦифруМесяцаИЦифруГода.getStringExtra("ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре");


    РодительскийUUDТаблицыТабель= Интент_ПослеУспешноСозданогоНовогоТабеляПередаемСюдаЦифруМесяцаИЦифруГода.getLongExtra("РодительскийUUDТаблицыТабель",0l);
    // ЦифровоеИмяНовгоТабеля= Интент_ПослеУспешноСозданогоНовогоТабеляПередаемСюдаЦифруМесяцаИЦифруГода.getStringExtra("ЦифровоеИмяНовгоТабеля");
        /////
        Log.d(this.getClass().getName(), " ПослеСозданиеовгоТабеляГОд "+ПослеСозданиеовгоТабеляГОд+ " ПослеСозданиеовгоТабеляГОд " +ПослеСозданиеовгоТабеляГОд +
                " ПослеСозданиеовгоТабеляВместеГодИМесяц " +ПослеСозданиеовгоТабеляВместеГодИМесяц +
                "    ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре " +  ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре+
                " ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре "+ ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре +
                "  РодительскийUUDТаблицыТабель " +РодительскийUUDТаблицыТабель);



    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
        // TODO: 01.09.2021 метод вызова
       this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
    }






    @Override
    protected void onStart() {
        super.onStart();



        ///TODO попытка открыть экран как full screan
        ////////ЗАПОЛНЯЕМ АРАЙЛИСТ
        try {


            //TODO МЕТОД ПОЛУЧЕНИЕ ДАННЫХ ДЛЯ ДАННОГО АКВТИВИ
            МетодПолучениеДанныхДляДаногоАктивтиИсторияТАбеля();



            //TODO метод праивльно возврящет дату в спиноре  на первоночальнуюс последней
            ///МетодВозвратаПравильногоДатыВСпиноре();
            //////

            ////todo заполение спинера
            МетодЗаполненияАлайЛИстаНовымМЕсцевНовогоТабеля();////метод вызаваем все созжданные ТАБЕДЯ ИЗ БАПЗЫ И ДАЛЕЕ ИХ ЗАПИСЫВАЕМ В ОБМЕН
            ////todo заполение спинера
            //////

            МетодСозданиеСпинераДляДатыНаАктивитиСозданиеИВыборТабеля();

            //


            ///todo метод для удаления табеля
            new Class_Delete_Current_Tabel().   МетодДляУдалениеТабеляЕслиВнемНетСотрудников();



        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), 
       this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }












    ///todo сообщение
    @UiThread
    void СообщениеПредпреждаетОВыбореУдалениеСамогоТабеля(String ШабкаДиалога,  String СообщениеДиалога,
                                                          String СамИндификаторUUID, String СамUUIDТабеля,int НазваниеУдаляемогоТАбеля,int НазваниеУдаляемогоТАбеляВЦифровомФормате) {

        Log.d(this.getClass().getName(), "  ФИНАЛ создание нового сотрудника ");
        ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ
//////сам вид
        final AlertDialog alertDialog = new MaterialAlertDialogBuilder(this)
                .setTitle(ШабкаДиалога)
                .setMessage(СообщениеДиалога)
                .setPositiveButton("ОК", null)
                .setIcon(R.drawable.icon_dsu1_tabel_info)
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

                /////todo сообщением передохим вв удаления табеля
                try {

                    ///
                    МетодУдалениеТАбеляСообщениеПередЭтим(СамUUIDТабеля, СамИндификаторUUID, НазваниеУдаляемогоТАбеля, НазваниеУдаляемогоТАбеляВЦифровомФормате,null,v);



                } catch (Exception e) {
                    //  Block of code to handle errors
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                            + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    // TODO: 01.09.2021 метод вызова
                    new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                            this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                            Thread.currentThread().getStackTrace()[2].getLineNumber());
                }


            }
        });
    }





































            ///TODO СООБЩЕНИЕ О РЕЗУЛЬТАТОВ







































    ///todo  конец метода удаления третий обработчки нажатия
    ///////МЕТОД СОЗДАННИЕ СПИНЕРА

    ///todo сообщение
    @UiThread
    protected void СообщениеПослеУдаленияСотрудникаИзТабеля(String ШабкаДиалога, String СообщениеДиалога, boolean Статус , Long СамоЗначениеUUID,String ДляУдалениеUUID,int НазваниеУдаляемогоТАбеляВЦифровомФормате) {
        ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ
//////сам вид
        int Значек;
        if (Статус){
            Значек  =R.drawable.icon_dsu1_tabel_info;
        }else{
            Значек  =R.drawable.icon_dsu1_delete_customer;///
        }
        final AlertDialog alertDialog = new MaterialAlertDialogBuilder(this)
                .setTitle(ШабкаДиалога)
                .setMessage(СообщениеДиалога)
                .setPositiveButton("Удалить", null)
                .setNegativeButton("Нет", null)
                .setIcon(Значек)
                .show();
/////////кнопка
        final Button MessageBoxUpdateСоздатьТабель = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        MessageBoxUpdateСоздатьТабель.setOnClickListener(new View.OnClickListener() {
            ///MessageBoxUpdate метод CLICK для DIALOBOX

            @Override
            public void onClick(View v) {
                //удаляем с экрана Диалог
                alertDialog.dismiss();
                Log.d(this.getClass().getName(), "  ФИНАЛ после удалание сотрудуника ");

                //TODO  второе действие заполенние контентом  в табеля в TableLyзаполения табеля из базы через элемент TableLauy
                //todo код послеу успешного удаления табеля
                //todo
            }
        });
        /////////////


        final Button MessageBoxUpdateСоздатьТабельВсеравноУдлаитьВместеССотрудникамиТабель = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        MessageBoxUpdateСоздатьТабельВсеравноУдлаитьВместеССотрудникамиТабель.setOnClickListener(new View.OnClickListener() {
            ///MessageBoxUpdate метод CLICK для DIALOBOX

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                //удаляем с экрана Диалог
                alertDialog.dismiss();
                Log.d(this.getClass().getName(), "  ФИНАЛ после удалание сотрудуника ");

////

                ///
                try {
                    МетодУдалениеВсехСотрудниковВТАбеле(СамоЗначениеUUID,ДляУдалениеUUID, НазваниеУдаляемогоТАбеляВЦифровомФормате);

                    ///todo команда которая удаляет выбранный табель
///todo команда которая удаляет выбранный табель




                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                           new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                }

                try {

                    ///todo метод для удаления табеля
                   /* МетодДляУдалениеТабеляЕслиВнемНетСотрудников();
                    //////
                    //////

                    ////todo заполение спинера
                    МетодЗаполненияАлайЛИстаНовымМЕсцевНовогоТабеля();////метод вызаваем все созжданные ТАБЕДЯ ИЗ БАПЗЫ И ДАЛЕЕ ИХ ЗАПИСЫВАЕМ В ОБМЕН
                    ////todo заполение спинера
                    //////


                    МетодСозданиеСпинераДляДатыНаАктивитиСозданиеИВыборТабеля();*/

                    //
                    onStart();
                    //////

                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), 
       this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                }

                //TODO  второе действие заполенние контентом  в табеля в TableLyзаполения табеля из базы через элемент TableLauy
                //todo код послеу успешного удаления табеля
                //todo
            }
        });
        /////////////





    }






    private void МетодУдалениеВсехСотрудниковВТАбеле(Long СамоЗначениеUUID,
                                                     String ДляУдалениеUUID,
                                                     int НазваниеУдаляемогоТАбеляВЦифровомФормате) throws ExecutionException, InterruptedException, TimeoutException {

        final long[] РезультатУдалениеВсехСотрудниковСамогоТАбеля = {0};

        /////TODO Дополнительно делаем ФИО поле НУЛЛ
/*
        ССылкаНаСозданнуюБазу.
         ();
        ССылкаНаСозданнуюБазу.execSQL("UPDATE tabels SET  fio= NULL WHERE fio=-1");
        ССылкаНаСозданнуюБазу.execSQL("UPDATE fio SET  uuid= NULL WHERE uuid=-1");
        ССылкаНаСозданнуюБазу.
         ();

    ;
*/

        try{

            final Object[] СамоЗначениеUUIDДляУдаланиевсехСотрудников = {null};

                    // TODO: 18.03.2021  если есть содружники
                    if(СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.size()>0){


                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            /////
                            СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.stream().forEachOrdered((ТекущйиUUIDДляУдаления)->{




                                СамоЗначениеUUIDДляУдаланиевсехСотрудников[0] =  ТекущйиUUIDДляУдаления;

                                String  СамоЗначениеUUIDДляУдаланиевсехСотрудниковФинал= СамоЗначениеUUIDДляУдаланиевсехСотрудников[0].toString();

                                System.out.println(СамоЗначениеUUIDДляУдаланиевсехСотрудников[0].toString());



                                ///////
                                int ГодДляУдаления = 0;
                                ////
                                int МесяцДляУдаления=0;
                                ///
                                Cursor       Курсор_ДляУдаленияПолучаемМесяцИгод=null;




                                // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ


                                class_grud_sql_operationsДляАктивтиТабель= new Class_GRUD_SQL_Operations(getApplicationContext());
                                ///
                                class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","tabel");
                                ///////
                                class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","month_tabels,year_tabels");
                                //
                                ////
                                class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","  uuid = ? ");
                                ///"_id > ?   AND _id< ?"
                                //////
                                class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",СамоЗначениеUUID);

                                ////
                                // TODO: 12.10.2021  Ссылка Менеджер Потоков

                                PUBLIC_CONTENT  Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = null;

                                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = new PUBLIC_CONTENT (getApplicationContext());



                                // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ


                                try {
                                    Курсор_ДляУдаленияПолучаемМесяцИгод= (SQLiteCursor)  class_grud_sql_operationsДляАктивтиТабель.
                                            new GetData(getApplicationContext()).getdata(class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                                            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());
                                } catch (ExecutionException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                Log.d(this.getClass().getName(), "GetData "+Курсор_ДляУдаленияПолучаемМесяцИгод  );

                                ////


                                // TODO: 02.09.2021

                                if(Курсор_ДляУдаленияПолучаемМесяцИгод.getCount()>0){

                                    Курсор_ДляУдаленияПолучаемМесяцИгод.moveToFirst();
                                    //////
                                    int ИндексМесяцДляУдаления=Курсор_ДляУдаленияПолучаемМесяцИгод.getColumnIndex("month_tabels")  ;
                                    ///////
                                    МесяцДляУдаления=Курсор_ДляУдаленияПолучаемМесяцИгод.getInt(ИндексМесяцДляУдаления);
                                    //////
                                    int  ИндексГодДляУдаления=Курсор_ДляУдаленияПолучаемМесяцИгод.getColumnIndex("year_tabels")  ;
                                    ///////
                                    ГодДляУдаления=Курсор_ДляУдаленияПолучаемМесяцИгод.getInt(ИндексГодДляУдаления);



                                }



                                System.out.println("СамоЗначениеUUIDДляУдаланиевсехСотрудников " + СамоЗначениеUUIDДляУдаланиевсехСотрудников[0]);
                                /////TODO конец while







                            });
                        }





                    }





                //  ССылкаНаСозданнуюБазу.close();

        /*    if (PUBLIC_CONTENT.Отладка==true) {
                    СообщениеПослеУдаленияСамогоТАбеля("Оповещение Табеля", "Успешное удалание Табеля"
                            +"\n"+" (с сотрудниками): "
                            +СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.size(), true,НазваниеУдаляемогоТАбеляВЦифровомФормате);
                } else {*/


                МетодСозданиеСпинераДляДатыНаАктивитиСозданиеИВыборТабеля();

                onStart();

                //
                ScrollНаАктивтиСозданныхТабелей.invalidate();
                /////
                ScrollНаАктивтиСозданныхТабелей.requestLayout();

                //////





        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                   new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
////todo конец фильаного сообщения о удалени самого табеля

































    ///todo сообщение
    @UiThread
    protected void СообщениеПослеУдаленияСамогоТАбеля(String ШабкаДиалога,  String СообщениеДиалога,boolean Статус, int НазваниеУдаляемогоТАбеляВЦифровомФормате) {
        ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ


//////сам вид
        int Значек;
        if (Статус){
            Значек  =R.drawable.icon_dsu1_tabel_info;
        }else{
            Значек  =R.drawable.icon_dsu1_delete_customer;
        }
        final AlertDialog alertDialog = new MaterialAlertDialogBuilder(this)
                .setTitle(ШабкаДиалога)
                .setMessage(СообщениеДиалога)
                .setPositiveButton("ОК", null)
                .setIcon(Значек)
                .show();
/////////кнопка
        final Button MessageBoxUpdateСоздатьТабель = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        MessageBoxUpdateСоздатьТабель.setOnClickListener(new View.OnClickListener() {
            ///MessageBoxUpdate метод CLICK для DIALOBOX

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                //удаляем с экрана Диалог
                alertDialog.dismiss();
                Log.d(this.getClass().getName(), "  ФИНАЛ после удалание сотрудуника ");
                //////// todo если успешно удаление табеля то запускаем сообщение
                if (Статус) {

                    ///TODO попытка открыть экран как full screan
                    ////////ЗАПОЛНЯЕМ АРАЙЛИСТ
                    ////////ЗАПОЛНЯЕМ АРАЙЛИСТ
                    try {

                        ///todo метод для удаления табеля
                /*        МетодДляУдалениеТабеляЕслиВнемНетСотрудников();
                        //////
                        //////

                        ////todo заполение спинера
                        МетодЗаполненияАлайЛИстаНовымМЕсцевНовогоТабеля();////метод вызаваем все созжданные ТАБЕДЯ ИЗ БАПЗЫ И ДАЛЕЕ ИХ ЗАПИСЫВАЕМ В ОБМЕН
                        ////todo заполение спинера
                        //////


                        МетодСозданиеСпинераДляДатыНаАктивитиСозданиеИВыборТабеля();*/


                        onStart();

                        //
                        ScrollНаАктивтиСозданныхТабелей.invalidate();

                        //////

                    } catch (Exception e) {
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), 
       this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }

                //TODO  второе действие заполенние контентом  в табеля в TableLyзаполения табеля из базы через элемент TableLauy
                //todo код послеу успешного удаления табеля
                //todo
            }
        });
    }
////todo конец фильаного сообщения о удалени самого табеля

























    private void МетодСозданиеСпинераДляДатыНаАктивитиСозданиеИВыборТабеля() {
        try {

            ////TODO сортируем дату на ПОСЛЕДНКЮ

         SQLiteCursor  Курсор_ВЫводимМаксимальнуюДатуДляСпинера = null;
            /////
            //int ПОложениевЛинкЛисте=0;todo САМИ ДАННЫЕ СОЗДАННЫЕ ТАБЕЛЯ


                Курсор_ВЫводимМаксимальнуюДатуДляСпинера =        МетодКоторыйПоказываетМаксимальнуюДатуИзмененияДляСпинера();
                ////
                ///////////;
                Log.d(this.getClass().getName(), "Курсор_ВЫводимМаксимальнуюДатуДляСпинера " + Курсор_ВЫводимМаксимальнуюДатуДляСпинера);

                if ( Курсор_ВЫводимМаксимальнуюДатуДляСпинера!=null){
                    /////
                    Курсор_ВЫводимМаксимальнуюДатуДляСпинера.moveToFirst();


                    //CountDownLatch countDownLatch=new CountDownLatch(1);

                    ////TODO МЕТОД ПРЕОБРАЗОВАНИЕ ЦИФРА В НАЗВАНИЕ МЕСЯЦА ДЛЯ ЕГО СРАВНЕНИЯ
                   // String ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре=      МетодДляПреоразванияЦифрыВНазванияМесяца(Курсор_ВЫводимМаксимальнуюДатуДляСпинера[0]);


                    Log.d(this.getClass().getName(), " " + ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре+
                            "  Курсор_ВЫводимМаксимальнуюДатуДляСпинера.getCount() " +Курсор_ВЫводимМаксимальнуюДатуДляСпинера.getCount());
                    ///


                    // TODO: 17.09.2021  делаем сортировку

                    ListIterator<String> iterator = МассивДляВыбораВСпинерДата.listIterator();

                    // Iterating the list in forward direction
                    System.out.println("LinkedList elements:");
                    //
                    while(iterator.hasNext()) {


                        String ИщемМесяцАЛинкЛисте = iterator.next();

                        int ПОложениевЛинкЛисте = iterator.nextIndex() - 1;


                        Log.d(this.getClass().getName(), " ИщемМесяцАЛинкЛисте  " + ИщемМесяцАЛинкЛисте
                                + " ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре " + ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре);

                        if (ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре == null) {
                            /////
                            ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре = МассивДляВыбораВСпинерДата.get(ПОложениевЛинкЛисте);
                        }



                                /////////
                                if (ИщемМесяцАЛинкЛисте.equalsIgnoreCase(ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре)) {

                                    Log.d(this.getClass().getName(), "  ПОложениевЛинкЛисте "
                                            + ПОложениевЛинкЛисте + "  ИщемМесяцАЛинкЛисте " +ИщемМесяцАЛинкЛисте + " ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре " +
                                            ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре);


                                    Collections.swap(МассивДляВыбораВСпинерДата, 0, ПОложениевЛинкЛисте);
                                    /////
                                    /*    ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре=null;*/

                                    ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре = МассивДляВыбораВСпинерДата.get(ПОложениевЛинкЛисте);

                                    break;

                                }
                        Log.d(this.getClass().getName(), "  ПОложениевЛинкЛисте "
                                + ПОложениевЛинкЛисте + "  ИщемМесяцАЛинкЛисте " +ИщемМесяцАЛинкЛисте + " ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре " +
                                ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре);






                        // TODO: 20.09.2021  когда нет данных

                    }}



            Log.d(  getApplicationContext().getClass().getName(), " сработала ... ВСТАВКА МассивДляВыбораВСпинерДата В БАЗУ"+МассивДляВыбораВСпинерДата);


            if (МассивДляВыбораВСпинерДата.size()>0) {/// && МассивДляВыбораВСпинерДата.size()>0
//////ТРЕТИЙ СПИНЕР ДАТА
                СпинерВыборДату=(Spinner) findViewById(R.id.СпинерТабельМесяцИсториииТабелей);


// Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
                ArrayAdapter<String> АдаптерДляСпинераДата = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, МассивДляВыбораВСпинерДата);
                // Определяем разметку для использования при выборе элемента
                АдаптерДляСпинераДата.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                // Применяем адаптер к элементу spinner
                СпинерВыборДату.setAdapter(АдаптерДляСпинераДата);
                ////что быврали


////////РЕЖИМ ПОЛНОГО  ЭКРАНА слушатели экрана табеля

                /////Метод не выбара а Клика

                СпинерВыборДату.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        //////TODO линия снизу самих табелей ЦВЕТ
                        ((TextView) parent.getChildAt(0)).setBackgroundResource(R.drawable.textlines_tabel_row_color_green);


                        ((TextView) parent.getChildAt(0)).setTextSize(16);

                        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);

                        ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

                        ((TextView) parent.getChildAt(0)).setTypeface(((TextView) parent.getChildAt(0)).getTypeface(), Typeface.BOLD);//////ВЫДЕЛЕМ ЖИРНЫМ ЦВЕТОМ ДАТЫ
                        //
                        // TODO: 16.05.2021

                       //// ((TextView) parent.getChildAt(0)).setText(((TextView) parent.getChildAt(0)).getText()+String.valueOf("  ("+СпинерВыборДату.getCount()+")"));

                        КакойКонтекст= String.valueOf(((TextView) parent.getChildAt(0)).getText()); /////ОПРЕДЕЛЯЕМ ТЕКУЩЕЕ ЗНАЧЕНИЕ ВНУТИРИ СПЕНИРА
                        //////меняем цвет спинера
                        // СпинерВыборДату.setTooltipText("Дата месяца");
                        ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре=КакойКонтекст;
                        //////конец второго лушателя спинера

                        Log.d(  this.getClass().getName(), " КакойКонтекст" +КакойКонтекст+ " ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре " +ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре);

                        ////todo данные два значения приходят только просле содание воговто табеля из другово актвити ПРИНИМАЕМ РЕШЕНИЕ ВСТВЛЕМ НОВУЮ ДАТУ ИЛИ НЕТ
                        /////////ПРИНИМАЕМ РЕШЕНИЕ СОЗДАННЫЙ ИЛИ НЕТ ПРИШЛА ДАТА ОТ ДРУГОВО АКТИВТИ ИЛИ НЕТ
                        if (ПослеСозданиеовгоТабеляГОд!=null && ПослеСозданиеовгоТабеляМЕсяц!=null){////заполянеться если новыйтабель создан и на при запуске встать на попределнный табель
                            /////ПОКАЗЫАМ ДАТУ ПРИ ЗАПУСКЕ АКТИВТИ ИСТОРИЯ ТАБЕЛЯ  ДАННАЯ ДАТА ПОЛУЧЕНА ПРИШЛА ОТ ДРУГОВО АКТИВТИ ПОСЛЕ УСПЕШНОЙ ВСТВКИ НОВГО ТАБЕЛЯ
                            ((TextView) parent.getChildAt(0)).setText(ПослеСозданиеовгоТабеляВместеГодИМесяц);//// ЗАПИСЫВАЕМ ЗНАЧЕНИЕ В СПИПЕР
                            ////
                            ПослеСозданиеовгоТабеляГОд=null;


                            ПослеСозданиеовгоТабеляМЕсяц=null;




                        }



                      ПолученноеЗначениеИзСпинераДата = (String) ((TextView) parent.getChildAt(0)).getText(); //ПОЛУЧАЕМ ЗНАЧЕНИЕ

                        Log.d(this.getClass().getName(), " ((TextView) parent.getChildAt(0)).getText()  " + ((TextView) parent.getChildAt(0)).getText());



                        /////////// todo КОНЕЦ СОЗДАНИЕ КОМПОНЕТА КАЛЕНДАРЬ

                       if (    ПолученноеЗначениеИзСпинераДата!=null) {
                            ///////future
                            try{


                                   МетодаСозданиеТабеляИзБазы(); /////МЕТОД ЗАГРУЗКИ СОЗДАННЫХ ТАБЕЛЕЙ ИЗ БАЗЫ



                               } catch (Exception e) {
                                   e.printStackTrace();
                                   ///метод запись ошибок в таблицу
                                   Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                           " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                   // TODO: 01.09.2021 метод вызова
               new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
              this.getClass().getName(),
                                           Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                               }
                           //
                            ScrollНаАктивтиСозданныхТабелей.invalidate();
                            /////
                            ScrollНаАктивтиСозданныхТабелей.requestLayout();

                            LinearLayoutСозданныхТабелей.requestLayout();


                        }


                        /////
    ///////// ТУТ МЫ НИЧИНАЕМ СОЗДАВАТЬ НОВЫЙ МЕСЯЦ АВГУСТ , СЕНТЯБРЬ ОКТЯБРЬ

                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Log.d(this.getClass().getName(), " ПолученноеЗначениеИзСпинераДата  " +ПолученноеЗначениеИзСпинераДата);
                    }

                });


                Log.d(this.getClass().getName(), " ПолученноеЗначениеИзСпинераДата  " +ПолученноеЗначениеИзСпинераДата);

                // TODO: 21.09.2021  Когда данныых нет
                
                
            }else{

                // TODO: 21.09.2021  Когда данныых нет

                Log.d(this.getClass().getName(), " МассивДляВыбораВСпинерДата.size()  " + МассивДляВыбораВСпинерДата.size());

                // TODO: 21.09.2021  НЕТ ДАННЫХ  НЕТ ТАБЕЛЬ
                МетодКогдаДанныхСамихТабелйНет();
                
            }


//поймать ошибку всего классаIOException | MyException e    NumberFormatException
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), 
       this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

        /////МЕТОД ЗАГРУКЗИ КОЛИЧЕСТВО ТАБЕЛЕЙ ИЗ БАЗЫ\




    }
































    ////TODO Метод Преоразует цифру в  названия месяца
    private String МетодДляПреоразванияЦифрыВНазванияМесяца(Cursor Курсор_ВЫводимМаксимальнуюДатуДляСпинера) {

        String  МаксимальнаяМесяцДляСпинера;

        String МаксимальнаяГодДляСпинера;

        String  МаксимальнаяНазваниеДляСпинера;

        String ПолученыеМесяцНеОбработанный = null;
        try{


            МаксимальнаяМесяцДляСпинера =Курсор_ВЫводимМаксимальнуюДатуДляСпинера.getString(0);
            //
            Log.i(this.getClass().getName(), "МаксимальнаяМесяцДляСпинера[0] " +   МаксимальнаяМесяцДляСпинера);

            МаксимальнаяГодДляСпинера =Курсор_ВЫводимМаксимальнуюДатуДляСпинера.getString(1);
            //
            Log.i(this.getClass().getName(), "МаксимальнаяГодДляСпинера[0] " + МаксимальнаяГодДляСпинера);

            МаксимальнаяНазваниеДляСпинера=Курсор_ВЫводимМаксимальнуюДатуДляСпинера.getString(2);
            //
            Log.i(this.getClass().getName(), " МаксимальнаяНазваниеДляСпинера[0] " + МаксимальнаяНазваниеДляСпинера);



            ///TODO из цифры в НАзвание




                /*            Locale ee=Locale.forLanguageTag("ru");
                            Calendar cal=Calendar.getInstance();
                            cal.set(Calendar.MONTH,Integer.parseInt(МаксимальнаяМесяцДляСпинера));
                            String s=cal.getDisplayName(Calendar.MONTH,Calendar.LONG_FORMAT,new Locale("rus"));
*/





            DateFormat df = new SimpleDateFormat("MM/yyyy");

            Date date = df.parse(МаксимальнаяМесяцДляСпинера+"/"+МаксимальнаяГодДляСпинера);

            System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010




                /*    SimpleDateFormat f = new SimpleDateFormat("MMM", new Locale("ru"));
                    SimpleDateFormat f1 = new SimpleDateFormat("LLL", new Locale("ru"));
                    SimpleDateFormat f2 = new SimpleDateFormat("MMMM", new Locale("ru"));*/
            SimpleDateFormat ПреобразованиеЦифраВНАзваниемесяца = new SimpleDateFormat("LLLL  yyyy", new Locale("ru"));

            ПолученыеМесяцНеОбработанный=  ПреобразованиеЦифраВНАзваниемесяца.format(date);
            System.out.println(ПолученыеМесяцНеОбработанный);

            ПолученыеМесяцНеОбработанный=(ПолученыеМесяцНеОбработанный.substring(0,1).toUpperCase()+
                    ПолученыеМесяцНеОбработанный.substring(1).toLowerCase());

            Log.i(this.getClass().getName(), " ПолученыеМесяцНеОбработанный " + ПолученыеМесяцНеОбработанный);










            //поймать ошибку всего классаIOException | MyException e    NumberFormatException
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), 
       this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return ПолученыеМесяцНеОбработанный;
    }






























////////НАЧАЛО МЕТОД СОЗДАНИЕ ТАБЕЛЯ


    private void МетодаСозданиеТабеляИзБазы() throws InterruptedException, ExecutionException, TimeoutException, ParseException {



        SQLiteCursor            Курсор_ПолучаемПубличныйID= null;

        SQLiteCursor Курсор_КоторыйЗагружаетГотовыеТабеля = null;

        SQLiteCursor         Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата= null;


        //

      String МесяцМаскимальнаяДатавТабеляхПоМесецям = null;
        ////todo ДАННЫЙ КУРСОР ДЛЯ ПОКАЗА НОВГО ТАБЕЛЯ
        try{
            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ



            Log.d(this.getClass().getName(), " ПолученноеЗначениеИзСпинераДата" + ПолученноеЗначениеИзСпинераДата);

            //
            //// todo ЗАПОЛЕНИЯ ТАБЕЛЯ ИЗ БАЗЫ ДАННЫХ
            if (ПолученноеЗначениеИзСпинераДата != null ) {


                try{
                    //////метод которы из текста которйц было арпдчьадена дата обраьно преобразует в дату для проверки
                    LinearLayoutСозданныхТабелей.removeAllViews();

                } catch (Exception e) {
                 /*   e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());*/
                }

                Log.d(this.getClass().getName(), " код загружает все созданные табеля из базы " + КакойКонтекст);
                //////TODO преобразовыываем оборатно из названиея месяц в цифру
                МЕсяцВвидеЦифрыДляКурсора= МетодПолучениниеКурсораМЕсяцДата(ПолученноеЗначениеИзСпинераДата);
                ////
                ГОДВвидеЦифрыДляКурсора=МетодПолучениниеКурсораГОДДата(ПолученноеЗначениеИзСпинераДата);
                /////
                Log.d(this.getClass().getName(), " МЕсяцВвидеЦифрыДляКурсора " + МЕсяцВвидеЦифрыДляКурсора +
                        "  ГОДВвидеЦифрыДляКурсора " + ГОДВвидеЦифрыДляКурсора);

                ///TODO СЮДА ЗАХОДИМ ТОЛЬКО КОГДА НОВЫЙ ТАБЕЛЬ


//TODO данный курсор работает когда не новый а старый простмартиваем ТАбель(создаенный ранее)

//////todo загружаем табеоля в начале  ЗАГРУЖАЕМ В СПИНЕР ДАТЫ А НЕ А ТАБЕЛЯ  ДАННЫЕ ДЛЯ СПИПЕР



                try {




                    // ID


                    Log.d(this.getClass().getName(), " ПубличноеIDПолученныйИзСервлетаДляUUID  " + ПубличноеIDПолученныйИзСервлетаДляUUID);
                    if (ПубличноеIDПолученныйИзСервлетаДляUUID==0) {



                        class_grud_sql_operationsДляАктивтиТабель= new Class_GRUD_SQL_Operations(getApplicationContext());

                        ///
                        class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СамFreeSQLКОд",
                                " SELECT id  FROM successlogin  ORDER BY date_update DESC ;");


                        // TODO: 12.10.2021  Ссылка Менеджер Потоков

                        Курсор_ПолучаемПубличныйID=null;
                        ///////
                        Курсор_ПолучаемПубличныйID= (SQLiteCursor) class_grud_sql_operationsДляАктивтиТабель.
                        new GetаFreeData(getApplicationContext()).getfreedata(class_grud_sql_operationsДляАктивтиТабель.
                                concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());


                        Log.d(this.getClass().getName(), " Курсор_ПолучаемПубличныйID  " + Курсор_ПолучаемПубличныйID);

                        if(Курсор_ПолучаемПубличныйID.getCount()>0){

                            ////
                            Курсор_ПолучаемПубличныйID.moveToFirst();

                            /////
                            ПубличноеIDПолученныйИзСервлетаДляUUID=         Курсор_ПолучаемПубличныйID.getInt(0);
    ///


                            Log.d(this.getClass().getName(), " ПубличноеIDПолученныйИзСервлетаДляUUID  " + ПубличноеIDПолученныйИзСервлетаДляUUID);


                        }

                        if(Курсор_ПолучаемПубличныйID != null && !Курсор_ПолучаемПубличныйID.isClosed()) {
                            Курсор_ПолучаемПубличныйID.close();

                        }
                    }


                    Log.d(this.getClass().getName(), "ПолученнаяUUIDНазванияОрганизации "+ ПолученнаяUUIDНазванияОрганизации
                            + " ПубличноеIDПолученныйИзСервлетаДляUUID " +ПубличноеIDПолученныйИзСервлетаДляUUID
                            + " МЕсяцВвидеЦифрыДляКурсора " +МЕсяцВвидеЦифрыДляКурсора
                            + " ГОДВвидеЦифрыДляКурсора  "+ ГОДВвидеЦифрыДляКурсора);

                    ///TODO ГЛАВНЫЙ КУРСОР ЗАГРУЗКИ САМИХ ТАБЕЛЕЙ НА АКТИВТИИ
                    if ( МЕсяцВвидеЦифрыДляКурсора>0 && ГОДВвидеЦифрыДляКурсора>0 ) {
                        //////////
                        Log.d(this.getClass().getName(), "ПолученнаяUUIDНазванияОрганизации "+ ПолученнаяUUIDНазванияОрганизации
                                + " ПубличноеIDПолученныйИзСервлетаДляUUID " +ПубличноеIDПолученныйИзСервлетаДляUUID
                                + " МЕсяцВвидеЦифрыДляКурсора " +МЕсяцВвидеЦифрыДляКурсора
                                + " ГОДВвидеЦифрыДляКурсора  "+ ГОДВвидеЦифрыДляКурсора);




                        String    НазваниеТабеля;

                        try{

                               int  finalМЕсяцВвидеЦифрыДляКурсора=МЕсяцВвидеЦифрыДляКурсора;

                             int  finalГОДВвидеЦифрыДляКурсора=ГОДВвидеЦифрыДляКурсора;


                         /////////////////////

                                    //TODO ГЛАВНЫЙ КУРСОР ЗАГРУЗКИ САМИХ ТАБЕЛЕЙ НА АКТИВТИИ"nametabel"
                        
                                /*        Курсор_КоторыйЗагружаетГотовыеТабеля = new Class_MODEL_synchronized(getApplicationContext()).КурсорУниверсальныйДляБазыДанных("tabels", new String[]{"*"},
                                                " month_tabels=? AND year_tabels=? AND status_send!=? " +
                                                        "AND month_tabels IS NOT NULL  AND year_tabels IS NOT NULL",
                                                new String[]{String.valueOf(finalМЕсяцВвидеЦифрыДляКурсора),
                                                        String.valueOf(finalГОДВвидеЦифрыДляКурсора), "Удаленная"},
                                                "cfo", null, "date_update DESC", null);///"SELECT name  FROM MODIFITATION_Client WHERE name=?",НазваниеТаблицНаСервере
                                        ///////*/
//


                            class_grud_sql_operationsДляАктивтиТабель= new Class_GRUD_SQL_Operations(getApplicationContext());
                            ///
                            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","tabel");
                            ///////
                            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","*");
                            //
                            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","month_tabels=? " +
                                    "AND year_tabels=? AND status_send!=? AND month_tabels IS NOT NULL  AND year_tabels IS NOT NULL");
                            ///"_id > ?   AND _id< ?"
                            //////
                            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",finalМЕсяцВвидеЦифрыДляКурсора);
                            ///
                            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2",finalГОДВвидеЦифрыДляКурсора);
                            //
                            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3","Удаленная");////УсловиеПоискаv4,........УсловиеПоискаv5 .......

                            ////TODO другие поля

                           //TODO sql group by --- САМИХ ТАБЕЛЕЙ

                            //class_grud_sql_operationsСозданиеТабеляИзБазы. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки","cfo");
                            ////
                          /*  class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки","cfo");
                            ////*/
                            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update");
                            ////
                           /* classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита",null);*/
                            ////



                            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
                            Курсор_КоторыйЗагружаетГотовыеТабеля=null;

                             Курсор_КоторыйЗагружаетГотовыеТабеля= (SQLiteCursor)  class_grud_sql_operationsДляАктивтиТабель.
                                    new GetData(getApplicationContext()).getdata(class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                                     Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

                            Log.d(this.getClass().getName(), "GetData "+Курсор_КоторыйЗагружаетГотовыеТабеля  );




                                    //////todo работающий NULL в query
                                    Log.d(this.getClass().getName(), " Курсор_КоторыйЗагружаетГотовыеТабеля.getCount() " +    Курсор_КоторыйЗагружаетГотовыеТабеля.getCount());
                                    ////todo получаем значение ищем
                                    ///


                                        /////TODO САМАЯ ЗАГРУЗКА ТАБЕЛЕЙ , ЕСЛИ ОНИ ВООБЩЕ ЕСТЬ

               


                      
                              Log.d(this.getClass().getName(), "ЗАГРУЗИЛИ ДАННЫЕ НА АКТИВТИ ИСТОРИЯ ТАБЕЛЯЕЙ  Курсор_КоторыйЗагружаетГотовыеТабеля.getCount() "
                                      + Курсор_КоторыйЗагружаетГотовыеТабеля.getCount());


                                  if (   Курсор_КоторыйЗагружаетГотовыеТабеля.getCount()>0) {


                                         textViewКоличествоТабелей.setText(" ("+СпинерВыборДату.getCount()+" м) "+ " ("+ String.valueOf(Курсор_КоторыйЗагружаетГотовыеТабеля.getCount())+" т)")  ;
                                         /////



                                     } else {
                                         textViewКоличествоТабелей.setText("("+"0"+")");

                                      // TODO: 21.09.2021  НЕТ ДАННЫХ  НЕТ ТАБЕЛЬ
                                    ///  МетодКогдаДанныхСамихТабелйНет();
                                     }


                              ////

                                    //todo




                            Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата=null;
                            //TODO ГЛАВНЫЙ КУРСОР ЗАГРУЗКИ САМИХ ТАБЕЛЕЙ НА АКТИВТИИ"nametabel"

                            Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата = МетодКоторыйПоказываетМаксимальнуюДатуИзменения(ПолученнаяUUIDНазванияОрганизации);



                            // TODO: 02.09.2021 курсорсы



                            if (Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата.getCount()>0) {

                                /////

                                Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата.moveToFirst();

                                Integer ИндексГлеНАходитьсяДата=Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата.getColumnIndex("MAX_d");


                                String   МаскимальнаяДатавТабеляхПоМесецям = Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата.getString(ИндексГлеНАходитьсяДата);





                                Log.d(this.getClass().getName(), " МаскимальнаяДатавТабеляхПоМесецям  " +    МаскимальнаяДатавТабеляхПоМесецям
                                        + " МесяцМаскимальнаяДатавТабеляхПоМесецям  " + МесяцМаскимальнаяДатавТабеляхПоМесецям +  "  Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата.getCount() "
                                        +Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата.getCount());

                            }else{

                                ////
                                МесяцМаскимальнаяДатавТабеляхПоМесецям ="";
                            }




                            if(!Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата.isClosed()) {
                                Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата.close();

                            }


















                                //TODO закрываем курсор с максимальной датой
                           // Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                            ///метод запись ошибок в таблицу
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), 
       this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }








            /*    ///TODO ГЛАВНЫЙ КУРСОР ЗАГРУЗКИ САМИХ ТАБЕЛЕЙ НА АКТИВТИИ
                Курсор_КоторыйЗагружаетГотовыеТабеля = new Class_MODEL_synchronized(this).КурсорУниверсальныйДляБазыДанных("viewtabel", new String[]{"*"},
                        "user_update= ? AND  month_tabels=? AND year_tabels=? AND name IS NOT NULL",
                        new String[]{ПубличноеIDПолученныйИзСервлетаДляUUID, String.valueOf(МЕсяцВвидеЦифрыДляКурсора),
                                String.valueOf(ГОДВвидеЦифрыДляКурсора)}, "nametabel", null, "date_update desc", null);///"SELECT name  FROM MODIFITATION_Client WHERE name=?",НазваниеТаблицНаСервере*/
                    }
                    //поймать ошибку всего классаIOException | MyException e    NumberFormatException
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                           new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                }

                ////
                /////УДАЛЯЕМ ИЗ ПАМЯТИ  ОТРАБОТАННЫЙ АСИНАТСК
                /////
                /////// обнуляем


                // TODO: 21.09.2021  add TABELS 
                
                
                
                ///
                String[] НазваниеТабеля = {""};
                /////
                String[] ДатаТабеляИзБАзы = {""};
                
                
                
                


                ////todo ЗАГРУЖАЕМ КУРСОР ПОЛУЧЕННЫЙ С ГОТОВЫМИ ТАБЕЛЯ ЗА КОНКЕРТНЫЙ МЕСЯЦ


                if (Курсор_КоторыйЗагружаетГотовыеТабеля.getCount() > 0) {/////ЕСЛИ ЕСТЬХОТЯБЫ ОДИН ТАБЕЛЬ

                    Log.d(this.getClass().getName(), " Курсор_КоторыйЗагружаетГотовыеТабеля " + Курсор_КоторыйЗагружаетГотовыеТабеля.getCount());

                    ////TODO СТАВИМ КУРСОР НА НУЖНУЮ ПОЗИЦИЮ
                    Курсор_КоторыйЗагружаетГотовыеТабеля.moveToFirst();
                    Log.d(this.getClass().getName(), " Курсор_КоторыйЗагружаетГотовыеТабеля " + Курсор_КоторыйЗагружаетГотовыеТабеля.getCount());
                    ///TODO




                    final int[] ИндексДляСозданныхОбьектовНаАктивитиТАбель = {0};

                    ///todo удалчем элемены перед новой вставкой обтьектов на активти


                    try{

                        //
                        LinearLayoutСозданныхТабелей.removeAllViews();/////удалем данные с актиывти
                        ////
                        LinearLayoutСозданныхТабелей.invalidate();



                    } catch (Exception e) {
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
               /* Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());*/
                    }






                    ////// todo заргужаем название табелеей ЦИКЛ загружаем на активти  УЖЕ СОЗДАННЫЕ ТАБЕЛЯ И ВИД ИХ ДЕЛАЕМ КАК КНОПКА
                    do {
                        Log.d(this.getClass().getName(), " Количество Строчек В табеле " + Курсор_КоторыйЗагружаетГотовыеТабеля.getCount() + " Количество столбиков в табеле " +
                                Курсор_КоторыйЗагружаетГотовыеТабеля.getColumnCount());
                        //////
                        /* TimeUnit.MILLISECONDS.sleep(30);*/


                        ////TODO электронне прдставлени имени табеля
                        int ИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ= Курсор_КоторыйЗагружаетГотовыеТабеля.getColumnIndex("cfo");
                        ////


                        // TODO: 10.06.2021
                  ПолучеаемЦифруСФО=0;

                        ///
                       ПолучеаемЦифруСФО= Курсор_КоторыйЗагружаетГотовыеТабеля.getInt(ИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ);


                        Log.d(this.getClass().getName()," ИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ  "+ИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ+" ПолучеаемЦифруСФО " +ПолучеаемЦифруСФО);


                        try {
                            НазваниеТабеля[0] = new Class_MODEL_synchronized(КонтекстИсторииВсехТабелейВыбранных).
                                    МетодПолучениеНазваниеТабеляНаОснованииСФО(КонтекстИсторииВсехТабелейВыбранных, ПолучеаемЦифруСФО);
                            ////////
                            Log.d(КонтекстИсторииВсехТабелейВыбранных.getClass().getName(), "    НазваниеТабеля[0] " + НазваниеТабеля[0]);


                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ///;


                        Log.d(this.getClass().getName(),"  НазваниеТабеля[0]   "+ НазваниеТабеля[0] );


                        try {
                            МесяцМаскимальнаяДатавТабеляхПоМесецям = new Class_MODEL_synchronized(КонтекстИсторииВсехТабелейВыбранных).
                                    МетодПолучениеНазваниеТабеляНаОснованииСФО(КонтекстИсторииВсехТабелейВыбранных, ПолучеаемЦифруСФО);

                            ////////
                            Log.d(КонтекстИсторииВсехТабелейВыбранных.getClass().getName(), "   МесяцМаскимальнаяДатавТабеляхПоМесецям " +     ////////
                                    МесяцМаскимальнаяДатавТабеляхПоМесецям);

                            ////
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ///;








                  //      НазваниеТабеля[0] = Курсор_КоторыйЗагружаетГотовыеТабеля.getString(ИндексНазваниеТабеля);

                        int ИндексДата= Курсор_КоторыйЗагружаетГотовыеТабеля.getColumnIndex("date_update");

                        ДатаТабеляИзБАзы[0] = Курсор_КоторыйЗагружаетГотовыеТабеля.getString(ИндексДата);
                        //todo перерводим в дату для СРАВНЕНИЯ

                        //TODO статус табеля
/*
                        int ИндексСтатусаТабеляПроведенИлиНет= Курсор_КоторыйЗагружаетГотовыеТабеля.getColumnIndex("status_carried_out");

                        int   СамСтатусАтбеля = Курсор_КоторыйЗагружаетГотовыеТабеля.getInt(ИндексСтатусаТабеляПроведенИлиНет)*/;

                        Integer   СамСтатусАтбеля =     МетодВЫчиляемСтатусТабеляПроведенИлиНет(МЕсяцВвидеЦифрыДляКурсора,ГОДВвидеЦифрыДляКурсора,ПолучеаемЦифруСФО);







//                        Date МаскимальнаяДатавТабеляхПоМесецямДляСравнениеВЦикле = new android.icu.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", new Locale("ru")).parse(ДатаТабеляИзБАзы[0]);


                        Log.d(this.getClass().getName(), " НазваниеТабеля " + НазваниеТабеля[0] + " ДатаТабеляИзБАзы " + ДатаТабеляИзБАзы[0] + " СамСтатусАтбеля " +СамСтатусАтбеля);
                        ///////// TODO добаляем кнопки
                        ТабелявВидеКнопок = new Button(this);////СОЗДАЕМ НОВЫЕ КНОПКИ НА АКТИВТИ
                        //////
                       // ТабелявВидеКнопок.setId(ИндексДляСозданныхОбьектовНаАктивитиТАбель[0]);
                        ///TODO определяем для созданого табеля его UUID для последющей работы
                        ///todo не посредственно для табеля
                        int ИндексГдеНаходитьсяUUIDВТАБЕЛЕ= Курсор_КоторыйЗагружаетГотовыеТабеля.getColumnIndex("uuid");
                        ////
                        String НепостредственоеЗначениеUUIDСозданогоТАбеля = "";
                        ///////
                        if (ИндексГдеНаходитьсяUUIDВТАБЕЛЕ>=0){
                            НепостредственоеЗначениеUUIDСозданогоТАбеля = Курсор_КоторыйЗагружаетГотовыеТабеля.getString(ИндексГдеНаходитьсяUUIDВТАБЕЛЕ).trim();
                        }

                        ////TODO электронне прдставлени имени табеля
                        ИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ= Курсор_КоторыйЗагружаетГотовыеТабеля.getColumnIndex("cfo");
                        ////
                        int НепостредственоеЗначениеИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ = 0;


                        ///////TODO вычисляем
                        if (ИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ>=0){
                            НепостредственоеЗначениеИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ = Курсор_КоторыйЗагружаетГотовыеТабеля.getInt(ИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ);

                            ЦифровоеИмяНовгоТабеля=НепостредственоеЗначениеИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ;
                        }




                        ////todo когда данные в табелй есть  САМИ ДАННЫЕ ТАБЕЛЕЙ ЗАГРУЖАЮТЬСЯ
                        //ТабелявВидеКнопок.setHint(НепостредственоеЗначениеИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ);
                        ТабелявВидеКнопок.setTag(НепостредственоеЗначениеUUIDСозданогоТАбеля);

                        ТабелявВидеКнопок.setId(НепостредственоеЗначениеИндексГдеНаходитьсяЭлектронноеИмяВТАБЕЛЕ);

                        ТабелявВидеКнопок.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                        ТабелявВидеКнопок.setMinLines(8);

                        ТабелявВидеКнопок.setTextSize(13);

                        ТабелявВидеКнопок.setHintTextColor(Color.RED);

                        ТабелявВидеКнопок.setText(НазваниеТабеля[0]);

                        ТабелявВидеКнопок.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

                        ТабелявВидеКнопок.setTextColor(Color.BLACK);

                        ТабелявВидеКнопок.setHintTextColor(Color.RED);

                        /////


    //TODO добвлем галочку
                        Log.d(this.getClass().getName(), " СамСтатусАтбеля "+СамСтатусАтбеля);
                        ///
if (СамСтатусАтбеля>0){ ///"пр"

    Drawable icon = getResources().getDrawable(R.mipmap.icon_dsu1_tabels_provedennye);
    icon.setBounds(0, 2, 100, 100);
  //  ТабелявВидеКнопок.setPadding (0,0, 0, 150);
    ТабелявВидеКнопок.setCompoundDrawables(icon, null, null, null);

}



                        ////
                   ТабелявВидеКнопок.setBackground(getApplication().getResources().getDrawable(R.drawable.textlines_tabel_row_color_green_mini));
                        //////ДОБАЯЛЕМ СТРОЧКУ

//////todo сЛУШАТЕЛЬ ДЛЯ УДАЛЕНИЯ ТАБЕЛЯ
                        ТабелявВидеКнопок.setOnLongClickListener(СлушательУдаланиеСамогоТабеля);

                        // TODO ТУТ ДАННЫЙ КОД СРАБАТЫВАЕТ ПОСЛЕ ТОГО КАК МЫ СОЗДАЛИ НОВЫЙ ТАБЕЛЬ И КНОПКА С НОВЫМ НАЗВАНИЕМ ТОЖЕ СОЗДААЛСЬ И МЫ ПО НЕЙ ПЕРЕХОДИМ НА НОВЫЙ ТАБЕЛЯ КЛИКНУТ ПО КНОПКЕ ТАБЕЛЬ

                        ////// todo КЛИК ПО КНОПКАМ --СОЗДАННЫМ НОВЫЕ ТАБЕЛЯ   //////КЛИК ПО КНОПКАМ --СОЗДАННЫМ НОВЫЕ ТАБЕЛЯ
                        //////КЛИК ПО КНОПКАМ --СОЗДАННЫМ НОВЫЕ ТАБЕЛЯ   //////КЛИК ПО КНОПКАМ --СОЗДАННЫМ НОВЫЕ ТАБЕЛЯ








                        ////////


// TODO: 18.03.2021 ЗАПУСКАЕТ КОД ПРОСТО КЛИКА ПО ТАБЕЛЮ ЧТО БЫ ЗАЙТИ ВО ВНУТЬ
                        ////////
                        ТабелявВидеКнопок.setOnClickListener(new View.OnClickListener() {


                            @Override
                            public void onClick(View v) {

                                try{



                                    ТабелявВидеКнопок.setBackgroundColor(Color.GRAY);


/////TODO одинатрный клик для загрузки в этот табель всех сотрудников
                        МетодЗапускаетТачОднократныйДляЗагрузкиВтабельСотрудников((Button) v);


                                КонтекстИсторииВсехТабелейВыбранныхВнешний=null;


                                /////////
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


                            ////////////////////////TODO event




                            ////////











                            /////TODO метод запуска кода при однократорм нажатии просто загузка сотрудников табель
                            private void МетодЗапускаетТачОднократныйДляЗагрузкиВтабельСотрудников(Button v) {
                                try{
                                    // TODO ДАННЫЙ КОД УЩУСЕТВЛЯЕТ ЗАПУСК СОЗДАНОГО ТАБЕЛЯ НОВОГО ЗАХОДИМ ПРАМЯ В НЕГО
                                    //////СПИНЕРА

                                    /////


                                    //  Toast.makeText(getApplicationContext(), "Тест на Клик по Табелю  MainActivity_CreateTableTHREE.class !!! "  , Toast.LENGTH_SHORT).show();
                                    /////СОБИТИЕ ПРИ НАЖАТИИ НА КОНРКУ СОЗДАННОГО ТАБЕЛЯ
                                    //Intent ИнтентЗапускаемСуществующийТабель=new Intent(MainActivity_List_Tabels.this,MainActivity_CreateTableTHREE.class);//getApplicationContext()
                                    // Intent ИнтентЗапускаемСуществующийТабель=new Intent(MainActivity_List_Tabels.this,MainActivity_Tabel_Only_Single_Employee.class);//getApplicationContext()
                                    Intent ИнтентЗапускаемСуществующийТабель=new Intent(MainActivity_List_Tabels.this, MainActivity_List_Employees_Current_Tabel.class);//getApplicationContext()

                                    ////todo сами данные для ПЕРЕДАЧИ

                                    String ПередаемСозданнуюДатуНовогоТабеля = (String) ((TextView) СпинерВыборДату.getChildAt(0)).getText();///дата нового табеля
                                    ///////todo ВЫТАСКИЕВАЕМ НАЗВАНИЕ ТАБЕЛЯ
                                    Button ИзКнопкиПолучаемНазваниеТабеля = v;

                                    String ПередаемСозданнуюНазваниеТабеля = ИзКнопкиПолучаемНазваниеТабеля.getText().toString();

                                    Log.d(this.getClass().getName(), " ПередаемСозданнуюНазваниеТабеля  " +ПередаемСозданнуюНазваниеТабеля);

                                    ///////todo ВЫТАСКИЕВАЕМ НАЗВАНИЕ ТАБЕЛЯ
                                    Button ИзКнопкиПолучаемUUIDТабеля = v;

                                    Object ПередаваемыйИзКнопкиПолучаемUUIDТабеля = ИзКнопкиПолучаемНазваниеТабеля.getTag();

                                    Log.d(this.getClass().getName(), " ПередаваемыйИзКнопкиПолучаемUUIDТабеля  " +ПередаваемыйИзКнопкиПолучаемUUIDТабеля);

                                    ПубличноеИмяКнопкиТабеля=  ТабелявВидеКнопок.getText().toString();
                                    ///////



                                    Button ИзКнопкиПолучаемЦифровоеИмяТабеля = v;

                                    Object ПередаваемыйИзКнопкиПолучаемЦифровоеИмяТабеля = ИзКнопкиПолучаемНазваниеТабеля.getId();

                                    ЦифровоеИмяНовгоТабеля= Integer.parseInt(ПередаваемыйИзКнопкиПолучаемЦифровоеИмяТабеля.toString());

                                    Log.d(this.getClass().getName(), " ЦифровоеИмяНовгоТабеля  " +ЦифровоеИмяНовгоТабеля);



                                    ///////
                                    int ПоискФлеша = ПередаемСозданнуюНазваниеТабеля.indexOf("\n") + 1;

                                    StringBuffer БуферДляПоискаФлешаДляГотовогоТабеля = new StringBuffer(ПередаемСозданнуюНазваниеТабеля);


                                    String ПередаемДепартаментФинал = БуферДляПоискаФлешаДляГотовогоТабеля.substring(ПоискФлеша, БуферДляПоискаФлешаДляГотовогоТабеля.length());

                                    ////
                                    Log.d(this.getClass().getName(), " ПередаемСозданнуюДатуНовогоТабеля " + ПередаемСозданнуюДатуНовогоТабеля +
                                            "  ПередаемСозданнуюДепартаментНовогоТабеля " + ПередаемСозданнуюНазваниеТабеля +
                                            " ПередаемДепартаментФинал  " +ПередаемДепартаментФинал + " ТабелявВидеКнопок.getTag().toString() " );

                                    ////
                                    Log.d(this.getClass().getName(), " МассивДляВыбораВСпинерДата.get(1) " + МассивДляВыбораВСпинерДата.get(0));
                                    ///

                                    МесяцТабеляФиналИзВсехСотрудниковВТАбеле  =МассивДляВыбораВСпинерДата.get(0);

                                    /////////todo отпраялем данные значения на активти где все сотрудникаи вконкретном табеле
                                    ИнтентЗапускаемСуществующийТабель.putExtra("ПередаемСозданнуюДатуНовогоТабеля", String.valueOf(ПередаемСозданнуюДатуНовогоТабеля));

                                    ИнтентЗапускаемСуществующийТабель.putExtra("ПередаемДепартаментФинал", ПередаемДепартаментФинал);

                                    ИнтентЗапускаемСуществующийТабель.putExtra("ПолноеНазваниеТабеляФинал", ПередаемСозданнуюНазваниеТабеля);

                                    ИнтентЗапускаемСуществующийТабель.putExtra("ПередаваемыйИзКнопкиПолучаемUUIDТабеля", String.valueOf(ПередаваемыйИзКнопкиПолучаемUUIDТабеля));

                                




                                    // TODO: 22.09.2021  clear operasion

                                    Log.d(this.getClass().getName(),
                                            "  ПередаваемыйИзКнопкиПолучаемUUIDТабеля " + ПередаваемыйИзКнопкиПолучаемUUIDТабеля);

                                    if (ПередаваемыйИзКнопкиПолучаемUUIDТабеля!=null) {

                                        // TODO: 28.01.2022

                                        ИнтентЗапускаемСуществующийТабель.putExtra("UUIDТабеляФинал", String.valueOf(ПередаваемыйИзКнопкиПолучаемUUIDТабеля));

                                        ИнтентЗапускаемСуществующийТабель.putExtra("РодительскийUUDТаблицыТабель", Long.parseLong(String.valueOf(ПередаваемыйИзКнопкиПолучаемUUIDТабеля)));
                                    }


                                    // TODO: 22.09.2021  clear operasion

                                    Log.d(this.getClass().getName(),
                                            "  РодительскийUUDТаблицыТабель " + РодительскийUUDТаблицыТабель);


                                    if (РодительскийUUDТаблицыТабель>0) {
                                        // TODO: 28.01.2022  
                                        ИнтентЗапускаемСуществующийТабель.putExtra("РодительскийUUDТаблицыТабель", РодительскийUUDТаблицыТабель);
                                        // TODO: 28.01.2022
                                        ИнтентЗапускаемСуществующийТабель.putExtra("UUIDТабеляФинал", String.valueOf(РодительскийUUDТаблицыТабель));
                                    }


                                    ИнтентЗапускаемСуществующийТабель.putExtra("МесяцТабеляФиналИзВсехСотрудниковВТАбеле", String.valueOf( МесяцТабеляФиналИзВсехСотрудниковВТАбеле));



                                    ИнтентЗапускаемСуществующийТабель.putExtra("ГодТабеляФиналИзВсехСотрудниковВТАбеле", String.valueOf( ГОДВвидеЦифрыДляКурсора));


                                 //   ИнтентЗапускаемСуществующийТабель.putExtra("ЦифровоеИмяНовгоТабеля", String.valueOf( ЦифровоеИмяНовгоТабеля));



                                    ИнтентЗапускаемСуществующийТабель.putExtra("ПолученнаяUUIDНазванияОрганизации",ПолученнаяUUIDНазванияОрганизации);


                                    ИнтентЗапускаемСуществующийТабель.putExtra("ЦифровоеИмяНовгоТабеля",ЦифровоеИмяНовгоТабеля);

                                    ИнтентЗапускаемСуществующийТабель.putExtra("ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре",ПолученныйПоследнийМесяцДляСортировкиЕгоВСпиноре);




                                    ////



                                    /////запускаем активти
                                    startActivity(ИнтентЗапускаемСуществующийТабель);
                                    /////
                                    ////
                                  ///  finish();



                                    /////////
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
                        });


                        ///todo клик по табелби преход на сотрудников
                        /////
/////



                        //////

                        if (  МесяцМаскимальнаяДатавТабеляхПоМесецям.trim().equals(НазваниеТабеля[0].trim())) {




                            LinearLayoutСозданныхТабелей.addView(ТабелявВидеКнопок, 0); /////СОЗДАЕМ НАКШИ КНОПКИ ВНУРИ СКРОЛБАР




                        }else{
                            //TODO  ОЧИЩАЕМ ПАМТЬ




                            ////////унопки распологаем внутири скролбара
                            LinearLayoutСозданныхТабелей.addView(ТабелявВидеКнопок, ИндексДляСозданныхОбьектовНаАктивитиТАбель[0]); /////СОЗДАЕМ НАКШИ КНОПКИ ВНУРИ СКРОЛБАР




                        }
                        ИндексДляСозданныхОбьектовНаАктивитиТАбель[0]++;///увеличиваем


                        ////ТУТ НАПИСАН  КОД КОТОРЫЙ ЗАПУСКАЕТ САМ ТАБЕЛЬ ПРИ НАЖАТИИ НА СОЗДАННЫЕ КНОПКА-ТАБЕЛЬ



                        /////todo ЦИКЛ ЗАГРУЗКИ ТОЛЬКО НАЗВАНИЙ ТАБЕЛЯ
                    } while (Курсор_КоторыйЗагружаетГотовыеТабеля.moveToNext());
                    /////toto ПОСЛЕ ВСТАВКИ ДАННЫХ ПЕРЕОПРЕДЕЛЯЕМ ВНЕГНИЙ ВИДЖ

                    if(!Курсор_КоторыйЗагружаетГотовыеТабеля.isClosed()) {
                        Курсор_КоторыйЗагружаетГотовыеТабеля.close();

                    }

                   // TextView) parent.getChildAt(0)).getText()+String.valueOf("  ("+СпинерВыборДату.getCount()+")")




///todo  когда в табеле нет сотрудников ПУСТОЙ ТАБЕЛЬ
                }

                ////TODO ПОСЛЕ ЗАПОЛЕНЕИЯ ТАБЕЛЯ В АКТИВИТИ
                LinearLayoutСозданныхТабелей.invalidate();

                ScrollНаАктивтиСозданныхТабелей.invalidate();

                ScrollНаАктивтиСозданныхТабелей.fullScroll(View.FOCUS_UP);


            }



            ///КОНЕЦ ЗАПОЛЕНИЯ ТАБЕЛЯ ИЗ ДАННЫХ
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                   new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    // TODO: 17.06.2021 вычиляем статус табеля

    private int МетодВЫчиляемСтатусТабеляПроведенИлиНет(int finalМЕсяцВвидеЦифрыДляКурсора ,int finalГОДВвидеЦифрыДляКурсора ,int ПолучеаемЦифруСФО ) {
//
        Integer ПолученныйСтатусТабеля=0;

        SQLiteCursor Курсор_КоторыйЗагружаетСтатусТабеля = null;

        Integer ПолученныйСтатусВнутри = null;
        //



   try{

               /////////////TODO вычислем по новому значение
   /*            /////////////
       Курсор_КоторыйЗагружаетСтатусТабеля = new Class_MODEL_synchronized(getApplicationContext()).КурсорУниверсальныйДляБазыДанных("viewtabel", new String[]{"status_carried_out"},
               " month_tabels=? AND year_tabels=?  AND cfo=?  AND status_send!=? " +
                       "AND status_carried_out IS NOT NULL",
               new String[]{String.valueOf(finalМЕсяцВвидеЦифрыДляКурсора),
                       String.valueOf(finalГОДВвидеЦифрыДляКурсора), String.valueOf(ПолучеаемЦифруСФО), "Удаленная"},
               "cfo", null, "date_update DESC", null);///"SELECT name  FROM MODIFITATION_Client WHERE name=?",НазваниеТаблицНаСервере
       ///////*/







       // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ


       class_grud_sql_operationsДляАктивтиТабель= new Class_GRUD_SQL_Operations(getApplicationContext());
       ///
       class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","viewtabel");//tabels
       ///////
       class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","status_carried_out");//status_carried_out
       //
       class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика"," month_tabels=? AND year_tabels=?  AND cfo=?  AND status_send!=?   ");//   AND status_send!=?   AND status_carried_out IS NOT NULL
       ///"_id > ?   AND _id< ?"
       //////
       class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",finalМЕсяцВвидеЦифрыДляКурсора);
       ///
       class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2",finalГОДВвидеЦифрыДляКурсора);
       //
       class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3",ПолучеаемЦифруСФО);////УсловиеПоискаv4,........УсловиеПоискаv5 .......

       //
       class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска4","Удаленная");////УсловиеПоискаv4,........УсловиеПоискаv5 .......


       ////TODO другие поля

       class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки","cfo");
       ////
   /*  class_grud_sql_operations1. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",  "cfo");*/
       ////
    //   class_grud_sql_operations1. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC");
       ////
     ////  class_grud_sql_operations1. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита",null);
       ////


       PUBLIC_CONTENT         Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = new PUBLIC_CONTENT (getApplicationContext());

       // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ


       Курсор_КоторыйЗагружаетСтатусТабеля= (SQLiteCursor)  class_grud_sql_operationsДляАктивтиТабель.
               new GetData(getApplicationContext()).getdata(class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
               Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

       Log.d(this.getClass().getName(), "GetData " +Курсор_КоторыйЗагружаетСтатусТабеля );


       // TODO: 02.09.2021 результат

               if( Курсор_КоторыйЗагружаетСтатусТабеля.getCount()>0){
                   ////
                   Курсор_КоторыйЗагружаетСтатусТабеля.moveToNext();
                   ///
               ПолученныйСтатусВнутри=Курсор_КоторыйЗагружаетСтатусТабеля.getInt(0);
               ///

                   if(ПолученныйСтатусВнутри==null){
                       ///
                       ПолученныйСтатусВнутри=0;
                   }


               }else{
                   ПолученныйСтатусВнутри=0;
               }

       Log.d(this.getClass().getName(), " ПолученныйСтатусВнутри  "+ПолученныйСтатусВнутри);

       ////


        ///КОНЕЦ ЗАПОЛЕНИЯ ТАБЕЛЯ ИЗ ДАННЫХ
    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
   return ПолученныйСтатусТабеля;
    }












    //////TODO вычисляем максимальную дату для LISTVIEW

    SQLiteCursor МетодКоторыйПоказываетМаксимальнуюДатуИзменения(Long полученнаяUUIDНазванияОрганизации) throws ExecutionException, InterruptedException {
        ///
     SQLiteCursor Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата = null;
        ///

                try{

            /*        Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата = new Class_MODEL_synchronized(КонтекстИсторииВсехТабелейВыбранных).КурсорУниверсальныйДляБазыДанных("tabels",
                            new String[]{"date_update"},
                            " month_tabels=? AND year_tabels=? AND status_send!=?  AND date_update = (SELECT MAX(date_update) FROM tabels)",
                            new String[]{ String.valueOf(МЕсяцВвидеЦифрыДляКурсора),
                                    String.valueOf(ГОДВвидеЦифрыДляКурсора), "Удаленная",}, null, null, "date_update DESC", null);
///////*/
                    String ТаблицаДляТекущейООперации="tabel";

                    // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ


                    class_grud_sql_operationsДляАктивтиТабель= new Class_GRUD_SQL_Operations(getApplicationContext());
                    ///
                    class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СамFreeSQLКОд",
                            " SELECT MAX (   date_update  ) AS MAX_d  FROM  " + ТаблицаДляТекущейООперации + "   " +
                                    " WHERE  month_tabels = '" + МЕсяцВвидеЦифрыДляКурсора + "'   AND year_tabels = '" + ГОДВвидеЦифрыДляКурсора + "'  AND status_send  != 'Удаленная'   ORDER BY date_update   DESC  ;");
                    ///////

                    //
                 /*   class_grud_sql_operationsКоторыйПоказываетМаксимальнуюДатуИзменения. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","month_tabels=? AND year_tabels=? AND status_send!=?  " +
                            "AND date_update = (SELECT MAX(date_update) FROM " + ТаблицаДляТекущейООперации+ ") ");
                    ///"_id > ?   AND _id< ?"
                    //////
                    class_grud_sql_operationsКоторыйПоказываетМаксимальнуюДатуИзменения. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",МЕсяцВвидеЦифрыДляКурсора);
                    ///
                    class_grud_sql_operationsКоторыйПоказываетМаксимальнуюДатуИзменения. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2",ГОДВвидеЦифрыДляКурсора);
                    //
                    class_grud_sql_operationsКоторыйПоказываетМаксимальнуюДатуИзменения. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3","Удаленная");////УсловиеПоискаv4,........УсловиеПоискаv5 .......

                    ////TODO другие поля

                ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
                    ////
                    //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
                    ////
                    class_grud_sql_operationsКоторыйПоказываетМаксимальнуюДатуИзменения. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC");*/
                    ////
                   /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита",null);
                    ////
                    PUBLIC_CONTENT         Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = new PUBLIC_CONTENT (getApplicationContext());
                    // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
                    Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата=null;

                    // TODO: 26.10.2021



                Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата= (SQLiteCursor) class_grud_sql_operationsДляАктивтиТабель.
                            new GetаFreeData(getApplicationContext()).getfreedata(class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

                    Log.d(this.getClass().getName(), "GetаFreeData "  +Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата);



                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                            + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                            Thread.currentThread().getStackTrace()[2].getLineNumber());
                }

        return Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДата;
    }

//////

















    //////TODO вычисляем максимальную дату для СПИНЕРА ДЛЯ ВАДАПТЕРА AAARYADAPTER

    SQLiteCursor МетодКоторыйПоказываетМаксимальнуюДатуИзмененияДляСпинера() throws ExecutionException, InterruptedException {

        //////
         SQLiteCursor  Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДатаДляСпинера = null;
        ///


                try{
/*
                    Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДатаДляСпинера = new Class_MODEL_synchronized(КонтекстИсторииВсехТабелейВыбранных).КурсорУниверсальныйДляБазыДанных("tabels", new String[]
                                    {"month_tabels,year_tabels"},
                            "status_send!=?  AND date_update = (SELECT MAX(date_update) FROM tabels)",
                            new String[]{ "Удаленная"}, null, null, "date_update DESC", null);
///////*/



// TODO: 02.09.2021  получение данных по новому через новый движок



                    // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ
                    String ТаблицаНазваниеОбработки="tabel";
                    // TODO: 26.10.202


                    class_grud_sql_operationsДляАктивтиТабель= new Class_GRUD_SQL_Operations(getApplicationContext());
                    ///
                    class_grud_sql_operationsДляАктивтиТабель.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы",ТаблицаНазваниеОбработки);
                    ///////
                    class_grud_sql_operationsДляАктивтиТабель.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","month_tabels,year_tabels");
                    //
                    class_grud_sql_operationsДляАктивтиТабель.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика"," status_send!=?" +
                            "  AND date_update = (SELECT MAX(date_update)  AS MAX_D  FROM "+ ТаблицаНазваниеОбработки +") ");
                    ///"_id > ?   AND _id< ?"
                    //////
                    class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1","Удаленная");
                    ///
                  /*  class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","12");
                    //
                    class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3","13");////УсловиеПоискаv4,........УсловиеПоискаv5 .......*/

                    ////TODO другие поля

              ///classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
                    ////
                   /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки",null);
                    ////
                    class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC");
                    ////
                    //class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита",null);
                    ////
                    /// class_grud_sql_operations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита",null);
                    ////
                    PUBLIC_CONTENT         Class_Engine_SQLГдеНаходитьсяМенеджерПотоков = new PUBLIC_CONTENT (getApplicationContext());
                    // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
                    Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДатаДляСпинера=null;

                    Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДатаДляСпинера= (SQLiteCursor) class_grud_sql_operationsДляАктивтиТабель.
                            new GetData(getApplicationContext()).getdata(class_grud_sql_operationsДляАктивтиТабель.
                            concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

                    Log.d(this.getClass().getName(), "GetData " +Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДатаДляСпинера );


                    // TODO: 22.09.2021  если ПРИШЕЛ НУЛОЕЫВОЙ КУРСОР ПОПРОБУЕМ ЕЩЕ РАЗ



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


        return Курсор_КоторыйЗагружаетГотовыеТабеляМаксимальнаяДатаДляСпинера;
    }
















     void МетодКогдаДанныхСамихТабелйНет() {
        try{
            ТабелявВидеКнопок = new Button(this);////СОЗДАЕМ НОВЫЕ КНОПКИ НА АКТИВТИ

            try {
                LinearLayoutСозданныхТабелей.removeAllViews();
            } catch (Exception e) {
               // e.printStackTrace();
            }
            //

                ///
                ТабелявВидеКнопок.setTag("*В этом месяце нет Табеля  " +"(создайте).*");

                ТабелявВидеКнопок.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                ТабелявВидеКнопок.setMinLines(10);

                ТабелявВидеКнопок.setTextSize(14);

                ТабелявВидеКнопок.setText("*В этом месяце нет Табеля  " +"(создайте).*");

                ТабелявВидеКнопок.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

                ТабелявВидеКнопок.setTextColor(Color.RED);//parseColor("#00ACC1"));

                ТабелявВидеКнопок.setHintTextColor(Color.RED);
                ////
                ТабелявВидеКнопок.setBackground(this.getResources().getDrawable(R.drawable.textlines_tabel_row));
                //////ДОБАЯЛЕМ СТРОЧКУ
            // TODO: 31.01.2022

            МассивДляВыбораВСпинерДата=new LinkedList<>();
// Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
            ArrayAdapter<String> АдаптерДляСпинераДата = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, МассивДляВыбораВСпинерДата);
            // Определяем разметку для использования при выборе элемента
            АдаптерДляСпинераДата.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


            if (СпинерВыборДату!=null) {
                // Применяем адаптер к элементу spinner
                СпинерВыборДату.setAdapter(АдаптерДляСпинераДата);

                АдаптерДляСпинераДата.notifyDataSetChanged();

                СпинерВыборДату.forceLayout();
            }

////////унопки распологаем внутири скролбар
                ((Activity) КонтекстИсторииВсехТабелейВыбранных).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ////////унопки распологаем внутири скролбара
                        LinearLayoutСозданныхТабелей.addView(ТабелявВидеКнопок); /////СОЗДАЕМ НАКШИ КНОПКИ ВНУРИ СКРОЛБАРА



                    }});


            ///////
        } catch (Exception e) {
            e.printStackTrace();
///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }































    /////МЕТОД СОЗДАНИЕ ДАТЫ И КАЛЕНДАРЯ
    /////МЕТОД СОЗДАНИЕ ДАТЫ И КАЛЕНДАРЯ
    /////МЕТОД СОЗДАНИЕ ДАТЫ И КАЛЕНДАРЯ
    /////МЕТОД СОЗДАНИЕ ДАТЫ И КАЛЕНДАРЯ

    private void МетодСозданиеДиалогаКалендаряДаты() {///////метод создание календяря даты
/////TODO тут визуализикуеться КАЛЕНДАРЬ
        try{

            ////


            final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", new Locale("ru"));
            ///////
            Calendar newDate = Calendar.getInstance();

            DatePickerDialog ДатаДляКалендаря = new DatePickerDialog(this, android.R.style.Theme_Holo_Panel , new DatePickerDialog.OnDateSetListener() {////Theme_Holo_Dialog_MinWidth  //Theme_Holo_Panel

                public void onDateSet(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    newDate.set(year, monthOfYear, dayOfMonth);
                   // newDate.set(year, monthOfYear, dayOfMonth);
                    Log.d(this.getClass().getName(), " ПолученноеЗначениеИзТолькоСпинераДата " + ПолученноеЗначениеИзТолькоСпинераДата);

                    try {

                    String ФинальныйПолученаяДата=DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(newDate.getTime());


                    Log.d(this.getClass().getName()," year " +year+" month " +monthOfYear+" dayOfMonth " +dayOfMonth  +  "  ФинальныйПолученаяДата " +ФинальныйПолученаяДата);

                    // TODO: 22.09.2021 после того как мы получил даты запускаме сомо приложения






                        String МесяцИзКолендаря = String.valueOf(monthOfYear + 1);////ТЕКУЩИЙ МЕСЯЦ ИЗ КАЛЕНДАРЯ






                        if (МесяцИзКолендаря.length() == 2) {

                            ПолученноеЗначениеИзСпинераДата = dayOfMonth + "-" + МесяцИзКолендаря + "-" + year;////ДАННОЕ ЗНАЧЕНИЕ ПЕРЕДАЕМ НА ВСЕ ПРОГРАММУ В ДАЛЬНЕЙШЕМ
                            Log.d(this.getClass().getName(), " ПолученноеЗначениеИзСпинераДата" + ПолученноеЗначениеИзСпинераДата);
                        } else {
                            ПолученноеЗначениеИзСпинераДата = dayOfMonth + "-" + "0" + МесяцИзКолендаря + "-" + year;////ДАННОЕ ЗНАЧЕНИЕ ПЕРЕДАЕМ НА ВСЕ ПРОГРАММУ В ДАЛЬНЕЙШЕМ
                            Log.d(this.getClass().getName(), " ПолученноеЗначениеИзСпинераДата" + ПолученноеЗначениеИзСпинераДата);
                        }

                        Date ПрасингДаты = new Date();



                        //   TimeUnit.MILLISECONDS.sleep(200);


                        if (ПолученноеЗначениеИзСпинераДата!=null) {
                            ////////
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                                ПрасингДаты = new android.icu.text.SimpleDateFormat("dd-MM-yyyy", new Locale("ru")).parse(ПолученноеЗначениеИзСпинераДата);

                            }else {

                                ПрасингДаты = new SimpleDateFormat("dd-MM-yyyy", new Locale("ru")).parse(ПолученноеЗначениеИзСпинераДата);


                            }
                            Log.d(this.getClass().getName()," ПрасингДаты " +ПрасингДаты.toString());


                            ///////получаем значение месца на руском через метод дата
                            ПолученноеЗначениеИзТолькоСпинераДата = МетодПереводаНазваниеМесяцаСАнглискогоНаРУсский(ПрасингДаты);

                            Log.d(this.getClass().getName(), " ПолученноеЗначениеИзТолькоСпинераДата " + ПолученноеЗначениеИзТолькоСпинераДата);

                            /////вАЖНО ЗАПИСЫВАЕМ ОБРАТНО В СПИНЕР НА РАБОЧИЙ СТОЛ АКТИВТИ НАПРИМЕР НОВЫЙ МЕСЯЦ  ОКТЯБРЬ 2020 ГОДА НАПРИМЕР

                            Log.d(this.getClass().getName(),"  ПолученноеЗначениеИзСпинераДата" + ПолученноеЗначениеИзСпинераДата);
                        }


/////////////ТУТ КРУТИМ ВЕСЬ КУРСОР  И ПЫТАЕМСЯ НАЙТИ ЗНАЧЕНИЕ ВНЕМ  И ПО РЕЗУЛЬТАТ ЗАПОЛЯЕМ ЕГО В STRINGBUGGER
                        ////TODO ТУТ МЫ КРУТИМ ВЕСЬ СПИНЕР В КОТРЫЙ ИЗ БАЗЫ ЗАГРУЗИЛОСЬ ВСЕ СОЗДАННЫЕ МЕСЯЦА ИМЫ ПРОВЕРЕМ ЕЛСИ ТАКОМ МЕСЯЦ ЕЩН ИЛИ НЕТ



                        StringBuffer ИщемУжеСозданныйМЕсяц=new StringBuffer();

                        if (СпинерВыборДату!=null) {

                            for (int ИндексСуществуюЩимМесяц=1;ИндексСуществуюЩимМесяц<СпинерВыборДату.getCount();ИндексСуществуюЩимМесяц++){

                                ////todo ДА ПРОСТО ЗАПОЛЯНЕМ БУФЕР УЖЕ СОЗДАННЫМИ МЕСЯЦАМИ В СПИНЕРЕ
                                ИщемУжеСозданныйМЕсяц.append(СпинерВыборДату.getItemAtPosition(ИндексСуществуюЩимМесяц).toString()).append("\n");

                                Log.d(this.getClass().getName()," ИщемУжеСозданныйМЕсяц " +ИщемУжеСозданныйМЕсяц.toString()+"\n");

                            }
                        }else{
                               if(ПолученноеЗначениеИзТолькоСпинераДата!=null){

                                   //
                                   ИщемУжеСозданныйМЕсяц.append(ПолученноеЗначениеИзТолькоСпинераДата)  ;
                               }else {

                                   Toast.makeText(getApplicationContext(), " Нет месяца для создание Табеля !!! ", Toast.LENGTH_LONG).show();
                               }

                        }



                        ///// todo ТУТ ВСТАВЛЯЕМ ММЕСЯЦА УКТОРГНО НЕТ ЕШЕ


                        Log.d(this.getClass().getName()," ИщемУжеСозданныйМЕсяц " +ИщемУжеСозданныйМЕсяц.toString()+"\n"+ " ПолученноеЗначениеИзТолькоСпинераДата " +ПолученноеЗначениеИзТолькоСпинераДата);

                        // TODO: 26.10.2021 метод создания новго табеля

                        МетодВставкиНовогоМесяцавТабельКоторогоНет(ИщемУжеСозданныйМЕсяц);



                    ////
                } catch (Exception e) {
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                            Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                }


                }

            }, newDate.get(Calendar.YEAR), newDate.get(Calendar.MONTH), newDate.get(Calendar.DAY_OF_MONTH));
//        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);


            // TODO: 22.09.2021
            ДатаДляКалендаря.setTitle("Календарь");
            
            ДатаДляКалендаря.show();


        //////////////////////

            Log.d(this.getClass().getName(), " ПолученноеЗначениеИзТолькоСпинераДата " + ПолученноеЗначениеИзТолькоСпинераДата);
        ////
    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
    }



























    //////////
//TODO метод который и создает календарь после нажатие на кнопку ОК

/*
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        try{

           /// МетодСозданиеДиалогаКалендаряДаты();

       Calendar calendar=Calendar.getInstance();
       ///
            calendar.set(Calendar.YEAR,year);
            ///
            calendar.set(Calendar.MONTH,month);
            ///
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            /////
            String ФинальныйПолученаяДата=DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(calendar.getTime());


            Log.d(this.getClass().getName()," year " +year+" month " +month+" dayOfMonth " +dayOfMonth  +  "  ФинальныйПолученаяДата " +ФинальныйПолученаяДата);



        String МесяцИзКолендаря = String.valueOf(month + 1);////ТЕКУЩИЙ МЕСЯЦ ИЗ КАЛЕНДАРЯ


            ПолученноеЗначениеИзСпинераДата=null;



        if (МесяцИзКолендаря.length() == 2) {

            ПолученноеЗначениеИзСпинераДата = dayOfMonth + "-" + МесяцИзКолендаря + "-" + year;////ДАННОЕ ЗНАЧЕНИЕ ПЕРЕДАЕМ НА ВСЕ ПРОГРАММУ В ДАЛЬНЕЙШЕМ
            Log.d(this.getClass().getName(), " ПолученноеЗначениеИзСпинераДата" + ПолученноеЗначениеИзСпинераДата);
        } else {
            ПолученноеЗначениеИзСпинераДата = dayOfMonth + "-" + "0" + МесяцИзКолендаря + "-" + year;////ДАННОЕ ЗНАЧЕНИЕ ПЕРЕДАЕМ НА ВСЕ ПРОГРАММУ В ДАЛЬНЕЙШЕМ
            Log.d(this.getClass().getName(), " ПолученноеЗначениеИзСпинераДата" + ПолученноеЗначениеИзСпинераДата);
        }

        Date ПрасингДаты = new Date();



       //   TimeUnit.MILLISECONDS.sleep(200);


            if (ПолученноеЗначениеИзСпинераДата!=null) {
                ////////
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                    ПрасингДаты = new android.icu.text.SimpleDateFormat("dd-MM-yyyy", new Locale("ru")).parse(ПолученноеЗначениеИзСпинераДата);

                }else {

                    ПрасингДаты = new SimpleDateFormat("dd-MM-yyyy", new Locale("ru")).parse(ПолученноеЗначениеИзСпинераДата);


                }
                Log.d(this.getClass().getName()," ПрасингДаты " +ПрасингДаты.toString());


                ///////получаем значение месца на руском через метод дата
                ПолученноеЗначениеИзТолькоСпинераДата = МетодПереводаНазваниеМесяцаСАнглискогоНаРУсский(ПрасингДаты);

                Log.d(this.getClass().getName(), " ПолученноеЗначениеИзТолькоСпинераДата " + ПолученноеЗначениеИзТолькоСпинераДата);

                /////вАЖНО ЗАПИСЫВАЕМ ОБРАТНО В СПИНЕР НА РАБОЧИЙ СТОЛ АКТИВТИ НАПРИМЕР НОВЫЙ МЕСЯЦ  ОКТЯБРЬ 2020 ГОДА НАПРИМЕР

                Log.d(this.getClass().getName(),"  ПолученноеЗначениеИзСпинераДата" + ПолученноеЗначениеИзСпинераДата);
            }


/////////////ТУТ КРУТИМ ВЕСЬ КУРСОР  И ПЫТАЕМСЯ НАЙТИ ЗНАЧЕНИЕ ВНЕМ  И ПО РЕЗУЛЬТАТ ЗАПОЛЯЕМ ЕГО В STRINGBUGGER
        ////TODO ТУТ МЫ КРУТИМ ВЕСЬ СПИНЕР В КОТРЫЙ ИЗ БАЗЫ ЗАГРУЗИЛОСЬ ВСЕ СОЗДАННЫЕ МЕСЯЦА ИМЫ ПРОВЕРЕМ ЕЛСИ ТАКОМ МЕСЯЦ ЕЩН ИЛИ НЕТ



        StringBuffer ИщемУжеСозданныйМЕсяц=new StringBuffer();

        if (СпинерВыборДату!=null) {

            for (int ИндексСуществуюЩимМесяц=0;ИндексСуществуюЩимМесяц<СпинерВыборДату.getCount();ИндексСуществуюЩимМесяц++){

                ////todo ДА ПРОСТО ЗАПОЛЯНЕМ БУФЕР УЖЕ СОЗДАННЫМИ МЕСЯЦАМИ В СПИНЕРЕ
                ИщемУжеСозданныйМЕсяц.append(СпинерВыборДату.getItemAtPosition(ИндексСуществуюЩимМесяц).toString()).append("\n");

                Log.d(this.getClass().getName()," ИщемУжеСозданныйМЕсяц " +ИщемУжеСозданныйМЕсяц.toString()+"\n");

            }
        }




        ///// todo ТУТ ВСТАВЛЯЕМ ММЕСЯЦА УКТОРГНО НЕТ ЕШЕ



            МетодВставкиНовогоМесяцавТабельКоторогоНет(ИщемУжеСозданныйМЕсяц);








    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
    }
*/






////TODO СОЗДАНИЯ КАЛЕНДАРЯ С ПОЛУЧЕННЫМИ УЖЕ ДАННЫМИ
    private void МетодВставкиНовогоМесяцавТабельКоторогоНет(StringBuffer ищемУжеСозданныйМЕсяц) throws ParseException {
        ///////ПРОВЕРКА НЕ ВЫБРАЛИ ЛИ МЫ МЕСЯЦ КОТОРЫЙ УЖЕ СУЩЕТСВУЕТ

        try{

        Log.d(this.getClass().getName()," ПолученноеЗначениеИзТолькоСпинераДата " +ПолученноеЗначениеИзТолькоСпинераДата);

        StringBuffer МЕсяцСЗакглавнойБуквы =new StringBuffer(ПолученноеЗначениеИзТолькоСпинераДата.toLowerCase());

        ПолученноеЗначениеИзТолькоСпинераДата= МЕсяцСЗакглавнойБуквы.substring(0, 1).toUpperCase() + МЕсяцСЗакглавнойБуквы .substring(1).toLowerCase();

        Log.d(this.getClass().getName()," МЕсяцСЗакглавнойБуквы " +ПолученноеЗначениеИзТолькоСпинераДата);
        ///проверяем не тот же самый месяц выбран был ///ЕСЛИ ВЕРНУЛ -1 ТО ТАКОГО МЕСЯЦА ЕЩЕ НЕТ И НАДО ЕГО СОЗДАТЬ

        //TODO ВАЖНО ОПРЕДЕЛЯЕМ ВСТАЛЯТЬ ИЛИ НЕ ВСТАЛЯТЬ МЕСЯЦ ЕСЛИ НИЖЕ В IF ВЕРНУЛАСЬ ЦИФРА -1 ТО ТАКОГО МЕСЯЦА НЕТ И НАДО ВСТАЛЯТЬ,
        // TODO ЕСЛИ ПРИШЛА ПОЛОЖИТЕЛЕЛЬАЯ ЦИФРА ТО ТАКОЙ МЕСЯЦ УЖЕ ЕСТЬ НЕ НАДО ВСТАЛЯТЬ


        ////ЗАПОЛЕНИЕ СПИНЕРА ТОЛЬКО ЕСЛИ ТАКОГО МЕСЯЦА ЕЩЕ НЕТ
        //////ВАЖГНО ЗАПОЛЕНИЕ СПИНЕРА СДЕСЬ КА КТЕКС ДОБАВЛЕНИЕ МЕСЯЦА , СЕНТЯБРЬ ОКТЯБРЬ НОЯБРЬ


            ////////
            ContentValues АдаптерВставкаНовогоМЕсяцаИзКалендаря = new ContentValues();////контрейнер для нового табеля
            ////////заполение контейнера данными новго табеля
            // /TODO перердаваемые три згначение в следующее активти // -- ФинальнаяМЕсяцДляНовогоТабеля // ПолученныйГодДляНовогоТабеля // -ПолученноеЗначениеИзТолькоСпинераДата
            ///TODO вставляемый контент
            int ДляВставкиНовогоМесяцаНазвание = МетодПолучениниеНовогоМесяцДляЗАписивОднуКолонку(ФинальнаяМЕсяцДляНовогоТабеля);
////
            int ДляВставкиНовогоГодНазвание = МетодПолучениниеНовыйГодДляЗАписивОднуКолонку(ПолученныйГодДляНовогоТабеля);

///TODO  заполянем контейнер новыми данными новый месяц и новый год
      /*          АдаптерВставкаНовогоМЕсяцаИзКалендаря.put("month_tabels",ДляВставкиНовогоМесяцаНазвание);
                АдаптерВставкаНовогоМЕсяцаИзКалендаря.put("year_tabels",ДляВставкиНовогоГодНазвание  );
                АдаптерВставкаНовогоМЕсяцаИзКалендаря.put("date_update",ГлавнаяДатаИВремяДляТабеля() );

////
                Log.d(this.getClass().getName()," ДляВставкиНовогоМесяцаНазвание " +ДляВставкиНовогоМесяцаНазвание+ " ДляВставкиНовогоГодНазвание " +ДляВставкиНовогоГодНазвание);
                //////
                long РезультатВставкиНовогоМесяцаСозданогоИзКалендаря= 0;
                try {
                  РезультатВставкиНовогоМесяцаСозданогоИзКалендаря = new Class_MODEL_synchronized(getApplication()).ВставкаДанныхЧерезКонтейнерУниверсальная("tabels",
                            АдаптерВставкаНовогоМЕсяцаИзКалендаря,"tabels","",true);

                   ///ОЧИСТКА ПАМЯТИ
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }*/
            /// после вствки в базу обнуляем контейнер данные от сервера

            ///todo ПОКАЗЫВАЕМ ЧТО ПРОШЛАУ СПЕШНО ОПЕРВЦИЯ
            ///PUBLIC_CONTENT.КоличествоУспешныхВставки++;////ПРИ УСПЕШНОЙ ВСТАВКИ ДАННЫХ  ПЕРЕДАЕМ СТАТИЧНОМУ СЁЧИКК  ОБНОВЛЕНИЙ ЧТО НАДО УВЕЛИЧИТ ЗНАЧЕНИЕ НА 1+

            //TODO тут КОД НАЧИНАЕТ РАБОТЬ КОГДА УКАЗАННЫЙ МЕСЯЦ УЖЕ СТЬ И МЫ В КАЛЕНДАРИ ВЫБРАЛИ МЕСЯЦ КОТОРФЙ УЖЕ ЕСТЬ И ЕГО СОЗДАВАТЬ НЕ НАДО И МЫ СРАЗУ ПЕРЕХОДИМ НА СОЗАЛНИЕ ЕЩЕ ОДНОГО ТАБЕЛЕЯ НА МЕСЯЦ


            ////ПОСЛЕ ВССТАВКИ ЗАПУСКАЕМ АКТИВТИ ЧТОБЫ ПЕРЕЙТИ НА СОЗАННУЮ




            ///TODO  ПОСЛЕ ВСТАКИ ПЕРЕХОДИМ НА АКТИВТИ С ВЫБОРО И СОЗДАНИЕМ САМОГО ТАБЕЛЯ НОВОГО
            Intent Интент_ЗапускСозданиеНовогоТабельногоУчетавТаблицуИстория = new Intent();

            Интент_ЗапускСозданиеНовогоТабельногоУчетавТаблицуИстория.setClass(getApplicationContext(), MainActivity_New_Tabely.class); // ТУТ ЗАПВСКАЕТЬСЯ ВЫБОР ПРИЛОЖЕНИЯ
            // КОТОРЫЕ ЕСТЬ FACE APP НА ДАННЫЙ МОМЕТНТ РАЗРАБОТНАО ТАБЕЛЬНЫЙ УЧЁТ
            Интент_ЗапускСозданиеНовогоТабельногоУчетавТаблицуИстория.putExtra("ПолученноеЗначениеИзСпинераДата", ПолученноеЗначениеИзТолькоСпинераДата);

            Интент_ЗапускСозданиеНовогоТабельногоУчетавТаблицуИстория.putExtra("ПолученныйГодДляНовогоТабеля", String.valueOf(ДляВставкиНовогоГодНазвание));

            Интент_ЗапускСозданиеНовогоТабельногоУчетавТаблицуИстория.putExtra("ФинальнаяМЕсяцДляНовогоТабеля", String.valueOf(ДляВставкиНовогоМесяцаНазвание));

            ////
            // /TODO перердаваемые три згначение в следующее активти // -- ФинальнаяМЕсяцДляНовогоТабеля // ПолученныйГодДляНовогоТабеля // -ПолученноеЗначениеИзТолькоСпинераДата
            Log.d(this.getClass().getName(), "  ПолученноеЗначениеИзТолькоСпинераДата " + ПолученноеЗначениеИзТолькоСпинераДата +
                    " ПолученныйГодДляНовогоТабеля " + ПолученныйГодДляНовогоТабеля
                    + " ФинальнаяМЕсяцДляНовогоТабеля " + ФинальнаяМЕсяцДляНовогоТабеля);
            ///TODO ПОСЛЕ ОТПРОВКИ ДАННЫХ ЧИСТИМ ПЕРЕМЕНЕЫ

            ////
        Интент_ЗапускСозданиеНовогоТабельногоУчетавТаблицуИстория.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(Интент_ЗапускСозданиеНовогоТабельногоУчетавТаблицуИстория);

            ////
          // finish();

            // ВЫБОРА ИЛИ СОЗДАНИЕ МАКЕТА ТАБЕЛЯ СПРАВИШАЕМ НУЖНА ЛИ СОЗДАТЬ ТАБЕЛЬ НА ЛРУГОМ АКТТИВИТИ
            //////спрашиваем пользователя хочел ли он создать табель
            ////СООБЩЕНИЕ ИЗ ИТОРИИИ ТАБЛЕЙ ОТПРАВЛЯЕМ СООБЩЕНЕИ И ЗНАЧЕНИЕ В ДУГОЕ АКТИВТИ О СОЗДАНИЮ НОВОГО ТАБЕЛЯ И ПЛЮС ТУТ ПЕРЕДАЕМ ПОЛУЧЕННОЕ ЗНАЧЕНИЕ НОВОГО МЕСЯЦ
            // finish();
            ///TODO очищаем память
            if (АдаптерВставкаНовогоМЕсяцаИзКалендаря!=null) {
                АдаптерВставкаНовогоМЕсяцаИзКалендаря.clear();//
            }
            ПолученныйГодДляНовогоТабеля = "";
            ФинальнаяМЕсяцДляНовогоТабеля = "";


    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///


    }

        }






    //TODO метод получени месяа для записи в одну колонку

    private int  МетодПолучениниеМесяцДляЗАписивОднуКолонку(String ДатаКоторуюНадоПеревестиИзТекставЦифру) throws ParseException {
        System.out.println( " " + ДатаКоторуюНадоПеревестиИзТекставЦифру + " " +ДатаКоторуюНадоПеревестиИзТекставЦифру);
        int month=0;
        try{
        SimpleDateFormat formatмесяц = new SimpleDateFormat("LLLL  yyyy");
        Date date = formatмесяц .parse(ДатаКоторуюНадоПеревестиИзТекставЦифру);
        Calendar calendar = Calendar.getInstance(new Locale("ru"));
        calendar.setTime(date);
        Calendar calendar2 = new GregorianCalendar();
        calendar.setTime(date );
        month = calendar.get(Calendar.MONTH) + 1;



    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///


    }


        return   month;
    }

    //TODO метод получени месяа для записи в одну колонку

    private int  МетодПолучениниеГОдДляЗАписивОднуКолонку(String ДатаКоторуюНадоПеревестиИзТекставЦифру) throws ParseException {
        System.out.println( "ДатаКоторуюНадоПеревестиИзТекставЦифру " +ДатаКоторуюНадоПеревестиИзТекставЦифру);
        int year=0;
        try{
        SimpleDateFormat formatгод = new SimpleDateFormat("LLLL  yyyy");
        Date date = formatгод.parse(ДатаКоторуюНадоПеревестиИзТекставЦифру);
        Calendar calendar = Calendar.getInstance(new Locale("ru"));
        calendar.setTime(date);
            year  = calendar.get(Calendar.YEAR);


    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///


    }
        return   year ;
    }

////TODO МЕТОД ТОЛЬКО ДЛЯ ВСТВКИ НОВОГО МЕСЯЦА и ГОД НОВЫЙ

















    private int  МетодПолучениниеНовогоМесяцДляЗАписивОднуКолонку(String ДатаКоторуюНадоПеревестиИзТекставЦифру) throws ParseException {
        System.out.println( " " + ДатаКоторуюНадоПеревестиИзТекставЦифру + " " +ДатаКоторуюНадоПеревестиИзТекставЦифру);
        int month=0;
        try{
        SimpleDateFormat formatмесяц = new SimpleDateFormat("LLLL");
        Date date = formatмесяц .parse(ДатаКоторуюНадоПеревестиИзТекставЦифру);
        Calendar calendar = Calendar.getInstance(new Locale("ru"));
        calendar.setTime(date);
        month = calendar.get(Calendar.MONTH) + 1;


    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///


    }
        return   month;
    }

    private int  МетодПолучениниеНовыйГодДляЗАписивОднуКолонку(String ДатаКоторуюНадоПеревестиИзТекставЦифру) throws ParseException {
        System.out.println( "ДатаКоторуюНадоПеревестиИзТекставЦифру " +ДатаКоторуюНадоПеревестиИзТекставЦифру);

        int year=0;
        try{
        SimpleDateFormat formatгод = new SimpleDateFormat("yyyy");
        Date date = formatгод.parse(ДатаКоторуюНадоПеревестиИзТекставЦифру);
        Calendar calendar = Calendar.getInstance(new Locale("ru"));
        calendar.setTime(date);
        Calendar calendar2 = new GregorianCalendar();
        calendar.setTime(date );
      year = calendar.get(Calendar.YEAR);


    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///


    }
        return   year ;
    }





    //TODO метод получени года для записи в одну колонку

    private String МетодПолучениниеГодаДляЗАписивОднуКолонку(String ДатаКоторуюНадоПеревестиИзТекставЦифру) throws ParseException {
        //
        String Год = null;
try{
        int ИщемЕслиПробелВДате=ДатаКоторуюНадоПеревестиИзТекставЦифру.indexOf(" ");

        StringBuffer ИщемГод=new StringBuffer(ДатаКоторуюНадоПеревестиИзТекставЦифру);

         Год=  ИщемГод.substring(ИщемЕслиПробелВДате,ИщемГод.length());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy", new Locale("ru"));

        Date date = formatter.parse(Год);

        System.out.println(date);

        System.out.println(formatter.format(date));


    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        ///


    }
        return   Год;
    }



    //TODO метод получени года для записи в одну колонку






    //////TODO МЕТОД ПЕРВЫЙ ПРИ ПРОСМОТРЕ КАКЕИ ТАБЕЛЯ ВООБЩЕ ЕСТЬ
    private void МетодЗаполненияАлайЛИстаНовымМЕсцевНовогоТабеля() throws InterruptedException, ExecutionException, TimeoutException, ParseException {

        try{





// TODO вытасиваем даные из базы чтобы ЗАполнить спирер готовыми табелями Датами НАПРИМЕР ОКТЯРЬ 2020  ДЕКАБРЬ 2019

Cursor Курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля=null;






//////////TODO
            Курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля = new Class_MODEL_synchronized(КонтекстИсторииВсехТабелейВыбранных).
                    МетодЗагружаетЗначенияНовгоСотрудника(КонтекстИсторииВсехТабелейВыбранных);

//
                    //// МесяцМаскимальнаяДатавТабеляхПоМесецям

            Log.d(this.getClass().getName(), " Курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля"
                    +" время: "
                    +Курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля);

            // TODO: 16.05.2021 запоеления данных

            String ЗначениеДляЗаполенияСпинера= "";
            int   IDДляЗаполенияСпинера;


            if (Курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.getCount()>0) {
////////
                МетодЗаполенияТабелямиАктивти(Курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля);


                ///////////////todo закрываем курсор для заполения данными АКайлиста ЗАКРЫВАЕМ
                Курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.close();
            }else{
                //////

                Log.d(this.getClass().getName(), " СЛУЖБА УВЕДОМЛЕНИЯ В ПОТОКЕ Scheduled  .......(ожидание 30 секунд ожидания внутри потока Scheduled  ) "
                        +" время: "
                        +new Date());



            }


          /*  List<String> names = Arrays.asList("John", "Arya", "Sansa");
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                ArrayList<String> upperCaseNames = names.stream().collect(Collectors.toCollection(ArrayList::new));
            }
*/



            ///
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), 
       this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }





    private void МетодЗаполенияТабелямиАктивти(Cursor курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля) throws ExecutionException, InterruptedException, ParseException {



        if ( курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.getCount()>0) {/////ЗАГРУЖАЕМ ДАННЫЕ ИЗ ТАБЛИЦЫ CFO ДЛЯ СПИНЕРА И СОЗДАНИЯ ТАБЕЛЯ
            //TODO ЧТО В КУРСОРЕ
            if (курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.getCount()>0) {
                Log.d(this.getClass().getName()," Курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.getCount() " + курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.getCount());
                ///TODO очищаем арайлист
                //МассивДляВыбораВСпинерДата.clear();
                курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.moveToFirst();
            }

            //////TODO ЗАПОЛЯЕМ СПИНЕР ЧЕРЕЗ АРАЙЛИСТ ПОСЛЕДНИМИ ДАТАМИ

            МассивДляВыбораВСпинерДата.clear();





            ////первый элемент в спинре

            do{
                ///


                ///////вытаскиваем данные из базы столбкик ЗАПОЛЕНИЕ ХЕША

                String     ЗнаениеИзБазыНовыеТабеляМесяц = курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.getString(0).trim();

                String     ЗнаениеИзБазыНовыеТабеляГод = курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.getString(1).trim();

               // String     ЗнаениеИзБазыНовыеТабеляНазваниеТабеля = курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.getString(2).trim();
                String     ЗнаениеИзБазыНовыеТабеляНазваниеТабеля = null;

                int ИндексСФО=курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.getColumnIndex("cfo");

                int     ЗнаениеИзБазыНовыеТабеляIDСфо = курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.getInt(ИндексСФО);

// TODO: 10.06.2021



                ПолученнаяUUIDНазванияОрганизации=0l;

                ПолученнаяUUIDНазванияОрганизации=Long.parseLong(String.valueOf(ЗнаениеИзБазыНовыеТабеляIDСфо));

                Log.d(this.getClass().getName()," ЗнаениеИзБазыНовыеТабеляМесяц " +ЗнаениеИзБазыНовыеТабеляМесяц +"  ЗнаениеИзБазыНовыеТабеляГод " +ЗнаениеИзБазыНовыеТабеляГод
                        +" ЗнаениеИзБазыНовыеТабеляIDСфо" +ЗнаениеИзБазыНовыеТабеляIDСфо + " ПолученнаяUUIDНазванияОрганизации " +ПолученнаяUUIDНазванияОрганизации);



        String ЗнаениеИзБазыНовыеТабеляНазваниеТабеляВнутри=null;
                // TODO: 19.05.2021 если нет названеи Табеля то выислчем его пото ID сфо


 try {





     // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ


     class_grud_sql_operationsДляАктивтиТабель= new Class_GRUD_SQL_Operations(getApplicationContext());
     ///
     class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","cfo");
     ///////
     class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","name");
     //
     class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика"," id =?");
     ///"_id > ?   AND _id< ?"
     //////
     class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",ЗнаениеИзБазыНовыеТабеляIDСфо);
     ///
             /*       concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска2","12");
                    //
                    concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска3","13");////УсловиеПоискаv4,........УсловиеПоискаv5 .......*/

     ////TODO другие поля

     /////classGrudSqlOperations. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ПоляГрупировки",null);
     ////
     ///  concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеГрупировки","date_update DESC");
     ////
     class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC");
     ////
     class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита","1");
     ////

     // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ
     SQLiteCursor Курсор_ВычисляемНазваниеТАбеляПоIDсфо =null;

     /////
     // TODO: 12.10.2021  Ссылка Менеджер Потоков

     PUBLIC_CONTENT  Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new PUBLIC_CONTENT (getApplicationContext());

     ///////

     Курсор_ВычисляемНазваниеТАбеляПоIDсфо= (SQLiteCursor)  class_grud_sql_operationsДляАктивтиТабель.
             new GetData(getApplicationContext()).getdata(class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
             Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

     Log.d(this.getClass().getName(), "GetData " +Курсор_ВычисляемНазваниеТАбеляПоIDсфо );





   /*  // TODO: 06.09.2021 _old

     Курсор_ВычисляемНазваниеТАбеляПоIDсфо = new Class_MODEL_synchronized(КонтекстИсторииВсехТабелейВыбранных).
               КурсорУниверсальныйБазыДанных("SELECT name FROM cfo WHERE id='"+ЗнаениеИзБазыНовыеТабеляIDСфо+"' LIMIT 1");


*/



     
     // TODO: 06.09.2021  результат

                if (Курсор_ВычисляемНазваниеТАбеляПоIDсфо.getCount()>0){
                    ///
                    Курсор_ВычисляемНазваниеТАбеляПоIDсфо.moveToFirst();
                    ////
                 ЗнаениеИзБазыНовыеТабеляНазваниеТабеляВнутри=  Курсор_ВычисляемНазваниеТАбеляПоIDсфо.getString(0);
                 ///TODO результат

                    Log.d(this.getClass().getName(), "Запущен...ЗнаениеИзБазыНовыеТабеляНазваниеТабеляВнутри "+ЗнаениеИзБазыНовыеТабеляНазваниеТабеляВнутри);




                }


       /////
   } catch (Exception e) {///////ошибки
                    e.printStackTrace();
                    ///метод запись ошибок в таблицу

     Log.e(Class_MODEL_synchronized.class.getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
             " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
     // TODO: 01.09.2021 метод вызова
     new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
             this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
             Thread.currentThread().getStackTrace()[2].getLineNumber());
                }




                Log.d(this.getClass().getName()," ЗнаениеИзБазыНовыеТабеляНазваниеТабеля " +ЗнаениеИзБазыНовыеТабеляНазваниеТабеля);




                ////todo ПРЕОБРАЗОВАЫВЕМ ЦИФРВЫ В ДАТУ ВВИДЕТ ТЕКСТА ИБЛЬ АВГУСТ 2020 2021
                SimpleDateFormat ПереводимЦифруВТЕкстМЕсяца = new SimpleDateFormat("mm", new Locale("rus") );

                Date ДатаДляПолученияМесяцаСловом = ПереводимЦифруВТЕкстМЕсяца.parse(ЗнаениеИзБазыНовыеТабеляМесяц);

                String ПреобразованоеИмяМесяца= ПереводимЦифруВТЕкстМЕсяца.format( ДатаДляПолученияМесяцаСловом );

                Log.d(this.getClass().getName()," ПреобразованоеИмяМесяца " +ПреобразованоеИмяМесяца);


                ////////////////
                SimpleDateFormat formatмесяц = new SimpleDateFormat("MMyyyy", new Locale("ru"));

                Date date = formatмесяц.parse(ПреобразованоеИмяМесяца+ЗнаениеИзБазыНовыеТабеляГод);

                Calendar calendar = Calendar.getInstance(new Locale("ru"));
                calendar.setTime(date);
                System.out.println(calendar.get(Calendar.YEAR));
                System.out.println(calendar.get(Calendar.MONTH)+1);
                System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println(new SimpleDateFormat("LLLL").format(calendar.getTime()));
                ПреобразованоеИмяМесяца=new SimpleDateFormat("LLLL").format(calendar.getTime());


                StringBuffer stringBuffer=new StringBuffer(ПреобразованоеИмяМесяца);

                ПреобразованоеИмяМесяца=stringBuffer.substring(0,1).toUpperCase()+stringBuffer.substring(1,stringBuffer.length()).toLowerCase();

                //String месяцОбрантноТекстДляКурсора=   МетодПолучениеДатыИзЦифраВТекстДляКурсора(ЗнаениеИзБазыНовыеТабеляМесяц);
                String ФиналВставкаМЕсяцаИгода = "";
                ////TODO ПОКАЗЫВВАЕТ ПОЛЬЗОВАТЛЕЛЮ МЕСЯЦ И ГОДВ ВИДЕ СЛОВ ИЗ ЦИФРЫ 11 МЕНЯЕ НА НОЯБРЬ 2020 НАПРИМЕР
                ФиналВставкаМЕсяцаИгода=ПреобразованоеИмяМесяца+ "  "+ЗнаениеИзБазыНовыеТабеляГод;

                Log.d(this.getClass().getName()," ФиналВставкаМЕсяцаИгода "+ФиналВставкаМЕсяцаИгода);






                ///todo ТОЛЬКО ДЛЯ ПРОСМОТРА ДАННЫХ ПОЛЬЗОВТЕЛЯ ЗАГРУАЕТЬСЯ ИЗ БАЗЫ
                МассивДляВыбораВСпинерДата.add(ФиналВставкаМЕсяцаИгода);

                Log.d(this.getClass().getName(),"  МассивДляВыбораВСпинерДата " + МассивДляВыбораВСпинерДата.toString() +"  МассивДляВыбораВСпинерДата " +МассивДляВыбораВСпинерДата.size());
                ////////
            }while (курсор_ЗагружаетАрайдистЗначенийНовогоТИабеля.moveToNext());
            //todO УДАЛЕМ КУРСОР

/*

            //TODO метод праивльно возврящет дату в спиноре  на первоночальнуюс последней
            МетодВозвратаПравильногоДатыВСпиноре();*/






            ////todo данный ко дпрказывает что на текущего польоватлея пока нет не обного табеля
        }


    }






    ////СООБЩЕНИЕ ИЗ ИТОРИИИ ТАБЛЕЙ ОТПРАВЛЯЕМ СООБЩЕНЕИ И ЗНАЧЕНИЕ В ДУГОЕ АКТИВТИ О СОЗДАНИЮ НОВОГО ТАБЕЛЯ






    ////ВТОРАЯ ФУНКЦИЯ  ДАТЫ НА РУСКИЙ ЯЗЫК МЕСЯЦ
    //функция получающая время операции

    public String МетодПереводаНазваниеМесяцаСАнглискогоНаРУсский(Date ПрасингДаты) {
        SimpleDateFormat sdfmt = null;
        SimpleDateFormat sdfmtГод = null;
        String ДатаДляСпинераИМеняемАнглискиеНаРУскиеНазваниеМесяцев;
        String ФинальнаяДатаДЛяОпределенияНовыйЭтоМесяцИлиНЕт;
        sdfmt = new SimpleDateFormat("LLLL", new Locale("ru"));
        ФинальнаяМЕсяцДляНовогоТабеля=sdfmt.format(ПрасингДаты);
        Log.d(this.getClass().getName(),"  ФинальнаяМЕсяцДляНовогоТабеля  "+ ФинальнаяМЕсяцДляНовогоТабеля);

        ///////МЕНЯЕМ АГЛИСКИЕ НА РУСКОЕ НАЗВАНИЕМЕСЯЦА
        ДатаДляСпинераИМеняемАнглискиеНаРУскиеНазваниеМесяцев=sdfmt.format(ПрасингДаты);////ПЕРВОНОЧАЛЬНОЕ ВИД МЕСЯЦ НА АНГЛИСКОМ
        ДатаДляСпинераИМеняемАнглискиеНаРУскиеНазваниеМесяцев= ДатаДляСпинераИМеняемАнглискиеНаРУскиеНазваниеМесяцев;
        Log.d(this.getClass().getName(),"  ДатаДляСпинераИМеняемАнглискиеНаРУскиеНазваниеМесяцев  "+ДатаДляСпинераИМеняемАнглискиеНаРУскиеНазваниеМесяцев);
        ///////Добалявем год
        sdfmtГод = new SimpleDateFormat("yyyy", new Locale("ru"));
        ПолученныйГодДляНовогоТабеля=sdfmtГод.format(ПрасингДаты);
        System.out.println("  операции время :  " + sdfmtГод.format(ПрасингДаты));
        ФинальнаяДатаДЛяОпределенияНовыйЭтоМесяцИлиНЕт=ФинальнаяМЕсяцДляНовогоТабеля+"  "+ПолученныйГодДляНовогоТабеля;
        System.out.println("  ФинальнаяДатаДЛяОпределенияНовыйЭтоМесяцИлиНЕт  " + ФинальнаяДатаДЛяОпределенияНовыйЭтоМесяцИлиНЕт);
////////свич пробегаеться по названиям месяцев и перерделываем их с аглиского на русский
        return  ФинальнаяДатаДЛяОпределенияНовыйЭтоМесяцИлиНЕт;
    }



    //TODO метод получени месяа для записи в одну колонку ОБРАБОТКА ДАТЫ ДЛЯ КУРСОРА НЕ НОВЫЕ ДАННЫЕ А УЖЕ СУЩЕТСВУЮЩИЕ--МЕСЯЦ

    private int  МетодПолучениниеКурсораМЕсяцДата(String ДатаКоторуюНадоПеревестиИзТекставЦифру) throws ParseException {
        String[] ДелимМЕсяцИгод =ДатаКоторуюНадоПеревестиИзТекставЦифру.split(" ");
        System.out.println( " " + ДелимМЕсяцИгод [0]);
        SimpleDateFormat formatмесяц = new SimpleDateFormat("LLLL  yyyy", new Locale("ru"));
        Date date = formatмесяц.parse(ДатаКоторуюНадоПеревестиИзТекставЦифру.trim());
        Calendar calendar = Calendar.getInstance(new Locale("ru"));
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(new SimpleDateFormat("MMMM").format(calendar.getTime()));
        return   calendar.get(Calendar.MONTH)+1;
    }
    //TODO метод получени месяа для записи в одну колонку ОБРАБОТКА ДАТЫ ДЛЯ КУРСОРА НЕ НОВЫЕ ДАННЫЕ А УЖЕ СУЩЕТСВУЮЩИЕ--ГОД
    private int  МетодПолучениниеКурсораГОДДата(String ДатаКоторуюНадоПеревестиИзТекставЦифру) throws ParseException {
        String[] ДелимМЕсяцИгод =ДатаКоторуюНадоПеревестиИзТекставЦифру.split(" ");
        System.out.println( " " + ДелимМЕсяцИгод [1]);
        SimpleDateFormat formatгод = new SimpleDateFormat("LLLL  yyyy");
        Date date = formatгод.parse(ДатаКоторуюНадоПеревестиИзТекставЦифру.trim());
        Calendar calendar = Calendar.getInstance(new Locale("ru"));
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(new SimpleDateFormat("yyyy").format(calendar.getTime()));
        return   calendar.get(Calendar.YEAR);
    }
    //TODO  конец метод получени месяа для записи в одну колонку ОБРАБОТКА ДАТЫ ДЛЯ КУРСОРА НЕ НОВЫЕ ДАННЫЕ А УЖЕ СУЩЕТСВУЮЩИЕ--МЕСЯЦ








    ///todo сообщение на активти создание новго сотрудника спрашиваем нужно ли создать
    @UiThread
    protected void СообщениеСпрашиваемПользователяЧтоОнТОчноХочетьСоздатьНовыйТабель(String ШабкаДиалога, final String СообщениеДиалога, boolean статус) {
        ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ
        try{
//////сам вид
            final AlertDialog alertDialog = new MaterialAlertDialogBuilder(this)
                    .setTitle(ШабкаДиалога)
                    .setMessage(СообщениеДиалога)
                    .setPositiveButton("Да", null)
                    .setNegativeButton("Нет", null)
                    .setIcon(R.drawable.icon_dsu1_new_tabel1)
                    .show();
/////////кнопка
            final Button MessageBoxUpdateСоздатьТабель = alertDialog .getButton(AlertDialog.BUTTON_POSITIVE);
            MessageBoxUpdateСоздатьТабель.setOnClickListener(new View.OnClickListener() {
                ///MessageBoxUpdate метод CLICK для DIALOBOX
                @Override
                public void onClick(View v) {
                    //удаляем с экрана Диалог
                    alertDialog .dismiss();
                    Log.d(this.getClass().getName()," создание нового сотрудника " );


                    ///TODO создание нового ТАБЕЛЯ
                    МетодСозданиеДиалогаКалендаряДаты();////ЗПАСУКАЕМ МЕТОД КОГДА НАДО ВЫБРВТЬ ДАТУ С КАЛЕНДАРКА


                }
            });

/////////кнопка
            final Button MessageBoxUpdateЗАкрытьСозданиеТабеля = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            MessageBoxUpdateЗАкрытьСозданиеТабеля.setOnClickListener(new View.OnClickListener() {
                ///MessageBoxUpdate метод CLICK для DIALOBOX
                @Override
                public void onClick(View v) {
                    //удаляем с экрана Диалог
                    alertDialog .dismiss();
///запуск метода обновления через DIALOGBOX
                }
            });
            /////
            //TODO шаблоны



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








































































    // TODO: 20.09.2021 CLASS TO DELETE TABEL AS CUNSTOMNER




    class Class_Delete_Current_Tabel{


        public Class_Delete_Current_Tabel() {
        }

        //todo метод удаления табля из проекта если внем нет сотрудников
        private void МетодДляУдалениеТабеляЕслиВнемНетСотрудников() {
            ///todo третий обработчки нажатия


///TODO  удаление ОБРАБОТКА КЛИКА ПО ФИО

            СлушательУдаланиеСамогоТабеля = new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    try{






                        ////todo
                        //МыУжеВКодеУденияСотрудника=true;
                        TextView UUIDУдаляемогоТабеля=(TextView) v;

                        Log.d(this.getClass().getName(), " UUIDУдаляемогоТабеля " +UUIDУдаляемогоТабеля.getTag());

                        ///Toast.makeText(getApplication(), " Удаление Самого Табеля  " +v.getTag(), Toast.LENGTH_SHORT).show();

                        ((TextView) v).setBackgroundColor(Color.GRAY);





                        String UUIDУдаляемогоТабеляКАкТекст= (String) UUIDУдаляемогоТабеля.getTag();

                        int НазваниеУдаляемогоТАбеля=(int) UUIDУдаляемогоТабеля.getId();

                        int НазваниеУдаляемогоТАбеляВЦифровомФормате=(int) UUIDУдаляемогоТабеля.getId();

                        ///
                        String ПолноеНазваниеУдалмемогоТабелья= (String ) UUIDУдаляемогоТабеля.getText();

                        ////
                        Log.d(this.getClass().getName(), " НазваниеУдаляемогоТАбеля " +НазваниеУдаляемогоТАбеля+
                                "НазваниеУдаляемогоТАбеляВЦифровомФормате "+НазваниеУдаляемогоТАбеляВЦифровомФормате+ПолноеНазваниеУдалмемогоТабелья);




////todo метод придупрежнает что будет процесс даленис самого табеля
             /*           if (PUBLIC_CONTENT.Отладка==true) {
                            //////
                            СообщениеПредпреждаетОВыбореУдалениеСамогоТабеля("Оповещение",  "Вы выбрали функцию удаление"+"\n"
                                            +"Табеля: " +ПолноеНазваниеУдалмемогоТабелья+"\n" + "(Выбор Да/Нет на следующем диалогом окне).", "nametabel_typename",
                                    UUIDУдаляемогоТабеляКАкТекст,НазваниеУдаляемогоТАбеля,НазваниеУдаляемогоТАбеляВЦифровомФормате);
                            //  +"Табеля: " +НазваниеУдаляемогоТАбеля+"\n" + "(Выбор Да/Нет на следующем диалогом окне).", "uuid", UUIDУдаляемогоТабеляКАкТекст,НазваниеУдаляемогоТАбеля,НазваниеУдаляемогоТАбеляВЦифровомФормате);
                        } else {*/

                            /////todo сообщением передохим вв удаления табеля
                            МетодУдалениеТАбеляСообщениеПередЭтим(UUIDУдаляемогоТабеляКАкТекст,
                                    UUIDУдаляемогоТабеляКАкТекст,
                                    НазваниеУдаляемогоТАбеля,
                                    НазваниеУдаляемогоТАбеляВЦифровомФормате,
                                    ПолноеНазваниеУдалмемогоТабелья ,v);


                        ////
                        Log.d(this.getClass().getName(), " Удаление Прошло " +НазваниеУдаляемогоТАбеля+
                                "НазваниеУдаляемогоТАбеляВЦифровомФормате "+НазваниеУдаляемогоТАбеляВЦифровомФормате+ПолноеНазваниеУдалмемогоТабелья);







/*/////TODO КОД КОТОРЫЙ КОТОРЫ УДАЛЯЮТ СОТРУДНИКА ИЗ ТАБЕЛЯ
                    СообщениеПредпреждаетОВыбореУдалениеСотрудникаИзТабеля("Оповещение",  "Вы выбрали функцию удаление сотрудника: "+"\n" +ФИОДляУдаление.getText() +
                            " из Табеля."+"\n"+"(Выбор Да/Нет на следующем диалогом окне).", "uuid",(String) v.getTag(), (String) ФИОДляУдаление.getText());*/
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " +e + " Метод :"+Thread.currentThread().getStackTrace()[2].getMethodName()
                                + " Линия  :"+Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),  this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                    return true;
                }
            };


        }
///todo конецслушателя long для уделанеи самого табеля




    }


    void МетодУдалениеТАбеляСообщениеПередЭтим(String СамUUIDТабеля, String СамИндификаторUUID, int НазваниеУдаляемогоТАбеля,
                                               int НазваниеУдаляемогоТАбеляВЦифровомФормате,
                                               String  ПолноеНазваниеУдалмемогоТабелья,
                                               View v) throws InterruptedException



    {




        Long СамUUIDТабеляКакLONG= Long.valueOf(СамUUIDТабеля);

        Integer ФлагВыясняемПроведенныйТабельИлиНет = 0;
        try{







            SQLiteCursor Курсор_ИщемПроведенЛиТАбельИлиНЕт = null;




            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ


            class_grud_sql_operationsДляАктивтиТабель= new Class_GRUD_SQL_Operations(getApplicationContext());
            ///
            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("НазваниеОбрабоатываемойТаблицы","data_tabels");
            ///////
            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СтолбцыОбработки","*");
            //

            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("ФорматПосика","uuid_tabel=?");
            ///"_id > ?   AND _id< ?"
            //////
            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеПоиска1",СамUUIDТабеляКакLONG);

            ////
            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеЛимита",1);

            ////
            class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("УсловиеСортировки","date_update DESC");
            ////

            // TODO: 12.10.2021  Ссылка Менеджер Потоков

            PUBLIC_CONTENT  Class_Engine_SQLГдеНаходитьсяМенеджерПотоков =new PUBLIC_CONTENT (getApplicationContext());
            // TODO: 27.08.2021  ПОЛУЧЕНИЕ ДАННЫХ ОТ КЛАССА GRUD-ОПЕРАЦИИ


            Курсор_ИщемПроведенЛиТАбельИлиНЕт= (SQLiteCursor) class_grud_sql_operationsДляАктивтиТабель.
                    new GetData(getApplicationContext()).getdata(class_grud_sql_operationsДляАктивтиТабель. concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                    Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());

            Log.d(this.getClass().getName(), "GetData " +Курсор_ИщемПроведенЛиТАбельИлиНЕт );

            ////


            /////////
            if(Курсор_ИщемПроведенЛиТАбельИлиНЕт.getCount()>0){
                ///////
                Курсор_ИщемПроведенЛиТАбельИлиНЕт.moveToFirst();
                ////
                Log.d(this.getClass().getName(), " Курсор_ИщемПУбличныйIDКогдаегоНетВстатике " + Курсор_ИщемПроведенЛиТАбельИлиНЕт.getCount());



                int ИндексКурсор_ИщемПУбличныйIDКогдаегоНетВстатике= Курсор_ИщемПроведенЛиТАбельИлиНЕт.getColumnIndex("status_carried_out");



                ФлагВыясняемПроведенныйТабельИлиНет = Курсор_ИщемПроведенЛиТАбельИлиНЕт.getInt(ИндексКурсор_ИщемПУбличныйIDКогдаегоНетВстатике);

// TODO: 06.10.2021



                ////
                Log.d(this.getClass().getName(), " ИндексКурсор_ИщемПУбличныйIDКогдаегоНетВстатике " + ИндексКурсор_ИщемПУбличныйIDКогдаегоНетВстатике+
                        "  ФлагВыясняемПроведенныйТабельИлиНет " +ФлагВыясняемПроведенныйТабельИлиНет);



            }
 ///
            Курсор_ИщемПроведенЛиТАбельИлиНЕт.close();



            if(ФлагВыясняемПроведенныйТабельИлиНет==null){

                ФлагВыясняемПроведенныйТабельИлиНет=0;
            }



            // TODO: 16.09.2021  продолжаем удаление табеля табелья ЕСЛИ СТАРУС ТАБЕЛЬЯ НЕ ПРОВЕДЕННЫЙ


            if (ФлагВыясняемПроведенныйТабельИлиНет==0 ) {
                ///todo
                СообщениеВыборУдлалянияТабеляИзБазы("Удаление табеля","Удалить выбранный табель ?: "+"\n"+"\n"
                                +ПолноеНазваниеУдалмемогоТабелья+"." , СамИндификаторUUID,
                        СамUUIDТабеляКакLONG,НазваниеУдаляемогоТАбеля,ПолноеНазваниеУдалмемогоТабелья) ;

                ///////////
            }else if (ФлагВыясняемПроведенныйТабельИлиНет==1){



            Snackbar.make(v, "В Табеле присутстуют проведенный табель !!! ( удалить нельзя )",Snackbar.LENGTH_LONG).setAction("Action",null).show();
                ///
                //Toast.makeText(getApplicationContext(), " Табель Проведён (удаление запрещено !!!)" , Toast.LENGTH_LONG).show();

            }


        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " +e + " Метод :"+Thread.currentThread().getStackTrace()[2].getMethodName()
                    + " Линия  :"+Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),  this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }


    }
//todo  конеч сообщение предупреждения удлаения табеля





















    ///todo сообщение
    @UiThread
    protected void СообщениеВыборУдлалянияТабеляИзБазы(String ШабкаДиалога,  String СообщениеДиалога,  String ИндификаторUUID,
                                                       Long СамоЗначениеUUID,int НазваниеУдаляемогоТАбеля, String НазваниеУдаляемогоТАбеляВЦифровомФормате) {
        ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ///////СОЗДАЕМ ДИАЛОГ ДА ИЛИ НЕТ
        try {
//////сам вид
            final AlertDialog alertDialog = new MaterialAlertDialogBuilder(this)
                    .setTitle(ШабкаДиалога)
                    .setMessage(СообщениеДиалога)
                    .setPositiveButton("Да", null)
                    .setNegativeButton("Нет", null)
                    .setIcon(R.drawable.icon_dsu1_delete_customer)
                    .show();
/////////кнопка
            final Button MessageBoxУдалениеСотрудникаИзТабеля = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
            MessageBoxУдалениеСотрудникаИзТабеля .setOnClickListener(new View.OnClickListener() {
                ///MessageBoxUpdate метод CLICK для DIALOBOX
                @Override
                public void onClick(View v) {
                    //удаляем с экрана Диалог
                    alertDialog.dismiss();
                    Log.d(this.getClass().getName(), "  ФИНАЛ создание нового сотрудника " + "ИндификаторUUID " +ИндификаторUUID+ " СамоЗначениеUUID " + СамоЗначениеUUID+"  "+ПолученноеЗначениеИзСпинераДата);

//////todo
                    if (СамоЗначениеUUID>0) {



                        Integer РезультатУдалениеТабеля=
                                МетодУдалениеСамогоТабеля(ИндификаторUUID,
                                        СамоЗначениеUUID,НазваниеУдаляемогоТАбеля,
                                        ПолученноеЗначениеИзСпинераДата,
                                        НазваниеУдаляемогоТАбеляВЦифровомФормате); //// TODO передаеюм UUID для Удалание

                        ///todo поле удаления табеля



                        Log.d(this.getClass().getName(), "  ФИНАЛ создание нового сотрудника " + "РезультатУдалениеТабеля " +РезультатУдалениеТабеля);


//



                    }

                }
            });

            /////////кнопка
            final Button MessageBoxУдалениеСотрудникаИзТабеляОтмена = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            MessageBoxУдалениеСотрудникаИзТабеляОтмена.setOnClickListener(new View.OnClickListener() {
                ///MessageBoxUpdate метод CLICK для DIALOBOX
                @Override
                public void onClick(View v) {
                    //удаляем с экрана Диалог
                    alertDialog.dismiss();
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


    //todo метод удаление сотрудника из табеля
    private Integer МетодУдалениеСамогоТабеля(String ДляУдалениеUUID,Long СамоЗначениеUUID,int НазваниеУдаляемогоТАбеля , String ПолученноеЗначениеИзСпинераДата, String НазваниеУдаляемогоТАбеляВЦифровомФормате) {

        StringBuffer ПрисутстуетСотрудникВУдаляемомоТабеле=new StringBuffer();

        final Cursor[] Курсор_КоторыйПроверяетПУстойЛиТабеля = {null};


        Integer РезультатУдаленияТабеля=0;

        try{
            Log.d(this.getClass().getName()," СамоЗначениеUUID "+СамоЗначениеUUID+ " ДляУдалениеUUID " +ДляУдалениеUUID);

            /////todo код курсор выясняеть нет вполе fio сотрудник короче если в табеле нет ни одного сотрудника
            long РезультатУдалениеСамогоТАбеля = 0;


            Log.d(this.getClass().getName()," НазваниеУдаляемогоТАбеля"+ НазваниеУдаляемогоТАбеля);


            ////



            // TODO: 11.06.2021 метод который удялет
            РезультатУдаленияТабеля=             МетодУдалениеТабеляПриУсловииЧтоНетСотрудниковВнем(ДляУдалениеUUID,
                    СамоЗначениеUUID, НазваниеУдаляемогоТАбеля, ПрисутстуетСотрудникВУдаляемомоТабеле,
                    Курсор_КоторыйПроверяетПУстойЛиТабеля,НазваниеУдаляемогоТАбеляВЦифровомФормате);

///

            Log.d(this.getClass().getName(), " РезультатУдаленияТабеля " +РезультатУдаленияТабеля);



//TODO удаление ТАБЕЛЯ ПРИУСЛОВИИ ЧТО В ТАБЕЛЕ НЕТ СОТРУДНИКОВ






//TODO удаление ТАБЕЛЯ ПРИУСЛОВИИ ЧТО В ТАБЕЛЕ НЕТ СОТРУДНИКОВ

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return РезультатУдаленияТабеля;
    }


















    protected Integer МетодУдалениеТабеляПриУсловииЧтоНетСотрудниковВнем(String ДляУдалениеUUID, Long СамоЗначениеUUID, int НазваниеУдаляемогоТАбеля,
                                                                         StringBuffer присутстуетСотрудникВУдаляемомоТабеле, Cursor[] курсор_КоторыйПроверяетПУстойЛиТабеля, String НазваниеУдаляемогоТАбеляВЦифровомФормате)
            throws ExecutionException, InterruptedException, TimeoutException, BrokenBarrierException {


        ///  Log.d(this.getClass().getName()," Курсор_КоторыйПроверяетПУстойЛиТабеля.getCount() "+ курсор_КоторыйПроверяетПУстойЛиТабеля[0].getCount());
        String СодержимоеКурсора = null;

        String СодержимоеКурсораНазваниеТабеля = null;
        //



        //todo если данныз нет то не удаляем Табеля удаляем если нет не одного сотрудника в нутир табеля


        try {

            Log.d(this.getClass().getName(), " СодержимоеКурсораНазваниеТабеля       " + СодержимоеКурсораНазваниеТабеля);



// TODO: 06.09.2021  ВТОРОЕ ДЕЙСТИЕ ПОЛУЧЕНИЕ ДАННЫХ


                    СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником = new LinkedBlockingQueue<Long>();


                        СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.put(СамоЗначениеUUID);


                   // progressDialogДляУдаления.setMax(СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.size());

                    Log.d(this.getClass().getName(), "  СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником "
                            + СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.toArray());




///todo команда которая удаляет выбранный табель


  PUBLIC_CONTENT public_contentПрогресВезуализации=new PUBLIC_CONTENT(activity);
            //


            // TODO: 26.10.2021
            progressDialogДляУдаления = new ProgressDialog(activity);

            progressDialogДляУдаления.setTitle("Удаление Табеля");

            progressDialogДляУдаления.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            progressDialogДляУдаления.setProgress(0);
            ///
            progressDialogДляУдаления.setMax(СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.size());


            progressDialogДляУдаления.setCanceledOnTouchOutside(false);

            progressDialogДляУдаления.setMessage("Удалание...");

            progressDialogДляУдаления.setMessage("Удалание..." + НазваниеУдаляемогоТАбеляВЦифровомФормате);

           // progressDialogДляУдаления. setIndeterminateDrawable(getApplicationContext().getResources().getDrawable(R.color.accent));
            ///
            progressDialogДляУдаления.show();
            //


            // TODO: 20.09.2021
            final String ПередаемСозданнуюДатуНовогоТабеля = (String) ((TextView) СпинерВыборДату.getChildAt(0)).getText();///дата нового табеля





            public_contentПрогресВезуализации.МенеджерПотоков.submit(()-> {
                // TODO: 26.10.2021



       /*     //////
            Class_Engine_SQLГдеНаходитьсяМенеджерПотоков.МенеджерПотоков.submit(new Callable() {
                @Override
                public Object call() throws Exception {*/
                /////////

                // TODO: 26.10.2021

                Iterator<Long> iteratorДляУдалениеТАбеля = СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.iterator();

                //
                Integer РезультатУдалениеСамогоТАбеля = null;
                while (iteratorДляУдалениеТАбеля.hasNext()) {
                    ///
                    Long ПолученныйUUIDДляУдалениесотрудникаИЗТабеля = iteratorДляУдалениеТАбеля.next();


                    Log.d(this.getClass().getName(), " ПолученныйUUIDДляУдалениесотрудникаИЗТабеля" + ПолученныйUUIDДляУдалениесотрудникаИЗТабеля);

                    //todo заполения

                    /////
                    РезультатУдалениеСамогоТАбеля = 0;

                    /////TODO КОД ПРИ ОБНОВЛЯЕМ ПРИ ТАБЕЛЯ (ВАРИАНТ ВАРИАНТ УДЯЛЯЕМ А НИЖЕ ПРОСТО ОБНОВЛЯЕМ КОЛОКУ И ВПИСЫВАЕМ уДАЛЕННЫЕ)

                    //////
                    try {
                        ///
// TODO: 26.10.2021 DELETE TABLE TABEL
                        /////
                        РезультатУдалениеСамогоТАбеля = new Class_MODEL_synchronized(getApplicationContext()).УдалениеТолькоПустогоТабеляЧерезКонтейнерУниверсальная("tabel", "uuid",
                                ПолученныйUUIDДляУдалениесотрудникаИЗТабеля);

                        /////
                        Log.d(this.getClass().getName(), " РезультатУдалениеСамогоТАбеля " + РезультатУдалениеСамогоТАбеля);


/*
                        if (РезультатУдалениеСамогоТАбеля>0) {
                            Long РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПриСозданииНовогоТабеля = 0l;

                            // TODO: 12.08.2021 ЛОКАЛЬНАЯ ДАТА ЛОКАЛЬНАЯ

                            String ТекущаяТаблицаОбработкиДляПовышенияВерсии="tabel";
                            Class_GRUD_SQL_Operations      class_grud_sql_operationsПовышаемВерсиюДляЛокальногоОбволенияТабеля=new Class_GRUD_SQL_Operations(getApplicationContext());

                          Long  РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника=
                                  class_grud_sql_operationsПовышаемВерсиюДляЛокальногоОбволенияТабеля. new ChangesVesionData(getApplicationContext()).
                                            МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table(ТекущаяТаблицаОбработкиДляПовышенияВерсии
                                                    ,"localversionandroid_version",
                                                    getApplicationContext()
                                                    ,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());///  current_table    ///  localversionandroid_version




                            Log.d(this.getClass().getName(), "  РезультатУвеличинаяВерсияДАныхЧата " + РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника);


                            // TODO: 12.08.2021 код повышает или уменьшает верисю данных
                            Integer РезультатПовышенияВерсииДанныхДатыиВерсии =new Class_Engine_SQL(getApplicationContext()).
                                    МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_Client(РезультатУдалениеСамогоТАбеля ,
                                            ТекущаяТаблицаОбработкиДляПовышенияВерсии,
                                            "Локальное"
                                            ,РезультатУвеличинаяВерсияВнутриСамогоТабелСтрудника,
                                            new PUBLIC_CONTENT(getApplicationContext()).МенеджерПотоков);//ЛокальныйСерверныйОба

                            Log.i(this.getClass().getName(), "   ИмяТаблицыОтАндройда_Локальноая"
                                    + ТекущаяТаблицаОбработкиДляПовышенияВерсии + " РезультатУспешнойВставкиИлИОбвновленияССервера " + РезультатПовышенияВерсииДанныхДатыиВерсии +
                                    "  РезультатПовышенияВерсииДанныхДатыиВерсии " + РезультатПовышенияВерсииДанныхДатыиВерсии);
                        }*/



















                        Log.d(this.getClass().getName(), " РезультатУдалениеСамогоТАбеля " + РезультатУдалениеСамогоТАбеля);

                        // TODO: 08.09.2021 DELETE TWO TABLE DATA_TABELS
                        if (РезультатУдалениеСамогоТАбеля > 0) {
                            /////

                            РезультатУдалениеСамогоТАбеля=0;


                            // TODO: 01.11.2021  само удаление табеля
                            РезультатУдалениеСамогоТАбеля =
                                    new Class_MODEL_synchronized(getApplicationContext()).УдалениеТолькоПустогоТабеляЧерезКонтейнерУниверсальная("data_tabels", "uuid_tabel",
                                            ПолученныйUUIDДляУдалениесотрудникаИЗТабеля);


                            /////
                            Log.d(this.getClass().getName(), " РезультатУдалениеСамогоТАбеля " + РезультатУдалениеСамогоТАбеля);

                     /*       if (РезультатУдалениеСамогоТАбеля>0) {
                                // TODO: 28.01.2022
                                Long РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПриСозданииНовогоТабеля = 0l;

                                // TODO: 12.08.2021 ЛОКАЛЬНАЯ ДАТА ЛОКАЛЬНАЯ

                                String ТекущаяТаблицаОбработкиДляПовышенияВерсии="data_tabels";

                                Class_GRUD_SQL_Operations  class_grud_sql_operationsПовышаемВерсиюДляЛокальногоОбволенияТабеля=new Class_GRUD_SQL_Operations(getApplicationContext());

                                РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПриСозданииНовогоТабеля =
                                                class_grud_sql_operationsПовышаемВерсиюДляЛокальногоОбволенияТабеля. new ChangesVesionData(getApplicationContext()).
                                                        МетодПолученияУвеличинойВесрииДанныхДляТекущейВнутренейтаблицы_ПоПолю_current_table_ПоПолю_current_table(ТекущаяТаблицаОбработкиДляПовышенияВерсии
                                                                ,"localversionandroid_version",
                                                                getApplicationContext()
                                                                ,Create_Database_СсылкаНАБазовыйКласс.getССылкаНаСозданнуюБазу());///  current_table    ///  localversionandroid_version




                                Log.d(this.getClass().getName(), "  РезультатУвеличинаяВерсияДАныхЧата " + РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПриСозданииНовогоТабеля);

                                Log.d(this.getClass().getName(),
                                        " РезультаПолученаяЛокальнаяВерсияДанныхКогдаПользовательСоздалНовыеДаннее" + РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПриСозданииНовогоТабеля);


                                // TODO: 12.08.2021 код повышает или уменьшает верисю данных
                                Integer РезультатПовышенияВерсииДанныхДатыиВерсии =new Class_Engine_SQL(getApplicationContext()).
                                        МетодПовышаемВерсиюДанныхПроектавТаблицеMODIFITATION_Client(РезультатУдалениеСамогоТАбеля ,
                                                ТекущаяТаблицаОбработкиДляПовышенияВерсии,
                                                "Локальное",
                                                РезультаПолученаяЛокальнаяЛокальнаяВерсияДанныхКогдаПриСозданииНовогоТабеля,
                                                new PUBLIC_CONTENT(getApplicationContext()).МенеджерПотоков);//ЛокальныйСерверныйОба

                                Log.i(this.getClass().getName(), "   ИмяТаблицыОтАндройда_Локальноая"
                                        + ТекущаяТаблицаОбработкиДляПовышенияВерсии + " РезультатУспешнойВставкиИлИОбвновленияССервера " + РезультатПовышенияВерсииДанныхДатыиВерсии +
                                        "  РезультатПовышенияВерсииДанныхДатыиВерсии " + РезультатПовышенияВерсииДанныхДатыиВерсии);
                            }*/

                            // TODO: 08.09.2021 reset


                        }


                        //////////////////////
                    } catch (Exception e) {
                        e.printStackTrace();
                        ///метод запись ошибок в таблицу
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        //
                        // TODO: 01.09.2021 метод вызова
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());


                    }
                    //todo очищаем память
///
                    // TODO: 14.06.2021 прогресс бар для удаления


                    Log.d(this.getClass().getName(), " РезультатУдалениеСамогоТАбеля " + РезультатУдалениеСамогоТАбеля);


                    final String finalПередаемСозданнуюДатуНовогоТабеля=ПередаемСозданнуюДатуНовогоТабеля;
                    ////////
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            /////
                            progressDialogДляУдаления.setMessage("Удалание..." + НазваниеУдаляемогоТАбеляВЦифровомФормате);
                            //

                            try {
                                TimeUnit.MILLISECONDS.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            ///


                       /*     МетодСозданиеСпинераДляДатыНаАктивитиСозданиеИВыборТабеля();

                            //
                            //////


                            //
                            ScrollНаАктивтиСозданныхТабелей.invalidate();
                            /////
                            ScrollНаАктивтиСозданныхТабелей.requestLayout();

                            LinearLayoutСозданныхТабелей.requestLayout();*/

                        }
                    });


                    ////
                    СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.take();


                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            /////


// TODO: 20.09.2021
                            progressDialogДляУдаления.dismiss();



                            Log.d(this.getClass().getName(), " МассивДляВыбораВСпинерДата " + МассивДляВыбораВСпинерДата);
                            МассивДляВыбораВСпинерДата.clear();
                            //

                            СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником.clear();
                            Log.d(this.getClass().getName(), " СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником " + СодержимоеКурсораUUIDТабеляПриУдалениеиТАбеляилиВместеССотрудником);


                        /*      ScrollНаАктивтиСозданныхТабелей.invalidate();
                           /////
                           ScrollНаАктивтиСозданныхТабелей.requestLayout();

                           LinearLayoutСозданныхТабелей.requestLayout();*/


                            ///

                            ///todo метод для удаления табеля
                            onStart();

                        }
                    });
                    //

                }


                // TODO: 20.09.2021  end


                // TODO: 20.09.2021

          /*          return null;
                }
            });*/
              // public_contentПрогресВезуализации.МенеджерПотоков.poll().get();

                return РезультатУдалениеСамогоТАбеля;

            });
            // TODO: 26.10.2021
         Integer РезультатУдаленияТабеля= (Integer) public_contentПрогресВезуализации.МенеджерПотоков.take().get();








            ////

            // TODO: 06.09.2021  end while


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            //
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());


        }
        return null;

    }




}