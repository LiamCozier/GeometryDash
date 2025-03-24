package io.github.geometrydash.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.geometrydash.Camera;
import io.github.geometrydash.Vector2;

public class LevelRenderer {

    public LevelRenderer() {}

    public void render_ground(float ground_height, ShapeRenderer sr, Camera c) {
        float half_height = (float) Gdx.graphics.getHeight() / 2;
        Vector2 floor_centre = new Vector2(0, ground_height);
        float floor_screen_height = c.global_to_screen_space(floor_centre).y;
        if (floor_screen_height >= -half_height) {
            sr.rect(0, 0 ,Gdx.graphics.getWidth(), floor_screen_height);
        }
    }

}
