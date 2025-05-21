package snakegame.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import snakegame.Controller;
import snakegame.DTO.GameState;
import snakegame.Snake.SnakeParts.Head;

public class e2eTest {
  private Controller controller;
  GameState gameState;
  Head head;

  @BeforeEach
  public void setUp() {
    controller = new Controller();
  }

  @Test
  public void testSnakeSpawnsInMiddle() {
    // Snake should spawn in the middle of the board
    GameState gameState = controller.getGameState();
    Head head = gameState.getHead();

    assertEquals(10, head.getxCord());
    assertEquals(10, head.getxCord());

  }

  @Test
  public void testMovementDown() {

    // Go down
    controller.goDown();

    // tick 10 times
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();

    gameState = controller.getGameState();
    head = gameState.getHead();

    // Should end up 10 blocks to the left
    assertEquals(10, head.getxCord());
    assertEquals(0, head.getyCord());
  }

  @Test
  public void testMovementUp() {

    // Go down
    controller.goUp();

    // tick 10 times
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();

    gameState = controller.getGameState();
    head = gameState.getHead();

    // Should end up 10 blocks to the left
    assertEquals(10, head.getxCord());
    assertEquals(20, head.getyCord());
  }

  @Test
  public void testMovementLeft() {

    // Go Left
    controller.goUp();
    controller.goLeft();

    // tick 10 times
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();

    gameState = controller.getGameState();
    head = gameState.getHead();

    // Should end up 10 blocks to the left
    assertEquals(0, head.getxCord());
    assertEquals(10, head.getyCord());
  }

  @Test
  public void testMovementRight() {

    // tick 10 times
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();
    controller.tick();

    gameState = controller.getGameState();
    head = gameState.getHead();

    // Should end up 10 blocks to the left
    assertEquals(20, head.getxCord());
    assertEquals(10, head.getyCord());
  }
}
