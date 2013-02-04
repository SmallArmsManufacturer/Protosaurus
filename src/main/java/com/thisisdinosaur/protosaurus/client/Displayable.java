package com.thisisdinosaur.protosaurus.client;

import java.awt.Graphics2D;

public interface Displayable {

    public void draw (Graphics2D g);

    public float getX();
    
    public float getY();

    public float getRotation();
    
}
