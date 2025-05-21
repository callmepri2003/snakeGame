package snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener, ActionListener {

    private Timer timer;
    private Controller controller;

    public Game() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(100, 100, 50, 50);
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

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
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
}
