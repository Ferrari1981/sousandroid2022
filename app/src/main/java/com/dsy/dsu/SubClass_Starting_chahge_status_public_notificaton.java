package com.dsy.dsu;


import static android.content.Context.NOTIFICATION_SERVICE;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

public class SubClass_Starting_chahge_status_public_notificaton {
    Context context;

    public SubClass_Starting_chahge_status_public_notificaton(Context context) {
        // TODO: 03.03.2022
        this.context=context;
    }


    // TODO: 03.03.2022

    public PendingIntent МетодЗапускаСменыСтатусаСлужбыЧерезPendingIntent(String PROCESS_ID_УведомленияПлановая,
                                                                          String ИмяСлужбыУведомленияДляЧата
            , String UUIDПолучениейЗадачи) {
        ///
        PendingIntent ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием = null;

        try{
        ///////TODO запускаем смены стануса задачи черезе PendingIntent
        Log.d(context.getClass().getName(), "PROCESS_ID_УведомленияПлановая "+PROCESS_ID_УведомленияПлановая +
                " ИмяСлужбыУведомленияДляЧата " +ИмяСлужбыУведомленияДляЧата + "  UUIDПолучениейЗадачи " +UUIDПолучениейЗадачи);


            PackageManager pm = context.getPackageManager();


// TODO: 17.11.2021 БЛОК КОДА РЕАЛИЗАЦИЯ БУДУШЕГО ЗАПУСКА ПРИ НАЖАТИИ НА УВЕДОСЛЕНИЕ ИЛИ НА КНОПКИ ЗАПУСКАЕТ С УВЕДОМЛЕНИЯ РАЗЛИЧНЫЕ ДЕЙСТВИЯ

            Intent notificationIntentДляУведомленийЗапускСогласования ;
            // TODO: 17.11.2021
            notificationIntentДляУведомленийЗапускСогласования = new Intent(context, Service_Notificatios_Для_Чата.class);
            notificationIntentДляУведомленийЗапускСогласования.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //notificationIntentЗакрыть.addCategory(Intent.CATEGORY_LAUNCHER);;
            Uri uri = Uri.parse(PROCESS_ID_УведомленияПлановая);
            notificationIntentДляУведомленийЗапускСогласования.setData(uri);
            notificationIntentДляУведомленийЗапускСогласования.addCategory(ИмяСлужбыУведомленияДляЧата);

            // TODO: 07.02.2022  Вытаскием Знасение ДЛяСогдаоснвании что будет ознакомлен  person
            notificationIntentДляУведомленийЗапускСогласования.addCategory(UUIDПолучениейЗадачи);
            // TODO: 03.03.2022
            notificationIntentДляУведомленийЗапускСогласования.setAction("ЗапускСогласованияПришедшегоЗАДАНИЕ");
            ///////



            if (notificationIntentДляУведомленийЗапускСогласования.resolveActivity(pm) != null) {
                ЗапускКОдаЧтоПОльзовательОзнаомленсЗаданием = PendingIntent.getService(context,
                        10,notificationIntentДляУведомленийЗапускСогласования,
                        PendingIntent.FLAG_IMMUTABLE); //PendingIntent.FLAG_UPDATE_CURRENT
                // TODO: 17.11.2021
                // Service_Notificatios_Для_Чата.enqueueWork(getApplicationContext(),notificationIntentДляУведомленийЗапускПаузы);

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





}
