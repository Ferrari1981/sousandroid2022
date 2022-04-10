package com.dsy.dsu;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.Date;

public class SubClass_Delete_File_FOr_MainActivity_Face_App {


    protected Integer МетодДополнительногоУдалениеФайлов(Context context) {


        Integer РезультатУдаления = 0;
        try {


/////TODO  УДАЛЕНИЕ .JSON ФАЙЛА
            File ФайлыДляОбновлениеПОУдалениеПриАнализеJSONВерсии = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS);
            // TODO: 10.04.2022
            Boolean[] ФайлУдаления = new Boolean[10];

            File[] Files = ФайлыДляОбновлениеПОУдалениеПриАнализеJSONВерсии.listFiles();

            if (Files != null) {
                int j;
                for (j = 0; j < Files.length; j++) {
                    String ИмяФайла = Files[j].getName();
                    // TODO: 10.04.2022
                    ФайлУдаления[0] = ИмяФайла.matches("(.*)json(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");
                    ФайлУдаления[1] = ИмяФайла.matches("(.*)analysis_version(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");
                    ФайлУдаления[2] = ИмяФайла.matches("(.*)output-metadata.json(.*)");
                    ФайлУдаления[3] = ИмяФайла.matches("(.*)apk(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");
                    ФайлУдаления[4] = ИмяФайла.matches("(.*)update_dsu1(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");
                    ФайлУдаления[5] = ИмяФайла.matches("(.*)update_dsu1.apk(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");

                    // TODO: 10.04.2022
                    Log.d(this.getClass().getName(), " СЛУЖБА  ТАКОГО ФАЙЛА БОЛЬШЕ НЕТ  .JSON АНАЛИЗ " + Files[j].length()
                            + "   путь файла " + Files[j].getAbsolutePath() + "   --- " + new Date() + " ИмяФайла " + ИмяФайла);

                    if (ФайлУдаления[0] = true || ФайлУдаления[1] == true ||
                            ФайлУдаления[2] == true || ФайлУдаления[3] == true ||
                            ФайлУдаления[4] == true || ФайлУдаления[5] == true) {
                        // TODO: 10.04.2022
                        if (Files[j].exists()) {
                            // TODO: 10.04.2022
                            Files[j].delete();
                            // TODO: 10.04.2022
                            Log.d(this.getClass().getName(), " СЛУЖБА  ТАКОГО ФАЙЛА БОЛЬШЕ НЕТ  .JSON АНАЛИЗ " + Files[j].length()
                                    + "   путь файла " + Files[j].getAbsolutePath() + "   --- " + new Date() + " ИмяФайла " + ИмяФайла);

                        }
                        //

                    }
                    ////    ФайлыДляОбновлениеПОУдаление.delete();

                }//ещыыщ
            }



        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

            Log.d(this.getClass().getName(), " ошибка  faceapp из меню МетодДополнительногоУдалениеФайлов Обновление ПО ");

            РезультатУдаления = null;

        }
        return РезультатУдаления;
    }
}
