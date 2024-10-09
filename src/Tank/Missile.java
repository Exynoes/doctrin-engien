package Tank;

import Doctrina.Canvas;
import Doctrina.Direction;
import Doctrina.MovableEntity;

import java.awt.*;

public class Missile extends MovableEntity {

    private Direction tankDirection;

    public Missile(Tank tank){
        setSpeed(7);
        tankDirection = tank.getDirection();
        initialize(tank);
    }

    @Override
    public void update() {
        move(tankDirection);
        if (x >= 820){
            x = -20;
        }
        if (y >= 620){
            y = -20;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.YELLOW);
    }

    private void initialize(Tank tank){
        if (tankDirection == Direction.RIGHT){
            setDimension(8,4);
            teleport(tank.getX() + tank.getWidth() + 1, tank.getY() + tank.getHeight() / 2 - height / 2);
        } else if (tankDirection == Direction.LEFT) {
            setDimension(8,4);
            teleport(tank.getX() - tank.getWidth() + 1, tank.getY() + tank.getHeight() / 2 - height / 2);
        } else if (tankDirection == Direction.DOWN) {
            setDimension(4,8);
            teleport(tank.getX() + tank.getHeight() / 2 - height / 2, tank.getY() + tank.getWidth() + 1);
        } else if (tankDirection == Direction.UP) {
            setDimension(4,8);
            teleport(tank.getX() + tank.getHeight() / 2 - height / 2, tank.getY() - tank.getWidth() + 1);
        }
    }
}
