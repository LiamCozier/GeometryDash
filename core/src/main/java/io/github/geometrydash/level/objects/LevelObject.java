package io.github.geometrydash.level.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.geometrydash.Vector2;
import io.github.geometrydash.level.Hitbox;

public abstract class LevelObject {

    protected Vector2 grid_position;
    protected Hitbox hitbox;

    public LevelObject(Vector2 position) {
        this.grid_position = position;
    }

    public Vector2 get_position() {
        return grid_position;
    }

    public void set_position(Vector2 grid_position) {
        this.grid_position = grid_position;
    }

    public void render(Vector2 position, ShapeRenderer sr) {
        sr.rect(position.x, position.y, 8, 8);
    }

    public Hitbox get_hitbox() {
        return this.hitbox;
    }

    private Vector2 grid_to_global() {
        return Vector2.mul(grid_position, 64);
    }



}
