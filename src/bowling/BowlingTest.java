package bowling;

import org.junit.Before;
import org.junit.Test;


/**
 * Created by Sepehr hasanabadi.
 */
public class BowlingTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void attempt() {
        game.attempt(10);
        game.attempt(10);

        game.attempt(10);
        game.attempt(10);

        game.attempt(10);
        game.attempt(10);

        game.attempt(10);
        game.attempt(10);

        game.attempt(7);
        game.attempt(3);

        game.attempt(1);
        game.attempt(9);

        printScore(game.getScore());
    }

    private void printScore(int score) {
        System.out.println("global score: " + score);
    }

}
