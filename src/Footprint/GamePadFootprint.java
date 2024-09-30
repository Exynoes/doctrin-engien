package Footprint;

import Doctrina.MovementController;
import MovingRectangle.GamePad;

import java.awt.event.KeyEvent;

public class GamePadFootprint extends MovementController {

    private int quitKey = KeyEvent.VK_Q;

    public GamePadFootprint(){
        bindKey(quitKey);
    }

    public boolean isQuitKepPressed (){
        return isKeyPressed(quitKey);
    }
}
