package snakegame.Items;

import java.awt.Color;
import java.awt.Graphics;
import snakegame.DTO.GameEntity;

public class Apple implements Collidable, GameEntity {
  private int xCord, yCord;

  public Apple(int x, int y) {
    this.xCord = x;
    this.yCord = y;
  }

  @Override
  public void collide() {

  }

  public void setxCord(int xCord) {
    this.xCord = xCord;
  }

  public void setyCord(int yCord) {
    this.yCord = yCord;
  }

  public int getyCord() {
    return yCord;
  }

  public int getxCord() {
    return xCord;
  }

  @Override
  public void paint(Graphics g, int HEIGHT, int WIDTH, int TILESIZE) {
    g.setColor(Color.RED);
    g.fillOval(getxCord() * TILESIZE, (HEIGHT - getyCord() - 1) * TILESIZE, TILESIZE, TILESIZE);
  }

}
