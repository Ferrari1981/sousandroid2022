package com.dsy.dsu;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Stream;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class КЛАСС_ДЛЯТЕСТИРОВАНИЯRXJAVA3 {


    public КЛАСС_ДЛЯТЕСТИРОВАНИЯRXJAVA3(Context context) throws ExecutionException, InterruptedException {

        Cursor cursorКАКПРИМЕР = null;


        Completable completable=   Completable.fromAction(new Action() {
            @Override
            public void run() throws Throwable {
               int f= cursorКАКПРИМЕР.getCount();
                Log.w(context.getClass().getName(), "  SRART UPDAET SOFT" );

           /*     AsyncQueryHandler asyncQueryHandler= new AsyncQueryHandler(context.getContentResolver()){


                    @Override
                    public void startQuery(int token, Object cookie, Uri uri, String[] projection, String selection, String[] selectionArgs, String orderBy) {
                        super.startQuery(token, cookie, uri, projection, selection, selectionArgs, orderBy);

                    }

                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                    }

                    @NonNull
                    @Override
                    public String getMessageName(@NonNull Message message) {
                        return super.getMessageName(message);
                    }
                };
                asyncQueryHandler.obtainMessage(1);
                asyncQueryHandler.startDelete(null,);*/
           /*     Stream<Character> testStream = Stream.of('a', 'b', 'c');

                String result = testStream.collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));*/
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {

                Log.w(context.getClass().getName(), "  SRART UPDAET SOFT" );
                int f= cursorКАКПРИМЕР.getPosition();
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Throwable {
                Uri f2= cursorКАКПРИМЕР.getNotificationUri();

            }
        })
                .onErrorComplete(new Predicate<Throwable>() {
                    @Override
                    public boolean test(Throwable throwable) throws Throwable {
                        return false;
                    }
                })
                .subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());

        completable.blockingSubscribe(System.out::println);
// TODO: 10.01.2022



        Log.w(context.getClass().getName(), "  SRART UPDAET SOFT" );



 SUBClass_ОтКлассаКЛАСС_ДЛЯТЕСТИРОВАНИЯRXJAVA3от subClass_отКлассаКЛАСС_длятестированияrxjava3от=new SUBClass_ОтКлассаКЛАСС_ДЛЯТЕСТИРОВАНИЯRXJAVA3от();
        // TODO: 21.01.2022  s
        subClass_отКлассаКЛАСС_длятестированияrxjava3от.ddddddddddddddddddddddddddddddddddddddddddddddddddddd();


    }


 class SUBClass_ОтКлассаКЛАСС_ДЛЯТЕСТИРОВАНИЯRXJAVA3от {
        public SUBClass_ОтКлассаКЛАСС_ДЛЯТЕСТИРОВАНИЯRXJAVA3от() {
        }

        void ddddddddddddddddddddddddddddddddddddddddddddddddddddd() {
            Log.w(this.getClass().getName(), "  SUB SUB SUB SUB  UPDAET SOFT SUBClass_ОтКлассаКЛАСС_ДЛЯТЕСТИРОВАНИЯRXJAVA3от" );

        }
    }
}
class rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr{



    void ddd(){


/*    LinkedBlockingQueue arrayList= Observable.fromIterable(mSettlementList)
                .delay(700, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(iStr -> iStr.toLowerCase().contains(iQuery.toLowerCase()))
                .toSortedList()
                .blockingGet();*/
    }
private  class testehandler{
/*    Handler handlerДляСлушателяWorkMangerНаФрагментеЧитатьИПисать=new Handler();
    Message message=Message.obtain(handlerДляСлушателяWorkMangerНаФрагментеЧитатьИПисать);
    message.obj=1;
    Object objectHello="d";
    Bundle bundle=new Bundle();
        bundle.putSerializable("objectss", (Serializable) objectHello);
        message.setData(bundle);
        message.setAsynchronous(true);

        handlerДляСлушателяWorkMangerНаФрагментеЧитатьИПисать.sendMessage(message);

        handlerДляСлушателяWorkMangerНаФрагментеЧитатьИПисать.handleMessage(message);
    Bundle bundle1=   message.getData();

    Object objectBallCalls=   bundle1.getSerializable("objectss");

        Log.d(this.getClass().getName(), "  message.obj "+  message.obj.toString()+ " objectBallCalls "+objectBallCalls.toString() );*/
}
}



/*            //////////
            class sss{
                int fff;
                long ggg;


                public sss(int fff, long ggg) {
                    this.fff = fff;
                    this.ggg = ggg;
                }

                public int getFff() {
                    return fff;
                }

                public void setFff(int fff) {
                    this.fff = fff;
                }

                public long getGgg() {
                    return ggg;
                }

                public void setGgg(long ggg) {
                    this.ggg = ggg;
                }


            }

            Stream.Builder<sss> builder = Stream.builder();

            builder.add( new sss(1, 2l) {
                // TODO: 01.03.202
            });

            builder.build();*/