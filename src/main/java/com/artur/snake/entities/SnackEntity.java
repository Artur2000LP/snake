package com.artur.snake.entities;

import java.awt.Color;

public class SnackEntity extends Entity {
    public SnackEntity(int x, int y) {
        super(x, y, 25, 25);
        component.setBackground(Color.ORANGE);
    }
}
