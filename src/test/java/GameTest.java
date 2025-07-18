import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test // победил 1 игрок
    void testRoundPlayer1Wins() {
        Player dima = new Player(1, "Дима", 5);
        Player danya = new Player(2, "Даня", 2);
        Game game = new Game();

        game.register(dima);
        game.register(danya);
        int actual = game.round("Дима", "Даня");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test // победил 2 игрок
    void testRoundPlayer2Wins() {
        Player dima = new Player(1, "Дима", 2);
        Player danya = new Player(2, "Даня", 5);
        Game game = new Game();

        game.register(dima);
        game.register(danya);
        int actual = game.round("Дима", "Даня");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test // ничья
    void testRoundDraw() {
        Player dima = new Player(1, "Дима", 5);
        Player danya = new Player(3, "Аня", 5);
        Game game = new Game();

        game.register(dima);
        game.register(danya);
        int actual = game.round("Дима", "Аня");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test // ничья
    void test1PlayerNotRegistered() {
        Player dima = new Player(1, "Дима", 5);
        Game game = new Game();

        game.register(dima);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Дима", "Даня"));
    }

    @Test // ничья
    void test2PlayerNotRegistered() {
        Player dima = new Player(2, "Даня", 2);
        Game game = new Game();

        game.register(dima);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Даня", "Дима"));
    }

}
