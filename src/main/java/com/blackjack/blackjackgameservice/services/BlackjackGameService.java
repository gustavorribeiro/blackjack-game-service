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
            player.renewHandCards();
            deck.shuffle();
            player.addCard(deck.drawCard());
            player.addCard(deck.drawCard());

            System.out.println("Player's hand:");
            player.printHand();
            System.out.println("Total points: " + player.getPoints());

            if (player.getPoints() == 21) {
                System.out.println("Blackjack 21! Player wins.");
                break;
            }

            while (player.getPoints() < 21) {
                System.out.print("Do you want to hit (draw another card) (Y/N) OR shuffle deck? (S): ");
                String choice = scanner.nextLine().toUpperCase();
                System.out.println("Your choice is: " + choice);

                if (choice.equals("Y")) {
                    CardsService card = deck.drawCard();
                    player.addCard(card);
                    System.out.println("Player drew: " + card.getRank() + " of " + card.getSuit());
                    System.out.println("Total points: " + player.getPoints());
                    if (player.isBust()) {
                        System.out.println("Bust player loses!");
                        break;
                    } else if (player.getPoints() == 21) {
                        System.out.println("Blackjack 21! Player wins.");
                        break;
                    }
                } else if (choice.equals("N") || choice.isEmpty() || choice.isBlank()) {
                    System.out.println("See you next game! Bye.");
                    break;
                } else if (choice.equals("S")) {
                    deck.shuffle();
                    System.out.println("Your cars has been shuffled!");
                } else {
                    System.out.println("Invalid input. Please enter Y or N or S.");
                }
            }
            System.out.println("Do you want to play again? (Y/N): ");
            String playAgain = scanner.nextLine().toUpperCase();

            if (!playAgain.equals("Y")) {
                break;
            }
        }
        scanner.close();
    }
}
