package ca.mikhailov.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * A simple stateful bean that will be created anew every time it is requested.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)   // <-- prototype scope
public class Counter {

    private static final Logger logger = LoggerFactory.getLogger(Counter.class);
    private static final AtomicLong GLOBAL_ID = new AtomicLong(0);   // just to give each instance a unique id
    private final long id;
    private int value = 0;

    public Counter() {
        this.id = GLOBAL_ID.incrementAndGet();
        logger.info(">>> Counter instance created – id={}", id);
    }

    public void inc() {
        value++;
    }

    public int getValue() {
        return value;
    }

    public long getId() {
        return id;
    }
}
