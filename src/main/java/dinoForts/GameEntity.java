package dinoForts;

import main.LogicTicker;

public abstract class GameEntity implements LogicTicker {
    
    private float x, y;
    
    public GameEntity () {
        
        x = 0;
        y = 0;
        
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    @Override
    public void tick(int delta) {
    }
    
}
