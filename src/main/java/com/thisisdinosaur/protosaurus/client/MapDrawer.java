package com.thisisdinosaur.protosaurus.client;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;



public class MapDrawer extends SubWindow {

    private static final Color GROUND_COLOUR = new Color(120, 72, 0);
    
    private GameWindow container;

    // Changes object location on screen to simulate panning in 2d
    private AffineTransform defaultTransform;

    private int width, height;
    
    private float panX, panY;
    
    public MapDrawer (GameWindow container) {
        
        this.container = container;
        
        this.defaultTransform = new AffineTransform();
        
        this.panX = 0f;
        this.panY = 0f;
        
    }

    @Override
    public void draw(Graphics2D g) {
        
        AffineTransform transform = new AffineTransform();
        
        this.width = container.getWidth();
        this.height = container.getHeight();
        
        // Draw a dirt coloured rectangle to represent the ground
        g.setColor(GROUND_COLOUR);
        g.fillRect(0, 0, width, height);
        
        // Draw map entities e.g Resource Node, Relic, Dinosaur
        for (int i = 0; i < this.drawList.size(); i++) {
            
            transform.setToTranslation(this.drawList.get(i).getX() + panX,
                                       this.drawList.get(i).getY() + panY);
            
            transform.rotate(this.drawList.get(i).getRotation());
            
            g.setTransform(transform);
            
            this.drawList.get(i).draw(g);
         
            transform.setToTranslation(0, 0);
        }
        
        g.setTransform(defaultTransform);
        
    }

    public void pan (int xIncrement, int yIncrement) {
        
        this.panX += xIncrement;
        this.panY += yIncrement;
        
    }

    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }

    public float getPanX() {
        return panX;
    }

    public float getPanY() {
        return panY;
    }
    
}
