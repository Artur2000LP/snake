package com.artur.snake;

import java.util.concurrent.ThreadLocalRandom;

public class GameHelper {


    public static  int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static  void  sleep(int seconds){
        try {
            int millis = seconds * 1000 ;
            Thread.sleep(millis);
        }catch (Exception ignored){

        }
    }

}
