package Tank;

import Doctrina.Canvas;
import Doctrina.Game;

import java.util.ArrayList;

public class TankGame extends Game {
    private GamePadTank gamePadTank;
    private Tank tank;
    private ArrayList<Missile> missiles;

    @Override
    protected void initialize() {
        gamePadTank = new GamePadTank();
        tank = new Tank(gamePadTank);
        missiles = new ArrayList<>();
    }

    @Override
    protected void update() {
        if (gamePadTank.isQuitPressed()){
            stop();
        }
        if (gamePadTank.isFirePressed() && tank.canFire()){
            missiles.add(tank.fire());
        }
        tank.update();
        for (Missile missile: missiles){
            missile.update();
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        tank.draw(canvas);
        for (Missile missile: missiles){
            missile.draw(canvas);
        }
    }
}
