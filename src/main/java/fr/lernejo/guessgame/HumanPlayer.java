package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private Scanner scanner = new Scanner(System.in);


    @Override
    public long askNextGuess() {
        logger.log("Enter a number :");
        int number = scanner.nextInt();

        logger.log("Human guessed : " + number);
        return number;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            logger.log("Greater");
        else
            logger.log("Lower");
    }
}
