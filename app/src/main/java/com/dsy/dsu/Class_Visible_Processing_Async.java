package com.dsy.dsu;

import static java.util.Calendar.getInstance;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Class_Visible_Processing_Async {

    Context contextДляКлассавизуальнойСинхронизации;



    public Class_Visible_Processing_Async(Context context) {

        contextДляКлассавизуальнойСинхронизации=context;

    }
    //функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ
    // TODO: 05.07.2021



    // TODO: 07.09.2021  метод визуальной синхронизации отображения прогресс бара

    protected void МетодВизуальногоОтображенияХодаВизуальнойСинхронизации(int ДляСинхронизацииОбщееКоличествоСколькоСтрочекJSON,
                                                                          boolean СинхронизациюВизуализировать,
                                                                          Activity ActivityДляСинхронизацииОбмена,
                                                                          Integer Результат_Обновление_ИлиВставкиДанных,
                                                                          Integer ОбщееКоличествоСтрокВJSON, Float ФиналПроценты) {



        try{

            if (СинхронизациюВизуализировать  && ОбщееКоличествоСтрокВJSON > 0 && Результат_Обновление_ИлиВставкиДанных>0) {


                ///=
                Log.d(MODEL_synchronized.class.getName(), " ДляСинхронизацииОбщееКоличествоСколькоСтрочекJSON " + ДляСинхронизацииОбщееКоличествоСколькоСтрочекJSON +
                        " Результат_Обновление_ИлиВставкиДанных  " + Результат_Обновление_ИлиВставкиДанных);
/////

                Log.d(this.getClass().getName(), " ПроцентыДляВизуализацииИхПриСинхронизации" + Результат_Обновление_ИлиВставкиДанных + " ОбщееКоличествоСтрокВJSON " + ОбщееКоличествоСтрокВJSON);

                String ФиналПроцентыДляВизуализацииИхПриСинхронизации = null;
                //TODO считаем проценты от цифры
                Integer   ФинальныеПроценты=0;



                if (ОбщееКоличествоСтрокВJSON > 0 ) {


              Float ОбщееКоличествоСтрокВJSONfloat=Float.parseFloat(String.valueOf(ОбщееКоличествоСтрокВJSON));
                    ///
                    Float Результат_Обновление_ИлиВставкиДанныхfloat=Float.parseFloat(String.valueOf(Результат_Обновление_ИлиВставкиДанных));

                    /////
                  ФиналПроценты = ( Результат_Обновление_ИлиВставкиДанныхfloat/ОбщееКоличествоСтрокВJSONfloat  ) * 100;     ///        ФиналПроценты = ( ОбщееКоличествоСтрокВJSONfloat *Результат_Обновление_ИлиВставкиДанныхfloat ) / 100;
                    ////


                    ////TODO ищем Точку
                    Log.d(this.getClass().getName(), "  ФиналПроценты  нЕ ОБРАБОТАННЫЕ " + ФиналПроценты+  "  Результат_Обновление_ИлиВставкиДанных " +Результат_Обновление_ИлиВставкиДанных);


                    // TODO: 15.09.2021

                if (ФиналПроценты < 100) {

                        //
                        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
                        //
                        DecimalFormatSymbols ЗонаПроцентовфОрмат = new DecimalFormatSymbols(Locale.US);//new Locale("ru")

                        DecimalFormat ФОрматированиеВидаПроцентов = new DecimalFormat("##", ЗонаПроцентовфОрмат);//#0.0"
                      //  df.applyLocalizedPattern("#0,#");



                        Log.d(this.getClass().getName(), "  ФиналПроценты"+ ФиналПроценты);
                        // TODO: 14.10.2021 ЗамоПреобразование

                        final  String  ФиналПроцентыВременно=  ФОрматированиеВидаПроцентов.format(Math.ceil(ФиналПроценты));
                        
                        Log.d(this.getClass().getName(), "  ФиналПроцентыВременно"+ ФиналПроцентыВременно);


                    ФинальныеПроценты =0;
                    //
                    ФинальныеПроценты = Integer.parseInt(ФиналПроцентыВременно);
                        ///
                        ///

                        Log.d(this.getClass().getName(), "  ФиналПроценты"+ ФиналПроценты);
                        /// PUBLIC_CONTENT. ФиналПроценты = Float.parseFloat(f.format(   PUBLIC_CONTENT. ФиналПроценты));
                        ///////
                    } else {
                        ///DecimalFormat f = new DecimalFormat("###");

                        ///DecimalFormat df = new DecimalFormat("###");
                        //
                        DecimalFormatSymbols ЗонаПроцентовфОрмат = new DecimalFormatSymbols(Locale.US);///new Locale("ru")

                        DecimalFormat ФОрматированиеВидаПроцентов = new DecimalFormat("###", ЗонаПроцентовфОрмат);


                        ///TODO переропределяем проценты
                        Log.d(this.getClass().getName(), "  ФиналПроценты"+ ФиналПроценты);
                        // TODO: 14.10.2021 ЗамоПреобразование

                        final  String  ФиналПроцентыВременно=  ФОрматированиеВидаПроцентов.format(ФиналПроценты);

                        Log.d(this.getClass().getName(), "  ФиналПроцентыВременно"+ ФиналПроцентыВременно);

                      ФинальныеПроценты =0;
                        //
                     ФинальныеПроценты = Integer.parseInt(ФиналПроцентыВременно);

                        Log.d(this.getClass().getName(), "  ФиналПроценты"+ ФиналПроценты);
                        ///


                        Log.d(this.getClass().getName(), "  ФинальныеПроценты"+ ФинальныеПроценты);
                        ////todo

                        if (ФинальныеПроценты >= 100  || ФинальныеПроценты >= 100.0) {

                            ////todo если процентов больше 100 %  уменьваем их принудтельно
                            ФиналПроценты =Float.parseFloat(String.valueOf(100));

                            Log.d(this.getClass().getName(), " ФиналПроценты"+ ФиналПроценты);
                        }


                    }

                    //



                    //  ФиналПроцентыДляВизуализацииИхПриСинхронизации = String.valueOf(ФиналПроценты);






                    // TODO: 15.09.2021



                    ////TODO вставка backcalls ВСТАВКА ФИНИАЛЬНЫЕ ПРОЦЕНТЫ

                    final String ВозвратВПотокЗначенияСнизу =  ФинальныеПроценты + " %";
                    //TODO ПОСЫЛАЕМ ВВЕРХ ПО ПОТОКУ

                    Log.d(this.getClass().getName(), " ВозвратВПотокЗначенияСнизу " + ВозвратВПотокЗначенияСнизу);

                    //////TODO выводими обратно в UI обновления
                    if (ActivityДляСинхронизацииОбмена!=null) {

                        ActivityДляСинхронизацииОбмена.runOnUiThread(new Runnable() {
                            public void run() {

                                ///TODO ОБВНОВЛЕНИЕ false это првидбно начит это не первый запуск и нужно и обновление

                                TextView ТекстВидBarСинх=  ActivityДляСинхронизацииОбмена.findViewById(R.id.TextViewДляProgressBarГлавнойСинхронизации);

                                    // TODO: 13.09.2021 проверяет чтобы значение не
                                    //////////TODO ВСТАВКА ПРОЦЕНТОВ ПРИ ОБНОВЛЕНИИ

                                    ТекстВидBarСинх.setText(ВозвратВПотокЗначенияСнизу.trim());

                                    ///
                                    Log.d(this.getClass().getName(), " ПРОЦЕНТЫ %     "
                                            + ВозвратВПотокЗначенияСнизу.trim());



                                //////


              /*          Toast.makeText(Публичный_КонтекстДляСинхронизацииОбмена, " Проценты Обновления %   " +ВозвратВПотокЗначенияСнизу +
                                " Количество Успешных Обновлений :   " +ПроцентыДляВизуализацииИхПриСинхронизации+ " Таблица Куда Обновляем " +ТаблицаКудаОбновляем, Toast.LENGTH_SHORT).show();*/
                                ///////TODO обработкаи  ГОризонтального PrograssBARA


                            }
                        });
                    }
                    //////////TODO  В ФОНЕ
                }

            }//TODO если не проходит по условию





            //////TODO   конец  визуальное оформления прогресс бара
            //   }///// todo  if (     finalФлагПриПервомЗапускеОграничитьОперациюТолькоВставка == false) {
        } catch (Exception e) {///////ошибки
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(MODEL_synchronized.class.getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(contextДляКлассавизуальнойСинхронизации).МетодЗаписиВЖурналНовойОшибки(e.toString(), MODEL_synchronized.class.getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

        }
    }






}
