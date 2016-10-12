package bowling;

import java.util.ArrayList;

/**
 * Created by Sepehr hasanabadi.
 */
public class Game {

    private static final int FRAMES_COUNT = 10;
    private ArrayList<Frame> frames;
    private int framesAttempts;

    public Game() {
        this.frames = new ArrayList<>();
        this.framesAttempts = 0;
    }

    public void attempt(int fallen) {
        initFrame();
        if (canAttempt())
            getCurrentFrame().attempt(fallen);
    }

    public int getScore() {
        int score = 0;
        for (Frame frame : frames) {
            score += frame.getScore();
        }

        return score;
    }

    private boolean canAttempt() {
        return (framesAttempts <= FRAMES_COUNT ||
                (getCurrentFrame().canAttempt() || getCurrentFrame().getCurrentRole().canAttempt()));
    }

    private void initFrame() {
        if (frames.size() == 0) {
            frames.add(new Frame());
            framesAttempts++;
        }
        else if (getCurrentFrame().isFinish()) {
            frames.add(new Frame(getCurrentFrame()));
            framesAttempts++;
        }
    }

    private Frame getCurrentFrame() {
        if (frames.size() < 1)
            return null;

        return frames.get(frames.size() - 1);
    }

}
