package snakegame.GameScreen;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public interface GameScreen {

  void paintComponent(Graphics g);

  void keyPressed(KeyEvent e);

}
