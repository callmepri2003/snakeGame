package snakegame.Snake.SnakeStates;

import java.awt.image.BufferedImage;

import snakegame.Snake.SnakeParts.SnakePart;

public interface Direction {

  void advance();

  public void goLeft();

  public void goRight();

  public void goUp();

  public void goDown();

  BufferedImage getImg(Direction prevDirection, Class<? extends SnakePart> partClass);

}