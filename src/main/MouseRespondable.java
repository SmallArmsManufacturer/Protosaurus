package main;

public interface MouseRespondable {

    public boolean mouseDown (int x, int y, int button);
    
    public boolean mouseUp (int x, int y, int button);
    
    public boolean mouseIn (int x, int y);
    
    public void mouseOut ();

    boolean inBounds(int actionX, int actionY);
    
}
