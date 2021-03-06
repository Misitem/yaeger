package nl.meron.yaeger.engine;

import nl.meron.yaeger.engine.annotations.Initializer;
import nl.meron.yaeger.engine.annotations.UpdatableProvider;
import nl.meron.yaeger.engine.exceptions.YaegerEngineException;

/**
 * Implementing this interface exposes the {@link #addTimer(Timer)} method. A {@link Timer} that is
 * instantiated, but not registered, will not work.
 */
public interface WithTimers extends WithTimerList {

    /**
     * Use this method to add any {@link Timer} that is required by the {@link nl.meron.yaeger.engine.scenes.YaegerScene}
     * or {@link nl.meron.yaeger.engine.entities.entity.Entity} in which it is instantiated.
     *
     * @param timer The {@link Timer} that needs to be added.
     */
    default void addTimer(Timer timer) {
        if (getTimers() != null) {
            getTimers().add(timer);
        } else {
            throw new YaegerEngineException("getTimers() returns null, please return an instance of ArrayList<>");
        }
    }

    @Initializer
    default void initTimers() {
        getTimers().clear();
        setupTimers();
    }

    /**
     * Only instances of {@link Timer} that are registered with the method {@link #addTimer(Timer)}
     * within this method are registered and will receive an animation update.
     */
    void setupTimers();

    @UpdatableProvider
    default Updatable callTimers() {
        return timestamp -> {
            if (getTimers() != null && !getTimers().isEmpty()) {
                getTimers().forEach(timer -> timer.handle(timestamp));
            }
        };
    }
}
