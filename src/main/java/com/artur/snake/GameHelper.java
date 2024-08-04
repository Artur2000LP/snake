package com.artur.snake;

import java.util.concurrent.ThreadLocalRandom;

public class GameHelper {


    public static int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void sleepSeconds(int seconds) {
        sleepMillis(seconds * 1000);
    }

    public static void sleepMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception ignored) {

        }
    }

}
