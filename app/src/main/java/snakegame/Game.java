package snakegame;

import javax.swing.*;
import snakegame.GameScreen.GameScreen;
import snakegame.GameScreen.StartMenu;

import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener, ActionListener {
    private final int HEIGHT = 14;
    private final int WIDTH = 21;
    private final int TILESIZE = 60;

    private GameScreen gameScreen;

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public Game() {
        setPreferredSize(new Dimension(WIDTH * TILESIZE, HEIGHT * TILESIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        setLayout(null); // Use absolute layout to position button
        addKeyListener(this);
        Assets.initialiseAssets();

        gameScreen = new StartMenu(this, WIDTH, HEIGHT, TILESIZE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        gameScreen.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        gameScreen.keyPressed(e);
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
