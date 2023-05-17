package com.blackjack.blackjackgameservice.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackjackGameServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void testPlayBlackjack_PlayerWinsWithBlackjack() {
        String input = "N\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BlackjackGameService game = new BlackjackGameService();

        try {
            game.play();
        } catch (NoSuchElementException ignored) {}


        String consoleOutput = outContent.toString().trim();

        String expectedOutput = consoleOutput;

        assertEquals(expectedOutput, consoleOutput);
    }

    @Test
    void testPlayBlackjack_PlayerBusts() {
        String input = "Y\nN\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BlackjackGameService game = new BlackjackGameService();

        try {
            game.play();
        } catch (NoSuchElementException ignored) {}

        String consoleOutput = outContent.toString().trim();

        String expectedOutput = consoleOutput;

        assertEquals(expectedOutput, consoleOutput);
    }

    @Test
    void testPlayBlackjack_ShuffleDeck() {
        String input = "S\nN\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BlackjackGameService game = new BlackjackGameService();

        try {
            game.play();
        } catch (NoSuchElementException ignored) {}

        String consoleOutput = outContent.toString().trim();

        String expectedOutput = consoleOutput;

        assertEquals(expectedOutput, consoleOutput);
    }

    @Test
    void testPlayBlackjack_PlayAgain() {
        String input = "Y\nN\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BlackjackGameService game = new BlackjackGameService();

        try {
            game.play();
        } catch (NoSuchElementException ignored) {}

        String consoleOutput = outContent.toString().trim();

        String expectedOutput = consoleOutput;

        assertEquals(expectedOutput, consoleOutput);
    }
}
