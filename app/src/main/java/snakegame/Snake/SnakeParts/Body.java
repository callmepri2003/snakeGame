package snakegame.Snake.SnakeParts;

import java.awt.Color;
import java.awt.Graphics;

import snakegame.Snake.SnakeStates.Direction;

public class Body extends SnakePart {

  private boolean born;

  public Body(Class<? extends Direction> direction, int xCord, int yCord) {
    super(direction, xCord, yCord);
    born = true;
  }

  @Override
  public void paint(Graphics g, int HEIGHT, int WIDTH, int TILESIZE) {
    g.setColor(Color.GREEN.darker());
    g.fillRect(getxCord() * TILESIZE, (HEIGHT - getyCord()) * TILESIZE, TILESIZE, TILESIZE);
    if (getSuccessor() != null) {
      getSuccessor().paint(g, HEIGHT, WIDTH, TILESIZE);
    }
  }

  @Override
  public void advance() {
    if (born) {
      this.born = false;
      return;
    }
    getDirection().advance();
    if (getSuccessor() != null) {
      getSuccessor().advance();
      getSuccessor().setDirection(getDirection().getClass());
    }
  }

}
