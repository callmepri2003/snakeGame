package snakegame.DTO;

import java.util.ArrayList;
import java.util.List;

import snakegame.Items.Apple;
import snakegame.Snake.SnakeParts.Head;
import snakegame.Snake.SnakeParts.SnakePart;

public class GameState {
  private List<GameEntity> gameEntities = new ArrayList<>();

  public GameState() {

  }

  public void addEntity(GameEntity entity) {
    gameEntities.add(entity);
  }

  public List<GameEntity> getAllEntities() {
    List<GameEntity> allEntities = new ArrayList<>();

    for (GameEntity entity : gameEntities) {
      if (!(entity instanceof Head)) {
        allEntities.add(entity);
      }
    }

    Head head = getHead();
    SnakePart current = head;

    while (current != null) {
      allEntities.add(current);
      current = current.getSuccessor();
    }

    return allEntities;
  }

  public Head getHead() {
    for (GameEntity entity : gameEntities) {
      if (entity instanceof Head head) {
        return head;
      }
    }
    return null;
  }

  public Apple getApple() {
    for (GameEntity entity : gameEntities) {
      if (entity instanceof Apple apple) {
        return apple;
      }
    }
    return null;
  }

  public void removeEntity(GameEntity entity) {
    gameEntities.remove(entity);
  }

}
