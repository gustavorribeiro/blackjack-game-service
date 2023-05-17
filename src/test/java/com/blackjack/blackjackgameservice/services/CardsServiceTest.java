package com.blackjack.blackjackgameservice.services;

import com.blackjack.blackjackgameservice.enums.Rank;
import com.blackjack.blackjackgameservice.enums.Suit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardsServiceTest {
    @Test
    void testGetRank() {
        CardsService card = new CardsService(Rank.ACE, Suit.SPADES);
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    void testGetSuit() {
        CardsService card = new CardsService(Rank.KING, Suit.DIAMONDS);
        assertEquals(Suit.DIAMONDS, card.getSuit());
    }

    @Test
    void testGetValue() {
        CardsService aceCard = new CardsService(Rank.ACE, Suit.CLUBS);
        CardsService jackCard = new CardsService(Rank.JACK, Suit.HEARTS);
        CardsService sixCard = new CardsService(Rank.SIX, Suit.SPADES);

        assertEquals(11, aceCard.getValue());
        assertEquals(10, jackCard.getValue());
        assertEquals(6, sixCard.getValue());
    }

    @Test
    void testToString() {
        CardsService card = new CardsService(Rank.QUEEN, Suit.HEARTS);
        assertEquals("QUEEN of HEARTS", card.toString());
    }
}

