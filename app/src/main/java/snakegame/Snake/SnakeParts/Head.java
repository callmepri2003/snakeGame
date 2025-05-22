package snakegame.Snake.SnakeParts;

import java.awt.Color;
import java.awt.Graphics;

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
    g.fillRect(getxCord() * TILESIZE, (HEIGHT - getyCord()) * TILESIZE, TILESIZE, TILESIZE);
    g.setColor(Color.BLACK);
    // Draw eyes based on direction
    if (getDirection() instanceof Up || getDirection() instanceof Down) {
      g.fillOval(getxCord() * TILESIZE + 4, (HEIGHT - getyCord()) * TILESIZE + 4, 4, 4);
      g.fillOval(getxCord() * TILESIZE + 12, (HEIGHT - getyCord()) * TILESIZE + 4, 4, 4);
    } else {
      g.fillOval(getxCord() * TILESIZE + 4, (HEIGHT - getyCord()) * TILESIZE + 4, 4, 4);
      g.fillOval(getxCord() * TILESIZE + 4, (HEIGHT - getyCord()) * TILESIZE + 12, 4, 4);
    }
  }

}
