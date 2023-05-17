package com.blackjack.blackjackgameservice.services;

import com.blackjack.blackjackgameservice.enums.Rank;
import com.blackjack.blackjackgameservice.enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckService {
    private List<CardsService> cards;

    public DeckService() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new CardsService(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards, new Random());
    }

    public CardsService drawCard() {
        //Removes one card of deck
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public List<CardsService> getCards() {
        return new ArrayList<>(cards);
    }

}
