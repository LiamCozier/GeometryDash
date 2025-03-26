package io.github.geometrydash.level.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.geometrydash.Vector2;
import io.github.geometrydash.level.Hitbox;
import io.github.geometrydash.level.HitboxType;

public class SpikeObject extends LevelObject{

    public SpikeObject(Vector2 position) {
        super(position);

        this.hitbox = new Hitbox(
            Vector2.add(position, new Vector2(0.25f, 0f)),
            Vector2.add(position, new Vector2(0.75f, 0.5f)),
            HitboxType.HAZARD
        );

    }

    @Override
    public void render(Vector2 position, ShapeRenderer sr) {
        sr.triangle(
            position.x, position.y,
            position.x+32, position.y+64,
            position.x+64, position.y
        );
    }

}
