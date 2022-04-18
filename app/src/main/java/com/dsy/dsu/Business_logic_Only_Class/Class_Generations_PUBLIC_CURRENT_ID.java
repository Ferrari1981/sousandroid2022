package com.dsy.dsu.Business_logic_Only_Class;

import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.util.Log;

import com.dsy.dsu.CREATE_DATABASE;
import com.dsy.dsu.PUBLIC_CONTENT;

import java.util.concurrent.ExecutionException;

public class Class_Generations_PUBLIC_CURRENT_ID {

    Context contextДляКлассПУБЛИЧНЫЙID;

    public Class_Generations_PUBLIC_CURRENT_ID(Context context) {

        contextДляКлассПУБЛИЧНЫЙID=context;
        ///
    }


    //todo функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ


    // TODO: 27.12.2021  public id

    public Integer ПолучениеПубличногоТекущегоПользователяID() {
        ///TODO --первая вставка

        Integer ПубличныйIDДляФрагмента = 0;
        try{
            SQLiteCursor Курсор_ВычисляемПУбличныйIDПриСозданииНовогоСообщения = null;


            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ

            // TODO: 26.08.2021 НОВЫЙ ВЫЗОВ НОВОГО КЛАСС GRUD - ОПЕРАЦИИ
            Class_GRUD_SQL_Operations class_grud_sql_operationsРабоатемВФрагментечитатьПисатьШестаяЧасть = new Class_GRUD_SQL_Operations(contextДляКлассПУБЛИЧНЫЙID);
            ///
            class_grud_sql_operationsРабоатемВФрагментечитатьПисатьШестаяЧасть.concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций.put("СамFreeSQLКОд",
                    " SELECT id FROM SuccessLogin ORDER BY date_update DESC LIMIT 1 ");


            ////
            Курсор_ВычисляемПУбличныйIDПриСозданииНовогоСообщения = null;
            ///////
            try {
                Курсор_ВычисляемПУбличныйIDПриСозданииНовогоСообщения = (SQLiteCursor) class_grud_sql_operationsРабоатемВФрагментечитатьПисатьШестаяЧасть.
                        new GetаFreeData(contextДляКлассПУБЛИЧНЫЙID).getfreedata(class_grud_sql_operationsРабоатемВФрагментечитатьПисатьШестаяЧасть.
                                concurrentHashMapНаборПараментовSQLBuilder_Для_GRUD_Операций,
                        new PUBLIC_CONTENT(contextДляКлассПУБЛИЧНЫЙID).МенеджерПотоков
                        , new CREATE_DATABASE(contextДляКлассПУБЛИЧНЫЙID).getССылкаНаСозданнуюБазу());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.d(this.getClass().getName(), "GetData " + Курсор_ВычисляемПУбличныйIDПриСозданииНовогоСообщения);


            // TODO: 09.09.2021 resultat
            /////
            if (Курсор_ВычисляемПУбличныйIDПриСозданииНовогоСообщения.getCount() > 0) {
                //////////
                Курсор_ВычисляемПУбличныйIDПриСозданииНовогоСообщения.moveToFirst();
                //////////////
                ПубличныйIDДляФрагмента = Курсор_ВычисляемПУбличныйIDПриСозданииНовогоСообщения.getInt(0);
                //////


                //
                Log.d(this.getClass().getName(), "  ФИНАЛ ФОНОВАЯ  СИНХРОНИЗАЦИИ СЛУЖБА КОЛИЧЕСТВО УСПЕШНЫХ ВСТАКОВ полученный публичный id ПЕРЕД ВСТАВКОЙ"
                        + " ПубличныйIDДляФрагмента " + ПубличныйIDДляФрагмента);


            }


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());

            // TODO: 01.09.2021 метод вызова
            new   Class_Generation_Errors(contextДляКлассПУБЛИЧНЫЙID).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            ///


        }
        return  ПубличныйIDДляФрагмента;
    }
}