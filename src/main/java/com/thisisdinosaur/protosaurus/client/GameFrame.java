package com.thisisdinosaur.protosaurus.client;

import com.thisisdinosaur.protosaurus.shared.DinosaurCarnivore;
import com.thisisdinosaur.protosaurus.shared.DinosaurFactory;
import com.thisisdinosaur.protosaurus.shared.ResourceNode;
import com.thisisdinosaur.protosaurus.shared.ResourceNodeFactory;


public class GameFrame extends SubWindow {

    private MapDrawer mapDrawer;
    private MapLogic mapLogic;
    private EffectsDrawer effectsDrawer;
    private GameKeyboardHandler keyboardHandler;
    
    private Player player;
    
    public GameFrame () {
        
    }
    
    public void init (GameWindow container) {
        
        initMap(container);
        initDinosaurPicker();
        // TEMP
        initGame();
        
    }

    private void initMap (GameWindow container) {
        
    	player = new Player();
    	
        // Create Map
        this.mapDrawer = new MapDrawer(player, container);
        this.effectsDrawer = new EffectsDrawer(mapDrawer);
        this.mapLogic = new MapLogic(mapDrawer, effectsDrawer, 800, 800);
        this.keyboardHandler = new GameKeyboardHandler(mapLogic, mapDrawer);
        
        this.mapLogic.selectPlayer(player);
        
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
        
        ResourceNode node1 = ResourceNodeFactory.makeResourceNode(mapLogic);
        node1.setX(500);
        node1.setY(500);
        mapDrawer.addVisDisplayable(node1);
        mapLogic.addEntity(node1);
        
        ResourceNode node2 = ResourceNodeFactory.makeResourceNode(mapLogic);
        node2.setX(150);
        node2.setY(300);
        mapDrawer.addVisDisplayable(node2);
        mapLogic.addEntity(node2);

        initUi();
    }
    
    private void placeDinosaurs() {

        DinosaurCarnivore carnivore = DinosaurFactory.makeCarnivore();
        mapDrawer.addVisDisplayable(carnivore);
        mapLogic.addEntity(carnivore);
        player.setSelectedEntity(carnivore);
        
        player.addDinosaur(carnivore);
    }

    private void initUi () {

        // Create various Ui elements
        
    }
    
}
