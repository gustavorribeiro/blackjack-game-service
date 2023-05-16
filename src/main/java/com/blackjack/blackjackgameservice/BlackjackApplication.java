package com.blackjack.blackjackgameservice;

import com.blackjack.blackjackgameservice.services.DeckService;
import com.blackjack.blackjackgameservice.services.PlayerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {

		SpringApplication.run(BlackjackApplication.class, args);

		DeckService deck = new DeckService();
		deck.shuffle();

		PlayerService player = new PlayerService();
		player.addCard(deck.drawCard());
		player.addCard(deck.drawCard());

		System.out.println("Players hand:");
		player.printHand();
		System.out.println("Total point: " + player.getPoints());

		if (player.isBust()) {
			System.out.println("Bust! Player loses.");
		} else if (player.getPoints() == 21) {
			System.out.println("Blackjack 21! Player wins.");
		} else {
			System.out.println("Keep playing...");
		}
	}
}
