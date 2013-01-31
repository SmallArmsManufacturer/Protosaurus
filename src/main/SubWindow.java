package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class SubWindow implements Displayable, KeyboardRespondable, MouseRespondable{

    private List<Displayable> drawList;
    private List<MouseRespondable> mouseActionList;
    private List<KeyboardRespondable> keyboardActionList;

    public SubWindow () {
        
        this.drawList = new ArrayList<>();
        this.mouseActionList = new ArrayList<>();
        this.keyboardActionList = new ArrayList<>();
        
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
    public void draw(Graphics g) {
        
        for (int i = 0; i < drawList.size(); i++) {
            drawList.get(i).draw(g);
        }
        
    }

}
