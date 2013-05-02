import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: flocl
 * Date: 13-5-2
 * Time: 下午6:41
 * To change this template use File | Settings | File Templates.
 */
public class BowlingGameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
   public void testOneKick() {
       //given
       //when
       game.kick(1);
       //then
       assertThat(game.getScore(),is(1));
    }

    @Test
    public void testAllOnes() {
        //given
        //when
        kickScores(20,1);
        //then
        assertThat(game.getScore(),is(20));
    }

    @Test

    public void testOneSpare() {
        //given
        //when
        whenSpare();
        //then
        assertThat(game.getScore(),is(16));
    }

    private void whenSpare() {
        game.kick(3);
        game.kick(7);
        game.kick(3);
        kickScores(17, 0);
    }

    private void kickScores(int times, int pins) {
        for (int i = 0; i < times; i ++){
            game.kick(pins);
        }
    }

    @Test

    public void testOneStrike() {
        //given
        //when
        whenStrike();
        //then
        assertThat(game.getScore(),is(20));
    }

    private void whenStrike() {
        game.kick(10);
        game.kick(2);
        game.kick(3);
        kickScores(16,0);
    }

    @Test

    public void testPerfectGame() {
        //given
        //when
        kickScores(12,10);
        //then
        assertThat(game.getScore(),is(300));
    }
}
