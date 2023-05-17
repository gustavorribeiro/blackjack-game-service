package com.blackjack.blackjackgameservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeckServiceTest {
    private DeckService deck;

    @BeforeEach
    public void setup() {
        deck = new DeckService();
    }

    @Test
    public void testConstructor() {
        List<CardsService> cards = deck.getCards();
        assertNotNull(cards);
        assertEquals(52, cards.size());
    }

    @Test
    public void testShuffle() {
        List<CardsService> initialCards = deck.getCards();
        deck.shuffle();
        List<CardsService> shuffledCards = deck.getCards();
        assertNotEquals(initialCards, shuffledCards);
    }

    @Test
    public void testDrawCard() {
        int initialSize = deck.getCards().size();
        CardsService card = deck.drawCard();
        assertNotNull(card);
        assertEquals(initialSize - 1, deck.getCards().size());
    }
}
