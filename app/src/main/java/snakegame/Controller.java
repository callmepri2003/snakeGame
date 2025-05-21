package snakegame;

import java.util.ArrayList;
import java.util.List;

import snakegame.DTO.DTO;
import snakegame.DTO.GameEntity;
import snakegame.Snake.SnakeParts.Head;
import snakegame.Snake.SnakeStates.Left;
import snakegame.Snake.SnakeStates.Right;

public class Controller {

  private Head head;
  private List<GameEntity> gameEntities = new ArrayList<>();

  public Controller() {
    head = new Head(Right.class);
    gameEntities.add(head);
  }

  public void goLeft() {
    head.goLeft();
  }

  public void goRight() {
    head.goRight();
  }

  public void goUp() {
    head.goUp();
  }

  public void goDown() {
    head.goDown();
  }

  public void tick() {
    head.advance();
    handleCollisions();
  }

  private void handleCollisions() {
  }

  public List<GameEntity> getAllObjects() {
    return gameEntities;
  }

}
