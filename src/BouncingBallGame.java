import java.awt.*;

public class BouncingBallGame extends Game {

    private int score;
    private Ball ball;

    @Override
    protected void initialize() {
        ball = new Ball(25);
    }

    @Override
    public void update(){
        ball.update();
        if (ball.hasTouched()){
            score += 10;
        }
    }
    @Override
    public void drawOnBuffer(Graphics2D bufferEngine){
        ball.draw(bufferEngine);

        bufferEngine.setPaint(Color.WHITE);
        bufferEngine.drawString("Score: " + score,10,20);
    }
}
