package snakegame.Snake.SnakeStates;

import java.awt.image.BufferedImage;

import snakegame.Assets;
import snakegame.Snake.SnakeParts.Body;
import snakegame.Snake.SnakeParts.Head;
import snakegame.Snake.SnakeParts.SnakePart;
import snakegame.Snake.SnakeParts.Tail;

public class Up implements Direction {
  private SnakePart snakePart;

  public Up(SnakePart snakePart) {
    this.snakePart = snakePart;
  }

  @Override
  public void advance() {
    snakePart.setyCord(snakePart.getyCord() + 1);
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

  @Override
  public BufferedImage getImg(Direction prevDirection, Class<? extends SnakePart> partClass) {
    if (partClass.equals(Head.class)) {
      return getHeadImg(prevDirection);
    } else if (partClass.equals(Body.class)) {
      return getBodyImg(prevDirection);
    } else if (partClass.equals(Tail.class)) {
      return getTailImg();
    }
    return null;
  }

  private BufferedImage getBodyImg(Direction prevDirection) {
    if (prevDirection instanceof Down) {
      return Assets.body_vertical;
    } else if (prevDirection instanceof Right) {
      return Assets.body_bottomright;
    } else if (prevDirection instanceof Left) {
      return Assets.body_bottomleft;
    } else if (prevDirection instanceof Up) {
      return Assets.body_vertical;
    } else {
      return Assets.apple;
    }
  }

  private BufferedImage getHeadImg(Direction prevDirection) {
    return Assets.head_up;
  }

  private BufferedImage getTailImg() {
    return Assets.tail_down;
  }

}
