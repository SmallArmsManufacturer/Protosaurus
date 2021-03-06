package com.thisisdinosaur.protosaurus.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.thisisdinosaur.protosaurus.shared.Dinosaur;


public class MapLogic extends MouseActionRegion implements LogicTicker{

    private Set<Player> players;
    private Player selectedPlayer;
    
    private MapDrawer mapDrawer;
    private EffectsDrawer effectsDrawer;

    private MoveFlag moveFlag;
	private MapData map;
    
    public MapLogic (MapDrawer mapDrawer, EffectsDrawer effectsDrawer, int width, int height) {
        
        super(0, 0, mapDrawer.getWidth(), mapDrawer.getHeight());
        
        this.map = new MapData(width, height);
        this.players = new HashSet<Player>();
        
        this.mapDrawer = mapDrawer;
        this.effectsDrawer = effectsDrawer;
        
        this.moveFlag = new MoveFlag();
        mapDrawer.addDisplayable(moveFlag);
        
    }

    @Override
    public void tick(int delta) {
    	
        for (int i = 0; i < map.entities.size(); i++) {
        	map.entities.get(i).tick(delta);
        }
        
        selectedPlayer.setVisibleTiles(map.getVisibleTiles(selectedPlayer.getLOSEntities()));

    }
    
    @Override
    public boolean inBounds(int actionX, int actionY) {
        
        // Update the size of the map mouse response every time it is queried
        // to make sure it is correct size after rescaling
        this.setWidth(mapDrawer.getWidth());
        this.setHeight(mapDrawer.getWidth());
        
        return super.inBounds(actionX, actionY);
    }
    
    @Override
    public boolean mouseDown(int x, int y, int button) {
        if(button == MouseRespondable.RIGHT_CLICK) {
        	
        	Dinosaur selectedDinosaur = selectedPlayer.getSelectedEntity();
        	
            int mapX = x - (int)mapDrawer.getPanX();
			selectedDinosaur .setTargetX(mapX);
            
            int mapY = y - (int)mapDrawer.getPanY();
            selectedDinosaur.setTargetY(mapY);
            
            moveFlag.setX(mapX);
            moveFlag.setY(mapY);
        }
        
        return true;
    }

    public void addEntity(LogicTicker entity) {
        map.entities.add(entity);
    }

    public List<Dinosaur> getPlayerControlledDinosaurs() {
    	List<Dinosaur> dinosaurs = new ArrayList<Dinosaur>();
    	
    	for(Player player : this.players) {
    		dinosaurs.addAll(player.getDinosaurs());
    	}
    	
    	return dinosaurs;
    }

	public void selectPlayer(Player player) {
		this.players.add(player);
		this.selectedPlayer = player;
	}
	
	public Player getSelectedPlayer() {
		return this.selectedPlayer;
	}

	public Set<Player> getPlayers() {
		return this.players;
	}
    
}
