import java.awt.*;

public class Gate extends Rectangle {
    protected int startAngle;
    protected int arcAngle;

    public Gate(int x, int y, int width, int height, int startAngle, int arcAngle){
        super(x, y, width, height);
        this.startAngle = startAngle;
        this.arcAngle = arcAngle;
    }

    public void paint(Graphics g){
        g.setColor(Color.cyan);
        g.fillArc(this.x, this.y, this.width, this.height, this.startAngle, this.arcAngle);
    }
}