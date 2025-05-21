package snakegame.Snake.SnakeStates;

import snakegame.Snake.SnakeParts.SnakePart;

public class Left implements Direction {
  private SnakePart snakePart;

  public Left(SnakePart snakePart) {
    this.snakePart = snakePart;
  }

  @Override
  public void advance() {
    snakePart.setxCord(snakePart.getxCord() - 1);
  }

  @Override
  public void goLeft() {
  }

  @Override
  public void goRight() {

  }

  @Override
  public void goUp() {
    snakePart.setDirection(Up.class);
  }

  @Override
  public void goDown() {
    snakePart.setDirection(Down.class);
  }

}
