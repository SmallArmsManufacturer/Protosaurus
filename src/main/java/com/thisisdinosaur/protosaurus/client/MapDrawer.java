package com.thisisdinosaur.protosaurus.client;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;



public class MapDrawer extends SubWindow {

    private static final Color GROUND_COLOUR_UNSEEN = new Color(100, 42, 0);
    private static final Color GROUND_COLOUR_SEEN = new Color(120, 72, 0);
    
    private GameWindow container;
    private Player player;
    
    // Changes object location on screen to simulate panning in 2d
    private AffineTransform defaultTransform;

    private int width, height;
    
    private float panX, panY;
	private List<Displayable> visDrawList;
    
    public MapDrawer (Player player, GameWindow container) {
        
    	visDrawList = new ArrayList<Displayable>();
    	
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
        for (int i = 0; i < this.visDrawList.size(); i++) {
            
        	if(player.isVisible(this.visDrawList.get(i).getX(), this.visDrawList.get(i).getY())) {
        	
	        	transform = new AffineTransform();
	        	
	            transform.setToTranslation(this.visDrawList.get(i).getX() + panX,
	                                       this.visDrawList.get(i).getY() + panY);
	            
	            transform.rotate(this.visDrawList.get(i).getRotation());
	            
	            g.setTransform(transform);
	            
	            this.visDrawList.get(i).draw(g);
	         
	            transform.setToTranslation(0, 0);
            
        	}
        }
        
        // Draw entities that don't need los e.g move markers
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
    	
    	List<Integer[]> visibleTiles = player.getVisibleTiles();

    	g.setColor(GROUND_COLOUR_UNSEEN);
    	g.fillRect((int)-panX, (int)-panY, width, height);
    	
    	g.setColor(GROUND_COLOUR_SEEN);
    	
    	for(int i = 0; i < visibleTiles.size(); i++) {
    		
    		Integer[] tile = visibleTiles.get(i);
    		
    		int tilePanX = (int) (tile[0] + panX);
    		int tilePanY = (int) (tile[1] + panY);
    		
    		// If on screen then draw
			if(tilePanX + MapData.LOS_TILE_SIZE >= 0 && tilePanX <= this.width && tilePanY + MapData.LOS_TILE_SIZE >= 0 && tilePanY <= this.height) {
    			g.fillRect(tile[0], tile[1], MapData.LOS_TILE_SIZE, MapData.LOS_TILE_SIZE);
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
    
    public void addVisDisplayable(Displayable displayable) {
    	this.visDrawList.add(displayable);
    }
    
}
