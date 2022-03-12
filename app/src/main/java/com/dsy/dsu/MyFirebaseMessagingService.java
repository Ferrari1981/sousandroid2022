package com.dsy.dsu;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.dsy.dsu.Code_For_Firebase_AndOneSignal_Здесь_КодДЛяСлужбыУведомленияFirebase.Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {


    // TODO: 02.12.2021
    public MyFirebaseMessagingService() {
        super();
        try{
            ///
        Log.w(this.getClass().getName(), " MyFirebaseMessagingService ПРИШЛО СООБЩЕНИЕ УВЕДОМЛЕНИЯ  С САЙТА ONESIGNAL !!!!!!!!!!!!  MyFirebaseMessagingService   metod onNewToken " );




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
    public void handleIntent(@NonNull Intent intent) {
       super.handleIntent(intent);
           /*     NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);


            notificationManager.cancelAll();*/

       Log.d(this.getClass().getName(), " handleIntent ПРИШЛО СООБЩЕНИЕ УВЕДОМЛЕНИЯ  С САЙТА ONESIGNAL !!!!!!!!!!!!  " +
               " MyFirebaseMessagingService  protected Intent public void handleIntent");
    }
    @NonNull
    @Override
    protected Intent getStartCommandIntent(@NonNull Intent intent) {

        Log.d(this.getClass().getName(), " getStartCommandIntent ПРИШЛО СООБЩЕНИЕ УВЕДОМЛЕНИЯ  С САЙТА ONESIGNAL !!!!!!!!!!!!  " +
                " MyFirebaseMessagingService  protected Intent getStartCommandIntent");
         return super.getStartCommandIntent(intent);

      /*     NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);


            notificationManager.cancelAll();*/

    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
      super.onMessageReceived(remoteMessage);

        try{

        Log.d(this.getClass().getName(), " onMessageReceived ПРИШЛО СООБЩЕНИЕ УВЕДОМЛЕНИЯ  С САЙТА ONESIGNAL !!!!!!!!!!!!  " +
                " MyFirebaseMessagingService   metod onNewToken "+remoteMessage.getMessageId()+"\n"+
              "  remoteMessage.getMessageType() "+  remoteMessage.getMessageType()+"\n"+
                "  remoteMessage.getRawData() "+remoteMessage.getRawData()+"\n"+
                 " remoteMessage.getSenderId()  " +remoteMessage.getSenderId());


        // TODO: 02.12.2021  ПРИШЛИ ДАННЫЕ ОТ FIREBASE CLOUD  НОВО СООБЕЩЕНИ И ИХ АНАЛИЗИРУЕМ И ЕСЛИ СООБЩЕНИЕ НЕ ПУСТОЕ МЫ УДАЛЯЕМ НОВТИВИКАЦИО ВИСЕВШЕЕ И СОЩЗДАЕНМ НВОЕ ЕЛСИ НЕСТЬ СООБЩЕНИ ТЕСТ СООБЩЕНИЯ
     Map<String, String> Уведоелмение= remoteMessage.getData();

        for (Map.Entry<String, String> entry: Уведоелмение.entrySet())
        {
            String key = entry.getKey();

            String value = entry.getValue();

            Log.d(this.getClass().getName(), " key "+key+"\n"+
                    " value "+value+"\n" );


            // TODO: 02.12.2021 модуль удаления

   /*       NotificationManager notificationManager = (NotificationManager)
                    getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

           StatusBarNotification[] statusBarNotifications= notificationManager.getActiveNotifications();

           for(StatusBarNotification statusBarNotification:statusBarNotifications){

               if(statusBarNotification.getId()!=12)

               notificationManager.cancel(statusBarNotification.getId());
           }*/

            Log.d(this.getClass().getName(),  "ПРИШЛО СООБЩЕНИЕ ОТ FIREBASE CLOUD И СМОТРИМ СОДЕРЖИМОЕ "+"\n"
                    +value+"\n"+ " key " +key+"\n"+
                    " entry.getValue() " +entry.getValue());


         if (entry.getValue().matches("(.*)android(.*)")) {


                    Log.d(this.getClass().getName(),  " value ЕСЛИ ЕСТЬ СООБЩЕНИ НАПИСАННО ДРУГИМ ПОЛЬОВАТЛЕМ ТО УДАЛЯЕМ УВЕДОМЛЕНИ И СОЗАДЕМ НОВЫЙ СЛУЖЮА BRODCAST"+value+"\n"+ " key " +key);



             Integer  ПубличныйIDДляОдноразовойСинхрониазции=   new Class_Generations_PUBLIC_CURRENT_ID(getApplicationContext()).ПолучениеПубличногоТекущегоПользователяID();


             Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента  ИЗ ВСЕХ ТАБЕЛЕЙ ПубличныйIDДляОдноразовойСинхрониазции " + ПубличныйIDДляОдноразовойСинхрониазции);





             // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР в даннм служаее все  правильно ТУТ ПОЛЬЗОВАТЕЛЬ ВЫЗЫВАЕМ САМ НА СЕБЯ СИНХРОНИАЗЦИЮ, СО
             // TODO: СО СВОИМ ПКБЛИЧНЫМ ID



            new Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).
                    МетодПовторногоЗапускаВсехWorkManager__ОДНОРАЗОВОЙСинхрониазцииданных(ПубличныйIDДляОдноразовойСинхрониазции,getApplicationContext());


                    Log.d(this.getClass().getName(),  "   ЗАПУСК ОДНОРАЗОВОЙ СИНХРОНИАЗЦИИ" +
                            "      new  Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаВсехWorkManagerОДНОРАЗОВОЙСинхрониазцииданных()  " +
                            "ПОСЛЕ ЗАПУСКА БРОДКАСТЕРА ПОСЛЕ СИСТЕМНОГО УЕДОМДЕНИЯ КОТОРЫЙ И ЗАПУСТИЛ ЭТО  И СОЗАДЕМ НОВЫЙ СЛУЖЮА BRODCAST  FAREBASE " +
                            " МетодОдноразовыйЗапускВоерМенеджера(getApplicationContext(),ПубличныйIDДляОдноразовойСинхрониазции"+value+"\n" );





             // TODO: 30.12.2021  запуск уведомелния


             new  Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаУведомленияДляОдноразовойСинхрониазации();


             Log.d(this.getClass().getName(),  "  Запуск уведомления \n" +
                     "             new  Class_Generation_SendBroadcastReceiver_And_Firebase_OneSignal(getApplicationContext()).МетодПовторногоЗапускаВсехWorkManagerУведедомления(); " +
                     "ПОСЛЕ ЗАПУСКА БРОДКАСТЕРА ПОСЛЕ СИСТЕМНОГО УЕДОМДЕНИЯ КОТОРЫЙ И ЗАПУСТИЛ ЭТО  И СОЗАДЕМ НОВЫЙ СЛУЖЮА BRODCAST  FAREBASE " +
                     " МетодОдноразовыйЗапускВоерМенеджера(getApplicationContext(),ПубличныйIDДляОдноразовойСинхрониазции"+value+"\n" );


                    break;
           }


        }


        Log.d(this.getClass().getName(), " Уведоелмение "+Уведоелмение.values());


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
    public void onDeletedMessages() {
        super.onDeletedMessages();
        ////
        Log.d(this.getClass().getName(), " onDeletedMessages ПРИШЛО СООБЩЕНИЕ УВЕДОМЛЕНИЯ  С САЙТА ONESIGNAL !!!!!!!!!!!!   MyFirebaseMessagingService   metod onNewToken " );
    }

    @Override
    public void onMessageSent(@NonNull String s) {
        super.onMessageSent(s);

        try{
        /////

/*        String КлючДляFirebaseNotification="2a1819db-60c8-4ca3-a752-1b6cd9cadfa1";

   FirebaseMessaging.getInstance().subscribeToTopic("adroid");

            RemoteMessage rm = new RemoteMessage.Builder(КлючДляFirebaseNotification)
                    .setMessageId("myApp_" + + System.currentTimeMillis())
                    .addData("action", "chat")
                    .addData("destinataire", "ee")
                    .addData("emetteur","ee")
                    .setTtl(0)
                    .build();
            FirebaseMessaging.getInstance().send(rm);*/
        ////
        Log.d(this.getClass().getName(), " onMessageSent ПРИШЛО СООБЩЕНИЕ УВЕДОМЛЕНИЯ  С САЙТА ONESIGNAL !!!!!!!!!!!!   MyFirebaseMessagingService   metod onNewToken "+s.toString() );






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
    public void onSendError(@NonNull String s, @NonNull Exception e) {
        super.onSendError(s, e);
        Log.e(this.getClass().getName(), " onSendError  ОШИБКА  ПРИШЛО СООБЩЕНИЕ УВЕДОМЛЕНИЯ  С САЙТА ONESIGNAL " +
                "!!!!!!!!!!!!  MyFirebaseMessagingService   metod onNewToken e  "+e.toString()+"\n"+
                " s " +s.toString());
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.d(this.getClass().getName(), " onNewToken  ПРИШЛО СООБЩЕНИЕ УВЕДОМЛЕНИЯ  С САЙТА ONESIGNAL !!!!!!!!!!!!   MyFirebaseMessagingService   metod onNewToken "+s.toString());

    }


}
