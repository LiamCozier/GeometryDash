package io.github.geometrydash;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.geometrydash.level.LevelRenderer;

public class Game {
    ShapeRenderer sr;
    LevelRenderer lr;
    Camera c;

    float ground_height = -50f;

    public Game() {
        init();
    }

    private void init() {
        this.sr = new ShapeRenderer();
        this.lr = new LevelRenderer();
        this.c = new Camera();
    }

    public void process() {
        c.input();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        sr.begin(ShapeRenderer.ShapeType.Filled);

        Vector2 square_pos = c.global_to_screen_space(Vector2.ZERO);
        sr.rect(square_pos.x, square_pos.y, 64, 64);

        lr.render_ground(ground_height, sr, c);
        sr.end();
    }
}
