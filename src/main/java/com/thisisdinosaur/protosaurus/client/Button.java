package com.thisisdinosaur.protosaurus.client;

import java.awt.Graphics2D;


public class Button implements Displayable, MouseRespondable{

    private MouseActionRegion actionRegion;
    private Displayable buttonDisplay;
    
    public Button (MouseActionRegion actionRegion, Displayable display) {
        
        this.actionRegion = actionRegion;
        this.buttonDisplay = display;
        
    }

    @Override
    public boolean mouseDown(int x, int y, int button) {
        return this.actionRegion.mouseDown(x, y, button);
    }

    @Override
    public boolean mouseUp(int x, int y, int button) {
        return this.actionRegion.mouseUp(x, y, button);
    }

    @Override
    public boolean mouseIn(int x, int y) {
        return this.actionRegion.mouseIn(x, y);
    }

    @Override
    public void mouseOut() {
        this.actionRegion.mouseOut();
    }

    @Override
    public boolean inBounds(int actionX, int actionY) {
        return this.actionRegion.inBounds(actionX, actionY);
    }

    @Override
    public void draw(Graphics2D g) {
        this.buttonDisplay.draw(g);
    }

    @Override
    public float getX() {
        return this.actionRegion.getX();
    }

    @Override
    public float getY() {
        return this.actionRegion.getY();
    }

    @Override
    public float getRotation() {
        return this.buttonDisplay.getRotation();
    }
    
}
