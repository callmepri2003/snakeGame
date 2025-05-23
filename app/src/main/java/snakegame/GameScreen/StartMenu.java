package snakegame.GameScreen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;

import snakegame.Game;

public class StartMenu implements GameScreen {
  private int WIDTH;
  private int HEIGHT;
  private int TILESIZE;
  private Game game;

  // UI State
  private boolean playButtonHovered = false;
  private int animationFrame = 0;

  // Colors
  private static final Color DARK_GREEN = new Color(34, 139, 34);
  private static final Color LIGHT_GREEN = new Color(144, 238, 144);
  private static final Color GOLD = new Color(255, 215, 0);
  private static final Color DARK_GRAY = new Color(45, 45, 45);
  private static final Color LIGHT_GRAY = new Color(220, 220, 220);

  // Button dimensions
  private Rectangle playButton;
  private Rectangle exitButton;

  public StartMenu(Game game, int width, int height, int tileSize) {
    this.game = game;
    this.WIDTH = width * tileSize;
    this.HEIGHT = height * tileSize;
    this.TILESIZE = tileSize;

    // Initialize button rectangles
    int buttonWidth = 200;
    int buttonHeight = 50;
    int centerX = WIDTH / 2 - buttonWidth / 2;

    playButton = new Rectangle(centerX, HEIGHT / 2 + 20, buttonWidth, buttonHeight);
    exitButton = new Rectangle(centerX, HEIGHT / 2 + 90, buttonWidth, buttonHeight);
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    // Animate background
    animationFrame = (animationFrame + 1) % 360;

    // Draw gradient background
    drawBackground(g2d);

    // Draw animated snake pattern in background
    drawBackgroundPattern(g2d);

    // Draw title
    drawTitle(g2d);

    // Draw subtitle
    drawSubtitle(g2d);

    // Draw version/credits
    drawCredits(g2d);
  }

  private void drawBackground(Graphics2D g2d) {
    // Create gradient background
    GradientPaint gradient = new GradientPaint(
        0, 0, new Color(20, 30, 20),
        0, HEIGHT, new Color(40, 60, 40));
    g2d.setPaint(gradient);
    g2d.fillRect(0, 0, WIDTH, HEIGHT);
  }

  private void drawBackgroundPattern(Graphics2D g2d) {
    // Draw subtle snake-like pattern
    g2d.setColor(new Color(255, 255, 255, 10));
    g2d.setStroke(new BasicStroke(2));

    for (int i = 0; i < 5; i++) {
      int offset = (int) (Math.sin(Math.toRadians(animationFrame + i * 72)) * 20);
      int y = HEIGHT / 6 * (i + 1) + offset;

      for (int x = -50; x < WIDTH + 50; x += 30) {
        int waveY = (int) (Math.sin(Math.toRadians(x * 0.5 + animationFrame)) * 15);
        g2d.fillOval(x, y + waveY, 8, 8);
      }
    }
  }

  private void drawTitle(Graphics2D g2d) {
    // Main title with shadow effect
    Font titleFont = new Font("Arial", Font.BOLD, 48);
    g2d.setFont(titleFont);

    String title = "FEED THE SNAKE";
    FontMetrics fm = g2d.getFontMetrics();
    int titleX = (WIDTH - fm.stringWidth(title)) / 2;
    int titleY = HEIGHT / 4;

    // Title shadow
    g2d.setColor(new Color(0, 0, 0, 100));
    g2d.drawString(title, titleX + 3, titleY + 3);

    // Title gradient
    GradientPaint titleGradient = new GradientPaint(
        titleX, titleY - 30, GOLD,
        titleX, titleY + 10, LIGHT_GREEN);
    g2d.setPaint(titleGradient);
    g2d.drawString(title, titleX, titleY);
  }

  private void drawSubtitle(Graphics2D g2d) {
    Font subtitleFont = new Font("Arial", Font.ITALIC, 16);
    g2d.setFont(subtitleFont);
    g2d.setColor(LIGHT_GRAY);

    String subtitle = "A Classic Snake Adventure";
    FontMetrics fm = g2d.getFontMetrics();
    int subtitleX = (WIDTH - fm.stringWidth(subtitle)) / 2;
    int subtitleY = HEIGHT / 4 + 30;

    g2d.drawString(subtitle, subtitleX, subtitleY);
  }

