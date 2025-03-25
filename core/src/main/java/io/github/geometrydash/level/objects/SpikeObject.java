package io.github.geometrydash.level.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.geometrydash.Vector2;

public class SpikeObject extends LevelObject{

    public SpikeObject(Vector2 position) {
        super(position);
    }

    @Override
    public void render(Vector2 position, ShapeRenderer sr) {
        sr.triangle(
            position.x, position.y,
            position.x+32, position.y+64,
            position.x+64, position.y);
    }

}
