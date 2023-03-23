package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class GameTest {
    @Test
    public void testWhenPlayer1Win() {
        Game game = new Game();
        Player player_1 = new Player(1, "Tim", 15);
        Player player_2 = new Player(2, "Bim", 10);

        game.register(player_1);
        game.register(player_2);

        int expected = 1;
        int actual = game.round("Tim", "Bim");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayer2Win() {
        Game game = new Game();
        Player player_1 = new Player(1, "Tim", 15);
        Player player_2 = new Player(2, "Bim", 20);

        game.register(player_1);
        game.register(player_2);

        int expected = 2;
        int actual = game.round("Tim", "Bim");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDeadHeat() {
        Game game = new Game();
        Player player_1 = new Player(1, "Tim", 20);
        Player player_2 = new Player(2, "Bim", 20);

        game.register(player_1);
        game.register(player_2);

        int expected = 0;
        int actual = game.round("Tim", "Bim");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenOnOfPlayer1IsNotRegistered() {
        Game game = new Game();
        Player player_1 = new Player(1, "Tim", 20);
        Player player_2 = new Player(2, "Bim", 20);

        game.register(player_1);
        game.register(player_2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Sim", "Bim");
        });
    }

    @Test
    public void testWhenOnOfPlayer2IsNotRegistered() {
        Game game = new Game();
        Player player_1 = new Player(1, "Tim", 20);
        Player player_2 = new Player(2, "Bim", 20);

        game.register(player_1);
        game.register(player_2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Tim", "Zim");
        });
    }

    @Test
    public void testWhenBothPlayersIsNotRegistered() {
        Game game = new Game();
        Player player_1 = new Player(1, "Tim", 20);
        Player player_2 = new Player(2, "Bim", 20);

        game.register(player_1);
        game.register(player_2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Sim", "Zim");
        });
    }
}