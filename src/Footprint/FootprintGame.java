package Footprint;

import Doctrina.Canvas;
import Doctrina.Game;

import java.awt.*;
import java.util.ArrayList;

public class FootprintGame extends Game {

    private GamePadFootprint gamePadFootprintOne;
    private GamePadFootprint gamePadFootprintTwo;
    private PlayerFootprint playerFootprintOne;
    private PlayerFootprint playerFootprintTwo;
    private ArrayList<Footprint> footprints;

    @Override
    protected void initialize() {
        gamePadFootprintOne = new GamePadFootprint();
        playerFootprintOne = new PlayerFootprint(gamePadFootprintOne);

        gamePadFootprintTwo = new GamePadFootprint();
        gamePadFootprintTwo.useWasdKeys();

        playerFootprintTwo = new PlayerFootprint(gamePadFootprintTwo);

        footprints = new ArrayList<>();
    }

    @Override
    protected void update() {
        if (gamePadFootprintOne.isQuitKepPressed()){
            stop();
        }
        playerFootprintOne.update();
        playerFootprintTwo.update();
        if (gamePadFootprintOne.isMoving()){
            footprints.add(playerFootprintOne.layFootprint());
        }
        if (gamePadFootprintTwo.isMoving()){
            footprints.add(playerFootprintTwo.layFootprint());
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        canvas.drawRectangle(0,0,800,600, Color.BLUE);
        for (Footprint footprint: footprints) {
            footprint.draw(canvas);
        }
        playerFootprintOne.draw(canvas);
        playerFootprintTwo.draw(canvas);
    }
}
