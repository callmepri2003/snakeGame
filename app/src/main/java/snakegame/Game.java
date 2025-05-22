package snakegame;

import javax.swing.*;
import snakegame.DTO.GameEntity;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.TileObserver;

public class Game extends JPanel implements KeyListener, ActionListener {
    private final int HEIGHT = 20;
    private final int WIDTH = 32;
    private final int TILESIZE = 40;

    private Timer timer;
    private Controller controller;
    private JButton restartButton;

    public Game() {
        setPreferredSize(new Dimension(WIDTH * TILESIZE, HEIGHT * TILESIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        setLayout(null); // Use absolute layout to position button
        addKeyListener(this);

        Assets.initialiseAssets();

        controller = new Controller(WIDTH, HEIGHT, TILESIZE);

        // Create and configure restart button
        restartButton = new JButton("Restart");
        restartButton.setBounds((WIDTH * TILESIZE) / 2 - 75, (HEIGHT * TILESIZE) / 2 + 40, 150, 40);
        restartButton.setVisible(false);
        restartButton.addActionListener(e -> restartGame());
        this.add(restartButton);

        // Timer loop
        timer = new Timer(32, e -> {
            if (controller.gameOn()) {
                controller.tick();
            }
            repaint(); // Always repaint to show game or end screen
        });
        timer.start();
    }

    private void restartGame() {
        controller = new Controller(WIDTH, HEIGHT, TILESIZE); // Re-initialize game
        restartButton.setVisible(false);
        requestFocusInWindow(); // Regain key focus
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.background, 0, 0, WIDTH * TILESIZE, HEIGHT * TILESIZE, null);

        for (GameEntity object : controller.getGameState().getAllEntities()) {
            object.paint(g, HEIGHT, WIDTH, TILESIZE);
        }

        if (!controller.gameOn()) {
            // Dim background
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(0, 0, WIDTH * TILESIZE, HEIGHT * TILESIZE);

            // Game Over message
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            String msg = "Game Over";
            int textWidth = g.getFontMetrics().stringWidth(msg);
            g.drawString(msg, (WIDTH * TILESIZE - textWidth) / 2, (HEIGHT * TILESIZE) / 2);

            // Show restart button
            restartButton.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
            controller.goLeft();
        if (key == KeyEvent.VK_RIGHT)
            controller.goRight();
        if (key == KeyEvent.VK_UP)
            controller.goUp();
        if (key == KeyEvent.VK_DOWN)
            controller.goDown();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Feed the Snake");
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
