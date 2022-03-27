package com.dsy.dsu;


import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class SubClass_Starting_Tasks_ЗапускДЛяЗадач {
    Context context;

    // TODO: 24.03.2022
    Bundle bundleДляПередачиВСлужбу;

    public SubClass_Starting_Tasks_ЗапускДЛяЗадач(Context context) {
        // TODO: 03.03.2022
        this.context = context;
        // TODO: 26.03.2022
        bundleДляПередачиВСлужбу = new Bundle();

    }


    // TODO: 03.03.2022

    public PendingIntent МетодЗапускаСменыСтатусаВыполнилСлужбыЧерезPendingIntent(String PROCESS_ID_УведомленияПлановая,
                                                                                  String ИмяСлужбыУведомленияДляЧата
            , Object UUIDПолучениейЗадачиОбьект, int ПередаемСтатусзадачи, String ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу) {
        ///
        PendingIntent ЗапускКОдаЧтоПОльзовательЗадачаВыполнил = null;

        try {

            Long UUIDПолучениейЗадачи = Long.parseLong(String.valueOf(UUIDПолучениейЗадачиОбьект));


            ///////TODO запускаем смены стануса задачи черезе PendingIntent
            Log.d(context.getClass().getName(), "PROCESS_ID_УведомленияПлановая " + PROCESS_ID_УведомленияПлановая +
                    " ИмяСлужбыУведомленияДляЧата " + ИмяСлужбыУведомленияДляЧата + "  UUIDПолучениейЗадачи " + UUIDПолучениейЗадачи +
                    " ПередаемСтатусзадачи " + ПередаемСтатусзадачи);


            PackageManager pm = context.getPackageManager();


// TODO: 17.11.2021 БЛОК КОДА РЕАЛИЗАЦИЯ БУДУШЕГО ЗАПУСКА ПРИ НАЖАТИИ НА УВЕДОСЛЕНИЕ ИЛИ НА КНОПКИ ЗАПУСКАЕТ С УВЕДОМЛЕНИЯ РАЗЛИЧНЫЕ ДЕЙСТВИЯ

            Intent notificationIntentДляЗадачиВыполнили;
            // TODO: 17.11.2021
            notificationIntentДляЗадачиВыполнили = new Intent(context, Service_Notificatios_Для_Задания.class);
            // TODO: 24.03.2022
            //  notificationIntentДляЗадачиВыполнили.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // TODO: 03.03.2022
            notificationIntentДляЗадачиВыполнили.setAction("ЗапускСогласованияПришедшегоЗАДАНИЕ");
            // TODO: 17.11.2021
            notificationIntentДляЗадачиВыполнили.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);


            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putString("PROCESS_ID_Задачи", PROCESS_ID_УведомленияПлановая);
            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putString("ИмяСлужбыУведомленияДляЧата_Задачи", ИмяСлужбыУведомленияДляЧата);
            // TODO: 24.03.2022  
            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putLong("UUIDПолучениейЗадачи", UUIDПолучениейЗадачи);
            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putString("ЗапускСогласованияПришедшегоЗАДАНИЕ", "ЗапускСогласованияПришедшегоЗАДАНИЕ");
// TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putInt("ДляЗадачиПередаемФлагВыполненаЗадчаИлиОтказ", ПередаемСтатусзадачи);

            // TODO: 24.03.2022
            notificationIntentДляЗадачиВыполнили.putExtras(bundleДляПередачиВСлужбу);

            Log.d(context.getClass().getName(), "ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу "
                    + ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу + "  bundleДляПередачиВСлужбу " + bundleДляПередачиВСлужбу);


            if (notificationIntentДляЗадачиВыполнили.resolveActivity(pm) != null) {
                // TODO: 24.03.2022
                ЗапускКОдаЧтоПОльзовательЗадачаВыполнил = PendingIntent.getService(context,
                        0, notificationIntentДляЗадачиВыполнили,
                        PendingIntent.FLAG_MUTABLE | PendingIntent.FLAG_CANCEL_CURRENT); //PendingIntent.FLAG_UPDATE_CURRENT
                // TODO: 17.11.2021
                // Service_Notifocations_Для_Чата.enqueueWork(getApplicationContext(),notificationIntentДляУведомленийЗапускПаузы);

                // TODO: 03.03.2022

                /// ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием.send();

          }

            // TODO: 03.03.2022

    } catch (Exception e) {
        e.printStackTrace();
        ///метод запись ошибок в таблицу
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
            //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ
            Log.d(context.getClass().getName(), " Стоп СЛУЖБА СЛУЖБАService_Notifications ДЛЯ ЧАТА  onDestroy() Exception ");

        }
///TODO
        return ЗапускКОдаЧтоПОльзовательЗадачаВыполнил;
    }

