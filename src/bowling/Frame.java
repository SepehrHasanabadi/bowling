package bowling;

/**
 * Created by Sepehr hasanabadi.
 */
public class Frame {

    private Role firstRole;
    private Role secondRole;
    private Frame previousFrame;
    private boolean isUsedSecondRole;

    public Frame getPreviousFrame() {
        if (previousFrame == null)
            return this;

        return previousFrame;
    }

    public Frame() {
        isUsedSecondRole = false;
        initRole();
    }

    public Frame(Frame previousFrame) {
        isUsedSecondRole = false;
        this.previousFrame = previousFrame;
        initRole();
    }

    public boolean isFinish() {
        if (firstRole.isSpare())
            return true;

        return isUsedSecondRole;
    }

    public int getScore() {
        int firstScore = (firstRole == null ? 0 : firstRole.getScore());
        int secondScore = (secondRole == null ? 0 : secondRole.getScore());

        System.out.println("first role score: " + firstScore + "   second role score: " + secondScore);
        return firstScore + secondScore;

    }

    public boolean isStrike() {
        if (firstRole != null && secondRole != null) {
            return firstRole.getFallenPins() + secondRole.getFallenPins() == Role.PINS_COUNT;
        }

        return false;
    }

    public Role getCurrentRole() {
        if (secondRole == null)
            return firstRole;

        return secondRole;
    }

    public void attempt(int fallen) {
        getCurrentRole().fallPins(fallen);
        initRole();
    }

    public boolean canAttempt() {
        if (secondRole == null) {
            if (previousFrame.isStrike())
                return true;
        }

        return false;
    }

    private void initRole() {
        if (firstRole == null) {
            firstRole = new Role(getPreviousFrame().getCurrentRole());
            if (getPreviousFrame().isStrike()) {
                firstRole.incrementFactor();
            }
        } else if (!firstRole.isSpare() && secondRole == null)
            secondRole = new Role(firstRole);
        else isUsedSecondRole = true;
    }

}
