import java.awt.*;

public class Score{

    public static int GAME_WIDTH;
    public static int GAME_HEIGHT;
    protected int player1;
    protected int player2;

    Score(int GAME_WIDTH, int GAME_HEIGHT) {
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }

    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.RED);
        graphics2D.setFont(new Font("Consolas", Font.PLAIN, 60));

        graphics2D.setStroke(new BasicStroke(7));
        graphics2D.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);
        graphics2D.drawOval(GAME_WIDTH / 2 - 62, GAME_HEIGHT / 2 - 62, GAME_WIDTH /8, GAME_HEIGHT / 4);

        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(String.valueOf(player1 / 10) + String.valueOf(player1 % 10), (GAME_WIDTH / 2) - 85, 50);
        graphics2D.drawString(String.valueOf(player2 / 10) + String.valueOf(player2 % 10), (GAME_WIDTH / 2) + 20, 50);
    }
}