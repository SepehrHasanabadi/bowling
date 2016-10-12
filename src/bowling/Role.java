package bowling;

/**
 * Created by Sepehr hasanabadi.
 */
public class Role {

    public static final int PINS_COUNT = 10;
    private int score;
    private int scoreFactor;
    private Role previousRole;
    private int fallenPins;

    public Role(Role previousRole) {
        this.previousRole = previousRole;
        this.scoreFactor = 1;
    }

    public void incrementFactor() {
        scoreFactor++;
    }

    public void fallPins(int fallen) {
        this.score = fallen;
        this.fallenPins = fallen;
    }

    public Role getPreviousRole() {
        if (previousRole == null)
            return new Role(null);

        return previousRole;
    }

    public void setPreviousRole(Role previousRole) {
        this.previousRole = previousRole;
    }

    public int getScore() {
        if (getPreviousRole().isSpare()) {
            incrementFactor();
        }
        if (getPreviousRole().getPreviousRole().isSpare())
            incrementFactor();

        return score * scoreFactor;
    }

    public int getFallenPins() {
        return fallenPins;
    }

    public boolean isSpare() {
        return getFallenPins() == PINS_COUNT;
    }

    public boolean canAttempt() {
        if (getPreviousRole().isSpare() || getPreviousRole().getPreviousRole().isSpare())
            return true;

        return false;
    }

}
