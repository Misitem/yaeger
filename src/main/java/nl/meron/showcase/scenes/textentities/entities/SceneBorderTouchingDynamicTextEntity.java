package nl.meron.showcase.scenes.textentities.entities;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.meron.yaeger.engine.entities.entity.Location;
import nl.meron.yaeger.engine.entities.entity.SceneBorderTouchingWatcher;
import nl.meron.yaeger.engine.entities.entity.motion.Direction;
import nl.meron.yaeger.engine.entities.entity.shape.text.DynamicTextEntity;
import nl.meron.yaeger.engine.scenes.SceneBorder;

public class SceneBorderTouchingDynamicTextEntity extends DynamicTextEntity implements SceneBorderTouchingWatcher {

    public static final String TEXT = "SceneBorderTouching";

    public SceneBorderTouchingDynamicTextEntity(final Location position) {
        super(position, TEXT);
        setFill(Color.SILVER);
        setFont(Font.font("arial", FontWeight.BOLD, 30));
        setMotionTo(6, Direction.RIGHT.getValue());
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        if (border.equals(SceneBorder.LEFT)) {
            setFill(Color.SILVER);
        } else {
            setFill(Color.TEAL);
        }
        changeDirectionBy(180);
    }
}
