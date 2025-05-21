package snakegame.Snake.SnakeStates;

import snakegame.Snake.SnakeParts.SnakePart;

public class Down implements Direction {
  private SnakePart snakePart;

  public Down(SnakePart snakePart) {
    this.snakePart = snakePart;
  }

  @Override
  public void advance() {
    snakePart.setyCord(snakePart.getyCord() - 1);
  }

  @Override
  public void goLeft() {
    snakePart.setDirection(Left.class);
  }

  @Override
  public void goRight() {
    snakePart.setDirection(Right.class);
  }

  @Override
  public void goUp() {

  }

  @Override
  public void goDown() {

  }

}
