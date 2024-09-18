package Doctrina;

import java.awt.event.KeyEvent;

public class MovementController extends Controller{

    private int upKey = KeyEvent.VK_UP;
    private int downKey = KeyEvent.VK_DOWN;
    private int leftKey = KeyEvent.VK_LEFT;
    private int rightKey = KeyEvent.VK_RIGHT;

    public MovementController(){
        bindkey(upKey);
        bindkey(downKey);
        bindkey(leftKey);
        bindkey(rightKey);
    }

    public boolean isLeftPressed(){
        return isKeyPressed(leftKey);
    }

    public boolean isRightPressed(){
        return isKeyPressed(rightKey);
    }

    public boolean isUpPressed(){
        return isKeyPressed(upKey);
    }

    public boolean isDownPressed(){
        return isKeyPressed(downKey);
    }

    public boolean isMoving(){
        return  isUpPressed() ||isDownPressed() || isRightPressed() || isLeftPressed();
    }

    public void setDownKey(int keyCode){
        unbindKey(downKey);
        bindkey(keyCode);
        this.downKey = keyCode;
    }

    public void setUpKey(int keyCode){
        unbindKey(upKey);
        bindkey(keyCode);
        this.upKey = keyCode;
    }

    public void setLeftKeyKey(int keyCode){
        unbindKey(leftKey);
        bindkey(keyCode);
        this.leftKey = keyCode;
    }

    public void setRightKey(int keyCode){
        unbindKey(rightKey);
        bindkey(keyCode);
        this.rightKey = keyCode;
    }
}
