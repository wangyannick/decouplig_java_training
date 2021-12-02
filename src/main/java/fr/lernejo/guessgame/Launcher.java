package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("launcher");

        if (args[0].equals("-interactive")) {
            HumanPlayer player = new HumanPlayer();
            Simulation simulation = new Simulation(player);

            SecureRandom random = new SecureRandom();
            long number = random.nextLong(100);
            simulation.initialize(number);
            simulation.loopUntilPlayerSucceed((int) Long.MAX_VALUE);
        }

        if (args[0].equals("-auto")) {
            long numberToGuess = Long.parseLong(args[1]);
            ComputerPlayer computer = new ComputerPlayer();
            Simulation simulation = new Simulation(computer);

            simulation.initialize(numberToGuess);
            simulation.loopUntilPlayerSucceed(1000);
        }

        else {
            logger.log("Use -interactive or -auto parameters");
        }
    }
}
