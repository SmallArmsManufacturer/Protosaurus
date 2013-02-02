package dinoForts;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Displayable;

public class MoveFlag implements Displayable {

    private int x, y;

    public MoveFlag () {
        this.x = 0;
        this.y = 0;
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.pink);
        g.fillOval(-5, -5, 10, 10);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public float getRotation() {
        return 0;
    }

}
