package io.github.geometrydash.level.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.geometrydash.Vector2;
import io.github.geometrydash.level.Hitbox;
import io.github.geometrydash.level.HitboxType;

public class SquareObject extends LevelObject{

    public SquareObject(Vector2 position) {
        super(position);

        Vector2 corner2 = Vector2.add(position, new Vector2(1, 1));
        this.hitbox = new Hitbox(position, corner2, HitboxType.COLLIDE);
    }

    @Override
    public void render(Vector2 position, ShapeRenderer sr) {
        sr.rect(position.x, position.y, 64, 64);
    }
}
