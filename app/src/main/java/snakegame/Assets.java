package snakegame;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {
  public static BufferedImage apple,
      body_bottomleft,
      body_bottomright,
      body_horizontal,
      body_topleft,
      body_topright,
      body_vertical,
      head_down,
      head_left,
      head_right,
      head_up,
      tail_down,
      tail_left,
      tail_right,
      tail_up,
      background,
      wall;

  public static void initialiseAssets() {
    try {
      apple = ImageIO.read(Assets.class.getResource("/images/subject.png"));
      body_bottomleft = ImageIO.read(Assets.class.getResource("/images/body_bottomleft.png"));
      body_bottomright = ImageIO.read(Assets.class.getResource("/images/body_bottomright.png"));
      body_horizontal = ImageIO.read(Assets.class.getResource("/images/body_horizontal.png"));
      body_topleft = ImageIO.read(Assets.class.getResource("/images/body_topleft.png"));
      body_topright = ImageIO.read(Assets.class.getResource("/images/body_topright.png"));
      body_vertical = ImageIO.read(Assets.class.getResource("/images/body_vertical.png"));

      head_down = ImageIO.read(Assets.class.getResource("/images/head_down.png"));
      head_left = ImageIO.read(Assets.class.getResource("/images/head_left.png"));
      head_right = ImageIO.read(Assets.class.getResource("/images/head_right.png"));
      head_up = ImageIO.read(Assets.class.getResource("/images/head_up.png"));

      tail_down = ImageIO.read(Assets.class.getResource("/images/tail_down.png"));
      tail_left = ImageIO.read(Assets.class.getResource("/images/tail_left.png"));
      tail_right = ImageIO.read(Assets.class.getResource("/images/tail_right.png"));
      tail_up = ImageIO.read(Assets.class.getResource("/images/tail_up.png"));
      background = ImageIO.read(Assets.class.getResource("/images/bg.png"));
      wall = ImageIO.read(Assets.class.getResource("/images/wall.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}