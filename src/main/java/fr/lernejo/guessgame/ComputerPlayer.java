package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("computer");
    private long start = 0;
    private long mid;
    private long end = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        mid = (start + end) / 2;
        logger.log("Computer guessed : " + mid);
        return mid;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            start = mid;
        else
            end = mid;
    }
}
