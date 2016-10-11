package bowling;

import java.util.ArrayList;

/**
 * Created by Sepehr hasanabadi.
 */
public class Game {

    private static final int FRAMES_COUNT = 10;
    private ArrayList<Frame> frames;
    private int attempts;

    public Game() {
        this.frames = new ArrayList<>();
        this.attempts = 0;
    }

    public void attempt(int fallen) {
        attempts++;
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
        if (attempts <= FRAMES_COUNT)
            return true;

        if (attempts <= FRAMES_COUNT + 2 && attempts > FRAMES_COUNT) {
            return getCurrentFrame().canAttempt() || canAttempt(getPreviousFrame().getCurrentRole());
        }

        return false;
    }

    private boolean canAttempt(Role previousRole) {
        if (previousRole.isSpare() || previousRole.getPreviousRole().isSpare())
            return true;

        return false;
    }

    private void initFrame() {
        if (frames.size() == 0) {
            frames.add(new Frame());
        }
        else if (getCurrentFrame().isFinish()) {
            frames.add(new Frame(getCurrentFrame()));
        }
    }

    private Frame getCurrentFrame() {
        if (frames.size() < 1)
            return null;

        return frames.get(frames.size() - 1);
    }

    private Frame getPreviousFrame() {
        if (frames.size() < 2)
            return null;

        return frames.get(frames.size() - 2);
    }

}
