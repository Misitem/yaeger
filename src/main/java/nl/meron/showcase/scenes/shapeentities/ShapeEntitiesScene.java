package nl.meron.showcase.scenes.shapeentities;

import nl.meron.showcase.YaegerShowCase;
import nl.meron.showcase.buttons.Back;
import nl.meron.showcase.scenes.ShowCaseScene;
import nl.meron.showcase.scenes.shapeentities.entities.DynamicRectangle;
import nl.meron.showcase.scenes.shapeentities.entities.StaticRectangle;
import nl.meron.showcase.scenes.shapeentities.entities.TimedDynamicRectangle;
import nl.meron.yaeger.engine.entities.entity.Location;

public class ShapeEntitiesScene extends ShowCaseScene {

    private YaegerShowCase showCase;

    public ShapeEntitiesScene(YaegerShowCase showCase) {
        this.showCase = showCase;
    }

    @Override
    protected void setupSpawners() {

    }

    @Override
    public void setupScene() {
        setBackgroundImage("showcase/backgrounds/milky-way.jpg");
    }

    @Override
    public void setupEntities() {
        var backButton = new Back(showCase);
        addEntity(backButton);

        var rect = new StaticRectangle(new Location(40, 60));
        addEntity(rect);

        var dynamicRectangle = new DynamicRectangle(new Location(40, 160));
        addEntity(dynamicRectangle);

        var timedDynamicRectangle = new TimedDynamicRectangle(new Location(40, 260));
        addEntity(timedDynamicRectangle);
    }

    @Override
    public YaegerShowCase getShowCase() {
        return showCase;
    }
}
