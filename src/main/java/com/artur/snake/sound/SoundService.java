package com.artur.snake.sound;

public class SoundService {
    private static GameSound background;
    private static GameSound collision;
    private static GameSound eat;
    private static GameSound snack;

    public static GameSound getCollision() {
        if (collision == null) {
            collision = new GameSound("collision.wav");
        }
        return collision;
    }

    public static GameSound getBackground() {
        if (background == null) {
            background = new GameSound("background.wav");
            background.setLoop(true);
        }
        return background;
    }

    public static GameSound getEat() {
        if (eat == null) {
            eat = new GameSound("eat.wav");
        }
        return eat;
    }

    public static GameSound getSnack() {
        if (snack == null) {
            snack = new GameSound("appearanceSnack.wav");
        }
        return snack;
    }
}
