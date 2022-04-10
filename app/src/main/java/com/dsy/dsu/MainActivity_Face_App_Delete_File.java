package com.dsy.dsu;

import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.Date;

public abstract class MainActivity_Face_App_Delete_File extends AppCompatActivity {
    private Integer МетодДополнительногоУдалениеФайлов() {


        Integer РезультатУдаления = 0;
        try {


/////TODO  УДАЛЕНИЕ .JSON ФАЙЛА
               /* File  ФайлыДляОбновлениеПОУдаление = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS + "/" + "*.json");*/

            File ФайлыДляОбновлениеПОУдалениеПриАнализеJSONВерсии = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS);

            File[] Files = ФайлыДляОбновлениеПОУдалениеПриАнализеJSONВерсии.listFiles();

            if (Files != null) {
                int j;
                for (j = 0; j < Files.length; j++) {
                    String ИмяФайла = Files[j].getName();
                    boolean ПосикПоНазваниюФайла = ИмяФайла.matches("(.*)json(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");
                    boolean ПосикПоНазваниюФайлаРасширенная = ИмяФайла.matches("(.*)analysis_version(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");
                    boolean ПосикПоНазваниюФайлаРасширенная2 = ИмяФайла.matches("(.*)output-metadata.json(.*)");

                    if (ПосикПоНазваниюФайла == true || ПосикПоНазваниюФайлаРасширенная == true || ПосикПоНазваниюФайлаРасширенная2 == true) {
                        if (Files[j].exists()) {
                            Files[j].delete();
                        }
                        //
                        /////
                        if (!Files[j].isFile()) {
                            Log.d(this.getClass().getName(), " СЛУЖБА  ТАКОГО ФАЙЛА БОЛЬШЕ НЕТ  .JSON АНАЛИЗ " + Files[j].length()
                                    + "   путь файла " + Files[j].getAbsolutePath() + "   --- " + new Date() + " ИмяФайла " + ИмяФайла);
                        }
                    }
                    ////    ФайлыДляОбновлениеПОУдаление.delete();

                }//ещыыщ
            }


            /////TODO  УДАЛЕНИЕ .JSON ФАЙЛА
               /* File  ФайлыДляОбновлениеПОУдаление = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS + "/" + "*.json");*/

            if (Files != null) {
                int j;
                for (j = 0; j < Files.length; j++) {
                    String ИмяФайла = Files[j].getName();
                    boolean ПосикПоНазваниюФайла = ИмяФайла.matches("(.*)apk(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");
                    boolean ПосикПоНазваниюФайлаРасширенная = ИмяФайла.matches("(.*)update_dsu1(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");
                    boolean ПосикПоНазваниюФайлаРасширенная2 = ИмяФайла.matches("(.*)update_dsu1.apk(.*)");//    boolean ПосикПоНазваниюФайла=Files[j].getName().matches("(.*).json(.*)");


                    if (ПосикПоНазваниюФайла == true || ПосикПоНазваниюФайлаРасширенная == true || ПосикПоНазваниюФайлаРасширенная2 == true) {
                        if (Files[j].exists()) {
                            Files[j].delete();
                        }
                        //
                        /////
                        if (!Files[j].isFile()) {
                            Log.d(this.getClass().getName(), " СЛУЖБА  ТАКОГО ФАЙЛА БОЛЬШЕ НЕТ  .JSON АНАЛИЗ " + Files[j].length()
                                    + "   путь файла " + Files[j].getAbsolutePath() + "   --- " + new Date() + " ИмяФайла " + ИмяФайла);
                        }
                    }
                    ////    ФайлыДляОбновлениеПОУдаление.delete();

                }//ещыыщ
            }


        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());

            Log.d(this.getClass().getName(), " ошибка  faceapp из меню МетодДополнительногоУдалениеФайлов Обновление ПО ");

            РезультатУдаления = null;

        }
        return РезультатУдаления;
    }
}
