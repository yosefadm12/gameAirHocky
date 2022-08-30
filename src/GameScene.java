import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import java.util.*;
import javax.swing.*;



public class GameScene extends JPanel{
    public static final int GAME_WIDTH = 1000;
    public static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    public static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    public static final int BALL_DIAMETER = 20;
    public static final int PADDLE_WIDTH = 50;
    public static final int PADDLE_HEIGHT = 50;
    protected Random random;
    protected Scull scull1;
    protected Scull scull2;
    protected Gate gate1;
    protected Gate gate2;
    protected Ball ball;
    protected Score score;

    public GameScene(){
        this.setPreferredSize(SCREEN_SIZE);
        newScull();
        newBall();
        newGates();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        gameLoop();
    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
    }
    public void newScull() {
        scull1 = new Scull(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        scull2 = new Scull(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);

    }
    public void newGates(){
        gate1 = new Gate(0-250/2,(GAME_HEIGHT/2)-(250/2),250,250, 270, 180 );
        gate2 = new Gate(GAME_WIDTH-250/2, (GAME_HEIGHT/2)-(250/2), 250, 250, 90, 180);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gate1.paint(g);
        gate2.paint(g);
        scull1.paint(g);
        scull2.paint(g);
        ball.paint(g);
        score.draw(g);
    }

    public void move() {
        scull1.move();
        scull2.move();
        ball.move();
    }


    public void checkCollisions() {
        //bounce ball off top & bottom window edges
        if(ball.y <=0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }
        //bounce ball off paddles
        if(ball.intersects(scull1) && !(ball.intersects(gate1))) {
            ball.setXDirection(Math.abs(ball.xVelocity));
            if (scull1.x > GAME_WIDTH/4)
                ball.setXDirection(ball.xVelocity++);
        }
        if(ball.intersects(scull2) && !(ball.intersects(gate2))) {
            if (ball.xVelocity>0)
                ball.setXDirection(-ball.xVelocity);
            if (scull2.x < (GAME_WIDTH/4)*3)
                ball.setYDirection(ball.yVelocity++);
        }

        //stop paddles when they reach the window edges
        if(scull1.y<=0)
            scull1.y=0;
        if (scull1.x<=0)
            scull1.x = 0;
        if(scull1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            scull1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        if (scull1.x >= (GAME_WIDTH/2)-PADDLE_WIDTH)
            scull1.x = (GAME_WIDTH/2)-PADDLE_WIDTH;

        if(scull2.y<=0)
            scull2.y=0;
        if (scull2.x>=GAME_WIDTH-PADDLE_WIDTH)
            scull2.x =GAME_WIDTH-PADDLE_WIDTH;
        if(scull2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            scull2.y = GAME_HEIGHT-PADDLE_HEIGHT;
        if (scull2.x <= (GAME_WIDTH/2))
            scull2.x = (GAME_WIDTH/2);

        //give a players points and creates new paddles & ball
        if(ball.intersects(gate2)) {
            if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
                score.player1++;
                newScull();
                newBall();
            }
        }
        if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
            newScull();
            newBall();
        }
        if(ball.intersects(gate1)) {
            if(ball.x <=0) {
                score.player2++;
                newScull();
                newBall();
            }
        }
        if(ball.x <=0) {
            newScull();
            newBall();
        }

    }


    public void gameLoop(){
        new Thread( ()-> {
            this.addKeyListener(new Listener());
            this.setFocusable(true);
            this.requestFocus();
            while (true){
                move();
                checkCollisions();
                repaint();
                try {
                    Thread.sleep(9);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private class Listener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            scull1.keyPressed(e);
            scull2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            scull1.keyReleased(e);
            scull2.keyReleased(e);
        }
    }


}

