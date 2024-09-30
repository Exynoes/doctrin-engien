package Footprint;

import Doctrina.Canvas;
import Doctrina.Game;

import java.awt.*;

public class FootprintGame extends Game {

    private GamePadFootprint gamePadFootprint;
    private PlayerFootprint playerFootprint;

    @Override
    protected void initialize() {
        gamePadFootprint = new GamePadFootprint();
        playerFootprint = new PlayerFootprint(gamePadFootprint);
    }

    @Override
    protected void update() {
        if (gamePadFootprint.isQuitKepPressed()){
            stop();
        }
        playerFootprint.update();
    }

    @Override
    protected void draw(Canvas canvas) {
        canvas.drawRectangle(0,0,800,600, Color.BLUE);
        playerFootprint.draw(canvas);
    }
}
