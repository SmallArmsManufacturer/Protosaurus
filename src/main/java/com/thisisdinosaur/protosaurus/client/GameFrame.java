package com.thisisdinosaur.protosaurus.client;

import com.thisisdinosaur.protosaurus.shared.DinosaurCarnivore;
import com.thisisdinosaur.protosaurus.shared.DinosaurFactory;


public class GameFrame extends SubWindow {

    private MapDrawer mapDrawer;
    private MapLogic mapLogic;
    private EffectsDrawer effectsDrawer;
    private GameKeyboardHandler keyboardHandler;
    
    public GameFrame () {
        
    }
    
    public void init (GameWindow container) {
        
        initMap(container);
        initDinosaurPicker();
        // TEMP
        initGame();
        
    }

    private void initMap (GameWindow container) {
        
        // Create Map
        this.mapDrawer = new MapDrawer(container);
        this.effectsDrawer = new EffectsDrawer(mapDrawer);
        this.mapLogic = new MapLogic(mapDrawer, effectsDrawer);
        this.keyboardHandler = new GameKeyboardHandler(mapLogic, mapDrawer);
        
        // Reserve Dinosaur Locations
        
    }

    private void initDinosaurPicker () {
        
        // Create ui to choose what dinosaur the player wants to start with
        
    }
    
    public void initGame () {
        
        // Add map objects to updater lists
        this.addDisplayable(mapDrawer);
        this.addLogicTicker(mapLogic);
        this.addMouseActionListener(mapLogic);
        
        this.addDisplayable(effectsDrawer);
        this.addLogicTicker(effectsDrawer);
        
        this.addKeyboardActionListener(keyboardHandler);
        
        // Place dinosaurs in reserved location
        // taking into consideration what ones the player and ai chose to make sure the map contains at least one dinosaur of each type
        placeDinosaurs();
        
        initUi();
        
    }
    
    private void placeDinosaurs() {

        DinosaurCarnivore carnivore = DinosaurFactory.makeCarnivore();
        mapDrawer.addDisplayable(carnivore);
        mapLogic.addEntity(carnivore);
        mapLogic.setCurrentDinosaur(carnivore);
    }

    private void initUi () {

        // Create various Ui elements
        
    }
    
}
