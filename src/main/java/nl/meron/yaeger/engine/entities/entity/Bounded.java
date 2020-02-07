package nl.meron.yaeger.engine.entities.entity;

import javafx.geometry.Bounds;

/**
 * Implementing this interface exposes the {@code getBounds} method, which returns the bounds, aka
 * Bounding Box, of this Entity.
 */
public interface Bounded extends NodeProvider {

    /**
     * Return the {@link Bounds}, aka Bounding Box.
     *
     * @return the {@link Bounds}
     */
    default Bounds getBounds() {
        return getGameNode().getBoundsInLocal();
    }

    /**
     * @return a {@code double} of the right side x value
     */
    default double getRightSideX() {
        return getBounds().getMaxX();
    }

    /**
     * @return a {@code double} of the left side x value
     */
    default double getLeftSideX() {
        return getBounds().getMinX();
    }

    /**
     * @return a {@code double} of the bottom y value
     */
    default double getBottomY() {
        return getBounds().getMaxY();
    }

    /**
     * @return a {@code double} of the top y value
     */
    default double getTopY() {
        return getBounds().getMinY();
    }
}
