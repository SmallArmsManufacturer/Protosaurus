package main;

import javax.swing.SwingUtilities;

import dinoForts.GameFrame;

public class Main {

    public static void main(String[] args) {
        // Start Swing objects on event dispatch thread to avoid errors
        SwingUtilities.invokeLater(new Runnable() { 
            
            @Override
            public void run() {
                GameWindow gameWindow = new GameWindow();
                gameWindow.init();   
                
                GameFrame gameFrame = new GameFrame();
                
                gameFrame.init(gameWindow);
                
                gameWindow.addDisplayable(gameFrame);
                gameWindow.addMouseActionListener(gameFrame);
                gameWindow.addKeyboardActionListener(gameFrame);
                gameWindow.addLogicTicker(gameFrame);
                
            }
            
        });
    }
    
}
