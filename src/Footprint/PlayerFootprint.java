package Footprint;

import Doctrina.Canvas;
import Doctrina.MovableEntity;

import java.awt.*;

public class PlayerFootprint extends MovableEntity {
    private GamePadFootprint gamePadFootprint;


    public PlayerFootprint(GamePadFootprint gamePadFootprint){
        this.gamePadFootprint = gamePadFootprint;
        teleport(200,200);
        setDimension(20,60);
        setSpeed(3);
    }

    public void update(){
        if (gamePadFootprint.isMoving()){
            move(gamePadFootprint.getDirection());
        }
    }

    public void draw(Canvas canvas){
        canvas.drawRectangle(this, Color.WHITE);
    }

    public Footprint layFootprint(){
        return new Footprint(x,y);
    }
}
