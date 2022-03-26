package com.dsy.dsu;


import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.dsy.dsu.Code_For_Tasks_КодДля_Задания.MainActivity_Tasks;

public class SubClass_Starting_chahge_status_public_notificaton {
    Context context;

    public SubClass_Starting_chahge_status_public_notificaton(Context context) {
        // TODO: 03.03.2022
        this.context = context;
    }


    // TODO: 03.03.2022

    public PendingIntent МетодЗапускаСменыСтатусаСлужбыЧерезPendingIntent(String PROCESS_ID_УведомленияПлановая,
                                                                          String ИмяСлужбыУведомленияДляЧата
            , Object UUIDПолучениейЗадачиОбьект, Integer ПередаемСтатусзадачи, String ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу) {
        ///
        PendingIntent ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием = null;

        try {

            Long UUIDПолучениейЗадачи = Long.parseLong(String.valueOf(UUIDПолучениейЗадачиОбьект));


            ///////TODO запускаем смены стануса задачи черезе PendingIntent
            Log.d(context.getClass().getName(), "PROCESS_ID_УведомленияПлановая " + PROCESS_ID_УведомленияПлановая +
                    " ИмяСлужбыУведомленияДляЧата " + ИмяСлужбыУведомленияДляЧата + "  UUIDПолучениейЗадачи " + UUIDПолучениейЗадачи +
                    " ПередаемСтатусзадачи " + ПередаемСтатусзадачи);


            PackageManager pm = context.getPackageManager();


// TODO: 17.11.2021 БЛОК КОДА РЕАЛИЗАЦИЯ БУДУШЕГО ЗАПУСКА ПРИ НАЖАТИИ НА УВЕДОСЛЕНИЕ ИЛИ НА КНОПКИ ЗАПУСКАЕТ С УВЕДОМЛЕНИЯ РАЗЛИЧНЫЕ ДЕЙСТВИЯ

            Intent notificationIntentДляУведомленийЗапускСогласования;
            // TODO: 17.11.2021
            notificationIntentДляУведомленийЗапускСогласования = new Intent(context, Service_Notificatios_Для_Задания.class);
            // TODO: 24.03.2022
            // TODO: 03.03.2022
            notificationIntentДляУведомленийЗапускСогласования.setAction("ЗапускСогласованияПришедшегоЗАДАНИЕ");
            // TODO: 17.11.2021
            notificationIntentДляУведомленийЗапускСогласования.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);


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
            notificationIntentДляУведомленийЗапускСогласования.putExtras(bundleДляПередачиВСлужбу);

            Log.d(context.getClass().getName(), "ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу "
                    + ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу);


            if (notificationIntentДляУведомленийЗапускСогласования.resolveActivity(pm) != null) {
                // TODO: 24.03.2022
                ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием = PendingIntent.getService(context,
                        10, notificationIntentДляУведомленийЗапускСогласования,
                        PendingIntent.FLAG_IMMUTABLE); //PendingIntent.FLAG_UPDATE_CURRENT
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
        return ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием;
    }

// TODO: 26.03.2022 код для ЗАДАНИЯ КОТОРЫЙ СРАБАТЫВАЕТ КОГДАНА САМО УВЕДОМЛЕНИЯ ЗАДАНИЕ НАЖАЛИ


    // TODO: 03.03.2022

    public PendingIntent МетодЗапускаЗаданияИзСамогоУведомленияПереход(String PROCESS_ID_УведомленияПлановая,
                                                                       String ИмяСлужбыУведомленияДляЧата
            , Object UUIDПолучениейЗадачиОбьект, Integer ПередаемСтатусзадачи, String ПримечаниеВыполнилКлиентИлиНетЗадачуПришлиВСлужбу) {
        ///
        PendingIntent ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием = null;

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
            notificationIntentДляЗапусказаданияИзУведомленияПереход = new Intent(context, MainActivity_Tasks.class);
            // TODO: 24.03.2022
            // TODO: 03.03.2022
            notificationIntentДляЗапусказаданияИзУведомленияПереход.setAction("ЗапускСогласованияПришедшегоЗАДАНИЕ");
            // TODO: 17.11.2021
            notificationIntentДляЗапусказаданияИзУведомленияПереход.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            // TODO: 26.03.2022
            notificationIntentДляЗапусказаданияИзУведомленияПереход.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


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
                ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием = PendingIntent.getService(context,
                        47, notificationIntentДляЗапусказаданияИзУведомленияПереход,
                        PendingIntent.FLAG_IMMUTABLE); //PendingIntent.FLAG_UPDATE_CURRENT
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
        return ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием;
    }


}
