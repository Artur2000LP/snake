package com.artur.snake.entities;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Snake {

    private final List<SnakeBodyEntity> body = new LinkedList<>();

    public Snake() {
        grow();
    }

    public void moveTo(int bx, int by) {
        Entity head = getHead();
        if (bx == getHead().getX() && by == getHead().getY()) {
            return;
        }
        int ax = head.getX();
        int ay = head.getY();
        int velocity = head.getVelocity();
        int dx = bx - ax;
        int dy = by - ay;
        int headX = dx > 0 ? ax + Math.min(dx, velocity) : ax - Math.min(Math.abs(dx), velocity);
        int headY = dy > 0 ? ay + Math.min(dy, velocity) : ay - Math.min(Math.abs(dy), velocity);
        head.setPosition(headX, headY);
        int prevX = ax;
        int prevY = ay;
        for (int i = 1; i < body.size(); ++i) {
            Entity part = body.get(i);
            int x = prevX;
            int y = prevY;
            prevX = part.getX();
            prevY = part.getY();
            part.setPosition(x, y);
        }
    }

    public int getHeadWidth() {
        //head == cabeza
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

    public Entity getHead() {
        if (!body.isEmpty()) {
            return body.get(0);
        }
        return null;
    }

    public Entity grow() {
        Entity tail = body.isEmpty() ? new SnakeBodyEntity() : body.get(body.size() - 1);
        int x = tail.getX();
        int y = tail.getY();
        SnakeBodyEntity part = body.isEmpty() ? new SnakeBodyEntity(Color.RED) : new SnakeBodyEntity();
        part.setPosition(x, y);
        body.add(part);
        return part;
    }

}
