package Viking;

import Doctrina.Canvas;
import Doctrina.Game;
import Doctrina.RenderingEngine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class VikingGame extends Game {
    private Player player;
    private GamePad gamePad;
    private World world;
    private Tree tree;

    private int soundCooldown;

    @Override
    protected void initialize() {

        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream("audio/music.wav"));
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        gamePad = new GamePad();
        player = new Player(gamePad);
        world = new World();
        world.load();
        tree = new Tree();

        RenderingEngine.getInstance().getScreen().fullscreen();
        RenderingEngine.getInstance().getScreen().hideCursor();
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()){
            stop();
        }
        player.update();

        soundCooldown--;
        if (soundCooldown < 0){
            soundCooldown = 0;
        }
        if (gamePad.isFirePressed() && soundCooldown == 0){
            soundCooldown = 10;
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream audioInputStream =
                        AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream("audio/fire.wav"));
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        world.draw(canvas);
        if (player.getY() < tree.getY() + 40) {
            player.draw(canvas);
            tree.draw(canvas);
        } else {
            tree.draw(canvas);
            player.draw(canvas);
        }
    }
}
