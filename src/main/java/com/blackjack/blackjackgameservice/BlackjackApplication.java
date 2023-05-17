package com.blackjack.blackjackgameservice;

import com.blackjack.blackjackgameservice.services.BlackjackGameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {

		SpringApplication.run(BlackjackApplication.class, args);

		BlackjackGameService game = new BlackjackGameService();
		game.play();
	}
}
