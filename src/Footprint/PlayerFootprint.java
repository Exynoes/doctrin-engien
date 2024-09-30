package Footprint;

import Doctrina.Canvas;
import MovingRectangle.Player;

import java.awt.*;

public class PlayerFootprint {
    private GamePadFootprint gamePadFootprint;
    private int x;
    private int y;
    private int speed;

    public PlayerFootprint(GamePadFootprint gamePadFootprint){
        this.gamePadFootprint = gamePadFootprint;
        x = 200;
        y = 200;
        speed = 10;
    }

    public void update(){
        if (gamePadFootprint.isDownPressed()){
            y += speed;
        } else if (gamePadFootprint.isUpPressed()){
            y -= speed;
        } else if (gamePadFootprint.isLeftPressed()){
            x -= speed;
        } else if (gamePadFootprint.isRightPressed()){
            x += speed;
        }
    }

    public void draw(Canvas canvas){
        canvas.drawRectangle(x,y,20,60, Color.WHITE);
    }
}
