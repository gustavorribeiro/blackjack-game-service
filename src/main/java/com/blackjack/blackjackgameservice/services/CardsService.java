package com.blackjack.blackjackgameservice.services;

import com.blackjack.blackjackgameservice.enums.Rank;
import com.blackjack.blackjackgameservice.enums.Suit;

public class CardsService {
    private final Rank rank;
    private final Suit suit;

    public CardsService(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        if (rank == Rank.ACE) {
            return 11;
        } else if (rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING) {
            return 10;
        } else {
            return rank.ordinal() + 1;
        }
    }

    public String toString() {
        return rank + " of " + suit;
    }


}
