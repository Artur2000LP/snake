package com.artur.snake;

import com.artur.snake.entities.SnackEntity;
import com.artur.snake.entities.SnakeEntity;

import java.util.concurrent.ThreadLocalRandom;

public class GameEngine implements Runnable {

    private final SnackEntity snack;
    private final SnakeEntity snake;
    private final GameWindow window;
    private boolean exit = false;

    public GameEngine(GameWindow window) {
        this.snack = new SnackEntity(getRandomNumber(0, 425), getRandomNumber(0, 375));
        this.snake = new SnakeEntity();
        this.window = window;
        this.window.addEntity(snack);
    }

    @Override
    public void run() {
        new Thread(this::randomSnack).start();
        while (!exit) {
            System.out.println("soy infinito");
            sleep(1000);
        }
    }

    private void randomSnack() {
        while (!exit) {
            int x = getRandomNumber(0, window.getGamePanelWidth() - snack.getWidth());
            int y = getRandomNumber(0, window.getGamePanelHeight() - snack.getHeight());
            this.snack.setPosition(x, y);
            System.out.println("snack x: " + x);
            System.out.println("snack y: " + y);
            sleep(DefaultProvider.SNACK_TIMING_SECONDS);
        }
    }

    private static int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception ignored) {
        }
    }
}
