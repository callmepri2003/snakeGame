package snakegame.GameScreen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;

import snakegame.Controller;
import snakegame.Game;

public class GameOver implements GameScreen {
  private int WIDTH;
  private int HEIGHT;
  private int TILESIZE;
  private Game game;
  private Controller newController = null;

  // UI State
  private boolean restartButtonHovered = false;
  private boolean menuButtonHovered = false;
  private int animationFrame = 0;
  private int fadeAlpha = 0;
  private final int MAX_FADE = 180;

  // Colors
  private static final Color DARK_RED = new Color(139, 34, 34);
  private static final Color LIGHT_RED = new Color(255, 99, 99);
  private static final Color DARK_GREEN = new Color(34, 139, 34);
  private static final Color LIGHT_GREEN = new Color(144, 238, 144);
  private static final Color GOLD = new Color(255, 215, 0);
  private static final Color DARK_GRAY = new Color(45, 45, 45);
  private static final Color LIGHT_GRAY = new Color(220, 220, 220);

  // Button dimensions
  private Rectangle restartButton;
  private Rectangle menuButton;
  private Rectangle exitButton;

  public GameOver(Game game, int width, int height, int tileSize) {
    this.game = game;
    this.WIDTH = width;
    this.HEIGHT = height;
    this.TILESIZE = tileSize;

    // Initialize button rectangles
    int buttonWidth = 180;
    int buttonHeight = 45;
    int centerX = (WIDTH * TILESIZE) / 2 - buttonWidth / 2;
    int centerY = (HEIGHT * TILESIZE) / 2;

    restartButton = new Rectangle(centerX, centerY + 60, buttonWidth, buttonHeight);
    menuButton = new Rectangle(centerX, centerY + 120, buttonWidth, buttonHeight);
    exitButton = new Rectangle(centerX, centerY + 180, buttonWidth, buttonHeight);
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    // Animate fade and effects
    animationFrame = (animationFrame + 1) % 360;
    if (fadeAlpha < MAX_FADE) {
      fadeAlpha += 3;
    }

    // Draw dimmed background overlay
    drawBackground(g2d);

    // Draw animated failure pattern
    drawBackgroundPattern(g2d);

    // Draw game over title
    drawGameOverTitle(g2d);

    // Draw score and stats (you can integrate actual score)
    drawGameStats(g2d);

    // Draw controls info
    drawControlsInfo(g2d);
  }

  private void drawBackground(Graphics2D g2d) {
    // Create dimmed overlay with gradient
    GradientPaint overlay = new GradientPaint(
        0, 0, new Color(0, 0, 0, Math.min(fadeAlpha, 120)),
        0, HEIGHT * TILESIZE, new Color(20, 0, 0, Math.min(fadeAlpha, 160)));
    g2d.setPaint(overlay);
    g2d.fillRect(0, 0, WIDTH * TILESIZE, HEIGHT * TILESIZE);
  }

  private void drawBackgroundPattern(Graphics2D g2d) {
    // Draw subtle X pattern for game over effect
    g2d.setColor(new Color(255, 0, 0, 15));
    g2d.setStroke(new BasicStroke(3));

    int spacing = 40;
    for (int i = 0; i < 8; i++) {
      float alpha = (float) (Math.sin(Math.toRadians(animationFrame + i * 45)) + 1) / 2;
      g2d.setColor(new Color(255, 0, 0, (int) (alpha * 20 + 5)));

      int offset = (int) (Math.sin(Math.toRadians(animationFrame * 2 + i * 45)) * 10);
      int y = (HEIGHT * TILESIZE) / 8 * (i + 1) + offset;

      // Draw X pattern
      for (int x = 0; x < WIDTH * TILESIZE; x += spacing) {
        g2d.drawLine(x, y - 10, x + 20, y + 10);
        g2d.drawLine(x + 20, y - 10, x, y + 10);
      }
    }
  }

