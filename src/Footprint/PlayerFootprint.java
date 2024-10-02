package Footprint;

import Doctrina.Canvas;
import Doctrina.ControllableEntity;
import Doctrina.MovableEntity;

import java.awt.*;

public class PlayerFootprint extends ControllableEntity {

    public PlayerFootprint(GamePadFootprint gamePadFootprint){
        super(gamePadFootprint);
        teleport(200,200);
        setDimension(20,60);
        setSpeed(3);
    }

    @Override
    public void update(){
        moveWithController();
    }

    @Override
    public void draw(Canvas canvas){
        canvas.drawRectangle(this, Color.WHITE);
    }

    public Footprint layFootprint(){
        return new Footprint(x,y);
    }
}
