package Tank;

import Doctrina.Canvas;
import Doctrina.Game;

public class TankGame extends Game {
    private GamePadTank gamePadTank;
    private Tank tank;


    @Override
    protected void initialize() {
        gamePadTank = new GamePadTank();
        tank = new Tank(gamePadTank);
    }

    @Override
    protected void update() {
        if (gamePadTank.isQuitPressed()){
            stop();
        }
        tank.update();
    }

    @Override
    protected void draw(Canvas canvas) {
        tank.draw(canvas);
    }
}
