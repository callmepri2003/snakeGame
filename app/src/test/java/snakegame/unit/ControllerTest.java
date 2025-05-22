package snakegame.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import snakegame.Controller;
import snakegame.DTO.GameState;
import snakegame.Items.Apple;
import snakegame.Snake.SnakeParts.Head;

public class ControllerTest {
  private final int HEIGHT = 12;
  private final int WIDTH = 20;
  private final int TILESIZE = 50;
  private Controller controller;

  @BeforeEach
  public void setUp() {

  }

  @Test
  public void randomAppleSpawn() {
    controller = new Controller(WIDTH, HEIGHT, TILESIZE, true);
    GameState gameState = controller.getGameState();
    Apple apple = gameState.getApple();

    assertTrue(apple.getxCord() <= WIDTH - 1);
    assertTrue(apple.getxCord() >= 1);
    assertTrue(apple.getyCord() <= HEIGHT - 1);
    assertTrue(apple.getyCord() >= 1);

  }

  @Test
  public void appleCollision() {
    controller = new Controller(WIDTH, HEIGHT, TILESIZE, false);
    controller.spawnApple(10, 10);
    GameState gameState = controller.getGameState();
    Apple apple = gameState.getApple();
    Head head = gameState.getHead();

    assertEquals(apple.getxCord(), head.getxCord());
    assertEquals(apple.getyCord(), head.getyCord());

  }
}
