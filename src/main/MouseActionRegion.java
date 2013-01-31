package main;

public class MouseActionRegion implements MouseRespondable {

    private int x,y,width,height;
    
    public MouseActionRegion (int x, int y, int width, int height) {
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
    }
        
    @Override
    public boolean inBounds (int actionX, int actionY) {
        return actionX >= x && actionX <= x + width && actionY >= y && actionY <= y + height;
    }
    
    @Override
    public boolean mouseDown(int x, int y, int button) {
        return false;
    }
    
    @Override
    public boolean mouseUp(int x, int y, int button) {
        return false;
    }
    
    @Override
    public boolean mouseIn(int x, int y) {
        return false;
    }
    
    @Override
    public void mouseOut() {
    }
    
}
