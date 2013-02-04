package dinoForts;

import java.awt.Color;
import java.awt.Graphics2D;

public class MapPing extends Effect {

    private static final int LIFE_TIME = 2000;

    public MapPing() {
        super(LIFE_TIME);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.pink);
        g.fillOval(this.x -5, this.y -5, 10, 10);
    }

}
