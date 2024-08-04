package com.artur.snake;

import com.artur.snake.entities.Entity;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class GameWindow extends JFrame implements MouseMotionListener {

    private final JLabel deathsLabel = new JLabel("Muertes: ");
    private final JLabel scoreLabel = new JLabel("Puntos: ");
    private final JLabel timeLabel = new JLabel("");
    private final JPanel gamePanel = new JPanel();

    private int mouseX = 0, mouseY = 0;

    public GameWindow() {
        configWindow();
        add(buildLabelsPanel(), BorderLayout.NORTH);
        add(new JPanel(), BorderLayout.WEST);
        add(new JPanel(), BorderLayout.EAST);
        add(new JPanel(), BorderLayout.SOUTH);
        add(buildGamePanel(), BorderLayout.CENTER);
        setVisible(true);
    }

    public void addEntity(Entity entity) {
        this.gamePanel.add(entity.getComponent());
        revalidate();
        repaint();
    }

    public void addEntities(List<Entity> entities){
        for(Entity entity : entities){
            addEntity(entity);
        }
    }

    public int getGamePanelWidth() {
        return this.gamePanel.getWidth();
    }

    public int getGamePanelHeight() {
        return this.gamePanel.getHeight();
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    private void configWindow() {
        setSize(500, 400);
        setTitle("Snake Game By Artur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }

    private JPanel buildLabelsPanel() {
        JPanel panel = new JPanel();
        panel.add(deathsLabel);
        panel.add(scoreLabel);
        panel.add(timeLabel);
        return panel;
    }

    private JPanel buildGamePanel() {
        gamePanel.setLayout(null);
        gamePanel.setBackground(Color.DARK_GRAY);
        gamePanel.addMouseMotionListener(this);
        return gamePanel;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

}


