package MovingRectangle;

import Doctrina.MovementController;

import java.awt.event.KeyEvent;

public class GamePad extends MovementController {

    private int quitKey = KeyEvent.VK_Q;

    public GamePad(){
        bindkey(quitKey);
    }

    public boolean isQuitPressed(){
        return isKeyPressed(quitKey);
    }
}