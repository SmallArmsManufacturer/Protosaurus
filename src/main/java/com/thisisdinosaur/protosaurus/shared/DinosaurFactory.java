package com.thisisdinosaur.protosaurus.shared;

public class DinosaurFactory {

    private static final int DEFAULT_POP_COUNT = 1;
    private static final int DEFAULT_RES_COUNT = 0;
    
    public static DinosaurCarnivore makeCarnivore () {
     
        DinosaurEntity dinosaurEntity = new DinosaurEntity();
        DinosaurCarnivoreDrawer dinosaurDrawer = new DinosaurCarnivoreDrawer(dinosaurEntity);
        return new DinosaurCarnivore(dinosaurEntity, dinosaurDrawer, DEFAULT_POP_COUNT, DEFAULT_RES_COUNT);
        
    }
    
}
