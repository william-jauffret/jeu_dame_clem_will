package testpacakge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import org.junit.Before;
import org.junit.Test;

public class JeuDameTest {

	private JeuDame game;

    @Before
    public void doBefore() throws Exception {
        game = new JeuDameImpl();
    }

    @Test
    public void aPlayerMayEatChip() throws Exception {
        game.play(RED, 3);
        assertThat(game.getCell(3, 0)).isEqualTo(RED);

        game.play(RED, 3);
        assertThat(game.getCell(3, 1)).isEqualTo(RED);

        assertThat(game.getCell(3, 2)).isNull();
        assertThat(game.getCell(4, 5)).isNull();
    }
    

    @Test
    public void itCantPlayOutsideOfTheBoard() throws Exception {
        try {
            game.play(RED, 10);
            fail("It should not be possible to play outside of the board");
        } catch (GameException e) {

        }

        try {
            for (int i = 0; i <= game.getRowsNumber(); i++) {
                game.play(RED, 3);
            }
            fail("It should not be possible to play outside of the board");
        } catch (GameException e) {

        }

    }

    
    @Test
    public void itCanWinTheGameDiagonally() throws Exception {
        assertThat(game.getWinner()).isNull();
        game.play(RED, 0);
        game.play(YELLOW, 1);
        game.play(RED, 1);
        game.play(YELLOW, 2);
        game.play(RED, 2);
        game.play(YELLOW, 3);
        game.play(RED, 2);
        game.play(YELLOW, 3);
        game.play(RED, 3);
        game.play(YELLOW, 4);
        game.play(RED, 3);

        assertThat(game.getWinner()).isEqualTo(RED);
        System.out.println(game);

    }
}
