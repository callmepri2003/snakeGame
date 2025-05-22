package snakegame.Snake.SnakeStates;

import java.awt.image.BufferedImage;

import snakegame.Assets;
import snakegame.Snake.SnakeParts.Body;
import snakegame.Snake.SnakeParts.Head;
import snakegame.Snake.SnakeParts.SnakePart;

public class Right implements Direction {
  private SnakePart snakePart;

  public Right(SnakePart snakePart) {
    this.snakePart = snakePart;
  }

  @Override
  public void advance() {
    snakePart.setxCord(snakePart.getxCord() + 1);
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

  @Override
  public BufferedImage getImg(Direction prevDirection, Class<? extends SnakePart> partClass) {
    if (partClass.equals(Head.class)) {
      return getHeadImg(prevDirection);
    } else if (partClass.equals(Body.class)) {
      return getBodyImg(prevDirection);
    }
    return null;
  }

  private BufferedImage getBodyImg(Direction prevDirection) {
    if (prevDirection instanceof Down) {
      return Assets.body_bottomleft;
    } else if (prevDirection instanceof Right) {
      return Assets.body_horizontal;
    } else if (prevDirection instanceof Left) {
      return Assets.body_horizontal;
    } else if (prevDirection instanceof Up) {
      return Assets.body_topleft;
    } else {
      return Assets.apple;
    }
  }

  private BufferedImage getHeadImg(Direction prevDirection) {
    return Assets.head_right;
  }

}
