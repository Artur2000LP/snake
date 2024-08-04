package com.artur.snake;

import com.artur.snake.entities.SnackEntity;
import com.artur.snake.entities.Snake;


public class GameEngine implements Runnable {

    private final SnackEntity snack;
    private final Snake snake;
    private final GameWindow window;
    private boolean exit = false;

    public GameEngine(GameWindow window) {
        this.snack = new SnackEntity(0, 0);
        this.snake = new Snake();
        this.window = window;
        this.window.addEntity(snack);
        this.window.addEntities(snake.getBody());
    }

    @Override
    public void run() {
        new Thread(this::moveSnake).start();
        new Thread(this::randomSnack).start();
        while (!exit) {
            System.out.println("soy infinito");
            GameHelper.sleepSeconds(1000);
        }
    }

    private void randomSnack() {
        while (!exit) {
            int x = GameHelper.getRandomNumber(0, window.getGamePanelWidth() - snack.getWidth());
            int y = GameHelper.getRandomNumber(0, window.getGamePanelHeight() - snack.getHeight());
            this.snack.setPosition(x, y);
            System.out.println("snack x: " + x);
            System.out.println("snack y: " + y);
            System.out.println("snack x: " + x);
            System.out.println("snack y: " + y);
            GameHelper.sleepSeconds(DefaultProvider.SNACK_TIMING_SECONDS);
        }
    }

    private void moveSnake() {
        while (!exit) {
            int mouseX = Math.min(window.getMouseX(), window.getGamePanelWidth() - snake.getHeadWidth());
            int mouseY = Math.min(window.getMouseY(), window.getGamePanelHeight() - snake.getHeadHeight());
            System.out.println("Mouse Position: (" + mouseX + ", " + mouseY + ")");
            snake.moveTo(mouseX, mouseY);
            GameHelper.sleepMillis(DefaultProvider.SNAKE_MOVEMENT_TIMING_MILLIS);
        }
    }

}
