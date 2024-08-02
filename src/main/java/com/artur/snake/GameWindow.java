package com.artur.snake;

import com.artur.snake.entities.Entity;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private final JLabel deathsLabel = new JLabel("Muertes: ");
    private final JLabel scoreLabel = new JLabel("Puntos: ");
    private final JLabel timeLabel = new JLabel("");
    private final JPanel gamePanel = new JPanel();

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
    
    public int getGamePanelWidth(){
        return this.gamePanel.getWidth();
    }
    
    public int getGamePanelHeight(){
        return this.gamePanel.getHeight();
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
        return gamePanel;
    }

}


