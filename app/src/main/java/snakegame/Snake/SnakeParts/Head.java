package snakegame.Snake.SnakeParts;

import java.awt.Color;
import java.awt.Graphics;

import snakegame.DTO.DTO;
import snakegame.Snake.SnakeStates.Direction;
import snakegame.Snake.SnakeStates.Down;
import snakegame.Snake.SnakeStates.Up;

public class Head extends SnakePart {

  public Head(Class<? extends Direction> direction) {
    super(direction, 100, 100);
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
    g.fillRect(getxCord() * WIDTH, (HEIGHT - getyCord()) * HEIGHT, TILESIZE, TILESIZE);
    g.setColor(Color.BLACK);
    // Draw eyes based on direction
    if (getDirection() instanceof Up || getDirection() instanceof Down) {
      g.fillOval(getxCord() * WIDTH + 4, (HEIGHT - getyCord()) * HEIGHT + 4, 4, 4);
      g.fillOval(getxCord() * WIDTH + 12, (HEIGHT - getyCord()) * HEIGHT + 4, 4, 4);
    } else {
      g.fillOval(getxCord() * WIDTH + 4, (HEIGHT - getyCord()) * HEIGHT + 4, 4, 4);
      g.fillOval(getxCord() * WIDTH + 4, (HEIGHT - getyCord()) * HEIGHT + 12, 4, 4);
    }
  }

}
