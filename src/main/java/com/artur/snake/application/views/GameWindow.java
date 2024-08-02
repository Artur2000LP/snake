package com.artur.snake.application.views;

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
    }

    public void showWindow() {
        setVisible(true);
    }

    private void configWindow() {
        setSize(600, 400);
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
        gamePanel.setBackground(Color.DARK_GRAY);
        return gamePanel;
    }




}


