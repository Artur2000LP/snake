package com.artur.snake;

import com.artur.snake.entities.SnackEntity;
import com.artur.snake.entities.Snake;
import com.artur.snake.sound.SoundService;


public class GameEngine implements Runnable {

    private final SnackEntity snack;
    private Snake snake;
    private final GameWindow window;
    private boolean exit = false;
    private int time = 0;
    private int mouseX = 0;
    private int mouseY = 0;
    private int score = 0;
    private int death = 0;

    public GameEngine(GameWindow window) {
        this.snack = new SnackEntity(5, 5);
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
        SoundService.getBackground().play();
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
        SoundService.getSnack().play();
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
                SoundService.getEat().play();
            }

            if (snake.getHead().getX() <= 1 ||
                    snake.getHead().getY() <= 0 ||
                    snake.getHead().getX() >= window.getGamePanelWidth() - snake.getHeadWidth() ||
                    snake.getHead().getY() >= window.getGamePanelHeight() - snake.getHeadHeight()
            ) {
                deathSnake();
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

    public void deathSnake() {
        score = 0;
        time = 0;
        death++;
        window.setScore(score);
        for (int i = 0; i < snake.getBody().size(); i++) {
            window.removeEntity(snake.getBody().get(i));
        }
        snake = new Snake();
        window.addEntities(snake.getBody());
        snake.getHead().setPosition(5, 5);
        window.setMouseX(5);
        window.setMouseY(5);
        window.setDeaths(death);
        SoundService.getCollision().play();

    }
}
