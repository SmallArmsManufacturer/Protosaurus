package dinoForts;

import java.util.ArrayList;
import java.util.List;

import main.LogicTicker;
import main.MouseActionRegion;
import main.MouseRespondable;
import dinoForts.dinosaurs.Dinosaur;

public class MapLogic extends MouseActionRegion implements LogicTicker{

    private List<LogicTicker> entities;
    
    private MapDrawer mapDrawer;
    private EffectsDrawer effectsDrawer;

    private Dinosaur currentDinosaur;
    private MoveFlag moveFlag;
    
    public MapLogic (MapDrawer mapDrawer, EffectsDrawer effectsDrawer) {
        
        super(0, 0, mapDrawer.getWidth(), mapDrawer.getHeight());
        
        this.entities = new ArrayList<LogicTicker>();
        this.mapDrawer = mapDrawer;
        this.effectsDrawer = effectsDrawer;
        
        this.moveFlag = new MoveFlag();
        mapDrawer.addDisplayable(moveFlag);
        
    }

    @Override
    public void tick(int delta) {
        
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).tick(delta);
        }

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
            
            int mapX = x - (int)mapDrawer.getPanX();
            currentDinosaur.setTargetX(mapX);
            
            int mapY = y - (int)mapDrawer.getPanY();
            currentDinosaur.setTargetY(mapY);
            
//            MapPing mapPing = new MapPing();
//            
//            mapPing.setX(mapX);
//            mapPing.setY(mapY);
//            
//            effectsDrawer.addEffect(mapPing);
            
            moveFlag.setX(mapX);
            moveFlag.setY(mapY);
        }
        
        return true;
    }

    public void addEntity(LogicTicker entity) {
        this.entities.add(entity);
    }

    public void setCurrentDinosaur(Dinosaur currentDinosaur) {
        this.currentDinosaur = currentDinosaur;
    }
    
}
