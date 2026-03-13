package ca.mikhailov.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * A singleton service that needs a new Counter each time it does some work.
 * <p>
 * Uses {@link CounterFactory} which uses @Lookup so Spring overrides the method
 * and returns a fresh prototype bean.
 */
@Service
public class CounterUser {

    private static final Logger logger = LoggerFactory.getLogger(CounterUser.class);
    private final CounterFactory counterFactory;

    public CounterUser(CounterFactory counterFactory) {
        this.counterFactory = counterFactory;
    }

    /**
     * Simulates some business logic that needs a fresh Counter.
     */
    public void doWork(String description) {
        // Every call to counterFactory.getCounter() returns a brand-new Counter instance.
        Counter counter = counterFactory.getCounter();

        logger.info("\n--- {} ---", description);
        logger.info("Counter id   = {}", counter.getId());
        logger.info("Initial value= {}", counter.getValue());

        // mutate the instance – this mutation is *not* visible to any other caller
        counter.inc();
        counter.inc();

        logger.info("After 2 incs = {}", counter.getValue());
    }
}
