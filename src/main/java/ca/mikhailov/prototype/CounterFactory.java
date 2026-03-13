package ca.mikhailov.prototype;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * A factory that uses Spring's @Lookup to provide fresh prototype beans.
 */
@Component
public abstract class CounterFactory {

    @Lookup
    public abstract Counter getCounter();
}