// TODO: 26.03.2022 код для ЗАДАНИЯ КОТОРЫЙ СРАБАТЫВАЕТ КОГДАНА САМО УВЕДОМЛЕНИЯ ЗАДАНИЕ НАЖАЛИ
    // TODO: 03.03.2022

    public PendingIntent МетодЗапускаСменыСтатусаОтказСлужбыЧерезPendingIntent(String PROCESS_ID_УведомленияПлановая,
                                                                               String ИмяСлужбыУведомленияДляЧата
            , Object UUIDПолучениейЗадачиОбьект, int ПередаемСтатусзадачи, String ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу) {
        ///
        PendingIntent ЗапускКОдаЧтоПОльзовательЗадачаВыполнилОтказ = null;

        try {

            Long UUIDПолучениейЗадачи = Long.parseLong(String.valueOf(UUIDПолучениейЗадачиОбьект));


            ///////TODO запускаем смены стануса задачи черезе PendingIntent
            Log.d(context.getClass().getName(), "PROCESS_ID_УведомленияПлановая " + PROCESS_ID_УведомленияПлановая +
                    " ИмяСлужбыУведомленияДляЧата " + ИмяСлужбыУведомленияДляЧата + "  UUIDПолучениейЗадачи " + UUIDПолучениейЗадачи +
                    " ПередаемСтатусзадачи " + ПередаемСтатусзадачи);


            PackageManager pm = context.getPackageManager();


// TODO: 17.11.2021 БЛОК КОДА РЕАЛИЗАЦИЯ БУДУШЕГО ЗАПУСКА ПРИ НАЖАТИИ НА УВЕДОСЛЕНИЕ ИЛИ НА КНОПКИ ЗАПУСКАЕТ С УВЕДОМЛЕНИЯ РАЗЛИЧНЫЕ ДЕЙСТВИЯ

            Intent notificationIntentДляЗадачиОтказ;
            // TODO: 17.11.2021
            notificationIntentДляЗадачиОтказ = new Intent(context, Service_Notificatios_Для_Задания.class);
            // TODO: 24.03.2022
            // notificationIntentДляЗадачиОтказ.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // TODO: 03.03.2022
            notificationIntentДляЗадачиОтказ.setAction("ЗапускСогласованияПришедшегоЗАДАНИЕ");
            // TODO: 17.11.2021
            notificationIntentДляЗадачиОтказ.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);


            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putString("PROCESS_ID_Задачи", PROCESS_ID_УведомленияПлановая);
            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putString("ИмяСлужбыУведомленияДляЧата_Задачи", ИмяСлужбыУведомленияДляЧата);
            // TODO: 24.03.2022
            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putLong("UUIDПолучениейЗадачи", UUIDПолучениейЗадачи);
            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putString("ЗапускСогласованияПришедшегоЗАДАНИЕ", "ЗапускСогласованияПришедшегоЗАДАНИЕ");
// TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putInt("ДляЗадачиПередаемФлагВыполненаЗадчаИлиОтказ", ПередаемСтатусзадачи);

            // TODO: 24.03.2022
            notificationIntentДляЗадачиОтказ.putExtras(bundleДляПередачиВСлужбу);

            Log.d(context.getClass().getName(), "ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу "
                    + ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу + "  bundleДляПередачиВСлужбу " + bundleДляПередачиВСлужбу);


            if (notificationIntentДляЗадачиОтказ.resolveActivity(pm) != null) {
                // TODO: 24.03.2022
                ЗапускКОдаЧтоПОльзовательЗадачаВыполнилОтказ = PendingIntent.getService(context,
                        1, notificationIntentДляЗадачиОтказ,
                        PendingIntent.FLAG_MUTABLE | PendingIntent.FLAG_CANCEL_CURRENT); //PendingIntent.FLAG_UPDATE_CURRENT
                // TODO: 17.11.2021
                // Service_Notifocations_Для_Чата.enqueueWork(getApplicationContext(),notificationIntentДляУведомленийЗапускПаузы);

                // TODO: 03.03.2022

                /// ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием.send();

            }

            // TODO: 03.03.2022

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
            //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ
            Log.d(context.getClass().getName(), " Стоп СЛУЖБА СЛУЖБАService_Notifications ДЛЯ ЧАТА  onDestroy() Exception ");

        }
