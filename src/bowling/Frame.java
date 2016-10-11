package bowling;

/**
 * Created by Sepehr hasanabadi.
 */
public class Frame {

    private Role firstRole;
    private Role secondRole;
    private Frame previousFrame;

    public Frame getPreviousFrame() {
        if (previousFrame == null)
            return this;

        return previousFrame;
    }

    public Frame() {

    }

    public Frame(Frame previousFrame) {
        this.previousFrame = previousFrame;

    }

    public boolean isFinish() {
        if (firstRole != null && firstRole.isSpare())
            return true;

        return secondRole != null;

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
        createRole();
        getCurrentRole().fallPins(fallen);
    }

    public boolean canAttempt() {
        if (firstRole == null) {
            if (previousFrame.isStrike())
                return true;
        }

        return false;
    }

    private void createRole() {
        if (firstRole == null) {
            firstRole = new Role(getPreviousFrame().getCurrentRole());
            if (getPreviousFrame().isStrike()) {
                firstRole.incrementFactor();
            }
        } else if (secondRole == null)
            secondRole = new Role(firstRole);
    }

}
