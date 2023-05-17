package com.blackjack.blackjackgameservice.services;

import com.blackjack.blackjackgameservice.enums.Rank;
import com.blackjack.blackjackgameservice.enums.Suit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PlayerServiceTest {
    private PlayerService player;

    @BeforeEach
    void setUp() {
        player = new PlayerService();
    }

    @Test
    void addCard_shouldIncreaseHandSize() {
        CardsService card = new CardsService(Rank.ACE, Suit.SPADES);
        player.addCard(card);

        List<CardsService> hand = player.getHand();

        Assertions.assertEquals(1, hand.size());
        Assertions.assertEquals(card, hand.get(0));
    }

    @Test
    void renewHandCards_shouldEmptyHand() {
        player.addCard(new CardsService(Rank.ACE, Suit.SPADES));
        player.addCard(new CardsService(Rank.KING, Suit.HEARTS));

        player.renewHandCards();

        List<CardsService> hand = player.getHand();

        Assertions.assertEquals(0, hand.size());
    }

    @Test
    void getPoints_shouldCalculateCorrectPoints() {
        player.addCard(new CardsService(Rank.ACE, Suit.SPADES));
        player.addCard(new CardsService(Rank.TEN, Suit.HEARTS));
        player.addCard(new CardsService(Rank.KING, Suit.DIAMONDS));

        int points = player.getPoints();

        Assertions.assertEquals(21, points);
    }

    @Test
    void isBust_shouldReturnFalseIfPointsAreNotOver21() {
        player.addCard(new CardsService(Rank.TWO, Suit.SPADES));
        player.addCard(new CardsService(Rank.SEVEN, Suit.HEARTS));

        boolean isBust = player.isBust();

        Assertions.assertFalse(isBust);
    }

    @Test
    void isBust_shouldReturnTrueIfPointsAreOver21() {
        player.addCard(new CardsService(Rank.KING, Suit.SPADES));
        player.addCard(new CardsService(Rank.QUEEN, Suit.HEARTS));
        player.addCard(new CardsService(Rank.JACK, Suit.DIAMONDS));

        boolean isBust = player.isBust();

        Assertions.assertTrue(isBust);
    }
}
