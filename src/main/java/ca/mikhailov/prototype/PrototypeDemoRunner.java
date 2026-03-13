package ca.mikhailov.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PrototypeDemoRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(PrototypeDemoRunner.class);

    private final CounterUser counterUser;

    public PrototypeDemoRunner(CounterUser counterUser) {
        this.counterUser = counterUser;
    }

    @Override
    public void run(String... args) {
        logger.info("\n=== Prototype Bean Demonstration ===");

        counterUser.doWork("First operation");
        counterUser.doWork("Second operation");
        counterUser.doWork("Third operation");

        logger.info("\nDemo finished.");
    }
}

