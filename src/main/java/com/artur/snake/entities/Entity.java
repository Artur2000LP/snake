package com.artur.snake.entities;


import com.artur.snake.DefaultProvider;

import javax.swing.*;

public class Entity implements Movable {
    protected final JButton component;
    private int _x;
    private int _y;
    private final int _width;
    private final int _height;
    private int _velocity = DefaultProvider.DEFAULT_ENTITY_VELOCITY;

    public Entity(int x, int y, int width, int height) {
        this.component = new JButton("");
        this._x = x;
        this._y = y;
        this._width = width;
        this._height = height;
        component.setBounds(x, y, width, height);
    }

    public void setVelocity(int velocity) {
        this._velocity = Math.max(velocity, 0);
    }

		@Override
    public void moveUp() {
        setPosition(_x, Math.max(_y - _velocity, 0));
    }

		@Override
    public void moveDown() {
        setPosition(_x, Math.max(_y + _velocity, 0));
    }

		@Override
    public void moveLeft() {
        setPosition(Math.max(_x - _velocity, 0), _y);
    }

		@Override
    public void moveRight() {
        setPosition(Math.max(_x + _velocity, 0), _y);
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public int getWidth() {
        return this._width;
    }

    public int getHeight() {
        return this._height;
    }

    public int getVelocity(){
        return this._velocity;
    }

    public void setPosition(int x, int y) {
        this._x = x;
        this._y = y;
        component.setBounds(x, y, _width, _height);
    }

    public JButton getComponent() {
        return component;
    }

}
