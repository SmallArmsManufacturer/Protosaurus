package com.thisisdinosaur.protosaurus.shared;

import com.thisisdinosaur.protosaurus.client.GameEntity;

public class DinosaurEntity extends GameEntity {

    private DinosaurLocomotion locomotion;
    
    public DinosaurEntity () {
        
        this.locomotion = new DinosaurLocomotion(this);
        
    }
    
    @Override
    public void tick(int delta) {
        
        this.move(delta);
        
    }

    private void move(int delta) {
        
        this.locomotion.move(delta);
        
    }

    public float getRotation() {
        return this.locomotion.getAngle();
    }

    public float getTargetX() {
        return this.locomotion.getTargetX();
    }

    public void setTargetX(float targetX) {
        this.locomotion.setTargetX(targetX);
    }

    public float getTargetY() {
        return this.locomotion.getTargetY();
    }

    public void setTargetY(float targetY) {
        this.locomotion.setTargetY(targetY);
    }
    
}
