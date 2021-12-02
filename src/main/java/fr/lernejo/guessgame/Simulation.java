package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

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
        if (playerChoice == numberToGuess)
            return true;

        if (playerChoice > numberToGuess)
            player.respond(false);
        else
            player.respond(true);

        return false;
    }

    public void loopUntilPlayerSucceed() {
        logger.log("Start of the simulation");
        while (!nextRound())
            nextRound();
        logger.log("Player won");
    }
}