///TODO
        return ЗапускКОдаЧтоПОльзовательЗадачаВыполнилОтказ;
    }


    // TODO: 03.03.2022

    public PendingIntent МетодПриКликеЗапускаЗаданияИзСамогоУведомленияПереход(String PROCESS_ID_УведомленияПлановая,
                                                                               String ИмяСлужбыУведомленияДляЧата
            , Object UUIDПолучениейЗадачиОбьект, Integer ПередаемСтатусзадачи, String ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу) {
        ///
        PendingIntent ЗапускКОдаПереходИзУведомленияВЗадачу = null;

        try {

            Long UUIDПолучениейЗадачи = Long.parseLong(String.valueOf(UUIDПолучениейЗадачиОбьект));


            ///////TODO запускаем смены стануса задачи черезе PendingIntent
            Log.d(context.getClass().getName(), "PROCESS_ID_УведомленияПлановая " + PROCESS_ID_УведомленияПлановая +
                    " ИмяСлужбыУведомленияДляЧата " + ИмяСлужбыУведомленияДляЧата + "  UUIDПолучениейЗадачи " + UUIDПолучениейЗадачи +
                    " ПередаемСтатусзадачи " + ПередаемСтатусзадачи);


            PackageManager pm = context.getPackageManager();


// TODO: 17.11.2021 БЛОК КОДА РЕАЛИЗАЦИЯ БУДУШЕГО ЗАПУСКА ПРИ НАЖАТИИ НА УВЕДОСЛЕНИЕ ИЛИ НА КНОПКИ ЗАПУСКАЕТ С УВЕДОМЛЕНИЯ РАЗЛИЧНЫЕ ДЕЙСТВИЯ

            Intent notificationIntentДляЗапусказаданияИзУведомленияПереход;
            // TODO: 17.11.2021
            notificationIntentДляЗапусказаданияИзУведомленияПереход = new Intent(context, Service_Notificatios_Для_Задания.class);
            // TODO: 24.03.2022
            // TODO: 03.03.2022
            notificationIntentДляЗапусказаданияИзУведомленияПереход.setAction("ПереходВЗАДАНИЕИзУведомления");
            // TODO: 17.11.2021
            notificationIntentДляЗапусказаданияИзУведомленияПереход.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            // TODO: 26.03.2022
            // notificationIntentДляЗапусказаданияИзУведомленияПереход.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


            // TODO: 24.03.2022
            Bundle bundleДляПередачиВСлужбу = new Bundle();
            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putString("PROCESS_ID_УведомленияПлановая", PROCESS_ID_УведомленияПлановая);
            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putString("ИмяСлужбыУведомленияДляЧата", ИмяСлужбыУведомленияДляЧата);
            // TODO: 24.03.2022
            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putLong("UUIDПолучениейЗадачи", UUIDПолучениейЗадачи);
            // TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putString("ЗапускСогласованияПришедшегоЗАДАНИЕ", "ЗапускСогласованияПришедшегоЗАДАНИЕ");
// TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putInt("ПередаемСтатусзадачи", ПередаемСтатусзадачи);

            ///////todo
// TODO: 24.03.2022
            bundleДляПередачиВСлужбу.putString("ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу", ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу);
            // TODO: 24.03.2022
            notificationIntentДляЗапусказаданияИзУведомленияПереход.putExtras(bundleДляПередачиВСлужбу);

            Log.d(context.getClass().getName(), "ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу "
                    + ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу);


            if (notificationIntentДляЗапусказаданияИзУведомленияПереход.resolveActivity(pm) != null) {
                // TODO: 24.03.2022
                ЗапускКОдаПереходИзУведомленияВЗадачу = PendingIntent.getService(context,
                        2, notificationIntentДляЗапусказаданияИзУведомленияПереход,
                        PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_CANCEL_CURRENT); //PendingIntent.FLAG_UPDATE_CURRENT
                // TODO: 17.11.2021
                // Service_Notifocations_Для_Чата.enqueueWork(getApplicationContext(),notificationIntentДляУведомленийЗапускПаузы);

                // TODO: 03.03.2022

                /// ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием.send();

            }

            // TODO: 03.03.2022

        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
            //TODO ПЕРЕД СОЗДАНИЕМ НОВОГО СООБЕЩНИЯ ОБНУЛЯЕМ ПРДЫДУЩЕЕ
            Log.d(context.getClass().getName(), " Стоп СЛУЖБА СЛУЖБАService_Notifications ДЛЯ ЧАТА  onDestroy() Exception ");

        }
///TODO
        return ЗапускКОдаПереходИзУведомленияВЗадачу;
    }


}
