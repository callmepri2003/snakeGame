package snakegame;

import snakegame.DTO.GameState;
import snakegame.Snake.SnakeParts.Head;
import snakegame.Snake.SnakeStates.Right;

public class Controller {

  private Head head;
  private GameState gameState;

  public Controller() {
    head = new Head(Right.class);
    gameState = new GameState();
    gameState.addEntity(head);
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

  public GameState getGameState() {
    return gameState;
  }

}
