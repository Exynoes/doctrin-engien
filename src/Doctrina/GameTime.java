package Doctrina;

import java.util.concurrent.TimeUnit;

public class GameTime {

    private static final int FPS_TARGET = 60;

    private static int currentFps;
    private static int fpsCount;
    private static long fpsTimeDelta;
    private static long gameStartTime;
    private long syncTime;
    public static long getCurrentTime(){
        return  System.currentTimeMillis();
    }

    public static int getCurrentFps(){
        return (currentFps > 0) ? currentFps : fpsCount;
    }

    public static long getElapsedTime(){
        return System.currentTimeMillis() - gameStartTime;
    }

    public static String getFormattedElapsedTime() {
        long time = getElapsedTime();
        long hours = TimeUnit.MILLISECONDS.toHours(time);
        time -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
        time -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    protected GameTime(){
        updaterSyncTime();
        gameStartTime = System.currentTimeMillis();
        fpsTimeDelta = 0;
        currentFps = 0;
    }

    public void synchronize(){
        update();
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        updaterSyncTime();
    }

    private void update(){
        fpsCount++;
        long currentSecond = getElapsedTime() / 1000;
        if (fpsTimeDelta != currentSecond){
            currentFps = fpsCount;
            fpsCount = 0;
        }
        fpsTimeDelta = currentSecond;
    }

    private long getSleepTime(){
        long targetTime = 1000L / FPS_TARGET;
        long sleep = targetTime - (System.currentTimeMillis() - syncTime);
        if (sleep < 0){
            sleep = 4;
        }
        return sleep;
    }

    private void updaterSyncTime() {
        syncTime = System.currentTimeMillis();
    }
}
