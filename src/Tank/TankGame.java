package Tank;

import Doctrina.Canvas;
import Doctrina.CollidableRepository;
import Doctrina.Game;
import Doctrina.StaticEntity;

import java.util.ArrayList;

public class TankGame extends Game {
    private GamePadTank gamePadTank;
    private Tank tank;
    private ArrayList<Missile> missiles;
    private ArrayList<Brick> bricks;

    @Override
    protected void initialize() {
        gamePadTank = new GamePadTank();
        tank = new Tank(gamePadTank);
        missiles = new ArrayList<>();
        bricks = new ArrayList<>();
        bricks.add(new Brick(500,500));
        bricks.add(new Brick(484,542));
        bricks.add(new Brick(600,360));
        bricks.add(new Brick(500,140));
        bricks.add(new Brick(350,360));
        bricks.add(new Brick(240,450));

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

        ArrayList<StaticEntity> killedEntities = new ArrayList<>();

        for (Missile missile: missiles){
            missile.update();
            for (Brick brick: bricks){
                if (missile.hitBoxIntersectWith(brick)){
                    killedEntities.add(missile);
                    killedEntities.add(brick);
                }
            }
        }

        for (StaticEntity killedEntity: killedEntities){
            if (killedEntity instanceof Brick){
                bricks.remove(killedEntity);
            }
            if (killedEntity instanceof Missile){
                missiles.remove(killedEntity);
            }
        }
        CollidableRepository.getInstance().unregisterEntities(killedEntities);
    }

    @Override
    protected void draw(Canvas canvas) {
        tank.draw(canvas);
        for (Missile missile: missiles){
            missile.draw(canvas);
        }
        for (Brick brick: bricks){
            brick.draw(canvas);
        }
    }
}
