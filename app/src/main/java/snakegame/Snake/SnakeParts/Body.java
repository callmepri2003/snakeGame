package snakegame.Snake.SnakeParts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import snakegame.Snake.SnakeStates.Direction;

public class Body extends SnakePart {

  private boolean born;

  public Body(Class<? extends Direction> direction, int xCord, int yCord) {
    super(direction, xCord, yCord);
    born = true;
  }

  @Override
  public void paint(Graphics g, int HEIGHT, int WIDTH, int TILESIZE) {
    BufferedImage img;
    if (getSuccessor() != null) {
      img = getDirection().getImg(getPrevDirection(), Body.class);
    } else {
      img = getDirection().getImg(getPrevDirection(), Tail.class);

    }
    g.drawImage(img, getxCord() * TILESIZE, (HEIGHT - getyCord() - 1) * TILESIZE, TILESIZE, TILESIZE, null);
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
