package com.artur.snake.entities;

import java.awt.Color;

public class SnakeBodyEntity extends Entity {

    public SnakeBodyEntity() {
        super(0, 0, 25, 25);
        component.setBackground(Color.GREEN);
    }
}
