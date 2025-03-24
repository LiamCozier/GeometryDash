package io.github.geometrydash.level.objects;

import io.github.geometrydash.Vector2;

public abstract class LevelObject {
    private Vector2 grid_position;

    public LevelObject(Vector2 position) {
        this.grid_position = position;
    }

    public void render() {}

    private Vector2 grid_to_global() {
        return Vector2.mul(grid_position, 64);
    }

}
