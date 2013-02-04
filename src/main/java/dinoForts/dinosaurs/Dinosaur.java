package dinoForts.dinosaurs;

import java.awt.Graphics2D;

import main.Displayable;
import main.LogicTicker;

public abstract class Dinosaur implements Displayable, LogicTicker {

    protected DinosaurEntity dinosaurEntity;
    protected Displayable dinosaurDrawer;
    
    protected int popCount, resourceCount;
    
    public Dinosaur (DinosaurEntity dinosaurEntity, Displayable dinosaurDrawer, int popCount, int resourceCount) {
        
        this.dinosaurEntity = dinosaurEntity;
        this.dinosaurDrawer = dinosaurDrawer;
        
        this.popCount = popCount;
        this.resourceCount = resourceCount;
        
    }

    public int getPopCount() {
        return popCount;
    }

    public void setPopCount(int popCount) {
        this.popCount = popCount;
    }

    public int getResourceCount() {
        return resourceCount;
    }

    public void setResourceCount(int resourceCount) {
        this.resourceCount = resourceCount;
    }
    
    public float getX () {
        return this.dinosaurEntity.getX();
    }
    
    public float getY () {
        return this.dinosaurEntity.getY();
    }
    
    public void setX(int x) {
        this.dinosaurEntity.setX(x);
    }
    
    public void setY(int y) {
        this.dinosaurEntity.setY(y);
    }

    @Override
    public void tick(int delta) {
        this.dinosaurEntity.tick(delta);
    }

    @Override
    public void draw(Graphics2D g) {
        this.dinosaurDrawer.draw(g);
    }
    
    public float getRotation() {
        return this.dinosaurDrawer.getRotation();
    }

    public void setTargetX(float x) {
        this.dinosaurEntity.setTargetX(x);
    }

    public void setTargetY(float y) {
        this.dinosaurEntity.setTargetY(y);
    }
    
}
