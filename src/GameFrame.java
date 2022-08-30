import javax.swing.*;
public class GameFrame extends JFrame{


    GameFrame(){
        this.add(new OpeningPanel(this));
        this.setVisible(true);
        this.pack();
        this.setTitle("Air hockey");
        this.setIconImage(new ImageIcon("hockey_icon.png").getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}

