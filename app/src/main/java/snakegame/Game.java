package snakegame;

import javax.swing.*;

import snakegame.DTO.DTO;
import snakegame.DTO.GameEntity;
import snakegame.Snake.SnakeStates.Direction;
import snakegame.Snake.SnakeStates.Down;
import snakegame.Snake.SnakeStates.Up;

import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener, ActionListener {
    private final int HEIGHT = 12;
    private final int WIDTH = 20;
    private Timer timer;
    private Controller controller;
    private final int TILESIZE = 50;

    public Game() {
        setPreferredSize(new Dimension(WIDTH * TILESIZE, HEIGHT * TILESIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        controller = new Controller();

        timer = new Timer(200, e -> {
            controller.tick();
            repaint();
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (GameEntity object : controller.getAllObjects()) {
            object.paint(g, HEIGHT, WIDTH, TILESIZE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    // Key handling
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Move square
        if (key == KeyEvent.VK_LEFT) {
            controller.goLeft();
        }
        if (key == KeyEvent.VK_RIGHT)
            controller.goRight();
        if (key == KeyEvent.VK_UP)
            controller.goUp();
        if (key == KeyEvent.VK_DOWN)
            controller.goDown();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        Game gamePanel = new Game();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
