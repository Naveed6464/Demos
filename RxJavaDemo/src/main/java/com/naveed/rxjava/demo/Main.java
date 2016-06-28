package com.naveed.rxjava.demo;

import java.util.Arrays;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class Main {

    public static void main(String[] args) {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> sub) {
                sub.onNext("One");
                sub.onNext("Two");
                sub.onCompleted();
            }
        });
        observable.subscribe(new Observer<String>() {

            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Error");
            }

            @Override
            public void onNext(String msg) {
                System.out.println(">>> " + msg);
            }
        });

        //Simple
        Observable.just("Hello, world!").subscribe(s -> System.out.println(s));

        Observable<Integer> obs = Observable.from(Arrays.asList(1, 3, 5, 7, 9));
        obs = obs.skip(1).take(3).map(i -> i * i);
        obs.subscribe(s -> System.out.println(s));
    }
}
