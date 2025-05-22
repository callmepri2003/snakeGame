package snakegame.Snake.SnakeParts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import snakegame.Snake.SnakeStates.Direction;
import snakegame.Snake.SnakeStates.Down;
import snakegame.Snake.SnakeStates.Up;

public class Head extends SnakePart {

  public Head(Class<? extends Direction> direction) {
    super(direction, 10, 10);
  }

  public void goLeft() {
    getDirection().goLeft();
  }

  public void goRight() {
    getDirection().goRight();
  }

  public void goUp() {
    getDirection().goUp();
  }

  public void goDown() {
    getDirection().goDown();
  }

  @Override
  public void paint(Graphics g, int HEIGHT, int WIDTH, int TILESIZE) {
    g.setColor(Color.GREEN);
    BufferedImage img = getDirection().getImg(getPrevDirection(), Head.class);
    g.drawImage(img, getxCord() * TILESIZE, (HEIGHT - getyCord() - 1) * TILESIZE, TILESIZE, TILESIZE, null);

    if (getSuccessor() != null) {
      getSuccessor().paint(g, HEIGHT, WIDTH, TILESIZE);
    }
  }

}
