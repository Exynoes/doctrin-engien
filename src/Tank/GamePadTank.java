package Tank;

import Doctrina.MovementController;

import java.awt.event.KeyEvent;

public class GamePadTank extends MovementController{
    private final int quitKey = KeyEvent.VK_Q;
    private final int fireKey = KeyEvent.VK_SPACE;

    public GamePadTank(){
        bindKey(quitKey);
        bindKey(fireKey);
    }

    public boolean isQuitPressed(){
        return isKeyPressed(quitKey);
    }

    public boolean isFirePressed(){
        return isKeyPressed(fireKey);
    }
}
