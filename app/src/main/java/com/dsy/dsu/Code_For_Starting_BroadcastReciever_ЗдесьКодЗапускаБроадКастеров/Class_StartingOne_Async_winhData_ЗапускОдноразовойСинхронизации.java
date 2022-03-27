package com.dsy.dsu.Code_For_Starting_BroadcastReciever_ЗдесьКодЗапускаБроадКастеров;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.dsy.dsu.Class_Generation_Errors;
import com.dsy.dsu.Class_Generations_PUBLIC_CURRENT_ID;
import com.dsy.dsu.Class_Generator_One_WORK_MANAGER;

import java.util.Date;

public class Class_StartingOne_Async_winhData_ЗапускОдноразовойСинхронизации {



    public void МетодЗапускОдноразовойСинхронизации(Context context, Integer ВходящиеПараментыБродКсстера ) {
        try {


            Log.i(this.getClass().getName(), " ЗАПУСК BroadcastReceiver_Sous_Asyns_Glassfish_One_ОдноразоваяСинхронизация   public void onReceive(Context context, Intent intent)" +
                    " ........ СНАРУЖИ BroadcastReceiver_Sous_Asyns_Glassfish_DISTR=OY  (intent.getAction()   СЛУЖБА" + " время запуска  " + new Date() + "\n" +
                    " ВходящиеПараментыБродКсстера " + ВходящиеПараментыБродКсстера +
                    "  ВходящиеОдноразовогоЧтоДелатьБродКсстера ВходящиеПараментыБродКсстера  " + ВходящиеПараментыБродКсстера);

            // TODO: 18.04.2021 запувскает широковещатель

            ///
            Log.i(this.getClass().getName(), " Внутри Broadcatrecever (intent.getAction()   СЛУЖБА кто ЗАПУСТИЛ САМ bRODCAST ? :::" +  "\n" +
                    " Build.BRAND.toString() Название Телефона " + Build.BRAND.toString());


            // TODO: 07.10.2021


            ///
            Log.i(this.getClass().getName(), " Внутри Broadcatrecever (intent.getAction()   ВходящиеПараментыБродКсстера" + ВходящиеПараментыБродКсстера);


            // TODO: 29.09.2021     ЗАПУСК BROADCAST СИНХРОНИАЗЦИИ


            if (ВходящиеПараментыБродКсстера > 0) {


                // TODO: 10.11.2021
/*
                        new Class_Generation_WORK_MANGER_DIRECT(context).МетодЗапускаСинхоронизацииИзШироковещательногоПриёмника(context,ВходящиеПараментыБродКсстера);*/

                // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР

                new Class_Generator_One_WORK_MANAGER(context).МетодОдноразовыйЗапускВоерМенеджера(context, ВходящиеПараментыБродКсстера);

                // TODO: 15.12.2021
                Log.w(context.getClass().getName(), " ПОСЛЕ ОТРАБОТКИ МЕТОДА с пользователем  " +
                        "....Внутри BroadcastReceiver_Sous_Asyns_Glassfish_One_ОдноразоваяСинхронизация periodicWorkRequestСинхронизация.getId() ВходящиеПараментыБродКсстера "
                        + ВходящиеПараментыБродКсстера + "\n");

            } else {


                // TODO: 30.09.2021 МЕТОД ЗАПУСКА СИНХРОНИЗАЦИИ ЧАТА ПО РАСПИСАНИЮ , НЕ ВЗАВИСИМОСТИ ОТ СОЗДАВАЛ ЛИ СООБЩЕНИЕ ИЛИ НЕТ

                Integer ПубличныйIDДляФрагмента = new Class_Generations_PUBLIC_CURRENT_ID(context).ПолучениеПубличногоТекущегоПользователяID();


                Log.d(this.getClass().getName(), "ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);

                // TODO: 29.12.2021

                if (ПубличныйIDДляФрагмента == null) {
                    // TODO: 29.12.2021
                    ПубличныйIDДляФрагмента = 0;
                }

                // TODO: 14.11.2021  ПОВТОРЫЙ ЗАПУСК ВОРК МЕНЕДЖЕР

                new Class_Generator_One_WORK_MANAGER(context).МетодОдноразовыйЗапускВоерМенеджера(context, ПубличныйIDДляФрагмента);


                // TODO: 15.12.2021
                Log.w(context.getClass().getName(), " ПОСЛЕ ОТРАБОТКИ МЕТОДА без пользователя " +
                        "....Внутри BroadcastReceiver_Sous_Asyns_Glassfish_One_ОдноразоваяСинхронизация periodicWorkRequestСинхронизация.getId() БЕЗ ПАРАМЕТРА ВходящиеПараментыБродКсстера "
                        + ВходящиеПараментыБродКсстера + "\n" + " ПубличныйIDДляФрагмента " +ПубличныйIDДляФрагмента);


            }
            /////

            Log.i(this.getClass().getName(), " ВЫХОД ИЗ МЕТОДА     МетодЗапускаСинхоронизацииИзШироковещательногоПриёмника(context); " +
                    " BroadcastReceiver_Sous_Asyns_Glassfish_One_ОдноразоваяСинхронизация(intent.getAction()   СЛУЖБА кто ЗАПУСТИЛ САМ bRODCAST ? :::" +ВходящиеПараментыБродКсстера + "\n" +
                    " Build.BRAND.toString() Название Телефона " + Build.BRAND.toString());


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context.getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            ;
            Log.e(context.getClass().getName(), " ОШИБКА В BroadcastReceiver_Sous_Notificatioons_For_Tasks  СЛУЖБА  public void onReceive  " + " ОШИБКА ::" + e.toString());


        }
    }
}
