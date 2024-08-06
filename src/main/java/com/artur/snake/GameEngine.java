package com.artur.snake;

import com.artur.snake.entities.SnackEntity;
import com.artur.snake.entities.Snake;


public class GameEngine implements Runnable {

    private final SnackEntity snack;
    private final Snake snake;
    private final GameWindow window;
    private boolean exit = false;
    private int time = 0;
    private int mouseX = 0;
    private int mouseY = 0;
    private int score =0;

    public GameEngine(GameWindow window) {
        this.snack = new SnackEntity(0, 0);
        this.snake = new Snake();
        this.window = window;
        this.window.addEntity(snack);
        setRandomPositionSnack();
        this.window.addEntities(snake.getBody());

    }

    @Override
    public void run() {
        new Thread(this::moveSnake).start();
        new Thread(this::timer).start();
        while (!exit) {
            System.out.println("soy infinito");
            GameHelper.sleepSeconds(1000);
        }
    }

    public void setRandomPositionSnack() {
        int x = GameHelper.getRandomNumber(0, window.getGamePanelWidth() - snack.getWidth());
        int y = GameHelper.getRandomNumber(0, window.getGamePanelHeight() - snack.getHeight());
        this.snack.setPosition(x, y);
        System.out.printf("Snack position: (%d, %d)%n", x, y);
    }

    private void moveSnake() {
        while (!exit) {
            int mouseX = Math.min(window.getMouseX(), window.getGamePanelWidth() - snake.getHeadWidth());
            int mouseY = Math.min(window.getMouseY(), window.getGamePanelHeight() - snake.getHeadHeight());
            System.out.println("Mouse Position: (" + mouseX + ", " + mouseY + ")");
            snake.moveTo(mouseX, mouseY);
            if (snake.getHead().collision(snack)) {
                setRandomPositionSnack();
                window.addEntity(snake.grow());
                time = 0;
                score++;
                window.setScore(score);
            }
            GameHelper.sleepMillis(DefaultProvider.SNAKE_MOVEMENT_TIMING_MILLIS);
        }
    }

    private void timer() {
        while (!exit) {
            if (time >= 5) {
                setRandomPositionSnack();
                time = 0;
            }
            window.setTime(time);
            GameHelper.sleepSeconds(1);
            time++;
        }
    }

}
