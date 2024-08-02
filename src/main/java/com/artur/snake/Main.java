package com.artur.snake;

public class Main {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        GameEngine engine = new GameEngine(window);
        new Thread(engine).start();
    }

}
