package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Sasha", 15);
    Player player2 = new Player(2, "Masha", 10);
    Player player3 = new Player(3, "Lena", 10);
    Player player4 = new Player(4, "Stas", 18);
    Player player5 = new Player(5, "Lesha", 13);
    Player player6 = new Player(6, "Ivan", 20);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void whenFirstPlayerIsStronger() {
        int actual = game.round("Sasha", "Masha");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void  whenSecondPlayerIsStronger() {
        int actual = game.round("Lena", "Stas");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenStrengthIsEqual() {
        int actual = game.round("Masha", "Lena");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerIsNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Lesha", "Lena"));
    }

    @Test
    public void whenSecondPlayerIsNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Sasha", "Ivan"));
    }

    @Test
    public void whenBothPlayersAreNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Lesha", "Ivan"));
    }
}
