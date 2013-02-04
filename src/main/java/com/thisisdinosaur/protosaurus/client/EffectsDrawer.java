package com.thisisdinosaur.protosaurus.client;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class EffectsDrawer extends SubWindow{

    private List<Effect> effects;
    
    private MapDrawer mapDrawer;
    
    public EffectsDrawer (MapDrawer mapDrawer) {
        this.effects = new ArrayList<Effect>();
        this.mapDrawer = mapDrawer;
    }
    
    public void addEffect (Effect effect) {
       this.effects.add(effect);
    }
    
    @Override
    public void tick(int delta) {
        
        Iterator<Effect> effectIt = this.effects.iterator();
        
        while (effectIt.hasNext()) {
            Effect effect = effectIt.next();
            
            effect.tick(delta);
            
            if(effect.isDead())
                effectIt.remove();
        }
        
    }
    
    @Override
    public void draw(Graphics2D g) {
        
        AffineTransform panTransform = new AffineTransform();
        panTransform.setToTranslation(mapDrawer.getPanX(), mapDrawer.getPanY());
        
        g.setTransform(panTransform);
        
        for (int i = 0; i < effects.size(); i++) {
            effects.get(i).draw(g);
        }
        
        g.getTransform().setToTranslation(0, 0);
    }
}
