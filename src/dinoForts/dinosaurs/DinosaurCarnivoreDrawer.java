package dinoForts.dinosaurs;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Displayable;

public class DinosaurCarnivoreDrawer implements Displayable {

    private static final Color BODY_COLOUR = Color.red;
    private static final Color NECK_COLOUR = Color.white;
    
    private static final int HALF_WIDTH = 6;
    private static final int HALF_HEIGHT = 14;

    private DinosaurEntity gameEntity;
    
    public DinosaurCarnivoreDrawer (DinosaurEntity gameEntity) {
        this.gameEntity = gameEntity;
    }
    
    @Override
    public void draw(Graphics2D g) {
        
        g.getTransform().rotate(Math.PI / 2);
        
        g.setColor(BODY_COLOUR);
        
        g.fillOval(-HALF_HEIGHT,
                   -HALF_WIDTH,
                   HALF_HEIGHT * 2,
                   HALF_WIDTH * 2);
        
        g.setColor(NECK_COLOUR);
        g.drawLine(0, 0, HALF_HEIGHT * 2, 0);
        
        g.getTransform().rotate(-gameEntity.getRotation());
        
    }

    @Override
    public float getX() {
        return this.gameEntity.getX();
    }

    @Override
    public float getY() {
        return this.gameEntity.getY();
    }

    @Override
    public float getRotation() {
        return this.gameEntity.getRotation();
    }

}
