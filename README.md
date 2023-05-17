# Blackjack

This is a simple single-player command line interface Blackjack card game. The system acts as the house and creates new tables/games for player. Players can leave after each round or will be kicked out when player loses.

## How to Play

Follow these instructions to play Blackjack. It can be played by just running main class "BlackjackApplication". When you execute main class you will input Y for Yes, N for No and S for Shuffle the deck.</br>
Your points will be printed in each round when you start game or draw a card from deck.

## Setup

To run the blackjack-game-service, you need to have Java and Gradle installed on your system.

### Prerequisites

Java Development Kit (JDK) 11 or higher.</br>
Gradle

### Getting Started

1. Clone the repository to your local machine:</br>
   ````
   git clone https://github.com/gustavorribeiro/blackjack-game-service.git
   ````
   
2. Build the project using Gradle:</br>
   ````
    ./gradlew clean build
   ````
   
   
3. Run the application running the main class "BlackjackApplication" for you can input data and play the game in IDE.

## Usage

Once the application is running, you can play the Blackjack game by following the prompts in the command line interface. You will be asked to make choices such as hitting (drawing another card), standing (not drawing another card), shuffling the deck, and whether to play another round.

The game follows the standard rules of Blackjack, where the goal is to get a hand value as close to 21 as possible without exceeding it.

## Testing 

The project includes unit tests for the various components of the Blackjack game service. To run the tests, use the following command:</br>
````
 ./gradlew test
````

## Contributing

Contributions to the Blackjack game service are welcome. If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License

The blackjack-game-service is open-source software licensed under the MIT License. See the [LICENSE.md](LICENSE.md) file for details.