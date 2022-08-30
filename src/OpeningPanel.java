import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpeningPanel extends JPanel implements ActionListener {
    public static final int PANEL_WIDTH = 600;
    public static final int PANEL_HEIGHT = 600;
    protected JFrame gameFrame;
    protected JLabel message;
    protected JButton startButton;

    public OpeningPanel(JFrame gameFrame){
        this.gameFrame = gameFrame;
        message = new JLabel("Air Hockey");
        Font messageFont = new Font("Ink Free", Font.BOLD, 90);
        message.setFont(messageFont);
        FontMetrics fontMetrics = getFontMetrics(messageFont);
        int messageWidth = fontMetrics.stringWidth("Air Hockey");
        message.setForeground(Color.red);
        message.setBounds((PANEL_WIDTH)/2- (messageWidth/2), 85, messageWidth, 120 );

        startButton = new JButton("Start Game");
        startButton.setFont(new Font("Ink Free", Font.BOLD, 32));
        startButton.setForeground(Color.red);
        startButton.setBackground(Color.lightGray);
        startButton.setBounds((PANEL_WIDTH/2)-(220/2), message.getY()+message.getHeight()+60, 220, 100);
        startButton.addActionListener(this);

        this.add(message);
        this.add(startButton);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("hockey_background.jpg").getImage();
        g.drawImage(image, 0,0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==startButton){
            gameFrame.add(new GameScene());
            gameFrame.pack();
            gameFrame.setLocationRelativeTo(null);
        }

    }
}