package Footprint;

import Doctrina.Canvas;
import Doctrina.Game;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FootprintGame extends Game {

    private GamePadFootprint gamePadFootprint;
    private PlayerFootprint playerFootprint;
    private ArrayList<Footprint> footprints;

    @Override
    protected void initialize() {
        gamePadFootprint = new GamePadFootprint();
        playerFootprint = new PlayerFootprint(gamePadFootprint);
        footprints = new ArrayList<>();
    }

    @Override
    protected void update() {
        if (gamePadFootprint.isQuitKepPressed()){
            stop();
        }
        playerFootprint.update();
        if (gamePadFootprint.isMoving()){
            footprints.add(playerFootprint.layFootprint());
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        canvas.drawRectangle(0,0,800,600, Color.BLUE);
        for (Footprint footprint: footprints) {
            footprint.draw(canvas);
        }
        playerFootprint.draw(canvas);
    }
}
