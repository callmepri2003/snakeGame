package snakegame;

import snakegame.DTO.GameEntity;
import snakegame.DTO.GameState;
import snakegame.Items.Apple;
import snakegame.Items.Collidable;
import snakegame.Items.Wall;
import snakegame.Snake.SnakeParts.Head;
import snakegame.Snake.SnakeStates.Right;

public class Controller {

  private Head head;
  private GameState gameState;

  private int HEIGHT, WIDTH;
  private int TILESIZE;

  private boolean gameOn = true;

  public Controller(int WIDTH, int HEIGHT, int TILESIZE) {
    commonInit(WIDTH, HEIGHT, TILESIZE);
    spawnApple();

  }

  public Controller(int wIDTH2, int hEIGHT2, int tILESIZE2, boolean spawnApple) {
    commonInit(wIDTH2, hEIGHT2, tILESIZE2);
    if (spawnApple) {
      spawnApple();
    }

  }

  private void commonInit(int WIDTH, int HEIGHT, int TILESIZE) {
    head = new Head(Right.class);
    gameState = new GameState();
    gameState.addEntity(head);
    this.WIDTH = WIDTH;
    this.HEIGHT = HEIGHT;
    this.TILESIZE = TILESIZE;

    lineWalls();
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
    boolean respawnApple = false;
    for (GameEntity entity : getGameState().getAllEntities()) {
      if (entity.getxCord() == head.getxCord() &&
          entity.getyCord() == head.getyCord() &&
          entity != head) {
        if (entity instanceof Apple apple) {
          respawnApple = true;
          head.grow();
        }
        if (entity instanceof Wall wall) {
          gameOn = false;
        }
      }
    }

    if (respawnApple) {
      getGameState().removeEntity(getGameState().getApple());
      spawnApple();
    }
  }

  public GameState getGameState() {
    return gameState;
  }

  public void spawnApple() {
    Apple apple = new Apple(
        (int) (Math.random() * (WIDTH - 2)) + 1,
        (int) (Math.random() * (HEIGHT - 2)) + 1);
    gameState.addEntity(apple);
  }

  public void spawnApple(int x, int y) {
    Apple apple = new Apple(x, y);
    gameState.addEntity(apple);
  }

  private void lineWalls() {
    for (int i = 0; i < WIDTH; i++) {
      gameState.addEntity(new Wall(i, HEIGHT - 1));
    }
    for (int currHeight = 1; currHeight < HEIGHT - 1; currHeight++) {
      gameState.addEntity(new Wall(0, currHeight));
      gameState.addEntity(new Wall(WIDTH - 1, currHeight));
    }
    for (int i = 0; i < WIDTH; i++) {
      gameState.addEntity(new Wall(i, 0));
    }
  }

  public boolean gameOn() {
    return gameOn;
  }

}
