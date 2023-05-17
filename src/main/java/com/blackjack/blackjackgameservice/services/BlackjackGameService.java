package com.blackjack.blackjackgameservice.services;

import java.util.Scanner;

public class BlackjackGameService {
    private final DeckService deck;
    private final PlayerService player;

    public BlackjackGameService() {
        deck = new DeckService();
        player = new PlayerService();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("======== New Game ========");
            deck.shuffle();
            player.addCard(deck.drawCard());
            player.addCard(deck.drawCard());

            System.out.println("Player's hand:");
            player.printHand();
            System.out.println("Total points: " + player.getPoints());

            if (player.getPoints() == 21) {
                System.out.println("Blackjack! Player wins.");
                break;
            }

            while (player.getPoints() < 21) {
                System.out.print("Do you want to hit (draw another card)? (Y/N): ");
                String choice;
                while (scanner.hasNextLine()) {
                    choice = scanner.nextLine().toUpperCase();

                    if (choice.equals("Y")) {
                        CardsService card = deck.drawCard();
                        player.addCard(card);
                        System.out.println("Player drew: " + card.getRank() + "of" + card.getSuit());
                        System.out.println("Total points: " + player.getPoints());
                        if (player.isBust()) {
                            System.out.println("Bust player loses!");
                            break;
                        } else if (player.getPoints() == 21) {
                            System.out.println("Blackjack 21! Player wins.");
                            break;
                        }
                    } else if (choice.equals("N")) {
                        System.out.println("See you next game! Bye.");
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter Y or N.");
                    }
                    System.out.println("Do you want to play again? (Y/N): ");
                    String playAgain = scanner.nextLine().toUpperCase();
                    if (!playAgain.equals("Y")) {
                        break;
                    }
                }
            }
        }
        scanner.close();
    }
}
