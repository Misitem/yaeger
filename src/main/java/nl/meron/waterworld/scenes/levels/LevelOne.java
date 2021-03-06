package nl.meron.waterworld.scenes.levels;

import nl.meron.waterworld.Waterworld;
import nl.meron.waterworld.entities.game.tilemaps.CoralTileMap;
import nl.meron.yaeger.engine.entities.tilemap.WithTileMaps;

public class LevelOne extends Level implements WithTileMaps {

    private static final String BACKGROUND_IMAGE = "waterworld/underwater2.jpg";

    public LevelOne(final Waterworld waterworld) {
        super(waterworld);
    }

    @Override
    public void setupScene() {
        super.setupScene();
        setBackgroundImage(BACKGROUND_IMAGE);
    }

    @Override
    public void increaseBubblesPopped() {
        super.increaseBubblesPopped();

        if (bubblesPopped > 2) {
            waterworld.nextScene(Waterworld.SCENE_LEVEL_TWO);
        }
    }

    @Override
    public void setupTileMaps() {
        var coralMap = new CoralTileMap();
        addTileMap(coralMap);
    }
}
