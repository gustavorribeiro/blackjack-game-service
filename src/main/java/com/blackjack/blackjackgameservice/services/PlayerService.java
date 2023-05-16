package com.blackjack.blackjackgameservice.services;

import com.blackjack.blackjackgameservice.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private List<CardsService> hand;

    public PlayerService() {
        hand = new ArrayList<>();
    }

    public void addCard(CardsService card) {
        hand.add(card);
    }

    public int getPoints() {
        int points = 0;
        int aceCount = 0;

        for (CardsService card : hand) {
            points += card.getValue();
            if (card.getRank() == Rank.ACE) {
                aceCount++;
            }
        }

        while (points > 21 && aceCount > 0) {
            points -= 10;
            aceCount --;
        }
        return points;
    }

    public boolean isBust() {
        return getPoints() > 21;
    }

    public void printHand() {
        for (CardsService card : hand) {
            System.out.println(card);
        }
    }


}
