package com.thisisdinosaur.protosaurus.client;

public interface MouseRespondable {

    public static final int LEFT_CLICK = 1;
    public static final int RIGHT_CLICK = 3;
    public static final int MIDDLE_CLICK = 2;
    
    public boolean mouseDown (int x, int y, int button);
    
    public boolean mouseUp (int x, int y, int button);
    
    public boolean mouseIn (int x, int y);
    
    public void mouseOut ();

    boolean inBounds(int actionX, int actionY);
    
}
