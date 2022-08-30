
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class Scull extends Rectangle {

    protected int speed = 5;
    protected int userId;
    protected int yVelocity, xVelocity;


    public Scull(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.userId = id;
    }


    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void setXDirection(int yDirection) {
        xVelocity = yDirection;
    }

    public void move() {
        y = y + yVelocity;
        x = x + xVelocity;
    }

    public void paint(Graphics g) {
        if (userId == 1) {
            g.drawImage(new ImageIcon("scull1.png").getImage(), x, y, width, height, null);
        } else {
            g.drawImage(new ImageIcon("scull2.png").getImage(), x, y, width, height, null);
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (userId) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    setXDirection(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    setXDirection(speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setXDirection(speed =0);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setYDirection(speed =0);
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    setXDirection(speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setXDirection(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setXDirection(speed =0);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setYDirection(speed =0);
                }
                break;


        }

    }

    public void keyReleased(KeyEvent e) {
        switch (userId) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    setXDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    setXDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setXDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setYDirection(0);
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    setXDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setXDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setXDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    setYDirection(0);
                }
                break;
        }
    }
}
