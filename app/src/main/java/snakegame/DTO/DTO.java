package snakegame.DTO;

import snakegame.Snake.SnakeStates.Direction;

public class DTO {
  public int x;
  public int y;
  public Direction direction;
  public Class<? extends GameEntity> type;

  public DTO(int x, int y, Direction direction, Class<? extends GameEntity> type) {
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.type = type;
  }
}