  private void drawGameOverTitle(Graphics2D g2d) {
    // Main "GAME OVER" title with dramatic effect
    Font titleFont = new Font("Arial", Font.BOLD, 56);
    g2d.setFont(titleFont);

    String title = "GAME OVER";
    FontMetrics fm = g2d.getFontMetrics();
    int titleX = (WIDTH * TILESIZE - fm.stringWidth(title)) / 2;
    int titleY = (HEIGHT * TILESIZE) / 2 - 40;

    // Title shadow with red tint
    g2d.setColor(new Color(100, 0, 0, 150));
    g2d.drawString(title, titleX + 4, titleY + 4);

    // Title gradient from red to orange
    GradientPaint titleGradient = new GradientPaint(
        titleX, titleY - 40, LIGHT_RED,
        titleX, titleY + 10, new Color(255, 140, 0));
    g2d.setPaint(titleGradient);
    g2d.drawString(title, titleX, titleY);

    // Add glowing effect
    g2d.setColor(new Color(255, 255, 255, 50));
    g2d.drawString(title, titleX, titleY);
  }

  private void drawGameStats(Graphics2D g2d) {
    Font statsFont = new Font("Arial", Font.BOLD, 18);
    g2d.setFont(statsFont);
    g2d.setColor(LIGHT_GRAY);

    // Score display (placeholder - integrate with actual score)
    String scoreText = "Final Score: 0";
    FontMetrics fm = g2d.getFontMetrics();
    int scoreX = (WIDTH * TILESIZE - fm.stringWidth(scoreText)) / 2;
    int scoreY = (HEIGHT * TILESIZE) / 2 + 20;
    g2d.drawString(scoreText, scoreX, scoreY);

    // Additional stats
    Font smallFont = new Font("Arial", Font.PLAIN, 14);
    g2d.setFont(smallFont);
    g2d.setColor(new Color(200, 200, 200, 200));
  }

  private void drawControlsInfo(Graphics2D g2d) {
    Font controlFont = new Font("Arial", Font.PLAIN, 11);
    g2d.setFont(controlFont);
    g2d.setColor(new Color(150, 150, 150, 180));

    String controls = "Press R to restart • M for menu • ESC to exit";
    FontMetrics fm = g2d.getFontMetrics();
    int controlX = (WIDTH * TILESIZE - fm.stringWidth(controls)) / 2;
    int controlY = HEIGHT * TILESIZE - 25;

    g2d.drawString(controls, controlX, controlY);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    switch (key) {
      case KeyEvent.VK_R:
      case KeyEvent.VK_SPACE:
      case KeyEvent.VK_ENTER:
        restartGame();
        break;
      case KeyEvent.VK_M:
        returnToMenu();
        break;
      case KeyEvent.VK_ESCAPE:
        exitGame();
        break;
      case KeyEvent.VK_UP:
      case KeyEvent.VK_DOWN:
        // Toggle button selection for keyboard navigation
        if (restartButtonHovered) {
          restartButtonHovered = false;
          menuButtonHovered = true;
        } else if (menuButtonHovered) {
          menuButtonHovered = false;
          restartButtonHovered = true;
        } else {
          restartButtonHovered = true;
        }
        break;
    }
  }

  // Game control methods
  private void restartGame() {
    game.setGameScreen(new GameBody(game, WIDTH, HEIGHT, TILESIZE));
    game.requestFocusInWindow();
  }

  private void returnToMenu() {
    game.setGameScreen(new StartMenu(game, WIDTH, HEIGHT, TILESIZE));
  }

  private void exitGame() {
    System.exit(0);
  }

  // Optional: Add mouse support for button clicks
  public void mouseClicked(int x, int y) {
    if (restartButton.contains(x, y)) {
      restartGame();
    } else if (menuButton.contains(x, y)) {
      returnToMenu();
    } else if (exitButton.contains(x, y)) {
      exitGame();
    }
  }

  public void mouseMoved(int x, int y) {
    restartButtonHovered = restartButton.contains(x, y);
    menuButtonHovered = menuButton.contains(x, y);
  }
}