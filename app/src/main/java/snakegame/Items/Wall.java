package snakegame.Items;

import java.awt.Color;
import java.awt.Graphics;
import snakegame.DTO.GameEntity;

public class Wall implements Collidable, GameEntity {
  private int xCord, yCord;

  public Wall(int xCord, int yCord) {
    this.xCord = xCord;
    this.yCord = yCord;
  }

  @Override
  public void collide() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'collide'");
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

  @Override
  public void paint(Graphics g, int HEIGHT, int WIDTH, int TILESIZE) {
    g.setColor(Color.DARK_GRAY);
    g.fillRect(getxCord() * TILESIZE, (HEIGHT - getyCord()) * TILESIZE, TILESIZE, TILESIZE);
  }

}