  private void drawPlayButton(Graphics2D g2d) {
    // Button background with hover effect
    Color buttonColor = playButtonHovered ? LIGHT_GREEN : DARK_GREEN;

    // Button shadow
    g2d.setColor(new Color(0, 0, 0, 50));
    g2d.fill(new RoundRectangle2D.Double(
        playButton.x + 2, playButton.y + 2,
        playButton.width, playButton.height, 15, 15));

    // Button background
    GradientPaint buttonGradient = new GradientPaint(
        playButton.x, playButton.y, buttonColor,
        playButton.x, playButton.y + playButton.height, buttonColor.darker());
    g2d.setPaint(buttonGradient);
    g2d.fill(new RoundRectangle2D.Double(
        playButton.x, playButton.y,
        playButton.width, playButton.height, 15, 15));

    // Button border
    g2d.setColor(GOLD);
    g2d.setStroke(new BasicStroke(2));
    g2d.draw(new RoundRectangle2D.Double(
        playButton.x, playButton.y,
        playButton.width, playButton.height, 15, 15));

    // Button text
    Font buttonFont = new Font("Arial", Font.BOLD, 18);
    g2d.setFont(buttonFont);
    g2d.setColor(Color.WHITE);

    String playText = "▶ PLAY GAME";
    FontMetrics fm = g2d.getFontMetrics();
    int textX = playButton.x + (playButton.width - fm.stringWidth(playText)) / 2;
    int textY = playButton.y + (playButton.height + fm.getAscent()) / 2 - 2;

    g2d.drawString(playText, textX, textY);
  }

  private void drawExitButton(Graphics2D g2d) {
    // Simple exit button
    g2d.setColor(new Color(0, 0, 0, 50));
    g2d.fill(new RoundRectangle2D.Double(
        exitButton.x + 2, exitButton.y + 2,
        exitButton.width, exitButton.height, 15, 15));

    g2d.setColor(DARK_GRAY);
    g2d.fill(new RoundRectangle2D.Double(
        exitButton.x, exitButton.y,
        exitButton.width, exitButton.height, 15, 15));

    g2d.setColor(LIGHT_GRAY);
    g2d.setStroke(new BasicStroke(1));
    g2d.draw(new RoundRectangle2D.Double(
        exitButton.x, exitButton.y,
        exitButton.width, exitButton.height, 15, 15));

    Font buttonFont = new Font("Arial", Font.PLAIN, 16);
    g2d.setFont(buttonFont);
    g2d.setColor(LIGHT_GRAY);

    String exitText = "EXIT";
    FontMetrics fm = g2d.getFontMetrics();
    int textX = exitButton.x + (exitButton.width - fm.stringWidth(exitText)) / 2;
    int textY = exitButton.y + (exitButton.height + fm.getAscent()) / 2 - 2;

    g2d.drawString(exitText, textX, textY);
  }

  private void drawGameInfo(Graphics2D g2d) {
    // High score and instructions
    Font infoFont = new Font("Arial", Font.PLAIN, 14);
    g2d.setFont(infoFont);
    g2d.setColor(LIGHT_GRAY);

    // High Score (placeholder - you can integrate with actual high score system)
    String highScore = "High Score: 0";
    FontMetrics fm = g2d.getFontMetrics();
    int hsX = (WIDTH - fm.stringWidth(highScore)) / 2;
    int hsY = HEIGHT / 2 + 180;
    g2d.drawString(highScore, hsX, hsY);

    // Instructions
    String[] instructions = {
        "Use ARROW KEYS to move",
        "Collect food to grow",
        "Don't hit walls or yourself!"
    };

    g2d.setColor(new Color(200, 200, 200, 180));
    Font instructFont = new Font("Arial", Font.PLAIN, 12);
    g2d.setFont(instructFont);

    for (int i = 0; i < instructions.length; i++) {
      String instruction = instructions[i];
      FontMetrics ifm = g2d.getFontMetrics();
      int instX = (WIDTH - ifm.stringWidth(instruction)) / 2;
      int instY = HEIGHT / 2 + 220 + (i * 18);
      g2d.drawString(instruction, instX, instY);
    }
  }

  private void drawCredits(Graphics2D g2d) {
    Font creditFont = new Font("Arial", Font.PLAIN, 10);
    g2d.setFont(creditFont);
    g2d.setColor(new Color(150, 150, 150, 200));

    String credits = "Press SPACE or ENTER to play • ESC to exit";
    FontMetrics fm = g2d.getFontMetrics();
    int credX = (WIDTH - fm.stringWidth(credits)) / 2;
    int credY = HEIGHT - 20;

    g2d.drawString(credits, credX, credY);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    switch (key) {
      case KeyEvent.VK_SPACE:
      case KeyEvent.VK_ENTER:
        startGame();
        break;
      case KeyEvent.VK_ESCAPE:
        exitGame();
        break;
      case KeyEvent.VK_UP:
      case KeyEvent.VK_DOWN:
        // Toggle button selection if you want keyboard navigation
        playButtonHovered = !playButtonHovered;
        break;
    }
  }

  // Stub methods for you to implement
  private void startGame() {
    game.setGameScreen(new GameBody(game, WIDTH / TILESIZE, HEIGHT / TILESIZE, TILESIZE));
  }

  private void exitGame() {
    System.out.println("Exiting game...");
  }

  // Optional: Add mouse support for button clicks
  public void mouseClicked(int x, int y) {
    if (playButton.contains(x, y)) {
      startGame();
    } else if (exitButton.contains(x, y)) {
      exitGame();
    }
  }

  public void mouseMoved(int x, int y) {
    playButtonHovered = playButton.contains(x, y);
  }
}