package snakegame.Snake.SnakeParts;

import snakegame.DTO.GameEntity;
import snakegame.Snake.SnakeStates.Direction;
import snakegame.Snake.SnakeStates.Down;
import snakegame.Snake.SnakeStates.Left;
import snakegame.Snake.SnakeStates.Right;
import snakegame.Snake.SnakeStates.Up;

public abstract class SnakePart implements GameEntity {
  private Direction left;
  private Direction right;
  private Direction up;
  private Direction down;
  private Direction state;
  private Body successor;

  private int xCord;
  private int yCord;

  public SnakePart(Class<? extends Direction> direction, int xCord, int yCord) {
    this.left = new Left(this);
    this.right = new Right(this);
    this.up = new Up(this);
    this.down = new Down(this);
    this.xCord = xCord;
    this.yCord = yCord;
    setDirection(direction);
  }

  public int getxCord() {
    return xCord;
  }

  public void setxCord(int xCord) {
    this.xCord = xCord;
  }

  public int getyCord() {
    return yCord;
  }

  public void setyCord(int yCord) {
    this.yCord = yCord;
  }

  public Direction getDirection() {
    return state;
  }

  public void grow() {
    if (successor != null) {
      successor.grow();
    } else {
      successor = new Body(getDirection().getClass(), getxCord(), getyCord());
    }

  }

  public void setDirection(Class<? extends Direction> direction) {
    if (direction == Left.class) {
      state = left;
    } else if (direction == Right.class) {
      state = right;
    } else if (direction == Up.class) {
      state = up;
    } else if (direction == Down.class) {
      state = down;
    }
  }

  public void advance() {
    state.advance();
    if (successor != null) {
      successor.advance();
      successor.setDirection(getDirection().getClass());
    }
  }

  public Body getSuccessor() {
    return successor;
  }

  public void setSuccessor(Body successor) {
    this.successor = successor;
  }
}
