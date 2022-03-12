package com.dsy.dsu;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Class_Generations_RxJava2 {

    Activity contextДляКлассRxJava2;

    public Class_Generations_RxJava2(Activity activity) {

        contextДляКлассRxJava2=activity;
        ///

      /*  Observable<StringBuffer> observable = Observable.just(1);
        observable.subscribeOn(Schedulers.computation())
                .subscribe(
                        new Observer<StringBuffer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                // TODO: 02.09.2021
                                Log.d(MODEL_synchronized.class.getName(), " PUBLIC_CONTENT.БуферРезуоотатРаботыБазыВсестеССервером " );
                            }

                            @Override
                            public void onNext(@NonNull StringBuffer stringBuffer) {

                            }

                            @Override
                            public void onError(Throwable e) {
                                // TODO: 02.09.2021
                                Log.d(MODEL_synchronized.class.getName(), " PUBLIC_CONTENT.БуферРезуоотатРаботыБазыВсестеССервером " );
                            }

                            @Override
                            public void onComplete() {
                                // TODO: 02.09.2021
                                Log.d(MODEL_synchronized.class.getName(), " PUBLIC_CONTENT.БуферРезуоотатРаботыБазыВсестеССервером " );

                                observable.subscribeOn(AndroidSchedulers.mainThread())
                                        .subscribe ((ddd)->{
                                            Log.d(MODEL_synchronized.class.getName(), " PUBLIC_CONTENT.БуферРезуоотатРаботыБазыВсестеССервером " );

                                            // TODO: 24.09.2021

                                            Toast.makeText(contextДляКлассRxJava2, " Превый RXJAVA 2" , Toast.LENGTH_SHORT).show();


                                        }  );


                            }


                        });*/
    }



    //todo функция получающая время операции ДАННАЯ ФУНКЦИЯ ВРЕМЯ ПРИМЕНЯЕТЬСЯ ВО ВСЕЙ ПРОГРАММЕ

}
