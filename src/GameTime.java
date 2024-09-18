public class GameTime {

    private  static final int SLEEP = 25;

    private long syncTime;


    public static long getCurrentTime(){
        return  System.currentTimeMillis();
    }

    public GameTime(){
        updaterSyncTime();
    }

    public void sleep(){
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        updaterSyncTime();
    }

    private long getSleepTime(){
        long sleep = SLEEP - (System.currentTimeMillis() - syncTime);
        if (sleep < 4){
            sleep = 4;
        }
        return sleep;
    }

    private void updaterSyncTime() {
        syncTime = System.currentTimeMillis();
    }
}
