package snakegame.Snake.SnakeParts;

import java.awt.Graphics;

import snakegame.Snake.SnakeStates.Direction;

public class Tail extends SnakePart {

  public Tail(Class<? extends Direction> direction, int xCord, int yCord) {
    super(direction, xCord, yCord);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void paint(Graphics g, int hEIGHT, int WIDTH, int TILESIZE) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'paint'");
  }

}
