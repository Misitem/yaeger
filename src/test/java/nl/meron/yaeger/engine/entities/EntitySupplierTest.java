package nl.meron.yaeger.engine.entities;

import com.google.inject.Injector;
import javafx.scene.Node;
import nl.meron.yaeger.engine.Timer;
import nl.meron.yaeger.engine.entities.entity.AnchorPoint;
import nl.meron.yaeger.engine.entities.entity.Entity;
import nl.meron.yaeger.engine.entities.entity.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

class EntitySupplierTest {

    private EntitySupplier entitySupplier;


    @BeforeEach
    void setup() {
        entitySupplier = new EntitySupplier();
    }

    @Test
    void addEntitiesAddsEntity() {
        // Arrange
        Entity entity = new TestEntity();

        // Act
        entitySupplier.add(entity);

        // Assert
        Assertions.assertEquals(1, entitySupplier.size());
    }

    @Test
    void clearClearsListOfSpawnedEntities() {
        // Arrange
        Entity entity = new TestEntity();

        // Act
        entitySupplier.add(entity);
        entitySupplier.clear();

        // Assert
        Assertions.assertEquals(0, entitySupplier.size());
    }

    @Test
    void getOnEmptySetReturnsEmptySet() {
        // Arrange

        // Act
        Set<Entity> entities = entitySupplier.get();

        // Assert
        Assertions.assertEquals(0, entities.size());
    }

    private class TestEntity implements Entity {
        @Override
        public void remove() {
            // Not required here.
        }

        @Override
        public Optional<Node> getGameNode() {
            return null;
        }

        @Override
        public void setAnchorPoint(AnchorPoint anchorPoint) {
            // Not required here.
        }

        @Override
        public AnchorPoint getAnchorPoint() {
            return null;
        }

        @Override
        public void setOriginX(double x) {
            // Not required here.
        }

        @Override
        public void setOriginY(double y) {
            // Not required here.
        }

        @Override
        public void placeOnScene() {

        }

        @Override
        public void init(Injector injector) {
            // Not required here.
        }

        @Override
        public List<Timer> getTimers() {
            return null;
            // Not required here.
        }
    }
}
