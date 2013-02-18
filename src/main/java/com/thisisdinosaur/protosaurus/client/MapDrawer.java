package com.thisisdinosaur.protosaurus.client;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import com.thisisdinosaur.protosaurus.shared.Maths;



public class MapDrawer extends SubWindow {

    private static final Color GROUND_COLOUR_UNSEEN = new Color(100, 42, 0);
    private static final Color GROUND_COLOUR_SEEN = new Color(120, 72, 0);
    
    private static final int FOG_TILE_SIZE = 10;
    
    private GameWindow container;
    private Player player;
    
    // Changes object location on screen to simulate panning in 2d
    private AffineTransform defaultTransform;

    private int width, height;
    
    private float panX, panY;
    
    public MapDrawer (Player player, GameWindow container) {
        
    	this.player = player;
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
        
        transform.setToTranslation(panX,panY);
        g.setTransform(transform);
        
        drawFogOfWar(g);
        
        // Draw map entities e.g Resource Node, Relic, Dinosaur
        for (int i = 0; i < this.drawList.size(); i++) {
            
        	transform = new AffineTransform();
        	
            transform.setToTranslation(this.drawList.get(i).getX() + panX,
                                       this.drawList.get(i).getY() + panY);
            
            transform.rotate(this.drawList.get(i).getRotation());
            
            g.setTransform(transform);
            
            this.drawList.get(i).draw(g);
         
            transform.setToTranslation(0, 0);
        }
        
        g.setTransform(defaultTransform);
        
    }
    
    private void drawFogOfWar(Graphics2D g){
    	for(int i = 0; i < container.getWidth(); i+= FOG_TILE_SIZE){
        	for(int j = 0; j < container.getHeight(); j+= FOG_TILE_SIZE){
        		for(int k = 0; k < this.player.getLOSEntities().size(); k++){
        			if(Maths.getDistance(this.player.getLOSEntities().get(k).getX(), this.player.getLOSEntities().get(k).getY(), i - panX, j - panY) < 200){
        				g.setColor(GROUND_COLOUR_SEEN);
    	                g.fillRect(i - (int)panX, j - (int)panY, FOG_TILE_SIZE, FOG_TILE_SIZE);
        			}
        			else{
        				g.setColor(GROUND_COLOUR_UNSEEN);
    	                g.fillRect(i - (int)panX, j - (int)panY, FOG_TILE_SIZE, FOG_TILE_SIZE);
        			}
        		}
        	}
        }
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
