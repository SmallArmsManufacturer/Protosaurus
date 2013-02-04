package main;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class SubWindow implements Displayable, KeyboardRespondable, MouseRespondable, LogicTicker {

    protected List<Displayable> drawList;
    protected List<MouseRespondable> mouseActionList;
    protected List<KeyboardRespondable> keyboardActionList;
    protected List<LogicTicker> logicTickList;
    
    protected float x, y;

    public SubWindow () {
        
        this.drawList = new ArrayList<>();
        this.mouseActionList = new ArrayList<>();
        this.keyboardActionList = new ArrayList<>();
        this.logicTickList = new ArrayList<>();
        
        x = 0;
        y = 0;
        
    }
    
    @Override
    public boolean mouseDown(int x, int y, int button) {
        
        for (int i = 0; i < mouseActionList.size(); i++) {
            if(mouseActionList.get(i).inBounds(x, y) && mouseActionList.get(i).mouseDown(x, y, button))
                return true;
        }
        
        return false;
        
    }

    @Override
    public boolean mouseUp(int x, int y, int button) {
        
        for (int i = 0; i < mouseActionList.size(); i++) {
            if(mouseActionList.get(i).inBounds(x, y) && mouseActionList.get(i).mouseUp(x, y, button))
                return true;
        }
        
        return false;
        
    }

    @Override
    public boolean mouseIn(int x, int y) {
        
        for (int i = 0; i < mouseActionList.size(); i++) {
            
            boolean inBounds = mouseActionList.get(i).inBounds(x, y);
            
            if(inBounds && mouseActionList.get(i).mouseIn(x, y))
                return true;
            else if(!inBounds)
                mouseActionList.get(i).mouseOut();
            
        }
        
        return false;
        
    }

    @Override
    public void mouseOut() {}

    @Override
    public boolean inBounds(int actionX, int actionY) {
        return true;
    }

    @Override
    public void keyDown(int keyCode) {
        
        for (int i = 0; i < keyboardActionList.size(); i++) {
            keyboardActionList.get(i).keyDown(keyCode);
        }
        
    }

    @Override
    public void keyUp(int keyCode) {
        
        for (int i = 0; i < keyboardActionList.size(); i++) {
            keyboardActionList.get(i).keyUp(keyCode);
        }
        
    }

    @Override
    public void draw(Graphics2D g) {
        
        for (int i = 0; i < drawList.size(); i++) {
            drawList.get(i).draw(g);
        }
        
    }
    
    @Override
    public void tick(int delta) {

        for (int i = 0; i < logicTickList.size(); i++) {
            logicTickList.get(i).tick(delta);
        }
        
    }
    
    public void addDisplayable (Displayable displayable) {
        this.drawList.add(displayable);
    }
    
    public void removeDisplayable (Displayable displayable) {
        this.drawList.remove(displayable);
    }
    
    public void addMouseActionListener (MouseRespondable mouseRespondable) {
        this.mouseActionList.add(mouseRespondable);
    }
    
    public void removeMouseActionListener (MouseRespondable mouseRespondable) {
        this.mouseActionList.remove(mouseRespondable);
    }

    public void addKeyboardActionListener (KeyboardRespondable keyboardRespondable) {
        this.keyboardActionList.add(keyboardRespondable);
    }
    
    public void removeKeyboardActionListener (KeyboardRespondable keyboardRespondable) {
        this.keyboardActionList.remove(keyboardRespondable);
    }
    
    public void addLogicTicker (LogicTicker logicTicker) {
        this.logicTickList.add(logicTicker);
    }
    
    public void removeLogicTicker (LogicTicker logicTicker) {
        this.logicTickList.remove(logicTicker);
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public float getRotation() {
        return 0;
    }

}
