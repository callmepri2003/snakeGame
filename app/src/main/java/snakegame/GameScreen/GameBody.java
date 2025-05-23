package snakegame.GameScreen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.*;

import snakegame.Controller;
import snakegame.Game;
import snakegame.DTO.GameEntity;

public class GameBody implements GameScreen {
  private Controller controller;
  private int HEIGHT, WIDTH, TILESIZE;
  private Timer timer;

  public GameBody(Game game, int width, int height, int tileSize) {
    this.HEIGHT = height;
    this.WIDTH = width;
    this.TILESIZE = tileSize;
    controller = new Controller(this.WIDTH, this.HEIGHT, this.TILESIZE);

    timer = new Timer(50, e -> {
      if (controller.gameOn()) {
        controller.tick();
        checkGameOver(controller, game);
      }
      game.repaint();
    });
    timer.start();
  }

  private void checkGameOver(Controller controller2, Game game) {
    if (!controller2.gameOn()) {
      game.setGameScreen(new GameOver(game, WIDTH, HEIGHT, TILESIZE));
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    Color lightGreen = new Color(200, 230, 200);
    Color mediumGreen = new Color(180, 210, 180);

    for (int y = 0; y < HEIGHT; y++) {
      for (int x = 0; x < WIDTH; x++) {
        g.setColor(((x + y) % 2 == 0) ? lightGreen : mediumGreen);
        g.fillRect(x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE);
      }
    }

    for (GameEntity object : controller.getGameState().getAllEntities()) {
      object.paint(g, HEIGHT, WIDTH, TILESIZE);
    }
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
}
