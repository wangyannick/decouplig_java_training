package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;
    private boolean numberFound = false;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long playerChoice = player.askNextGuess();
        if (playerChoice == numberToGuess) {
            numberFound = true;
            return true;
        }


        if (playerChoice > numberToGuess)
            player.respond(false);
        else
            player.respond(true);

        return false;
    }

    public void loopUntilPlayerSucceed(int maxIteration) {
        logger.log("Start of the simulation");
        long starting_date = System.currentTimeMillis();
        int iteration = 0;
        while (!numberFound)
        {
            nextRound();
            iteration++;

            if (maxIteration == iteration) {
                break;
            }

        }

        if (numberFound)
            logger.log("Player won");
        else
            logger.log("Max iteration, played lost");
        long ending_date = System.currentTimeMillis();
        logger.log("Time : " + (ending_date - starting_date) + "ms");
    }
}
