package snakegame.Snake.SnakeParts;

import java.awt.Color;
import java.awt.Graphics;

import snakegame.Snake.SnakeStates.Direction;

public class Body extends SnakePart {

  public Body(Class<? extends Direction> direction, int xCord, int yCord) {
    super(direction, xCord, yCord);
  }

  @Override
  public void paint(Graphics g, int HEIGHT, int WIDTH, int TILESIZE) {
    g.setColor(Color.GREEN.darker());
    g.fillRect(getxCord() * TILESIZE, getyCord() * TILESIZE, TILESIZE, TILESIZE);
  }

}
