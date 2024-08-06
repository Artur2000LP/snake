package com.artur.snake.entities;

import java.awt.Color;

public class SnakeBodyEntity extends Entity {
    
    public SnakeBodyEntity(){
        this(Color.GREEN);
    }

    public SnakeBodyEntity(Color color) {
        super(0, 0, 20, 20);
        component.setBackground(color);
    }
    
}
