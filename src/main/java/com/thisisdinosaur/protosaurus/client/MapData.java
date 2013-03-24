package com.thisisdinosaur.protosaurus.client;

import java.util.ArrayList;
import java.util.List;

import com.thisisdinosaur.protosaurus.shared.Maths;

public class MapData {

	protected static final int LOS_TILE_SIZE = 10;
	
	int width, height;
	List<LogicTicker> entities;
	
	public MapData(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.entities = new ArrayList<LogicTicker>();
	}

	public List<Integer[]> getVisibleTiles(List<GameEntity> losEntities) {
		
		// Simple inefficient implementation
		
		List<Integer[]> visibleTiles = new ArrayList<Integer[]>();
		
		for(int i = 0; i < this.width; i += LOS_TILE_SIZE) {
			for(int j = 0; j < this.height; j += LOS_TILE_SIZE) {
				
				for(int k = 0; k < losEntities.size(); k++) {
					if(Maths.getDistance(i + (LOS_TILE_SIZE / 2),
										 j + (LOS_TILE_SIZE / 2),
										 losEntities.get(k).getX(),
										 losEntities.get(k).getY()) <= losEntities.get(k).getLOS()) {
						
						visibleTiles.add(new Integer[]{i, j});
						break;
					}
				}
			}
		}
		
		return visibleTiles;
	}
	
}
