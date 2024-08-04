package com.artur.snake.entities;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private final List<SnakeBodyEntity> body;

    public Snake() {
        body = new LinkedList<>();
        SnakeBodyEntity head = new SnakeBodyEntity();
        body.add(head);
    }

    public void moveTo(int bx, int by) {
        for (SnakeBodyEntity part : body) {
            int ax = part.getX();
            int ay = part.getY();
            int velocity = part.getVelocity();
            int dx = bx - ax;
            int dy = by - ay;
            int x = dx > 0 ? ax + Math.min(dx, velocity) : ax - Math.min(Math.abs(dx), velocity);
            int y = dy > 0 ? ay + Math.min(dy, velocity) : ay - Math.min(Math.abs(dy), velocity);
            part.setPosition(x, y);
        }
    }

    public int getHeadWidth() {
        if (body.isEmpty())
            return 0;
        return body.get(0).getWidth();
    }

    public int getHeadHeight() {
        if (body.isEmpty())
            return 0;
        return body.get(0).getHeight();
    }

    public List<Entity> getBody() {
        return body.stream().map(bodyEntity -> (Entity) bodyEntity).toList();
    }

}
