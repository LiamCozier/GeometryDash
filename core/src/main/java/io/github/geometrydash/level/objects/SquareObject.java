package io.github.geometrydash.level.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.geometrydash.Vector2;

public class SquareObject extends LevelObject{

    public SquareObject(Vector2 position) {
        super(position);
    }

    @Override
    public void render(Vector2 position, ShapeRenderer sr) {
        sr.rect(position.x, position.y, 64, 64);
    }
}
